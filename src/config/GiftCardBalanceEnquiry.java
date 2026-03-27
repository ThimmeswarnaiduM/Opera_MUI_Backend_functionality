package config;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import data.GiftCardPropertyMapping;
import data.HashMapData;


@WebServlet("/GiftCardBalanceEnquiry") 
public class GiftCardBalanceEnquiry extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	String GlobalReservationNumber = "";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		performOperation(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	
	private void performOperation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("Balance Enquiry Called");
		
		String privilegeType="";
		try {
			GlobalReservationNumber = request.getParameter("GlobalReservationNumber");
		} catch(Exception e){}
		
		String CardNumber = request.getParameter("CardNumber");
		String CardPin = request.getParameter("CardPin");
		String Type=request.getParameter("Type");
		String Error ="",status="";
		
		if(Type.equals("GRAVTY")) {
			String VoucherNumber= request.getParameter("CardNumber");
			String Memtype = request.getParameter("Memtype");
			double availableBal=-1.0;
			
			// GRAVTY - check balance api Start
			try {

				OkHttpClient client = new OkHttpClient();
						MediaType mediaType = MediaType.parse("application/json");
						RequestBody body = RequestBody.create(mediaType, "{\r\n      \"Privilege_Id\": \""+VoucherNumber+"\",\r\n    \"MemberType\": \""+Memtype+"\"\r\n}");
						Request CheckBalrequest = new Request.Builder()
						  .url(Configuration.GET_ALL_PRIVILEGES)
						  .method("POST", body)
						  .addHeader("Authorization", "Basic T2ljX3VzZXI6SW5ub3ZhY3hAMzIx")
						  .addHeader("Content-Type", "application/json")
						  .build();
						Response CheckBalresponse = client.newCall(CheckBalrequest).execute();
							String resp = CheckBalresponse.body().string().toString();																
						//System.out.println("AvailResponse: "+resp);
						
						JSONObject jsonObject = new JSONObject(resp);
						
						//JSONObject object = jsonObject.getJSONObject("status");
						JSONArray response_jsonarr = jsonObject.getJSONArray("data");
						JSONObject data_obj = response_jsonarr.getJSONObject(0);
						 Object obj_privilegeType = data_obj.get("privilegeType");
						privilegeType = obj_privilegeType.toString();
						System.out.println("privilegeType: "+privilegeType);
						
						JSONObject Json_status = response_jsonarr.getJSONObject(0);
						Object obj_status = Json_status.get("status");
						status= obj_status.toString();
						
						if(privilegeType.equals("Fixed-Product")&& status.equals("AVAILABLE")) {
							JSONObject Json_value = response_jsonarr.getJSONObject(0);
							Object obj_value = Json_value.get("productCost");
							availableBal = (double) obj_value;
							System.out.println("availableBal: "+availableBal);	
							
							
						}
						
							//errorDetails = jsonObject.getString("o:errorDetails");	
						try {
							JSONArray error_jsonarr = jsonObject.getJSONArray("o:errorDetails");
							JSONObject item_obj = error_jsonarr.getJSONObject(0);
							Object item_id = item_obj.get("title");
							Error = item_id.toString();
							//title =errorDetails.substring("title");	
							int Start= Error.indexOf("message");
							Error=Error.substring(Start);
							System.out.println(Error);
							int End= Error.indexOf("\",");
							Error= Error.substring(10,End);									
							System.out.println(Error);
						} catch (Exception e) {
							// TODO: handle exception
						}
							
								
					
			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				if(availableBal== -1.0 && !privilegeType.equals("Fixed-Product") )
					response.getWriter().write("Invalid Voucher");
				else if(availableBal== -1.0 && privilegeType.equals("Fixed-Product") && status.equals("USED"))
					response.getWriter().write("Voucher is already used");
				else if(availableBal== -1.0 && Error.equals("Invalid unique privilege code")) {
					response.getWriter().write(Error);						
				}
				else {
					
				}
				if(privilegeType.equals("Fixed-Product")&& status.equals("AVAILABLE") && availableBal!= -1.0)	{			
				response.getWriter().write("Balance: " + availableBal);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(Type.equals("QGC")) {
			try
			{
				BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.giftCardLogLoc + request.getParameter("GlobalReservationNumber")+".txt",true));

				writer.write("\n\nBalance Enquiry Card Number:\t " + CardNumber + "\n");
				
				writer.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			
			GetReservationData reservationData = HashMapData.mapReservationData.get(GlobalReservationNumber);
			String PropertyCode = reservationData.OWSProperty;
			
			//code to get the property name
			@SuppressWarnings("unused")
			Configuration configuration = new Configuration();
			GiftCardPropertyMapping mapping = new GiftCardPropertyMapping();
			String PropertyName = mapping.getGcHotelName(PropertyCode);
			
			
			String TerminalID = GiftCardRequestHeader.TerminalID;
			String DateAtClient = mapping.getDateAtClient();
			String ForwardEntityId = GiftCardRequestHeader.ForwardEntityId;
			String ForwardingEntityPassword = GiftCardRequestHeader.ForwardingEntityPassword;
			String TransactionId = mapping.getTransactionId();
			String UserName = GiftCardRequestHeader.UserName;
			String Password = GiftCardRequestHeader.Password;
			String OrganizationName = GiftCardRequestHeader.OrganizationName;
			String MerchantOutletName = PropertyName;
			String POSEntryMode = GiftCardRequestHeader.POSEntryMode;
			String POSTypeId = GiftCardRequestHeader.POSTypeId;
			
			try
			{
			
				GetGiftCardBatchNumber giftCardBatchNumber = new GetGiftCardBatchNumber(TerminalID, DateAtClient, ForwardEntityId, ForwardingEntityPassword, TransactionId, UserName, Password);
				
				String BatchNumber = giftCardBatchNumber.batchNumber();
				
				OkHttpClient client = new OkHttpClient();
		
				MediaType mediaType = MediaType.parse("application/json");
				//RequestBody body = RequestBody.create(mediaType, "{\r\n\"CardNumber\": \""+CardNumber+"\"\r\n} ");
				RequestBody body = RequestBody.create(mediaType, "{\r\n" + 
						"    \"CardNumber\": \""+CardNumber+"\",\r\n" + 
						"    \"CardPin\": \""+CardPin+"\"\r\n" + 
						"}");
				Request request1 = new Request.Builder()
				  .url(Configuration.GiftCardBalanceEnquiryURL)
				  .post(body)
				  .addHeader("content-type", "application/json")
				  .addHeader("TerminalID", TerminalID)
				  .addHeader("ForwardEntityId", ForwardEntityId)
				  .addHeader("ForwardingEntityPassword", ForwardingEntityPassword)
				  .addHeader("UserName", UserName)
				  .addHeader("Password", Password)
				  .addHeader("TransactionId", TransactionId)
				  .addHeader("DateAtClient", DateAtClient)
				  .addHeader("POSEntryMode", POSEntryMode)
				  .addHeader("POSTypeId", POSTypeId)
				  .addHeader("MerchantOutletName", MerchantOutletName)
				  .addHeader("OrganizationName", OrganizationName)
				  .addHeader("CurrentBatchNumber", BatchNumber)
				  .addHeader("authorization", Configuration.IcsBasicAuth)
				  .addHeader("cache-control", "no-cache")
				  .addHeader("postman-token", "156b7f7a-1618-7724-8edd-02fd68afd9b2")
				  .build();
				
				
				try
				{
					BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.giftCardLogLoc + request.getParameter("GlobalReservationNumber")+".txt",true));

					writer.write("\n\nBalance Enquiry Request:\t " + request1.headers() + "\n");
					
					writer.close();
				}catch(Exception e)
				{
					e.printStackTrace();
				}
		
				Response response1 = client.newCall(request1).execute();
				
				String Resp = response1.body().string();
				
				System.out.println("GC Balance Enquiry Resp: \n" + Resp);
				
				try
				{
					BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.giftCardLogLoc + request.getParameter("GlobalReservationNumber")+".txt",true));

					writer.write("\n\nBalance Enquiry Response:\n " + Resp + "\n");
					
					writer.close();
				}catch(Exception e)
				{
					e.printStackTrace();
				}
				
				//response.getWriter().write("Balance Enquiry Response: \n" + Resp);
				
				JSONObject object = new JSONObject(Resp);
				
				String isSuccess = object.getString("ResponseCode");
				
				if(isSuccess.equals("0"))
				{
					String Bal = object.getString("Amount");
					
					//String Balance = Bal.substring(0, Bal.length()-2);
					
					String Balance = Bal;
					
					System.out.println("Available Balance: \t" + Balance);
					
					response.getWriter().write("Balance: " + Balance);
					
					return;
				} else if(isSuccess.equals("10004"))
				{
					response.getWriter().write("Invalid Card Number");
					return;
					
				} else if(isSuccess.equals("10136"))
				{
					response.getWriter().write("Card Disabled");
					return;
					
				} else if(isSuccess.equals("10001"))
				{
					response.getWriter().write("Card Expired");
					return;
					
				} else if(isSuccess.equals("10002"))
				{
					response.getWriter().write("Card Deactivated");
					return;
					
				} else if(isSuccess.equals("10029"))
				{
					response.getWriter().write("Card Not Active");
					return;
					
				} else if(isSuccess.equals("10064"))
				{
					//response.getWriter().write("Invalid batch number");
					System.out.println("Invalid batch number");
					HashMapData.mapBatchNumber.put("BatchNumber", "null");
					performOperation(request, response);
					return;
				} else
				{
					response.getWriter().write("Please try again later");
					return;
				}
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}			
		}

	}
	

}
