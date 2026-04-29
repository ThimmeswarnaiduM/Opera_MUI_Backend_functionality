

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
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
import config.GetGiftCardBatchNumber;
import config.GetHotelsData;
import config.GetMemberData;
import config.GetProfileData;
import config.GetReservationData;
import config.GiftCardData;
import config.GiftCardRequestHeader;
import config.SoapExecutor;
import config.URLConfig;
import data.GiftCardPropertyMapping;
import data.HashMapData;
import data.NewInvoicesData;
import data.ProcessInvoicesData;
import data.StoreInvoiceDataMap;
import data.StoreInvoiceDetails;


@WebServlet("/ProcessInvoices")
public class ProcessInvoices extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String GlobalReservationNumber = "";
	String GlobalPropertyCode = "";
	String status_ = "";
	String RESVID = GetReservationData.RESVID;
	String GlobalOrionCode="";	
	HttpServletResponse servletResponse = null;
	
	ProcessInvoicesData processInvoicesData = null;
	JSONObject object = new JSONObject();
	

    public ProcessInvoices() {
        super();
        
    }

	
	@SuppressWarnings("null")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
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
		
		if(PaymentType.equals("Points"))
		{

			try{
				String memberCardType = request.getParameter("MemberCardType");
				if(memberCardType.equals("Swipe"))
				{
					@SuppressWarnings("unused")
					String localMemNum = request.getParameter("SwipeMemberNumber");
				} else if(memberCardType.equals("OTP"))
				{
					@SuppressWarnings("unused")
					String localMemNum = request.getParameter("MembershipNumber");
					
				}
			}catch(Exception e)
			{
				//e.printStackTrace();
			}
			
			processInvoicesData.ConversionType = request.getParameter("Type");
			processInvoicesData.TotalAmount = request.getParameter("Amount");				
			processInvoicesData.TotalPoints = request.getParameter("Points");
			processInvoicesData.PaymentCardType = request.getParameter("Type").toUpperCase();
			
			HashMapData.mapProcessInvoices.put(processInvoicesData.URLReservationNumber, processInvoicesData);
			processInvoicesData = HashMapData.mapProcessInvoices.get(processInvoicesData.URLReservationNumber);
			
			
		} else if(PaymentType.equals("GiftCard"))
		{
			String GCPayType = request.getParameter("GCPayType");
			processInvoicesData.GCPayType = GCPayType;
			
			NewInvoicesData newInvoicesData = HashMapData.mapNewInvoices.get(GlobalReservationNumber);
			String BillAmount = Double.toString(newInvoicesData.CurrentBalance);
			processInvoicesData.GCBillAmount = BillAmount;
			
			HashMapData.mapProcessInvoices.put(GlobalReservationNumber, processInvoicesData);
			processInvoicesData = HashMapData.mapProcessInvoices.get(GlobalReservationNumber);
			
			if(GCPayType.equals("Number"))
			{
				processInvoicesData.TotalAmount = request.getParameter("Amount");
				processInvoicesData.GiftCardNumber = request.getParameter("CardNumber");
				processInvoicesData.GiftCardPin = request.getParameter("CardPin");
				processInvoicesData.PaymentCardType = request.getParameter("Type");
				
			} else if(GCPayType.equals("Swipe"))
			{
				processInvoicesData.TotalAmount = request.getParameter("Amount");
				processInvoicesData.GiftCardNumber = request.getParameter("CardNumber");
				processInvoicesData.GiftCardTrackData= request.getParameter("TrackData");
				processInvoicesData.PaymentCardType = request.getParameter("Type");
				
				if(processInvoicesData.GiftCardTrackData.contains("/"))
				{
					processInvoicesData.GiftCardTrackData.replace("/", "?");
				}
			}
			
			
			
			HashMapData.mapProcessInvoices.put(processInvoicesData.URLReservationNumber, processInvoicesData);
			processInvoicesData = HashMapData.mapProcessInvoices.get(processInvoicesData.URLReservationNumber);
			
			try
			{
				BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.giftCardLogLoc + request.getParameter("GlobalReservationNumber")+".txt",true));

				writer.write("\n\nPayment Type:\t " + PaymentType + "\n");
				writer.write("\n\nGiftCard Pay Type:\t " + GCPayType + "\n");
				writer.write("\n\nPaying Bill Amount:\t " + BillAmount + "\n");
				writer.write("\n\nTotal Amount:\t " + processInvoicesData.TotalAmount + "\n");
				writer.write("\n\nGiftCard Number:\t " + processInvoicesData.GiftCardNumber + "\n");
				writer.write("\n\nGiftCard PIN:\t " + processInvoicesData.GiftCardPin + "\n");
				writer.write("\n\nGiftCard Track Data:\t " + processInvoicesData.GiftCardTrackData + "\n");
				writer.write("\n\nPayment Card Type:\t " + processInvoicesData.PaymentCardType + "\n");
				
				
				writer.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		
		
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
			
			if(PaymentType.equals("Points"))
			{
			
				if(processInvoicesData.ConversionType.equalsIgnoreCase("TIC"))
				{
					processInvoicesData.RedeemPoints = processInvoicesData.TotalPoints;
					processInvoicesData.PointsRedeemedType = "TIC";
					
					HashMapData.mapProcessInvoices.put(processInvoicesData.URLReservationNumber, processInvoicesData);
					processInvoicesData = HashMapData.mapProcessInvoices.get(processInvoicesData.URLReservationNumber);
					
				}else if(processInvoicesData.ConversionType.equalsIgnoreCase("EPR"))
				{
					processInvoicesData.RedeemPoints = processInvoicesData.TotalPoints;
					processInvoicesData.PointsRedeemedType = "Epicure";
					
					HashMapData.mapProcessInvoices.put(processInvoicesData.URLReservationNumber, processInvoicesData);
					processInvoicesData = HashMapData.mapProcessInvoices.get(processInvoicesData.URLReservationNumber);
					
				}
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
		
		
		if(PaymentType.equals("Points"))
		{
			//payUsingPoint(processInvoicesData.URLReservationNumber);
			
			String localMemberNumber = processInvoicesData.EnrollNumber_c;
			String EnteredOTP = "";
			
			try
			{
				String memberCardType = request.getParameter("MemberCardType");
				if(memberCardType.equals("Swipe"))
				{
					localMemberNumber = request.getParameter("SwipeMemberNumber");
				}else if(memberCardType.equals("OTP"))
				{
					localMemberNumber = request.getParameter("MembershipNumber");
					EnteredOTP = request.getParameter("userEnteredOTP");
				}
			}catch(Exception e)
			{
				
			}
			//String PropertyCode = getPropertyCode(GlobalPropertyCode);
			//System.out.println("Siebel Property Code: \t" + PropertyCode);
			if(GlobalPropertyCode != null || !GlobalPropertyCode.equalsIgnoreCase("") || !GlobalPropertyCode.equalsIgnoreCase("null"))
			{
				/*String confNumber = request.getParameter("confirmationNumberDis");
				String arrival = request.getParameter("arrivalDis");
				
				
				String departure = request.getParameter("DepartureDis");*/
				String confNumber = processInvoicesData.ConfirmationNo;
				String KJhgfh=request.getParameter("GlobalPropertyCode");
				System.out.println("KJhgfh:"+KJhgfh);
				
				String arrival = convertDateFormat(processInvoicesData.CheckInDate);
				String departure = convertDateFormat(processInvoicesData.CheckOutDate);
				payUsingPoint(request, response, processInvoicesData.URLReservationNumber, GlobalPropertyCode, processInvoicesData.TransactionComments, processInvoicesData.PaymentType, processInvoicesData.PaymentTransID, processInvoicesData.RegisterNumber, processInvoicesData.TotalAmount, localMemberNumber, processInvoicesData.RedeemPoints, processInvoicesData.PointsRedeemedType, EnteredOTP, confNumber, arrival, departure);
				return;
			} else 
			{
				servletResponse.getWriter().write("NewInvoices.jsp?ReservId="+processInvoicesData.URLReservationNumber+"&PayStatus=failedSiebelProperty&Property="+GlobalPropertyCode+"");

try{
			GetReservationData getReservationData = HashMapData.mapReservationData.get(GlobalReservationNumber);
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + request.getParameter("GlobalReservationNumber")+".txt",true));
			
			writer.write("NewInvoices.jsp?ReservId="+processInvoicesData.URLReservationNumber+"&PayStatus=failedSiebelProperty&Property="+GlobalPropertyCode+"");
			
			writer.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
				
				return;
			}

		}  else if(PaymentType.equals("GiftCard"))
		{
			payUsingGiftCard(request, response, processInvoicesData.URLReservationNumber, GlobalPropertyCode, processInvoicesData.TotalAmount);
		}
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	private void payUsingPoint(HttpServletRequest request, HttpServletResponse response,String GResvNumber, String GlobalPropertyCode, String TransactionComments, String PaymentType, String PaymentTransID, String RegisterNumber, String TotalAmount, String EnrollNumber_c, String RedeemPoints, String PointsRedeemedType, String EnteredOTP, String confNumber, String arrival, String departure)
	{
	System.out.println("GlobalPropertyCode:"+GlobalPropertyCode);
		try
		{
			if(GResvNumber == null || GlobalPropertyCode == null || PaymentType == null || RegisterNumber == null || TotalAmount == null || EnrollNumber_c == null || RedeemPoints == null ||  PointsRedeemedType == null || GResvNumber.equals("") || GlobalPropertyCode.equals("") || PaymentType.equals("") || RegisterNumber.equals("") || TotalAmount.equals("") || EnrollNumber_c.equals("") || RedeemPoints.equals("") ||  PointsRedeemedType.equals("") )
			{
				servletResponse.getWriter().write("NewInvoices.jsp?ReservId="+processInvoicesData.URLReservationNumber+"&PayStatus=failedSiebelError&Property="+GlobalPropertyCode+"");

try{
			GetReservationData getReservationData = HashMapData.mapReservationData.get(GlobalReservationNumber);			
			BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + request.getParameter("GlobalReservationNumber")+".txt",true));			
			writer.write("NewInvoices.jsp?ReservId="+processInvoicesData.URLReservationNumber+"&PayStatus=failedSiebelError&Property="+GlobalPropertyCode+"");		
			writer.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
				
				return;
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
/*		String TcpCustomerHashtemp = "";
		try
		{
		String getMemberPayload = (new ConfigPayloads()).getMemberDataPayload(EnrollNumber_c);
		OkHttpClient clientGetMember = new OkHttpClient();
		MediaType mediaTypeGetMember = MediaType.parse("application/json");
		RequestBody bodyGetMember = RequestBody.create(mediaTypeGetMember, getMemberPayload);
		Request requestGetMember = new Request.Builder()
		  .url(Configuration.GetMemberDataURL)
		  .method("POST", bodyGetMember)
		  .addHeader("Authorization", Configuration.IcsBasicAuth)
		  .addHeader("Content-Type", "application/json")
		  .build();
		Response responseMember = clientGetMember.newCall(requestGetMember).execute();
		
		String testResponse = responseMember.body().string();
		JSONObject objectMember = new JSONObject(testResponse);
		//MembershipNumber = objectMember.getString("tcpNumber");
		TcpCustomerHashtemp = objectMember.getString("customerHash");
		System.out.println("TcpCustomerHashtemp : "+TcpCustomerHashtemp);
		}
		catch(Exception e)
		{
			
		}*/
		Random rand = new Random(); 
        int rand_int1 = rand.nextInt(1000000); 
		ProcessInvoicesData processInvoicesData = HashMapData.mapProcessInvoices.get(GResvNumber);
		GetMemberData getMemberData = HashMapData.mapMemberData.get(GResvNumber);
		String notes = confNumber+" | "+arrival+" | "+departure;
		String payload = "{\r\n" + 
				"\"pointsRedeemed\": \""+RedeemPoints+"\",\r\n" + 
				"\"customerHash\": \""+getMemberData.redeemTCPCustomerHash+"\",\r\n" + 
				"\"otp\":\""+EnteredOTP+"\",\r\n" + 
				"\"transactionNumber\": \""+confNumber+"\",\r\n" + 
				"\"externalReferenceNumber\":\""+GlobalPropertyCode+GResvNumber+"-"+rand_int1+"\",\r\n" + 
				"\"cardNo\": \"\",\r\n" + 
				"\"refID\":\"\",\r\n" + 
				"\"notes\": \""+notes+"\",\r\n" + 
				 "    \"customFields\": { " + 
				 "        \"field\": [ " + 
				 "            { " + 
				 "                \"name\": \"checkin_date\", " + 
				 "                \"value\": \""+ arrival +"\""+  
				 "            }, " + 
				 "            { " + 
				 "                \"name\": \"checkout_date\", " + 
				 "                \"value\": \"" + departure+"\""+
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
				 "                \"value\": \""+ confNumber+"\""+ 
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
		
		System.out.println("Payment Request payload: \n" + payload);
		
		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + request.getParameter("GlobalReservationNumber")+".txt",true));
			
			writer.write("\nPoints Payment Request payload: \n" + payload + "\n\n");
			writer.close();
			
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		// Redemption Logs
		
		
		
		
		try
		{
		/*
		OkHttpClient client = new OkHttpClient();
		client.setConnectTimeout(70, TimeUnit.SECONDS);
		client.setReadTimeout(70, TimeUnit.SECONDS);

		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType, payload);
		Request req = new Request.Builder()
				.url(Configuration.PayUsingPointsURL)
				  .post(body)
				  .addHeader("authorization", Configuration.IcsBasicAuth)
				  .addHeader("content-type", "application/json")
				  .addHeader("cache-control", "no-cache")
				  .addHeader("postman-token", "526a0f00-cf5d-6206-0597-0cd24e92f3b1")
				  .build();

		Response resp = client.newCall(req).execute();
		*/
			GetHotelsData hotelsData = new GetHotelsData();
			//String PropertyCode = hotelsData.getProperty(request.getParameter("GlobalPropertyCode"));
			//String s=GetHotelsData.getHotel(GlobalPropertyCode);
            
            //String GlobalOrionCode = HashMapData.mapOrionCode.get(GlobalPropertyCode);                                       
			
			
			
		OkHttpClient client = new OkHttpClient();
		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType, payload);
		Request req = new Request.Builder()
		  .url(Configuration.PayUsingPointsURL)
		  .method("POST", body)
		  .addHeader("store_id", GlobalPropertyCode)
		  .addHeader("Authorization", Configuration.IcsBasicAuth)
		  .addHeader("Content-Type", "application/json")
		  .build();
		Response resp = client.newCall(req).execute();
		
		String strRes = resp.body().string();
		
		System.out.println("Payment Response: " + strRes);
		
		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + request.getParameter("GlobalReservationNumber")+".txt",true));
			
			writer.write("\nPoints Payment Response: \n" + strRes + "\n\n");
			writer.close();
			
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		
		//Remdemption logs
		try{
			BufferedWriter writer02 = new BufferedWriter(new FileWriter(Configuration.redemptionLog + request.getParameter("GlobalReservationNumber")+"_TataNeuPoints_"+getMemberData.redeemTCPCustomerHash+".txt",true));
			writer02.write((new Date()).toString());
			writer02.write("\nPoints Payment Request payload: \n" + payload + "\n\n");
			writer02.write("\nPoints Payment Response: \n" + strRes + "\n\n");
			
			writer02.close();
			
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		
		String isSucess = "";
		String redeemId = "";
		if(strRes.contains("OTP Validation fail"))
		{
			isSucess = "Fail";
		}
		else
		{
			JSONObject jsonObj = new JSONObject(strRes).getJSONObject("response");
			JSONObject statusObj = jsonObj.getJSONObject("status");
			String status = statusObj.getString("success");
			if(status.equals("true"))
			{
				redeemId = jsonObj.getJSONObject("responses").getJSONObject("points").getString("redemption_id");
				isSucess = "Success";
			}
			else
			{
				isSucess = "Fail";
			}
		}
		
		
		System.out.println("Points payment isSuccess:\t" + isSucess);
	//	isSucess = "Success";////dont uncomment
		if(isSucess.equalsIgnoreCase("Success"))
		
		{
			//String TransactionId = objPayRes.getString("TransactionId");
			String TransactionId = redeemId;
			//String PromotionRuleName = objPayRes.getString("PromotionRuleName");
			writeToPMS(request, response, TransactionId, EnrollNumber_c, processInvoicesData.URLReservationNumber, GlobalPropertyCode,"_TataNeuPoints_"+getMemberData.redeemTCPCustomerHash);

			//servletResponse.getWriter().write("NewInvoices.jsp?ReservId="+processInvoicesData.URLReservationNumber+"&PayStatus=success&Property="+GlobalPropertyCode+"");
			//return;
		} else {
			
			if(strRes.contains("OTP Validation fail"))
				servletResponse.getWriter().write("NewInvoices.jsp?ReservId="+processInvoicesData.URLReservationNumber+"&PayStatus=failedSiebelOTP&Property="+GlobalPropertyCode+"");
					else
						servletResponse.getWriter().write("NewInvoices.jsp?ReservId="+processInvoicesData.URLReservationNumber+"&PayStatus=failedSiebel&Property="+GlobalPropertyCode+"");			

try{
			GetReservationData getReservationData = HashMapData.mapReservationData.get(GlobalReservationNumber);
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + request.getParameter("GlobalReservationNumber")+".txt",true));
			if(strRes.contains("OTP Validation fail"))
			writer.write("NewInvoices.jsp?ReservId="+processInvoicesData.URLReservationNumber+"&PayStatus=failedSiebelOTP&Property="+GlobalPropertyCode+"");
			else
				writer.write("NewInvoices.jsp?ReservId="+processInvoicesData.URLReservationNumber+"&PayStatus=failedSiebel&Property="+GlobalPropertyCode+"");
			writer.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
			//servletResponse.getWriter().write("NewInvoices.jsp?ReservId="+processInvoicesData.URLReservationNumber+"&PayStatus=OTPValidationFail&Property="+GlobalPropertyCode+"");
			//servletResponse.sendRedirect("NewInvoices.jsp?ReservId="+StoreInvoiceDetails.ReservationID+"&PayStatus=failedSiebel");
		//	servletResponse.getWriter().write("NewInvoices.jsp?ReservId="+processInvoicesData.URLReservationNumber+"&PayStatus=failedSiebel&Property="+GlobalPropertyCode+"");
		//	servletResponse.getWriter().write("NewInvoices.jsp?ReservId="+processInvoicesData.URLReservationNumber+"&PayStatus=failedSiebel&Property="+GlobalPropertyCode+"");
			return;
		}
		
