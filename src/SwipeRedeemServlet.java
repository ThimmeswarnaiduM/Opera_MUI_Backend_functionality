

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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
import config.GetHotelsData;
import config.GetReservationData;
import config.SoapExecutor;
import config.URLConfig;
import data.HashMapData;
import data.ProcessInvoicesData;
import data.StoreInvoiceDataMap;
import data.StoreInvoiceDetails;

/**
 * Servlet implementation class SwipeRedeemServlet
 */
@WebServlet("/SwipeRedeemServlet")
public class SwipeRedeemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	HttpServletResponse servletResponse = null;
	
	ProcessInvoicesData processInvoicesData = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SwipeRedeemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		servletResponse = response;
		GetHotelsData hotelsData = new GetHotelsData();
		String PropertyCode = hotelsData.getProperty(request.getParameter("GlobalPropertyCode"));
		String GlobalOrionCode = HashMapData.mapOrionCode.get(request.getParameter("GlobalPropertyCode"));
		String points = request.getParameter("Points");
		String customerHash = request.getParameter("customerHash");
		String tcpMemberNumber = request.getParameter("tcpMemberNumber");
		String resvId = request.getParameter("GlobalReservationNumber");
		String cardString = request.getParameter("SwipeMemberNumber");
		GetReservationData getReservationData = HashMapData.mapReservationData.get(resvId);
		/*String confirmationNumberDis = request.getParameter("confirmationNumberDis");
		String arrivalDis = request.getParameter("arrivalDis");
		String DepartureDis = request.getParameter("DepartureDis");*/
		String confirmationNumberDis = getReservationData.ConfirmationNo;
		String arrivalDisTemp = getReservationData.ArrivalDate;
		System.out.println("Arrival Date Temp: "+arrivalDisTemp);
		String arrivalDis = convertDateFormatTemp(arrivalDisTemp);
		String DepartureDisTemp = getReservationData.DepartureDate;
		System.out.println("DepartureDisTemp Date Temp: "+DepartureDisTemp);
		String DepartureDis = convertDateFormatTemp(DepartureDisTemp);
		ProcessInvoicesData processInvoicesData = HashMapData.mapProcessInvoices.get(resvId);
		Random rand = new Random(); 
		int rand_int1 = rand.nextInt(1000000000); 
		String property = processInvoicesData.URLPropertyCode;
		
		
		
