package config;




import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONObject;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import data.GiftCardPropertyMapping;
import config.GetReservationData;

public class Configuration {
	
	public static String MDMUsername = "datacentre";
	public static String MDMPassword = "Smile@25";
	
	public static String OWSUsername = "KIOSK";
	public static String OWSPassword = "$$$KIOSK$$";
	
	public static String ICSUsername = "raj.srinivasan@innovacx.com";
	public static String ICSPassword = "Smile@25";
	public static String OICUsername = "oic_user";
	public static String OICPassword = "Innovacx@321";
//Prod
	//public static String OperaCloudUsername = "IHCLORACLECLOUDSUPPORT";
	//public static String OperaCloudPassword = "Welcome@12345";
	//UAT
//	public static String OperaCloudUsername = "oxiows_innovacx";
//    public static String OperaCloudPassword = "Welcometoservice@0824";
//	
	public static String OperaCloudUsername = "innovacx.";
	public static String OperaCloudPassword = "Welcometoopera@0724Welcome";
	//public static String OperaCloudPassword = "Welcometoopera@0724Welcome";
	//public  static String ICSBase64Binary = "WXP8XgkVLThQylMntUL2tQ==";
	public  static String ICSBase64Binary = "cmFqLnNyaW5pdmFzYW5AaW5ub3ZhY3guY29tOlNtaWxlQDI1";
	public  static String OICBase64Binary = "U07gU1zpL1QcujIh+uEAOQ==";
	/*public static String ICSUsername = "madhusudhan.baddam@innovacx.com";
	public static String ICSPassword = "Smile@02";
	public  static String ICSBase64Binary = "iS62C01eQ8nA2wN+xGOTAA==";*/
	
//	public static String IcsBasicAuth = "Basic cmFqLnNyaW5pdmFzYW5AaW5ub3ZhY3guY29tOlNtaWxlQDI1"; //raj.srinivasan
//	public static String IcsBasicAuth = "Basic bWFkaHVzdWRoYW4uYmFkZGFtQGlubm92YWN4LmNvbTpTbWlsZUAwMg=="; //madhusudhan
	public static String IcsBasicAuth = "Basic b2ljX3VzZXI6SW5ub3ZhY3hAMzIx"; //oic_user
	
//	public static String MDMBasicAuth = "Basic cmFqLnNyaW5pdmFzYW5AaW5ub3ZhY3guY29tOlNtaWxlQDI1";	//raj.srinivasan
	public static String MDMBasicAuth = "Basic ZGF0YWNlbnRyZTpTbWlsZUAyNQ==";  //ZGF0YWNlbnRyZTpTbWlsZUAyNQ==	//datacentre
	
	public static Map<String, String> hotelList = new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);
	
	public static String logLoc ="/u01/data/domains/ocitajmw_domain/MUILog/MUIPaymentLog/Prod/";
	public static String redemptionLog = "/u01/data/domains/ocitajmw_domain/MUILog/MUIPaymentLog/Prod/TransactionLogs/";
	//public static String redemptionLog = "D:/";
	//public static String logLoc = "D:/INNOVACX/STS Workspace/MUI Redemption prod 04-04-2022/log/";
	
	public static String giftCardLogLoc = "/u01/data/domains/ocitajmw_domain/MUILog/MUIPaymentLog/GiftCardLogs/";	
	//public static String giftCardLogLoc = "D:/Taj/PaymentLog/QC/";
	
	public static boolean underMaintainance = false;
	public static String downtimeFrom = "16th Oct, 12:00 AM IST";
	public static String downtimeTo = "16th Oct, 01:00 PM IST";
	
	/* CCAvenue credentials */
	public static String CCAvenueWokringKey = "9A9C525B00C77455D71AD2BFBBE3F02E";
	public static String CCAvenueAccessCode = "AVEV86GG30AB78VEBA";
	public static String CCAvenueUrl = "https://api.ccavenue.com/apis/servlet/DoWebTrans";
	
	/* CCAvenue MUI Invoke Jar Locations */
//	public static String CCAvenueMUIInvokeJar = "D:\\mui\\CCAvenueMUIInvoke\\";
	//public static String CCAvenueMUIInvokeJar = "/u01/data/domains/TajMiddl_domain/MUILog/CCAvenueMUIInvoke/";
	public static String CCAvenueMUIInvokeJar = "/u01/data/domains/ocitajmw_domain/MUILog/CCAvenueMUIInvoke/";
	
	
	
	/**OWS Services**/
	
	/* PRODUCTION START */
		
		//public static String InvoiceWSDL = "https://tajprodics-a455764.integration.us2.oraclecloud.com/integration/flowsvc/soap/OWS_FETCHINVOICE/v01/";
		public static String InvoiceWSDL = "https://tajoicprod-bmsvb0wsgm8n-bo.integration.ocp.oraclecloud.com/ic/ws/integration/v1/flows/soap/OWS_FETCHINVOICE/1.0/";
		public static String InvoiceActionURL = "http://webservices.micros.com/ows/5.1/ResvAdvanced.wsdl#Invoice";
		
		//public static String MakePaymentWSDL = "https://tajprodics-a455764.integration.us2.oraclecloud.com/integration/flowsvc/soap/OWS_MAKEPAYMENT/v01/";
		public static String MakePaymentWSDL = "https://tajoicprod-bmsvb0wsgm8n-bo.integration.ocp.oraclecloud.com:443/ic/ws/integration/v1/flows/soap/OWS_MAKEPAYMENT/1.0/";
		public static String MakePaymentActionURL = "http://webservices.micros.com/ows/5.1/ResvAdvanced.wsdl#MakePayment";
		
		//public static String CurrencyConverterWSDL = "https://tajprodics-a455764.integration.us2.oraclecloud.com/integration/flowsvc/soap/OWS_CURRENCYCONVERTE/v01/";
		public static String CurrencyConverterWSDL = "https://tajoicprod-bmsvb0wsgm8n-bo.integration.ocp.oraclecloud.com:443/ic/ws/integration/v1/flows/soap/OWS_CURRENCYCONVERTE/1.0/";
				public static String CurrencyConverterActionURL = "http://webservices.micros.com/ows/5.1/Information.wsdl#CurrencyConverter";
		
		//public static String GetFutureBookingSummaryWSDL = "https://tajprodics-a455764.integration.us2.oraclecloud.com:443/integration/flowsvc/soap/OWS_FUTUREBOOKINGSUM/v01/";
		public static String GetFutureBookingSummaryWSDL = "https://tajoicprod-bmsvb0wsgm8n-bo.integration.ocp.oraclecloud.com/ic/ws/integration/v1/flows/soap/OWS_FUTUREBOOKINGSUM/1.0/";
		//public static String GetFutureBookingSummaryWSDL = "https://tajoicprod-bmsvb0wsgm8n-bo.integration.ocp.oraclecloud.com/ic/ws/integration/v1/flows/soap/OWS_FUTURE_BOOKIN_SUMMAR_OPERA/1.0/";
		public static String GetFutureBookingSummaryActionURL = "http://webservices.micros.com/ows/5.1/Reservation.wsdl#FutureBookingSummary";

		//UAT Opera Cloud		
	/*	public static String GetFutureBookingSummaryOperaCloudWSDL = "https://hbs1-uat-ssd-osb.oracleindustry.com:443/OPERAOSB/OPERA_OWS/OWS_WS_51/Reservation";
		public static String GetFutureBookingSummaryOperaCloudActionURL = "http://webservices.micros.com/ows/5.1/Reservation.wsdl#FutureBookingSummary";
		public static String InvoiceWSDLOperaCloud = "https://hbs1-uat-ssd-osb.oracleindustry.com:443/OPERAOSB/OPERA_OWS/OWS_WS_51/ResvAdvanced";
		public static String InvoiceActionURLOperaCloud = "http://webservices.micros.com/ows/5.1/ResvAdvanced.wsdl#Invoice";
		public static String FetchBookingCentralOperaCloudWSDL = "https://hbs1-uat-ssd-osb.oracleindustry.com:443/OPERAOSB/OPERA_OWS/OWS_WS_51/Reservation";
		public static String FetchBookingCentralOperaCloudWSDLActionURL = "http://webservices.micros.com/ows/5.1/Reservation.wsdl#FetchBooking";
		public static String MakePaymentOperaCloudWSDL = "https://hbs1-uat-ssd-osb.oracleindustry.com:443/OPERAOSB/OPERA_OWS/OWS_WS_51/ResvAdvanced";
		public static String MakePaymentOperaCloudActionURL = "http://webservices.micros.com/ows/5.1/ResvAdvanced.wsdl#MakePayment";
		*/
		//Prod OPera Cloud
		//public static String GetFutureBookingSummaryOperaCloudWSDL = "https://hbs1-ssd-osb.oracleindustry.com/OPERAOSB/OPERA_OWS/OWS_WS_51/Reservation"; prod
		public static String GetFutureBookingSummaryOperaCloudWSDL = "https://tajoicprod-bmsvb0wsgm8n-bo.integration.ocp.oraclecloud.com:443/ic/api/integration/v1/flows/rest/OHIP_RESERVATIONS/1.0/ReservationsAndFolios/";
		public static String GetFutureBookingSummaryOperaCloudActionURL = "http://webservices.micros.com/ows/5.1/Reservation.wsdl#FutureBookingSummary";
		
		public static String InvoiceWSDLOperaCloud = "https://hbs1-ssd-osb.oracleindustry.com/OPERAOSB/OPERA_OWS/OWS_WS_51/ResvAdvanced";
		public static String InvoiceActionURLOperaCloud = "http://webservices.micros.com/ows/5.1/ResvAdvanced.wsdl#Invoice";
		
		public static String FetchBookingCentralOperaCloudWSDL = "https://tajoicprod-bmsvb0wsgm8n-bo.integration.ocp.oraclecloud.com:443/ic/api/integration/v1/flows/rest/OHIP_PROFILES/1.0/crm/v1/profiles/";
		public static String FetchBookingCentralOperaCloudWSDLActionURL = "http://webservices.micros.com/ows/5.1/Reservation.wsdl#FetchBooking";
		
		public static String MakePaymentOperaCloudWSDL = "https://tajoicprod-bmsvb0wsgm8n-bo.integration.ocp.oraclecloud.com:443/ic/api/integration/v1/flows/rest/OHIP_WRITEBACKTOPMS/1.0/writeBackToPMS/";
		public static String MakePaymentOperaCloudActionURL = "http://webservices.micros.com/ows/5.1/ResvAdvanced.wsdl#MakePayment";
	
	/*public static String InvoiceWSDL = "https://tajics-a455764.integration.us2.oraclecloud.com/integration/flowsvc/soap/OWS_FETCH_INVOICE/v01/";
	public static String InvoiceActionURL = "http://webservices.micros.com/ows/5.1/ResvAdvanced.wsdl#Invoice";
	
	public static String MakePaymentWSDL = "https://tajics-a455764.integration.us2.oraclecloud.com/integration/flowsvc/soap/OWS_MAKE_PAYMENT/v01/";
	public static String MakePaymentActionURL = "http://webservices.micros.com/ows/5.1/ResvAdvanced.wsdl#MakePayment";
	
	public static String CurrencyConverterWSDL = "https://tajics-a455764.integration.us2.oraclecloud.com/integration/flowsvc/soap/OWS_CURRENCYCONVERTE/v01/";
	public static String CurrencyConverterActionURL = "http://webservices.micros.com/ows/5.1/Information.wsdl#CurrencyConverter";
	
	public static String GetFutureBookingSummaryWSDL = "https://tajics-a455764.integration.us2.oraclecloud.com:443/integration/flowsvc/soap/OWS_FUTURE_BOOKING_SUMMARY/v01/";
	public static String GetFutureBookingSummaryActionURL = "http://webservices.micros.com/ows/5.1/Reservation.wsdl#FutureBookingSummary";*/
	
	
	/* OPERA VERSION 5.0.05 START*/
		//London
		//public static String InvoiceOP5005WSDL = "https://tajprodics-a455764.integration.us2.oraclecloud.com:443/integration/flowsvc/soap/OWS_FETCHINV_ADDN_OP5005/v01/";
		public static String InvoiceOP5005WSDL = "https://tajoicprod-bmsvb0wsgm8n-bo.integration.ocp.oraclecloud.com/ic/ws/integration/v1/flows/soap/OWS_FETCHINV_ADDN_OP5005/1.0/";
		public static String InvoiceOP5005ActionURL = "http://webservices.micros.com/ows/5.1/ResvAdvanced.wsdl#Invoice";
		
		//public static String MakePaymentOP5005WSDL = "https://tajprodics-a455764.integration.us2.oraclecloud.com/integration/flowsvc/soap/OWS_MAKEPAYMEN_OP5005/v01/";
		public static String MakePaymentOP5005WSDL = "https://tajoicprod-bmsvb0wsgm8n-bo.integration.ocp.oraclecloud.com/ic/ws/integration/v1/flows/soap/OWS_MAKEPAYMEN_OP5005/1.0/";
		public static String MakePaymentOP5005ActionURL = "http://webservices.micros.com/ows/5.1/ResvAdvanced.wsdl#MakePayment";
		
		//public static String GetFutureBookingSummaryOP5005WSDL = "https://tajprodics-a455764.integration.us2.oraclecloud.com/integration/flowsvc/soap/OWS_FUTUREBO_ADDN_OP5005/v01/";
		public static String GetFutureBookingSummaryOP5005WSDL = "https://tajoicprod-bmsvb0wsgm8n-bo.integration.ocp.oraclecloud.com/ic/ws/integration/v1/flows/soap/OWS_FUTUREBO_ADDN_OP5005/1.0/";
		public static String GetFutureBookingSummaryOP5005ActionURL = "http://webservices.micros.com/ows/5.1/Reservation.wsdl#FutureBookingSummary";
		
	/* OPERA VERSION 5.0.05 END*/
		
	/* OPERA VERSION 5.6.12 START*/
		
		//public static String InvoiceOP5612WSDL = "https://tajprodics-a455764.integration.us2.oraclecloud.com/integration/flowsvc/soap/OWS_FETCHINV_ADDN_OP56120/v01/";
		public static String InvoiceOP5612WSDL = "https://tajoicprod-bmsvb0wsgm8n-bo.integration.ocp.oraclecloud.com/ic/ws/integration/v1/flows/soap/OWS_FETCHINV_ADDN_OP56120/1.0/";
		public static String InvoiceOP5612ActionURL = "http://webservices.micros.com/ows/5.1/ResvAdvanced.wsdl#Invoice";
		
		//public static String MakePaymentOP5612WSDL = "https://tajprodics-a455764.integration.us2.oraclecloud.com/integration/flowsvc/soap/OWS_MAKEPAYM_ADDN_OP56120/v01/";
		public static String MakePaymentOP5612WSDL = "https://tajoicprod-bmsvb0wsgm8n-bo.integration.ocp.oraclecloud.com/ic/ws/integration/v1/flows/soap/OWS_MAKEPAYM_ADDN_OP56120/1.0/";
		public static String MakePaymentOP5612ActionURL = "http://webservices.micros.com/ows/5.1/ResvAdvanced.wsdl#MakePayment";
		
		//public static String GetFutureBookingSummaryOP5612WSDL = "https://tajprodics-a455764.integration.us2.oraclecloud.com/integration/flowsvc/soap/OWS_FUTUREBO_ADD_OP56120/v01/";
		public static String GetFutureBookingSummaryOP5612WSDL = "https://tajoicprod-bmsvb0wsgm8n-bo.integration.ocp.oraclecloud.com/ic/ws/integration/v1/flows/soap/OWS_FUTUREBO_ADD_OP56120/1.0/";
		public static String GetFutureBookingSummaryOP5612ActionURL = "http://webservices.micros.com/ows/5.1/Reservation.wsdl#FutureBookingSummary";
	
	/* OPERA VERSION 5.6.12 END*/
		
	/* OPERA VERSION 5.5.0.0 START*/
		//New York
		//Dubai
		
		//public static String InvoiceOP5500WSDL = "https://tajprodics-a455764.integration.us2.oraclecloud.com/integration/flowsvc/soap/OWS_FETCHINV_ADDN_OP5500/v01/";
		public static String InvoiceOP5500WSDL = "https://tajoicprod-bmsvb0wsgm8n-bo.integration.ocp.oraclecloud.com/ic/ws/integration/v1/flows/soap/OWS_FETCHINV_ADDN_OP5500/1.0/";
		public static String InvoiceOP5500ActionURL = "http://webservices.micros.com/ows/5.1/ResvAdvanced.wsdl#Invoice";
		
		//public static String MakePaymentOP5500WSDL = "https://tajprodics-a455764.integration.us2.oraclecloud.com/integration/flowsvc/soap/OWS_MAKEPAYM_ADDN_OP5500/v01/";
		public static String MakePaymentOP5500WSDL = "https://tajoicprod-bmsvb0wsgm8n-bo.integration.ocp.oraclecloud.com/ic/ws/integration/v1/flows/soap/OWS_MAKEPAYM_ADDN_OP5500/1.0/";
		public static String MakePaymentOP5500ActionURL = "http://webservices.micros.com/ows/5.1/ResvAdvanced.wsdl#MakePayment";
		
		//public static String GetFutureBookingSummaryOP5500WSDL = "https://tajprodics-a455764.integration.us2.oraclecloud.com/integration/flowsvc/soap/OWS_FUTUREBO_ADDN_OP5500/v01/";
		public static String GetFutureBookingSummaryOP5500WSDL = "https://tajoicprod-bmsvb0wsgm8n-bo.integration.ocp.oraclecloud.com/ic/ws/integration/v1/flows/soap/OWS_FUTUREBO_ADDN_OP5500/1.0/";
		public static String GetFutureBookingSummaryOP5500ActionURL = "http://webservices.micros.com/ows/5.1/Reservation.wsdl#FutureBookingSummary";
	/* OPERA VERSION 5.5.0.0 End*/
		
	/* OPERA VERSION 5.0.05 START*/
		//LGKTR - Rebak Island
		//public static String InvoiceOP500511WSDL = "https://tajprodics-a455764.integration.us2.oraclecloud.com:443/integration/flowsvc/soap/OWS_FETCHINV_ADDN_OP500511/v01/";
		public static String InvoiceOP500511WSDL = "https://tajoicprod-bmsvb0wsgm8n-bo.integration.ocp.oraclecloud.com/ic/ws/integration/v1/flows/soap/OWS_FETCHINV_ADDN_OP500511/1.0/";
		public static String InvoiceOP500511ActionURL = "http://webservices.micros.com/ows/5.1/ResvAdvanced.wsdl#Invoice";
		
