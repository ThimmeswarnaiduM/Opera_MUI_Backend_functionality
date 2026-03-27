package config;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import data.NewInvoicesData;

public class GetProfileData implements Runnable {
	private HttpServletRequest request;
    private HttpServletResponse response;
    private static String AUTH_TOKEN = "";

	public static HashMap<String, GetProfileData> mapInvoice = new HashMap<>(); 
	public static HashMap<String,String> GravtyMemberNumber=new HashMap<String,String>();// Hash map to store GravtyMemberNumber
	
	String PMSNameCode = "";
	String ReservationNo = "";
	String OWSPropertyCode = "";
	boolean origBoolean = false;
	public static String Token="Q1hVTklUWVNJLWloY2xjZHB0ZXN0X0FQUElEOmlkY3Njcy0zNGI3ODE5My03NzM5LTQ3YTUtYTA4Yy1hZDBlYzY5YjVkNTA='";

	public String FirstName = "";
	public String LastName = "";
	public String MembershipNumberTPM="";
	public String Salutation = "";
	public String Gender = "";
	public String Email = "";
	public String Phone = "";
	public String MDMPartyNumber="";
	
	public String PartyId = "";
	public String PartyNumber = "";
	public String MembershipType = "";
	public String EnrollNumber_c = "";
	public String TPMMemberNumber = "";
	public String TPMMemberLevel="";
	public String TICMemberNumber = "";
	public String CHMemberNumber = "";
	public String  EPIMemberNumber="";
	public String  EPIMemberLevel="";
	public String CHMemberLevel="";
	public String  TCPMemberLevel="";
		
	public String  membershipNumber="";
	public String  TICmembershipTier="";
	public String  Reservation_LoyaltyNumber= GetReservationData.Reservation_LoyaltyNumber;
	public String membership_Type="";
	public String membershipTier="";
	public String  Reservation_status;
	
	public String DateOfBirth = "";
	public String Address1 = "";
	public String Address2 = "";
	public String Address3 = "";
	public String Address4 = "";
	public String city = "";
	public String state = "";
	public String country = "";
	public String postal = "";
	//
	public String ResMemID = GetReservationData.membershipID;
	//
	
	public boolean isProfileFound = false;
	
	
	public GetProfileData(String PMSNameCode, String ReservationNo, String OWSPropertyCode,HttpServletRequest request, HttpServletResponse response) {
		
		super();
		this.PMSNameCode = PMSNameCode;
		this.ReservationNo = ReservationNo;
		this.OWSPropertyCode = OWSPropertyCode;
		this.request=request;
		this.response=response;
	}



	@Override
	public void run() {
		
	//	JSONArray MembershipDetailsArray = new JSONArray();
		
		System.out.println("Thread Started");
//		ConfigPayloads payloads = new ConfigPayloads();
//		 Map<String, String> personalData = GetReservationData.personalDetails;
//		 List<Map<String, String>> membershipData = GetReservationData.membershipList;
//		 String profileId=GetReservationData.ReservationID;
//		 System.out.println("Personal Data :" + personalData);
//		 System.out.println("Membership Data: " + membershipData);
//		 Map<String, Object> finalData = new HashMap<>();
//		 finalData.put("personalDetails", GetReservationData.personalDetails);
//		 finalData.put("membershipDetails", GetReservationData.membershipList);
//		 System.out.println("FINAL DATA ==> " + finalData);
//		 if (isValidFinalData(finalData)) {			 
//			 String masterCustomerId = personalData.get("operaProfileId");
//			 String origSys = null;
//		     String origSysRef = null;
//		     if (masterCustomerId != null && masterCustomerId.contains("_")) {
//		            int lastUnderscoreIndex = masterCustomerId.lastIndexOf("_");
//		            origSys = masterCustomerId.substring(0, lastUnderscoreIndex);
//		            origSysRef = masterCustomerId.substring(lastUnderscoreIndex + 1);
//		        }
//
//		        if ("OPERA_CLOUD".equalsIgnoreCase(origSys)|| "EPICURE".equalsIgnoreCase(origSys)) {
//		            origSys = "CLOUDCENTRAL";
//		        }
//		        if( origSys.equals("CLOUDCENTRAL")) {
//		        	 origBoolean = true;
//		        	
//		        }
//		        if(origBoolean == true) {
//		        	isProfileFound = true;
//		        	for (Map<String, String> member : membershipData) {
//		        	    String type = member.get("membershipType");
//		        	    if ("TPM".equalsIgnoreCase(type)) {
//		        	        TPMMemberNumber = member.get("membershipCardNo");
//		        	        break;  // stop once found
//		        	    }
//		        	}
//		        	if (TPMMemberNumber == null || TPMMemberNumber.isEmpty()) {
//		        	    TPMMemberNumber = personalData.get("phone"); 
//		        	}
//		        	PartyNumber=personalData.get("masterCustomerId");
//		        	FirstName=personalData.get("firstName");
//		        	LastName=personalData.get("lastName");
//		        	Salutation=personalData.get("prefix");
//		        	Gender=personalData.get("");
//		        	Phone=personalData.get("phone");
//		        	Address1=personalData.get("addressLine1");
//		        	city=personalData.get("city");
//		        	country=personalData.get("country");
//		        	postal=personalData.get("zipcode");
//		        	state=personalData.get("state");		        	
//		        	
//		        	
//		        }
//		        
//
//		        for (Map<String, String> member : membershipData) {
//
//		            String membershipType  = member.get("membershipType");
//		            String membershipCardNo = member.get("membershipCardNo");
//		            String membershipLevel = member.get("membershipLevel");
//
//		            if ("null".equalsIgnoreCase(membershipLevel)) {
//		                membershipLevel = "";
//		            }
//
//		            System.out.println("Type: " + membershipType +
//		                    " | Card: " + membershipCardNo + " | Level: " + membershipLevel);
//
//		            if (membershipType == null || membershipType.trim().isEmpty()) continue;
//
//		            if (membershipType.equalsIgnoreCase("TCP")) {
//		                if (membershipCardNo.equals(Reservation_LoyaltyNumber)) {
//		                    membershipNumber = membershipCardNo;
//		                    membershipTier = membershipLevel;
//		                    membership_Type = membershipType;
//		                }
//		            }
//		            else if (membershipType.equalsIgnoreCase("TPM")) {
//		                if (membershipCardNo.equals(Reservation_LoyaltyNumber)) {
//		                    membershipNumber = membershipCardNo;
//		                    membershipTier = membershipLevel;
//		                    membership_Type = membershipType;
//		                }
//		            }
//		            else if (membershipType.equalsIgnoreCase("TAJ")) {
//		                if (membershipCardNo.equals(Reservation_LoyaltyNumber)) {
//		                    membershipNumber = membershipCardNo;
//		                    membershipTier = membershipLevel;
//		                    membership_Type = membershipType;
//		                }
//		            }
//		            else if (membershipType.equalsIgnoreCase("CHAMBERS")) {
//		                CHMemberNumber = membershipCardNo;
//		                CHMemberLevel = membershipLevel;
//
//		                if (membershipCardNo.equals(Reservation_LoyaltyNumber)) {
//		                    membershipNumber = CHMemberNumber;
//		                    membershipTier = CHMemberLevel;
//		                    membership_Type = membershipType;
//		                }
//
//		                JSONObject payload = new JSONObject();
//		                try {
//							payload.put("MemberType", "Chambers");
//						} catch (JSONException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}
//		                try {
//							payload.put("chambers_id", CHMemberNumber);
//						} catch (JSONException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//
//		                fetchOutstandingBalance(payload);
//		            }
//		            else if (membershipType.equalsIgnoreCase("EPI")) {
//		                if (membershipCardNo.equals(Reservation_LoyaltyNumber)) {
//		                    membershipNumber = membershipCardNo;
//		                    membershipTier = membershipLevel;
//		                    membership_Type = membershipType;
//		                }
//		            }
//
//		            GravtyMemberNumber.put("CHMemberNumber", CHMemberNumber);
//		            GravtyMemberNumber.put("EPIMemberNumber", EPIMemberNumber);
//		        }
//
//
//			}
//		 
		 
//		String findPersonServicePayload = payloads.getProfileDataPayload(PMSNameCode);
//		String PMSCODE= "OPERA_CLOUD_"+PMSNameCode;
//		try {
//		    JSONObject jsonObject = FecthprofileDataCDP(PMSCODE);
//		    
//		    System.out.println("CDP Fetch Profile Data: " + jsonObject);
//
//		    JSONArray headers = jsonObject.getJSONArray("header");
//		    JSONArray dataArray = jsonObject.getJSONArray("data");
//
//		    
//		    Map<String, Integer> headerIndexMap = new HashMap<>();
//		    for (int i = 0; i < headers.length(); i++) {
//		        JSONObject headerObj = headers.getJSONObject(i);
//		        String name = headerObj.optString("name", "").trim();
//		        headerIndexMap.put(name, i);
//		    }
//
//		   
//		    JSONArray firstRow = null;
//		    for (int i = 0; i < dataArray.length(); i++) {
//		        JSONArray row = dataArray.getJSONArray(i);
//		        String phoneCandidate = row.optString(headerIndexMap.get("m_mobienumber"), null);
//		        if (phoneCandidate != null && !phoneCandidate.isEmpty()) {
//		            firstRow = row;
//		            break;
//		        }
//		    }
//
//		    if (firstRow != null) {
//		        
//		        String masterCustomerId = firstRow.optString(headerIndexMap.get("c_id"), null);
//		        String origSys = null;
//		        String origSysRef = null;
//
//		        if (masterCustomerId != null && masterCustomerId.contains("_")) {
//		            int lastUnderscoreIndex = masterCustomerId.lastIndexOf("_");
//		            origSys = masterCustomerId.substring(0, lastUnderscoreIndex);
//		            origSysRef = masterCustomerId.substring(lastUnderscoreIndex + 1);
//		        }
//
//		        if ("OPERA_CLOUD".equalsIgnoreCase(origSys)) {
//		            origSys = "CLOUDCENTRAL";
//		        }
//
//		        System.out.println("origSys: " + origSys);
//		        System.out.println("origSysRef: " + origSysRef);
//		        //origSysRef.equals(PMSNameCode)&&
//		        
//		        if( origSys.equals("CLOUDCENTRAL")) {
//		        	 origBoolean = true;
//		        	
//		        }
//		        if(origBoolean == true) {
//		        	isProfileFound = true;
//		        
//		       
//		        TPMMemberNumber = "91-" + firstRow.optString(headerIndexMap.get("m_mobienumber"), null);
//		        PartyNumber = firstRow.optString(headerIndexMap.get("c_id"), null);
//		        FirstName = firstRow.optString(headerIndexMap.get("m_firstname"), null);
//		        LastName = firstRow.optString(headerIndexMap.get("m_lastname"), null);
//		        Salutation = firstRow.optString(headerIndexMap.get("m_saluatation"), null);
//		        Gender = firstRow.optString(headerIndexMap.get("m_gender"), null);
//		        Email = firstRow.optString(headerIndexMap.get("m_emailaddress"), null);
//		        Phone = firstRow.optString(headerIndexMap.get("m_mobienumber"), null);
//		        Address1 = firstRow.optString(headerIndexMap.get("m_addressline1"), null);
//		        Address2 = firstRow.optString(headerIndexMap.get("m_addressline2"), null);
//		        city = firstRow.optString(headerIndexMap.get("m_city"), null);
//		        country = firstRow.optString(headerIndexMap.get("m_country"), null);
//		        postal = firstRow.optString(headerIndexMap.get("m_pincode"), null);
//		        state = firstRow.optString(headerIndexMap.get("m_state"), null);
//
//		        // Create GetProfileData object
//		        GetProfileData getProfileData = new GetProfileData(origSysRef, origSysRef, origSysRef, request, response);
//		        getProfileData.FirstName = FirstName;
//		        getProfileData.LastName = LastName;
//		        getProfileData.Email = Email;
//		        getProfileData.Phone = Phone;
//		        getProfileData.Address1 = Address1;
//		        getProfileData.Address2 = Address2;
//		        getProfileData.city = city;
//		        getProfileData.country = country;
//		        getProfileData.postal = postal;
//		        getProfileData.state = state;
//		        getProfileData.Gender = Gender;
//		        getProfileData.Salutation = Salutation;
//
//		        System.out.println("FirstName: " + FirstName);
//		        System.out.println("LastName: " + LastName);
//		        System.out.println("Salutation: " + Salutation);
//		        System.out.println("Gender: " + Gender);
//		        System.out.println("Email: " + Email);
//		        System.out.println("Phone: " + Phone);
//		        System.out.println("Address1: " + Address1);
//		    }
//
//		    // Step 4️⃣ — Handle membership details dynamically
//		    for (int i = 0; i < dataArray.length(); i++) {
//		        JSONArray row = dataArray.getJSONArray(i);
//
//		        String membershipType = row.optString(headerIndexMap.get("l_membershiptype"), "");
//		        String membershipCardNo = row.optString(headerIndexMap.get("l_membershipcardno"), "");
//		        String membershipLevel = row.optString(headerIndexMap.get("l_membershiplevel"), "");
//		        if ("null".equalsIgnoreCase(membershipLevel)) {
//		            membershipLevel = "";
//		        }
//		        System.out.println("Row " + i + " -> Type: " + membershipType +
//		                " | Card: " + membershipCardNo + " | Level: " + membershipLevel);
//
//		        if (membershipType == null || membershipType.trim().isEmpty()) continue;
//
//		        if (membershipType.equalsIgnoreCase("TCP")) {
//			        if (membershipCardNo.equals(Reservation_LoyaltyNumber)) {
//			            membershipNumber = membershipCardNo;
//			            membershipTier = membershipLevel;
//			            membership_Type = membershipType;
//			        }
//			    } 
//			    else if (membershipType.equalsIgnoreCase("TPM")) {
//			        if (membershipCardNo.equals(Reservation_LoyaltyNumber)) {
//			            membershipNumber = membershipCardNo;
//			            membershipTier = membershipLevel;
//			            membership_Type = membershipType;
//			        }
//			    } 
//			    else if (membershipType.equalsIgnoreCase("TAJ")) {
//			        if (membershipCardNo.equals(Reservation_LoyaltyNumber)) {
//			            membershipNumber = membershipCardNo;
//			            membershipTier = membershipLevel;
//			            membership_Type = membershipType;
//			        }
//			    } 
//			    else if (membershipType.equalsIgnoreCase("CHAMBERS")) {
//			    	CHMemberNumber=membershipCardNo;
//			    	CHMemberLevel=membershipLevel;
//			    	
//			        if (membershipCardNo.equals(Reservation_LoyaltyNumber)) {
//			            membershipNumber = CHMemberNumber;
//			            System.out.println("membershipNumber:"+membershipNumber);
//			            membershipTier = CHMemberLevel;
//			            System.out.println("membershipTier:"+membershipTier);
//			            membership_Type = membershipType;
//			        }
//
//			        
//			        JSONObject payload = new JSONObject();
//			        payload.put("MemberType", "Chambers");
//			        payload.put("chambers_id", CHMemberNumber);
//
//			        // Call new API
//			        fetchOutstandingBalance(payload);
//			    } 
//			    else if (membershipType.equalsIgnoreCase("EPI")) {
//			        if (membershipCardNo.equals(Reservation_LoyaltyNumber)) {
//			            membershipNumber = membershipCardNo;
//			            membershipTier = membershipLevel;
//			            membership_Type = membershipType;
//			        }
//			    }
//
//			    // You can also build your GravtyMemberNumber object like before:
//			    //GravtyMemberNumber.put("CHMemberNumber", membershipType.equalsIgnoreCase("CH") ? membershipCardNo : JSONObject.NULL);
//			    GravtyMemberNumber.put("CHMemberNumber",CHMemberNumber);
//         		GravtyMemberNumber.put("EPIMemberNumber",EPIMemberNumber);
//			   // GravtyMemberNumber.put("EPIMemberNumber", membershipType.equalsIgnoreCase("EPI") ? membershipCardNo : JSONObject.NULL);
//			}
//
//		    }
//		} catch (IOException | JSONException e) {
//		    e.printStackTrace();
//		}


		
		
		
		
		//System.out.println("findPersonServicePayload: "+findPersonServicePayload);
		
//		try{
//			BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + ReservationNo+".txt",true));
//			
//			writer.write("\nFind Person Request payload: \n" + findPersonServicePayload + "\n\n");
//			writer.write((new Date()).toString());
//			writer.close();
//			
//		} catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//		
		
	 	String WSDL = Configuration.GetProfileDataWSDL; //"https://httpstat.us/500"; 
		String Action = Configuration.GetProfileDataActionURL;
		
		String userName = "datacentre";
		String password = "Smile@25";
		
		 if(origBoolean == false) {
			//
			WSDL = Configuration.FetchBookingCentralOperaCloudWSDL;
			WSDL = WSDL+PMSNameCode;
			Response response = Configuration.getProfileDataFromAPI(WSDL,OWSPropertyCode);
			String resp=null;
			try {
				resp = response.body().string();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try{
				BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + ReservationNo+".txt",true));	
				writer.write("\nFetch Booking Response: \n" + resp + "\n\n");
				writer.write((new Date()).toString());
				writer.close();
				
			} catch(Exception e)
			{
				e.printStackTrace();
			}
			Configuration configuration = new Configuration();
			String hotelSet = Configuration.hotelList.get(OWSPropertyCode);
			if(hotelSet.equals("Central") || hotelSet.equals("Oracle Cloud Central")) {
				JSONObject reservationJson = null;
				try {
					reservationJson = new JSONObject(resp);
				} catch (JSONException e) {
					e.printStackTrace();
				}
			    origBoolean = true;
				isProfileFound = true;
				try {
					Gender = reservationJson.getJSONObject("profileDetails").getJSONObject("customer").getString("gender");
				} catch (JSONException e2) {
					e2.printStackTrace();
				}
				try {
					DateOfBirth = reservationJson.getJSONObject("profileDetails").getJSONObject("customer").getString("birthDate");
				} catch (JSONException e2) {
					e2.printStackTrace();
				}
				try {
					FirstName =  reservationJson.getJSONObject("profileDetails").getJSONObject("customer").getJSONArray("personName").getJSONObject(0).getString("givenName");
				} catch (JSONException e) {
					e.printStackTrace();
				}
				try {
					LastName = reservationJson.getJSONObject("profileDetails").getJSONObject("customer").getJSONArray("personName").getJSONObject(0).getString("surname");
				} catch (JSONException e) {
					e.printStackTrace();
				}
				
				try {
					Salutation = reservationJson.getJSONObject("profileDetails").getJSONObject("customer").getJSONArray("personName").getJSONObject(0).getString("nameTitle");
				} catch (JSONException e) {
					e.printStackTrace();
				}
				try {
					Phone = reservationJson.getJSONObject("profileDetails").getJSONObject("telephones").getJSONArray("telephoneInfo").getJSONObject(0).getJSONObject("telephone").getString("phoneNumber");	
					MembershipNumberTPM = reservationJson.getJSONObject("profileDetails").getJSONObject("telephones").getJSONArray("telephoneInfo").getJSONObject(0).getJSONObject("telephone").getString("phoneNumber");	
				} catch (JSONException e) {
					e.printStackTrace();
				}
				try {
					Email = reservationJson.getJSONObject("profileDetails").getJSONObject("emails").getJSONArray("emailInfo").getJSONObject(0).getJSONObject("email").getString("emailAddress");
				} catch (JSONException e) {
					e.printStackTrace();
				}
				//membershipNumber = null;
				JSONArray MembershipArray = null; 
				try {
					MembershipArray=reservationJson.getJSONObject("profileDetails").getJSONObject("profileMemberships").getJSONArray("profileMembership");
				} catch (JSONException e1) {
					e1.printStackTrace();
				}
				if (MembershipArray != null) {		
				    for (int i = 0; i < MembershipArray.length(); i++) {

				        String membershipid = null;
				        String membershipType = null;

				        try {
				            membershipType = MembershipArray.getJSONObject(i).getString("membershipType");
				        } catch (JSONException e1) {
				            e1.printStackTrace();
				        }

				        
				        if ("HSBC".equalsIgnoreCase(membershipType)) {
				            continue;  
				        }

				        try {
				            membershipid = MembershipArray.getJSONObject(i).getString("membershipIdNo");
				        } catch (JSONException e1) {
				            e1.printStackTrace();
				        }

				       
				        if (ResMemID.equals(membershipid)) {
				            try {
				                membershipNumber = MembershipArray.getJSONObject(i).getString("membershipId");
				                membership_Type   = membershipType;
				                membershipTier   = MembershipArray.getJSONObject(i)
				                                   .getString("membershipLevelDescription");
				            } catch (JSONException e) {
				                e.printStackTrace();
				            }
				        }

				       
				        if ("TAJ".equalsIgnoreCase(membershipType)) {

				            try {
				                TICMemberNumber = MembershipArray.getJSONObject(i)
				                                   .getString("membershipId");
				                TICmembershipTier = MembershipArray.getJSONObject(i)
				                                   .getString("membershipLevelDescription");
				            } catch (JSONException e) {
				                e.printStackTrace();
				            }

				        
				        } else if ("TCP".equalsIgnoreCase(membershipType)) {

				            try {
				                EnrollNumber_c = MembershipArray.getJSONObject(i)
				                                   .getString("membershipId");
				                TCPMemberLevel = MembershipArray.getJSONObject(i)
				                                   .getString("membershipLevelDescription");
				            } catch (JSONException e) {
				                e.printStackTrace();
				            }

				      
				        } else if ("TPM".equalsIgnoreCase(membershipType)) {

				            try {
				                TPMMemberNumber = MembershipArray.getJSONObject(i)
				                                   .getString("membershipId");
				                TPMMemberLevel  = MembershipArray.getJSONObject(i)
				                                   .getString("membershipLevelDescription");
				            } catch (JSONException e) {
				                e.printStackTrace();
				            }

				        
				        } else if ("CH".equalsIgnoreCase(membershipType)) {

				            try {
				                CHMemberNumber = MembershipArray.getJSONObject(i)
				                                   .getString("membershipId");
				                CHMemberLevel  = MembershipArray.getJSONObject(i)
				                                   .getString("membershipLevelDescription");
				            } catch (JSONException e) {
				                e.printStackTrace();
				            }

				            GravtyMemberNumber.put("CHMemberNumber", CHMemberNumber);

				            JSONObject payload = new JSONObject();
				            try {
				                payload.put("MemberType", "Chambers");
				                payload.put("chambers_id", CHMemberNumber);
				            } catch (JSONException e) {
				                e.printStackTrace();
				            }

				            fetchOutstandingBalance(payload);

				       
				        } else if ("EPI".equalsIgnoreCase(membershipType)) {

				            try {
				                EPIMemberNumber = MembershipArray.getJSONObject(i)
				                                    .getString("membershipId");
				                EPIMemberLevel  = MembershipArray.getJSONObject(i)
				                                    .getString("membershipLevelDescription");
				            } catch (JSONException e) {
				                e.printStackTrace();
				            }

				            GravtyMemberNumber.put("EPIMemberNumber", EPIMemberNumber);
				        }
				    }
				

		       }	
				postal = GetReservationData.postalCode;
				country = GetReservationData.countryCode;
				state = GetReservationData.state;
				city = GetReservationData.City;
				Address1 = GetReservationData.Address1;
				
			}
		}
		System.out.println(GetReservationData.Reservation_LoyaltyNumber);
		if(membershipNumber.equals("")||!membership_Type.equals("HSBC")) {
			
			if(!EPIMemberNumber.equals("")){		
				membershipNumber=EPIMemberNumber;
				membershipTier=EPIMemberLevel;
				membership_Type = "EPI";
				
			}else if(!CHMemberNumber.equals("")) {
				membershipNumber=CHMemberNumber;
				membershipTier=CHMemberLevel;
				membership_Type = "CH";
			}
			else if(!TICMemberNumber.equals("")) {
				membershipNumber="TICMemberNumber";
				membershipTier="TICmembershipTier";
				membership_Type = "TAJ";
			}
			else if(!TPMMemberNumber.equals("")) {
				membershipNumber=TPMMemberNumber;
				membershipTier=TPMMemberLevel;
				membership_Type = "TPM";
			}
			
			
			
			
		}
					