//		System.out.println(objPayRes);
		
		
		
		} catch(Exception e)
		{
			e.printStackTrace();
			try {
				servletResponse.getWriter().write("NewInvoices.jsp?ReservId="+processInvoicesData.URLReservationNumber+"&PayStatus=failedSiebel&Property="+GlobalPropertyCode+"");
				//servletResponse.sendRedirect("NewInvoices.jsp?ReservId="+StoreInvoiceDetails.ReservationID+"&PayStatus=failedSiebel");
				try{
					GetReservationData getReservationData = HashMapData.mapReservationData.get(GlobalReservationNumber);
					
					BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + request.getParameter("GlobalReservationNumber")+".txt",true));
					
					writer.write(servletResponse.toString());
					
					writer.close();
					
				}catch(Exception e1){
					e1.printStackTrace();
				}

				
				return;
			}catch(Exception ae)
			{
				ae.getMessage();
			}
		}
	}
	
	/*private String dateFormat(String oldDate)
	{
		String newDate = "";
		
		try {

			SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
			Date date = dt.parse(oldDate);

			SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy");
			newDate = dt1.format(date);
			return newDate;
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
			newDate = "";
		}
		
		return newDate;
	}*/
	
	private void writeToPMS(HttpServletRequest request, HttpServletResponse response, String TransactionID, String PaymentDescription, String GResvNumber, String GlobalPropertyCode, String logsID)
	{

		//double currencyConversionRate = HashMapData.mapCurrency.get(GResvNumber);
		ProcessInvoicesData processInvoicesData = HashMapData.mapProcessInvoices.get(GResvNumber);

		double tempTotalAmount = Double.parseDouble(processInvoicesData.TotalAmount);

		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + request.getParameter("GlobalReservationNumber")+".txt",true));
			writer.write("\ntempTotalAmount  before condition: \n" + tempTotalAmount + "\n\n");

			writer.close();

		} catch(Exception e)
		{
			e.printStackTrace();
		}



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
					try{
						BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + request.getParameter("GlobalReservationNumber")+".txt",true));
						writer.write("\nwriteBackAmount: \n"+i+":" + writeBackAmount+ "\n\n");
						writer.close();
						} catch(Exception e){e.printStackTrace();}
					// Redemption Logs

					try{
						BufferedWriter writer02 = new BufferedWriter(new FileWriter(Configuration.redemptionLog + request.getParameter("GlobalReservationNumber")+logsID+".txt",true));
						writer02.write((new Date()).toString());
						writer02.write("\nwriteBackAmount: \n"+i+":" + writeBackAmount+ "\n\n");
						writer02.close();
						} catch(Exception e){e.printStackTrace();}

					if(tempTotalAmount >= writeBackAmount)
						tempTotalAmount = tempTotalAmount - writeBackAmount;
					else
					{
						writeBackAmount = tempTotalAmount;
						tempTotalAmount = 0;

						try{
							BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + request.getParameter("GlobalReservationNumber")+".txt",true));
							writer.write("\nentered total amount is lessthan write back amount condition: \n" + tempTotalAmount + "< \n\n"+writeBackAmount+" \n\n");
							writer.close();

						} catch(Exception e)
						{
							e.printStackTrace();
						}
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
					//Paylode IDS change

					String IDSRESVID = GetReservationData.RESVID;
					payload = payloads.getWriteToPMSPaylaod(GlobalPropertyCode, PostTime, UserName, PaymentDescription, writeBackAmount, PostDate, processInvoicesData.strWindowNo[i], getReservationData.HotelCode, IDSRESVID, processInvoicesData.PaymentCardType, TransactionID);

				}

				else {
					payload = payloads.getWriteToPMSPaylaod(GlobalPropertyCode, PostTime, UserName, PaymentDescription, writeBackAmount, PostDate, processInvoicesData.strWindowNo[i], getReservationData.HotelCode, request.getParameter("GlobalReservationNumber"), processInvoicesData.PaymentCardType, TransactionID);

				}


				try{
					BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + request.getParameter("GlobalReservationNumber")+".txt",true));
					writer.write("\n--------------------------------------------\n");
					writer.write("\ndata after writeback amount condition\n\n");
					writer.write("\ntempTotalAmount: \n" + tempTotalAmount + "\n\n");
					writer.write("\nwriteBackAmount: \n" + writeBackAmount + "\n\n");
					writer.write("\nPMS Payment Request payload: \n" + payload + "\n\n");
					writer.write("\n--------------------------------------------\n");
					writer.close();

				} catch(Exception e)
				{
					e.printStackTrace();
				}

				try{
					BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.redemptionLog + request.getParameter("GlobalReservationNumber")+logsID+".txt",true));
					writer.write("\n--------------------------------------------\n");
					writer.write("\ndata after writeback amount condition\n\n");
					writer.write("\ntempTotalAmount: \n" + tempTotalAmount + "\n\n");
					writer.write("\nwriteBackAmount: \n" + writeBackAmount + "\n\n");
					writer.write("\nPMS Payment Request payload: \n" + payload + "\n\n");
					writer.write("\n--------------------------------------------\n");
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

						writer.write("\n\nPMS QC Gift Card Payment Request:\n " + payload + "\n");

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
				String WSDL ;
				String Action, userName, password ;
				if(URLConfig.owsOperaCentralOperaCloud(GlobalPropertyCode))
				{
					WSDL = Configuration.MakePaymentOperaCloudWSDL;
					WSDL = WSDL+request.getParameter("GlobalReservationNumber");
//					Action = Configuration.MakePaymentOperaCloudWSDL;
//					userName = Configuration.OperaCloudUsername;
//					password = Configuration.OperaCloudPassword;
				}
				else {
					WSDL = URLConfig.getMakePaymentWSDL(GlobalPropertyCode);
					Action = URLConfig.getMakePaymentActionUrl(GlobalPropertyCode);
				userName = "oic_user";
				password = "Innovacx@321";
				}
				Response writeBackToPMSResponse = Configuration.writeBackToPMSResponse(WSDL, GlobalPropertyCode, payload);
				String responce = writeBackToPMSResponse.body().string();
				try{
					BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + request.getParameter("GlobalReservationNumber")+".txt",true));

					writer.write("\n writeBackToPMSResponse: \n" + responce + "\n\n");
					writer.close();

				} catch(Exception e)
				{
					e.printStackTrace();
				}


