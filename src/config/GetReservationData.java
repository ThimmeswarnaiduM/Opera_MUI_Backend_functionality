package config;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import attributes.AesCryptUtil;
import attributes.InvokeRestFullWebservices;
import data.NewInvoicesData;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.util.regex.*;

public class GetReservationData implements Runnable {

    public static String ReservationID = "";

    public String ErrorFlag503 = "";
    public String flag="P";
    public static Map<String, String> personalDetails = new HashMap<>();
    public static List<Map<String, String>> membershipList = new ArrayList<>();
    public String Status = "";
    public String resStatus = "";
    public String CheckInDate = "";
    public String CheckOutDate = "";
    public String HotelName = "";
    public String HotelCode = "";
    public String RoomNo = "";
    public String PropertyFullName = "";

    public String ArrivalDate = "";
    public String DepartureDate = "";
    public String OWSProperty = "";
    public String ReservationStatus="";

    public Date CInDate = null;
    public Date COutDate = null;
    public Date bookingDate = null;

    public String ConfirmationNo = "";

    public String PMSNameCode = "";

    public String ResvInvoiceStatus = "";
    public String ResvInvoiceTinyUrl = "";
    public String ResvInvoiceId = "";
    public String ResvInvoiceStatusMsg = "";
    public String ResvInvoicePaymentStatus = "";
    public String ResvInvoicePaymentStatusLabel = "Action";
    public String ReservationMDM = "";
    public String resp;
    private static String AUTH_TOKEN = "";

    public static String Reservation_LoyaltyNumber = "";
    public static String Reservation_LoyaltyType= "";
    public static String Reservation_status= "";
    public static String RESVID= "";
    public static String Token="Q1hVTklUWVNJLWloY2xjZHB0ZXN0X0FQUElEOmlkY3Njcy0zNGI3ODE5My03NzM5LTQ3YTUtYTA4Yy1hZDBlYzY5YjVkNTA='";


    public static String RateCode= "";
    public static String BOOKINGDATE = "";

    public static String membershipID ="";
    public static String Address1 = "";
    public static String City ="";
    public static String countryCode = "";
    public static String postalCode = "";
    public static String state ="";
    private HttpServletResponse responses;

    ///
    public GetReservationData() {}

    public GetReservationData(String reservationID, String OWSProperty, String flag) {
        super();
        ReservationID = reservationID;
        this.OWSProperty = OWSProperty;
        this.flag = flag;
//		 Configuration.updateFlag(flag);
//		 Configuration.loadConfiguration();
        System.out.println("DEBUG Constructor: ReservationID = " + reservationID);
        System.out.println("DEBUG Constructor: OWSProperty = " + OWSProperty);
        System.out.println("DEBUG Constructor: flag parameter = " + flag);
        System.out.println("DEBUG Constructor: this.flag field = " + this.flag);

    }








    @Override
    public void run() {


        System.out.println("----------------------------GetReservationData Started-----------------------------");
        System.out.println("Current working directory: " + System.getProperty("user.dir"));


        String WSDL = URLConfig.getFutureBookingSummaryWSDL(OWSProperty);
        System.out.println("WSDL : "+WSDL);
        WSDL = WSDL+ReservationID;
        Response response = null;
        resp = null;
       
        try {

            response = Configuration.getReservationData(WSDL,OWSProperty);
            resp = response.body().string();
            System.out.println("Future Booking Response:\n" + resp);
//***************   Request and Response Logs ********************//
        } catch (IOException e) {
            e.printStackTrace();
        }

        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + ReservationID+".txt",true));
            writer.write("\nFuture Booking Response: \n" + resp + "\n\n");
            writer.write((new Date()).toString());
            writer.close();

        } catch(Exception e)
        {
            e.printStackTrace();
        }