		NewInvoicesData data= new NewInvoicesData();
		data.CHMemberLevel=CHMemberLevel;
		data.CHMemberLevel=CHMemberLevel;
		
		System.out.println("Thread Completed");

		
		return;
		
	
		
//		SoapExecutor soapExecutor = new SoapExecutor(WSDL);
//		String responce ="";
//		if (!PMSNameCode.equals("")) {
//			JSONObject jsonObject;
//			try {
//				jsonObject = FecthprofileDataCDP(PMSNameCode);
//				System.out.println("CDP Fecth Profile Data:" +jsonObject);
//				JSONArray dataArray = jsonObject.getJSONArray("data");				
//				JSONArray firstRow = dataArray.getJSONArray(0);
//				
//				String masterCustomerId = firstRow.getString(0); // e.g. "OPERA_CLOUD_4186992"
//
//				String origSys = null;
//				String origSysRef = null;
//
//				if (masterCustomerId != null && masterCustomerId.contains("_")) {
//				    int lastUnderscoreIndex = masterCustomerId.lastIndexOf("_");
//				    origSys = masterCustomerId.substring(0, lastUnderscoreIndex);   // "OPERA_CLOUD"
//				    origSysRef = masterCustomerId.substring(lastUnderscoreIndex + 1); // "4186992"
//				}
//				if ("OPERA_CLOUD".equalsIgnoreCase(origSys)) {
//				    origSys = "CloudCentre";
//				}
//
//				System.out.println("origSys: " + origSys);
//				System.out.println("origSysRef: " + origSysRef);
//
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (JSONException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
		
			//responce = soapExecutor.executeRequest(userName, password, Action,findPersonServicePayload);
		}
	//	System.out.println("response: "+responce);
			
		
		
		
		//Document doc = soapExecutor.convertStringToDocument(responce);
		//System.out.println("Response : "+ responce);
		//NodeList nList = null;
		//try {
		     //nList = doc.getElementsByTagName("ns1:Value");	
		
	//	System.out.println("len: "+nList.getLength());
//		for(int j = 0 ; j < nList.getLength() ; j++)
//		{
//		
//			Element profileEle = (Element) (Node) nList.item(j);
//			if (profileEle == null) {
//				System.out.println("Profile Not Found in CDM");
//				
//				return; //old code
//			}
//			
//			
//			String status = soapExecutor.getValue(profileEle, "ns1:Status");
//			if(status.equals("I") || status.equals("M"))
//				continue;
//			
//			
//			@SuppressWarnings("unused")
//			Configuration configuration = new Configuration();
//			
//			
//			NodeList nListSource = profileEle.getElementsByTagName("ns1:OriginalSystemReference");
//			
//			for(int i=0; i<nListSource.getLength(); i++)
//			{
//				Element eleSource = (Element) nListSource.item(i);
//				
//				String origSys = soapExecutor.getValue(eleSource, "ns3:OrigSystem");
//				String origSysRef = soapExecutor.getValue(eleSource, "ns3:OrigSystemReference");
//				System.out.println(origSys + "\t" + origSysRef);
//				
//				String hotelSet = Configuration.hotelList.get(OWSPropertyCode);
//				String tempToCheck = null;
//				if(origSys.equals("CLOUDCENTRAL") && OWSPropertyCode !=null) tempToCheck = OWSPropertyCode;
//				
//				else tempToCheck = origSys;
//			    String tempHotelSet = Configuration.hotelList.get(tempToCheck);
//			   
//			    if(tempHotelSet !=null && origSysRef.equals(PMSNameCode) && tempHotelSet.equals(hotelSet))
//			    {
//				  origBoolean = true;
//				    break;
//			    }
//			}
//			
//			if(origBoolean == true)
//			   {
//					isProfileFound = true;
//				
//				   PartyId = soapExecutor.getValue(profileEle, "ns1:PartyId");
//				   PartyNumber = soapExecutor.getValue(profileEle, "ns1:PartyNumber");
//				   
//				    FirstName = soapExecutor.getValue(profileEle, "ns1:PersonFirstName");
//					LastName = soapExecutor.getValue(profileEle, "ns1:PersonLastName");
//					Salutation = soapExecutor.getValue(profileEle, "ns1:PersonPreNameAdjunct");
//				   
//				   System.out.println("Salutation: " + Salutation);
//			
//					if(Salutation != null && !(Salutation.equals("")))
//					{
//						String s1 = Salutation.substring(0,1);
//						String s2 = Salutation.substring(1, Salutation.length());
//						s2 = s2.toLowerCase();
//						Salutation = s1+s2;
//						System.out.println("Salutation MOD: " + Salutation);
//					}
//					
//					if(Salutation.equalsIgnoreCase("Other") || Salutation.equalsIgnoreCase("His Excellency Wali") || Salutation.equalsIgnoreCase("Her Serene Highness") || Salutation.equalsIgnoreCase("Mme.") || Salutation.equalsIgnoreCase("His Royal Highness") || Salutation.equalsIgnoreCase("Cmdr.") || Salutation.equalsIgnoreCase("Cdr.") || Salutation.equalsIgnoreCase("F/O") || Salutation.equalsIgnoreCase("Air Chief Marshal") || Salutation.equalsIgnoreCase("AVM.") || Salutation.equalsIgnoreCase("Air Cmdr.") || Salutation.equalsIgnoreCase("Sqd. Ldr."))
//						Salutation = "";
//					
//					Gender = soapExecutor.getValue(profileEle, "ns1:Gender");
//					if(Gender!=null && Gender.equals("MALE"))
//						Gender = "Male";
//					else if(Gender!=null && Gender.equals("FEMALE"))
//						Gender= "Female";
//					else if(Gender.equalsIgnoreCase("unknown"))
//						Gender = "";
//					
//					System.out.println("Gender: " + Gender);
//					
//					NodeList nListEmail = profileEle.getElementsByTagName("ns1:Email");
//					for(int i=0; i<nListEmail.getLength(); i++)
//					{
//						Element eleEmail = (Element) nListEmail.item(i);
//						String isActive = soapExecutor.getValue(eleEmail, "ns5:Status");
//						String isPrimary = soapExecutor.getValue(eleEmail, "ns5:PrimaryFlag");
//						
//						if(isActive.equalsIgnoreCase("A") && isPrimary.equalsIgnoreCase("true"))
//						{
//							Email = soapExecutor.getValue(eleEmail, "ns5:EmailAddress");
//							System.out.println("Email: "+Email);
//							System.out.println("Email Type: " + soapExecutor.getValue(eleEmail, "ns5:ContactPointPurpose"));
//							System.out.println("Email ID: " + soapExecutor.getValue(eleEmail, "ns5:ContactPointId"));
//						}
//					}
//					
//					NodeList nListPhone = profileEle.getElementsByTagName("ns1:Phone");
//					for(int i=0; i<nListPhone.getLength(); i++)
//					{
//						Element elePhone = (Element) nListPhone.item(i);
//						String isActive = soapExecutor.getValue(elePhone, "ns5:Status");
//						String isPrimary = soapExecutor.getValue(elePhone, "ns5:PrimaryFlag");
//						
//						if(isActive.equalsIgnoreCase("A") && isPrimary.equalsIgnoreCase("true"))
//						{
//							Phone = soapExecutor.getValue(elePhone, "ns5:PhoneNumber");
//							System.out.println("Phone: " + Phone);
//							System.out.println("Phone Type: " + soapExecutor.getValue(elePhone, "ns5:PhoneLineType"));
//							System.out.println("Phone ID: " + soapExecutor.getValue(elePhone, "ns5:ContactPointId"));
//						}
//						
//					}
//					
//					try
//					 {
//					
//						NodeList nodeList = ((Element) doc.getElementsByTagName("ns1:Value").item(j)).getElementsByTagName("ns1:LoyaltyMembershipsCollection_c");
//						System.out.println("length of cdm memberships: "+nodeList.getLength());
//						for(int i=0; i<nodeList.getLength(); i++)
//						{
//							Element ele = (Element) nodeList.item(i);
//							String Inactive = ele.getElementsByTagName("ns1:InactiveNew_c").item(0).getTextContent()+"";
//							if(!Inactive.equalsIgnoreCase("true"))
//							{
//								MembershipType = ele.getElementsByTagName("ns1:MembershipTypeLOV_c").item(0).getTextContent();								
//								//if(MembershipType.equalsIgnoreCase("TIC") || MembershipType.equalsIgnoreCase("Taj InnerCircle") || MembershipType.equalsIgnoreCase("TAJ"))
//									if(MembershipType.equalsIgnoreCase("TCP"))
//									{
//									EnrollNumber_c = ele.getElementsByTagName("ns1:MembershipCardNo_c").item(0).getTextContent();									
//									System.out.println("EnrollNumber_c: "+EnrollNumber_c);
//									if(EnrollNumber_c.equals(Reservation_LoyaltyNumber)) {
//										membershipNumber=EnrollNumber_c;
//										membershipTier=ele.getElementsByTagName("ns1:MembershipLevelLOV_c").item(0).getTextContent();
//										membership_Type = MembershipType;
//									}							
//									}
//									else if(MembershipType.equalsIgnoreCase("TPM"))
//									{
//										TPMMemberNumber = ele.getElementsByTagName("ns1:MembershipCardNo_c").item(0).getTextContent();
//										System.out.println("TPMMemberNumber: "+TPMMemberNumber);
//										if(TPMMemberNumber.equals(Reservation_LoyaltyNumber)) {
//											membershipNumber=TPMMemberNumber;
//											membershipTier=ele.getElementsByTagName("ns1:MembershipLevelLOV_c").item(0).getTextContent();
//											membership_Type = MembershipType;
//											
//										}
//									}
//									else if(MembershipType.equalsIgnoreCase("TAJ"))
//									{
//										TICMemberNumber= ele.getElementsByTagName("ns1:MembershipCardNo_c").item(0).getTextContent();
//										TICmembershipTier=ele.getElementsByTagName("ns1:MembershipLevelLOV_c").item(0).getTextContent();
//										System.out.println("TICMemberNumber: "+TICMemberNumber);
//										if(TICMemberNumber.equals(Reservation_LoyaltyNumber)) {
//											membershipNumber=TICMemberNumber;
//											membershipTier=ele.getElementsByTagName("ns1:MembershipLevelLOV_c").item(0).getTextContent();
//											membership_Type = MembershipType;
//										}
//									}
//									else if (MembershipType.equalsIgnoreCase("CH")) {
//									    CHMemberNumber = ele.getElementsByTagName("ns1:MembershipCardNo_c").item(0).getTextContent();
//									    CHMemberLevel = ele.getElementsByTagName("ns1:MembershipLevelLOV_c").item(0).getTextContent();
//
//									    if (CHMemberNumber.equals(Reservation_LoyaltyNumber)) {
//									        membershipNumber = CHMemberNumber;
//									        membershipTier = ele.getElementsByTagName("ns1:MembershipLevelLOV_c").item(0).getTextContent();
//									        membership_Type = MembershipType;
//									    }
//
//									    //  Build payload
//									    JSONObject payload = new JSONObject();
//									    payload.put("MemberType", "Chambers");
//									    payload.put("chambers_id", 3456);
//
//									    // ✅ Call new method
//									    fetchOutstandingBalance(payload);
//
//									    
//									}
//									else if(MembershipType.equalsIgnoreCase("EPI"))
//									{
//										EPIMemberNumber= ele.getElementsByTagName("ns1:MembershipCardNo_c").item(0).getTextContent();
//										EPIMemberLevel= ele.getElementsByTagName("ns1:MembershipLevelLOV_c").item(0).getTextContent();
//										System.out.println("EPIMemberNumber: "+EPIMemberNumber);
//										if(EPIMemberNumber.equals(Reservation_LoyaltyNumber)) {
//											membershipNumber=EPIMemberNumber;
//											membershipTier=ele.getElementsByTagName("ns1:MembershipLevelLOV_c").item(0).getTextContent();										
//											membership_Type = MembershipType;
//										}
//									}
//									
//									GravtyMemberNumber.put("CHMemberNumber",CHMemberNumber);
//									GravtyMemberNumber.put("EPIMemberNumber",EPIMemberNumber);//adee this in new code
//									
//								/*	JSONObject o = new JSONObject();
//									o.put("EnrollNumber_c", EnrollNumber_c);
//									o.put("TPMMemberNumber", TPMMemberNumber);
//									o.put("TICMemberNumber", TICMemberNumber);
//									o.put("CHMemberNumber", CHMemberNumber);
//									o.put("EPIMemberNumber", EPIMemberNumber);
//										
//									MembershipDetailsArray.put(o);
//								*/	
//							}
//						}
//					 } catch(Exception e)
//					 {
//						 e.printStackTrace();
//					 }
//					 
////					 DateOfBirth = soapExecutor.getValue(profileEle, "ns1:DateOfBirth");
////			
////					//parsing the address from the root element
////					Address1 = soapExecutor.getValue(profileEle, "ns1:Address1");
////					Address2 = soapExecutor.getValue(profileEle, "ns1:Address2");
////					Address3 = soapExecutor.getValue(profileEle, "ns1:Address3");
////					Address4 = soapExecutor.getValue(profileEle, "ns1:Address4");
////					city = soapExecutor.getValue(profileEle, "ns1:City");
////					state = soapExecutor.getValue(profileEle, "ns1:State");
////					country = soapExecutor.getValue(profileEle, "ns1:Country");
////					postal = soapExecutor.getValue(profileEle, "ns1:PostalCode");
//				   
//					break;
//					
//			   } else 
//			   {
//			   		System.out.println("Profile not found");
//			   }
//			
//			
//		
//		}
//	}
//	catch(Exception e) {
//		e.printStackTrace();
//	}
		//if(nList.getLength()== 0) {
		