//				SoapExecutor soapExecutor = new SoapExecutor(WSDL);
//				payload= payload.replace("cardType=\"GCPIN\"", "cardType=\"QGC\"");
//				String responce = soapExecutor.executeRequest(userName, password, Action,payload);

				System.out.println("Transaction Write Response: \n" + responce);
				if(URLConfig.owsOperaCentralOperaCloud(GlobalPropertyCode))
				{
					responce = Configuration.ReplaceNameSpacesMakePayment(responce);
				}
				try{
					BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + request.getParameter("GlobalReservationNumber")+".txt",true));

					writer.write("\nPMS QC Gift Card Payment Response: \n" + responce + "\n\n");
					writer.close();

				} catch(Exception e)
				{
					e.printStackTrace();
				}

				try{
					BufferedWriter writer02 = new BufferedWriter(new FileWriter(Configuration.redemptionLog + request.getParameter("GlobalReservationNumber")+logsID+".txt",true));
					writer02.write((new Date()).toString());
					writer02.write("\nAmount Write back to PMS Response\n" + responce + "\n\n");
					writer02.close();

				} catch(Exception e)
				{
					e.printStackTrace();
				}
				if(responce.contains("Error 503--Service Unavailable")  || responce.contains("Service Unavailable") || responce.contains("Error 503")  || responce.contains("Error 503--Service Unavailable")) {
					String EmailStatus = GetReservationData.SendEmailAlert(request.getParameter("GlobalReservationNumber") , GlobalPropertyCode, "PMS Make Payment");
					try{
						BufferedWriter writer1 = new BufferedWriter(new FileWriter(Configuration.logLoc +"ErrorLogs/"+ request.getParameter("GlobalReservationNumber")+".txt",true));

						writer1.write("\nPMS Payment Response: \n" + responce + "\n\n");
						writer1.close();
					} catch(Exception e)
					{
						e.printStackTrace();
					}

				}else if(responce.contains("The timeout period elapsed prior to obtaining a connection from the pool")){

						try{
							BufferedWriter writer1 = new BufferedWriter(new FileWriter(Configuration.logLoc +"TimeOutErrorLogs/"+GlobalPropertyCode+"_"+request.getParameter("GlobalReservationNumber")+".txt",true));

							writer1.write("\nPMS Payment Response: \n" + responce + "\n\n");
							writer1.close();
						} catch(Exception e)
						{
							e.printStackTrace();
						}
					}
               // MUI Redemption Logs
	               // MUI Redemption Logs

				if(processInvoicesData.PaymentCardType.equals("QGC") || processInvoicesData.PaymentCardType.equals("GCPIN"))
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

				JSONObject req = null;
				try {
					req = new JSONObject(responce);
				} catch (JSONException e) {
					e.printStackTrace();
				}
				String codeandmessage = writeBackToPMSResponse.toString();
				Map<String, String> result = Configuration.getCodeAndMessage(codeandmessage);

