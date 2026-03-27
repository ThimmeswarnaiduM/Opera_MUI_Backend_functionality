package config;

import java.util.concurrent.TimeUnit;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

public class GetOffersData {

	public static void main(String[] args) {
		
		GetOffersData offersData = new GetOffersData();
		offersData.getOffers("101015305090", "");

	}
	
	public String getOffers(String MemberNumber, String ReservationIDz)
	{
		ConfigPayloads payloads = new ConfigPayloads();
		String payload = payloads.getOffersPayload(MemberNumber);
	
		try
		{
		
			OkHttpClient client = new OkHttpClient();
			client.setConnectTimeout(120, TimeUnit.SECONDS); // connect timeout
			client.setReadTimeout(120, TimeUnit.SECONDS);
	
			System.out.println("offerPayload:\n" + payload + "\nURL:\t" + Configuration.OfferQueryURL);
			
			MediaType mediaType = MediaType.parse("application/json");
			RequestBody body = RequestBody.create(mediaType, payload);
			Request request = new Request.Builder()
			  //.url("https://tajics-a455764.integration.us2.oraclecloud.com/integration/flowapi/rest/QUERYOFFER/v01/OfferQuery")
			  .url(Configuration.OfferQueryURL)
			  .post(body)
			  .addHeader("Content-Type", "application/json")
			  .addHeader("Authorization", Configuration.IcsBasicAuth)
			  .addHeader("Cache-Control", "no-cache")
			  .addHeader("Postman-Token", "cc0e0a23-fc93-4d83-898f-b46473adc304")
			  .build();
	
			Response response = client.newCall(request).execute();
			String resp = response.body().string().toString();
			System.out.println(resp);
			
			return resp;
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return "error";
	}

}
