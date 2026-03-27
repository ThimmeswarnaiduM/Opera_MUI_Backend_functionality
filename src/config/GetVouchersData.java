package config;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

public class GetVouchersData {
	
	public String resp = "";
	public String resp_02 = "";
	
	public String getVouchers(String MemberNumber, String ReservationID, String MemberType) throws IOException
	{
		
		OkHttpClient client_02 = new OkHttpClient();
				MediaType mediaType_02 = MediaType.parse("application/json");
				RequestBody body_02 = RequestBody.create(mediaType_02, "{\r\n    \"Member_Id\": \""+MemberNumber+"\",\r\n    \"MemberType\": \""+MemberType+"\"\r\n}");
				Request request_02 = new Request.Builder()
				  .url(Configuration.GET_ALL_PRIVILEGES_EXPIRED)
				  .method("POST", body_02)
				  .addHeader("Authorization", "Basic T2ljX3VzZXI6SW5ub3ZhY3hAMzIx")
				  .addHeader("Content-Type", "application/json")
				  .build();
				Response response_02 = client_02.newCall(request_02).execute();
				resp_02 = response_02.body().string().toString();
				
				System.out.println("Voucher Resp: \n" + resp_02);
				return resp_02;
		
	/*	try 
		{
			ConfigPayloads payloads = new ConfigPayloads();
			
			String payload = payloads.getVouchersPayload(MemberNumber);
			System.out.println("Voucher URL\t" + Configuration.GetVouchersURL);
			System.out.println("Voucher Req: \n" + payload);
		
			OkHttpClient client = new OkHttpClient();
		
			MediaType mediaType = MediaType.parse("application/json");
			RequestBody body = RequestBody.create(mediaType, payload);
			Request request = new Request.Builder()
			  .url(Configuration.GetVouchersURL)
			  .post(body)
			  .addHeader("Content-Type", "application/json")
			  .addHeader("Authorization", Configuration.IcsBasicAuth)
			  .addHeader("cache-control", "no-cache")
			  .addHeader("Postman-Token", "cb799ece-486c-4e69-898c-82063d9a4d23")
			  .build();
		
			Response response = client.newCall(request).execute();
			
			resp = response.body().string().toString();
			
			System.out.println("Voucher Resp: \n" + resp);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
*/		//return resp;
	}
	
	
	public String getExpiredVouchers(String MemberNumber, String ReservationID, String MemberType) throws IOException
	{	
		Date date = new Date();
		String TodayDate= new SimpleDateFormat("yyyy-MM-dd").format(date);
		OkHttpClient client_02 = new OkHttpClient();
		MediaType mediaType_02 = MediaType.parse("application/json");
		String ReqBody = "{\r\n    \"Member_Id\": \""+MemberNumber+"\","
				+ "\r\n    \"MemberType\": \""+MemberType+"\","
				+ "\r\n    \"Status\": \"EXPIRED\"\r\n}";
		RequestBody body_02 = RequestBody.create(mediaType_02,ReqBody );
		
		Request request_02 = new Request.Builder()
		  .url(Configuration.GET_ALL_PRIVILEGES_EXPIRED)
		  .method("POST", body_02)
		  .addHeader("Authorization", "Basic T2ljX3VzZXI6SW5ub3ZhY3hAMzIx")
		  .addHeader("Content-Type", "application/json")
		  .build();
		Response response_02 = client_02.newCall(request_02).execute();
		resp_02 = response_02.body().string().toString();
		System.out.println("Voucher Req: \n" + ReqBody);
		System.out.println("Voucher Resp: \n" + resp_02);
		return resp_02;

	
		
	}
	

}
