import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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

import config.ConfigPayloads;
import config.Configuration;
import config.GetProfileData;
import data.HashMapData;
import data.NewInvoicesData;


@WebServlet("/GravtySendOtpServlet")
public class GravtySendOtpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpServletResponse servletResponse = null;
    
	
	JSONObject objectPoint = new JSONObject();
//	JSONObject objectVoucher = new JSONObject();
	JSONObject object = new JSONObject();
	static String VoucherNumber =null;
	static String CardNumber =null;	
	static String Memtype =null;
	static String GlobalReservationNumber =null;
	static String GlobalPropertyCode =null;
	static String Type =null;
	
	
	protected void getData(HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException
	{
		servletResponse = response;
		String ApiResponse_body=null,status=null , mobile= "" , email="";
		try
		{
	
			Memtype = request.getParameter("Memtype");
					
					GetProfileData x = new GetProfileData(null, null, null,null,null);
					/* for(Map.Entry m : x.VoucherPinHashMap.entrySet()){    
						    System.out.println(m.getKey()+" and "+m.getValue());    
						   }
					*/
					String CHMemberNumber= x.GravtyMemberNumber.get("CHMemberNumber");
					String EPIMemberNumber= x.GravtyMemberNumber.get("EPIMemberNumber");
					System.out.println("CHMemberNumber from hashmap: "+CHMemberNumber);
					System.out.println("EPIMemberNumber from hashmap: "+EPIMemberNumber);
					System.out.println("Memtype: "+Memtype);
					String MemberNumber=null;
					
					//Send otp rest api call
					if (Memtype.equals("Epicure")) {
						MemberNumber=EPIMemberNumber;
						
					}
					else if (Memtype.equals("Chambers")) {
						MemberNumber=CHMemberNumber;
						
					}
					OkHttpClient client = new OkHttpClient();
					MediaType mediaType = MediaType.parse("application/json");
					RequestBody body = RequestBody.create(mediaType, "{\r\n    \"MemberType\": \""+Memtype+"\",\r\n    \"action\": \"GENERATE\",\r\n    \"service\": \"REDEMPTION_OTP\"\r\n}");
					Request ApiRequest = new Request.Builder()
					  .url(Configuration.GENERATE_OTP+MemberNumber+"/otp/")
					  .method("POST", body)
					  .addHeader("Authorization", "Basic T2ljX3VzZXI6SW5ub3ZhY3hAMzIx")
					  .addHeader("Content-Type", "application/json")
					  .build();
					Response ApiResponse = client.newCall(ApiRequest).execute();
					
					ApiResponse_body=ApiResponse.body().string();
					JSONObject jsonObject = new JSONObject(ApiResponse_body);
					status = jsonObject.getString("status");
					mobile = jsonObject.getString("mobile");
					email = jsonObject.getString("email");
					
					mobile="xxxxx"+mobile.substring((mobile.length() - 3));
					int index1=email.indexOf("@");
					email = email.substring(0, 3)+"xxxxx"+email.substring(index1-3);
					
					String errorDetails = jsonObject.getString("o:errorDetails");
					System.out.println("errorDetails: "+errorDetails);
					
					
					
			}catch(Exception e)
		{
			e.printStackTrace();
		}
		this.object.put("status", status);
		this.object.put("mobile", mobile);
		this.object.put("email", email);
		servletResponse.getWriter().write(this.object.toString());
		//servletResponse.getWriter().write(status);
	}
	
	
	public static void main(String a[])
	{
		
		System.out.println("Gravty Send Otp servlet");
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			getData(request, response);
		} catch (IOException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}


	
	
}