//				Document doc = soapExecutor.convertStringToDocument(responce);
//
//
//				NodeList nList = doc.getElementsByTagName("s0:MakePaymentResponse");
//
//				for(int j=0; j<nList.getLength(); j++)
//				{
//					Element Ele = (Element) nList.item(j);
//
//					NodeList nListRes = Ele.getElementsByTagName("s0:Result");
//
//					Element EleRes = (Element) nListRes.item(0);
//
//					String isSuccess = EleRes.getAttribute("resultStatusFlag").toString();
//
//					System.out.println(isSuccess);
//
//					try{
//						BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + request.getParameter("GlobalReservationNumber")+".txt",true));
//
//						writer.write("\nPMS Payment Status: \t" + isSuccess + "\n\n");
//						writer.close();
//
//					} catch(Exception e)
//					{
//						e.printStackTrace();
//					}
//					try{
//						BufferedWriter writer02 = new BufferedWriter(new FileWriter(Configuration.redemptionLog + request.getParameter("GlobalReservationNumber")+logsID+".txt",true));
//						writer02.write((new Date()).toString());
//						writer02.write("\nPMS Payment Status: \t" + isSuccess + "\n\n");
//						writer02.close();
//
//					} catch(Exception e)
//					{
//						e.printStackTrace();
//					}
//
//
//					if(isSuccess.equalsIgnoreCase("SUCCESS"))
//					{
//						writeCount++;
//					}
//				}

				//writeCount++;
				if(result.get("code").equalsIgnoreCase("200") && result.get("message").equalsIgnoreCase("OK"))
				{
						writeCount++;
				}
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
					this.object.put("url02", "NewInvoices.jsp?ReservId="+processInvoicesData.URLReservationNumber+"&PayStatus=success&Property="+GlobalPropertyCode+"");
					//servletResponse.getWriter().write(this.object.toString());
					//servletResponse.getWriter().write("NewInvoices.jsp?ReservId="+processInvoicesData.URLReservationNumber+"&PayStatus=success&Property="+GlobalPropertyCode+"");
					//servletResponse.sendRedirect("NewInvoices.jsp?ReservId="+StoreInvoiceDetails.ReservationID+"&PayStatus=success");

