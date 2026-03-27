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
import config.GetProfileData;
import config.GetReservationData;
import config.GetVouchersData;
import data.HashMapData;


@WebServlet("/GetVouchersDataServlet")
public class GetVouchersDataServlet extends HttpServlet {
	//System.out.println("GetVouchersDataServlet started");
	private static final long serialVersionUID = 1L;
	public static HashMap<String,String> GravtyMemberNumber=new HashMap<String,String>();
	public static HashMap<String,String> VoucherPinHashMap=new HashMap<String,String>();// Hash map to store pin
 

	@SuppressWarnings("null")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("GetVouchersDataServlet started");
		//delete after debug\/
		System.out.println("GetVouchersDataServlet degugging");
		
		String ReservationID = request.getParameter("ReservId");
		
		GetProfileData getProfileData = HashMapData.mapProfileData.get(ReservationID);
		String MemberNumber = getProfileData.EnrollNumber_c;
		String CHMemberNumber = getProfileData.CHMemberNumber;
		String EPIMemberNumber = getProfileData.EPIMemberNumber;		
		System.out.println("EPIMemberNumber:"+ EPIMemberNumber);
		GetVouchersData vouchersData = new GetVouchersData();
		String resp = null ;
		String resp_ = null ;
		JSONArray array = new JSONArray();
		
		//updated uedvochers code
		JSONArray usedVochersArray = new JSONArray();
		JSONArray expiredVochersArray = new JSONArray();
		
		//Get TCP vouchers - Start
		