	public boolean isValidFinalData(Map<String, Object> finalData) {
	    return finalData != null
	        && finalData.containsKey("personalDetails")
	        && finalData.containsKey("membershipDetails")
	        && !((Map<?, ?>) finalData.get("personalDetails")).isEmpty()
	        && !((List<?>) finalData.get("membershipDetails")).isEmpty();
	}
	
	private JSONObject FecthprofileDataCDP(String PMSCODE) throws IOException, JSONException {
		JSONObject jsonObjectReturn = new JSONObject();
		String payload= "{\r\n" + 
				"    \"MCPSQuery\": {\r\n" + 
				"        \"name\": \"TEST 1234\",\r\n" + 
				"        \"operation\": {\r\n" + 
				"            \"ctype\": \".SetOperation\",\r\n" + 
				"            \"name\": \"MasterCustomer\",\r\n" + 
				"            \"operator\": \"INTERSECTION\",\r\n" + 
				"            \"tenantId\": \"100074\",\r\n" + 
				"            \"distinct\": true,\r\n" + 
				"            \"operands\": [\r\n" + 
				"                {\r\n" + 
				"                    \"ctype\": \".ObjectSet\",\r\n" + 
				"                    \"name\": \"M4\",\r\n" + 
				"                    \"operand\": {\r\n" + 
				"                        \"ctype\": \".ObjectSet\",\r\n" + 
				"                        \"name\": \"M0\",\r\n" + 
				"                        \"distinct\": false,\r\n" + 
				"                        \"objectName\": \"MasterCustomer\",\r\n" + 
				"                        \"objectJoin\": {\r\n" + 
				"                            \"type\": \"LEFT\",\r\n" + 
				"                            \"targetSet\": {\r\n" + 
				"                                \"ctype\": \".ObjectSet\",\r\n" + 
				"                                \"name\": \"C0\",\r\n" + 
				"                                \"distinct\": true,\r\n" + 
				"                                \"objectName\": \"Customer_MasterCustomer\",\r\n" + 
				"                                \"objectJoin\": {\r\n" + 
				"                                    \"type\": \"LEFT\",\r\n" + 
				"                                    \"targetSet\": {\r\n" + 
				"                                        \"ctype\": \".ObjectSet\",\r\n" + 
				"                                        \"name\": \"C1\",\r\n" + 
				"                                        \"distinct\": false,\r\n" + 
				"                                        \"objectName\": \"Customer\",\r\n" + 
				"                                        \"objectJoin\": {\r\n" + 
				"                                            \"type\": \"LEFT_OUTER\",\r\n" + 
				"                                            \"targetSet\": {\r\n" + 
				"                                                \"ctype\": \".ObjectSet\",\r\n" + 
				"                                                \"name\": \"L0\",\r\n" + 
				"                                                \"distinct\": true,\r\n" + 
				"                                                \"objectName\": \"Loyalty_Memberships\",\r\n" + 
				"                                                \"outputAttributes\": [\r\n" + 
				"                                                    {\r\n" + 
				"                                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                        \"attributeName\": \"CustomerID\",\r\n" + 
				"                                                        \"tableName\": \"L0\",\r\n" + 
				"                                                        \"alias\": \"Loyalty_Memberships_CustomerID\"\r\n" + 
				"                                                    },\r\n" + 
				"                                                    {\r\n" + 
				"                                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                        \"attributeName\": \"MembershipCardNo\",\r\n" + 
				"                                                        \"tableName\": \"L0\",\r\n" + 
				"                                                        \"alias\": \"Loyalty_Memberships_MembershipCardNo\"\r\n" + 
				"                                                    },\r\n" + 
				"                                                    {\r\n" + 
				"                                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                        \"attributeName\": \"MemberSince\",\r\n" + 
				"                                                        \"tableName\": \"L0\",\r\n" + 
				"                                                        \"alias\": \"Loyalty_Memberships_MemberSince\"\r\n" + 
				"                                                    },\r\n" + 
				"                                                    {\r\n" + 
				"                                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                        \"attributeName\": \"MembershipExpiration\",\r\n" + 
				"                                                        \"tableName\": \"L0\",\r\n" + 
				"                                                        \"alias\": \"Loyalty_Memberships_MembershipExpiration\"\r\n" + 
				"                                                    },\r\n" + 
				"                                                    {\r\n" + 
				"                                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                        \"attributeName\": \"MembershipLevel\",\r\n" + 
				"                                                        \"tableName\": \"L0\",\r\n" + 
				"                                                        \"alias\": \"Loyalty_Memberships_MembershipLevel\"\r\n" + 
				"                                                    },\r\n" + 
				"                                                    {\r\n" + 
				"                                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                        \"attributeName\": \"MembershipStage\",\r\n" + 
				"                                                        \"tableName\": \"L0\",\r\n" + 
				"                                                        \"alias\": \"Loyalty_Memberships_MembershipStage\"\r\n" + 
				"                                                    },\r\n" + 
				"                                                    {\r\n" + 
				"                                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                        \"attributeName\": \"NameOnCard\",\r\n" + 
				"                                                        \"tableName\": \"L0\",\r\n" + 
				"                                                        \"alias\": \"Loyalty_Memberships_NameOnCard\"\r\n" + 
				"                                                    },\r\n" + 
				"                                                    {\r\n" + 
				"                                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                        \"attributeName\": \"MembershipType\",\r\n" + 
				"                                                        \"tableName\": \"L0\",\r\n" + 
				"                                                        \"alias\": \"Loyalty_MembershipType\"\r\n" + 
				"                                                    }\r\n" + 
				"                                                ]\r\n" + 
				"                                            },\r\n" + 
				"                                            \"condition\": [\r\n" + 
				"                                                {\r\n" + 
				"                                                    \"left\": {\r\n" + 
				"                                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                        \"attributeName\": \"ID\",\r\n" + 
				"                                                        \"tableName\": \"C1\",\r\n" + 
				"                                                        \"alias\": \"ID\"\r\n" + 
				"                                                    },\r\n" + 
				"                                                    \"right\": {\r\n" + 
				"                                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                        \"attributeName\": \"Loyalty_Memberships_CustomerID\",\r\n" + 
				"                                                        \"tableName\": \"L0\",\r\n" + 
				"                                                        \"alias\": \"Loyalty_Memberships_CustomerID\"\r\n" + 
				"                                                    }\r\n" + 
				"                                                }\r\n" + 
				"                                            ]\r\n" + 
				"                                        },\r\n" + 
				"                                        \"outputAttributes\": [\r\n" + 
				"                                            {\r\n" + 
				"                                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                \"attributeName\": \"ID\",\r\n" + 
				"                                                \"tableName\": \"C1\",\r\n" + 
				"                                                \"alias\": \"Customer_ID\"\r\n" + 
				"                                            },\r\n" + 
				"                                            {\r\n" + 
				"                                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                \"attributeName\": \"Loyalty_Memberships_MembershipCardNo\",\r\n" + 
				"                                                \"tableName\": \"L0\",\r\n" + 
				"                                                \"alias\": \"Loyalty_Memberships_MembershipCardNo\"\r\n" + 
				"                                            },\r\n" + 
				"                                            {\r\n" + 
				"                                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                \"attributeName\": \"Loyalty_Memberships_MemberSince\",\r\n" + 
				"                                                \"tableName\": \"L0\",\r\n" + 
				"                                                \"alias\": \"Loyalty_Memberships_MemberSince\"\r\n" + 
				"                                            },\r\n" + 
				"                                            {\r\n" + 
				"                                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                \"attributeName\": \"Loyalty_Memberships_MembershipExpiration\",\r\n" + 
				"                                                \"tableName\": \"L0\",\r\n" + 
				"                                                \"alias\": \"Loyalty_Memberships_MembershipExpiration\"\r\n" + 
				"                                            },\r\n" + 
				"                                            {\r\n" + 
				"                                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                \"attributeName\": \"Loyalty_Memberships_MembershipLevel\",\r\n" + 
				"                                                \"tableName\": \"L0\",\r\n" + 
				"                                                \"alias\": \"Loyalty_Memberships_MembershipLevel\"\r\n" + 
				"                                            },\r\n" + 
				"                                            {\r\n" + 
				"                                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                \"attributeName\": \"Loyalty_Memberships_MembershipStage\",\r\n" + 
				"                                                \"tableName\": \"L0\",\r\n" + 
				"                                                \"alias\": \"Loyalty_Memberships_MembershipStage\"\r\n" + 
				"                                            },\r\n" + 
				"                                            {\r\n" + 
				"                                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                \"attributeName\": \"Loyalty_Memberships_NameOnCard\",\r\n" + 
				"                                                \"tableName\": \"L0\",\r\n" + 
				"                                                \"alias\": \"Loyalty_Memberships_NameOnCard\"\r\n" + 
				"                                            },\r\n" + 
				"                                            {\r\n" + 
				"                                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                \"attributeName\": \"Loyalty_MembershipType\",\r\n" + 
				"                                                \"tableName\": \"L0\",\r\n" + 
				"                                                \"alias\": \"Loyalty_MembershipType\"\r\n" + 
				"                                            },\r\n" + 
				"                                            {\r\n" + 
				"                                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                \"attributeName\": \"SourceID\",\r\n" + 
				"                                                \"tableName\": \"C1\",\r\n" + 
				"                                                \"alias\": \"Customer_SourceID\"\r\n" + 
				"                                            },\r\n" + 
				"                                            {\r\n" + 
				"                                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                \"attributeName\": \"SourceCustomerID\",\r\n" + 
				"                                                \"tableName\": \"C1\",\r\n" + 
				"                                                \"alias\": \"Customer_SourceCustomerID\"\r\n" + 
				"                                            },\r\n" + 
				"                                            {\r\n" + 
				"                                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                \"attributeName\": \"FirstName\",\r\n" + 
				"                                                \"tableName\": \"C1\",\r\n" + 
				"                                                \"alias\": \"Customer_FirstName\"\r\n" + 
				"                                            },\r\n" + 
				"                                            {\r\n" + 
				"                                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                \"attributeName\": \"LastName\",\r\n" + 
				"                                                \"tableName\": \"C1\",\r\n" + 
				"                                                \"alias\": \"Customer_LastName\"\r\n" + 
				"                                            },\r\n" + 
				"                                            {\r\n" + 
				"                                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                \"attributeName\": \"Email\",\r\n" + 
				"                                                \"tableName\": \"C1\",\r\n" + 
				"                                                \"alias\": \"Customer_Email\"\r\n" + 
				"                                            },\r\n" + 
				"                                            {\r\n" + 
				"                                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                \"attributeName\": \"Phone\",\r\n" + 
				"                                                \"tableName\": \"C1\",\r\n" + 
				"                                                \"alias\": \"Customer_Phone\"\r\n" + 
				"                                            }\r\n" + 
				"                                        ]\r\n" + 
				"                                    },\r\n" + 
				"                                    \"condition\": [\r\n" + 
				"                                        {\r\n" + 
				"                                            \"left\": {\r\n" + 
				"                                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                \"attributeName\": \"CustomerID\",\r\n" + 
				"                                                \"tableName\": \"C0\",\r\n" + 
				"                                                \"alias\": \"CustomerID\"\r\n" + 
				"                                            },\r\n" + 
				"                                            \"right\": {\r\n" + 
				"                                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                \"attributeName\": \"Customer_ID\",\r\n" + 
				"                                                \"tableName\": \"C1\",\r\n" + 
				"                                                \"alias\": \"Customer_ID\"\r\n" + 
				"                                            }\r\n" + 
				"                                        }\r\n" + 
				"                                    ]\r\n" + 
				"                                },\r\n" + 
				"                                \"outputAttributes\": [\r\n" + 
				"                                    {\r\n" + 
				"                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                        \"attributeName\": \"MasterCustomerID\",\r\n" + 
				"                                        \"tableName\": \"C0\",\r\n" + 
				"                                        \"alias\": \"Customer_MasterCustomer_MasterCustomerID\"\r\n" + 
				"                                    },\r\n" + 
				"                                    {\r\n" + 
				"                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                        \"attributeName\": \"Customer_ID\",\r\n" + 
				"                                        \"tableName\": \"C1\",\r\n" + 
				"                                        \"alias\": \"Customer_ID\"\r\n" + 
				"                                    },\r\n" + 
				"                                    {\r\n" + 
				"                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                        \"attributeName\": \"Loyalty_Memberships_MembershipCardNo\",\r\n" + 
				"                                        \"tableName\": \"C1\",\r\n" + 
				"                                        \"alias\": \"Loyalty_Memberships_MembershipCardNo\"\r\n" + 
				"                                    },\r\n" + 
				"                                    {\r\n" + 
				"                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                        \"attributeName\": \"Loyalty_Memberships_MemberSince\",\r\n" + 
				"                                        \"tableName\": \"C1\",\r\n" + 
				"                                        \"alias\": \"Loyalty_Memberships_MemberSince\"\r\n" + 
				"                                    },\r\n" + 
				"                                    {\r\n" + 
				"                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                        \"attributeName\": \"Loyalty_Memberships_MembershipExpiration\",\r\n" + 
				"                                        \"tableName\": \"C1\",\r\n" + 
				"                                        \"alias\": \"Loyalty_Memberships_MembershipExpiration\"\r\n" + 
				"                                    },\r\n" + 
				"                                    {\r\n" + 
				"                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                        \"attributeName\": \"Loyalty_Memberships_MembershipLevel\",\r\n" + 
				"                                        \"tableName\": \"C1\",\r\n" + 
				"                                        \"alias\": \"Loyalty_Memberships_MembershipLevel\"\r\n" + 
				"                                    },\r\n" + 
				"                                    {\r\n" + 
				"                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                        \"attributeName\": \"Loyalty_Memberships_MembershipStage\",\r\n" + 
				"                                        \"tableName\": \"C1\",\r\n" + 
				"                                        \"alias\": \"Loyalty_Memberships_MembershipStage\"\r\n" + 
				"                                    },\r\n" + 
				"                                    {\r\n" + 
				"                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                        \"attributeName\": \"Loyalty_Memberships_NameOnCard\",\r\n" + 
				"                                        \"tableName\": \"C1\",\r\n" + 
				"                                        \"alias\": \"Loyalty_Memberships_NameOnCard\"\r\n" + 
				"                                    },\r\n" + 
				"                                    {\r\n" + 
				"                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                        \"attributeName\": \"Loyalty_MembershipType\",\r\n" + 
				"                                        \"tableName\": \"C1\",\r\n" + 
				"                                        \"alias\": \"Loyalty_MembershipType\"\r\n" + 
				"                                    },\r\n" + 
				"                                    {\r\n" + 
				"                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                        \"attributeName\": \"Customer_SourceID\",\r\n" + 
				"                                        \"tableName\": \"C1\",\r\n" + 
				"                                        \"alias\": \"Customer_SourceID\"\r\n" + 
				"                                    },\r\n" + 
				"                                    {\r\n" + 
				"                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                        \"attributeName\": \"Customer_SourceCustomerID\",\r\n" + 
				"                                        \"tableName\": \"C1\",\r\n" + 
				"                                        \"alias\": \"Customer_SourceCustomerID\"\r\n" + 
				"                                    },\r\n" + 
				"                                    {\r\n" + 
				"                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                        \"attributeName\": \"Customer_FirstName\",\r\n" + 
				"                                        \"tableName\": \"C1\",\r\n" + 
				"                                        \"alias\": \"Customer_FirstName\"\r\n" + 
				"                                    },\r\n" + 
				"                                    {\r\n" + 
				"                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                        \"attributeName\": \"Customer_LastName\",\r\n" + 
				"                                        \"tableName\": \"C1\",\r\n" + 
				"                                        \"alias\": \"Customer_LastName\"\r\n" + 
				"                                    },\r\n" + 
				"                                    {\r\n" + 
				"                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                        \"attributeName\": \"Customer_Email\",\r\n" + 
				"                                        \"tableName\": \"C1\",\r\n" + 
				"                                        \"alias\": \"Customer_Email\"\r\n" + 
				"                                    },\r\n" + 
				"                                    {\r\n" + 
				"                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                        \"attributeName\": \"Customer_Phone\",\r\n" + 
				"                                        \"tableName\": \"C1\",\r\n" + 
				"                                        \"alias\": \"Customer_Phone\"\r\n" + 
				"                                    }\r\n" + 
				"                                ]\r\n" + 
				"                            },\r\n" + 
				"                            \"condition\": [\r\n" + 
				"                                {\r\n" + 
				"                                    \"left\": {\r\n" + 
				"                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                        \"attributeName\": \"ID\",\r\n" + 
				"                                        \"tableName\": \"M0\",\r\n" + 
				"                                        \"alias\": \"ID\"\r\n" + 
				"                                    },\r\n" + 
				"                                    \"right\": {\r\n" + 
				"                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                        \"attributeName\": \"Customer_MasterCustomer_MasterCustomerID\",\r\n" + 
				"                                        \"tableName\": \"C0\",\r\n" + 
				"                                        \"alias\": \"Customer_MasterCustomer_MasterCustomerID\"\r\n" + 
				"                                    }\r\n" + 
				"                                }\r\n" + 
				"                            ]\r\n" + 
				"                        },\r\n" + 
				"                        \"outputAttributes\": [\r\n" + 
				"                            {\r\n" + 
				"                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                \"attributeName\": \"Customer_ID\",\r\n" + 
				"                                \"tableName\": \"C0\",\r\n" + 
				"                                \"alias\": \"Customer_ID\"\r\n" + 
				"                            },\r\n" + 
				"                            {\r\n" + 
				"                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                \"attributeName\": \"Loyalty_Memberships_MembershipCardNo\",\r\n" + 
				"                                \"tableName\": \"C0\",\r\n" + 
				"                                \"alias\": \"Loyalty_Memberships_MembershipCardNo\"\r\n" + 
				"                            },\r\n" + 
				"                            {\r\n" + 
				"                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                \"attributeName\": \"Loyalty_Memberships_MemberSince\",\r\n" + 
				"                                \"tableName\": \"C0\",\r\n" + 
				"                                \"alias\": \"Loyalty_Memberships_MemberSince\"\r\n" + 
				"                            },\r\n" + 
				"                            {\r\n" + 
				"                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                \"attributeName\": \"Loyalty_Memberships_MembershipExpiration\",\r\n" + 
				"                                \"tableName\": \"C0\",\r\n" + 
				"                                \"alias\": \"Loyalty_Memberships_MembershipExpiration\"\r\n" + 
				"                            },\r\n" + 
				"                            {\r\n" + 
				"                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                \"attributeName\": \"Loyalty_Memberships_MembershipLevel\",\r\n" + 
				"                                \"tableName\": \"C0\",\r\n" + 
				"                                \"alias\": \"Loyalty_Memberships_MembershipLevel\"\r\n" + 
				"                            },\r\n" + 
				"                            {\r\n" + 
				"                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                \"attributeName\": \"Loyalty_Memberships_MembershipStage\",\r\n" + 
				"                                \"tableName\": \"C0\",\r\n" + 
				"                                \"alias\": \"Loyalty_Memberships_MembershipStage\"\r\n" + 
				"                            },\r\n" + 
				"                            {\r\n" + 
				"                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                \"attributeName\": \"Loyalty_Memberships_NameOnCard\",\r\n" + 
				"                                \"tableName\": \"C0\",\r\n" + 
				"                                \"alias\": \"Loyalty_Memberships_NameOnCard\"\r\n" + 
				"                            },\r\n" + 
				"                            {\r\n" + 
				"                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                \"attributeName\": \"Loyalty_MembershipType\",\r\n" + 
				"                                \"tableName\": \"C0\",\r\n" + 
				"                                \"alias\": \"Loyalty_MembershipType\"\r\n" + 
				"                            },\r\n" + 
				"                            {\r\n" + 
				"                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                \"attributeName\": \"Customer_SourceID\",\r\n" + 
				"                                \"tableName\": \"C0\",\r\n" + 
				"                                \"alias\": \"Customer_SourceID\"\r\n" + 
				"                            },\r\n" + 
				"                            {\r\n" + 
				"                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                \"attributeName\": \"Customer_SourceCustomerID\",\r\n" + 
				"                                \"tableName\": \"C0\",\r\n" + 
				"                                \"alias\": \"Customer_SourceCustomerID\"\r\n" + 
				"                            },\r\n" + 
				"                            {\r\n" + 
				"                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                \"attributeName\": \"Customer_FirstName\",\r\n" + 
				"                                \"tableName\": \"C0\",\r\n" + 
				"                                \"alias\": \"Customer_FirstName\"\r\n" + 
				"                            },\r\n" + 
				"                            {\r\n" + 
				"                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                \"attributeName\": \"Customer_LastName\",\r\n" + 
				"                                \"tableName\": \"C0\",\r\n" + 
				"                                \"alias\": \"Customer_LastName\"\r\n" + 
				"                            },\r\n" + 
				"                            {\r\n" + 
				"                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                \"attributeName\": \"Customer_Email\",\r\n" + 
				"                                \"tableName\": \"C0\",\r\n" + 
				"                                \"alias\": \"Customer_Email\"\r\n" + 
				"                            },\r\n" + 
				"                            {\r\n" + 
				"                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                \"attributeName\": \"Customer_Phone\",\r\n" + 
				"                                \"tableName\": \"C0\",\r\n" + 
				"                                \"alias\": \"Customer_Phone\"\r\n" + 
				"                            },\r\n" + 
				"                            {\r\n" + 
				"                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                \"attributeName\": \"ID\",\r\n" + 
				"                                \"tableName\": \"M0\",\r\n" + 
				"                                \"alias\": \"MasterCustomer_ID\"\r\n" + 
				"                            },\r\n" + 
				"                            {\r\n" + 
				"                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                \"attributeName\": \"FirstName\",\r\n" + 
				"                                \"tableName\": \"M0\",\r\n" + 
				"                                \"alias\": \"MasterCustomer_FirstName\"\r\n" + 
				"                            },\r\n" + 
				"                            {\r\n" + 
				"                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                \"attributeName\": \"LastName\",\r\n" + 
				"                                \"tableName\": \"M0\",\r\n" + 
				"                                \"alias\": \"MasterCustomer_LastName\"\r\n" + 
				"                            },\r\n" + 
				"                            {\r\n" + 
				"                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                \"attributeName\": \"Mobile_Country_Code\",\r\n" + 
				"                                \"tableName\": \"M0\",\r\n" + 
				"                                \"alias\": \"MasterCustomer_MobileCountryCode\"\r\n" + 
				"                            },\r\n" + 
				"                            {\r\n" + 
				"                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                \"attributeName\": \"Phone\",\r\n" + 
				"                                \"tableName\": \"M0\",\r\n" + 
				"                                \"alias\": \"MasterCustomer_Phone\"\r\n" + 
				"                            },\r\n" + 
				"                            {\r\n" + 
				"                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                \"attributeName\": \"Email\",\r\n" + 
				"                                \"tableName\": \"M0\",\r\n" + 
				"                                \"alias\": \"MasterCustomer_Email\"\r\n" + 
				"                            },\r\n" + 
				"                            {\r\n" + 
				"                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                \"attributeName\": \"Cashlisted\",\r\n" + 
				"                                \"tableName\": \"M0\",\r\n" + 
				"                                \"alias\": \"MasterCustomer_Cashlisted\"\r\n" + 
				"                            },\r\n" + 
				"                            {\r\n" + 
				"                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                \"attributeName\": \"Restricted\",\r\n" + 
				"                                \"tableName\": \"M0\",\r\n" + 
				"                                \"alias\": \"MasterCustomer_Restricted\"\r\n" + 
				"                            },\r\n" + 
				"                            {\r\n" + 
				"                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                \"attributeName\": \"BirthDate\",\r\n" + 
				"                                \"tableName\": \"M0\",\r\n" + 
				"                                \"alias\": \"MasterCustomer_BirthDate\"\r\n" + 
				"                            },\r\n" + 
				"                            {\r\n" + 
				"                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                \"attributeName\": \"AddressLine1\",\r\n" + 
				"                                \"tableName\": \"M0\",\r\n" + 
				"                                \"alias\": \"MasterCustomer_AddressLine1\"\r\n" + 
				"                            },\r\n" + 
				"                            {\r\n" + 
				"                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                \"attributeName\": \"AddressLine2\",\r\n" + 
				"                                \"tableName\": \"M0\",\r\n" + 
				"                                \"alias\": \"MasterCustomer_AddressLine2\"\r\n" + 
				"                            },\r\n" + 
				"                            {\r\n" + 
				"                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                \"attributeName\": \"City\",\r\n" + 
				"                                \"tableName\": \"M0\",\r\n" + 
				"                                \"alias\": \"MasterCustomer_City\"\r\n" + 
				"                            },\r\n" + 
				"                            {\r\n" + 
				"                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                \"attributeName\": \"Country\",\r\n" + 
				"                                \"tableName\": \"M0\",\r\n" + 
				"                                \"alias\": \"MasterCustomer_Country\"\r\n" + 
				"                            },\r\n" + 
				"                            {\r\n" + 
				"                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                \"attributeName\": \"ZipCode\",\r\n" + 
				"                                \"tableName\": \"M0\",\r\n" + 
				"                                \"alias\": \"MasterCustomer_ZipCode\"\r\n" + 
				"                            },\r\n" + 
				"                            {\r\n" + 
				"                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                \"attributeName\": \"State\",\r\n" + 
				"                                \"tableName\": \"M0\",\r\n" + 
				"                                \"alias\": \"MasterCustomer_State\"\r\n" + 
				"                            },\r\n" + 
				"                            {\r\n" + 
				"                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                \"attributeName\": \"CountryCode_ISOAlpha2\",\r\n" + 
				"                                \"tableName\": \"M0\",\r\n" + 
				"                                \"alias\": \"MasterCustomer_CountryCode_ISOAlpha2\"\r\n" + 
				"                            },\r\n" + 
				"                            {\r\n" + 
				"                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                \"attributeName\": \"Gender\",\r\n" + 
				"                                \"tableName\": \"M0\",\r\n" + 
				"                                \"alias\": \"MasterCustomer_Gender\"\r\n" + 
				"                            },\r\n" + 
				"                            {\r\n" + 
				"                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                \"attributeName\": \"MartialStatus\",\r\n" + 
				"                                \"tableName\": \"M0\",\r\n" + 
				"                                \"alias\": \"MasterCustomer_MartialStatus\"\r\n" + 
				"                            },\r\n" + 
				"                            {\r\n" + 
				"                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                \"attributeName\": \"Prefix\",\r\n" + 
				"                                \"tableName\": \"M0\",\r\n" + 
				"                                \"alias\": \"MasterCustomer_Prefix\"\r\n" + 
				"                            },\r\n" + 
				"                            {\r\n" + 
				"                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                \"attributeName\": \"Email_Validation_Status\",\r\n" + 
				"                                \"tableName\": \"M0\",\r\n" + 
				"                                \"alias\": \"MasterCustomer_Email_Validation_Status\"\r\n" + 
				"                            }\r\n" + 
				"                        ]\r\n" + 
				"                    },\r\n" + 
				"                    \"objectJoin\": {\r\n" + 
				"                        \"type\": \"LEFT\",\r\n" + 
				"                        \"targetSet\": {\r\n" + 
				"                            \"ctype\": \".ObjectSet\",\r\n" + 
				"                            \"name\": \"M3\",\r\n" + 
				"                            \"operand\": {\r\n" + 
				"                                \"ctype\": \".ObjectSet\",\r\n" + 
				"                                \"name\": \"M1\",\r\n" + 
				"                                \"distinct\": false,\r\n" + 
				"                                \"objectName\": \"MasterCustomer\",\r\n" + 
				"                                \"objectJoin\": {\r\n" + 
				"                                    \"type\": \"LEFT\",\r\n" + 
				"                                    \"targetSet\": {\r\n" + 
				"                                        \"ctype\": \".ObjectSet\",\r\n" + 
				"                                        \"name\": \"C2\",\r\n" + 
				"                                        \"distinct\": true,\r\n" + 
				"                                        \"objectName\": \"Customer_MasterCustomer\",\r\n" + 
				"                                        \"objectJoin\": {\r\n" + 
				"                                            \"type\": \"LEFT\",\r\n" + 
				"                                            \"targetSet\": {\r\n" + 
				"                                                \"ctype\": \".ObjectSet\",\r\n" + 
				"                                                \"name\": \"C3\",\r\n" + 
				"                                                \"distinct\": false,\r\n" + 
				"                                                \"objectName\": \"Customer\",\r\n" + 
				"                                                \"objectJoin\": {\r\n" + 
				"                                                    \"type\": \"LEFT_OUTER\",\r\n" + 
				"                                                    \"targetSet\": {\r\n" + 
				"                                                        \"ctype\": \".ObjectSet\",\r\n" + 
				"                                                        \"name\": \"L1\",\r\n" + 
				"                                                        \"distinct\": true,\r\n" + 
				"                                                        \"objectName\": \"Loyalty_Memberships\",\r\n" + 
				"                                                        \"outputAttributes\": [\r\n" + 
				"                                                            {\r\n" + 
				"                                                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                                \"attributeName\": \"CustomerID\",\r\n" + 
				"                                                                \"tableName\": \"L1\",\r\n" + 
				"                                                                \"alias\": \"Loyalty_Memberships_CustomerID\"\r\n" + 
				"                                                            },\r\n" + 
				"                                                            {\r\n" + 
				"                                                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                                \"attributeName\": \"MembershipCardNo\",\r\n" + 
				"                                                                \"tableName\": \"L1\",\r\n" + 
				"                                                                \"alias\": \"Loyalty_Memberships_MembershipCardNo\"\r\n" + 
				"                                                            },\r\n" + 
				"                                                            {\r\n" + 
				"                                                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                                \"attributeName\": \"MemberSince\",\r\n" + 
				"                                                                \"tableName\": \"L1\",\r\n" + 
				"                                                                \"alias\": \"Loyalty_Memberships_MemberSince\"\r\n" + 
				"                                                            },\r\n" + 
				"                                                            {\r\n" + 
				"                                                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                                \"attributeName\": \"MembershipExpiration\",\r\n" + 
				"                                                                \"tableName\": \"L1\",\r\n" + 
				"                                                                \"alias\": \"Loyalty_Memberships_MembershipExpiration\"\r\n" + 
				"                                                            },\r\n" + 
				"                                                            {\r\n" + 
				"                                                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                                \"attributeName\": \"MembershipLevel\",\r\n" + 
				"                                                                \"tableName\": \"L1\",\r\n" + 
				"                                                                \"alias\": \"Loyalty_Memberships_MembershipLevel\"\r\n" + 
				"                                                            },\r\n" + 
				"                                                            {\r\n" + 
				"                                                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                                \"attributeName\": \"MembershipStage\",\r\n" + 
				"                                                                \"tableName\": \"L1\",\r\n" + 
				"                                                                \"alias\": \"Loyalty_Memberships_MembershipStage\"\r\n" + 
				"                                                            },\r\n" + 
				"                                                            {\r\n" + 
				"                                                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                                \"attributeName\": \"NameOnCard\",\r\n" + 
				"                                                                \"tableName\": \"L1\",\r\n" + 
				"                                                                \"alias\": \"Loyalty_Memberships_NameOnCard\"\r\n" + 
				"                                                            },\r\n" + 
				"                                                            {\r\n" + 
				"                                                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                                \"attributeName\": \"MembershipType\",\r\n" + 
				"                                                                \"tableName\": \"L1\",\r\n" + 
				"                                                                \"alias\": \"Loyalty_MembershipType\"\r\n" + 
				"                                                            }\r\n" + 
				"                                                        ]\r\n" + 
				"                                                    },\r\n" + 
				"                                                    \"condition\": [\r\n" + 
				"                                                        {\r\n" + 
				"                                                            \"left\": {\r\n" + 
				"                                                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                                \"attributeName\": \"ID\",\r\n" + 
				"                                                                \"tableName\": \"C3\",\r\n" + 
				"                                                                \"alias\": \"ID\"\r\n" + 
				"                                                            },\r\n" + 
				"                                                            \"right\": {\r\n" + 
				"                                                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                                \"attributeName\": \"Loyalty_Memberships_CustomerID\",\r\n" + 
				"                                                                \"tableName\": \"L1\",\r\n" + 
				"                                                                \"alias\": \"Loyalty_Memberships_CustomerID\"\r\n" + 
				"                                                            }\r\n" + 
				"                                                        }\r\n" + 
				"                                                    ]\r\n" + 
				"                                                },\r\n" + 
				"                                                \"outputAttributes\": [\r\n" + 
				"                                                    {\r\n" + 
				"                                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                        \"attributeName\": \"ID\",\r\n" + 
				"                                                        \"tableName\": \"C3\",\r\n" + 
				"                                                        \"alias\": \"Customer_ID\"\r\n" + 
				"                                                    },\r\n" + 
				"                                                    {\r\n" + 
				"                                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                        \"attributeName\": \"Loyalty_Memberships_MembershipCardNo\",\r\n" + 
				"                                                        \"tableName\": \"L1\",\r\n" + 
				"                                                        \"alias\": \"Loyalty_Memberships_MembershipCardNo\"\r\n" + 
				"                                                    },\r\n" + 
				"                                                    {\r\n" + 
				"                                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                        \"attributeName\": \"Loyalty_Memberships_MemberSince\",\r\n" + 
				"                                                        \"tableName\": \"L1\",\r\n" + 
				"                                                        \"alias\": \"Loyalty_Memberships_MemberSince\"\r\n" + 
				"                                                    },\r\n" + 
				"                                                    {\r\n" + 
				"                                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                        \"attributeName\": \"Loyalty_Memberships_MembershipExpiration\",\r\n" + 
				"                                                        \"tableName\": \"L1\",\r\n" + 
				"                                                        \"alias\": \"Loyalty_Memberships_MembershipExpiration\"\r\n" + 
				"                                                    },\r\n" + 
				"                                                    {\r\n" + 
				"                                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                        \"attributeName\": \"Loyalty_Memberships_MembershipLevel\",\r\n" + 
				"                                                        \"tableName\": \"L1\",\r\n" + 
				"                                                        \"alias\": \"Loyalty_Memberships_MembershipLevel\"\r\n" + 
				"                                                    },\r\n" + 
				"                                                    {\r\n" + 
				"                                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                        \"attributeName\": \"Loyalty_Memberships_MembershipStage\",\r\n" + 
				"                                                        \"tableName\": \"L1\",\r\n" + 
				"                                                        \"alias\": \"Loyalty_Memberships_MembershipStage\"\r\n" + 
				"                                                    },\r\n" + 
				"                                                    {\r\n" + 
				"                                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                        \"attributeName\": \"Loyalty_Memberships_NameOnCard\",\r\n" + 
				"                                                        \"tableName\": \"L1\",\r\n" + 
				"                                                        \"alias\": \"Loyalty_Memberships_NameOnCard\"\r\n" + 
				"                                                    },\r\n" + 
				"                                                    {\r\n" + 
				"                                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                        \"attributeName\": \"Loyalty_MembershipType\",\r\n" + 
				"                                                        \"tableName\": \"L1\",\r\n" + 
				"                                                        \"alias\": \"Loyalty_MembershipType\"\r\n" + 
				"                                                    },\r\n" + 
				"                                                    {\r\n" + 
				"                                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                        \"attributeName\": \"SourceID\",\r\n" + 
				"                                                        \"tableName\": \"C3\",\r\n" + 
				"                                                        \"alias\": \"Customer_SourceID\"\r\n" + 
				"                                                    },\r\n" + 
				"                                                    {\r\n" + 
				"                                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                        \"attributeName\": \"SourceCustomerID\",\r\n" + 
				"                                                        \"tableName\": \"C3\",\r\n" + 
				"                                                        \"alias\": \"Customer_SourceCustomerID\"\r\n" + 
				"                                                    },\r\n" + 
				"                                                    {\r\n" + 
				"                                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                        \"attributeName\": \"FirstName\",\r\n" + 
				"                                                        \"tableName\": \"C3\",\r\n" + 
				"                                                        \"alias\": \"Customer_FirstName\"\r\n" + 
				"                                                    },\r\n" + 
				"                                                    {\r\n" + 
				"                                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                        \"attributeName\": \"LastName\",\r\n" + 
				"                                                        \"tableName\": \"C3\",\r\n" + 
				"                                                        \"alias\": \"Customer_LastName\"\r\n" + 
				"                                                    },\r\n" + 
				"                                                    {\r\n" + 
				"                                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                        \"attributeName\": \"Email\",\r\n" + 
				"                                                        \"tableName\": \"C3\",\r\n" + 
				"                                                        \"alias\": \"Customer_Email\"\r\n" + 
				"                                                    },\r\n" + 
				"                                                    {\r\n" + 
				"                                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                        \"attributeName\": \"Phone\",\r\n" + 
				"                                                        \"tableName\": \"C3\",\r\n" + 
				"                                                        \"alias\": \"Customer_Phone\"\r\n" + 
				"                                                    }\r\n" + 
				"                                                ]\r\n" + 
				"                                            },\r\n" + 
				"                                            \"condition\": [\r\n" + 
				"                                                {\r\n" + 
				"                                                    \"left\": {\r\n" + 
				"                                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                        \"attributeName\": \"CustomerID\",\r\n" + 
				"                                                        \"tableName\": \"C2\",\r\n" + 
				"                                                        \"alias\": \"CustomerID\"\r\n" + 
				"                                                    },\r\n" + 
				"                                                    \"right\": {\r\n" + 
				"                                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                        \"attributeName\": \"Customer_ID\",\r\n" + 
				"                                                        \"tableName\": \"C3\",\r\n" + 
				"                                                        \"alias\": \"Customer_ID\"\r\n" + 
				"                                                    }\r\n" + 
				"                                                }\r\n" + 
				"                                            ]\r\n" + 
				"                                        },\r\n" + 
				"                                        \"outputAttributes\": [\r\n" + 
				"                                            {\r\n" + 
				"                                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                \"attributeName\": \"MasterCustomerID\",\r\n" + 
				"                                                \"tableName\": \"C2\",\r\n" + 
				"                                                \"alias\": \"Customer_MasterCustomer_MasterCustomerID\"\r\n" + 
				"                                            },\r\n" + 
				"                                            {\r\n" + 
				"                                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                \"attributeName\": \"Customer_ID\",\r\n" + 
				"                                                \"tableName\": \"C3\",\r\n" + 
				"                                                \"alias\": \"Customer_ID\"\r\n" + 
				"                                            },\r\n" + 
				"                                            {\r\n" + 
				"                                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                \"attributeName\": \"Loyalty_Memberships_MembershipCardNo\",\r\n" + 
				"                                                \"tableName\": \"C3\",\r\n" + 
				"                                                \"alias\": \"Loyalty_Memberships_MembershipCardNo\"\r\n" + 
				"                                            },\r\n" + 
				"                                            {\r\n" + 
				"                                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                \"attributeName\": \"Loyalty_Memberships_MemberSince\",\r\n" + 
				"                                                \"tableName\": \"C3\",\r\n" + 
				"                                                \"alias\": \"Loyalty_Memberships_MemberSince\"\r\n" + 
				"                                            },\r\n" + 
				"                                            {\r\n" + 
				"                                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                \"attributeName\": \"Loyalty_Memberships_MembershipExpiration\",\r\n" + 
				"                                                \"tableName\": \"C3\",\r\n" + 
				"                                                \"alias\": \"Loyalty_Memberships_MembershipExpiration\"\r\n" + 
				"                                            },\r\n" + 
				"                                            {\r\n" + 
				"                                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                \"attributeName\": \"Loyalty_Memberships_MembershipLevel\",\r\n" + 
				"                                                \"tableName\": \"C3\",\r\n" + 
				"                                                \"alias\": \"Loyalty_Memberships_MembershipLevel\"\r\n" + 
				"                                            },\r\n" + 
				"                                            {\r\n" + 
				"                                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                \"attributeName\": \"Loyalty_Memberships_MembershipStage\",\r\n" + 
				"                                                \"tableName\": \"C3\",\r\n" + 
				"                                                \"alias\": \"Loyalty_Memberships_MembershipStage\"\r\n" + 
				"                                            },\r\n" + 
				"                                            {\r\n" + 
				"                                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                \"attributeName\": \"Loyalty_Memberships_NameOnCard\",\r\n" + 
				"                                                \"tableName\": \"C3\",\r\n" + 
				"                                                \"alias\": \"Loyalty_Memberships_NameOnCard\"\r\n" + 
				"                                            },\r\n" + 
				"                                            {\r\n" + 
				"                                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                \"attributeName\": \"Loyalty_MembershipType\",\r\n" + 
				"                                                \"tableName\": \"C3\",\r\n" + 
				"                                                \"alias\": \"Loyalty_MembershipType\"\r\n" + 
				"                                            },\r\n" + 
				"                                            {\r\n" + 
				"                                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                \"attributeName\": \"Customer_SourceID\",\r\n" + 
				"                                                \"tableName\": \"C3\",\r\n" + 
				"                                                \"alias\": \"Customer_SourceID\"\r\n" + 
				"                                            },\r\n" + 
				"                                            {\r\n" + 
				"                                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                \"attributeName\": \"Customer_SourceCustomerID\",\r\n" + 
				"                                                \"tableName\": \"C3\",\r\n" + 
				"                                                \"alias\": \"Customer_SourceCustomerID\"\r\n" + 
				"                                            },\r\n" + 
				"                                            {\r\n" + 
				"                                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                \"attributeName\": \"Customer_FirstName\",\r\n" + 
				"                                                \"tableName\": \"C3\",\r\n" + 
				"                                                \"alias\": \"Customer_FirstName\"\r\n" + 
				"                                            },\r\n" + 
				"                                            {\r\n" + 
				"                                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                \"attributeName\": \"Customer_LastName\",\r\n" + 
				"                                                \"tableName\": \"C3\",\r\n" + 
				"                                                \"alias\": \"Customer_LastName\"\r\n" + 
				"                                            },\r\n" + 
				"                                            {\r\n" + 
				"                                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                \"attributeName\": \"Customer_Email\",\r\n" + 
				"                                                \"tableName\": \"C3\",\r\n" + 
				"                                                \"alias\": \"Customer_Email\"\r\n" + 
				"                                            },\r\n" + 
				"                                            {\r\n" + 
				"                                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                \"attributeName\": \"Customer_Phone\",\r\n" + 
				"                                                \"tableName\": \"C3\",\r\n" + 
				"                                                \"alias\": \"Customer_Phone\"\r\n" + 
				"                                            }\r\n" + 
				"                                        ]\r\n" + 
				"                                    },\r\n" + 
				"                                    \"condition\": [\r\n" + 
				"                                        {\r\n" + 
				"                                            \"left\": {\r\n" + 
				"                                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                \"attributeName\": \"ID\",\r\n" + 
				"                                                \"tableName\": \"M1\",\r\n" + 
				"                                                \"alias\": \"ID\"\r\n" + 
				"                                            },\r\n" + 
				"                                            \"right\": {\r\n" + 
				"                                                \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                \"attributeName\": \"Customer_MasterCustomer_MasterCustomerID\",\r\n" + 
				"                                                \"tableName\": \"C2\",\r\n" + 
				"                                                \"alias\": \"Customer_MasterCustomer_MasterCustomerID\"\r\n" + 
				"                                            }\r\n" + 
				"                                        }\r\n" + 
				"                                    ]\r\n" + 
				"                                },\r\n" + 
				"                                \"outputAttributes\": [\r\n" + 
				"                                    {\r\n" + 
				"                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                        \"attributeName\": \"Customer_ID\",\r\n" + 
				"                                        \"tableName\": \"C2\",\r\n" + 
				"                                        \"alias\": \"Customer_ID\"\r\n" + 
				"                                    },\r\n" + 
				"                                    {\r\n" + 
				"                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                        \"attributeName\": \"Loyalty_Memberships_MembershipCardNo\",\r\n" + 
				"                                        \"tableName\": \"C2\",\r\n" + 
				"                                        \"alias\": \"Loyalty_Memberships_MembershipCardNo\"\r\n" + 
				"                                    },\r\n" + 
				"                                    {\r\n" + 
				"                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                        \"attributeName\": \"Loyalty_Memberships_MemberSince\",\r\n" + 
				"                                        \"tableName\": \"C2\",\r\n" + 
				"                                        \"alias\": \"Loyalty_Memberships_MemberSince\"\r\n" + 
				"                                    },\r\n" + 
				"                                    {\r\n" + 
				"                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                        \"attributeName\": \"Loyalty_Memberships_MembershipExpiration\",\r\n" + 
				"                                        \"tableName\": \"C2\",\r\n" + 
				"                                        \"alias\": \"Loyalty_Memberships_MembershipExpiration\"\r\n" + 
				"                                    },\r\n" + 
				"                                    {\r\n" + 
				"                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                        \"attributeName\": \"Loyalty_Memberships_MembershipLevel\",\r\n" + 
				"                                        \"tableName\": \"C2\",\r\n" + 
				"                                        \"alias\": \"Loyalty_Memberships_MembershipLevel\"\r\n" + 
				"                                    },\r\n" + 
				"                                    {\r\n" + 
				"                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                        \"attributeName\": \"Loyalty_Memberships_MembershipStage\",\r\n" + 
				"                                        \"tableName\": \"C2\",\r\n" + 
				"                                        \"alias\": \"Loyalty_Memberships_MembershipStage\"\r\n" + 
				"                                    },\r\n" + 
				"                                    {\r\n" + 
				"                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                        \"attributeName\": \"Loyalty_Memberships_NameOnCard\",\r\n" + 
				"                                        \"tableName\": \"C2\",\r\n" + 
				"                                        \"alias\": \"Loyalty_Memberships_NameOnCard\"\r\n" + 
				"                                    },\r\n" + 
				"                                    {\r\n" + 
				"                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                        \"attributeName\": \"Loyalty_MembershipType\",\r\n" + 
				"                                        \"tableName\": \"C2\",\r\n" + 
				"                                        \"alias\": \"Loyalty_MembershipType\"\r\n" + 
				"                                    },\r\n" + 
				"                                    {\r\n" + 
				"                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                        \"attributeName\": \"Customer_SourceCustomerID\",\r\n" + 
				"                                        \"tableName\": \"C2\",\r\n" + 
				"                                        \"alias\": \"Customer_SourceCustomerID\"\r\n" + 
				"                                    },\r\n" + 
				"                                    {\r\n" + 
				"                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                        \"attributeName\": \"Customer_SourceID\",\r\n" + 
				"                                        \"tableName\": \"C2\",\r\n" + 
				"                                        \"alias\": \"Customer_SourceID\"\r\n" + 
				"                                    },\r\n" + 
				"                                    {\r\n" + 
				"                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                        \"attributeName\": \"Customer_FirstName\",\r\n" + 
				"                                        \"tableName\": \"C2\",\r\n" + 
				"                                        \"alias\": \"Customer_FirstName\"\r\n" + 
				"                                    },\r\n" + 
				"                                    {\r\n" + 
				"                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                        \"attributeName\": \"Customer_LastName\",\r\n" + 
				"                                        \"tableName\": \"C2\",\r\n" + 
				"                                        \"alias\": \"Customer_LastName\"\r\n" + 
				"                                    },\r\n" + 
				"                                    {\r\n" + 
				"                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                        \"attributeName\": \"Customer_Email\",\r\n" + 
				"                                        \"tableName\": \"C2\",\r\n" + 
				"                                        \"alias\": \"Customer_Email\"\r\n" + 
				"                                    },\r\n" + 
				"                                    {\r\n" + 
				"                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                        \"attributeName\": \"Customer_Phone\",\r\n" + 
				"                                        \"tableName\": \"C2\",\r\n" + 
				"                                        \"alias\": \"Customer_Phone\"\r\n" + 
				"                                    },\r\n" + 
				"                                    {\r\n" + 
				"                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                        \"attributeName\": \"ID\",\r\n" + 
				"                                        \"tableName\": \"M1\",\r\n" + 
				"                                        \"alias\": \"MasterCustomer_ID\"\r\n" + 
				"                                    },\r\n" + 
				"                                    {\r\n" + 
				"                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                        \"attributeName\": \"FirstName\",\r\n" + 
				"                                        \"tableName\": \"M1\",\r\n" + 
				"                                        \"alias\": \"MasterCustomer_FirstName\"\r\n" + 
				"                                    },\r\n" + 
				"                                    {\r\n" + 
				"                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                        \"attributeName\": \"LastName\",\r\n" + 
				"                                        \"tableName\": \"M1\",\r\n" + 
				"                                        \"alias\": \"MasterCustomer_LastName\"\r\n" + 
				"                                    },\r\n" + 
				"                                    {\r\n" + 
				"                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                        \"attributeName\": \"Mobile_Country_Code\",\r\n" + 
				"                                        \"tableName\": \"M1\",\r\n" + 
				"                                        \"alias\": \"MasterCustomer_MobileCountryCode\"\r\n" + 
				"                                    },\r\n" + 
				"                                    {\r\n" + 
				"                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                        \"attributeName\": \"Phone\",\r\n" + 
				"                                        \"tableName\": \"M1\",\r\n" + 
				"                                        \"alias\": \"MasterCustomer_Phone\"\r\n" + 
				"                                    },\r\n" + 
				"                                    {\r\n" + 
				"                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                        \"attributeName\": \"Email\",\r\n" + 
				"                                        \"tableName\": \"M1\",\r\n" + 
				"                                        \"alias\": \"MasterCustomer_Email\"\r\n" + 
				"                                    },\r\n" + 
				"                                    {\r\n" + 
				"                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                        \"attributeName\": \"Cashlisted\",\r\n" + 
				"                                        \"tableName\": \"M1\",\r\n" + 
				"                                        \"alias\": \"MasterCustomer_Cashlisted\"\r\n" + 
				"                                    },\r\n" + 
				"                                    {\r\n" + 
				"                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                        \"attributeName\": \"Restricted\",\r\n" + 
				"                                        \"tableName\": \"M1\",\r\n" + 
				"                                        \"alias\": \"MasterCustomer_Restricted\"\r\n" + 
				"                                    },\r\n" + 
				"                                    {\r\n" + 
				"                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                        \"attributeName\": \"BirthDate\",\r\n" + 
				"                                        \"tableName\": \"M1\",\r\n" + 
				"                                        \"alias\": \"MasterCustomer_BirthDate\"\r\n" + 
				"                                    },\r\n" + 
				"                                    {\r\n" + 
				"                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                        \"attributeName\": \"AddressLine1\",\r\n" + 
				"                                        \"tableName\": \"M1\",\r\n" + 
				"                                        \"alias\": \"MasterCustomer_AddressLine1\"\r\n" + 
				"                                    },\r\n" + 
				"                                    {\r\n" + 
				"                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                        \"attributeName\": \"AddressLine2\",\r\n" + 
				"                                        \"tableName\": \"M1\",\r\n" + 
				"                                        \"alias\": \"MasterCustomer_AddressLine2\"\r\n" + 
				"                                    },\r\n" + 
				"                                    {\r\n" + 
				"                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                        \"attributeName\": \"City\",\r\n" + 
				"                                        \"tableName\": \"M1\",\r\n" + 
				"                                        \"alias\": \"MasterCustomer_City\"\r\n" + 
				"                                    },\r\n" + 
				"                                    {\r\n" + 
				"                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                        \"attributeName\": \"Country\",\r\n" + 
				"                                        \"tableName\": \"M1\",\r\n" + 
				"                                        \"alias\": \"MasterCustomer_Country\"\r\n" + 
				"                                    },\r\n" + 
				"                                    {\r\n" + 
				"                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                        \"attributeName\": \"ZipCode\",\r\n" + 
				"                                        \"tableName\": \"M1\",\r\n" + 
				"                                        \"alias\": \"MasterCustomer_ZipCode\"\r\n" + 
				"                                    },\r\n" + 
				"                                    {\r\n" + 
				"                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                        \"attributeName\": \"State\",\r\n" + 
				"                                        \"tableName\": \"M1\",\r\n" + 
				"                                        \"alias\": \"MasterCustomer_State\"\r\n" + 
				"                                    },\r\n" + 
				"                                    {\r\n" + 
				"                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                        \"attributeName\": \"CountryCode_ISOAlpha2\",\r\n" + 
				"                                        \"tableName\": \"M1\",\r\n" + 
				"                                        \"alias\": \"MasterCustomer_CountryCode_ISOAlpha2\"\r\n" + 
				"                                    },\r\n" + 
				"                                    {\r\n" + 
				"                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                        \"attributeName\": \"Gender\",\r\n" + 
				"                                        \"tableName\": \"M1\",\r\n" + 
				"                                        \"alias\": \"MasterCustomer_Gender\"\r\n" + 
				"                                    },\r\n" + 
				"                                    {\r\n" + 
				"                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                        \"attributeName\": \"MartialStatus\",\r\n" + 
				"                                        \"tableName\": \"M1\",\r\n" + 
				"                                        \"alias\": \"MasterCustomer_MartialStatus\"\r\n" + 
				"                                    },\r\n" + 
				"                                    {\r\n" + 
				"                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                        \"attributeName\": \"Prefix\",\r\n" + 
				"                                        \"tableName\": \"M1\",\r\n" + 
				"                                        \"alias\": \"MasterCustomer_Prefix\"\r\n" + 
				"                                    },\r\n" + 
				"                                    {\r\n" + 
				"                                        \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                        \"attributeName\": \"Email_Validation_Status\",\r\n" + 
				"                                        \"tableName\": \"M1\",\r\n" + 
				"                                        \"alias\": \"MasterCustomer_Email_Validation_Status\"\r\n" + 
				"                                    }\r\n" + 
				"                                ]\r\n" + 
				"                            },\r\n" + 
				"                            \"objectJoin\": {\r\n" + 
				"                                \"type\": \"LEFT\",\r\n" + 
				"                                \"targetSet\": {\r\n" + 
				"                                    \"ctype\": \".ObjectSet\",\r\n" + 
				"                                    \"name\": \"M2\",\r\n" + 
				"                                    \"distinct\": false,\r\n" + 
				"                                    \"objectName\": \"MasterCustomer\",\r\n" + 
				"                                    \"objectJoin\": {\r\n" + 
				"                                        \"type\": \"LEFT\",\r\n" + 
				"                                        \"targetSet\": {\r\n" + 
				"                                            \"ctype\": \".ObjectSet\",\r\n" + 
				"                                            \"name\": \"C4\",\r\n" + 
				"                                            \"distinct\": true,\r\n" + 
				"                                            \"objectName\": \"Customer_MasterCustomer\",\r\n" + 
				"                                            \"objectJoin\": {\r\n" + 
				"                                                \"type\": \"LEFT\",\r\n" + 
				"                                                \"targetSet\": {\r\n" + 
				"                                                    \"ctype\": \".ObjectSet\",\r\n" + 
				"                                                    \"name\": \"C5\",\r\n" + 
				"                                                    \"distinct\": false,\r\n" + 
				"                                                    \"objectName\": \"Customer\",\r\n" + 
				"                                                    \"criteria\": {\r\n" + 
				"                                                        \"ctype\": \".Criteria\",\r\n" + 
				"                                                        \"operator\": \"OR\",\r\n" + 
				"                                                        \"operands\": [\r\n" + 
				"                                                            {\r\n" + 
				"                                                                \"ctype\": \".Criteria\",\r\n" + 
				"                                                                \"operator\": \"EQUALS\",\r\n" + 
				"                                                                \"operands\": [\r\n" + 
				"                                                                    {\r\n" + 
				"                                                                        \"ctype\": \".ReferenceAttribute\",\r\n" + 
				"                                                                        \"tableName\": \"C5\",\r\n" + 
				"                                                                        \"attributeName\": \"ID\"\r\n" + 
				"                                                                    },\r\n" + 
				"                                                                    {\r\n" + 
				"                                                                        \"ctype\": \".StaticAttribute\",\r\n" + 
				"                                                                        \"data\": \"OPERA_CLOUD_5571834\"\r\n" + 
				"                                                                    }\r\n" + 
				"                                                                ]\r\n" + 
				"                                                            }\r\n" + 
				"                                                        ]\r\n" + 
				"                                                    },\r\n" + 
				"                                                    \"outputAttributes\": [\r\n" + 
				"                                                        {\r\n" + 
				"                                                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                            \"attributeName\": \"ID\",\r\n" + 
				"                                                            \"tableName\": \"C5\",\r\n" + 
				"                                                            \"alias\": \"Customer_ID\"\r\n" + 
				"                                                        },\r\n" + 
				"                                                        {\r\n" + 
				"                                                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                            \"attributeName\": \"SourceID\",\r\n" + 
				"                                                            \"tableName\": \"C5\",\r\n" + 
				"                                                            \"alias\": \"Customer_SourceID\"\r\n" + 
				"                                                        },\r\n" + 
				"                                                        {\r\n" + 
				"                                                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                            \"attributeName\": \"SourceCustomerID\",\r\n" + 
				"                                                            \"tableName\": \"C5\",\r\n" + 
				"                                                            \"alias\": \"Customer_SourceCustomerID\"\r\n" + 
				"                                                        },\r\n" + 
				"                                                        {\r\n" + 
				"                                                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                            \"attributeName\": \"FirstName\",\r\n" + 
				"                                                            \"tableName\": \"C5\",\r\n" + 
				"                                                            \"alias\": \"Customer_FirstName\"\r\n" + 
				"                                                        },\r\n" + 
				"                                                        {\r\n" + 
				"                                                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                            \"attributeName\": \"LastName\",\r\n" + 
				"                                                            \"tableName\": \"C5\",\r\n" + 
				"                                                            \"alias\": \"Customer_LastName\"\r\n" + 
				"                                                        },\r\n" + 
				"                                                        {\r\n" + 
				"                                                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                            \"attributeName\": \"Email\",\r\n" + 
				"                                                            \"tableName\": \"C5\",\r\n" + 
				"                                                            \"alias\": \"Customer_Email\"\r\n" + 
				"                                                        },\r\n" + 
				"                                                        {\r\n" + 
				"                                                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                            \"attributeName\": \"Phone\",\r\n" + 
				"                                                            \"tableName\": \"C5\",\r\n" + 
				"                                                            \"alias\": \"Customer_Phone\"\r\n" + 
				"                                                        }\r\n" + 
				"                                                    ]\r\n" + 
				"                                                },\r\n" + 
				"                                                \"condition\": [\r\n" + 
				"                                                    {\r\n" + 
				"                                                        \"left\": {\r\n" + 
				"                                                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                            \"attributeName\": \"CustomerID\",\r\n" + 
				"                                                            \"tableName\": \"C4\",\r\n" + 
				"                                                            \"alias\": \"CustomerID\"\r\n" + 
				"                                                        },\r\n" + 
				"                                                        \"right\": {\r\n" + 
				"                                                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                            \"attributeName\": \"Customer_ID\",\r\n" + 
				"                                                            \"tableName\": \"C5\",\r\n" + 
				"                                                            \"alias\": \"Customer_ID\"\r\n" + 
				"                                                        }\r\n" + 
				"                                                    }\r\n" + 
				"                                                ]\r\n" + 
				"                                            },\r\n" + 
				"                                            \"outputAttributes\": [\r\n" + 
				"                                                {\r\n" + 
				"                                                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                    \"attributeName\": \"MasterCustomerID\",\r\n" + 
				"                                                    \"tableName\": \"C4\",\r\n" + 
				"                                                    \"alias\": \"Customer_MasterCustomer_MasterCustomerID\"\r\n" + 
				"                                                },\r\n" + 
				"                                                {\r\n" + 
				"                                                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                    \"attributeName\": \"Customer_ID\",\r\n" + 
				"                                                    \"tableName\": \"C5\",\r\n" + 
				"                                                    \"alias\": \"Customer_ID\"\r\n" + 
				"                                                },\r\n" + 
				"                                                {\r\n" + 
				"                                                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                    \"attributeName\": \"Customer_SourceID\",\r\n" + 
				"                                                    \"tableName\": \"C5\",\r\n" + 
				"                                                    \"alias\": \"Customer_SourceID\"\r\n" + 
				"                                                },\r\n" + 
				"                                                {\r\n" + 
				"                                                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                    \"attributeName\": \"Customer_SourceCustomerID\",\r\n" + 
				"                                                    \"tableName\": \"C5\",\r\n" + 
				"                                                    \"alias\": \"Customer_SourceCustomerID\"\r\n" + 
				"                                                },\r\n" + 
				"                                                {\r\n" + 
				"                                                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                    \"attributeName\": \"Customer_FirstName\",\r\n" + 
				"                                                    \"tableName\": \"C5\",\r\n" + 
				"                                                    \"alias\": \"Customer_FirstName\"\r\n" + 
				"                                                },\r\n" + 
				"                                                {\r\n" + 
				"                                                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                    \"attributeName\": \"Customer_LastName\",\r\n" + 
				"                                                    \"tableName\": \"C5\",\r\n" + 
				"                                                    \"alias\": \"Customer_LastName\"\r\n" + 
				"                                                },\r\n" + 
				"                                                {\r\n" + 
				"                                                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                    \"attributeName\": \"Customer_Email\",\r\n" + 
				"                                                    \"tableName\": \"C5\",\r\n" + 
				"                                                    \"alias\": \"Customer_Email\"\r\n" + 
				"                                                },\r\n" + 
				"                                                {\r\n" + 
				"                                                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                    \"attributeName\": \"Customer_Phone\",\r\n" + 
				"                                                    \"tableName\": \"C5\",\r\n" + 
				"                                                    \"alias\": \"Customer_Phone\"\r\n" + 
				"                                                }\r\n" + 
				"                                            ]\r\n" + 
				"                                        },\r\n" + 
				"                                        \"condition\": [\r\n" + 
				"                                            {\r\n" + 
				"                                                \"left\": {\r\n" + 
				"                                                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                    \"attributeName\": \"ID\",\r\n" + 
				"                                                    \"tableName\": \"M2\",\r\n" + 
				"                                                    \"alias\": \"ID\"\r\n" + 
				"                                                },\r\n" + 
				"                                                \"right\": {\r\n" + 
				"                                                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                                    \"attributeName\": \"Customer_MasterCustomer_MasterCustomerID\",\r\n" + 
				"                                                    \"tableName\": \"C4\",\r\n" + 
				"                                                    \"alias\": \"Customer_MasterCustomer_MasterCustomerID\"\r\n" + 
				"                                                }\r\n" + 
				"                                            }\r\n" + 
				"                                        ]\r\n" + 
				"                                    },\r\n" + 
				"                                    \"outputAttributes\": [\r\n" + 
				"                                        {\r\n" + 
				"                                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                            \"attributeName\": \"Customer_ID\",\r\n" + 
				"                                            \"tableName\": \"C4\",\r\n" + 
				"                                            \"alias\": \"Customer_ID\"\r\n" + 
				"                                        },\r\n" + 
				"                                        {\r\n" + 
				"                                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                            \"attributeName\": \"Customer_SourceID\",\r\n" + 
				"                                            \"tableName\": \"C4\",\r\n" + 
				"                                            \"alias\": \"Customer_SourceID\"\r\n" + 
				"                                        },\r\n" + 
				"                                        {\r\n" + 
				"                                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                            \"attributeName\": \"Customer_SourceCustomerID\",\r\n" + 
				"                                            \"tableName\": \"C4\",\r\n" + 
				"                                            \"alias\": \"Customer_SourceCustomerID\"\r\n" + 
				"                                        },\r\n" + 
				"                                        {\r\n" + 
				"                                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                            \"attributeName\": \"Customer_FirstName\",\r\n" + 
				"                                            \"tableName\": \"C4\",\r\n" + 
				"                                            \"alias\": \"Customer_FirstName\"\r\n" + 
				"                                        },\r\n" + 
				"                                        {\r\n" + 
				"                                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                            \"attributeName\": \"Customer_LastName\",\r\n" + 
				"                                            \"tableName\": \"C4\",\r\n" + 
				"                                            \"alias\": \"Customer_LastName\"\r\n" + 
				"                                        },\r\n" + 
				"                                        {\r\n" + 
				"                                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                            \"attributeName\": \"Customer_Email\",\r\n" + 
				"                                            \"tableName\": \"C4\",\r\n" + 
				"                                            \"alias\": \"Customer_Email\"\r\n" + 
				"                                        },\r\n" + 
				"                                        {\r\n" + 
				"                                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                            \"attributeName\": \"Customer_Phone\",\r\n" + 
				"                                            \"tableName\": \"C4\",\r\n" + 
				"                                            \"alias\": \"Customer_Phone\"\r\n" + 
				"                                        },\r\n" + 
				"                                        {\r\n" + 
				"                                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                            \"attributeName\": \"ID\",\r\n" + 
				"                                            \"tableName\": \"M2\",\r\n" + 
				"                                            \"alias\": \"MasterCustomer_ID\"\r\n" + 
				"                                        },\r\n" + 
				"                                        {\r\n" + 
				"                                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                            \"attributeName\": \"FirstName\",\r\n" + 
				"                                            \"tableName\": \"M2\",\r\n" + 
				"                                            \"alias\": \"MasterCustomer_FirstName\"\r\n" + 
				"                                        },\r\n" + 
				"                                        {\r\n" + 
				"                                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                            \"attributeName\": \"LastName\",\r\n" + 
				"                                            \"tableName\": \"M2\",\r\n" + 
				"                                            \"alias\": \"MasterCustomer_LastName\"\r\n" + 
				"                                        },\r\n" + 
				"                                        {\r\n" + 
				"                                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                            \"attributeName\": \"Mobile_Country_Code\",\r\n" + 
				"                                            \"tableName\": \"M2\",\r\n" + 
				"                                            \"alias\": \"MasterCustomer_MobileCountryCode\"\r\n" + 
				"                                        },\r\n" + 
				"                                        {\r\n" + 
				"                                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                            \"attributeName\": \"Phone\",\r\n" + 
				"                                            \"tableName\": \"M2\",\r\n" + 
				"                                            \"alias\": \"MasterCustomer_Phone\"\r\n" + 
				"                                        },\r\n" + 
				"                                        {\r\n" + 
				"                                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                            \"attributeName\": \"Email\",\r\n" + 
				"                                            \"tableName\": \"M2\",\r\n" + 
				"                                            \"alias\": \"MasterCustomer_Email\"\r\n" + 
				"                                        },\r\n" + 
				"                                        {\r\n" + 
				"                                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                            \"attributeName\": \"Cashlisted\",\r\n" + 
				"                                            \"tableName\": \"M2\",\r\n" + 
				"                                            \"alias\": \"MasterCustomer_Cashlisted\"\r\n" + 
				"                                        },\r\n" + 
				"                                        {\r\n" + 
				"                                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                            \"attributeName\": \"Restricted\",\r\n" + 
				"                                            \"tableName\": \"M2\",\r\n" + 
				"                                            \"alias\": \"MasterCustomer_Restricted\"\r\n" + 
				"                                        },\r\n" + 
				"                                        {\r\n" + 
				"                                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                            \"attributeName\": \"BirthDate\",\r\n" + 
				"                                            \"tableName\": \"M2\",\r\n" + 
				"                                            \"alias\": \"MasterCustomer_BirthDate\"\r\n" + 
				"                                        },\r\n" + 
				"                                        {\r\n" + 
				"                                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                            \"attributeName\": \"AddressLine1\",\r\n" + 
				"                                            \"tableName\": \"M2\",\r\n" + 
				"                                            \"alias\": \"MasterCustomer_AddressLine1\"\r\n" + 
				"                                        },\r\n" + 
				"                                        {\r\n" + 
				"                                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                            \"attributeName\": \"AddressLine2\",\r\n" + 
				"                                            \"tableName\": \"M2\",\r\n" + 
				"                                            \"alias\": \"MasterCustomer_AddressLine2\"\r\n" + 
				"                                        },\r\n" + 
				"                                        {\r\n" + 
				"                                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                            \"attributeName\": \"City\",\r\n" + 
				"                                            \"tableName\": \"M2\",\r\n" + 
				"                                            \"alias\": \"MasterCustomer_City\"\r\n" + 
				"                                        },\r\n" + 
				"                                        {\r\n" + 
				"                                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                            \"attributeName\": \"Country\",\r\n" + 
				"                                            \"tableName\": \"M2\",\r\n" + 
				"                                            \"alias\": \"MasterCustomer_Country\"\r\n" + 
				"                                        },\r\n" + 
				"                                        {\r\n" + 
				"                                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                            \"attributeName\": \"ZipCode\",\r\n" + 
				"                                            \"tableName\": \"M2\",\r\n" + 
				"                                            \"alias\": \"MasterCustomer_ZipCode\"\r\n" + 
				"                                        },\r\n" + 
				"                                        {\r\n" + 
				"                                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                            \"attributeName\": \"State\",\r\n" + 
				"                                            \"tableName\": \"M2\",\r\n" + 
				"                                            \"alias\": \"MasterCustomer_State\"\r\n" + 
				"                                        },\r\n" + 
				"                                        {\r\n" + 
				"                                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                            \"attributeName\": \"CountryCode_ISOAlpha2\",\r\n" + 
				"                                            \"tableName\": \"M2\",\r\n" + 
				"                                            \"alias\": \"MasterCustomer_CountryCode_ISOAlpha2\"\r\n" + 
				"                                        },\r\n" + 
				"                                        {\r\n" + 
				"                                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                            \"attributeName\": \"Gender\",\r\n" + 
				"                                            \"tableName\": \"M2\",\r\n" + 
				"                                            \"alias\": \"MasterCustomer_Gender\"\r\n" + 
				"                                        },\r\n" + 
				"                                        {\r\n" + 
				"                                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                            \"attributeName\": \"MartialStatus\",\r\n" + 
				"                                            \"tableName\": \"M2\",\r\n" + 
				"                                            \"alias\": \"MasterCustomer_MartialStatus\"\r\n" + 
				"                                        },\r\n" + 
				"                                        {\r\n" + 
				"                                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                            \"attributeName\": \"Prefix\",\r\n" + 
				"                                            \"tableName\": \"M2\",\r\n" + 
				"                                            \"alias\": \"MasterCustomer_Prefix\"\r\n" + 
				"                                        },\r\n" + 
				"                                        {\r\n" + 
				"                                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                            \"attributeName\": \"Email_Validation_Status\",\r\n" + 
				"                                            \"tableName\": \"M2\",\r\n" + 
				"                                            \"alias\": \"MasterCustomer_Email_Validation_Status\"\r\n" + 
				"                                        }\r\n" + 
				"                                    ]\r\n" + 
				"                                },\r\n" + 
				"                                \"condition\": [\r\n" + 
				"                                    {\r\n" + 
				"                                        \"left\": {\r\n" + 
				"                                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                            \"attributeName\": \"MasterCustomer_ID\",\r\n" + 
				"                                            \"tableName\": \"M1\",\r\n" + 
				"                                            \"alias\": \"MasterCustomer_ID\"\r\n" + 
				"                                        },\r\n" + 
				"                                        \"right\": {\r\n" + 
				"                                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                            \"attributeName\": \"MasterCustomer_ID\",\r\n" + 
				"                                            \"tableName\": \"M2\",\r\n" + 
				"                                            \"alias\": \"MasterCustomer_ID\"\r\n" + 
				"                                        }\r\n" + 
				"                                    }\r\n" + 
				"                                ]\r\n" + 
				"                            },\r\n" + 
				"                            \"outputAttributes\": [\r\n" + 
				"                                {\r\n" + 
				"                                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                    \"attributeName\": \"Customer_ID\",\r\n" + 
				"                                    \"tableName\": \"M1\",\r\n" + 
				"                                    \"alias\": \"Customer_ID\"\r\n" + 
				"                                },\r\n" + 
				"                                {\r\n" + 
				"                                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                    \"attributeName\": \"Loyalty_Memberships_MembershipCardNo\",\r\n" + 
				"                                    \"tableName\": \"M1\",\r\n" + 
				"                                    \"alias\": \"Loyalty_Memberships_MembershipCardNo\"\r\n" + 
				"                                },\r\n" + 
				"                                {\r\n" + 
				"                                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                    \"attributeName\": \"Loyalty_Memberships_MemberSince\",\r\n" + 
				"                                    \"tableName\": \"M1\",\r\n" + 
				"                                    \"alias\": \"Loyalty_Memberships_MemberSince\"\r\n" + 
				"                                },\r\n" + 
				"                                {\r\n" + 
				"                                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                    \"attributeName\": \"Loyalty_Memberships_MembershipExpiration\",\r\n" + 
				"                                    \"tableName\": \"M1\",\r\n" + 
				"                                    \"alias\": \"Loyalty_Memberships_MembershipExpiration\"\r\n" + 
				"                                },\r\n" + 
				"                                {\r\n" + 
				"                                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                    \"attributeName\": \"Loyalty_Memberships_MembershipLevel\",\r\n" + 
				"                                    \"tableName\": \"M1\",\r\n" + 
				"                                    \"alias\": \"Loyalty_Memberships_MembershipLevel\"\r\n" + 
				"                                },\r\n" + 
				"                                {\r\n" + 
				"                                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                    \"attributeName\": \"Loyalty_Memberships_MembershipStage\",\r\n" + 
				"                                    \"tableName\": \"M1\",\r\n" + 
				"                                    \"alias\": \"Loyalty_Memberships_MembershipStage\"\r\n" + 
				"                                },\r\n" + 
				"                                {\r\n" + 
				"                                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                    \"attributeName\": \"Loyalty_Memberships_NameOnCard\",\r\n" + 
				"                                    \"tableName\": \"M1\",\r\n" + 
				"                                    \"alias\": \"Loyalty_Memberships_NameOnCard\"\r\n" + 
				"                                },\r\n" + 
				"                                {\r\n" + 
				"                                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                    \"attributeName\": \"Loyalty_MembershipType\",\r\n" + 
				"                                    \"tableName\": \"M1\",\r\n" + 
				"                                    \"alias\": \"Loyalty_MembershipType\"\r\n" + 
				"                                },\r\n" + 
				"                                {\r\n" + 
				"                                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                    \"attributeName\": \"Customer_SourceID\",\r\n" + 
				"                                    \"tableName\": \"M1\",\r\n" + 
				"                                    \"alias\": \"Customer_SourceID\"\r\n" + 
				"                                },\r\n" + 
				"                                {\r\n" + 
				"                                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                    \"attributeName\": \"Customer_SourceCustomerID\",\r\n" + 
				"                                    \"tableName\": \"M1\",\r\n" + 
				"                                    \"alias\": \"Customer_SourceCustomerID\"\r\n" + 
				"                                },\r\n" + 
				"                                {\r\n" + 
				"                                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                    \"attributeName\": \"Customer_FirstName\",\r\n" + 
				"                                    \"tableName\": \"M1\",\r\n" + 
				"                                    \"alias\": \"Customer_FirstName\"\r\n" + 
				"                                },\r\n" + 
				"                                {\r\n" + 
				"                                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                    \"attributeName\": \"Customer_LastName\",\r\n" + 
				"                                    \"tableName\": \"M1\",\r\n" + 
				"                                    \"alias\": \"Customer_LastName\"\r\n" + 
				"                                },\r\n" + 
				"                                {\r\n" + 
				"                                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                    \"attributeName\": \"Customer_Email\",\r\n" + 
				"                                    \"tableName\": \"M1\",\r\n" + 
				"                                    \"alias\": \"Customer_Email\"\r\n" + 
				"                                },\r\n" + 
				"                                {\r\n" + 
				"                                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                    \"attributeName\": \"Customer_Phone\",\r\n" + 
				"                                    \"tableName\": \"M1\",\r\n" + 
				"                                    \"alias\": \"Customer_Phone\"\r\n" + 
				"                                },\r\n" + 
				"                                {\r\n" + 
				"                                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                    \"attributeName\": \"MasterCustomer_ID\",\r\n" + 
				"                                    \"tableName\": \"M1\",\r\n" + 
				"                                    \"alias\": \"MasterCustomer_ID\"\r\n" + 
				"                                },\r\n" + 
				"                                {\r\n" + 
				"                                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                    \"attributeName\": \"MasterCustomer_FirstName\",\r\n" + 
				"                                    \"tableName\": \"M1\",\r\n" + 
				"                                    \"alias\": \"MasterCustomer_FirstName\"\r\n" + 
				"                                },\r\n" + 
				"                                {\r\n" + 
				"                                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                    \"attributeName\": \"MasterCustomer_LastName\",\r\n" + 
				"                                    \"tableName\": \"M1\",\r\n" + 
				"                                    \"alias\": \"MasterCustomer_LastName\"\r\n" + 
				"                                },\r\n" + 
				"                                {\r\n" + 
				"                                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                    \"attributeName\": \"MasterCustomer_MobileCountryCode\",\r\n" + 
				"                                    \"tableName\": \"M1\",\r\n" + 
				"                                    \"alias\": \"MasterCustomer_MobileCountryCode\"\r\n" + 
				"                                },\r\n" + 
				"                                {\r\n" + 
				"                                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                    \"attributeName\": \"MasterCustomer_Phone\",\r\n" + 
				"                                    \"tableName\": \"M1\",\r\n" + 
				"                                    \"alias\": \"MasterCustomer_Phone\"\r\n" + 
				"                                },\r\n" + 
				"                                {\r\n" + 
				"                                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                    \"attributeName\": \"MasterCustomer_Email\",\r\n" + 
				"                                    \"tableName\": \"M1\",\r\n" + 
				"                                    \"alias\": \"MasterCustomer_Email\"\r\n" + 
				"                                },\r\n" + 
				"                                {\r\n" + 
				"                                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                    \"attributeName\": \"MasterCustomer_Cashlisted\",\r\n" + 
				"                                    \"tableName\": \"M1\",\r\n" + 
				"                                    \"alias\": \"MasterCustomer_Cashlisted\"\r\n" + 
				"                                },\r\n" + 
				"                                {\r\n" + 
				"                                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                    \"attributeName\": \"MasterCustomer_Restricted\",\r\n" + 
				"                                    \"tableName\": \"M1\",\r\n" + 
				"                                    \"alias\": \"MasterCustomer_Restricted\"\r\n" + 
				"                                },\r\n" + 
				"                                {\r\n" + 
				"                                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                    \"attributeName\": \"MasterCustomer_BirthDate\",\r\n" + 
				"                                    \"tableName\": \"M1\",\r\n" + 
				"                                    \"alias\": \"MasterCustomer_BirthDate\"\r\n" + 
				"                                },\r\n" + 
				"                                {\r\n" + 
				"                                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                    \"attributeName\": \"MasterCustomer_AddressLine1\",\r\n" + 
				"                                    \"tableName\": \"M1\",\r\n" + 
				"                                    \"alias\": \"MasterCustomer_AddressLine1\"\r\n" + 
				"                                },\r\n" + 
				"                                {\r\n" + 
				"                                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                    \"attributeName\": \"MasterCustomer_AddressLine2\",\r\n" + 
				"                                    \"tableName\": \"M1\",\r\n" + 
				"                                    \"alias\": \"MasterCustomer_AddressLine2\"\r\n" + 
				"                                },\r\n" + 
				"                                {\r\n" + 
				"                                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                    \"attributeName\": \"MasterCustomer_City\",\r\n" + 
				"                                    \"tableName\": \"M1\",\r\n" + 
				"                                    \"alias\": \"MasterCustomer_City\"\r\n" + 
				"                                },\r\n" + 
				"                                {\r\n" + 
				"                                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                    \"attributeName\": \"MasterCustomer_Country\",\r\n" + 
				"                                    \"tableName\": \"M1\",\r\n" + 
				"                                    \"alias\": \"MasterCustomer_Country\"\r\n" + 
				"                                },\r\n" + 
				"                                {\r\n" + 
				"                                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                    \"attributeName\": \"MasterCustomer_ZipCode\",\r\n" + 
				"                                    \"tableName\": \"M1\",\r\n" + 
				"                                    \"alias\": \"MasterCustomer_ZipCode\"\r\n" + 
				"                                },\r\n" + 
				"                                {\r\n" + 
				"                                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                    \"attributeName\": \"MasterCustomer_State\",\r\n" + 
				"                                    \"tableName\": \"M1\",\r\n" + 
				"                                    \"alias\": \"MasterCustomer_State\"\r\n" + 
				"                                },\r\n" + 
				"                                {\r\n" + 
				"                                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                    \"attributeName\": \"MasterCustomer_CountryCode_ISOAlpha2\",\r\n" + 
				"                                    \"tableName\": \"M1\",\r\n" + 
				"                                    \"alias\": \"MasterCustomer_CountryCode_ISOAlpha2\"\r\n" + 
				"                                },\r\n" + 
				"                                {\r\n" + 
				"                                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                    \"attributeName\": \"MasterCustomer_Gender\",\r\n" + 
				"                                    \"tableName\": \"M1\",\r\n" + 
				"                                    \"alias\": \"MasterCustomer_Gender\"\r\n" + 
				"                                },\r\n" + 
				"                                {\r\n" + 
				"                                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                    \"attributeName\": \"MasterCustomer_MartialStatus\",\r\n" + 
				"                                    \"tableName\": \"M1\",\r\n" + 
				"                                    \"alias\": \"MasterCustomer_MartialStatus\"\r\n" + 
				"                                },\r\n" + 
				"                                {\r\n" + 
				"                                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                    \"attributeName\": \"MasterCustomer_Prefix\",\r\n" + 
				"                                    \"tableName\": \"M1\",\r\n" + 
				"                                    \"alias\": \"MasterCustomer_Prefix\"\r\n" + 
				"                                },\r\n" + 
				"                                {\r\n" + 
				"                                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                    \"attributeName\": \"MasterCustomer_Email_Validation_Status\",\r\n" + 
				"                                    \"tableName\": \"M1\",\r\n" + 
				"                                    \"alias\": \"MasterCustomer_Email_Validation_Status\"\r\n" + 
				"                                }\r\n" + 
				"                            ],\r\n" + 
				"                            \"distinct\": false\r\n" + 
				"                        },\r\n" + 
				"                        \"condition\": [\r\n" + 
				"                            {\r\n" + 
				"                                \"left\": {\r\n" + 
				"                                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                    \"attributeName\": \"MasterCustomer_ID\",\r\n" + 
				"                                    \"tableName\": \"M0\",\r\n" + 
				"                                    \"alias\": \"MasterCustomer_ID\"\r\n" + 
				"                                },\r\n" + 
				"                                \"right\": {\r\n" + 
				"                                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                                    \"attributeName\": \"MasterCustomer_ID\",\r\n" + 
				"                                    \"tableName\": \"M3\",\r\n" + 
				"                                    \"alias\": \"MasterCustomer_ID\"\r\n" + 
				"                                }\r\n" + 
				"                            }\r\n" + 
				"                        ]\r\n" + 
				"                    },\r\n" + 
				"                    \"distinct\": false,\r\n" + 
				"                    \"outputAttributes\": [\r\n" + 
				"                        {\r\n" + 
				"                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                            \"attributeName\": \"Customer_ID\",\r\n" + 
				"                            \"tableName\": \"M0\",\r\n" + 
				"                            \"alias\": \"Customer_ID\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                            \"attributeName\": \"Loyalty_Memberships_MembershipCardNo\",\r\n" + 
				"                            \"tableName\": \"M0\",\r\n" + 
				"                            \"alias\": \"Loyalty_Memberships_MembershipCardNo\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                            \"attributeName\": \"Loyalty_Memberships_MemberSince\",\r\n" + 
				"                            \"tableName\": \"M0\",\r\n" + 
				"                            \"alias\": \"Loyalty_Memberships_MemberSince\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                            \"attributeName\": \"Loyalty_Memberships_MembershipExpiration\",\r\n" + 
				"                            \"tableName\": \"M0\",\r\n" + 
				"                            \"alias\": \"Loyalty_Memberships_MembershipExpiration\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                            \"attributeName\": \"Loyalty_Memberships_MembershipLevel\",\r\n" + 
				"                            \"tableName\": \"M0\",\r\n" + 
				"                            \"alias\": \"Loyalty_Memberships_MembershipLevel\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                            \"attributeName\": \"Loyalty_Memberships_MembershipStage\",\r\n" + 
				"                            \"tableName\": \"M0\",\r\n" + 
				"                            \"alias\": \"Loyalty_Memberships_MembershipStage\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                            \"attributeName\": \"Loyalty_Memberships_NameOnCard\",\r\n" + 
				"                            \"tableName\": \"M0\",\r\n" + 
				"                            \"alias\": \"Loyalty_Memberships_NameOnCard\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                            \"attributeName\": \"Loyalty_MembershipType\",\r\n" + 
				"                            \"tableName\": \"M0\",\r\n" + 
				"                            \"alias\": \"Loyalty_MembershipType\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                            \"attributeName\": \"Customer_SourceID\",\r\n" + 
				"                            \"tableName\": \"M0\",\r\n" + 
				"                            \"alias\": \"Customer_SourceID\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                            \"attributeName\": \"Customer_SourceCustomerID\",\r\n" + 
				"                            \"tableName\": \"M0\",\r\n" + 
				"                            \"alias\": \"Customer_SourceCustomerID\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                            \"attributeName\": \"Customer_FirstName\",\r\n" + 
				"                            \"tableName\": \"M0\",\r\n" + 
				"                            \"alias\": \"Customer_FirstName\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                            \"attributeName\": \"Customer_LastName\",\r\n" + 
				"                            \"tableName\": \"M0\",\r\n" + 
				"                            \"alias\": \"Customer_LastName\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                            \"attributeName\": \"Customer_Email\",\r\n" + 
				"                            \"tableName\": \"M0\",\r\n" + 
				"                            \"alias\": \"Customer_Email\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                            \"attributeName\": \"Customer_Phone\",\r\n" + 
				"                            \"tableName\": \"M0\",\r\n" + 
				"                            \"alias\": \"Customer_Phone\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                            \"attributeName\": \"MasterCustomer_FirstName\",\r\n" + 
				"                            \"tableName\": \"M0\",\r\n" + 
				"                            \"alias\": \"MasterCustomer_FirstName\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                            \"attributeName\": \"MasterCustomer_LastName\",\r\n" + 
				"                            \"tableName\": \"M0\",\r\n" + 
				"                            \"alias\": \"MasterCustomer_LastName\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                            \"attributeName\": \"MasterCustomer_Email\",\r\n" + 
				"                            \"tableName\": \"M0\",\r\n" + 
				"                            \"alias\": \"MasterCustomer_Email\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                            \"attributeName\": \"MasterCustomer_MobileCountryCode\",\r\n" + 
				"                            \"tableName\": \"M0\",\r\n" + 
				"                            \"alias\": \"MasterCustomer_MobileCountryCode\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                            \"attributeName\": \"MasterCustomer_Phone\",\r\n" + 
				"                            \"tableName\": \"M0\",\r\n" + 
				"                            \"alias\": \"MasterCustomer_Phone\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                            \"attributeName\": \"MasterCustomer_ID\",\r\n" + 
				"                            \"tableName\": \"M0\",\r\n" + 
				"                            \"alias\": \"MasterCustomer_ID\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                            \"attributeName\": \"MasterCustomer_Cashlisted\",\r\n" + 
				"                            \"tableName\": \"M0\",\r\n" + 
				"                            \"alias\": \"MasterCustomer_Cashlisted\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                            \"attributeName\": \"MasterCustomer_Restricted\",\r\n" + 
				"                            \"tableName\": \"M0\",\r\n" + 
				"                            \"alias\": \"MasterCustomer_Restricted\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                            \"attributeName\": \"MasterCustomer_BirthDate\",\r\n" + 
				"                            \"tableName\": \"M0\",\r\n" + 
				"                            \"alias\": \"MasterCustomer_BirthDate\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                            \"attributeName\": \"MasterCustomer_AddressLine1\",\r\n" + 
				"                            \"tableName\": \"M0\",\r\n" + 
				"                            \"alias\": \"MasterCustomer_AddressLine1\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                            \"attributeName\": \"MasterCustomer_AddressLine2\",\r\n" + 
				"                            \"tableName\": \"M0\",\r\n" + 
				"                            \"alias\": \"MasterCustomer_AddressLine2\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                            \"attributeName\": \"MasterCustomer_City\",\r\n" + 
				"                            \"tableName\": \"M0\",\r\n" + 
				"                            \"alias\": \"MasterCustomer_City\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                            \"attributeName\": \"MasterCustomer_Country\",\r\n" + 
				"                            \"tableName\": \"M0\",\r\n" + 
				"                            \"alias\": \"MasterCustomer_Country\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                            \"attributeName\": \"MasterCustomer_ZipCode\",\r\n" + 
				"                            \"tableName\": \"M0\",\r\n" + 
				"                            \"alias\": \"MasterCustomer_ZipCode\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                            \"attributeName\": \"MasterCustomer_State\",\r\n" + 
				"                            \"tableName\": \"M0\",\r\n" + 
				"                            \"alias\": \"MasterCustomer_State\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                            \"attributeName\": \"MasterCustomer_CountryCode_ISOAlpha2\",\r\n" + 
				"                            \"tableName\": \"M0\",\r\n" + 
				"                            \"alias\": \"MasterCustomer_CountryCode_ISOAlpha2\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                            \"attributeName\": \"MasterCustomer_Gender\",\r\n" + 
				"                            \"tableName\": \"M0\",\r\n" + 
				"                            \"alias\": \"MasterCustomer_Gender\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                            \"attributeName\": \"MasterCustomer_MartialStatus\",\r\n" + 
				"                            \"tableName\": \"M0\",\r\n" + 
				"                            \"alias\": \"MasterCustomer_MartialStatus\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                            \"attributeName\": \"MasterCustomer_Prefix\",\r\n" + 
				"                            \"tableName\": \"M0\",\r\n" + 
				"                            \"alias\": \"MasterCustomer_Prefix\"\r\n" + 
				"                        },\r\n" + 
				"                        {\r\n" + 
				"                            \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                            \"attributeName\": \"MasterCustomer_Email_Validation_Status\",\r\n" + 
				"                            \"tableName\": \"M0\",\r\n" + 
				"                            \"alias\": \"MasterCustomer_Email_Validation_Status\"\r\n" + 
				"                        }\r\n" + 
				"                    ]\r\n" + 
				"                }\r\n" + 
				"            ],\r\n" + 
				"            \"outputAttributes\": [\r\n" + 
				"                {\r\n" + 
				"                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                    \"attributeName\": \"MasterCustomer_ID\",\r\n" + 
				"                    \"tableName\": \"M4\",\r\n" + 
				"                    \"alias\": \"M_MasterID\"\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                    \"attributeName\": \"Customer_ID\",\r\n" + 
				"                    \"tableName\": \"M4\",\r\n" + 
				"                    \"alias\": \"C_ID\"\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                    \"attributeName\": \"Customer_SourceID\",\r\n" + 
				"                    \"tableName\": \"M4\",\r\n" + 
				"                    \"alias\": \"C_SourceID\"\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                    \"attributeName\": \"Customer_SourceCustomerID\",\r\n" + 
				"                    \"tableName\": \"M4\",\r\n" + 
				"                    \"alias\": \"C_SourceCustomerID\"\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                    \"attributeName\": \"MasterCustomer_Prefix\",\r\n" + 
				"                    \"tableName\": \"M4\",\r\n" + 
				"                    \"alias\": \"M_Saluatation\"\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                    \"attributeName\": \"MasterCustomer_FirstName\",\r\n" + 
				"                    \"tableName\": \"M4\",\r\n" + 
				"                    \"alias\": \"M_FirstName\"\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                    \"attributeName\": \"MasterCustomer_LastName\",\r\n" + 
				"                    \"tableName\": \"M4\",\r\n" + 
				"                    \"alias\": \"M_LastName\"\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                    \"attributeName\": \"MasterCustomer_Phone\",\r\n" + 
				"                    \"tableName\": \"M4\",\r\n" + 
				"                    \"alias\": \"M_MobieNumber\"\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                    \"attributeName\": \"MasterCustomer_MobileCountryCode\",\r\n" + 
				"                    \"tableName\": \"M4\",\r\n" + 
				"                    \"alias\": \"M_MobileCountryCode\"\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                    \"attributeName\": \"MasterCustomer_Email\",\r\n" + 
				"                    \"tableName\": \"M4\",\r\n" + 
				"                    \"alias\": \"M_EmailAddress\"\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                    \"attributeName\": \"MasterCustomer_BirthDate\",\r\n" + 
				"                    \"tableName\": \"M4\",\r\n" + 
				"                    \"alias\": \"M_DateOfBirth\"\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                    \"attributeName\": \"MasterCustomer_Gender\",\r\n" + 
				"                    \"tableName\": \"M4\",\r\n" + 
				"                    \"alias\": \"M_Gender\"\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                    \"attributeName\": \"MasterCustomer_MartialStatus\",\r\n" + 
				"                    \"tableName\": \"M4\",\r\n" + 
				"                    \"alias\": \"M_MartialStatus\"\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                    \"attributeName\": \"MasterCustomer_Cashlisted\",\r\n" + 
				"                    \"tableName\": \"M4\",\r\n" + 
				"                    \"alias\": \"M_Cashlisted\"\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                    \"attributeName\": \"MasterCustomer_Restricted\",\r\n" + 
				"                    \"tableName\": \"M4\",\r\n" + 
				"                    \"alias\": \"M_Restricted\"\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                    \"attributeName\": \"MasterCustomer_Email_Validation_Status\",\r\n" + 
				"                    \"tableName\": \"M4\",\r\n" + 
				"                    \"alias\": \"M_EmailValidationStatus\"\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                    \"attributeName\": \"MasterCustomer_AddressLine1\",\r\n" + 
				"                    \"tableName\": \"M4\",\r\n" + 
				"                    \"alias\": \"M_AddressLine1\"\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                    \"attributeName\": \"MasterCustomer_AddressLine2\",\r\n" + 
				"                    \"tableName\": \"M4\",\r\n" + 
				"                    \"alias\": \"M_AddressLine2\"\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                    \"attributeName\": \"MasterCustomer_City\",\r\n" + 
				"                    \"tableName\": \"M4\",\r\n" + 
				"                    \"alias\": \"M_City\"\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                    \"attributeName\": \"MasterCustomer_Country\",\r\n" + 
				"                    \"tableName\": \"M4\",\r\n" + 
				"                    \"alias\": \"M_Country\"\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                    \"attributeName\": \"MasterCustomer_ZipCode\",\r\n" + 
				"                    \"tableName\": \"M4\",\r\n" + 
				"                    \"alias\": \"M_PinCode\"\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                    \"attributeName\": \"MasterCustomer_State\",\r\n" + 
				"                    \"tableName\": \"M4\",\r\n" + 
				"                    \"alias\": \"M_State\"\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                    \"attributeName\": \"Loyalty_MembershipType\",\r\n" + 
				"                    \"tableName\": \"M4\",\r\n" + 
				"                    \"alias\": \"L_MembershipType\"\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                    \"attributeName\": \"Loyalty_Memberships_MembershipLevel\",\r\n" + 
				"                    \"tableName\": \"M4\",\r\n" + 
				"                    \"alias\": \"L_MembershipLevel\"\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                    \"attributeName\": \"Loyalty_Memberships_MembershipCardNo\",\r\n" + 
				"                    \"tableName\": \"M4\",\r\n" + 
				"                    \"alias\": \"L_MembershipCardNo\"\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                    \"attributeName\": \"Loyalty_Memberships_MemberSince\",\r\n" + 
				"                    \"tableName\": \"M4\",\r\n" + 
				"                    \"alias\": \"L_MemberSince\"\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                    \"attributeName\": \"Loyalty_Memberships_MembershipExpiration\",\r\n" + 
				"                    \"tableName\": \"M4\",\r\n" + 
				"                    \"alias\": \"L_MembershipExpiration\"\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                    \"attributeName\": \"Loyalty_Memberships_MembershipStage\",\r\n" + 
				"                    \"tableName\": \"M4\",\r\n" + 
				"                    \"alias\": \"L_MembershipStage\"\r\n" + 
				"                },\r\n" + 
				"                {\r\n" + 
				"                    \"atype\": \".ReferenceAttribute\",\r\n" + 
				"                    \"attributeName\": \"Loyalty_Memberships_NameOnCard\",\r\n" + 
				"                    \"tableName\": \"M4\",\r\n" + 
				"                    \"alias\": \"L_NameOnCard\"\r\n" + 
				"                }\r\n" + 
				"            ]\r\n" + 
				"        },\r\n" + 
				"        \"uniqueId\": \"cxu_3adddb62_8241_4cf2_9787_75d11ec64bc2\",\r\n" + 
				"        \"tenantId\": 100074\r\n" + 
				"    }\r\n" + 
				"}";
		OkHttpClient client = new OkHttpClient();
		String authToken = readTokenFromFile();
		if (authToken == null || authToken.isEmpty()) {
			 System.out.println("authtoken is null");
			 authToken = generateNewToken();
			 saveTokenToFile(authToken);
			 System.out.println("auth is null so generated and saved it");
			 }
		MediaType mediaType = MediaType.parse("application/json");
		RequestBody jsonOfReservation = RequestBody.create(mediaType, payload);
		String response = FecthReservationRequestWithTokenHandling(client, jsonOfReservation, authToken);
		JSONObject jsonObject = new JSONObject(response);

		System.out.println(response); 
		
		return jsonObject;
	}