//************** API failure Case  ******************************//
        String codeandmessage = response.toString();
        Map<String, String> result = Configuration.getCodeAndMessage(codeandmessage);
        JSONObject reservationJson = null;
        try {
            reservationJson = new JSONObject(resp);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        
        if(result.get("code").equalsIgnoreCase("200") && result.get("message").equalsIgnoreCase("OK") ) {
            System.out.println("SuccessK");
            try {

                Status=reservationJson.getJSONObject("reservationFolioInformation").getJSONObject("reservationInfo").getString("reservationStatus");
                if(Status.equalsIgnoreCase("InHouse")) 
                {
                	Reservation_status = "CHECKED IN";
                	
                } else if(Status.equals("CHANGED") || Status.equals("Reserved")) {
                    Reservation_status="Not Guarantee";
                }else if(Status.equalsIgnoreCase("CheckedOut")) {
                    Reservation_status="CHECKED OUT";

                }
                
                
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("Reservation Status : "+Status);

            try {
                RateCode=reservationJson.getJSONObject("reservationFolioInformation").getJSONObject("reservationInfo").getJSONObject("roomStay").getString("ratePlanCode");
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("Rate Code : "+RateCode);
            // Rate code
            // Reservation Status Checked-out or Checked-in
            try {
                if(false) { //checking IDS property
//**************************** Handle IDS Property ************************//
                }else {
                    JSONArray resIdsList=reservationJson.getJSONObject("reservationFolioInformation").getJSONObject("reservationInfo").getJSONArray("reservationIdList");
                    for(int i=0;i<resIdsList.length();i++) {
                        if(resIdsList.getJSONObject(i).getString("type").equals("Confirmation")){
                            ConfirmationNo = resIdsList.getJSONObject(i).getString("id");
                            System.out.println("Reservation Confirmation Number  : "+ConfirmationNo);
                            break;
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();}
//		  	  } catch (Exception e) {
//				e.printStackTrace();
//				this.ResvInvoiceStatus = "NOT ENABLED";
//			  }
            System.out.println(ConfirmationNo);
            try {
                try {
                    membershipID = reservationJson.getJSONObject("reservationFolioInformation").getJSONObject("reservationInfo").getJSONObject("reservationGuest").getJSONObject("membership").getString("membershipId");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                //JSONObject jsonObject = getReservationDataMDM(ConfirmationNo, this.OWSProperty,reservationJson,responses );
                // JSONObject jsonObject= getReservationDataCDP(ConfirmationNo, this.OWSProperty,reservationJson);
                //System.out.println("CDP UPDATE----" +jsonObject);

//				if(CCAvenuePropertyList.getCCMUI(this.OWSProperty))
//				{
//					String status = null;
//					try {
//						status = jsonObject.getString("STATUS");
//						System.out.println("status : "+status);
//					} catch (JSONException e) {
//						e.printStackTrace();
//					}
//					if(status.equals("SUCCESS"))
//					{
//						this.ResvInvoiceStatus = "SUCCESS";
//						try {
//							this.ResvInvoiceId = jsonObject.getString("InvoiceId");
//						} catch (JSONException e) {
//							e.printStackTrace();
//						}
//						try {
//							this.ResvInvoiceTinyUrl = jsonObject.getString("TinyURL");
//						} catch (JSONException e) {
//							e.printStackTrace();
//						}
//						this.ResvInvoiceStatusMsg = "Sent";
//						try {
//							this.ResvInvoicePaymentStatus = getInvoiceStatus(ResvInvoiceId);
//						} catch (Exception e) {
//							e.printStackTrace();
//						}
//
//					} else if(status.equals("ERROR"))
//					{
//						String msg=null;
//						try {
//							msg = jsonObject.getString("MSG");
//						} catch (JSONException e) {
//							e.printStackTrace();
//						}
//						if(msg.equals("Invoice not created"))
//						{
//							this.ResvInvoiceStatus = "FAILED";
//							this.ResvInvoiceStatusMsg = "Not sent";
//						}
//					}
//				} else
//				{
//					this.ResvInvoiceStatus = "NOT ENABLED";
//
//				}
            } catch (Exception e) {
                e.printStackTrace();
               
            }


            try {
                RoomNo = reservationJson.getJSONObject("reservationFolioInformation").getJSONObject("reservationInfo").getJSONObject("roomStay").getString("roomId");
                System.out.println("Room Number: "+RoomNo);
                Address1 = reservationJson.getJSONObject("reservationFolioInformation").getJSONObject("reservationInfo").getJSONObject("reservationGuest").getJSONObject("address").getString("streetAddress");
                System.out.println("Address: "+Address1);
                City = reservationJson.getJSONObject("reservationFolioInformation").getJSONObject("reservationInfo").getJSONObject("reservationGuest").getJSONObject("address").getString("cityName");
                System.out.println("City: "+City);
                countryCode = reservationJson.getJSONObject("reservationFolioInformation").getJSONObject("reservationInfo").getJSONObject("reservationGuest").getJSONObject("address").getJSONObject("country").getString("code");
                System.out.println("Country Code: "+countryCode);
                postalCode = reservationJson.getJSONObject("reservationFolioInformation").getJSONObject("reservationInfo").getJSONObject("reservationGuest").getJSONObject("address").getString("postalCode");
                System.out.println("Postal Code: "+postalCode);
                state = null;
                System.out.println("state: "+state);
                CheckInDate = reservationJson.getJSONObject("reservationFolioInformation").getJSONObject("reservationInfo").getJSONObject("roomStay").getString("arrivalDate");
                CheckOutDate =reservationJson.getJSONObject("reservationFolioInformation").getJSONObject("reservationInfo").getJSONObject("roomStay").getString("departureDate");
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date d1 = format.parse(CheckInDate.substring(0, 10));
                Date d2 = format.parse(CheckOutDate.substring(0, 10));
                CInDate = d1;
                COutDate = d2;
                ArrivalDate = dateFormat.format(d1);
                DepartureDate = dateFormat.format(d2);
                System.out.println(ArrivalDate + "\n" + DepartureDate);
                HotelName = reservationJson.getJSONObject("reservationFolioInformation").getJSONObject("reservationInfo").getString("hotelName");
                System.out.println("Hotel Name: "+HotelName);
                PMSNameCode = reservationJson.getJSONObject("reservationFolioInformation").getJSONObject("reservationInfo").getJSONObject("reservationGuest").getString("id");
                System.out.println("PMS Name Code"+ PMSNameCode);
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }

            try {
                RoomNo = reservationJson.getJSONObject("reservationFolioInformation").getJSONObject("reservationInfo").getJSONObject("roomStay").getString("roomId");
                System.out.println("Room Number: " + RoomNo);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            try {
                Address1 = reservationJson.getJSONObject("reservationFolioInformation").getJSONObject("reservationInfo").getJSONObject("reservationGuest").getJSONObject("address").getString("streetAddress");
                System.out.println("Address: " + Address1);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            try {
                City = reservationJson.getJSONObject("reservationFolioInformation").getJSONObject("reservationInfo").getJSONObject("reservationGuest").getJSONObject("address").getString("cityName");
                System.out.println("City: " + City);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            try {
                countryCode = reservationJson.getJSONObject("reservationFolioInformation").getJSONObject("reservationInfo").getJSONObject("reservationGuest").getJSONObject("address").getJSONObject("country").getString("code");
                System.out.println("Country Code: " + countryCode);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            try {
                postalCode = reservationJson.getJSONObject("reservationFolioInformation").getJSONObject("reservationInfo").getJSONObject("reservationGuest").getJSONObject("address").getString("postalCode");
                System.out.println("Postal Code: " + postalCode);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            try {
                state = reservationJson.getJSONObject("reservationFolioInformation").getJSONObject("reservationInfo").getJSONObject("reservationGuest").getJSONObject("address").getString("state");
            } catch (JSONException e1) {
                e1.printStackTrace();
            }
            System.out.println("State: " + state);

            try {
                CheckInDate = reservationJson.getJSONObject("reservationFolioInformation").getJSONObject("reservationInfo").getJSONObject("roomStay").getString("arrivalDate");
                CheckOutDate = reservationJson.getJSONObject("reservationFolioInformation").getJSONObject("reservationInfo").getJSONObject("roomStay").getString("departureDate");
                String insertDate = reservationJson.getJSONObject("reservationFolioInformation").getJSONObject("reservationInfo").getString("createDateTime");// Booking Date
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date d1 = format.parse(CheckInDate.substring(0, 10));
                Date d2 = format.parse(CheckOutDate.substring(0, 10));
               
                Date d3 = format.parse(insertDate.substring(0, 10));
                bookingDate = d3;
                BOOKINGDATE = dateFormat.format(d3);
                System.out.println("BOOKINGDATE: "+BOOKINGDATE);

                CInDate = d1;
                COutDate = d2;
                ArrivalDate = dateFormat.format(d1);
                DepartureDate = dateFormat.format(d2);
                System.out.println(ArrivalDate + "\n" + DepartureDate);
            } catch (JSONException | ParseException e) {
                e.printStackTrace();
            }

            try {
                HotelName = reservationJson.getJSONObject("reservationFolioInformation").getJSONObject("reservationInfo").getString("hotelName");
                System.out.println("Hotel Name: " + HotelName);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            PropertyFullName = HotelName;
            try {
                PMSNameCode = reservationJson.getJSONObject("reservationFolioInformation").getJSONObject("reservationInfo").getJSONObject("reservationGuest").getString("id");
                System.out.println("PMS Name Code: " + PMSNameCode);
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }else {
            resStatus = "ERROR";
        }

        System.out.println("----------------------------GetReservationData Ended-----------------------------");
    }

    public static void main(String a[]) throws Exception
    {
        GetReservationData data = new GetReservationData();
        String jsonObject = data.getInvoiceStatus("161968914");
        System.out.println(jsonObject);

    }
    private String getInvoiceStatus(String invoiceId) throws Exception
    {
        try {

            InvokeRestFullWebservices restOb = new InvokeRestFullWebservices();
            String response = "";
            String workingKey = Configuration.CCAvenueWokringKey;
            String accessCode = Configuration.CCAvenueAccessCode;
            String command = "invoiceList";
            String request_type = "JSON";
            String response_type = "JSON";
            String version = "1.1";
            String fromDate = "01-01-2018";

            String jsonString = "{\r\n" +
                    "\"from_date\":\""+fromDate+"\",\r\n" +
                    "\"invoice_id\":\""+invoiceId+"\"\r\n" +
                    "}";

//			  GetReservationData.log.info("Json Req:\n" + jsonString);

            try {

                AesCryptUtil localAesCryptUtil = new AesCryptUtil(workingKey);
                response = localAesCryptUtil.encrypt(jsonString);

            } catch (Exception localException) {
                response = null;
            }

            if(response != null && !response.equals(""))
            {
                InvokeRestFullWebservices.getInstance("", "");
                String CCrequest = Configuration.CCAvenueUrl+"?"+"enc_request="+response+"&access_code="+accessCode
                        +"&command="+command+"&request_type="+request_type+"&response_type="+response_type+"&version="+version;
                Response logRes = restOb.doPostRequest(CCrequest, "",2);
                String logBody = logRes.body().string();
                String[] spliteResponse = logBody.split("=");

                if(spliteResponse.length == 3)
                {
                    AesCryptUtil localAesCryptUtil = new AesCryptUtil(workingKey);

                    String resAES = spliteResponse[2];
                    String decryptedResponse = localAesCryptUtil.decrypt(resAES.trim());
                    System.out.println(decryptedResponse);
                    JSONObject invoiceJSON = new JSONObject(decryptedResponse);
                    JSONObject invoiceObj = invoiceJSON.getJSONArray("invoice_List").getJSONObject(0);

                    String status = invoiceObj.getString("order_Status");	//Shipped

                    if(status.equalsIgnoreCase("Shipped"))
                    {
                        ResvInvoicePaymentStatusLabel = "Status";
                        return "Customer Paid";
                    } else
                    {
                        ResvInvoicePaymentStatusLabel = "Action";
                        return "Pending";
                    }

//					return invoiceJSON;

                }
            }

            return "Pending";

        }catch (Exception e) {
            e.printStackTrace();
        }

        return "Pending";

    }

    private JSONObject getReservationDataMDM(String confirmationNo, String propertyCode,JSONObject reservationJson,HttpServletResponse responses)
    {

        JSONObject jsonObjectReturn = new JSONObject();

        try {

            String actionURL = Configuration.RestGetReservationUrl;

            String urlFilters = "q=HotelCode_c="+propertyCode+";REGISTER_c="+confirmationNo+"&onlyData=true&fields=Id,RecordName,REGISTER_c,HotelCode_c,Hotel_dcl_c,Action_c,RoomNumber_c,TinyURL_c,InvoiceStatus_c,InvoiceId_c,LoyaltyType_c,LoyaltyNumber_c";

            String urlFilters_final=actionURL+urlFilters;
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url(urlFilters_final)
                    .get()
                    .addHeader("Authorization", Configuration.MDMBasicAuth)
                    .addHeader("Accept", "*/*")
                    .addHeader("Cache-Control", "no-cache")
                    //.addHeader("Accept-Encoding", "gzip, deflate")
                    .addHeader("Connection", "keep-alive")
                    .addHeader("cache-control", "no-cache")
                    .build();

            Response response = client.newCall(request).execute();

            String resp = response.body().string().toString();

            System.out.println(resp);

            JSONObject object = new JSONObject(resp);

            /*******************************************/

//			OkHttpClient client = new OkHttpClient();
//
//	        String url500 = "https://httpstat.us/500";  // This URL always returns 500
//
//	        Request request = new Request.Builder()
//	            .url(url500)
//	            .get()
//	            .addHeader("Accept", "*/*")
//	            .addHeader("Cache-Control", "no-cache")
//	            .addHeader("Connection", "keep-alive")
//	            .build();
//
//	            Response response = client.newCall(request).execute();
//	            System.out.println("Response Code: " + response.code());
//	            System.out.println("Response Message: " + response.message());
//	            String resp = response.body().string().toString();
//	            System.out.println(resp);
//	            JSONObject object = new JSONObject(resp);
//
            /*******************************************/

            int count = object.getInt("count");
            if(count == 1)
            {
                JSONArray array = object.getJSONArray("items");
                JSONObject jsonObject = array.getJSONObject(0);

                String invoiceStatus = readJson(jsonObject, "InvoiceStatus_c");
                Reservation_LoyaltyNumber = readJson(jsonObject, "LoyaltyNumber_c");
                Reservation_LoyaltyType = readJson(jsonObject, "LoyaltyType_c");

                Reservation_status = readJson(jsonObject, "Action_c");
                //status checkde in code
                if(Status.equals("InHouse")) {
                    Reservation_status="CHECKED IN";
                }else if(Status.equals("CHANGED") || Status.equals("Reserved")) {
                    Reservation_status="Not Guarantee";
                }else if(Status.equals("CheckedOut")) {
                    Reservation_status="CHECKED OUT";

                }

                if("CHECKED OUT".equalsIgnoreCase(Reservation_status)||"Not Guarantee".equalsIgnoreCase(Reservation_status)) {
                    responses.sendRedirect("checkout.jsp");
                    return null ;
                }
                if(invoiceStatus.equals("SUCCESS"))
                {
                    String tinyURL = readJson(jsonObject, "TinyURL_c");
                    String invoiceId = readJson(jsonObject, "InvoiceId_c");

                    jsonObjectReturn.put("STATUS", "SUCCESS");
                    jsonObjectReturn.put("TinyURL", tinyURL);
                    jsonObjectReturn.put("InvoiceId", invoiceId);

                } else
                {
                    jsonObjectReturn.put("STATUS", "ERROR");
                    jsonObjectReturn.put("MSG", "Invoice not created");
                    jsonObjectReturn.put("InvoiceStatus", invoiceStatus);
                }
            } else
            {
                Configuration configuration = new Configuration();
                //Reservation_Status = "";
                configuration.hotelList();
                String hotelSet = Configuration.hotelList.get(propertyCode);
                if(hotelSet.equals("Central") || hotelSet.equals("Oracle Cloud Central")) {
                    String insertDate = reservationJson.getJSONObject("reservationFolioInformation").getJSONObject("reservationInfo").getString("createDateTime");// Booking Date
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    Date d3 = format.parse(insertDate.substring(0, 10));
                    bookingDate = d3;
                    BOOKINGDATE = dateFormat.format(d3);
                    System.out.println("BOOKINGDATE: "+BOOKINGDATE);
                    Reservation_LoyaltyNumber = reservationJson.getJSONObject("reservationFolioInformation").getJSONObject("reservationInfo").getJSONObject("reservationGuest").getJSONObject("membership").getString("accountId");
                    Reservation_LoyaltyType = reservationJson.getJSONObject("reservationFolioInformation").getJSONObject("reservationInfo").getJSONObject("reservationGuest").getJSONObject("membership").getString("programCode");
                    jsonObjectReturn.put("STATUS", "ERROR");
                    jsonObjectReturn.put("MSG", "Invoice not created");
                    if(Status.equals("InHouse")) {
                        Reservation_status="CHECKED IN";
                    }else if(Status.equals("CHANGED") || Status.equals("Reserved")) {
                        Reservation_status="Not Guarantee";
                    }else if(Status.equals("CheckedOut")) {
                        Reservation_status="CHECKED OUT";
                    }

                }else {
                    jsonObjectReturn.put("STATUS", "ERROR");
                    jsonObjectReturn.put("MSG", "Reservation not found");
                    this.ReservationMDM= "NOT FOUND IN MDM";
                }
                if("CHECKED OUT".equalsIgnoreCase(Reservation_status)||"Not Guarantee".equalsIgnoreCase(Reservation_status)) {
                    responses.sendRedirect("checkout.jsp");
                    return null ;
                }
                //add else case hear


            }



        } catch (Exception e) {
            e.printStackTrace();
            try{
                BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + ReservationID+".txt",true));

                writer.write("\nExceptionOccured: \n" + e.getMessage() + "\n\n");
                writer.write((new Date()).toString());
                writer.close();

            } catch(Exception e1)
            {
                e1.printStackTrace();
            }
        }

        return jsonObjectReturn;
    }
    //\"data\": \"" + confirmationNo + "\"\r\n" +

    private static JSONObject getReservationDataCDP(String confirmationNo,String propertyCode,JSONObject reservationJson) throws IOException, JSONException, ParseException {
        JSONObject jsonObjectReturn = new JSONObject();
        String payload = "{\r\n" +
                "    \"MCPSQuery\": {\r\n" +
                "        \"name\": \"Reservation_linked_Records\",\r\n" +
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
                "                                            \"type\": \"LEFT\",\r\n" +
                "                                            \"targetSet\": {\r\n" +
                "                                                \"ctype\": \".ObjectSet\",\r\n" +
                "                                                \"name\": \"L0\",\r\n" +
                "                                                \"distinct\": true,\r\n" +
                "                                                \"objectName\": \"Loyalty_Memberships\",\r\n" +
                "                                                \"criteria\": {\r\n" +
                "                                                    \"ctype\": \".Criteria\",\r\n" +
                "                                                    \"operands\": [\r\n" +
                "                                                        {\r\n" +
                "                                                            \"ctype\": \".ReferenceAttribute\",\r\n" +
                "                                                            \"attributeName\": \"SourceLoyalty_MembershipsID\",\r\n" +
                "                                                            \"tableName\": \"L0\",\r\n" +
                "                                                            \"alias\": \"SourceLoyalty_MembershipsID\"\r\n" +
                "                                                        }\r\n" +
                "                                                    ],\r\n" +
                "                                                    \"operator\": \"NOT_NULL\"\r\n" +
                "                                                },\r\n" +
                "                                                \"outputAttributes\": [\r\n" +
                "                                                    {\r\n" +
                "                                                        \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                        \"attributeName\": \"CustomerID\",\r\n" +
                "                                                        \"tableName\": \"L0\",\r\n" +
                "                                                        \"alias\": \"Loyalty_Memberships_CustomerID\"\r\n" +
                "                                                    },\r\n" +
                "                                                    {\r\n" +
                "                                                        \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                        \"attributeName\": \"SourceLoyalty_MembershipsID\",\r\n" +
                "                                                        \"tableName\": \"L0\",\r\n" +
                "                                                        \"alias\": \"Loyalty_Memberships_SourceLoyalty_MembershipsID\"\r\n" +
                "                                                    },\r\n" +
                "                                                    {\r\n" +
                "                                                        \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                        \"attributeName\": \"MembershipType\",\r\n" +
                "                                                        \"tableName\": \"L0\",\r\n" +
                "                                                        \"alias\": \"Loyalty_Memberships_MembershipType\"\r\n" +
                "                                                    },\r\n" +
                "                                                    {\r\n" +
                "                                                        \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                        \"attributeName\": \"MembershipCardNo\",\r\n" +
                "                                                        \"tableName\": \"L0\",\r\n" +
                "                                                        \"alias\": \"Loyalty_Memberships_MembershipCardNo\"\r\n" +
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
                "                                                        \"attributeName\": \"MemberSince\",\r\n" +
                "                                                        \"tableName\": \"L0\",\r\n" +
                "                                                        \"alias\": \"Loyalty_Memberships_MemberSince\"\r\n" +
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
                "                                                \"attributeName\": \"Loyalty_Memberships_SourceLoyalty_MembershipsID\",\r\n" +
                "                                                \"tableName\": \"L0\",\r\n" +
                "                                                \"alias\": \"Loyalty_Memberships_SourceLoyalty_MembershipsID\"\r\n" +
                "                                            },\r\n" +
                "                                            {\r\n" +
                "                                                \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                \"attributeName\": \"Loyalty_Memberships_MembershipType\",\r\n" +
                "                                                \"tableName\": \"L0\",\r\n" +
                "                                                \"alias\": \"Loyalty_Memberships_MembershipType\"\r\n" +
                "                                            },\r\n" +
                "                                            {\r\n" +
                "                                                \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                \"attributeName\": \"Loyalty_Memberships_MembershipCardNo\",\r\n" +
                "                                                \"tableName\": \"L0\",\r\n" +
                "                                                \"alias\": \"Loyalty_Memberships_MembershipCardNo\"\r\n" +
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
                "                                                \"attributeName\": \"Loyalty_Memberships_MemberSince\",\r\n" +
                "                                                \"tableName\": \"L0\",\r\n" +
                "                                                \"alias\": \"Loyalty_Memberships_MemberSince\"\r\n" +
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
                "                                        \"attributeName\": \"Loyalty_Memberships_SourceLoyalty_MembershipsID\",\r\n" +
                "                                        \"tableName\": \"C1\",\r\n" +
                "                                        \"alias\": \"Loyalty_Memberships_SourceLoyalty_MembershipsID\"\r\n" +
                "                                    },\r\n" +
                "                                    {\r\n" +
                "                                        \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                        \"attributeName\": \"Loyalty_Memberships_MembershipType\",\r\n" +
                "                                        \"tableName\": \"C1\",\r\n" +
                "                                        \"alias\": \"Loyalty_Memberships_MembershipType\"\r\n" +
                "                                    },\r\n" +
                "                                    {\r\n" +
                "                                        \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                        \"attributeName\": \"Loyalty_Memberships_MembershipCardNo\",\r\n" +
                "                                        \"tableName\": \"C1\",\r\n" +
                "                                        \"alias\": \"Loyalty_Memberships_MembershipCardNo\"\r\n" +
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
                "                                        \"attributeName\": \"Loyalty_Memberships_MemberSince\",\r\n" +
                "                                        \"tableName\": \"C1\",\r\n" +
                "                                        \"alias\": \"Loyalty_Memberships_MemberSince\"\r\n" +
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
                "                                \"attributeName\": \"Loyalty_Memberships_SourceLoyalty_MembershipsID\",\r\n" +
                "                                \"tableName\": \"C0\",\r\n" +
                "                                \"alias\": \"Loyalty_Memberships_SourceLoyalty_MembershipsID\"\r\n" +
                "                            },\r\n" +
                "                            {\r\n" +
                "                                \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                \"attributeName\": \"Loyalty_Memberships_MembershipType\",\r\n" +
                "                                \"tableName\": \"C0\",\r\n" +
                "                                \"alias\": \"Loyalty_Memberships_MembershipType\"\r\n" +
                "                            },\r\n" +
                "                            {\r\n" +
                "                                \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                \"attributeName\": \"Loyalty_Memberships_MembershipCardNo\",\r\n" +
                "                                \"tableName\": \"C0\",\r\n" +
                "                                \"alias\": \"Loyalty_Memberships_MembershipCardNo\"\r\n" +
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
                "                                \"attributeName\": \"Loyalty_Memberships_MemberSince\",\r\n" +
                "                                \"tableName\": \"C0\",\r\n" +
                "                                \"alias\": \"Loyalty_Memberships_MemberSince\"\r\n" +
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
                "                                \"attributeName\": \"Phone\",\r\n" +
                "                                \"tableName\": \"M0\",\r\n" +
                "                                \"alias\": \"MasterCustomer_Phone\"\r\n" +
                "                            },\r\n" +
                "                            {\r\n" +
                "                                \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                \"attributeName\": \"Prefix\",\r\n" +
                "                                \"tableName\": \"M0\",\r\n" +
                "                                \"alias\": \"MasterCustomer_Prefix\"\r\n" +
                "                            },\r\n" +
                "                            {\r\n" +
                "                                \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                \"attributeName\": \"AddressLine1\",\r\n" +
                "                                \"tableName\": \"M0\",\r\n" +
                "                                \"alias\": \"MasterCustomer_AddressLine1\"\r\n" +
                "                            },\r\n" +
                "                            {\r\n" +
                "                                \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                \"attributeName\": \"City\",\r\n" +
                "                                \"tableName\": \"M0\",\r\n" +
                "                                \"alias\": \"MasterCustomer_City\"\r\n" +
                "                            },\r\n" +
                "                            {\r\n" +
                "                                \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                \"attributeName\": \"State\",\r\n" +
                "                                \"tableName\": \"M0\",\r\n" +
                "                                \"alias\": \"MasterCustomer_State\"\r\n" +
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
                "                                                    \"type\": \"LEFT\",\r\n" +
                "                                                    \"targetSet\": {\r\n" +
                "                                                        \"ctype\": \".ObjectSet\",\r\n" +
                "                                                        \"name\": \"R0\",\r\n" +
                "                                                        \"distinct\": true,\r\n" +
                "                                                        \"objectName\": \"Reservation\",\r\n" +
                "                                                        \"criteria\": {\r\n" +
                "                                                            \"ctype\": \".Criteria\",\r\n" +
                "                                                            \"operands\": [\r\n" +
                "                                                                {\r\n" +
                "                                                                    \"ctype\": \".ReferenceAttribute\",\r\n" +
                "                                                                    \"attributeName\": \"HOTELCODEPMS\",\r\n" +
                "                                                                    \"tableName\": \"R0\",\r\n" +
                "                                                                    \"alias\": \"HOTELCODEPMS\"\r\n" +
                "                                                                },\r\n" +
                "                                                                {\r\n" +
                "                                                                    \"ctype\": \".StaticAttribute\",\r\n" +
                "                                                                    \"data\": \"GOITE\"\r\n" +
                "                                                                }\r\n" +
                "                                                            ],\r\n" +
                "                                                            \"operator\": \"IN\"\r\n" +
                "                                                        },\r\n" +
                "                                                        \"outputAttributes\": [\r\n" +
                "                                                            {\r\n" +
                "                                                                \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                                \"attributeName\": \"CustomerID\",\r\n" +
                "                                                                \"tableName\": \"R0\",\r\n" +
                "                                                                \"alias\": \"Reservation_CustomerID\"\r\n" +
                "                                                            },\r\n" +
                "                                                            {\r\n" +
                "                                                                \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                                \"attributeName\": \"ReservationNameId\",\r\n" +
                "                                                                \"tableName\": \"R0\",\r\n" +
                "                                                                \"alias\": \"Reservation_ReservationNameId\"\r\n" +
                "                                                            },\r\n" +
                "                                                            {\r\n" +
                "                                                                \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                                \"attributeName\": \"HOTELCODEPMS\",\r\n" +
                "                                                                \"tableName\": \"R0\",\r\n" +
                "                                                                \"alias\": \"Reservation_HOTELCODEPMS\"\r\n" +
                "                                                            },\r\n" +
                "                                                            {\r\n" +
                "                                                                \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                                \"attributeName\": \"ID\",\r\n" +
                "                                                                \"tableName\": \"R0\",\r\n" +
                "                                                                \"alias\": \"Reservation_ID\"\r\n" +
                "                                                            },\r\n" +
                "                                                            {\r\n" +
                "                                                                \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                                \"attributeName\": \"InvoiceId\",\r\n" +
                "                                                                \"tableName\": \"R0\",\r\n" +
                "                                                                \"alias\": \"Reservation_InvoiceId\"\r\n" +
                "                                                            },\r\n" +
                "                                                            {\r\n" +
                "                                                                \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                                \"attributeName\": \"InvoiceStatus\",\r\n" +
                "                                                                \"tableName\": \"R0\",\r\n" +
                "                                                                \"alias\": \"Reservation_InvoiceStatus\"\r\n" +
                "                                                            },\r\n" +
                "                                                            {\r\n" +
                "                                                                \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                                \"attributeName\": \"LoyaltyNumber\",\r\n" +
                "                                                                \"tableName\": \"R0\",\r\n" +
                "                                                                \"alias\": \"Reservation_LoyaltyNumber\"\r\n" +
                "                                                            },\r\n" +
                "                                                            {\r\n" +
                "                                                                \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                                \"attributeName\": \"LoyaltyType\",\r\n" +
                "                                                                \"tableName\": \"R0\",\r\n" +
                "                                                                \"alias\": \"Reservation_LoyaltyType\"\r\n" +
                "                                                            },\r\n" +
                "                                                            {\r\n" +
                "                                                                \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                                \"attributeName\": \"Status\",\r\n" +
                "                                                                \"tableName\": \"R0\",\r\n" +
                "                                                                \"alias\": \"Reservation_Status\"\r\n" +
                "                                                            },\r\n" +
                "                                                            {\r\n" +
                "                                                                \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                                \"attributeName\": \"CheckedInDate\",\r\n" +
                "                                                                \"tableName\": \"R0\",\r\n" +
                "                                                                \"alias\": \"Reservation_CheckedInDate\"\r\n" +
                "                                                            },\r\n" +
                "                                                            {\r\n" +
                "                                                                \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                                \"attributeName\": \"CheckedOutDate\",\r\n" +
                "                                                                \"tableName\": \"R0\",\r\n" +
                "                                                                \"alias\": \"Reservation_CheckedOutDate\"\r\n" +
                "                                                            },\r\n" +
                "                                                            {\r\n" +
                "                                                                \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                                \"attributeName\": \"Register\",\r\n" +
                "                                                                \"tableName\": \"R0\",\r\n" +
                "                                                                \"alias\": \"Reservation_Register\"\r\n" +
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
                "                                                                \"attributeName\": \"Reservation_CustomerID\",\r\n" +
                "                                                                \"tableName\": \"R0\",\r\n" +
                "                                                                \"alias\": \"Reservation_CustomerID\"\r\n" +
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
                "                                                        \"attributeName\": \"Reservation_ReservationNameId\",\r\n" +
                "                                                        \"tableName\": \"R0\",\r\n" +
                "                                                        \"alias\": \"Reservation_ReservationNameId\"\r\n" +
                "                                                    },\r\n" +
                "                                                    {\r\n" +
                "                                                        \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                        \"attributeName\": \"Reservation_HOTELCODEPMS\",\r\n" +
                "                                                        \"tableName\": \"R0\",\r\n" +
                "                                                        \"alias\": \"Reservation_HOTELCODEPMS\"\r\n" +
                "                                                    },\r\n" +
                "                                                    {\r\n" +
                "                                                        \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                        \"attributeName\": \"Reservation_ID\",\r\n" +
                "                                                        \"tableName\": \"R0\",\r\n" +
                "                                                        \"alias\": \"Reservation_ID\"\r\n" +
                "                                                    },\r\n" +
                "                                                    {\r\n" +
                "                                                        \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                        \"attributeName\": \"Reservation_InvoiceId\",\r\n" +
                "                                                        \"tableName\": \"R0\",\r\n" +
                "                                                        \"alias\": \"Reservation_InvoiceId\"\r\n" +
                "                                                    },\r\n" +
                "                                                    {\r\n" +
                "                                                        \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                        \"attributeName\": \"Reservation_InvoiceStatus\",\r\n" +
                "                                                        \"tableName\": \"R0\",\r\n" +
                "                                                        \"alias\": \"Reservation_InvoiceStatus\"\r\n" +
                "                                                    },\r\n" +
                "                                                    {\r\n" +
                "                                                        \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                        \"attributeName\": \"Reservation_LoyaltyNumber\",\r\n" +
                "                                                        \"tableName\": \"R0\",\r\n" +
                "                                                        \"alias\": \"Reservation_LoyaltyNumber\"\r\n" +
                "                                                    },\r\n" +
                "                                                    {\r\n" +
                "                                                        \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                        \"attributeName\": \"Reservation_LoyaltyType\",\r\n" +
                "                                                        \"tableName\": \"R0\",\r\n" +
                "                                                        \"alias\": \"Reservation_LoyaltyType\"\r\n" +
                "                                                    },\r\n" +
                "                                                    {\r\n" +
                "                                                        \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                        \"attributeName\": \"Reservation_Status\",\r\n" +
                "                                                        \"tableName\": \"R0\",\r\n" +
                "                                                        \"alias\": \"Reservation_Status\"\r\n" +
                "                                                    },\r\n" +
                "                                                    {\r\n" +
                "                                                        \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                        \"attributeName\": \"Reservation_CheckedInDate\",\r\n" +
                "                                                        \"tableName\": \"R0\",\r\n" +
                "                                                        \"alias\": \"Reservation_CheckedInDate\"\r\n" +
                "                                                    },\r\n" +
                "                                                    {\r\n" +
                "                                                        \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                        \"attributeName\": \"Reservation_CheckedOutDate\",\r\n" +
                "                                                        \"tableName\": \"R0\",\r\n" +
                "                                                        \"alias\": \"Reservation_CheckedOutDate\"\r\n" +
                "                                                    },\r\n" +
                "                                                    {\r\n" +
                "                                                        \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                        \"attributeName\": \"Reservation_Register\",\r\n" +
                "                                                        \"tableName\": \"R0\",\r\n" +
                "                                                        \"alias\": \"Reservation_Register\"\r\n" +
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
                "                                                \"attributeName\": \"Reservation_ReservationNameId\",\r\n" +
                "                                                \"tableName\": \"C3\",\r\n" +
                "                                                \"alias\": \"Reservation_ReservationNameId\"\r\n" +
                "                                            },\r\n" +
                "                                            {\r\n" +
                "                                                \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                \"attributeName\": \"Reservation_HOTELCODEPMS\",\r\n" +
                "                                                \"tableName\": \"C3\",\r\n" +
                "                                                \"alias\": \"Reservation_HOTELCODEPMS\"\r\n" +
                "                                            },\r\n" +
                "                                            {\r\n" +
                "                                                \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                \"attributeName\": \"Reservation_ID\",\r\n" +
                "                                                \"tableName\": \"C3\",\r\n" +
                "                                                \"alias\": \"Reservation_ID\"\r\n" +
                "                                            },\r\n" +
                "                                            {\r\n" +
                "                                                \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                \"attributeName\": \"Reservation_InvoiceId\",\r\n" +
                "                                                \"tableName\": \"C3\",\r\n" +
                "                                                \"alias\": \"Reservation_InvoiceId\"\r\n" +
                "                                            },\r\n" +
                "                                            {\r\n" +
                "                                                \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                \"attributeName\": \"Reservation_InvoiceStatus\",\r\n" +
                "                                                \"tableName\": \"C3\",\r\n" +
                "                                                \"alias\": \"Reservation_InvoiceStatus\"\r\n" +
                "                                            },\r\n" +
                "                                            {\r\n" +
                "                                                \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                \"attributeName\": \"Reservation_LoyaltyNumber\",\r\n" +
                "                                                \"tableName\": \"C3\",\r\n" +
                "                                                \"alias\": \"Reservation_LoyaltyNumber\"\r\n" +
                "                                            },\r\n" +
                "                                            {\r\n" +
                "                                                \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                \"attributeName\": \"Reservation_LoyaltyType\",\r\n" +
                "                                                \"tableName\": \"C3\",\r\n" +
                "                                                \"alias\": \"Reservation_LoyaltyType\"\r\n" +
                "                                            },\r\n" +
                "                                            {\r\n" +
                "                                                \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                \"attributeName\": \"Reservation_Status\",\r\n" +
                "                                                \"tableName\": \"C3\",\r\n" +
                "                                                \"alias\": \"Reservation_Status\"\r\n" +
                "                                            },\r\n" +
                "                                            {\r\n" +
                "                                                \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                \"attributeName\": \"Reservation_CheckedInDate\",\r\n" +
                "                                                \"tableName\": \"C3\",\r\n" +
                "                                                \"alias\": \"Reservation_CheckedInDate\"\r\n" +
                "                                            },\r\n" +
                "                                            {\r\n" +
                "                                                \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                \"attributeName\": \"Reservation_CheckedOutDate\",\r\n" +
                "                                                \"tableName\": \"C3\",\r\n" +
                "                                                \"alias\": \"Reservation_CheckedOutDate\"\r\n" +
                "                                            },\r\n" +
                "                                            {\r\n" +
                "                                                \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                \"attributeName\": \"Reservation_Register\",\r\n" +
                "                                                \"tableName\": \"C3\",\r\n" +
                "                                                \"alias\": \"Reservation_Register\"\r\n" +
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
                "                                        \"attributeName\": \"Reservation_ReservationNameId\",\r\n" +
                "                                        \"tableName\": \"C2\",\r\n" +
                "                                        \"alias\": \"Reservation_ReservationNameId\"\r\n" +
                "                                    },\r\n" +
                "                                    {\r\n" +
                "                                        \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                        \"attributeName\": \"Reservation_HOTELCODEPMS\",\r\n" +
                "                                        \"tableName\": \"C2\",\r\n" +
                "                                        \"alias\": \"Reservation_HOTELCODEPMS\"\r\n" +
                "                                    },\r\n" +
                "                                    {\r\n" +
                "                                        \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                        \"attributeName\": \"Reservation_ID\",\r\n" +
                "                                        \"tableName\": \"C2\",\r\n" +
                "                                        \"alias\": \"Reservation_ID\"\r\n" +
                "                                    },\r\n" +
                "                                    {\r\n" +
                "                                        \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                        \"attributeName\": \"Reservation_InvoiceId\",\r\n" +
                "                                        \"tableName\": \"C2\",\r\n" +
                "                                        \"alias\": \"Reservation_InvoiceId\"\r\n" +
                "                                    },\r\n" +
                "                                    {\r\n" +
                "                                        \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                        \"attributeName\": \"Reservation_InvoiceStatus\",\r\n" +
                "                                        \"tableName\": \"C2\",\r\n" +
                "                                        \"alias\": \"Reservation_InvoiceStatus\"\r\n" +
                "                                    },\r\n" +
                "                                    {\r\n" +
                "                                        \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                        \"attributeName\": \"Reservation_LoyaltyNumber\",\r\n" +
                "                                        \"tableName\": \"C2\",\r\n" +
                "                                        \"alias\": \"Reservation_LoyaltyNumber\"\r\n" +
                "                                    },\r\n" +
                "                                    {\r\n" +
                "                                        \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                        \"attributeName\": \"Reservation_LoyaltyType\",\r\n" +
                "                                        \"tableName\": \"C2\",\r\n" +
                "                                        \"alias\": \"Reservation_LoyaltyType\"\r\n" +
                "                                    },\r\n" +
                "                                    {\r\n" +
                "                                        \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                        \"attributeName\": \"Reservation_Status\",\r\n" +
                "                                        \"tableName\": \"C2\",\r\n" +
                "                                        \"alias\": \"Reservation_Status\"\r\n" +
                "                                    },\r\n" +
                "                                    {\r\n" +
                "                                        \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                        \"attributeName\": \"Reservation_CheckedInDate\",\r\n" +
                "                                        \"tableName\": \"C2\",\r\n" +
                "                                        \"alias\": \"Reservation_CheckedInDate\"\r\n" +
                "                                    },\r\n" +
                "                                    {\r\n" +
                "                                        \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                        \"attributeName\": \"Reservation_CheckedOutDate\",\r\n" +
                "                                        \"tableName\": \"C2\",\r\n" +
                "                                        \"alias\": \"Reservation_CheckedOutDate\"\r\n" +
                "                                    },\r\n" +
                "                                    {\r\n" +
                "                                        \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                        \"attributeName\": \"Reservation_Register\",\r\n" +
                "                                        \"tableName\": \"C2\",\r\n" +
                "                                        \"alias\": \"Reservation_Register\"\r\n" +
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
                "                                        \"attributeName\": \"Phone\",\r\n" +
                "                                        \"tableName\": \"M1\",\r\n" +
                "                                        \"alias\": \"MasterCustomer_Phone\"\r\n" +
                "                                    },\r\n" +
                "                                    {\r\n" +
                "                                        \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                        \"attributeName\": \"Prefix\",\r\n" +
                "                                        \"tableName\": \"M1\",\r\n" +
                "                                        \"alias\": \"MasterCustomer_Prefix\"\r\n" +
                "                                    },\r\n" +
                "                                    {\r\n" +
                "                                        \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                        \"attributeName\": \"AddressLine1\",\r\n" +
                "                                        \"tableName\": \"M1\",\r\n" +
                "                                        \"alias\": \"MasterCustomer_AddressLine1\"\r\n" +
                "                                    },\r\n" +
                "                                    {\r\n" +
                "                                        \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                        \"attributeName\": \"City\",\r\n" +
                "                                        \"tableName\": \"M1\",\r\n" +
                "                                        \"alias\": \"MasterCustomer_City\"\r\n" +
                "                                    },\r\n" +
                "                                    {\r\n" +
                "                                        \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                        \"attributeName\": \"State\",\r\n" +
                "                                        \"tableName\": \"M1\",\r\n" +
                "                                        \"alias\": \"MasterCustomer_State\"\r\n" +
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
                "                                                    \"objectJoin\": {\r\n" +
                "                                                        \"type\": \"LEFT\",\r\n" +
                "                                                        \"targetSet\": {\r\n" +
                "                                                            \"ctype\": \".ObjectSet\",\r\n" +
                "                                                            \"name\": \"R1\",\r\n" +
                "                                                            \"distinct\": true,\r\n" +
                "                                                            \"objectName\": \"Reservation\",\r\n" +
                "                                                            \"criteria\": {\r\n" +
                "                                                                \"ctype\": \".Criteria\",\r\n" +
                "                                                                \"operands\": [\r\n" +
                "                                                                    {\r\n" +
                "                                                                        \"ctype\": \".ReferenceAttribute\",\r\n" +
                "                                                                        \"attributeName\": \"Register\",\r\n" +
                "                                                                        \"tableName\": \"R1\",\r\n" +
                "                                                                        \"alias\": \"Register\"\r\n" +
                "                                                                    },\r\n" +
                "                                                                    {\r\n" +
                "                                                                        \"ctype\": \".StaticAttribute\",\r\n" +
                "                                                                        \"data\": \"833313\"\r\n" +
                "                                                                    }\r\n" +
                "                                                                ],\r\n" +
                "                                                                \"operator\": \"IN\"\r\n" +
                "                                                            },\r\n" +
                "                                                            \"outputAttributes\": [\r\n" +
                "                                                                {\r\n" +
                "                                                                    \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                                    \"attributeName\": \"CustomerID\",\r\n" +
                "                                                                    \"tableName\": \"R1\",\r\n" +
                "                                                                    \"alias\": \"Reservation_CustomerID\"\r\n" +
                "                                                                },\r\n" +
                "                                                                {\r\n" +
                "                                                                    \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                                    \"attributeName\": \"ReservationNameId\",\r\n" +
                "                                                                    \"tableName\": \"R1\",\r\n" +
                "                                                                    \"alias\": \"Reservation_ReservationNameId\"\r\n" +
                "                                                                },\r\n" +
                "                                                                {\r\n" +
                "                                                                    \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                                    \"attributeName\": \"HOTELCODEPMS\",\r\n" +
                "                                                                    \"tableName\": \"R1\",\r\n" +
                "                                                                    \"alias\": \"Reservation_HOTELCODEPMS\"\r\n" +
                "                                                                },\r\n" +
                "                                                                {\r\n" +
                "                                                                    \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                                    \"attributeName\": \"ID\",\r\n" +
                "                                                                    \"tableName\": \"R1\",\r\n" +
                "                                                                    \"alias\": \"Reservation_ID\"\r\n" +
                "                                                                },\r\n" +
                "                                                                {\r\n" +
                "                                                                    \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                                    \"attributeName\": \"InvoiceId\",\r\n" +
                "                                                                    \"tableName\": \"R1\",\r\n" +
                "                                                                    \"alias\": \"Reservation_InvoiceId\"\r\n" +
                "                                                                },\r\n" +
                "                                                                {\r\n" +
                "                                                                    \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                                    \"attributeName\": \"InvoiceStatus\",\r\n" +
                "                                                                    \"tableName\": \"R1\",\r\n" +
                "                                                                    \"alias\": \"Reservation_InvoiceStatus\"\r\n" +
                "                                                                },\r\n" +
                "                                                                {\r\n" +
                "                                                                    \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                                    \"attributeName\": \"LoyaltyNumber\",\r\n" +
                "                                                                    \"tableName\": \"R1\",\r\n" +
                "                                                                    \"alias\": \"Reservation_LoyaltyNumber\"\r\n" +
                "                                                                },\r\n" +
                "                                                                {\r\n" +
                "                                                                    \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                                    \"attributeName\": \"LoyaltyType\",\r\n" +
                "                                                                    \"tableName\": \"R1\",\r\n" +
                "                                                                    \"alias\": \"Reservation_LoyaltyType\"\r\n" +
                "                                                                },\r\n" +
                "                                                                {\r\n" +
                "                                                                    \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                                    \"attributeName\": \"Status\",\r\n" +
                "                                                                    \"tableName\": \"R1\",\r\n" +
                "                                                                    \"alias\": \"Reservation_Status\"\r\n" +
                "                                                                },\r\n" +
                "                                                                {\r\n" +
                "                                                                    \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                                    \"attributeName\": \"CheckedInDate\",\r\n" +
                "                                                                    \"tableName\": \"R1\",\r\n" +
                "                                                                    \"alias\": \"Reservation_CheckedInDate\"\r\n" +
                "                                                                },\r\n" +
                "                                                                {\r\n" +
                "                                                                    \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                                    \"attributeName\": \"CheckedOutDate\",\r\n" +
                "                                                                    \"tableName\": \"R1\",\r\n" +
                "                                                                    \"alias\": \"Reservation_CheckedOutDate\"\r\n" +
                "                                                                },\r\n" +
                "                                                                {\r\n" +
                "                                                                    \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                                    \"attributeName\": \"Register\",\r\n" +
                "                                                                    \"tableName\": \"R1\",\r\n" +
                "                                                                    \"alias\": \"Reservation_Register\"\r\n" +
                "                                                                }\r\n" +
                "                                                            ]\r\n" +
                "                                                        },\r\n" +
                "                                                        \"condition\": [\r\n" +
                "                                                            {\r\n" +
                "                                                                \"left\": {\r\n" +
                "                                                                    \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                                    \"attributeName\": \"ID\",\r\n" +
                "                                                                    \"tableName\": \"C5\",\r\n" +
                "                                                                    \"alias\": \"ID\"\r\n" +
                "                                                                },\r\n" +
                "                                                                \"right\": {\r\n" +
                "                                                                    \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                                    \"attributeName\": \"Reservation_CustomerID\",\r\n" +
                "                                                                    \"tableName\": \"R1\",\r\n" +
                "                                                                    \"alias\": \"Reservation_CustomerID\"\r\n" +
                "                                                                }\r\n" +
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
                "                                                            \"attributeName\": \"Reservation_ReservationNameId\",\r\n" +
                "                                                            \"tableName\": \"R1\",\r\n" +
                "                                                            \"alias\": \"Reservation_ReservationNameId\"\r\n" +
                "                                                        },\r\n" +
                "                                                        {\r\n" +
                "                                                            \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                            \"attributeName\": \"Reservation_HOTELCODEPMS\",\r\n" +
                "                                                            \"tableName\": \"R1\",\r\n" +
                "                                                            \"alias\": \"Reservation_HOTELCODEPMS\"\r\n" +
                "                                                        },\r\n" +
                "                                                        {\r\n" +
                "                                                            \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                            \"attributeName\": \"Reservation_ID\",\r\n" +
                "                                                            \"tableName\": \"R1\",\r\n" +
                "                                                            \"alias\": \"Reservation_ID\"\r\n" +
                "                                                        },\r\n" +
                "                                                        {\r\n" +
                "                                                            \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                            \"attributeName\": \"Reservation_InvoiceId\",\r\n" +
                "                                                            \"tableName\": \"R1\",\r\n" +
                "                                                            \"alias\": \"Reservation_InvoiceId\"\r\n" +
                "                                                        },\r\n" +
                "                                                        {\r\n" +
                "                                                            \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                            \"attributeName\": \"Reservation_InvoiceStatus\",\r\n" +
                "                                                            \"tableName\": \"R1\",\r\n" +
                "                                                            \"alias\": \"Reservation_InvoiceStatus\"\r\n" +
                "                                                        },\r\n" +
                "                                                        {\r\n" +
                "                                                            \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                            \"attributeName\": \"Reservation_LoyaltyNumber\",\r\n" +
                "                                                            \"tableName\": \"R1\",\r\n" +
                "                                                            \"alias\": \"Reservation_LoyaltyNumber\"\r\n" +
                "                                                        },\r\n" +
                "                                                        {\r\n" +
                "                                                            \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                            \"attributeName\": \"Reservation_LoyaltyType\",\r\n" +
                "                                                            \"tableName\": \"R1\",\r\n" +
                "                                                            \"alias\": \"Reservation_LoyaltyType\"\r\n" +
                "                                                        },\r\n" +
                "                                                        {\r\n" +
                "                                                            \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                            \"attributeName\": \"Reservation_Status\",\r\n" +
                "                                                            \"tableName\": \"R1\",\r\n" +
                "                                                            \"alias\": \"Reservation_Status\"\r\n" +
                "                                                        },\r\n" +
                "                                                        {\r\n" +
                "                                                            \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                            \"attributeName\": \"Reservation_CheckedInDate\",\r\n" +
                "                                                            \"tableName\": \"R1\",\r\n" +
                "                                                            \"alias\": \"Reservation_CheckedInDate\"\r\n" +
                "                                                        },\r\n" +
                "                                                        {\r\n" +
                "                                                            \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                            \"attributeName\": \"Reservation_CheckedOutDate\",\r\n" +
                "                                                            \"tableName\": \"R1\",\r\n" +
                "                                                            \"alias\": \"Reservation_CheckedOutDate\"\r\n" +
                "                                                        },\r\n" +
                "                                                        {\r\n" +
                "                                                            \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                            \"attributeName\": \"Reservation_Register\",\r\n" +
                "                                                            \"tableName\": \"R1\",\r\n" +
                "                                                            \"alias\": \"Reservation_Register\"\r\n" +
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
                "                                                    \"attributeName\": \"Reservation_ReservationNameId\",\r\n" +
                "                                                    \"tableName\": \"C5\",\r\n" +
                "                                                    \"alias\": \"Reservation_ReservationNameId\"\r\n" +
                "                                                },\r\n" +
                "                                                {\r\n" +
                "                                                    \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                    \"attributeName\": \"Reservation_HOTELCODEPMS\",\r\n" +
                "                                                    \"tableName\": \"C5\",\r\n" +
                "                                                    \"alias\": \"Reservation_HOTELCODEPMS\"\r\n" +
                "                                                },\r\n" +
                "                                                {\r\n" +
                "                                                    \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                    \"attributeName\": \"Reservation_ID\",\r\n" +
                "                                                    \"tableName\": \"C5\",\r\n" +
                "                                                    \"alias\": \"Reservation_ID\"\r\n" +
                "                                                },\r\n" +
                "                                                {\r\n" +
                "                                                    \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                    \"attributeName\": \"Reservation_InvoiceId\",\r\n" +
                "                                                    \"tableName\": \"C5\",\r\n" +
                "                                                    \"alias\": \"Reservation_InvoiceId\"\r\n" +
                "                                                },\r\n" +
                "                                                {\r\n" +
                "                                                    \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                    \"attributeName\": \"Reservation_InvoiceStatus\",\r\n" +
                "                                                    \"tableName\": \"C5\",\r\n" +
                "                                                    \"alias\": \"Reservation_InvoiceStatus\"\r\n" +
                "                                                },\r\n" +
                "                                                {\r\n" +
                "                                                    \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                    \"attributeName\": \"Reservation_LoyaltyNumber\",\r\n" +
                "                                                    \"tableName\": \"C5\",\r\n" +
                "                                                    \"alias\": \"Reservation_LoyaltyNumber\"\r\n" +
                "                                                },\r\n" +
                "                                                {\r\n" +
                "                                                    \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                    \"attributeName\": \"Reservation_LoyaltyType\",\r\n" +
                "                                                    \"tableName\": \"C5\",\r\n" +
                "                                                    \"alias\": \"Reservation_LoyaltyType\"\r\n" +
                "                                                },\r\n" +
                "                                                {\r\n" +
                "                                                    \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                    \"attributeName\": \"Reservation_Status\",\r\n" +
                "                                                    \"tableName\": \"C5\",\r\n" +
                "                                                    \"alias\": \"Reservation_Status\"\r\n" +
                "                                                },\r\n" +
                "                                                {\r\n" +
                "                                                    \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                    \"attributeName\": \"Reservation_CheckedInDate\",\r\n" +
                "                                                    \"tableName\": \"C5\",\r\n" +
                "                                                    \"alias\": \"Reservation_CheckedInDate\"\r\n" +
                "                                                },\r\n" +
                "                                                {\r\n" +
                "                                                    \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                    \"attributeName\": \"Reservation_CheckedOutDate\",\r\n" +
                "                                                    \"tableName\": \"C5\",\r\n" +
                "                                                    \"alias\": \"Reservation_CheckedOutDate\"\r\n" +
                "                                                },\r\n" +
                "                                                {\r\n" +
                "                                                    \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                                    \"attributeName\": \"Reservation_Register\",\r\n" +
                "                                                    \"tableName\": \"C5\",\r\n" +
                "                                                    \"alias\": \"Reservation_Register\"\r\n" +
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
                "                                            \"attributeName\": \"Reservation_ReservationNameId\",\r\n" +
                "                                            \"tableName\": \"C4\",\r\n" +
                "                                            \"alias\": \"Reservation_ReservationNameId\"\r\n" +
                "                                        },\r\n" +
                "                                        {\r\n" +
                "                                            \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                            \"attributeName\": \"Reservation_HOTELCODEPMS\",\r\n" +
                "                                            \"tableName\": \"C4\",\r\n" +
                "                                            \"alias\": \"Reservation_HOTELCODEPMS\"\r\n" +
                "                                        },\r\n" +
                "                                        {\r\n" +
                "                                            \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                            \"attributeName\": \"Reservation_ID\",\r\n" +
                "                                            \"tableName\": \"C4\",\r\n" +
                "                                            \"alias\": \"Reservation_ID\"\r\n" +
                "                                        },\r\n" +
                "                                        {\r\n" +
                "                                            \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                            \"attributeName\": \"Reservation_InvoiceId\",\r\n" +
                "                                            \"tableName\": \"C4\",\r\n" +
                "                                            \"alias\": \"Reservation_InvoiceId\"\r\n" +
                "                                        },\r\n" +
                "                                        {\r\n" +
                "                                            \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                            \"attributeName\": \"Reservation_InvoiceStatus\",\r\n" +
                "                                            \"tableName\": \"C4\",\r\n" +
                "                                            \"alias\": \"Reservation_InvoiceStatus\"\r\n" +
                "                                        },\r\n" +
                "                                        {\r\n" +
                "                                            \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                            \"attributeName\": \"Reservation_LoyaltyNumber\",\r\n" +
                "                                            \"tableName\": \"C4\",\r\n" +
                "                                            \"alias\": \"Reservation_LoyaltyNumber\"\r\n" +
                "                                        },\r\n" +
                "                                        {\r\n" +
                "                                            \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                            \"attributeName\": \"Reservation_LoyaltyType\",\r\n" +
                "                                            \"tableName\": \"C4\",\r\n" +
                "                                            \"alias\": \"Reservation_LoyaltyType\"\r\n" +
                "                                        },\r\n" +
                "                                        {\r\n" +
                "                                            \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                            \"attributeName\": \"Reservation_Status\",\r\n" +
                "                                            \"tableName\": \"C4\",\r\n" +
                "                                            \"alias\": \"Reservation_Status\"\r\n" +
                "                                        },\r\n" +
                "                                        {\r\n" +
                "                                            \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                            \"attributeName\": \"Reservation_CheckedInDate\",\r\n" +
                "                                            \"tableName\": \"C4\",\r\n" +
                "                                            \"alias\": \"Reservation_CheckedInDate\"\r\n" +
                "                                        },\r\n" +
                "                                        {\r\n" +
                "                                            \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                            \"attributeName\": \"Reservation_CheckedOutDate\",\r\n" +
                "                                            \"tableName\": \"C4\",\r\n" +
                "                                            \"alias\": \"Reservation_CheckedOutDate\"\r\n" +
                "                                        },\r\n" +
                "                                        {\r\n" +
                "                                            \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                            \"attributeName\": \"Reservation_Register\",\r\n" +
                "                                            \"tableName\": \"C4\",\r\n" +
                "                                            \"alias\": \"Reservation_Register\"\r\n" +
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
                "                                            \"attributeName\": \"Phone\",\r\n" +
                "                                            \"tableName\": \"M2\",\r\n" +
                "                                            \"alias\": \"MasterCustomer_Phone\"\r\n" +
                "                                        },\r\n" +
                "                                        {\r\n" +
                "                                            \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                            \"attributeName\": \"Prefix\",\r\n" +
                "                                            \"tableName\": \"M2\",\r\n" +
                "                                            \"alias\": \"MasterCustomer_Prefix\"\r\n" +
                "                                        },\r\n" +
                "                                        {\r\n" +
                "                                            \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                            \"attributeName\": \"AddressLine1\",\r\n" +
                "                                            \"tableName\": \"M2\",\r\n" +
                "                                            \"alias\": \"MasterCustomer_AddressLine1\"\r\n" +
                "                                        },\r\n" +
                "                                        {\r\n" +
                "                                            \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                            \"attributeName\": \"City\",\r\n" +
                "                                            \"tableName\": \"M2\",\r\n" +
                "                                            \"alias\": \"MasterCustomer_City\"\r\n" +
                "                                        },\r\n" +
                "                                        {\r\n" +
                "                                            \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                            \"attributeName\": \"State\",\r\n" +
                "                                            \"tableName\": \"M2\",\r\n" +
                "                                            \"alias\": \"MasterCustomer_State\"\r\n" +
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
                "                                    \"attributeName\": \"Reservation_ReservationNameId\",\r\n" +
                "                                    \"tableName\": \"M1\",\r\n" +
                "                                    \"alias\": \"Reservation_ReservationNameId\"\r\n" +
                "                                },\r\n" +
                "                                {\r\n" +
                "                                    \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                    \"attributeName\": \"Reservation_HOTELCODEPMS\",\r\n" +
                "                                    \"tableName\": \"M1\",\r\n" +
                "                                    \"alias\": \"Reservation_HOTELCODEPMS\"\r\n" +
                "                                },\r\n" +
                "                                {\r\n" +
                "                                    \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                    \"attributeName\": \"Reservation_ID\",\r\n" +
                "                                    \"tableName\": \"M1\",\r\n" +
                "                                    \"alias\": \"Reservation_ID\"\r\n" +
                "                                },\r\n" +
                "                                {\r\n" +
                "                                    \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                    \"attributeName\": \"Reservation_InvoiceId\",\r\n" +
                "                                    \"tableName\": \"M1\",\r\n" +
                "                                    \"alias\": \"Reservation_InvoiceId\"\r\n" +
                "                                },\r\n" +
                "                                {\r\n" +
                "                                    \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                    \"attributeName\": \"Reservation_InvoiceStatus\",\r\n" +
                "                                    \"tableName\": \"M1\",\r\n" +
                "                                    \"alias\": \"Reservation_InvoiceStatus\"\r\n" +
                "                                },\r\n" +
                "                                {\r\n" +
                "                                    \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                    \"attributeName\": \"Reservation_LoyaltyNumber\",\r\n" +
                "                                    \"tableName\": \"M1\",\r\n" +
                "                                    \"alias\": \"Reservation_LoyaltyNumber\"\r\n" +
                "                                },\r\n" +
                "                                {\r\n" +
                "                                    \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                    \"attributeName\": \"Reservation_LoyaltyType\",\r\n" +
                "                                    \"tableName\": \"M1\",\r\n" +
                "                                    \"alias\": \"Reservation_LoyaltyType\"\r\n" +
                "                                },\r\n" +
                "                                {\r\n" +
                "                                    \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                    \"attributeName\": \"Reservation_Status\",\r\n" +
                "                                    \"tableName\": \"M1\",\r\n" +
                "                                    \"alias\": \"Reservation_Status\"\r\n" +
                "                                },\r\n" +
                "                                {\r\n" +
                "                                    \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                    \"attributeName\": \"Reservation_CheckedInDate\",\r\n" +
                "                                    \"tableName\": \"M1\",\r\n" +
                "                                    \"alias\": \"Reservation_CheckedInDate\"\r\n" +
                "                                },\r\n" +
                "                                {\r\n" +
                "                                    \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                    \"attributeName\": \"Reservation_CheckedOutDate\",\r\n" +
                "                                    \"tableName\": \"M1\",\r\n" +
                "                                    \"alias\": \"Reservation_CheckedOutDate\"\r\n" +
                "                                },\r\n" +
                "                                {\r\n" +
                "                                    \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                    \"attributeName\": \"Reservation_Register\",\r\n" +
                "                                    \"tableName\": \"M1\",\r\n" +
                "                                    \"alias\": \"Reservation_Register\"\r\n" +
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
                "                                    \"attributeName\": \"MasterCustomer_Phone\",\r\n" +
                "                                    \"tableName\": \"M1\",\r\n" +
                "                                    \"alias\": \"MasterCustomer_Phone\"\r\n" +
                "                                },\r\n" +
                "                                {\r\n" +
                "                                    \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                    \"attributeName\": \"MasterCustomer_Prefix\",\r\n" +
                "                                    \"tableName\": \"M1\",\r\n" +
                "                                    \"alias\": \"MasterCustomer_Prefix\"\r\n" +
                "                                },\r\n" +
                "                                {\r\n" +
                "                                    \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                    \"attributeName\": \"MasterCustomer_AddressLine1\",\r\n" +
                "                                    \"tableName\": \"M1\",\r\n" +
                "                                    \"alias\": \"MasterCustomer_AddressLine1\"\r\n" +
                "                                },\r\n" +
                "                                {\r\n" +
                "                                    \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                    \"attributeName\": \"MasterCustomer_City\",\r\n" +
                "                                    \"tableName\": \"M1\",\r\n" +
                "                                    \"alias\": \"MasterCustomer_City\"\r\n" +
                "                                },\r\n" +
                "                                {\r\n" +
                "                                    \"atype\": \".ReferenceAttribute\",\r\n" +
                "                                    \"attributeName\": \"MasterCustomer_State\",\r\n" +
                "                                    \"tableName\": \"M1\",\r\n" +
                "                                    \"alias\": \"MasterCustomer_State\"\r\n" +
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
                "                            \"attributeName\": \"Loyalty_Memberships_SourceLoyalty_MembershipsID\",\r\n" +
                "                            \"tableName\": \"M0\",\r\n" +
                "                            \"alias\": \"Loyalty_Memberships_SourceLoyalty_MembershipsID\"\r\n" +
                "                        },\r\n" +
                "                        {\r\n" +
                "                            \"atype\": \".ReferenceAttribute\",\r\n" +
                "                            \"attributeName\": \"Loyalty_Memberships_MembershipType\",\r\n" +
                "                            \"tableName\": \"M0\",\r\n" +
                "                            \"alias\": \"Loyalty_Memberships_MembershipType\"\r\n" +
                "                        },\r\n" +
                "                        {\r\n" +
                "                            \"atype\": \".ReferenceAttribute\",\r\n" +
                "                            \"attributeName\": \"Loyalty_Memberships_MembershipCardNo\",\r\n" +
                "                            \"tableName\": \"M0\",\r\n" +
                "                            \"alias\": \"Loyalty_Memberships_MembershipCardNo\"\r\n" +
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
                "                            \"attributeName\": \"Loyalty_Memberships_MemberSince\",\r\n" +
                "                            \"tableName\": \"M0\",\r\n" +
                "                            \"alias\": \"Loyalty_Memberships_MemberSince\"\r\n" +
                "                        },\r\n" +
                "                        {\r\n" +
                "                            \"atype\": \".ReferenceAttribute\",\r\n" +
                "                            \"attributeName\": \"MasterCustomer_ID\",\r\n" +
                "                            \"tableName\": \"M0\",\r\n" +
                "                            \"alias\": \"MasterCustomer_ID\"\r\n" +
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
                "                            \"attributeName\": \"MasterCustomer_Phone\",\r\n" +
                "                            \"tableName\": \"M0\",\r\n" +
                "                            \"alias\": \"MasterCustomer_Phone\"\r\n" +
                "                        },\r\n" +
                "                        {\r\n" +
                "                            \"atype\": \".ReferenceAttribute\",\r\n" +
                "                            \"attributeName\": \"MasterCustomer_Prefix\",\r\n" +
                "                            \"tableName\": \"M0\",\r\n" +
                "                            \"alias\": \"MasterCustomer_Prefix\"\r\n" +
                "                        },\r\n" +
                "                        {\r\n" +
                "                            \"atype\": \".ReferenceAttribute\",\r\n" +
                "                            \"attributeName\": \"MasterCustomer_AddressLine1\",\r\n" +
                "                            \"tableName\": \"M0\",\r\n" +
                "                            \"alias\": \"MasterCustomer_AddressLine1\"\r\n" +
                "                        },\r\n" +
                "                        {\r\n" +
                "                            \"atype\": \".ReferenceAttribute\",\r\n" +
                "                            \"attributeName\": \"MasterCustomer_City\",\r\n" +
                "                            \"tableName\": \"M0\",\r\n" +
                "                            \"alias\": \"MasterCustomer_City\"\r\n" +
                "                        },\r\n" +
                "                        {\r\n" +
                "                            \"atype\": \".ReferenceAttribute\",\r\n" +
                "                            \"attributeName\": \"MasterCustomer_State\",\r\n" +
                "                            \"tableName\": \"M0\",\r\n" +
                "                            \"alias\": \"MasterCustomer_State\"\r\n" +
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
                "                            \"attributeName\": \"Reservation_ReservationNameId\",\r\n" +
                "                            \"tableName\": \"M3\",\r\n" +
                "                            \"alias\": \"Reservation_ReservationNameId\"\r\n" +
                "                        },\r\n" +
                "                        {\r\n" +
                "                            \"atype\": \".ReferenceAttribute\",\r\n" +
                "                            \"attributeName\": \"Reservation_HOTELCODEPMS\",\r\n" +
                "                            \"tableName\": \"M3\",\r\n" +
                "                            \"alias\": \"Reservation_HOTELCODEPMS\"\r\n" +
                "                        },\r\n" +
                "                        {\r\n" +
                "                            \"atype\": \".ReferenceAttribute\",\r\n" +
                "                            \"attributeName\": \"Reservation_ID\",\r\n" +
                "                            \"tableName\": \"M3\",\r\n" +
                "                            \"alias\": \"Reservation_ID\"\r\n" +
                "                        },\r\n" +
                "                        {\r\n" +
                "                            \"atype\": \".ReferenceAttribute\",\r\n" +
                "                            \"attributeName\": \"Reservation_InvoiceId\",\r\n" +
                "                            \"tableName\": \"M3\",\r\n" +
                "                            \"alias\": \"Reservation_InvoiceId\"\r\n" +
                "                        },\r\n" +
                "                        {\r\n" +
                "                            \"atype\": \".ReferenceAttribute\",\r\n" +
                "                            \"attributeName\": \"Reservation_InvoiceStatus\",\r\n" +
                "                            \"tableName\": \"M3\",\r\n" +
                "                            \"alias\": \"Reservation_InvoiceStatus\"\r\n" +
                "                        },\r\n" +
                "                        {\r\n" +
                "                            \"atype\": \".ReferenceAttribute\",\r\n" +
                "                            \"attributeName\": \"Reservation_LoyaltyNumber\",\r\n" +
                "                            \"tableName\": \"M3\",\r\n" +
                "                            \"alias\": \"Reservation_LoyaltyNumber\"\r\n" +
                "                        },\r\n" +
                "                        {\r\n" +
                "                            \"atype\": \".ReferenceAttribute\",\r\n" +
                "                            \"attributeName\": \"Reservation_LoyaltyType\",\r\n" +
                "                            \"tableName\": \"M3\",\r\n" +
                "                            \"alias\": \"Reservation_LoyaltyType\"\r\n" +
                "                        },\r\n" +
                "                        {\r\n" +
                "                            \"atype\": \".ReferenceAttribute\",\r\n" +
                "                            \"attributeName\": \"Reservation_Status\",\r\n" +
                "                            \"tableName\": \"M3\",\r\n" +
                "                            \"alias\": \"Reservation_Status\"\r\n" +
                "                        },\r\n" +
                "                        {\r\n" +
                "                            \"atype\": \".ReferenceAttribute\",\r\n" +
                "                            \"attributeName\": \"Reservation_CheckedInDate\",\r\n" +
                "                            \"tableName\": \"M3\",\r\n" +
                "                            \"alias\": \"Reservation_CheckedInDate\"\r\n" +
                "                        },\r\n" +
                "                        {\r\n" +
                "                            \"atype\": \".ReferenceAttribute\",\r\n" +
                "                            \"attributeName\": \"Reservation_CheckedOutDate\",\r\n" +
                "                            \"tableName\": \"M3\",\r\n" +
                "                            \"alias\": \"Reservation_CheckedOutDate\"\r\n" +
                "                        },\r\n" +
                "                        {\r\n" +
                "                            \"atype\": \".ReferenceAttribute\",\r\n" +
                "                            \"attributeName\": \"Reservation_Register\",\r\n" +
                "                            \"tableName\": \"M3\",\r\n" +
                "                            \"alias\": \"Reservation_Register\"\r\n" +
                "                        }\r\n" +
                "                    ]\r\n" +
                "                }\r\n" +
                "            ],\r\n" +
                "            \"outputAttributes\": [\r\n" +
                "                {\r\n" +
                "                    \"atype\": \".ReferenceAttribute\",\r\n" +
                "                    \"attributeName\": \"MasterCustomer_ID\",\r\n" +
                "                    \"tableName\": \"M4\",\r\n" +
                "                    \"alias\": \"M_MasterCustomer_ID\"\r\n" +
                "                },\r\n" +
                "                {\r\n" +
                "                    \"atype\": \".ReferenceAttribute\",\r\n" +
                "                    \"attributeName\": \"Reservation_ReservationNameId\",\r\n" +
                "                    \"tableName\": \"M4\",\r\n" +
                "                    \"alias\": \"R_ReservationNameId\"\r\n" +
                "                },\r\n" +
                "                {\r\n" +
                "                    \"atype\": \".ReferenceAttribute\",\r\n" +
                "                    \"attributeName\": \"Loyalty_Memberships_SourceLoyalty_MembershipsID\",\r\n" +
                "                    \"tableName\": \"M4\",\r\n" +
                "                    \"alias\": \"L_SourceLoyalty_MembershipsID\"\r\n" +
                "                },\r\n" +
                "                {\r\n" +
                "                    \"atype\": \".ReferenceAttribute\",\r\n" +
                "                    \"attributeName\": \"Reservation_HOTELCODEPMS\",\r\n" +
                "                    \"tableName\": \"M4\",\r\n" +
                "                    \"alias\": \"HOTELCODEPMS\"\r\n" +
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
                "                    \"alias\": \"M_Phone\"\r\n" +
                "                },\r\n" +
                "                {\r\n" +
                "                    \"atype\": \".ReferenceAttribute\",\r\n" +
                "                    \"attributeName\": \"MasterCustomer_Prefix\",\r\n" +
                "                    \"tableName\": \"M4\",\r\n" +
                "                    \"alias\": \"M_Prefix\"\r\n" +
                "                },\r\n" +
                "                {\r\n" +
                "                    \"atype\": \".ReferenceAttribute\",\r\n" +
                "                    \"attributeName\": \"MasterCustomer_AddressLine1\",\r\n" +
                "                    \"tableName\": \"M4\",\r\n" +
                "                    \"alias\": \"M_AddressLine1\"\r\n" +
                "                },\r\n" +
                "                {\r\n" +
                "                    \"atype\": \".ReferenceAttribute\",\r\n" +
                "                    \"attributeName\": \"MasterCustomer_City\",\r\n" +
                "                    \"tableName\": \"M4\",\r\n" +
                "                    \"alias\": \"M_City\"\r\n" +
                "                },\r\n" +
                "                {\r\n" +
                "                    \"atype\": \".ReferenceAttribute\",\r\n" +
                "                    \"attributeName\": \"MasterCustomer_State\",\r\n" +
                "                    \"tableName\": \"M4\",\r\n" +
                "                    \"alias\": \"M_State\"\r\n" +
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
                "                    \"alias\": \"M_ZipCode\"\r\n" +
                "                },\r\n" +
                "                {\r\n" +
                "                    \"atype\": \".ReferenceAttribute\",\r\n" +
                "                    \"attributeName\": \"Loyalty_Memberships_MembershipType\",\r\n" +
                "                    \"tableName\": \"M4\",\r\n" +
                "                    \"alias\": \"L_MembershipType\"\r\n" +
                "                },\r\n" +
                "                {\r\n" +
                "                    \"atype\": \".ReferenceAttribute\",\r\n" +
                "                    \"attributeName\": \"Loyalty_Memberships_MembershipCardNo\",\r\n" +
                "                    \"tableName\": \"M4\",\r\n" +
                "                    \"alias\": \"L_MembershipCardNo\"\r\n" +
                "                },\r\n" +
                "                {\r\n" +
                "                    \"atype\": \".ReferenceAttribute\",\r\n" +
                "                    \"attributeName\": \"Loyalty_Memberships_MembershipLevel\",\r\n" +
                "                    \"tableName\": \"M4\",\r\n" +
                "                    \"alias\": \"L_MembershipLevel\"\r\n" +
                "                },\r\n" +
                "                {\r\n" +
                "                    \"atype\": \".ReferenceAttribute\",\r\n" +
                "                    \"attributeName\": \"Loyalty_Memberships_MembershipStage\",\r\n" +
                "                    \"tableName\": \"M4\",\r\n" +
                "                    \"alias\": \"L_MembershipStage\"\r\n" +
                "                },\r\n" +
                "                {\r\n" +
                "                    \"atype\": \".ReferenceAttribute\",\r\n" +
                "                    \"attributeName\": \"Loyalty_Memberships_MemberSince\",\r\n" +
                "                    \"tableName\": \"M4\",\r\n" +
                "                    \"alias\": \"L_MemberSince\"\r\n" +
                "                },\r\n" +
                "                {\r\n" +
                "                    \"atype\": \".ReferenceAttribute\",\r\n" +
                "                    \"attributeName\": \"Reservation_ID\",\r\n" +
                "                    \"tableName\": \"M4\",\r\n" +
                "                    \"alias\": \"R_ID\"\r\n" +
                "                },\r\n" +
                "                {\r\n" +
                "                    \"atype\": \".ReferenceAttribute\",\r\n" +
                "                    \"attributeName\": \"Reservation_InvoiceId\",\r\n" +
                "                    \"tableName\": \"M4\",\r\n" +
                "                    \"alias\": \"R_InvoiceId\"\r\n" +
                "                },\r\n" +
                "                {\r\n" +
                "                    \"atype\": \".ReferenceAttribute\",\r\n" +
                "                    \"attributeName\": \"Reservation_InvoiceStatus\",\r\n" +
                "                    \"tableName\": \"M4\",\r\n" +
                "                    \"alias\": \"R_InvoiceStatus\"\r\n" +
                "                },\r\n" +
                "                {\r\n" +
                "                    \"atype\": \".ReferenceAttribute\",\r\n" +
                "                    \"attributeName\": \"Reservation_LoyaltyNumber\",\r\n" +
                "                    \"tableName\": \"M4\",\r\n" +
                "                    \"alias\": \"R_LoyaltyNumber\"\r\n" +
                "                },\r\n" +
                "                {\r\n" +
                "                    \"atype\": \".ReferenceAttribute\",\r\n" +
                "                    \"attributeName\": \"Reservation_LoyaltyType\",\r\n" +
                "                    \"tableName\": \"M4\",\r\n" +
                "                    \"alias\": \"R_LoyaltyType\"\r\n" +
                "                },\r\n" +
                "                {\r\n" +
                "                    \"atype\": \".ReferenceAttribute\",\r\n" +
                "                    \"attributeName\": \"Reservation_Status\",\r\n" +
                "                    \"tableName\": \"M4\",\r\n" +
                "                    \"alias\": \"R_Status\"\r\n" +
                "                },\r\n" +
                "                {\r\n" +
                "                    \"atype\": \".ReferenceAttribute\",\r\n" +
                "                    \"attributeName\": \"Reservation_CheckedInDate\",\r\n" +
                "                    \"tableName\": \"M4\",\r\n" +
                "                    \"alias\": \"R_CheckedInDate\"\r\n" +
                "                },\r\n" +
                "                {\r\n" +
                "                    \"atype\": \".ReferenceAttribute\",\r\n" +
                "                    \"attributeName\": \"Reservation_CheckedOutDate\",\r\n" +
                "                    \"tableName\": \"M4\",\r\n" +
                "                    \"alias\": \"R_CheckedOutDate\"\r\n" +
                "                },\r\n" +
                "                {\r\n" +
                "                    \"atype\": \".ReferenceAttribute\",\r\n" +
                "                    \"attributeName\": \"Reservation_Register\",\r\n" +
                "                    \"tableName\": \"M4\",\r\n" +
                "                    \"alias\": \"R_Register\"\r\n" +
                "                }\r\n" +
                "            ]\r\n" +
                "        },\r\n" +
                "        \"uniqueId\": \"cxu_7e59f64e_e56d_45e9_99e5_7246b89ed518\",\r\n" +
                "        \"tenantId\": 100074\r\n" +
                "    }\r\n" +
                "}";


        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody jsonOfReservation = RequestBody.create(mediaType, payload);

        String response = sendReservationRequestWithTokenHandling(client, jsonOfReservation, Token);
        System.out.println(response);


        JSONObject jsonResponse = new JSONObject(response);
        // Build header index map
        Map<String, Integer> headerIndexMap = new HashMap<>();
        JSONArray headerArray = jsonResponse.getJSONArray("header");
        for (int i = 0; i < headerArray.length(); i++) {
            headerIndexMap.put(headerArray.getJSONObject(i).getString("name"), i);
        }

        // Personal & Membership Collections


        // Loop rows
        JSONArray dataArray = jsonResponse.getJSONArray("data");
        for (int i = 0; i < dataArray.length(); i++) {
            JSONArray row = dataArray.getJSONArray(i);

            // Personal details captured once from the first row
            if (i == 0) {
                personalDetails.put("firstName", row.optString(headerIndexMap.get("m_firstname"), ""));
                personalDetails.put("lastName", row.optString(headerIndexMap.get("m_lastname"), ""));
                personalDetails.put("phone", row.optString(headerIndexMap.get("m_phone"), ""));
                personalDetails.put("prefix", row.optString(headerIndexMap.get("m_prefix"), ""));
                personalDetails.put("addressLine1", row.optString(headerIndexMap.get("m_addressline1"), ""));
                //personalDetails.put("addressLine2", row.optString(headerIndexMap.get("m_addressline2"), ""));
                // personalDetails.put("addressLine3", row.optString(headerIndexMap.get("m_addressline3"), ""));
                //personalDetails.put("addressLine4", row.optString(headerIndexMap.get("m_addressline4"), ""));
                personalDetails.put("city", row.optString(headerIndexMap.get("m_city"), ""));
                personalDetails.put("state", row.optString(headerIndexMap.get("m_state"), ""));
                personalDetails.put("country", row.optString(headerIndexMap.get("m_country"), ""));
                personalDetails.put("zipcode", row.optString(headerIndexMap.get("m_zipcode"), ""));
                //personalDetails.put("email", row.optString(headerIndexMap.get("m_email"), ""));
                personalDetails.put("masterCustomerId", row.optString(headerIndexMap.get("m_mastercustomer_id"), ""));
                personalDetails.put("phone", row.optString(headerIndexMap.get("m_phone"), ""));
                personalDetails.put("operaProfileId", row.optString(headerIndexMap.get("r_id"), ""));
            }

            // Membership details for each row
            Map<String, String> membershipMap = new HashMap<>();
            membershipMap.put("membershipSourceId", row.optString(headerIndexMap.get("l_sourceloyalty_membershipsid"), ""));
            membershipMap.put("membershipType", row.optString(headerIndexMap.get("l_membershiptype"), ""));
            membershipMap.put("membershipCardNo", row.optString(headerIndexMap.get("l_membershipcardno"), ""));
            membershipMap.put("membershipLevel", row.optString(headerIndexMap.get("l_membershiplevel"), ""));
            membershipMap.put("membershipStage", row.optString(headerIndexMap.get("l_membershipstage"), ""));
            membershipMap.put("membershipSince", row.optString(headerIndexMap.get("l_membersince"), ""));

            membershipList.add(membershipMap);
        }

        // Print results
        System.out.println("PERSONAL DETAILS --> " + personalDetails);
        System.out.println("MEMBERSHIP DETAILS LIST --> " + membershipList);




        JSONArray headers = jsonResponse.getJSONArray("header");
        JSONArray dataArrays = jsonResponse.getJSONArray("data");


        // Dynamically set count based on number of rows in "data"
        int count = dataArrays.length();
        System.out.println("Count value based on data size: " + count);

        if (count == 4) {
            JSONArray firstData = dataArrays.getJSONArray(0);
            JSONObject jsonObject = new JSONObject();


            // Map header names to values
            for (int i = 0; i < headers.length(); i++) {
                String headerName = headers.getJSONObject(i).getString("name");
                String value = firstData.optString(i, "");
                jsonObject.put(headerName, value);
            }

            // Extract fields
            String invoiceStatus = jsonObject.optString("r_invoicestatus", "");
            Reservation_LoyaltyNumber = jsonObject.optString("r_loyaltynumber", "");
            Reservation_LoyaltyType = jsonObject.optString("r_loyaltytype", "");
            String Status = jsonObject.optString("r_status", "");

            String Reservation_Status;
            if (Status.equalsIgnoreCase("InHouse")) {
                Reservation_Status = "CHECKED IN";
            } else if (Status.equalsIgnoreCase("CHANGED") || Status.equalsIgnoreCase("Reserved")) {
                Reservation_Status = "Not Guarantee";
            } else if (Status.equalsIgnoreCase("CheckedOut")) {
                Reservation_Status = "CHECKED OUT";
            } else {
                Reservation_Status = Status;
            }

            if (invoiceStatus.equalsIgnoreCase("Active") || invoiceStatus.equalsIgnoreCase("SUCCESS")) {
                String tinyURL = jsonObject.optString("tinyurl_c", "");
                String invoiceId = jsonObject.optString("r_invoiceid", "");

                jsonObjectReturn.put("STATUS", "SUCCESS");
                jsonObjectReturn.put("TinyURL", tinyURL);
                jsonObjectReturn.put("InvoiceId", invoiceId);
                jsonObjectReturn.put("ReservationStatus", Reservation_Status);
                jsonObjectReturn.put("LoyaltyNumber", Reservation_LoyaltyNumber);
                jsonObjectReturn.put("LoyaltyType", Reservation_LoyaltyType);
            } else {
                jsonObjectReturn.put("STATUS", "ERROR");
                jsonObjectReturn.put("MSG", "Invoice not created");
                jsonObjectReturn.put("InvoiceStatus", invoiceStatus);
            }

        } else {
            Configuration configuration = new Configuration();
            configuration.hotelList();
            String hotelSet = Configuration.hotelList.get(propertyCode);

            if (hotelSet.equals("Central") || hotelSet.equals("Oracle Cloud Central")) {
                String insertDate = reservationJson
                        .getJSONObject("reservationFolioInformation")
                        .getJSONObject("reservationInfo")
                        .getString("createDateTime");

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date d3 = format.parse(insertDate.substring(0, 10));
                String BOOKINGDATE = dateFormat.format(d3);

                Reservation_LoyaltyNumber = reservationJson
                        .getJSONObject("reservationFolioInformation")
                        .getJSONObject("reservationInfo")
                        .getJSONObject("reservationGuest")
                        .getJSONObject("membership")
                        .optString("accountId", "");

                Reservation_LoyaltyType = reservationJson
                        .getJSONObject("reservationFolioInformation")
                        .getJSONObject("reservationInfo")
                        .getJSONObject("reservationGuest")
                        .getJSONObject("membership")
                        .optString("programCode", "");

                jsonObjectReturn.put("STATUS", "ERROR");
                jsonObjectReturn.put("MSG", "Invoice not created");
                jsonObjectReturn.put("BookingDate", BOOKINGDATE);
                jsonObjectReturn.put("LoyaltyNumber", Reservation_LoyaltyNumber);
                jsonObjectReturn.put("LoyaltyType", Reservation_LoyaltyType);

            } else {
                jsonObjectReturn.put("STATUS", "ERROR");
                jsonObjectReturn.put("MSG", "Reservation not found");
                jsonObjectReturn.put("ReservationMDM", "NOT FOUND IN MDM");
            }
        }

        return jsonObjectReturn;
    }

    // Helper method to send request (avoids code duplication)
    private static String sendReservationRequestWithTokenHandling(OkHttpClient client, RequestBody body, String token) throws IOException, JSONException {
        Response response = null;
        String authTokens = TokenManager.getToken();
//	    String authToken = readTokenFromFile();
        if (authTokens == null || authTokens.isEmpty()) {
            System.out.println("authtoken is null");
//			 authToken = generateNewToken();
//			 saveTokenToFile(authToken);
            authTokens = TokenManager.generateNewToken();  // call your token method
            TokenManager.setToken(authTokens);
            System.out.println("auth is null so generated and saved it");
        }
        try {
            Request request = new Request.Builder()
                    .url("https://ihclcdptest.cxunity.ocs.oraclecloud.com/api-data/v1/19700a85df1648f0866d0fd380fe246c/data/query/execute")
                    .post(body)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Authorization", "Bearer " + authTokens)
                    .build();

            response = client.newCall(request).execute();
            String responseData = response.body() != null ? response.body().string() : "{}";

            // Parse JSON response
            JSONObject json = new JSONObject(responseData);
            if (json.has("Response")) {
                JSONArray respArray = json.getJSONArray("Response");
                if (respArray.length() > 0) {
                    JSONObject firstResp = respArray.getJSONObject(0);
                    String decision = firstResp.optString("Decision", "");

                    if ("Deny".equalsIgnoreCase(decision)) {
                        System.out.println("Decision Deny received. Regenerating token...");

                        // Regenerate token

//
//	                    AUTH_TOKEN = generateNewToken();
//	                    saveTokenToFile(AUTH_TOKEN);
//	                    token = generateNewToken();
                        authTokens = TokenManager.generateNewToken();
                        TokenManager.setToken(authTokens);

                        // Retry once with new token
                        return sendReservationRequestWithTokenHandling(client, body, authTokens);
                    }

                    // If there is a Data array, print details
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

            return responseData;

        } finally {
            if (response != null) {
                // Properly close the response
            }
        }
    }






    private static String readTokenFromFile() {
        try {
            System.out.println("Reading token from file...");
            String currentDir = System.getProperty("user.dir");
            String masterInput = currentDir + "\\src\\config\\auth_token.txt";
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





    static String readJson(JSONObject obj, String key)
    {
        try {
            String val = obj.getString(key);
            return val;
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    public void clearCache()
    {
        ReservationID = "";
        ErrorFlag503 = "";

        Status = "";
        resStatus = "";
        CheckInDate = "";
        CheckOutDate = "";
        HotelName = "";
        HotelCode = "";
        RoomNo = "";
        PropertyFullName = "";

        ArrivalDate = "";
        DepartureDate = "";
        OWSProperty = "";

        CInDate = null;
        COutDate = null;

        ConfirmationNo = "";

        //ResMemID = "";
        postalCode = "";
        state = "";
        Address1 = "";
        City = "";
        state = "";
        countryCode = "";
    }

    public static String SendEmailAlert(String ReservationID, String OWSProperty, String ErrorMsg) {
        String MailStatus = "";
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        String eBody ="";
        String fBody = eBody.replaceAll("\\n", "");
        //	String tBody = eBody.replaceAll("\\s+", " ");
        String tBody = "https://ocimiddleware.tajhotels.com/Stay/?ReservId="+ReservationID
                +"&Property="+OWSProperty;
        String ToEmail = "IHCLOracleCloudSupport@innovacx.com";
        final SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

        String Subject = "MUI 503 Service Unavailable Error"+" - "+OWSProperty+" "+df.format(new Date());
//		String bodyStr = "{\r\n"
//				+ "    \"From\": \"pavan.kurre@innovacx.com\",\r\n"
//				+ "    \"To\": \"pavan.kurre@innovacx.com\",\r\n"
//				+ "    \"Subject\": \"TCP erservation generation failed\",\r\n"
//				+ "    \"body\": \"TCP file generation failed on time from: "+fDate+" to : "+tDate+"\"\r\n"
//				+ "}";
        String bodyStr = "{\r\n"
                + "    \"From\": \""+ToEmail+"\",\r\n"
                + "    \"To\": \""+ToEmail+"\",\r\n"
                + "    \"Subject\": \""+Subject+"\",\r\n"
                + "\r\n    \"Title\": \"MUI 503 Service Unavailable Error\","
                + "    \"body\": \""+"MUI 503 Service Unavailable Error: \\n \\n \\n \\n"+tBody+"\",\r\n"
                + "\r\n    \"Message\": \""+ErrorMsg+"\"\r\n}";
//				+ "}";
//		String bodyStr = "{\r\n"
//				+ "    \"From\": \"pavan.kurre@innovacx.com\",\r\n"
//				+ "    \"To\": \"pavan.kurre@innovacx.com\",\r\n"
//				+ "    \"Subject\": \"TCP Rerservation file failed\",\r\n"
//				+ "    \"body\": \""+bodytxt+"\"\r\n"
//				+ "}";
        RequestBody body1 = RequestBody.create(mediaType, bodyStr);
        Request request1 = new Request.Builder()
                .url("https://tajoicprod-bmsvb0wsgm8n-bo.integration.ocp.oraclecloud.com:443/ic/api/integration/v1/flows/rest/EMAIL_ALERT/1.0/EmailAlert")
                .method("POST", body1)
                .addHeader("Authorization", "Basic b2ljX3VzZXI6SW5ub3ZhY3hAMzIx")
                .addHeader("Content-Type", "application/json")
                .build();
        Response response1;
        try {
            response1 = client.newCall(request1).execute();
            String resp = response1.body().string().toString();
            System.out.println("Email send status :"+resp);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return MailStatus;



    }


}
