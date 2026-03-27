package config;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.json.JSONArray;
import org.json.JSONObject;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

public class GetMemberData implements Runnable {
	
	String MembershipNumber = "";
	String ReservationNo = "";
	String GlobalPropertyCode = "";
	
	public String TICPointsBalance = "";
	public String EpicurePointsBalance = "";
	public String MembershipTier = "";
	public String TcpCustomerHash = "";
	public String redeemTCPCustomerHash = "";
	public String phoneNumber = "";
	public String isdCode = "";
	

	public GetMemberData(String membershipNumber, String ReservationNo,String GlobalPropertyCode ) {
		super();
		MembershipNumber = membershipNumber;
		this.GlobalPropertyCode = GlobalPropertyCode;
		this.ReservationNo = ReservationNo;
	}
	
	public GetMemberData() {

	}



	@Override
	public void run() {

		try {
			ConfigPayloads payloads = new ConfigPayloads();
			
			String payload = payloads.getMemberDataPayload(MembershipNumber);
			
			try{
				BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + ReservationNo+".txt",true));
				
				writer.write("\nMember Data Request payload: \n" + payload + "\n\n");
				writer.write((new Date()).toString());
				writer.close();
				
			} catch(Exception e)
			{
				e.printStackTrace();
			} 

			System.out.println("Get Member Data Payload: \n" + payload);
			
			OkHttpClient client = new OkHttpClient();
			MediaType mediaType = MediaType.parse("application/json");
			RequestBody body = RequestBody.create(mediaType, payload);
			Request request = new Request.Builder()
			  .url(Configuration.GetMemberDataURL)
			  .method("POST", body).addHeader("Store_Id", GlobalPropertyCode)
			  .addHeader("Authorization", Configuration.IcsBasicAuth)
			  .addHeader("Content-Type", "application/json")
			  .build();
			Response responseMember = client.newCall(request).execute();
			
			String testResponse = responseMember.body().string();
			
			try{
				BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + ReservationNo+".txt",true));
				
				writer.write("\nMember Data Response: \n" + testResponse + "\n\n");
				writer.write((new Date()).toString());
				writer.close();
				
			} catch(Exception e)
			{
				e.printStackTrace();
			} 
			
			try {
			System.out.println("Get Member Data Response: \n" + testResponse);

			
			JSONObject objectMember = new JSONObject(testResponse);
				MembershipNumber = objectMember.getString("tcpNumber");
				TcpCustomerHash = objectMember.getString("customerHash");
				//PHONE NEW CODE
				JSONObject Phone = objectMember.getJSONObject("primaryMobile");
				phoneNumber = Phone.getString("phoneNumber");
				isdCode = Phone.getString("isdCode");
				System.out.println("ISD"+isdCode+"PHONE : "+phoneNumber );
				JSONArray loyArray = objectMember.getJSONArray("loyaltyInfo");
		        JSONObject loyObj = loyArray.getJSONObject(0);
		        MembershipTier = loyObj.getString("currentSlab");
		        TICPointsBalance = loyObj.getString("loyaltyPoints");
		        redeemTCPCustomerHash = TcpCustomerHash;
		        
		        if(TICPointsBalance != null && !TICPointsBalance.equals(""))
		        {
		        	TICPointsBalance = TICPointsBalance.substring(0, TICPointsBalance.length()-2);
		        }
		        
			}
	       catch(Exception e)
	       {
	    	   e.printStackTrace();
	       }

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return;
		}

		return;
	}
	
	public void clearCache()
	{
		TICPointsBalance = "";
		EpicurePointsBalance = "";
		MembershipTier = "";
		MembershipNumber = "";
		ReservationNo = "";
		isdCode = "";
		phoneNumber = "";
	}

}
