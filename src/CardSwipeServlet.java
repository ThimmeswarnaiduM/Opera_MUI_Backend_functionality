

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

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

import config.ConfigPayloads;
import config.Configuration;
import config.GetProfileData;
import data.HashMapData;
import data.NewInvoicesData;


@WebServlet("/CardSwipeServlet")
public class CardSwipeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	JSONObject objectPoint = new JSONObject();
	JSONObject objectVoucher = new JSONObject();

	protected void getData(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			System.out.println("Card Swipe");
			String swipedFor = request.getParameter("SwipedFor");
			String GlobalReservationNumber = request.getParameter("GlobalReservationNumber");
			String GlobalPropertyCode = request.getParameter("GlobalPropertyCode");

			if(swipedFor.equals("Vouchers"))
			{
				try
				{
				
					String CardNumber = request.getParameter("CardNumber");
					
					String swipedMemberNumber = readCardNumber(CardNumber);
					
					GetProfileData getProfileData = HashMapData.mapProfileData.get(GlobalReservationNumber);
					String profileMemberNumber = getProfileData.EnrollNumber_c;
					
					if(swipedMemberNumber.equals(profileMemberNumber))
					{
						objectVoucher.put("status", "SUCCESS");
					} else 
					{
						objectVoucher.put("status", "FAILED");
						objectVoucher.put("statusMsg", "Swiped card does not belong to this member <br/><br/>Thank you");
						
					}
				}catch(Exception e)
				{
					e.printStackTrace();
				}
				
				response.getWriter().write(objectVoucher.toString());
				return;
				
			} else if(swipedFor.equals("Points"))
			{
				try
				{
					String CardNumber = request.getParameter("CardNumber");
					String pointType = request.getParameter("PointType");
					String Points = request.getParameter("Point");
					
					String tempCardNumber = readCardNumber(CardNumber);
					
					try{
						objectPoint.put("memberNumber", tempCardNumber);
						
						validateMember(CardNumber, pointType, Points, GlobalReservationNumber, GlobalPropertyCode);
						
					}catch(Exception e)
					{
						e.printStackTrace();
						try {
							objectPoint.put("status", "ERROR");
							objectPoint.put("statusMsg", "Failed to validate card <br/>Please try again later <br/><br/>Thank you");
						} catch (JSONException e1) {
							e1.printStackTrace();
						}
					}
				
				}catch(Exception e)
				{
					e.printStackTrace();
				}
					System.out.println("Card Swipe Response: "+objectPoint.toString());
					try{
						BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + GlobalReservationNumber+".txt",true));
						
						writer.write("\nCard Swipe Response: : \n" + objectPoint.toString() + "\n\n");
						writer.write((new Date()).toString());
						writer.close();
						
					} catch(Exception e)
					{
						e.printStackTrace();
					}
					
				response.getWriter().write(objectPoint.toString());
				
				return;
				
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private String readCardNumber(String CardData)
	{
		String MemberNumber = "";
		
		try{
			
			MemberNumber = CardData.substring(CardData.indexOf("%")+1, CardData.indexOf("^"));
		}catch(Exception e)
		{
			e.printStackTrace();
			try {
				
				objectPoint.put("status", "FAILED");
				objectPoint.put("statusMsg", "Unable to read the card <br/>Please try again <br/><br/>Thank you");
				
				objectVoucher.put("status", "FAILED");
				objectVoucher.put("statusMsg", "Unable to read the card <br/>Please try again <br/><br/>Thank you");
				
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
		}
		
		return MemberNumber;
	}
	
	public static void main(String a[])
	{
		String CardData = "%101014774663^TEST CARD               ^^1-12194965982?;101014774663=?+101014774663==?";
		
		CardSwipeServlet servlet = new CardSwipeServlet();
		System.out.println(servlet.readCardNumber(CardData));
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		getData(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}


	private void validateMember(String CardmemberNumber, String pointType, String Points, String ReservationNo, String GlobalPropertyCode)
	{
		
		String TICPointsBalance = "";
		String EpicurePointsBalance = "";
		
		int TICPoints = 0, EpicurePoints = 0;
		JSONObject objectMember = null;
		
		try {
			/*ConfigPayloads payloads = new ConfigPayloads();
			
			String payload = payloads.getMemberDataPayload(memberNumber);*/
			String payload = "{\r\n" + 
					"    \"card_string\": \""+CardmemberNumber+"\"\r\n" + 
					"}\r\n" + 
					"";

			System.out.println("Get Member Data Payload: \n" + payload);
			
			try{
				BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + ReservationNo+".txt",true));
				
				writer.write("\nMembership Card Validate Points Request payload: \n" + payload + "\n\n");
				writer.write("Point Type:\t " + pointType + "\nPoints: \t" + Points + "\n\n" );
				writer.write((new Date()).toString());
				writer.close();
				
			} catch(Exception e)
			{
				e.printStackTrace();
			}
			
			
			
			
			OkHttpClient clientMember = new OkHttpClient();

			clientMember.setConnectTimeout(70, TimeUnit.SECONDS); // connect timeout
			clientMember.setReadTimeout(70, TimeUnit.SECONDS);

			MediaType mediaTypeMember = MediaType.parse("application/json");
			RequestBody bodyMember = RequestBody.create(mediaTypeMember, payload);
			Request requestMember = new Request.Builder()
					// .url("https://tajics-a455764.integration.us2.oraclecloud.com/integration/flowapi/rest/MEMBERQUERYMN/v01/QueryMember")
					.url(Configuration.validateCardURL)
					.post(bodyMember).addHeader("Content-Type", "application/json")
					.addHeader("Authorization", Configuration.IcsBasicAuth)
					.addHeader("Cache-Control", "no-cache")
					.addHeader("Postman-Token", "2d8738ae-ac58-4d88-bccf-c8a008ce8e52").build();

			Response responseMember = clientMember.newCall(requestMember).execute();
			String testResponse = responseMember.body().string();
			int resCode = responseMember.code();
			
			System.out.println("Get Member Data Response: \n" + testResponse);
			
			try{
				BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + ReservationNo+".txt",true));
				
				writer.write("\nMembership Card Validate Response: \n" + testResponse + "\n\n");
				writer.write((new Date()).toString());
				writer.close();
				
			} catch(Exception e)
			{
				e.printStackTrace();
			}
			
			
			objectMember = new JSONObject(testResponse);
			
			
			if(resCode == 200 || resCode == 201 || resCode == 202)
			{
				try
				{
					String message = objectMember.getString("message");
					if(message.contains("Card is not present"))
					{
						objectPoint.put("status", "FAILED");
						objectPoint.put("statusMsg", "Member does not exist");
						
						return;
					}
					else if(message.contains("Card is Present but Expired"))
					{
						objectPoint.put("status", "FAILED");
						objectPoint.put("statusMsg", "Card is Present but Expired");
						return;
					}
					else if(message.contains("TIC Number does not exist"))
					{
						objectPoint.put("status", "FAILED");
						objectPoint.put("statusMsg", "Member does not exist");
						return;
					}
				}
				catch(Exception e)
				{
					
				}
			}
			else
			{
				objectPoint.put("status", "FAILED");
				objectPoint.put("statusMsg", "Card Not Swiped Properly");
				return;
			}
			String memberNumber = objectMember.getString("membershipNumber");
			
			String fetchCustomerRequest = "{\r\n" + 
					"	\"membershipNumber\": \""+memberNumber+"\",\r\n" + 
					"	\"source_identifier\": \""+"MUIRedemption"+"\"\r\n" + 
					"}";
			try{
				BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + ReservationNo+".txt",true));
				
				writer.write("\nFetch Membership Request payload: \n" + fetchCustomerRequest + "\n\n");
				writer.write("Point Type:\t " + pointType + "\nPoints: \t" + Points + "\n\n" );
				writer.write((new Date()).toString());
				writer.close();
				
			} catch(Exception e)
			{
				e.printStackTrace();
			}
			
			
			
			OkHttpClient clientFetchMember = new OkHttpClient();

			clientFetchMember.setConnectTimeout(70, TimeUnit.SECONDS); // connect timeout
			clientFetchMember.setReadTimeout(70, TimeUnit.SECONDS);

			MediaType mediaTypeFetchMember = MediaType.parse("application/json");
			RequestBody bodyFetchMember = RequestBody.create(mediaTypeFetchMember, fetchCustomerRequest);
			Request requestFetchMember = new Request.Builder()
					// .url("https://tajics-a455764.integration.us2.oraclecloud.com/integration/flowapi/rest/MEMBERQUERYMN/v01/QueryMember")
					.url(Configuration.GetMemberDataURL).addHeader("Store_Id", GlobalPropertyCode)
					.post(bodyFetchMember).addHeader("Content-Type", "application/json")
					.addHeader("Authorization", Configuration.IcsBasicAuth)
					.addHeader("Cache-Control", "no-cache")
					.addHeader("Postman-Token", "2d8738ae-ac58-4d88-bccf-c8a008ce8e52").build();

			Response responseFetchMember = clientFetchMember.newCall(requestFetchMember).execute();
			String testFetchResponse = responseFetchMember.body().string();
			int resFetchCode = responseFetchMember.code();
			
			System.out.println("Get Member Data Response: \n" + testFetchResponse);
			
			try{
				BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + ReservationNo+".txt",true));
				
				writer.write("\nMembership Card Validate Response: \n" + testResponse + "\n\n");
				writer.write((new Date()).toString());
				writer.close();
				
			} catch(Exception e)
			{
				e.printStackTrace();
			}
			
			
			
			if(resFetchCode == 200 || resFetchCode == 201 || resFetchCode == 202)
			{
				try
				{
					JSONObject objectFetchMember1 = new JSONObject(testFetchResponse);
					JSONObject objectFetchStatuc = objectFetchMember1.getJSONObject("status");
					String message = objectFetchStatuc.getString("message");
					if(message.contains("No record found"))
					{
						try{
							BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + ReservationNo+".txt",true));
							
							writer.write("\nCardSwipe Res: \n" + objectPoint.toString() + "\n\n");
							writer.write((new Date()).toString());
							writer.close();
							
						} catch(Exception e)
						{
							e.printStackTrace();
						}
						
						
						
						objectPoint.put("status", "FAILED");
						objectPoint.put("statusMsg", "Member does not exist");
						return;
					}
				}
				catch(Exception e)
				{
					
				}
			}
			else
			{
				objectPoint.put("status", "FAILED");
				objectPoint.put("statusMsg", "Card Not Swiped Properly");
				return;
			}
			
			JSONObject objectFetchMember = new JSONObject(testFetchResponse);
			String customerHash = objectFetchMember.getString("customerHash");
			String tcpMemberNumber = objectFetchMember.getString("tcpNumber");
			JSONArray loyArray = objectFetchMember.getJSONArray("loyaltyInfo");
	        JSONObject loyObj = loyArray.getJSONObject(0);
	        //String MembershipTier = loyObj.getString("currentSlab");
	        TICPointsBalance = loyObj.getString("loyaltyPoints");
	        double doublePoints = Float.parseFloat(TICPointsBalance);
	        TICPoints = (int) doublePoints;
			
			/*JSONArray MemberJson1 = objectMember.getJSONObject("MemberQuery_Output")
					.getJSONObject("ListOfIhclLoyMemberQueryIo").getJSONArray("LoyMember");
			

			for(int i = 0; i < MemberJson1.length(); i++) {
				JSONObject JsonMemberData = MemberJson1.getJSONObject(i);

				String MembershipNumber = JsonMemberData.getString("MemberNumber");
				// MemberName = JsonMemberData.getString("Name");
				
				String MembershipTier = JsonMemberData.getJSONObject("ListOfLoyMemberTier").getJSONArray("LoyMemberTier").getJSONObject(0).getString("TierName");

				JSONArray MemberPoints = JsonMemberData.getJSONObject("ListOfLoyMemberPointBalancesVbc")
						.getJSONArray("LoyMemberPointBalancesVbc");
				for (int j = 0; j < MemberPoints.length(); j++) {
					JSONObject JsonPoints = MemberPoints.getJSONObject(j);
					System.out.println(JsonPoints);
					if(JsonPoints.getString("PointType").equalsIgnoreCase("TIC"))
					{
						TICPointsBalance = JsonPoints.getString("AvailablePoints");
						if(!TICPointsBalance.equalsIgnoreCase("0") || !TICPointsBalance.equalsIgnoreCase("") || TICPointsBalance != null)
							TICPoints = Integer.parseInt(TICPointsBalance);
					}
					if(JsonPoints.getString("PointType").equalsIgnoreCase("Epicure"))
					{
						EpicurePointsBalance = JsonPoints.getString("AvailablePoints");
						if(!EpicurePointsBalance.equalsIgnoreCase("0") || !EpicurePointsBalance.equalsIgnoreCase("") || EpicurePointsBalance != null)
							EpicurePoints = Integer.parseInt(EpicurePointsBalance);
					}

				}

			}*/

				if(Integer.parseInt(Points) <= TICPoints)
				{
					
					objectPoint.put("status", "SUCCESS");
					objectPoint.put("customerHash", customerHash);
					objectPoint.put("memberNumber", memberNumber);
					objectPoint.put("tcpMemberNumber", tcpMemberNumber);
					return;
				} else if(Integer.parseInt(Points) > TICPoints)
				{
				
					objectPoint.put("status", "ERROR");
					objectPoint.put("statusMsg", "Insufficient points entered");
					objectPoint.put("TICPoints", TICPoints);
					objectPoint.put("EpicurePoints", EpicurePoints);
					return;
				}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
			try{
				JSONObject object1 = objectMember;
				
				String error = object1.getJSONArray("o:errorDetails").getJSONObject(0).getString("title");
				
				if(error.contains("Member does not exist"))
				{
					System.out.println("Member does not exist");
					objectPoint.put("status", "FAILED");
					objectPoint.put("statusMsg", "Member does not exist");
				}
			}catch(Exception ee)
			{
				ee.printStackTrace();
			}

			return;
		}
		
		return;
	}
	
}