//		public static String MakePaymentOP500511WSDL = "https://tajprodics-a455764.integration.us2.oraclecloud.com/integration/flowsvc/soap/OWS_MAKEPAYM_ADDN_OP500511/v01/";
		public static String MakePaymentOP500511WSDL = "https://tajoicprod-bmsvb0wsgm8n-bo.integration.ocp.oraclecloud.com/ic/ws/integration/v1/flows/soap/OWS_MAKEPAYM_ADDN_OP500511/1.0/";
		public static String MakePaymentOP500511ActionURL = "http://webservices.micros.com/ows/5.1/ResvAdvanced.wsdl#MakePayment";
		
		//public static String GetFutureBookingSummaryOP500511WSDL = "https://tajprodics-a455764.integration.us2.oraclecloud.com:443/integration/flowsvc/soap/OWS_FUTUREBO_ADDN_OP500511/v01/";
		public static String GetFutureBookingSummaryOP500511WSDL = "https://tajoicprod-bmsvb0wsgm8n-bo.integration.ocp.oraclecloud.com/ic/ws/integration/v1/flows/soap/OWS_FUTUREBO_ADDN_OP500511/1.0/";
		public static String GetFutureBookingSummaryOP500511ActionURL = "http://webservices.micros.com/ows/5.1/Reservation.wsdl#FutureBookingSummary";
		
	/* OPERA VERSION 5.0.05 END*/
		
	/* OWS IDS Property START */
		//public static String InvoiceIDSWSDL = "https://tajprodics-a455764.integration.us2.oraclecloud.com/integration/flowsvc/soap/OWS_IDS_FETCHINVOI/v01/";
		public static String InvoiceIDSWSDL = "https://tajoicprod-bmsvb0wsgm8n-bo.integration.ocp.oraclecloud.com/ic/ws/integration/v1/flows/soap/OWS_IDS_FETCHINVOI/1.0/";
		public static String InvoiceIDSActionURL = "http://webservices.micros.com/ows/5.1/ResvAdvanced.wsdl#Invoice";
		
		//public static String MakePaymentIDSWSDL = "https://tajprodics-a455764.integration.us2.oraclecloud.com/integration/flowsvc/soap/OWS_IDS_MAKEPAYMEN/v01/";
		public static String MakePaymentIDSWSDL = "https://tajoicprod-bmsvb0wsgm8n-bo.integration.ocp.oraclecloud.com/ic/ws/integration/v1/flows/soap/OWS_IDS_MAKEPAYMEN/1.0/";
		public static String MakePaymentIDSActionURL = "http://webservices.micros.com/ows/5.1/ResvAdvanced.wsdl#MakePayment";
		
		//public static String GetFutureBookingSummaryIDSWSDL = "https://tajprodics-a455764.integration.us2.oraclecloud.com/integration/flowsvc/soap/OWS_IDS_FUTUREBOOK/v01/";
		public static String GetFutureBookingSummaryIDSWSDL = "https://tajoicprod-bmsvb0wsgm8n-bo.integration.ocp.oraclecloud.com/ic/ws/integration/v1/flows/soap/OWS_IDS_FUTUREBOOK/1.0/";
		public static String GetFutureBookingSummaryIDSActionURL = "http://webservices.micros.com/ows/5.1/Reservation.wsdl#FutureBookingSummary";
	
		//OWS FetchBooking Central 
		public static String FetchBookingCentralWSDL = "https://tajoicprod-bmsvb0wsgm8n-bo.integration.ocp.oraclecloud.com:443/ic/ws/integration/v1/flows/soap/OWS_FETCHBOOKI_CENTRAL/1.0/";
		public static String FetchBookingCentralActionURL = "http://webservices.micros.com/ows/5.1/Reservation.wsdl#FetchBooking";
				
		//fxcloud
		
				public static String GetFutureBookingSummaryIDSAMA="https://tajoicprod-bmsvb0wsgm8n-bo.integration.ocp.oraclecloud.com/ic/ws/integration/v1/flows/soap/OWS_IDS_FUTUREBO_AMA/1.0/";
				public static String GetFutureBookingSummaryIDSAMAActionURL = "http://webservices.micros.com/ows/5.1/Reservation.wsdl#FutureBookingSummary";
				
				public static String InvoiceIDSAMA="https://tajoicprod-bmsvb0wsgm8n-bo.integration.ocp.oraclecloud.com/ic/ws/integration/v1/flows/soap/OWS_IDS_FETCHINV_AMA/1.0/";
				public static String InvoiceIDSAMAActionURL = "http://webservices.micros.com/ows/5.1/ResvAdvanced.wsdl#Invoice";
				
				public static String MakePaymentIDSAMA="https://tajoicprod-bmsvb0wsgm8n-bo.integration.ocp.oraclecloud.com/ic/ws/integration/v1/flows/soap/OWS_IDS_MAKEPAYM_AMA/1.0/";
				public static String MakePaymentIDSAMAActionURL = "http://webservices.micros.com/ows/5.1/ResvAdvanced.wsdl#MakePayment";
		
				//central OCI new wsdl
				public static String InvoiceCentralOCIWSDL = "https://tajoicprod-bmsvb0wsgm8n-bo.integration.ocp.oraclecloud.com/ic/ws/integration/v1/flows/soap/OWS_FETCHINVOI_CENTRALOCI/1.0/";
				public static String InvoiceCentralOCIActionURL = "http://webservices.micros.com/ows/5.1/ResvAdvanced.wsdl#Invoice";
						
				public static String MakePaymentCentralOCIWSDL = "https://tajoicprod-bmsvb0wsgm8n-bo.integration.ocp.oraclecloud.com/ic/ws/integration/v1/flows/soap/OWS_MAKEPAYM_ADDN_CENTRALO/1.0/";
				public static String MakePaymentCentralOCIActionURL = "http://webservices.micros.com/ows/5.1/ResvAdvanced.wsdl#MakePayment";
						
				public static String GetFutureBookingSummaryCentralOCIWSDL = "https://tajoicprod-bmsvb0wsgm8n-bo.integration.ocp.oraclecloud.com/ic/ws/integration/v1/flows/soap/OWS_FUTUREBOOK_CENTRALOCI/1.0/";
				public static String GetFutureBookingSummaryCentralOCIActionURL = "http://webservices.micros.com/ows/5.1/Reservation.wsdl#FutureBookingSummary";
	/* OWS IDS Property END */
				
		
	/* PRODUCTION END */
		
		
		//Test
		
		/*public static String InvoiceWSDL = "https://tajprodics-a455764.integration.us2.oraclecloud.com/integration/flowsvc/soap/OWS_FETCH_INVOICE/v01/";
		public static String InvoiceActionURL = "http://webservices.micros.com/ows/5.1/ResvAdvanced.wsdl#Invoice";
		
		public static String MakePaymentWSDL = "https://tajprodics-a455764.integration.us2.oraclecloud.com/integration/flowsvc/soap/OWS_MAKE_PAYMENT/v01/";
		public static String MakePaymentActionURL = "http://webservices.micros.com/ows/5.1/ResvAdvanced.wsdl#MakePayment";
		
		public static String CurrencyConverterWSDL = "https://tajprodics-a455764.integration.us2.oraclecloud.com/integration/flowsvc/soap/OWS_CURRENCY_CONVERTER/v01/";
		public static String CurrencyConverterActionURL = "http://webservices.micros.com/ows/5.1/Information.wsdl#CurrencyConverter";*/
		
		//public static String GetReservationDataWSDL = "https://tajprodics-a455764.integration.us2.oraclecloud.com/integration/flowsvc/soap/OWS_FETCH_BOOKING/v01/";
		public static String GetReservationDataWSDL = "https://tajoicprod-bmsvb0wsgm8n-bo.integration.ocp.oraclecloud.com/ic/ws/integration/v1/flows/soap/OWS_FETCH_BOOKING/1.0/";
		public static String GetReservationDataActionURL = "http://webservices.micros.com/ows/5.1/Reservation.wsdl#FetchBooking";
		public static String FecthOutstandingbalance="https://tajoicprod-bmsvb0wsgm8n-bo.integration.ap-mumbai-1.ocp.oraclecloud.com/ic/api/integration/v1/flows/rest/GETMEMBERLIST_GRAVTY/1.0/v1/members/list/";

		/*public static String GetFutureBookingSummaryWSDL = "https://tajprodics-a455764.integration.us2.oraclecloud.com:443/integration/flowsvc/soap/OWS_FUTURE_BOOKING_SUMMARY/v01/";
		public static String GetFutureBookingSummaryActionURL = "http://webservices.micros.com/ows/5.1/Reservation.wsdl#FutureBookingSummary";*/ 
		
	/**OWS Services**/

		
		/**MDM**/
		
		public static String MDMProfileWSDL = "https://ccre.fa.us6.oraclecloud.com/crmCommonSalesParties/SalesPartyService?WSDL";
		public static String MDMProfileActionURL = "https://ccre.fa.us6.oraclecloud.com/crmCommonSalesParties/SalesPartyService";
		
		
		public static String GetProfileDataWSDL = "https://ccre.fa.us6.oraclecloud.com/foundationParties/PersonService?WSDL";
		public static String GetProfileDataActionURL = "https://ccre.fa.us6.oraclecloud.com:443/crmService/FoundationPartiesPersonService";
		
		public static String SalesCustomObjectServiceWSDL = "https://ccre.fa.us6.oraclecloud.com:443/opptyMgmtExtensibility/SalesCustomObjectService?WSDL";	//Stay Details	//Login	//HotelCode
		public static String SalesCustomObjectServiceAction = "https://ccre.fa.us6.oraclecloud.com:443/opptyMgmtExtensibility/SalesCustomObjectService";	//Stay Details	//Login	//HotelCode
		
		public static String RestGetReservationUrl = "https://ccre.fa.us6.oraclecloud.com:443/crmCommonApi/resources/latest/Reservation_c?";
		
		/**MDM**/
		
		
		public static String GET_ALL_PRIVILEGES_EXPIRED ="https://tajoicprod-bmsvb0wsgm8n-bo.integration.ocp.oraclecloud.com:443/ic/api/integration/v1/flows/rest/GET_ALL_PRIVIL_WITH_EXPIRE/1.0/privileges/";
		
		/**ICS**/
	/* PROD */
		/*
		public static String GetMemberDataURL = "https://tajprodics-a455764.integration.us2.oraclecloud.com/integration/flowapi/rest/MEMBERQUERYWITHMEMBERNUMBER/v01/MemberQueryMN";
		
		public static String PayUsingPointsURL = "https://tajprodics-a455764.integration.us2.oraclecloud.com/integration/flowapi/rest/REDEEM_POINTS_WEBSITE/v01/RedeemPointsThroughWebsite";
		
		public static String GiftCardBatchNumberURL = "https://tajprodics-a455764.integration.us2.oraclecloud.com/integration/flowapi/rest/QC_INTIALIZE/v01/initialize";
		
		public static String GiftCardBalanceEnquiryURL = "https://tajprodics-a455764.integration.us2.oraclecloud.com/integration/flowapi/rest/GC_BALANCE_ENQUIRY/v01/balanceenquiry";
		
		public static String PayUsingGiftCardURL = "https://tajprodics-a455764.integration.us2.oraclecloud.com/integration/flowapi/rest/QC_GIFT_CARD_REDEEM/v01/redeem";
		
		public static String SendOTPURL = "https://tajprodics-a455764.integration.us2.oraclecloud.com/integration/flowapi/rest/SYZYGY_MWUI_OTP/v01/SyzygyMWUIOTP";

		public static String ValidateOTPURL = "https://tajprodics-a455764.integration.us2.oraclecloud.com/integration/flowapi/rest/SYZYGY_VALIDA_DYNAMI_ACCESS_CODE/v01/ValidateDynamicAccessCode";
		
		public static String AvailVoucherURL = "https://tajprodics-a455764.integration.us2.oraclecloud.com/integration/flowapi/rest/VOUCHER_OPERATION_WEBSITE/v01/VoucherOperation";
		
		public static String GetVouchersURL = "https://tajprodics-a455764.integration.us2.oraclecloud.com/integration/flowapi/rest/VOUCHER_OPERATION_WEBSITE/v01/VoucherOperation";
		
		public static String GetMemberprofileInfo = "https://tajprodics-a455764.integration.us2.oraclecloud.com/integration/flowapi/rest/UPDATE_MEMBER_ROFILE/v01/MemberProfileOperation";
		
		public static String SiebelCurrencyConverter = "https://tajprodics-a455764.integration.us2.oraclecloud.com/integration/flowapi/rest/IHCL_CURRENCY_CONVERTER/v01/CurrecnyConverter";
		
		public static String OfferQueryURL = "https://tajprodics-a455764.integration.us2.oraclecloud.com/integration/flowapi/rest/QUERYOFFER/v01/OfferQuery";
		
		public static String ForgotPasswordOTPURL = "https://tajprodics-a455764.integration.us2.oraclecloud.com/integration/flowapi/rest/SYZYGYFORGOTPASSWORD/v01/ForgotPassword";
		*/
		
	/* TEST */
