package config;

import org.json.JSONObject;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

public class GetOTPEmail {

	
	
	public String getEmail(String MembershipNumber)
	{
		String emailId = "";
		
		String resp = invokeService(MembershipNumber);
		
		try
		{
			
			JSONObject object = new JSONObject(resp);
			
			String status =object.getString("status");
			
			System.out.println(status);
			
			if(status.equalsIgnoreCase("SUCCESS"))
			{
				JSONObject jsonObject = object.getJSONObject("responseValue");
				
				emailId = jsonObject.getString("email");
				
				String maskedEmail = maskEmail(emailId);
				
				System.out.println(maskedEmail);
				
				return maskedEmail;
			} else
			{
				emailId = "error";
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
			emailId = "error";
		}
		
		
		return "";
	}
	
	private String invokeService(String MembershipNumber)
	{
		try {
			
			OkHttpClient client = new OkHttpClient();

			MediaType mediaType = MediaType.parse("text");
			RequestBody body = RequestBody.create(mediaType, "");
			Request request = new Request.Builder()
			  .url(Configuration.ForgotPasswordOTPURL+"?login="+MembershipNumber)
			  .post(body)
			  .addHeader("Authorization", Configuration.IcsBasicAuth)
			  .addHeader("Cache-Control", "no-cache")
			  .addHeader("Postman-Token", "511219fd-bbb2-437a-8603-2e663a78b425,ec294036-7a33-4b07-82ce-3cc1aeac4c42")
			  .addHeader("content-length", "")
			  .addHeader("Connection", "keep-alive")
			  .addHeader("cache-control", "no-cache")
			  .build();

			Response response = client.newCall(request).execute();
			
			String resp = response.body().string().toString();
			
			return resp;
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return "null";
	}

	private String maskEmail(String EmailId)
	{
		String maskedEmail = "";
		
		int strLen = EmailId.length();
		
		String str1 = EmailId.substring(0, 3);
		String str2 = EmailId.substring(EmailId.indexOf("@")-2, strLen);
		
		int cut = 6;
		
		String maskChar = "";
		
		for(int i=0; i<cut; i++)
			maskChar += "*";
		
		maskedEmail = str1 + maskChar + str2;
		
		System.out.println(maskedEmail);
		
		return maskedEmail;
	}
	
}