		/*
		 * GetMemberData tempMember = HashMapData.mapMemberData.get(ReservationID);
		 * String custHaash= tempMember.redeemTCPCustomerHash; // String
		 * custHaash="672060e4c42939c2004cc00eefc65209";
		 * System.out.println("custHaash : "+custHaash);
		 * 
		 * OkHttpClient client = new OkHttpClient(); MediaType mediaType =
		 * MediaType.parse("application/json"); RequestBody body =
		 * RequestBody.create(mediaType,
		 * "{\r\n    \"fetchCustomerOffersByStatusRequest\": {\r\n        \"customerHash\": \""
		 * +custHaash+"\",\r\n        \"programId\": \"01eac520-bc7a-1a10-8675-cf6516f1f134\",\r\n        \"status\": \"ADDED_TO_VAULT\",\r\n        \"isChannelsRequired\": true\r\n    }\r\n}"
		 * ); Request request_ = new Request.Builder()
		 * .url(Configuration.fetchCustomerOffersByStatus) .method("POST", body)
		 * .addHeader("Program-Id", "01eac520-bc7a-1a10-8675-cf6516f1f134")
		 * .addHeader("Authorization", "Basic b2ljX3VzZXI6SW5ub3ZhY3hAMzIx")
		 * .addHeader("Content-Type", "application/json") .build(); Response response_ =
		 * client.newCall(request_).execute();
		 * 
		 * JSONObject jsonObject_ = null; JSONObject jsonObject02_ =null; try {
		 * jsonObject_ = new JSONObject(response_.body().string().toString()); } catch
		 * (JSONException e1) { // TODO Auto-generated catch block e1.printStackTrace();
		 * } catch (IOException e1) { // TODO Auto-generated catch block
		 * e1.printStackTrace(); } String str=""; String offerId =""; String
		 * programId=""; try { str=
		 * jsonObject_.getJSONObject("fetchCustomerOffersByStatusResponse").getString(
		 * "offerDetails"); } catch (JSONException e2) { // TODO Auto-generated catch
		 * block
		 * 
		 * } // JSONArray str_=str;
		 * 
		 * JSONArray jArray = null; try { jArray = new JSONArray(str); } catch
		 * (JSONException e2) {
		 * 
		 * } String customerRedemptionsDetails="", overallExpiry="",promotionType="";;
		 * JSONArray JSONArray_customerRedemptionsDetails=null; try { int lenght =0; try
		 * { lenght =jArray.length(); } catch (Exception e) { // TODO: handle exception
		 * } if(lenght>0) { for(int i=0;i<lenght;i++) {
		 * 
		 * offerId=jArray.getJSONObject(i).getString("offerId"); programId
		 * =jArray.getJSONObject(i).getString("programId");
		 * customerRedemptionsDetails=jArray.getJSONObject(i).getString("expiryDetails")
		 * ; JSONArray_customerRedemptionsDetails = new
		 * JSONArray(customerRedemptionsDetails);
		 * overallExpiry=JSONArray_customerRedemptionsDetails.getJSONObject(0).getString
		 * ("expiryDate");
		 * 
		 * 
		 * //get voucher description - Start String req =
		 * "{\r\n    \"getOffersDescriptionDetailsRequest\": {\r\n        \"programId\": \""
		 * +programId+"\",\r\n        \"offerIds\": [\r\n            \""
		 * +offerId+"\"\r\n        ]\r\n    }\r\n}"; OkHttpClient _client = new
		 * OkHttpClient(); MediaType _mediaType = MediaType.parse("application/json");
		 * RequestBody _body = RequestBody.create(_mediaType, req); Request _request =
		 * new Request.Builder() .url(Configuration.getRedemptionDetails)
		 * .method("POST", _body) .addHeader("Program-Id",
		 * "01eac520-bc7a-1a10-8675-cf6516f1f134") .addHeader("Authorization",
		 * "Basic b2ljX3VzZXI6SW5ub3ZhY3hAMzIx") .addHeader("Content-Type",
		 * "application/json") .build(); Response _response =
		 * _client.newCall(_request).execute(); JSONObject _jsonObject02 =null;
		 * System.out.println("descp req body= "+req); try { _jsonObject02 = new
		 * JSONObject(_response.body().string().toString()); } catch (JSONException e1)
		 * { // TODO Auto-generated catch block e1.printStackTrace(); } catch
		 * (IOException e1) { // TODO Auto-generated catch block e1.printStackTrace(); }
		 * String _str=""; String promotionDescription =""; JSONArray _jArray = null;
		 * 
		 * try { _str=
		 * _jsonObject02.getJSONObject("getOffersDescriptionDetailsResponse").getString(
		 * "descriptionDetails"); _jArray = new JSONArray(_str);
		 * promotionDescription=_jArray.getJSONObject(0).getString("offerDescription");
		 * // customerRedemptionsDetails=_jArray.getJSONObject(0).getString(
		 * "descriptionDetails");
		 * promotionType=_jArray.getJSONObject(0).getString("offerType"); } catch
		 * (Exception e) { // TODO: handle exception }
		 * 
		 * 
		 * // System.out.println("resp :"+_response.toString()); JSONObject o = new
		 * JSONObject(); try { o.put("MemberType", "TCP"); o.put("VoucherNumber",
		 * offerId); o.put("Description", promotionDescription); o.put("VoucherType",
		 * promotionType); //o.put("ExpirationDate", tmpVoucherExpiry);
		 * o.put("ExpirationDate", overallExpiry); } catch (Exception e) { // TODO:
		 * handle exception } array.put(o); }
		 * 
		 * 
		 * //get voucher description - End
		 * 
		 * //end for loop } } catch (JSONException e2) {
		 * 
		 * }
		 */
		//Get TCP vouchers - End
		
		

		
		String Reservation_Status =GetReservationData.Reservation_status;
			
