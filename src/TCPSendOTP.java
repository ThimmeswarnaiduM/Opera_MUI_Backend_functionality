import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import config.Configuration;
import config.GetMemberData;
import data.HashMapData;

@WebServlet("/TCPSendOTP")
public class TCPSendOTP extends HttpServlet {
	
	public static String RefId;
	

	private static final long serialVersionUID = 1L;
	@SuppressWarnings("null")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//System.out.println("GetBillDataServlet started");
		String ReservationID = request.getParameter("ReservId");
		GetMemberData tempMember = HashMapData.mapMemberData.get(ReservationID);
		 //String custHaash = tempMember.redeemTCPCustomerHash;
		
		String mobileNumber = tempMember.phoneNumber;
		//String mobileNumber = "8919383736";
		String countryCode = tempMember.isdCode;
		String req = "{\r\n  \"countryCode\": \""+countryCode+"\",\r\n  \"mobileNumber\": \""+mobileNumber+"\",\r\n  \"event\": \"generic_validation_OTP\",\r\n  \"programId\": \"tcp\"\r\n}";
		OkHttpClient client_02 = new OkHttpClient();
		MediaType mediaType_02 = MediaType.parse("application/json");
		//RequestBody body_02 = RequestBody.create(mediaType_02, "{\r\n  \"countryCode\": \"+91\",\r\n  \"mobileNumber\": \"8019915401\",\r\n  \"event\": \"generic_validation_OTP\",\r\n  \"programId\": \"tcp\"\r\n}");
		//change request after testing
		RequestBody body_02 = RequestBody.create(mediaType_02,req );
		Request request_02 = new Request.Builder()
		  .url(Configuration.TCPSERVICEGENERATEOTP)
		  .method("POST", body_02)
		  .addHeader("Authorization", "Basic b2ljX3VzZXI6SW5ub3ZhY3hAMzIx")
		  .addHeader("Content-Type", "application/json")
		  .build();
		Response response_02 = client_02.newCall(request_02).execute();
		String resp = response_02.body().string().toString();
		JSONObject OTPresp = new JSONObject();
		try {
			JSONObject RespOTP  = new JSONObject(resp);
			RefId = RespOTP.getString("id");
			JSONObject status = RespOTP.getJSONObject("status");
			String sMSG = status.getString("message");
			String Scode = status.getString("code");
			System.out.println("Scode : "+Scode);
			System.out.println("SMSG : "+sMSG);
			if(Scode.equals("201")) {
			OTPresp.put("id", RefId);
			OTPresp.put("status", "Success");
			OTPresp.put("mobile", mobileNumber);
			}else {
				OTPresp.put("status", sMSG);
			}
			
		} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		System.out.println("OTPresp : "+OTPresp.toString());
		
		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + ReservationID+".txt",true));
			writer.write("\nSend TCP OTP request: \n" + req + "\n\n");
			writer.write("\nSend TCP OTP responce: \n" + OTPresp + "\n\n");
			writer.write((new Date()).toString());
			writer.close();
			
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		response.getWriter().write(OTPresp.toString());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
}