	/*
	//add code changes to call OWS FetchBooking
	public static void FetchBooking(String ResID, String OWSProperty) {
		//code to call fetch booking
		String WSDL = Configuration.FetchBookingCentralWSDL;
		String Action = Configuration.FetchBookingCentralActionURL;
		
		String userName = "oic_user";
		String password = "Innovacx@321";
		
		ConfigPayloads payloads = new ConfigPayloads();
		String payload = payloads.getFetchBookingPayload(ResID, OWSProperty);
		System.out.println("getFetchBookingPayload: "+payload);
		SoapExecutor soapExecutor = new SoapExecutor(WSDL);
		String responce = soapExecutor.executeRequest(userName, password, Action,payload);
		System.out.println("response: "+responce);
			
		
		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + ReservationNo+".txt",true));
			
			writer.write("\nFetchBookingPayload :  \n" + payload + "\n\n");
			writer.write("\nFetchBookingResponce :  \n" + responce + "\n\n");
			writer.write((new Date()).toString());
			writer.close();
			
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		
		Document doc = soapExecutor.convertStringToDocument(responce);
		//System.out.println("Response : "+ responce);
		
		NodeList Result = doc.getElementsByTagName("s0:Result");
		Element res = (Element) Result.item(0);
		String ststus = res.getAttribute("resultStatusFlag");
		//changed code
		//String Status = ((Element) doc.getElementsByTagName("s0:Result")).getAttribute("resultStatusFlag");
		//System.out.println("Status of fetchbooking" + Status);
		if(ststus.equals("SUCCESS")) {
			origBoolean = true;
			isProfileFound = true;
		}
		///
		NodeList nList = doc.getElementsByTagName("s4:Profile");
		Element eleProfile = (Element) nList.item(0);
		NodeList Cust = eleProfile.getElementsByTagName("s4:Customer");
		Element CustProfile = (Element) Cust.item(0);
		Gender = CustProfile.getAttribute("gender");
		DateOfBirth = CustProfile.getAttribute("birthDate");
		FirstName = soapExecutor.getValue(eleProfile, "s2:firstName");
		LastName = soapExecutor.getValue(eleProfile, "s2:lastName");
		Salutation = soapExecutor.getValue(eleProfile,"s2:nameTitle");
		
		NodeList nPhone = eleProfile.getElementsByTagName("s4:NamePhone");
		System.out.println("len: "+nPhone.getLength());
		for(int j = 0 ; j < nPhone.getLength() ; j++)
		{
			Element profileEle = (Element) nPhone.item(j);
			
		
		String phoneRole = profileEle.getAttribute("phoneRole");
		String primary = profileEle.getAttribute("primary");
		
		if (phoneRole.equals("PHONE") && primary.equals("true")) {
				
			Phone = soapExecutor.getValue(profileEle, "s2:PhoneNumber");
				
			}
		}
		NodeList nEMail = eleProfile.getElementsByTagName("s4:NameEmail");
		
		for(int j = 0 ; j < nEMail.getLength() ; j++)
		{
			Element profileEle = (Element) nEMail.item(j);
			
		
		
		String primary = profileEle.getAttribute("primary");
		
		if (primary.equals("true")) {
				
			Email = soapExecutor.getValue(profileEle, "s4:NameEmail");
				
			}
		}
		
		NodeList NameMembership = eleProfile.getElementsByTagName("s4:NameMembership");
		System.out.println("len: "+NameMembership.getLength());
		
		for(int j = 0 ; j < NameMembership.getLength() ; j++)
		{
			Element profileEle = (Element) NameMembership.item(j);
			
		
		String membershipType = soapExecutor.getValue(profileEle, "s2:membershipType");
		
		String membershipid = soapExecutor.getValue(profileEle, "s2:membershipid");
		
		if(ResMemID.equals(membershipid)){
			
			 membershipNumber = soapExecutor.getValue(profileEle, "s2:membershipNumber");
			 membership_Type = soapExecutor.getValue(profileEle, "s2:membershipType");
			 membershipTier = soapExecutor.getValue(profileEle, "s2:membershipLevel");
			
		}
		
		
		if (membershipType.equals("TAJ")) {
				 
				TICMemberNumber = soapExecutor.getValue(profileEle, "s2:membershipNumber");
				TICmembershipTier = soapExecutor.getValue(profileEle, "s2:membershipLevel");
				
			}else if(membershipType.equals("TCP")){
				EnrollNumber_c = soapExecutor.getValue(profileEle, "s2:membershipNumber");
				String TCPMemberLevel = soapExecutor.getValue(profileEle, "s2:membershipLevel");
			}else if(membershipType.equals("TPM")){
				TPMMemberNumber = soapExecutor.getValue(profileEle, "s2:membershipNumber");
				String TCPMemberLevel = soapExecutor.getValue(profileEle, "s2:membershipLevel");
				
			}else if(membershipType.equals("CH")){
				CHMemberNumber = soapExecutor.getValue(profileEle, "s2:membershipNumber");
				CHMemberLevel = soapExecutor.getValue(profileEle, "s2:membershipLevel");
				
			}else if(membershipType.equals("EPI")){
				EPIMemberNumber = soapExecutor.getValue(profileEle, "s2:membershipNumber");
				EPIMemberLevel = soapExecutor.getValue(profileEle, "s2:membershipLevel");
				
			}
		}
		//code end change
		return;
		
	}
	*/
	
	
	private static void saveTokenToFile(String token) {
		 
	    String filePath = "C:\\Users\\ICX\\Downloads\\projectM\\TCPMUIRedemptionOHIPOperaCloudMRPROD_30-09-2025.zip_expanded\\src\\config\\auth_token.txt";

	    if (token == null || token.trim().isEmpty()) {
	        System.out.println("Token is empty. Skipping save.");
	        return;
	    }

	    try {
	        
	        Files.createDirectories(Paths.get(filePath).getParent());

	        // Write token to the file
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
	            writer.write(token);
	            System.out.println(" Token saved successfully to file: " + filePath);
	        }

	    } catch (IOException e) {
	        System.err.println(" Error saving token to file: " + filePath);
	        e.printStackTrace();
	    }

	}



	private static String readTokenFromFile() {
        try {
            System.out.println("Reading token from file...");

            //  Use your absolute file path here
            String filePath = "C:\\Users\\ICX\\Downloads\\projectM\\TCPMUIRedemptionOHIPOperaCloudMRPROD_30-09-2025.zip_expanded\\src\\config\\auth_token.txt";

            if (Files.exists(Paths.get(filePath))) {
                String token = new String(Files.readAllBytes(Paths.get(filePath))).trim();
                System.out.println("Token read successfully: " + token);
                return token;
            } else {
                System.out.println("Token file not found at: " + filePath);
                return null;
            }

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


	private static String FecthReservationRequestWithTokenHandling(OkHttpClient client, RequestBody body, String token) throws IOException, JSONException {
	    Response response = null;
	    try {
	        Request request = new Request.Builder()
	                .url("https://ihclcdptest.cxunity.ocs.oraclecloud.com/api-data/v1/19700a85df1648f0866d0fd380fe246c/data/query/execute")
	                .post(body)
	                .addHeader("Content-Type", "application/json")
	                .addHeader("Authorization", "Bearer " + token)
	                .build();

	        response = client.newCall(request).execute();
	        String responseData = response.body() != null ? response.body().string() : "{}";

	        JSONObject json = new JSONObject(responseData);

	        // ✅ CASE 1: Old style (Response → Decision)
	        if (json.has("Response")) {
	            JSONArray respArray = json.getJSONArray("Response");
	            if (respArray.length() > 0) {
	                JSONObject firstResp = respArray.getJSONObject(0);
	                String decision = firstResp.optString("Decision", "");

	                if ("Deny".equalsIgnoreCase(decision)) {
	                    System.out.println("Decision Deny received. Regenerating token...");
	                    AUTH_TOKEN = generateNewToken();
	                    saveTokenToFile(AUTH_TOKEN);  // Your method
	                    return FecthReservationRequestWithTokenHandling(client, body, AUTH_TOKEN);
	                }

	                if (firstResp.has("Data")) {
	                    JSONArray dataArray = firstResp.getJSONArray("Data");
	                    if (dataArray.length() > 0) {
	                        JSONArray firstRow = dataArray.getJSONArray(0);
	                        System.out.println("Reservation ID: " + firstRow.optString(0));
	                        System.out.println("Loyalty Type: " + firstRow.optString(1));
	                        System.out.println("Status: " + firstRow.optString(2));
	                        System.out.println("Loyalty Number: " + firstRow.optString(3));
	                        System.out.println("Invoice Status: " + firstRow.optString(4));
	                        System.out.println("Invoice ID: " + firstRow.optString(5));
	                        System.out.println("Reservation Name ID: " + firstRow.optString(6));
	                    }
	                }
	            }
	        }
	        // CASE 2: New structure (header + data)
	        else if (json.has("header") && json.has("data")) {
	            JSONArray headers = json.getJSONArray("header");
	            JSONArray data = json.getJSONArray("data");

	            for (int i = 0; i < data.length(); i++) {
	                JSONArray row = data.getJSONArray(i);
	                System.out.println("----- ROW " + (i + 1) + " -----");
	                for (int j = 0; j < headers.length(); j++) {
	                    String columnName = headers.getJSONObject(j).getString("name");
	                    String value = row.isNull(j) ? "" : row.getString(j);
	                    System.out.println(columnName + ": " + value);
	                }
	            }
	        }

	        return responseData;

	    } finally {
	        if (response != null) {
	           
	        }
	    }
	}

	
	
	 public void fetchOutstandingBalance(JSONObject payload) {
	        try {
	            // Example: call your existing API
	            String outstandingUrl = Configuration.FecthOutstandingbalance;
	            String apiResponse = Configuration.fecthProfileDataFromAPI(outstandingUrl, payload);

	            JSONArray jsonArray = new JSONArray(apiResponse);

	            String outstandingBalance = "0.0"; 
	            String cashlisted="";// default

	            if (jsonArray.length() > 0) {
	                JSONObject firstProfile = jsonArray.getJSONObject(0);
	                JSONObject extraData = firstProfile.getJSONObject("extra_data");
	                outstandingBalance = extraData.getString("outstanding_balance");
	                 cashlisted = extraData.optString("cashlisted", "");
	            }

	            // Store in session
	            if (request != null) {
	                HttpSession session = request.getSession();
	                session.setAttribute("outstandingBalance", outstandingBalance);
	                session.setAttribute("cashlisted", cashlisted);
	                System.out.println("Outstanding Balance stored in session: " + outstandingBalance);
	                System.out.println("cashlisted stored in session: " +cashlisted );
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	            try {
	                if (response != null) response.sendRedirect("error.jsp");
	            } catch (Exception ex) {
	                ex.printStackTrace();
	            }
	        }
	    }
	
	
	
	
	
	
	

	
	 private static String generateNewToken() throws IOException {

		    String newToken = null;
		    OkHttpClient client = new OkHttpClient();
		    Response response = null;

		    try {
		        String formData = "username=" + URLEncoder.encode("abhik.das@innovacx.com", "UTF-8") +
		                          "&password=" + URLEncoder.encode("Innovacx@1234", "UTF-8") +
		                          "&grant_type=password" +
		                          "&scope=" + URLEncoder.encode("urn:opc:entitlementid=ihclcdptestcxunity", "UTF-8");

		        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		        RequestBody body = RequestBody.create(mediaType, formData);

		        Request request = new Request.Builder()
		                .url("https://idcs-e260a4be96844ebda0761f1b741668c5.identity.oraclecloud.com/oauth2/v1/token")
		                .post(body)
		                .addHeader("Content-Type", "application/x-www-form-urlencoded")
		                .addHeader("Authorization", "Basic Q1hVTklUWVNJLWloY2xjZHB0ZXN0X0FQUElEOmlkY3Njcy0zNGI3ODE5My03NzM5LTQ3YTUtYTA4Yy1hZDBlYzY5YjVkNTA=")
		                .build();

		        response = client.newCall(request).execute();

		        int statusCode = response.code();
		        System.out.println("Response Code: " + statusCode);

		        if (response.isSuccessful()) {
		            String responseBody = response.body().string();
		            System.out.println("Token Response: " + responseBody);
		            newToken = extractTokenFromResponse(responseBody);
		        } else {
		            System.out.println("Failed: " + response.body().string());
		        }

		    } catch (Exception e) {
		        System.err.println("Error generating token: " + e.getMessage());
		        e.printStackTrace();

		    } finally {
		        if (response != null) {
		            response.body().close();  // Important to prevent connection leaks
		        }
		    }

		    return newToken;
		}
		private static String extractTokenFromResponse(String responseBody) {
		    String token = responseBody.split("\"access_token\":\"")[1].split("\"")[0];
		    return token;
		  }
		  



	public void clearCache()
	{
		PMSNameCode = "";
		ReservationNo = "";
		OWSPropertyCode = "";
		origBoolean = false;

		FirstName = "";
		LastName = "";
		Salutation = "";
		Gender = "";
		Email = "";
		Phone = "";
		PartyId = "";
		PartyNumber = "";
		MembershipType = "";
		EnrollNumber_c = "";
		DateOfBirth = "";
		Address1 = "";
		Address2 = "";
		Address3 = "";
		Address4 = "";
		city = "";
		state = "";
		country = "";
		postal = "";
		
		isProfileFound = false;
		
		
		TPMMemberNumber = "";
		TPMMemberLevel="";
		TPMMemberNumber = "";
		TICMemberNumber = "";
		CHMemberNumber = "";
		EPIMemberNumber="";
		EPIMemberLevel="";
		CHMemberLevel="";
			
		membershipNumber="";
		TICmembershipTier="";
		
		membership_Type="";
		membershipTier="";
		
	}

}


