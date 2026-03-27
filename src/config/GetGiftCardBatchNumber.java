package config;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.concurrent.TimeUnit;

import org.json.JSONObject;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import data.HashMapData;

public class GetGiftCardBatchNumber {

	String TerminalID = "";
	String DateAtClient = "";
	String ForwardEntityId = "";
	String ForwardingEntityPassword = "";
	String TransactionId = "";
	String UserName = "";
	String Password = "";

	
	public GetGiftCardBatchNumber(String TerminalID, String DateAtClient, String ForwardEntityID, String ForwardingEntityPassword, String TransactionID, String UserName, String Password)
	{
		this.TerminalID = TerminalID;
		this.DateAtClient = DateAtClient;
		this.ForwardEntityId = ForwardEntityID;
		this.ForwardingEntityPassword = ForwardingEntityPassword;
		this.TransactionId = TransactionID;
		this.UserName = UserName;
		this.Password = Password;
	}
	
	public String batchNumber()
	{

		String BatchNumber = HashMapData.mapBatchNumber.get("BatchNumber");
		
		if(BatchNumber == null || BatchNumber.equalsIgnoreCase("null") || BatchNumber.equalsIgnoreCase(""))
		{
			BatchNumber = getBatchNumber();
			HashMapData.mapBatchNumber.put("BatchNumber", BatchNumber);
		}
		
		
		return BatchNumber;
	}
	
	
	private String getBatchNumber()
	{
		String BatchNumber = "";
		
		try {
			OkHttpClient client = new OkHttpClient();
			client.setConnectTimeout(70, TimeUnit.SECONDS);
			client.setReadTimeout(70, TimeUnit.SECONDS);

			Request request = new Request.Builder()
					.url(Configuration.GiftCardBatchNumberURL)
					  .get()
					  .addHeader("TerminalID", TerminalID)
					  .addHeader("DateAtClient", DateAtClient)
					  .addHeader("ForwardEntityId", ForwardEntityId)
					  .addHeader("ForwardingEntityPassword", ForwardingEntityPassword)
					  .addHeader("TransactionId", TransactionId)
					  .addHeader("UserName", UserName)
					  .addHeader("Password", Password)
					  .addHeader("authorization", Configuration.IcsBasicAuth)
					  .addHeader("cache-control", "no-cache")
					  .addHeader("postman-token", "e8909193-7507-788d-e5ef-0e8685463bb0")
					  .build();
			
			System.out.println("\n\nBalance Enquiry Request:\t " +request+"\n"+ request.headers() + "\n");
			try
			{
				BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.giftCardLogLoc + "BatchNumber"+".txt",true));

				writer.write("\n\nBalance Enquiry Request:\t " +request+"\n"+ request.headers() + "\n");
				
				writer.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
	
			Response response = client.newCall(request).execute();
			
			String resp = response.body().string();
			
			//System.out.println("Initialize Response: "+resp);
			
			try {
				
				JSONObject jsonObject = new JSONObject(resp);
				
				String isSuccess = jsonObject.getString("ResponseCode");
				if(isSuccess.equals("0"))
				{
			
					JSONObject obj = jsonObject.getJSONObject("ApiWebProperties");
					
					BatchNumber = obj.getString("CurrentBatchNumber");
					
					if(BatchNumber != null && !BatchNumber.equals(""))
					{
						System.out.println("BatchNumber: "+BatchNumber);
						
						return BatchNumber;
					}
				}else 
					BatchNumber = "";
				
				
			} catch(Exception e)
			{
				BatchNumber = "";
				e.printStackTrace();
			}
			
			
		}catch(Exception e)
		{
			BatchNumber = "";
			e.printStackTrace();
		}
		
		return BatchNumber;
	}

}