try{
			GetReservationData getReservationData = HashMapData.mapReservationData.get(GlobalReservationNumber);
			BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + request.getParameter("GlobalReservationNumber")+".txt",true));
			writer.write("NewInvoices.jsp?ReservId="+processInvoicesData.URLReservationNumber+"&PayStatus=success&Property="+GlobalPropertyCode+"");
			writer.close();

		}catch(Exception e){
			e.printStackTrace();
		}

					return;
				} else
				{
					status_ ="WriteToPmsFailed";
				//	this.object.put("status", "WriteToPmsFailed");
					if(processInvoicesData.PaymentCardType.equals("QGC")) {
						servletResponse.getWriter().write("NewInvoices.jsp?ReservId="+processInvoicesData.URLReservationNumber+"&PayStatus=failedPMS&Property="+GlobalPropertyCode+"");
						try{
							GetReservationData getReservationData = HashMapData.mapReservationData.get(GlobalReservationNumber);
							BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + request.getParameter("GlobalReservationNumber")+".txt",true));
							writer.write("NewInvoices.jsp?ReservId="+processInvoicesData.URLReservationNumber+"&PayStatus=failedPMS&Property="+GlobalPropertyCode+"");
							writer.close();

						}catch(Exception e){
							e.printStackTrace();
						}
					}
					//servletResponse.sendRedirect("NewInvoices.jsp?ReservId="+StoreInvoiceDetails.ReservationID+"&PayStatus=failedPMS");
					return;
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	
	private void payUsingGiftCard(HttpServletRequest request, HttpServletResponse response, String GResvNumber, String GlobalPropertyCode, String TotalAmount)
	{
		ProcessInvoicesData processInvoicesData = HashMapData.mapProcessInvoices.get(GResvNumber);
		
		GetReservationData reservationData = HashMapData.mapReservationData.get(GlobalReservationNumber);
		String PMSPropertyCode = reservationData.OWSProperty;		
		
		//code to get the property name
		@SuppressWarnings("unused")
		Configuration configuration = new Configuration();
		GiftCardPropertyMapping mapping = new GiftCardPropertyMapping();
		String PropertyName = mapping.getGcHotelName(PMSPropertyCode);
		
		
		String gcTerminalID = GiftCardRequestHeader.TerminalID;
		String gcDateAtClient = mapping.getDateAtClient();
		String gcForwardEntityId = GiftCardRequestHeader.ForwardEntityId;
		String gcForwardingEntityPassword = GiftCardRequestHeader.ForwardingEntityPassword;
		String gcTransactionId = mapping.getTransactionId();
		String gcUserName = GiftCardRequestHeader.UserName;
		String gcPassword = GiftCardRequestHeader.Password;
		String gcOrganizationName = GiftCardRequestHeader.OrganizationName;
		String gcMerchantOutletName = PropertyName;
		String gcPOSEntryMode = GiftCardRequestHeader.POSEntryMode;
		String gcPOSTypeId = GiftCardRequestHeader.POSTypeId;
		
		
		HashMapData.mapProcessInvoices.put(processInvoicesData.URLReservationNumber, processInvoicesData);
		processInvoicesData = HashMapData.mapProcessInvoices.get(processInvoicesData.URLReservationNumber);

		
		GetGiftCardBatchNumber giftCardBatchNumber = new GetGiftCardBatchNumber(gcTerminalID, gcDateAtClient, gcForwardEntityId, gcForwardingEntityPassword, gcTransactionId, gcUserName, gcPassword);
		
		String BatchNumber = giftCardBatchNumber.batchNumber();
				
		
		// String Remarks = "Stay Redemption";
		
		String Remarks = processInvoicesData.FirstName + " " + processInvoicesData.LastName;
		
		
		ConfigPayloads payloads = new ConfigPayloads();
		
		String payload = "";
		
		
		if(BatchNumber != null && !BatchNumber.equals("") && processInvoicesData.PaymentCardType.equals("QGC"))
		{
			//code for generating IdempotencyKey for GC
			SimpleDateFormat format = new SimpleDateFormat("hhmmss");
			Date date = new Date();
			String d = format.format(date);
			String IdempotencyKey = processInvoicesData.ConfirmationNo + d;
			
			for(int i=0; i<=2; i++)
			{
				
				/*if(i == 0)
				{
					payload = payloads.getPayUsingGiftCardPayload(TotalAmount, processInvoicesData.GiftCardNumber, processInvoicesData.GiftCardPin, processInvoicesData.GiftCardTrackData, Remarks, "", processInvoicesData.ConfirmationNo);
					
					System.out.println("Giftcard Payload: \n"+ payload );
					
					try{
						BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + request.getParameter("GlobalReservationNumber")+".txt",true));
						
						writer.write("\nGiftCard Payment Request payload: \n" + payload + "\n\n");
						writer.close();
						
					} catch(Exception e)
					{
						e.printStackTrace();
					}
					
				} else
				{
					*/
					payload = payloads.getPayUsingGiftCardPayload(TotalAmount, processInvoicesData.GCBillAmount, processInvoicesData.GiftCardNumber, processInvoicesData.GiftCardPin, processInvoicesData.GiftCardTrackData, Remarks, IdempotencyKey, processInvoicesData.ConfirmationNo);
					
					System.out.println("Giftcard Payload: \n"+ payload );
					
					try{
						BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + request.getParameter("GlobalReservationNumber")+".txt",true));
						writer.write("Requested At:\t " + new Date());
						writer.write("\nGiftCard Payment Request payload Idempotency: \n" + payload + "\n\n");
						writer.close();
						
					} catch(Exception e)
					{
						e.printStackTrace();
					}
					try{
						BufferedWriter writer02 = new BufferedWriter(new FileWriter(Configuration.redemptionLog + request.getParameter("GlobalReservationNumber")+"_GiftCard_"+processInvoicesData.GiftCardNumber+".txt",true));
						writer02.write("Requested At:\t " + new Date());
						writer02.write("\nGiftCard Payment Request payload Idempotency: \n" + payload + "\n\n");
						writer02.close();
						
					} catch(Exception e)
					{
						e.printStackTrace();
					}
					try
					{
						BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.giftCardLogLoc + request.getParameter("GlobalReservationNumber")+".txt",true));

						writer.write("\n\nBatch Number:\t" + BatchNumber );
						writer.write("\n\nGiftCard Payment Request payload:\n " + payload + "\n");
						
						writer.close();
					}catch(Exception e)
					{
						e.printStackTrace();
					}
				//}
				
				try {
					
					OkHttpClient client = new OkHttpClient();
		
					MediaType mediaType = MediaType.parse("application/json");
					RequestBody body = RequestBody.create(mediaType, payload);
					Request req = new Request.Builder()
							.url(Configuration.PayUsingGiftCardURL)
							  .post(body)
							  .addHeader("TerminalID", gcTerminalID)
							  .addHeader("ForwardEntityId", gcForwardEntityId)
							  .addHeader("ForwardingEntityPassword", gcForwardingEntityPassword)
							  .addHeader("UserName", gcUserName)
							  .addHeader("Password", gcPassword)
							  .addHeader("TransactionId", gcTransactionId)
							  .addHeader("DateAtClient", gcDateAtClient)
							  .addHeader("POSEntryMode", gcPOSEntryMode)
							  .addHeader("POSTypeId", gcPOSTypeId)
							  .addHeader("MerchantOutletName", gcMerchantOutletName)
							  .addHeader("OrganizationName", gcOrganizationName)
							  .addHeader("CurrentBatchNumber", BatchNumber)
							  .addHeader("Authorization", Configuration.IcsBasicAuth)
							  .addHeader("cache-control", "no-cache")
							  .addHeader("postman-token", "5dbee3df-025c-29b0-cc52-007cb293ec39")
							  .addHeader("content-type", "application/json")
							  .build();
					
					Response res = null;
					
					try
					{
						res = client.newCall(req).execute();
						
					}catch(Exception e)
					{
						
						
						try{
							BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + request.getParameter("GlobalReservationNumber")+".txt",true));
							writer.write("\n\nException TimeOut At:\t " + new Date() + "\n\n");
							writer.close();
							
						} catch(Exception e1)
						{
							e1.printStackTrace();
						}
						try{
							BufferedWriter writer02 = new BufferedWriter(new FileWriter(Configuration.redemptionLog + request.getParameter("GlobalReservationNumber")+"_GiftCard_"+processInvoicesData.GiftCardNumber+".txt",true));
							writer02.write((new Date()).toString());
							writer02.write("\n\nException TimeOut At:\t " + new Date() + "\n\n");
							writer02.close();
							
						} catch(Exception e1)
						{
							e1.printStackTrace();
						}
						
						Thread.sleep(5000);
						
						//after 2 attempts also, if didn't response, do not make more calls, and return to home page
						if(i == 2)
						{
							servletResponse.getWriter().write("NewInvoices.jsp?ReservId="+processInvoicesData.URLReservationNumber+"&PayStatus=failedGC&Property="+GlobalPropertyCode+"");
							//after 2 attempts, clear the GiftCardData
							GiftCardData giftCardData = new GiftCardData();
							giftCardData.errorMsg = "Request timed out <br/>Please try again later";
							HashMapData.mapGiftCard.put(processInvoicesData.URLReservationNumber, giftCardData);
							
							return;
						}
						
						continue;
					}
					
					String resp = res.body().string();
					
					try
					{
						BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.giftCardLogLoc + request.getParameter("GlobalReservationNumber")+".txt",true));

						writer.write("\n\nGiftCard Payment Response:\n " + resp + "\n");
						
						writer.close();
					}catch(Exception e)
					{
						e.printStackTrace();
					}
					
					int respCode = res.code();
					GiftCardData giftCardData = new GiftCardData();

					System.out.println("Giftcard Response: \n" + resp);
					
					
					
					try{
						BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + request.getParameter("GlobalReservationNumber")+".txt",true));
						
						writer.write("\nGiftCard Payment Response: \n" + resp + "\n\n");
						writer.close();
						
					} catch(Exception e)
					{
						e.printStackTrace();
					}
					try{
						BufferedWriter writer02 = new BufferedWriter(new FileWriter(Configuration.redemptionLog + request.getParameter("GlobalReservationNumber")+"_GiftCard_"+processInvoicesData.GiftCardNumber+".txt",true));
						writer02.write((new Date()).toString());
						writer02.write("\nGiftCard Payment Response: \n" + resp + "\n\n");
						writer02.close();
						
					} catch(Exception e)
					{
						e.printStackTrace();
					}
					
					try
					{
						if(resp.contains("<html>") || resp.contains("Service Unavailable") || resp.contains("HTTP Error 503") || resp.contains("HTTP Error") || resp.contains("502 Bad Gateway"))
						{						
							giftCardData.errorMsg = "Please try again later";
							HashMapData.mapGiftCard.put(processInvoicesData.URLReservationNumber, giftCardData);
							
							try{
								BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + request.getParameter("GlobalReservationNumber")+".txt",true));
								writer.write("\n\nGiftCard Server Not Reachable At:\t " + new Date() + "\n\n");
								writer.close();
							} catch(Exception e1)
							{
								e1.printStackTrace();
							}
							try{
								BufferedWriter writer02 = new BufferedWriter(new FileWriter(Configuration.redemptionLog + request.getParameter("GlobalReservationNumber")+"_GiftCard_"+processInvoicesData.GiftCardNumber+".txt",true));
								writer02.write((new Date()).toString());
								writer02.write("\n\nGiftCard Server Not Reachable At:\t " + new Date() + "\n\n");
								writer02.close();
							} catch(Exception e1)
							{
								e1.printStackTrace();
							}
							
							//code for retry with Idempotency - when server gets shut down
							Thread.sleep(5000);
							
							//after 2 attempts also, if didn't response, do not make more calls, and return to home page
							if(i == 2)
							{
								servletResponse.getWriter().write("NewInvoices.jsp?ReservId="+processInvoicesData.URLReservationNumber+"&PayStatus=failedGC&Property="+GlobalPropertyCode+"");
								return;
							}
							
							continue;
							
							
						}
						else if(resp.contains("Either card number or card pin is incorrect.") ) {
							
							giftCardData.errorMsg = "Either card number or card pin is incorrect.";
							HashMapData.mapGiftCard.put(processInvoicesData.URLReservationNumber, giftCardData);
							
							try{
								BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + request.getParameter("GlobalReservationNumber")+".txt",true));
								writer.write("\n\nEither card number or card pin is incorrect.");
								writer.close();
							} catch(Exception e1)
							{
								e1.printStackTrace();
							}
							
							
							//code for retry with Idempotency - when server gets shut down
							Thread.sleep(5000);
							
							//after 2 attempts also, if didn't response, do not make more calls, and return to home page
							if(i == 2)
							{
								servletResponse.getWriter().write("NewInvoices.jsp?ReservId="+processInvoicesData.URLReservationNumber+"&PayStatus=failedGC&Property="+GlobalPropertyCode+"");
								return;
							}
							
							continue;
							
							
							
						}
                     else if (resp.contains("Your card has been temporarily deactivated for the day due to multiple attempts with invalid PIN. Please retry tomorrow.") ) {

							
							giftCardData.errorMsg = "Your card has been temporarily deactivated for the day due to multiple attempts with invalid PIN. Please retry tomorrow.";
							HashMapData.mapGiftCard.put(processInvoicesData.URLReservationNumber, giftCardData);
							
							try{
								BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + request.getParameter("GlobalReservationNumber")+".txt",true));
								writer.write("\n\nYour card has been temporarily deactivated for the day due to multiple attempts with invalid PIN. Please retry tomorrow.");
								writer.close();
							} catch(Exception e1)
							{
								e1.printStackTrace();
							}
							
							//code for retry with Idempotency - when server gets shut down
							Thread.sleep(5000);
							
							//after 2 attempts also, if didn't response, do not make more calls, and return to home page
							if(i == 2)
							{
								servletResponse.getWriter().write("NewInvoices.jsp?ReservId="+processInvoicesData.URLReservationNumber+"&PayStatus=failedGC&Property="+GlobalPropertyCode+"");
								return;
							}
							
							continue;																											
						
					}
						
					}catch(Exception e)
					{
						e.printStackTrace();
					}
					
					
					
					
					try {
						
						JSONObject jsonObject = new JSONObject(resp);
						
						String status = jsonObject.getString("ResponseCode");
						String msg = jsonObject.getString("ResponseMessage");
						
						giftCardData = new GiftCardData();
						giftCardData.errorMsg = msg;
						HashMapData.mapGiftCard.put(processInvoicesData.URLReservationNumber, giftCardData);
						
						System.out.println(status);
						
						if(status.equalsIgnoreCase("0"))
						{
							String ApprovalCode = jsonObject.getString("ApprovalCode");
							writeToPMS(request, response, ApprovalCode, processInvoicesData.GiftCardNumber, processInvoicesData.URLReservationNumber, GlobalPropertyCode,"_GiftCard_"+processInvoicesData.GiftCardNumber);
							
						} else if(status.equalsIgnoreCase("10064"))
						{
							HashMapData.mapBatchNumber.put("BatchNumber", "null");
							giftCardData.errorMsg = "Please try again in few minutes";
							HashMapData.mapGiftCard.put(processInvoicesData.URLReservationNumber, giftCardData);
							try {
								servletResponse.getWriter().write("NewInvoices.jsp?ReservId="+processInvoicesData.URLReservationNumber+"&PayStatus=failedGC&Property="+GlobalPropertyCode+"");
								return;
							}catch(Exception ae)
							{
								ae.printStackTrace();
							}
						} else
						{
							try {
								// giftCardData.errorMsg = "Please try again in few minutes";
								giftCardData.errorMsg = msg;
								HashMapData.mapGiftCard.put(processInvoicesData.URLReservationNumber, giftCardData);
								servletResponse.getWriter().write("NewInvoices.jsp?ReservId="+processInvoicesData.URLReservationNumber+"&PayStatus=failedGC&Property="+GlobalPropertyCode+"");
								return;
							}catch(Exception ae)
							{
								ae.printStackTrace();
							}
						}
						
						
					} catch (JSONException e) {
						e.printStackTrace();
						try {
							servletResponse.getWriter().write("NewInvoices.jsp?ReservId="+processInvoicesData.URLReservationNumber+"&PayStatus=failedGC&Property="+GlobalPropertyCode+"");
							return;
						}catch(Exception ae)
						{
							ae.printStackTrace();
						}
					}
					
				}catch(Exception e)
				{
					e.printStackTrace();
					try {
						servletResponse.getWriter().write("NewInvoices.jsp?ReservId="+processInvoicesData.URLReservationNumber+"&PayStatus=failedBatch&Property="+GlobalPropertyCode+"");
						return;
					}catch(Exception ae)
					{
						ae.printStackTrace();
					}
				}
				
				//if the GC is success, then stop iterating the loop
				break;
			}						
		} 
		//Gravty GC-PIN BLock Start
		else if (processInvoicesData.PaymentCardType.equals("GCPIN") ){			
			//code for generating IdempotencyKey for GC
			SimpleDateFormat format = new SimpleDateFormat("hhmmss");
			Date date = new Date();
			String d = format.format(date);
			String IdempotencyKey = processInvoicesData.ConfirmationNo + d;
			String status ="" ,status_ ="";
			String detail ="";
			String errorDetails="";
			Object item_id ="",obj_privilegeType ="",obj_value ="" , title_obj="" ,status_obj="";
			String Error = "" , title_="";
			double availableBal= 0;
			String privilegeType="";
			String Memtype = request.getParameter("Memtype");
			String VoucherNumber= request.getParameter("CardNumber");
			String ApprovalCode = "";
																			
					payload = payloads.getPayUsingGiftCardPayload(TotalAmount, processInvoicesData.GCBillAmount, processInvoicesData.GiftCardNumber, processInvoicesData.GiftCardPin, processInvoicesData.GiftCardTrackData, Remarks, IdempotencyKey, processInvoicesData.ConfirmationNo);
					
					System.out.println("Giftcard Payload: \n"+ payload );																													
				
				try {
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
								
								
									//errorDetails = jsonObject.getString("o:errorDetails");	
								try {
									JSONArray response_jsonarr = jsonObject.getJSONArray("o:errorDetails");
									JSONObject item_obj = response_jsonarr.getJSONObject(0);
									item_id = item_obj.get("title");
									Error=item_id.toString();
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
									
										JSONArray response_jsonarr = jsonObject.getJSONArray("data");
										JSONObject data_obj = response_jsonarr.getJSONObject(0);
										obj_privilegeType = data_obj.get("privilegeType");
										privilegeType=obj_privilegeType.toString();
										System.out.println("privilegeType: "+privilegeType);
										
										status_obj = data_obj.get("status");
										status_="";
										status_=status_obj.toString();
										System.out.println("Status: "+status_);
										
										
										if(privilegeType.equals("Fixed-Product") && status_.equals("AVAILABLE")) {
											JSONObject Json_value = response_jsonarr.getJSONObject(0);
											obj_value = Json_value.get("productCost");
											availableBal=(double) obj_value;
											System.out.println("availableBal: "+availableBal);
										}
							
					} catch (Exception e) {
						// TODO: handle exception
					}
					// GRAVTY - check balance api End
					if(Error.equals("Invalid unique privilege code")) {
						this.object.put("msg", Error);
						this.object.put("status","Availment Failed");						
					}
					else if (status_.equals("USED") && privilegeType.equals("Fixed-Product")) {
						this.object.put("msg", "Voucher Already Used");
						this.object.put("status","Availment Failed");
					}
					
					//double Amount =Integer.parse(request.getParameter("Amount"));
					double Amount = Double.parseDouble(request.getParameter("Amount"));
					if (availableBal >= Amount && privilegeType.equals("Fixed-Product") && status_.equals("AVAILABLE")) {
						//Get reservation details - Start
						OkHttpClient client_ = new OkHttpClient();
						Request request_ = new Request.Builder()
						  .url(Configuration.CDM_URL+"/crmCommonApi/resources/latest/Reservation_c?q=REGISTER_c="+processInvoicesData.ConfirmationNo+"")
						  .method("GET", null)
						  .addHeader("Authorization", "Basic UmFqLnNyaW5pdmFzYW5AaW5ub3ZhY3guY29tOlNtaWxlQDI1")
						  .addHeader("Content-Type", "application/json")
						  .build();
						Response response_ = client_.newCall(request_).execute();
						String resp_ = response_.body().string().toString();										
						System.out.println("resv resp: "+resp_);
						
						JSONObject response_json_obj = new JSONObject(resp_);
						
						//code changes
						int count = response_json_obj.getInt("count");
						Object RateCode = "";
						Object CHECKINDATE = "";
						Object CHECKOUTDATE = "";
						Object BOOKINGDATE = "";
						
						if(count == 0) {
							Configuration configuration1 = new Configuration();
							//Reservation_Status = "";
							configuration1.hotelList();
							String hotelSet = Configuration.hotelList.get(GlobalPropertyCode);
							if(hotelSet.equals("Central")) {
								RateCode = GetReservationData.RateCode;
								CHECKINDATE = reservationData.ArrivalDate;
								CHECKOUTDATE = reservationData.DepartureDate;
								BOOKINGDATE = GetReservationData.BOOKINGDATE;
							}
							
							
							
						}else {
							JSONArray response_jsonarr_ = response_json_obj.getJSONArray("items");
							JSONObject item_obj_ = response_jsonarr_.getJSONObject(0);
							RateCode = item_obj_.get("RateCode_c");
							CHECKINDATE = item_obj_.get("ANREISE_CHECKINDATE_c");
							CHECKOUTDATE = item_obj_.get("ABREISE_CHECKOUTDATE_c");
							BOOKINGDATE = item_obj_.get("AM_BOOKINGDATE_c");
						}
						
						
						//found the bug.
						
						/*
						
		                JSONArray response_jsonarr_ = response_json_obj.getJSONArray("items");
		                JSONObject item_obj_ = response_jsonarr_.getJSONObject(0);
	                    Object RateCode = item_obj_.get("RateCode_c");
	                    Object CHECKINDATE = item_obj_.get("ANREISE_CHECKINDATE_c");                    
	                    Object CHECKOUTDATE = item_obj_.get("ABREISE_CHECKOUTDATE_c");
	                    Object BOOKINGDATE = item_obj_.get("AM_BOOKINGDATE_c");
	                    
	                    */
						/*
						 * String s=GetHotelsData.getHotel(GlobalPropertyCode);
						 * 
						 * String GlobalOrionCode = HashMapData.mapOrionCode.get(GlobalPropertyCode);
						 */
	                    
	                    System.out.println("RateCode_: "+RateCode);
	                    System.out.println("RateCode_: "+RateCode+" : "+CHECKINDATE+" : "+CHECKOUTDATE+" : "+BOOKINGDATE+" : "+GlobalOrionCode);
	                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu-MM-ddHH:mm:ss");
						  LocalDateTime now = LocalDateTime.now();
						  String t=dtf.format(now);
						    System.out.println(t);
						  String date_ = t.substring(0, 10) 
						                           + "T" 
						                           + t.substring(10,t.length()-3)+"+05:30"; 
						

						//Get reservation details - End
						//avail privilage code
						OkHttpClient client = new OkHttpClient();
						MediaType mediaType = MediaType.parse("application/json");
						RequestBody body=null;
												
						String InvoiceNo=request.getParameter("InvoiceNo");
						InvoiceNo=InvoiceNo.substring(2,3);
						String InputPin=request.getParameter("CardPin");
						String req="";
				//		req="{\r\n    \"h_bit_date\": \"2021-08-27T17:15+05:30\",\r\n    \"h_bit_category\": \"AVAILMENT\",\r\n    \"MemberType\": \""+Memtype+"\",\r\n    \"sponsor_code\": \""+Memtype+"\",\r\n    \"h_privileges_with_pin\": [\r\n        {\r\n            \"h_privilege\": \""+VoucherNumber+"\",\r\n            \"pin\": \""+InputPin+"\"\r\n        }\r\n    ]\r\n}";
						req="{\r\n    \"h_bit_date\": \""+date_+"\",\r\n    \"hotel_pms_code\": \""+GlobalPropertyCode+"\",\r\n    \"folio_number\": \""+InvoiceNo+"\",\r\n    \"h_bit_amount\": \""+Amount+"\",\r\n    \"rate_code\": \""+RateCode+"\",\r\n    \"h_start_date\": \""+CHECKINDATE+"\",\r\n    \"h_end_date\": \""+CHECKOUTDATE+"\",\r\n    \"h_date_of_booking\": \""+BOOKINGDATE+"\",\r\n    \"h_bit_source_generated_id\": \""+processInvoicesData.ConfirmationNo+"\",\r\n    \"h_bit_source\": \"PMS\",\r\n    \"h_bit_category\": \"AVAILMENT\",\r\n    \"MemberType\": \""+Memtype+"\",\r\n    \"bill_number\":\""+processInvoicesData.ConfirmationNo+"\",\r\n    \"h_privileges_with_pin\": [\r\n        {\r\n            \"h_privilege\": \""+VoucherNumber+"\",\r\n            \"pin\": \""+InputPin+"\"\r\n        }\r\n    ]\r\n}";
						 body = RequestBody.create(mediaType, req);
						 Request AvailRequest = new Request.Builder()
								  .url(Configuration.AVAIL_PRIVILEGE)
								  .method("POST", body)
								  .addHeader("Authorization", "Basic T2ljX3VzZXI6SW5ub3ZhY3hAMzIx")
								  .addHeader("Content-Type", "application/json")
								  .build();
								Response AvailResponse = client.newCall(AvailRequest).execute();
								String resp = AvailResponse.body().string().toString();
								
								System.out.println("AvailRequest: "+req.toString());
								System.out.println("AvailResponse: "+resp);
								
								JSONObject jsonObject = new JSONObject(resp);
								
								//JSONObject object = jsonObject.getJSONObject("status");
								
								try {
									status = jsonObject.getString("status");									
									System.out.println("status: "+status);
									ApprovalCode = jsonObject.getString("bit_id");									
								} catch (Exception e) {
									//errorDetails = jsonObject.getString("o:errorDetails");	
									try {

										JSONArray response_jsonarr = jsonObject.getJSONArray("o:errorDetails");
										JSONObject item_obj = response_jsonarr.getJSONObject(0);
										title_obj = item_obj.get("title");
										title_=title_obj.toString();
										item_id = item_obj.get("o:errorDetails");
										Error=item_id.toString();
										//title =errorDetails.substring("title");	
										int Start= Error.indexOf("message");
										Error=Error.substring(Start);
										System.out.println(Error);
										int End= Error.indexOf("\",");
										Error= Error.substring(10,End);
										System.out.println("=================================");
										System.out.println(Error);
				
											
									} catch (Exception e2) {
										// TODO: handle exception
									}
									
									detail = jsonObject.get("detail").toString();								
								}
								
								
								System.out.println(status);
								//status = "SUCCESS";
								//status="SUCCESS";
								//if(status.equals("SUCCESS")) {
						/*		if(1==1) {
									String ApprovalCode = "test transaction number";	
									writeToPMS(request, response, ApprovalCode, processInvoicesData.GiftCardNumber, processInvoicesData.URLReservationNumber, GlobalPropertyCode);
									this.object.put("status", "SUCCESS");
									this.object.put("msg", "Successfull Availed");
									this.object.put("url", "NewInvoices.jsp?ReservId="+GlobalReservationNumber+"&PayStatus=success&Property="+GlobalPropertyCode+"");
									//Success url		
									servletResponse.getWriter().write("NewInvoices.jsp?ReservId="+processInvoicesData.URLReservationNumber+"&PayStatus=success&Property="+GlobalPropertyCode+"");
								//	servletResponse.getWriter().write("NewInvoices.jsp?ReservId="+GlobalReservationNumber+"&PayStatus=success&Property="+GlobalPropertyCode+"");
									//response.getWriter().write(this.object.toString());
									//String ApprovalCode = jsonObject.getString("ApprovalCode");
									servletResponse.getWriter().write(this.object.toString());
									return;
								}
*/
								
					
					}/* else if(!(availableBal==0.0) && privilegeType.equals("Fixed-Product") )  {
						this.object.put("msg", "please try amount less than: "+availableBal);
						this.object.put("status","Availment Failed");
						}
					else if(availableBal== 0.0 && Error.equals("")) {
						this.object.put("msg","Voucher is not usable, Please try another voucher");
					this.object.put("status","Availment Failed");
					}
					else if(availableBal== 0.0 && Error.equals("Invalid unique privilege code")) {
						this.object.put("status","Availment Failed");
						this.object.put("msg","Invalid unique privilege code");
					}
							
					else
						//response.getWriter().write("Failed try again");
					
						servletResponse.getWriter().write(this.object.toString());		
					
					*/
			//		String resp = res.body().string();
					
					
					
					
					try
					{/*
						if(resp.contains("<html>") || resp.contains("Service Unavailable") || resp.contains("HTTP Error 503") || resp.contains("HTTP Error") || resp.contains("502 Bad Gateway"))
						{						
							giftCardData.errorMsg = "Please try again later";
							HashMapData.mapGiftCard.put(processInvoicesData.URLReservationNumber, giftCardData);
							
							try{
								BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + request.getParameter("GlobalReservationNumber")+".txt",true));
								writer.write("\n\nGiftCard Server Not Reachable At:\t " + new Date() + "\n\n");
								writer.close();
							} catch(Exception e1)
							{
								e1.printStackTrace();
							}
							
							//code for retry with Idempotency - when server gets shut down
							Thread.sleep(5000);
							
							//after 2 attempts also, if didn't response, do not make more calls, and return to home page
							if(i == 2)
							{
								servletResponse.getWriter().write("NewInvoices.jsp?ReservId="+processInvoicesData.URLReservationNumber+"&PayStatus=failedGC&Property="+GlobalPropertyCode+"");
								return;
							}
							
							continue;
							
							
						}
						
					}*/
					
					
						GiftCardData giftCardData = new GiftCardData();
					giftCardData = new GiftCardData();
//	giftCardData.errorMsg = msg;
//	HashMapData.mapGiftCard.put(processInvoicesData.URLReservationNumber, giftCardData);
					
//	System.out.println(status);
					  System.out.println("request :"+request.getParameterNames());
                    
			//		status="SUCCESS";
					if(status.equalsIgnoreCase("SUCCESS")) // availment successful
					{
					//	String ApprovalCode = jsonObject.getString("ApprovalCode");
						
						writeToPMS(request, response, ApprovalCode, processInvoicesData.GiftCardNumber, processInvoicesData.URLReservationNumber, GlobalPropertyCode,"_GiftCard_"+processInvoicesData.GiftCardNumber );
						if(status_.equals("WriteToPmsFailed")) {
							this.object.put("status","WriteToPmsFailed");
							this.object.put("msg", "Voucher availed sucessfully, posting to PMS failed.");
						}
						else {
							this.object.put("status", "SUCCESS");
							this.object.put("msg", "Successfull Availed");
							this.object.put("url", "NewInvoices.jsp?ReservId="+GlobalReservationNumber+"&PayStatus=success&Property="+GlobalPropertyCode+"");						
								
						}						
					}
					else if (status_.equals("USED") && privilegeType.equals("Fixed-Product")) {
						this.object.put("msg", "Voucher Already Used");
						this.object.put("status","Availment Failed");
					}
					else if(detail.equals("Card not found, Please check the card and try again.")) {
						this.object.put("status","Availment Failed");
						this.object.put("msg", detail);
						
					}					
					else if(detail.equals("No such program exists, Please check the MemberType / Member_Id and try again")) {
						this.object.put("status","Availment Failed");
						this.object.put("msg", detail);
						
					}
					else if(Amount > availableBal  && privilegeType.equals("Fixed-Product") && availableBal != 0.0 && status_.equals("AVAILABLE"))  {
						this.object.put("msg", "please try amount less than or equal to: "+availableBal);
						this.object.put("status","Availment Failed");
						}
					else if(availableBal== 0.0 && Error.equals("")) {
						this.object.put("msg","Voucher is not usable, Please try another voucher");
					this.object.put("status","Availment Failed");
					}
					else if (Error.equals("Privilege cannot be used")) {
						this.object.put("msg","Privilege cannot be used");
						this.object.put("status","Availment Failed");
					}
					else if (Error.equals("Invalid unique privilege code")) {
						this.object.put("msg","Invalid unique privilege code");
						this.object.put("status","Availment Failed");
					}
					else if(title_.equals("Invalid pin for privilege")) {
						this.object.put("status","Availment Failed");
						this.object.put("msg", "Voucher PIN is Invalid");
					
					}
					else
					{
						this.object.put("msg","Voucher Availment Failed");
						this.object.put("status","Availment Failed");
					}
					servletResponse.getWriter().write(this.object.toString());
					
				}catch(Exception e)
				{
					e.printStackTrace();
					try {
						servletResponse.getWriter().write("NewInvoices.jsp?ReservId="+processInvoicesData.URLReservationNumber+"&PayStatus=failedBatch&Property="+GlobalPropertyCode+"");
						return;
					}catch(Exception ae)
					{
						ae.printStackTrace();
					}
				}						
			
			}
				catch (Exception e) {
					// TODO: handle exception
				}
		}
				
				//Gravty GC-PIN BLock End
		
		else
		{
			try {
				servletResponse.getWriter().write("NewInvoices.jsp?ReservId="+processInvoicesData.URLReservationNumber+"&PayStatus=failedBatch&Property="+GlobalPropertyCode+"");
				return;
			}catch(Exception e)
			{
				e.printStackTrace();
			}
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

}
