
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import config.Configuration;
import config.GetHotelsData;
import config.GetMemberData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import config.ConfigPayloads;
import config.Configuration;
import config.GetProfileData;
import config.GetReservationData;
import config.SoapExecutor;
import config.URLConfig;
import data.HashMapData;
import data.NewInvoicesData;
import data.ProcessInvoicesData;
import data.StoreInvoiceDataMap;
import data.StoreInvoiceDetails;

@WebServlet("/GravtyAvailPrivilageServlet")
public class GravtyAvailPrivilageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpServletResponse servletResponse = null;

	JSONObject objectPoint = new JSONObject();
	JSONObject object = new JSONObject();
//	JSONObject objectVoucher = new JSONObject();
	static String VoucherNumber = null;
	static String CardNumber = null;
	static String Memtype = null;
	static String GlobalReservationNumber = null;
	static String GlobalPropertyCode = null;
	static String confirmationNo = null;
	static String Type = null;
	static String OTP = "";
	static String privilegeType = "";
	String WriteToPmsStatus_ = "";
	String BillAmount;
	double availableBal;
	ProcessInvoicesData processInvoicesData = null;
	
	protected void getData(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("--------------------GravtyAvailPrivilageServlet----------------------");
		servletResponse = response;
		GlobalReservationNumber = request.getParameter("GlobalReservationNumber");
		ProcessInvoicesData processInvoicesData = HashMapData.mapProcessInvoices.get(GlobalReservationNumber);

		GetReservationData reservationData = HashMapData.mapReservationData.get(GlobalReservationNumber);

		NewInvoicesData newInvoicesData = HashMapData.mapNewInvoices.get(GlobalReservationNumber);
		BillAmount = Double.toString(newInvoicesData.CurrentBalance);
		System.out.println(BillAmount);
		processInvoicesData.TotalAmount = BillAmount;	
		
		
		HashMapData.mapProcessInvoices.put(processInvoicesData.URLReservationNumber, processInvoicesData);
		processInvoicesData = HashMapData.mapProcessInvoices.get(processInvoicesData.URLReservationNumber);
		
		try {
			processInvoicesData.InvoiceCount = processInvoicesData.arrRequest.length();	
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {

			System.out.println("Gravty Card Swipe");
			// String swipedFor = request.getParameter("SwipedFor");
			// String GlobalReservationNumber = null;
			// String GlobalReservationNumber =
			// request.getParameter("GlobalReservationNumber");
			// String VoucherNumber = request.getParameter("VoucherNumber");
			VoucherNumber = request.getParameter("VoucherCode");
			System.out.println("VoucherNumber : " + VoucherNumber);
			CardNumber = request.getParameter("CardNumber");
			System.out.println("CardNumber : " + CardNumber);

			Memtype = request.getParameter("Memtype");
			System.out.println("Memtype : " + Memtype);

			System.out.println("GlobalReservationNumber : " + GlobalReservationNumber);

			GlobalPropertyCode = request.getParameter("GlobalPropertyCode");
			System.out.println("GlobalPropertyCode : " + GlobalPropertyCode);

			confirmationNo = request.getParameter("confirmationNo");
			System.out.println("confirmationNo: " + confirmationNo);

			Type = request.getParameter("Type");
			System.out.println("Type: " + Type);
			GetProfileData y = new GetProfileData(null, null, null,null,null);
			/*
			 * for(Map.Entry m : x.VoucherPinHashMap.entrySet()){
			 * System.out.println(m.getKey()+" and "+m.getValue()); }
			 */
			Memtype = request.getParameter("Memtype");
			if (Memtype.equals("TCP")) {
				System.out.println("TCP");
				System.out.println("VoucherNumber: " + VoucherNumber);
				GetMemberData tempMember = HashMapData.mapMemberData.get(GlobalReservationNumber);
				String custHaash = tempMember.redeemTCPCustomerHash;
				// String custHaash="672060e4c42939c2004cc00eefc65209";

				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();
				String t = dtf.format(now);
				System.out.println("date : " + t);

				try {
					String req = "{\r\n    \"redeemOffersRequest\": {\r\n        \"customerHash\": \"" + custHaash
							+ "\",\r\n        \"transactionId\": \"" + GlobalReservationNumber
							+ "\",\r\n        \"offersToBeRedeemed\": [\r\n            {\r\n                \"offerId\": \""
							+ VoucherNumber
							+ "\",\r\n                \"numberOfTimesOfferApplied\": 1,\r\n                \"savings\": 0.2,\r\n                \"customerActivatedPromotion\": false\r\n            }\r\n        ],\r\n        \"redeemDateTime\": \""
							+ t + "\"\r\n    }\r\n}";
					OkHttpClient client = new OkHttpClient();
					MediaType mediaType = MediaType.parse("application/json");
					RequestBody body = RequestBody.create(mediaType, req);
					Request request2 = new Request.Builder().url(Configuration.redeem)//change link to prod							
							.method("POST", body).addHeader("Program-Id", "01eae2e1-ebcf-1bb0-956d-b0ebc692vhrs")
							.addHeader("Authorization", "Basic b2ljX3VzZXI6SW5ub3ZhY3hAMzIx")
							.addHeader("Content-Type", "application/json").build();
					Response response2 = client.newCall(request2).execute();

					String resp2 = response2.body().string().toString();
					System.out.println("TCP Avail Voucher req: " + req);
					System.out.println("TCP Avail Voucher resp: " + resp2);

					JSONObject jsonObject = new JSONObject(resp2);
					JSONObject response_jsonarr = (JSONObject) jsonObject.get("redeemOffersResponse");
					String operationStatusCode = response_jsonarr.getString("operationStatusCode");

					if (operationStatusCode.equals("200")) {

						this.object.put("status", "SUCCESS");
						this.object.put("msg", "Successfully Availed");
						this.object.put("url", "NewInvoices.jsp?ReservId=" + GlobalReservationNumber
								+ "&PayStatus=success&Property=" + GlobalPropertyCode + "");
						// Success url
						// servletResponse.getWriter().write("NewInvoices.jsp?ReservId="+GlobalReservationNumber+"&PayStatus=success&Property="+GlobalPropertyCode+"");
					} else {

						this.object.put("status", "Availment Failed");
						this.object.put("msg", "Availment Failed");

					}
				} finally {

				}

				response.getWriter().write(this.object.toString());
			} else {
				
				processInvoicesData.rq = request.getParameter("InvoiceNo");
				try {
					processInvoicesData.arrRequest = new JSONArray(processInvoicesData.rq);
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				// Fixed- product and Fixed-Discount check - Start
				Object obj_privilegeType = "", obj_value = "", title_obj = "", status_obj = "";
			 	String ApprovalCode = "";
				try {
					String req= "{\r\n      \"Privilege_Id\": \"" + VoucherNumber
							+ "\",\r\n    \"MemberType\": \"" + Memtype + "\"\r\n}";
					OkHttpClient client = new OkHttpClient();
					MediaType mediaType = MediaType.parse("application/json");
					RequestBody body = RequestBody.create(mediaType, req);
					Request CheckBalrequest = new Request.Builder().url(Configuration.GET_ALL_PRIVILEGES)
							.method("POST", body).addHeader("Authorization", "Basic T2ljX3VzZXI6SW5ub3ZhY3hAMzIx")  //T2ljX3VzZXI6SW5ub3ZhY3hAMzIx b2ljX3VzZXI6SW5ub3ZhY3hAMzIx
							.addHeader("Content-Type", "application/json").build();
					Response CheckBalresponse = client.newCall(CheckBalrequest).execute();
					String resp = CheckBalresponse.body().string().toString();
					// System.out.println("AvailResponse: "+resp);
						System.out.println("get privilage req: "+req);
						System.out.println("get privilage resp: "+resp);
//						JSONArray jsonArray = new JSONArray(resp);
//						JSONObject jsonObject = jsonArray.getJSONObject(0);
					    JSONObject jsonObject = new JSONObject(resp);
					JSONArray response_jsonarr = jsonObject.getJSONArray("data");
					JSONObject data_obj = response_jsonarr.getJSONObject(0);
					obj_privilegeType = data_obj.get("privilegeType");
					privilegeType = obj_privilegeType.toString();
					System.out.println("privilegeType: " + privilegeType);
					
						JSONObject Json_value = response_jsonarr.getJSONObject(0);
						obj_value = Json_value.get("productCost");
						availableBal=(double) obj_value;
						System.out.println("availableBal: "+availableBal);
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}

//				Fixed- product and Fixed-Discount check - End
				String CHMemberNumber = y.GravtyMemberNumber.get("CHMemberNumber");
				String EPIMemberNumber = y.GravtyMemberNumber.get("EPIMemberNumber");
				System.out.println("CHMemberNumber from hashmap: " + CHMemberNumber);
				System.out.println("EPIMemberNumber from hashmap: " + EPIMemberNumber);
				String MemberNumber = null;
				if (Memtype.equals("Epicure")) {
					MemberNumber = EPIMemberNumber;
//				req="{\r\n    \"h_bit_date\": \"2021-08-27T17:15+05:30\",\r\n    \"h_bit_category\": \"AVAILMENT\",\r\n    \"h_member_id\": \""+MemberNumber+"\",\r\n    \"sponsor_code\": \""+Memtype+"\",\r\n    \"h_privileges_with_pin\": [\r\n        {\r\n            \"h_privilege\": \""+VoucherNumber+"\",\r\n            \"pin\": \""+PIN+"\"\r\n        }\r\n    ],\r\n    \"OTP\": \""+OTP+"\"\r\n}";

				} else if (Memtype.equals("Chambers")) {
					MemberNumber = CHMemberNumber;
				}

				// String CHMemberNumber = getProfileData.CHMemberNumber;
				// String EPIMemberNumber = getProfileData.EPIMemberNumber;

				// get reservation details CMD - Start
				OkHttpClient client_ = new OkHttpClient();
				Request request_ = new Request.Builder()
						.url(Configuration.CDM_URL + "/crmCommonApi/resources/latest/Reservation_c?q=REGISTER_c="
								+ confirmationNo + "")
						.method("GET", null)
						.addHeader("Authorization", "Basic ZGF0YWNlbnRyZTpTbWlsZUAyNQ==")
						.addHeader("Content-Type", "application/json").build();
				Response response_ = client_.newCall(request_).execute();
				String resp_ = response_.body().string().toString();
				System.out.println("resv resp: " + resp_);	
				//fixing code
				JSONObject response_json_obj = new JSONObject(resp_);
				
				int count = response_json_obj.getInt("count");
				Object Rate_Code = "";
				Object CHECKINDATE = "";
				Object CHECKOUTDATE = "";
				Object BOOKINGDATE = "";
				
				if(count == 0) {
					Configuration configuration = new Configuration();
					//Reservation_Status = "";
					configuration.hotelList();
					String hotelSet = Configuration.hotelList.get(GlobalPropertyCode);
					if(hotelSet.equals("Central")||hotelSet.equals("Oracle Cloud Central")) {
						GetReservationData obj = new GetReservationData();
						Rate_Code = obj.RateCode;
						System.out.println("Rate_Code: " + Rate_Code);
						//CHECKINDATE = reservationData.ArrivalDate;
						//CHECKOUTDATE = reservationData.DepartureDate;
						//BOOKINGDATE = GetReservationData.BOOKINGDATE;
					/*	SimpleDateFormat parseFormat = new SimpleDateFormat("MM-dd-yyyy");
						Date date = parseFormat.parse(reservationData.DepartureDate);
						SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
						String formattedCheckoutDate = format.format(date);
					    CHECKOUTDATE = formattedCheckoutDate;*/
						SimpleDateFormat parseFormat = new SimpleDateFormat("dd-MM-yyyy");
						Date checkoutdate = parseFormat.parse(reservationData.DepartureDate);
						Date checkindate = parseFormat.parse(reservationData.ArrivalDate);
						Date checkbookingdate = parseFormat.parse(GetReservationData.BOOKINGDATE);
						SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
						String formattedCheckoutDate = format.format(checkoutdate);
						String formattedCheckinDate = format.format(checkindate);
						String formattedBookingDate = format.format(checkbookingdate);
					    CHECKOUTDATE = formattedCheckoutDate;
					    CHECKINDATE = formattedCheckinDate;
					    BOOKINGDATE = formattedBookingDate;
						
						
					}
					
					
					
				}else {
					JSONArray response_jsonarr_ = response_json_obj.getJSONArray("items");
					JSONObject item_obj_ = response_jsonarr_.getJSONObject(0);
					GetReservationData obj = new GetReservationData();
					Rate_Code = obj.RateCode;
					System.out.println("Rate_Code: " + Rate_Code);
					
					CHECKINDATE = item_obj_.get("ANREISE_CHECKINDATE_c");
					CHECKOUTDATE = item_obj_.get("ABREISE_CHECKOUTDATE_c");
					BOOKINGDATE = item_obj_.get("AM_BOOKINGDATE_c");
				}
				
				
				//found the bug.
				
				
				
				/*
				 * String s=GetHotelsData.getHotel(GlobalPropertyCode);
				 * 
				 * String GlobalOrionCode = HashMapData.mapOrionCode.get(GlobalPropertyCode);
				 */
				JSONObject jsonObject_ = new JSONObject(resp_);

				// JSONObject object = jsonObject.getJSONObject("status");
				try {
					// status = jsonObject.getString("status");
					// System.out.println("status: "+status);
				} catch (Exception e) {
					// errorDetails = jsonObject.getString("o:errorDetails");
				}
				// get reservation details CMD - End

				//
				GetVouchersDataServlet x = new GetVouchersDataServlet();
				/*
				 * for(Map.Entry m : x.VoucherPinHashMap.entrySet()){
				 * System.out.println(m.getKey()+" and "+m.getValue()); }
				 */
				String PIN = x.VoucherPinHashMap.get(VoucherNumber.toString());
				System.out.println("Pin : " + PIN);
				// objectVoucher.put("status", "ERROR");
				// objectVoucher.put("statusMsg", "Swiped card Sucessfully<br/><br/>Thank you");
				// response.getWriter().write(objectVoucher.toString());
				OkHttpClient client = new OkHttpClient();
				MediaType mediaType = MediaType.parse("application/json");
				RequestBody body = null;
				String req = "";
				String status = "";
				if (Type.equals("CARD") || Type.equals("OTP") || Type.equals("PIN")) {
					// current date Start
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu-MM-ddHH:mm:ss");
					LocalDateTime now = LocalDateTime.now();
					String t = dtf.format(now);
					System.out.println(t);
					String date_ = t.substring(0, 10) + "T" + t.substring(10, t.length() - 3) + "-05:30";//change current date -05:30 --
					System.out.println(date_);
					// current date End
					if (Type.equals("CARD")) {
						System.out.println("Card swipe block");
						// Avail privilage rest api code

						req = "{\r\n    \"h_bit_date\": \"" + date_ + "\",\r\n    \"hotel_pms_code\": \""
								+ GlobalPropertyCode + "\",\r\n    \"rate_code\": \"" + Rate_Code
								+ "\",\r\n    \"h_start_date\": \"" + CHECKINDATE + "\",\r\n    \"h_end_date\": \""
								+ CHECKOUTDATE + "\",\r\n    \"h_date_of_booking\": \"" + BOOKINGDATE
								+ "\",\r\n    \"h_bit_source_generated_id\": \"" + confirmationNo
								+ "\",\r\n    \"h_bit_source\": \"PMS\",\r\n    \"h_bit_category\": \"AVAILMENT\",\r\n    \"MemberType\": \""
								+ Memtype + "\",\r\n    \"bill_number\":\"" + confirmationNo
								+ "\",\r\n    \"h_privileges_with_pin\": [\r\n        {\r\n            \"h_privilege\": \""
								+ VoucherNumber + "\",\r\n            \"pin\": \"" + PIN
								+ "\"\r\n        }\r\n    ],\r\n    \"CardString\": \"" + CardNumber + "\"\r\n}";
						body = RequestBody.create(mediaType, req);
						System.out.println("CardNumber: " + CardNumber);
					} else if (Type.equals("OTP")) {
						System.out.println("OTP block");
						OTP = request.getParameter("OTP");
						req = "{\r\n    \"h_bit_date\": \"" + date_ + "\",\r\n    \"hotel_pms_code\": \""
								+ GlobalPropertyCode + "\",\r\n    \"rate_code\": \"" + Rate_Code
								+ "\",\r\n    \"h_start_date\": \"" + CHECKINDATE + "\",\r\n    \"h_end_date\": \""
								+ CHECKOUTDATE + "\",\r\n    \"h_date_of_booking\": \"" + BOOKINGDATE
								+ "\",\r\n    \"h_bit_source_generated_id\": \"" + confirmationNo
								+ "\",\r\n    \"h_bit_source\": \"PMS\",\r\n    \"h_bit_category\": \"AVAILMENT\",\r\n    \"h_member_id\": \""
								+ MemberNumber + "\",\r\n    \"MemberType\": \"" + Memtype
								+ "\",\r\n    \"bill_number\":\"" + confirmationNo
								+ "\",\r\n    \"h_privileges_with_pin\": [\r\n        {\r\n            \"h_privilege\": \""
								+ VoucherNumber + "\",\r\n            \"pin\": \"" + PIN
								+ "\"\r\n        }\r\n    ],\r\n    \"OTP\": \"" + OTP + "\"\r\n}";

						body = RequestBody.create(mediaType, req);

					}

					else if (Type.equals("PIN")) {
						System.out.println("PIN block");
						String InputPin = request.getParameter("InputPin");
						req = "{\r\n    \"h_bit_date\": \"" + date_ + "\",\r\n    \"h_member_id\": \"" + MemberNumber
								+ "\",\r\n    \"hotel_pms_code\": \"" + GlobalPropertyCode
								+ "\",\r\n    \"rate_code\": \"" + Rate_Code + "\",\r\n    \"h_start_date\": \""
								+ CHECKINDATE + "\",\r\n    \"h_end_date\": \"" + CHECKOUTDATE
								+ "\",\r\n    \"h_date_of_booking\": \"" + BOOKINGDATE
								+ "\",\r\n    \"h_bit_source_generated_id\": \"" + confirmationNo
								+ "\",\r\n    \"h_bit_source\": \"PMS\",\r\n    \"h_bit_category\": \"AVAILMENT\",\r\n    \"MemberType\": \""
								+ Memtype + "\",\r\n    \"bill_number\":\"" + confirmationNo
								+ "\",\r\n    \"h_privileges_with_pin\": [\r\n        {\r\n            \"h_privilege\": \""
								+ VoucherNumber + "\",\r\n            \"pin\": \"" + InputPin
								+ "\"\r\n        }\r\n    ]\r\n}";
						body = RequestBody.create(mediaType, req);

					}
					// PIN end
					
					Request AvailRequest = new Request.Builder().url(Configuration.AVAIL_PRIVILEGE).method("POST", body)
							.addHeader("Authorization", "Basic "
									+ "T2ljX3VzZXI6SW5ub3ZhY3hAMzIx")
							.addHeader("Content-Type", "application/json").build();
					Response AvailResponse = client.newCall(AvailRequest).execute();
					String resp = AvailResponse.body().string().toString();

					System.out.println("AvailRequest: " + req.toString());
					System.out.println("AvailResponse: " + resp);
					
					try{
						BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + GlobalReservationNumber+".txt",true));
						
						writer.write("\nAvailRequest:  \n" + req.toString() + "\n\n");
						writer.write("\nAvailResponse:  \n" + resp + "\n\n");
						
						writer.write("\nprivilegeType:  \n" + privilegeType+ "\n\n");						
						writer.close();
						
					} catch(Exception e)
					{
						e.printStackTrace();
					}
				 try{
					  BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.redemptionLog + GlobalReservationNumber+"_GravtyAvailPrivilage_"+VoucherNumber+".txt",true));
					    writer.write((new Date()).toString());
					    writer.write("\nprivilegeType:  \n" + privilegeType+ "\n\n");
						writer.write("\nGrvaty Avail Request:  \n" + req.toString() + "\n\n");
						writer.write("\nGrvaty Avail Response:  \n" + resp + "\n\n");																		
						writer.close();
						
					} catch(Exception e)
					{
						e.printStackTrace();
					}

					JSONObject jsonObject = new JSONObject(resp);

					//JSONObject object = jsonObject.getJSONObject("status");
					String detail = "";
					String errorDetails = "";
					String title = "";
					Object item_id = "";
					String Error = "";
					try {
						status = jsonObject.getString("status");
						System.out.println("status: " + status);
						ApprovalCode = jsonObject.getString("bit_id");
						
						//adding additional try block to run local
						try {
							BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.giftCardLogLoc + request.getParameter("GlobalReservationNumber")+".txt",true));

							writer.write("\n\nAvailment Status:\n " + status + "\n");
							
							writer.close();
						}catch (Exception e) {
								e.printStackTrace();
													
						}
							
					} catch (Exception e) {
						// errorDetails = jsonObject.getString("o:errorDetails");
						try {

							JSONArray response_jsonarr = jsonObject.getJSONArray("o:errorDetails");
							JSONObject item_obj = response_jsonarr.getJSONObject(0);
							if (Type.equals("PIN")) {
								item_id = item_obj.get("title");
							}

							Error = item_obj.toString();
							// title =errorDetails.substring("title");
							int Start = Error.indexOf("message");
							Error = Error.substring(Start);
							System.out.println(Error);
							int End = Error.indexOf("\",");
							Error = Error.substring(12, End - 1);
							System.out.println("=================================");
							System.out.println(Error);

						} catch (Exception e2) {
							// TODO: handle exception
						}

						detail = jsonObject.get("detail")
								.toString();/*
											 * JSONObject obj_detail = arr_detail.getJSONObject(0); detail =
											 * obj_detail.toString();
											 */
						// JSONObject detail_obj = response_jsonarr.getJSONObject(0);
						/*
						 * if(item_id.equals("Voucher PIN is Invalid")) {
						 * System.out.println("item_id: "+item_id); this.object.put("status",
						 * "Voucher PIN is Invalid"); }
						 */

						// System.out.println("item_id: "+item_id);
						// Failed url
						// this.object.put("status", "ERROR");
						// servletResponse.getWriter().write("NewInvoices.jsp?ReservId="+GlobalReservationNumber+"&PayStatus=availmentFailed&Property="+GlobalPropertyCode+"");
						// TODO: handle exception
					}

					this.object.put("status", "");
					this.object.put("msg", "");
					this.object.put("url", "");

					System.out.println(status);
			//		status = "SUCCESS";////dont uncomment 
					String Reservation_Status=	GetReservationData.Reservation_status;
					if (status.equals("SUCCESS")) {
						if (   (privilegeType.equals("Fixed-Product") || privilegeType.equals("Fixed-Discount")  ) &&  Reservation_Status.equalsIgnoreCase("CHECKED IN")) {
					//		writeToPMS(request, response, "12345", "voucher number",GlobalReservationNumber, GlobalPropertyCode);

							writeToPMS(request, response,ApprovalCode,VoucherNumber,GlobalReservationNumber, GlobalPropertyCode,"_GravtyAvailPrivilage_"+VoucherNumber);

							if (WriteToPmsStatus_.equals("WriteToPmsFailed")) {
								this.object.put("status", "SUCCESS");
								this.object.put("msg", "Voucher availed sucessfully, posting to PMS failed.");
							} else {
								this.object.put("status", "SUCCESS");
								this.object.put("msg", "Successfully Availed and "+availableBal+" Deducted Sucessfully");

							}
						}
						else if (!Reservation_Status.equalsIgnoreCase("CHECKED IN")){
							this.object.put("status", "SUCCESS");
							this.object.put("msg", "Successfully Availed, But Not Written Back to PMS");
							this.object.put("url", "NewInvoices.jsp?ReservId=" + GlobalReservationNumber+ "&PayStatus=successButNotWrittenBacktoPMS&Property=" + GlobalPropertyCode + "");
						
						}
						else {
							this.object.put("status", "SUCCESS");
							this.object.put("msg", "Successfully Availed");

						}
						

						this.object.put("url", "NewInvoices.jsp?ReservId=" + GlobalReservationNumber
								+ "&PayStatus=success&Property=" + GlobalPropertyCode + "");
						// Success url
						// servletResponse.getWriter().write("NewInvoices.jsp?ReservId="+GlobalReservationNumber+"&PayStatus=success&Property="+GlobalPropertyCode+"");

					} else if (detail.equals("Card not found, Please check the card and try again.")) {
						this.object.put("status", "Availment Failed");
						this.object.put("msg", detail);

					} else if (detail
							.equals("No such program exists, Please check the MemberType / Member_Id and try again")) {
						this.object.put("status", "Availment Failed");
						this.object.put("msg", detail);

					} else {
						System.out.println("Availment Failed");
						this.object.put("status", "Availment Failed");

						if (Type.equals("CARD")) {
							System.out.println("");
							this.object.put("msg", "Invalid card details, Please Swipe card again");
						} else if (Type.equals("OTP") && OTP.equals("")) {
							System.out.println("");
							this.object.put("msg", "Please Enter OTP");
						} else if (detail.equals("The OTP entered is invalid")
								|| Error.equals("The OTP entered is invalid")) {
							this.object.put("msg", "The OTP entered is invalid");
						} else if (Error.equals("Invalid pin for privilege")) {
							this.object.put("msg", "Voucher PIN is Invalid");

						} else
							this.object.put("msg", "Availment Failed");

						// Failed url
						// servletResponse.getWriter().write("NewInvoices.jsp?ReservId="+GlobalReservationNumber+"&PayStatus=availmentFailed&Property="+GlobalPropertyCode+"");

					}
					response.getWriter().write(this.object.toString());

				}
				status = "";

			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String a[]) {

		System.out.println("Gravty avail voucher servlet");

		// String CardData = "%101014774663^TEST CARD
		// ^^1-12194965982?;101014774663=?+101014774663==?";

		// GravtyAvailPrivilageServlet servlet = new CardSwipeServlet();
		// GravtyAvailPrivilageServlet servlet = new GravtyAvailPrivilageServlet();
		// System.out.println(servlet.readCardNumber_(CardData));
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// process invoices - Start
		System.out.println("Gravty avail voucher servlet - doGet");
		
		servletResponse = response;

		try {
			GlobalReservationNumber = request.getParameter("GlobalReservationNumber");
			
			processInvoicesData = HashMapData.mapProcessInvoices.get(GlobalReservationNumber);
			
			processInvoicesData.URLReservationNumber = GlobalReservationNumber;
			
			HashMapData.mapProcessInvoices.put(GlobalReservationNumber, processInvoicesData);
			processInvoicesData = HashMapData.mapProcessInvoices.get(GlobalReservationNumber);
			
			//NewInvoicesData newInvoicesData = HashMapData.mapNewInvoices.get(GlobalReservationNumber);
			
			GlobalPropertyCode = processInvoicesData.URLPropertyCode;
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
		String PaymentType = request.getParameter("PaymentType");
		processInvoicesData.rq = request.getParameter("InvoiceNo");
		
		
		
		
		System.out.println("InvoiceNo: \t" + processInvoicesData.rq);
		System.out.println("Payment type: \t" + PaymentType);
		System.out.println("Point type: \t" + processInvoicesData.ConversionType);
		System.out.println("TotalAmount: \t" + processInvoicesData.TotalAmount);
		System.out.println("TotalPoints: \t" + processInvoicesData.TotalPoints);
		System.out.println("GiftCardNumber: \t" + processInvoicesData.GiftCardNumber);
		System.out.println("GiftCardPin: \t" + processInvoicesData.GiftCardPin);
		System.out.println("GiftCardTrackData: \t" + processInvoicesData.GiftCardTrackData);
		System.out.println("PaymentCardType: \t" + processInvoicesData.PaymentCardType);
		
		try{
			GetReservationData getReservationData = HashMapData.mapReservationData.get(GlobalReservationNumber);
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + request.getParameter("GlobalReservationNumber")+".txt",true));
			
			writer.write("PaymentRequested_Conf_" + getReservationData.ConfirmationNo + "\n");
			writer.write("PaymentRequested_Resv_" + GlobalReservationNumber + "\n");
			writer.write("PaymentRequested_Property_" + GlobalPropertyCode + "\n");
			writer.write("\nInvoiceNo: \t" + processInvoicesData.rq + "\n");
			writer.write("Payment type: \t" + PaymentType + "\n");
			writer.write("Point type: \t" + processInvoicesData.ConversionType + "\n");
			writer.write("TotalAmount: \t" + processInvoicesData.TotalAmount + "\n");
			writer.write("TotalPoints: \t" + processInvoicesData.TotalPoints + "\n");
			writer.write("GiftCardNumber: \t" + processInvoicesData.GiftCardNumber + "\n");
			writer.write("GiftCardPin: \t" + processInvoicesData.GiftCardPin + "\n");
			writer.write("GiftCardTrackData: \t" + processInvoicesData.GiftCardTrackData + "\n");
			writer.write("PaymentCardType: \t" + processInvoicesData.PaymentCardType + "\n");
			
			writer.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		try {
			
			processInvoicesData.arrRequest = new JSONArray(processInvoicesData.rq);
			
			HashMapData.mapProcessInvoices.put(processInvoicesData.URLReservationNumber, processInvoicesData);
			processInvoicesData = HashMapData.mapProcessInvoices.get(processInvoicesData.URLReservationNumber);
			
			processInvoicesData.InvoiceCount = processInvoicesData.arrRequest.length();
		    if(processInvoicesData.InvoiceCount == 0  && GetReservationData.Reservation_status.equalsIgnoreCase("CHECKED IN"))
				return;
			
			processInvoicesData.strWindowNo = new String[processInvoicesData.InvoiceCount];
			processInvoicesData.strName = new String[processInvoicesData.InvoiceCount];			
			processInvoicesData.strAmount = new String[processInvoicesData.InvoiceCount];
			processInvoicesData.strOrigCurrencyAmount = new String[processInvoicesData.InvoiceCount];
			
			HashMapData.mapProcessInvoices.put(processInvoicesData.URLReservationNumber, processInvoicesData);
			processInvoicesData = HashMapData.mapProcessInvoices.get(processInvoicesData.URLReservationNumber);
			
			for(int i=0; i<processInvoicesData.arrRequest.length(); i++)
			{
				String Invoice = processInvoicesData.arrRequest.getString(i);
				
				/*StoreInvoiceDetails storeInvoiceDetails = HashMapData.mapInvoices.get(processInvoicesData.URLReservationNumber);
				
				storeInvoiceDetails.mapInvoice.get(Invoice);
				StoreInvoiceDetails invoiceDetails = storeInvoiceDetails.mapInvoice.get(Invoice);*/
				
				StoreInvoiceDataMap storeInvoiceDataMap = HashMapData.mapInvoices.get(request.getParameter("GlobalReservationNumber"));
				
				HashMap<String, StoreInvoiceDetails> storeInvoiceDetailsMap = storeInvoiceDataMap.getstoreInvoices();
				
				StoreInvoiceDetails invoiceDetails = storeInvoiceDetailsMap.get(Invoice);
				
				processInvoicesData.strWindowNo[i] = invoiceDetails.WindowNo;
				processInvoicesData.strName[i] = invoiceDetails.Name;
				processInvoicesData.strAmount[i] = Double.toString(invoiceDetails.Amount);
				processInvoicesData.strOrigCurrencyAmount[i] = Double.toString(invoiceDetails.OriginalCurrencyTotalAmount);
				
				HashMapData.mapProcessInvoices.put(processInvoicesData.URLReservationNumber, processInvoicesData);
				processInvoicesData = HashMapData.mapProcessInvoices.get(processInvoicesData.URLReservationNumber);
				
			}
			
			
			StoreInvoiceDetails storeInvoiceDetails = HashMapData.mapInvoiceData.get(processInvoicesData.URLReservationNumber);
			GetReservationData getReservationData = HashMapData.mapReservationData.get(processInvoicesData.URLReservationNumber);
			
			processInvoicesData.TransactionComments = getReservationData.ConfirmationNo;
			processInvoicesData.RegisterNumber = getReservationData.ConfirmationNo;
			processInvoicesData.ConfirmationNo = getReservationData.ConfirmationNo;
			processInvoicesData.RoomNumber = getReservationData.RoomNo;
			processInvoicesData.BookingSource = "Web Booking";
			processInvoicesData.TransactionChannel = "Middleware UI";
			processInvoicesData.BillDate = storeInvoiceDetails.BillDate;
			
			HashMapData.mapProcessInvoices.put(processInvoicesData.URLReservationNumber, processInvoicesData);
			processInvoicesData = HashMapData.mapProcessInvoices.get(processInvoicesData.URLReservationNumber);
			
			//SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat dateFormat1 = new SimpleDateFormat("MM/dd/yyyy");
			
			
			
			String tempCheckInDate = "";
			String tempCheckOutDate = "";
			
			try{
				DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				Date dIn = format.parse(getReservationData.CheckInDate.substring(0, 10));
				Date dOut = format.parse(getReservationData.CheckOutDate.substring(0, 10));
				
				tempCheckInDate = dateFormat1.format(dIn);
				tempCheckOutDate = dateFormat1.format(dOut);
			}catch(Exception e)
			{}
				
			
			//String tempCheckOutDate = dateFormat1.format(new Date()); 
			
			try {
			
				processInvoicesData.CheckInDate = tempCheckInDate;
				processInvoicesData.CheckOutDate = tempCheckOutDate;
				
				HashMapData.mapProcessInvoices.put(processInvoicesData.URLReservationNumber, processInvoicesData);
				processInvoicesData = HashMapData.mapProcessInvoices.get(processInvoicesData.URLReservationNumber);
			
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			
			
			
		} catch (JSONException e) {
		
			e.printStackTrace();
		}
		
		
		//Global Variables
		try {

			GetProfileData getProfileData = HashMapData.mapProfileData.get(processInvoicesData.URLReservationNumber);
			
			processInvoicesData.FirstName = getProfileData.FirstName;
			processInvoicesData.LastName = getProfileData.LastName;
			processInvoicesData.Salutation = getProfileData.Salutation;
			processInvoicesData.Gender = getProfileData.Gender;
			processInvoicesData.Email = getProfileData.Email;
			processInvoicesData.Phone = getProfileData.Phone;
			processInvoicesData.PartyId = getProfileData.PartyId;
			processInvoicesData.PartyNumber = getProfileData.PartyNumber;
			processInvoicesData.MembershipType = getProfileData.MembershipType;
			processInvoicesData.EnrollNumber_c = getProfileData.EnrollNumber_c;
			processInvoicesData.DateOfBirth = getProfileData.DateOfBirth;
			processInvoicesData.Address1 = getProfileData.Address1;
			processInvoicesData.Address2 = getProfileData.Address2;
			processInvoicesData.Address3 = getProfileData.Address3;
			processInvoicesData.Address4 = getProfileData.Address4;
			processInvoicesData.city = getProfileData.city;
			processInvoicesData.state = getProfileData.state;
			processInvoicesData.country = getProfileData.country;
			processInvoicesData.postal = getProfileData.postal;
			
			processInvoicesData.MemberNumber = getProfileData.EnrollNumber_c;
			
			HashMapData.mapProcessInvoices.put(processInvoicesData.URLReservationNumber, processInvoicesData);
			processInvoicesData = HashMapData.mapProcessInvoices.get(processInvoicesData.URLReservationNumber);
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		  
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
		
		// process invoices - End						
		

		getData(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	private void validateMember(String CardmemberNumber, String pointType, String Points, String ReservationNo) {

		String TICPointsBalance = "";
		String EpicurePointsBalance = "";

		int TICPoints = 0, EpicurePoints = 0;
		JSONObject objectMember = null;

		try {
			/*
			 * ConfigPayloads payloads = new ConfigPayloads();
			 * 
			 * String payload = payloads.getMemberDataPayload(memberNumber);
			 */
			String payload = "{\r\n" + "    \"card_string\": \"" + CardmemberNumber + "\"\r\n" + "}\r\n" + "";

			System.out.println("Get Member Data Payload: \n" + payload);

			try {
				BufferedWriter writer = new BufferedWriter(
						new FileWriter(Configuration.logLoc + ReservationNo + ".txt", true));

				writer.write("\nMembership Card Validate Points Request payload: \n" + payload + "\n\n");
				writer.write("Point Type:\t " + pointType + "\nPoints: \t" + Points + "\n\n");
				writer.write((new Date()).toString());
				writer.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

			OkHttpClient clientMember = new OkHttpClient();

			clientMember.setConnectTimeout(70, TimeUnit.SECONDS); // connect timeout
			clientMember.setReadTimeout(70, TimeUnit.SECONDS);

			MediaType mediaTypeMember = MediaType.parse("application/json");
			RequestBody bodyMember = RequestBody.create(mediaTypeMember, payload);
			Request requestMember = new Request.Builder()
					// .url("https://tajics-a455764.integration.us2.oraclecloud.com/integration/flowapi/rest/MEMBERQUERYMN/v01/QueryMember")
					.url(Configuration.validateCardURL).post(bodyMember).addHeader("Content-Type", "application/json")
					.addHeader("Authorization", Configuration.IcsBasicAuth).addHeader("Cache-Control", "no-cache")
					.addHeader("Postman-Token", "2d8738ae-ac58-4d88-bccf-c8a008ce8e52").build();

			Response responseMember = clientMember.newCall(requestMember).execute();
			String testResponse = responseMember.body().string();
			int resCode = responseMember.code();

			System.out.println("Get Member Data Response: \n" + testResponse);

			try {
				BufferedWriter writer = new BufferedWriter(
						new FileWriter(Configuration.logLoc + ReservationNo + ".txt", true));

				writer.write("\nMembership Card Validate Response: \n" + testResponse + "\n\n");
				writer.write((new Date()).toString());
				writer.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

			objectMember = new JSONObject(testResponse);

			if (resCode == 200 || resCode == 201 || resCode == 202) {
				try {
					String message = objectMember.getString("message");
					if (message.contains("Card is not present")) {
						objectPoint.put("status", "FAILED");
						objectPoint.put("statusMsg", "Member does not exist");

						return;
					} else if (message.contains("Card is Present but Expired")) {
						objectPoint.put("status", "FAILED");
						objectPoint.put("statusMsg", "Card is Present but Expired");
						return;
					} else if (message.contains("TIC Number does not exist")) {
						objectPoint.put("status", "FAILED");
						objectPoint.put("statusMsg", "Member does not exist");
						return;
					}
				} catch (Exception e) {

				}
			} else {
				objectPoint.put("status", "FAILED");
				objectPoint.put("statusMsg", "Card Not Swiped Properly");
				return;
			}
			String memberNumber = objectMember.getString("membershipNumber");

			String fetchCustomerRequest = "{\r\n" + "	\"membershipNumber\": \"" + memberNumber + "\",\r\n" + "	\"source_identifier\": \""+"MUIRedemption"+"\"\r\n" +  "}";
			try {
				BufferedWriter writer = new BufferedWriter(
						new FileWriter(Configuration.logLoc + ReservationNo + ".txt", true));

				writer.write("\nFetch Membership Request payload: \n" + fetchCustomerRequest + "\n\n");
				writer.write("Point Type:\t " + pointType + "\nPoints: \t" + Points + "\n\n");
				writer.write((new Date()).toString());
				writer.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

			OkHttpClient clientFetchMember = new OkHttpClient();

			clientFetchMember.setConnectTimeout(70, TimeUnit.SECONDS); // connect timeout
			clientFetchMember.setReadTimeout(70, TimeUnit.SECONDS);

			MediaType mediaTypeFetchMember = MediaType.parse("application/json");
			RequestBody bodyFetchMember = RequestBody.create(mediaTypeFetchMember, fetchCustomerRequest);
			Request requestFetchMember = new Request.Builder()
					// .url("https://tajics-a455764.integration.us2.oraclecloud.com/integration/flowapi/rest/MEMBERQUERYMN/v01/QueryMember")
					.url(Configuration.GetMemberDataURL).post(bodyFetchMember)
					.addHeader("Content-Type", "application/json").addHeader("Store_Id", GlobalPropertyCode)
					.addHeader("Authorization", Configuration.IcsBasicAuth).addHeader("Cache-Control", "no-cache")
					.addHeader("Postman-Token", "2d8738ae-ac58-4d88-bccf-c8a008ce8e52").build();

			Response responseFetchMember = clientFetchMember.newCall(requestFetchMember).execute();
			String testFetchResponse = responseFetchMember.body().string();
			int resFetchCode = responseFetchMember.code();

			System.out.println("Get Member Data Response: \n" + testFetchResponse);

			try {
				BufferedWriter writer = new BufferedWriter(
						new FileWriter(Configuration.logLoc + ReservationNo + ".txt", true));

				writer.write("\nMembership Card Validate Response: \n" + testResponse + "\n\n");
				writer.write((new Date()).toString());
				writer.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

			if (resFetchCode == 200 || resFetchCode == 201 || resFetchCode == 202) {
				try {
					JSONObject objectFetchMember1 = new JSONObject(testFetchResponse);
					JSONObject objectFetchStatuc = objectFetchMember1.getJSONObject("status");
					String message = objectFetchStatuc.getString("message");
					if (message.contains("No record found")) {
						try {
							BufferedWriter writer = new BufferedWriter(
									new FileWriter(Configuration.logLoc + ReservationNo + ".txt", true));

							writer.write("\nCardSwipe Res: \n" + objectPoint.toString() + "\n\n");
							writer.write((new Date()).toString());
							writer.close();

						} catch (Exception e) {
							e.printStackTrace();
						}
						objectPoint.put("status", "FAILED");
						objectPoint.put("statusMsg", "Member does not exist");
						return;
					}
				} catch (Exception e) {

				}
			} else {
				objectPoint.put("status", "FAILED");
				objectPoint.put("statusMsg", "Card Not Swiped Properly");
				return;
			}

			JSONObject objectFetchMember = new JSONObject(testFetchResponse);
			String customerHash = objectFetchMember.getString("customerHash");
			String tcpMemberNumber = objectFetchMember.getString("tcpNumber");
			JSONArray loyArray = objectFetchMember.getJSONArray("loyaltyInfo");
			JSONObject loyObj = loyArray.getJSONObject(0);
			// String MembershipTier = loyObj.getString("currentSlab");
			TICPointsBalance = loyObj.getString("loyaltyPoints");
			double doublePoints = Float.parseFloat(TICPointsBalance);
			TICPoints = (int) doublePoints;

			/*
			 * JSONArray MemberJson1 = objectMember.getJSONObject("MemberQuery_Output")
			 * .getJSONObject("ListOfIhclLoyMemberQueryIo").getJSONArray("LoyMember");
			 * 
			 * 
			 * for(int i = 0; i < MemberJson1.length(); i++) { JSONObject JsonMemberData =
			 * MemberJson1.getJSONObject(i);
			 * 
			 * String MembershipNumber = JsonMemberData.getString("MemberNumber"); //
			 * MemberName = JsonMemberData.getString("Name");
			 * 
			 * String MembershipTier =
			 * JsonMemberData.getJSONObject("ListOfLoyMemberTier").getJSONArray(
			 * "LoyMemberTier").getJSONObject(0).getString("TierName");
			 * 
			 * JSONArray MemberPoints =
			 * JsonMemberData.getJSONObject("ListOfLoyMemberPointBalancesVbc")
			 * .getJSONArray("LoyMemberPointBalancesVbc"); for (int j = 0; j <
			 * MemberPoints.length(); j++) { JSONObject JsonPoints =
			 * MemberPoints.getJSONObject(j); System.out.println(JsonPoints);
			 * if(JsonPoints.getString("PointType").equalsIgnoreCase("TIC")) {
			 * TICPointsBalance = JsonPoints.getString("AvailablePoints");
			 * if(!TICPointsBalance.equalsIgnoreCase("0") ||
			 * !TICPointsBalance.equalsIgnoreCase("") || TICPointsBalance != null) TICPoints
			 * = Integer.parseInt(TICPointsBalance); }
			 * if(JsonPoints.getString("PointType").equalsIgnoreCase("Epicure")) {
			 * EpicurePointsBalance = JsonPoints.getString("AvailablePoints");
			 * if(!EpicurePointsBalance.equalsIgnoreCase("0") ||
			 * !EpicurePointsBalance.equalsIgnoreCase("") || EpicurePointsBalance != null)
			 * EpicurePoints = Integer.parseInt(EpicurePointsBalance); }
			 * 
			 * }
			 * 
			 * }
			 */

			if (Integer.parseInt(Points) <= TICPoints) {

				objectPoint.put("status", "SUCCESS");
				objectPoint.put("customerHash", customerHash);
				objectPoint.put("memberNumber", memberNumber);
				objectPoint.put("tcpMemberNumber", tcpMemberNumber);
				return;
			} else if (Integer.parseInt(Points) > TICPoints) {

				objectPoint.put("status", "ERROR");
				objectPoint.put("statusMsg", "Insufficient points entered");
				objectPoint.put("TICPoints", TICPoints);
				objectPoint.put("EpicurePoints", EpicurePoints);
				return;
			}

		} catch (Exception e) {
			e.printStackTrace();

			try {
				JSONObject object1 = objectMember;

				String error = object1.getJSONArray("o:errorDetails").getJSONObject(0).getString("title");

				if (error.contains("Member does not exist")) {
					System.out.println("Member does not exist");
					objectPoint.put("status", "FAILED");
					objectPoint.put("statusMsg", "Member does not exist");
				}
			} catch (Exception ee) {

			}

			return;
		}

		return;
	}

	private void writeToPMS(HttpServletRequest request, HttpServletResponse response, String TransactionID,
			String PaymentDescription, String GResvNumber, String GlobalPropertyCode, String logsID) {

		// double currencyConversionRate = HashMapData.mapCurrency.get(GResvNumber);
		ProcessInvoicesData processInvoicesData = HashMapData.mapProcessInvoices.get(GResvNumber);

		// double tempTotalAmount = Double.parseDouble(processInvoicesData.TotalAmount);
		double tempTotalAmount = availableBal;

		String UserName = "Supervisor";

		Date date = new Date();

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

		System.out.println(dateFormat.format(date));
		System.out.println(timeFormat.format(date));

		String PostDate = dateFormat.format(date);
		String PostTime = timeFormat.format(date);
int len= 45 ;
		int writeCount = 0;
		try {
			 len =processInvoicesData.arrRequest.length();
			String Invoicessss = processInvoicesData.arrRequest.getString(0);
			
			System.out.println(Invoicessss);
			System.out.println(len);
		} catch (Exception e) {
			System.out.println(len);
			e.printStackTrace();
			// TODO: handle exception
		}
		
		try {
			
			 for(int i=0; i<processInvoicesData.arrRequest.length(); i++)
			{

					String Invoice = processInvoicesData.arrRequest.getString(i);
					
					/*StoreInvoiceDetails storeInvoiceDetails = HashMapData.mapInvoices.get(processInvoicesData.URLReservationNumber);
					
					storeInvoiceDetails.mapInvoice.get(Invoice);6
					StoreInvoiceDetails invoiceDetails = storeInvoiceDetails.mapInvoice.get(Invoice);*/
					
					String resvNumber = request.getParameter("GlobalReservationNumber");
					System.out.println(GlobalReservationNumber);
					StoreInvoiceDataMap storeInvoiceDataMap = HashMapData.mapInvoices.get(request.getParameter("GlobalReservationNumber"));
					
					HashMap<String, StoreInvoiceDetails> storeInvoiceDetailsMap = storeInvoiceDataMap.getstoreInvoices();
					
					StoreInvoiceDetails invoiceDetails = storeInvoiceDetailsMap.get(Invoice);
					
				System.out.println(invoiceDetails.WindowNo);
					
					processInvoicesData.strWindowNo[i] = invoiceDetails.WindowNo;
					processInvoicesData.strName[i] = invoiceDetails.Name;
					processInvoicesData.strAmount[i] = Double.toString(invoiceDetails.Amount);
					
					System.out.println(processInvoicesData.strWindowNo[i]);
					System.out.println(processInvoicesData.strName[i]);
					System.out.println(processInvoicesData.strName[i]);					
					
					HashMapData.mapProcessInvoices.put(processInvoicesData.URLReservationNumber, processInvoicesData);
					processInvoicesData = HashMapData.mapProcessInvoices.get(processInvoicesData.URLReservationNumber);
					
					if(tempTotalAmount != 0) 
					{
					
						double writeBackAmount = Double.parseDouble(processInvoicesData.strOrigCurrencyAmount[i]);
						if(tempTotalAmount >= writeBackAmount)
							tempTotalAmount = tempTotalAmount - writeBackAmount;
						else
						{
							writeBackAmount = tempTotalAmount;
							tempTotalAmount = 0;
						}
					//System.out.println(TransactionNo+"\t"+Date+"\t"+Description+"\t"+Amount+"\t"+RoomNo);
					
					GetReservationData getReservationData = HashMapData.mapReservationData.get(processInvoicesData.URLReservationNumber);
					
					//payment type
					/*String payType = processInvoicesData.PaymentCardType;
					if(payType.equals("TIC"))
						payType="TCP";*/
					
					ConfigPayloads payloads = new ConfigPayloads();
					
					String PaymentCardType="";
				//	PaymentCardType="QGC";
					
					  if(Memtype.equals("Epicure")) PaymentCardType="EPV"; 
					  else if(Memtype.equals("Chambers")) PaymentCardType="CHV";					  
					  else if(Memtype.equals("Taj Club")) PaymentCardType="TCV";
					  
					  String payload = "";
					//Paylode IDS change 
					  if(GlobalPropertyCode.startsWith("IDS")) {
							String IDSRESVID = GetReservationData.RESVID;
							payload = payloads.getWriteToPMSPaylaod(GlobalPropertyCode, PostTime, UserName, PaymentDescription, writeBackAmount, PostDate, processInvoicesData.strWindowNo[i], getReservationData.HotelCode, IDSRESVID, PaymentCardType, TransactionID);

					  }else {
							payload = payloads.getWriteToPMSPaylaod(GlobalPropertyCode, PostTime, UserName, PaymentDescription, writeBackAmount, PostDate, processInvoicesData.strWindowNo[i], getReservationData.HotelCode, request.getParameter("GlobalReservationNumber"), PaymentCardType, TransactionID);

					  }
					 	
					try{
						BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + request.getParameter("GlobalReservationNumber")+".txt",true));
						
						writer.write("\nPMS Payment Request payload: \n" + payload + "\n\n");
						writer.close();
						
					} catch(Exception e)
					{
						e.printStackTrace();
					}
					try{
						BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.redemptionLog + request.getParameter("GlobalReservationNumber")+logsID+".txt",true));
						writer.write((new Date()).toString());
						writer.write("\nPMS Payment Request payload: \n" + payload + "\n\n");
						writer.close();
						
					} catch(Exception e)
					{
						e.printStackTrace();
					}
					
					if(processInvoicesData.PaymentCardType.equals("QGC"))
					{
						try
						{
							BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.giftCardLogLoc + request.getParameter("GlobalReservationNumber")+".txt",true));

							writer.write("\n\nPMS Payment Request:\n " + payload + "\n");
							
							writer.close();
						}catch(Exception e)
						{
							e.printStackTrace();
						}
					}
					
			/*String payload = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:core=\"http://webservices.micros.com/og/4.3/Core/\" xmlns:res=\"http://webservices.micros.com/og/4.3/ResvAdvanced/\" xmlns:com=\"http://webservices.micros.com/og/4.3/Common/\" xmlns:hot=\"http://webservices.micros.com/og/4.3/HotelCommon/\">\r\n" + 
					"  <soap:Header>\r\n" + 
					"    <OGHeader transactionID=\"349860637\" timeStamp=\"2009-02-13T14:48:16.0718750-05:00\" xmlns=\"http://webservices.micros.com/og/4.3/Core/\">\r\n" + 
					"      <Origin entityID=\"OWS\" systemType=\"OWS\" />\r\n" + 
					"      <Destination entityID=\"OWS\" systemType=\"PMS\" />\r\n" + 
					"     <Authentication>\r\n" + 
					"        <UserCredentials>\r\n" + 
					"          <UserName>SUPERVISOR</UserName>\r\n" + 
					"          <UserPassword>BETTERTHANV6</UserPassword>\r\n" + 
					"          <Domain>FSDH</Domain>\r\n" + 
					"        </UserCredentials>\r\n" + 
					"      </Authentication>\r\n" + 
					"    </OGHeader>\r\n" + 
					"  </soap:Header>\r\n" + 
					"  <soap:Body>\r\n" + 
					"    <MakePaymentRequest xmlns=\"http://webservices.micros.com/og/4.3/ResvAdvanced/\" xmlns:c=\"http://webservices.micros.com/og/4.3/Common/\" xmlns:hc=\"http://webservices.micros.com/og/4.3/HotelCommon/\" xmlns:n=\"http://webservices.micros.com/og/4.3/Name/\" xmlns:r=\"http://webservices.micros.com/og/4.3/Reservation/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
					"      <Posting PostTime=\""+PostTime+"\" UserID=\""+UserName+"\" ShortInfo=\"POINT\" LongInfo=\""+PaymentDescription+"\" Charge=\""+writeBackAmount+"\" StationID=\"KIOSK1\" PostDate=\""+PostDate+"\"  FolioViewNo=\""+processInvoicesData.strWindowNo[i]+"\" >\r\n" + 
					"        <ReservationRequestBase>\r\n" + 
					"          <HotelReference hotelCode=\""+getReservationData.HotelCode+"\" />\r\n" + 
					"           <ReservationID>\r\n" + 
					"          <c:UniqueID type=\"INTERNAL\" source=\"PMSID\">"+processInvoicesData.URLReservationNumber+"</c:UniqueID>\r\n" + 
					"        </ReservationID>\r\n" + 
					"        </ReservationRequestBase>\r\n" + 
					"      </Posting>\r\n" + 
					"      <CreditCardInfo>\r\n" + 
					"        <CreditCardApproved cardType=\""+processInvoicesData.PaymentCardType+"\">\r\n"+ 
					"			<c:cardHolderName>Middleware</c:cardHolderName>" +
					"			<c:cardNumber>12345</c:cardNumber>" +
					"			<c:expirationDate>2022-12-31</c:expirationDate>" + 
					"          <hc:ApprovalCode>9001</hc:ApprovalCode>\r\n" + 
					"        </CreditCardApproved>\r\n" + 
					"      </CreditCardInfo>\r\n" + 
					"      <Reference>"+TransactionID+"</Reference>\r\n" + 
					"    </MakePaymentRequest>\r\n" + 
					"  </soap:Body>\r\n" + 
					"</soap:Envelope>";*/
			
					System.out.println("Transaction Write Payload: \n" + payload);
					
					String WSDL = URLConfig.getMakePaymentWSDL(GlobalPropertyCode);
					WSDL = WSDL+resvNumber;
					
  					Response writeBackToPMSResponse = Configuration.writeBackToPMSResponse(WSDL, GlobalPropertyCode, payload);
					String responce = writeBackToPMSResponse.body().string();
					System.out.println("Future Booking Response:\n" + responce); 					
					try{
						BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + request.getParameter("GlobalReservationNumber")+".txt",true));
						writer.write("\nPMS Payment Response: \n" + responce + "\n\n");
						writer.close();
						
					} catch(Exception e)
					{
						e.printStackTrace();
					}
					try{
						BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.redemptionLog + request.getParameter("GlobalReservationNumber")+logsID+".txt",true));
						writer.write((new Date()).toString());
						writer.write("\nPMS Payment Response: \n" + responce + "\n\n");
						writer.close();
						
					} catch(Exception e)
					{
						e.printStackTrace();
					}
					
					if(responce.contains("The timeout period elapsed prior to obtaining a connection from the pool")) {
						
						try{		     
							BufferedWriter writer2 = new BufferedWriter(new FileWriter(Configuration.logLoc +"TimeOutErrorLogs/"+GlobalPropertyCode+"_"+ request.getParameter("GlobalReservationNumber")+".txt",true));
							
							writer2.write("\nPMS Payment Response: \n" + responce + "\n\n");
							writer2.write((new Date()).toString());
							writer2.close();
							
						} catch(Exception e)
						{
							e.printStackTrace();
						}
					}else if(responce.contains("Error 503--Service Unavailable")  || responce.contains("Service Unavailable") || responce.contains("Error 503")  || responce.contains("Error 503--Service Unavailable")) {
						String EmailStatus = GetReservationData.SendEmailAlert(request.getParameter("GlobalReservationNumber") , GlobalPropertyCode, "PMS Make Payment");
						try{
							BufferedWriter writer1 = new BufferedWriter(new FileWriter(Configuration.logLoc +"ErrorLogs/"+ request.getParameter("GlobalReservationNumber")+".txt",true));

							writer1.write("\nPMS Payment Response: \n" + responce + "\n\n");
							writer1.close();	
						} catch(Exception e)
						{
							e.printStackTrace();
						}
						}
					
					
						try
						{
							BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.giftCardLogLoc + request.getParameter("GlobalReservationNumber")+".txt",true));

							writer.write("\n\nPMS Payment Response:\n " + responce + "\n");
							
							writer.close();
						}catch(Exception e)
						{
							e.printStackTrace();
						}
					
						JSONObject req = null;
						try {
							req = new JSONObject(responce);
						} catch (JSONException e) {
							e.printStackTrace();
						}
						String codeandmessage = writeBackToPMSResponse.toString();
						Map<String, String> result = Configuration.getCodeAndMessage(codeandmessage);
