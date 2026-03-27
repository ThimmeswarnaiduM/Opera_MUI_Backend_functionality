

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import config.Configuration;



@WebServlet("/ValidateOTP")
public class ValidateOTP extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String GlobalReservationNumber = "";
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			GlobalReservationNumber = request.getParameter("GlobalReservationNumber");
		} catch(Exception e){}
		
		String UserOTP = request.getParameter("UserOTP");
		

		String MemberNumber = request.getParameter("MembershipNumber");
		
		JSONObject resp = processRequst(MemberNumber, UserOTP, GlobalReservationNumber);
		
		response.getWriter().write(resp.toString());
		
		return;
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	private JSONObject processRequst(String MemberNumber, String UserOTP, String ReservationNo)
	{
		
		JSONObject jsonString = new JSONObject();

		try
		{
			OkHttpClient client = new OkHttpClient();
	
			String ValidateOTPUrl = Configuration.ValidateOTPURL+"?"+"otp="+UserOTP+"&username="+MemberNumber;
			System.out.println("ValidateOTPUrl \t" + ValidateOTPUrl);
			MediaType mediaType = MediaType.parse("text");
			RequestBody body = RequestBody.create(mediaType, "");
			Request req = new Request.Builder()
					.url(ValidateOTPUrl)
					  .post(body)
					  .addHeader("Authorization", Configuration.IcsBasicAuth)
					  .addHeader("cache-control", "no-cache")
					  .addHeader("Postman-Token", "da9560b0-9bb3-480a-af5a-b008adbe4ebc")
					  .build();
			
			
			Response resp = client.newCall(req).execute();
			
			JSONObject jsonObject = new JSONObject(resp.body().string());
			
			System.out.println("Validate OTP Resp: \n" + jsonObject.toString());
			
			try{
				BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + ReservationNo+".txt",true));
				
				writer.write("\nValidateOTPUrl: \n" + ValidateOTPUrl + "\n");
				writer.write("\nValidate OTP Response: \n" + jsonObject + "\n\n");
				writer.write((new Date()).toString());
				writer.close();
				
			} catch(Exception e)
			{
				e.printStackTrace();
			}
			
			String errMsg = "";
			
			String isSuccess = jsonObject.getString("status");
			
			if(isSuccess.equalsIgnoreCase("SUCCESS"))
			{
				errMsg = "OTP authenticated successfully";
				jsonString.put("status", isSuccess);
				jsonString.put("msg", errMsg);
			}
			else if(isSuccess.equalsIgnoreCase("FAILURE"))
			{
				/*String errCode = jsonObject.getString("errorCode");
				if(errCode.equalsIgnoreCase("null"))
				{
					errMsg = "Invalid OTP entered\nPlease try again";
					jsonString.put("status", isSuccess);
					jsonString.put("msg", errMsg);
				}
				else if(errCode.equalsIgnoreCase("INVALID_ARGUMENTS"))
				{
					errMsg = jsonObject.getString("errorText");
					jsonString.put("status", isSuccess);
					jsonString.put("msg", errMsg);
				}
				else if(errCode.equalsIgnoreCase("INVALID_PRINCIPAL"))
				{
					errMsg = jsonObject.getString("errorText");
					jsonString.put("status", isSuccess);
					jsonString.put("msg", errMsg);
				}
				else {
					jsonString.put("status", isSuccess);
					jsonString.put("msg", "Failed to validate OTP");
				}*/
				
				jsonString.put("status", isSuccess);
				jsonString.put("msg", "Invalid OTP provided");
				
			}
			
			//System.out.println(errMsg);
			return jsonString;
			
		}catch(Exception e)
		{
			e.printStackTrace();
			try {
				
				jsonString.put("status", "FAILED");
				jsonString.put("msg", "Failed to validate OTP");
				
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
			
		}
		
		return jsonString;
	}

}