		if (!CHMemberNumber.equals("")) {
			resp = vouchersData.getVouchers(CHMemberNumber, ReservationID,"Chambers");		
			if(resp.contains("There is no available Vouchers for the given"))
			{
				try {
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("CustomStatus", "ERROR");
					jsonObject.put("MSG", "No Vouchers available for this member");
					response.getWriter().write(jsonObject.toString());
					return;
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			
			try{
				BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + ReservationID+".txt",true));
				
				writer.write("\nFetch Vouchers Response: \n" + resp + "\n\n");
				writer.close();
				
			} catch(Exception e)
			{
				e.printStackTrace();
			}
			
			/*try {
				
				JSONObject jsonObject = new JSONObject(resp);
				
				JSONObject object = jsonObject.getJSONObject("IHCL_spcVoucher_spcOperations_spcWS_spcWebsite_spcV1_Output");
				
				String status = object.getString("Response");
				
				System.out.println(status);
				
				JSONArray array = new JSONArray();
				
				if(status.equals("Success"))
				{
					JSONObject objVoucherInfo = object.getJSONObject("ListOfIhclVoucherIo");
					
					JSONArray jsonArray = objVoucherInfo.getJSONArray("LoyVoucherAll");
					
					for(int i=0; i<jsonArray.length(); i++)
					{
						JSONObject objVouchers = jsonArray.getJSONObject(i);
						
						String VoucherDesc = objVouchers.getString("Description");
						String VoucherExpiry = objVouchers.getString("ExpirationDate");
						
						String VoucherType = objVouchers.getString("IHCLVoucherType");
						String VoucherNumber = objVouchers.getString("VoucherNumber");
						String tmpVoucherExpiry = "";
					
						try {
						    Date date1 = new SimpleDateFormat("MM/dd/yyyy").parse(VoucherExpiry.substring(0, 10));
						    tmpVoucherExpiry = new SimpleDateFormat("dd-MM-yyyy").format(date1);
						}catch(Exception e)
						{
							e.printStackTrace();
						}
						
						
						JSONObject o = new JSONObject();
					//	o.put("VoucherNumber", VoucherNumber);
					//	o.put("Description", VoucherDesc);
					//	o.put("VoucherType", VoucherType);
					//	o.put("ExpirationDate", tmpVoucherExpiry);
					
						o.put("VoucherNumber", "VoucherNumber");
					    o.put("Description", "VoucherDesc");
						o.put("VoucherType", "VoucherType");
						o.put("ExpirationDate", "tmpVoucherExpiry");
							
						array.put(o);

						
					}
					
					System.out.println(array.toString());
					
					response.getWriter().write(array.toString());
					return;
				}
				
			}
			*//* catch (JSONException e) {
			
				e.printStackTrace();
			}
			*/
				
				// Gravty Avail voucher code
	try {

		
		JSONObject jsonObject = new JSONObject(resp);
		

			JSONArray jsonArray = jsonObject.getJSONArray("data");									
			
			
			for(int i=0; i<jsonArray.length(); i++)
			{
				
				try{
					BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + ReservationID+".txt",true));
					
					writer.write("\nVoucher For loop entered  \n");				
					writer.close();
					
				} catch(Exception e)
				{
					e.printStackTrace();
				}
				JSONObject objVouchers = jsonArray.getJSONObject(i);
				String status = objVouchers.getString("status");
				String VoucherType = objVouchers.getString("privilegeType");
				String VoucherExpiry = objVouchers.getString("VALID_TILL");
				int timeZoneIndex = VoucherExpiry.indexOf("+");		            		           
	            VoucherExpiry = VoucherExpiry.substring(0, timeZoneIndex);
	            
			LocalDateTime today = LocalDateTime.now();
			
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
		        LocalDateTime givenDate = LocalDateTime.parse(VoucherExpiry, formatter);
		        int comparisonResult = today.compareTo(givenDate);
						
	        
				if(status.equals("AVAILABLE") && Reservation_Status.equalsIgnoreCase("CHECKED IN") &&(comparisonResult < 0)) {
			if( (VoucherType.equals("Fixed-Product") || VoucherType.equals("Fixed-Discount")) ) {
				System.out.println("Voucher Status: "+status);
				String VoucherDesc = objVouchers.getString("PRODUCT_NAME");
				//String VoucherExpiry = objVouchers.getString("VALID_TILL");
				VoucherExpiry = VoucherExpiry.replace("T", " ");
				
				String VoucherNumber = objVouchers.getString("PRIVILEGE_CODE");
				
				String MemberType = objVouchers.getString("offerTitle");
				GravtyMemberNumber.put("CHMemberId",objVouchers.getString("memberID"));
				String tmpVoucherExpiry = "";
				
				String sub_date=VoucherExpiry.substring(0, 10);
				
				String VoucherPin = objVouchers.getString("pin");
				VoucherPinHashMap.put(VoucherNumber,VoucherPin);
				
			//	String str_availableBal = objVouchers.getString("productCost");
				Double str_availableBal = objVouchers.getDouble("productCost");
				Double availableBal =str_availableBal;
	//			Double availableBal = Double.parseDouble(str_availableBal);
				try {
				    Date date1 = new SimpleDateFormat("YYYY-MM-DD").parse(sub_date);
				    tmpVoucherExpiry = new SimpleDateFormat("dd-MM-yyyy").format(date1);
					
				}catch(Exception e)
				{
					e.printStackTrace();
				}
				
				try{
					BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + ReservationID+".txt",true));
					
					writer.write("\nVoucherNumber"+VoucherNumber);
					writer.write("\nVoucherDesc"+VoucherDesc);
					writer.write("\nVoucherType"+VoucherType);
					writer.write("\ntmpVoucherExpiry"+VoucherExpiry);
					writer.close();
					
				} catch(Exception e)
				{
					e.printStackTrace();
				}
				
				System.out.println("VoucherNumber"+VoucherNumber);
				System.out.println("VoucherDesc"+VoucherDesc);
				System.out.println("VoucherType"+VoucherType);
				System.out.println("tmpVoucherExpiry"+tmpVoucherExpiry);							
				
				JSONObject o = new JSONObject();
				o.put("MemberType", MemberType);
				o.put("VoucherNumber", VoucherNumber);
				o.put("Description", VoucherDesc);
				o.put("VoucherType", availableBal);
				//o.put("ExpirationDate", tmpVoucherExpiry);
				o.put("ExpirationDate", VoucherExpiry);

					
				array.put(o);


			}// IF END
			}//updated codev
				else if(status.equals("USED") ){
					if( (VoucherType.equals("Fixed-Product")) || VoucherType.equals("Fixed-Discount")){
					String VoucherDesc = objVouchers.getString("PRODUCT_NAME");
					if( 
(VoucherType.equals("Fixed-Product")) || VoucherType.equals("Fixed-Discount")||
							
							VoucherDesc.equalsIgnoreCase("Complimentary Room Night including breakfast for two persons.") || 
							VoucherDesc.equalsIgnoreCase("20% discount on Best Available Rates") ||	
							VoucherDesc.equalsIgnoreCase("20% Discount on Best Available Rate for Room/Suite Stay at Taj Palaces") ||
							VoucherDesc.equalsIgnoreCase("20% Discount on Best Available Rate for Room/Suite Stay at Taj Safaris") 
							
						
							
							
							){
					
					String VoucherNumber = objVouchers.getString("PRIVILEGE_CODE");
					String UsedOn = objVouchers.getString("usageDate");
					String MemberType = objVouchers.getString("offerTitle");
					Double availableBal = objVouchers.getDouble("productCost");
					
					String MemberIdUsed = objVouchers.getString("memberID");
					String AvailmentBitIdUsed = objVouchers.getString("availmentBitID");
					//update 1
					JSONObject o = new JSONObject();
								o.put("MemberTypeUsed", MemberType);
								o.put("VoucherNumberUsed", VoucherNumber);
								o.put("DescriptionUsed", VoucherDesc);
								o.put("VoucherTypeUsed", availableBal);
								//o.put("ExpirationDate", tmpVoucherExpiry);
								o.put("UsedOn", UsedOn);
								//update 1
								o.put("MemberIdUsed", MemberIdUsed);
								o.put("AvailmentBitIdUsed", AvailmentBitIdUsed);

									
								usedVochersArray.put(o);
					}
					}
				}
								
			}//FOR END
			try{
				BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + ReservationID+".txt",true));
				
				writer.write("\nAvailable Vouchers:  \n" + array.toString() + "\n\n");				
				writer.close();
				
			} catch(Exception e)
			{
				e.printStackTrace();
			}
			


		
	} catch (Exception e2) {
		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + ReservationID+".txt",true));
			
			writer.write(e2.toString());				
			writer.close();
			
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		
		// TODO: handle exception
	}			
			
			
			
		}
		
		System.out.println("===");
		//EPIMemberNumber = 	"202020002855";
		
		if(!EPIMemberNumber.equals("")){
			resp = vouchersData.getVouchers(EPIMemberNumber, ReservationID,"Epicure");
			
			if(resp.contains("There is no available Vouchers for the given"))
			{
				try {
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("CustomStatus", "ERROR");
					jsonObject.put("MSG", "No Vouchers available for this member");
					response.getWriter().write(jsonObject.toString());
					return;
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			
			/*try{
				BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + ReservationID+".txt",true));
				
				writer.write("\nFetch Vouchers Response: \n" + resp + "\n\n");
				writer.close();
				
			} catch(Exception e)
			{
				e.printStackTrace();
			}*/
			
			/*try {
				
				JSONObject jsonObject = new JSONObject(resp);
				
				JSONObject object = jsonObject.getJSONObject("IHCL_spcVoucher_spcOperations_spcWS_spcWebsite_spcV1_Output");
				
				String status = object.getString("Response");
				
				System.out.println(status);
				
				JSONArray array = new JSONArray();
				
				if(status.equals("Success"))
				{
					JSONObject objVoucherInfo = object.getJSONObject("ListOfIhclVoucherIo");
					
					JSONArray jsonArray = objVoucherInfo.getJSONArray("LoyVoucherAll");
					
					for(int i=0; i<jsonArray.length(); i++)
					{
						JSONObject objVouchers = jsonArray.getJSONObject(i);
						
						String VoucherDesc = objVouchers.getString("Description");
						String VoucherExpiry = objVouchers.getString("ExpirationDate");
						
						String VoucherType = objVouchers.getString("IHCLVoucherType");
						String VoucherNumber = objVouchers.getString("VoucherNumber");
						String tmpVoucherExpiry = "";
					
						try {
						    Date date1 = new SimpleDateFormat("MM/dd/yyyy").parse(VoucherExpiry.substring(0, 10));
						    tmpVoucherExpiry = new SimpleDateFormat("dd-MM-yyyy").format(date1);
						}catch(Exception e)
						{
							e.printStackTrace();
						}
						
						
						JSONObject o = new JSONObject();
					//	o.put("VoucherNumber", VoucherNumber);
					//	o.put("Description", VoucherDesc);
					//	o.put("VoucherType", VoucherType);
					//	o.put("ExpirationDate", tmpVoucherExpiry);
					
						o.put("VoucherNumber", "VoucherNumber");
					    o.put("Description", "VoucherDesc");
						o.put("VoucherType", "VoucherType");
						o.put("ExpirationDate", "tmpVoucherExpiry");
							
						array.put(o);

						
					}
					
					System.out.println(array.toString());
					
					response.getWriter().write(array.toString());
					return;
				}
				
			}
			*//* catch (JSONException e) {
			
				e.printStackTrace();
			}
			*/
				
				// Gravty Avail voucher code
	try {
		JSONArray jsonArray = null;
				JSONObject jsonObject =null;
		
		try {

			jsonObject = new JSONObject(resp);
			

				jsonArray = jsonObject.getJSONArray("data");
			
	
		} catch (Exception e) {
			// TODO: handle exception
		}			
			for(int i=0; i<jsonArray.length(); i++)
			{
				JSONObject objVouchers = jsonArray.getJSONObject(i);
				String status = objVouchers.getString("status");
				String VoucherType = objVouchers.getString("privilegeType");
				String Voucher_Desc = objVouchers.getString("PRODUCT_NAME");
				String VoucherExpiry = objVouchers.getString("VALID_TILL");
				//VoucherExpiry = VoucherExpiry.replace("T", " ");
				//String VoucherExpiry = "2023-07-30T22:32:00";
				 int timeZoneIndex = VoucherExpiry.indexOf("+");		            		           
		            VoucherExpiry = VoucherExpiry.substring(0, timeZoneIndex);
		            
				LocalDateTime today = LocalDateTime.now();
				
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
			        LocalDateTime givenDate = LocalDateTime.parse(VoucherExpiry, formatter);
			        int comparisonResult = today.compareTo(givenDate);
							
		        
		        
				
				if(status.equals("AVAILABLE")&&(comparisonResult < 0)) {
				if( (VoucherType.equals("Fixed-Product")) || VoucherType.equals("Fixed-Discount")||
						
						Voucher_Desc.equalsIgnoreCase("Complimentary Room Night including breakfast for two persons.") || 
						Voucher_Desc.equalsIgnoreCase("20% discount on Best Available Rates") ||	
						Voucher_Desc.equalsIgnoreCase("20% Discount on Best Available Rate for Room/Suite Stay at Taj Palaces") ||
						Voucher_Desc.equalsIgnoreCase("20% Discount on Best Available Rate for Room/Suite Stay at Taj Safaris") ) {
				
				
				
				
				
				String VoucherNumber = objVouchers.getString("PRIVILEGE_CODE");
			
				
				String MemberType = objVouchers.getString("offerTitle");
				String tmpVoucherExpiry = "";
				String VoucherPin = objVouchers.getString("pin");
				VoucherPinHashMap.put(VoucherNumber,VoucherPin);				
				//String str_availableBal = objVouchers.getString("productCost");
				Double str_availableBal = objVouchers.getDouble("productCost");
					Double availableBal = str_availableBal ;
			//	Double availableBal = Double.parseDouble(str_availableBal);
				String sub_date=VoucherExpiry.substring(0, 10);
				try {
				    Date date1 = new SimpleDateFormat("YYYY-MM-DD").parse(sub_date);
				    tmpVoucherExpiry = new SimpleDateFormat("dd-MM-yyyy").format(date1);
					
				}catch(Exception e)
				{
					e.printStackTrace();
				}
				
				System.out.println("VoucherNumber"+VoucherNumber);
				System.out.println("VoucherDesc"+Voucher_Desc);
				System.out.println("VoucherType"+availableBal);
				System.out.println("tmpVoucherExpiry"+tmpVoucherExpiry);
				VoucherExpiry = VoucherExpiry.replace("T", " ");
				JSONObject o = new JSONObject();
				o.put("MemberType", MemberType);
				o.put("VoucherNumber", VoucherNumber);
				o.put("Description", Voucher_Desc);
				o.put("VoucherType", availableBal);
				//o.put("ExpirationDate", tmpVoucherExpiry);
				o.put("ExpirationDate", VoucherExpiry);

					
				array.put(o);

				
			}
			}//updated code usedv
				else if(status.equals("USED") ){
					String VoucherDesc = objVouchers.getString("PRODUCT_NAME");
					if( (VoucherType.equals("Fixed-Product")) || VoucherType.equals("Fixed-Discount")||
							
							VoucherDesc.equalsIgnoreCase("Complimentary Room Night including breakfast for two persons.") || 
							VoucherDesc.equalsIgnoreCase("20% discount on Best Available Rates") ||	
							VoucherDesc.equalsIgnoreCase("20% Discount on Best Available Rate for Room/Suite Stay at Taj Palaces") ||
							VoucherDesc.equalsIgnoreCase("20% Discount on Best Available Rate for Room/Suite Stay at Taj Safaris") 
							
							
							){
				
					String VoucherNumber = objVouchers.getString("PRIVILEGE_CODE");
					String UsedOn = objVouchers.getString("usageDate");
					String MemberType = objVouchers.getString("offerTitle");
					Double availableBal = objVouchers.getDouble("productCost");
					
					String MemberIdUsed = objVouchers.getString("memberID");
					String AvailmentBitIdUsed = objVouchers.getString("availmentBitID");
					
					JSONObject o = new JSONObject();
								o.put("MemberTypeUsed", MemberType);
								o.put("VoucherNumberUsed", VoucherNumber);
								o.put("DescriptionUsed", VoucherDesc);
								o.put("VoucherTypeUsed", availableBal);
								//o.put("ExpirationDate", tmpVoucherExpiry);
								o.put("UsedOn", UsedOn);
								o.put("MemberIdUsed", MemberIdUsed);
								o.put("AvailmentBitIdUsed", AvailmentBitIdUsed);

								usedVochersArray.put(o);
					}
				}
				else if(status.equals("AVAILABLE") && !Reservation_Status.equalsIgnoreCase("CHECKED IN")  && 
						!Reservation_Status.equalsIgnoreCase("CANCELLED")  && 
						!Reservation_Status.equalsIgnoreCase("NO SHOW")&&(comparisonResult < 0)) {
					

					
					
					String VoucherDesc = objVouchers.getString("PRODUCT_NAME");
					String VoucherExpiry1 = objVouchers.getString("VALID_TILL");
					VoucherExpiry1 = VoucherExpiry1.replace("T", " ");
					
					String VoucherNumber = objVouchers.getString("PRIVILEGE_CODE");
				
					
					String MemberType = objVouchers.getString("offerTitle");
					String tmpVoucherExpiry = "";
					String VoucherPin = objVouchers.getString("pin");
					VoucherPinHashMap.put(VoucherNumber,VoucherPin);				
					//String str_availableBal = objVouchers.getString("productCost");
					Double str_availableBal = objVouchers.getDouble("productCost");
						Double availableBal = str_availableBal ;
				//	Double availableBal = Double.parseDouble(str_availableBal);
					String sub_date=VoucherExpiry1.substring(0, 10);
					try {
					    Date date1 = new SimpleDateFormat("YYYY-MM-DD").parse(sub_date);
					    tmpVoucherExpiry = new SimpleDateFormat("dd-MM-yyyy").format(date1);
						
					}catch(Exception e)
					{
						e.printStackTrace();
					}
					
					System.out.println("VoucherNumber"+VoucherNumber);
					System.out.println("VoucherDesc"+VoucherDesc);
					System.out.println("VoucherType"+availableBal);
					System.out.println("tmpVoucherExpiry"+tmpVoucherExpiry);
					
					if(VoucherDesc.equalsIgnoreCase("Complimentary Room Night including breakfast for two persons.") || 
						VoucherDesc.equalsIgnoreCase("20% discount on Best Available Rates") ||	
						VoucherDesc.equalsIgnoreCase("20% Discount on Best Available Rate for Room/Suite Stay at Taj Palaces") ||
						VoucherDesc.equalsIgnoreCase("20% Discount on Best Available Rate for Room/Suite Stay at Taj Safaris") 
							) {
					
					JSONObject o = new JSONObject();
					o.put("MemberType", MemberType);
					o.put("VoucherNumber", VoucherNumber);
					o.put("Description", VoucherDesc);
					o.put("VoucherType", availableBal);
					//o.put("ExpirationDate", tmpVoucherExpiry);
					o.put("ExpirationDate", VoucherExpiry1);

						
					array.put(o);
					}
					
				
				
					
				}	

			}


		//used vouchers - start
			
			

			
	        //used vouchers - end
	
	
	} catch (Exception e2) {
		System.out.println("e2:: "+e2);
		// TODO: handle exception
	}
	
try {


	resp_= vouchersData.getExpiredVouchers(EPIMemberNumber, ReservationID,"Epicure");
	
	if(resp_.contains("There is no available Vouchers for the given"))
	{
		try {
			JSONObject jsonObject1 = new JSONObject();
			jsonObject1.put("CustomStatus", "ERROR");
			jsonObject1.put("MSG", "No Vouchers available for this member");
			response.getWriter().write(jsonObject1.toString());
			return;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
		JSONObject jsonObject1 = new JSONObject(resp_);
		

			JSONArray jsonArray1 = jsonObject1.getJSONArray("data");
		
			
			for(int i=0; i<jsonArray1.length(); i++)
			{
				JSONObject objVouchers = jsonArray1.getJSONObject(i);
				String status = objVouchers.getString("status");
				String VoucherType = objVouchers.getString("privilegeType");
				if(status.equals("AVAILABLE")) {
				if( (VoucherType.equals("Fixed-Product")) || VoucherType.equals("Fixed-Discount")) {
				
				String VoucherDesc = objVouchers.getString("PRODUCT_NAME");
				String VoucherExpiry = objVouchers.getString("VALID_TILL");
				VoucherExpiry = VoucherExpiry.replace("T", " ");
				
				String VoucherNumber = objVouchers.getString("PRIVILEGE_CODE");
			
				
				String MemberType = objVouchers.getString("offerTitle");
				String tmpVoucherExpiry = "";
				String VoucherPin = objVouchers.getString("pin");
				VoucherPinHashMap.put(VoucherNumber,VoucherPin);				
				//String str_availableBal = objVouchers.getString("productCost");
				Double str_availableBal = objVouchers.getDouble("productCost");
					Double availableBal = str_availableBal ;
			//	Double availableBal = Double.parseDouble(str_availableBal);
				String sub_date=VoucherExpiry.substring(0, 10);
				try {
				    Date date1 = new SimpleDateFormat("YYYY-MM-DD").parse(sub_date);
				    tmpVoucherExpiry = new SimpleDateFormat("dd-MM-yyyy").format(date1);
					
				}catch(Exception e)
				{
					e.printStackTrace();
				}
				
				System.out.println("VoucherNumber"+VoucherNumber);
				System.out.println("VoucherDesc"+VoucherDesc);
				System.out.println("VoucherType"+availableBal);
				System.out.println("tmpVoucherExpiry"+tmpVoucherExpiry);
				
				JSONObject o = new JSONObject();
				o.put("MemberType", MemberType);
				o.put("VoucherNumber", VoucherNumber);
				o.put("Description", VoucherDesc);
				o.put("VoucherType", availableBal);
				//o.put("ExpirationDate", tmpVoucherExpiry);
				o.put("ExpirationDate", VoucherExpiry);

					
				expiredVochersArray.put(o);

				
			}
			}//updated code used				

			}
	} catch (Exception e2) {
		// TODO: handle exception
	}			
//Expired Vouchers - end
	
		}

		System.out.println(array.toString());
		System.out.println(usedVochersArray.toString());
		
		JSONObject AllVochers = new JSONObject();
		try {
			AllVochers.put("UsedVochers", usedVochersArray);
			AllVochers.put("AvailableVochers", array);
			AllVochers.put("ExpiredVochers", expiredVochersArray);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(AllVochers.toString());
		response.getWriter().write(AllVochers.toString());
		//response.getWriter().write(array.toString());
		//response.getWriter().write(usedVochersArray.toString());
		 for(Map.Entry m : VoucherPinHashMap.entrySet()){    
			    System.out.println(m.getKey()+" and "+m.getValue());    
			   }
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