//		public static String GetMemberDataURL = "https://tajics-a455764.integration.us2.oraclecloud.com/integration/flowapi/rest/MEMBERQUERYWITHMEMBERNUMBER/v01/MemberQueryMN";
		//TCP
		//public static String GetMemberDataURL = "https://tajprodics-a455764.integration.us2.oraclecloud.com/integration/flowapi/rest/TCPAPISERVICES/v01/fetchcustomer";
		public static String GetMemberDataURL = "https://tajoicprod-bmsvb0wsgm8n-bo.integration.ocp.oraclecloud.com/ic/api/integration/v1/flows/rest/TCPAPISERVICES/1.0/fetchcustomer";
		
//		public static String PayUsingPointsURL = "https://tajics-a455764.integration.us2.oraclecloud.com/integration/flowapi/rest/REDEEM_POINTS_WEBSITE/v01/RedeemPointsThroughWebsite";
		//TCP
		//public static String PayUsingPointsURL = "https://tajprodics-a455764.integration.us2.oraclecloud.com/integration/flowapi/rest/TCPLOYALTYREDEEMPOINTSPOS/v01/redeemPoints";
		public static String PayUsingPointsURL = "https://tajoicprod-bmsvb0wsgm8n-bo.integration.ocp.oraclecloud.com/ic/api/integration/v1/flows/rest/TCPLOYALTYREDEEMPOINTSPOS/1.0/redeemPoints";
		
		//public static String validateCardURL = "https://tajprodics-a455764.integration.us2.oraclecloud.com/integration/flowapi/rest/CARDVALIDATION/v01/cardvalidation";
		public static String validateCardURL = "https://tajoicprod-bmsvb0wsgm8n-bo.integration.ocp.oraclecloud.com/ic/api/integration/v1/flows/rest/CARDVALIDATION/1.0/cardvalidation";
		
		//public static String GiftCardBatchNumberURL = "https://tajprodics-a455764.integration.us2.oraclecloud.com/integration/flowapi/rest/QC_INTIALIZE/v01/initialize";
		public static String GiftCardBatchNumberURL = "https://tajoicprod-bmsvb0wsgm8n-bo.integration.ocp.oraclecloud.com/ic/api/integration/v1/flows/rest/QC_INTIALIZE/1.0/initialize";
		
		//public static String GiftCardBalanceEnquiryURL = "https://tajprodics-a455764.integration.us2.oraclecloud.com/integration/flowapi/rest/GC_BALANCE_ENQUIRY/v01/balanceenquiry";
		public static String GiftCardBalanceEnquiryURL = "https://tajoicprod-bmsvb0wsgm8n-bo.integration.ocp.oraclecloud.com/ic/api/integration/v1/flows/rest/GC_BALANCE_ENQUIRY/1.0/balanceenquiry";
		
		//public static String PayUsingGiftCardURL = "https://tajprodics-a455764.integration.us2.oraclecloud.com/integration/flowapi/rest/QC_GIFT_CARD_REDEEM/v01/redeem";
		public static String PayUsingGiftCardURL = "https://tajoicprod-bmsvb0wsgm8n-bo.integration.ocp.oraclecloud.com/ic/api/integration/v1/flows/rest/QC_GIFT_CARD_REDEEM/1.0/redeem";
		
//		public static String SendOTPURL = "https://tajics-a455764.integration.us2.oraclecloud.com/integration/flowapi/rest/SYZYGY_MWUI_OTP/v01/SyzygyMWUIOTP";
		//TCP
		//public static String SendOTPURL = "https://tajprodics-a455764.integration.us2.oraclecloud.com/integration/flowapi/rest/TCPSERVICELOYALTYVALIDATEPOINTS/v01/validatePoints";
		public static String SendOTPURL = "https://tajoicprod-bmsvb0wsgm8n-bo.integration.ocp.oraclecloud.com/ic/api/integration/v1/flows/rest/TCPSERVICELOYALTYVALIDATEPOINTS/1.0/validatePoints";
		
		
		//check this service name
//		public static String ValidateOTPURL = "https://tajprodics-a455764.integration.us2.oraclecloud.com/integration/flowapi/rest/SYZYGY_VALIDA_DYNAMI_ACCESS_CODE/v01/ValidateDynamicAccessCode";
		public static String ValidateOTPURL = "https://tajoicprod-bmsvb0wsgm8n-bo.integration.ocp.oraclecloud.com/ic/api/integration/v1/flows/rest/SYZYGY_VALIDA_DYNAMI_ACCESS_CODE/1.0/ValidateDynamicAccessCode";
		
//		public static String AvailVoucherURL = "https://tajprodics-a455764.integration.us2.oraclecloud.com/integration/flowapi/rest/VOUCHER_OPERATION_WEBSITE/v01/VoucherOperation";
		public static String AvailVoucherURL = "https://tajoicprod-bmsvb0wsgm8n-bo.integration.ocp.oraclecloud.com/ic/api/integration/v1/flows/rest/VOUCHER_OPERATION_WEBSITE/1.0/VoucherOperation";
		
//		public static String GetVouchersURL = "https://tajprodics-a455764.integration.us2.oraclecloud.com/integration/flowapi/rest/VOUCHER_OPERATION_WEBSITE/v01/VoucherOperation";
		public static String GetVouchersURL = "https://tajoicprod-bmsvb0wsgm8n-bo.integration.ocp.oraclecloud.com/ic/api/integration/v1/flows/rest/VOUCHER_OPERATION_WEBSITE/1.0/VoucherOperation";
		
//		public static String GetMemberprofileInfo = "https://tajprodics-a455764.integration.us2.oraclecloud.com/integration/flowapi/rest/UPDATE_MEMBER_ROFILE/v01/MemberProfileOperation";
		public static String GetMemberprofileInfo = "https://tajoicprod-bmsvb0wsgm8n-bo.integration.ocp.oraclecloud.com/ic/api/integration/v1/flows/rest/UPDATE_MEMBER_ROFILE/1.0/MemberProfileOperation";
		
