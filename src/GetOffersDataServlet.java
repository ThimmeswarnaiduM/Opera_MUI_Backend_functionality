

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

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
import config.GetOffersData;
import config.GetProfileData;
import data.HashMapData;

@WebServlet("/GetOffersDataServlet")
public class GetOffersDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("started");
		JSONArray arrayReturn = new JSONArray();
		
		
		String ReservationID = request.getParameter("ReservId");
		
		GetProfileData getProfileData = HashMapData.mapProfileData.get(ReservationID);
		String MemberNumber = getProfileData.EnrollNumber_c;
		
		GetOffersData offersData = new GetOffersData();
	/*	String resp = offersData.getOffers(MemberNumber, ReservationID);
		
		if(resp.equalsIgnoreCase("error"))
		{
			try {
				JSONObject objReturn = new JSONObject();
				objReturn.put("CustomStatus", "ERROR");
				objReturn.put("MSG", "Error in retreiving offers \nPlease try again later");
				response.getWriter().write(objReturn.toString());
				return;
			} catch (JSONException e) {
				e.printStackTrace();
			}
		} else if(resp.contains("AAAAAAAAAAAAAA")) //when there is no offers available for the member
		{
			try {
				JSONObject objReturn = new JSONObject();
				objReturn.put("CustomStatus", "NOOFFERS");
				objReturn.put("MSG", "Error in retreiving offers \nPlease try again later");
				response.getWriter().write(objReturn.toString());
				return;
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		
		try
		{
		
			//JSONArray arrayReturn = new JSONArray();
			
			JSONObject objectOffer = new JSONObject(resp);
			JSONObject OfferJson1 = objectOffer.getJSONObject("IHCLMemberOfferQuery_Output");
			
			JSONArray OfferRes = OfferJson1.getJSONObject("ListOfIhclMemberOfferIo").getJSONArray("LoyMember").getJSONObject(0).getJSONObject("ListOfOffer").getJSONArray("Offer");
			
			for(int i=0; i<OfferRes.length(); i++)
			{
				JSONObject objReturn = new JSONObject();
				
				JSONObject OfferResponse = OfferRes.getJSONObject(i);
				String OfferName = OfferResponse.getString("OfferName");
				String OfferNumber = OfferResponse.getString("IHCLOfferNumber");
				String OfferEndDate = OfferResponse.getString("IHCLOfferEndDate");
				String RevenueAmount = OfferResponse.getString("RevenueAmount");
				String RevenueCode = OfferResponse.getString("RevenueCode");
				String RevenueType = OfferResponse.getString("RevenueType");
				
				objReturn.put("OfferName", OfferName);
				objReturn.put("OfferNumber", OfferNumber);
				objReturn.put("OfferEndDate", OfferEndDate);
				objReturn.put("RevenueAmount", RevenueAmount);
				objReturn.put("RevenueCode", RevenueCode);
				objReturn.put("RevenueType", RevenueType);
				
				arrayReturn.put(objReturn);
			}
			
		//	response.getWriter().write(arrayReturn.toString());
		//	return;
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	*/	try {

			
			//Get TCP vouchers - Start
			
		
			  GetMemberData tempMember = HashMapData.mapMemberData.get(ReservationID);
			  String custHaash = tempMember.redeemTCPCustomerHash; // String
		//	  custHaash = "672060e4c42939c2004cc00eefc65209";
			  System.out.println("custHaash : " + custHaash);

			  String Request= "{\r\n    \"fetchCustomerOffersByStatusRequest\": {\r\n        \"customerHash\": \"" +
				      custHaash + "\",\r\n        \"programId\": \"01eae2e1-ebcf-1bb0-956d-b0ebc692vhrs\",\r\n        \"status\": \"COLLECTED\",\r\n        \"isChannelsRequired\": true\r\n    }\r\n}";
			  OkHttpClient client = new OkHttpClient();
			  MediaType mediaType =
			    MediaType.parse("application/json");
			  RequestBody body =
					  RequestBody.create(mediaType,Request);
		//	    RequestBody.create(mediaType,
		//	      "{\r\n    \"fetchCustomerOffersByStatusRequest\": {\r\n        \"customerHash\": \"" +
		//	      custHaash + "\",\r\n        \"programId\": \"b098cfab-0bfd-4c0e-9a7d-4bee045evhrs\",\r\n        \"status\": \"ADDED_TO_VAULT\",\r\n        \"isChannelsRequired\": true\r\n    }\r\n}"
		//	    );
			  Request request_ = new Request.Builder()
			    .url(Configuration.fetchCustomerOffersByStatus).method("POST", body)
			    .addHeader("Program-Id", "01eae2e1-ebcf-1bb0-956d-b0ebc692vhrs")
			    .addHeader("Authorization", "Basic b2ljX3VzZXI6SW5ub3ZhY3hAMzIx")
			    .addHeader("Content-Type", "application/json").build();
			  Response response_ =
			    client.newCall(request_).execute();

			  JSONObject jsonObject_ = null;
			  JSONObject jsonObject02_ = null;
			  try {
			    jsonObject_ = new JSONObject(response_.body().string().toString());
			  } catch (JSONException e1) { // TODO Auto-generated catch block e1.printStackTrace();
			  } catch (IOException e1) { // TODO Auto-generated catch block
			    e1.printStackTrace();
			  }
			  System.out.println("Get Offers Request: "+Request);
			  System.out.println("Get Offers Response: "+jsonObject_);
			  
			  try{
					BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc +ReservationID+".txt",true));
					
					writer.write("\nGet TCP Offers Request:  \n" + Request + "\n\n");
					writer.write("\nGet TCP Offers Response:  \n" + jsonObject_ + "\n\n");
					writer.close();
					
				} catch(Exception e)
				{
					
				}
			  JSONArray jArray = null;
			  String offerId = "";
			  String programId = "";
			  try {
				  jArray =jsonObject_.getJSONObject("fetchCustomerOffersByStatusResponse").getJSONArray("offerDetails");
			  } catch (JSONException e2) { // TODO Auto-generated catch
			    
				try {
					BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + ReservationID+".txt",true));
					
					writer.write("\nexception :   \n" + e2.toString() + "\n\n");
					writer.write("\nexception :   \n" + e2 + "\n\n");
					writer.close();									  
				  
				} catch (Exception e) {
					// TODO: handle exception
				}  
			  } // JSONArray str_=str;

			
			  
			  String customerRedemptionsDetails = "", overallExpiry = "", promotionType = "";
			  JSONArray JSONArray_customerRedemptionsDetails = null;
			  try {
			    int lenght = 0;
			    try {
			      lenght = jArray.length();
			    } catch (Exception e) { // TODO: handle exception
			    }
			    System.out.println("lenght: "+lenght);
			    if (lenght > 0) {
			      for (int i = 0; i < lenght; i++) {
			    	  int userRedemptionLimitLeft=0;
			        offerId = jArray.getJSONObject(i).getString("offerId");		
			        
			        try{
						BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + ReservationID+".txt",true));
						
						writer.write("\nOffers list length lenght:  \n" + lenght + "\n\n");	
						writer.write("\nTCP offerId:  \n" + offerId + "\n\n");	
						writer.close();
						
					}
			        catch (Exception e) {
						// TODO: handle exception
					}
			        if(offerId.equals("01eae2e1-ebcf-1bb0-956d-b0ebc692vhrs:1-5U9Z-8") || offerId.equals("01eae2e1-ebcf-1bb0-956d-b0ebc692vhrs:1-CYYE9IK") || offerId.equals("01eae2e1-ebcf-1bb0-956d-b0ebc692vhrs:1-5U9Z-13") || offerId.equals("01eae2e1-ebcf-1bb0-956d-b0ebc692vhrs:1-CYYE9IK2")) {
			        	
			        programId= jArray.getJSONObject(i).getString("programId");
			        JSONArray_customerRedemptionsDetails = jArray.getJSONObject(i).getJSONArray("expiryDetails");
			       // JSONArray_customerRedemptionsDetails = new JSONArray(customerRedemptionsDetails);
			        overallExpiry = JSONArray_customerRedemptionsDetails.getJSONObject(0).getString("expiryDate");

			        //get voucher description - Start 
					
	/*				  String req =
					  "{\r\n    \"getOffersDescriptionDetailsRequest\": {\r\n        \"programId\": \""
					  + programId + "\",\r\n        \"offerIds\": [\r\n            \"" + offerId +
					  "\"\r\n        ]\r\n    }\r\n}"; OkHttpClient _client = new OkHttpClient();
					  MediaType _mediaType = MediaType.parse("application/json"); RequestBody _body
					  = RequestBody.create(_mediaType, req); Request _request = new
					  Request.Builder().url(Configuration.getRedemptionDetails) .method("POST",
					  _body).addHeader("Program-Id",
					  "01eac520-bc7a-1a10-8675-cf6516f1f134").addHeader("Authorization",
					  "Basic b2ljX3VzZXI6SW5ub3ZhY3hAMzIx").addHeader("Content-Type",
					  "application/json").build();
					   Response _response = _client.newCall(_request).execute();
					   JSONObject _jsonObject02 = null;
					  System.out.println("descp req body= " + req); try { _jsonObject02 = new
					  JSONObject(_response.body().string().toString()); } catch (JSONException e1)
					  { e1.printStackTrace(); }
					  
					  catch(IOException e1) { e1.printStackTrace(); } String _str = ""; String
					  promotionDescription = ""; JSONArray _jArray = null;
					  
					  try { _str =
					  _jsonObject02.getJSONObject("getOffersDescriptionDetailsResponse").getString(
					  "descriptionDetails"); _jArray = new JSONArray(_str); promotionDescription =
					  _jArray.getJSONObject(0).getString("offerDescription");
					  
					  // customerRedemptionsDetails=_jArray.getJSONObject(0).getString(
					  "descriptionDetails"); promotionType =
					  _jArray.getJSONObject(0).getString("offerType"); } catch (Exception e) { }
					 
			            // System.out.println("resp :"+_response.toString()); 
			             * 
			             */
			      //get voucher description - End
			        
			      //Offer details - Start
			        
			        String req1= "{\r\n    \"offerDetailsRequest\": {\r\n        \"programId\": \""+programId+"\",\r\n        \"customerHash\": \""+custHaash+"\",\r\n        \"offerId\": \""+offerId+"\"\r\n    }\r\n}";
			      
			        OkHttpClient client1 = new OkHttpClient();
			        		MediaType mediaType1 = MediaType.parse("application/json");
			        		RequestBody body1 = RequestBody.create(mediaType1, req1);
			        		Request request1 = new Request.Builder()
			        		  .url(Configuration.OfferDetails)
			        		  .method("POST", body1)
			        		  .addHeader("Authorization", Configuration.IcsBasicAuth)
			        		  .addHeader("Content-Type", "application/json")
			        		  .build();
			        		Response response1 = client1.newCall(request1).execute();
			        
			        		JSONObject _jsonObject02 = null;
							  
							  try { _jsonObject02 = new JSONObject(response1.body().string().toString());
							  } catch (JSONException e1)
							  { e1.printStackTrace(); }
							  
							  catch(IOException e1) { e1.printStackTrace(); }
							  
							  System.out.println("Offer Details req: " + req1);
							  System.out.println("Offer Details resp: " + _jsonObject02);
							 
							  String promotionDescription = "";
							  JSONArray _jArray = null;
							  
							  try { 
							  //_jsonObject02.getJSONObject("offerDetailsResponse").getString("offerDetailsList");
								  _jArray =_jsonObject02.getJSONObject("offerDetailsResponse").getJSONArray("offerDetailsList");
							   
							  promotionDescription = _jArray.getJSONObject(0).getString("description");
							  
							  // customerRedemptionsDetails=_jArray.getJSONObject(0).getString( "descriptionDetails");
						//	  promotionType = _jArray.getJSONObject(0).getString("offerType"); 
							  
							  JSONArray customerPromotionDetails_jsonArr = _jArray.getJSONObject(0).getJSONArray("customerPromotionDetails");
							  System.out.println("customerPromotionDetails: "+customerPromotionDetails_jsonArr);
							  
									
							  System.out.println("length: "+customerPromotionDetails_jsonArr.length());
							  for (int k = 0; k < customerPromotionDetails_jsonArr.length(); k++)
						        {
								  String collectedStatus = customerPromotionDetails_jsonArr.getJSONObject(k).getString("collectedStatus");
								  if (collectedStatus.equals("COLLECTED")) {									  
									  userRedemptionLimitLeft = userRedemptionLimitLeft + customerPromotionDetails_jsonArr.getJSONObject(k).getInt("userRedemptionLimitLeft");
								}							
								  
						        }
							  System.out.println("userRedemptionLimitLeft: "+userRedemptionLimitLeft);
							  try{
									BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + ReservationID+".txt",true));
									
									writer.write("\nuserRedemptionLimitLeft  \n" + userRedemptionLimitLeft + "\n\n");									
									writer.close();
									
								} catch(Exception e)
								{
									e.printStackTrace();
								}
							  
							  
							  } catch (Exception e) { 
								  e.printStackTrace();
								  BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + ReservationID+".txt",true));
									
									writer.write("\nexception :   \n" + e.toString() + "\n\n");
									writer.write("\nexception :   \n" + e + "\n\n");
									writer.close();
							  }
							 
					            // System.out.println("resp :"+_response.toString()); 
					         
				      //Offer details - End
			        
			        	  JSONObject o = new
			            JSONObject();
			            try {
							/*
							 * o.put("MemberType", "TCP"); o.put("VoucherNumber",offerId);
							 * o.put("Description", promotionDescription);
							 * o.put("VoucherType",promotionType); //o.put("ExpirationDate",
							 * tmpVoucherExpiry); o.put("ExpirationDate", overallExpiry);
							 */ 
			            	String short_offerId = offerId.substring((offerId.indexOf(":")+1), offerId.length());
			              JSONObject objReturn = new JSONObject();			              
							objReturn.put("OfferName", promotionDescription);
							objReturn.put("offerId", offerId);
							objReturn.put("short_offerId", short_offerId);
							objReturn.put("OfferEndDate", overallExpiry);
						//	objReturn.put("RevenueAmount", "RevenueAmount");
							objReturn.put("MembershipType", "TCP");
							objReturn.put("userRedemptionLimitLeft", userRedemptionLimitLeft);
							
							arrayReturn.put(objReturn);
							
							
							  try{
									BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + ReservationID+".txt",true));
									
									writer.write("\n OfferName  \n" + promotionDescription + "\n\n");
									writer.write("\n offerId  \n" + offerId + "\n\n");
									writer.write("\n short_offerId  \n" + short_offerId + "\n\n");
									writer.write("\n OfferEndDate  \n" + overallExpiry + "\n\n");									
									writer.write("\n userRedemptionLimitLeft  \n" + userRedemptionLimitLeft + "\n\n");
									writer.close();
									
								} catch(Exception e)
								{
									e.printStackTrace();
								}
							
							
							
			            } catch (Exception e1) { // TODO:
			              
			            }
			           // array.put(o);
			          }
			    } 

			          //end for loop 
			            } 
			        } catch (JSONException e2) {
			        	
			        	BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + ReservationID+".txt",true));
						
						writer.write("\nexception :   \n" + e2.toString() + "\n\n");
						writer.write("\nexception :   \n" + e2 + "\n\n");
						writer.close();
						

			        }			 
			//Get TCP vouchers - End

			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	System.out.println("resonce: "+arrayReturn.toString());
		response.getWriter().write(arrayReturn.toString());
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	
}
