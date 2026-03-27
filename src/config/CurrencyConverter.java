package config;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONObject;


import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import data.HashMapData;

public class CurrencyConverter {
	
	public double ConversionRate = 0;
	double CurrencyRate = 0;
	double TotalAmountInINR = 0;

	
	/*private double GetCurrencyRate1(String CurrencyCode, String OWSProperty, String ReservationNo)
	{
	
		ConfigPayloads payloads = new ConfigPayloads();
		
		String payload = payloads.getCurrencyConverterPayload(CurrencyCode, OWSProperty);
			
			
			try {
			
				String WSDL = Configuration.CurrencyConverterWSDL;
				String Action = Configuration.CurrencyConverterActionURL;
				
				String userName = "datacentre";
				String password = "Smile@25";
				
				SoapExecutor soapExecutor = new SoapExecutor(WSDL);
				
				try{
					BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + ReservationNo + ".txt",true));
					
					writer.write("\nCurrencyConverter Request payload: \n" + payload + "\n\n");
					writer.write((new Date()).toString());
					writer.close();
					
				} catch(Exception e)
				{
					e.printStackTrace();
				}
				
				String responce = soapExecutor.executeRequest(userName, password, Action,payload);
				
				System.out.println("Currency Converter Request: \n" + payload);
				
				System.out.println("Currency Converter Response: \n" + responce); 
				
				try{
					BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + ReservationNo +".txt",true));
					
					writer.write("\nCurrencyConverter Response: \n" + responce + "\n\n");
					writer.write((new Date()).toString());
					writer.close();
					
				} catch(Exception e)
				{
					e.printStackTrace();
				}
				
				Document doc = soapExecutor.convertStringToDocument(responce);
				
				
				NodeList nList = doc.getElementsByTagName("s0:CurrencyConverterResponse");
				
				for(int i=0; i<nList.getLength(); i++)
				{
					Element ele = (Element) nList.item(i);
					
					Element eleSuccess = (Element) ele.getElementsByTagName("s0:Result").item(0);
					
					String isSuccess = eleSuccess.getAttribute("resultStatusFlag");
					
					System.out.println(isSuccess);
					
					if(isSuccess.equalsIgnoreCase("SUCCESS"))
					{
						CurrencyRate  = Integer.parseInt(ele.getElementsByTagName("s0:ToCurrencyAmt").item(0).getTextContent());
						
						ConversionRate = CurrencyRate;
						
						System.out.println(CurrencyRate);
					}
					
					
				}
				
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		return CurrencyRate;
	}
	*/
	
	private double GetCurrencyRate(String CurrencyCode, String OWSProperty, String ReservationNo)
	{
		/*if(true)
		{
			return 1;
		}*/
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date d = new Date();
		String conversionDate = dateFormat.format(d);
		
		ConfigPayloads payloads = new ConfigPayloads();
		String payload = payloads.getSiebelCurrencyCodePayload(CurrencyCode, conversionDate);
		
		JSONObject object = null;
		
		try {
			
			/*
			 * OkHttpClient client = new OkHttpClient();
			 * 
			 * MediaType mediaType = MediaType.parse("application/json"); RequestBody body =
			 * RequestBody.create(mediaType, payload); Request request = new
			 * Request.Builder() .url(Configuration.SiebelCurrencyConverter) .post(body)
			 * .addHeader("Content-Type", "application/json") .addHeader("Authorization",
			 * Configuration.IcsBasicAuth) .addHeader("Cache-Control", "no-cache")
			 * .addHeader("Postman-Token",
			 * "82c728b6-45a0-4830-acb6-fd86954d426b,1f88eaad-0d98-4a3b-9c13-e633e3bf72e1")
			 * .addHeader("Connection", "keep-alive") .addHeader("cache-control",
			 * "no-cache") .build();
			 * 
			 * Response response = client.newCall(request).execute();
			 */		
			OkHttpClient client = new OkHttpClient();
					Request request = new Request.Builder()
					  .url(Configuration.SiebelCurrencyConverter+"?currencyCode="+CurrencyCode)
					  .method("GET", null)
					  .addHeader("Authorization", "Basic b2ljX3VzZXI6SW5ub3ZhY3hAMzIx")
					  .build();
					Response response = client.newCall(request).execute();
			
			
			String resp = response.body().string();
			
			object = new JSONObject(resp);
			
			System.out.println("Currency Converter Request: \n" + payload);
			
			System.out.println("Currency Converter Resppnse: \n" + resp);
			
			JSONObject jsonObject = object.getJSONObject("IHCL_spcExchange_spcRate_spc_Output");
			
			String status = jsonObject.getString("Response");
			
			if(status.equalsIgnoreCase("Success"))
			{
				String rate = jsonObject.getString("Exchange_spcRate");
				
				CurrencyRate = Double.parseDouble(rate);
				
				ConversionRate = CurrencyRate;
				
				System.out.println(rate);
			}
			
		
		}catch(Exception e)
		{
			e.printStackTrace();
			
			String resp = object.toString();
			
			if(resp.contains("EAI Common Internal Error"))
			{
				CurrencyRate = 0;
				ConversionRate = CurrencyRate;
			}
		}
		
		return CurrencyRate;
	}
	
	public double convertCurrency(String CurrencyCode, String ResvId, String OWSProperty)
	{
		TotalAmountInINR = 0;
		HashMapData.mapCurrencyCode.put(ResvId, CurrencyCode);
		System.out.println("CurrencyCode : "+CurrencyCode);
		if(CurrencyCode.equalsIgnoreCase("INR"))
		{
			TotalAmountInINR = 1;
			HashMapData.mapCurrency.put(ResvId, Double.parseDouble("1"));
		}
		else 
		{
			if(ConversionRate != 0)
			{
				HashMapData.mapCurrency.put(ResvId, ConversionRate);
				TotalAmountInINR = ConversionRate;
				
			}else {
				
				double rate = GetCurrencyRate(CurrencyCode, OWSProperty, ResvId);
				if(rate != 0)
				{
					TotalAmountInINR = convertCurrency(CurrencyCode, ResvId, OWSProperty);
					HashMapData.mapCurrency.put(ResvId, rate);
				}
				
			}
		}
		
		
		return TotalAmountInINR;
	}

	
}
