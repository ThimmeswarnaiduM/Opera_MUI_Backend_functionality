import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

@WebServlet("/TCPValidateRedeem")
public class TCPValidateRedeem extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("null")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//System.out.println("GetBillDataServlet started");
		String ReservationID = request.getParameter("ReservId");
		String RefID = request.getParameter("RefID");
		String OTP = request.getParameter("OTP");
		String offerId = request.getParameter("offerId");
		GetMemberData tempMember = HashMapData.mapMemberData.get(ReservationID);
		String custHaash = tempMember.redeemTCPCustomerHash;
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		String t = dtf.format(now);
		System.out.println("date : " + t);
		
		String req = "{\r\n    \"programTnC\": \"false\",\r\n    "
				+ "\"marketingCommunication\": \"false\",\r\n    \"otp\": \""+OTP+"\","
				+ "\r\n    \"refId\": \""+RefID+"\",\r\n    "
				+ "\"loyalCustomer\": \"Y\",\r\n    \"appTnC\": \"true\",\r\n    "
				+ "\"redeemOffersRequest\": {\r\n        "
				+ "\"customerHash\": \""+custHaash+"\",\r\n        "
				+ "\"transactionId\": \""+ReservationID+"\",\r\n        \"offersToBeRedeemed\": [\r\n   "
				+ "{\r\n    \"offerId\": \""+offerId+"\",\r\n                "
				+ "\"numberOfTimesOfferApplied\": \"1\",\r\n                \"savings\": \"0.2\",\r\n                "
				+ "\"customerActivatedPromotion\": \"false\"\r\n            }\r\n        ],\r\n        "
				+ "\"redeemDateTime\": \""+t+"\"\r\n    }\r\n}";
		
		
		/*
		String req = "{\r\n    \"programTnC\": \"false\",\r\n    "
				+ "\"marketingCommunication\": \"false\",\r\n    \"otp\": \""+OTP+"\","
				+ "\r\n    \"refId\": \""+RefID+"\",\r\n    "
				+ "\"loyalCustomer\": \"Y\",\r\n    \"appTnC\": \"true\",\r\n    "
				+ "\"redeemOffersRequest\": {\r\n        "
				+ "\"customerHash\": \"ddbcd388b2c15ff65fb1110607a982d9\",\r\n        "
				+ "\"transactionId\": \""+ReservationID+"\",\r\n        \"offersToBeRedeemed\": [\r\n   "
				+ "{\r\n    \"offerId\": \"b098cfab-0bfd-4c0e-9a7d-4bee045evhrs:1-CYYE9IK\",\r\n                "
				+ "\"numberOfTimesOfferApplied\": \"1\",\r\n                \"savings\": \"0.2\",\r\n                "
				+ "\"customerActivatedPromotion\": \"false\"\r\n            }\r\n        ],\r\n        "
				+ "\"redeemDateTime\": \""+t+"\"\r\n    }\r\n}";
		*/
		OkHttpClient client = new OkHttpClient();
		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType, req);
		Request request2 = new Request.Builder().url(Configuration.TCP_MUI_VALIDATEREDEEM)//change link to prod						
				.method("POST", body).addHeader("Program-Id", "01eae2e1-ebcf-1bb0-956d-b0ebc692vhrs")
				.addHeader("Authorization", "Basic b2ljX3VzZXI6SW5ub3ZhY3hAMzIx")
				.addHeader("Content-Type", "application/json").build();
		Response response2 = client.newCall(request2).execute();
		
		String resp = response2.body().string().toString();
		JSONObject ValidateResponce = new JSONObject();
		
		try {
			JSONObject respVal  = new JSONObject(resp);
			JSONObject status = respVal.getJSONObject("redeemOffersResponse");
			String sMSG = status.getString("operationStatus");
			//String Scode = status.getString("operationStatusCode");//error
			JSONObject Error = respVal.getJSONObject("businessError");
			String eMSG = Error.getString("errorMessage");
			String Ecode = Error.getString("code");
			//System.out.println("Scode : "+Scode);
			System.out.println("SMSG : "+sMSG);
			System.out.println("Ecode : "+Ecode);
			System.out.println("eMSG : "+eMSG);
			if(sMSG.equals("Promotion's are  successfully Redeemed")) {
				
				ValidateResponce.put("status", "successfull");
			
			}else {
				ValidateResponce.put("status", eMSG);
				ValidateResponce.put("errorMessage", eMSG);
			}
			
		} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		System.out.println("OTPresp : "+ValidateResponce.toString());
		
		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + ReservationID+".txt",true));
			writer.write("\nValidate Redeem TCP request: \n" + req + "\n\n");
			writer.write("\nValidate Redeem TCP responce: \n" + ValidateResponce + "\n\n");
			writer.write((new Date()).toString());
			writer.close();
			
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		
		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.redemptionLog + ReservationID+"__TataNeuOffers__"+custHaash+".txt",true));
			writer.write("\nValidate Redeem TCP request: \n" + req + "\n\n");
			writer.write("\nValidate Redeem TCP responce: \n" + ValidateResponce + "\n\n");
			writer.write((new Date()).toString());
			writer.close();
			
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		
		response.getWriter().write(ValidateResponce.toString());
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}



}