//		public static String SiebelCurrencyConverter = "https://tajprodics-a455764.integration.us2.oraclecloud.com/integration/flowapi/rest/IHCL_CURRENCY_CONVERTER/v01/CurrecnyConverter";
		public static String SiebelCurrencyConverter = "https://tajoicprod-bmsvb0wsgm8n-bo.integration.ocp.oraclecloud.com:443/ic/api/integration/v1/flows/rest/SIEBEL_EXCHANGE_RATE/1.0/v1/pos/frontend/exchangeRate";
		
		//public static String OfferQueryURL = "https://tajprodics-a455764.integration.us2.oraclecloud.com/integration/flowapi/rest/QUERYOFFER/v01/OfferQuery";
		public static String OfferQueryURL = "https://tajoicprod-bmsvb0wsgm8n-bo.integration.ocp.oraclecloud.com/ic/api/integration/v1/flows/rest/QUERYOFFER/1.0/OfferQuery";
		
		//public static String ForgotPasswordOTPURL = "https://tajprodics-a455764.integration.us2.oraclecloud.com/integration/flowapi/rest/SYZYGYFORGOTPASSWORD/v01/ForgotPassword";
		public static String ForgotPasswordOTPURL = "https://tajoicprod-bmsvb0wsgm8n-bo.integration.ocp.oraclecloud.com/ic/api/integration/v1/flows/rest/SYZYGYFORGOTPASSWORD/1.0/ForgotPassword";
		
		
		
		/**ICS**/
		
		public static String GET_ALL_PRIVILEGES ="https://tajoicprod-bmsvb0wsgm8n-bo.integration.ocp.oraclecloud.com:443/ic/api/integration/v1/flows/rest/GET_ALL_PRIVILEGES/1.0/privileges/";
		public static String AVAIL_PRIVILEGE = "https://tajoicprod-bmsvb0wsgm8n-bo.integration.ocp.oraclecloud.com:443/ic/api/integration/v1/flows/rest/AVAIL_PRIVILEGE/1.0/v1/bits/";
		public static String CDM_URL = "https://ccre.fa.us6.oraclecloud.com:443";
		public static String GENERATE_OTP = "https://tajoicprod-bmsvb0wsgm8n-bo.integration.ocp.oraclecloud.com:443/ic/api/integration/v1/flows/rest/GENERATE_OTP_1WAY_NEW/1.0/v1/members/";
		public static String fetchCustomerOffersByStatus = "https://tajoicprod-bmsvb0wsgm8n-bo.integration.ocp.oraclecloud.com:443/ic/api/integration/v1/flows/rest/IHCLOFFERS_FETCHCUSTOMEROFF/1.0/v1/offerPOS/fetchCustomerOffersByStatus";
		public static String getRedemptionDetails = "https://tajoicprod-bmsvb0wsgm8n-bo.integration.ocp.oraclecloud.com:443/ic/api/integration/v1/flows/rest/IHCL_GETOFFERSDESCRIP/1.0/v1/offerPOS/getOffersDescriptionDetails";
		public static String OfferDetails = "https://tajoicprod-bmsvb0wsgm8n-bo.integration.ocp.oraclecloud.com:443/ic/api/integration/v1/flows/rest/IHCLOFFERS_OFFERDETAILS/1.0/v1/pos/offerDetails";
		public static String redeem = "https://tajoicprod-bmsvb0wsgm8n-bo.integration.ocp.oraclecloud.com:443/ic/api/integration/v1/flows/rest/IHCLOFFERS_REDEEMAPI/1.0/v1/pos/redeem";
		public static String TCPSERVICEGENERATEOTP = "https://tajoicprod-bmsvb0wsgm8n-bo.integration.ocp.oraclecloud.com/ic/api/integration/v1/flows/rest/TCPSERVICEGENERATEOTP/1.0/generateotp";
		public static String TCP_MUI_VALIDATEREDEEM = "https://tajoicprod-bmsvb0wsgm8n-bo.integration.ocp.oraclecloud.com/ic/api/integration/v1/flows/rest/TCP_MUI_VALIDATERE/1.0/v1/pos/validateotp/redeem";
		
		//testAPIs
		//public static String redeem = "https://tajoicprod-bmsvb0wsgm8n-bo.integration.ocp.oraclecloud.com:443/ic/api/integration/v1/flows/rest/IHCLOFFERS_REDEEMAPI/1.0/v1/pos/redeem";
		//public static String TCPSERVICEGENERATEOTP = "https://tajoicprod-bmsvb0wsgm8n-bo.integration.ocp.oraclecloud.com/ic/api/integration/v1/flows/rest/TCPSERVICEGENERATEOTP/1.0/generateotp";
		//public static String TCP_MUI_VALIDATEREDEEM = "https://tajoicprod-bmsvb0wsgm8n-bo.integration.ocp.oraclecloud.com/ic/api/integration/v1/flows/rest/TCP_MUI_VALIDATERE/1.0/v1/pos/validateotp/redeem";
		
		
		public static String QUERYBITS = "https://tajoicprod-bmsvb0wsgm8n-bo.integration.ocp.oraclecloud.com:443/ic/api/integration/v1/flows/rest/QUERYBITS/1.0/v1/bits/";
	
	public Configuration()
	{
		hotelList();
		GiftCardPropertyMapping giftCardPropertyMapping = new GiftCardPropertyMapping();
		giftCardPropertyMapping.setMapping();
	}
	
	public String getInvoices(String ResID, String OWSProperty, String ReservationStatus)
	{
		
		String responce = "";
		
		//String test = GetReservationData.SendEmailAlert(ResID , OWSProperty, "Fetch Invoices");//remove after testing;
		//if(true)//totest
		if(ReservationStatus.equalsIgnoreCase("INHOUSE") || ReservationStatus.equalsIgnoreCase("DUEOUT"))
		{
		
			ConfigPayloads payloads = new ConfigPayloads();
			
			String payload = payloads.getInvoicesPayload(ResID, OWSProperty);
			
			try{
				BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + ResID+".txt",true));
				
				writer.write("\nFetch Invoices Request payload: \n" + payload + "\n\n");
				writer.write((new Date()).toString());
				writer.close();
				
			} catch(Exception e)
			{
				e.printStackTrace();
			}
			
			System.out.println("Payload: \n" + payload);
			
			String WSDL = URLConfig.getInvoiceWSDL(OWSProperty);
			String Action = URLConfig.getInvoiceActionUrl(OWSProperty);
			
			String userName = Configuration.MDMUsername;
			String password = Configuration.MDMPassword;
			
			SoapExecutor soapExecutor = new SoapExecutor(WSDL);
			
			responce = soapExecutor.executeRequest(userName, password, Action,payload);			
			
			if(URLConfig.owsOperaCentralOperaCloud(OWSProperty)){
				responce = ReplaceNameSpacesFetchInvoice(responce);	
			}
			
			try{
				BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + ResID+".txt",true));
				
				writer.write("\nFetch Invoices Response: \n" + responce + "\n\n");
				writer.write((new Date()).toString());
				writer.close();
				
			} catch(Exception e)
			{
				e.printStackTrace();
			}
			if(responce.contains("The timeout period elapsed prior to obtaining a connection from the pool")) {
				
				try{		     
					BufferedWriter writer2 = new BufferedWriter(new FileWriter(Configuration.logLoc +"TimeOutErrorLogs/"+OWSProperty+"_"+ResID+".txt",true));
					
					writer2.write("\nFetch Invoices Response: \n" + responce + "\n\n");
					writer2.write((new Date()).toString());
					writer2.close();
					
				} catch(Exception e)
				{
					e.printStackTrace();
				}
			}else if(responce.contains("Error 503--Service Unavailable")  || responce.contains("Service Unavailable") || responce.contains("Error 503")  || responce.contains("Error 503--Service Unavailable")) {
				
				
				
				String EmailStatus = GetReservationData.SendEmailAlert(ResID , OWSProperty, "Fetch Invoices");
				
				
					
						try{		     
				BufferedWriter writer1 = new BufferedWriter(new FileWriter(Configuration.logLoc +"ErrorLogs/"+ ResID+".txt",true));
				
				writer1.write("\nFetch Invoices Response:\n" + responce + "\n\n");
				writer1.write((new Date()).toString());
				writer1.close();
				
			} catch(Exception e)
			{
				e.printStackTrace();
			}
			}
		} else {
			responce = "<env:Envelope xmlns:env=\"http://schemas.xmlsoap.org/soap/envelope/\"><env:Header><wsse:Security env:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\"><wsu:Timestamp xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\" wsu:Id=\"Timestamp-ecnzeqjvs6alRtUDAhvvMw22\"><wsu:Created>2019-12-02T07:25:00Z</wsu:Created><wsu:Expires>2019-12-02T07:30:00Z</wsu:Expires></wsu:Timestamp></wsse:Security></env:Header><env:Body><s0:InvoiceResponse xmlns:s0=\"http://webservices.micros.com/og/4.3/ResvAdvanced/\"><s0:HotelReference hotelCode=\"\" chainCode=\"\"/><s0:ReservationID/><s0:ExpectedCharges><s0:TotalCharges currencyText=\"\" decimals=\"\" currencyCode=\"\"/><s0:CurrentBalance currencyText=\"\" decimals=\"\" currencyCode=\"\"/><s0:DailyCharges decimals=\"\" TaxInclusive=\"\" TotalFixedCharges=\"\" TotalTaxesAndFees=\"\" TotalRoomRateAndPackages=\"\"/></s0:ExpectedCharges><s0:Result resultStatusFlag=\"SUCCESS\"><s2:Text xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"><s2:TextElement>No Folio Records Found</s2:TextElement></s2:Text><s2:IDs xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/><s2:OperaErrorCode xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/></s0:Result><s0:Result xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:type=\"s1:GDSResultStatus\" resultStatusFlag=\"\"><s2:Text xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/><s2:IDs xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/><s2:OperaErrorCode xmlns:s2=\"http://webservices.micros.com/og/4.3/Common/\"/><s1:GDSError elementId=\"\" errorCode=\"\" xmlns:s1=\"http://webservices.micros.com/og/4.3/HotelCommon/\"/></s0:Result></s0:InvoiceResponse></env:Body></env:Envelope>";
		}
		return responce;
		
		
	}
	
	
	/*public String getMDMProfileID(String PMSProfileID, HttpServletResponse servletResponse)
	{
		
		ConfigPayloads payloads = new ConfigPayloads();
		
		String getPartyNumberPayload = payloads.getMDMProfileIDPayload(); 
	
		String PartyNumber = "";
		String PartyID = "";
		String WSDL1 = Configuration.MDMProfileWSDL;
		String Action1 = Configuration.MDMProfileActionURL;
		
		String Username = Configuration.MDMUsername;
		String Password = Configuration.MDMPassword;
		
		//String res = dd.getRes();
		   SoapExecutor soapExecutor = new SoapExecutor(WSDL1);
		   String responce = soapExecutor.executeRequest(Username, Password, Action1,getPartyNumberPayload.replace("SalesPartyNumber", PMSProfileID));
		   
		   System.out.println("Find MDM Profile Payload:  \n" + getPartyNumberPayload);
		   
		   System.out.println("Find MDM Profile Response:  \n" + responce);
		   
		   Document doc = soapExecutor.convertStringToDocument(responce);
		   
		   NodeList nList = doc.getElementsByTagName("ns3:result");
		   Element partyEle = (Element) (Node) nList.item(0);

		   PartyNumber = soapExecutor.getValue(partyEle, "ns1:PartyNumber");
		   PartyID = soapExecutor.getValue(partyEle, "ns1:PartyId");
		   
		   if(PartyNumber == "")
			   PartyNumber = "1";
			
			Cookie cMDM = new Cookie("PartyNumber", PartyNumber);
			servletResponse.addCookie(cMDM);
			Cookie cPID = new Cookie("PartyIDRes", PartyID);
			servletResponse.addCookie(cPID);
		   
			System.out.println("MDM Party ID: " + PartyNumber);
		
		return PartyNumber;
	}*/
	
	
	/*
	 * public String getMDMProfileID(String PMSProfileID, HttpServletResponse
	 * servletResponse, String hotelCode, String ReservationNo) {
	 * 
	 * ConfigPayloads payloads = new ConfigPayloads();
	 * 
	 * String getPartyNumberPayload = payloads.getMDMProfileIDPayload();
	 * 
	 * try{ BufferedWriter writer = new BufferedWriter(new
	 * FileWriter(Configuration.logLoc + ReservationNo+".txt",true));
	 * 
	 * writer.write("\nFetch GetMDMProfileID Request payload: \n" +
	 * getPartyNumberPayload.replace("SalesPartyNumber", PMSProfileID) + "\n\n");
	 * writer.write((new Date()).toString()); writer.close();
	 * 
	 * } catch(Exception e) { e.printStackTrace(); }
	 * 
	 * String PartyNumber = ""; String PartyID = ""; String WSDL1 =
	 * Configuration.MDMProfileWSDL; String Action1 =
	 * Configuration.MDMProfileActionURL;
	 * 
	 * String Username = Configuration.MDMUsername; String Password =
	 * Configuration.MDMPassword;
	 * 
	 * 
	 * //String res = dd.getRes(); SoapExecutor soapExecutor = new
	 * SoapExecutor(WSDL1); String responce = soapExecutor.executeRequest(Username,
	 * Password, Action1,getPartyNumberPayload.replace("SalesPartyNumber",
	 * PMSProfileID));
	 * 
	 * // System.out.println("Find MDM Profile Payload:  \n" +
	 * getPartyNumberPayload);
	 * 
	 * // System.out.println("Find MDM Profile Response:  \n" + responce);
	 * 
	 * try{ BufferedWriter writer = new BufferedWriter(new
	 * FileWriter(Configuration.logLoc + ReservationNo+".txt",true));
	 * 
	 * writer.write("\nFetch GetMDMProfileID Response: \n" + responce + "\n\n");
	 * writer.write((new Date()).toString()); writer.close();
	 * 
	 * } catch(Exception e) { e.printStackTrace(); }
	 * 
	 * Document doc = soapExecutor.convertStringToDocument(responce);
	 * 
	 * boolean origBoolean = false;
	 * 
	 * NodeList nList = doc.getElementsByTagName("ns3:result");
	 * 
	 * for(int i = 0 ; i < nList.getLength() ; i++) { Element ele =
	 * (Element)(Node)nList.item(i); String status = soapExecutor.getValue(ele,
	 * "ns1:Status"); if(status.equals("I") || status.equals("M")) continue;
	 * NodeList origNL = ele.getElementsByTagName("ns4:OriginalSystemReference");
	 * for(int j = 0 ; j < origNL.getLength() ; j++) { Element origEle =
	 * (Element)(Node)origNL.item(j); String origSys =
	 * soapExecutor.getValue(origEle, "ns6:OrigSystem"); String origSysRef =
	 * soapExecutor.getValue(origEle, "ns6:OrigSystemReference");
	 * 
	 * String hotelSet = Configuration.hotelList.get(hotelCode); String tempHotelSet
	 * = Configuration.hotelList.get(origSys);
	 * 
	 * 
	 * 
	 * if(origSysRef.equals(PMSProfileID) && tempHotelSet.equals(hotelSet)) {
	 * origBoolean = true; break; } } if(origBoolean == true) { PartyNumber =
	 * soapExecutor.getValue(ele, "ns1:PartyNumber"); PartyID =
	 * soapExecutor.getValue(ele, "ns1:PartyId"); break; } } // if(PartyNumber ==
	 * "") PartyNumber = "1";
	 * 
	 * return PartyNumber; }
	 * 
	 */	
	
	/*protected void getProfileData(String MDMId)
	{
		String findPersonServicePayload = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:typ=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/personService/applicationModule/types/\" xmlns:typ1=\"http://xmlns.oracle.com/adf/svc/types/\"> " + 
				 "  <soapenv:Header/> " + 
				 "  <soapenv:Body> " + 
				 "    <typ:findPerson> " + 
				 "      <typ:findCriteria> " + 
				 "        <typ1:fetchStart>0</typ1:fetchStart> " + 
				 "        <typ1:fetchSize>-1</typ1:fetchSize> " + 
				 "        <typ1:filter> " + 
				 "          <typ1:conjunction>And</typ1:conjunction> " + 
				 "          <typ1:group> " + 
				 "            <typ1:conjunction>And</typ1:conjunction> " + 
				 "            <typ1:upperCaseCompare>false</typ1:upperCaseCompare> " + 
				 "            <typ1:item> " + 
				 "              <typ1:conjunction>And</typ1:conjunction> " + 
				 "              <typ1:upperCaseCompare>false</typ1:upperCaseCompare> " + 
				 "              <typ1:attribute>PartyNumber</typ1:attribute> " + 
				 "              <typ1:operator>=</typ1:operator> " + 
				 "              <typ1:value>"+MDMId+"</typ1:value> " + 
				 "            </typ1:item> " + 
				 "          </typ1:group> " + 
				 "        </typ1:filter> " + 
				 "      </typ:findCriteria> " + 
				 "    </typ:findPerson> " + 
				 "  </soapenv:Body> " + 
				 "</soapenv:Envelope> ";
		
		
		System.out.println("Fetch Profile Payload: \n" + findPersonServicePayload);
		 
	 	String WSDL = "https://ccre-test.crm.us6.oraclecloud.com/foundationParties/PersonService?WSDL";
		String Action = "https://ccre-test.crm.us6.oraclecloud.com:443/crmService/FoundationPartiesPersonService";
		
		String userName = "datacentre";
		String password = "Smile@25";
		
		SoapExecutor soapExecutor = new SoapExecutor(WSDL);
		String responce = soapExecutor.executeRequest(userName, password, Action,findPersonServicePayload);
		
		Document doc = soapExecutor.convertStringToDocument(responce);
		
		
		NodeList nList = doc.getElementsByTagName("ns1:Value");
		Element profileEle = (Element) (Node) nList.item(0);
		if (profileEle == null) {
 			return;
		}

		String FirstName = soapExecutor.getValue(profileEle, "ns1:PersonFirstName");
		String LastName = soapExecutor.getValue(profileEle, "ns1:PersonLastName");
		String Salutation = soapExecutor.getValue(profileEle, "ns1:PersonPreNameAdjunct");
		
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
		//Email = soapExecutor.getValue(profileEle, "ns5:EmailAddress");
		//Phone = soapExecutor.getValue(profileEle, "ns5:MobileNumber");
		
		NodeList nListEmail = doc.getElementsByTagName("ns1:Email");
		for(int i=0; i<nListEmail.getLength(); i++)
		{
			Element eleEmail = (Element) nListEmail.item(i);
			String isActive = soapExecutor.getValue(eleEmail, "ns5:Status");
			String isPrimary = soapExecutor.getValue(eleEmail, "ns5:PrimaryFlag");
			
			if(isActive.equalsIgnoreCase("A") && isPrimary.equalsIgnoreCase("true"))
			{
				String Email = soapExecutor.getValue(eleEmail, "ns5:EmailAddress");
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
				System.out.println("Phone Type: " + soapExecutor.getValue(elePhone, "ns5:PhoneLineType"));
				System.out.println("Phone ID: " + soapExecutor.getValue(elePhone, "ns5:ContactPointId"));
			}
			
		}
		
		//Owner = soapExecutor.getValue(profileEle, "ns5:OwnerName");
		String PartyId = soapExecutor.getValue(profileEle, "ns1:PartyId");
		String PartyNumber = soapExecutor.getValue(profileEle, "ns1:PartyNumber");

		//Category = soapExecutor.getValue(profileEle, "ns5:PersonDEO_Category_c");
		//ContactLevel = soapExecutor.getValue(profileEle, "ns5:PersonDEO_ContactLevel_c");
		//LoyaltyMembership = soapExecutor.getValue(profileEle, "ns5:PersonDEO_LoyaltyMembership_c");
		//LoyaltyMembershipNumber = soapExecutor.getValue(profileEle, "ns5:PersonDEO_LoyaltyMembershipNumber_c");
		
		
		try
		 {	
		 NodeList nodeList = ((Element) doc.getElementsByTagName("ns1:Value").item(0)).getElementsByTagName("ns1:LoyaltyMembershipsCollection_c");
			
			for(int i=0; i<nodeList.getLength(); i++)
			{
				Element ele = (Element) nodeList.item(i);
				String MembershipType = ele.getElementsByTagName("ns1:MembershipTypeLOV_c").item(0).getTextContent();
				String EnrollNumber_c = "";
				if(MembershipType.equalsIgnoreCase("TIC") || MembershipType.equalsIgnoreCase("Taj InnerCircle") || MembershipType.equalsIgnoreCase("TAJ"))
					EnrollNumber_c = ele.getElementsByTagName("ns1:MembershipCardNo_c").item(0).getTextContent();
			}
		 } catch(Exception e)
		 {
			 
		 }
		
		
		
		
		//Passport = soapExecutor.getValue(profileEle, "ns5:PersonDEO_Passport_c");
		//ChamberMembershipNumber = soapExecutor.getValue(profileEle, "ns5:PersonDEO_ChamberMembershipNumber_c");
		//PANNumber = soapExecutor.getValue(profileEle, "ns5:PersonDEO_PANNumber_c");
		//LegalCompany = soapExecutor.getValue(profileEle, "ns5:PersonDEO_LegalCompany_c");
		//Company = soapExecutor.getValue(profileEle, "ns5:PersonDEO_Company_c");
		//Aadhaar = soapExecutor.getValue(profileEle, "ns5:PersonDEO_AadhaarNumber_c");
		String DateOfBirth = soapExecutor.getValue(profileEle, "ns1:DateOfBirth");

		//parsing the address from the root element
		String Address1 = soapExecutor.getValue(profileEle, "ns1:Address1");
		String Address2 = soapExecutor.getValue(profileEle, "ns1:Address2");
		String Address3 = soapExecutor.getValue(profileEle, "ns1:Address3");
		String Address4 = soapExecutor.getValue(profileEle, "ns1:Address4");
		String city = soapExecutor.getValue(profileEle, "ns1:City");
		String state = soapExecutor.getValue(profileEle, "ns1:State");
		String 	country = soapExecutor.getValue(profileEle, "ns1:Country");
		String 	postal = soapExecutor.getValue(profileEle, "ns1:PostalCode");
		
		

		
		
		
		
		
		
	}*/

	
	public void hotelList()
	{
		hotelList.put("BLRAP","Central");
		hotelList.put("DELTA","Central");
		//hotelList.put("NAGBP","NAGBP");
		//hotelList.put("JLRBT","JLRBT");
		//hotelList.put("JLRMK","JLRMK");
		hotelList.put("MEYMS","MEYMS");
		//hotelList.put("HJRPG","HJRPG");
		hotelList.put("LONSJ","LONSJ");
		hotelList.put("51BG","51BG");
		hotelList.put("HYDTB","Central");
		hotelList.put("CMBTE","CMBTE");
		hotelList.put("BOSTB","BOSTB");
		hotelList.put("SFOCP","SFOCP");
		hotelList.put("CPTCT","CPTCT");
		hotelList.put("IXCTC","Central");
		hotelList.put("MLETC","MLETC");
		hotelList.put("DXBTD","DXBTD");		
		hotelList.put("MLETE","MLETE");
		hotelList.put("DELTM","Central");
		hotelList.put("DELTP","Central");
		hotelList.put("TPHLU","TPHLU");
		//hotelList.put("LUNTP","LUNTP");
		hotelList.put("CMBTS","CMBTS");
		hotelList.put("DELSU","DELSU");
		hotelList.put("PBHTT","PBHTT");
		hotelList.put("STVGH","STVGH");
		hotelList.put("NAGGO","NAGGO");
		hotelList.put("CMBTA","CMBTA");
		hotelList.put("VTZTR","Central");
		//hotelList.put("DELDA","DELDA");
		hotelList.put("NYCTP","NYCTP");
		hotelList.put("IXUTR","Central");
		hotelList.put("TRVTR","Central");
		//hotelList.put("DELDW","DELDW");
		hotelList.put("LGKTR","LGKTR");
		/*hotelList.put("JAIML","JAIML");*/
		//hotelList.put("DXBJL","DXBJL");		//Jumeira Lake
		hotelList.put("IDS6825", "IDS6825");	//Taj Vivanta Kathmandu
		hotelList.put("IDS7520", "IDS7520");
        hotelList.put("IDS7574", "IDS7574");
        hotelList.put("IDS7575", "IDS7575");
        hotelList.put("IDS7565", "IDS7565");
        hotelList.put("IDS7522", "IDS7522");
        hotelList.put("IDS7716", "IDS7716");
        hotelList.put("IDS7728", "IDS7728");
        hotelList.put("IXBCK", "IXBCK");
        hotelList.put("AMDTS", "AMDTS");
        hotelList.put("MAAWM", "MAAWM");
        hotelList.put("MLETE", "MLETE");
        
        
        
		hotelList.put("IDS7747", "IDS7747");
		hotelList.put("IDS7851", "IDS7851");
		hotelList.put("IDS7859", "IDS7859");
		hotelList.put("IDS7841", "IDS7841");
		hotelList.put("IDS7846", "IDS7846");
		hotelList.put("IDS7915", "IDS7915");
		hotelList.put("IDS7958", "IDS7958");
		hotelList.put("IDS7983", "IDS7983");
		hotelList.put("IDS7991", "IDS7991");
		hotelList.put("IDS7990", "IDS7990");
		hotelList.put("TRVVT", "TRVVT");
		hotelList.put("DEDHW", "DEDHW");
		hotelList.put("BBIVB", "BBIVB");
		hotelList.put("BHOTL","BHOTL");
		hotelList.put("GOIVM", "GOIVM");
		hotelList.put("IDS8049", "IDS8049");
		hotelList.put("IDS8044", "IDS8044");
		hotelList.put("IDS8051", "IDS8051");
		hotelList.put("IDS8066", "IDS8066");
		hotelList.put("IDS8097", "IDS8097");
		hotelList.put("IDS8099", "IDS8099");
		hotelList.put("IDS8111", "IDS8111");
		hotelList.put("IDS8095", "IDS8095");
		hotelList.put("IDS8100", "IDS8100");
		hotelList.put("IDS8101", "IDS8101");
		hotelList.put("IDS8096", "IDS8096");
		hotelList.put("IDS8110", "IDS8110");
		hotelList.put("IDS8098", "IDS8098");
		hotelList.put("IDS8050", "IDS8050");
		hotelList.put("IDS8149", "IDS8149");
		hotelList.put("IDS8130", "IDS8130");
		hotelList.put("IDS8147", "IDS8147");
		hotelList.put("PYGVS", "PYGVS");
		//hotelList.put("DXBTE", "DXBTE");
		//hotelList.put("CCURK", "CCURK");
		hotelList.put("BOMNT", "BOMNT");
		hotelList.put("CCUNT","CCUNT");
		hotelList.put("AMDVA","AMDVA");
		hotelList.put("IXJVK","IXJVK");
		hotelList.put("CCJTW","CentralOCI");//taj Wayanad
		hotelList.put("SHLVS","CentralOCI");// taj Shillong
		hotelList.put("JAITA","CentralOCI");//taj amar
		hotelList.put("DHMNM","CentralOCI");
		hotelList.put("LKOJM","CentralOCI");
		hotelList.put("KUUBM","CentralOCI");
		hotelList.put("GOXYH","CentralOCI");
		hotelList.put("IDS30002","IDS30002");//ids property test invoice?
		hotelList.put("AMDTG","CentralOCI");
		hotelList.put("IXJVJ","CentralOCI");
		hotelList.put("BBITC","CentralOCI");
		hotelList.put("IDRWC","CentralOCI");
		hotelList.put("PYGTG","CentralOCI");
		hotelList.put("CCUTK","CentralOCI");
		hotelList.put("TEZVT","CentralOCI");
		hotelList.put("JSAGP","CentralOCI");
	
		hotelList.put("TIRBT","CentralOCI");
		hotelList.put("COKSM","CentralOCI");
		hotelList.put("IXWVJ","CentralOCI");
		hotelList.put("PNQFM","CentralOCI");  //Fountain Mahabaleshwar – IHCL SeleQtions
		hotelList.put("JAIRG","CentralOCI");
		hotelList.put("PATCP","CentralOCI");  //Taj City Center Patna
		hotelList.put("IXEGB","CentralOCI");  //IHCL SeleQtions Sacred Bay Bekal
		hotelList.put("GOITE","Oracle Cloud Central");
		hotelList.put("GOIVI","Oracle Cloud Central");
		hotelList.put("GOIFA","Oracle Cloud Central");
		hotelList.put("GOITH","Oracle Cloud Central");
		hotelList.put("GOITC","Oracle Cloud Central");
        hotelList.put("GOICD","Oracle Cloud Central");
        hotelList.put("BOMTP","Oracle Cloud Central");
		hotelList.put("BOMWM","Oracle Cloud Central");
        hotelList.put("ISKTR","Oracle Cloud Central");
        hotelList.put("BOMTS","Oracle Cloud Central");
        hotelList.put("PNQBD","Oracle Cloud Central");
        hotelList.put("PNQHI","Oracle Cloud Central");
        hotelList.put("IXUTR","Oracle Cloud Central");
        hotelList.put("BLRIT","Oracle Cloud Central");
        hotelList.put("BLRGH","Oracle Cloud Central");
        hotelList.put("BLRTB","Oracle Cloud Central");
        hotelList.put("BLRYE","Oracle Cloud Central");
		hotelList.put("BLRTR","Oracle Cloud Central");
		hotelList.put("BLRWE","Oracle Cloud Central");
		hotelList.put("CMBTS","Oracle Cloud Central");
		hotelList.put("CMBTE","Oracle Cloud Central");
		hotelList.put("CMBTA","Oracle Cloud Central");
		hotelList.put("MLETC","Oracle Cloud Central");
		hotelList.put("MLETE","Oracle Cloud Central");
		
		
        hotelList.put("BLRTG","Oracle Cloud Central");
        hotelList.put("IXECO","Oracle Cloud Central");
        hotelList.put("GOILE","Oracle Cloud Central");
        hotelList.put("IXEMH","Oracle Cloud Central");
		hotelList.put("IXEVI","Oracle Cloud Central");
		hotelList.put("MAAFC","Oracle Cloud Central");
		hotelList.put("MAACN","Oracle Cloud Central");
		hotelList.put("MAATC","Oracle Cloud Central");
		hotelList.put("MAAGH","Oracle Cloud Central");
		hotelList.put("MAAMR","Oracle Cloud Central");
		hotelList.put("TIRTT","Oracle Cloud Central");
		hotelList.put("CJBVI","Oracle Cloud Central");
		hotelList.put("IXMTG","Oracle Cloud Central");
		hotelList.put("CJBSH","Oracle Cloud Central");
		hotelList.put("CJBTG","Oracle Cloud Central");
		hotelList.put("BOMLE","Oracle Cloud Central");
		hotelList.put("BOMTM","Oracle Cloud Central");
		hotelList.put("BOMPA","Oracle Cloud Central");
		hotelList.put("COKTR","Oracle Cloud Central");
		hotelList.put("COKTM","Oracle Cloud Central");
		hotelList.put("CCJTR","Oracle Cloud Central");
		hotelList.put("COKTG","Oracle Cloud Central");
		hotelList.put("TRVGR","Oracle Cloud Central");
		hotelList.put("TRVTG","Oracle Cloud Central");
		hotelList.put("AGRCC","Oracle Cloud Central");
		hotelList.put("AGRTV","Oracle Cloud Central");
		hotelList.put("VNSTG","Oracle Cloud Central");
		hotelList.put("VNSTP","Oracle Cloud Central");
		hotelList.put("GWLUK","Oracle Cloud Central");
		hotelList.put("LKOTR","Oracle Cloud Central");
		hotelList.put("BBITP","Oracle Cloud Central");
		hotelList.put("UDRRK","Oracle Cloud Central");
		hotelList.put("BDQTR","Oracle Cloud Central");
		hotelList.put("DIUGF","Oracle Cloud Central");
		hotelList.put("JPRDR","Oracle Cloud Central");
		hotelList.put("COKIC","Oracle Cloud Central");
		hotelList.put("JAIJM","Oracle Cloud Central");
		hotelList.put("JAISM","Oracle Cloud Central");
		hotelList.put("JAIRP","Oracle Cloud Central");
		hotelList.put("JAIAJ","Oracle Cloud Central");
		hotelList.put("PGHCO","Oracle Cloud Central");
		hotelList.put("SLVTT","Oracle Cloud Central");
		hotelList.put("DEDTR","Oracle Cloud Central");
		hotelList.put("DEDAK","Oracle Cloud Central");
		hotelList.put("IXCTC","Oracle Cloud Central");
		hotelList.put("UDRTA","Oracle Cloud Central");
		hotelList.put("ATQTA","Oracle Cloud Central");
		hotelList.put("UDRTL","Oracle Cloud Central");
		hotelList.put("UDRFP","Oracle Cloud Central");
		hotelList.put("HYDTK","Oracle Cloud Central");
		hotelList.put("HYDFP","Oracle Cloud Central");
		hotelList.put("PGHNH","Oracle Cloud Central");
		hotelList.put("DEDTD","Oracle Cloud Central");
		hotelList.put("DELTP","Oracle Cloud Central");
		hotelList.put("DELTA","Oracle Cloud Central");
		hotelList.put("DELTM","Oracle Cloud Central");
		hotelList.put("HYDVI","Oracle Cloud Central");
		hotelList.put("HYDTD","Oracle Cloud Central");
		hotelList.put("DELCP","Oracle Cloud Central");
		hotelList.put("DELGU","Oracle Cloud Central");
		hotelList.put("VGAGH","Oracle Cloud Central");
		hotelList.put("SXRSR","Oracle Cloud Central");
		hotelList.put("DELSU","Oracle Cloud Central");//stadlone
		hotelList.put("DELDA","Oracle Cloud Central");
		hotelList.put("DELDW","Oracle Cloud Central");
		hotelList.put("BOMTT","Oracle Cloud Central");
		hotelList.put("IXZTE","Oracle Cloud Central");
		hotelList.put("JDHTH","Oracle Cloud Central");
		hotelList.put("GAUTG","Oracle Cloud Central");
		hotelList.put("JAIML","Oracle Cloud Central");
		hotelList.put("JDHUB","Oracle Cloud Central");
		hotelList.put("CCUBK","Oracle Cloud Central");
		hotelList.put("CCUEM","Oracle Cloud Central");
		hotelList.put("DIUFH","Oracle Cloud Central");
		hotelList.put("DXBJL","Oracle Cloud Central");
		hotelList.put("DXBTD","Oracle Cloud Central");
		hotelList.put("DXBTE","Oracle Cloud Central");
		hotelList.put("DELTC","Oracle Cloud Central");
		hotelList.put("CNNGC","Oracle Cloud Central");
		hotelList.put("NAGBV","Oracle Cloud Central");
		hotelList.put("JLRMK","Oracle Cloud Central");
		hotelList.put("JLRBT","Oracle Cloud Central");
		hotelList.put("HJRPG","Oracle Cloud Central");
		hotelList.put("AGXBP","Oracle Cloud Central");
		hotelList.put("AGXBR","Oracle Cloud Central");
		hotelList.put("BOMTA","Oracle Cloud Central");
		hotelList.put("DIUGD","Oracle Cloud Central");
		hotelList.put("BOMTH","Oracle Cloud Central");
		hotelList.put("GOIGP","Oracle Cloud Central");
		hotelList.put("CCUGK","Oracle Cloud Central");
		hotelList.put("JAIGH","Oracle Cloud Central");
		hotelList.put("JLRBA","Oracle Cloud Central");
		hotelList.put("PGHCT","Oracle Cloud Central");
		hotelList.put("AMDDA","Oracle Cloud Central");
		hotelList.put("DECDE","Oracle Cloud Central");
		hotelList.put("DHMBC","Oracle Cloud Central");
		hotelList.put("IXBMH","Oracle Cloud Central");
		hotelList.put("JAISP","Oracle Cloud Central");
		hotelList.put("JDHBH","Oracle Cloud Central");
		hotelList.put("PGHJH","Oracle Cloud Central");
		hotelList.put("JAIUD","Oracle Cloud Central");
		hotelList.put("DEDJO","Oracle Cloud Central");
		hotelList.put("VNSVA","Oracle Cloud Central");
		hotelList.put("UDRCA","Oracle Cloud Central");
		hotelList.put("CDRAR","Oracle Cloud Central");
		hotelList.put("AMDGA","Oracle Cloud Central");
		hotelList.put("UDRLB","Oracle Cloud Central");
		hotelList.put("BDQEN","Oracle Cloud Central");
		hotelList.put("DEDHN","Oracle Cloud Central");
		hotelList.put("COKVA","Oracle Cloud Central");
		hotelList.put("VNSAV","Oracle Cloud Central");
		hotelList.put("BDQNS","Oracle Cloud Central");
		hotelList.put("PBHTP","Oracle Cloud Central");
		hotelList.put("PBHGR","Oracle Cloud Central");
		hotelList.put("FRATA","Oracle Cloud Central");
		hotelList.put("DEDGD","Oracle Cloud Central");
		hotelList.put("MAAWM","Oracle Cloud Central");
		hotelList.put("JAIGA","Oracle Cloud Central");
		hotelList.put("BHUGB","Oracle Cloud Central");
		hotelList.put("JAIGR","Oracle Cloud Central");
		hotelList.put("BDQGV","Oracle Cloud Central");
		hotelList.put("AMDGK","Oracle Cloud Central");
		hotelList.put("DEDTH","Oracle Cloud Central");
		hotelList.put("KNUIS","Oracle Cloud Central");
		hotelList.put("DELVV","Oracle Cloud Central");
		hotelList.put("UDRPJ","Oracle Cloud Central");
		hotelList.put("JAIBR","Oracle Cloud Central");
		hotelList.put("JLRSB","Oracle Cloud Central");
		hotelList.put("VNSBR","Oracle Cloud Central");
		hotelList.put("PGHBR","Oracle Cloud Central");
		hotelList.put("UDRPJ","Oracle Cloud Central");
		hotelList.put("GOXBP","Oracle Cloud Central");
		hotelList.put("DHMBD","Oracle Cloud Central");
		hotelList.put("JDHBL","Oracle Cloud Central");
		hotelList.put("IXYGK","Oracle Cloud Central");
		hotelList.put("JAISR","Oracle Cloud Central");
		
		
	
		
		
	}

	public static Boolean getGCENabledProperty(String PropertyCode)
	{
		boolean isEnable = false;
		
		HashMap<String, String>	GCHotel = new HashMap<String,String>();
		GCHotel.put("AGRCC","AGRCC");	//	Taj Hotel & Convention Centre Agra
		GCHotel.put("AGRTV","AGRTV");	//	Tajview, Agra
		GCHotel.put("ATQTA","ATQTA");	//	Taj Swarna Amritsar
		GCHotel.put("BDQTR","BDQTR");	//	Vivanta Vadodara
		GCHotel.put("BLRAP","BLRAP");	//	Ama Plantation Trails
		GCHotel.put("BLRGH","BLRGH");	//	The Gateway Hotel Residency Rd
		GCHotel.put("BLRIT","BLRIT");	//	Vivanta Bengaluru Whitefield
		GCHotel.put("BLRTB","BLRTB");	//	Taj Bangalore Bengaluru
		GCHotel.put("BLRTG","BLRTG");	//	The Gateway Hotel Chikmagalur
		GCHotel.put("BLRTR","BLRTR");	//	Taj M G Road Bengaluru
		GCHotel.put("BLRWE","BLRWE");	//	Taj West End Bengaluru
		GCHotel.put("BLRYE","BLRYE");	//	Taj Yeshwantpur Bengaluru
		GCHotel.put("BOMLE","BOMLE");	//	Taj Lands End
		GCHotel.put("BOMPA","BOMPA");	//	The Taj Mahal Palace
		GCHotel.put("BOMTM","BOMTM");	//	Taj Mahal Tower
		GCHotel.put("BOMTP","BOMTP");	//	President Mumbai
		GCHotel.put("BOMTS","BOMTS");	//	Taj Santacruz Mumbai
		GCHotel.put("BOMWM","BOMWM");	//	Taj Wellington Mews Mumbai
		GCHotel.put("CCJTR","CCJTR");	//	The Gateway Hotel Calicut
		GCHotel.put("CCUBK","CCUBK");	//	Taj Bengal
		GCHotel.put("CCUEM","CCUEM");	//	The Gateway Hotel EM Bypass
		GCHotel.put("CJBSH","CJBSH");	//	Savoy Ooty
		GCHotel.put("CJBTG","CJBTG");	//	The Gateway Hotel Coonoor
		GCHotel.put("CJBVI","CJBVI");	//	Vivanta Coimbatore
		GCHotel.put("COKTG","COKTG");	//	Taj Kumarakom Resort and Spa
		GCHotel.put("COKTM","COKTM");	//	Taj Malabar Resort and Spa
		GCHotel.put("COKTR","COKTR");	//	The Gateway Hotel Marine Drive
		GCHotel.put("DEDTR","DEDTR");	//	Taj Rishikesh Resort & Spa
		GCHotel.put("DELGU","DELGU");	//	Taj City Centre
		GCHotel.put("DELTA","DELTA");	//	Ambassador, New Delhi
		GCHotel.put("DELTM","DELTM");	//	Taj Mahal Hotel New Delhi
		GCHotel.put("DELTP","DELTP");	//	Taj Palace New Delhi
		GCHotel.put("DIUGF","DIUGF");	//	The Gateway Hotel Gir Forest
		GCHotel.put("GAUTG","GAUTG");	//	Vivanta Guwahati
		GCHotel.put("GOICD","GOICD");	//	Cidade De Goa
		GCHotel.put("GOIFA","GOIFA");	//	Taj Fort Aguada Resort and Spa
		GCHotel.put("GOITE","GOITE");	//	Taj Exotica Resort and Spa Goa
		GCHotel.put("GOITH","GOITH");	//	Taj Holiday Village Resort Spa
		GCHotel.put("GOIVI","GOIVI");	//	Vivanta Goa Panaji
		GCHotel.put("GWLUK","GWLUK");	//	Taj Usha Kiran Palace
		GCHotel.put("HYDFP","HYDFP");	//	Taj Falaknuma Palace
		GCHotel.put("HYDTB","HYDTB");	//	Taj Banjara Hyderabad
		GCHotel.put("HYDTD","HYDTD");	//	Taj Deccan Hyderabad
		GCHotel.put("HYDTK","HYDTK");	//	Taj Krishna Hyderabad
		GCHotel.put("HYDVI","HYDVI");	//	Vivanta Hyderabad Begumpet
		GCHotel.put("ISKTR","ISKTR");	//	The Gateway Hotel Ambad Nashik
		GCHotel.put("IXCTC","IXCTC");	//	Taj Chandigarh Chandigarh
		GCHotel.put("IXECO","IXECO");	//	Taj Madikeri Resort and Spa
		GCHotel.put("IXEMH","IXEMH");	//	The Gateway Hotel Old Port Rd
		GCHotel.put("IXEVI","IXEVI");	//	Taj Bekal Resort and Spa
		GCHotel.put("IXMTG","IXMTG");	//	The Gateway Hotel Pasumalai
		GCHotel.put("IXUTR","IXUTR");	//	Vivanta Aurangabad Maharashtra
		GCHotel.put("JAIAJ","JAIAJ");	//	Pratap Mahal, Ajmer
		GCHotel.put("JAIJM","JAIJM");	//	Jai Mahal Palace
		GCHotel.put("JAIRP","JAIRP");	//	Rambagh Palace
		GCHotel.put("JAISM","JAISM");	//	SMS Hotel
		GCHotel.put("JDHTH","JDHTH");	//	Taj Hari Mahal Jodhpur
		GCHotel.put("JDHUB","JDHUB");	//	Umaid Bhawan Palace
		GCHotel.put("LKOTR","LKOTR");	//	Taj Mahal Lucknow
		GCHotel.put("MAACN","MAACN");	//	Taj Connemara, Chennai
		GCHotel.put("MAAFC","MAAFC");	//	Taj Fishermans Cove Resort&Spa
		GCHotel.put("MAAGH","MAAGH");	//	Vivanta Chennai IT Expressway
		GCHotel.put("MAAMR","MAAMR");	//	Taj Club House Chennai
		GCHotel.put("MAATC","MAATC");	//	Taj Coromandel Chennai
		GCHotel.put("PGHCO","PGHCO");	//	Taj Corbett Resort & Spa
		GCHotel.put("PNQBD","PNQBD");	//	Blue Diamond Pune
		GCHotel.put("PNQHI","PNQHI");	//	Vivanta Pune Hinjawadi
		GCHotel.put("SLVTT","SLVTT");	//	Taj Theog Resort and Spa
		GCHotel.put("SXRSR","SXRSR");	//	Vivanta Dal View
		GCHotel.put("TRVGR","TRVGR");	//	The Gateway Hotel Varkala
		GCHotel.put("TRVTG","TRVTG");	//	Taj Green Cove Resort & Spa
		GCHotel.put("TRVTR","TRVTR");	//	Vivanta By Taj Trivandrum
		GCHotel.put("UDRTA","UDRTA");	//	Taj Aravali Resort & Spa
		GCHotel.put("UDRTL","UDRTL");	//	Taj Lake Palace Udaipur
		GCHotel.put("VGAGH","VGAGH");	//	The Gateway Hotel M G Road
		GCHotel.put("VNSTG","VNSTG");	//	Taj Ganges Varanasi
		GCHotel.put("VNSTP","VNSTP");	//	Taj Nadesar Palace
		GCHotel.put("VTZTR","VTZTR");	//	The Gateway Hotel Vizag
		GCHotel.put("NAGBP","NAGBP");	//	Baghvan A Taj Safari
		GCHotel.put("JLRBT","JLRBT");	//	Banjaar Tola Kanha
		GCHotel.put("JLRMK","JLRMK");	//	Mahua Kothi, Bandhavgarh
		GCHotel.put("HJRPG","HJRPG");	//	Pashan Garh Panna
		GCHotel.put("IXZTE","IXZTE");	//	Taj Exotica Resort & Spa
		GCHotel.put("STVGH","STVGH");	//	The Gateway Hotel Athwalines
		GCHotel.put("NAGGO","NAGGO");	//	The Gateway Hotel Balaghat Rd
		GCHotel.put("DELDA","DELDA");	//	The Gateway Resort Damdama
		GCHotel.put("DELDW","DELDW");	//	Vivanta New Delhi Dwarka
		GCHotel.put("JAIML","JAIML");	//	Vivanta Sawai Madhopur Lodge
		GCHotel.put("DELSU","DELSU");	//	Vivanta Surajkund NCR
		GCHotel.put("GOITC","GOITC");    //Taj Hotel Convention Centre Goa
        GCHotel.put("DELCP", "DELCP");  //The Connaught,New Delhi
        GCHotel.put("IXBCK", "IXBCK");  //TAJ CHIA KUTIR RESORTS & SPA, DARJEELING
        GCHotel.put("AMDTS", "AMDTS");  //Taj Skyline Ahmedabad
         //Taj Wellington Mews Chennai  
		GCHotel.put("TRVVT", "TRVVT");//Vivanta Thiruvananthapuram
		GCHotel.put("DEDHW", "DEDHW"); //Pilibhit House IHCL SeleQtions Haridwar  
		GCHotel.put("BBIVB", "BBIVB"); //Vivanta Bhubaneswar
		GCHotel.put("BHOTL","BHOTL"); //  Taj Lakefront Bhopal
		GCHotel.put("GOIVM", "GOIVM");//  Vivanta Goa Miramar
		GCHotel.put("IDS7520","IDS7520");  // AMA Stays & Trails -Cardozo House Goa
		GCHotel.put("IDS7574","IDS7574");  // AMA Stays & Trails - Pathrimanal Villa Alappuzha
		GCHotel.put("IDS7575","IDS7575");  // AMA Stays & Trails - Ambika Vilas Triv&rum
		GCHotel.put("IDS7565","IDS7565");  // AMA Stays & Trails - Rare Earth Estate Coorg
		GCHotel.put("IDS7522","IDS7522");  // AMA Stays & Trails - Braganza house Goa
		GCHotel.put("IDS7716","IDS7716");  // AMA Stays & Trails - Villa Siolim Goa
		GCHotel.put("IDS7728","IDS7728");  // AMA Stays & Trails - Madh Isl& Mumbai
		GCHotel.put("IDS7747","IDS7747");  // AMA Stays & Trails - Sluice House Lonavala
		GCHotel.put("IDS7851","IDS7851");  // AMA Stays & Trails - Villa No 1 GOA
		GCHotel.put("IDS7859","IDS7859");  // AMA Stays & Trails - Kharvi Abode Betul Goa
		GCHotel.put("IDS7841","IDS7841");  // AMA Stays & Trails - Kailash House Kodaikanal
		GCHotel.put("IDS7846","IDS7846");  // AMA Stays & Trails - Kumara Villa Kodaikanal
		GCHotel.put("IDS7915","IDS7915");  // AMA Stays & Trails - La Maison Fontainhas  Goa
		GCHotel.put("IDS7958","IDS7958");  // AMA stays & tarils -chikoo villa goa
		GCHotel.put("IDS7983","IDS7983");  // AMA Stays & Trails - Cliffs Edge Sangrun
		GCHotel.put("IDS7991","IDS7991");  // AMA Stays & Trails - Tea Estate Bungalows Munnar
		GCHotel.put("IDS7990","IDS7990");  // AMA Stays & Trails - Nine Palms Alibag
		GCHotel.put("IDS8049","IDS8049");  // AMA Stays & Trails - La Quinta Saipem Goa
		GCHotel.put("IDS8044","IDS8044");  // AMA Stays & Trails - Makaibari Bungalow
		GCHotel.put("IDS8051","IDS8051");  // AMA Stays & Trails - 70 Vale Goa
		GCHotel.put("IDS8049", "IDS8049");
		GCHotel.put("IDS8044", "IDS8044");
		GCHotel.put("IDS8051", "IDS8051");
		GCHotel.put("IDS8066", "IDS8066");
		GCHotel.put("IDS8097", "IDS8097");
		GCHotel.put("IDS8099", "IDS8099");
		GCHotel.put("IDS8111", "IDS8111");
		GCHotel.put("IDS8095", "IDS8095");
		GCHotel.put("IDS8100", "IDS8100");
		GCHotel.put("IDS8101", "IDS8101");
		GCHotel.put("IDS8096", "IDS8096");
		GCHotel.put("IDS8110", "IDS8110");
		GCHotel.put("IDS8098", "IDS8098");
		GCHotel.put("IDS8050", "IDS8050");
		GCHotel.put("IDS8149", "IDS8149");
		GCHotel.put("IDS8130", "IDS8130");
		GCHotel.put("IDS8147", "IDS8147");
		GCHotel.put("PYGVS", "PYGVS"); //Vivanta Pakyong
		GCHotel.put("CCURK", "CCURK");//Raaj Kutir
		GCHotel.put("BOMNT", "BOMNT");//Vivanta Navi Mumbai Turbhe
		GCHotel.put("DEDAK", "DEDAK");
		GCHotel.put("CCUNT", "CCUNT");
		GCHotel.put("IXJVK", "IXJVK");
		GCHotel.put("AMDVA", "AMDVA");
		GCHotel.put("CCJTW", "CCJTW");//Taj Wayanad Resort & Spa Kerala
		GCHotel.put("SHLVS", "SHLVS");//Vivanta Meghalaya, Shillong
		GCHotel.put("JAITA", "JAITA");
		GCHotel.put("DHMNM", "DHMNM");
		GCHotel.put("LKOJM", "LKOJM");
		GCHotel.put("KUUBM", "KUUBM");
		GCHotel.put("GOXYH", "GOXYH");
		GCHotel.put("IDS30002", "IDS30002");
		GCHotel.put("AMDTG", "AMDTG");
		GCHotel.put("IXJVJ", "IXJVJ");
		GCHotel.put("BBITC", "BBITC");
		GCHotel.put("IDRWC", "IDRWC");
		GCHotel.put("BOMTT", "BOMTT");
		GCHotel.put("PYGTG", "PYGTG");
		GCHotel.put("CCUTK", "CCUTK");
		GCHotel.put("TEZVT", "TEZVT");
		GCHotel.put("JSAGP", "JSAGP");
		GCHotel.put("JAISR", "JAISR");
		GCHotel.put("TIRBT", "TIRBT");
		GCHotel.put("COKSM", "COKSM");
		GCHotel.put("IXWVJ", "IXWVJ");
		GCHotel.put("JAIRG", "JAIRG");
		GCHotel.put("TIRTT", "TIRTT");
		GCHotel.put("UDRFP", "UDRFP");
		GCHotel.put("PNQFM", "PNQFM");  //Fountain Mahabaleshwar – IHCL SeleQtions
		GCHotel.put("JPRDR", "JPRDR");
		GCHotel.put("PATCP", "PATCP");  //Taj City Center Patna
		GCHotel.put("IXEGB", "IXEGB");  //IHCL SeleQtions Sacred Bay Bekal
		GCHotel.put("GOILE", "GOILE");
		GCHotel.put("BBITP", "BBITP");
		GCHotel.put("UDRRK", "UDRRK");
		GCHotel.put("COKIC", "COKIC");
		GCHotel.put("PGHNH", "PGHNH");
		GCHotel.put("DEDTD", "DEDTD");
		GCHotel.put("DIUFH", "DIUFH");
		GCHotel.put("DELTC", "DELTC");
		GCHotel.put("CNNGC", "CNNGC");
		GCHotel.put("DXBJL", "DXBJL");
		GCHotel.put("AGXBP", "AGXBP");
		GCHotel.put("AGXBR", "AGXBR");
		GCHotel.put("DXBTE", "DXBTE");
		GCHotel.put("BOMTA", "BOMTA");
		GCHotel.put("DIUGD", "DIUGD");
		GCHotel.put("BOMTH", "BOMTH");
		GCHotel.put("GOIGP", "GOIGP");
		GCHotel.put("CCUGK", "CCUGK");
		GCHotel.put("JAIGH", "JAIGH");
		GCHotel.put("AMDGA", "AMDGA");
		GCHotel.put("UDRLB", "UDRLB");
		GCHotel.put("BDQEN", "BDQEN");
		GCHotel.put("DEDHN", "DEDHN");
		GCHotel.put("COKVA", "COKVA");
		GCHotel.put("VNSAV", "VNSAV");
		GCHotel.put("BDQNS", "BDQNS");
		GCHotel.put("PBHTP", "PBHTP");
		GCHotel.put("PBHGR", "PBHGR");
		GCHotel.put("DEDGD", "DEDGD");
		GCHotel.put("MAAWM", "MAAWM");
		GCHotel.put("DELVV", "DELVV");
		GCHotel.put("KNUIS", "KNUIS");
		GCHotel.put("IXYGK", "IXYGK");
		
//		GCHotel.put("JAIGA", "JAIGA");
//		GCHotel.put("BHUGB", "BHUGB");
//		GCHotel.put("JAIGR", "JAIGR");
//		GCHotel.put("BDQGV", "BDQGV");
//		GCHotel.put("AMDGK", "AMDGK");
//		GCHotel.put("DEDTH", "DEDTH");
		
		
		
		
		try {
			String tmp = GCHotel.get(PropertyCode);
		
			if(tmp.equalsIgnoreCase(PropertyCode))
				isEnable = true;
			else 
				isEnable = false;
		}catch(Exception e)
		{
			isEnable = false;
		}
		System.out.println(isEnable);
		return isEnable; 
	}
	
	public static String ReplaceNameSpaces(String xml)
	{	
	// Replace the namespaces
    xml = xml.replaceAll("<Result", "<s0:Result");
    xml = xml.replaceAll("</Result", "</s0:Result");
    xml = xml.replaceAll("<r:", "<s3:");
    xml = xml.replaceAll("</r:", "</s3:");
    xml = xml.replaceAll("<hc:", "<s1:");
    xml = xml.replaceAll("</hc:", "</s1:");
    //xml = xml.replaceAll("hc:RatePlan", "s1:RatePlan");
    //xml = xml.replaceAll("hc:RoomType", "s1:RoomType");
    //xml = xml.replaceAll("hc:RoomTypeDescription", "s1:RoomTypeDescription");
    //xml = xml.replaceAll("hc:RoomRate", "s1:RoomRate");
    //xml = xml.replaceAll("hc:Rate", "s1:Rate");
    //xml = xml.replaceAll("hc:GuestCount", "s1:GuestCount");
    //xml = xml.replaceAll("hc:TimeSpan", "s1:TimeSpan");
    //xml = xml.replaceAll("hc:HotelReference", "s1:HotelReference");
    xml = xml.replaceAll("hc:ResGuestRPH", "s1:ResGuestRPH");
  //  xml = xml.replaceAll("<r:", "<s3:");
    //xml = xml.replaceAll("</r:", "</s3:");
    //xml = xml.replaceAll("r:ResGuests", "s3:ResGuests");
    //xml = xml.replaceAll("r:Profiles", "s3:Profiles");
    xml = xml.replaceAll("<c:", "<s2:");
    xml = xml.replaceAll("</c:", "</s2:");
    //xml = xml.replaceAll("c:lastName", "s2:lastName");
    xml = xml.replaceAll("<Profile", "<s4:Profile");
    xml = xml.replaceAll("</Profile", "</s4:Profile");
    xml = xml.replaceAll("<Customer", "<s4:Customer");
    xml = xml.replaceAll("</Customer", "</s4:Customer");
    
    xml = xml.replaceAll("<PersonName", "<s4:PersonName");
    xml = xml.replaceAll("</PersonName", "</s4:PersonName");
    
    xml = xml.replaceAll("<Addresses", "<s4:Addresses");
    xml = xml.replaceAll("</Addresses", "</s4:Addresses");
    
    xml = xml.replaceAll("<NameAddress", "<s4:NameAddress");
    xml = xml.replaceAll("</NameAddress", "</s4:NameAddress");
    
    xml = xml.replaceAll("<Phones", "<s4:Phones");
    xml = xml.replaceAll("</Phones", "</s4:Phones");

    xml = xml.replaceAll("<NamePhone", "<s4:NamePhone");
    xml = xml.replaceAll("</NamePhone", "</s4:NamePhone");
    
    xml = xml.replaceAll("<c:Text", "<s2:Text");
    xml = xml.replaceAll("</c:Text", "</s2:Text");

    xml = xml.replaceAll("<c:TextElement", "<s2:TextElement");
    xml = xml.replaceAll("</c:TextElement", "</s2:TextElement");

    xml = xml.replaceAll("<Invoice", "<s0:Invoice");
    xml = xml.replaceAll("</Invoice", "</s0:Invoice");

    xml = xml.replaceAll("<NameEmail", "<s4:NameEmail");
    xml = xml.replaceAll("</NameEmail", "</s4:NameEmail");

    xml = xml.replaceAll("<NameMembership", "<s4:NameMembership");
    xml = xml.replaceAll("</NameMembership", "</s4:NameMembership");

    
    return xml;
}
	public static String ReplaceNameSpacesFetchInvoice(String xml)
	{
		 xml = xml.replaceAll("<Result", "<s0:Result");
		    xml = xml.replaceAll("</Result", "</s0:Result");
		    xml = xml.replaceAll("<r:", "<s5:");
		    xml = xml.replaceAll("</r:", "</s5:");
		    xml = xml.replaceAll("<hc:", "<s1:");
		    xml = xml.replaceAll("</hc:", "</s1:");
		    //xml = xml.replaceAll("hc:RatePlan", "s1:RatePlan");
		    //xml = xml.replaceAll("hc:RoomType", "s1:RoomType");
		    //xml = xml.replaceAll("hc:RoomTypeDescription", "s1:RoomTypeDescription");
		    //xml = xml.replaceAll("hc:RoomRate", "s1:RoomRate");
		    //xml = xml.replaceAll("hc:Rate", "s1:Rate");
		    //xml = xml.replaceAll("hc:GuestCount", "s1:GuestCount");
		    //xml = xml.replaceAll("hc:TimeSpan", "s1:TimeSpan");
		    //xml = xml.replaceAll("hc:HotelReference", "s1:HotelReference");
		    xml = xml.replaceAll("hc:ResGuestRPH", "s1:ResGuestRPH");
		  //  xml = xml.replaceAll("<r:", "<s3:");
		    //xml = xml.replaceAll("</r:", "</s3:");
		    //xml = xml.replaceAll("r:ResGuests", "s3:ResGuests");
		    //xml = xml.replaceAll("r:Profiles", "s3:Profiles");
		    xml = xml.replaceAll("<c:", "<s2:");
		    xml = xml.replaceAll("</c:", "</s2:");
		    //xml = xml.replaceAll("c:lastName", "s2:lastName");
		    xml = xml.replaceAll("<Profile", "<s4:Profile");
		    xml = xml.replaceAll("</Profile", "</s4:Profile");
		    xml = xml.replaceAll("<Customer", "<s4:Customer");
		    xml = xml.replaceAll("</Customer", "</s4:Customer");
		    
		    xml = xml.replaceAll("<PersonName", "<s4:PersonName");
		    xml = xml.replaceAll("</PersonName", "</s4:PersonName");
		    
		    xml = xml.replaceAll("<Addresses", "<s4:Addresses");
		    xml = xml.replaceAll("</Addresses", "</s4:Addresses");
		    
		    xml = xml.replaceAll("<NameAddress", "<s4:NameAddress");
		    xml = xml.replaceAll("</NameAddress", "</s4:NameAddress");
		    
		    xml = xml.replaceAll("<Phones", "<s4:Phones");
		    xml = xml.replaceAll("</Phones", "</s4:Phones");

		    xml = xml.replaceAll("<NamePhone", "<s4:NamePhone");
		    xml = xml.replaceAll("</NamePhone", "</s4:NamePhone");
		    
		    xml = xml.replaceAll("<c:Text", "<s2:Text");
		    xml = xml.replaceAll("</c:Text", "</s2:Text");

		    xml = xml.replaceAll("<c:TextElement", "<s2:TextElement");
		    xml = xml.replaceAll("</c:TextElement", "</s2:TextElement");

		    xml = xml.replaceAll("<Invoice", "<s0:Invoice");
		    xml = xml.replaceAll("</Invoice", "</s0:Invoice");

		    return xml;
	
	}
	public static String ReplaceNameSpacesMakePayment(String xml)
	{
		  xml = xml.replaceAll("<MakePaymentResponse", "<s0:MakePaymentResponse");
		    xml = xml.replaceAll("</MakePaymentResponse", "</s0:MakePaymentResponse");

		    xml = xml.replaceAll("<Result", "<s0:Result");
		    xml = xml.replaceAll("</Result", "</s0:Result");		

		   return xml;
	}
	public static Response getReservationData(String url,String propertyCode) {
		OkHttpClient client = new OkHttpClient();
				MediaType mediaType = MediaType.parse("text/plain");
				RequestBody body = RequestBody.create(mediaType, "");
				Request request = new Request.Builder()
				  .url(url)
				  .get()
				  .addHeader("x-hotelid", propertyCode)
				  .addHeader("Authorization", "Basic b2ljX3VzZXI6SW5ub3ZhY3hAMzIx")
				  .build();
				Response response = null;
				try {
					response = client.newCall(request).execute();
				} catch (IOException e) {
					e.printStackTrace();
				}
		return response;
	}
	
	public static Response getProfileDataFromAPI(String url, String propertyCode) {
		
		OkHttpClient client = new OkHttpClient();
				   Request request = new Request.Builder()
				  .url(url)
				  .get()
				  .addHeader("x-hotelid", propertyCode)
				  .addHeader("Authorization", "Basic b2ljX3VzZXI6SW5ub3ZhY3hAMzIx")
				  .build();
				   Response response = null;
				try {
					response = client.newCall(request).execute();
				} catch (IOException e) {
					e.printStackTrace();
				}		
		 return response;
	}
	
	public static Response writeBackToPMSResponse(String url, String propertyCode, String body) {
		OkHttpClient client = new OkHttpClient();
				MediaType mediaType = MediaType.parse("application/json");
				RequestBody body1 = RequestBody.create(mediaType, body);
				Request request = new Request.Builder()
				  .url(url)
				  .method("POST", body1)
				  .addHeader("x-hotelid", propertyCode)
				  .addHeader("Content-Type", "application/json")
				  .addHeader("Authorization", "Basic b2ljX3VzZXI6SW5ub3ZhY3hAMzIx")
				  .build();
				Response response = null;
				try {
					response = client.newCall(request).execute();
				} catch (IOException e) {
					e.printStackTrace();
				}
			return response;
	}
	
	
	public static Map<String, String> getCodeAndMessage(String req) {
	    String modifiedResponse = req.replace("Response", "");
	    Pattern codePattern = Pattern.compile("code=(\\d+)");
	    Pattern messagePattern = Pattern.compile("message=([^,]+)");

	    Matcher codeMatcher = codePattern.matcher(modifiedResponse);
	    String code = codeMatcher.find() ? codeMatcher.group(1) : "No code";

	    Matcher messageMatcher = messagePattern.matcher(modifiedResponse);
	    String message = messageMatcher.find() ? messageMatcher.group(1) : "No message";

	    // Create a map to hold the code and message
	    Map<String, String> result = new HashMap<>();
	    result.put("code", code);
	    result.put("message", message);

	    return result;
	}

	public static String fecthProfileDataFromAPI(String outstandingUrl, JSONObject payload) {
	    OkHttpClient client = new OkHttpClient();

	    MediaType mediaType = MediaType.parse("application/json");
	    RequestBody body = RequestBody.create(mediaType, payload.toString());

	    Request request = new Request.Builder()
	            .url(outstandingUrl)
	            .post(body)
	            .addHeader("Authorization", "Basic b2ljX3VzZXI6SW5ub3ZhY3hAMzIx")
	            .addHeader("Content-Type", "application/json")
	            .build();

	    Response response = null;
	    try {
	        response = client.newCall(request).execute();

	        if (!response.isSuccessful()) {
	            return "Error: " + response.code() + " - " + response.message();
	        }

	        return response.body().string();

	    } catch (IOException e) {
	        e.printStackTrace();
	        return "Exception: " + e.getMessage();

	    } finally {
	        if (response != null) {
	           
	        }
	    }
	}
	
}