/*		String confirmationNumberDis = processInvoicesData.ConfirmationNo;
		String arrivalDis = convertDateFormat(processInvoicesData.CheckInDate);
		String DepartureDis = convertDateFormat(processInvoicesData.CheckOutDate);*/
		String notes = confirmationNumberDis+" | "+arrivalDis+" | "+DepartureDis;
		String redeemRequest = "{\r\n" + 
				"  \"pointsRedeemed\": \""+points+"\",\r\n" + 
				"  \"customerHash\": \""+customerHash+"\",\r\n" + 
				"  \"transactionNumber\": \""+confirmationNumberDis+"\",\r\n" + 
				"  \"externalReferenceNumber\":\""+property+resvId+rand_int1+"\",\r\n" + 
				"  \"cardNo\": \""+cardString+"\",\r\n" + 
				"  \"refID\":\"\",\r\n" + 
				"  \"notes\": \""+notes+"\",\r\n" +
				 "    \"customFields\": { " + 
				 "        \"field\": [ " + 
				 "            { " + 
				 "                \"name\": \"checkin_date\", " + 
				 "                \"value\": \""+ arrivalDis +"\" "+  
				 "            }, " + 
				 "            { " + 
				 "                \"name\": \"checkout_date\", " + 
				 "                \"value\": \"" + DepartureDis+"\" "+
				 "            }, " + 
				 "            { " + 
				 "                \"name\": \"source\", " + 
				 "                \"value\": \"PMS\" " + 
				 "            }, " + 
				 "            { " + 
				 "                \"name\": \"product_type\", " + 
				 "                \"value\": \"Stay\" " + 
				 "            }, " + 
				 "            { " + 
				 "                \"name\": \"reservation_no\", " + 
				 "                \"value\":\""+ confirmationNumberDis+"\" "+ 
				 "            }, " + 
				 "            { " + 
				 "                \"name\": \"quantity\", " + 
				 "                \"value\": \"1\" " + 
				 "            }, " + 
				 "            { " + 
				 "                \"name\": \"settlement\", " + 
				 "                \"value\": \"Points\" " + 
				 "            } " + 
				 "        ] " + 
				 "    } " + 
				 "}"; 
		try
		{
			System.out.println("Request : "+redeemRequest);
			try{
				BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + resvId+".txt",true));
				
				writer.write("\nSwipe Redeem Request: : \n" + redeemRequest + "\n\n");
				writer.write((new Date()).toString());
				writer.close();
				
			} catch(Exception e)
			{
				e.printStackTrace();
			}
			
			try{
				BufferedWriter writer02 = new BufferedWriter(new FileWriter(Configuration.redemptionLog + resvId+"_TataNeuPoints_"+customerHash+".txt",true));
				
				writer02.write("\nSwipe Redeem Request: : \n" + redeemRequest + "\n\n");
				writer02.write((new Date()).toString());
				writer02.close();
				
			} catch(Exception e)
			{
				e.printStackTrace();
			}
			
			
		OkHttpClient clientMember = new OkHttpClient();

		clientMember.setConnectTimeout(70, TimeUnit.SECONDS); // connect timeout
		clientMember.setReadTimeout(70, TimeUnit.SECONDS);

		MediaType mediaTypeMember = MediaType.parse("application/json");
		RequestBody bodyMember = RequestBody.create(mediaTypeMember, redeemRequest);
		Request requestMember = new Request.Builder()
				// .url("https://tajics-a455764.integration.us2.oraclecloud.com/integration/flowapi/rest/MEMBERQUERYMN/v01/QueryMember")
				.url(Configuration.PayUsingPointsURL)
				.post(bodyMember).addHeader("Content-Type", "application/json")
				.addHeader("Authorization", Configuration.IcsBasicAuth)
				.addHeader("store_id", GlobalOrionCode)
				.addHeader("Cache-Control", "no-cache")
				.addHeader("Postman-Token", "2d8738ae-ac58-4d88-bccf-c8a008ce8e52").build();

		Response responseMember = clientMember.newCall(requestMember).execute();
		String testResponse = responseMember.body().string();
		System.out.println("Response: "+testResponse);
		int resCode = responseMember.code();
		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + resvId+".txt",true));
			
			writer.write("\nSwipe Redeem Response: : \n" + testResponse + "\n\n");
			writer.write((new Date()).toString());
			writer.close();
			
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		
		try{
			BufferedWriter writer02 = new BufferedWriter(new FileWriter(Configuration.redemptionLog + resvId+"_TataNeuPoints_"+customerHash+".txt",true));
			
			writer02.write("\nSwipe Redeem Response: : \n" + testResponse + "\n\n");
			writer02.write((new Date()).toString());
			writer02.close();
			
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		if(resCode == 200 || resCode == 201 || resCode ==202)
		{
			String redeemId = "";
			JSONObject jsonObj = new JSONObject(testResponse).getJSONObject("response");
			JSONObject statusObj = jsonObj.getJSONObject("status");
			String status = statusObj.getString("success");
			if(status.equals("true"))
			{
				redeemId = jsonObj.getJSONObject("responses").getJSONObject("points").getString("redemption_id");
			}
			else
			{
				//Failed
				try{
					BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + resvId+".txt",true));
					
					writer.write("\nRedirct URL: : \n" + "NewInvoices.jsp?ReservId="+resvId+"&PayStatus=failedSiebel&Property="+property+"" + "\n\n");
					writer.write((new Date()).toString());
					writer.close();
					
				} catch(Exception e)
				{
					e.printStackTrace();
				}
				servletResponse.getWriter().write("NewInvoices.jsp?ReservId="+resvId+"&PayStatus=failedSiebel&Property="+property+"");
				return;
			}
			
			
			processInvoicesData = HashMapData.mapProcessInvoices.get(resvId);
			
			processInvoicesData.URLReservationNumber = resvId;
			
			HashMapData.mapProcessInvoices.put(resvId, processInvoicesData);
			processInvoicesData = HashMapData.mapProcessInvoices.get(resvId);
			
			String PaymentType = request.getParameter("PaymentType");
			processInvoicesData.rq = request.getParameter("InvoiceNo");
			
			processInvoicesData.ConversionType = request.getParameter("Type");
			processInvoicesData.TotalAmount = request.getParameter("Amount");
			processInvoicesData.TotalPoints = request.getParameter("Points");
			processInvoicesData.PaymentCardType = request.getParameter("Type").toUpperCase();
			
			HashMapData.mapProcessInvoices.put(processInvoicesData.URLReservationNumber, processInvoicesData);
			processInvoicesData = HashMapData.mapProcessInvoices.get(processInvoicesData.URLReservationNumber);
			/*System.out.println("InvoiceNo: \t" + processInvoicesData.rq);
			System.out.println("Payment type: \t" + PaymentType);
			System.out.println("Point type: \t" + processInvoicesData.ConversionType);
			System.out.println("TotalAmount: \t" + processInvoicesData.TotalAmount);
			System.out.println("TotalPoints: \t" + processInvoicesData.TotalPoints);
			System.out.println("GiftCardNumber: \t" + processInvoicesData.GiftCardNumber);
			System.out.println("GiftCardPin: \t" + processInvoicesData.GiftCardPin);
			System.out.println("GiftCardTrackData: \t" + processInvoicesData.GiftCardTrackData);
			System.out.println("PaymentCardType: \t" + processInvoicesData.PaymentCardType);
			*/
			processInvoicesData.arrRequest = new JSONArray(processInvoicesData.rq);
			
			HashMapData.mapProcessInvoices.put(processInvoicesData.URLReservationNumber, processInvoicesData);
			processInvoicesData = HashMapData.mapProcessInvoices.get(processInvoicesData.URLReservationNumber);
			
			processInvoicesData.InvoiceCount = processInvoicesData.arrRequest.length();
			if(processInvoicesData.InvoiceCount == 0)
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
			
			
			processInvoicesData.RedeemPoints = processInvoicesData.TotalPoints;
			processInvoicesData.PointsRedeemedType = "TIC";
			
			HashMapData.mapProcessInvoices.put(processInvoicesData.URLReservationNumber, processInvoicesData);
			processInvoicesData = HashMapData.mapProcessInvoices.get(processInvoicesData.URLReservationNumber);
			
			StoreInvoiceDetails storeInvoiceDetails = HashMapData.mapInvoiceData.get(processInvoicesData.URLReservationNumber);
			
			
			processInvoicesData.TransactionComments = getReservationData.ConfirmationNo;
			processInvoicesData.RegisterNumber = getReservationData.ConfirmationNo;
			processInvoicesData.ConfirmationNo = getReservationData.ConfirmationNo;
			processInvoicesData.RoomNumber = getReservationData.RoomNo;
			processInvoicesData.BookingSource = "Web Booking";
			processInvoicesData.TransactionChannel = "Middleware UI";
			processInvoicesData.BillDate = storeInvoiceDetails.BillDate;
			
			HashMapData.mapProcessInvoices.put(processInvoicesData.URLReservationNumber, processInvoicesData);
			
			writeToPMS(request, response, redeemId, tcpMemberNumber, resvId, property,"_TataNeuPoints_"+customerHash);
						
		}
		else
		{
			try{
				BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + resvId+".txt",true));
				
				writer.write("\nRedirct URL: : \n" +"NewInvoices.jsp?ReservId="+resvId+"&PayStatus=failedSiebel&Property="+property+""+ "\n\n");
				writer.write((new Date()).toString());
				writer.close();
				
			} catch(Exception e)
			{
				e.printStackTrace();
			}
			servletResponse.getWriter().write("NewInvoices.jsp?ReservId="+resvId+"&PayStatus=failedSiebel&Property="+property+"");
			return;
		}
		}
		catch(Exception e)
		{
			try{
				BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + resvId+".txt",true));
				
				writer.write("\nRedirct URL: : \n" +"NewInvoices.jsp?ReservId="+resvId+"&PayStatus=failedSiebel&Property="+property+""+ "\n\n");
				writer.write((new Date()).toString());
				writer.close();
				
			} catch(Exception em)
			{
				em.printStackTrace();
			}
			servletResponse.getWriter().write("NewInvoices.jsp?ReservId="+resvId+"&PayStatus=failedSiebel&Property="+property+"");
			return;
		}
		
	}
	
	private void writeToPMS(HttpServletRequest request, HttpServletResponse response, String TransactionID, String PaymentDescription, String GResvNumber, String GlobalPropertyCode, String logId)
	{
		
		//double currencyConversionRate = HashMapData.mapCurrency.get(GResvNumber);
		ProcessInvoicesData processInvoicesData = HashMapData.mapProcessInvoices.get(GResvNumber);
		
		double tempTotalAmount = Double.parseDouble(processInvoicesData.TotalAmount);
		 
		
		String UserName = "Supervisor";
		
		Date date = new Date();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		
		
		System.out.println(dateFormat.format(date));
		System.out.println(timeFormat.format(date));
		
		String PostDate = dateFormat.format(date);
		String PostTime = timeFormat.format(date);
		
		int writeCount = 0; 
		
		try
			{
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
				String payload = "";
				if(GlobalPropertyCode.startsWith("IDS")) {
					String IDSRESVID = GetReservationData.RESVID;
					//if IDS pass reservation name ID = RESVTD from FBS
					 payload = payloads.getWriteToPMSPaylaod(GlobalPropertyCode, PostTime, UserName, PaymentDescription, writeBackAmount, PostDate, processInvoicesData.strWindowNo[i], getReservationData.HotelCode, IDSRESVID , processInvoicesData.PaymentCardType, TransactionID);
						
				}else {
					 payload = payloads.getWriteToPMSPaylaod(GlobalPropertyCode, PostTime, UserName, PaymentDescription, writeBackAmount, PostDate, processInvoicesData.strWindowNo[i], getReservationData.HotelCode, request.getParameter("GlobalReservationNumber"), processInvoicesData.PaymentCardType, TransactionID);
						
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
					BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.redemptionLog + request.getParameter("GlobalReservationNumber")+logId+".txt",true));
					
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
				String Action = URLConfig.getMakePaymentActionUrl(GlobalPropertyCode);
				
				String userName = "datacentre";
				String password = "Smile@25";
				
				SoapExecutor soapExecutor = new SoapExecutor(WSDL);
				
				String responce = soapExecutor.executeRequest(userName, password, Action,payload);
				
				System.out.println("Transaction Write Response: \n" + responce); 
				
				try{
					BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + request.getParameter("GlobalReservationNumber")+".txt",true));
					
					writer.write("\nPMS Payment Response: \n" + responce + "\n\n");
					writer.close();
					
				} catch(Exception e)
				{
					e.printStackTrace();
				}
				
				try{
					BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.redemptionLog + request.getParameter("GlobalReservationNumber")+logId+".txt",true));
					
					writer.write("\nPMS Payment Response: \n" + responce + "\n\n");
					writer.close();
					
				} catch(Exception e)
				{
					e.printStackTrace();
				}
				
				if(responce.contains("The timeout period elapsed prior to obtaining a connection from the pool")) {
					
					try{		     
						BufferedWriter writer2 = new BufferedWriter(new FileWriter(Configuration.logLoc +"TimeOutErrorLogs/"+GlobalPropertyCode+"_"+ request.getParameter("GlobalReservationNumber")+".txt",true));
						
						writer2.write("\nFuture Booking Response: \n" + responce + "\n\n");
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
				
				if(processInvoicesData.PaymentCardType.equals("QGC"))
				{
					try
					{
						BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.giftCardLogLoc + request.getParameter("GlobalReservationNumber")+".txt",true));

						writer.write("\n\nPMS Payment Response:\n " + responce + "\n");
						
						writer.close();
					}catch(Exception e)
					{
						e.printStackTrace();
					}

					
				}
		
				Document doc = soapExecutor.convertStringToDocument(responce);
				
				
				NodeList nList = doc.getElementsByTagName("s0:MakePaymentResponse");
				
				for(int j=0; j<nList.getLength(); j++)
				{
					Element Ele = (Element) nList.item(j);
					
					NodeList nListRes = Ele.getElementsByTagName("s0:Result");
					
					Element EleRes = (Element) nListRes.item(0);
					
					String isSuccess = EleRes.getAttribute("resultStatusFlag").toString();
					
					System.out.println(isSuccess);
					
					try{
						BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + request.getParameter("GlobalReservationNumber")+".txt",true));
						
						writer.write("\nPMS Payment Status: \t" + isSuccess + "\n\n");
						writer.close();
						
					} catch(Exception e)
					{
						e.printStackTrace();
					}
		
	
					
					
					if(isSuccess.equalsIgnoreCase("SUCCESS"))
					{
						writeCount++;
					}
				} 
				
				//writeCount++;				
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			try {
				/*if(writeCount == processInvoicesData.arrRequest.length())
				{
					servletResponse.getWriter().write("NewInvoices.jsp?ReservId="+processInvoicesData.URLReservationNumber+"&PayStatus=success");
					//servletResponse.sendRedirect("NewInvoices.jsp?ReservId="+StoreInvoiceDetails.ReservationID+"&PayStatus=success");
					return;
				}*/
				if(writeCount > 0)
				{
					try{
						BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + GResvNumber+".txt",true));
						
						writer.write("\nRedirct URL: : \n" +"NewInvoices.jsp?ReservId="+processInvoicesData.URLReservationNumber+"&PayStatus=success&Property="+GlobalPropertyCode+""+ "\n\n");
						writer.write((new Date()).toString());
						writer.close();
						
					} catch(Exception em)
					{
						em.printStackTrace();
					}
					
					servletResponse.getWriter().write("NewInvoices.jsp?ReservId="+processInvoicesData.URLReservationNumber+"&PayStatus=success&Property="+GlobalPropertyCode+"");
					System.out.println("URL: "+"NewInvoices.jsp?ReservId="+processInvoicesData.URLReservationNumber+"&PayStatus=success&Property="+GlobalPropertyCode+"");
					//servletResponse.sendRedirect("NewInvoices.jsp?ReservId="+StoreInvoiceDetails.ReservationID+"&PayStatus=success");
					return;
				} else
				{
					
					try{
						BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + GResvNumber+".txt",true));
						
						writer.write("\nRedirct URL: : \n" +"NewInvoices.jsp?ReservId="+processInvoicesData.URLReservationNumber+"&PayStatus=failedPMS&Property="+GlobalPropertyCode+""+ "\n\n");
						writer.write((new Date()).toString());
						writer.close();
						
					} catch(Exception em)
					{
						em.printStackTrace();
					}
					servletResponse.getWriter().write("NewInvoices.jsp?ReservId="+processInvoicesData.URLReservationNumber+"&PayStatus=failedPMS&Property="+GlobalPropertyCode+"");
					System.out.println("URL: "+"NewInvoices.jsp?ReservId="+processInvoicesData.URLReservationNumber+"&PayStatus=failedPMS&Property="+GlobalPropertyCode+"");
					//servletResponse.sendRedirect("NewInvoices.jsp?ReservId="+StoreInvoiceDetails.ReservationID+"&PayStatus=failedPMS");
					return;
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	String convertDateFormatTemp(String date)
	{
		try
		{
			SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat format2 = new SimpleDateFormat("dd-MMM-yyyy");
			Date convertedDate = format1.parse(date.substring(0, 10));
			String returnString = format2.format(convertedDate);
			return returnString;
		}
		catch(Exception e)
		{
			return "";
		}
	}

}
