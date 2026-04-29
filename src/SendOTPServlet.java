

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
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
import config.GetHotelsData;
import config.GetMemberData;
import config.GetOTPEmail;
import config.GetProfileData;
import data.HashMapData;
import data.StoreInvoiceDetails;


@WebServlet("/SendOTPServlet")
public class SendOTPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String GlobalReservationNumber = "";
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			GlobalReservationNumber = request.getParameter("GlobalReservationNumber");
			String GlobalOrionCode=request.getParameter("GlobalPropertyCode");
			
			String TcpCustomerHash = request.getParameter("TcpCustomerHash");
			String PointsToRedeem = request.getParameter("PointsToRedeem");
			
			JSONObject resp = processRequest(request, response, TcpCustomerHash, PointsToRedeem, GlobalReservationNumber,GlobalOrionCode);
			
			response.getWriter().write(resp.toString());
			
		} catch(Exception e){}
	
		return;
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//System.out.println("DoPost");
		doGet(request, response);
	}
	
	
	
	private JSONObject processRequest(HttpServletRequest request, HttpServletResponse response, String TcpCustomerHash, String PointsToRedeem, String GlobalResvNumber,String GlobalOrionCode)
	{
		
		JSONObject jsonString = new JSONObject();
		GetHotelsData hotelsData = new GetHotelsData();
		//GlobalOrionCodString PropertyCode = hotelsData.getProperty(request.getParameter("GlobalPropertyCode"));
		//String GlobalOrionCodes = HashMapData.mapOrionCode.get(request.getParameter("GlobalPropertyCode"));
//		GetProfileData profileData = HashMapData.mapProfileData.get(GlobalResvNumber);
//		String partyId = profileData.PartyId;
		
		
		String payload = "{\r\n" + 
				"  \"customerHash\": \""+TcpCustomerHash+"\",\r\n" + 
				"  \"points\": \""+PointsToRedeem+"\"\r\n" + 
				"}";
		
		System.out.println("Send OTP payload:\n"+payload);
		
		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + request.getParameter("GlobalReservationNumber")+".txt",true));
			
			writer.write("\nSend OTP Request payload: \n" + payload + "\n\n");
			writer.write((new Date()).toString());
			writer.close();
			
		} catch(Exception e)
		{
			e.printStackTrace();
		}
				
		try {
				
			/*OkHttpClient client = new OkHttpClient();
	
			MediaType mediaType = MediaType.parse("application/json");
			RequestBody body = RequestBody.create(mediaType, payload);
			Request req = new Request.Builder()
			  .url(Configuration.SendOTPURL)
			  .post(body)
			  .addHeader("content-type", "application/json")
			  .addHeader("authorization", Configuration.IcsBasicAuth)
			  .addHeader("cache-control", "no-cache")
			  .addHeader("postman-token", "b25e4e02-ccca-e073-9221-01ecee92a36c")
			  .build();
	
			Response res = client.newCall(req).execute();*/
			
			OkHttpClient client = new OkHttpClient();
			MediaType mediaType = MediaType.parse("application/json");
			RequestBody body = RequestBody.create(mediaType, payload);
			Request req = new Request.Builder()
			  .url(Configuration.SendOTPURL)
			  .method("POST", body)
			  .addHeader("store_id", GlobalOrionCode)
			  .addHeader("Content-Type", "application/json")
			  .addHeader("Authorization", Configuration.IcsBasicAuth)
			  .build();
			Response res = client.newCall(req).execute();
			
			String resp = res.body().string();
			
			System.out.println("Send OTP response:\n" + resp);
			
			try{
				BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + request.getParameter("GlobalReservationNumber")+".txt",true));
				
				writer.write("\nSend OTP Response: \n" + resp + "\n\n");
				writer.write((new Date()).toString());
				writer.close();
				
			} catch(Exception e)
			{
				e.printStackTrace();
			}
			
			JSONObject objectMember = new JSONObject(resp);
			JSONObject objPoints = objectMember.getJSONObject("response").getJSONObject("points").getJSONObject("redeemable");
			String isRedeemable = objPoints.getString("is_redeemable");
			
			if(isRedeemable.equals("false"))
			{
				String msg = objPoints.getJSONObject("item_status").getString("message");
				jsonString.put("status", "FAILURE");
				jsonString.put("msg", msg);
			} else
			{
				jsonString.put("status", "SUCCESS");
			}
						
			return jsonString;
			
		}catch(Exception e)
		{
			e.printStackTrace();
			
			try {
				
				jsonString.put("status", "FAILED");
				jsonString.put("msg", "Failed to send OTP\nPlease try again later");
				
			} catch (JSONException e1) {
		
				e1.printStackTrace();
			}
			
		}
		
		return jsonString;
	}

}