//						try{
//							BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + request.getParameter("GlobalReservationNumber")+".txt",true));
//							
//							writer.write("\nPMS Payment Status: \t" + isSuccess + "\n\n");
//							writer.close();
//							
//						} catch(Exception e)
//						{
//							e.printStackTrace();
//						}
						if(result.get("code").equalsIgnoreCase("200") && result.get("message").equalsIgnoreCase("OK"))
						{
								writeCount++;
						}
						
	//				Document doc = soapExecutor.convertStringToDocument(responce);
					
					
//					NodeList nList = doc.getElementsByTagName("s0:MakePaymentResponse");
//					
//					for(int j=0; j<nList.getLength(); j++)
//					{
//						Element Ele = (Element) nList.item(j);
//						
//						NodeList nListRes = Ele.getElementsByTagName("s0:Result");
//						
//						Element EleRes = (Element) nListRes.item(0);
//						
//						String isSuccess = EleRes.getAttribute("resultStatusFlag").toString();
//						
//						System.out.println(isSuccess);
//						
//						try{
//							BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + request.getParameter("GlobalReservationNumber")+".txt",true));
//							
//							writer.write("\nPMS Payment Status: \t" + isSuccess + "\n\n");
//							writer.close();
//							
//						} catch(Exception e)
//						{
//							e.printStackTrace();
//						}
//						
//						if(isSuccess.equalsIgnoreCase("SUCCESS"))
//						{
//							writeCount++;
//						}
//					} 
					
					//writeCount++;				
					}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				/*
				 * if(writeCount == processInvoicesData.arrRequest.length()) {
				 * servletResponse.getWriter().write("NewInvoices.jsp?ReservId="+
				 * processInvoicesData.URLReservationNumber+"&PayStatus=success");
				 * //servletResponse.sendRedirect("NewInvoices.jsp?ReservId="+
				 * StoreInvoiceDetails.ReservationID+"&PayStatus=success"); return; }
				 */
				if (writeCount > 0) {
					this.object.put("url02", "NewInvoices.jsp?ReservId=" + processInvoicesData.URLReservationNumber
							+ "&PayStatus=success&Property=" + GlobalPropertyCode + "");
					// servletResponse.getWriter().write(this.object.toString());
					// servletResponse.getWriter().write("NewInvoices.jsp?ReservId="+processInvoicesData.URLReservationNumber+"&PayStatus=success&Property="+GlobalPropertyCode+"");
					// servletResponse.sendRedirect("NewInvoices.jsp?ReservId="+StoreInvoiceDetails.ReservationID+"&PayStatus=success");
					return;
				} else {
					WriteToPmsStatus_ = "WriteToPmsFailed";
					// this.object.put("status", "WriteToPmsFailed");
					if (processInvoicesData.PaymentCardType.equals("QGC")) {
						servletResponse.getWriter()
								.write("NewInvoices.jsp?ReservId=" + processInvoicesData.URLReservationNumber
										+ "&PayStatus=failedPMS&Property=" + GlobalPropertyCode + "");
					}
					// servletResponse.sendRedirect("NewInvoices.jsp?ReservId="+StoreInvoiceDetails.ReservationID+"&PayStatus=failedPMS");
					return;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	String convertDateFormat(String date)
	{
		try
		{
			SimpleDateFormat format1 = new SimpleDateFormat("MM/dd/yyyy");
			SimpleDateFormat format2 = new SimpleDateFormat("dd-MMM-yyyy");
			Date convertedDate = format1.parse(date);
			String returnString = format2.format(convertedDate);
			return returnString;
		}
		catch(Exception e)
		{
			return "";
		}
	}
	private String getPropertyCode(String PMSPropertyCode)
	{
		String PropertyCode = "";
		
		String WSDL1 = Configuration.SalesCustomObjectServiceWSDL;
		String Action1 = Configuration.SalesCustomObjectServiceAction;
		
		String userName = Configuration.MDMUsername;
		String password = Configuration.MDMPassword;
		
		ConfigPayloads payloads = new ConfigPayloads();
		String payload = payloads.getHotelsPayload();
		
		SoapExecutor soapExecutor = new SoapExecutor(WSDL1);
		String responce = soapExecutor.executeRequest(userName, password, Action1,payload);
		System.out.println("Hotel: \n"+responce);
		Document doc = soapExecutor.convertStringToDocument(responce);
		
		NodeList nList = doc.getElementsByTagName("ns0:findEntityResponse");
		
		
		
			Element eleHotel = (Element) nList.item(0);
			NodeList nListHotel =  eleHotel.getElementsByTagName("ns2:result");
			
			for(int i=0; i<nListHotel.getLength(); i++)
			{
				Element ele = (Element) nListHotel.item(i);
				
//				String ID = soapExecutor.getValue(ele, "ns1:Id");
//				String RecordName = soapExecutor.getValue(ele, "ns1:RecordName");
//				String HotelName = soapExecutor.getValue(ele, "ns1:HotelName_c");
				
				String PMSHotelCode = soapExecutor.getValue(ele, "ns1:PmsHotelCode_c");
				System.out.println(PMSHotelCode);
				if(PMSHotelCode.equalsIgnoreCase(PMSPropertyCode))
					PropertyCode = soapExecutor.getValue(ele, "ns1:PropertyCode_c");
				

		}
		
		
		return PropertyCode;
	}
}
