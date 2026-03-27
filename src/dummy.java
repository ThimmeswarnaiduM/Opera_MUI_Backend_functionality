import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;


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

import config.ConfigPayloads;
import config.Configuration;
import config.GetProfileData;
import config.GetReservationData;
import config.SoapExecutor;

public class dummy {

	@SuppressWarnings("unused")
	public static void main1(String a[])
	{
		String resp = "{\r\n" + 
				"   \"status\":\"SUCCESS\",\r\n" + 
				"   \"errorCode\":null,\r\n" + 
				"   \"errorText\":null,\r\n" + 
				"   \"responseValue\":\"Dynamic access code has been sent to your email registered with us.\",\r\n" + 
				"   \"errorTokenList\":null,\r\n" + 
				"   \"failure\":false,\r\n" + 
				"   \"success\":true\r\n" + 
				"}";
		
		String resp1 = "{\r\n" + 
				"   \"status\":\"FAILURE\",\r\n" + 
				"   \"errorCode\":null,\r\n" + 
				"   \"errorText\":\"Not able to create user account. Please contact your Administrator.\",\r\n" + 
				"   \"responseValue\":null,\r\n" + 
				"   \"errorTokenList\":[\r\n" + 
				"      {\r\n" + 
				"         \"className\":null,\r\n" + 
				"         \"fieldName\":null,\r\n" + 
				"         \"message\":\"Not able to create user account. Please contact your Administrator.\",\r\n" + 
				"         \"lengthConstraint\":null,\r\n" + 
				"         \"value\":\"COTP1500\"\r\n" + 
				"      }\r\n" + 
				"   ],\r\n" + 
				"   \"success\":false,\r\n" + 
				"   \"failure\":true\r\n" + 
				"}";
		
		String resp2 = "{\r\n" + 
				"   \"status\":\"FAILURE\",\r\n" + 
				"   \"errorCode\":\"INVALID_ARGUMENTS\",\r\n" + 
				"   \"errorText\":null,\r\n" + 
				"   \"responseValue\":null,\r\n" + 
				"   \"errorTokenList\":[\r\n" + 
				"      {\r\n" + 
				"         \"className\":null,\r\n" + 
				"         \"fieldName\":\"title\",\r\n" + 
				"         \"message\":\"Title required.\",\r\n" + 
				"         \"lengthConstraint\":null,\r\n" + 
				"         \"value\":\"COTP1001\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"         \"className\":null,\r\n" + 
				"         \"fieldName\":\"firstName\",\r\n" + 
				"         \"message\":\"First name required.\",\r\n" + 
				"         \"lengthConstraint\":null,\r\n" + 
				"         \"value\":\"COTP1002\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"         \"className\":null,\r\n" + 
				"         \"fieldName\":\"lastName\",\r\n" + 
				"         \"message\":\"Last name required.\",\r\n" + 
				"         \"lengthConstraint\":null,\r\n" + 
				"         \"value\":\"COTP1004\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"         \"className\":null,\r\n" + 
				"         \"fieldName\":\"email\",\r\n" + 
				"         \"message\":\"Invalid email.\",\r\n" + 
				"         \"lengthConstraint\":null,\r\n" + 
				"         \"value\":\"COTP1006\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"         \"className\":null,\r\n" + 
				"         \"fieldName\":\"countryCode\",\r\n" + 
				"         \"message\":\"Invalid country code, only numbers allowed.\",\r\n" + 
				"         \"lengthConstraint\":null,\r\n" + 
				"         \"value\":\"COTP1007\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"         \"className\":null,\r\n" + 
				"         \"fieldName\":\"mobile\",\r\n" + 
				"         \"message\":\"Invalid mobile number, only numbers allowed.\",\r\n" + 
				"         \"lengthConstraint\":null,\r\n" + 
				"         \"value\":\"COTP1008\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"         \"className\":null,\r\n" + 
				"         \"fieldName\":\"loginId\",\r\n" + 
				"         \"message\":\"Invalid login Id.\",\r\n" + 
				"         \"lengthConstraint\":null,\r\n" + 
				"         \"value\":\"COTP1009\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"         \"className\":null,\r\n" + 
				"         \"fieldName\":\"password\",\r\n" + 
				"         \"message\":\"Invalid password.\",\r\n" + 
				"         \"lengthConstraint\":null,\r\n" + 
				"         \"value\":\"COTP1010\"\r\n" + 
				"      }\r\n" + 
				"   ],\r\n" + 
				"   \"failure\":true,\r\n" + 
				"   \"success\":false\r\n" + 
				"}";
		
		String resp3 = "{\r\n" + 
				"   \"status\":\"FAILURE\",\r\n" + 
				"   \"errorCode\":\"DUPLICATE_PRINCIPAL\",\r\n" + 
				"   \"errorText\":null,\r\n" + 
				"   \"responseValue\":null,\r\n" + 
				"   \"errorTokenList\":[\r\n" + 
				"      {\r\n" + 
				"         \"className\":null,\r\n" + 
				"         \"fieldName\":\"email\",\r\n" + 
				"         \"message\":\"Provided email address is already registered with another account.\",\r\n" + 
				"         \"lengthConstraint\":null,\r\n" + 
				"         \"value\":\"COTP1013\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"         \"className\":null,\r\n" + 
				"         \"fieldName\":\"mobile\",\r\n" + 
				"         \"message\":\"Provided mobile number is already registered with another account.\",\r\n" + 
				"         \"lengthConstraint\":null,\r\n" + 
				"         \"value\":\"COTP1014\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"         \"className\":null,\r\n" + 
				"         \"fieldName\":\"loginId\",\r\n" + 
				"         \"message\":\"Provided loginId is already registered with another account.\",\r\n" + 
				"         \"lengthConstraint\":null,\r\n" + 
				"         \"value\":\"COTP1015\"\r\n" + 
				"      }\r\n" + 
				"   ],\r\n" + 
				"   \"failure\":true,\r\n" + 
				"   \"success\":false\r\n" + 
				"}";
		
		String resp4 = "{\r\n" + 
				"   \"status\":\"FAILURE\",\r\n" + 
				"   \"errorCode\":\"INVALID_ARGUMENTS\",\r\n" + 
				"   \"errorText\":\"Invalid membershipId.\",\r\n" + 
				"   \"responseValue\":null,\r\n" + 
				"   \"errorTokenList\":[\r\n" + 
				"      {\r\n" + 
				"         \"className\":null,\r\n" + 
				"         \"fieldName\":\"membershipId\",\r\n" + 
				"         \"message\":\"Invalid membershipId.\",\r\n" + 
				"         \"lengthConstraint\":null,\r\n" + 
				"         \"value\":\"COTP1020\"\r\n" + 
				"      }\r\n" + 
				"   ],\r\n" + 
				"   \"failure\":true,\r\n" + 
				"   \"success\":false\r\n" + 
				"}";
		
		String resp5 = "{\r\n" + 
				"   \"status\":\"FAILURE\",\r\n" + 
				"   \"errorCode\":\"INTERNAL_ERROR\",\r\n" + 
				"   \"errorText\":\"Unable to send dynamic access code, internal error has occured.\",\r\n" + 
				"   \"responseValue\":null,\r\n" + 
				"   \"errorTokenList\":[\r\n" + 
				"      {\r\n" + 
				"         \"className\":null,\r\n" + 
				"         \"fieldName\":\"\",\r\n" + 
				"         \"message\":\"Unable to send dynamic access code, internal error has occured.\",\r\n" + 
				"         \"lengthConstraint\":null,\r\n" + 
				"         \"value\":\"COTP1500\"\r\n" + 
				"      }\r\n" + 
				"   ],\r\n" + 
				"   \"failure\":true,\r\n" + 
				"   \"success\":false\r\n" + 
				"}";
		
		try
		{
		
			JSONObject jsonObject = new JSONObject(resp);
//			JSONObject jsonObject = new JSONObject(resp1);
//			JSONObject jsonObject = new JSONObject(resp2);
//			JSONObject jsonObject = new JSONObject(resp3);
//			JSONObject jsonObject = new JSONObject(resp4);
//			JSONObject jsonObject = new JSONObject(resp5);
			
			
			
			String isSuccess = jsonObject.getString("status");
			
			String errMsg = "";
			
			if(isSuccess.equals("SUCCESS"))
			{
				String msg = jsonObject.getString("responseValue");
				//response.getWriter().write(msg);
				//System.out.println(msg);
				errMsg = msg;
				
			}
			else if(isSuccess.equals("FAILURE"))
			{
				String errorCode = jsonObject.getString("errorCode");
				
				if(errorCode.equalsIgnoreCase("null"))
				{
					JSONArray jsonArray = jsonObject.getJSONArray("errorTokenList");
					JSONObject jsonObject2 = jsonArray.getJSONObject(0);
					String msg = jsonObject2.getString("message");
					errMsg = msg;
					//System.out.println(msg);
				}
				else if(errorCode.equalsIgnoreCase("INVALID_ARGUMENTS"))
				{
					JSONArray jsonArray = jsonObject.getJSONArray("errorTokenList");
					JSONObject jsonObject2 = jsonArray.getJSONObject(0);
					String msg = jsonObject2.getString("message");
					errMsg = msg;
					//System.out.println(msg);
					//parameter missing
				}
				else if(errorCode.equalsIgnoreCase("DUPLICATE_PRINCIPAL"))
				{
					JSONArray jsonArray = jsonObject.getJSONArray("errorTokenList");
					JSONObject jsonObject2 = jsonArray.getJSONObject(0);
					String msg = jsonObject2.getString("message");
					errMsg = msg;
					//System.out.println(msg);
				}
				else if(errorCode.equalsIgnoreCase("INTERNAL_ERROR"))
				{
					JSONArray jsonArray = jsonObject.getJSONArray("errorTokenList");
					JSONObject jsonObject2 = jsonArray.getJSONObject(0);
					String msg = jsonObject2.getString("message");
					errMsg = msg;
					//System.out.println(msg);
				}
				
				
			}
			
			
			System.out.println(errMsg);
			
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main2(String a[]) throws Exception
	{
		String resp = "{\r\n" + 
				"    \"type\": \"http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html#sec10.5.1\",\r\n" + 
				"    \"title\": \"Internal Server Error\",\r\n" + 
				"    \"detail\": \"Internal server error. Please contact oracle support for details.\",\r\n" + 
				"    \"o:errorCode\": \"500\",\r\n" + 
				"    \"o:errorDetails\": [\r\n" + 
				"        {\r\n" + 
				"            \"type\": \"UnMappedFault:execute\",\r\n" + 
				"            \"instance\": \"<![CDATA[Please inspect the logs for more details. Initiating Request: <request_payload>\\n   <Body xmlns=\\\"http://schemas.xmlsoap.org/soap/envelope/\\\">\\n      <execute xmlns=\\\"http://xmlns.oracle.com/cloud/adapter/REST/MemberQueryMN_REQUEST/types\\\">\\n         <request-wrapper xmlns=\\\"http://xmlns.oracle.com/cloud/adapter/REST/MemberQueryMN/types\\\">\\n            <MemberQuery_Input>\\n               <Member_spcNumber>1015305090</Member_spcNumber>\\n            </MemberQuery_Input>\\n         </request-wrapper>\\n         <HTTPHeaders/>\\n      </execute>\\n   </Body>\\n</request_payload>\\n]]>\",\r\n" + 
				"            \"title\": \"Fault received on invocation of target :https://14.141.152.144:8443/eai_anon_enu/start.swe?SWEExtSource=SecureWebService&SWEExtCmd=Execute <![CDATA[ \\nFault Code : SOAP-ENV:Server\\nFault String : [Member does not exist](SBL-BPR-00140)\\nFault Details : \\n<siebelf:siebdetail xmlns:siebelf=\\\"http://www.siebel.com/ws/fault\\\">\\n   <siebelf:logfilename>EAIObjMgr_enu_0028_29360166.log</siebelf:logfilename>\\n   <siebelf:errorstack>\\n      <siebelf:error>\\n         <siebelf:errorcode>SBL-BPR-00140</siebelf:errorcode>\\n         <siebelf:errorsymbol>WF_ERR_CUSTOM_9</siebelf:errorsymbol>\\n         <siebelf:errormsg>[Member does not exist](SBL-BPR-00140)</siebelf:errormsg>\\n      </siebelf:error>\\n   </siebelf:errorstack>\\n</siebelf:siebdetail>\\n ]]>\\n:Application Error\",\r\n" + 
				"            \"o:errorPath\": \"<![CDATA[<location>\\n   <node>RouteNode1</node>\\n   <path>response-pipeline</path>\\n</location>\\n]]>\",\r\n" + 
				"            \"o:errorCode\": \"OSB-380001\"\r\n" + 
				"        }\r\n" + 
				"    ]\r\n" + 
				"}";
		
		
		JSONObject object = new JSONObject(resp);
		
		String error = object.getJSONArray("o:errorDetails").getJSONObject(0).getString("title");
		
		if(error.contains("Member does not exist"))
		{
			System.out.println("Member does not exist");
		}
	}

	@SuppressWarnings("unused")
	public static void main3(String a[])
	{
		String responce = payload();
		
		SoapExecutor soapExecutor = new SoapExecutor();
		
		Document doc = soapExecutor.convertStringToDocument(responce);
		
		NodeList nList = doc.getElementsByTagName("s0:FetchBookingResponse");
		Element Ele = (Element) (Node) nList.item(0);
		if (Ele == null) {
			System.out.println("No Reservation Found");
			return;
		}
		 
		Element eleSucesss = (Element) Ele.getElementsByTagName("s0:Result").item(0);
		String isSuccess = eleSucesss.getAttribute("resultStatusFlag");
		if(isSuccess.equalsIgnoreCase("SUCCESS"))
		{
			System.out.println("Hi");
			Element EleHotelResv = (Element) Ele.getElementsByTagName("s0:HotelReservation").item(0);
			String Status = EleHotelResv.getAttribute("reservationStatus");
			
			NodeList nListRoomStays = EleHotelResv.getElementsByTagName("s3:RoomStays");
			
			for(int i=0; i<nListRoomStays.getLength(); i++)
			{
				Element EleRoomStays = (Element) nListRoomStays.item(i);
				
				NodeList nListRoomStay = EleRoomStays.getElementsByTagName("s1:RoomStay");
				
				for(int j=0; j<nListRoomStay.getLength(); j++)
				{
					Element eleRoomStay = (Element) nListRoomStay.item(j);
					
					String PropertyFullName =  eleRoomStay.getElementsByTagName("s1:HotelReference").item(0).getTextContent();
					
					NodeList nListTimestamp = eleRoomStay.getElementsByTagName("s1:TimeSpan");
					
					for(int k=0; k<nListTimestamp.getLength(); k++)
					{
						Element eleTimestamp = (Element) nListTimestamp.item(k);
						
						String CheckInDate = soapExecutor.getValue(eleTimestamp, "s1:StartDate");
						String CheckOutDate = soapExecutor.getValue(eleTimestamp, "s1:EndDate");
						
						
						try{
							SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
							DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
							Date d1 = format.parse(CheckInDate.substring(0, 10));
							Date d2 = format.parse(CheckOutDate.substring(0, 10));
							
							String ArrivalDate = dateFormat.format(d1);
							String DepartureDate = dateFormat.format(d2);
						}catch(Exception e)
						{}
						
					}
					
					String HotelName = eleRoomStay.getElementsByTagName("s1:HotelReference").item(0).getTextContent();
					NodeList nListHotel = eleRoomStay.getElementsByTagName("s1:HotelReference");
					
					for(int k=0; k<nListHotel.getLength(); k++)
					{
						Element eleHotel = (Element) nListHotel.item(k);
						
						String HotelCode = eleHotel.getAttribute("hotelCode");
						String ChainCode = eleHotel.getAttribute("chainCode");
					}
				}
				
			}
			
			Element elePayRoutings = (Element) EleHotelResv.getElementsByTagName("s3:PayRoutings").item(0);
			
			String RoomNo = elePayRoutings.getAttribute("Room");
			
		} else if(isSuccess.equalsIgnoreCase("FAIL")) {
			String Status = "error";
		}
	}
	
	static String payload()
	{
		String payload = "<env:Envelope xmlns:env=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n" + 
				"   <env:Header>\r\n" + 
				"      <s6:OGHeader env:mustUnderstand=\"0\" primaryLangID=\"E\" transactionID=\"3297907325\" xmlns:s6=\"http://webservices.micros.com/og/4.3/Core/\">\r\n" + 
				"         <s6:Origin entityID=\"KIOSK\" systemType=\"PMS\"/>\r\n" + 
				"         <s6:Destination entityID=\"KIOSK\" systemType=\"WEB\"/>\r\n" + 
				"         <s6:Authentication>\r\n" + 
				"            <s6:UserCredentials>\r\n" + 
				"               <s6:UserName>KIOSK</s6:UserName>\r\n" + 
				"               <s6:UserPassword>$$$KIOSK$$</s6:UserPassword>\r\n" + 
				"               <s6:Domain>BLRWE</s6:Domain>\r\n" + 
				"            </s6:UserCredentials>\r\n" + 
				"         </s6:Authentication>\r\n" + 
				"      </s6:OGHeader>\r\n" + 
				"      <wsse:Security env:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\">\r\n" + 
				"         <wsu:Timestamp wsu:Id=\"Timestamp-uakXWR3YR1eZzfl1pJkbkA22\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\r\n" + 
				"            <wsu:Created>2019-03-20T08:22:27Z</wsu:Created>\r\n" + 
				"            <wsu:Expires>2019-03-20T08:27:27Z</wsu:Expires>\r\n" + 
				"         </wsu:Timestamp>\r\n" + 
				"      </wsse:Security>\r\n" + 
				"   </env:Header>\r\n" + 
				"   <env:Body>\r\n" + 
				"      <s0:FetchBookingResponse xmlns:s0=\"http://webservices.micros.com/ows/5.1/Reservation.wsdl\">\r\n" + 
				"         <s0:Result resultStatusFlag=\"SUCCESS\">\r\n" + 
				"            <s2:Text xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"            <s2:IDs xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"            <s2:OperaErrorCode xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"            <s1:GDSError elementId=\"\" errorCode=\"\" xmlns:s1=\"http://webservices.micros.com/og/4.3/HotelCommon/\"/>\r\n" + 
				"         </s0:Result>\r\n" + 
				"         <s0:HotelReservation returningGuest=\"\" checkInTime=\"\" referralYN=\"N\" printRate=\"true\" financialTransactionExists=\"true\" computedReservationStatus=\"CHECKEDOUT\" checkOutTime=\"09:35:00.0000000+05:30\" messagesCount=\"\" messageExists=\"\" alertsCount=\"\" alertExists=\"\" queueNumber=\"\" queueExists=\"false\" shareExists=\"\" roomPreferencesCount=\"\" roomPreferenceExists=\"\" specialsCount=\"\" specialsExists=\"\" tracesCount=\"\" tracesExists=\"\" commentsCount=\"\" commentsExists=\"\" OptInComplete=\"false\" OptIn=\"false\" DoNotMoveRoom=\"false\" totalCreditCardSurcharges=\"\" keyExpirationDate=\"\" preRegisterFlag=\"\" allowPreRegisteration=\"\" attachPreferenceProfile=\"\" group=\"\" remoteCo=\"\" noPost=\"\" walkIn=\"\" inactiveDate=\"\" updateDate=\"\" updateUser=\"\" insertDate=\"\" insertUser=\"\" redemReservationFlag=\"false\" onBehalfFlag=\"false\" compRoutingAuthorizer=\"\" compRoutingFlag=\"\" authorizer=\"\" originCode=\"PMS\" sourceCode=\"PMS\" marketSegment=\"RAC\" reservationStatus=\"CHECKEDOUT\" reservationAction=\"\">\r\n" + 
				"            <s3:UniqueIDList xmlns:s3=\"http://webservices.micros.com/og/4.3/Reservation/\">\r\n" + 
				"               <s2:UniqueID source=\"\" type=\"INTERNAL\" xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\">107799096</s2:UniqueID>\r\n" + 
				"               <s2:UniqueID source=\"RESVID\" type=\"INTERNAL\" xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\">102135879</s2:UniqueID>\r\n" + 
				"               <s2:UniqueID source=\"LEGNUMBER\" type=\"INTERNAL\" xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\">1</s2:UniqueID>\r\n" + 
				"            </s3:UniqueIDList>\r\n" + 
				"            <s3:ExternalSystemNumberList xmlns:s3=\"http://webservices.micros.com/og/4.3/Reservation/\"/>\r\n" + 
				"            <s3:RoomStays xmlns:s3=\"http://webservices.micros.com/og/4.3/Reservation/\">\r\n" + 
				"               <s1:RoomStay isAlternate=\"\" xmlns:s1=\"http://webservices.micros.com/og/4.3/HotelCommon/\">\r\n" + 
				"                  <s1:RatePlans>\r\n" + 
				"                     <s1:RatePlan postingRhythmNights=\"\" discountRatePercent=\"\" discountRateAmount=\"\" repeatPostingRhythm=\"\" postingRhythm=\"\" rateTypeIndicator=\"\" rankRate=\"\" blockName=\"\" taxInclusive=\"\" hasPackage=\"\" asbRateCycle=\"\" commissionCode=\"\" redemRate=\"\" awardType=\"\" ratePlanName=\"\" suppressRate=\"false\" mandatoryDeposit=\"\" commissionYn=\"\" hold=\"\" expirationDate=\"\" effectiveDate=\"\" qualifyingIdValue=\"\" qualifyingIdType=\"\" promotionCode=\"\" ratePlanCode=\"NN80\" ratePlanCategory=\"\">\r\n" + 
				"                        <s1:RatePlanDescription>\r\n" + 
				"                           <s1:URL/>\r\n" + 
				"                           <s1:Text language=\"\" formatted=\"\">Superior Rate Plan</s1:Text>\r\n" + 
				"                           <s1:Image/>\r\n" + 
				"                        </s1:RatePlanDescription>\r\n" + 
				"                        <s1:RatePlanDescription xsi:type=\"s1:SpecialRequest\" requestCode=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
				"                           <s1:URL/>\r\n" + 
				"                           <s1:Text language=\"\" formatted=\"\"/>\r\n" + 
				"                           <s1:Image/>\r\n" + 
				"                           <s1:SpecialRequestId/>\r\n" + 
				"                        </s1:RatePlanDescription>\r\n" + 
				"                        <s1:RatePlanDescription xsi:type=\"s1:ReservationComment\" guestViewable=\"\" commentOriginatorCode=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
				"                           <s1:URL/>\r\n" + 
				"                           <s1:Text language=\"\" formatted=\"\"/>\r\n" + 
				"                           <s1:Image/>\r\n" + 
				"                           <s1:CommentId/>\r\n" + 
				"                           <s1:InternalYn/>\r\n" + 
				"                           <s1:CommentType/>\r\n" + 
				"                        </s1:RatePlanDescription>\r\n" + 
				"                        <s1:RatePlanDescription xsi:type=\"s1:ReservationTrace\" resolved=\"\" department=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
				"                           <s1:URL/>\r\n" + 
				"                           <s1:Text language=\"\" formatted=\"\"/>\r\n" + 
				"                           <s1:Image/>\r\n" + 
				"                           <s1:TraceId/>\r\n" + 
				"                           <s1:TraceDate/>\r\n" + 
				"                           <s1:TraceTime/>\r\n" + 
				"                           <s1:ResolvedOn/>\r\n" + 
				"                           <s1:ResolvedBy/>\r\n" + 
				"                        </s1:RatePlanDescription>\r\n" + 
				"                        <s1:RatePlanShortDescription>\r\n" + 
				"                           <s1:URL/>\r\n" + 
				"                           <s1:Text language=\"\" formatted=\"\"/>\r\n" + 
				"                           <s1:Image/>\r\n" + 
				"                        </s1:RatePlanShortDescription>\r\n" + 
				"                        <s1:RatePlanShortDescription xsi:type=\"s1:SpecialRequest\" requestCode=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
				"                           <s1:URL/>\r\n" + 
				"                           <s1:Text language=\"\" formatted=\"\"/>\r\n" + 
				"                           <s1:Image/>\r\n" + 
				"                           <s1:SpecialRequestId/>\r\n" + 
				"                        </s1:RatePlanShortDescription>\r\n" + 
				"                        <s1:RatePlanShortDescription xsi:type=\"s1:ReservationComment\" guestViewable=\"\" commentOriginatorCode=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
				"                           <s1:URL/>\r\n" + 
				"                           <s1:Text language=\"\" formatted=\"\"/>\r\n" + 
				"                           <s1:Image/>\r\n" + 
				"                           <s1:CommentId/>\r\n" + 
				"                           <s1:InternalYn/>\r\n" + 
				"                           <s1:CommentType/>\r\n" + 
				"                        </s1:RatePlanShortDescription>\r\n" + 
				"                        <s1:RatePlanShortDescription xsi:type=\"s1:ReservationTrace\" resolved=\"\" department=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
				"                           <s1:URL/>\r\n" + 
				"                           <s1:Text language=\"\" formatted=\"\"/>\r\n" + 
				"                           <s1:Image/>\r\n" + 
				"                           <s1:TraceId/>\r\n" + 
				"                           <s1:TraceDate/>\r\n" + 
				"                           <s1:TraceTime/>\r\n" + 
				"                           <s1:ResolvedOn/>\r\n" + 
				"                           <s1:ResolvedBy/>\r\n" + 
				"                        </s1:RatePlanShortDescription>\r\n" + 
				"                        <s1:Commission currencyCode=\"\" percent=\"\">\r\n" + 
				"                           <s1:CommissionPayableAmount currencyText=\"\" decimals=\"\" currencyCode=\"\"/>\r\n" + 
				"                           <s1:Comment>\r\n" + 
				"                              <s1:URL/>\r\n" + 
				"                              <s1:Text language=\"\" formatted=\"\"/>\r\n" + 
				"                              <s1:Image/>\r\n" + 
				"                           </s1:Comment>\r\n" + 
				"                           <s1:Comment xsi:type=\"s1:SpecialRequest\" requestCode=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
				"                              <s1:URL/>\r\n" + 
				"                              <s1:Text language=\"\" formatted=\"\"/>\r\n" + 
				"                              <s1:Image/>\r\n" + 
				"                              <s1:SpecialRequestId/>\r\n" + 
				"                           </s1:Comment>\r\n" + 
				"                           <s1:Comment xsi:type=\"s1:ReservationComment\" guestViewable=\"\" commentOriginatorCode=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
				"                              <s1:URL/>\r\n" + 
				"                              <s1:Text language=\"\" formatted=\"\"/>\r\n" + 
				"                              <s1:Image/>\r\n" + 
				"                              <s1:CommentId/>\r\n" + 
				"                              <s1:InternalYn/>\r\n" + 
				"                              <s1:CommentType/>\r\n" + 
				"                           </s1:Comment>\r\n" + 
				"                           <s1:Comment xsi:type=\"s1:ReservationTrace\" resolved=\"\" department=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
				"                              <s1:URL/>\r\n" + 
				"                              <s1:Text language=\"\" formatted=\"\"/>\r\n" + 
				"                              <s1:Image/>\r\n" + 
				"                              <s1:TraceId/>\r\n" + 
				"                              <s1:TraceDate/>\r\n" + 
				"                              <s1:TraceTime/>\r\n" + 
				"                              <s1:ResolvedOn/>\r\n" + 
				"                              <s1:ResolvedBy/>\r\n" + 
				"                           </s1:Comment>\r\n" + 
				"                        </s1:Commission>\r\n" + 
				"                        <s1:AdditionalDetails>\r\n" + 
				"                           <s1:AdditionalDetail otherDetailType=\"\" detailType=\"CancelPolicy\">\r\n" + 
				"                              <s1:AdditionalDetailDescription>\r\n" + 
				"                                 <s1:URL/>\r\n" + 
				"                                 <s1:Text language=\"\" formatted=\"\">Cancel By 14-FEB-19</s1:Text>\r\n" + 
				"                                 <s1:Image/>\r\n" + 
				"                              </s1:AdditionalDetailDescription>\r\n" + 
				"                              <s1:AdditionalDetailDescription xsi:type=\"s1:SpecialRequest\" requestCode=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
				"                                 <s1:URL/>\r\n" + 
				"                                 <s1:Text language=\"\" formatted=\"\"/>\r\n" + 
				"                                 <s1:Image/>\r\n" + 
				"                                 <s1:SpecialRequestId/>\r\n" + 
				"                              </s1:AdditionalDetailDescription>\r\n" + 
				"                              <s1:AdditionalDetailDescription xsi:type=\"s1:ReservationComment\" guestViewable=\"\" commentOriginatorCode=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
				"                                 <s1:URL/>\r\n" + 
				"                                 <s1:Text language=\"\" formatted=\"\"/>\r\n" + 
				"                                 <s1:Image/>\r\n" + 
				"                                 <s1:CommentId/>\r\n" + 
				"                                 <s1:InternalYn/>\r\n" + 
				"                                 <s1:CommentType/>\r\n" + 
				"                              </s1:AdditionalDetailDescription>\r\n" + 
				"                              <s1:AdditionalDetailDescription xsi:type=\"s1:ReservationTrace\" resolved=\"\" department=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
				"                                 <s1:URL/>\r\n" + 
				"                                 <s1:Text language=\"\" formatted=\"\"/>\r\n" + 
				"                                 <s1:Image/>\r\n" + 
				"                                 <s1:TraceId/>\r\n" + 
				"                                 <s1:TraceDate/>\r\n" + 
				"                                 <s1:TraceTime/>\r\n" + 
				"                                 <s1:ResolvedOn/>\r\n" + 
				"                                 <s1:ResolvedBy/>\r\n" + 
				"                              </s1:AdditionalDetailDescription>\r\n" + 
				"                           </s1:AdditionalDetail>\r\n" + 
				"                           <s1:AdditionalDetail otherDetailType=\"\" detailType=\"TaxInformation\">\r\n" + 
				"                              <s1:AdditionalDetailDescription>\r\n" + 
				"                                 <s1:URL/>\r\n" + 
				"                                 <s1:Text language=\"\" formatted=\"\">Tax not included CGST Room Charge 0 PCT SGST Room Charge 0 PCT CGST Room Charge 6 PCT SGST Room Charge 6 PCT CGST Room Charge 9 PCT SGST Room Charge 9 PCT CGST Room Charge 14 PCT SGST Room Charge 14 PCT</s1:Text>\r\n" + 
				"                                 <s1:Image/>\r\n" + 
				"                              </s1:AdditionalDetailDescription>\r\n" + 
				"                              <s1:AdditionalDetailDescription xsi:type=\"s1:SpecialRequest\" requestCode=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
				"                                 <s1:URL/>\r\n" + 
				"                                 <s1:Text language=\"\" formatted=\"\"/>\r\n" + 
				"                                 <s1:Image/>\r\n" + 
				"                                 <s1:SpecialRequestId/>\r\n" + 
				"                              </s1:AdditionalDetailDescription>\r\n" + 
				"                              <s1:AdditionalDetailDescription xsi:type=\"s1:ReservationComment\" guestViewable=\"\" commentOriginatorCode=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
				"                                 <s1:URL/>\r\n" + 
				"                                 <s1:Text language=\"\" formatted=\"\"/>\r\n" + 
				"                                 <s1:Image/>\r\n" + 
				"                                 <s1:CommentId/>\r\n" + 
				"                                 <s1:InternalYn/>\r\n" + 
				"                                 <s1:CommentType/>\r\n" + 
				"                              </s1:AdditionalDetailDescription>\r\n" + 
				"                              <s1:AdditionalDetailDescription xsi:type=\"s1:ReservationTrace\" resolved=\"\" department=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
				"                                 <s1:URL/>\r\n" + 
				"                                 <s1:Text language=\"\" formatted=\"\"/>\r\n" + 
				"                                 <s1:Image/>\r\n" + 
				"                                 <s1:TraceId/>\r\n" + 
				"                                 <s1:TraceDate/>\r\n" + 
				"                                 <s1:TraceTime/>\r\n" + 
				"                                 <s1:ResolvedOn/>\r\n" + 
				"                                 <s1:ResolvedBy/>\r\n" + 
				"                              </s1:AdditionalDetailDescription>\r\n" + 
				"                           </s1:AdditionalDetail>\r\n" + 
				"                           <s1:AdditionalDetail otherDetailType=\"\" detailType=\"MarketingInformation\">\r\n" + 
				"                              <s1:AdditionalDetailDescription>\r\n" + 
				"                                 <s1:URL/>\r\n" + 
				"                                 <s1:Text language=\"\" formatted=\"\">Thank you for booking</s1:Text>\r\n" + 
				"                                 <s1:Image/>\r\n" + 
				"                              </s1:AdditionalDetailDescription>\r\n" + 
				"                              <s1:AdditionalDetailDescription xsi:type=\"s1:SpecialRequest\" requestCode=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
				"                                 <s1:URL/>\r\n" + 
				"                                 <s1:Text language=\"\" formatted=\"\"/>\r\n" + 
				"                                 <s1:Image/>\r\n" + 
				"                                 <s1:SpecialRequestId/>\r\n" + 
				"                              </s1:AdditionalDetailDescription>\r\n" + 
				"                              <s1:AdditionalDetailDescription xsi:type=\"s1:ReservationComment\" guestViewable=\"\" commentOriginatorCode=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
				"                                 <s1:URL/>\r\n" + 
				"                                 <s1:Text language=\"\" formatted=\"\"/>\r\n" + 
				"                                 <s1:Image/>\r\n" + 
				"                                 <s1:CommentId/>\r\n" + 
				"                                 <s1:InternalYn/>\r\n" + 
				"                                 <s1:CommentType/>\r\n" + 
				"                              </s1:AdditionalDetailDescription>\r\n" + 
				"                              <s1:AdditionalDetailDescription xsi:type=\"s1:ReservationTrace\" resolved=\"\" department=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
				"                                 <s1:URL/>\r\n" + 
				"                                 <s1:Text language=\"\" formatted=\"\"/>\r\n" + 
				"                                 <s1:Image/>\r\n" + 
				"                                 <s1:TraceId/>\r\n" + 
				"                                 <s1:TraceDate/>\r\n" + 
				"                                 <s1:TraceTime/>\r\n" + 
				"                                 <s1:ResolvedOn/>\r\n" + 
				"                                 <s1:ResolvedBy/>\r\n" + 
				"                              </s1:AdditionalDetailDescription>\r\n" + 
				"                           </s1:AdditionalDetail>\r\n" + 
				"                           <s1:AdditionalDetail otherDetailType=\"\" detailType=\"DepositPolicy\">\r\n" + 
				"                              <s1:AdditionalDetailDescription>\r\n" + 
				"                                 <s1:URL/>\r\n" + 
				"                                 <s1:Text language=\"\" formatted=\"\">A deposit is not required for guarantee of your reservation</s1:Text>\r\n" + 
				"                                 <s1:Image/>\r\n" + 
				"                              </s1:AdditionalDetailDescription>\r\n" + 
				"                              <s1:AdditionalDetailDescription xsi:type=\"s1:SpecialRequest\" requestCode=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
				"                                 <s1:URL/>\r\n" + 
				"                                 <s1:Text language=\"\" formatted=\"\"/>\r\n" + 
				"                                 <s1:Image/>\r\n" + 
				"                                 <s1:SpecialRequestId/>\r\n" + 
				"                              </s1:AdditionalDetailDescription>\r\n" + 
				"                              <s1:AdditionalDetailDescription xsi:type=\"s1:ReservationComment\" guestViewable=\"\" commentOriginatorCode=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
				"                                 <s1:URL/>\r\n" + 
				"                                 <s1:Text language=\"\" formatted=\"\"/>\r\n" + 
				"                                 <s1:Image/>\r\n" + 
				"                                 <s1:CommentId/>\r\n" + 
				"                                 <s1:InternalYn/>\r\n" + 
				"                                 <s1:CommentType/>\r\n" + 
				"                              </s1:AdditionalDetailDescription>\r\n" + 
				"                              <s1:AdditionalDetailDescription xsi:type=\"s1:ReservationTrace\" resolved=\"\" department=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
				"                                 <s1:URL/>\r\n" + 
				"                                 <s1:Text language=\"\" formatted=\"\"/>\r\n" + 
				"                                 <s1:Image/>\r\n" + 
				"                                 <s1:TraceId/>\r\n" + 
				"                                 <s1:TraceDate/>\r\n" + 
				"                                 <s1:TraceTime/>\r\n" + 
				"                                 <s1:ResolvedOn/>\r\n" + 
				"                                 <s1:ResolvedBy/>\r\n" + 
				"                              </s1:AdditionalDetailDescription>\r\n" + 
				"                           </s1:AdditionalDetail>\r\n" + 
				"                        </s1:AdditionalDetails>\r\n" + 
				"                        <s1:CancellationDateTime period=\"\">0001-01-01T00:00:00</s1:CancellationDateTime>\r\n" + 
				"                        <s1:DepositRequired>\r\n" + 
				"                           <s1:DepositAmount currencyText=\"\" decimals=\"2\" currencyCode=\"INR\">0</s1:DepositAmount>\r\n" + 
				"                           <s1:DueDate/>\r\n" + 
				"                           <s1:DepositDueAmount currencyText=\"\" decimals=\"2\" currencyCode=\"INR\">0</s1:DepositDueAmount>\r\n" + 
				"                        </s1:DepositRequired>\r\n" + 
				"                        <s1:GdsFlags>\r\n" + 
				"                           <s1:LateArrivalTime/>\r\n" + 
				"                           <s1:CancellationCode/>\r\n" + 
				"                           <s1:GuarCancelFlag/>\r\n" + 
				"                        </s1:GdsFlags>\r\n" + 
				"                        <s1:GuaranteeDetails/>\r\n" + 
				"                        <s1:MealPlanCodes>\r\n" + 
				"                           <s1:Amenities/>\r\n" + 
				"                        </s1:MealPlanCodes>\r\n" + 
				"                        <s1:Packages/>\r\n" + 
				"                        <s1:Discount>\r\n" + 
				"                           <s1:DiscountAmount/>\r\n" + 
				"                           <s1:DiscountType/>\r\n" + 
				"                           <s1:DiscountReason/>\r\n" + 
				"                        </s1:Discount>\r\n" + 
				"                     </s1:RatePlan>\r\n" + 
				"                  </s1:RatePlans>\r\n" + 
				"                  <s1:RoomTypes>\r\n" + 
				"                     <s1:RoomType minimumRoomsAvailable=\"\" roomServiceStatus=\"SK\" pseudoRoom=\"\" roomClass=\"\" roomStatus=\"DI\" roomToChargeName=\"\" roomToChargeCode=\"ATG\" roomTypeName=\"\" expirationDate=\"\" effectiveDate=\"\" isRoom=\"\" numberOfUnits=\"1\" invBlockCode=\"\" upgradeFromCode=\"\" feature=\"\" roomTypeCode=\"ATG\">\r\n" + 
				"                        <s1:RoomTypeDescription>\r\n" + 
				"                           <s1:URL/>\r\n" + 
				"                           <s1:Text language=\"\" formatted=\"\">Luxury Grande Room/ Garden View/ Twin Bed/ Basic Wifi Comp</s1:Text>\r\n" + 
				"                           <s1:Image/>\r\n" + 
				"                        </s1:RoomTypeDescription>\r\n" + 
				"                        <s1:RoomTypeDescription xsi:type=\"s1:SpecialRequest\" requestCode=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
				"                           <s1:URL/>\r\n" + 
				"                           <s1:Text language=\"\" formatted=\"\"/>\r\n" + 
				"                           <s1:Image/>\r\n" + 
				"                           <s1:SpecialRequestId/>\r\n" + 
				"                        </s1:RoomTypeDescription>\r\n" + 
				"                        <s1:RoomTypeDescription xsi:type=\"s1:ReservationComment\" guestViewable=\"\" commentOriginatorCode=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
				"                           <s1:URL/>\r\n" + 
				"                           <s1:Text language=\"\" formatted=\"\"/>\r\n" + 
				"                           <s1:Image/>\r\n" + 
				"                           <s1:CommentId/>\r\n" + 
				"                           <s1:InternalYn/>\r\n" + 
				"                           <s1:CommentType/>\r\n" + 
				"                        </s1:RoomTypeDescription>\r\n" + 
				"                        <s1:RoomTypeDescription xsi:type=\"s1:ReservationTrace\" resolved=\"\" department=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
				"                           <s1:URL/>\r\n" + 
				"                           <s1:Text language=\"\" formatted=\"\"/>\r\n" + 
				"                           <s1:Image/>\r\n" + 
				"                           <s1:TraceId/>\r\n" + 
				"                           <s1:TraceDate/>\r\n" + 
				"                           <s1:TraceTime/>\r\n" + 
				"                           <s1:ResolvedOn/>\r\n" + 
				"                           <s1:ResolvedBy/>\r\n" + 
				"                        </s1:RoomTypeDescription>\r\n" + 
				"                        <s1:RoomTypeShortDescription>\r\n" + 
				"                           <s1:URL/>\r\n" + 
				"                           <s1:Text language=\"\" formatted=\"\">Luxury Grande Room/ Twin Bed</s1:Text>\r\n" + 
				"                           <s1:Image/>\r\n" + 
				"                        </s1:RoomTypeShortDescription>\r\n" + 
				"                        <s1:RoomTypeShortDescription xsi:type=\"s1:SpecialRequest\" requestCode=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
				"                           <s1:URL/>\r\n" + 
				"                           <s1:Text language=\"\" formatted=\"\"/>\r\n" + 
				"                           <s1:Image/>\r\n" + 
				"                           <s1:SpecialRequestId/>\r\n" + 
				"                        </s1:RoomTypeShortDescription>\r\n" + 
				"                        <s1:RoomTypeShortDescription xsi:type=\"s1:ReservationComment\" guestViewable=\"\" commentOriginatorCode=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
				"                           <s1:URL/>\r\n" + 
				"                           <s1:Text language=\"\" formatted=\"\"/>\r\n" + 
				"                           <s1:Image/>\r\n" + 
				"                           <s1:CommentId/>\r\n" + 
				"                           <s1:InternalYn/>\r\n" + 
				"                           <s1:CommentType/>\r\n" + 
				"                        </s1:RoomTypeShortDescription>\r\n" + 
				"                        <s1:RoomTypeShortDescription xsi:type=\"s1:ReservationTrace\" resolved=\"\" department=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
				"                           <s1:URL/>\r\n" + 
				"                           <s1:Text language=\"\" formatted=\"\"/>\r\n" + 
				"                           <s1:Image/>\r\n" + 
				"                           <s1:TraceId/>\r\n" + 
				"                           <s1:TraceDate/>\r\n" + 
				"                           <s1:TraceTime/>\r\n" + 
				"                           <s1:ResolvedOn/>\r\n" + 
				"                           <s1:ResolvedBy/>\r\n" + 
				"                        </s1:RoomTypeShortDescription>\r\n" + 
				"                        <s1:RoomNumber>1420</s1:RoomNumber>\r\n" + 
				"                        <s1:RoomToChargeDescription>\r\n" + 
				"                           <s1:URL/>\r\n" + 
				"                           <s1:Text language=\"\" formatted=\"\">Luxury Grande Room/ Garden View/ Twin Bed/ Basic Wifi Comp</s1:Text>\r\n" + 
				"                           <s1:Image/>\r\n" + 
				"                        </s1:RoomToChargeDescription>\r\n" + 
				"                        <s1:RoomToChargeDescription xsi:type=\"s1:SpecialRequest\" requestCode=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
				"                           <s1:URL/>\r\n" + 
				"                           <s1:Text language=\"\" formatted=\"\"/>\r\n" + 
				"                           <s1:Image/>\r\n" + 
				"                           <s1:SpecialRequestId/>\r\n" + 
				"                        </s1:RoomToChargeDescription>\r\n" + 
				"                        <s1:RoomToChargeDescription xsi:type=\"s1:ReservationComment\" guestViewable=\"\" commentOriginatorCode=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
				"                           <s1:URL/>\r\n" + 
				"                           <s1:Text language=\"\" formatted=\"\"/>\r\n" + 
				"                           <s1:Image/>\r\n" + 
				"                           <s1:CommentId/>\r\n" + 
				"                           <s1:InternalYn/>\r\n" + 
				"                           <s1:CommentType/>\r\n" + 
				"                        </s1:RoomToChargeDescription>\r\n" + 
				"                        <s1:RoomToChargeDescription xsi:type=\"s1:ReservationTrace\" resolved=\"\" department=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
				"                           <s1:URL/>\r\n" + 
				"                           <s1:Text language=\"\" formatted=\"\"/>\r\n" + 
				"                           <s1:Image/>\r\n" + 
				"                           <s1:TraceId/>\r\n" + 
				"                           <s1:TraceDate/>\r\n" + 
				"                           <s1:TraceTime/>\r\n" + 
				"                           <s1:ResolvedOn/>\r\n" + 
				"                           <s1:ResolvedBy/>\r\n" + 
				"                        </s1:RoomToChargeDescription>\r\n" + 
				"                        <s1:RoomToChargeShortDescription>\r\n" + 
				"                           <s1:URL/>\r\n" + 
				"                           <s1:Text language=\"\" formatted=\"\">Luxury Grande Room/ Twin Bed</s1:Text>\r\n" + 
				"                           <s1:Image/>\r\n" + 
				"                        </s1:RoomToChargeShortDescription>\r\n" + 
				"                        <s1:RoomToChargeShortDescription xsi:type=\"s1:SpecialRequest\" requestCode=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
				"                           <s1:URL/>\r\n" + 
				"                           <s1:Text language=\"\" formatted=\"\"/>\r\n" + 
				"                           <s1:Image/>\r\n" + 
				"                           <s1:SpecialRequestId/>\r\n" + 
				"                        </s1:RoomToChargeShortDescription>\r\n" + 
				"                        <s1:RoomToChargeShortDescription xsi:type=\"s1:ReservationComment\" guestViewable=\"\" commentOriginatorCode=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
				"                           <s1:URL/>\r\n" + 
				"                           <s1:Text language=\"\" formatted=\"\"/>\r\n" + 
				"                           <s1:Image/>\r\n" + 
				"                           <s1:CommentId/>\r\n" + 
				"                           <s1:InternalYn/>\r\n" + 
				"                           <s1:CommentType/>\r\n" + 
				"                        </s1:RoomToChargeShortDescription>\r\n" + 
				"                        <s1:RoomToChargeShortDescription xsi:type=\"s1:ReservationTrace\" resolved=\"\" department=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
				"                           <s1:URL/>\r\n" + 
				"                           <s1:Text language=\"\" formatted=\"\"/>\r\n" + 
				"                           <s1:Image/>\r\n" + 
				"                           <s1:TraceId/>\r\n" + 
				"                           <s1:TraceDate/>\r\n" + 
				"                           <s1:TraceTime/>\r\n" + 
				"                           <s1:ResolvedOn/>\r\n" + 
				"                           <s1:ResolvedBy/>\r\n" + 
				"                        </s1:RoomToChargeShortDescription>\r\n" + 
				"                        <s1:AmenityInfo>\r\n" + 
				"                           <s1:Amenities/>\r\n" + 
				"                        </s1:AmenityInfo>\r\n" + 
				"                        <s1:RoomFeatures/>\r\n" + 
				"                     </s1:RoomType>\r\n" + 
				"                  </s1:RoomTypes>\r\n" + 
				"                  <s1:RoomRates>\r\n" + 
				"                     <s1:RoomRate pointsChangeIndicator=\"\" hasPackage=\"\" redemRate=\"\" suppressRate=\"false\" expirationDate=\"\" effectiveDate=\"\" ratePlanCode=\"NN80\" roomTypeCode=\"ATG\">\r\n" + 
				"                        <s1:Rates>\r\n" + 
				"                           <s1:Rate rateChangeIndicator=\"\" otherRateOccurrence=\"\" rateOccurrence=\"\" expirationDate=\"\" effectiveDate=\"\">\r\n" + 
				"                              <s1:Base currencyText=\"\" decimals=\"2\" currencyCode=\"INR\">15500</s1:Base>\r\n" + 
				"                              <s1:AdditionalGuestAmounts/>\r\n" + 
				"                              <s1:AdditionalBedAmounts/>\r\n" + 
				"                              <s1:GdsTotalPricingTaxes/>\r\n" + 
				"                              <s1:Points/>\r\n" + 
				"                           </s1:Rate>\r\n" + 
				"                        </s1:Rates>\r\n" + 
				"                        <s1:InvBlockDescription>\r\n" + 
				"                           <s1:URL/>\r\n" + 
				"                           <s1:Text language=\"\" formatted=\"\"/>\r\n" + 
				"                           <s1:Image/>\r\n" + 
				"                        </s1:InvBlockDescription>\r\n" + 
				"                        <s1:InvBlockDescription xsi:type=\"s1:SpecialRequest\" requestCode=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
				"                           <s1:URL/>\r\n" + 
				"                           <s1:Text language=\"\" formatted=\"\"/>\r\n" + 
				"                           <s1:Image/>\r\n" + 
				"                           <s1:SpecialRequestId/>\r\n" + 
				"                        </s1:InvBlockDescription>\r\n" + 
				"                        <s1:InvBlockDescription xsi:type=\"s1:ReservationComment\" guestViewable=\"\" commentOriginatorCode=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
				"                           <s1:URL/>\r\n" + 
				"                           <s1:Text language=\"\" formatted=\"\"/>\r\n" + 
				"                           <s1:Image/>\r\n" + 
				"                           <s1:CommentId/>\r\n" + 
				"                           <s1:InternalYn/>\r\n" + 
				"                           <s1:CommentType/>\r\n" + 
				"                        </s1:InvBlockDescription>\r\n" + 
				"                        <s1:InvBlockDescription xsi:type=\"s1:ReservationTrace\" resolved=\"\" department=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
				"                           <s1:URL/>\r\n" + 
				"                           <s1:Text language=\"\" formatted=\"\"/>\r\n" + 
				"                           <s1:Image/>\r\n" + 
				"                           <s1:TraceId/>\r\n" + 
				"                           <s1:TraceDate/>\r\n" + 
				"                           <s1:TraceTime/>\r\n" + 
				"                           <s1:ResolvedOn/>\r\n" + 
				"                           <s1:ResolvedBy/>\r\n" + 
				"                        </s1:InvBlockDescription>\r\n" + 
				"                        <s1:Total currencyText=\"\" decimals=\"\" currencyCode=\"\"/>\r\n" + 
				"                        <s1:TotalPoints/>\r\n" + 
				"                        <s1:GdsTotalPricing>\r\n" + 
				"                           <s1:TotalInclusiveRoomRate currencyText=\"\" decimals=\"\" currencyCode=\"\"/>\r\n" + 
				"                           <s1:TotalExclusiveRoomRate currencyText=\"\" decimals=\"\" currencyCode=\"\"/>\r\n" + 
				"                           <s1:TotalTax currencyText=\"\" decimals=\"\" currencyCode=\"\"/>\r\n" + 
				"                           <s1:TotalSurCharge currencyText=\"\" decimals=\"\" currencyCode=\"\"/>\r\n" + 
				"                           <s1:TaxQualifier/>\r\n" + 
				"                           <s1:MatchingQualifier/>\r\n" + 
				"                        </s1:GdsTotalPricing>\r\n" + 
				"                        <s1:Packages/>\r\n" + 
				"                     </s1:RoomRate>\r\n" + 
				"                  </s1:RoomRates>\r\n" + 
				"                  <s1:GuestCounts isPerRoom=\"true\">\r\n" + 
				"                     <s1:GuestCount count=\"1\" age=\"\" otherAgeQualifyingCode=\"\" ageQualifyingCode=\"ADULT\"/>\r\n" + 
				"                     <s1:GuestCount count=\"0\" age=\"\" otherAgeQualifyingCode=\"\" ageQualifyingCode=\"CHILD\"/>\r\n" + 
				"                     <s1:GuestCount count=\"0\" age=\"\" otherAgeQualifyingCode=\"\" ageQualifyingCode=\"CHILDBUCKET1\"/>\r\n" + 
				"                     <s1:GuestCount count=\"0\" age=\"\" otherAgeQualifyingCode=\"\" ageQualifyingCode=\"CHILDBUCKET2\"/>\r\n" + 
				"                     <s1:GuestCount count=\"0\" age=\"\" otherAgeQualifyingCode=\"\" ageQualifyingCode=\"CHILDBUCKET3\"/>\r\n" + 
				"                  </s1:GuestCounts>\r\n" + 
				"                  <s1:TimeSpan>\r\n" + 
				"                     <s1:StartDate>2019-02-14T00:00:00</s1:StartDate>\r\n" + 
				"                     <s1:EndDate>2019-02-14T00:00:00</s1:EndDate>\r\n" + 
				"                     <s1:Duration/>\r\n" + 
				"                  </s1:TimeSpan>\r\n" + 
				"                  <s1:TimeSpan xsi:type=\"s0:FutureBookingSummaryRequestQueryDateRange\" dateType=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
				"                     <s1:StartDate/>\r\n" + 
				"                     <s1:EndDate/>\r\n" + 
				"                     <s1:Duration/>\r\n" + 
				"                  </s1:TimeSpan>\r\n" + 
				"                  <s1:Guarantee requirementCode=\"\" paymentType=\"\" creditCardRequired=\"\" cancellationRequired=\"\" mandatoryDeposit=\"\" guaranteeType=\"CHECKED IN\">\r\n" + 
				"                     <s1:GuaranteesAccepted/>\r\n" + 
				"                     <s1:Deadline/>\r\n" + 
				"                     <s1:GuaranteeDescription>\r\n" + 
				"                        <s1:URL/>\r\n" + 
				"                        <s1:Text language=\"\" formatted=\"\"/>\r\n" + 
				"                        <s1:Image/>\r\n" + 
				"                     </s1:GuaranteeDescription>\r\n" + 
				"                     <s1:GuaranteeDescription xsi:type=\"s1:SpecialRequest\" requestCode=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
				"                        <s1:URL/>\r\n" + 
				"                        <s1:Text language=\"\" formatted=\"\"/>\r\n" + 
				"                        <s1:Image/>\r\n" + 
				"                        <s1:SpecialRequestId/>\r\n" + 
				"                     </s1:GuaranteeDescription>\r\n" + 
				"                     <s1:GuaranteeDescription xsi:type=\"s1:ReservationComment\" guestViewable=\"\" commentOriginatorCode=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
				"                        <s1:URL/>\r\n" + 
				"                        <s1:Text language=\"\" formatted=\"\"/>\r\n" + 
				"                        <s1:Image/>\r\n" + 
				"                        <s1:CommentId/>\r\n" + 
				"                        <s1:InternalYn/>\r\n" + 
				"                        <s1:CommentType/>\r\n" + 
				"                     </s1:GuaranteeDescription>\r\n" + 
				"                     <s1:GuaranteeDescription xsi:type=\"s1:ReservationTrace\" resolved=\"\" department=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
				"                        <s1:URL/>\r\n" + 
				"                        <s1:Text language=\"\" formatted=\"\"/>\r\n" + 
				"                        <s1:Image/>\r\n" + 
				"                        <s1:TraceId/>\r\n" + 
				"                        <s1:TraceDate/>\r\n" + 
				"                        <s1:TraceTime/>\r\n" + 
				"                        <s1:ResolvedOn/>\r\n" + 
				"                        <s1:ResolvedBy/>\r\n" + 
				"                     </s1:GuaranteeDescription>\r\n" + 
				"                  </s1:Guarantee>\r\n" + 
				"                  <s1:Payment>\r\n" + 
				"                     <s1:PaymentsAccepted>\r\n" + 
				"                        <s1:PaymentType>\r\n" + 
				"                           <s1:PaymentCard chipAndPin=\"\" otherCardType=\"\" cardType=\"\">\r\n" + 
				"                              <s2:cardID xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:cardCode xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:cardHolderName xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:VaultedCardData lastFourDigits=\"\" vaultedCardID=\"\" xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:cardNumber xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:seriesCode xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:Track2 xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:effectiveDate xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:expirationDate xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:EncryptedSwipe xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\">\r\n" + 
				"                                 <s2:TrackIndicator/>\r\n" + 
				"                                 <s2:SwiperType/>\r\n" + 
				"                                 <s2:SwiperID/>\r\n" + 
				"                                 <s2:MaskedPAN/>\r\n" + 
				"                                 <s2:Track1/>\r\n" + 
				"                                 <s2:Track2/>\r\n" + 
				"                                 <s2:KeySerialNumber/>\r\n" + 
				"                              </s2:EncryptedSwipe>\r\n" + 
				"                           </s1:PaymentCard>\r\n" + 
				"                           <s1:PaymentCard xsi:type=\"s4:NameCreditCard\" chipAndPin=\"\" otherCardType=\"\" cardType=\"\" inactiveDate=\"\" updateDate=\"\" updateUser=\"\" insertDate=\"\" insertUser=\"\" displaySequence=\"\" primary=\"\" externalId=\"\" operaId=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
				"                              <s2:cardID xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:cardCode xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:cardHolderName xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:VaultedCardData lastFourDigits=\"\" vaultedCardID=\"\" xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:cardNumber xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:seriesCode xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:Track2 xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:effectiveDate xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:expirationDate xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:EncryptedSwipe xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\">\r\n" + 
				"                                 <s2:TrackIndicator/>\r\n" + 
				"                                 <s2:SwiperType/>\r\n" + 
				"                                 <s2:SwiperID/>\r\n" + 
				"                                 <s2:MaskedPAN/>\r\n" + 
				"                                 <s2:Track1/>\r\n" + 
				"                                 <s2:Track2/>\r\n" + 
				"                                 <s2:KeySerialNumber/>\r\n" + 
				"                              </s2:EncryptedSwipe>\r\n" + 
				"                           </s1:PaymentCard>\r\n" + 
				"                           <s1:PaymentCard xsi:type=\"s1:CreditCardPayment\" chipAndPin=\"\" otherCardType=\"\" cardType=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
				"                              <s2:cardID xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:cardCode xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:cardHolderName xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:VaultedCardData lastFourDigits=\"\" vaultedCardID=\"\" xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:cardNumber xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:seriesCode xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:Track2 xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:effectiveDate xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:expirationDate xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:EncryptedSwipe xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\">\r\n" + 
				"                                 <s2:TrackIndicator/>\r\n" + 
				"                                 <s2:SwiperType/>\r\n" + 
				"                                 <s2:SwiperID/>\r\n" + 
				"                                 <s2:MaskedPAN/>\r\n" + 
				"                                 <s2:Track1/>\r\n" + 
				"                                 <s2:Track2/>\r\n" + 
				"                                 <s2:KeySerialNumber/>\r\n" + 
				"                              </s2:EncryptedSwipe>\r\n" + 
				"                              <s1:CIDNumber/>\r\n" + 
				"                              <s1:Address languageCode=\"\" otherAddressType=\"\" addressType=\"\">\r\n" + 
				"                                 <s2:cityName xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                                 <s2:stateProv xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                                 <s2:countryCode xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                                 <s2:postalCode xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                                 <s2:barCode xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                                 <s2:cityExtension xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              </s1:Address>\r\n" + 
				"                              <s1:Address xsi:type=\"s4:NameAddress\" languageCode=\"\" otherAddressType=\"\" addressType=\"\" inactiveDate=\"\" updateDate=\"\" updateUser=\"\" insertDate=\"\" insertUser=\"\" displaySequence=\"\" primary=\"\" externalId=\"\" operaId=\"\">\r\n" + 
				"                                 <s2:cityName xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                                 <s2:stateProv xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                                 <s2:countryCode xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                                 <s2:postalCode xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                                 <s2:barCode xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                                 <s2:cityExtension xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              </s1:Address>\r\n" + 
				"                              <s1:IssueNumber/>\r\n" + 
				"                              <s1:ApprovalCode/>\r\n" + 
				"                              <s1:DepositAmount currencyText=\"\" decimals=\"\" currencyCode=\"\"/>\r\n" + 
				"                           </s1:PaymentCard>\r\n" + 
				"                           <s1:OtherPayment source=\"\" value=\"\" type=\"CA\"/>\r\n" + 
				"                           <s1:PaymentVoucher voucherValidDate=\"\" voucherIssuedBy=\"\" voucherNumber=\"\"/>\r\n" + 
				"                        </s1:PaymentType>\r\n" + 
				"                     </s1:PaymentsAccepted>\r\n" + 
				"                     <s1:PaymentUsed>\r\n" + 
				"                        <s1:PaymentType>\r\n" + 
				"                           <s1:PaymentCard chipAndPin=\"\" otherCardType=\"\" cardType=\"\">\r\n" + 
				"                              <s2:cardID xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:cardCode xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:cardHolderName xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:VaultedCardData lastFourDigits=\"\" vaultedCardID=\"\" xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:cardNumber xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:seriesCode xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:Track2 xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:effectiveDate xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:expirationDate xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:EncryptedSwipe xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\">\r\n" + 
				"                                 <s2:TrackIndicator/>\r\n" + 
				"                                 <s2:SwiperType/>\r\n" + 
				"                                 <s2:SwiperID/>\r\n" + 
				"                                 <s2:MaskedPAN/>\r\n" + 
				"                                 <s2:Track1/>\r\n" + 
				"                                 <s2:Track2/>\r\n" + 
				"                                 <s2:KeySerialNumber/>\r\n" + 
				"                              </s2:EncryptedSwipe>\r\n" + 
				"                           </s1:PaymentCard>\r\n" + 
				"                           <s1:PaymentCard xsi:type=\"s4:NameCreditCard\" chipAndPin=\"\" otherCardType=\"\" cardType=\"\" inactiveDate=\"\" updateDate=\"\" updateUser=\"\" insertDate=\"\" insertUser=\"\" displaySequence=\"\" primary=\"\" externalId=\"\" operaId=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
				"                              <s2:cardID xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:cardCode xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:cardHolderName xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:VaultedCardData lastFourDigits=\"\" vaultedCardID=\"\" xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:cardNumber xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:seriesCode xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:Track2 xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:effectiveDate xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:expirationDate xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:EncryptedSwipe xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\">\r\n" + 
				"                                 <s2:TrackIndicator/>\r\n" + 
				"                                 <s2:SwiperType/>\r\n" + 
				"                                 <s2:SwiperID/>\r\n" + 
				"                                 <s2:MaskedPAN/>\r\n" + 
				"                                 <s2:Track1/>\r\n" + 
				"                                 <s2:Track2/>\r\n" + 
				"                                 <s2:KeySerialNumber/>\r\n" + 
				"                              </s2:EncryptedSwipe>\r\n" + 
				"                           </s1:PaymentCard>\r\n" + 
				"                           <s1:PaymentCard xsi:type=\"s1:CreditCardPayment\" chipAndPin=\"\" otherCardType=\"\" cardType=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
				"                              <s2:cardID xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:cardCode xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:cardHolderName xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:VaultedCardData lastFourDigits=\"\" vaultedCardID=\"\" xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:cardNumber xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:seriesCode xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:Track2 xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:effectiveDate xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:expirationDate xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:EncryptedSwipe xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\">\r\n" + 
				"                                 <s2:TrackIndicator/>\r\n" + 
				"                                 <s2:SwiperType/>\r\n" + 
				"                                 <s2:SwiperID/>\r\n" + 
				"                                 <s2:MaskedPAN/>\r\n" + 
				"                                 <s2:Track1/>\r\n" + 
				"                                 <s2:Track2/>\r\n" + 
				"                                 <s2:KeySerialNumber/>\r\n" + 
				"                              </s2:EncryptedSwipe>\r\n" + 
				"                              <s1:CIDNumber/>\r\n" + 
				"                              <s1:Address languageCode=\"\" otherAddressType=\"\" addressType=\"\">\r\n" + 
				"                                 <s2:cityName xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                                 <s2:stateProv xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                                 <s2:countryCode xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                                 <s2:postalCode xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                                 <s2:barCode xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                                 <s2:cityExtension xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              </s1:Address>\r\n" + 
				"                              <s1:Address xsi:type=\"s4:NameAddress\" languageCode=\"\" otherAddressType=\"\" addressType=\"\" inactiveDate=\"\" updateDate=\"\" updateUser=\"\" insertDate=\"\" insertUser=\"\" displaySequence=\"\" primary=\"\" externalId=\"\" operaId=\"\">\r\n" + 
				"                                 <s2:cityName xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                                 <s2:stateProv xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                                 <s2:countryCode xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                                 <s2:postalCode xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                                 <s2:barCode xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                                 <s2:cityExtension xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              </s1:Address>\r\n" + 
				"                              <s1:IssueNumber/>\r\n" + 
				"                              <s1:ApprovalCode/>\r\n" + 
				"                              <s1:DepositAmount currencyText=\"\" decimals=\"\" currencyCode=\"\"/>\r\n" + 
				"                           </s1:PaymentCard>\r\n" + 
				"                           <s1:OtherPayment source=\"\" value=\"\" type=\"\"/>\r\n" + 
				"                           <s1:PaymentVoucher voucherValidDate=\"\" voucherIssuedBy=\"\" voucherNumber=\"\"/>\r\n" + 
				"                        </s1:PaymentType>\r\n" + 
				"                        <s1:Deposit currencyText=\"\" decimals=\"\" currencyCode=\"\"/>\r\n" + 
				"                     </s1:PaymentUsed>\r\n" + 
				"                  </s1:Payment>\r\n" + 
				"                  <s1:CreditCardDeposit/>\r\n" + 
				"                  <s1:CancelPenalties/>\r\n" + 
				"                  <s1:CancelTerm cancelBy=\"\" cancelDate=\"\" cancelNumber=\"\" cancelReasonCode=\"\" otherCancelType=\"Checked Out\" cancelType=\"Other\">\r\n" + 
				"                     <s1:CancelReason>\r\n" + 
				"                        <s1:URL/>\r\n" + 
				"                        <s1:Text language=\"\" formatted=\"\"/>\r\n" + 
				"                        <s1:Image/>\r\n" + 
				"                     </s1:CancelReason>\r\n" + 
				"                     <s1:CancelReason xsi:type=\"s1:SpecialRequest\" requestCode=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
				"                        <s1:URL/>\r\n" + 
				"                        <s1:Text language=\"\" formatted=\"\"/>\r\n" + 
				"                        <s1:Image/>\r\n" + 
				"                        <s1:SpecialRequestId/>\r\n" + 
				"                     </s1:CancelReason>\r\n" + 
				"                     <s1:CancelReason xsi:type=\"s1:ReservationComment\" guestViewable=\"\" commentOriginatorCode=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
				"                        <s1:URL/>\r\n" + 
				"                        <s1:Text language=\"\" formatted=\"\"/>\r\n" + 
				"                        <s1:Image/>\r\n" + 
				"                        <s1:CommentId/>\r\n" + 
				"                        <s1:InternalYn/>\r\n" + 
				"                        <s1:CommentType/>\r\n" + 
				"                     </s1:CancelReason>\r\n" + 
				"                     <s1:CancelReason xsi:type=\"s1:ReservationTrace\" resolved=\"\" department=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
				"                        <s1:URL/>\r\n" + 
				"                        <s1:Text language=\"\" formatted=\"\"/>\r\n" + 
				"                        <s1:Image/>\r\n" + 
				"                        <s1:TraceId/>\r\n" + 
				"                        <s1:TraceDate/>\r\n" + 
				"                        <s1:TraceTime/>\r\n" + 
				"                        <s1:ResolvedOn/>\r\n" + 
				"                        <s1:ResolvedBy/>\r\n" + 
				"                     </s1:CancelReason>\r\n" + 
				"                  </s1:CancelTerm>\r\n" + 
				"                  <s1:HotelReference hotelCode=\"BLRWE\" chainCode=\"CHA\">Taj West End Bengaluru</s1:HotelReference>\r\n" + 
				"                  <s1:HotelContact>\r\n" + 
				"                     <s1:Addresses/>\r\n" + 
				"                     <s1:ContactEmails/>\r\n" + 
				"                     <s1:ContactPhones/>\r\n" + 
				"                     <s1:HotelInformation/>\r\n" + 
				"                     <s1:URIs/>\r\n" + 
				"                     <s1:Vector>\r\n" + 
				"                        <s1:Direction otherVectorDirection=\"\" vectorDirection=\"\"/>\r\n" + 
				"                        <s1:Distance otherDistanceUnit=\"\" distanceUnit=\"\"/>\r\n" + 
				"                     </s1:Vector>\r\n" + 
				"                  </s1:HotelContact>\r\n" + 
				"                  <s1:Total currencyText=\"\" decimals=\"2\" currencyCode=\"INR\">19840</s1:Total>\r\n" + 
				"                  <s1:CurrentBalance currencyText=\"\" decimals=\"2\" currencyCode=\"INR\">0</s1:CurrentBalance>\r\n" + 
				"                  <s1:ResGuestRPHs>\r\n" + 
				"                     <s1:ResGuestRPH RPH=\"0\"/>\r\n" + 
				"                  </s1:ResGuestRPHs>\r\n" + 
				"                  <s1:Comments/>\r\n" + 
				"                  <s1:SpecialRequests/>\r\n" + 
				"                  <s1:Packages/>\r\n" + 
				"                  <s1:HotelExtendedInformation>\r\n" + 
				"                     <s1:HotelInformation/>\r\n" + 
				"                     <s1:PaymentMethods/>\r\n" + 
				"                     <s1:AmenityInfo>\r\n" + 
				"                        <s1:Amenities/>\r\n" + 
				"                     </s1:AmenityInfo>\r\n" + 
				"                     <s1:Position altitude=\"\" longitude=\"\" latitude=\"\"/>\r\n" + 
				"                     <s1:FacilityInfo dateRennovated=\"\" dateOpened=\"\">\r\n" + 
				"                        <s1:GuestRooms totalRooms=\"\"/>\r\n" + 
				"                        <s1:Restaurants/>\r\n" + 
				"                        <s1:MeetingRooms SmallestSeatingCapacity=\"\" SecondLargestSeatingCapacity=\"\" LargestSeatingCapacity=\"\" TotalRoomSpace=\"\" LargestRoomSpace=\"\" SmallestRoomSpace=\"\" MeetingRoomCount=\"\"/>\r\n" + 
				"                        <s1:Attractions/>\r\n" + 
				"                     </s1:FacilityInfo>\r\n" + 
				"                     <s1:AlternateProperties/>\r\n" + 
				"                  </s1:HotelExtendedInformation>\r\n" + 
				"                  <s1:DailyChargePoints/>\r\n" + 
				"                  <s1:MemberAwardInfo>\r\n" + 
				"                     <s1:awardType/>\r\n" + 
				"                     <s1:membershipID/>\r\n" + 
				"                     <s1:pointsUsedForReservation/>\r\n" + 
				"                     <s1:redemRateCode/>\r\n" + 
				"                     <s1:stayDate>\r\n" + 
				"                        <s1:StartDate/>\r\n" + 
				"                        <s1:EndDate/>\r\n" + 
				"                        <s1:Duration/>\r\n" + 
				"                     </s1:stayDate>\r\n" + 
				"                     <s1:stayDate xsi:type=\"s0:FutureBookingSummaryRequestQueryDateRange\" dateType=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
				"                        <s1:StartDate/>\r\n" + 
				"                        <s1:EndDate/>\r\n" + 
				"                        <s1:Duration/>\r\n" + 
				"                     </s1:stayDate>\r\n" + 
				"                     <s1:overridePenalty/>\r\n" + 
				"                  </s1:MemberAwardInfo>\r\n" + 
				"                  <s1:ExpectedCharges decimals=\"2\" TaxInclusive=\"false\" TotalFixedCharges=\"\" TotalTaxesAndFees=\"0\" TotalRoomRateAndPackages=\"0\">\r\n" + 
				"                     <s1:ChargesForPostingDate TotalCharges=\"\" PostingDate=\"2019-02-14\">\r\n" + 
				"                        <s1:RoomRateAndPackages decimals=\"2\" TotalCharges=\"15500\">\r\n" + 
				"                           <s1:Charges>\r\n" + 
				"                              <s1:Description>BASE RATE</s1:Description>\r\n" + 
				"                              <s1:Amount currencyText=\"\" decimals=\"2\" currencyCode=\"INR\">15500</s1:Amount>\r\n" + 
				"                              <s1:CodeType/>\r\n" + 
				"                              <s1:Code/>\r\n" + 
				"                           </s1:Charges>\r\n" + 
				"                        </s1:RoomRateAndPackages>\r\n" + 
				"                        <s1:TaxesAndFees decimals=\"2\" TotalCharges=\"4340\">\r\n" + 
				"                           <s1:Charges>\r\n" + 
				"                              <s1:Description>7703 CGST Room Charge 6%</s1:Description>\r\n" + 
				"                              <s1:Amount currencyText=\"\" decimals=\"2\" currencyCode=\"INR\">0</s1:Amount>\r\n" + 
				"                              <s1:CodeType>R</s1:CodeType>\r\n" + 
				"                              <s1:Code>1000</s1:Code>\r\n" + 
				"                           </s1:Charges>\r\n" + 
				"                           <s1:Charges>\r\n" + 
				"                              <s1:Description>7795 SGST Room Charge 0%</s1:Description>\r\n" + 
				"                              <s1:Amount currencyText=\"\" decimals=\"2\" currencyCode=\"INR\">0</s1:Amount>\r\n" + 
				"                              <s1:CodeType>R</s1:CodeType>\r\n" + 
				"                              <s1:Code>1000</s1:Code>\r\n" + 
				"                           </s1:Charges>\r\n" + 
				"                           <s1:Charges>\r\n" + 
				"                              <s1:Description>7701 CGST Room Charge 14%</s1:Description>\r\n" + 
				"                              <s1:Amount currencyText=\"\" decimals=\"2\" currencyCode=\"INR\">2170</s1:Amount>\r\n" + 
				"                              <s1:CodeType>R</s1:CodeType>\r\n" + 
				"                              <s1:Code>1000</s1:Code>\r\n" + 
				"                           </s1:Charges>\r\n" + 
				"                           <s1:Charges>\r\n" + 
				"                              <s1:Description>7700 CGST Room Charge 9%</s1:Description>\r\n" + 
				"                              <s1:Amount currencyText=\"\" decimals=\"2\" currencyCode=\"INR\">0</s1:Amount>\r\n" + 
				"                              <s1:CodeType>R</s1:CodeType>\r\n" + 
				"                              <s1:Code>1000</s1:Code>\r\n" + 
				"                           </s1:Charges>\r\n" + 
				"                           <s1:Charges>\r\n" + 
				"                              <s1:Description>7750 SGST Room Charge 9%</s1:Description>\r\n" + 
				"                              <s1:Amount currencyText=\"\" decimals=\"2\" currencyCode=\"INR\">0</s1:Amount>\r\n" + 
				"                              <s1:CodeType>R</s1:CodeType>\r\n" + 
				"                              <s1:Code>1000</s1:Code>\r\n" + 
				"                           </s1:Charges>\r\n" + 
				"                           <s1:Charges>\r\n" + 
				"                              <s1:Description>7751 SGST Room Charge 14%</s1:Description>\r\n" + 
				"                              <s1:Amount currencyText=\"\" decimals=\"2\" currencyCode=\"INR\">2170</s1:Amount>\r\n" + 
				"                              <s1:CodeType>R</s1:CodeType>\r\n" + 
				"                              <s1:Code>1000</s1:Code>\r\n" + 
				"                           </s1:Charges>\r\n" + 
				"                           <s1:Charges>\r\n" + 
				"                              <s1:Description>7735 CGST Room Charge 0%</s1:Description>\r\n" + 
				"                              <s1:Amount currencyText=\"\" decimals=\"2\" currencyCode=\"INR\">0</s1:Amount>\r\n" + 
				"                              <s1:CodeType>R</s1:CodeType>\r\n" + 
				"                              <s1:Code>1000</s1:Code>\r\n" + 
				"                           </s1:Charges>\r\n" + 
				"                           <s1:Charges>\r\n" + 
				"                              <s1:Description>7753 SGST Room Charge 6%</s1:Description>\r\n" + 
				"                              <s1:Amount currencyText=\"\" decimals=\"2\" currencyCode=\"INR\">0</s1:Amount>\r\n" + 
				"                              <s1:CodeType>R</s1:CodeType>\r\n" + 
				"                              <s1:Code>1000</s1:Code>\r\n" + 
				"                           </s1:Charges>\r\n" + 
				"                           <s1:Charges>\r\n" + 
				"                              <s1:Description>BASE RATE</s1:Description>\r\n" + 
				"                              <s1:Amount currencyText=\"\" decimals=\"2\" currencyCode=\"INR\">15500</s1:Amount>\r\n" + 
				"                              <s1:CodeType/>\r\n" + 
				"                              <s1:Code/>\r\n" + 
				"                           </s1:Charges>\r\n" + 
				"                           <s1:Charges>\r\n" + 
				"                              <s1:Description>DAILY RATE PACKAGE TAX TOTAL</s1:Description>\r\n" + 
				"                              <s1:Amount currencyText=\"\" decimals=\"2\" currencyCode=\"INR\">15500</s1:Amount>\r\n" + 
				"                              <s1:CodeType/>\r\n" + 
				"                              <s1:Code/>\r\n" + 
				"                           </s1:Charges>\r\n" + 
				"                        </s1:TaxesAndFees>\r\n" + 
				"                        <s1:FixedCharges decimals=\"\" TotalCharges=\"\"/>\r\n" + 
				"                     </s1:ChargesForPostingDate>\r\n" + 
				"                  </s1:ExpectedCharges>\r\n" + 
				"                  <s1:GdsTotalPricing>\r\n" + 
				"                     <s1:TotalInclusiveRoomRate currencyText=\"\" decimals=\"\" currencyCode=\"\"/>\r\n" + 
				"                     <s1:TotalExclusiveRoomRate currencyText=\"\" decimals=\"\" currencyCode=\"\"/>\r\n" + 
				"                     <s1:TotalTax currencyText=\"\" decimals=\"\" currencyCode=\"\"/>\r\n" + 
				"                     <s1:TotalSurCharge currencyText=\"\" decimals=\"\" currencyCode=\"\"/>\r\n" + 
				"                     <s1:TaxQualifier/>\r\n" + 
				"                     <s1:MatchingQualifier/>\r\n" + 
				"                  </s1:GdsTotalPricing>\r\n" + 
				"                  <s1:Traces/>\r\n" + 
				"               </s1:RoomStay>\r\n" + 
				"            </s3:RoomStays>\r\n" + 
				"            <s3:ResGuests xmlns:s3=\"http://webservices.micros.com/og/4.3/Reservation/\">\r\n" + 
				"               <s3:ResGuest departureTime=\"09:35:00.0000000+05:30\" arrivalTime=\"13:02:00.0000000+05:30\" otherAgeQualifyingCode=\"\" ageQualifyingCode=\"\" resGuestRPH=\"0\">\r\n" + 
				"                  <s3:Profiles>\r\n" + 
				"                     <s4:Profile customerValue=\"\" yieldMarketCode=\"\" active=\"\" inactiveDate=\"\" updateDate=\"\" updateUser=\"\" insertDate=\"\" insertUser=\"\" taxExempt=\"\" vipCode=\"0\" nationality=\"IN\" languageCode=\"\" protected=\"\" nameType=\"\" xmlns:s4=\"http://webservices.micros.com/og/4.3/Name/\">\r\n" + 
				"                        <s4:ProfileIDs>\r\n" + 
				"                           <s2:UniqueID source=\"\" type=\"INTERNAL\" xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\">103430407</s2:UniqueID>\r\n" + 
				"                        </s4:ProfileIDs>\r\n" + 
				"                        <s4:Company commissionCode=\"\">\r\n" + 
				"                           <s4:CompanyName/>\r\n" + 
				"                           <s4:CompanyType/>\r\n" + 
				"                           <s4:CompanyID/>\r\n" + 
				"                        </s4:Company>\r\n" + 
				"                        <s4:Customer profileType=\"\" birthDate=\"\" gender=\"MALE\">\r\n" + 
				"                           <s4:PersonName active=\"\" familiarName=\"\" nameOrdered=\"\">\r\n" + 
				"                              <s2:nameTitle xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\">Mr.</s2:nameTitle>\r\n" + 
				"                              <s2:firstName xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\">Middleware</s2:firstName>\r\n" + 
				"                              <s2:lastName xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\">Latest</s2:lastName>\r\n" + 
				"                              <s2:accountName2 xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:accountName3 xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:profession xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                           </s4:PersonName>\r\n" + 
				"                           <s4:PersonName xsi:type=\"s4:NativeName\" active=\"\" familiarName=\"\" nameOrdered=\"\" languageCode=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
				"                              <s2:firstName xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:lastName xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:accountName2 xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:accountName3 xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:profession xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                           </s4:PersonName>\r\n" + 
				"                           <s4:NativeName active=\"\" familiarName=\"\" nameOrdered=\"\" languageCode=\"\">\r\n" + 
				"                              <s2:firstName xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:lastName xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:accountName2 xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:accountName3 xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:profession xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                           </s4:NativeName>\r\n" + 
				"                           <s4:BusinessTitle/>\r\n" + 
				"                           <s4:GovernmentIDList/>\r\n" + 
				"                        </s4:Customer>\r\n" + 
				"                        <s4:CreditCards/>\r\n" + 
				"                        <s4:Addresses>\r\n" + 
				"                           <s4:NameAddress languageCode=\"\" otherAddressType=\"HOME\" addressType=\"HOME\" inactiveDate=\"\" updateDate=\"\" updateUser=\"\" insertDate=\"\" insertUser=\"\" displaySequence=\"\" primary=\"\" externalId=\"\" operaId=\"106510900\">\r\n" + 
				"                              <s2:AddressLine xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\">CMR College</s2:AddressLine>\r\n" + 
				"                              <s2:cityName xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\">Hyderabad</s2:cityName>\r\n" + 
				"                              <s2:stateProv xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\">TS</s2:stateProv>\r\n" + 
				"                              <s2:countryCode xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\">IN</s2:countryCode>\r\n" + 
				"                              <s2:postalCode xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\">500036</s2:postalCode>\r\n" + 
				"                              <s2:barCode xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:cityExtension xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                           </s4:NameAddress>\r\n" + 
				"                        </s4:Addresses>\r\n" + 
				"                        <s4:Blacklist flag=\"\"/>\r\n" + 
				"                        <s4:Phones>\r\n" + 
				"                           <s4:NamePhone primaryPhone=\"\" phoneRole=\"PHONE\" phoneType=\"MOBILE\" extension=\"\" inactiveDate=\"\" updateDate=\"\" updateUser=\"\" insertDate=\"\" insertUser=\"\" displaySequence=\"\" primary=\"\" externalId=\"\" operaId=\"61373410\">\r\n" + 
				"                              <s2:PhoneData extension=\"\" phoneNumber=\"\" areaCode=\"\" countryAccessCode=\"\" xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:PhoneNumber xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\">9549618941</s2:PhoneNumber>\r\n" + 
				"                           </s4:NamePhone>\r\n" + 
				"                           <s4:NamePhone primaryPhone=\"\" phoneRole=\"EMAIL\" phoneType=\"EMAIL\" extension=\"\" inactiveDate=\"\" updateDate=\"\" updateUser=\"\" insertDate=\"\" insertUser=\"\" displaySequence=\"\" primary=\"true\" externalId=\"\" operaId=\"85625551\">\r\n" + 
				"                              <s2:PhoneData extension=\"\" phoneNumber=\"\" areaCode=\"\" countryAccessCode=\"\" xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:PhoneNumber xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\">abhishekkumar.jha@innovacx.com</s2:PhoneNumber>\r\n" + 
				"                           </s4:NamePhone>\r\n" + 
				"                        </s4:Phones>\r\n" + 
				"                        <s4:Preferences/>\r\n" + 
				"                        <s4:EMails>\r\n" + 
				"                           <s4:NameEmail emailFormat=\"\" emailType=\"EMAIL\" inactiveDate=\"\" updateDate=\"\" updateUser=\"\" insertDate=\"\" insertUser=\"\" displaySequence=\"\" primary=\"true\" externalId=\"\" operaId=\"\">abhishekkumar.jha@innovacx.com</s4:NameEmail>\r\n" + 
				"                        </s4:EMails>\r\n" + 
				"                        <s4:Memberships>\r\n" + 
				"                           <s4:NameMembership usedInReservation=\"false\" inactiveDate=\"\" updateDate=\"\" updateUser=\"\" insertDate=\"\" insertUser=\"\" displaySequence=\"1\" status=\"\" pointsLabel=\"\" membershipClass=\"\" central=\"\" preferred=\"\" primary=\"\" externalId=\"\" operaId=\"\">\r\n" + 
				"                              <s2:membershipType xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\">TAJ</s2:membershipType>\r\n" + 
				"                              <s2:membershipNumber xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\">101015327742</s2:membershipNumber>\r\n" + 
				"                              <s2:membershipLevel xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\">TC</s2:membershipLevel>\r\n" + 
				"                              <s2:membershipNextLevel xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:memberName xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\">Latest Middleware</s2:memberName>\r\n" + 
				"                              <s2:effectiveDate xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\">2018-08-07</s2:effectiveDate>\r\n" + 
				"                              <s2:expirationDate xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\">2019-08-06</s2:expirationDate>\r\n" + 
				"                              <s2:currentPoints xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\">0</s2:currentPoints>\r\n" + 
				"                              <s2:enrollmentCode xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:ResvNameId xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:membershipid source=\"\" type=\"INTERNAL\" xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\">55060492</s2:membershipid>\r\n" + 
				"                              <s2:transferPoints xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:enrollmentSource xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:enrolledAt xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:awardPointsToExpires xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:inactive xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:excludeBatchIndicator xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                           </s4:NameMembership>\r\n" + 
				"                           <s4:NameMembership usedInReservation=\"true\" inactiveDate=\"\" updateDate=\"\" updateUser=\"\" insertDate=\"\" insertUser=\"\" displaySequence=\"2\" status=\"\" pointsLabel=\"\" membershipClass=\"\" central=\"\" preferred=\"\" primary=\"\" externalId=\"\" operaId=\"\">\r\n" + 
				"                              <s2:membershipType xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\">TAJ</s2:membershipType>\r\n" + 
				"                              <s2:membershipNumber xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\">101015305090</s2:membershipNumber>\r\n" + 
				"                              <s2:membershipLevel xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\">TC</s2:membershipLevel>\r\n" + 
				"                              <s2:membershipNextLevel xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:memberName xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\">Latest Middleware</s2:memberName>\r\n" + 
				"                              <s2:effectiveDate xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\">2018-08-30</s2:effectiveDate>\r\n" + 
				"                              <s2:expirationDate xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\">2019-08-29</s2:expirationDate>\r\n" + 
				"                              <s2:currentPoints xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\">0</s2:currentPoints>\r\n" + 
				"                              <s2:enrollmentCode xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:ResvNameId xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:membershipid source=\"\" type=\"INTERNAL\" xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\">57376999</s2:membershipid>\r\n" + 
				"                              <s2:transferPoints xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:enrollmentSource xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:enrolledAt xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:awardPointsToExpires xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:inactive xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                              <s2:excludeBatchIndicator xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                           </s4:NameMembership>\r\n" + 
				"                        </s4:Memberships>\r\n" + 
				"                        <s4:NegotiatedRates/>\r\n" + 
				"                        <s4:Comments/>\r\n" + 
				"                        <s4:UserDefinedValues/>\r\n" + 
				"                        <s4:Privacy/>\r\n" + 
				"                        <s4:UserGroup groupType=\"\"/>\r\n" + 
				"                        <s4:StayHistory>\r\n" + 
				"                           <s4:LastStay/>\r\n" + 
				"                           <s4:TotalNumberOfStays/>\r\n" + 
				"                           <s4:LastRoomNumber/>\r\n" + 
				"                           <s4:LastRate currencyText=\"\" decimals=\"\" currencyCode=\"\"/>\r\n" + 
				"                        </s4:StayHistory>\r\n" + 
				"                        <s4:Id displaySequence=\"\" primary=\"\" resort=\"\" documentID=\"\" countryOfIssue=\"\" placeOfIssue=\"\" expirationDate=\"\" effectiveDate=\"\" documentNumber=\"\" documentType=\"\"/>\r\n" + 
				"                        <s4:KeyWord/>\r\n" + 
				"                        <s4:Features/>\r\n" + 
				"                     </s4:Profile>\r\n" + 
				"                  </s3:Profiles>\r\n" + 
				"                  <s3:SpecialRequests/>\r\n" + 
				"                  <s3:Comments/>\r\n" + 
				"                  <s3:ArrivalTransport transportationRequired=\"\" time=\"2019-02-14T00:00:00\" locationCode=\"\" carrierCode=\"\" id=\"\" type=\"\"/>\r\n" + 
				"                  <s3:DepartureTransport transportationRequired=\"\" time=\"2019-02-14T00:00:00\" locationCode=\"\" carrierCode=\"\" id=\"\" type=\"\"/>\r\n" + 
				"                  <s3:GuestCounts isPerRoom=\"\"/>\r\n" + 
				"                  <s3:InHouseTimeSpan>\r\n" + 
				"                     <s1:StartDate xmlns:s1=\"http://webservices.micros.com/og/4.3/HotelCommon/\"/>\r\n" + 
				"                     <s1:EndDate xmlns:s1=\"http://webservices.micros.com/og/4.3/HotelCommon/\"/>\r\n" + 
				"                     <s1:Duration xmlns:s1=\"http://webservices.micros.com/og/4.3/HotelCommon/\"/>\r\n" + 
				"                  </s3:InHouseTimeSpan>\r\n" + 
				"                  <s3:InHouseTimeSpan xsi:type=\"s0:FutureBookingSummaryRequestQueryDateRange\" dateType=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
				"                     <s1:StartDate xmlns:s1=\"http://webservices.micros.com/og/4.3/HotelCommon/\"/>\r\n" + 
				"                     <s1:EndDate xmlns:s1=\"http://webservices.micros.com/og/4.3/HotelCommon/\"/>\r\n" + 
				"                     <s1:Duration xmlns:s1=\"http://webservices.micros.com/og/4.3/HotelCommon/\"/>\r\n" + 
				"                  </s3:InHouseTimeSpan>\r\n" + 
				"               </s3:ResGuest>\r\n" + 
				"            </s3:ResGuests>\r\n" + 
				"            <s3:WrittenConfInst telephone=\"\" address=\"\" addresseeName=\"\" languageId=\"\" xmlns:s3=\"http://webservices.micros.com/og/4.3/Reservation/\">\r\n" + 
				"               <s3:Email/>\r\n" + 
				"               <s3:OptionalEmail/>\r\n" + 
				"            </s3:WrittenConfInst>\r\n" + 
				"            <s3:ReservationHistory transactions=\"\" inactiveDate=\"\" updateDate=\"2019-03-19T09:35:36\" updateUser=\"MINDLCONS\" insertDate=\"2019-02-14T13:00:57\" insertUser=\"SUPERVISOR\" xmlns:s3=\"http://webservices.micros.com/og/4.3/Reservation/\"/>\r\n" + 
				"            <s3:UserDefinedValues xmlns:s3=\"http://webservices.micros.com/og/4.3/Reservation/\"/>\r\n" + 
				"            <s3:Invoice FolioViewNo=\"\" xmlns:s3=\"http://webservices.micros.com/og/4.3/Reservation/\">\r\n" + 
				"               <s3:Address languageCode=\"\" otherAddressType=\"\" addressType=\"\" inactiveDate=\"\" updateDate=\"\" updateUser=\"\" insertDate=\"\" insertUser=\"\" displaySequence=\"\" primary=\"\" externalId=\"\" operaId=\"\">\r\n" + 
				"                  <s2:cityName xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                  <s2:stateProv xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                  <s2:countryCode xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                  <s2:postalCode xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                  <s2:barCode xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                  <s2:cityExtension xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"               </s3:Address>\r\n" + 
				"               <s3:Name active=\"\" familiarName=\"\" nameOrdered=\"\" languageCode=\"\">\r\n" + 
				"                  <s2:firstName xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                  <s2:lastName xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                  <s2:accountName2 xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                  <s2:accountName3 xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                  <s2:profession xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"               </s3:Name>\r\n" + 
				"               <s3:ProfileIDs/>\r\n" + 
				"               <s3:BillNumber source=\"\" type=\"\"/>\r\n" + 
				"               <s3:CurrentBalance currencyText=\"\" decimals=\"\" currencyCode=\"\"/>\r\n" + 
				"            </s3:Invoice>\r\n" + 
				"            <s3:Preferences xmlns:s3=\"http://webservices.micros.com/og/4.3/Reservation/\"/>\r\n" + 
				"            <s3:PayRoutings Room=\"1420\" Window=\"1\" Owner=\"Latest, Middleware\" RoutingInstruction=\"\" xmlns:s3=\"http://webservices.micros.com/og/4.3/Reservation/\"/>\r\n" + 
				"            <s3:PayMethods Window=\"1\" Owner=\"Latest, Middleware\" xmlns:s3=\"http://webservices.micros.com/og/4.3/Reservation/\">\r\n" + 
				"               <s1:PaymentMethod source=\"\" value=\"CA\" type=\"\" xmlns:s1=\"http://webservices.micros.com/og/4.3/HotelCommon/\"/>\r\n" + 
				"            </s3:PayMethods>\r\n" + 
				"            <s3:AccompanyGuests xmlns:s3=\"http://webservices.micros.com/og/4.3/Reservation/\"/>\r\n" + 
				"            <s3:ECertificate xmlns:s3=\"http://webservices.micros.com/og/4.3/Reservation/\">\r\n" + 
				"               <s5:CertificateID source=\"\" type=\"\" xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:VoucherNumber xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:CertificateNumber xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:CertificateCode xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:HotelReference hotelCode=\"\" chainCode=\"\" xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:MembershipType xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:AwardType xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:PromotionCode xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:ShortDescription xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:LongDescription xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:ExpirationDate xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:ReservationCertificateYN xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:CertificateValue currencyText=\"\" decimals=\"\" currencyCode=\"\" xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:CertificateCost currencyText=\"\" decimals=\"\" currencyCode=\"\" xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:CertificateLabel xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:NameID source=\"\" type=\"\" xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:ConsumedAt xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:ConsumerLastName xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:ConsumerFirstName xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:ConsumerMiddleName xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:ConsumerEmail xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:ConsumptionDate xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:ConsumedHotelReference hotelCode=\"\" chainCode=\"\" xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:ConsumptionRefNo source=\"\" type=\"\" xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:ConsumptionRefType xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:ConsumptionLegNo source=\"\" type=\"\" xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:UserNotes xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:Status xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:PrintStatus xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:MembershipAwardID source=\"\" type=\"\" xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:IssueType xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:IssueSource xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:AwardPoints xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:InActiveDate xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:CertificateBeginDate xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:CertificateEndDate xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:CertificateExpriyMonths xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:WebAllowed xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:PMSConsumed xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:WebConsumed xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:Awards xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\">\r\n" + 
				"                  <s5:AwardCode/>\r\n" + 
				"                  <s5:PointsRequired/>\r\n" + 
				"                  <s5:RuleSchedule>\r\n" + 
				"                     <s5:Code/>\r\n" + 
				"                     <s5:Description>\r\n" + 
				"                        <s2:Url xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                        <s2:Text xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                        <s2:Image xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                     </s5:Description>\r\n" + 
				"                     <s5:Description xsi:type=\"s4:Comment\" internalYn=\"\" globalYn=\"\" commentType=\"\" inactiveDate=\"\" updateDate=\"\" updateUser=\"\" insertDate=\"\" insertUser=\"\" commentTitle=\"\" externalId=\"\" operaId=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
				"                        <s2:Url xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                        <s2:Text xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                        <s2:Image xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                     </s5:Description>\r\n" + 
				"                     <s5:Description xsi:type=\"s1:HotelInfo\" otherHotelInfoType=\"\" hotelInfoType=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
				"                        <s2:Url xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                        <s2:Text xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                        <s2:Image xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                     </s5:Description>\r\n" + 
				"                     <s5:Description xsi:type=\"s1:AttractionInfo\" otherAttractionInfoType=\"\" attractionInfoType=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
				"                        <s2:Url xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                        <s2:Text xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                        <s2:Image xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                     </s5:Description>\r\n" + 
				"                  </s5:RuleSchedule>\r\n" + 
				"               </s5:Awards>\r\n" + 
				"               <s5:Scope xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"            </s3:ECertificate>\r\n" + 
				"            <s3:ShareReservations xmlns:s3=\"http://webservices.micros.com/og/4.3/Reservation/\"/>\r\n" + 
				"            <s3:Miscellaneous xmlns:s3=\"http://webservices.micros.com/og/4.3/Reservation/\">\r\n" + 
				"               <s3:CustomerValue/>\r\n" + 
				"               <s3:PartyCode/>\r\n" + 
				"            </s3:Miscellaneous>\r\n" + 
				"            <s3:ReservationVouchers xmlns:s3=\"http://webservices.micros.com/og/4.3/Reservation/\"/>\r\n" + 
				"            <s3:ReservationPayments xmlns:s3=\"http://webservices.micros.com/og/4.3/Reservation/\">\r\n" + 
				"               <s3:ReservationPaymentInfo PaymentType=\"CA\" Window=\"1\">\r\n" + 
				"                  <s3:CreditCard chipAndPin=\"\" otherCardType=\"\" cardType=\"\">\r\n" + 
				"                     <s2:cardID xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                     <s2:cardCode xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                     <s2:cardHolderName xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                     <s2:VaultedCardData lastFourDigits=\"\" vaultedCardID=\"\" xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                     <s2:cardNumber xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                     <s2:seriesCode xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                     <s2:Track2 xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                     <s2:effectiveDate xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                     <s2:expirationDate xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                     <s2:EncryptedSwipe xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\">\r\n" + 
				"                        <s2:TrackIndicator/>\r\n" + 
				"                        <s2:SwiperType/>\r\n" + 
				"                        <s2:SwiperID/>\r\n" + 
				"                        <s2:MaskedPAN/>\r\n" + 
				"                        <s2:Track1/>\r\n" + 
				"                        <s2:Track2/>\r\n" + 
				"                        <s2:KeySerialNumber/>\r\n" + 
				"                     </s2:EncryptedSwipe>\r\n" + 
				"                  </s3:CreditCard>\r\n" + 
				"                  <s3:CreditCard xsi:type=\"s4:NameCreditCard\" chipAndPin=\"\" otherCardType=\"\" cardType=\"\" inactiveDate=\"\" updateDate=\"\" updateUser=\"\" insertDate=\"\" insertUser=\"\" displaySequence=\"\" primary=\"\" externalId=\"\" operaId=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
				"                     <s2:cardID xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                     <s2:cardCode xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                     <s2:cardHolderName xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                     <s2:VaultedCardData lastFourDigits=\"\" vaultedCardID=\"\" xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                     <s2:cardNumber xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                     <s2:seriesCode xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                     <s2:Track2 xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                     <s2:effectiveDate xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                     <s2:expirationDate xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                     <s2:EncryptedSwipe xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\">\r\n" + 
				"                        <s2:TrackIndicator/>\r\n" + 
				"                        <s2:SwiperType/>\r\n" + 
				"                        <s2:SwiperID/>\r\n" + 
				"                        <s2:MaskedPAN/>\r\n" + 
				"                        <s2:Track1/>\r\n" + 
				"                        <s2:Track2/>\r\n" + 
				"                        <s2:KeySerialNumber/>\r\n" + 
				"                     </s2:EncryptedSwipe>\r\n" + 
				"                  </s3:CreditCard>\r\n" + 
				"                  <s3:CreditCard xsi:type=\"s1:CreditCardPayment\" chipAndPin=\"\" otherCardType=\"\" cardType=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
				"                     <s2:cardID xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                     <s2:cardCode xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                     <s2:cardHolderName xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                     <s2:VaultedCardData lastFourDigits=\"\" vaultedCardID=\"\" xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                     <s2:cardNumber xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                     <s2:seriesCode xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                     <s2:Track2 xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                     <s2:effectiveDate xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                     <s2:expirationDate xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                     <s2:EncryptedSwipe xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\">\r\n" + 
				"                        <s2:TrackIndicator/>\r\n" + 
				"                        <s2:SwiperType/>\r\n" + 
				"                        <s2:SwiperID/>\r\n" + 
				"                        <s2:MaskedPAN/>\r\n" + 
				"                        <s2:Track1/>\r\n" + 
				"                        <s2:Track2/>\r\n" + 
				"                        <s2:KeySerialNumber/>\r\n" + 
				"                     </s2:EncryptedSwipe>\r\n" + 
				"                     <s1:CIDNumber xmlns:s1=\"http://webservices.micros.com/og/4.3/HotelCommon/\"/>\r\n" + 
				"                     <s1:Address languageCode=\"\" otherAddressType=\"\" addressType=\"\" xmlns:s1=\"http://webservices.micros.com/og/4.3/HotelCommon/\">\r\n" + 
				"                        <s2:cityName xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                        <s2:stateProv xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                        <s2:countryCode xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                        <s2:postalCode xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                        <s2:barCode xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                        <s2:cityExtension xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                     </s1:Address>\r\n" + 
				"                     <s1:Address xsi:type=\"s4:NameAddress\" languageCode=\"\" otherAddressType=\"\" addressType=\"\" inactiveDate=\"\" updateDate=\"\" updateUser=\"\" insertDate=\"\" insertUser=\"\" displaySequence=\"\" primary=\"\" externalId=\"\" operaId=\"\" xmlns:s1=\"http://webservices.micros.com/og/4.3/HotelCommon/\">\r\n" + 
				"                        <s2:cityName xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                        <s2:stateProv xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                        <s2:countryCode xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                        <s2:postalCode xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                        <s2:barCode xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                        <s2:cityExtension xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                     </s1:Address>\r\n" + 
				"                     <s1:IssueNumber xmlns:s1=\"http://webservices.micros.com/og/4.3/HotelCommon/\"/>\r\n" + 
				"                     <s1:ApprovalCode xmlns:s1=\"http://webservices.micros.com/og/4.3/HotelCommon/\"/>\r\n" + 
				"                     <s1:DepositAmount currencyText=\"\" decimals=\"\" currencyCode=\"\" xmlns:s1=\"http://webservices.micros.com/og/4.3/HotelCommon/\"/>\r\n" + 
				"                  </s3:CreditCard>\r\n" + 
				"               </s3:ReservationPaymentInfo>\r\n" + 
				"            </s3:ReservationPayments>\r\n" + 
				"         </s0:HotelReservation>\r\n" + 
				"         <s0:HotelReservation xsi:type=\"s3:HotelReservationListHotelReservation\" returningGuest=\"\" checkInTime=\"\" referralYN=\"\" printRate=\"\" financialTransactionExists=\"\" computedReservationStatus=\"\" checkOutTime=\"\" messagesCount=\"\" messageExists=\"\" alertsCount=\"\" alertExists=\"\" queueNumber=\"\" queueExists=\"\" shareExists=\"\" roomPreferencesCount=\"\" roomPreferenceExists=\"\" specialsCount=\"\" specialsExists=\"\" tracesCount=\"\" tracesExists=\"\" commentsCount=\"\" commentsExists=\"\" OptInComplete=\"\" OptIn=\"\" DoNotMoveRoom=\"\" totalCreditCardSurcharges=\"\" keyExpirationDate=\"\" preRegisterFlag=\"\" allowPreRegisteration=\"\" attachPreferenceProfile=\"\" group=\"\" remoteCo=\"\" noPost=\"\" walkIn=\"\" inactiveDate=\"\" updateDate=\"\" updateUser=\"\" insertDate=\"\" insertUser=\"\" redemReservationFlag=\"\" onBehalfFlag=\"\" compRoutingAuthorizer=\"\" compRoutingFlag=\"\" authorizer=\"\" originCode=\"\" sourceCode=\"\" marketSegment=\"\" reservationStatus=\"\" reservationAction=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
				"            <s3:UniqueIDList xmlns:s3=\"http://webservices.micros.com/og/4.3/Reservation/\"/>\r\n" + 
				"            <s3:ExternalSystemNumberList xmlns:s3=\"http://webservices.micros.com/og/4.3/Reservation/\"/>\r\n" + 
				"            <s3:RoomStays xmlns:s3=\"http://webservices.micros.com/og/4.3/Reservation/\"/>\r\n" + 
				"            <s3:ResGuests xmlns:s3=\"http://webservices.micros.com/og/4.3/Reservation/\"/>\r\n" + 
				"            <s3:WrittenConfInst telephone=\"\" address=\"\" addresseeName=\"\" languageId=\"\" xmlns:s3=\"http://webservices.micros.com/og/4.3/Reservation/\">\r\n" + 
				"               <s3:Email/>\r\n" + 
				"               <s3:OptionalEmail/>\r\n" + 
				"            </s3:WrittenConfInst>\r\n" + 
				"            <s3:ReservationHistory transactions=\"\" inactiveDate=\"\" updateDate=\"\" updateUser=\"\" insertDate=\"\" insertUser=\"\" xmlns:s3=\"http://webservices.micros.com/og/4.3/Reservation/\"/>\r\n" + 
				"            <s3:UserDefinedValues xmlns:s3=\"http://webservices.micros.com/og/4.3/Reservation/\"/>\r\n" + 
				"            <s3:Invoice FolioViewNo=\"\" xmlns:s3=\"http://webservices.micros.com/og/4.3/Reservation/\">\r\n" + 
				"               <s3:Address languageCode=\"\" otherAddressType=\"\" addressType=\"\" inactiveDate=\"\" updateDate=\"\" updateUser=\"\" insertDate=\"\" insertUser=\"\" displaySequence=\"\" primary=\"\" externalId=\"\" operaId=\"\">\r\n" + 
				"                  <s2:cityName xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                  <s2:stateProv xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                  <s2:countryCode xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                  <s2:postalCode xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                  <s2:barCode xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                  <s2:cityExtension xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"               </s3:Address>\r\n" + 
				"               <s3:Name active=\"\" familiarName=\"\" nameOrdered=\"\" languageCode=\"\">\r\n" + 
				"                  <s2:firstName xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                  <s2:lastName xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                  <s2:accountName2 xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                  <s2:accountName3 xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                  <s2:profession xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"               </s3:Name>\r\n" + 
				"               <s3:ProfileIDs/>\r\n" + 
				"               <s3:BillNumber source=\"\" type=\"\"/>\r\n" + 
				"               <s3:CurrentBalance currencyText=\"\" decimals=\"\" currencyCode=\"\"/>\r\n" + 
				"            </s3:Invoice>\r\n" + 
				"            <s3:Preferences xmlns:s3=\"http://webservices.micros.com/og/4.3/Reservation/\"/>\r\n" + 
				"            <s3:AccompanyGuests xmlns:s3=\"http://webservices.micros.com/og/4.3/Reservation/\"/>\r\n" + 
				"            <s3:ECertificate xmlns:s3=\"http://webservices.micros.com/og/4.3/Reservation/\">\r\n" + 
				"               <s5:CertificateID source=\"\" type=\"\" xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:VoucherNumber xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:CertificateNumber xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:CertificateCode xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:HotelReference hotelCode=\"\" chainCode=\"\" xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:MembershipType xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:AwardType xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:PromotionCode xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:ShortDescription xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:LongDescription xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:ExpirationDate xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:ReservationCertificateYN xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:CertificateValue currencyText=\"\" decimals=\"\" currencyCode=\"\" xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:CertificateCost currencyText=\"\" decimals=\"\" currencyCode=\"\" xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:CertificateLabel xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:NameID source=\"\" type=\"\" xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:ConsumedAt xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:ConsumerLastName xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:ConsumerFirstName xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:ConsumerMiddleName xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:ConsumerEmail xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:ConsumptionDate xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:ConsumedHotelReference hotelCode=\"\" chainCode=\"\" xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:ConsumptionRefNo source=\"\" type=\"\" xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:ConsumptionRefType xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:ConsumptionLegNo source=\"\" type=\"\" xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:UserNotes xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:Status xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:PrintStatus xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:MembershipAwardID source=\"\" type=\"\" xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:IssueType xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:IssueSource xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:AwardPoints xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:InActiveDate xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:CertificateBeginDate xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:CertificateEndDate xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:CertificateExpriyMonths xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:WebAllowed xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:PMSConsumed xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:WebConsumed xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"               <s5:Awards xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\">\r\n" + 
				"                  <s5:AwardCode/>\r\n" + 
				"                  <s5:PointsRequired/>\r\n" + 
				"                  <s5:RuleSchedule>\r\n" + 
				"                     <s5:Code/>\r\n" + 
				"                     <s5:Description>\r\n" + 
				"                        <s2:Url xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                        <s2:Text xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                        <s2:Image xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                     </s5:Description>\r\n" + 
				"                     <s5:Description xsi:type=\"s4:Comment\" internalYn=\"\" globalYn=\"\" commentType=\"\" inactiveDate=\"\" updateDate=\"\" updateUser=\"\" insertDate=\"\" insertUser=\"\" commentTitle=\"\" externalId=\"\" operaId=\"\">\r\n" + 
				"                        <s2:Url xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                        <s2:Text xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                        <s2:Image xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                     </s5:Description>\r\n" + 
				"                     <s5:Description xsi:type=\"s1:HotelInfo\" otherHotelInfoType=\"\" hotelInfoType=\"\">\r\n" + 
				"                        <s2:Url xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                        <s2:Text xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                        <s2:Image xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                     </s5:Description>\r\n" + 
				"                     <s5:Description xsi:type=\"s1:AttractionInfo\" otherAttractionInfoType=\"\" attractionInfoType=\"\">\r\n" + 
				"                        <s2:Url xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                        <s2:Text xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                        <s2:Image xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/>\r\n" + 
				"                     </s5:Description>\r\n" + 
				"                  </s5:RuleSchedule>\r\n" + 
				"               </s5:Awards>\r\n" + 
				"               <s5:Scope xmlns:s5=\"http://webservices.micros.com/og/4.3/Membership/\"/>\r\n" + 
				"            </s3:ECertificate>\r\n" + 
				"            <s3:ShareReservations xmlns:s3=\"http://webservices.micros.com/og/4.3/Reservation/\"/>\r\n" + 
				"            <s3:Miscellaneous xmlns:s3=\"http://webservices.micros.com/og/4.3/Reservation/\">\r\n" + 
				"               <s3:CustomerValue/>\r\n" + 
				"               <s3:PartyCode/>\r\n" + 
				"            </s3:Miscellaneous>\r\n" + 
				"            <s3:ReservationVouchers xmlns:s3=\"http://webservices.micros.com/og/4.3/Reservation/\"/>\r\n" + 
				"            <s3:ReservationPayments xmlns:s3=\"http://webservices.micros.com/og/4.3/Reservation/\"/>\r\n" + 
				"         </s0:HotelReservation>\r\n" + 
				"      </s0:FetchBookingResponse>\r\n" + 
				"   </env:Body>\r\n" + 
				"</env:Envelope>";
		
		return payload;
	}

	@SuppressWarnings("unused")
	public static void main7(String a[])
	{
		String pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
		String aa = "2018-03-14T14:14:45";
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		String date = format.format(new Date());
		System.out.println(aa);
		System.out.println(date);
		
		
	}




	public static void main5(String a[])
	{
		String resp = "{\r\n" + 
				"  \"RedemptionTransactionWebsite_Output\" : {\r\n" + 
				"    \"Error_spcCode\" : \"\",\r\n" + 
				"    \"Error_spcMessage\" : \"\",\r\n" + 
				"    \"ErrorMsg\" : \"\",\r\n" + 
				"    \"OrderId\" : \"\",\r\n" + 
				"    \"PointsShortage\" : \"\",\r\n" + 
				"    \"PromotionRuleName\" : \"Stay Redemption\",\r\n" + 
				"    \"Response\" : \"Success\",\r\n" + 
				"    \"TotalPointsRedeemed\" : \"1\",\r\n" + 
				"    \"TransactionId\" : \"1-ALSZF84\"\r\n" + 
				"  }\r\n" + 
				"}\r\n" + 
				"";
		
		try {
		
			JSONObject objPayRes = new JSONObject(resp).getJSONObject("RedemptionTransactionWebsite_Output");
			
			String isSucess = objPayRes.getString("Response");
			
			if(isSucess.equalsIgnoreCase("Success"))
			{
				String TransactionId = objPayRes.getString("TransactionId");
				String PromotionRuleName = objPayRes.getString("PromotionRuleName");
				System.out.println(TransactionId + "\n" + PromotionRuleName);
				//writeToPMS(request, response, TransactionId, EnrollNumber_c, processInvoicesData.URLReservationNumber, GlobalPropertyCode);
			} else {
				System.out.println("error");
				
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	public static void main6(String a[])
	{
		String resp = "<env:Envelope xmlns:env=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:wsa=\"http://www.w3.org/2005/08/addressing\" xmlns:typ=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/personService/applicationModule/types/\">\r\n" + 
				"   <env:Header>\r\n" + 
				"      <wsa:Action>http://xmlns.oracle.com/apps/cdm/foundation/parties/personService/applicationModule//PersonService/findPersonResponse</wsa:Action>\r\n" + 
				"      <wsa:MessageID>urn:uuid:8113b85f-c2e4-442b-af36-775f91682691</wsa:MessageID>\r\n" + 
				"   </env:Header>\r\n" + 
				"   <env:Body>\r\n" + 
				"      <ns0:findPersonResponse xmlns:ns0=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/personService/applicationModule/types/\">\r\n" + 
				"         <ns2:result xsi:type=\"ns1:PersonResult\" xmlns:ns2=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/personService/applicationModule/types/\" xmlns:ns1=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/personService/\" xmlns:ns3=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/partyService/\" xmlns:tns=\"http://xmlns.oracle.com/adf/svc/errors/\" xmlns:ns0=\"http://xmlns.oracle.com/adf/svc/types/\" xmlns:ns5=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/contactPointService/\" xmlns:ns8=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/relationshipService/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
				"            <ns1:Value>\r\n" + 
				"               <ns1:PartyId>100000044971942</ns1:PartyId>\r\n" + 
				"               <ns1:PartyNumber>2973180</ns1:PartyNumber>\r\n" + 
				"               <ns1:PartyName>Shrilaxmi reddy</ns1:PartyName>\r\n" + 
				"               <ns1:PartyType>PERSON</ns1:PartyType>\r\n" + 
				"               <ns1:ValidatedFlag>false</ns1:ValidatedFlag>\r\n" + 
				"               <ns1:LastUpdatedBy>Datacentre</ns1:LastUpdatedBy>\r\n" + 
				"               <ns1:LastUpdateLogin>7EAD65F273AE2234E0530867360A86B6</ns1:LastUpdateLogin>\r\n" + 
				"               <ns1:CreationDate>2018-06-06T03:24:20.874022Z</ns1:CreationDate>\r\n" + 
				"               <ns1:RequestId>67968</ns1:RequestId>\r\n" + 
				"               <ns1:LastUpdateDate>2019-04-02T06:59:06.156Z</ns1:LastUpdateDate>\r\n" + 
				"               <ns1:CreatedBy>Datacentre</ns1:CreatedBy>\r\n" + 
				"               <ns1:OrigSystemReference>89424836</ns1:OrigSystemReference>\r\n" + 
				"               <ns1:SICCode xsi:nil=\"true\"/>\r\n" + 
				"               <ns1:JgzzFiscalCode xsi:nil=\"true\"/>\r\n" + 
				"               <ns1:PersonFirstName>Shrilaxmi</ns1:PersonFirstName>\r\n" + 
				"               <ns1:PersonPreNameAdjunct>Ms.</ns1:PersonPreNameAdjunct>\r\n" + 
				"               <ns1:PersonLastName>reddy</ns1:PersonLastName>\r\n" + 
				"               <ns1:PersonMiddleName xsi:nil=\"true\"/>\r\n" + 
				"               <ns1:PersonTitle xsi:nil=\"true\"/>\r\n" + 
				"               <ns1:PersonNameSuffix xsi:nil=\"true\"/>\r\n" + 
				"               <ns1:PersonPreviousLastName xsi:nil=\"true\"/>\r\n" + 
				"               <ns1:PersonAcademicTitle xsi:nil=\"true\"/>\r\n" + 
				"               <ns1:Country>IN</ns1:Country>\r\n" + 
				"               <ns1:Address2>Terminus</ns1:Address2>\r\n" + 
				"               <ns1:Address1>Sln</ns1:Address1>\r\n" + 
				"               <ns1:Address4 xsi:nil=\"true\"/>\r\n" + 
				"               <ns1:Address3 xsi:nil=\"true\"/>\r\n" + 
				"               <ns1:PostalCode>500014</ns1:PostalCode>\r\n" + 
				"               <ns1:City>Hyderabad</ns1:City>\r\n" + 
				"               <ns1:Province xsi:nil=\"true\"/>\r\n" + 
				"               <ns1:State>TS</ns1:State>\r\n" + 
				"               <ns1:County xsi:nil=\"true\"/>\r\n" + 
				"               <ns1:Status>A</ns1:Status>\r\n" + 
				"               <ns1:URL xsi:nil=\"true\"/>\r\n" + 
				"               <ns1:SICCodeType xsi:nil=\"true\"/>\r\n" + 
				"               <ns1:EmailAddress>Shrilaxmi@test.com</ns1:EmailAddress>\r\n" + 
				"               <ns1:GSAIndicatorFlag xsi:nil=\"true\"/>\r\n" + 
				"               <ns1:LanguageName xsi:nil=\"true\"/>\r\n" + 
				"               <ns1:MissionStatement xsi:nil=\"true\"/>\r\n" + 
				"               <ns1:CategoryCode xsi:nil=\"true\"/>\r\n" + 
				"               <ns1:ThirdPartyFlag xsi:nil=\"true\"/>\r\n" + 
				"               <ns1:Salutation xsi:nil=\"true\"/>\r\n" + 
				"               <ns1:CreatedByModule>HZ_IMPORT</ns1:CreatedByModule>\r\n" + 
				"               <ns1:CertReasonCode xsi:nil=\"true\"/>\r\n" + 
				"               <ns1:CertificationLevel xsi:nil=\"true\"/>\r\n" + 
				"               <ns1:PrimaryPhonePurpose xsi:nil=\"true\"/>\r\n" + 
				"               <ns1:PrimaryPhoneContactPTId xsi:nil=\"true\"/>\r\n" + 
				"               <ns1:PrimaryPhoneCountryCode xsi:nil=\"true\"/>\r\n" + 
				"               <ns1:PrimaryPhoneLineType xsi:nil=\"true\"/>\r\n" + 
				"               <ns1:PrimaryPhoneNumber xsi:nil=\"true\"/>\r\n" + 
				"               <ns1:PrimaryPhoneAreaCode xsi:nil=\"true\"/>\r\n" + 
				"               <ns1:PreferredContactMethod xsi:nil=\"true\"/>\r\n" + 
				"               <ns1:PrimaryPhoneExtension xsi:nil=\"true\"/>\r\n" + 
				"               <ns1:IdenAddrLocationId>300000603140926</ns1:IdenAddrLocationId>\r\n" + 
				"               <ns1:PrimaryEmailContactPTId>300000603139991</ns1:PrimaryEmailContactPTId>\r\n" + 
				"               <ns1:IdenAddrPartySiteId>300000603140925</ns1:IdenAddrPartySiteId>\r\n" + 
				"               <ns1:PersonLastNamePrefix xsi:nil=\"true\"/>\r\n" + 
				"               <ns1:PrimaryURLContactPTId xsi:nil=\"true\"/>\r\n" + 
				"               <ns1:PreferredName xsi:nil=\"true\"/>\r\n" + 
				"               <ns1:PersonSecondLastName xsi:nil=\"true\"/>\r\n" + 
				"               <ns1:PreferredNameId xsi:nil=\"true\"/>\r\n" + 
				"               <ns1:PreferredContactPersonId xsi:nil=\"true\"/>\r\n" + 
				"               <ns1:InternalFlag>false</ns1:InternalFlag>\r\n" + 
				"               <ns1:PreferredFunctionalCurrency xsi:nil=\"true\"/>\r\n" + 
				"               <ns1:Gender>UNKNOWN</ns1:Gender>\r\n" + 
				"               <ns1:MaritalStatus xsi:nil=\"true\"/>\r\n" + 
				"               <ns1:Comments xsi:nil=\"true\"/>\r\n" + 
				"               <ns1:DateOfBirth>1995-05-12</ns1:DateOfBirth>\r\n" + 
				"               <ns1:UserGUID xsi:nil=\"true\"/>\r\n" + 
				"               <ns1:PartyUniqueName>Shrilaxmi reddy</ns1:PartyUniqueName>\r\n" + 
				"               <ns1:SourceSystem xsi:nil=\"true\"/>\r\n" + 
				"               <ns1:SourceSystemReferenceValue xsi:nil=\"true\"/>\r\n" + 
				"               <ns1:SourceSystemUpdateDate xsi:nil=\"true\"/>\r\n" + 
				"               <ns1:Email xmlns:ns6=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/contactPoint/\">\r\n" + 
				"                  <ns5:ContactPointId>300000602160791</ns5:ContactPointId>\r\n" + 
				"                  <ns5:ContactPointType>EMAIL</ns5:ContactPointType>\r\n" + 
				"                  <ns5:Status>I</ns5:Status>\r\n" + 
				"                  <ns5:OwnerTableName>HZ_PARTIES</ns5:OwnerTableName>\r\n" + 
				"                  <ns5:OwnerTableId>100000044971942</ns5:OwnerTableId>\r\n" + 
				"                  <ns5:PrimaryFlag>false</ns5:PrimaryFlag>\r\n" + 
				"                  <ns5:OrigSystemReference>300000602160791</ns5:OrigSystemReference>\r\n" + 
				"                  <ns5:LastUpdateDate>2018-08-29T08:30:40.476Z</ns5:LastUpdateDate>\r\n" + 
				"                  <ns5:LastUpdatedBy>Datacentre</ns5:LastUpdatedBy>\r\n" + 
				"                  <ns5:CreationDate>2018-07-10T16:00:28.004Z</ns5:CreationDate>\r\n" + 
				"                  <ns5:CreatedBy>Datacentre</ns5:CreatedBy>\r\n" + 
				"                  <ns5:LastUpdateLogin>73D9B2C0741B2F73E0530A67360A8443</ns5:LastUpdateLogin>\r\n" + 
				"                  <ns5:RequestId xsi:nil=\"true\"/>\r\n" + 
				"                  <ns5:ObjectVersionNumber>2</ns5:ObjectVersionNumber>\r\n" + 
				"                  <ns5:CreatedByModule>HZ_WS</ns5:CreatedByModule>\r\n" + 
				"                  <ns5:ContactPointPurpose xsi:nil=\"true\"/>\r\n" + 
				"                  <ns5:PrimaryByPurpose>N</ns5:PrimaryByPurpose>\r\n" + 
				"                  <ns5:StartDate>2018-07-10</ns5:StartDate>\r\n" + 
				"                  <ns5:EndDate>4712-12-31</ns5:EndDate>\r\n" + 
				"                  <ns5:RelationshipId xsi:nil=\"true\"/>\r\n" + 
				"                  <ns5:PartyUsageCode xsi:nil=\"true\"/>\r\n" + 
				"                  <ns5:OrigSystem xsi:nil=\"true\"/>\r\n" + 
				"                  <ns5:EmailFormat/>\r\n" + 
				"                  <ns5:EmailAddress>Shrilaxmi@test.com</ns5:EmailAddress>\r\n" + 
				"                  <ns5:PartyName>Shrilaxmi reddy</ns5:PartyName>\r\n" + 
				"                  <ns5:OverallPrimaryFlag>false</ns5:OverallPrimaryFlag>\r\n" + 
				"                  <ns5:EmailInformation>\r\n" + 
				"                     <ns6:ContactPointId>300000602160791</ns6:ContactPointId>\r\n" + 
				"                     <ns6:ContactPointType>EMAIL</ns6:ContactPointType>\r\n" + 
				"                     <ns6:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"                     <ns6:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"                     <ns6:_FLEX_NumOfSegments>0</ns6:_FLEX_NumOfSegments>\r\n" + 
				"                  </ns5:EmailInformation>\r\n" + 
				"               </ns1:Email>\r\n" + 
				"               <ns1:Email xmlns:ns6=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/contactPoint/\">\r\n" + 
				"                  <ns5:ContactPointId>300000603139991</ns5:ContactPointId>\r\n" + 
				"                  <ns5:ContactPointType>EMAIL</ns5:ContactPointType>\r\n" + 
				"                  <ns5:Status>A</ns5:Status>\r\n" + 
				"                  <ns5:OwnerTableName>HZ_PARTIES</ns5:OwnerTableName>\r\n" + 
				"                  <ns5:OwnerTableId>100000044971942</ns5:OwnerTableId>\r\n" + 
				"                  <ns5:PrimaryFlag>true</ns5:PrimaryFlag>\r\n" + 
				"                  <ns5:OrigSystemReference>2018082908302471333</ns5:OrigSystemReference>\r\n" + 
				"                  <ns5:LastUpdateDate>2018-08-29T08:30:40.402Z</ns5:LastUpdateDate>\r\n" + 
				"                  <ns5:LastUpdatedBy>Datacentre</ns5:LastUpdatedBy>\r\n" + 
				"                  <ns5:CreationDate>2018-08-29T08:30:40.001Z</ns5:CreationDate>\r\n" + 
				"                  <ns5:CreatedBy>Datacentre</ns5:CreatedBy>\r\n" + 
				"                  <ns5:LastUpdateLogin>73D9B2C0741B2F73E0530A67360A8443</ns5:LastUpdateLogin>\r\n" + 
				"                  <ns5:RequestId xsi:nil=\"true\"/>\r\n" + 
				"                  <ns5:ObjectVersionNumber>1</ns5:ObjectVersionNumber>\r\n" + 
				"                  <ns5:CreatedByModule>HZ_WS</ns5:CreatedByModule>\r\n" + 
				"                  <ns5:ContactPointPurpose>EMAIL</ns5:ContactPointPurpose>\r\n" + 
				"                  <ns5:PrimaryByPurpose>N</ns5:PrimaryByPurpose>\r\n" + 
				"                  <ns5:StartDate>2018-08-29</ns5:StartDate>\r\n" + 
				"                  <ns5:EndDate>4712-12-31</ns5:EndDate>\r\n" + 
				"                  <ns5:RelationshipId xsi:nil=\"true\"/>\r\n" + 
				"                  <ns5:PartyUsageCode xsi:nil=\"true\"/>\r\n" + 
				"                  <ns5:OrigSystem xsi:nil=\"true\"/>\r\n" + 
				"                  <ns5:EmailFormat/>\r\n" + 
				"                  <ns5:EmailAddress>Shrilaxmi@test.com</ns5:EmailAddress>\r\n" + 
				"                  <ns5:PartyName>Shrilaxmi reddy</ns5:PartyName>\r\n" + 
				"                  <ns5:OverallPrimaryFlag>true</ns5:OverallPrimaryFlag>\r\n" + 
				"                  <ns5:OriginalSystemReference xmlns:ns4=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/sourceSystemRef/\">\r\n" + 
				"                     <ns3:OrigSystemReferenceId>300000603139992</ns3:OrigSystemReferenceId>\r\n" + 
				"                     <ns3:OrigSystem>PMS</ns3:OrigSystem>\r\n" + 
				"                     <ns3:OrigSystemReference>2018082908302471333</ns3:OrigSystemReference>\r\n" + 
				"                     <ns3:OwnerTableName>HZ_CONTACT_POINTS</ns3:OwnerTableName>\r\n" + 
				"                     <ns3:OwnerTableId>300000603139991</ns3:OwnerTableId>\r\n" + 
				"                     <ns3:Status>A</ns3:Status>\r\n" + 
				"                     <ns3:ReasonCode xsi:nil=\"true\"/>\r\n" + 
				"                     <ns3:OldOrigSystemReference xsi:nil=\"true\"/>\r\n" + 
				"                     <ns3:StartDateActive>2018-08-29</ns3:StartDateActive>\r\n" + 
				"                     <ns3:EndDateActive>4712-12-31</ns3:EndDateActive>\r\n" + 
				"                     <ns3:CreatedBy>Datacentre</ns3:CreatedBy>\r\n" + 
				"                     <ns3:CreationDate>2018-08-29T08:30:40.232Z</ns3:CreationDate>\r\n" + 
				"                     <ns3:LastUpdatedBy>Datacentre</ns3:LastUpdatedBy>\r\n" + 
				"                     <ns3:LastUpdateDate>2018-08-29T08:30:40.576Z</ns3:LastUpdateDate>\r\n" + 
				"                     <ns3:LastUpdateLogin>73D9B2C0741B2F73E0530A67360A8443</ns3:LastUpdateLogin>\r\n" + 
				"                     <ns3:ObjectVersionNumber>1</ns3:ObjectVersionNumber>\r\n" + 
				"                     <ns3:CreatedByModule>HZ_WS</ns3:CreatedByModule>\r\n" + 
				"                     <ns3:PartyId>100000044971942</ns3:PartyId>\r\n" + 
				"                     <ns3:RequestId xsi:nil=\"true\"/>\r\n" + 
				"                     <ns3:SourceSystemRefInformation>\r\n" + 
				"                        <ns4:OrigSystemRefId>300000603139992</ns4:OrigSystemRefId>\r\n" + 
				"                        <ns4:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"                        <ns4:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"                        <ns4:_FLEX_NumOfSegments>0</ns4:_FLEX_NumOfSegments>\r\n" + 
				"                     </ns3:SourceSystemRefInformation>\r\n" + 
				"                  </ns5:OriginalSystemReference>\r\n" + 
				"                  <ns5:EmailInformation>\r\n" + 
				"                     <ns6:ContactPointId>300000603139991</ns6:ContactPointId>\r\n" + 
				"                     <ns6:ContactPointType>EMAIL</ns6:ContactPointType>\r\n" + 
				"                     <ns6:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"                     <ns6:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"                     <ns6:_FLEX_NumOfSegments>0</ns6:_FLEX_NumOfSegments>\r\n" + 
				"                  </ns5:EmailInformation>\r\n" + 
				"               </ns1:Email>\r\n" + 
				"               <ns1:OriginalSystemReference xmlns:ns4=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/sourceSystemRef/\">\r\n" + 
				"                  <ns3:OrigSystemReferenceId>100000045860899</ns3:OrigSystemReferenceId>\r\n" + 
				"                  <ns3:OrigSystem>BLRWE</ns3:OrigSystem>\r\n" + 
				"                  <ns3:OrigSystemReference>89424836</ns3:OrigSystemReference>\r\n" + 
				"                  <ns3:OwnerTableName>HZ_PARTIES</ns3:OwnerTableName>\r\n" + 
				"                  <ns3:OwnerTableId>100000044971942</ns3:OwnerTableId>\r\n" + 
				"                  <ns3:Status>A</ns3:Status>\r\n" + 
				"                  <ns3:ReasonCode xsi:nil=\"true\"/>\r\n" + 
				"                  <ns3:OldOrigSystemReference xsi:nil=\"true\"/>\r\n" + 
				"                  <ns3:StartDateActive>2018-06-06</ns3:StartDateActive>\r\n" + 
				"                  <ns3:EndDateActive>4712-12-31</ns3:EndDateActive>\r\n" + 
				"                  <ns3:CreatedBy>Datacentre</ns3:CreatedBy>\r\n" + 
				"                  <ns3:CreationDate>2018-06-06T03:23:31.22127Z</ns3:CreationDate>\r\n" + 
				"                  <ns3:LastUpdatedBy>Datacentre</ns3:LastUpdatedBy>\r\n" + 
				"                  <ns3:LastUpdateDate>2018-06-06T03:23:31.22127Z</ns3:LastUpdateDate>\r\n" + 
				"                  <ns3:LastUpdateLogin>-1</ns3:LastUpdateLogin>\r\n" + 
				"                  <ns3:ObjectVersionNumber>1</ns3:ObjectVersionNumber>\r\n" + 
				"                  <ns3:CreatedByModule>HZ_IMPORT</ns3:CreatedByModule>\r\n" + 
				"                  <ns3:PartyId>100000044971942</ns3:PartyId>\r\n" + 
				"                  <ns3:RequestId>67968</ns3:RequestId>\r\n" + 
				"                  <ns3:SourceSystemRefInformation>\r\n" + 
				"                     <ns4:OrigSystemRefId>100000045860899</ns4:OrigSystemRefId>\r\n" + 
				"                     <ns4:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"                     <ns4:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"                     <ns4:_FLEX_NumOfSegments>0</ns4:_FLEX_NumOfSegments>\r\n" + 
				"                  </ns3:SourceSystemRefInformation>\r\n" + 
				"               </ns1:OriginalSystemReference>\r\n" + 
				"               <ns1:OriginalSystemReference xmlns:ns4=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/sourceSystemRef/\">\r\n" + 
				"                  <ns3:OrigSystemReferenceId>300000602160801</ns3:OrigSystemReferenceId>\r\n" + 
				"                  <ns3:OrigSystem>SIEBEL</ns3:OrigSystem>\r\n" + 
				"                  <ns3:OrigSystemReference>101014855654</ns3:OrigSystemReference>\r\n" + 
				"                  <ns3:OwnerTableName>HZ_PARTIES</ns3:OwnerTableName>\r\n" + 
				"                  <ns3:OwnerTableId>100000044971942</ns3:OwnerTableId>\r\n" + 
				"                  <ns3:Status>A</ns3:Status>\r\n" + 
				"                  <ns3:ReasonCode xsi:nil=\"true\"/>\r\n" + 
				"                  <ns3:OldOrigSystemReference xsi:nil=\"true\"/>\r\n" + 
				"                  <ns3:StartDateActive>2018-07-10</ns3:StartDateActive>\r\n" + 
				"                  <ns3:EndDateActive>4712-12-31</ns3:EndDateActive>\r\n" + 
				"                  <ns3:CreatedBy>Datacentre</ns3:CreatedBy>\r\n" + 
				"                  <ns3:CreationDate>2018-07-10T16:01:13.156Z</ns3:CreationDate>\r\n" + 
				"                  <ns3:LastUpdatedBy>Datacentre</ns3:LastUpdatedBy>\r\n" + 
				"                  <ns3:LastUpdateDate>2018-07-10T16:01:13.262Z</ns3:LastUpdateDate>\r\n" + 
				"                  <ns3:LastUpdateLogin>70A5FB8FF6C114A8E0530A67360AFE22</ns3:LastUpdateLogin>\r\n" + 
				"                  <ns3:ObjectVersionNumber>1</ns3:ObjectVersionNumber>\r\n" + 
				"                  <ns3:CreatedByModule>HZ_WS</ns3:CreatedByModule>\r\n" + 
				"                  <ns3:PartyId xsi:nil=\"true\"/>\r\n" + 
				"                  <ns3:RequestId xsi:nil=\"true\"/>\r\n" + 
				"                  <ns3:SourceSystemRefInformation>\r\n" + 
				"                     <ns4:OrigSystemRefId>300000602160801</ns4:OrigSystemRefId>\r\n" + 
				"                     <ns4:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"                     <ns4:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"                     <ns4:_FLEX_NumOfSegments>0</ns4:_FLEX_NumOfSegments>\r\n" + 
				"                  </ns3:SourceSystemRefInformation>\r\n" + 
				"               </ns1:OriginalSystemReference>\r\n" + 
				"               <ns1:PartySite xmlns:ns7=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/partySite/\">\r\n" + 
				"                  <ns3:PartySiteId>300000602160792</ns3:PartySiteId>\r\n" + 
				"                  <ns3:PartyId>100000044971942</ns3:PartyId>\r\n" + 
				"                  <ns3:LocationId>300000602160793</ns3:LocationId>\r\n" + 
				"                  <ns3:LastUpdateDate>2018-08-29T08:30:38.0Z</ns3:LastUpdateDate>\r\n" + 
				"                  <ns3:PartySiteNumber>7981043</ns3:PartySiteNumber>\r\n" + 
				"                  <ns3:LastUpdatedBy>Datacentre</ns3:LastUpdatedBy>\r\n" + 
				"                  <ns3:CreationDate>2018-07-10T16:00:28.025Z</ns3:CreationDate>\r\n" + 
				"                  <ns3:CreatedBy>Datacentre</ns3:CreatedBy>\r\n" + 
				"                  <ns3:LastUpdateLogin>73D9B57D7C432FEFE0530A67360ABFA6</ns3:LastUpdateLogin>\r\n" + 
				"                  <ns3:RequestId xsi:nil=\"true\"/>\r\n" + 
				"                  <ns3:OrigSystemReference>300000602160792</ns3:OrigSystemReference>\r\n" + 
				"                  <ns3:StartDateActive>2018-07-10</ns3:StartDateActive>\r\n" + 
				"                  <ns3:EndDateActive>4712-12-31</ns3:EndDateActive>\r\n" + 
				"                  <ns3:Mailstop xsi:nil=\"true\"/>\r\n" + 
				"                  <ns3:IdentifyingAddressFlag>false</ns3:IdentifyingAddressFlag>\r\n" + 
				"                  <ns3:Language xsi:nil=\"true\"/>\r\n" + 
				"                  <ns3:Status>I</ns3:Status>\r\n" + 
				"                  <ns3:PartySiteName xsi:nil=\"true\"/>\r\n" + 
				"                  <ns3:Addressee xsi:nil=\"true\"/>\r\n" + 
				"                  <ns3:ObjectVersionNumber>3</ns3:ObjectVersionNumber>\r\n" + 
				"                  <ns3:CreatedByModule>HZ_WS</ns3:CreatedByModule>\r\n" + 
				"                  <ns3:GlobalLocationNumber xsi:nil=\"true\"/>\r\n" + 
				"                  <ns3:DUNSNumberC xsi:nil=\"true\"/>\r\n" + 
				"                  <ns3:Comments xsi:nil=\"true\"/>\r\n" + 
				"                  <ns3:PartySiteType xsi:nil=\"true\"/>\r\n" + 
				"                  <ns3:PartyNameDba xsi:nil=\"true\"/>\r\n" + 
				"                  <ns3:PartyNameDivision xsi:nil=\"true\"/>\r\n" + 
				"                  <ns3:PartyNameLegal xsi:nil=\"true\"/>\r\n" + 
				"                  <ns3:RelationshipId xsi:nil=\"true\"/>\r\n" + 
				"                  <ns3:PartyUsageCode xsi:nil=\"true\"/>\r\n" + 
				"                  <ns3:OverallPrimaryFlag>false</ns3:OverallPrimaryFlag>\r\n" + 
				"                  <ns3:PersonPartySiteInformation>\r\n" + 
				"                     <ns7:PartySiteId>300000602160792</ns7:PartySiteId>\r\n" + 
				"                     <ns7:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"                     <ns7:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"                     <ns7:_FLEX_NumOfSegments>0</ns7:_FLEX_NumOfSegments>\r\n" + 
				"                  </ns3:PersonPartySiteInformation>\r\n" + 
				"               </ns1:PartySite>\r\n" + 
				"               <ns1:PartySite xmlns:ns7=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/partySite/\">\r\n" + 
				"                  <ns3:PartySiteId>300000603140925</ns3:PartySiteId>\r\n" + 
				"                  <ns3:PartyId>100000044971942</ns3:PartyId>\r\n" + 
				"                  <ns3:LocationId>300000603140926</ns3:LocationId>\r\n" + 
				"                  <ns3:LastUpdateDate>2018-08-29T08:30:35.052Z</ns3:LastUpdateDate>\r\n" + 
				"                  <ns3:PartySiteNumber>8006676</ns3:PartySiteNumber>\r\n" + 
				"                  <ns3:LastUpdatedBy>Datacentre</ns3:LastUpdatedBy>\r\n" + 
				"                  <ns3:CreationDate>2018-08-29T08:30:34.002Z</ns3:CreationDate>\r\n" + 
				"                  <ns3:CreatedBy>Datacentre</ns3:CreatedBy>\r\n" + 
				"                  <ns3:LastUpdateLogin>73D9B846F22D2F89E0530A67360A2BB0</ns3:LastUpdateLogin>\r\n" + 
				"                  <ns3:RequestId xsi:nil=\"true\"/>\r\n" + 
				"                  <ns3:OrigSystemReference>300000603140925</ns3:OrigSystemReference>\r\n" + 
				"                  <ns3:StartDateActive>2018-08-29</ns3:StartDateActive>\r\n" + 
				"                  <ns3:EndDateActive>4712-12-31</ns3:EndDateActive>\r\n" + 
				"                  <ns3:Mailstop xsi:nil=\"true\"/>\r\n" + 
				"                  <ns3:IdentifyingAddressFlag>true</ns3:IdentifyingAddressFlag>\r\n" + 
				"                  <ns3:Language xsi:nil=\"true\"/>\r\n" + 
				"                  <ns3:Status>A</ns3:Status>\r\n" + 
				"                  <ns3:PartySiteName xsi:nil=\"true\"/>\r\n" + 
				"                  <ns3:Addressee xsi:nil=\"true\"/>\r\n" + 
				"                  <ns3:ObjectVersionNumber>1</ns3:ObjectVersionNumber>\r\n" + 
				"                  <ns3:CreatedByModule>HZ_WS</ns3:CreatedByModule>\r\n" + 
				"                  <ns3:GlobalLocationNumber xsi:nil=\"true\"/>\r\n" + 
				"                  <ns3:DUNSNumberC xsi:nil=\"true\"/>\r\n" + 
				"                  <ns3:Comments xsi:nil=\"true\"/>\r\n" + 
				"                  <ns3:PartySiteType xsi:nil=\"true\"/>\r\n" + 
				"                  <ns3:PartyNameDba xsi:nil=\"true\"/>\r\n" + 
				"                  <ns3:PartyNameDivision xsi:nil=\"true\"/>\r\n" + 
				"                  <ns3:PartyNameLegal xsi:nil=\"true\"/>\r\n" + 
				"                  <ns3:RelationshipId xsi:nil=\"true\"/>\r\n" + 
				"                  <ns3:PartyUsageCode xsi:nil=\"true\"/>\r\n" + 
				"                  <ns3:OverallPrimaryFlag>true</ns3:OverallPrimaryFlag>\r\n" + 
				"                  <ns3:PartySiteUse>\r\n" + 
				"                     <ns3:PartySiteUseId>300000603140928</ns3:PartySiteUseId>\r\n" + 
				"                     <ns3:BeginDate>2018-08-29</ns3:BeginDate>\r\n" + 
				"                     <ns3:Comments xsi:nil=\"true\"/>\r\n" + 
				"                     <ns3:EndDate>4712-12-31</ns3:EndDate>\r\n" + 
				"                     <ns3:PartySiteId>300000603140925</ns3:PartySiteId>\r\n" + 
				"                     <ns3:LastUpdateDate>2018-08-29T08:30:34.723Z</ns3:LastUpdateDate>\r\n" + 
				"                     <ns3:RequestId xsi:nil=\"true\"/>\r\n" + 
				"                     <ns3:LastUpdatedBy>Datacentre</ns3:LastUpdatedBy>\r\n" + 
				"                     <ns3:CreationDate>2018-08-29T08:30:34.184Z</ns3:CreationDate>\r\n" + 
				"                     <ns3:CreatedBy>Datacentre</ns3:CreatedBy>\r\n" + 
				"                     <ns3:LastUpdateLogin>73D9B846F22D2F89E0530A67360A2BB0</ns3:LastUpdateLogin>\r\n" + 
				"                     <ns3:IntegrationKey xsi:nil=\"true\"/>\r\n" + 
				"                     <ns3:SiteUseType>HOME</ns3:SiteUseType>\r\n" + 
				"                     <ns3:PrimaryPerType>Y</ns3:PrimaryPerType>\r\n" + 
				"                     <ns3:Status>A</ns3:Status>\r\n" + 
				"                     <ns3:ObjectVersionNumber>1</ns3:ObjectVersionNumber>\r\n" + 
				"                     <ns3:CreatedByModule>HZ_WS</ns3:CreatedByModule>\r\n" + 
				"                  </ns3:PartySiteUse>\r\n" + 
				"                  <ns3:OriginalSystemReference xmlns:ns4=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/sourceSystemRef/\">\r\n" + 
				"                     <ns3:OrigSystemReferenceId>300000603140927</ns3:OrigSystemReferenceId>\r\n" + 
				"                     <ns3:OrigSystem>PMS</ns3:OrigSystem>\r\n" + 
				"                     <ns3:OrigSystemReference>2018082908303379506</ns3:OrigSystemReference>\r\n" + 
				"                     <ns3:OwnerTableName>HZ_PARTY_SITES</ns3:OwnerTableName>\r\n" + 
				"                     <ns3:OwnerTableId>300000603140925</ns3:OwnerTableId>\r\n" + 
				"                     <ns3:Status>A</ns3:Status>\r\n" + 
				"                     <ns3:ReasonCode xsi:nil=\"true\"/>\r\n" + 
				"                     <ns3:OldOrigSystemReference xsi:nil=\"true\"/>\r\n" + 
				"                     <ns3:StartDateActive>2018-08-29</ns3:StartDateActive>\r\n" + 
				"                     <ns3:EndDateActive>4712-12-31</ns3:EndDateActive>\r\n" + 
				"                     <ns3:CreatedBy>Datacentre</ns3:CreatedBy>\r\n" + 
				"                     <ns3:CreationDate>2018-08-29T08:30:34.147Z</ns3:CreationDate>\r\n" + 
				"                     <ns3:LastUpdatedBy>Datacentre</ns3:LastUpdatedBy>\r\n" + 
				"                     <ns3:LastUpdateDate>2018-08-29T08:30:34.703Z</ns3:LastUpdateDate>\r\n" + 
				"                     <ns3:LastUpdateLogin>73D9B846F22D2F89E0530A67360A2BB0</ns3:LastUpdateLogin>\r\n" + 
				"                     <ns3:ObjectVersionNumber>1</ns3:ObjectVersionNumber>\r\n" + 
				"                     <ns3:CreatedByModule>HZ_WS</ns3:CreatedByModule>\r\n" + 
				"                     <ns3:PartyId xsi:nil=\"true\"/>\r\n" + 
				"                     <ns3:RequestId xsi:nil=\"true\"/>\r\n" + 
				"                     <ns3:SourceSystemRefInformation>\r\n" + 
				"                        <ns4:OrigSystemRefId>300000603140927</ns4:OrigSystemRefId>\r\n" + 
				"                        <ns4:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"                        <ns4:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"                        <ns4:_FLEX_NumOfSegments>0</ns4:_FLEX_NumOfSegments>\r\n" + 
				"                     </ns3:SourceSystemRefInformation>\r\n" + 
				"                  </ns3:OriginalSystemReference>\r\n" + 
				"                  <ns3:PersonPartySiteInformation>\r\n" + 
				"                     <ns7:PartySiteId>300000603140925</ns7:PartySiteId>\r\n" + 
				"                     <ns7:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"                     <ns7:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"                     <ns7:_FLEX_NumOfSegments>0</ns7:_FLEX_NumOfSegments>\r\n" + 
				"                  </ns3:PersonPartySiteInformation>\r\n" + 
				"               </ns1:PartySite>\r\n" + 
				"               <ns1:PersonProfile xmlns:ns2=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/person/\">\r\n" + 
				"                  <ns1:PersonProfileId>100000044971942</ns1:PersonProfileId>\r\n" + 
				"                  <ns1:PartyId>100000044971942</ns1:PartyId>\r\n" + 
				"                  <ns1:PersonName>Shrilaxmi reddy</ns1:PersonName>\r\n" + 
				"                  <ns1:LastUpdateDate>2019-04-02T06:59:05.472Z</ns1:LastUpdateDate>\r\n" + 
				"                  <ns1:LastUpdatedBy>Datacentre</ns1:LastUpdatedBy>\r\n" + 
				"                  <ns1:CreationDate>2018-06-06T03:27:57.510025Z</ns1:CreationDate>\r\n" + 
				"                  <ns1:CreatedBy>Datacentre</ns1:CreatedBy>\r\n" + 
				"                  <ns1:LastUpdateLogin>7EAD65F273AE2234E0530867360A86B6</ns1:LastUpdateLogin>\r\n" + 
				"                  <ns1:RequestId>101971</ns1:RequestId>\r\n" + 
				"                  <ns1:PersonPreNameAdjunct>Ms.</ns1:PersonPreNameAdjunct>\r\n" + 
				"                  <ns1:PersonFirstName>Shrilaxmi</ns1:PersonFirstName>\r\n" + 
				"                  <ns1:PersonMiddleName xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:PersonLastName>reddy</ns1:PersonLastName>\r\n" + 
				"                  <ns1:PersonNameSuffix xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:PersonTitle xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:PersonAcademicTitle xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:PersonPreviousLastName xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:PersonInitials xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:JgzzFiscalCode xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:DateOfBirth>1995-05-12</ns1:DateOfBirth>\r\n" + 
				"                  <ns1:PlaceOfBirth xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:DateOfDeath xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:Gender>UNKNOWN</ns1:Gender>\r\n" + 
				"                  <ns1:DeclaredEthnicity xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:MaritalStatus xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:MaritalStatusEffectiveDate xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:PersonalIncomeAmount xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:RentOwnInd xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:LastKnownGPS xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:EffectiveStartDate>2018-06-06</ns1:EffectiveStartDate>\r\n" + 
				"                  <ns1:EffectiveEndDate>4712-12-31</ns1:EffectiveEndDate>\r\n" + 
				"                  <ns1:InternalFlag>false</ns1:InternalFlag>\r\n" + 
				"                  <ns1:Status>A</ns1:Status>\r\n" + 
				"                  <ns1:CreatedByModule>HZ_IMPORT</ns1:CreatedByModule>\r\n" + 
				"                  <ns1:DeceasedFlag>false</ns1:DeceasedFlag>\r\n" + 
				"                  <ns1:Comments xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:PersonLastNamePrefix xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:PersonSecondLastName xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:PreferredFunctionalCurrency xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:OrigSystem xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:OrigSystemReference>89424836</ns1:OrigSystemReference>\r\n" + 
				"                  <ns1:EffectiveSequence>1</ns1:EffectiveSequence>\r\n" + 
				"                  <ns1:HeadOfHouseholdFlag xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:HouseholdIncomeAmount xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:HouseholdSize xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:EffectiveLatestChange>Y</ns1:EffectiveLatestChange>\r\n" + 
				"                  <ns1:SuffixOverriddenFlag>false</ns1:SuffixOverriddenFlag>\r\n" + 
				"                  <ns1:UniqueNameSuffix xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:CorpCurrencyCode xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:CurcyConvRateType xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:CurrencyCode xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:PartyNumber>2973180</ns1:PartyNumber>\r\n" + 
				"                  <ns1:Salutation xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:CertReasonCode xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:CertificationLevel xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:PreferredContactMethod xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:PreferredContactPersonId xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:PrimaryAddressLine1>Sln</ns1:PrimaryAddressLine1>\r\n" + 
				"                  <ns1:PrimaryAddressLine2>Terminus</ns1:PrimaryAddressLine2>\r\n" + 
				"                  <ns1:PrimaryAddressLine3 xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:PrimaryAddressLine4 xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:Alias xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:PrimaryAddressCity>Hyderabad</ns1:PrimaryAddressCity>\r\n" + 
				"                  <ns1:PrimaryAddressCountry>IN</ns1:PrimaryAddressCountry>\r\n" + 
				"                  <ns1:PrimaryAddressCounty xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:PrimaryEmailAddress>Shrilaxmi@test.com</ns1:PrimaryEmailAddress>\r\n" + 
				"                  <ns1:PrimaryFormattedAddress>Sln,Terminus,HYDERABAD-500014,TS</ns1:PrimaryFormattedAddress>\r\n" + 
				"                  <ns1:PrimaryFormattedPhoneNumber xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:PrimaryLanguage xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:PartyUniqueName>Shrilaxmi reddy</ns1:PartyUniqueName>\r\n" + 
				"                  <ns1:PrimaryAddressPostalCode>500014</ns1:PrimaryAddressPostalCode>\r\n" + 
				"                  <ns1:PreferredContactEmail xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:PreferredContactName xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:PreferredContactPhone xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:PreferredContactURL xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:PreferredName xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:PreferredNameId xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:PrimaryEmailId>300000603139991</ns1:PrimaryEmailId>\r\n" + 
				"                  <ns1:PrimaryPhoneAreaCode xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:PrimaryPhoneId xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:PrimaryPhoneCountryCode xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:PrimaryPhoneExtension xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:PrimaryPhoneLineType xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:PrimaryPhoneNumber xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:PrimaryPhonePurpose xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:PrimaryWebId xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:Pronunciation xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:PrimaryAddressProvince xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:PrimaryAddressState>TS</ns1:PrimaryAddressState>\r\n" + 
				"                  <ns1:PrimaryURL xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:ValidatedFlag>false</ns1:ValidatedFlag>\r\n" + 
				"                  <ns1:PrimaryAddressLatitude xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:PrimaryAddressLongitude xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:PrimaryAddressLocationId>300000603140926</ns1:PrimaryAddressLocationId>\r\n" + 
				"                  <ns1:FavoriteContactFlag>false</ns1:FavoriteContactFlag>\r\n" + 
				"                  <ns1:Distance xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:SalesAffinityCode xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:SalesBuyingRoleCode xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:DepartmentCode xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:Department xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:JobTitleCode xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:JobTitle xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:DoNotCallFlag>false</ns1:DoNotCallFlag>\r\n" + 
				"                  <ns1:DoNotContactFlag>false</ns1:DoNotContactFlag>\r\n" + 
				"                  <ns1:DoNotEmailFlag>false</ns1:DoNotEmailFlag>\r\n" + 
				"                  <ns1:DoNotMailFlag>false</ns1:DoNotMailFlag>\r\n" + 
				"                  <ns1:LastContactDate xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:PrimaryCustomerId xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:PrimaryCustomerRelationshipId xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:PrimaryCustomerName xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:LastSourceUpdateDate>2019-04-02T06:59:05.0Z</ns1:LastSourceUpdateDate>\r\n" + 
				"                  <ns1:LastUpdateSourceSystem>UNKNOWN</ns1:LastUpdateSourceSystem>\r\n" + 
				"                  <ns1:DataCloudStatus xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:LastEnrichmentDate xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:PersonInformation>\r\n" + 
				"                     <ns2:PersonProfileId>100000044971942</ns2:PersonProfileId>\r\n" + 
				"                     <ns2:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"                     <ns2:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"                     <ns2:_FLEX_NumOfSegments>0</ns2:_FLEX_NumOfSegments>\r\n" + 
				"                  </ns1:PersonInformation>\r\n" + 
				"                  <ns1:Secretary_Id_c xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:Secretary_c xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:ChamberMember_c>false</ns1:ChamberMember_c>\r\n" + 
				"                  <ns1:Category_c xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:ContactLevel_c xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:OtherSalutation_c xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:SpouseName_c xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:SecretaryFormulaField_c xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:LoyaltyMembership_c xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:Tier_c xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:LoyaltyMembershipNumber_c xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:MembershipNumber_c xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:Passport_c xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:DateOfBirth_c xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:ChamberMembershipNumber_c xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:AccountCity_c xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:AccountCity1_c xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:Association_c xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:PANNumber_c xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:ProfileCreatedAtChannel_c xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:ProfileCreatedAtProperty_c>BLRWE</ns1:ProfileCreatedAtProperty_c>\r\n" + 
				"                  <ns1:ProfileCreatedBy_c>*TRUST_XML*</ns1:ProfileCreatedBy_c>\r\n" + 
				"                  <ns1:ProfileCreatedDate_c>2017-05-29</ns1:ProfileCreatedDate_c>\r\n" + 
				"                  <ns1:ProfileUpdatedBy_c xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:ProfileUpdatedDate_c>2019-01-09</ns1:ProfileUpdatedDate_c>\r\n" + 
				"                  <ns1:NationalityLOV_c xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:SpouseBirthday_c xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:AnniversaryDate_c xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:LegalCompany_c xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:AadhaarNumber_c xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:LicenseNumber_c xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:VIPLOV_c xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:Profession_c xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:MUI_c xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:LastUpdateSource_c>PMS</ns1:LastUpdateSource_c>\r\n" + 
				"                  <ns1:LanguagePreference_c>E</ns1:LanguagePreference_c>\r\n" + 
				"                  <ns1:NotParticipateInMarketRea_c>false</ns1:NotParticipateInMarketRea_c>\r\n" + 
				"                  <ns1:NotReceiveEmails_c>true</ns1:NotReceiveEmails_c>\r\n" + 
				"                  <ns1:NotInfoFromThirdParty_c>false</ns1:NotInfoFromThirdParty_c>\r\n" + 
				"                  <ns1:LicenseIDIssueDate_c xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:PassportIDIssueDate_c xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:AadhaarIssueDate_c xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:LicenseIDIssuePlace_c xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:PassportIDIssuePlace_c xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:AadhaarIssuePlace_c xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:PassportIDExpiryDate_c xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:WebSite_c xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:PrivateWebpage_c xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:ARNo_c xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:Restricted_c>false</ns1:Restricted_c>\r\n" + 
				"                  <ns1:RestrictRule_c xsi:nil=\"true\"/>\r\n" + 
				"                  <ns1:LoyaltyMembershipsCollection_c>\r\n" + 
				"                     <ns1:Id>300000602160799</ns1:Id>\r\n" + 
				"                     <ns1:RecordName>SR-0013665-180710</ns1:RecordName>\r\n" + 
				"                     <ns1:CreatedBy>Datacentre</ns1:CreatedBy>\r\n" + 
				"                     <ns1:CreationDate>2018-07-10T16:01:13.0Z</ns1:CreationDate>\r\n" + 
				"                     <ns1:LastUpdatedBy>Datacentre</ns1:LastUpdatedBy>\r\n" + 
				"                     <ns1:LastUpdateDate>2018-07-10T16:01:13.171Z</ns1:LastUpdateDate>\r\n" + 
				"                     <ns1:ObjectVersionNumber>1</ns1:ObjectVersionNumber>\r\n" + 
				"                     <ns1:PersonProfile_Id_c>100000044971942</ns1:PersonProfile_Id_c>\r\n" + 
				"                     <ns1:RecordNumber>8717468</ns1:RecordNumber>\r\n" + 
				"                     <ns1:LastUpdateLogin xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:UserLastUpdateDate xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:CurrencyCode>INR</ns1:CurrencyCode>\r\n" + 
				"                     <ns1:CurcyConvRateType>Corporate</ns1:CurcyConvRateType>\r\n" + 
				"                     <ns1:CorpCurrencyCode>INR</ns1:CorpCurrencyCode>\r\n" + 
				"                     <ns1:ContactID_c>1-3OIE2JC</ns1:ContactID_c>\r\n" + 
				"                     <ns1:MemberSince_c>2018-07-10</ns1:MemberSince_c>\r\n" + 
				"                     <ns1:MembershipCardNo_c>101014855654</ns1:MembershipCardNo_c>\r\n" + 
				"                     <ns1:MembershipClass_c xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:MembershipDescription_c xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:MembershipExpirationNew_c>2019-07-09</ns1:MembershipExpirationNew_c>\r\n" + 
				"                     <ns1:MembershipLevel_c xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:MembershipType_c xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:NameOnCard_c>Shrilaxmi reddy</ns1:NameOnCard_c>\r\n" + 
				"                     <ns1:InactiveNew_c>false</ns1:InactiveNew_c>\r\n" + 
				"                     <ns1:MembershipTypeLOV_c>TAJ</ns1:MembershipTypeLOV_c>\r\n" + 
				"                     <ns1:MembershipLevelLOV_c>TC</ns1:MembershipLevelLOV_c>\r\n" + 
				"                     <ns1:MUI_temp_c>Y</ns1:MUI_temp_c>\r\n" + 
				"                  </ns1:LoyaltyMembershipsCollection_c>\r\n" + 
				"                  <ns1:LoyaltyMembershipsCollection_c>\r\n" + 
				"                     <ns1:Id>300000606980059</ns1:Id>\r\n" + 
				"                     <ns1:RecordName>SR-0015590-190124</ns1:RecordName>\r\n" + 
				"                     <ns1:CreatedBy>Datacentre</ns1:CreatedBy>\r\n" + 
				"                     <ns1:CreationDate>2019-01-24T10:18:22.0Z</ns1:CreationDate>\r\n" + 
				"                     <ns1:LastUpdatedBy>Datacentre</ns1:LastUpdatedBy>\r\n" + 
				"                     <ns1:LastUpdateDate>2019-01-24T10:19:13.526Z</ns1:LastUpdateDate>\r\n" + 
				"                     <ns1:ObjectVersionNumber>1</ns1:ObjectVersionNumber>\r\n" + 
				"                     <ns1:PersonProfile_Id_c>100000044971942</ns1:PersonProfile_Id_c>\r\n" + 
				"                     <ns1:RecordNumber>9881825</ns1:RecordNumber>\r\n" + 
				"                     <ns1:LastUpdateLogin xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:UserLastUpdateDate xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:CurrencyCode>INR</ns1:CurrencyCode>\r\n" + 
				"                     <ns1:CurcyConvRateType>Corporate</ns1:CurcyConvRateType>\r\n" + 
				"                     <ns1:CorpCurrencyCode>INR</ns1:CorpCurrencyCode>\r\n" + 
				"                     <ns1:ContactID_c xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:MemberSince_c>2019-01-23</ns1:MemberSince_c>\r\n" + 
				"                     <ns1:MembershipCardNo_c>101014100004</ns1:MembershipCardNo_c>\r\n" + 
				"                     <ns1:MembershipClass_c xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:MembershipDescription_c xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:MembershipExpirationNew_c>2020-01-24</ns1:MembershipExpirationNew_c>\r\n" + 
				"                     <ns1:MembershipLevel_c xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:MembershipType_c xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:NameOnCard_c>DUMMY4 SIEBELUI</ns1:NameOnCard_c>\r\n" + 
				"                     <ns1:InactiveNew_c>false</ns1:InactiveNew_c>\r\n" + 
				"                     <ns1:MembershipTypeLOV_c>TAJ</ns1:MembershipTypeLOV_c>\r\n" + 
				"                     <ns1:MembershipLevelLOV_c>TC</ns1:MembershipLevelLOV_c>\r\n" + 
				"                     <ns1:MUI_temp_c xsi:nil=\"true\"/>\r\n" + 
				"                  </ns1:LoyaltyMembershipsCollection_c>\r\n" + 
				"                  <ns1:LoyaltyMembershipsCollection_c>\r\n" + 
				"                     <ns1:Id>300000607124835</ns1:Id>\r\n" + 
				"                     <ns1:RecordName>SR-0015926-190329</ns1:RecordName>\r\n" + 
				"                     <ns1:CreatedBy>Datacentre</ns1:CreatedBy>\r\n" + 
				"                     <ns1:CreationDate>2019-03-29T10:01:13.0Z</ns1:CreationDate>\r\n" + 
				"                     <ns1:LastUpdatedBy>Datacentre</ns1:LastUpdatedBy>\r\n" + 
				"                     <ns1:LastUpdateDate>2019-04-02T06:59:05.749Z</ns1:LastUpdateDate>\r\n" + 
				"                     <ns1:ObjectVersionNumber>4</ns1:ObjectVersionNumber>\r\n" + 
				"                     <ns1:PersonProfile_Id_c>100000044971942</ns1:PersonProfile_Id_c>\r\n" + 
				"                     <ns1:RecordNumber>9948146</ns1:RecordNumber>\r\n" + 
				"                     <ns1:LastUpdateLogin xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:UserLastUpdateDate xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:CurrencyCode>INR</ns1:CurrencyCode>\r\n" + 
				"                     <ns1:CurcyConvRateType>Corporate</ns1:CurcyConvRateType>\r\n" + 
				"                     <ns1:CorpCurrencyCode>INR</ns1:CorpCurrencyCode>\r\n" + 
				"                     <ns1:ContactID_c xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:MemberSince_c>2019-03-28</ns1:MemberSince_c>\r\n" + 
				"                     <ns1:MembershipCardNo_c>9874563210</ns1:MembershipCardNo_c>\r\n" + 
				"                     <ns1:MembershipClass_c xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:MembershipDescription_c xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:MembershipExpirationNew_c>2020-03-27</ns1:MembershipExpirationNew_c>\r\n" + 
				"                     <ns1:MembershipLevel_c xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:MembershipType_c xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:NameOnCard_c>Abhishek Jha</ns1:NameOnCard_c>\r\n" + 
				"                     <ns1:InactiveNew_c>true</ns1:InactiveNew_c>\r\n" + 
				"                     <ns1:MembershipTypeLOV_c>ET</ns1:MembershipTypeLOV_c>\r\n" + 
				"                     <ns1:MembershipLevelLOV_c>GE</ns1:MembershipLevelLOV_c>\r\n" + 
				"                     <ns1:MUI_temp_c xsi:nil=\"true\"/>\r\n" + 
				"                  </ns1:LoyaltyMembershipsCollection_c>\r\n" + 
				"                  <ns1:LoyaltyMembershipsCollection_c>\r\n" + 
				"                     <ns1:Id>300000607124867</ns1:Id>\r\n" + 
				"                     <ns1:RecordName>SR-0015927-190329</ns1:RecordName>\r\n" + 
				"                     <ns1:CreatedBy>Datacentre</ns1:CreatedBy>\r\n" + 
				"                     <ns1:CreationDate>2019-03-29T10:07:35.0Z</ns1:CreationDate>\r\n" + 
				"                     <ns1:LastUpdatedBy>Datacentre</ns1:LastUpdatedBy>\r\n" + 
				"                     <ns1:LastUpdateDate>2019-04-02T06:03:51.495Z</ns1:LastUpdateDate>\r\n" + 
				"                     <ns1:ObjectVersionNumber>3</ns1:ObjectVersionNumber>\r\n" + 
				"                     <ns1:PersonProfile_Id_c>100000044971942</ns1:PersonProfile_Id_c>\r\n" + 
				"                     <ns1:RecordNumber>9948147</ns1:RecordNumber>\r\n" + 
				"                     <ns1:LastUpdateLogin xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:UserLastUpdateDate xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:CurrencyCode>INR</ns1:CurrencyCode>\r\n" + 
				"                     <ns1:CurcyConvRateType>Corporate</ns1:CurcyConvRateType>\r\n" + 
				"                     <ns1:CorpCurrencyCode>INR</ns1:CorpCurrencyCode>\r\n" + 
				"                     <ns1:ContactID_c xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:MemberSince_c>2019-03-28</ns1:MemberSince_c>\r\n" + 
				"                     <ns1:MembershipCardNo_c>987468158615</ns1:MembershipCardNo_c>\r\n" + 
				"                     <ns1:MembershipClass_c xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:MembershipDescription_c xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:MembershipExpirationNew_c>2020-03-27</ns1:MembershipExpirationNew_c>\r\n" + 
				"                     <ns1:MembershipLevel_c xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:MembershipType_c xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:NameOnCard_c>Abhishek Jha</ns1:NameOnCard_c>\r\n" + 
				"                     <ns1:InactiveNew_c>false</ns1:InactiveNew_c>\r\n" + 
				"                     <ns1:MembershipTypeLOV_c>ET</ns1:MembershipTypeLOV_c>\r\n" + 
				"                     <ns1:MembershipLevelLOV_c>GE</ns1:MembershipLevelLOV_c>\r\n" + 
				"                     <ns1:MUI_temp_c xsi:nil=\"true\"/>\r\n" + 
				"                  </ns1:LoyaltyMembershipsCollection_c>\r\n" + 
				"                  <ns1:LoyaltyMembershipsCollection_c>\r\n" + 
				"                     <ns1:Id>300000607119876</ns1:Id>\r\n" + 
				"                     <ns1:RecordName>SR-0015928-190329</ns1:RecordName>\r\n" + 
				"                     <ns1:CreatedBy>Datacentre</ns1:CreatedBy>\r\n" + 
				"                     <ns1:CreationDate>2019-03-29T10:11:38.0Z</ns1:CreationDate>\r\n" + 
				"                     <ns1:LastUpdatedBy>Datacentre</ns1:LastUpdatedBy>\r\n" + 
				"                     <ns1:LastUpdateDate>2019-04-02T06:03:51.504Z</ns1:LastUpdateDate>\r\n" + 
				"                     <ns1:ObjectVersionNumber>3</ns1:ObjectVersionNumber>\r\n" + 
				"                     <ns1:PersonProfile_Id_c>100000044971942</ns1:PersonProfile_Id_c>\r\n" + 
				"                     <ns1:RecordNumber>9948170</ns1:RecordNumber>\r\n" + 
				"                     <ns1:LastUpdateLogin xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:UserLastUpdateDate xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:CurrencyCode>INR</ns1:CurrencyCode>\r\n" + 
				"                     <ns1:CurcyConvRateType>Corporate</ns1:CurcyConvRateType>\r\n" + 
				"                     <ns1:CorpCurrencyCode>INR</ns1:CorpCurrencyCode>\r\n" + 
				"                     <ns1:ContactID_c xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:MemberSince_c>2019-03-28</ns1:MemberSince_c>\r\n" + 
				"                     <ns1:MembershipCardNo_c>54168168534</ns1:MembershipCardNo_c>\r\n" + 
				"                     <ns1:MembershipClass_c xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:MembershipDescription_c xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:MembershipExpirationNew_c>2020-03-27</ns1:MembershipExpirationNew_c>\r\n" + 
				"                     <ns1:MembershipLevel_c xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:MembershipType_c xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:NameOnCard_c>Abhishek Jha</ns1:NameOnCard_c>\r\n" + 
				"                     <ns1:InactiveNew_c>false</ns1:InactiveNew_c>\r\n" + 
				"                     <ns1:MembershipTypeLOV_c>ET</ns1:MembershipTypeLOV_c>\r\n" + 
				"                     <ns1:MembershipLevelLOV_c>GE</ns1:MembershipLevelLOV_c>\r\n" + 
				"                     <ns1:MUI_temp_c xsi:nil=\"true\"/>\r\n" + 
				"                  </ns1:LoyaltyMembershipsCollection_c>\r\n" + 
				"                  <ns1:LoyaltyMembershipsCollection_c>\r\n" + 
				"                     <ns1:Id>300000607119886</ns1:Id>\r\n" + 
				"                     <ns1:RecordName>SR-0015929-190329</ns1:RecordName>\r\n" + 
				"                     <ns1:CreatedBy>Datacentre</ns1:CreatedBy>\r\n" + 
				"                     <ns1:CreationDate>2019-03-29T10:14:13.0Z</ns1:CreationDate>\r\n" + 
				"                     <ns1:LastUpdatedBy>Datacentre</ns1:LastUpdatedBy>\r\n" + 
				"                     <ns1:LastUpdateDate>2019-04-02T06:03:51.507Z</ns1:LastUpdateDate>\r\n" + 
				"                     <ns1:ObjectVersionNumber>3</ns1:ObjectVersionNumber>\r\n" + 
				"                     <ns1:PersonProfile_Id_c>100000044971942</ns1:PersonProfile_Id_c>\r\n" + 
				"                     <ns1:RecordNumber>9948177</ns1:RecordNumber>\r\n" + 
				"                     <ns1:LastUpdateLogin xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:UserLastUpdateDate xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:CurrencyCode>INR</ns1:CurrencyCode>\r\n" + 
				"                     <ns1:CurcyConvRateType>Corporate</ns1:CurcyConvRateType>\r\n" + 
				"                     <ns1:CorpCurrencyCode>INR</ns1:CorpCurrencyCode>\r\n" + 
				"                     <ns1:ContactID_c xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:MemberSince_c>2019-03-08</ns1:MemberSince_c>\r\n" + 
				"                     <ns1:MembershipCardNo_c>1245789630</ns1:MembershipCardNo_c>\r\n" + 
				"                     <ns1:MembershipClass_c xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:MembershipDescription_c xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:MembershipExpirationNew_c>2019-03-28</ns1:MembershipExpirationNew_c>\r\n" + 
				"                     <ns1:MembershipLevel_c xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:MembershipType_c xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:NameOnCard_c>Ugender</ns1:NameOnCard_c>\r\n" + 
				"                     <ns1:InactiveNew_c>false</ns1:InactiveNew_c>\r\n" + 
				"                     <ns1:MembershipTypeLOV_c>ET</ns1:MembershipTypeLOV_c>\r\n" + 
				"                     <ns1:MembershipLevelLOV_c>GE</ns1:MembershipLevelLOV_c>\r\n" + 
				"                     <ns1:MUI_temp_c xsi:nil=\"true\"/>\r\n" + 
				"                  </ns1:LoyaltyMembershipsCollection_c>\r\n" + 
				"                  <ns1:LoyaltyMembershipsCollection_c>\r\n" + 
				"                     <ns1:Id>300000607137293</ns1:Id>\r\n" + 
				"                     <ns1:RecordName>SR-0015931-190401</ns1:RecordName>\r\n" + 
				"                     <ns1:CreatedBy>Datacentre</ns1:CreatedBy>\r\n" + 
				"                     <ns1:CreationDate>2019-04-01T07:17:15.0Z</ns1:CreationDate>\r\n" + 
				"                     <ns1:LastUpdatedBy>Datacentre</ns1:LastUpdatedBy>\r\n" + 
				"                     <ns1:LastUpdateDate>2019-04-02T06:59:05.745Z</ns1:LastUpdateDate>\r\n" + 
				"                     <ns1:ObjectVersionNumber>4</ns1:ObjectVersionNumber>\r\n" + 
				"                     <ns1:PersonProfile_Id_c>100000044971942</ns1:PersonProfile_Id_c>\r\n" + 
				"                     <ns1:RecordNumber>9948844</ns1:RecordNumber>\r\n" + 
				"                     <ns1:LastUpdateLogin xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:UserLastUpdateDate xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:CurrencyCode>INR</ns1:CurrencyCode>\r\n" + 
				"                     <ns1:CurcyConvRateType>Corporate</ns1:CurcyConvRateType>\r\n" + 
				"                     <ns1:CorpCurrencyCode>INR</ns1:CorpCurrencyCode>\r\n" + 
				"                     <ns1:ContactID_c xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:MemberSince_c>2019-04-16</ns1:MemberSince_c>\r\n" + 
				"                     <ns1:MembershipCardNo_c>74745381514</ns1:MembershipCardNo_c>\r\n" + 
				"                     <ns1:MembershipClass_c xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:MembershipDescription_c xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:MembershipExpirationNew_c>2019-04-06</ns1:MembershipExpirationNew_c>\r\n" + 
				"                     <ns1:MembershipLevel_c xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:MembershipType_c xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:NameOnCard_c>Naveen</ns1:NameOnCard_c>\r\n" + 
				"                     <ns1:InactiveNew_c>true</ns1:InactiveNew_c>\r\n" + 
				"                     <ns1:MembershipTypeLOV_c>ET</ns1:MembershipTypeLOV_c>\r\n" + 
				"                     <ns1:MembershipLevelLOV_c>GE</ns1:MembershipLevelLOV_c>\r\n" + 
				"                     <ns1:MUI_temp_c xsi:nil=\"true\"/>\r\n" + 
				"                  </ns1:LoyaltyMembershipsCollection_c>\r\n" + 
				"                  <ns1:LoyaltyMembershipsCollection_c>\r\n" + 
				"                     <ns1:Id>300000607135679</ns1:Id>\r\n" + 
				"                     <ns1:RecordName>SR-0015932-190402</ns1:RecordName>\r\n" + 
				"                     <ns1:CreatedBy>Datacentre</ns1:CreatedBy>\r\n" + 
				"                     <ns1:CreationDate>2019-04-02T05:39:02.0Z</ns1:CreationDate>\r\n" + 
				"                     <ns1:LastUpdatedBy>Datacentre</ns1:LastUpdatedBy>\r\n" + 
				"                     <ns1:LastUpdateDate>2019-04-02T06:03:51.498Z</ns1:LastUpdateDate>\r\n" + 
				"                     <ns1:ObjectVersionNumber>2</ns1:ObjectVersionNumber>\r\n" + 
				"                     <ns1:PersonProfile_Id_c>100000044971942</ns1:PersonProfile_Id_c>\r\n" + 
				"                     <ns1:RecordNumber>9948849</ns1:RecordNumber>\r\n" + 
				"                     <ns1:LastUpdateLogin xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:UserLastUpdateDate xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:CurrencyCode>INR</ns1:CurrencyCode>\r\n" + 
				"                     <ns1:CurcyConvRateType>Corporate</ns1:CurcyConvRateType>\r\n" + 
				"                     <ns1:CorpCurrencyCode>INR</ns1:CorpCurrencyCode>\r\n" + 
				"                     <ns1:ContactID_c xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:MemberSince_c>2019-04-10</ns1:MemberSince_c>\r\n" + 
				"                     <ns1:MembershipCardNo_c>2973180123</ns1:MembershipCardNo_c>\r\n" + 
				"                     <ns1:MembershipClass_c xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:MembershipDescription_c xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:MembershipExpirationNew_c>2020-04-05</ns1:MembershipExpirationNew_c>\r\n" + 
				"                     <ns1:MembershipLevel_c xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:MembershipType_c xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:NameOnCard_c>Abhishek Jha</ns1:NameOnCard_c>\r\n" + 
				"                     <ns1:InactiveNew_c>false</ns1:InactiveNew_c>\r\n" + 
				"                     <ns1:MembershipTypeLOV_c>ET</ns1:MembershipTypeLOV_c>\r\n" + 
				"                     <ns1:MembershipLevelLOV_c>GE</ns1:MembershipLevelLOV_c>\r\n" + 
				"                     <ns1:MUI_temp_c xsi:nil=\"true\"/>\r\n" + 
				"                  </ns1:LoyaltyMembershipsCollection_c>\r\n" + 
				"                  <ns1:LoyaltyMembershipsCollection_c>\r\n" + 
				"                     <ns1:Id>300000607146066</ns1:Id>\r\n" + 
				"                     <ns1:RecordName>SR-0015933-190402</ns1:RecordName>\r\n" + 
				"                     <ns1:CreatedBy>Datacentre</ns1:CreatedBy>\r\n" + 
				"                     <ns1:CreationDate>2019-04-02T06:04:34.0Z</ns1:CreationDate>\r\n" + 
				"                     <ns1:LastUpdatedBy>Datacentre</ns1:LastUpdatedBy>\r\n" + 
				"                     <ns1:LastUpdateDate>2019-04-02T06:09:22.142Z</ns1:LastUpdateDate>\r\n" + 
				"                     <ns1:ObjectVersionNumber>2</ns1:ObjectVersionNumber>\r\n" + 
				"                     <ns1:PersonProfile_Id_c>100000044971942</ns1:PersonProfile_Id_c>\r\n" + 
				"                     <ns1:RecordNumber>9948850</ns1:RecordNumber>\r\n" + 
				"                     <ns1:LastUpdateLogin xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:UserLastUpdateDate xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:CurrencyCode>INR</ns1:CurrencyCode>\r\n" + 
				"                     <ns1:CurcyConvRateType>Corporate</ns1:CurcyConvRateType>\r\n" + 
				"                     <ns1:CorpCurrencyCode>INR</ns1:CorpCurrencyCode>\r\n" + 
				"                     <ns1:ContactID_c xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:MemberSince_c>2017-04-13</ns1:MemberSince_c>\r\n" + 
				"                     <ns1:MembershipCardNo_c>7864586548</ns1:MembershipCardNo_c>\r\n" + 
				"                     <ns1:MembershipClass_c xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:MembershipDescription_c xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:MembershipExpirationNew_c>2019-03-08</ns1:MembershipExpirationNew_c>\r\n" + 
				"                     <ns1:MembershipLevel_c xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:MembershipType_c xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:NameOnCard_c>Abhishek</ns1:NameOnCard_c>\r\n" + 
				"                     <ns1:InactiveNew_c>false</ns1:InactiveNew_c>\r\n" + 
				"                     <ns1:MembershipTypeLOV_c>ET</ns1:MembershipTypeLOV_c>\r\n" + 
				"                     <ns1:MembershipLevelLOV_c>GE</ns1:MembershipLevelLOV_c>\r\n" + 
				"                     <ns1:MUI_temp_c xsi:nil=\"true\"/>\r\n" + 
				"                  </ns1:LoyaltyMembershipsCollection_c>\r\n" + 
				"                  <ns1:LoyaltyMembershipsCollection_c>\r\n" + 
				"                     <ns1:Id>300000607137326</ns1:Id>\r\n" + 
				"                     <ns1:RecordName>SR-0015934-190402</ns1:RecordName>\r\n" + 
				"                     <ns1:CreatedBy>Datacentre</ns1:CreatedBy>\r\n" + 
				"                     <ns1:CreationDate>2019-04-02T06:08:36.0Z</ns1:CreationDate>\r\n" + 
				"                     <ns1:LastUpdatedBy>Datacentre</ns1:LastUpdatedBy>\r\n" + 
				"                     <ns1:LastUpdateDate>2019-04-02T06:59:05.74Z</ns1:LastUpdateDate>\r\n" + 
				"                     <ns1:ObjectVersionNumber>2</ns1:ObjectVersionNumber>\r\n" + 
				"                     <ns1:PersonProfile_Id_c>100000044971942</ns1:PersonProfile_Id_c>\r\n" + 
				"                     <ns1:RecordNumber>9948851</ns1:RecordNumber>\r\n" + 
				"                     <ns1:LastUpdateLogin xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:UserLastUpdateDate xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:CurrencyCode>INR</ns1:CurrencyCode>\r\n" + 
				"                     <ns1:CurcyConvRateType>Corporate</ns1:CurcyConvRateType>\r\n" + 
				"                     <ns1:CorpCurrencyCode>INR</ns1:CorpCurrencyCode>\r\n" + 
				"                     <ns1:ContactID_c xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:MemberSince_c>2019-04-12</ns1:MemberSince_c>\r\n" + 
				"                     <ns1:MembershipCardNo_c>465134813</ns1:MembershipCardNo_c>\r\n" + 
				"                     <ns1:MembershipClass_c xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:MembershipDescription_c xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:MembershipExpirationNew_c>2019-04-20</ns1:MembershipExpirationNew_c>\r\n" + 
				"                     <ns1:MembershipLevel_c xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:MembershipType_c xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:NameOnCard_c>Abhishek Kumar Jha</ns1:NameOnCard_c>\r\n" + 
				"                     <ns1:InactiveNew_c>true</ns1:InactiveNew_c>\r\n" + 
				"                     <ns1:MembershipTypeLOV_c>ET</ns1:MembershipTypeLOV_c>\r\n" + 
				"                     <ns1:MembershipLevelLOV_c>GE</ns1:MembershipLevelLOV_c>\r\n" + 
				"                     <ns1:MUI_temp_c xsi:nil=\"true\"/>\r\n" + 
				"                  </ns1:LoyaltyMembershipsCollection_c>\r\n" + 
				"                  <ns1:LoyaltyMembershipsCollection_c>\r\n" + 
				"                     <ns1:Id>300000607146068</ns1:Id>\r\n" + 
				"                     <ns1:RecordName>SR-0015935-190402</ns1:RecordName>\r\n" + 
				"                     <ns1:CreatedBy>Datacentre</ns1:CreatedBy>\r\n" + 
				"                     <ns1:CreationDate>2019-04-02T06:47:24.0Z</ns1:CreationDate>\r\n" + 
				"                     <ns1:LastUpdatedBy>Datacentre</ns1:LastUpdatedBy>\r\n" + 
				"                     <ns1:LastUpdateDate>2019-04-02T06:47:24.382Z</ns1:LastUpdateDate>\r\n" + 
				"                     <ns1:ObjectVersionNumber>1</ns1:ObjectVersionNumber>\r\n" + 
				"                     <ns1:PersonProfile_Id_c>100000044971942</ns1:PersonProfile_Id_c>\r\n" + 
				"                     <ns1:RecordNumber>9948852</ns1:RecordNumber>\r\n" + 
				"                     <ns1:LastUpdateLogin xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:UserLastUpdateDate xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:CurrencyCode>INR</ns1:CurrencyCode>\r\n" + 
				"                     <ns1:CurcyConvRateType>Corporate</ns1:CurcyConvRateType>\r\n" + 
				"                     <ns1:CorpCurrencyCode>INR</ns1:CorpCurrencyCode>\r\n" + 
				"                     <ns1:ContactID_c xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:MemberSince_c>2019-03-08</ns1:MemberSince_c>\r\n" + 
				"                     <ns1:MembershipCardNo_c>78998879</ns1:MembershipCardNo_c>\r\n" + 
				"                     <ns1:MembershipClass_c xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:MembershipDescription_c xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:MembershipExpirationNew_c>2019-04-27</ns1:MembershipExpirationNew_c>\r\n" + 
				"                     <ns1:MembershipLevel_c xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:MembershipType_c xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:NameOnCard_c>Akshay</ns1:NameOnCard_c>\r\n" + 
				"                     <ns1:InactiveNew_c>false</ns1:InactiveNew_c>\r\n" + 
				"                     <ns1:MembershipTypeLOV_c>ET</ns1:MembershipTypeLOV_c>\r\n" + 
				"                     <ns1:MembershipLevelLOV_c>BE</ns1:MembershipLevelLOV_c>\r\n" + 
				"                     <ns1:MUI_temp_c xsi:nil=\"true\"/>\r\n" + 
				"                  </ns1:LoyaltyMembershipsCollection_c>\r\n" + 
				"                  <ns1:LoyaltyMembershipsCollection_c>\r\n" + 
				"                     <ns1:Id>300000607146070</ns1:Id>\r\n" + 
				"                     <ns1:RecordName>SR-0015936-190402</ns1:RecordName>\r\n" + 
				"                     <ns1:CreatedBy>Datacentre</ns1:CreatedBy>\r\n" + 
				"                     <ns1:CreationDate>2019-04-02T06:58:21.0Z</ns1:CreationDate>\r\n" + 
				"                     <ns1:LastUpdatedBy>Datacentre</ns1:LastUpdatedBy>\r\n" + 
				"                     <ns1:LastUpdateDate>2019-04-02T06:58:21.214Z</ns1:LastUpdateDate>\r\n" + 
				"                     <ns1:ObjectVersionNumber>1</ns1:ObjectVersionNumber>\r\n" + 
				"                     <ns1:PersonProfile_Id_c>100000044971942</ns1:PersonProfile_Id_c>\r\n" + 
				"                     <ns1:RecordNumber>9948853</ns1:RecordNumber>\r\n" + 
				"                     <ns1:LastUpdateLogin xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:UserLastUpdateDate xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:CurrencyCode>INR</ns1:CurrencyCode>\r\n" + 
				"                     <ns1:CurcyConvRateType>Corporate</ns1:CurcyConvRateType>\r\n" + 
				"                     <ns1:CorpCurrencyCode>INR</ns1:CorpCurrencyCode>\r\n" + 
				"                     <ns1:ContactID_c xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:MemberSince_c>2019-04-05</ns1:MemberSince_c>\r\n" + 
				"                     <ns1:MembershipCardNo_c>788466518</ns1:MembershipCardNo_c>\r\n" + 
				"                     <ns1:MembershipClass_c xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:MembershipDescription_c xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:MembershipExpirationNew_c>2019-04-19</ns1:MembershipExpirationNew_c>\r\n" + 
				"                     <ns1:MembershipLevel_c xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:MembershipType_c xsi:nil=\"true\"/>\r\n" + 
				"                     <ns1:NameOnCard_c>Naveen Reddy</ns1:NameOnCard_c>\r\n" + 
				"                     <ns1:InactiveNew_c>false</ns1:InactiveNew_c>\r\n" + 
				"                     <ns1:MembershipTypeLOV_c>ET</ns1:MembershipTypeLOV_c>\r\n" + 
				"                     <ns1:MembershipLevelLOV_c>SE</ns1:MembershipLevelLOV_c>\r\n" + 
				"                     <ns1:MUI_temp_c xsi:nil=\"true\"/>\r\n" + 
				"                  </ns1:LoyaltyMembershipsCollection_c>\r\n" + 
				"               </ns1:PersonProfile>\r\n" + 
				"               <ns1:PartyUsageAssignment>\r\n" + 
				"                  <ns3:PartyUsgAssignmentId>100000046457059</ns3:PartyUsgAssignmentId>\r\n" + 
				"                  <ns3:PartyId>100000044971942</ns3:PartyId>\r\n" + 
				"                  <ns3:PartyUsageCode>CONTACT</ns3:PartyUsageCode>\r\n" + 
				"                  <ns3:EffectiveStartDate>2018-06-06</ns3:EffectiveStartDate>\r\n" + 
				"                  <ns3:EffectiveEndDate>4712-12-31</ns3:EffectiveEndDate>\r\n" + 
				"                  <ns3:StatusFlag>true</ns3:StatusFlag>\r\n" + 
				"                  <ns3:Comments xsi:nil=\"true\"/>\r\n" + 
				"                  <ns3:OwnerTableName xsi:nil=\"true\"/>\r\n" + 
				"                  <ns3:OwnerTableId xsi:nil=\"true\"/>\r\n" + 
				"                  <ns3:CreatedByModule>HZ_IMPORT</ns3:CreatedByModule>\r\n" + 
				"                  <ns3:ObjectVersionNumber>1</ns3:ObjectVersionNumber>\r\n" + 
				"                  <ns3:CreatedBy>Datacentre</ns3:CreatedBy>\r\n" + 
				"                  <ns3:CreationDate>2018-06-06T03:28:41.609299Z</ns3:CreationDate>\r\n" + 
				"                  <ns3:LastUpdateLogin>-1</ns3:LastUpdateLogin>\r\n" + 
				"                  <ns3:LastUpdateDate>2018-06-06T03:28:41.609299Z</ns3:LastUpdateDate>\r\n" + 
				"                  <ns3:LastUpdatedBy>Datacentre</ns3:LastUpdatedBy>\r\n" + 
				"                  <ns3:RequestId>67968</ns3:RequestId>\r\n" + 
				"               </ns1:PartyUsageAssignment>\r\n" + 
				"            </ns1:Value>\r\n" + 
				"         </ns2:result>\r\n" + 
				"      </ns0:findPersonResponse>\r\n" + 
				"   </env:Body>\r\n" + 
				"</env:Envelope>";
				
		String OWSHotelCode = "51BG";
		String PMSNameCode = "89424836";
		boolean origBoolean = false;
				
		SoapExecutor soapExecutor = new SoapExecutor();
		
		Document doc = soapExecutor.convertStringToDocument(resp);
		
		NodeList nList = doc.getElementsByTagName("ns1:Value");
		
		for(int j = 0 ; j < nList.getLength() ; j++)
		{
		
			Element profileEle = (Element) (Node) nList.item(0);
			if (profileEle == null) {
				System.out.println("Profile Not Found");
				return;
			}
			
			String status = soapExecutor.getValue(profileEle, "ns1:Status");
			if(status.equals("I") || status.equals("M"))
				continue;
			
			
			Configuration configuration = new Configuration();
			String FirstName = soapExecutor.getValue(profileEle, "ns1:PersonFirstName");
			String LastName = soapExecutor.getValue(profileEle, "ns1:PersonLastName");
			String Salutation = soapExecutor.getValue(profileEle, "ns1:PersonPreNameAdjunct");
			
			NodeList nListSource = profileEle.getElementsByTagName("ns1:OriginalSystemReference");
			
			for(int i=0; i<nListSource.getLength(); i++)
			{
				Element eleSource = (Element) nListSource.item(i);
				
				String origSys = soapExecutor.getValue(eleSource, "ns3:OrigSystem");
				String origSysRef = soapExecutor.getValue(eleSource, "ns3:OrigSystemReference");
				System.out.println(origSys + "\t" + origSysRef);
				
				String hotelSet = Configuration.hotelList.get(OWSHotelCode);
			    String tempHotelSet = Configuration.hotelList.get(origSys);
			   
			    if(origSysRef.equals(PMSNameCode) && tempHotelSet.equals(hotelSet))
			    {
				    origBoolean = true;
				    break;
			    }
				
			}
			
			if(origBoolean == true)
			   {
				   String PartyId = soapExecutor.getValue(profileEle, "ns1:PartyId");
				   String PartyNumber = soapExecutor.getValue(profileEle, "ns1:PartyNumber");
				   
				   System.out.println("Salutation: " + Salutation);
			
					if(Salutation != null && !(Salutation.equals("")))
					{
						String s1 = Salutation.substring(0,1);
						String s2 = Salutation.substring(1, Salutation.length());
						s2 = s2.toLowerCase();
						Salutation = s1+s2;
						System.out.println("Salutation MOD: " + Salutation);
					}
					
					if(Salutation.equalsIgnoreCase("Other") || Salutation.equalsIgnoreCase("His Excellency Wali") || Salutation.equalsIgnoreCase("Her Serene Highness") || Salutation.equalsIgnoreCase("Mme.") || Salutation.equalsIgnoreCase("His Royal Highness") || Salutation.equalsIgnoreCase("Cmdr.") || Salutation.equalsIgnoreCase("Cdr.") || Salutation.equalsIgnoreCase("F/O") || Salutation.equalsIgnoreCase("Air Chief Marshal") || Salutation.equalsIgnoreCase("AVM.") || Salutation.equalsIgnoreCase("Air Cmdr.") || Salutation.equalsIgnoreCase("Sqd. Ldr."))
						Salutation = "";
					
					String Gender = soapExecutor.getValue(profileEle, "ns1:Gender");
					if(Gender!=null && Gender.equals("MALE"))
						Gender = "Male";
					else if(Gender!=null && Gender.equals("FEMALE"))
						Gender= "Female";
					else if(Gender.equalsIgnoreCase("unknown"))
						Gender = "";
					
					System.out.println("Gender: " + Gender);
					
					NodeList nListEmail = doc.getElementsByTagName("ns1:Email");
					for(int i=0; i<nListEmail.getLength(); i++)
					{
						Element eleEmail = (Element) nListEmail.item(i);
						String isActive = soapExecutor.getValue(eleEmail, "ns5:Status");
						String isPrimary = soapExecutor.getValue(eleEmail, "ns5:PrimaryFlag");
						
						if(isActive.equalsIgnoreCase("A") && isPrimary.equalsIgnoreCase("true"))
						{
							String Email = soapExecutor.getValue(eleEmail, "ns5:EmailAddress");
							System.out.println("Email: "+Email);
							System.out.println("Email Type: " + soapExecutor.getValue(eleEmail, "ns5:ContactPointPurpose"));
							System.out.println("Email ID: " + soapExecutor.getValue(eleEmail, "ns5:ContactPointId"));
						}
					}
					
					NodeList nListPhone = doc.getElementsByTagName("ns1:Phone");
					for(int i=0; i<nListPhone.getLength(); i++)
					{
						Element elePhone = (Element) nListPhone.item(i);
						String isActive = soapExecutor.getValue(elePhone, "ns5:Status");
						String isPrimary = soapExecutor.getValue(elePhone, "ns5:PrimaryFlag");
						
						if(isActive.equalsIgnoreCase("A") && isPrimary.equalsIgnoreCase("true"))
						{
							String Phone = soapExecutor.getValue(elePhone, "ns5:PhoneNumber");
							System.out.println("Phone: " + Phone);
							System.out.println("Phone Type: " + soapExecutor.getValue(elePhone, "ns5:PhoneLineType"));
							System.out.println("Phone ID: " + soapExecutor.getValue(elePhone, "ns5:ContactPointId"));
						}
						
					}
					
					try
					 {	
					 String EnrollNumber_c = "";
					 NodeList nodeList = ((Element) doc.getElementsByTagName("ns1:Value").item(0)).getElementsByTagName("ns1:LoyaltyMembershipsCollection_c");
						
						for(int i=0; i<nodeList.getLength(); i++)
						{
							Element ele = (Element) nodeList.item(i);
							String MembershipType = ele.getElementsByTagName("ns1:MembershipTypeLOV_c").item(0).getTextContent();
							
							
							if(MembershipType.equalsIgnoreCase("TIC") || MembershipType.equalsIgnoreCase("Taj InnerCircle") || MembershipType.equalsIgnoreCase("TAJ"))
								{
									EnrollNumber_c = ele.getElementsByTagName("ns1:MembershipCardNo_c").item(0).getTextContent();
									System.out.println("EnrollNumber_c: "+EnrollNumber_c);
								}
								
						}
					 } catch(Exception e)
					 {
						 
					 }
					 
					 String DateOfBirth = soapExecutor.getValue(profileEle, "ns1:DateOfBirth");
			
					//parsing the address from the root element
					String Address1 = soapExecutor.getValue(profileEle, "ns1:Address1");
					String Address2 = soapExecutor.getValue(profileEle, "ns1:Address2");
					String Address3 = soapExecutor.getValue(profileEle, "ns1:Address3");
					String Address4 = soapExecutor.getValue(profileEle, "ns1:Address4");
					String city = soapExecutor.getValue(profileEle, "ns1:City");
					String state = soapExecutor.getValue(profileEle, "ns1:State");
					String country = soapExecutor.getValue(profileEle, "ns1:Country");
					String postal = soapExecutor.getValue(profileEle, "ns1:PostalCode");
				   
			   } else 
			   {
			   		System.out.println("Profile not found");
			   }
			
			
		
		}
		
	}

	
	public static void main10(String a[])
	{
		SimpleDateFormat format = new SimpleDateFormat("hhmmss");
		Date date = new Date();
		String d = format.format(date);
		System.out.println(d);
	}

	public static void main11(String a[]) throws Exception
	{
		GetReservationData reservationData = new GetReservationData("102148646", "BLRWE","status");
		Thread threadReservation = new Thread(reservationData);
		threadReservation.start();
		threadReservation.join();
		
		try{
			SimpleDateFormat dateFormat1 = new SimpleDateFormat("MM/dd/yyyy");
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date CIn = format.parse(reservationData.CheckInDate.substring(0, 10));
			Date COut = format.parse(reservationData.CheckOutDate.substring(0, 10));
			
			String tempCheckInDate = dateFormat1.format(CIn);
			String tempCheckOutDate = dateFormat1.format(COut);
			
			System.out.println(tempCheckInDate);
			System.out.println(tempCheckOutDate);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unused")
	public static void main111(String a[])
	{

		String PMSNameCode = "182168", OWSPropertyCode = "STVGH";
		boolean origBoolean = false, isProfileFound = false;
		String AvailableSourceSystemRef = "";
		
		System.out.println("Thread Started");
		
		ConfigPayloads payloads = new ConfigPayloads();
		
		String findPersonServicePayload = payloads.getProfileDataPayload(PMSNameCode);
		
		
	 	String WSDL = Configuration.GetProfileDataWSDL;
		String Action = Configuration.GetProfileDataActionURL;
		
		String userName = "datacentre";
		String password = "Smile@25";
		
		SoapExecutor soapExecutor = new SoapExecutor(WSDL);
		String responce = soapExecutor.executeRequest(userName, password, Action,findPersonServicePayload);
		
		System.out.println(responce + "\n\n");
	
		Document doc = soapExecutor.convertStringToDocument(responce);
		
		NodeList nList = doc.getElementsByTagName("ns1:Value");
		
		for(int j = 0 ; j < nList.getLength() ; j++)
		{
		
			
			
			Element profileEle = (Element) (Node) nList.item(j);
			if (profileEle == null) {
				System.out.println("Profile Not Found");
				return;
			}
			
			System.out.println("PartyName\t" + soapExecutor.getValue(profileEle, "ns1:PartyName"));
			
			String status = soapExecutor.getValue(profileEle, "ns1:Status");
			if(status.equals("I") || status.equals("M"))
				continue;
			
			
			Configuration configuration = new Configuration();
			
			
			NodeList nListSource = profileEle.getElementsByTagName("ns1:OriginalSystemReference");
			
			for(int i=0; i<nListSource.getLength(); i++)
			{
				Element eleSource = (Element) nListSource.item(i);
				
				String origSys = soapExecutor.getValue(eleSource, "ns3:OrigSystem");
				String origSysRef = soapExecutor.getValue(eleSource, "ns3:OrigSystemReference");
				System.out.println(origSys + "\t" + origSysRef);
				
				String hotelSet = Configuration.hotelList.get(OWSPropertyCode);
			    String tempHotelSet = Configuration.hotelList.get(origSys);
			   
			    if(origSysRef.equals(PMSNameCode) && tempHotelSet.equals(hotelSet))
			    {
				    origBoolean = true;
				    AvailableSourceSystemRef = origSysRef;
				    break;
			    }
				
			}
			
			if(origBoolean == true)
			   {
					isProfileFound = true;
				
				   String PartyId = soapExecutor.getValue(profileEle, "ns1:PartyId");
				   String PartyNumber = soapExecutor.getValue(profileEle, "ns1:PartyNumber");
				   
				   String  FirstName = soapExecutor.getValue(profileEle, "ns1:PersonFirstName");
				   String LastName = soapExecutor.getValue(profileEle, "ns1:PersonLastName");
				   String Salutation = soapExecutor.getValue(profileEle, "ns1:PersonPreNameAdjunct");
				   
				   System.out.println(FirstName);
				   System.out.println(LastName);
				   System.out.println(PartyNumber);
				   
				  // System.out.println("Salutation: " + Salutation);
			
					if(Salutation != null && !(Salutation.equals("")))
					{
						String s1 = Salutation.substring(0,1);
						String s2 = Salutation.substring(1, Salutation.length());
						s2 = s2.toLowerCase();
						Salutation = s1+s2;
						
					}
					
					if(Salutation.equalsIgnoreCase("Other") || Salutation.equalsIgnoreCase("His Excellency Wali") || Salutation.equalsIgnoreCase("Her Serene Highness") || Salutation.equalsIgnoreCase("Mme.") || Salutation.equalsIgnoreCase("His Royal Highness") || Salutation.equalsIgnoreCase("Cmdr.") || Salutation.equalsIgnoreCase("Cdr.") || Salutation.equalsIgnoreCase("F/O") || Salutation.equalsIgnoreCase("Air Chief Marshal") || Salutation.equalsIgnoreCase("AVM.") || Salutation.equalsIgnoreCase("Air Cmdr.") || Salutation.equalsIgnoreCase("Sqd. Ldr."))
						Salutation = "";
					
					String Gender = soapExecutor.getValue(profileEle, "ns1:Gender");
					if(Gender!=null && Gender.equals("MALE"))
						Gender = "Male";
					else if(Gender!=null && Gender.equals("FEMALE"))
						Gender= "Female";
					else if(Gender.equalsIgnoreCase("unknown"))
						Gender = "";
					
					NodeList nListEmail = doc.getElementsByTagName("ns1:Email");
					for(int i=0; i<nListEmail.getLength(); i++)
					{
						Element eleEmail = (Element) nListEmail.item(i);
						String isActive = soapExecutor.getValue(eleEmail, "ns5:Status");
						String isPrimary = soapExecutor.getValue(eleEmail, "ns5:PrimaryFlag");
						
						if(isActive.equalsIgnoreCase("A") && isPrimary.equalsIgnoreCase("true"))
						{
							String 	Email = soapExecutor.getValue(eleEmail, "ns5:EmailAddress");
							
						}
					}
					
					NodeList nListPhone = doc.getElementsByTagName("ns1:Phone");
					for(int i=0; i<nListPhone.getLength(); i++)
					{
						Element elePhone = (Element) nListPhone.item(i);
						String isActive = soapExecutor.getValue(elePhone, "ns5:Status");
						String isPrimary = soapExecutor.getValue(elePhone, "ns5:PrimaryFlag");
						
						if(isActive.equalsIgnoreCase("A") && isPrimary.equalsIgnoreCase("true"))
						{
							String Phone = soapExecutor.getValue(elePhone, "ns5:PhoneNumber");
							
						}
						
					}
					
					try
					 {	
					
					 NodeList nodeList = ((Element) doc.getElementsByTagName("ns1:Value").item(0)).getElementsByTagName("ns1:LoyaltyMembershipsCollection_c");
						
						for(int i=0; i<nodeList.getLength(); i++)
						{
							Element ele = (Element) nodeList.item(i);
							String 	MembershipType = ele.getElementsByTagName("ns1:MembershipTypeLOV_c").item(0).getTextContent();
							
							
							if(MembershipType.equalsIgnoreCase("TIC") || MembershipType.equalsIgnoreCase("Taj InnerCircle") || MembershipType.equalsIgnoreCase("TAJ"))
								{
								String EnrollNumber_c = ele.getElementsByTagName("ns1:MembershipCardNo_c").item(0).getTextContent();
									
								}
								
						}
					 } catch(Exception e)
					 {
						 
					 }
					 
					 
				   break;
			   } else 
			   {
			   		System.out.println("Profile not found bottom");
			   }
			
			
		
		}
		
		System.out.println("Thread Completed");
		
		
		
	
	}
	
	@SuppressWarnings("unused")
	public static void main121(String a[])
	{
		String resp = "<env:Envelope xmlns:env=\"http://schemas.xmlsoap.org/soap/envelope/\"><env:Header><wsse:Security env:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\"><wsu:Timestamp xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\" wsu:Id=\"Timestamp-EMGeYhWzySwW4zlJgTZ6Ww22\"><wsu:Created>2019-05-08T05:47:14Z</wsu:Created><wsu:Expires>2019-05-08T05:52:14Z</wsu:Expires></wsu:Timestamp></wsse:Security></env:Header><env:Body><s0:FutureBookingSummaryResponse xmlns:s0=\"http://webservices.micros.com/ows/5.1/Reservation.wsdl\"><s0:Result resultStatusFlag=\"SUCCESS\"><s2:Text xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/><s2:IDs xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/><s2:OperaErrorCode xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/><s1:GDSError elementId=\"\" errorCode=\"\" xmlns:s1=\"http://webservices.micros.com/og/4.3/HotelCommon/\"/></s0:Result><s0:HotelReservations><s3:HotelReservation returningGuest=\"true\" checkInTime=\"13:36:00.0000000+05:30\" checkOutTime=\"00:00:00.0000000+05:30\" computedReservationStatus=\"INHOUSE\" redemReservationFlag=\"false\" onBehalfFlag=\"\" compRoutingAuthorizer=\"\" compRoutingFlag=\"\" authorizer=\"\" originCode=\"PMS\" sourceCode=\"BLRWE\" marketSegment=\"RAC\" reservationStatus=\"INHOUSE\" reservationAction=\"\" xmlns:s3=\"http://webservices.micros.com/og/4.3/Reservation/\"><s3:UniqueIDList><s2:UniqueID source=\"\" type=\"INTERNAL\" xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\">107813863</s2:UniqueID><s2:UniqueID source=\"RESVID\" type=\"INTERNAL\" xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\">102148646</s2:UniqueID><s2:UniqueID source=\"LEGNUMBER\" type=\"INTERNAL\" xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\">1</s2:UniqueID></s3:UniqueIDList><s3:RoomStays><s1:RoomStay xmlns:s1=\"http://webservices.micros.com/og/4.3/HotelCommon/\"><s1:RoomTypes><s1:RoomType><s1:RoomNumber>1109</s1:RoomNumber></s1:RoomType></s1:RoomTypes><s1:TimeSpan><s1:StartDate>2019-02-17T00:00:00</s1:StartDate><s1:EndDate>2019-03-18T00:00:00</s1:EndDate><s1:Duration/></s1:TimeSpan><s1:HotelReference hotelCode=\"\" chainCode=\"\">Taj West End Bengaluru</s1:HotelReference><s1:Total currencyText=\"\" decimals=\"2\" currencyCode=\"INR\">591750</s1:Total></s1:RoomStay></s3:RoomStays><s3:ResGuests><s3:ResGuest resGuestRPH=\"0\"><s3:Profiles><s4:Profile xmlns:s4=\"http://webservices.micros.com/og/4.3/Name/\"><s4:ProfileIDs><s2:UniqueID type=\"INTERNAL\" source=\"\" xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\">103430407</s2:UniqueID></s4:ProfileIDs><s4:Customer><s4:PersonName active=\"\"><s2:nameTitle xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\">Mr.</s2:nameTitle><s2:firstName xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\">Middleware</s2:firstName><s2:lastName xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\">Latest</s2:lastName></s4:PersonName></s4:Customer><s4:Addresses><s4:NameAddress externalId=\"\" operaId=\"\"><s2:AddressLine xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\">CMR College</s2:AddressLine><s2:cityName xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\">Hyderabad</s2:cityName><s2:stateProv xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\">TS</s2:stateProv><s2:countryCode xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\">IN</s2:countryCode><s2:postalCode xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\">500036</s2:postalCode><s2:barCode xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/><s2:cityExtension xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/></s4:NameAddress></s4:Addresses></s4:Profile></s3:Profiles></s3:ResGuest></s3:ResGuests></s3:HotelReservation></s0:HotelReservations></s0:FutureBookingSummaryResponse></env:Body></env:Envelope>";
	
		SoapExecutor soapExecutor = new SoapExecutor();
		
		Document doc = soapExecutor.convertStringToDocument(resp);
		
		NodeList nListRes = doc.getElementsByTagName("s0:Result");
		
		Element eleRes = (Element) nListRes.item(0);
		
		String resStatus = eleRes.getAttribute("resultStatusFlag");
		
		System.out.println(resStatus);
		
		if(resStatus.equalsIgnoreCase("SUCCESS"))
		{
			NodeList nList = doc.getElementsByTagName("s3:HotelReservation");
			
			Element ele = (Element) nList.item(0);
			if (ele == null) {
				System.out.println("No Reservation Found");
				return;
			}
			
			String Status = ele.getAttribute("reservationStatus");
			System.out.println("Stay Status: \t" + Status);
			
			if(!Status.equalsIgnoreCase("INHOUSE"))
			{
				return;
			}
			
			NodeList nListUnique = ele.getElementsByTagName("s3:UniqueIDList");
			
			for(int i=0; i<nListUnique.getLength(); i++)
			{
				Element eleUnique = (Element) nListUnique.item(i);
				
				NodeList nListUniqueId = eleUnique.getElementsByTagName("s2:UniqueID");
				
				for(int j=0; j<nListUniqueId.getLength(); j++)
				{
					Element eleUniqueId = (Element) nListUniqueId.item(j);
					
					String source = eleUniqueId.getAttribute("source");
					if(source == null || source.equalsIgnoreCase("null") || source.equalsIgnoreCase(""))
					{
						String ConfirmationNo = eleUniqueId.getTextContent().toString();
						System.out.println("ConfirmationNo\t"+ConfirmationNo);
					}
					
				}
			}
			
			NodeList nListRoomStays = ele.getElementsByTagName("s1:RoomNumber");
			
			Element eleRoom = (Element) nListRoomStays.item(0);
			
			String RoomNo = eleRoom.getTextContent();
			System.out.println("RoomNo\t"+RoomNo);
			
			NodeList nListTimeSpan = ele.getElementsByTagName("s1:TimeSpan");
			
			for(int i=0; i<nListTimeSpan.getLength(); i++)
			{
				Element eleTimeSpan = (Element) nListTimeSpan.item(i);
				
				String CheckInDate = soapExecutor.getValue(eleTimeSpan, "s1:StartDate");
				String CheckOutDate = soapExecutor.getValue(eleTimeSpan, "s1:EndDate");
				
				
				try{
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
					DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					
					String str1 = CheckInDate.substring(0, 10);
					String str2 = CheckOutDate.substring(0, 10);
					
					Date d1 = format.parse(str1);
					Date d2 = format.parse(str2);
					
					Date CInDate = d1;
					Date COutDate = d2;
					
					String ArrivalDate = dateFormat.format(d1);
					String DepartureDate = dateFormat.format(d2);
					
					System.out.println(ArrivalDate + "\n" + DepartureDate);
				}catch(Exception e)
				{
				//e.printStackTrace();
				}
			}
			
			NodeList nListHotel = ele.getElementsByTagName("s1:HotelReference");
			
			Element eleHotel = (Element) nListHotel.item(0);
			
			String HotelName = eleHotel.getTextContent();
			String PropertyFullName = HotelName;
			
			System.out.println("HotelName\t" + HotelName);
				
		}
	}
	
	public static void main00(String a[])
	{
		String resp = "{\r\n" + 
				"    \"IHCLProfileOperations_Input\": {\r\n" + 
				"        \"Error_spcCode\": \"\",\r\n" + 
				"        \"Error_spcMessage\": \"\",\r\n" + 
				"        \"ErrorMsg\": \"\",\r\n" + 
				"        \"Response\": \"Success\",\r\n" + 
				"        \"ListOfIhclMemberProfileIo\": {\r\n" + 
				"            \"LoyMember\": [\r\n" + 
				"                {\r\n" + 
				"                    \"@Operation\": \"\",\r\n" + 
				"                    \"MemberNumber\": \"101015305090\",\r\n" + 
				"                    \"IHCLAddOnCalling\": \"\",\r\n" + 
				"                    \"ListOfContact\": {\r\n" + 
				"                        \"Contact\": [\r\n" + 
				"                            {\r\n" + 
				"                                \"@Operation\": \"\",\r\n" + 
				"                                \"Id\": \"1-3RDF3FV\",\r\n" + 
				"                                \"BirthDate\": \"08/15/1995\",\r\n" + 
				"                                \"FirstName\": \"Middleware\",\r\n" + 
				"                                \"LastName\": \"Latest\",\r\n" + 
				"                                \"MF\": \"M\",\r\n" + 
				"                                \"MM\": \"Mr.\",\r\n" + 
				"                                \"ListOfContact_PersonalAddress\": {\r\n" + 
				"                                    \"Contact_PersonalAddress\": [\r\n" + 
				"                                        {\r\n" + 
				"                                            \"@Operation\": \"\",\r\n" + 
				"                                            \"@IsPrimaryMVG\": \"Y\",\r\n" + 
				"                                            \"AddressType\": \"Loyalty - Business\",\r\n" + 
				"                                            \"PersonalAddressName\": \"6724404_SLN Terminus\",\r\n" + 
				"                                            \"PersonalCity\": \"Hyderabad\",\r\n" + 
				"                                            \"PersonalCountry\": \"INDIA\",\r\n" + 
				"                                            \"PersonalPostalCode\": \"500025\",\r\n" + 
				"                                            \"PersonalState\": \"OTHER\",\r\n" + 
				"                                            \"PersonalStreetAddress\": \"SLN Terminus\",\r\n" + 
				"                                            \"PersonalStreetAddress2\": \"\",\r\n" + 
				"                                            \"IHCLAlternateAddrFlag\": \"N\",\r\n" + 
				"                                            \"IHCLOtherCity\": \"Hyderabad\",\r\n" + 
				"                                            \"IHCLOtherCountry\": \"\",\r\n" + 
				"                                            \"IHCLOtherState\": \"TELANGANA\",\r\n" + 
				"                                            \"AddressNameLockedFlag\": \"Y\"\r\n" + 
				"                                        }\r\n" + 
				"                                    ]\r\n" + 
				"                                },\r\n" + 
				"                                \"ListOfContact_CommunicationAddress\": {\r\n" + 
				"                                    \"Contact_CommunicationAddress\": [\r\n" + 
				"                                        {\r\n" + 
				"                                            \"@Operation\": \"\",\r\n" + 
				"                                            \"@IsPrimaryMVG\": \"Y\",\r\n" + 
				"                                            \"AlternateEmailAddress\": \"middlewarelate123@test.com\",\r\n" + 
				"                                            \"CommunicationAddressUseType\": \"Loyalty - Business\"\r\n" + 
				"                                        },\r\n" + 
				"                                        {\r\n" + 
				"                                            \"@Operation\": \"\",\r\n" + 
				"                                            \"@IsPrimaryMVG\": \"N\",\r\n" + 
				"                                            \"AlternateEmailAddress\": \"abhishek.jha@innovacx.com\",\r\n" + 
				"                                            \"CommunicationAddressUseType\": \"Personal\"\r\n" + 
				"                                        }\r\n" + 
				"                                    ]\r\n" + 
				"                                },\r\n" + 
				"                                \"ListOfContact_AlternatePhone\": {\r\n" + 
				"                                    \"Contact_AlternatePhone\": [\r\n" + 
				"                                        {\r\n" + 
				"                                            \"@Operation\": \"\",\r\n" + 
				"                                            \"@IsPrimaryMVG\": \"Y\",\r\n" + 
				"                                            \"AlternatePhone\": \"8688044351\",\r\n" + 
				"                                            \"AlternatePhoneUseType\": \"Loyalty - Personal\"\r\n" + 
				"                                        },\r\n" + 
				"                                        {\r\n" + 
				"                                            \"@Operation\": \"\",\r\n" + 
				"                                            \"@IsPrimaryMVG\": \"N\",\r\n" + 
				"                                            \"AlternatePhone\": \"8688045150\",\r\n" + 
				"                                            \"AlternatePhoneUseType\": \"Personal\"\r\n" + 
				"                                        }\r\n" + 
				"                                    ]\r\n" + 
				"                                }\r\n" + 
				"                            }\r\n" + 
				"                        ]\r\n" + 
				"                    },\r\n" + 
				"                    \"ListOfLoyMembershipCard\": {\r\n" + 
				"                        \"LoyMembershipCard\": [\r\n" + 
				"                            {\r\n" + 
				"                                \"@Operation\": \"\",\r\n" + 
				"                                \"ActiveFlag\": \"Y\",\r\n" + 
				"                                \"CardNumber\": \"1-8190711978\",\r\n" + 
				"                                \"CardStatusCode\": \"Active\",\r\n" + 
				"                                \"CardType\": \"TIC Copper\",\r\n" + 
				"                                \"Description2\": \"Custom Description\",\r\n" + 
				"                                \"ExpirationDate\": \"\",\r\n" + 
				"                                \"ExpirationDateOnCard\": \"\",\r\n" + 
				"                                \"IHCLAdd-OnCategory\": \"\",\r\n" + 
				"                                \"IHCLAdd-OnPlanCode\": \"\",\r\n" + 
				"                                \"IHCLAdd-OnPlanId\": \"\",\r\n" + 
				"                                \"IHCLAdd-OnPlanIssueType\": \"\",\r\n" + 
				"                                \"IHCLAdd-OnPlanName\": \"\",\r\n" + 
				"                                \"IHCLAdd-OnPlanStatus\": \"\",\r\n" + 
				"                                \"IHCLAdd-OnPlanType\": \"\",\r\n" + 
				"                                \"IHCLAdd-OnRenewReason\": \"\",\r\n" + 
				"                                \"IHCLAdd-OnRenewType\": \"\",\r\n" + 
				"                                \"IHCLIssuePartner\": \"Taj\",\r\n" + 
				"                                \"IHCLOrderNumber\": \"1-8190712000\",\r\n" + 
				"                                \"IHCLProductId\": \"\",\r\n" + 
				"                                \"MemberId\": \"1-3RDF3FZ\",\r\n" + 
				"                                \"NameOnCard\": \"Middleware Latest\",\r\n" + 
				"                                \"StartDate\": \"08/30/2018 00:00:00\",\r\n" + 
				"                                \"TierId\": \"1-2G3F\",\r\n" + 
				"                                \"TierName\": \"Copper\"\r\n" + 
				"                            },\r\n" + 
				"                            {\r\n" + 
				"                                \"@Operation\": \"\",\r\n" + 
				"                                \"ActiveFlag\": \"Y\",\r\n" + 
				"                                \"CardNumber\": \"1-8227768953\",\r\n" + 
				"                                \"CardStatusCode\": \"Active\",\r\n" + 
				"                                \"CardType\": \"TIC Silver\",\r\n" + 
				"                                \"Description2\": \"Custom Description\",\r\n" + 
				"                                \"ExpirationDate\": \"\",\r\n" + 
				"                                \"ExpirationDateOnCard\": \"09/30/2019\",\r\n" + 
				"                                \"IHCLAdd-OnCategory\": \"Epicure Plus\",\r\n" + 
				"                                \"IHCLAdd-OnPlanCode\": \"EPLUS\",\r\n" + 
				"                                \"IHCLAdd-OnPlanId\": \"1-2BR6\",\r\n" + 
				"                                \"IHCLAdd-OnPlanIssueType\": \"\",\r\n" + 
				"                                \"IHCLAdd-OnPlanName\": \"Epicure Plus\",\r\n" + 
				"                                \"IHCLAdd-OnPlanStatus\": \"Active\",\r\n" + 
				"                                \"IHCLAdd-OnPlanType\": \"New\",\r\n" + 
				"                                \"IHCLAdd-OnRenewReason\": \"\",\r\n" + 
				"                                \"IHCLAdd-OnRenewType\": \"\",\r\n" + 
				"                                \"IHCLIssuePartner\": \"Taj\",\r\n" + 
				"                                \"IHCLOrderNumber\": \"1-8227768873\",\r\n" + 
				"                                \"IHCLProductId\": \"1-2BR6\",\r\n" + 
				"                                \"MemberId\": \"1-3RDF3FZ\",\r\n" + 
				"                                \"NameOnCard\": \"Middleware Latest\",\r\n" + 
				"                                \"StartDate\": \"09/03/2018 11:01:49\",\r\n" + 
				"                                \"TierId\": \"1-2G3H\",\r\n" + 
				"                                \"TierName\": \"Silver\"\r\n" + 
				"                            }\r\n" + 
				"                        ]\r\n" + 
				"                    }\r\n" + 
				"                }\r\n" + 
				"            ]\r\n" + 
				"        },\r\n" + 
				"        \"ProfileOperation\": \"\"\r\n" + 
				"    }\r\n" + 
				"}";
		
		try 
		{
			JSONObject jsonObject  = new JSONObject(resp).getJSONObject("IHCLProfileOperations_Input");;
			
			String status = jsonObject.getString("Response");
			
			if(status.equalsIgnoreCase("Success"))
			{
				JSONObject objectInner = jsonObject.getJSONObject("ListOfIhclMemberProfileIo").getJSONArray("LoyMember").getJSONObject(0);
				
				String memberNumer = objectInner.getString("MemberNumber");
				System.out.println(memberNumer);
				
				JSONObject objectContact = objectInner.getJSONObject("ListOfContact").getJSONArray("Contact").getJSONObject(0);
				
				String FirstName = objectContact.getString("FirstName");
				String LastName = objectContact.getString("LastName");
				String Gender = objectContact.getString("MF");
				String Title = objectContact.getString("MM");
				
				System.out.println(FirstName);
				System.out.println(LastName);
				System.out.println(Gender);
				System.out.println(Title);
				
				JSONArray arrayEmail = objectContact.getJSONObject("ListOfContact_CommunicationAddress").getJSONArray("Contact_CommunicationAddress");
				
				for(int i=0; i<arrayEmail.length(); i++)
				{
					JSONObject objectEmail = arrayEmail.getJSONObject(i);
					
					String isPrimary = objectEmail.getString("@IsPrimaryMVG");
					String EmailAddress = "";
					
					if(isPrimary.equals("Y"))
						EmailAddress = objectEmail.getString("AlternateEmailAddress");
					System.out.println(EmailAddress);
				}
				
				JSONArray arrayPhone = objectContact.getJSONObject("ListOfContact_AlternatePhone").getJSONArray("Contact_AlternatePhone");
				
				for(int i=0; i<arrayPhone.length(); i++)
				{
					JSONObject objectPhone = arrayPhone.getJSONObject(i);
					
					String isPrimary = objectPhone.getString("@IsPrimaryMVG");
					String PhoneNumber = "";
					
					if(isPrimary.equals("Y"))
						PhoneNumber = objectPhone.getString("AlternatePhone");
					System.out.println(PhoneNumber);
				}
				
			}
			
		} 
		catch (JSONException e) 
		{
			e.printStackTrace();
		}
		
		
	
	}
	
	public static void maina(String a[])
	{
		JSONObject object = null;
		
		try {
		
			String payload = "{\r\n" + 
					"    \"IHCL_spcExchange_spcRate_spc_Input\": {\r\n" + 
					"        \"To_spcCurrency\": \"INR\",\r\n" + 
					"        \"Exchange_spcType\": \"Daily\",\r\n" + 
					"        \"From_spcCurrency\": \"LKR\",\r\n" + 
					"        \"Exchange_spcDate\": \"05/10/2019\"\r\n" + 
					"    }\r\n" + 
					"}";
			
			OkHttpClient client = new OkHttpClient();
	
			MediaType mediaType = MediaType.parse("application/json");
			RequestBody body = RequestBody.create(mediaType, payload);
			Request request = new Request.Builder()
			  .url("https://tajoicprod-bmsvb0wsgm8n-bo.integration.ocp.oraclecloud.com/ic/api/integration/v1/flows/rest/IHCL_CURRENCY_CONVERTER/1.0/CurrecnyConverter")
			  .post(body)
			  .addHeader("Content-Type", "application/json")
			  .addHeader("Authorization", Configuration.IcsBasicAuth)
			  .addHeader("Cache-Control", "no-cache")
			  .addHeader("Postman-Token", "82c728b6-45a0-4830-acb6-fd86954d426b,1f88eaad-0d98-4a3b-9c13-e633e3bf72e1")
			  .addHeader("Connection", "keep-alive")
			  .addHeader("cache-control", "no-cache")
			  .build();
	
			Response response = client.newCall(request).execute();
			
			String resp = response.body().string();
			
			object = new JSONObject(resp);
			
			System.out.println(resp);
			
			JSONObject jsonObject = object.getJSONObject("IHCL_spcExchange_spcRate_spc_Output");
			
			String status = jsonObject.getString("Response");
			
			if(status.equalsIgnoreCase("Success"))
			{
				String rate = jsonObject.getString("Exchange_spcRate");
				
				double amount = 10;
				
				double total = amount * Double.parseDouble(rate);
				
				System.out.println(total);
				
				System.out.println(rate);
			}
		
		}catch(Exception e)
		{
			e.printStackTrace();
			
			String resp = object.toString();
			
			if(resp.contains("EAI Common Internal Error"))
			{
				
			}
			
		}
	}
	
	public static void main32(String a[])
	{
		String responce = "<env:Envelope xmlns:env=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:wsa=\"http://www.w3.org/2005/08/addressing\">\r\n" + 
				"  <env:Header>\r\n" + 
				"    <wsa:Action>http://xmlns.oracle.com/apps/cdm/foundation/parties/personService/applicationModule//PersonService/findPersonResponse</wsa:Action>\r\n" + 
				"    <wsa:MessageID>urn:uuid:d864b1fc-fb7b-4d50-9964-bde81e9fb7b3</wsa:MessageID>\r\n" + 
				"  </env:Header>\r\n" + 
				"  <env:Body>\r\n" + 
				"    <ns0:findPersonResponse xmlns:ns0=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/personService/applicationModule/types/\">\r\n" + 
				"      <ns2:result xmlns:ns2=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/personService/applicationModule/types/\" xmlns:ns1=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/personService/\" xmlns:ns3=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/partyService/\" xmlns:tns=\"http://xmlns.oracle.com/adf/svc/errors/\" xmlns:ns0=\"http://xmlns.oracle.com/adf/svc/types/\" xmlns:ns5=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/contactPointService/\" xmlns:ns8=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/relationshipService/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:type=\"ns1:PersonResult\">\r\n" + 
				"        <ns1:Value>\r\n" + 
				"          <ns1:PartyId>300000840665756</ns1:PartyId>\r\n" + 
				"          <ns1:PartyNumber>12756143</ns1:PartyNumber>\r\n" + 
				"          <ns1:PartyName>Kyung Bae Kwak</ns1:PartyName>\r\n" + 
				"          <ns1:PartyType>PERSON</ns1:PartyType>\r\n" + 
				"          <ns1:ValidatedFlag xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:LastUpdatedBy>pms scheduler</ns1:LastUpdatedBy>\r\n" + 
				"          <ns1:LastUpdateLogin>82F24E35973F7AFFE0530A67360AFCE9</ns1:LastUpdateLogin>\r\n" + 
				"          <ns1:CreationDate>2019-02-28T11:14:21.0Z</ns1:CreationDate>\r\n" + 
				"          <ns1:RequestId xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:LastUpdateDate>2019-02-28T11:14:26.405Z</ns1:LastUpdateDate>\r\n" + 
				"          <ns1:CreatedBy>pms scheduler</ns1:CreatedBy>\r\n" + 
				"          <ns1:OrigSystemReference>300000840665756</ns1:OrigSystemReference>\r\n" + 
				"          <ns1:SICCode xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:JgzzFiscalCode xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PersonFirstName>Kyung Bae</ns1:PersonFirstName>\r\n" + 
				"          <ns1:PersonPreNameAdjunct>Mr.</ns1:PersonPreNameAdjunct>\r\n" + 
				"          <ns1:PersonLastName>Kwak</ns1:PersonLastName>\r\n" + 
				"          <ns1:PersonMiddleName xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PersonTitle xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PersonNameSuffix xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PersonPreviousLastName xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PersonAcademicTitle xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:Country>KR</ns1:Country>\r\n" + 
				"          <ns1:Address2 xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:Address1 xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:Address4 xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:Address3 xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PostalCode xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:City xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:Province xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:State xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:County xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:Status>A</ns1:Status>\r\n" + 
				"          <ns1:URL xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:SICCodeType xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:EmailAddress xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:GSAIndicatorFlag xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:LanguageName xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:MissionStatement xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:CategoryCode xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:ThirdPartyFlag xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:Salutation xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:CreatedByModule>HZ_WS</ns1:CreatedByModule>\r\n" + 
				"          <ns1:CertReasonCode xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:CertificationLevel xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PrimaryPhonePurpose xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PrimaryPhoneContactPTId xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PrimaryPhoneCountryCode xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PrimaryPhoneLineType xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PrimaryPhoneNumber xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PrimaryPhoneAreaCode xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PreferredContactMethod xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PrimaryPhoneExtension xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:IdenAddrLocationId>300000840669484</ns1:IdenAddrLocationId>\r\n" + 
				"          <ns1:PrimaryEmailContactPTId xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:IdenAddrPartySiteId>300000840669483</ns1:IdenAddrPartySiteId>\r\n" + 
				"          <ns1:PersonLastNamePrefix xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PrimaryURLContactPTId xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PreferredName xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PersonSecondLastName xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PreferredNameId xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PreferredContactPersonId xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:InternalFlag xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PreferredFunctionalCurrency xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:Gender>MALE</ns1:Gender>\r\n" + 
				"          <ns1:MaritalStatus xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:Comments xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:DateOfBirth xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:UserGUID xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PartyUniqueName>Kyung Bae Kwak</ns1:PartyUniqueName>\r\n" + 
				"          <ns1:SourceSystem xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:SourceSystemReferenceValue xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:SourceSystemUpdateDate xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:OriginalSystemReference xmlns:ns4=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/sourceSystemRef/\">\r\n" + 
				"            <ns3:OrigSystemReferenceId>300000840665760</ns3:OrigSystemReferenceId>\r\n" + 
				"            <ns3:OrigSystem>MLETE</ns3:OrigSystem>\r\n" + 
				"            <ns3:OrigSystemReference>204752</ns3:OrigSystemReference>\r\n" + 
				"            <ns3:OwnerTableName>HZ_PARTIES</ns3:OwnerTableName>\r\n" + 
				"            <ns3:OwnerTableId>300000840665756</ns3:OwnerTableId>\r\n" + 
				"            <ns3:Status>A</ns3:Status>\r\n" + 
				"            <ns3:ReasonCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:OldOrigSystemReference xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:StartDateActive>2019-02-28</ns3:StartDateActive>\r\n" + 
				"            <ns3:EndDateActive>4712-12-31</ns3:EndDateActive>\r\n" + 
				"            <ns3:CreatedBy>pms scheduler</ns3:CreatedBy>\r\n" + 
				"            <ns3:CreationDate>2019-02-28T11:14:21.023Z</ns3:CreationDate>\r\n" + 
				"            <ns3:LastUpdatedBy>pms scheduler</ns3:LastUpdatedBy>\r\n" + 
				"            <ns3:LastUpdateDate>2019-02-28T11:14:21.248Z</ns3:LastUpdateDate>\r\n" + 
				"            <ns3:LastUpdateLogin>82F2BE8C63A60E20E0530A67360A8152</ns3:LastUpdateLogin>\r\n" + 
				"            <ns3:ObjectVersionNumber>3</ns3:ObjectVersionNumber>\r\n" + 
				"            <ns3:CreatedByModule>HZ_WS</ns3:CreatedByModule>\r\n" + 
				"            <ns3:PartyId>300000840665756</ns3:PartyId>\r\n" + 
				"            <ns3:RequestId xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:SourceSystemRefInformation>\r\n" + 
				"              <ns4:OrigSystemRefId>300000840665760</ns4:OrigSystemRefId>\r\n" + 
				"              <ns4:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"              <ns4:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"              <ns4:_FLEX_NumOfSegments>0</ns4:_FLEX_NumOfSegments>\r\n" + 
				"            </ns3:SourceSystemRefInformation>\r\n" + 
				"          </ns1:OriginalSystemReference>\r\n" + 
				"          <ns1:PartySite xmlns:ns7=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/partySite/\">\r\n" + 
				"            <ns3:PartySiteId>300000840669483</ns3:PartySiteId>\r\n" + 
				"            <ns3:PartyId>300000840665756</ns3:PartyId>\r\n" + 
				"            <ns3:LocationId>300000840669484</ns3:LocationId>\r\n" + 
				"            <ns3:LastUpdateDate>2019-02-28T11:14:26.219Z</ns3:LastUpdateDate>\r\n" + 
				"            <ns3:PartySiteNumber>18813712</ns3:PartySiteNumber>\r\n" + 
				"            <ns3:LastUpdatedBy>pms scheduler</ns3:LastUpdatedBy>\r\n" + 
				"            <ns3:CreationDate>2019-02-28T11:14:26.001Z</ns3:CreationDate>\r\n" + 
				"            <ns3:CreatedBy>pms scheduler</ns3:CreatedBy>\r\n" + 
				"            <ns3:LastUpdateLogin>82F24E35973F7AFFE0530A67360AFCE9</ns3:LastUpdateLogin>\r\n" + 
				"            <ns3:RequestId xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:OrigSystemReference>300000840669483</ns3:OrigSystemReference>\r\n" + 
				"            <ns3:StartDateActive>2019-02-28</ns3:StartDateActive>\r\n" + 
				"            <ns3:EndDateActive>4712-12-31</ns3:EndDateActive>\r\n" + 
				"            <ns3:Mailstop xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:IdentifyingAddressFlag>true</ns3:IdentifyingAddressFlag>\r\n" + 
				"            <ns3:Language xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:Status>A</ns3:Status>\r\n" + 
				"            <ns3:PartySiteName xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:Addressee xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:ObjectVersionNumber>1</ns3:ObjectVersionNumber>\r\n" + 
				"            <ns3:CreatedByModule>HZ_WS</ns3:CreatedByModule>\r\n" + 
				"            <ns3:GlobalLocationNumber xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:DUNSNumberC xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:Comments xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:PartySiteType xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:PartyNameDba xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:PartyNameDivision xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:PartyNameLegal xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:RelationshipId xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:PartyUsageCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:OverallPrimaryFlag>true</ns3:OverallPrimaryFlag>\r\n" + 
				"            <ns3:PartySiteUse>\r\n" + 
				"              <ns3:PartySiteUseId>300000840669486</ns3:PartySiteUseId>\r\n" + 
				"              <ns3:BeginDate>2019-02-28</ns3:BeginDate>\r\n" + 
				"              <ns3:Comments xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:EndDate>4712-12-31</ns3:EndDate>\r\n" + 
				"              <ns3:PartySiteId>300000840669483</ns3:PartySiteId>\r\n" + 
				"              <ns3:LastUpdateDate>2019-02-28T11:14:26.146Z</ns3:LastUpdateDate>\r\n" + 
				"              <ns3:RequestId xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:LastUpdatedBy>pms scheduler</ns3:LastUpdatedBy>\r\n" + 
				"              <ns3:CreationDate>2019-02-28T11:14:26.026Z</ns3:CreationDate>\r\n" + 
				"              <ns3:CreatedBy>pms scheduler</ns3:CreatedBy>\r\n" + 
				"              <ns3:LastUpdateLogin>82F24E35973F7AFFE0530A67360AFCE9</ns3:LastUpdateLogin>\r\n" + 
				"              <ns3:IntegrationKey xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:SiteUseType>HOME</ns3:SiteUseType>\r\n" + 
				"              <ns3:PrimaryPerType>Y</ns3:PrimaryPerType>\r\n" + 
				"              <ns3:Status>A</ns3:Status>\r\n" + 
				"              <ns3:ObjectVersionNumber>1</ns3:ObjectVersionNumber>\r\n" + 
				"              <ns3:CreatedByModule>HZ_WS</ns3:CreatedByModule>\r\n" + 
				"            </ns3:PartySiteUse>\r\n" + 
				"            <ns3:OriginalSystemReference xmlns:ns4=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/sourceSystemRef/\">\r\n" + 
				"              <ns3:OrigSystemReferenceId>300000840669485</ns3:OrigSystemReferenceId>\r\n" + 
				"              <ns3:OrigSystem>PMS</ns3:OrigSystem>\r\n" + 
				"              <ns3:OrigSystemReference>PP_2019022811142249211</ns3:OrigSystemReference>\r\n" + 
				"              <ns3:OwnerTableName>HZ_PARTY_SITES</ns3:OwnerTableName>\r\n" + 
				"              <ns3:OwnerTableId>300000840669483</ns3:OwnerTableId>\r\n" + 
				"              <ns3:Status>A</ns3:Status>\r\n" + 
				"              <ns3:ReasonCode xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:OldOrigSystemReference xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:StartDateActive>2019-02-28</ns3:StartDateActive>\r\n" + 
				"              <ns3:EndDateActive>4712-12-31</ns3:EndDateActive>\r\n" + 
				"              <ns3:CreatedBy>pms scheduler</ns3:CreatedBy>\r\n" + 
				"              <ns3:CreationDate>2019-02-28T11:14:26.021Z</ns3:CreationDate>\r\n" + 
				"              <ns3:LastUpdatedBy>pms scheduler</ns3:LastUpdatedBy>\r\n" + 
				"              <ns3:LastUpdateDate>2019-02-28T11:14:26.142Z</ns3:LastUpdateDate>\r\n" + 
				"              <ns3:LastUpdateLogin>82F24E35973F7AFFE0530A67360AFCE9</ns3:LastUpdateLogin>\r\n" + 
				"              <ns3:ObjectVersionNumber>1</ns3:ObjectVersionNumber>\r\n" + 
				"              <ns3:CreatedByModule>HZ_WS</ns3:CreatedByModule>\r\n" + 
				"              <ns3:PartyId xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:RequestId xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:SourceSystemRefInformation>\r\n" + 
				"                <ns4:OrigSystemRefId>300000840669485</ns4:OrigSystemRefId>\r\n" + 
				"                <ns4:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"                <ns4:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"                <ns4:_FLEX_NumOfSegments>0</ns4:_FLEX_NumOfSegments>\r\n" + 
				"              </ns3:SourceSystemRefInformation>\r\n" + 
				"            </ns3:OriginalSystemReference>\r\n" + 
				"            <ns3:PersonPartySiteInformation>\r\n" + 
				"              <ns7:PartySiteId>300000840669483</ns7:PartySiteId>\r\n" + 
				"              <ns7:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"              <ns7:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"              <ns7:_FLEX_NumOfSegments>0</ns7:_FLEX_NumOfSegments>\r\n" + 
				"            </ns3:PersonPartySiteInformation>\r\n" + 
				"          </ns1:PartySite>\r\n" + 
				"          <ns1:PersonProfile xmlns:ns2=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/person/\">\r\n" + 
				"            <ns1:PersonProfileId>300000840665756</ns1:PersonProfileId>\r\n" + 
				"            <ns1:PartyId>300000840665756</ns1:PartyId>\r\n" + 
				"            <ns1:PersonName>Kyung Bae Kwak</ns1:PersonName>\r\n" + 
				"            <ns1:LastUpdateDate>2019-02-28T11:14:26.362Z</ns1:LastUpdateDate>\r\n" + 
				"            <ns1:LastUpdatedBy>pms scheduler</ns1:LastUpdatedBy>\r\n" + 
				"            <ns1:CreationDate>2019-02-28T11:14:21.001Z</ns1:CreationDate>\r\n" + 
				"            <ns1:CreatedBy>pms scheduler</ns1:CreatedBy>\r\n" + 
				"            <ns1:LastUpdateLogin>82F24E35973F7AFFE0530A67360AFCE9</ns1:LastUpdateLogin>\r\n" + 
				"            <ns1:RequestId xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PersonPreNameAdjunct>Mr.</ns1:PersonPreNameAdjunct>\r\n" + 
				"            <ns1:PersonFirstName>Kyung Bae</ns1:PersonFirstName>\r\n" + 
				"            <ns1:PersonMiddleName xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PersonLastName>Kwak</ns1:PersonLastName>\r\n" + 
				"            <ns1:PersonNameSuffix xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PersonTitle xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PersonAcademicTitle xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PersonPreviousLastName xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PersonInitials xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:JgzzFiscalCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:DateOfBirth xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PlaceOfBirth xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:DateOfDeath xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:Gender>MALE</ns1:Gender>\r\n" + 
				"            <ns1:DeclaredEthnicity xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:MaritalStatus xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:MaritalStatusEffectiveDate xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PersonalIncomeAmount xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:RentOwnInd xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:LastKnownGPS xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:EffectiveStartDate>2019-02-28</ns1:EffectiveStartDate>\r\n" + 
				"            <ns1:EffectiveEndDate>4712-12-31</ns1:EffectiveEndDate>\r\n" + 
				"            <ns1:InternalFlag xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:Status>A</ns1:Status>\r\n" + 
				"            <ns1:CreatedByModule>HZ_WS</ns1:CreatedByModule>\r\n" + 
				"            <ns1:DeceasedFlag>false</ns1:DeceasedFlag>\r\n" + 
				"            <ns1:Comments xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PersonLastNamePrefix xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PersonSecondLastName xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PreferredFunctionalCurrency xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:OrigSystem xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:OrigSystemReference>300000840665756</ns1:OrigSystemReference>\r\n" + 
				"            <ns1:EffectiveSequence>1</ns1:EffectiveSequence>\r\n" + 
				"            <ns1:HeadOfHouseholdFlag>false</ns1:HeadOfHouseholdFlag>\r\n" + 
				"            <ns1:HouseholdIncomeAmount xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:HouseholdSize xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:EffectiveLatestChange>Y</ns1:EffectiveLatestChange>\r\n" + 
				"            <ns1:SuffixOverriddenFlag>false</ns1:SuffixOverriddenFlag>\r\n" + 
				"            <ns1:UniqueNameSuffix xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:CorpCurrencyCode>INR</ns1:CorpCurrencyCode>\r\n" + 
				"            <ns1:CurcyConvRateType>Corporate</ns1:CurcyConvRateType>\r\n" + 
				"            <ns1:CurrencyCode>INR</ns1:CurrencyCode>\r\n" + 
				"            <ns1:PartyNumber>12756143</ns1:PartyNumber>\r\n" + 
				"            <ns1:Salutation xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:CertReasonCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:CertificationLevel xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PreferredContactMethod xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PreferredContactPersonId xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryAddressLine1 xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryAddressLine2 xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryAddressLine3 xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryAddressLine4 xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:Alias xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryAddressCity xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryAddressCountry>KR</ns1:PrimaryAddressCountry>\r\n" + 
				"            <ns1:PrimaryAddressCounty xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryEmailAddress xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryFormattedAddress>KOREA, REPUBLIC OF</ns1:PrimaryFormattedAddress>\r\n" + 
				"            <ns1:PrimaryFormattedPhoneNumber xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryLanguage xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PartyUniqueName>Kyung Bae Kwak</ns1:PartyUniqueName>\r\n" + 
				"            <ns1:PrimaryAddressPostalCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PreferredContactEmail xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PreferredContactName xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PreferredContactPhone xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PreferredContactURL xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PreferredName xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PreferredNameId xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryEmailId xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryPhoneAreaCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryPhoneId xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryPhoneCountryCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryPhoneExtension xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryPhoneLineType xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryPhoneNumber xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryPhonePurpose xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryWebId xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:Pronunciation xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryAddressProvince xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryAddressState xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryURL xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:ValidatedFlag xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryAddressLatitude xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryAddressLongitude xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryAddressLocationId>300000840669484</ns1:PrimaryAddressLocationId>\r\n" + 
				"            <ns1:FavoriteContactFlag>false</ns1:FavoriteContactFlag>\r\n" + 
				"            <ns1:Distance xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:SalesAffinityCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:SalesBuyingRoleCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:DepartmentCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:Department xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:JobTitleCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:JobTitle xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:DoNotCallFlag>false</ns1:DoNotCallFlag>\r\n" + 
				"            <ns1:DoNotContactFlag>false</ns1:DoNotContactFlag>\r\n" + 
				"            <ns1:DoNotEmailFlag>false</ns1:DoNotEmailFlag>\r\n" + 
				"            <ns1:DoNotMailFlag>false</ns1:DoNotMailFlag>\r\n" + 
				"            <ns1:LastContactDate xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryCustomerId xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryCustomerRelationshipId xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryCustomerName xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:LastSourceUpdateDate>2019-02-28T11:14:26.0Z</ns1:LastSourceUpdateDate>\r\n" + 
				"            <ns1:LastUpdateSourceSystem>UNKNOWN</ns1:LastUpdateSourceSystem>\r\n" + 
				"            <ns1:DataCloudStatus xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:LastEnrichmentDate xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PersonInformation>\r\n" + 
				"              <ns2:PersonProfileId>300000840665756</ns2:PersonProfileId>\r\n" + 
				"              <ns2:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"              <ns2:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"              <ns2:_FLEX_NumOfSegments>0</ns2:_FLEX_NumOfSegments>\r\n" + 
				"            </ns1:PersonInformation>\r\n" + 
				"            <ns1:Secretary_Id_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:Secretary_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:ChamberMember_c>false</ns1:ChamberMember_c>\r\n" + 
				"            <ns1:Category_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:ContactLevel_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:OtherSalutation_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:SpouseName_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:SecretaryFormulaField_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:LoyaltyMembership_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:Tier_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:LoyaltyMembershipNumber_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:MembershipNumber_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:Passport_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:DateOfBirth_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:ChamberMembershipNumber_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:AccountCity_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:AccountCity1_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:Association_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PANNumber_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:ProfileCreatedAtChannel_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:ProfileCreatedAtProperty_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:ProfileCreatedBy_c>KRITIKA</ns1:ProfileCreatedBy_c>\r\n" + 
				"            <ns1:ProfileCreatedDate_c>2019-02-28</ns1:ProfileCreatedDate_c>\r\n" + 
				"            <ns1:ProfileUpdatedBy_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:ProfileUpdatedDate_c>2019-02-28</ns1:ProfileUpdatedDate_c>\r\n" + 
				"            <ns1:NationalityLOV_c>KR</ns1:NationalityLOV_c>\r\n" + 
				"            <ns1:SpouseBirthday_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:AnniversaryDate_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:LegalCompany_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:AadhaarNumber_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:LicenseNumber_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:VIPLOV_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:Profession_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:MUI_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:LastUpdateSource_c>PMS</ns1:LastUpdateSource_c>\r\n" + 
				"            <ns1:LanguagePreference_c>E</ns1:LanguagePreference_c>\r\n" + 
				"            <ns1:NotParticipateInMarketRea_c>false</ns1:NotParticipateInMarketRea_c>\r\n" + 
				"            <ns1:NotReceiveEmails_c>true</ns1:NotReceiveEmails_c>\r\n" + 
				"            <ns1:NotInfoFromThirdParty_c>false</ns1:NotInfoFromThirdParty_c>\r\n" + 
				"            <ns1:LicenseIDIssueDate_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PassportIDIssueDate_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:AadhaarIssueDate_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:LicenseIDIssuePlace_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PassportIDIssuePlace_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:AadhaarIssuePlace_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PassportIDExpiryDate_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:WebSite_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrivateWebpage_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:ARNo_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:Restricted_c>false</ns1:Restricted_c>\r\n" + 
				"            <ns1:RestrictRule_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:CYNumber_c>2019</ns1:CYNumber_c>\r\n" + 
				"            <ns1:LYNumber_c>2018</ns1:LYNumber_c>\r\n" + 
				"            <ns1:Days_c>50</ns1:Days_c>\r\n" + 
				"            <ns1:PMSFlag_c>true</ns1:PMSFlag_c>\r\n" + 
				"            <ns1:PMSLastUpdateSource_c>MLETE</ns1:PMSLastUpdateSource_c>\r\n" + 
				"            <ns1:IAMUpdateFlag_c xsi:nil=\"true\"/>\r\n" + 
				"          </ns1:PersonProfile>\r\n" + 
				"          <ns1:PartyUsageAssignment>\r\n" + 
				"            <ns3:PartyUsgAssignmentId>300000840665759</ns3:PartyUsgAssignmentId>\r\n" + 
				"            <ns3:PartyId>300000840665756</ns3:PartyId>\r\n" + 
				"            <ns3:PartyUsageCode>CONTACT</ns3:PartyUsageCode>\r\n" + 
				"            <ns3:EffectiveStartDate>2019-02-28</ns3:EffectiveStartDate>\r\n" + 
				"            <ns3:EffectiveEndDate>4712-12-31</ns3:EffectiveEndDate>\r\n" + 
				"            <ns3:StatusFlag>true</ns3:StatusFlag>\r\n" + 
				"            <ns3:Comments xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:OwnerTableName xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:OwnerTableId xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:CreatedByModule>HZ_WS</ns3:CreatedByModule>\r\n" + 
				"            <ns3:ObjectVersionNumber>1</ns3:ObjectVersionNumber>\r\n" + 
				"            <ns3:CreatedBy>pms scheduler</ns3:CreatedBy>\r\n" + 
				"            <ns3:CreationDate>2019-02-28T11:14:21.021Z</ns3:CreationDate>\r\n" + 
				"            <ns3:LastUpdateLogin>82F2BE8C63A60E20E0530A67360A8152</ns3:LastUpdateLogin>\r\n" + 
				"            <ns3:LastUpdateDate>2019-02-28T11:14:21.066Z</ns3:LastUpdateDate>\r\n" + 
				"            <ns3:LastUpdatedBy>pms scheduler</ns3:LastUpdatedBy>\r\n" + 
				"            <ns3:RequestId xsi:nil=\"true\"/>\r\n" + 
				"          </ns1:PartyUsageAssignment>\r\n" + 
				"        </ns1:Value>\r\n" + 
				"        <ns1:Value>\r\n" + 
				"          <ns1:PartyId>100000163417139</ns1:PartyId>\r\n" + 
				"          <ns1:PartyNumber>5864022</ns1:PartyNumber>\r\n" + 
				"          <ns1:PartyName>Subash Ranga</ns1:PartyName>\r\n" + 
				"          <ns1:PartyType>PERSON</ns1:PartyType>\r\n" + 
				"          <ns1:ValidatedFlag>false</ns1:ValidatedFlag>\r\n" + 
				"          <ns1:LastUpdatedBy>Datacentre</ns1:LastUpdatedBy>\r\n" + 
				"          <ns1:LastUpdateLogin>-1</ns1:LastUpdateLogin>\r\n" + 
				"          <ns1:CreationDate>2018-06-22T11:10:16.617712Z</ns1:CreationDate>\r\n" + 
				"          <ns1:RequestId>104137</ns1:RequestId>\r\n" + 
				"          <ns1:LastUpdateDate>2018-06-22T11:43:41.448484Z</ns1:LastUpdateDate>\r\n" + 
				"          <ns1:CreatedBy>Datacentre</ns1:CreatedBy>\r\n" + 
				"          <ns1:OrigSystemReference>204752</ns1:OrigSystemReference>\r\n" + 
				"          <ns1:SICCode xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:JgzzFiscalCode xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PersonFirstName>Subash</ns1:PersonFirstName>\r\n" + 
				"          <ns1:PersonPreNameAdjunct xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PersonLastName>Ranga</ns1:PersonLastName>\r\n" + 
				"          <ns1:PersonMiddleName xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PersonTitle xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PersonNameSuffix xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PersonPreviousLastName xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PersonAcademicTitle xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:Country xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:Address2 xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:Address1 xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:Address4 xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:Address3 xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PostalCode xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:City xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:Province xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:State xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:County xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:Status>A</ns1:Status>\r\n" + 
				"          <ns1:URL xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:SICCodeType xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:EmailAddress xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:GSAIndicatorFlag xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:LanguageName xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:MissionStatement xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:CategoryCode xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:ThirdPartyFlag xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:Salutation xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:CreatedByModule>HZ_IMPORT</ns1:CreatedByModule>\r\n" + 
				"          <ns1:CertReasonCode xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:CertificationLevel xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PrimaryPhonePurpose xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PrimaryPhoneContactPTId xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PrimaryPhoneCountryCode xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PrimaryPhoneLineType xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PrimaryPhoneNumber xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PrimaryPhoneAreaCode xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PreferredContactMethod xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PrimaryPhoneExtension xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:IdenAddrLocationId xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PrimaryEmailContactPTId xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:IdenAddrPartySiteId xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PersonLastNamePrefix xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PrimaryURLContactPTId xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PreferredName xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PersonSecondLastName xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PreferredNameId xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PreferredContactPersonId xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:InternalFlag>false</ns1:InternalFlag>\r\n" + 
				"          <ns1:PreferredFunctionalCurrency xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:Gender xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:MaritalStatus xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:Comments xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:DateOfBirth xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:UserGUID xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PartyUniqueName>Subash Ranga</ns1:PartyUniqueName>\r\n" + 
				"          <ns1:SourceSystem xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:SourceSystemReferenceValue xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:SourceSystemUpdateDate xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:OriginalSystemReference xmlns:ns4=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/sourceSystemRef/\">\r\n" + 
				"            <ns3:OrigSystemReferenceId>100000163886083</ns3:OrigSystemReferenceId>\r\n" + 
				"            <ns3:OrigSystem>DELDW</ns3:OrigSystem>\r\n" + 
				"            <ns3:OrigSystemReference>204752</ns3:OrigSystemReference>\r\n" + 
				"            <ns3:OwnerTableName>HZ_PARTIES</ns3:OwnerTableName>\r\n" + 
				"            <ns3:OwnerTableId>100000163417139</ns3:OwnerTableId>\r\n" + 
				"            <ns3:Status>A</ns3:Status>\r\n" + 
				"            <ns3:ReasonCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:OldOrigSystemReference xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:StartDateActive>2018-06-22</ns3:StartDateActive>\r\n" + 
				"            <ns3:EndDateActive>4712-12-31</ns3:EndDateActive>\r\n" + 
				"            <ns3:CreatedBy>Datacentre</ns3:CreatedBy>\r\n" + 
				"            <ns3:CreationDate>2018-06-22T11:09:37.231652Z</ns3:CreationDate>\r\n" + 
				"            <ns3:LastUpdatedBy>Datacentre</ns3:LastUpdatedBy>\r\n" + 
				"            <ns3:LastUpdateDate>2018-06-22T11:09:37.231652Z</ns3:LastUpdateDate>\r\n" + 
				"            <ns3:LastUpdateLogin>-1</ns3:LastUpdateLogin>\r\n" + 
				"            <ns3:ObjectVersionNumber>1</ns3:ObjectVersionNumber>\r\n" + 
				"            <ns3:CreatedByModule>HZ_IMPORT</ns3:CreatedByModule>\r\n" + 
				"            <ns3:PartyId>100000163417139</ns3:PartyId>\r\n" + 
				"            <ns3:RequestId>104137</ns3:RequestId>\r\n" + 
				"            <ns3:SourceSystemRefInformation>\r\n" + 
				"              <ns4:OrigSystemRefId>100000163886083</ns4:OrigSystemRefId>\r\n" + 
				"              <ns4:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"              <ns4:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"              <ns4:_FLEX_NumOfSegments>0</ns4:_FLEX_NumOfSegments>\r\n" + 
				"            </ns3:SourceSystemRefInformation>\r\n" + 
				"          </ns1:OriginalSystemReference>\r\n" + 
				"          <ns1:PersonProfile xmlns:ns2=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/person/\">\r\n" + 
				"            <ns1:PersonProfileId>100000163417139</ns1:PersonProfileId>\r\n" + 
				"            <ns1:PartyId>100000163417139</ns1:PartyId>\r\n" + 
				"            <ns1:PersonName>Subash Ranga</ns1:PersonName>\r\n" + 
				"            <ns1:LastUpdateDate>2018-06-22T11:44:07.565828Z</ns1:LastUpdateDate>\r\n" + 
				"            <ns1:LastUpdatedBy>Datacentre</ns1:LastUpdatedBy>\r\n" + 
				"            <ns1:CreationDate>2018-06-22T11:14:37.281516Z</ns1:CreationDate>\r\n" + 
				"            <ns1:CreatedBy>Datacentre</ns1:CreatedBy>\r\n" + 
				"            <ns1:LastUpdateLogin>-1</ns1:LastUpdateLogin>\r\n" + 
				"            <ns1:RequestId>104137</ns1:RequestId>\r\n" + 
				"            <ns1:PersonPreNameAdjunct xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PersonFirstName>Subash</ns1:PersonFirstName>\r\n" + 
				"            <ns1:PersonMiddleName xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PersonLastName>Ranga</ns1:PersonLastName>\r\n" + 
				"            <ns1:PersonNameSuffix xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PersonTitle xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PersonAcademicTitle xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PersonPreviousLastName xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PersonInitials xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:JgzzFiscalCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:DateOfBirth xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PlaceOfBirth xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:DateOfDeath xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:Gender xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:DeclaredEthnicity xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:MaritalStatus xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:MaritalStatusEffectiveDate xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PersonalIncomeAmount xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:RentOwnInd xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:LastKnownGPS xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:EffectiveStartDate>2018-06-22</ns1:EffectiveStartDate>\r\n" + 
				"            <ns1:EffectiveEndDate>4712-12-31</ns1:EffectiveEndDate>\r\n" + 
				"            <ns1:InternalFlag>false</ns1:InternalFlag>\r\n" + 
				"            <ns1:Status>A</ns1:Status>\r\n" + 
				"            <ns1:CreatedByModule>HZ_IMPORT</ns1:CreatedByModule>\r\n" + 
				"            <ns1:DeceasedFlag>false</ns1:DeceasedFlag>\r\n" + 
				"            <ns1:Comments xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PersonLastNamePrefix xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PersonSecondLastName xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PreferredFunctionalCurrency xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:OrigSystem xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:OrigSystemReference>204752</ns1:OrigSystemReference>\r\n" + 
				"            <ns1:EffectiveSequence>1</ns1:EffectiveSequence>\r\n" + 
				"            <ns1:HeadOfHouseholdFlag xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:HouseholdIncomeAmount xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:HouseholdSize xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:EffectiveLatestChange>Y</ns1:EffectiveLatestChange>\r\n" + 
				"            <ns1:SuffixOverriddenFlag>false</ns1:SuffixOverriddenFlag>\r\n" + 
				"            <ns1:UniqueNameSuffix xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:CorpCurrencyCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:CurcyConvRateType xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:CurrencyCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PartyNumber>5864022</ns1:PartyNumber>\r\n" + 
				"            <ns1:Salutation xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:CertReasonCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:CertificationLevel xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PreferredContactMethod xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PreferredContactPersonId xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryAddressLine1 xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryAddressLine2 xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryAddressLine3 xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryAddressLine4 xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:Alias xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryAddressCity xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryAddressCountry xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryAddressCounty xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryEmailAddress xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryFormattedAddress xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryFormattedPhoneNumber xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryLanguage xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PartyUniqueName>Subash Ranga</ns1:PartyUniqueName>\r\n" + 
				"            <ns1:PrimaryAddressPostalCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PreferredContactEmail xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PreferredContactName xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PreferredContactPhone xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PreferredContactURL xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PreferredName xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PreferredNameId xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryEmailId xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryPhoneAreaCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryPhoneId xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryPhoneCountryCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryPhoneExtension xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryPhoneLineType xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryPhoneNumber xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryPhonePurpose xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryWebId xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:Pronunciation xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryAddressProvince xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryAddressState xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryURL xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:ValidatedFlag>false</ns1:ValidatedFlag>\r\n" + 
				"            <ns1:PrimaryAddressLatitude xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryAddressLongitude xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryAddressLocationId/>\r\n" + 
				"            <ns1:FavoriteContactFlag>false</ns1:FavoriteContactFlag>\r\n" + 
				"            <ns1:Distance xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:SalesAffinityCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:SalesBuyingRoleCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:DepartmentCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:Department xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:JobTitleCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:JobTitle xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:DoNotCallFlag>false</ns1:DoNotCallFlag>\r\n" + 
				"            <ns1:DoNotContactFlag>false</ns1:DoNotContactFlag>\r\n" + 
				"            <ns1:DoNotEmailFlag>false</ns1:DoNotEmailFlag>\r\n" + 
				"            <ns1:DoNotMailFlag>false</ns1:DoNotMailFlag>\r\n" + 
				"            <ns1:LastContactDate xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryCustomerId xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryCustomerRelationshipId xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryCustomerName xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:LastSourceUpdateDate>2018-06-22T11:14:33.733514Z</ns1:LastSourceUpdateDate>\r\n" + 
				"            <ns1:LastUpdateSourceSystem>DELDW</ns1:LastUpdateSourceSystem>\r\n" + 
				"            <ns1:DataCloudStatus xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:LastEnrichmentDate xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PersonInformation>\r\n" + 
				"              <ns2:PersonProfileId>100000163417139</ns2:PersonProfileId>\r\n" + 
				"              <ns2:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"              <ns2:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"              <ns2:_FLEX_NumOfSegments>0</ns2:_FLEX_NumOfSegments>\r\n" + 
				"            </ns1:PersonInformation>\r\n" + 
				"            <ns1:Secretary_Id_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:Secretary_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:ChamberMember_c>false</ns1:ChamberMember_c>\r\n" + 
				"            <ns1:Category_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:ContactLevel_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:OtherSalutation_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:SpouseName_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:SecretaryFormulaField_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:LoyaltyMembership_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:Tier_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:LoyaltyMembershipNumber_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:MembershipNumber_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:Passport_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:DateOfBirth_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:ChamberMembershipNumber_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:AccountCity_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:AccountCity1_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:Association_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PANNumber_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:ProfileCreatedAtChannel_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:ProfileCreatedAtProperty_c>DELDW</ns1:ProfileCreatedAtProperty_c>\r\n" + 
				"            <ns1:ProfileCreatedBy_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:ProfileCreatedDate_c>2017-09-26</ns1:ProfileCreatedDate_c>\r\n" + 
				"            <ns1:ProfileUpdatedBy_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:ProfileUpdatedDate_c>2017-09-26</ns1:ProfileUpdatedDate_c>\r\n" + 
				"            <ns1:NationalityLOV_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:SpouseBirthday_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:AnniversaryDate_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:LegalCompany_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:AadhaarNumber_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:LicenseNumber_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:VIPLOV_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:Profession_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:MUI_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:LastUpdateSource_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:LanguagePreference_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:NotParticipateInMarketRea_c/>\r\n" + 
				"            <ns1:NotReceiveEmails_c/>\r\n" + 
				"            <ns1:NotInfoFromThirdParty_c/>\r\n" + 
				"            <ns1:LicenseIDIssueDate_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PassportIDIssueDate_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:AadhaarIssueDate_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:LicenseIDIssuePlace_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PassportIDIssuePlace_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:AadhaarIssuePlace_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PassportIDExpiryDate_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:WebSite_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrivateWebpage_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:ARNo_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:Restricted_c/>\r\n" + 
				"            <ns1:RestrictRule_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:CYNumber_c>2019</ns1:CYNumber_c>\r\n" + 
				"            <ns1:LYNumber_c>2018</ns1:LYNumber_c>\r\n" + 
				"            <ns1:Days_c>50</ns1:Days_c>\r\n" + 
				"            <ns1:PMSFlag_c/>\r\n" + 
				"            <ns1:PMSLastUpdateSource_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:IAMUpdateFlag_c xsi:nil=\"true\"/>\r\n" + 
				"          </ns1:PersonProfile>\r\n" + 
				"          <ns1:PartyUsageAssignment>\r\n" + 
				"            <ns3:PartyUsgAssignmentId>100000164286465</ns3:PartyUsgAssignmentId>\r\n" + 
				"            <ns3:PartyId>100000163417139</ns3:PartyId>\r\n" + 
				"            <ns3:PartyUsageCode>CONTACT</ns3:PartyUsageCode>\r\n" + 
				"            <ns3:EffectiveStartDate>2018-06-22</ns3:EffectiveStartDate>\r\n" + 
				"            <ns3:EffectiveEndDate>4712-12-31</ns3:EffectiveEndDate>\r\n" + 
				"            <ns3:StatusFlag>true</ns3:StatusFlag>\r\n" + 
				"            <ns3:Comments xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:OwnerTableName xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:OwnerTableId xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:CreatedByModule>HZ_IMPORT</ns3:CreatedByModule>\r\n" + 
				"            <ns3:ObjectVersionNumber>1</ns3:ObjectVersionNumber>\r\n" + 
				"            <ns3:CreatedBy>Datacentre</ns3:CreatedBy>\r\n" + 
				"            <ns3:CreationDate>2018-06-22T11:15:42.378701Z</ns3:CreationDate>\r\n" + 
				"            <ns3:LastUpdateLogin>-1</ns3:LastUpdateLogin>\r\n" + 
				"            <ns3:LastUpdateDate>2018-06-22T11:15:42.378701Z</ns3:LastUpdateDate>\r\n" + 
				"            <ns3:LastUpdatedBy>Datacentre</ns3:LastUpdatedBy>\r\n" + 
				"            <ns3:RequestId>104137</ns3:RequestId>\r\n" + 
				"          </ns1:PartyUsageAssignment>\r\n" + 
				"        </ns1:Value>\r\n" + 
				"        <ns1:Value>\r\n" + 
				"          <ns1:PartyId>100000194389169</ns1:PartyId>\r\n" + 
				"          <ns1:PartyNumber>7402601</ns1:PartyNumber>\r\n" + 
				"          <ns1:PartyName>Saud Hijrif Z Alotaibi</ns1:PartyName>\r\n" + 
				"          <ns1:PartyType>PERSON</ns1:PartyType>\r\n" + 
				"          <ns1:ValidatedFlag>false</ns1:ValidatedFlag>\r\n" + 
				"          <ns1:LastUpdatedBy>raj.srinivasan@innovacx.com</ns1:LastUpdatedBy>\r\n" + 
				"          <ns1:LastUpdateLogin>-1</ns1:LastUpdateLogin>\r\n" + 
				"          <ns1:CreationDate>2018-07-31T13:31:53.830773Z</ns1:CreationDate>\r\n" + 
				"          <ns1:RequestId>122373</ns1:RequestId>\r\n" + 
				"          <ns1:LastUpdateDate>2018-08-01T06:26:24.285754Z</ns1:LastUpdateDate>\r\n" + 
				"          <ns1:CreatedBy>raj.srinivasan@innovacx.com</ns1:CreatedBy>\r\n" + 
				"          <ns1:OrigSystemReference>204752</ns1:OrigSystemReference>\r\n" + 
				"          <ns1:SICCode xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:JgzzFiscalCode xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PersonFirstName>Saud Hijrif Z</ns1:PersonFirstName>\r\n" + 
				"          <ns1:PersonPreNameAdjunct>Mr.</ns1:PersonPreNameAdjunct>\r\n" + 
				"          <ns1:PersonLastName>Alotaibi</ns1:PersonLastName>\r\n" + 
				"          <ns1:PersonMiddleName xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PersonTitle xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PersonNameSuffix xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PersonPreviousLastName xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PersonAcademicTitle xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:Country>SA</ns1:Country>\r\n" + 
				"          <ns1:Address2 xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:Address1 xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:Address4 xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:Address3 xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PostalCode xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:City xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:Province xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:State xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:County xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:Status>A</ns1:Status>\r\n" + 
				"          <ns1:URL xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:SICCodeType xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:EmailAddress xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:GSAIndicatorFlag xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:LanguageName xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:MissionStatement xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:CategoryCode xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:ThirdPartyFlag xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:Salutation xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:CreatedByModule>HZ_IMPORT</ns1:CreatedByModule>\r\n" + 
				"          <ns1:CertReasonCode xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:CertificationLevel xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PrimaryPhonePurpose xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PrimaryPhoneContactPTId xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PrimaryPhoneCountryCode xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PrimaryPhoneLineType xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PrimaryPhoneNumber xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PrimaryPhoneAreaCode xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PreferredContactMethod xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PrimaryPhoneExtension xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:IdenAddrLocationId>100000194586272</ns1:IdenAddrLocationId>\r\n" + 
				"          <ns1:PrimaryEmailContactPTId xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:IdenAddrPartySiteId>100000194612649</ns1:IdenAddrPartySiteId>\r\n" + 
				"          <ns1:PersonLastNamePrefix xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PrimaryURLContactPTId xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PreferredName xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PersonSecondLastName xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PreferredNameId xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PreferredContactPersonId xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:InternalFlag>false</ns1:InternalFlag>\r\n" + 
				"          <ns1:PreferredFunctionalCurrency xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:Gender>MALE</ns1:Gender>\r\n" + 
				"          <ns1:MaritalStatus xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:Comments xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:DateOfBirth xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:UserGUID xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PartyUniqueName>Saud Hijrif Z Alotaibi</ns1:PartyUniqueName>\r\n" + 
				"          <ns1:SourceSystem xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:SourceSystemReferenceValue xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:SourceSystemUpdateDate xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:OriginalSystemReference xmlns:ns4=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/sourceSystemRef/\">\r\n" + 
				"            <ns3:OrigSystemReferenceId>100000194429129</ns3:OrigSystemReferenceId>\r\n" + 
				"            <ns3:OrigSystem>LGKTR</ns3:OrigSystem>\r\n" + 
				"            <ns3:OrigSystemReference>204752</ns3:OrigSystemReference>\r\n" + 
				"            <ns3:OwnerTableName>HZ_PARTIES</ns3:OwnerTableName>\r\n" + 
				"            <ns3:OwnerTableId>100000194389169</ns3:OwnerTableId>\r\n" + 
				"            <ns3:Status>A</ns3:Status>\r\n" + 
				"            <ns3:ReasonCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:OldOrigSystemReference xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:StartDateActive>2018-07-31</ns3:StartDateActive>\r\n" + 
				"            <ns3:EndDateActive>4712-12-31</ns3:EndDateActive>\r\n" + 
				"            <ns3:CreatedBy>raj.srinivasan@innovacx.com</ns3:CreatedBy>\r\n" + 
				"            <ns3:CreationDate>2018-07-31T13:31:47.638304Z</ns3:CreationDate>\r\n" + 
				"            <ns3:LastUpdatedBy>raj.srinivasan@innovacx.com</ns3:LastUpdatedBy>\r\n" + 
				"            <ns3:LastUpdateDate>2018-07-31T13:31:47.638304Z</ns3:LastUpdateDate>\r\n" + 
				"            <ns3:LastUpdateLogin>-1</ns3:LastUpdateLogin>\r\n" + 
				"            <ns3:ObjectVersionNumber>1</ns3:ObjectVersionNumber>\r\n" + 
				"            <ns3:CreatedByModule>HZ_IMPORT</ns3:CreatedByModule>\r\n" + 
				"            <ns3:PartyId>100000194389169</ns3:PartyId>\r\n" + 
				"            <ns3:RequestId>122373</ns3:RequestId>\r\n" + 
				"            <ns3:SourceSystemRefInformation>\r\n" + 
				"              <ns4:OrigSystemRefId>100000194429129</ns4:OrigSystemRefId>\r\n" + 
				"              <ns4:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"              <ns4:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"              <ns4:_FLEX_NumOfSegments>0</ns4:_FLEX_NumOfSegments>\r\n" + 
				"            </ns3:SourceSystemRefInformation>\r\n" + 
				"          </ns1:OriginalSystemReference>\r\n" + 
				"          <ns1:PartySite xmlns:ns7=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/partySite/\">\r\n" + 
				"            <ns3:PartySiteId>100000194612649</ns3:PartySiteId>\r\n" + 
				"            <ns3:PartyId>100000194389169</ns3:PartyId>\r\n" + 
				"            <ns3:LocationId>100000194586272</ns3:LocationId>\r\n" + 
				"            <ns3:LastUpdateDate>2018-08-01T06:24:28.958069Z</ns3:LastUpdateDate>\r\n" + 
				"            <ns3:PartySiteNumber>8991308</ns3:PartySiteNumber>\r\n" + 
				"            <ns3:LastUpdatedBy>raj.srinivasan@innovacx.com</ns3:LastUpdatedBy>\r\n" + 
				"            <ns3:CreationDate>2018-08-01T06:24:14.056078Z</ns3:CreationDate>\r\n" + 
				"            <ns3:CreatedBy>raj.srinivasan@innovacx.com</ns3:CreatedBy>\r\n" + 
				"            <ns3:LastUpdateLogin>-1</ns3:LastUpdateLogin>\r\n" + 
				"            <ns3:RequestId xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:OrigSystemReference/>\r\n" + 
				"            <ns3:StartDateActive>2018-08-01</ns3:StartDateActive>\r\n" + 
				"            <ns3:EndDateActive>4712-12-31</ns3:EndDateActive>\r\n" + 
				"            <ns3:Mailstop xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:IdentifyingAddressFlag>true</ns3:IdentifyingAddressFlag>\r\n" + 
				"            <ns3:Language xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:Status>A</ns3:Status>\r\n" + 
				"            <ns3:PartySiteName xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:Addressee xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:ObjectVersionNumber>2</ns3:ObjectVersionNumber>\r\n" + 
				"            <ns3:CreatedByModule>HZ_IMPORT</ns3:CreatedByModule>\r\n" + 
				"            <ns3:GlobalLocationNumber xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:DUNSNumberC xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:Comments xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:PartySiteType xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:PartyNameDba xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:PartyNameDivision xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:PartyNameLegal xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:RelationshipId xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:PartyUsageCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:OverallPrimaryFlag>true</ns3:OverallPrimaryFlag>\r\n" + 
				"            <ns3:PartySiteUse>\r\n" + 
				"              <ns3:PartySiteUseId>100000194637925</ns3:PartySiteUseId>\r\n" + 
				"              <ns3:BeginDate>2018-08-01</ns3:BeginDate>\r\n" + 
				"              <ns3:Comments xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:EndDate>4712-12-31</ns3:EndDate>\r\n" + 
				"              <ns3:PartySiteId>100000194612649</ns3:PartySiteId>\r\n" + 
				"              <ns3:LastUpdateDate>2018-08-01T06:24:47.522754Z</ns3:LastUpdateDate>\r\n" + 
				"              <ns3:RequestId>-99999</ns3:RequestId>\r\n" + 
				"              <ns3:LastUpdatedBy>raj.srinivasan@innovacx.com</ns3:LastUpdatedBy>\r\n" + 
				"              <ns3:CreationDate>2018-08-01T06:24:38.807377Z</ns3:CreationDate>\r\n" + 
				"              <ns3:CreatedBy>raj.srinivasan@innovacx.com</ns3:CreatedBy>\r\n" + 
				"              <ns3:LastUpdateLogin>-1</ns3:LastUpdateLogin>\r\n" + 
				"              <ns3:IntegrationKey xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:SiteUseType>BUSINESS</ns3:SiteUseType>\r\n" + 
				"              <ns3:PrimaryPerType>Y</ns3:PrimaryPerType>\r\n" + 
				"              <ns3:Status>A</ns3:Status>\r\n" + 
				"              <ns3:ObjectVersionNumber>2</ns3:ObjectVersionNumber>\r\n" + 
				"              <ns3:CreatedByModule>HZ_IMPORT</ns3:CreatedByModule>\r\n" + 
				"            </ns3:PartySiteUse>\r\n" + 
				"            <ns3:OriginalSystemReference xmlns:ns4=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/sourceSystemRef/\">\r\n" + 
				"              <ns3:OrigSystemReferenceId>100000194730713</ns3:OrigSystemReferenceId>\r\n" + 
				"              <ns3:OrigSystem>LGKTR</ns3:OrigSystem>\r\n" + 
				"              <ns3:OrigSystemReference>206168</ns3:OrigSystemReference>\r\n" + 
				"              <ns3:OwnerTableName>HZ_PARTY_SITES</ns3:OwnerTableName>\r\n" + 
				"              <ns3:OwnerTableId>100000194612649</ns3:OwnerTableId>\r\n" + 
				"              <ns3:Status>A</ns3:Status>\r\n" + 
				"              <ns3:ReasonCode xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:OldOrigSystemReference xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:StartDateActive>2018-08-01</ns3:StartDateActive>\r\n" + 
				"              <ns3:EndDateActive>4712-12-31</ns3:EndDateActive>\r\n" + 
				"              <ns3:CreatedBy>raj.srinivasan@innovacx.com</ns3:CreatedBy>\r\n" + 
				"              <ns3:CreationDate>2018-08-01T06:24:20.697966Z</ns3:CreationDate>\r\n" + 
				"              <ns3:LastUpdatedBy>raj.srinivasan@innovacx.com</ns3:LastUpdatedBy>\r\n" + 
				"              <ns3:LastUpdateDate>2018-08-01T06:24:20.697966Z</ns3:LastUpdateDate>\r\n" + 
				"              <ns3:LastUpdateLogin>-1</ns3:LastUpdateLogin>\r\n" + 
				"              <ns3:ObjectVersionNumber>1</ns3:ObjectVersionNumber>\r\n" + 
				"              <ns3:CreatedByModule>HZ_IMPORT</ns3:CreatedByModule>\r\n" + 
				"              <ns3:PartyId>100000194389169</ns3:PartyId>\r\n" + 
				"              <ns3:RequestId xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:SourceSystemRefInformation>\r\n" + 
				"                <ns4:OrigSystemRefId>100000194730713</ns4:OrigSystemRefId>\r\n" + 
				"                <ns4:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"                <ns4:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"                <ns4:_FLEX_NumOfSegments>0</ns4:_FLEX_NumOfSegments>\r\n" + 
				"              </ns3:SourceSystemRefInformation>\r\n" + 
				"            </ns3:OriginalSystemReference>\r\n" + 
				"            <ns3:PersonPartySiteInformation>\r\n" + 
				"              <ns7:PartySiteId>100000194612649</ns7:PartySiteId>\r\n" + 
				"              <ns7:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"              <ns7:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"              <ns7:_FLEX_NumOfSegments>0</ns7:_FLEX_NumOfSegments>\r\n" + 
				"            </ns3:PersonPartySiteInformation>\r\n" + 
				"          </ns1:PartySite>\r\n" + 
				"          <ns1:PersonProfile xmlns:ns2=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/person/\">\r\n" + 
				"            <ns1:PersonProfileId>100000194389169</ns1:PersonProfileId>\r\n" + 
				"            <ns1:PartyId>100000194389169</ns1:PartyId>\r\n" + 
				"            <ns1:PersonName>Saud Hijrif Z Alotaibi</ns1:PersonName>\r\n" + 
				"            <ns1:LastUpdateDate>2018-08-01T06:26:38.376194Z</ns1:LastUpdateDate>\r\n" + 
				"            <ns1:LastUpdatedBy>raj.srinivasan@innovacx.com</ns1:LastUpdatedBy>\r\n" + 
				"            <ns1:CreationDate>2018-07-31T13:32:33.132721Z</ns1:CreationDate>\r\n" + 
				"            <ns1:CreatedBy>raj.srinivasan@innovacx.com</ns1:CreatedBy>\r\n" + 
				"            <ns1:LastUpdateLogin>-1</ns1:LastUpdateLogin>\r\n" + 
				"            <ns1:RequestId>122532</ns1:RequestId>\r\n" + 
				"            <ns1:PersonPreNameAdjunct>Mr.</ns1:PersonPreNameAdjunct>\r\n" + 
				"            <ns1:PersonFirstName>Saud Hijrif Z</ns1:PersonFirstName>\r\n" + 
				"            <ns1:PersonMiddleName xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PersonLastName>Alotaibi</ns1:PersonLastName>\r\n" + 
				"            <ns1:PersonNameSuffix xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PersonTitle xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PersonAcademicTitle xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PersonPreviousLastName xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PersonInitials xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:JgzzFiscalCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:DateOfBirth xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PlaceOfBirth xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:DateOfDeath xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:Gender>MALE</ns1:Gender>\r\n" + 
				"            <ns1:DeclaredEthnicity xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:MaritalStatus xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:MaritalStatusEffectiveDate xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PersonalIncomeAmount xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:RentOwnInd xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:LastKnownGPS xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:EffectiveStartDate>2018-07-31</ns1:EffectiveStartDate>\r\n" + 
				"            <ns1:EffectiveEndDate>4712-12-31</ns1:EffectiveEndDate>\r\n" + 
				"            <ns1:InternalFlag>false</ns1:InternalFlag>\r\n" + 
				"            <ns1:Status>A</ns1:Status>\r\n" + 
				"            <ns1:CreatedByModule>HZ_IMPORT</ns1:CreatedByModule>\r\n" + 
				"            <ns1:DeceasedFlag>false</ns1:DeceasedFlag>\r\n" + 
				"            <ns1:Comments xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PersonLastNamePrefix xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PersonSecondLastName xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PreferredFunctionalCurrency xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:OrigSystem xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:OrigSystemReference>204752</ns1:OrigSystemReference>\r\n" + 
				"            <ns1:EffectiveSequence>1</ns1:EffectiveSequence>\r\n" + 
				"            <ns1:HeadOfHouseholdFlag xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:HouseholdIncomeAmount xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:HouseholdSize xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:EffectiveLatestChange>Y</ns1:EffectiveLatestChange>\r\n" + 
				"            <ns1:SuffixOverriddenFlag>false</ns1:SuffixOverriddenFlag>\r\n" + 
				"            <ns1:UniqueNameSuffix xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:CorpCurrencyCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:CurcyConvRateType xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:CurrencyCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PartyNumber>7402601</ns1:PartyNumber>\r\n" + 
				"            <ns1:Salutation xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:CertReasonCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:CertificationLevel xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PreferredContactMethod xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PreferredContactPersonId xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryAddressLine1 xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryAddressLine2 xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryAddressLine3 xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryAddressLine4 xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:Alias xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryAddressCity xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryAddressCountry>SA</ns1:PrimaryAddressCountry>\r\n" + 
				"            <ns1:PrimaryAddressCounty xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryEmailAddress xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryFormattedAddress>SAUDI ARABIA</ns1:PrimaryFormattedAddress>\r\n" + 
				"            <ns1:PrimaryFormattedPhoneNumber xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryLanguage xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PartyUniqueName>Saud Hijrif Z Alotaibi</ns1:PartyUniqueName>\r\n" + 
				"            <ns1:PrimaryAddressPostalCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PreferredContactEmail xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PreferredContactName xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PreferredContactPhone xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PreferredContactURL xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PreferredName xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PreferredNameId xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryEmailId xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryPhoneAreaCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryPhoneId xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryPhoneCountryCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryPhoneExtension xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryPhoneLineType xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryPhoneNumber xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryPhonePurpose xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryWebId xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:Pronunciation xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryAddressProvince xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryAddressState xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryURL xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:ValidatedFlag>false</ns1:ValidatedFlag>\r\n" + 
				"            <ns1:PrimaryAddressLatitude xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryAddressLongitude xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryAddressLocationId>100000194586272</ns1:PrimaryAddressLocationId>\r\n" + 
				"            <ns1:FavoriteContactFlag>false</ns1:FavoriteContactFlag>\r\n" + 
				"            <ns1:Distance xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:SalesAffinityCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:SalesBuyingRoleCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:DepartmentCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:Department xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:JobTitleCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:JobTitle xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:DoNotCallFlag>false</ns1:DoNotCallFlag>\r\n" + 
				"            <ns1:DoNotContactFlag>false</ns1:DoNotContactFlag>\r\n" + 
				"            <ns1:DoNotEmailFlag>false</ns1:DoNotEmailFlag>\r\n" + 
				"            <ns1:DoNotMailFlag>false</ns1:DoNotMailFlag>\r\n" + 
				"            <ns1:LastContactDate xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryCustomerId xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryCustomerRelationshipId xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryCustomerName xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:LastSourceUpdateDate>2018-08-01T06:23:49.644582Z</ns1:LastSourceUpdateDate>\r\n" + 
				"            <ns1:LastUpdateSourceSystem>LGKTR</ns1:LastUpdateSourceSystem>\r\n" + 
				"            <ns1:DataCloudStatus xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:LastEnrichmentDate xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PersonInformation>\r\n" + 
				"              <ns2:PersonProfileId>100000194389169</ns2:PersonProfileId>\r\n" + 
				"              <ns2:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"              <ns2:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"              <ns2:_FLEX_NumOfSegments>0</ns2:_FLEX_NumOfSegments>\r\n" + 
				"            </ns1:PersonInformation>\r\n" + 
				"            <ns1:Secretary_Id_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:Secretary_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:ChamberMember_c>false</ns1:ChamberMember_c>\r\n" + 
				"            <ns1:Category_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:ContactLevel_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:OtherSalutation_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:SpouseName_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:SecretaryFormulaField_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:LoyaltyMembership_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:Tier_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:LoyaltyMembershipNumber_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:MembershipNumber_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:Passport_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:DateOfBirth_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:ChamberMembershipNumber_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:AccountCity_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:AccountCity1_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:Association_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PANNumber_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:ProfileCreatedAtChannel_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:ProfileCreatedAtProperty_c>LGKTR</ns1:ProfileCreatedAtProperty_c>\r\n" + 
				"            <ns1:ProfileCreatedBy_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:ProfileCreatedDate_c>2018-03-23</ns1:ProfileCreatedDate_c>\r\n" + 
				"            <ns1:ProfileUpdatedBy_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:ProfileUpdatedDate_c>2018-04-06</ns1:ProfileUpdatedDate_c>\r\n" + 
				"            <ns1:NationalityLOV_c>SA</ns1:NationalityLOV_c>\r\n" + 
				"            <ns1:SpouseBirthday_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:AnniversaryDate_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:LegalCompany_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:AadhaarNumber_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:LicenseNumber_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:VIPLOV_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:Profession_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:MUI_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:LastUpdateSource_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:LanguagePreference_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:NotParticipateInMarketRea_c>false</ns1:NotParticipateInMarketRea_c>\r\n" + 
				"            <ns1:NotReceiveEmails_c>false</ns1:NotReceiveEmails_c>\r\n" + 
				"            <ns1:NotInfoFromThirdParty_c>false</ns1:NotInfoFromThirdParty_c>\r\n" + 
				"            <ns1:LicenseIDIssueDate_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PassportIDIssueDate_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:AadhaarIssueDate_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:LicenseIDIssuePlace_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PassportIDIssuePlace_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:AadhaarIssuePlace_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PassportIDExpiryDate_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:WebSite_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrivateWebpage_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:ARNo_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:Restricted_c/>\r\n" + 
				"            <ns1:RestrictRule_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:CYNumber_c>2019</ns1:CYNumber_c>\r\n" + 
				"            <ns1:LYNumber_c>2018</ns1:LYNumber_c>\r\n" + 
				"            <ns1:Days_c>50</ns1:Days_c>\r\n" + 
				"            <ns1:PMSFlag_c/>\r\n" + 
				"            <ns1:PMSLastUpdateSource_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:IAMUpdateFlag_c xsi:nil=\"true\"/>\r\n" + 
				"          </ns1:PersonProfile>\r\n" + 
				"          <ns1:PartyUsageAssignment>\r\n" + 
				"            <ns3:PartyUsgAssignmentId>100000194466757</ns3:PartyUsgAssignmentId>\r\n" + 
				"            <ns3:PartyId>100000194389169</ns3:PartyId>\r\n" + 
				"            <ns3:PartyUsageCode>CONTACT</ns3:PartyUsageCode>\r\n" + 
				"            <ns3:EffectiveStartDate>2018-07-31</ns3:EffectiveStartDate>\r\n" + 
				"            <ns3:EffectiveEndDate>4712-12-31</ns3:EffectiveEndDate>\r\n" + 
				"            <ns3:StatusFlag>true</ns3:StatusFlag>\r\n" + 
				"            <ns3:Comments xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:OwnerTableName xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:OwnerTableId xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:CreatedByModule>HZ_IMPORT</ns3:CreatedByModule>\r\n" + 
				"            <ns3:ObjectVersionNumber>1</ns3:ObjectVersionNumber>\r\n" + 
				"            <ns3:CreatedBy>raj.srinivasan@innovacx.com</ns3:CreatedBy>\r\n" + 
				"            <ns3:CreationDate>2018-07-31T13:32:51.048453Z</ns3:CreationDate>\r\n" + 
				"            <ns3:LastUpdateLogin>-1</ns3:LastUpdateLogin>\r\n" + 
				"            <ns3:LastUpdateDate>2018-07-31T13:32:51.048453Z</ns3:LastUpdateDate>\r\n" + 
				"            <ns3:LastUpdatedBy>raj.srinivasan@innovacx.com</ns3:LastUpdatedBy>\r\n" + 
				"            <ns3:RequestId>122373</ns3:RequestId>\r\n" + 
				"          </ns1:PartyUsageAssignment>\r\n" + 
				"        </ns1:Value>\r\n" + 
				"        <ns1:Value>\r\n" + 
				"          <ns1:PartyId>100000088640991</ns1:PartyId>\r\n" + 
				"          <ns1:PartyNumber>4051031</ns1:PartyNumber>\r\n" + 
				"          <ns1:PartyName>C M Dhananjaya</ns1:PartyName>\r\n" + 
				"          <ns1:PartyType>PERSON</ns1:PartyType>\r\n" + 
				"          <ns1:ValidatedFlag>false</ns1:ValidatedFlag>\r\n" + 
				"          <ns1:LastUpdatedBy>siebelscheduler</ns1:LastUpdatedBy>\r\n" + 
				"          <ns1:LastUpdateLogin>892816F5FF4F7988E0530A67360A5691</ns1:LastUpdateLogin>\r\n" + 
				"          <ns1:CreationDate>2018-06-08T06:28:49.515576Z</ns1:CreationDate>\r\n" + 
				"          <ns1:RequestId>273465</ns1:RequestId>\r\n" + 
				"          <ns1:LastUpdateDate>2019-05-18T10:38:48.359Z</ns1:LastUpdateDate>\r\n" + 
				"          <ns1:CreatedBy>Datacentre</ns1:CreatedBy>\r\n" + 
				"          <ns1:OrigSystemReference>1-4OG-5578</ns1:OrigSystemReference>\r\n" + 
				"          <ns1:SICCode xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:JgzzFiscalCode xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PersonFirstName>C M</ns1:PersonFirstName>\r\n" + 
				"          <ns1:PersonPreNameAdjunct>Mr.</ns1:PersonPreNameAdjunct>\r\n" + 
				"          <ns1:PersonLastName>Dhananjaya</ns1:PersonLastName>\r\n" + 
				"          <ns1:PersonMiddleName xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PersonTitle>Mr.</ns1:PersonTitle>\r\n" + 
				"          <ns1:PersonNameSuffix xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PersonPreviousLastName xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PersonAcademicTitle xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:Country>IN</ns1:Country>\r\n" + 
				"          <ns1:Address2>6Th Cross 1St Stage</ns1:Address2>\r\n" + 
				"          <ns1:Address1>No 255 Sai Krupa</ns1:Address1>\r\n" + 
				"          <ns1:Address4 xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:Address3>Indira Nagar</ns1:Address3>\r\n" + 
				"          <ns1:PostalCode>560038</ns1:PostalCode>\r\n" + 
				"          <ns1:City>BANGALORE</ns1:City>\r\n" + 
				"          <ns1:Province xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:State>KA</ns1:State>\r\n" + 
				"          <ns1:County xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:Status>A</ns1:Status>\r\n" + 
				"          <ns1:URL xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:SICCodeType xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:EmailAddress>cmdlawasociates@yahoo.co.in</ns1:EmailAddress>\r\n" + 
				"          <ns1:GSAIndicatorFlag xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:LanguageName xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:MissionStatement xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:CategoryCode xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:ThirdPartyFlag xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:Salutation xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:CreatedByModule>HZ_IMPORT</ns1:CreatedByModule>\r\n" + 
				"          <ns1:CertReasonCode xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:CertificationLevel xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PrimaryPhonePurpose xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PrimaryPhoneContactPTId>300000907524061</ns1:PrimaryPhoneContactPTId>\r\n" + 
				"          <ns1:PrimaryPhoneCountryCode xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PrimaryPhoneLineType>WORK</ns1:PrimaryPhoneLineType>\r\n" + 
				"          <ns1:PrimaryPhoneNumber>+919845021675</ns1:PrimaryPhoneNumber>\r\n" + 
				"          <ns1:PrimaryPhoneAreaCode xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PreferredContactMethod xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PrimaryPhoneExtension xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:IdenAddrLocationId>100000108571602</ns1:IdenAddrLocationId>\r\n" + 
				"          <ns1:PrimaryEmailContactPTId>300000907524060</ns1:PrimaryEmailContactPTId>\r\n" + 
				"          <ns1:IdenAddrPartySiteId>100000108730752</ns1:IdenAddrPartySiteId>\r\n" + 
				"          <ns1:PersonLastNamePrefix xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PrimaryURLContactPTId xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PreferredName xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PersonSecondLastName xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PreferredNameId xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PreferredContactPersonId xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:InternalFlag>false</ns1:InternalFlag>\r\n" + 
				"          <ns1:PreferredFunctionalCurrency xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:Gender>MALE</ns1:Gender>\r\n" + 
				"          <ns1:MaritalStatus>M</ns1:MaritalStatus>\r\n" + 
				"          <ns1:Comments xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:DateOfBirth>1963-06-07</ns1:DateOfBirth>\r\n" + 
				"          <ns1:UserGUID xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:PartyUniqueName>C M Dhananjaya</ns1:PartyUniqueName>\r\n" + 
				"          <ns1:SourceSystem xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:SourceSystemReferenceValue xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:SourceSystemUpdateDate xsi:nil=\"true\"/>\r\n" + 
				"          <ns1:Email xmlns:ns6=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/contactPoint/\">\r\n" + 
				"            <ns5:ContactPointId>300000911604452</ns5:ContactPointId>\r\n" + 
				"            <ns5:ContactPointType>EMAIL</ns5:ContactPointType>\r\n" + 
				"            <ns5:Status>A</ns5:Status>\r\n" + 
				"            <ns5:OwnerTableName>HZ_PARTIES</ns5:OwnerTableName>\r\n" + 
				"            <ns5:OwnerTableId>100000088640991</ns5:OwnerTableId>\r\n" + 
				"            <ns5:PrimaryFlag>false</ns5:PrimaryFlag>\r\n" + 
				"            <ns5:OrigSystemReference>PP_2019051810362067233</ns5:OrigSystemReference>\r\n" + 
				"            <ns5:LastUpdateDate>2019-05-18T10:38:48.141Z</ns5:LastUpdateDate>\r\n" + 
				"            <ns5:LastUpdatedBy>siebelscheduler</ns5:LastUpdatedBy>\r\n" + 
				"            <ns5:CreationDate>2019-05-18T10:36:26.0Z</ns5:CreationDate>\r\n" + 
				"            <ns5:CreatedBy>pms scheduler</ns5:CreatedBy>\r\n" + 
				"            <ns5:LastUpdateLogin>892816F5FF4F7988E0530A67360A5691</ns5:LastUpdateLogin>\r\n" + 
				"            <ns5:RequestId xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:ObjectVersionNumber>2</ns5:ObjectVersionNumber>\r\n" + 
				"            <ns5:CreatedByModule>HZ_WS</ns5:CreatedByModule>\r\n" + 
				"            <ns5:ContactPointPurpose>EMAIL</ns5:ContactPointPurpose>\r\n" + 
				"            <ns5:PrimaryByPurpose>N</ns5:PrimaryByPurpose>\r\n" + 
				"            <ns5:StartDate>2019-05-18</ns5:StartDate>\r\n" + 
				"            <ns5:EndDate>4712-12-31</ns5:EndDate>\r\n" + 
				"            <ns5:RelationshipId xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PartyUsageCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:OrigSystem xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:EmailFormat/>\r\n" + 
				"            <ns5:EmailAddress>cmdlawasociates@yahoo.co.in</ns5:EmailAddress>\r\n" + 
				"            <ns5:PartyName>C M Dhananjaya</ns5:PartyName>\r\n" + 
				"            <ns5:OverallPrimaryFlag>false</ns5:OverallPrimaryFlag>\r\n" + 
				"            <ns5:OriginalSystemReference xmlns:ns4=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/sourceSystemRef/\">\r\n" + 
				"              <ns3:OrigSystemReferenceId>300000911604455</ns3:OrigSystemReferenceId>\r\n" + 
				"              <ns3:OrigSystem>PMS</ns3:OrigSystem>\r\n" + 
				"              <ns3:OrigSystemReference>PP_2019051810362067233</ns3:OrigSystemReference>\r\n" + 
				"              <ns3:OwnerTableName>HZ_CONTACT_POINTS</ns3:OwnerTableName>\r\n" + 
				"              <ns3:OwnerTableId>300000911604452</ns3:OwnerTableId>\r\n" + 
				"              <ns3:Status>A</ns3:Status>\r\n" + 
				"              <ns3:ReasonCode xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:OldOrigSystemReference xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:StartDateActive>2019-05-18</ns3:StartDateActive>\r\n" + 
				"              <ns3:EndDateActive>4712-12-31</ns3:EndDateActive>\r\n" + 
				"              <ns3:CreatedBy>pms scheduler</ns3:CreatedBy>\r\n" + 
				"              <ns3:CreationDate>2019-05-18T10:36:26.156Z</ns3:CreationDate>\r\n" + 
				"              <ns3:LastUpdatedBy>pms scheduler</ns3:LastUpdatedBy>\r\n" + 
				"              <ns3:LastUpdateDate>2019-05-18T10:36:26.404Z</ns3:LastUpdateDate>\r\n" + 
				"              <ns3:LastUpdateLogin>8926CAD6B4FB226DE0530A67360AD46C</ns3:LastUpdateLogin>\r\n" + 
				"              <ns3:ObjectVersionNumber>1</ns3:ObjectVersionNumber>\r\n" + 
				"              <ns3:CreatedByModule>HZ_WS</ns3:CreatedByModule>\r\n" + 
				"              <ns3:PartyId>100000088640991</ns3:PartyId>\r\n" + 
				"              <ns3:RequestId xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:SourceSystemRefInformation>\r\n" + 
				"                <ns4:OrigSystemRefId>300000911604455</ns4:OrigSystemRefId>\r\n" + 
				"                <ns4:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"                <ns4:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"                <ns4:_FLEX_NumOfSegments>0</ns4:_FLEX_NumOfSegments>\r\n" + 
				"              </ns3:SourceSystemRefInformation>\r\n" + 
				"            </ns5:OriginalSystemReference>\r\n" + 
				"            <ns5:EmailInformation>\r\n" + 
				"              <ns6:ContactPointId>300000911604452</ns6:ContactPointId>\r\n" + 
				"              <ns6:ContactPointType>EMAIL</ns6:ContactPointType>\r\n" + 
				"              <ns6:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"              <ns6:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"              <ns6:_FLEX_NumOfSegments>0</ns6:_FLEX_NumOfSegments>\r\n" + 
				"            </ns5:EmailInformation>\r\n" + 
				"          </ns1:Email>\r\n" + 
				"          <ns1:Email xmlns:ns6=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/contactPoint/\">\r\n" + 
				"            <ns5:ContactPointId>100000110595887</ns5:ContactPointId>\r\n" + 
				"            <ns5:ContactPointType>EMAIL</ns5:ContactPointType>\r\n" + 
				"            <ns5:Status>A</ns5:Status>\r\n" + 
				"            <ns5:OwnerTableName>HZ_PARTIES</ns5:OwnerTableName>\r\n" + 
				"            <ns5:OwnerTableId>100000088640991</ns5:OwnerTableId>\r\n" + 
				"            <ns5:PrimaryFlag>false</ns5:PrimaryFlag>\r\n" + 
				"            <ns5:OrigSystemReference xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:LastUpdateDate>2019-01-09T08:44:17.596803Z</ns5:LastUpdateDate>\r\n" + 
				"            <ns5:LastUpdatedBy>FUSION_APPS_CRM_ESS_APPID</ns5:LastUpdatedBy>\r\n" + 
				"            <ns5:CreationDate>2018-06-12T08:03:48.386661Z</ns5:CreationDate>\r\n" + 
				"            <ns5:CreatedBy>Datacentre</ns5:CreatedBy>\r\n" + 
				"            <ns5:LastUpdateLogin>7EFC90018141CEE6E0530A67360AE51C</ns5:LastUpdateLogin>\r\n" + 
				"            <ns5:RequestId>273465</ns5:RequestId>\r\n" + 
				"            <ns5:ObjectVersionNumber>4</ns5:ObjectVersionNumber>\r\n" + 
				"            <ns5:CreatedByModule>HZ_IMPORT</ns5:CreatedByModule>\r\n" + 
				"            <ns5:ContactPointPurpose>HOME-EMAIL</ns5:ContactPointPurpose>\r\n" + 
				"            <ns5:PrimaryByPurpose>N</ns5:PrimaryByPurpose>\r\n" + 
				"            <ns5:StartDate>2018-06-12</ns5:StartDate>\r\n" + 
				"            <ns5:EndDate>4712-12-31</ns5:EndDate>\r\n" + 
				"            <ns5:RelationshipId xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PartyUsageCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:OrigSystem xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:EmailFormat/>\r\n" + 
				"            <ns5:EmailAddress>cmdlawasociates@yahoo.co.in</ns5:EmailAddress>\r\n" + 
				"            <ns5:PartyName>C M Dhananjaya</ns5:PartyName>\r\n" + 
				"            <ns5:OverallPrimaryFlag>false</ns5:OverallPrimaryFlag>\r\n" + 
				"            <ns5:OriginalSystemReference xmlns:ns4=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/sourceSystemRef/\">\r\n" + 
				"              <ns3:OrigSystemReferenceId>100000110942105</ns3:OrigSystemReferenceId>\r\n" + 
				"              <ns3:OrigSystem>SIEBEL</ns3:OrigSystem>\r\n" + 
				"              <ns3:OrigSystemReference>300000404230682</ns3:OrigSystemReference>\r\n" + 
				"              <ns3:OwnerTableName>HZ_CONTACT_POINTS</ns3:OwnerTableName>\r\n" + 
				"              <ns3:OwnerTableId>100000110595887</ns3:OwnerTableId>\r\n" + 
				"              <ns3:Status>A</ns3:Status>\r\n" + 
				"              <ns3:ReasonCode xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:OldOrigSystemReference xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:StartDateActive>2018-06-12</ns3:StartDateActive>\r\n" + 
				"              <ns3:EndDateActive>4712-12-31</ns3:EndDateActive>\r\n" + 
				"              <ns3:CreatedBy>Datacentre</ns3:CreatedBy>\r\n" + 
				"              <ns3:CreationDate>2018-06-12T08:04:23.961991Z</ns3:CreationDate>\r\n" + 
				"              <ns3:LastUpdatedBy>Datacentre</ns3:LastUpdatedBy>\r\n" + 
				"              <ns3:LastUpdateDate>2018-06-12T08:04:23.961991Z</ns3:LastUpdateDate>\r\n" + 
				"              <ns3:LastUpdateLogin>-1</ns3:LastUpdateLogin>\r\n" + 
				"              <ns3:ObjectVersionNumber>1</ns3:ObjectVersionNumber>\r\n" + 
				"              <ns3:CreatedByModule>HZ_IMPORT</ns3:CreatedByModule>\r\n" + 
				"              <ns3:PartyId>100000088640991</ns3:PartyId>\r\n" + 
				"              <ns3:RequestId>-99999</ns3:RequestId>\r\n" + 
				"              <ns3:SourceSystemRefInformation>\r\n" + 
				"                <ns4:OrigSystemRefId>100000110942105</ns4:OrigSystemRefId>\r\n" + 
				"                <ns4:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"                <ns4:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"                <ns4:_FLEX_NumOfSegments>0</ns4:_FLEX_NumOfSegments>\r\n" + 
				"              </ns3:SourceSystemRefInformation>\r\n" + 
				"            </ns5:OriginalSystemReference>\r\n" + 
				"            <ns5:OriginalSystemReference xmlns:ns4=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/sourceSystemRef/\">\r\n" + 
				"              <ns3:OrigSystemReferenceId>300000758850348</ns3:OrigSystemReferenceId>\r\n" + 
				"              <ns3:OrigSystem>PMS</ns3:OrigSystem>\r\n" + 
				"              <ns3:OrigSystemReference>2018112812244993442</ns3:OrigSystemReference>\r\n" + 
				"              <ns3:OwnerTableName>HZ_CONTACT_POINTS</ns3:OwnerTableName>\r\n" + 
				"              <ns3:OwnerTableId>100000110595887</ns3:OwnerTableId>\r\n" + 
				"              <ns3:Status>A</ns3:Status>\r\n" + 
				"              <ns3:ReasonCode xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:OldOrigSystemReference xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:StartDateActive>2018-11-28</ns3:StartDateActive>\r\n" + 
				"              <ns3:EndDateActive>4712-12-31</ns3:EndDateActive>\r\n" + 
				"              <ns3:CreatedBy>Datacentre</ns3:CreatedBy>\r\n" + 
				"              <ns3:CreationDate>2018-11-28T12:24:54.117Z</ns3:CreationDate>\r\n" + 
				"              <ns3:LastUpdatedBy>FUSION_APPS_CRM_ESS_APPID</ns3:LastUpdatedBy>\r\n" + 
				"              <ns3:LastUpdateDate>2019-01-09T08:44:17.079811Z</ns3:LastUpdateDate>\r\n" + 
				"              <ns3:LastUpdateLogin>7EFC90018141CEE6E0530A67360AE51C</ns3:LastUpdateLogin>\r\n" + 
				"              <ns3:ObjectVersionNumber>2</ns3:ObjectVersionNumber>\r\n" + 
				"              <ns3:CreatedByModule>HZ_WS</ns3:CreatedByModule>\r\n" + 
				"              <ns3:PartyId>300000758851104</ns3:PartyId>\r\n" + 
				"              <ns3:RequestId>273465</ns3:RequestId>\r\n" + 
				"              <ns3:SourceSystemRefInformation>\r\n" + 
				"                <ns4:OrigSystemRefId>300000758850348</ns4:OrigSystemRefId>\r\n" + 
				"                <ns4:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"                <ns4:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"                <ns4:_FLEX_NumOfSegments>0</ns4:_FLEX_NumOfSegments>\r\n" + 
				"              </ns3:SourceSystemRefInformation>\r\n" + 
				"            </ns5:OriginalSystemReference>\r\n" + 
				"            <ns5:EmailInformation>\r\n" + 
				"              <ns6:ContactPointId>100000110595887</ns6:ContactPointId>\r\n" + 
				"              <ns6:ContactPointType>EMAIL</ns6:ContactPointType>\r\n" + 
				"              <ns6:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"              <ns6:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"              <ns6:_FLEX_NumOfSegments>0</ns6:_FLEX_NumOfSegments>\r\n" + 
				"            </ns5:EmailInformation>\r\n" + 
				"          </ns1:Email>\r\n" + 
				"          <ns1:Email xmlns:ns6=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/contactPoint/\">\r\n" + 
				"            <ns5:ContactPointId>300000907524060</ns5:ContactPointId>\r\n" + 
				"            <ns5:ContactPointType>EMAIL</ns5:ContactPointType>\r\n" + 
				"            <ns5:Status>A</ns5:Status>\r\n" + 
				"            <ns5:OwnerTableName>HZ_PARTIES</ns5:OwnerTableName>\r\n" + 
				"            <ns5:OwnerTableId>100000088640991</ns5:OwnerTableId>\r\n" + 
				"            <ns5:PrimaryFlag>true</ns5:PrimaryFlag>\r\n" + 
				"            <ns5:OrigSystemReference>SP_1-T59E-31</ns5:OrigSystemReference>\r\n" + 
				"            <ns5:LastUpdateDate>2019-05-18T10:38:48.132Z</ns5:LastUpdateDate>\r\n" + 
				"            <ns5:LastUpdatedBy>siebelscheduler</ns5:LastUpdatedBy>\r\n" + 
				"            <ns5:CreationDate>2019-05-06T20:42:34.001Z</ns5:CreationDate>\r\n" + 
				"            <ns5:CreatedBy>siebelscheduler</ns5:CreatedBy>\r\n" + 
				"            <ns5:LastUpdateLogin>892816F5FF4F7988E0530A67360A5691</ns5:LastUpdateLogin>\r\n" + 
				"            <ns5:RequestId xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:ObjectVersionNumber>3</ns5:ObjectVersionNumber>\r\n" + 
				"            <ns5:CreatedByModule>HZ_WS</ns5:CreatedByModule>\r\n" + 
				"            <ns5:ContactPointPurpose>HOME-EMAIL</ns5:ContactPointPurpose>\r\n" + 
				"            <ns5:PrimaryByPurpose>N</ns5:PrimaryByPurpose>\r\n" + 
				"            <ns5:StartDate>2019-05-06</ns5:StartDate>\r\n" + 
				"            <ns5:EndDate>4712-12-31</ns5:EndDate>\r\n" + 
				"            <ns5:RelationshipId xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PartyUsageCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:OrigSystem xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:EmailFormat/>\r\n" + 
				"            <ns5:EmailAddress>cmdlawasociates@yahoo.co.in</ns5:EmailAddress>\r\n" + 
				"            <ns5:PartyName>C M Dhananjaya</ns5:PartyName>\r\n" + 
				"            <ns5:OverallPrimaryFlag>true</ns5:OverallPrimaryFlag>\r\n" + 
				"            <ns5:EmailInformation>\r\n" + 
				"              <ns6:ContactPointId>300000907524060</ns6:ContactPointId>\r\n" + 
				"              <ns6:ContactPointType>EMAIL</ns6:ContactPointType>\r\n" + 
				"              <ns6:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"              <ns6:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"              <ns6:_FLEX_NumOfSegments>0</ns6:_FLEX_NumOfSegments>\r\n" + 
				"            </ns5:EmailInformation>\r\n" + 
				"          </ns1:Email>\r\n" + 
				"          <ns1:Email xmlns:ns6=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/contactPoint/\">\r\n" + 
				"            <ns5:ContactPointId>300000675276165</ns5:ContactPointId>\r\n" + 
				"            <ns5:ContactPointType>EMAIL</ns5:ContactPointType>\r\n" + 
				"            <ns5:Status>A</ns5:Status>\r\n" + 
				"            <ns5:OwnerTableName>HZ_PARTIES</ns5:OwnerTableName>\r\n" + 
				"            <ns5:OwnerTableId>100000088640991</ns5:OwnerTableId>\r\n" + 
				"            <ns5:PrimaryFlag>false</ns5:PrimaryFlag>\r\n" + 
				"            <ns5:OrigSystemReference>1-817V6WP</ns5:OrigSystemReference>\r\n" + 
				"            <ns5:LastUpdateDate>2019-05-06T20:42:34.153Z</ns5:LastUpdateDate>\r\n" + 
				"            <ns5:LastUpdatedBy>siebelscheduler</ns5:LastUpdatedBy>\r\n" + 
				"            <ns5:CreationDate>2018-08-30T06:30:14.001Z</ns5:CreationDate>\r\n" + 
				"            <ns5:CreatedBy>Datacentre</ns5:CreatedBy>\r\n" + 
				"            <ns5:LastUpdateLogin>883CDF95985ABF2BE0530A67360A76C2</ns5:LastUpdateLogin>\r\n" + 
				"            <ns5:RequestId>273465</ns5:RequestId>\r\n" + 
				"            <ns5:ObjectVersionNumber>3</ns5:ObjectVersionNumber>\r\n" + 
				"            <ns5:CreatedByModule>HZ_WS</ns5:CreatedByModule>\r\n" + 
				"            <ns5:ContactPointPurpose>HOME-EMAIL</ns5:ContactPointPurpose>\r\n" + 
				"            <ns5:PrimaryByPurpose>N</ns5:PrimaryByPurpose>\r\n" + 
				"            <ns5:StartDate>2018-08-30</ns5:StartDate>\r\n" + 
				"            <ns5:EndDate>4712-12-31</ns5:EndDate>\r\n" + 
				"            <ns5:RelationshipId xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PartyUsageCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:OrigSystem xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:EmailFormat/>\r\n" + 
				"            <ns5:EmailAddress>cmdlawassociates@yahoo.co.in</ns5:EmailAddress>\r\n" + 
				"            <ns5:PartyName>C M Dhananjaya</ns5:PartyName>\r\n" + 
				"            <ns5:OverallPrimaryFlag>false</ns5:OverallPrimaryFlag>\r\n" + 
				"            <ns5:EmailInformation>\r\n" + 
				"              <ns6:ContactPointId>300000675276165</ns6:ContactPointId>\r\n" + 
				"              <ns6:ContactPointType>EMAIL</ns6:ContactPointType>\r\n" + 
				"              <ns6:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"              <ns6:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"              <ns6:_FLEX_NumOfSegments>0</ns6:_FLEX_NumOfSegments>\r\n" + 
				"            </ns5:EmailInformation>\r\n" + 
				"          </ns1:Email>\r\n" + 
				"          <ns1:Email xmlns:ns6=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/contactPoint/\">\r\n" + 
				"            <ns5:ContactPointId>300000911602425</ns5:ContactPointId>\r\n" + 
				"            <ns5:ContactPointType>EMAIL</ns5:ContactPointType>\r\n" + 
				"            <ns5:Status>A</ns5:Status>\r\n" + 
				"            <ns5:OwnerTableName>HZ_PARTIES</ns5:OwnerTableName>\r\n" + 
				"            <ns5:OwnerTableId>100000088640991</ns5:OwnerTableId>\r\n" + 
				"            <ns5:PrimaryFlag>false</ns5:PrimaryFlag>\r\n" + 
				"            <ns5:OrigSystemReference>SP_1-B37D6MI</ns5:OrigSystemReference>\r\n" + 
				"            <ns5:LastUpdateDate>2019-05-18T10:38:48.274Z</ns5:LastUpdateDate>\r\n" + 
				"            <ns5:LastUpdatedBy>siebelscheduler</ns5:LastUpdatedBy>\r\n" + 
				"            <ns5:CreationDate>2019-05-18T10:38:48.001Z</ns5:CreationDate>\r\n" + 
				"            <ns5:CreatedBy>siebelscheduler</ns5:CreatedBy>\r\n" + 
				"            <ns5:LastUpdateLogin>892816F5FF4F7988E0530A67360A5691</ns5:LastUpdateLogin>\r\n" + 
				"            <ns5:RequestId xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:ObjectVersionNumber>1</ns5:ObjectVersionNumber>\r\n" + 
				"            <ns5:CreatedByModule>HZ_WS</ns5:CreatedByModule>\r\n" + 
				"            <ns5:ContactPointPurpose>HOME-EMAIL</ns5:ContactPointPurpose>\r\n" + 
				"            <ns5:PrimaryByPurpose>N</ns5:PrimaryByPurpose>\r\n" + 
				"            <ns5:StartDate>2019-05-18</ns5:StartDate>\r\n" + 
				"            <ns5:EndDate>4712-12-31</ns5:EndDate>\r\n" + 
				"            <ns5:RelationshipId xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PartyUsageCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:OrigSystem xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:EmailFormat/>\r\n" + 
				"            <ns5:EmailAddress>cmdlawassociates@yahoo.co.in</ns5:EmailAddress>\r\n" + 
				"            <ns5:PartyName>C M Dhananjaya</ns5:PartyName>\r\n" + 
				"            <ns5:OverallPrimaryFlag>false</ns5:OverallPrimaryFlag>\r\n" + 
				"            <ns5:EmailInformation>\r\n" + 
				"              <ns6:ContactPointId>300000911602425</ns6:ContactPointId>\r\n" + 
				"              <ns6:ContactPointType>EMAIL</ns6:ContactPointType>\r\n" + 
				"              <ns6:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"              <ns6:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"              <ns6:_FLEX_NumOfSegments>0</ns6:_FLEX_NumOfSegments>\r\n" + 
				"            </ns5:EmailInformation>\r\n" + 
				"          </ns1:Email>\r\n" + 
				"          <ns1:OriginalSystemReference xmlns:ns4=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/sourceSystemRef/\">\r\n" + 
				"            <ns3:OrigSystemReferenceId>100000088954722</ns3:OrigSystemReferenceId>\r\n" + 
				"            <ns3:OrigSystem>SIEBEL</ns3:OrigSystem>\r\n" + 
				"            <ns3:OrigSystemReference>1-4OG-5578</ns3:OrigSystemReference>\r\n" + 
				"            <ns3:OwnerTableName>HZ_PARTIES</ns3:OwnerTableName>\r\n" + 
				"            <ns3:OwnerTableId>100000088640991</ns3:OwnerTableId>\r\n" + 
				"            <ns3:Status>A</ns3:Status>\r\n" + 
				"            <ns3:ReasonCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:OldOrigSystemReference xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:StartDateActive>2018-06-08</ns3:StartDateActive>\r\n" + 
				"            <ns3:EndDateActive>4712-12-31</ns3:EndDateActive>\r\n" + 
				"            <ns3:CreatedBy>Datacentre</ns3:CreatedBy>\r\n" + 
				"            <ns3:CreationDate>2018-06-08T06:28:10.694557Z</ns3:CreationDate>\r\n" + 
				"            <ns3:LastUpdatedBy>Datacentre</ns3:LastUpdatedBy>\r\n" + 
				"            <ns3:LastUpdateDate>2018-06-08T06:28:10.694557Z</ns3:LastUpdateDate>\r\n" + 
				"            <ns3:LastUpdateLogin>-1</ns3:LastUpdateLogin>\r\n" + 
				"            <ns3:ObjectVersionNumber>1</ns3:ObjectVersionNumber>\r\n" + 
				"            <ns3:CreatedByModule>HZ_IMPORT</ns3:CreatedByModule>\r\n" + 
				"            <ns3:PartyId>100000088640991</ns3:PartyId>\r\n" + 
				"            <ns3:RequestId>74571</ns3:RequestId>\r\n" + 
				"            <ns3:SourceSystemRefInformation>\r\n" + 
				"              <ns4:OrigSystemRefId>100000088954722</ns4:OrigSystemRefId>\r\n" + 
				"              <ns4:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"              <ns4:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"              <ns4:_FLEX_NumOfSegments>0</ns4:_FLEX_NumOfSegments>\r\n" + 
				"            </ns3:SourceSystemRefInformation>\r\n" + 
				"          </ns1:OriginalSystemReference>\r\n" + 
				"          <ns1:OriginalSystemReference xmlns:ns4=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/sourceSystemRef/\">\r\n" + 
				"            <ns3:OrigSystemReferenceId>300000758851109</ns3:OrigSystemReferenceId>\r\n" + 
				"            <ns3:OrigSystem>DXBTD</ns3:OrigSystem>\r\n" + 
				"            <ns3:OrigSystemReference>204752</ns3:OrigSystemReference>\r\n" + 
				"            <ns3:OwnerTableName>HZ_PARTIES</ns3:OwnerTableName>\r\n" + 
				"            <ns3:OwnerTableId>100000088640991</ns3:OwnerTableId>\r\n" + 
				"            <ns3:Status>A</ns3:Status>\r\n" + 
				"            <ns3:ReasonCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:OldOrigSystemReference xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:StartDateActive>2018-11-28</ns3:StartDateActive>\r\n" + 
				"            <ns3:EndDateActive>4712-12-31</ns3:EndDateActive>\r\n" + 
				"            <ns3:CreatedBy>Datacentre</ns3:CreatedBy>\r\n" + 
				"            <ns3:CreationDate>2018-11-28T12:24:50.031Z</ns3:CreationDate>\r\n" + 
				"            <ns3:LastUpdatedBy>FUSION_APPS_CRM_ESS_APPID</ns3:LastUpdatedBy>\r\n" + 
				"            <ns3:LastUpdateDate>2019-01-09T08:44:13.453445Z</ns3:LastUpdateDate>\r\n" + 
				"            <ns3:LastUpdateLogin>7EFC90018141CEE6E0530A67360AE51C</ns3:LastUpdateLogin>\r\n" + 
				"            <ns3:ObjectVersionNumber>3</ns3:ObjectVersionNumber>\r\n" + 
				"            <ns3:CreatedByModule>HZ_WS</ns3:CreatedByModule>\r\n" + 
				"            <ns3:PartyId>300000758851104</ns3:PartyId>\r\n" + 
				"            <ns3:RequestId>273465</ns3:RequestId>\r\n" + 
				"            <ns3:SourceSystemRefInformation>\r\n" + 
				"              <ns4:OrigSystemRefId>300000758851109</ns4:OrigSystemRefId>\r\n" + 
				"              <ns4:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"              <ns4:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"              <ns4:_FLEX_NumOfSegments>0</ns4:_FLEX_NumOfSegments>\r\n" + 
				"            </ns3:SourceSystemRefInformation>\r\n" + 
				"          </ns1:OriginalSystemReference>\r\n" + 
				"          <ns1:PartySite xmlns:ns7=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/partySite/\">\r\n" + 
				"            <ns3:PartySiteId>100000108730751</ns3:PartySiteId>\r\n" + 
				"            <ns3:PartyId>100000088640991</ns3:PartyId>\r\n" + 
				"            <ns3:LocationId>100000108571601</ns3:LocationId>\r\n" + 
				"            <ns3:LastUpdateDate>2019-01-09T08:44:15.478225Z</ns3:LastUpdateDate>\r\n" + 
				"            <ns3:PartySiteNumber>4626853</ns3:PartySiteNumber>\r\n" + 
				"            <ns3:LastUpdatedBy>FUSION_APPS_CRM_ESS_APPID</ns3:LastUpdatedBy>\r\n" + 
				"            <ns3:CreationDate>2018-06-11T23:22:37.196598Z</ns3:CreationDate>\r\n" + 
				"            <ns3:CreatedBy>Datacentre</ns3:CreatedBy>\r\n" + 
				"            <ns3:LastUpdateLogin>7EFC90018141CEE6E0530A67360AE51C</ns3:LastUpdateLogin>\r\n" + 
				"            <ns3:RequestId>273465</ns3:RequestId>\r\n" + 
				"            <ns3:OrigSystemReference/>\r\n" + 
				"            <ns3:StartDateActive>2018-06-11</ns3:StartDateActive>\r\n" + 
				"            <ns3:EndDateActive>4712-12-31</ns3:EndDateActive>\r\n" + 
				"            <ns3:Mailstop xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:IdentifyingAddressFlag>false</ns3:IdentifyingAddressFlag>\r\n" + 
				"            <ns3:Language xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:Status>A</ns3:Status>\r\n" + 
				"            <ns3:PartySiteName xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:Addressee xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:ObjectVersionNumber>3</ns3:ObjectVersionNumber>\r\n" + 
				"            <ns3:CreatedByModule>HZ_IMPORT</ns3:CreatedByModule>\r\n" + 
				"            <ns3:GlobalLocationNumber xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:DUNSNumberC xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:Comments xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:PartySiteType xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:PartyNameDba xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:PartyNameDivision xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:PartyNameLegal xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:RelationshipId xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:PartyUsageCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:OverallPrimaryFlag>false</ns3:OverallPrimaryFlag>\r\n" + 
				"            <ns3:PartySiteUse>\r\n" + 
				"              <ns3:PartySiteUseId>300000675276162</ns3:PartySiteUseId>\r\n" + 
				"              <ns3:BeginDate>2018-08-30</ns3:BeginDate>\r\n" + 
				"              <ns3:Comments xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:EndDate>4712-12-31</ns3:EndDate>\r\n" + 
				"              <ns3:PartySiteId>100000108730751</ns3:PartySiteId>\r\n" + 
				"              <ns3:LastUpdateDate>2019-01-09T08:44:15.663996Z</ns3:LastUpdateDate>\r\n" + 
				"              <ns3:RequestId>273465</ns3:RequestId>\r\n" + 
				"              <ns3:LastUpdatedBy>FUSION_APPS_CRM_ESS_APPID</ns3:LastUpdatedBy>\r\n" + 
				"              <ns3:CreationDate>2018-08-30T06:30:13.001Z</ns3:CreationDate>\r\n" + 
				"              <ns3:CreatedBy>Datacentre</ns3:CreatedBy>\r\n" + 
				"              <ns3:LastUpdateLogin>7EFC90018141CEE6E0530A67360AE51C</ns3:LastUpdateLogin>\r\n" + 
				"              <ns3:IntegrationKey xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:SiteUseType>HOME</ns3:SiteUseType>\r\n" + 
				"              <ns3:PrimaryPerType>N</ns3:PrimaryPerType>\r\n" + 
				"              <ns3:Status>A</ns3:Status>\r\n" + 
				"              <ns3:ObjectVersionNumber>2</ns3:ObjectVersionNumber>\r\n" + 
				"              <ns3:CreatedByModule>HZ_WS</ns3:CreatedByModule>\r\n" + 
				"            </ns3:PartySiteUse>\r\n" + 
				"            <ns3:OriginalSystemReference xmlns:ns4=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/sourceSystemRef/\">\r\n" + 
				"              <ns3:OrigSystemReferenceId>100000110124163</ns3:OrigSystemReferenceId>\r\n" + 
				"              <ns3:OrigSystem>SIEBEL</ns3:OrigSystem>\r\n" + 
				"              <ns3:OrigSystemReference>1-1LS-586</ns3:OrigSystemReference>\r\n" + 
				"              <ns3:OwnerTableName>HZ_PARTY_SITES</ns3:OwnerTableName>\r\n" + 
				"              <ns3:OwnerTableId>100000108730751</ns3:OwnerTableId>\r\n" + 
				"              <ns3:Status>A</ns3:Status>\r\n" + 
				"              <ns3:ReasonCode xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:OldOrigSystemReference xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:StartDateActive>2018-06-11</ns3:StartDateActive>\r\n" + 
				"              <ns3:EndDateActive>4712-12-31</ns3:EndDateActive>\r\n" + 
				"              <ns3:CreatedBy>Datacentre</ns3:CreatedBy>\r\n" + 
				"              <ns3:CreationDate>2018-06-11T23:23:30.3611Z</ns3:CreationDate>\r\n" + 
				"              <ns3:LastUpdatedBy>Datacentre</ns3:LastUpdatedBy>\r\n" + 
				"              <ns3:LastUpdateDate>2018-06-11T23:23:30.3611Z</ns3:LastUpdateDate>\r\n" + 
				"              <ns3:LastUpdateLogin>-1</ns3:LastUpdateLogin>\r\n" + 
				"              <ns3:ObjectVersionNumber>1</ns3:ObjectVersionNumber>\r\n" + 
				"              <ns3:CreatedByModule>HZ_IMPORT</ns3:CreatedByModule>\r\n" + 
				"              <ns3:PartyId>100000088640991</ns3:PartyId>\r\n" + 
				"              <ns3:RequestId xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:SourceSystemRefInformation>\r\n" + 
				"                <ns4:OrigSystemRefId>100000110124163</ns4:OrigSystemRefId>\r\n" + 
				"                <ns4:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"                <ns4:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"                <ns4:_FLEX_NumOfSegments>0</ns4:_FLEX_NumOfSegments>\r\n" + 
				"              </ns3:SourceSystemRefInformation>\r\n" + 
				"            </ns3:OriginalSystemReference>\r\n" + 
				"            <ns3:PersonPartySiteInformation>\r\n" + 
				"              <ns7:PartySiteId>100000108730751</ns7:PartySiteId>\r\n" + 
				"              <ns7:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"              <ns7:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"              <ns7:_FLEX_NumOfSegments>0</ns7:_FLEX_NumOfSegments>\r\n" + 
				"            </ns3:PersonPartySiteInformation>\r\n" + 
				"          </ns1:PartySite>\r\n" + 
				"          <ns1:PartySite xmlns:ns7=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/partySite/\">\r\n" + 
				"            <ns3:PartySiteId>100000108730753</ns3:PartySiteId>\r\n" + 
				"            <ns3:PartyId>100000088640991</ns3:PartyId>\r\n" + 
				"            <ns3:LocationId>100000108571603</ns3:LocationId>\r\n" + 
				"            <ns3:LastUpdateDate>2019-05-06T13:35:55.165Z</ns3:LastUpdateDate>\r\n" + 
				"            <ns3:PartySiteNumber>4626855</ns3:PartySiteNumber>\r\n" + 
				"            <ns3:LastUpdatedBy>siebelscheduler</ns3:LastUpdatedBy>\r\n" + 
				"            <ns3:CreationDate>2018-06-11T23:22:37.196598Z</ns3:CreationDate>\r\n" + 
				"            <ns3:CreatedBy>Datacentre</ns3:CreatedBy>\r\n" + 
				"            <ns3:LastUpdateLogin>88392C81B14F29B3E0530867360A5B75</ns3:LastUpdateLogin>\r\n" + 
				"            <ns3:RequestId>273465</ns3:RequestId>\r\n" + 
				"            <ns3:OrigSystemReference/>\r\n" + 
				"            <ns3:StartDateActive>2018-06-11</ns3:StartDateActive>\r\n" + 
				"            <ns3:EndDateActive>4712-12-31</ns3:EndDateActive>\r\n" + 
				"            <ns3:Mailstop xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:IdentifyingAddressFlag>false</ns3:IdentifyingAddressFlag>\r\n" + 
				"            <ns3:Language xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:Status>A</ns3:Status>\r\n" + 
				"            <ns3:PartySiteName xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:Addressee xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:ObjectVersionNumber>3</ns3:ObjectVersionNumber>\r\n" + 
				"            <ns3:CreatedByModule>HZ_IMPORT</ns3:CreatedByModule>\r\n" + 
				"            <ns3:GlobalLocationNumber xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:DUNSNumberC xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:Comments xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:PartySiteType xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:PartyNameDba xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:PartyNameDivision xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:PartyNameLegal xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:RelationshipId xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:PartyUsageCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:OverallPrimaryFlag>false</ns3:OverallPrimaryFlag>\r\n" + 
				"            <ns3:OriginalSystemReference xmlns:ns4=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/sourceSystemRef/\">\r\n" + 
				"              <ns3:OrigSystemReferenceId>100000110124165</ns3:OrigSystemReferenceId>\r\n" + 
				"              <ns3:OrigSystem>SIEBEL</ns3:OrigSystem>\r\n" + 
				"              <ns3:OrigSystemReference>1-1RC-2019</ns3:OrigSystemReference>\r\n" + 
				"              <ns3:OwnerTableName>HZ_PARTY_SITES</ns3:OwnerTableName>\r\n" + 
				"              <ns3:OwnerTableId>100000108730753</ns3:OwnerTableId>\r\n" + 
				"              <ns3:Status>A</ns3:Status>\r\n" + 
				"              <ns3:ReasonCode xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:OldOrigSystemReference xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:StartDateActive>2018-06-11</ns3:StartDateActive>\r\n" + 
				"              <ns3:EndDateActive>4712-12-31</ns3:EndDateActive>\r\n" + 
				"              <ns3:CreatedBy>Datacentre</ns3:CreatedBy>\r\n" + 
				"              <ns3:CreationDate>2018-06-11T23:23:30.3611Z</ns3:CreationDate>\r\n" + 
				"              <ns3:LastUpdatedBy>Datacentre</ns3:LastUpdatedBy>\r\n" + 
				"              <ns3:LastUpdateDate>2018-06-11T23:23:30.3611Z</ns3:LastUpdateDate>\r\n" + 
				"              <ns3:LastUpdateLogin>-1</ns3:LastUpdateLogin>\r\n" + 
				"              <ns3:ObjectVersionNumber>1</ns3:ObjectVersionNumber>\r\n" + 
				"              <ns3:CreatedByModule>HZ_IMPORT</ns3:CreatedByModule>\r\n" + 
				"              <ns3:PartyId>100000088640991</ns3:PartyId>\r\n" + 
				"              <ns3:RequestId xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:SourceSystemRefInformation>\r\n" + 
				"                <ns4:OrigSystemRefId>100000110124165</ns4:OrigSystemRefId>\r\n" + 
				"                <ns4:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"                <ns4:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"                <ns4:_FLEX_NumOfSegments>0</ns4:_FLEX_NumOfSegments>\r\n" + 
				"              </ns3:SourceSystemRefInformation>\r\n" + 
				"            </ns3:OriginalSystemReference>\r\n" + 
				"            <ns3:PersonPartySiteInformation>\r\n" + 
				"              <ns7:PartySiteId>100000108730753</ns7:PartySiteId>\r\n" + 
				"              <ns7:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"              <ns7:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"              <ns7:_FLEX_NumOfSegments>0</ns7:_FLEX_NumOfSegments>\r\n" + 
				"            </ns3:PersonPartySiteInformation>\r\n" + 
				"          </ns1:PartySite>\r\n" + 
				"          <ns1:PartySite xmlns:ns7=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/partySite/\">\r\n" + 
				"            <ns3:PartySiteId>300000675274585</ns3:PartySiteId>\r\n" + 
				"            <ns3:PartyId>100000088640991</ns3:PartyId>\r\n" + 
				"            <ns3:LocationId>300000675274586</ns3:LocationId>\r\n" + 
				"            <ns3:LastUpdateDate>2019-01-09T08:44:15.478225Z</ns3:LastUpdateDate>\r\n" + 
				"            <ns3:PartySiteNumber>10630496</ns3:PartySiteNumber>\r\n" + 
				"            <ns3:LastUpdatedBy>FUSION_APPS_CRM_ESS_APPID</ns3:LastUpdatedBy>\r\n" + 
				"            <ns3:CreationDate>2018-08-30T06:30:08.001Z</ns3:CreationDate>\r\n" + 
				"            <ns3:CreatedBy>Datacentre</ns3:CreatedBy>\r\n" + 
				"            <ns3:LastUpdateLogin>7EFC90018141CEE6E0530A67360AE51C</ns3:LastUpdateLogin>\r\n" + 
				"            <ns3:RequestId>273465</ns3:RequestId>\r\n" + 
				"            <ns3:OrigSystemReference>300000675274585</ns3:OrigSystemReference>\r\n" + 
				"            <ns3:StartDateActive>2018-08-30</ns3:StartDateActive>\r\n" + 
				"            <ns3:EndDateActive>4712-12-31</ns3:EndDateActive>\r\n" + 
				"            <ns3:Mailstop xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:IdentifyingAddressFlag>false</ns3:IdentifyingAddressFlag>\r\n" + 
				"            <ns3:Language xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:Status>A</ns3:Status>\r\n" + 
				"            <ns3:PartySiteName xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:Addressee xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:ObjectVersionNumber>3</ns3:ObjectVersionNumber>\r\n" + 
				"            <ns3:CreatedByModule>HZ_WS</ns3:CreatedByModule>\r\n" + 
				"            <ns3:GlobalLocationNumber xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:DUNSNumberC xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:Comments xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:PartySiteType xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:PartyNameDba xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:PartyNameDivision xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:PartyNameLegal xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:RelationshipId xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:PartyUsageCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:OverallPrimaryFlag>false</ns3:OverallPrimaryFlag>\r\n" + 
				"            <ns3:PartySiteUse>\r\n" + 
				"              <ns3:PartySiteUseId>300000675274588</ns3:PartySiteUseId>\r\n" + 
				"              <ns3:BeginDate>2018-08-30</ns3:BeginDate>\r\n" + 
				"              <ns3:Comments xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:EndDate>4712-12-31</ns3:EndDate>\r\n" + 
				"              <ns3:PartySiteId>300000675274585</ns3:PartySiteId>\r\n" + 
				"              <ns3:LastUpdateDate>2018-08-30T06:30:08.172Z</ns3:LastUpdateDate>\r\n" + 
				"              <ns3:RequestId xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:LastUpdatedBy>Datacentre</ns3:LastUpdatedBy>\r\n" + 
				"              <ns3:CreationDate>2018-08-30T06:30:08.047Z</ns3:CreationDate>\r\n" + 
				"              <ns3:CreatedBy>Datacentre</ns3:CreatedBy>\r\n" + 
				"              <ns3:LastUpdateLogin>74A2050C1AA4728BE0530A67360A94E9</ns3:LastUpdateLogin>\r\n" + 
				"              <ns3:IntegrationKey xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:SiteUseType>HOME</ns3:SiteUseType>\r\n" + 
				"              <ns3:PrimaryPerType>Y</ns3:PrimaryPerType>\r\n" + 
				"              <ns3:Status>A</ns3:Status>\r\n" + 
				"              <ns3:ObjectVersionNumber>1</ns3:ObjectVersionNumber>\r\n" + 
				"              <ns3:CreatedByModule>HZ_WS</ns3:CreatedByModule>\r\n" + 
				"            </ns3:PartySiteUse>\r\n" + 
				"            <ns3:OriginalSystemReference xmlns:ns4=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/sourceSystemRef/\">\r\n" + 
				"              <ns3:OrigSystemReferenceId>300000675274587</ns3:OrigSystemReferenceId>\r\n" + 
				"              <ns3:OrigSystem>SIEBEL</ns3:OrigSystem>\r\n" + 
				"              <ns3:OrigSystemReference>H101010754080</ns3:OrigSystemReference>\r\n" + 
				"              <ns3:OwnerTableName>HZ_PARTY_SITES</ns3:OwnerTableName>\r\n" + 
				"              <ns3:OwnerTableId>300000675274585</ns3:OwnerTableId>\r\n" + 
				"              <ns3:Status>A</ns3:Status>\r\n" + 
				"              <ns3:ReasonCode xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:OldOrigSystemReference xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:StartDateActive>2018-08-30</ns3:StartDateActive>\r\n" + 
				"              <ns3:EndDateActive>4712-12-31</ns3:EndDateActive>\r\n" + 
				"              <ns3:CreatedBy>Datacentre</ns3:CreatedBy>\r\n" + 
				"              <ns3:CreationDate>2018-08-30T06:30:08.042Z</ns3:CreationDate>\r\n" + 
				"              <ns3:LastUpdatedBy>Datacentre</ns3:LastUpdatedBy>\r\n" + 
				"              <ns3:LastUpdateDate>2018-08-30T06:30:08.167Z</ns3:LastUpdateDate>\r\n" + 
				"              <ns3:LastUpdateLogin>74A2050C1AA4728BE0530A67360A94E9</ns3:LastUpdateLogin>\r\n" + 
				"              <ns3:ObjectVersionNumber>1</ns3:ObjectVersionNumber>\r\n" + 
				"              <ns3:CreatedByModule>HZ_WS</ns3:CreatedByModule>\r\n" + 
				"              <ns3:PartyId xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:RequestId xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:SourceSystemRefInformation>\r\n" + 
				"                <ns4:OrigSystemRefId>300000675274587</ns4:OrigSystemRefId>\r\n" + 
				"                <ns4:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"                <ns4:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"                <ns4:_FLEX_NumOfSegments>0</ns4:_FLEX_NumOfSegments>\r\n" + 
				"              </ns3:SourceSystemRefInformation>\r\n" + 
				"            </ns3:OriginalSystemReference>\r\n" + 
				"            <ns3:PersonPartySiteInformation>\r\n" + 
				"              <ns7:PartySiteId>300000675274585</ns7:PartySiteId>\r\n" + 
				"              <ns7:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"              <ns7:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"              <ns7:_FLEX_NumOfSegments>0</ns7:_FLEX_NumOfSegments>\r\n" + 
				"            </ns3:PersonPartySiteInformation>\r\n" + 
				"          </ns1:PartySite>\r\n" + 
				"          <ns1:PartySite xmlns:ns7=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/partySite/\">\r\n" + 
				"            <ns3:PartySiteId>100000108730752</ns3:PartySiteId>\r\n" + 
				"            <ns3:PartyId>100000088640991</ns3:PartyId>\r\n" + 
				"            <ns3:LocationId>100000108571602</ns3:LocationId>\r\n" + 
				"            <ns3:LastUpdateDate>2019-05-06T13:35:55.0Z</ns3:LastUpdateDate>\r\n" + 
				"            <ns3:PartySiteNumber>4626854</ns3:PartySiteNumber>\r\n" + 
				"            <ns3:LastUpdatedBy>siebelscheduler</ns3:LastUpdatedBy>\r\n" + 
				"            <ns3:CreationDate>2018-06-11T23:22:37.196598Z</ns3:CreationDate>\r\n" + 
				"            <ns3:CreatedBy>Datacentre</ns3:CreatedBy>\r\n" + 
				"            <ns3:LastUpdateLogin>88392C81B14F29B3E0530867360A5B75</ns3:LastUpdateLogin>\r\n" + 
				"            <ns3:RequestId>273465</ns3:RequestId>\r\n" + 
				"            <ns3:OrigSystemReference/>\r\n" + 
				"            <ns3:StartDateActive>2018-06-11</ns3:StartDateActive>\r\n" + 
				"            <ns3:EndDateActive>4712-12-31</ns3:EndDateActive>\r\n" + 
				"            <ns3:Mailstop xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:IdentifyingAddressFlag>true</ns3:IdentifyingAddressFlag>\r\n" + 
				"            <ns3:Language xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:Status>A</ns3:Status>\r\n" + 
				"            <ns3:PartySiteName xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:Addressee xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:ObjectVersionNumber>5</ns3:ObjectVersionNumber>\r\n" + 
				"            <ns3:CreatedByModule>HZ_IMPORT</ns3:CreatedByModule>\r\n" + 
				"            <ns3:GlobalLocationNumber xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:DUNSNumberC xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:Comments xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:PartySiteType xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:PartyNameDba xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:PartyNameDivision xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:PartyNameLegal xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:RelationshipId xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:PartyUsageCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:OverallPrimaryFlag>true</ns3:OverallPrimaryFlag>\r\n" + 
				"            <ns3:PartySiteUse>\r\n" + 
				"              <ns3:PartySiteUseId>300000675278064</ns3:PartySiteUseId>\r\n" + 
				"              <ns3:BeginDate>2018-08-30</ns3:BeginDate>\r\n" + 
				"              <ns3:Comments xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:EndDate>4712-12-31</ns3:EndDate>\r\n" + 
				"              <ns3:PartySiteId>100000108730752</ns3:PartySiteId>\r\n" + 
				"              <ns3:LastUpdateDate>2019-01-09T08:44:15.663996Z</ns3:LastUpdateDate>\r\n" + 
				"              <ns3:RequestId>273465</ns3:RequestId>\r\n" + 
				"              <ns3:LastUpdatedBy>FUSION_APPS_CRM_ESS_APPID</ns3:LastUpdatedBy>\r\n" + 
				"              <ns3:CreationDate>2018-08-30T06:30:11.0Z</ns3:CreationDate>\r\n" + 
				"              <ns3:CreatedBy>Datacentre</ns3:CreatedBy>\r\n" + 
				"              <ns3:LastUpdateLogin>7EFC90018141CEE6E0530A67360AE51C</ns3:LastUpdateLogin>\r\n" + 
				"              <ns3:IntegrationKey xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:SiteUseType>HOME</ns3:SiteUseType>\r\n" + 
				"              <ns3:PrimaryPerType>N</ns3:PrimaryPerType>\r\n" + 
				"              <ns3:Status>A</ns3:Status>\r\n" + 
				"              <ns3:ObjectVersionNumber>2</ns3:ObjectVersionNumber>\r\n" + 
				"              <ns3:CreatedByModule>HZ_WS</ns3:CreatedByModule>\r\n" + 
				"            </ns3:PartySiteUse>\r\n" + 
				"            <ns3:OriginalSystemReference xmlns:ns4=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/sourceSystemRef/\">\r\n" + 
				"              <ns3:OrigSystemReferenceId>100000110124164</ns3:OrigSystemReferenceId>\r\n" + 
				"              <ns3:OrigSystem>SIEBEL</ns3:OrigSystem>\r\n" + 
				"              <ns3:OrigSystemReference>1-1NR-1127</ns3:OrigSystemReference>\r\n" + 
				"              <ns3:OwnerTableName>HZ_PARTY_SITES</ns3:OwnerTableName>\r\n" + 
				"              <ns3:OwnerTableId>100000108730752</ns3:OwnerTableId>\r\n" + 
				"              <ns3:Status>A</ns3:Status>\r\n" + 
				"              <ns3:ReasonCode xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:OldOrigSystemReference xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:StartDateActive>2018-06-11</ns3:StartDateActive>\r\n" + 
				"              <ns3:EndDateActive>4712-12-31</ns3:EndDateActive>\r\n" + 
				"              <ns3:CreatedBy>Datacentre</ns3:CreatedBy>\r\n" + 
				"              <ns3:CreationDate>2018-06-11T23:23:30.3611Z</ns3:CreationDate>\r\n" + 
				"              <ns3:LastUpdatedBy>Datacentre</ns3:LastUpdatedBy>\r\n" + 
				"              <ns3:LastUpdateDate>2018-06-11T23:23:30.3611Z</ns3:LastUpdateDate>\r\n" + 
				"              <ns3:LastUpdateLogin>-1</ns3:LastUpdateLogin>\r\n" + 
				"              <ns3:ObjectVersionNumber>1</ns3:ObjectVersionNumber>\r\n" + 
				"              <ns3:CreatedByModule>HZ_IMPORT</ns3:CreatedByModule>\r\n" + 
				"              <ns3:PartyId>100000088640991</ns3:PartyId>\r\n" + 
				"              <ns3:RequestId xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:SourceSystemRefInformation>\r\n" + 
				"                <ns4:OrigSystemRefId>100000110124164</ns4:OrigSystemRefId>\r\n" + 
				"                <ns4:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"                <ns4:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"                <ns4:_FLEX_NumOfSegments>0</ns4:_FLEX_NumOfSegments>\r\n" + 
				"              </ns3:SourceSystemRefInformation>\r\n" + 
				"            </ns3:OriginalSystemReference>\r\n" + 
				"            <ns3:PersonPartySiteInformation>\r\n" + 
				"              <ns7:PartySiteId>100000108730752</ns7:PartySiteId>\r\n" + 
				"              <ns7:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"              <ns7:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"              <ns7:_FLEX_NumOfSegments>0</ns7:_FLEX_NumOfSegments>\r\n" + 
				"            </ns3:PersonPartySiteInformation>\r\n" + 
				"          </ns1:PartySite>\r\n" + 
				"          <ns1:PartySite xmlns:ns7=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/partySite/\">\r\n" + 
				"            <ns3:PartySiteId>300000911600752</ns3:PartySiteId>\r\n" + 
				"            <ns3:PartyId>100000088640991</ns3:PartyId>\r\n" + 
				"            <ns3:LocationId>300000911600753</ns3:LocationId>\r\n" + 
				"            <ns3:LastUpdateDate>2019-05-18T10:38:42.462Z</ns3:LastUpdateDate>\r\n" + 
				"            <ns3:PartySiteNumber>20431576</ns3:PartySiteNumber>\r\n" + 
				"            <ns3:LastUpdatedBy>siebelscheduler</ns3:LastUpdatedBy>\r\n" + 
				"            <ns3:CreationDate>2019-05-18T10:38:42.001Z</ns3:CreationDate>\r\n" + 
				"            <ns3:CreatedBy>siebelscheduler</ns3:CreatedBy>\r\n" + 
				"            <ns3:LastUpdateLogin>8926BB02DC2A0EB2E0530867360AF2E2</ns3:LastUpdateLogin>\r\n" + 
				"            <ns3:RequestId xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:OrigSystemReference>300000911600752</ns3:OrigSystemReference>\r\n" + 
				"            <ns3:StartDateActive>2019-05-18</ns3:StartDateActive>\r\n" + 
				"            <ns3:EndDateActive>4712-12-31</ns3:EndDateActive>\r\n" + 
				"            <ns3:Mailstop xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:IdentifyingAddressFlag>false</ns3:IdentifyingAddressFlag>\r\n" + 
				"            <ns3:Language xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:Status>A</ns3:Status>\r\n" + 
				"            <ns3:PartySiteName xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:Addressee xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:ObjectVersionNumber>1</ns3:ObjectVersionNumber>\r\n" + 
				"            <ns3:CreatedByModule>HZ_WS</ns3:CreatedByModule>\r\n" + 
				"            <ns3:GlobalLocationNumber xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:DUNSNumberC xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:Comments xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:PartySiteType xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:PartyNameDba xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:PartyNameDivision xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:PartyNameLegal xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:RelationshipId xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:PartyUsageCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:OverallPrimaryFlag>false</ns3:OverallPrimaryFlag>\r\n" + 
				"            <ns3:PartySiteUse>\r\n" + 
				"              <ns3:PartySiteUseId>300000911600755</ns3:PartySiteUseId>\r\n" + 
				"              <ns3:BeginDate>2019-05-18</ns3:BeginDate>\r\n" + 
				"              <ns3:Comments xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:EndDate>4712-12-31</ns3:EndDate>\r\n" + 
				"              <ns3:PartySiteId>300000911600752</ns3:PartySiteId>\r\n" + 
				"              <ns3:LastUpdateDate>2019-05-18T10:38:42.223Z</ns3:LastUpdateDate>\r\n" + 
				"              <ns3:RequestId xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:LastUpdatedBy>siebelscheduler</ns3:LastUpdatedBy>\r\n" + 
				"              <ns3:CreationDate>2019-05-18T10:38:42.029Z</ns3:CreationDate>\r\n" + 
				"              <ns3:CreatedBy>siebelscheduler</ns3:CreatedBy>\r\n" + 
				"              <ns3:LastUpdateLogin>8926BB02DC2A0EB2E0530867360AF2E2</ns3:LastUpdateLogin>\r\n" + 
				"              <ns3:IntegrationKey xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:SiteUseType>HOME</ns3:SiteUseType>\r\n" + 
				"              <ns3:PrimaryPerType>N</ns3:PrimaryPerType>\r\n" + 
				"              <ns3:Status>A</ns3:Status>\r\n" + 
				"              <ns3:ObjectVersionNumber>1</ns3:ObjectVersionNumber>\r\n" + 
				"              <ns3:CreatedByModule>HZ_WS</ns3:CreatedByModule>\r\n" + 
				"            </ns3:PartySiteUse>\r\n" + 
				"            <ns3:OriginalSystemReference xmlns:ns4=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/sourceSystemRef/\">\r\n" + 
				"              <ns3:OrigSystemReferenceId>300000911600754</ns3:OrigSystemReferenceId>\r\n" + 
				"              <ns3:OrigSystem>SIEBEL</ns3:OrigSystem>\r\n" + 
				"              <ns3:OrigSystemReference>No 255 Sai Krupa</ns3:OrigSystemReference>\r\n" + 
				"              <ns3:OwnerTableName>HZ_PARTY_SITES</ns3:OwnerTableName>\r\n" + 
				"              <ns3:OwnerTableId>300000911600752</ns3:OwnerTableId>\r\n" + 
				"              <ns3:Status>A</ns3:Status>\r\n" + 
				"              <ns3:ReasonCode xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:OldOrigSystemReference xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:StartDateActive>2019-05-18</ns3:StartDateActive>\r\n" + 
				"              <ns3:EndDateActive>4712-12-31</ns3:EndDateActive>\r\n" + 
				"              <ns3:CreatedBy>siebelscheduler</ns3:CreatedBy>\r\n" + 
				"              <ns3:CreationDate>2019-05-18T10:38:42.022Z</ns3:CreationDate>\r\n" + 
				"              <ns3:LastUpdatedBy>siebelscheduler</ns3:LastUpdatedBy>\r\n" + 
				"              <ns3:LastUpdateDate>2019-05-18T10:38:42.214Z</ns3:LastUpdateDate>\r\n" + 
				"              <ns3:LastUpdateLogin>8926BB02DC2A0EB2E0530867360AF2E2</ns3:LastUpdateLogin>\r\n" + 
				"              <ns3:ObjectVersionNumber>1</ns3:ObjectVersionNumber>\r\n" + 
				"              <ns3:CreatedByModule>HZ_WS</ns3:CreatedByModule>\r\n" + 
				"              <ns3:PartyId xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:RequestId xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:SourceSystemRefInformation>\r\n" + 
				"                <ns4:OrigSystemRefId>300000911600754</ns4:OrigSystemRefId>\r\n" + 
				"                <ns4:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"                <ns4:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"                <ns4:_FLEX_NumOfSegments>0</ns4:_FLEX_NumOfSegments>\r\n" + 
				"              </ns3:SourceSystemRefInformation>\r\n" + 
				"            </ns3:OriginalSystemReference>\r\n" + 
				"            <ns3:PersonPartySiteInformation>\r\n" + 
				"              <ns7:PartySiteId>300000911600752</ns7:PartySiteId>\r\n" + 
				"              <ns7:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"              <ns7:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"              <ns7:_FLEX_NumOfSegments>0</ns7:_FLEX_NumOfSegments>\r\n" + 
				"            </ns3:PersonPartySiteInformation>\r\n" + 
				"          </ns1:PartySite>\r\n" + 
				"          <ns1:PartySite xmlns:ns7=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/partySite/\">\r\n" + 
				"            <ns3:PartySiteId>300000771380854</ns3:PartySiteId>\r\n" + 
				"            <ns3:PartyId>100000088640991</ns3:PartyId>\r\n" + 
				"            <ns3:LocationId>300000771380855</ns3:LocationId>\r\n" + 
				"            <ns3:LastUpdateDate>2019-01-09T08:44:15.478225Z</ns3:LastUpdateDate>\r\n" + 
				"            <ns3:PartySiteNumber>14465077</ns3:PartySiteNumber>\r\n" + 
				"            <ns3:LastUpdatedBy>FUSION_APPS_CRM_ESS_APPID</ns3:LastUpdatedBy>\r\n" + 
				"            <ns3:CreationDate>2018-12-11T13:07:39.001Z</ns3:CreationDate>\r\n" + 
				"            <ns3:CreatedBy>Datacentre</ns3:CreatedBy>\r\n" + 
				"            <ns3:LastUpdateLogin>7EFC90018141CEE6E0530A67360AE51C</ns3:LastUpdateLogin>\r\n" + 
				"            <ns3:RequestId>273465</ns3:RequestId>\r\n" + 
				"            <ns3:OrigSystemReference>300000771380854</ns3:OrigSystemReference>\r\n" + 
				"            <ns3:StartDateActive>2018-12-11</ns3:StartDateActive>\r\n" + 
				"            <ns3:EndDateActive>4712-12-31</ns3:EndDateActive>\r\n" + 
				"            <ns3:Mailstop xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:IdentifyingAddressFlag>false</ns3:IdentifyingAddressFlag>\r\n" + 
				"            <ns3:Language xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:Status>A</ns3:Status>\r\n" + 
				"            <ns3:PartySiteName xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:Addressee xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:ObjectVersionNumber>2</ns3:ObjectVersionNumber>\r\n" + 
				"            <ns3:CreatedByModule>HZ_WS</ns3:CreatedByModule>\r\n" + 
				"            <ns3:GlobalLocationNumber xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:DUNSNumberC xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:Comments xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:PartySiteType xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:PartyNameDba xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:PartyNameDivision xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:PartyNameLegal xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:RelationshipId xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:PartyUsageCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:OverallPrimaryFlag>false</ns3:OverallPrimaryFlag>\r\n" + 
				"            <ns3:PartySiteUse>\r\n" + 
				"              <ns3:PartySiteUseId>300000771380857</ns3:PartySiteUseId>\r\n" + 
				"              <ns3:BeginDate>2018-12-11</ns3:BeginDate>\r\n" + 
				"              <ns3:Comments xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:EndDate>4712-12-31</ns3:EndDate>\r\n" + 
				"              <ns3:PartySiteId>300000771380854</ns3:PartySiteId>\r\n" + 
				"              <ns3:LastUpdateDate>2019-01-09T08:44:15.663996Z</ns3:LastUpdateDate>\r\n" + 
				"              <ns3:RequestId>273465</ns3:RequestId>\r\n" + 
				"              <ns3:LastUpdatedBy>FUSION_APPS_CRM_ESS_APPID</ns3:LastUpdatedBy>\r\n" + 
				"              <ns3:CreationDate>2018-12-11T13:07:39.06Z</ns3:CreationDate>\r\n" + 
				"              <ns3:CreatedBy>Datacentre</ns3:CreatedBy>\r\n" + 
				"              <ns3:LastUpdateLogin>7EFC90018141CEE6E0530A67360AE51C</ns3:LastUpdateLogin>\r\n" + 
				"              <ns3:IntegrationKey xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:SiteUseType>HOME</ns3:SiteUseType>\r\n" + 
				"              <ns3:PrimaryPerType>N</ns3:PrimaryPerType>\r\n" + 
				"              <ns3:Status>A</ns3:Status>\r\n" + 
				"              <ns3:ObjectVersionNumber>3</ns3:ObjectVersionNumber>\r\n" + 
				"              <ns3:CreatedByModule>HZ_WS</ns3:CreatedByModule>\r\n" + 
				"            </ns3:PartySiteUse>\r\n" + 
				"            <ns3:OriginalSystemReference xmlns:ns4=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/sourceSystemRef/\">\r\n" + 
				"              <ns3:OrigSystemReferenceId>300000771380856</ns3:OrigSystemReferenceId>\r\n" + 
				"              <ns3:OrigSystem>PMS</ns3:OrigSystem>\r\n" + 
				"              <ns3:OrigSystemReference>2018121101073827166</ns3:OrigSystemReference>\r\n" + 
				"              <ns3:OwnerTableName>HZ_PARTY_SITES</ns3:OwnerTableName>\r\n" + 
				"              <ns3:OwnerTableId>300000771380854</ns3:OwnerTableId>\r\n" + 
				"              <ns3:Status>A</ns3:Status>\r\n" + 
				"              <ns3:ReasonCode xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:OldOrigSystemReference xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:StartDateActive>2018-12-11</ns3:StartDateActive>\r\n" + 
				"              <ns3:EndDateActive>4712-12-31</ns3:EndDateActive>\r\n" + 
				"              <ns3:CreatedBy>Datacentre</ns3:CreatedBy>\r\n" + 
				"              <ns3:CreationDate>2018-12-11T13:07:39.051Z</ns3:CreationDate>\r\n" + 
				"              <ns3:LastUpdatedBy>Datacentre</ns3:LastUpdatedBy>\r\n" + 
				"              <ns3:LastUpdateDate>2018-12-11T13:07:39.207Z</ns3:LastUpdateDate>\r\n" + 
				"              <ns3:LastUpdateLogin>7CBEA25D2BD7B51CE0530A67360AF3F9</ns3:LastUpdateLogin>\r\n" + 
				"              <ns3:ObjectVersionNumber>1</ns3:ObjectVersionNumber>\r\n" + 
				"              <ns3:CreatedByModule>HZ_WS</ns3:CreatedByModule>\r\n" + 
				"              <ns3:PartyId xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:RequestId xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:SourceSystemRefInformation>\r\n" + 
				"                <ns4:OrigSystemRefId>300000771380856</ns4:OrigSystemRefId>\r\n" + 
				"                <ns4:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"                <ns4:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"                <ns4:_FLEX_NumOfSegments>0</ns4:_FLEX_NumOfSegments>\r\n" + 
				"              </ns3:SourceSystemRefInformation>\r\n" + 
				"            </ns3:OriginalSystemReference>\r\n" + 
				"            <ns3:PersonPartySiteInformation>\r\n" + 
				"              <ns7:PartySiteId>300000771380854</ns7:PartySiteId>\r\n" + 
				"              <ns7:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"              <ns7:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"              <ns7:_FLEX_NumOfSegments>0</ns7:_FLEX_NumOfSegments>\r\n" + 
				"            </ns3:PersonPartySiteInformation>\r\n" + 
				"          </ns1:PartySite>\r\n" + 
				"          <ns1:PartySite xmlns:ns7=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/partySite/\">\r\n" + 
				"            <ns3:PartySiteId>300000911605221</ns3:PartySiteId>\r\n" + 
				"            <ns3:PartyId>100000088640991</ns3:PartyId>\r\n" + 
				"            <ns3:LocationId>300000911605222</ns3:LocationId>\r\n" + 
				"            <ns3:LastUpdateDate>2019-05-18T10:38:44.351Z</ns3:LastUpdateDate>\r\n" + 
				"            <ns3:PartySiteNumber>20431578</ns3:PartySiteNumber>\r\n" + 
				"            <ns3:LastUpdatedBy>siebelscheduler</ns3:LastUpdatedBy>\r\n" + 
				"            <ns3:CreationDate>2019-05-18T10:38:44.001Z</ns3:CreationDate>\r\n" + 
				"            <ns3:CreatedBy>siebelscheduler</ns3:CreatedBy>\r\n" + 
				"            <ns3:LastUpdateLogin>8927CCAAEC9A9E50E0530867360A284B</ns3:LastUpdateLogin>\r\n" + 
				"            <ns3:RequestId xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:OrigSystemReference>300000911605221</ns3:OrigSystemReference>\r\n" + 
				"            <ns3:StartDateActive>2019-05-18</ns3:StartDateActive>\r\n" + 
				"            <ns3:EndDateActive>4712-12-31</ns3:EndDateActive>\r\n" + 
				"            <ns3:Mailstop xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:IdentifyingAddressFlag>false</ns3:IdentifyingAddressFlag>\r\n" + 
				"            <ns3:Language xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:Status>A</ns3:Status>\r\n" + 
				"            <ns3:PartySiteName xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:Addressee xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:ObjectVersionNumber>1</ns3:ObjectVersionNumber>\r\n" + 
				"            <ns3:CreatedByModule>HZ_WS</ns3:CreatedByModule>\r\n" + 
				"            <ns3:GlobalLocationNumber xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:DUNSNumberC xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:Comments xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:PartySiteType xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:PartyNameDba xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:PartyNameDivision xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:PartyNameLegal xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:RelationshipId xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:PartyUsageCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:OverallPrimaryFlag>false</ns3:OverallPrimaryFlag>\r\n" + 
				"            <ns3:PartySiteUse>\r\n" + 
				"              <ns3:PartySiteUseId>300000911605224</ns3:PartySiteUseId>\r\n" + 
				"              <ns3:BeginDate>2019-05-18</ns3:BeginDate>\r\n" + 
				"              <ns3:Comments xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:EndDate>4712-12-31</ns3:EndDate>\r\n" + 
				"              <ns3:PartySiteId>300000911605221</ns3:PartySiteId>\r\n" + 
				"              <ns3:LastUpdateDate>2019-05-18T10:38:44.097Z</ns3:LastUpdateDate>\r\n" + 
				"              <ns3:RequestId xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:LastUpdatedBy>siebelscheduler</ns3:LastUpdatedBy>\r\n" + 
				"              <ns3:CreationDate>2019-05-18T10:38:44.031Z</ns3:CreationDate>\r\n" + 
				"              <ns3:CreatedBy>siebelscheduler</ns3:CreatedBy>\r\n" + 
				"              <ns3:LastUpdateLogin>8927CCAAEC9A9E50E0530867360A284B</ns3:LastUpdateLogin>\r\n" + 
				"              <ns3:IntegrationKey xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:SiteUseType>HOME</ns3:SiteUseType>\r\n" + 
				"              <ns3:PrimaryPerType>N</ns3:PrimaryPerType>\r\n" + 
				"              <ns3:Status>A</ns3:Status>\r\n" + 
				"              <ns3:ObjectVersionNumber>1</ns3:ObjectVersionNumber>\r\n" + 
				"              <ns3:CreatedByModule>HZ_WS</ns3:CreatedByModule>\r\n" + 
				"            </ns3:PartySiteUse>\r\n" + 
				"            <ns3:OriginalSystemReference xmlns:ns4=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/sourceSystemRef/\">\r\n" + 
				"              <ns3:OrigSystemReferenceId>300000911605223</ns3:OrigSystemReferenceId>\r\n" + 
				"              <ns3:OrigSystem>SIEBEL</ns3:OrigSystem>\r\n" + 
				"              <ns3:OrigSystemReference>No 526 MTB Cmplx</ns3:OrigSystemReference>\r\n" + 
				"              <ns3:OwnerTableName>HZ_PARTY_SITES</ns3:OwnerTableName>\r\n" + 
				"              <ns3:OwnerTableId>300000911605221</ns3:OwnerTableId>\r\n" + 
				"              <ns3:Status>A</ns3:Status>\r\n" + 
				"              <ns3:ReasonCode xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:OldOrigSystemReference xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:StartDateActive>2019-05-18</ns3:StartDateActive>\r\n" + 
				"              <ns3:EndDateActive>4712-12-31</ns3:EndDateActive>\r\n" + 
				"              <ns3:CreatedBy>siebelscheduler</ns3:CreatedBy>\r\n" + 
				"              <ns3:CreationDate>2019-05-18T10:38:44.025Z</ns3:CreationDate>\r\n" + 
				"              <ns3:LastUpdatedBy>siebelscheduler</ns3:LastUpdatedBy>\r\n" + 
				"              <ns3:LastUpdateDate>2019-05-18T10:38:44.091Z</ns3:LastUpdateDate>\r\n" + 
				"              <ns3:LastUpdateLogin>8927CCAAEC9A9E50E0530867360A284B</ns3:LastUpdateLogin>\r\n" + 
				"              <ns3:ObjectVersionNumber>1</ns3:ObjectVersionNumber>\r\n" + 
				"              <ns3:CreatedByModule>HZ_WS</ns3:CreatedByModule>\r\n" + 
				"              <ns3:PartyId xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:RequestId xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:SourceSystemRefInformation>\r\n" + 
				"                <ns4:OrigSystemRefId>300000911605223</ns4:OrigSystemRefId>\r\n" + 
				"                <ns4:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"                <ns4:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"                <ns4:_FLEX_NumOfSegments>0</ns4:_FLEX_NumOfSegments>\r\n" + 
				"              </ns3:SourceSystemRefInformation>\r\n" + 
				"            </ns3:OriginalSystemReference>\r\n" + 
				"            <ns3:PersonPartySiteInformation>\r\n" + 
				"              <ns7:PartySiteId>300000911605221</ns7:PartySiteId>\r\n" + 
				"              <ns7:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"              <ns7:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"              <ns7:_FLEX_NumOfSegments>0</ns7:_FLEX_NumOfSegments>\r\n" + 
				"            </ns3:PersonPartySiteInformation>\r\n" + 
				"          </ns1:PartySite>\r\n" + 
				"          <ns1:PartySite xmlns:ns7=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/partySite/\">\r\n" + 
				"            <ns3:PartySiteId>300000911602419</ns3:PartySiteId>\r\n" + 
				"            <ns3:PartyId>100000088640991</ns3:PartyId>\r\n" + 
				"            <ns3:LocationId>300000911602420</ns3:LocationId>\r\n" + 
				"            <ns3:LastUpdateDate>2019-05-18T10:38:47.375Z</ns3:LastUpdateDate>\r\n" + 
				"            <ns3:PartySiteNumber>20431580</ns3:PartySiteNumber>\r\n" + 
				"            <ns3:LastUpdatedBy>siebelscheduler</ns3:LastUpdatedBy>\r\n" + 
				"            <ns3:CreationDate>2019-05-18T10:38:47.001Z</ns3:CreationDate>\r\n" + 
				"            <ns3:CreatedBy>siebelscheduler</ns3:CreatedBy>\r\n" + 
				"            <ns3:LastUpdateLogin>892812E853614F4AE0530867360A5097</ns3:LastUpdateLogin>\r\n" + 
				"            <ns3:RequestId xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:OrigSystemReference>300000911602419</ns3:OrigSystemReference>\r\n" + 
				"            <ns3:StartDateActive>2019-05-18</ns3:StartDateActive>\r\n" + 
				"            <ns3:EndDateActive>4712-12-31</ns3:EndDateActive>\r\n" + 
				"            <ns3:Mailstop xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:IdentifyingAddressFlag>false</ns3:IdentifyingAddressFlag>\r\n" + 
				"            <ns3:Language xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:Status>A</ns3:Status>\r\n" + 
				"            <ns3:PartySiteName xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:Addressee xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:ObjectVersionNumber>1</ns3:ObjectVersionNumber>\r\n" + 
				"            <ns3:CreatedByModule>HZ_WS</ns3:CreatedByModule>\r\n" + 
				"            <ns3:GlobalLocationNumber xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:DUNSNumberC xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:Comments xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:PartySiteType xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:PartyNameDba xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:PartyNameDivision xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:PartyNameLegal xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:RelationshipId xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:PartyUsageCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:OverallPrimaryFlag>false</ns3:OverallPrimaryFlag>\r\n" + 
				"            <ns3:PartySiteUse>\r\n" + 
				"              <ns3:PartySiteUseId>300000911602422</ns3:PartySiteUseId>\r\n" + 
				"              <ns3:BeginDate>2019-05-18</ns3:BeginDate>\r\n" + 
				"              <ns3:Comments xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:EndDate>4712-12-31</ns3:EndDate>\r\n" + 
				"              <ns3:PartySiteId>300000911602419</ns3:PartySiteId>\r\n" + 
				"              <ns3:LastUpdateDate>2019-05-18T10:38:47.116Z</ns3:LastUpdateDate>\r\n" + 
				"              <ns3:RequestId xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:LastUpdatedBy>siebelscheduler</ns3:LastUpdatedBy>\r\n" + 
				"              <ns3:CreationDate>2019-05-18T10:38:47.054Z</ns3:CreationDate>\r\n" + 
				"              <ns3:CreatedBy>siebelscheduler</ns3:CreatedBy>\r\n" + 
				"              <ns3:LastUpdateLogin>892812E853614F4AE0530867360A5097</ns3:LastUpdateLogin>\r\n" + 
				"              <ns3:IntegrationKey xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:SiteUseType>HOME</ns3:SiteUseType>\r\n" + 
				"              <ns3:PrimaryPerType>N</ns3:PrimaryPerType>\r\n" + 
				"              <ns3:Status>A</ns3:Status>\r\n" + 
				"              <ns3:ObjectVersionNumber>1</ns3:ObjectVersionNumber>\r\n" + 
				"              <ns3:CreatedByModule>HZ_WS</ns3:CreatedByModule>\r\n" + 
				"            </ns3:PartySiteUse>\r\n" + 
				"            <ns3:OriginalSystemReference xmlns:ns4=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/sourceSystemRef/\">\r\n" + 
				"              <ns3:OrigSystemReferenceId>300000911602421</ns3:OrigSystemReferenceId>\r\n" + 
				"              <ns3:OrigSystem>SIEBEL</ns3:OrigSystem>\r\n" + 
				"              <ns3:OrigSystemReference>Number 255 Sai Krupa</ns3:OrigSystemReference>\r\n" + 
				"              <ns3:OwnerTableName>HZ_PARTY_SITES</ns3:OwnerTableName>\r\n" + 
				"              <ns3:OwnerTableId>300000911602419</ns3:OwnerTableId>\r\n" + 
				"              <ns3:Status>A</ns3:Status>\r\n" + 
				"              <ns3:ReasonCode xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:OldOrigSystemReference xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:StartDateActive>2019-05-18</ns3:StartDateActive>\r\n" + 
				"              <ns3:EndDateActive>4712-12-31</ns3:EndDateActive>\r\n" + 
				"              <ns3:CreatedBy>siebelscheduler</ns3:CreatedBy>\r\n" + 
				"              <ns3:CreationDate>2019-05-18T10:38:47.048Z</ns3:CreationDate>\r\n" + 
				"              <ns3:LastUpdatedBy>siebelscheduler</ns3:LastUpdatedBy>\r\n" + 
				"              <ns3:LastUpdateDate>2019-05-18T10:38:47.111Z</ns3:LastUpdateDate>\r\n" + 
				"              <ns3:LastUpdateLogin>892812E853614F4AE0530867360A5097</ns3:LastUpdateLogin>\r\n" + 
				"              <ns3:ObjectVersionNumber>1</ns3:ObjectVersionNumber>\r\n" + 
				"              <ns3:CreatedByModule>HZ_WS</ns3:CreatedByModule>\r\n" + 
				"              <ns3:PartyId xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:RequestId xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:SourceSystemRefInformation>\r\n" + 
				"                <ns4:OrigSystemRefId>300000911602421</ns4:OrigSystemRefId>\r\n" + 
				"                <ns4:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"                <ns4:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"                <ns4:_FLEX_NumOfSegments>0</ns4:_FLEX_NumOfSegments>\r\n" + 
				"              </ns3:SourceSystemRefInformation>\r\n" + 
				"            </ns3:OriginalSystemReference>\r\n" + 
				"            <ns3:PersonPartySiteInformation>\r\n" + 
				"              <ns7:PartySiteId>300000911602419</ns7:PartySiteId>\r\n" + 
				"              <ns7:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"              <ns7:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"              <ns7:_FLEX_NumOfSegments>0</ns7:_FLEX_NumOfSegments>\r\n" + 
				"            </ns3:PersonPartySiteInformation>\r\n" + 
				"          </ns1:PartySite>\r\n" + 
				"          <ns1:PartySite xmlns:ns7=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/partySite/\">\r\n" + 
				"            <ns3:PartySiteId>300000911600715</ns3:PartySiteId>\r\n" + 
				"            <ns3:PartyId>100000088640991</ns3:PartyId>\r\n" + 
				"            <ns3:LocationId>300000911600716</ns3:LocationId>\r\n" + 
				"            <ns3:LastUpdateDate>2019-05-18T10:36:23.184Z</ns3:LastUpdateDate>\r\n" + 
				"            <ns3:PartySiteNumber>20431552</ns3:PartySiteNumber>\r\n" + 
				"            <ns3:LastUpdatedBy>pms scheduler</ns3:LastUpdatedBy>\r\n" + 
				"            <ns3:CreationDate>2019-05-18T10:36:23.001Z</ns3:CreationDate>\r\n" + 
				"            <ns3:CreatedBy>pms scheduler</ns3:CreatedBy>\r\n" + 
				"            <ns3:LastUpdateLogin>8926C1ABCBD90EAFE0530867360AEB73</ns3:LastUpdateLogin>\r\n" + 
				"            <ns3:RequestId xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:OrigSystemReference>300000911600715</ns3:OrigSystemReference>\r\n" + 
				"            <ns3:StartDateActive>2019-05-18</ns3:StartDateActive>\r\n" + 
				"            <ns3:EndDateActive>4712-12-31</ns3:EndDateActive>\r\n" + 
				"            <ns3:Mailstop xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:IdentifyingAddressFlag>false</ns3:IdentifyingAddressFlag>\r\n" + 
				"            <ns3:Language xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:Status>A</ns3:Status>\r\n" + 
				"            <ns3:PartySiteName xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:Addressee xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:ObjectVersionNumber>1</ns3:ObjectVersionNumber>\r\n" + 
				"            <ns3:CreatedByModule>HZ_WS</ns3:CreatedByModule>\r\n" + 
				"            <ns3:GlobalLocationNumber xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:DUNSNumberC xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:Comments xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:PartySiteType xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:PartyNameDba xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:PartyNameDivision xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:PartyNameLegal xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:RelationshipId xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:PartyUsageCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:OverallPrimaryFlag>false</ns3:OverallPrimaryFlag>\r\n" + 
				"            <ns3:PartySiteUse>\r\n" + 
				"              <ns3:PartySiteUseId>300000911600718</ns3:PartySiteUseId>\r\n" + 
				"              <ns3:BeginDate>2019-05-18</ns3:BeginDate>\r\n" + 
				"              <ns3:Comments xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:EndDate>4712-12-31</ns3:EndDate>\r\n" + 
				"              <ns3:PartySiteId>300000911600715</ns3:PartySiteId>\r\n" + 
				"              <ns3:LastUpdateDate>2019-05-18T10:36:23.092Z</ns3:LastUpdateDate>\r\n" + 
				"              <ns3:RequestId xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:LastUpdatedBy>pms scheduler</ns3:LastUpdatedBy>\r\n" + 
				"              <ns3:CreationDate>2019-05-18T10:36:23.024Z</ns3:CreationDate>\r\n" + 
				"              <ns3:CreatedBy>pms scheduler</ns3:CreatedBy>\r\n" + 
				"              <ns3:LastUpdateLogin>8926C1ABCBD90EAFE0530867360AEB73</ns3:LastUpdateLogin>\r\n" + 
				"              <ns3:IntegrationKey xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:SiteUseType>HOME</ns3:SiteUseType>\r\n" + 
				"              <ns3:PrimaryPerType>N</ns3:PrimaryPerType>\r\n" + 
				"              <ns3:Status>A</ns3:Status>\r\n" + 
				"              <ns3:ObjectVersionNumber>1</ns3:ObjectVersionNumber>\r\n" + 
				"              <ns3:CreatedByModule>HZ_WS</ns3:CreatedByModule>\r\n" + 
				"            </ns3:PartySiteUse>\r\n" + 
				"            <ns3:OriginalSystemReference xmlns:ns4=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/sourceSystemRef/\">\r\n" + 
				"              <ns3:OrigSystemReferenceId>300000911600717</ns3:OrigSystemReferenceId>\r\n" + 
				"              <ns3:OrigSystem>PMS</ns3:OrigSystem>\r\n" + 
				"              <ns3:OrigSystemReference>PP_2019051810362241333</ns3:OrigSystemReference>\r\n" + 
				"              <ns3:OwnerTableName>HZ_PARTY_SITES</ns3:OwnerTableName>\r\n" + 
				"              <ns3:OwnerTableId>300000911600715</ns3:OwnerTableId>\r\n" + 
				"              <ns3:Status>A</ns3:Status>\r\n" + 
				"              <ns3:ReasonCode xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:OldOrigSystemReference xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:StartDateActive>2019-05-18</ns3:StartDateActive>\r\n" + 
				"              <ns3:EndDateActive>4712-12-31</ns3:EndDateActive>\r\n" + 
				"              <ns3:CreatedBy>pms scheduler</ns3:CreatedBy>\r\n" + 
				"              <ns3:CreationDate>2019-05-18T10:36:23.019Z</ns3:CreationDate>\r\n" + 
				"              <ns3:LastUpdatedBy>pms scheduler</ns3:LastUpdatedBy>\r\n" + 
				"              <ns3:LastUpdateDate>2019-05-18T10:36:23.083Z</ns3:LastUpdateDate>\r\n" + 
				"              <ns3:LastUpdateLogin>8926C1ABCBD90EAFE0530867360AEB73</ns3:LastUpdateLogin>\r\n" + 
				"              <ns3:ObjectVersionNumber>1</ns3:ObjectVersionNumber>\r\n" + 
				"              <ns3:CreatedByModule>HZ_WS</ns3:CreatedByModule>\r\n" + 
				"              <ns3:PartyId xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:RequestId xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:SourceSystemRefInformation>\r\n" + 
				"                <ns4:OrigSystemRefId>300000911600717</ns4:OrigSystemRefId>\r\n" + 
				"                <ns4:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"                <ns4:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"                <ns4:_FLEX_NumOfSegments>0</ns4:_FLEX_NumOfSegments>\r\n" + 
				"              </ns3:SourceSystemRefInformation>\r\n" + 
				"            </ns3:OriginalSystemReference>\r\n" + 
				"            <ns3:PersonPartySiteInformation>\r\n" + 
				"              <ns7:PartySiteId>300000911600715</ns7:PartySiteId>\r\n" + 
				"              <ns7:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"              <ns7:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"              <ns7:_FLEX_NumOfSegments>0</ns7:_FLEX_NumOfSegments>\r\n" + 
				"            </ns3:PersonPartySiteInformation>\r\n" + 
				"          </ns1:PartySite>\r\n" + 
				"          <ns1:PersonProfile xmlns:ns2=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/person/\">\r\n" + 
				"            <ns1:PersonProfileId>100000088640991</ns1:PersonProfileId>\r\n" + 
				"            <ns1:PartyId>100000088640991</ns1:PartyId>\r\n" + 
				"            <ns1:PersonName>C M Dhananjaya</ns1:PersonName>\r\n" + 
				"            <ns1:LastUpdateDate>2019-05-18T10:38:48.256Z</ns1:LastUpdateDate>\r\n" + 
				"            <ns1:LastUpdatedBy>siebelscheduler</ns1:LastUpdatedBy>\r\n" + 
				"            <ns1:CreationDate>2018-06-08T06:31:50.013542Z</ns1:CreationDate>\r\n" + 
				"            <ns1:CreatedBy>Datacentre</ns1:CreatedBy>\r\n" + 
				"            <ns1:LastUpdateLogin>892816F5FF4F7988E0530A67360A5691</ns1:LastUpdateLogin>\r\n" + 
				"            <ns1:RequestId>273465</ns1:RequestId>\r\n" + 
				"            <ns1:PersonPreNameAdjunct>Mr.</ns1:PersonPreNameAdjunct>\r\n" + 
				"            <ns1:PersonFirstName>C M</ns1:PersonFirstName>\r\n" + 
				"            <ns1:PersonMiddleName xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PersonLastName>Dhananjaya</ns1:PersonLastName>\r\n" + 
				"            <ns1:PersonNameSuffix xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PersonTitle>Mr.</ns1:PersonTitle>\r\n" + 
				"            <ns1:PersonAcademicTitle xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PersonPreviousLastName xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PersonInitials xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:JgzzFiscalCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:DateOfBirth>1963-06-07</ns1:DateOfBirth>\r\n" + 
				"            <ns1:PlaceOfBirth xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:DateOfDeath xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:Gender>MALE</ns1:Gender>\r\n" + 
				"            <ns1:DeclaredEthnicity xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:MaritalStatus>M</ns1:MaritalStatus>\r\n" + 
				"            <ns1:MaritalStatusEffectiveDate xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PersonalIncomeAmount xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:RentOwnInd xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:LastKnownGPS xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:EffectiveStartDate>2018-06-08</ns1:EffectiveStartDate>\r\n" + 
				"            <ns1:EffectiveEndDate>4712-12-31</ns1:EffectiveEndDate>\r\n" + 
				"            <ns1:InternalFlag>false</ns1:InternalFlag>\r\n" + 
				"            <ns1:Status>A</ns1:Status>\r\n" + 
				"            <ns1:CreatedByModule>HZ_IMPORT</ns1:CreatedByModule>\r\n" + 
				"            <ns1:DeceasedFlag>false</ns1:DeceasedFlag>\r\n" + 
				"            <ns1:Comments xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PersonLastNamePrefix xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PersonSecondLastName xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PreferredFunctionalCurrency xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:OrigSystem xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:OrigSystemReference>1-4OG-5578</ns1:OrigSystemReference>\r\n" + 
				"            <ns1:EffectiveSequence>1</ns1:EffectiveSequence>\r\n" + 
				"            <ns1:HeadOfHouseholdFlag xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:HouseholdIncomeAmount xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:HouseholdSize xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:EffectiveLatestChange>Y</ns1:EffectiveLatestChange>\r\n" + 
				"            <ns1:SuffixOverriddenFlag>true</ns1:SuffixOverriddenFlag>\r\n" + 
				"            <ns1:UniqueNameSuffix xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:CorpCurrencyCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:CurcyConvRateType xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:CurrencyCode>USD</ns1:CurrencyCode>\r\n" + 
				"            <ns1:PartyNumber>4051031</ns1:PartyNumber>\r\n" + 
				"            <ns1:Salutation xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:CertReasonCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:CertificationLevel xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PreferredContactMethod xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PreferredContactPersonId xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryAddressLine1>No 255 Sai Krupa</ns1:PrimaryAddressLine1>\r\n" + 
				"            <ns1:PrimaryAddressLine2>6Th Cross 1St Stage</ns1:PrimaryAddressLine2>\r\n" + 
				"            <ns1:PrimaryAddressLine3>Indira Nagar</ns1:PrimaryAddressLine3>\r\n" + 
				"            <ns1:PrimaryAddressLine4 xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:Alias xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryAddressCity>BANGALORE</ns1:PrimaryAddressCity>\r\n" + 
				"            <ns1:PrimaryAddressCountry>IN</ns1:PrimaryAddressCountry>\r\n" + 
				"            <ns1:PrimaryAddressCounty xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryEmailAddress>cmdlawasociates@yahoo.co.in</ns1:PrimaryEmailAddress>\r\n" + 
				"            <ns1:PrimaryFormattedAddress>No 255 Sai Krupa,6Th Cross 1St Stage,Indira Nagar,BANGALORE-560038,KA</ns1:PrimaryFormattedAddress>\r\n" + 
				"            <ns1:PrimaryFormattedPhoneNumber>919845021675</ns1:PrimaryFormattedPhoneNumber>\r\n" + 
				"            <ns1:PrimaryLanguage xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PartyUniqueName>C M Dhananjaya</ns1:PartyUniqueName>\r\n" + 
				"            <ns1:PrimaryAddressPostalCode>560038</ns1:PrimaryAddressPostalCode>\r\n" + 
				"            <ns1:PreferredContactEmail xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PreferredContactName xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PreferredContactPhone xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PreferredContactURL xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PreferredName xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PreferredNameId xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryEmailId>300000907524060</ns1:PrimaryEmailId>\r\n" + 
				"            <ns1:PrimaryPhoneAreaCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryPhoneId>300000907524061</ns1:PrimaryPhoneId>\r\n" + 
				"            <ns1:PrimaryPhoneCountryCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryPhoneExtension xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryPhoneLineType>WORK</ns1:PrimaryPhoneLineType>\r\n" + 
				"            <ns1:PrimaryPhoneNumber>+919845021675</ns1:PrimaryPhoneNumber>\r\n" + 
				"            <ns1:PrimaryPhonePurpose xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryWebId xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:Pronunciation xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryAddressProvince xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryAddressState>KA</ns1:PrimaryAddressState>\r\n" + 
				"            <ns1:PrimaryURL xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:ValidatedFlag>false</ns1:ValidatedFlag>\r\n" + 
				"            <ns1:PrimaryAddressLatitude xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryAddressLongitude xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryAddressLocationId>100000108571602</ns1:PrimaryAddressLocationId>\r\n" + 
				"            <ns1:FavoriteContactFlag>false</ns1:FavoriteContactFlag>\r\n" + 
				"            <ns1:Distance xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:SalesAffinityCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:SalesBuyingRoleCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:DepartmentCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:Department xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:JobTitleCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:JobTitle xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:DoNotCallFlag>false</ns1:DoNotCallFlag>\r\n" + 
				"            <ns1:DoNotContactFlag>false</ns1:DoNotContactFlag>\r\n" + 
				"            <ns1:DoNotEmailFlag>false</ns1:DoNotEmailFlag>\r\n" + 
				"            <ns1:DoNotMailFlag>false</ns1:DoNotMailFlag>\r\n" + 
				"            <ns1:LastContactDate xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryCustomerId xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryCustomerRelationshipId xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrimaryCustomerName xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:LastSourceUpdateDate>2019-05-18T10:38:48.0Z</ns1:LastSourceUpdateDate>\r\n" + 
				"            <ns1:LastUpdateSourceSystem>SIEBEL</ns1:LastUpdateSourceSystem>\r\n" + 
				"            <ns1:DataCloudStatus xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:LastEnrichmentDate xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PersonInformation>\r\n" + 
				"              <ns2:PersonProfileId>100000088640991</ns2:PersonProfileId>\r\n" + 
				"              <ns2:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"              <ns2:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"              <ns2:_FLEX_NumOfSegments>0</ns2:_FLEX_NumOfSegments>\r\n" + 
				"            </ns1:PersonInformation>\r\n" + 
				"            <ns1:Secretary_Id_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:Secretary_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:ChamberMember_c>false</ns1:ChamberMember_c>\r\n" + 
				"            <ns1:Category_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:ContactLevel_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:OtherSalutation_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:SpouseName_c>Lilavathi</ns1:SpouseName_c>\r\n" + 
				"            <ns1:SecretaryFormulaField_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:LoyaltyMembership_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:Tier_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:LoyaltyMembershipNumber_c>2019-05-06 13:35:50.648</ns1:LoyaltyMembershipNumber_c>\r\n" + 
				"            <ns1:MembershipNumber_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:Passport_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:DateOfBirth_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:ChamberMembershipNumber_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:AccountCity_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:AccountCity1_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:Association_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PANNumber_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:ProfileCreatedAtChannel_c>Partner</ns1:ProfileCreatedAtChannel_c>\r\n" + 
				"            <ns1:ProfileCreatedAtProperty_c>American Express</ns1:ProfileCreatedAtProperty_c>\r\n" + 
				"            <ns1:ProfileCreatedBy_c>EIMADMIN</ns1:ProfileCreatedBy_c>\r\n" + 
				"            <ns1:ProfileCreatedDate_c>2014-07-11</ns1:ProfileCreatedDate_c>\r\n" + 
				"            <ns1:ProfileUpdatedBy_c>SADMIN</ns1:ProfileUpdatedBy_c>\r\n" + 
				"            <ns1:ProfileUpdatedDate_c>2019-05-15</ns1:ProfileUpdatedDate_c>\r\n" + 
				"            <ns1:NationalityLOV_c>IN</ns1:NationalityLOV_c>\r\n" + 
				"            <ns1:SpouseBirthday_c>1973-01-13</ns1:SpouseBirthday_c>\r\n" + 
				"            <ns1:AnniversaryDate_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:LegalCompany_c>Dhananjaya Associates</ns1:LegalCompany_c>\r\n" + 
				"            <ns1:AadhaarNumber_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:LicenseNumber_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:VIPLOV_c>0</ns1:VIPLOV_c>\r\n" + 
				"            <ns1:Profession_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:MUI_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:LastUpdateSource_c>SIEBEL</ns1:LastUpdateSource_c>\r\n" + 
				"            <ns1:LanguagePreference_c>E</ns1:LanguagePreference_c>\r\n" + 
				"            <ns1:NotParticipateInMarketRea_c>false</ns1:NotParticipateInMarketRea_c>\r\n" + 
				"            <ns1:NotReceiveEmails_c>true</ns1:NotReceiveEmails_c>\r\n" + 
				"            <ns1:NotInfoFromThirdParty_c>false</ns1:NotInfoFromThirdParty_c>\r\n" + 
				"            <ns1:LicenseIDIssueDate_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PassportIDIssueDate_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:AadhaarIssueDate_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:LicenseIDIssuePlace_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PassportIDIssuePlace_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:AadhaarIssuePlace_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PassportIDExpiryDate_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:WebSite_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:PrivateWebpage_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:ARNo_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:Restricted_c>false</ns1:Restricted_c>\r\n" + 
				"            <ns1:RestrictRule_c xsi:nil=\"true\"/>\r\n" + 
				"            <ns1:CYNumber_c>2019</ns1:CYNumber_c>\r\n" + 
				"            <ns1:LYNumber_c>2018</ns1:LYNumber_c>\r\n" + 
				"            <ns1:Days_c>50</ns1:Days_c>\r\n" + 
				"            <ns1:PMSFlag_c>true</ns1:PMSFlag_c>\r\n" + 
				"            <ns1:PMSLastUpdateSource_c>DXBTD</ns1:PMSLastUpdateSource_c>\r\n" + 
				"            <ns1:IAMUpdateFlag_c>N</ns1:IAMUpdateFlag_c>\r\n" + 
				"            <ns1:LoyaltyMembershipsCollection_c>\r\n" + 
				"              <ns1:Id>300000453595938</ns1:Id>\r\n" + 
				"              <ns1:RecordName>1-5MCZQD3</ns1:RecordName>\r\n" + 
				"              <ns1:CreatedBy>Datacentre</ns1:CreatedBy>\r\n" + 
				"              <ns1:CreationDate>2018-06-18T11:48:17.222861Z</ns1:CreationDate>\r\n" + 
				"              <ns1:LastUpdatedBy>siebelscheduler</ns1:LastUpdatedBy>\r\n" + 
				"              <ns1:LastUpdateDate>2019-05-06T13:35:50.425Z</ns1:LastUpdateDate>\r\n" + 
				"              <ns1:ObjectVersionNumber>5</ns1:ObjectVersionNumber>\r\n" + 
				"              <ns1:PersonProfile_Id_c>100000088640991</ns1:PersonProfile_Id_c>\r\n" + 
				"              <ns1:RecordNumber>11126052</ns1:RecordNumber>\r\n" + 
				"              <ns1:LastUpdateLogin xsi:nil=\"true\"/>\r\n" + 
				"              <ns1:UserLastUpdateDate xsi:nil=\"true\"/>\r\n" + 
				"              <ns1:CurrencyCode>INR</ns1:CurrencyCode>\r\n" + 
				"              <ns1:CurcyConvRateType>Corporate</ns1:CurcyConvRateType>\r\n" + 
				"              <ns1:CorpCurrencyCode>INR</ns1:CorpCurrencyCode>\r\n" + 
				"              <ns1:ContactID_c>1-1EF-588</ns1:ContactID_c>\r\n" + 
				"              <ns1:MemberSince_c>2006-10-11</ns1:MemberSince_c>\r\n" + 
				"              <ns1:MembershipCardNo_c>101010754080</ns1:MembershipCardNo_c>\r\n" + 
				"              <ns1:MembershipClass_c>Platinum</ns1:MembershipClass_c>\r\n" + 
				"              <ns1:MembershipDescription_c xsi:nil=\"true\"/>\r\n" + 
				"              <ns1:MembershipExpirationNew_c>2020-05-05</ns1:MembershipExpirationNew_c>\r\n" + 
				"              <ns1:MembershipLevel_c>Silver</ns1:MembershipLevel_c>\r\n" + 
				"              <ns1:MembershipType_c>Taj InnerCircle</ns1:MembershipType_c>\r\n" + 
				"              <ns1:NameOnCard_c>C M Dhananjaya</ns1:NameOnCard_c>\r\n" + 
				"              <ns1:InactiveNew_c>false</ns1:InactiveNew_c>\r\n" + 
				"              <ns1:MembershipTypeLOV_c>TAJ</ns1:MembershipTypeLOV_c>\r\n" + 
				"              <ns1:MembershipLevelLOV_c>TP</ns1:MembershipLevelLOV_c>\r\n" + 
				"              <ns1:MUI_temp_c xsi:nil=\"true\"/>\r\n" + 
				"            </ns1:LoyaltyMembershipsCollection_c>\r\n" + 
				"          </ns1:PersonProfile>\r\n" + 
				"          <ns1:PartyUsageAssignment>\r\n" + 
				"            <ns3:PartyUsgAssignmentId>100000089264208</ns3:PartyUsgAssignmentId>\r\n" + 
				"            <ns3:PartyId>100000088640991</ns3:PartyId>\r\n" + 
				"            <ns3:PartyUsageCode>CONTACT</ns3:PartyUsageCode>\r\n" + 
				"            <ns3:EffectiveStartDate>2018-06-08</ns3:EffectiveStartDate>\r\n" + 
				"            <ns3:EffectiveEndDate>4712-12-31</ns3:EffectiveEndDate>\r\n" + 
				"            <ns3:StatusFlag>true</ns3:StatusFlag>\r\n" + 
				"            <ns3:Comments xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:OwnerTableName xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:OwnerTableId xsi:nil=\"true\"/>\r\n" + 
				"            <ns3:CreatedByModule>HZ_IMPORT</ns3:CreatedByModule>\r\n" + 
				"            <ns3:ObjectVersionNumber>1</ns3:ObjectVersionNumber>\r\n" + 
				"            <ns3:CreatedBy>Datacentre</ns3:CreatedBy>\r\n" + 
				"            <ns3:CreationDate>2018-06-08T06:32:25.411959Z</ns3:CreationDate>\r\n" + 
				"            <ns3:LastUpdateLogin>-1</ns3:LastUpdateLogin>\r\n" + 
				"            <ns3:LastUpdateDate>2018-06-08T06:32:25.411959Z</ns3:LastUpdateDate>\r\n" + 
				"            <ns3:LastUpdatedBy>Datacentre</ns3:LastUpdatedBy>\r\n" + 
				"            <ns3:RequestId>74571</ns3:RequestId>\r\n" + 
				"          </ns1:PartyUsageAssignment>\r\n" + 
				"          <ns1:Phone xmlns:ns6=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/contactPoint/\">\r\n" + 
				"            <ns5:ContactPointId>100000117475866</ns5:ContactPointId>\r\n" + 
				"            <ns5:ContactPointType>PHONE</ns5:ContactPointType>\r\n" + 
				"            <ns5:Status>A</ns5:Status>\r\n" + 
				"            <ns5:OwnerTableName>HZ_PARTIES</ns5:OwnerTableName>\r\n" + 
				"            <ns5:OwnerTableId>100000088640991</ns5:OwnerTableId>\r\n" + 
				"            <ns5:PrimaryFlag>false</ns5:PrimaryFlag>\r\n" + 
				"            <ns5:OrigSystemReference xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:LastUpdateDate>2019-01-09T08:44:17.654127Z</ns5:LastUpdateDate>\r\n" + 
				"            <ns5:LastUpdatedBy>FUSION_APPS_CRM_ESS_APPID</ns5:LastUpdatedBy>\r\n" + 
				"            <ns5:CreationDate>2018-06-13T07:13:49.595158Z</ns5:CreationDate>\r\n" + 
				"            <ns5:CreatedBy>Datacentre</ns5:CreatedBy>\r\n" + 
				"            <ns5:LastUpdateLogin>7EFC90018141CEE6E0530A67360AE51C</ns5:LastUpdateLogin>\r\n" + 
				"            <ns5:RequestId>273465</ns5:RequestId>\r\n" + 
				"            <ns5:ObjectVersionNumber>8</ns5:ObjectVersionNumber>\r\n" + 
				"            <ns5:CreatedByModule>HZ_IMPORT</ns5:CreatedByModule>\r\n" + 
				"            <ns5:ContactPointPurpose>BUSINESS</ns5:ContactPointPurpose>\r\n" + 
				"            <ns5:PrimaryByPurpose>N</ns5:PrimaryByPurpose>\r\n" + 
				"            <ns5:StartDate>2018-06-13</ns5:StartDate>\r\n" + 
				"            <ns5:EndDate>4712-12-31</ns5:EndDate>\r\n" + 
				"            <ns5:RelationshipId xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PartyUsageCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:OrigSystem xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PhoneCallingCalendar xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:LastContactDtTime xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PhoneAreaCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PhoneCountryCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PhoneNumber>918025255985</ns5:PhoneNumber>\r\n" + 
				"            <ns5:PhoneExtension xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PhoneLineType>WORK</ns5:PhoneLineType>\r\n" + 
				"            <ns5:RawPhoneNumber>918025255985</ns5:RawPhoneNumber>\r\n" + 
				"            <ns5:PagerTypeCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:FormattedPhoneNumber>918025255985</ns5:FormattedPhoneNumber>\r\n" + 
				"            <ns5:TransposedPhoneNumber>589552520819</ns5:TransposedPhoneNumber>\r\n" + 
				"            <ns5:PartyName>C M Dhananjaya</ns5:PartyName>\r\n" + 
				"            <ns5:TimezoneCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:OverallPrimaryFlag>false</ns5:OverallPrimaryFlag>\r\n" + 
				"            <ns5:OriginalSystemReference xmlns:ns4=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/sourceSystemRef/\">\r\n" + 
				"              <ns3:OrigSystemReferenceId>100000117787345</ns3:OrigSystemReferenceId>\r\n" + 
				"              <ns3:OrigSystem>SIEBEL</ns3:OrigSystem>\r\n" + 
				"              <ns3:OrigSystemReference>300000412894999</ns3:OrigSystemReference>\r\n" + 
				"              <ns3:OwnerTableName>HZ_CONTACT_POINTS</ns3:OwnerTableName>\r\n" + 
				"              <ns3:OwnerTableId>100000117475866</ns3:OwnerTableId>\r\n" + 
				"              <ns3:Status>A</ns3:Status>\r\n" + 
				"              <ns3:ReasonCode xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:OldOrigSystemReference xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:StartDateActive>2018-06-13</ns3:StartDateActive>\r\n" + 
				"              <ns3:EndDateActive>4712-12-31</ns3:EndDateActive>\r\n" + 
				"              <ns3:CreatedBy>Datacentre</ns3:CreatedBy>\r\n" + 
				"              <ns3:CreationDate>2018-06-13T07:14:40.974157Z</ns3:CreationDate>\r\n" + 
				"              <ns3:LastUpdatedBy>Datacentre</ns3:LastUpdatedBy>\r\n" + 
				"              <ns3:LastUpdateDate>2018-06-13T07:14:40.974157Z</ns3:LastUpdateDate>\r\n" + 
				"              <ns3:LastUpdateLogin>-1</ns3:LastUpdateLogin>\r\n" + 
				"              <ns3:ObjectVersionNumber>1</ns3:ObjectVersionNumber>\r\n" + 
				"              <ns3:CreatedByModule>HZ_IMPORT</ns3:CreatedByModule>\r\n" + 
				"              <ns3:PartyId>100000088640991</ns3:PartyId>\r\n" + 
				"              <ns3:RequestId>-99999</ns3:RequestId>\r\n" + 
				"              <ns3:SourceSystemRefInformation>\r\n" + 
				"                <ns4:OrigSystemRefId>100000117787345</ns4:OrigSystemRefId>\r\n" + 
				"                <ns4:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"                <ns4:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"                <ns4:_FLEX_NumOfSegments>0</ns4:_FLEX_NumOfSegments>\r\n" + 
				"              </ns3:SourceSystemRefInformation>\r\n" + 
				"            </ns5:OriginalSystemReference>\r\n" + 
				"            <ns5:PhoneInformation>\r\n" + 
				"              <ns6:ContactPointId>100000117475866</ns6:ContactPointId>\r\n" + 
				"              <ns6:ContactPointType>PHONE</ns6:ContactPointType>\r\n" + 
				"              <ns6:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"              <ns6:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"              <ns6:_FLEX_NumOfSegments>0</ns6:_FLEX_NumOfSegments>\r\n" + 
				"            </ns5:PhoneInformation>\r\n" + 
				"          </ns1:Phone>\r\n" + 
				"          <ns1:Phone xmlns:ns6=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/contactPoint/\">\r\n" + 
				"            <ns5:ContactPointId>100000117475867</ns5:ContactPointId>\r\n" + 
				"            <ns5:ContactPointType>PHONE</ns5:ContactPointType>\r\n" + 
				"            <ns5:Status>A</ns5:Status>\r\n" + 
				"            <ns5:OwnerTableName>HZ_PARTIES</ns5:OwnerTableName>\r\n" + 
				"            <ns5:OwnerTableId>100000088640991</ns5:OwnerTableId>\r\n" + 
				"            <ns5:PrimaryFlag>false</ns5:PrimaryFlag>\r\n" + 
				"            <ns5:OrigSystemReference xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:LastUpdateDate>2019-05-06T20:42:34.307Z</ns5:LastUpdateDate>\r\n" + 
				"            <ns5:LastUpdatedBy>siebelscheduler</ns5:LastUpdatedBy>\r\n" + 
				"            <ns5:CreationDate>2018-06-13T07:13:49.595158Z</ns5:CreationDate>\r\n" + 
				"            <ns5:CreatedBy>Datacentre</ns5:CreatedBy>\r\n" + 
				"            <ns5:LastUpdateLogin>883CDF95985ABF2BE0530A67360A76C2</ns5:LastUpdateLogin>\r\n" + 
				"            <ns5:RequestId>273465</ns5:RequestId>\r\n" + 
				"            <ns5:ObjectVersionNumber>5</ns5:ObjectVersionNumber>\r\n" + 
				"            <ns5:CreatedByModule>HZ_IMPORT</ns5:CreatedByModule>\r\n" + 
				"            <ns5:ContactPointPurpose>BUSINESS</ns5:ContactPointPurpose>\r\n" + 
				"            <ns5:PrimaryByPurpose>N</ns5:PrimaryByPurpose>\r\n" + 
				"            <ns5:StartDate>2018-06-13</ns5:StartDate>\r\n" + 
				"            <ns5:EndDate>4712-12-31</ns5:EndDate>\r\n" + 
				"            <ns5:RelationshipId xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PartyUsageCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:OrigSystem xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PhoneCallingCalendar xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:LastContactDtTime xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PhoneAreaCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PhoneCountryCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PhoneNumber>918025255985</ns5:PhoneNumber>\r\n" + 
				"            <ns5:PhoneExtension xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PhoneLineType>BUSINESS</ns5:PhoneLineType>\r\n" + 
				"            <ns5:RawPhoneNumber>918025255985</ns5:RawPhoneNumber>\r\n" + 
				"            <ns5:PagerTypeCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:FormattedPhoneNumber>918025255985</ns5:FormattedPhoneNumber>\r\n" + 
				"            <ns5:TransposedPhoneNumber>589552520819</ns5:TransposedPhoneNumber>\r\n" + 
				"            <ns5:PartyName>C M Dhananjaya</ns5:PartyName>\r\n" + 
				"            <ns5:TimezoneCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:OverallPrimaryFlag>false</ns5:OverallPrimaryFlag>\r\n" + 
				"            <ns5:OriginalSystemReference xmlns:ns4=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/sourceSystemRef/\">\r\n" + 
				"              <ns3:OrigSystemReferenceId>100000117787346</ns3:OrigSystemReferenceId>\r\n" + 
				"              <ns3:OrigSystem>SIEBEL</ns3:OrigSystem>\r\n" + 
				"              <ns3:OrigSystemReference>300000412895000</ns3:OrigSystemReference>\r\n" + 
				"              <ns3:OwnerTableName>HZ_CONTACT_POINTS</ns3:OwnerTableName>\r\n" + 
				"              <ns3:OwnerTableId>100000117475867</ns3:OwnerTableId>\r\n" + 
				"              <ns3:Status>A</ns3:Status>\r\n" + 
				"              <ns3:ReasonCode xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:OldOrigSystemReference xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:StartDateActive>2018-06-13</ns3:StartDateActive>\r\n" + 
				"              <ns3:EndDateActive>4712-12-31</ns3:EndDateActive>\r\n" + 
				"              <ns3:CreatedBy>Datacentre</ns3:CreatedBy>\r\n" + 
				"              <ns3:CreationDate>2018-06-13T07:14:40.974157Z</ns3:CreationDate>\r\n" + 
				"              <ns3:LastUpdatedBy>Datacentre</ns3:LastUpdatedBy>\r\n" + 
				"              <ns3:LastUpdateDate>2018-06-13T07:14:40.974157Z</ns3:LastUpdateDate>\r\n" + 
				"              <ns3:LastUpdateLogin>-1</ns3:LastUpdateLogin>\r\n" + 
				"              <ns3:ObjectVersionNumber>1</ns3:ObjectVersionNumber>\r\n" + 
				"              <ns3:CreatedByModule>HZ_IMPORT</ns3:CreatedByModule>\r\n" + 
				"              <ns3:PartyId>100000088640991</ns3:PartyId>\r\n" + 
				"              <ns3:RequestId>-99999</ns3:RequestId>\r\n" + 
				"              <ns3:SourceSystemRefInformation>\r\n" + 
				"                <ns4:OrigSystemRefId>100000117787346</ns4:OrigSystemRefId>\r\n" + 
				"                <ns4:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"                <ns4:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"                <ns4:_FLEX_NumOfSegments>0</ns4:_FLEX_NumOfSegments>\r\n" + 
				"              </ns3:SourceSystemRefInformation>\r\n" + 
				"            </ns5:OriginalSystemReference>\r\n" + 
				"            <ns5:PhoneInformation>\r\n" + 
				"              <ns6:ContactPointId>100000117475867</ns6:ContactPointId>\r\n" + 
				"              <ns6:ContactPointType>PHONE</ns6:ContactPointType>\r\n" + 
				"              <ns6:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"              <ns6:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"              <ns6:_FLEX_NumOfSegments>0</ns6:_FLEX_NumOfSegments>\r\n" + 
				"            </ns5:PhoneInformation>\r\n" + 
				"          </ns1:Phone>\r\n" + 
				"          <ns1:Phone xmlns:ns6=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/contactPoint/\">\r\n" + 
				"            <ns5:ContactPointId>100000117475868</ns5:ContactPointId>\r\n" + 
				"            <ns5:ContactPointType>PHONE</ns5:ContactPointType>\r\n" + 
				"            <ns5:Status>A</ns5:Status>\r\n" + 
				"            <ns5:OwnerTableName>HZ_PARTIES</ns5:OwnerTableName>\r\n" + 
				"            <ns5:OwnerTableId>100000088640991</ns5:OwnerTableId>\r\n" + 
				"            <ns5:PrimaryFlag>false</ns5:PrimaryFlag>\r\n" + 
				"            <ns5:OrigSystemReference xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:LastUpdateDate>2019-05-06T20:42:34.316Z</ns5:LastUpdateDate>\r\n" + 
				"            <ns5:LastUpdatedBy>siebelscheduler</ns5:LastUpdatedBy>\r\n" + 
				"            <ns5:CreationDate>2018-06-13T07:13:49.595158Z</ns5:CreationDate>\r\n" + 
				"            <ns5:CreatedBy>Datacentre</ns5:CreatedBy>\r\n" + 
				"            <ns5:LastUpdateLogin>883CDF95985ABF2BE0530A67360A76C2</ns5:LastUpdateLogin>\r\n" + 
				"            <ns5:RequestId>273465</ns5:RequestId>\r\n" + 
				"            <ns5:ObjectVersionNumber>7</ns5:ObjectVersionNumber>\r\n" + 
				"            <ns5:CreatedByModule>HZ_IMPORT</ns5:CreatedByModule>\r\n" + 
				"            <ns5:ContactPointPurpose>BUSINESS</ns5:ContactPointPurpose>\r\n" + 
				"            <ns5:PrimaryByPurpose>N</ns5:PrimaryByPurpose>\r\n" + 
				"            <ns5:StartDate>2018-06-13</ns5:StartDate>\r\n" + 
				"            <ns5:EndDate>4712-12-31</ns5:EndDate>\r\n" + 
				"            <ns5:RelationshipId xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PartyUsageCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:OrigSystem xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PhoneCallingCalendar xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:LastContactDtTime xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PhoneAreaCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PhoneCountryCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PhoneNumber>919845021675</ns5:PhoneNumber>\r\n" + 
				"            <ns5:PhoneExtension xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PhoneLineType>WORK</ns5:PhoneLineType>\r\n" + 
				"            <ns5:RawPhoneNumber>919845021675</ns5:RawPhoneNumber>\r\n" + 
				"            <ns5:PagerTypeCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:FormattedPhoneNumber>919845021675</ns5:FormattedPhoneNumber>\r\n" + 
				"            <ns5:TransposedPhoneNumber>576120548919</ns5:TransposedPhoneNumber>\r\n" + 
				"            <ns5:PartyName>C M Dhananjaya</ns5:PartyName>\r\n" + 
				"            <ns5:TimezoneCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:OverallPrimaryFlag>false</ns5:OverallPrimaryFlag>\r\n" + 
				"            <ns5:OriginalSystemReference xmlns:ns4=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/sourceSystemRef/\">\r\n" + 
				"              <ns3:OrigSystemReferenceId>100000117787347</ns3:OrigSystemReferenceId>\r\n" + 
				"              <ns3:OrigSystem>SIEBEL</ns3:OrigSystem>\r\n" + 
				"              <ns3:OrigSystemReference>300000412895001</ns3:OrigSystemReference>\r\n" + 
				"              <ns3:OwnerTableName>HZ_CONTACT_POINTS</ns3:OwnerTableName>\r\n" + 
				"              <ns3:OwnerTableId>100000117475868</ns3:OwnerTableId>\r\n" + 
				"              <ns3:Status>A</ns3:Status>\r\n" + 
				"              <ns3:ReasonCode xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:OldOrigSystemReference xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:StartDateActive>2018-06-13</ns3:StartDateActive>\r\n" + 
				"              <ns3:EndDateActive>4712-12-31</ns3:EndDateActive>\r\n" + 
				"              <ns3:CreatedBy>Datacentre</ns3:CreatedBy>\r\n" + 
				"              <ns3:CreationDate>2018-06-13T07:14:40.974157Z</ns3:CreationDate>\r\n" + 
				"              <ns3:LastUpdatedBy>Datacentre</ns3:LastUpdatedBy>\r\n" + 
				"              <ns3:LastUpdateDate>2018-06-13T07:14:40.974157Z</ns3:LastUpdateDate>\r\n" + 
				"              <ns3:LastUpdateLogin>-1</ns3:LastUpdateLogin>\r\n" + 
				"              <ns3:ObjectVersionNumber>1</ns3:ObjectVersionNumber>\r\n" + 
				"              <ns3:CreatedByModule>HZ_IMPORT</ns3:CreatedByModule>\r\n" + 
				"              <ns3:PartyId>100000088640991</ns3:PartyId>\r\n" + 
				"              <ns3:RequestId>-99999</ns3:RequestId>\r\n" + 
				"              <ns3:SourceSystemRefInformation>\r\n" + 
				"                <ns4:OrigSystemRefId>100000117787347</ns4:OrigSystemRefId>\r\n" + 
				"                <ns4:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"                <ns4:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"                <ns4:_FLEX_NumOfSegments>0</ns4:_FLEX_NumOfSegments>\r\n" + 
				"              </ns3:SourceSystemRefInformation>\r\n" + 
				"            </ns5:OriginalSystemReference>\r\n" + 
				"            <ns5:PhoneInformation>\r\n" + 
				"              <ns6:ContactPointId>100000117475868</ns6:ContactPointId>\r\n" + 
				"              <ns6:ContactPointType>PHONE</ns6:ContactPointType>\r\n" + 
				"              <ns6:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"              <ns6:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"              <ns6:_FLEX_NumOfSegments>0</ns6:_FLEX_NumOfSegments>\r\n" + 
				"            </ns5:PhoneInformation>\r\n" + 
				"          </ns1:Phone>\r\n" + 
				"          <ns1:Phone xmlns:ns6=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/contactPoint/\">\r\n" + 
				"            <ns5:ContactPointId>300000675276166</ns5:ContactPointId>\r\n" + 
				"            <ns5:ContactPointType>PHONE</ns5:ContactPointType>\r\n" + 
				"            <ns5:Status>A</ns5:Status>\r\n" + 
				"            <ns5:OwnerTableName>HZ_PARTIES</ns5:OwnerTableName>\r\n" + 
				"            <ns5:OwnerTableId>100000088640991</ns5:OwnerTableId>\r\n" + 
				"            <ns5:PrimaryFlag>false</ns5:PrimaryFlag>\r\n" + 
				"            <ns5:OrigSystemReference>1-J92V-115</ns5:OrigSystemReference>\r\n" + 
				"            <ns5:LastUpdateDate>2019-01-09T08:44:17.654127Z</ns5:LastUpdateDate>\r\n" + 
				"            <ns5:LastUpdatedBy>FUSION_APPS_CRM_ESS_APPID</ns5:LastUpdatedBy>\r\n" + 
				"            <ns5:CreationDate>2018-08-30T06:30:14.022Z</ns5:CreationDate>\r\n" + 
				"            <ns5:CreatedBy>Datacentre</ns5:CreatedBy>\r\n" + 
				"            <ns5:LastUpdateLogin>7EFC90018141CEE6E0530A67360AE51C</ns5:LastUpdateLogin>\r\n" + 
				"            <ns5:RequestId>273465</ns5:RequestId>\r\n" + 
				"            <ns5:ObjectVersionNumber>3</ns5:ObjectVersionNumber>\r\n" + 
				"            <ns5:CreatedByModule>HZ_WS</ns5:CreatedByModule>\r\n" + 
				"            <ns5:ContactPointPurpose xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PrimaryByPurpose>N</ns5:PrimaryByPurpose>\r\n" + 
				"            <ns5:StartDate>2018-08-30</ns5:StartDate>\r\n" + 
				"            <ns5:EndDate>4712-12-31</ns5:EndDate>\r\n" + 
				"            <ns5:RelationshipId xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PartyUsageCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:OrigSystem xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PhoneCallingCalendar xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:LastContactDtTime xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PhoneAreaCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PhoneCountryCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PhoneNumber>+919845021675</ns5:PhoneNumber>\r\n" + 
				"            <ns5:PhoneExtension xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PhoneLineType>WORK</ns5:PhoneLineType>\r\n" + 
				"            <ns5:RawPhoneNumber>+919845021675</ns5:RawPhoneNumber>\r\n" + 
				"            <ns5:PagerTypeCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:FormattedPhoneNumber>919845021675</ns5:FormattedPhoneNumber>\r\n" + 
				"            <ns5:TransposedPhoneNumber>576120548919</ns5:TransposedPhoneNumber>\r\n" + 
				"            <ns5:PartyName>C M Dhananjaya</ns5:PartyName>\r\n" + 
				"            <ns5:TimezoneCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:OverallPrimaryFlag>false</ns5:OverallPrimaryFlag>\r\n" + 
				"            <ns5:PhoneInformation>\r\n" + 
				"              <ns6:ContactPointId>300000675276166</ns6:ContactPointId>\r\n" + 
				"              <ns6:ContactPointType>PHONE</ns6:ContactPointType>\r\n" + 
				"              <ns6:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"              <ns6:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"              <ns6:_FLEX_NumOfSegments>0</ns6:_FLEX_NumOfSegments>\r\n" + 
				"            </ns5:PhoneInformation>\r\n" + 
				"          </ns1:Phone>\r\n" + 
				"          <ns1:Phone xmlns:ns6=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/contactPoint/\">\r\n" + 
				"            <ns5:ContactPointId>300000911602426</ns5:ContactPointId>\r\n" + 
				"            <ns5:ContactPointType>PHONE</ns5:ContactPointType>\r\n" + 
				"            <ns5:Status>A</ns5:Status>\r\n" + 
				"            <ns5:OwnerTableName>HZ_PARTIES</ns5:OwnerTableName>\r\n" + 
				"            <ns5:OwnerTableId>100000088640991</ns5:OwnerTableId>\r\n" + 
				"            <ns5:PrimaryFlag>false</ns5:PrimaryFlag>\r\n" + 
				"            <ns5:OrigSystemReference>SP_1-B37D6MK</ns5:OrigSystemReference>\r\n" + 
				"            <ns5:LastUpdateDate>2019-05-18T10:38:48.295Z</ns5:LastUpdateDate>\r\n" + 
				"            <ns5:LastUpdatedBy>siebelscheduler</ns5:LastUpdatedBy>\r\n" + 
				"            <ns5:CreationDate>2019-05-18T10:38:48.033Z</ns5:CreationDate>\r\n" + 
				"            <ns5:CreatedBy>siebelscheduler</ns5:CreatedBy>\r\n" + 
				"            <ns5:LastUpdateLogin>892816F5FF4F7988E0530A67360A5691</ns5:LastUpdateLogin>\r\n" + 
				"            <ns5:RequestId xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:ObjectVersionNumber>1</ns5:ObjectVersionNumber>\r\n" + 
				"            <ns5:CreatedByModule>HZ_WS</ns5:CreatedByModule>\r\n" + 
				"            <ns5:ContactPointPurpose xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PrimaryByPurpose>N</ns5:PrimaryByPurpose>\r\n" + 
				"            <ns5:StartDate>2019-05-18</ns5:StartDate>\r\n" + 
				"            <ns5:EndDate>4712-12-31</ns5:EndDate>\r\n" + 
				"            <ns5:RelationshipId xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PartyUsageCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:OrigSystem xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PhoneCallingCalendar xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:LastContactDtTime xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PhoneAreaCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PhoneCountryCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PhoneNumber>918025255985</ns5:PhoneNumber>\r\n" + 
				"            <ns5:PhoneExtension xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PhoneLineType>BUSINESS</ns5:PhoneLineType>\r\n" + 
				"            <ns5:RawPhoneNumber>918025255985</ns5:RawPhoneNumber>\r\n" + 
				"            <ns5:PagerTypeCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:FormattedPhoneNumber>918025255985</ns5:FormattedPhoneNumber>\r\n" + 
				"            <ns5:TransposedPhoneNumber>589552520819</ns5:TransposedPhoneNumber>\r\n" + 
				"            <ns5:PartyName>C M Dhananjaya</ns5:PartyName>\r\n" + 
				"            <ns5:TimezoneCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:OverallPrimaryFlag>false</ns5:OverallPrimaryFlag>\r\n" + 
				"            <ns5:PhoneInformation>\r\n" + 
				"              <ns6:ContactPointId>300000911602426</ns6:ContactPointId>\r\n" + 
				"              <ns6:ContactPointType>PHONE</ns6:ContactPointType>\r\n" + 
				"              <ns6:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"              <ns6:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"              <ns6:_FLEX_NumOfSegments>0</ns6:_FLEX_NumOfSegments>\r\n" + 
				"            </ns5:PhoneInformation>\r\n" + 
				"          </ns1:Phone>\r\n" + 
				"          <ns1:Phone xmlns:ns6=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/contactPoint/\">\r\n" + 
				"            <ns5:ContactPointId>300000911602427</ns5:ContactPointId>\r\n" + 
				"            <ns5:ContactPointType>PHONE</ns5:ContactPointType>\r\n" + 
				"            <ns5:Status>A</ns5:Status>\r\n" + 
				"            <ns5:OwnerTableName>HZ_PARTIES</ns5:OwnerTableName>\r\n" + 
				"            <ns5:OwnerTableId>100000088640991</ns5:OwnerTableId>\r\n" + 
				"            <ns5:PrimaryFlag>false</ns5:PrimaryFlag>\r\n" + 
				"            <ns5:OrigSystemReference>SP_1-B37D6MM</ns5:OrigSystemReference>\r\n" + 
				"            <ns5:LastUpdateDate>2019-05-18T10:38:48.314Z</ns5:LastUpdateDate>\r\n" + 
				"            <ns5:LastUpdatedBy>siebelscheduler</ns5:LastUpdatedBy>\r\n" + 
				"            <ns5:CreationDate>2019-05-18T10:38:48.057Z</ns5:CreationDate>\r\n" + 
				"            <ns5:CreatedBy>siebelscheduler</ns5:CreatedBy>\r\n" + 
				"            <ns5:LastUpdateLogin>892816F5FF4F7988E0530A67360A5691</ns5:LastUpdateLogin>\r\n" + 
				"            <ns5:RequestId xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:ObjectVersionNumber>1</ns5:ObjectVersionNumber>\r\n" + 
				"            <ns5:CreatedByModule>HZ_WS</ns5:CreatedByModule>\r\n" + 
				"            <ns5:ContactPointPurpose xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PrimaryByPurpose>N</ns5:PrimaryByPurpose>\r\n" + 
				"            <ns5:StartDate>2019-05-18</ns5:StartDate>\r\n" + 
				"            <ns5:EndDate>4712-12-31</ns5:EndDate>\r\n" + 
				"            <ns5:RelationshipId xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PartyUsageCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:OrigSystem xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PhoneCallingCalendar xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:LastContactDtTime xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PhoneAreaCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PhoneCountryCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PhoneNumber>919845021675</ns5:PhoneNumber>\r\n" + 
				"            <ns5:PhoneExtension xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PhoneLineType>BUSINESS</ns5:PhoneLineType>\r\n" + 
				"            <ns5:RawPhoneNumber>919845021675</ns5:RawPhoneNumber>\r\n" + 
				"            <ns5:PagerTypeCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:FormattedPhoneNumber>919845021675</ns5:FormattedPhoneNumber>\r\n" + 
				"            <ns5:TransposedPhoneNumber>576120548919</ns5:TransposedPhoneNumber>\r\n" + 
				"            <ns5:PartyName>C M Dhananjaya</ns5:PartyName>\r\n" + 
				"            <ns5:TimezoneCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:OverallPrimaryFlag>false</ns5:OverallPrimaryFlag>\r\n" + 
				"            <ns5:PhoneInformation>\r\n" + 
				"              <ns6:ContactPointId>300000911602427</ns6:ContactPointId>\r\n" + 
				"              <ns6:ContactPointType>PHONE</ns6:ContactPointType>\r\n" + 
				"              <ns6:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"              <ns6:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"              <ns6:_FLEX_NumOfSegments>0</ns6:_FLEX_NumOfSegments>\r\n" + 
				"            </ns5:PhoneInformation>\r\n" + 
				"          </ns1:Phone>\r\n" + 
				"          <ns1:Phone xmlns:ns6=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/contactPoint/\">\r\n" + 
				"            <ns5:ContactPointId>300000911602428</ns5:ContactPointId>\r\n" + 
				"            <ns5:ContactPointType>PHONE</ns5:ContactPointType>\r\n" + 
				"            <ns5:Status>A</ns5:Status>\r\n" + 
				"            <ns5:OwnerTableName>HZ_PARTIES</ns5:OwnerTableName>\r\n" + 
				"            <ns5:OwnerTableId>100000088640991</ns5:OwnerTableId>\r\n" + 
				"            <ns5:PrimaryFlag>false</ns5:PrimaryFlag>\r\n" + 
				"            <ns5:OrigSystemReference>SP_1-B37D6MJ</ns5:OrigSystemReference>\r\n" + 
				"            <ns5:LastUpdateDate>2019-05-18T10:38:48.341Z</ns5:LastUpdateDate>\r\n" + 
				"            <ns5:LastUpdatedBy>siebelscheduler</ns5:LastUpdatedBy>\r\n" + 
				"            <ns5:CreationDate>2019-05-18T10:38:48.074Z</ns5:CreationDate>\r\n" + 
				"            <ns5:CreatedBy>siebelscheduler</ns5:CreatedBy>\r\n" + 
				"            <ns5:LastUpdateLogin>892816F5FF4F7988E0530A67360A5691</ns5:LastUpdateLogin>\r\n" + 
				"            <ns5:RequestId xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:ObjectVersionNumber>1</ns5:ObjectVersionNumber>\r\n" + 
				"            <ns5:CreatedByModule>HZ_WS</ns5:CreatedByModule>\r\n" + 
				"            <ns5:ContactPointPurpose xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PrimaryByPurpose>N</ns5:PrimaryByPurpose>\r\n" + 
				"            <ns5:StartDate>2019-05-18</ns5:StartDate>\r\n" + 
				"            <ns5:EndDate>4712-12-31</ns5:EndDate>\r\n" + 
				"            <ns5:RelationshipId xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PartyUsageCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:OrigSystem xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PhoneCallingCalendar xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:LastContactDtTime xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PhoneAreaCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PhoneCountryCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PhoneNumber>918025255985</ns5:PhoneNumber>\r\n" + 
				"            <ns5:PhoneExtension xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PhoneLineType>WORK</ns5:PhoneLineType>\r\n" + 
				"            <ns5:RawPhoneNumber>918025255985</ns5:RawPhoneNumber>\r\n" + 
				"            <ns5:PagerTypeCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:FormattedPhoneNumber>918025255985</ns5:FormattedPhoneNumber>\r\n" + 
				"            <ns5:TransposedPhoneNumber>589552520819</ns5:TransposedPhoneNumber>\r\n" + 
				"            <ns5:PartyName>C M Dhananjaya</ns5:PartyName>\r\n" + 
				"            <ns5:TimezoneCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:OverallPrimaryFlag>false</ns5:OverallPrimaryFlag>\r\n" + 
				"            <ns5:PhoneInformation>\r\n" + 
				"              <ns6:ContactPointId>300000911602428</ns6:ContactPointId>\r\n" + 
				"              <ns6:ContactPointType>PHONE</ns6:ContactPointType>\r\n" + 
				"              <ns6:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"              <ns6:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"              <ns6:_FLEX_NumOfSegments>0</ns6:_FLEX_NumOfSegments>\r\n" + 
				"            </ns5:PhoneInformation>\r\n" + 
				"          </ns1:Phone>\r\n" + 
				"          <ns1:Phone xmlns:ns6=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/contactPoint/\">\r\n" + 
				"            <ns5:ContactPointId>300000911602429</ns5:ContactPointId>\r\n" + 
				"            <ns5:ContactPointType>PHONE</ns5:ContactPointType>\r\n" + 
				"            <ns5:Status>A</ns5:Status>\r\n" + 
				"            <ns5:OwnerTableName>HZ_PARTIES</ns5:OwnerTableName>\r\n" + 
				"            <ns5:OwnerTableId>100000088640991</ns5:OwnerTableId>\r\n" + 
				"            <ns5:PrimaryFlag>false</ns5:PrimaryFlag>\r\n" + 
				"            <ns5:OrigSystemReference>SP_1-B37D6ML</ns5:OrigSystemReference>\r\n" + 
				"            <ns5:LastUpdateDate>2019-05-18T10:38:48.348Z</ns5:LastUpdateDate>\r\n" + 
				"            <ns5:LastUpdatedBy>siebelscheduler</ns5:LastUpdatedBy>\r\n" + 
				"            <ns5:CreationDate>2019-05-18T10:38:48.087Z</ns5:CreationDate>\r\n" + 
				"            <ns5:CreatedBy>siebelscheduler</ns5:CreatedBy>\r\n" + 
				"            <ns5:LastUpdateLogin>892816F5FF4F7988E0530A67360A5691</ns5:LastUpdateLogin>\r\n" + 
				"            <ns5:RequestId xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:ObjectVersionNumber>1</ns5:ObjectVersionNumber>\r\n" + 
				"            <ns5:CreatedByModule>HZ_WS</ns5:CreatedByModule>\r\n" + 
				"            <ns5:ContactPointPurpose xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PrimaryByPurpose>N</ns5:PrimaryByPurpose>\r\n" + 
				"            <ns5:StartDate>2019-05-18</ns5:StartDate>\r\n" + 
				"            <ns5:EndDate>4712-12-31</ns5:EndDate>\r\n" + 
				"            <ns5:RelationshipId xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PartyUsageCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:OrigSystem xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PhoneCallingCalendar xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:LastContactDtTime xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PhoneAreaCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PhoneCountryCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PhoneNumber>919845021675</ns5:PhoneNumber>\r\n" + 
				"            <ns5:PhoneExtension xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PhoneLineType>WORK</ns5:PhoneLineType>\r\n" + 
				"            <ns5:RawPhoneNumber>919845021675</ns5:RawPhoneNumber>\r\n" + 
				"            <ns5:PagerTypeCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:FormattedPhoneNumber>919845021675</ns5:FormattedPhoneNumber>\r\n" + 
				"            <ns5:TransposedPhoneNumber>576120548919</ns5:TransposedPhoneNumber>\r\n" + 
				"            <ns5:PartyName>C M Dhananjaya</ns5:PartyName>\r\n" + 
				"            <ns5:TimezoneCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:OverallPrimaryFlag>false</ns5:OverallPrimaryFlag>\r\n" + 
				"            <ns5:PhoneInformation>\r\n" + 
				"              <ns6:ContactPointId>300000911602429</ns6:ContactPointId>\r\n" + 
				"              <ns6:ContactPointType>PHONE</ns6:ContactPointType>\r\n" + 
				"              <ns6:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"              <ns6:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"              <ns6:_FLEX_NumOfSegments>0</ns6:_FLEX_NumOfSegments>\r\n" + 
				"            </ns5:PhoneInformation>\r\n" + 
				"          </ns1:Phone>\r\n" + 
				"          <ns1:Phone xmlns:ns6=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/contactPoint/\">\r\n" + 
				"            <ns5:ContactPointId>300000911604453</ns5:ContactPointId>\r\n" + 
				"            <ns5:ContactPointType>PHONE</ns5:ContactPointType>\r\n" + 
				"            <ns5:Status>A</ns5:Status>\r\n" + 
				"            <ns5:OwnerTableName>HZ_PARTIES</ns5:OwnerTableName>\r\n" + 
				"            <ns5:OwnerTableId>100000088640991</ns5:OwnerTableId>\r\n" + 
				"            <ns5:PrimaryFlag>false</ns5:PrimaryFlag>\r\n" + 
				"            <ns5:OrigSystemReference>PP_2019051810362055010</ns5:OrigSystemReference>\r\n" + 
				"            <ns5:LastUpdateDate>2019-05-18T10:38:48.335Z</ns5:LastUpdateDate>\r\n" + 
				"            <ns5:LastUpdatedBy>siebelscheduler</ns5:LastUpdatedBy>\r\n" + 
				"            <ns5:CreationDate>2019-05-18T10:36:26.094Z</ns5:CreationDate>\r\n" + 
				"            <ns5:CreatedBy>pms scheduler</ns5:CreatedBy>\r\n" + 
				"            <ns5:LastUpdateLogin>892816F5FF4F7988E0530A67360A5691</ns5:LastUpdateLogin>\r\n" + 
				"            <ns5:RequestId xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:ObjectVersionNumber>3</ns5:ObjectVersionNumber>\r\n" + 
				"            <ns5:CreatedByModule>HZ_WS</ns5:CreatedByModule>\r\n" + 
				"            <ns5:ContactPointPurpose xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PrimaryByPurpose>N</ns5:PrimaryByPurpose>\r\n" + 
				"            <ns5:StartDate>2019-05-18</ns5:StartDate>\r\n" + 
				"            <ns5:EndDate>4712-12-31</ns5:EndDate>\r\n" + 
				"            <ns5:RelationshipId xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PartyUsageCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:OrigSystem xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PhoneCallingCalendar xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:LastContactDtTime xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PhoneAreaCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PhoneCountryCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PhoneNumber>919845021675</ns5:PhoneNumber>\r\n" + 
				"            <ns5:PhoneExtension xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PhoneLineType>HOME</ns5:PhoneLineType>\r\n" + 
				"            <ns5:RawPhoneNumber>919845021675</ns5:RawPhoneNumber>\r\n" + 
				"            <ns5:PagerTypeCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:FormattedPhoneNumber>919845021675</ns5:FormattedPhoneNumber>\r\n" + 
				"            <ns5:TransposedPhoneNumber>576120548919</ns5:TransposedPhoneNumber>\r\n" + 
				"            <ns5:PartyName>C M Dhananjaya</ns5:PartyName>\r\n" + 
				"            <ns5:TimezoneCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:OverallPrimaryFlag>false</ns5:OverallPrimaryFlag>\r\n" + 
				"            <ns5:OriginalSystemReference xmlns:ns4=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/sourceSystemRef/\">\r\n" + 
				"              <ns3:OrigSystemReferenceId>300000911604457</ns3:OrigSystemReferenceId>\r\n" + 
				"              <ns3:OrigSystem>PMS</ns3:OrigSystem>\r\n" + 
				"              <ns3:OrigSystemReference>PP_2019051810362055010</ns3:OrigSystemReference>\r\n" + 
				"              <ns3:OwnerTableName>HZ_CONTACT_POINTS</ns3:OwnerTableName>\r\n" + 
				"              <ns3:OwnerTableId>300000911604453</ns3:OwnerTableId>\r\n" + 
				"              <ns3:Status>A</ns3:Status>\r\n" + 
				"              <ns3:ReasonCode xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:OldOrigSystemReference xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:StartDateActive>2019-05-18</ns3:StartDateActive>\r\n" + 
				"              <ns3:EndDateActive>4712-12-31</ns3:EndDateActive>\r\n" + 
				"              <ns3:CreatedBy>pms scheduler</ns3:CreatedBy>\r\n" + 
				"              <ns3:CreationDate>2019-05-18T10:36:26.31Z</ns3:CreationDate>\r\n" + 
				"              <ns3:LastUpdatedBy>pms scheduler</ns3:LastUpdatedBy>\r\n" + 
				"              <ns3:LastUpdateDate>2019-05-18T10:36:26.404Z</ns3:LastUpdateDate>\r\n" + 
				"              <ns3:LastUpdateLogin>8926CAD6B4FB226DE0530A67360AD46C</ns3:LastUpdateLogin>\r\n" + 
				"              <ns3:ObjectVersionNumber>1</ns3:ObjectVersionNumber>\r\n" + 
				"              <ns3:CreatedByModule>HZ_WS</ns3:CreatedByModule>\r\n" + 
				"              <ns3:PartyId>100000088640991</ns3:PartyId>\r\n" + 
				"              <ns3:RequestId xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:SourceSystemRefInformation>\r\n" + 
				"                <ns4:OrigSystemRefId>300000911604457</ns4:OrigSystemRefId>\r\n" + 
				"                <ns4:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"                <ns4:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"                <ns4:_FLEX_NumOfSegments>0</ns4:_FLEX_NumOfSegments>\r\n" + 
				"              </ns3:SourceSystemRefInformation>\r\n" + 
				"            </ns5:OriginalSystemReference>\r\n" + 
				"            <ns5:PhoneInformation>\r\n" + 
				"              <ns6:ContactPointId>300000911604453</ns6:ContactPointId>\r\n" + 
				"              <ns6:ContactPointType>PHONE</ns6:ContactPointType>\r\n" + 
				"              <ns6:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"              <ns6:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"              <ns6:_FLEX_NumOfSegments>0</ns6:_FLEX_NumOfSegments>\r\n" + 
				"            </ns5:PhoneInformation>\r\n" + 
				"          </ns1:Phone>\r\n" + 
				"          <ns1:Phone xmlns:ns6=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/contactPoint/\">\r\n" + 
				"            <ns5:ContactPointId>300000911604454</ns5:ContactPointId>\r\n" + 
				"            <ns5:ContactPointType>PHONE</ns5:ContactPointType>\r\n" + 
				"            <ns5:Status>A</ns5:Status>\r\n" + 
				"            <ns5:OwnerTableName>HZ_PARTIES</ns5:OwnerTableName>\r\n" + 
				"            <ns5:OwnerTableId>100000088640991</ns5:OwnerTableId>\r\n" + 
				"            <ns5:PrimaryFlag>false</ns5:PrimaryFlag>\r\n" + 
				"            <ns5:OrigSystemReference>PP_2019051810362011552</ns5:OrigSystemReference>\r\n" + 
				"            <ns5:LastUpdateDate>2019-05-18T10:36:40.013Z</ns5:LastUpdateDate>\r\n" + 
				"            <ns5:LastUpdatedBy>pms scheduler</ns5:LastUpdatedBy>\r\n" + 
				"            <ns5:CreationDate>2019-05-18T10:36:26.132Z</ns5:CreationDate>\r\n" + 
				"            <ns5:CreatedBy>pms scheduler</ns5:CreatedBy>\r\n" + 
				"            <ns5:LastUpdateLogin>8927FD3710158810E0530867360AB856</ns5:LastUpdateLogin>\r\n" + 
				"            <ns5:RequestId xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:ObjectVersionNumber>2</ns5:ObjectVersionNumber>\r\n" + 
				"            <ns5:CreatedByModule>HZ_WS</ns5:CreatedByModule>\r\n" + 
				"            <ns5:ContactPointPurpose xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PrimaryByPurpose>N</ns5:PrimaryByPurpose>\r\n" + 
				"            <ns5:StartDate>2019-05-18</ns5:StartDate>\r\n" + 
				"            <ns5:EndDate>4712-12-31</ns5:EndDate>\r\n" + 
				"            <ns5:RelationshipId xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PartyUsageCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:OrigSystem xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PhoneCallingCalendar xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:LastContactDtTime xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PhoneAreaCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PhoneCountryCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PhoneNumber>919845021675</ns5:PhoneNumber>\r\n" + 
				"            <ns5:PhoneExtension xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PhoneLineType>HOME</ns5:PhoneLineType>\r\n" + 
				"            <ns5:RawPhoneNumber>919845021675</ns5:RawPhoneNumber>\r\n" + 
				"            <ns5:PagerTypeCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:FormattedPhoneNumber>919845021675</ns5:FormattedPhoneNumber>\r\n" + 
				"            <ns5:TransposedPhoneNumber>576120548919</ns5:TransposedPhoneNumber>\r\n" + 
				"            <ns5:PartyName>C M Dhananjaya</ns5:PartyName>\r\n" + 
				"            <ns5:TimezoneCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:OverallPrimaryFlag>false</ns5:OverallPrimaryFlag>\r\n" + 
				"            <ns5:OriginalSystemReference xmlns:ns4=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/sourceSystemRef/\">\r\n" + 
				"              <ns3:OrigSystemReferenceId>300000911604458</ns3:OrigSystemReferenceId>\r\n" + 
				"              <ns3:OrigSystem>PMS</ns3:OrigSystem>\r\n" + 
				"              <ns3:OrigSystemReference>PP_2019051810362011552</ns3:OrigSystemReference>\r\n" + 
				"              <ns3:OwnerTableName>HZ_CONTACT_POINTS</ns3:OwnerTableName>\r\n" + 
				"              <ns3:OwnerTableId>300000911604454</ns3:OwnerTableId>\r\n" + 
				"              <ns3:Status>A</ns3:Status>\r\n" + 
				"              <ns3:ReasonCode xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:OldOrigSystemReference xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:StartDateActive>2019-05-18</ns3:StartDateActive>\r\n" + 
				"              <ns3:EndDateActive>4712-12-31</ns3:EndDateActive>\r\n" + 
				"              <ns3:CreatedBy>pms scheduler</ns3:CreatedBy>\r\n" + 
				"              <ns3:CreationDate>2019-05-18T10:36:26.358Z</ns3:CreationDate>\r\n" + 
				"              <ns3:LastUpdatedBy>pms scheduler</ns3:LastUpdatedBy>\r\n" + 
				"              <ns3:LastUpdateDate>2019-05-18T10:36:26.404Z</ns3:LastUpdateDate>\r\n" + 
				"              <ns3:LastUpdateLogin>8926CAD6B4FB226DE0530A67360AD46C</ns3:LastUpdateLogin>\r\n" + 
				"              <ns3:ObjectVersionNumber>1</ns3:ObjectVersionNumber>\r\n" + 
				"              <ns3:CreatedByModule>HZ_WS</ns3:CreatedByModule>\r\n" + 
				"              <ns3:PartyId>100000088640991</ns3:PartyId>\r\n" + 
				"              <ns3:RequestId xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:SourceSystemRefInformation>\r\n" + 
				"                <ns4:OrigSystemRefId>300000911604458</ns4:OrigSystemRefId>\r\n" + 
				"                <ns4:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"                <ns4:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"                <ns4:_FLEX_NumOfSegments>0</ns4:_FLEX_NumOfSegments>\r\n" + 
				"              </ns3:SourceSystemRefInformation>\r\n" + 
				"            </ns5:OriginalSystemReference>\r\n" + 
				"            <ns5:PhoneInformation>\r\n" + 
				"              <ns6:ContactPointId>300000911604454</ns6:ContactPointId>\r\n" + 
				"              <ns6:ContactPointType>PHONE</ns6:ContactPointType>\r\n" + 
				"              <ns6:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"              <ns6:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"              <ns6:_FLEX_NumOfSegments>0</ns6:_FLEX_NumOfSegments>\r\n" + 
				"            </ns5:PhoneInformation>\r\n" + 
				"          </ns1:Phone>\r\n" + 
				"          <ns1:Phone xmlns:ns6=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/contactPoint/\">\r\n" + 
				"            <ns5:ContactPointId>300000907524061</ns5:ContactPointId>\r\n" + 
				"            <ns5:ContactPointType>PHONE</ns5:ContactPointType>\r\n" + 
				"            <ns5:Status>A</ns5:Status>\r\n" + 
				"            <ns5:OwnerTableName>HZ_PARTIES</ns5:OwnerTableName>\r\n" + 
				"            <ns5:OwnerTableId>100000088640991</ns5:OwnerTableId>\r\n" + 
				"            <ns5:PrimaryFlag>true</ns5:PrimaryFlag>\r\n" + 
				"            <ns5:OrigSystemReference>SP_1-J92V-115</ns5:OrigSystemReference>\r\n" + 
				"            <ns5:LastUpdateDate>2019-05-18T10:38:48.328Z</ns5:LastUpdateDate>\r\n" + 
				"            <ns5:LastUpdatedBy>siebelscheduler</ns5:LastUpdatedBy>\r\n" + 
				"            <ns5:CreationDate>2019-05-06T20:42:34.039Z</ns5:CreationDate>\r\n" + 
				"            <ns5:CreatedBy>siebelscheduler</ns5:CreatedBy>\r\n" + 
				"            <ns5:LastUpdateLogin>892816F5FF4F7988E0530A67360A5691</ns5:LastUpdateLogin>\r\n" + 
				"            <ns5:RequestId xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:ObjectVersionNumber>3</ns5:ObjectVersionNumber>\r\n" + 
				"            <ns5:CreatedByModule>HZ_WS</ns5:CreatedByModule>\r\n" + 
				"            <ns5:ContactPointPurpose xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PrimaryByPurpose>N</ns5:PrimaryByPurpose>\r\n" + 
				"            <ns5:StartDate>2019-05-06</ns5:StartDate>\r\n" + 
				"            <ns5:EndDate>4712-12-31</ns5:EndDate>\r\n" + 
				"            <ns5:RelationshipId xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PartyUsageCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:OrigSystem xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PhoneCallingCalendar xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:LastContactDtTime xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PhoneAreaCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PhoneCountryCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PhoneNumber>+919845021675</ns5:PhoneNumber>\r\n" + 
				"            <ns5:PhoneExtension xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PhoneLineType>WORK</ns5:PhoneLineType>\r\n" + 
				"            <ns5:RawPhoneNumber>+919845021675</ns5:RawPhoneNumber>\r\n" + 
				"            <ns5:PagerTypeCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:FormattedPhoneNumber>919845021675</ns5:FormattedPhoneNumber>\r\n" + 
				"            <ns5:TransposedPhoneNumber>576120548919</ns5:TransposedPhoneNumber>\r\n" + 
				"            <ns5:PartyName>C M Dhananjaya</ns5:PartyName>\r\n" + 
				"            <ns5:TimezoneCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:OverallPrimaryFlag>true</ns5:OverallPrimaryFlag>\r\n" + 
				"            <ns5:PhoneInformation>\r\n" + 
				"              <ns6:ContactPointId>300000907524061</ns6:ContactPointId>\r\n" + 
				"              <ns6:ContactPointType>PHONE</ns6:ContactPointType>\r\n" + 
				"              <ns6:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"              <ns6:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"              <ns6:_FLEX_NumOfSegments>0</ns6:_FLEX_NumOfSegments>\r\n" + 
				"            </ns5:PhoneInformation>\r\n" + 
				"          </ns1:Phone>\r\n" + 
				"          <ns1:Phone xmlns:ns6=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/contactPoint/\">\r\n" + 
				"            <ns5:ContactPointId>300000758850347</ns5:ContactPointId>\r\n" + 
				"            <ns5:ContactPointType>PHONE</ns5:ContactPointType>\r\n" + 
				"            <ns5:Status>A</ns5:Status>\r\n" + 
				"            <ns5:OwnerTableName>HZ_PARTIES</ns5:OwnerTableName>\r\n" + 
				"            <ns5:OwnerTableId>100000088640991</ns5:OwnerTableId>\r\n" + 
				"            <ns5:PrimaryFlag>false</ns5:PrimaryFlag>\r\n" + 
				"            <ns5:OrigSystemReference>2018112812244990064</ns5:OrigSystemReference>\r\n" + 
				"            <ns5:LastUpdateDate>2019-05-18T10:36:26.352Z</ns5:LastUpdateDate>\r\n" + 
				"            <ns5:LastUpdatedBy>pms scheduler</ns5:LastUpdatedBy>\r\n" + 
				"            <ns5:CreationDate>2018-11-28T12:24:54.063Z</ns5:CreationDate>\r\n" + 
				"            <ns5:CreatedBy>Datacentre</ns5:CreatedBy>\r\n" + 
				"            <ns5:LastUpdateLogin>8926CAD6B4FB226DE0530A67360AD46C</ns5:LastUpdateLogin>\r\n" + 
				"            <ns5:RequestId>273465</ns5:RequestId>\r\n" + 
				"            <ns5:ObjectVersionNumber>3</ns5:ObjectVersionNumber>\r\n" + 
				"            <ns5:CreatedByModule>HZ_WS</ns5:CreatedByModule>\r\n" + 
				"            <ns5:ContactPointPurpose xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PrimaryByPurpose>N</ns5:PrimaryByPurpose>\r\n" + 
				"            <ns5:StartDate>2018-11-28</ns5:StartDate>\r\n" + 
				"            <ns5:EndDate>4712-12-31</ns5:EndDate>\r\n" + 
				"            <ns5:RelationshipId xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PartyUsageCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:OrigSystem xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PhoneCallingCalendar xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:LastContactDtTime xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PhoneAreaCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PhoneCountryCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PhoneNumber>919845021675</ns5:PhoneNumber>\r\n" + 
				"            <ns5:PhoneExtension xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:PhoneLineType>HOME</ns5:PhoneLineType>\r\n" + 
				"            <ns5:RawPhoneNumber>919845021675</ns5:RawPhoneNumber>\r\n" + 
				"            <ns5:PagerTypeCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:FormattedPhoneNumber>919845021675</ns5:FormattedPhoneNumber>\r\n" + 
				"            <ns5:TransposedPhoneNumber>576120548919</ns5:TransposedPhoneNumber>\r\n" + 
				"            <ns5:PartyName>C M Dhananjaya</ns5:PartyName>\r\n" + 
				"            <ns5:TimezoneCode xsi:nil=\"true\"/>\r\n" + 
				"            <ns5:OverallPrimaryFlag>false</ns5:OverallPrimaryFlag>\r\n" + 
				"            <ns5:OriginalSystemReference xmlns:ns4=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/flex/sourceSystemRef/\">\r\n" + 
				"              <ns3:OrigSystemReferenceId>300000758850355</ns3:OrigSystemReferenceId>\r\n" + 
				"              <ns3:OrigSystem>PMS</ns3:OrigSystem>\r\n" + 
				"              <ns3:OrigSystemReference>2018112812244990064</ns3:OrigSystemReference>\r\n" + 
				"              <ns3:OwnerTableName>HZ_CONTACT_POINTS</ns3:OwnerTableName>\r\n" + 
				"              <ns3:OwnerTableId>300000758850347</ns3:OwnerTableId>\r\n" + 
				"              <ns3:Status>A</ns3:Status>\r\n" + 
				"              <ns3:ReasonCode xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:OldOrigSystemReference xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:StartDateActive>2018-11-28</ns3:StartDateActive>\r\n" + 
				"              <ns3:EndDateActive>4712-12-31</ns3:EndDateActive>\r\n" + 
				"              <ns3:CreatedBy>Datacentre</ns3:CreatedBy>\r\n" + 
				"              <ns3:CreationDate>2018-11-28T12:24:54.271Z</ns3:CreationDate>\r\n" + 
				"              <ns3:LastUpdatedBy>Datacentre</ns3:LastUpdatedBy>\r\n" + 
				"              <ns3:LastUpdateDate>2018-11-28T12:24:54.354Z</ns3:LastUpdateDate>\r\n" + 
				"              <ns3:LastUpdateLogin>7BB9A635B7731747E0530A67360A96B5</ns3:LastUpdateLogin>\r\n" + 
				"              <ns3:ObjectVersionNumber>1</ns3:ObjectVersionNumber>\r\n" + 
				"              <ns3:CreatedByModule>HZ_WS</ns3:CreatedByModule>\r\n" + 
				"              <ns3:PartyId>300000758851104</ns3:PartyId>\r\n" + 
				"              <ns3:RequestId xsi:nil=\"true\"/>\r\n" + 
				"              <ns3:SourceSystemRefInformation>\r\n" + 
				"                <ns4:OrigSystemRefId>300000758850355</ns4:OrigSystemRefId>\r\n" + 
				"                <ns4:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"                <ns4:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"                <ns4:_FLEX_NumOfSegments>0</ns4:_FLEX_NumOfSegments>\r\n" + 
				"              </ns3:SourceSystemRefInformation>\r\n" + 
				"            </ns5:OriginalSystemReference>\r\n" + 
				"            <ns5:PhoneInformation>\r\n" + 
				"              <ns6:ContactPointId>300000758850347</ns6:ContactPointId>\r\n" + 
				"              <ns6:ContactPointType>PHONE</ns6:ContactPointType>\r\n" + 
				"              <ns6:__FLEX_Context xsi:nil=\"true\"/>\r\n" + 
				"              <ns6:__FLEX_Context_DisplayValue xsi:nil=\"true\"/>\r\n" + 
				"              <ns6:_FLEX_NumOfSegments>0</ns6:_FLEX_NumOfSegments>\r\n" + 
				"            </ns5:PhoneInformation>\r\n" + 
				"          </ns1:Phone>\r\n" + 
				"        </ns1:Value>\r\n" + 
				"      </ns2:result>\r\n" + 
				"    </ns0:findPersonResponse>\r\n" + 
				"  </env:Body>\r\n" + 
				"</env:Envelope>\r\n" + 
				"";
		
		try
		 {	
			SoapExecutor soapExecutor = new SoapExecutor();
		
			Document doc = soapExecutor.convertStringToDocument(responce);
			
		  NodeList nodeList = ((Element) doc.getElementsByTagName("ns1:Value").item(0)).getElementsByTagName("ns1:LoyaltyMembershipsCollection_c");
			
			for(int i=0; i<nodeList.getLength(); i++)
			{
				Element ele = (Element) nodeList.item(i);
				String MembershipType = ele.getElementsByTagName("ns1:MembershipTypeLOV_c").item(0).getTextContent();
				
				
				if(MembershipType.equalsIgnoreCase("TIC") || MembershipType.equalsIgnoreCase("Taj InnerCircle") || MembershipType.equalsIgnoreCase("TAJ"))
					{
						String EnrollNumber_c = ele.getElementsByTagName("ns1:MembershipCardNo_c").item(0).getTextContent();
						System.out.println("EnrollNumber_c: "+EnrollNumber_c);
					}
					
			}
		 } catch(Exception e)
		 {
			 e.printStackTrace();
		 }
	}
	
	public static void mainIDS(String a[])		//Future Booking IDS
	{
		try {
			
			OkHttpClient client = new OkHttpClient();

			MediaType mediaType = MediaType.parse("application/xml");
			RequestBody body = RequestBody.create(mediaType, "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:core=\"http://webservices.micros.com/og/4.3/Core/\" xmlns:res=\"http://webservices.micros.com/ows/5.1/Reservation.wsdl\" xmlns:hot=\"http://webservices.micros.com/og/4.3/HotelCommon/\" xmlns:res1=\"http://webservices.micros.com/og/4.3/Reservation/\" xmlns:com=\"http://webservices.micros.com/og/4.3/Common/\">\r\n  <soapenv:Header>\r\n    <OGHeader xmlns=\"http://webservices.micros.com/og/4.3/Core/\" transactionID=\"3297907325\" timeStamp=\"2009-03-08T09:15:27.568125-05:00\" primaryLangID=\"E\">\r\n      <Origin entityID=\"KIOSK\" systemType=\"WEB\" />\r\n      <Destination entityID=\"KIOSK\" systemType=\"PMS\" />\r\n      <Authentication>\r\n        <UserCredentials>\r\n          <UserName1>MDMUSER1</UserName1>\r\n          <UserPassword>B34zxv]@4ve!</UserPassword>\r\n          <Domain>DEDTR</Domain>\r\n        </UserCredentials>\r\n      </Authentication>\r\n    </OGHeader>\r\n  </soapenv:Header>\r\n  <soapenv:Body>\r\n    <res:FutureBookingSummaryRequest summaryOnly=\"false\">\r\n      <res:AdditionalFilters>\r\n        <res1:ResvNameId type=\"INTERNAL\" source=\"RESVID\">1421</res1:ResvNameId>\r\n      </res:AdditionalFilters>\r\n    </res:FutureBookingSummaryRequest>\r\n  </soapenv:Body>\r\n</soapenv:Envelope>");
			Request request = new Request.Builder()
			  .url("http://137.116.137.155:8888/RestMDMServiceLibrary/FutureBookingSummary")
			  .post(body)
			  .addHeader("Content-Type", "application/xml")
			  .addHeader("User-Agent", "PostmanRuntime/7.15.2")
			  .addHeader("Accept", "*/*")
			  .addHeader("Cache-Control", "no-cache")
			  .addHeader("Postman-Token", "c3609457-5651-4934-b902-a60c8c0f6af0,7ddd5f73-37da-4b86-9c95-915c5edc5543")
			  .addHeader("Host", "137.116.137.155:8888")
			  .addHeader("Accept-Encoding", "gzip, deflate")
			  .addHeader("Content-Length", "1240")
			  .addHeader("Connection", "keep-alive")
			  .addHeader("cache-control", "no-cache")
			  .build();

			Response response = client.newCall(request).execute();
			
			String resp = response.body().string().toString();
			
			SoapExecutor soapExecutor = new SoapExecutor();
			
			Document doc = soapExecutor.convertStringToDocument(resp);
			
			NodeList nListRes = doc.getElementsByTagName("s0:Result");
			
			Element eleRes = (Element) nListRes.item(0);
			
			String resStatus = eleRes.getAttribute("resultStatusFlag");
			
			System.out.println(resStatus);
			
			if(resStatus.equalsIgnoreCase("SUCCESS"))
			{
				NodeList nList = doc.getElementsByTagName("s3:HotelReservation");
				
				Element ele = (Element) nList.item(0);
				if (ele == null) {
					System.out.println("No Reservation Found");
					return;
				}
				
				String Status = ele.getAttribute("reservationStatus");
				System.out.println("Stay Status: \t" + Status);
				
				if(!Status.equalsIgnoreCase("INHOUSE"))
				{
					return;
				}
				
				NodeList nListUnique = ele.getElementsByTagName("s3:UniqueIDList");
				
				for(int i=0; i<nListUnique.getLength(); i++)
				{
					Element eleUnique = (Element) nListUnique.item(i);
					
					NodeList nListUniqueId = eleUnique.getElementsByTagName("s2:UniqueID");
					
					for(int j=0; j<nListUniqueId.getLength(); j++)
					{
						Element eleUniqueId = (Element) nListUniqueId.item(j);
						
						String source = eleUniqueId.getAttribute("source");
						if(source == null || source.equalsIgnoreCase("null") || source.equalsIgnoreCase(""))
						{
							String ConfirmationNo = eleUniqueId.getTextContent().toString();
							System.out.println("ConfirmationNo\t"+ConfirmationNo);
						}
						
					}
				}
				
				NodeList nListRoomStays = ele.getElementsByTagName("s1:RoomNumber");
				
				Element eleRoom = (Element) nListRoomStays.item(0);
				
				String RoomNo = eleRoom.getTextContent();
				System.out.println("RoomNo\t"+RoomNo);
				
				NodeList nListTimeSpan = ele.getElementsByTagName("s1:TimeSpan");
				
				for(int i=0; i<nListTimeSpan.getLength(); i++)
				{
					Element eleTimeSpan = (Element) nListTimeSpan.item(i);
					
					String CheckInDate = soapExecutor.getValue(eleTimeSpan, "s1:StartDate");
					String CheckOutDate = soapExecutor.getValue(eleTimeSpan, "s1:EndDate");
					
					
					try{
						SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
						DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
						Date d1 = format.parse(CheckInDate.substring(0, 10));
						Date d2 = format.parse(CheckOutDate.substring(0, 10));
						
						Date CInDate = d1;
						Date COutDate = d2;
						
						String ArrivalDate = dateFormat.format(d1);
						String DepartureDate = dateFormat.format(d2);
						
						System.out.println(ArrivalDate + "\n" + DepartureDate);
					}catch(Exception e)
					{
					//e.printStackTrace();
					}
				}
				
				NodeList nListHotel = ele.getElementsByTagName("s1:HotelReference");
				
				Element eleHotel = (Element) nListHotel.item(0);
				
				String HotelName = eleHotel.getTextContent();
				String PropertyFullName = HotelName;
				
				System.out.println("HotelName\t" + HotelName);
				
				//code to get the PMS Name Code for querying profile in MDM
				
				NodeList nListResGuest = ele.getElementsByTagName("s4:ProfileIDs");
				
				Element eleProfileId = (Element) nListResGuest.item(0);
				
				String PMSNameCode = soapExecutor.getValue(eleProfileId, "s2:UniqueID");
				
				System.out.println("PMS Name Code:\t"+PMSNameCode);
						
				
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main12345(String a[]) throws Exception		
	{
		GetProfileData profileData = new GetProfileData("20104586", "12345678", "SLVTT", null, null);
		Thread thread = new Thread(profileData);
		thread.start();
		thread.join();
		System.out.println(profileData.isProfileFound);
		if(!profileData.isProfileFound)
		{
			System.out.println("Profile Not Found");
		}
	}
	
	public static void main(String a[]) 
	{
		String resp = "{\r\n" + 
				"  \"items\" : [ {\r\n" + 
				"    \"Id\" : 300001103044941,\r\n" + 
				"    \"RecordName\" : \"IXMTG114082240\",\r\n" + 
				"    \"REGISTER_c\" : \"114082240\",\r\n" + 
				"    \"HotelCode_c\" : \"IXMTG\",\r\n" + 
				"    \"Hotel_dcl_c\" : \"The Gateway Hotel Pasumalai\",\r\n" + 
				"    \"Action_c\" : \"Not Guarantee\",\r\n" + 
				"    \"RoomNumber_c\" : null,\r\n" + 
				"    \"TinyURL_c\" : \"http://payit.cc/I150187116\",\r\n" + 
				"    \"InvoiceStatus_c\" : \"SUCCESS\",\r\n" + 
				"    \"InvoiceId_c\" : \"150187116\"\r\n" + 
				"  } ],\r\n" + 
				"  \"count\" : 1,\r\n" + 
				"  \"hasMore\" : false,\r\n" + 
				"  \"limit\" : 25,\r\n" + 
				"  \"offset\" : 0,\r\n" + 
				"  \"links\" : [ {\r\n" + 
				"    \"rel\" : \"self\",\r\n" + 
				"    \"href\" : \"https://ccre-test.crm.us6.oraclecloud.com:443/crmRestApi/resources/11.13.18.05/Reservation_c\",\r\n" + 
				"    \"name\" : \"Reservation_c\",\r\n" + 
				"    \"kind\" : \"collection\"\r\n" + 
				"  } ]\r\n" + 
				"}";
		
		
		try {
			
			JSONObject object = new JSONObject(resp);
			
			int count = Integer.parseInt(object.getString("count"));
			if(count == 1)
			{
				JSONArray array = object.getJSONArray("items");
				JSONObject jsonObject = array.getJSONObject(0);
				
				String invoiceStatus = jsonObject.getString("InvoiceStatus_c");
				if(invoiceStatus.equals("SUCCESS"))
				{
					String tinyURL = jsonObject.getString("TinyURL_c");
					String invoiceId = jsonObject.getString("InvoiceId_c");
					
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
