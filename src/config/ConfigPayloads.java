package config;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class ConfigPayloads {

	public String getInvoicesPayload(String ResID, String OWSProperty)
	{
	
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		format.setTimeZone(TimeZone.getTimeZone("GMT"));
		String startTime = format.format(new Date());
		Calendar date1 = Calendar.getInstance();
		long t= date1.getTimeInMillis();
		Date afterAdding5Mins=new Date(t + (5 * 60000));
		String endTime = format.format(afterAdding5Mins);
		
		String OWSusername, OICusername;
		String OWSpassword, OICpassword;
		if(URLConfig.owsOperaCentralOperaCloud(OWSProperty))		
		{
			String upperCaseToLowerCase = OWSProperty.toLowerCase();
			String cloudUserName = Configuration.OperaCloudUsername+upperCaseToLowerCase;
			OWSusername= cloudUserName;
			OICusername= cloudUserName;
			OWSpassword = Configuration.OperaCloudPassword;
			OICpassword= Configuration.OperaCloudPassword;
		}
		else
		{
			OWSusername= Configuration.OWSUsername;
			OWSpassword = Configuration.OWSPassword;
			OICusername = Configuration.OICUsername;
			OICpassword = Configuration.OICPassword;
		}
		
		String payload = "<soapenv:Envelope xmlns:com=\"http://webservices.micros.com/og/4.3/Common/\" xmlns:core=\"http://webservices.micros.com/og/4.3/Core/\" xmlns:res=\"http://webservices.micros.com/og/4.3/ResvAdvanced/\" xmlns:res1=\"http://webservices.micros.com/og/4.3/Reservation/\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n" + 
				"   <soapenv:Header>\r\n" + 
				"      <wsse:Security soapenv:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\r\n" + 
				"         <wsu:Timestamp wsu:Id=\"TS-C2A3BE2EFF54CC56C9155309540490323\">\r\n" + 
				"            <wsu:Created>"+startTime+"</wsu:Created>\r\n" + 
				"            <wsu:Expires>"+endTime+"</wsu:Expires>\r\n" + 
				"         </wsu:Timestamp>\r\n" + 
				"         <wsse:UsernameToken wsu:Id=\"UsernameToken-C2A3BE2EFF54CC56C9155309508419020\">\r\n" + 
				"            <wsse:Username>"+OICusername+"</wsse:Username>\r\n" + 
				"            <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">"+OICpassword+"</wsse:Password>\r\n" + 
				"            <wsse:Nonce EncodingType=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary\">"+Configuration.OICBase64Binary+"</wsse:Nonce>\r\n" + 
				"            <wsu:Created>"+startTime+"</wsu:Created>\r\n" + 
				"         </wsse:UsernameToken>\r\n" + 
				"      </wsse:Security>\r\n" + 
				"      <core:OGHeader>\r\n" + 
				"         <core:Authentication>\r\n" + 
				"            <core:UserCredentials>\r\n" + 
				"               <core:UserName>"+OWSusername+"</core:UserName>\r\n" + 
				"               <core:UserPassword>"+OWSpassword+"</core:UserPassword>\r\n" + 
				"               <core:Domain>"+OWSProperty+"</core:Domain>\r\n" + 
				"            </core:UserCredentials>\r\n" + 
				"         </core:Authentication>\r\n" + 
				"      </core:OGHeader>\r\n" + 
				"   </soapenv:Header>\r\n" + 
				"   <soapenv:Body>\r\n" + 
				"      <res:InvoiceRequest>\r\n" + 
				"         <res:ReservationRequest>\r\n" + 
				"            <res:HotelReference hotelCode=\""+OWSProperty+"\"/>\r\n" + 
				"            <res:ReservationID>\r\n" + 
				"               <com:UniqueID source=\"RESV_NAME_ID\" type=\"INTERNAL\">"+ResID+"</com:UniqueID>\r\n" + 
				"            </res:ReservationID>\r\n" + 
				"         </res:ReservationRequest>\r\n" + 
				"      </res:InvoiceRequest>\r\n" + 
				"   </soapenv:Body>\r\n" + 
				"</soapenv:Envelope>";
		
		return payload;
	
	}
	
	public String getFetchBookingPayload(String ResID, String OWSProperty)
	{
	
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		format.setTimeZone(TimeZone.getTimeZone("GMT"));
		String startTime = format.format(new Date());
		Calendar date1 = Calendar.getInstance();
		long t= date1.getTimeInMillis();
		Date afterAdding5Mins=new Date(t + (5 * 60000));
		String endTime = format.format(afterAdding5Mins);
		
		
		String OWSusername;
		String OICusername;
		String OWSpassword;
		String OICpassword;
		if(URLConfig.owsOperaCentralOperaCloud(OWSProperty))		
		{
			String upperCaseToLowerCase = OWSProperty.toLowerCase();
			String cloudUserName = Configuration.OperaCloudUsername+upperCaseToLowerCase;
			OWSusername= cloudUserName;
			OICusername= cloudUserName;
			OWSpassword = Configuration.OperaCloudPassword;
			OICpassword= Configuration.OperaCloudPassword;
		}
		else
		{
			OWSusername= Configuration.OWSUsername;
			OWSpassword = Configuration.OWSPassword;
			OICusername = Configuration.OICUsername;
			OICpassword = Configuration.OICPassword;
		}
		String payload="<soapenv:Envelope xmlns:com=\"http://webservices.micros.com/og/4.3/Common/\" xmlns:core=\"http://webservices.micros.com/og/4.3/Core/\" xmlns:hot=\"http://webservices.micros.com/og/4.3/HotelCommon/\" xmlns:res=\"http://webservices.micros.com/ows/5.1/Reservation.wsdl\" xmlns:res1=\"http://webservices.micros.com/og/4.3/Reservation/\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n"+ 
				"   <soapenv:Header>\r\n" + 
				"      <wsse:Security soapenv:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\r\n" + 
				"         <wsu:Timestamp wsu:Id=\"TS-C2A3BE2EFF54CC56C9155309540490323\">\r\n" + 
				"            <wsu:Created>"+startTime+"</wsu:Created>\r\n" + 
				"            <wsu:Expires>"+endTime+"</wsu:Expires>\r\n" + 
				"         </wsu:Timestamp>\r\n" + 
				"         <wsse:UsernameToken wsu:Id=\"UsernameToken-C2A3BE2EFF54CC56C9155309508419020\">\r\n" + 
				"            <wsse:Username>"+OICusername+"</wsse:Username>\r\n" + 
				"            <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">"+OICpassword+"</wsse:Password>\r\n" + 
				"            <wsse:Nonce EncodingType=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary\">"+Configuration.OICBase64Binary+"</wsse:Nonce>\r\n" + 
				"            <wsu:Created>"+startTime+"</wsu:Created>\r\n" + 
				"         </wsse:UsernameToken>\r\n" + 
				"      </wsse:Security>\r\n" + 
				"    <core:OGHeader primaryLangID=\"E\" timeStamp=\"2009-03-13T14:48:16.0718750-05:00\" transactionID=\"0329878907\">\r\n" + 
				"      <core:Origin entityID=\"KIOSK\" systemType=\"WEB\"/>\r\n" + 
				"      <core:Destination entityID=\"KIOSK\" systemType=\"PMS\"/>\r\n" + 
				"      <core:Authentication>\r\n" + 
				"        <core:UserCredentials>\r\n" + 
				"               <core:UserName>"+OWSusername+"</core:UserName>\r\n" + 
				"               <core:UserPassword>"+OWSpassword+"</core:UserPassword>\r\n" + 
				"               <core:Domain>"+OWSProperty+"</core:Domain>\r\n" + 
				"            </core:UserCredentials>\r\n" + 
				"         </core:Authentication>\r\n" + 
				"      </core:OGHeader>\r\n" + 
				"   </soapenv:Header>\r\n"
				+ "   <soapenv:Body>\r\n"
				+ "      <res:FetchBookingRequest>\r\n"
				+ "            <res:ResvNameId source=\"RESVID\" type=\"INTERNAL\">"+ResID+"</res:ResvNameId>\r\n"
				+ "      </res:FetchBookingRequest>\r\n"
				+ "   </soapenv:Body>\r\n"
				+ "</soapenv:Envelope>";
		
		return payload;
		
	}
	
	

	public String getCurrencyConverterPayload(String CurrencyCode, String OWSProperty)
	{
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		format.setTimeZone(TimeZone.getTimeZone("GMT"));
		String startTime = format.format(new Date());
		Calendar date1 = Calendar.getInstance();
		long t= date1.getTimeInMillis();
		Date afterAdding5Mins=new Date(t + (5 * 60000));
		String endTime = format.format(afterAdding5Mins);
		
		
		
		String payload = "<soapenv:Envelope xmlns:core=\"http://webservices.micros.com/og/4.3/Core/\" xmlns:inf=\"http://webservices.micros.com/ows/5.1/Information.wsdl\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n" + 
				"  <soapenv:Header>\r\n" + 
				"    <wsse:Security soapenv:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\r\n" + 
				"      <wsu:Timestamp wsu:Id=\"TS-C2A3BE2EFF54CC56C9155309563951324\">\r\n" + 
				"        <wsu:Created>"+startTime+"</wsu:Created>\r\n" + 
				"        <wsu:Expires>"+endTime+"</wsu:Expires>\r\n" + 
				"      </wsu:Timestamp>\r\n" + 
				"      <wsse:UsernameToken wsu:Id=\"UsernameToken-C2A3BE2EFF54CC56C9155308968927713\">\r\n" + 
				"        <wsse:Username>"+Configuration.OICUsername+"</wsse:Username>\r\n" + 
				"        <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">"+Configuration.OICPassword+"</wsse:Password>\r\n" + 
				"        <wsse:Nonce EncodingType=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary\">"+Configuration.OICBase64Binary+"</wsse:Nonce>\r\n" + 
				"        <wsu:Created>2019-03-20T13:48:09.276Z</wsu:Created>\r\n" + 
				"      </wsse:UsernameToken>\r\n" + 
				"    </wsse:Security>\r\n" + 
				"    <core:OGHeader primaryLangID=\"E\" timeStamp=\"2009-03-13T14:48:16.0718750-05:00\" transactionID=\"0329878907\">\r\n" + 
				"      <core:Origin entityID=\"KIOSK\" systemType=\"WEB\"/>\r\n" + 
				"      <core:Destination entityID=\"KIOSK\" systemType=\"PMS\"/>\r\n" + 
				"      <core:Authentication>\r\n" + 
				"        <core:UserCredentials>\r\n" + 
				"          <core:UserName>"+Configuration.OWSUsername+"</core:UserName>\r\n" + 
				"          <core:UserPassword>"+Configuration.OWSPassword+"</core:UserPassword>\r\n" + 
				"          <core:Domain>"+OWSProperty+"</core:Domain>\r\n" + 
				"        </core:UserCredentials>\r\n" + 
				"      </core:Authentication>\r\n" + 
				"    </core:OGHeader>\r\n" + 
				"  </soapenv:Header>\r\n" + 
				"  <soapenv:Body>\r\n" + 
				"    <inf:CurrencyConverterRequest>\r\n" + 
				"      <inf:FromCurrency currencyCode=\""+CurrencyCode+"\">1</inf:FromCurrency>\r\n" + 
				"      <inf:ToCurrency currencyCode=\"INR\"/>\r\n" + 
				"      <inf:Resort chainCode=\"WC\" hotelCode=\""+OWSProperty+"\"/>\r\n" + 
				"      <inf:ExchangeType>EXCHANGE_CHECK</inf:ExchangeType>\r\n" + 
				"    </inf:CurrencyConverterRequest>\r\n" + 
				"  </soapenv:Body>\r\n" + 
				"</soapenv:Envelope>\r\n" + 
				"";
		
		return payload;
	}

	public String getMemberDataPayload(String MembershipNumber)
	{
		String payload = "{\r\n" + 
				"	\"membershipNumber\": \""+MembershipNumber+"\",\r\n" + 
				"	\"source_identifier\": \""+"MUIRedemption"+"\"\r\n" + 
				"}";
		
		//MembershipNumber
		return payload;
	}

	public String getProfileDataPayload(String PMSNameCode)
	{
		String payload = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:typ=\"http://xmlns.oracle.com/apps/cdm/foundation/parties/personService/applicationModule/types/\" xmlns:typ1=\"http://xmlns.oracle.com/adf/svc/types/\">\r\n" + 
				"  <soapenv:Header/>\r\n" + 
				"  <soapenv:Body>\r\n" + 
				"    <typ:findPerson>\r\n" + 
				"      <typ:findCriteria>\r\n" + 
				"        <typ1:fetchStart>0</typ1:fetchStart>\r\n" + 
				"        <typ1:fetchSize>-1</typ1:fetchSize>\r\n" + 
				"        <typ1:filter>\r\n" + 
				"          <typ1:conjunction>And</typ1:conjunction>\r\n" + 
				"          <typ1:group>\r\n" + 
				"            <typ1:conjunction>And</typ1:conjunction>\r\n" + 
				"            <typ1:upperCaseCompare>false</typ1:upperCaseCompare>\r\n" + 
				"            <typ1:item>\r\n" + 
				"              <typ1:conjunction>And</typ1:conjunction>\r\n" + 
				"              <typ1:upperCaseCompare>false</typ1:upperCaseCompare>\r\n" + 
				"              <typ1:attribute>Status</typ1:attribute>\r\n" + 
				"              <typ1:operator>=</typ1:operator>\r\n" + 
				"              <typ1:value>A</typ1:value>\r\n" + 
				"            </typ1:item>\r\n" + 
				"            <typ1:item>\r\n" + 
				"              <typ1:conjunction>And</typ1:conjunction>\r\n" + 
				"              <typ1:upperCaseCompare>false</typ1:upperCaseCompare>\r\n" + 
				"              <typ1:attribute>OriginalSystemReference</typ1:attribute>\r\n" + 
				"              <typ1:operator>EXISTS</typ1:operator>\r\n" + 
				"              <typ1:nested>\r\n" + 
				"                <typ1:group>\r\n" + 
				"                  <typ1:item>\r\n" + 
				"                    <typ1:upperCaseCompare>false</typ1:upperCaseCompare>\r\n" + 
				"                    <typ1:attribute>OrigSystemReference</typ1:attribute>\r\n" + 
				"                    <typ1:operator>=</typ1:operator>\r\n" + 
				"                    <typ1:value>"+PMSNameCode+"</typ1:value>\r\n" + 
				"                  </typ1:item>\r\n" + 
				"                  <typ1:item>\r\n" + 
				"                    <typ1:upperCaseCompare>false</typ1:upperCaseCompare>\r\n" + 
				"                    <typ1:attribute>Status</typ1:attribute>\r\n" + 
				"                    <typ1:operator>=</typ1:operator>\r\n" + 
				"                    <typ1:value>A</typ1:value>\r\n" + 
				"                  </typ1:item>\r\n" +
				"                </typ1:group>\r\n" + 
				"              </typ1:nested>\r\n" + 
				"            </typ1:item>\r\n" + 
				"          </typ1:group>\r\n" + 
				"        </typ1:filter>\r\n" + 
				"      </typ:findCriteria>\r\n" + 
				"    </typ:findPerson>\r\n" + 
				"  </soapenv:Body>\r\n" + 
				"</soapenv:Envelope>\r\n" + 
				"";
		
		return payload;
	}

	public String getReservationDataPayload(String ReservationID, String OWSProperty)
	{
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		format.setTimeZone(TimeZone.getTimeZone("GMT"));
		String startTime = format.format(new Date());
		Calendar date1 = Calendar.getInstance();
		long t= date1.getTimeInMillis();
		Date afterAdding5Mins=new Date(t + (5 * 60000));
		String endTime = format.format(afterAdding5Mins);
		
		
		
		
		String payload = "<soapenv:Envelope xmlns:core=\"http://webservices.micros.com/og/4.3/Core/\" xmlns:res=\"http://webservices.micros.com/ows/5.1/Reservation.wsdl\" xmlns:res1=\"http://webservices.micros.com/og/4.3/Reservation/\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n" + 
				"   <soapenv:Header>\r\n" + 
				"      <wsse:Security soapenv:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\r\n" + 
				"         <wsu:Timestamp wsu:Id=\"TS-C2A3BE2EFF54CC56C9155309586358325\">\r\n" + 
				"            <wsu:Created>"+startTime+"</wsu:Created>\r\n" + 
				"            <wsu:Expires>"+endTime+"</wsu:Expires>\r\n" + 
				"         </wsu:Timestamp>\r\n" + 
				"         <wsse:UsernameToken wsu:Id=\"UsernameToken-C2A3BE2EFF54CC56C915530701323592\">\r\n" + 
				"            <wsse:Username>"+Configuration.OICUsername+"</wsse:Username>\r\n" + 
				"            <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">"+Configuration.OICPassword+"</wsse:Password>\r\n" + 
				"            <wsse:Nonce EncodingType=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary\">"+Configuration.OICBase64Binary+"</wsse:Nonce>\r\n" + 
				"            <wsu:Created>"+startTime+"</wsu:Created>\r\n" + 
				"         </wsse:UsernameToken>\r\n" + 
				"      </wsse:Security>\r\n" + 
				"      <core:OGHeader primaryLangID=\"E\" timeStamp=\"2009-03-08T09:15:27.568125-05:00\" transactionID=\"3297907325\" xmlns=\"http://webservices.micros.com/og/4.3/Core/\">\r\n" + 
				"         <core:Origin entityID=\"KIOSK\" systemType=\"WEB\"/>\r\n" + 
				"         <core:Destination entityID=\"KIOSK\" systemType=\"PMS\"/>\r\n" + 
				"         <core:Authentication>\r\n" + 
				"            <core:UserCredentials>\r\n" + 
				"               <core:UserName>"+Configuration.OWSUsername+"</core:UserName>\r\n" + 
				"               <core:UserPassword>"+Configuration.OWSPassword+"</core:UserPassword>\r\n" + 
				"               <core:Domain>"+OWSProperty+"</core:Domain>\r\n" + 
				"            </core:UserCredentials>\r\n" + 
				"         </core:Authentication>\r\n" + 
				"      </core:OGHeader>\r\n" + 
				"   </soapenv:Header>\r\n" + 
				"   <soapenv:Body>\r\n" + 
				"      <res:FetchBookingRequest>\r\n" + 
				"         <res:ResvNameId source=\"RESVID\" type=\"INTERNAL\">"+ReservationID+"</res:ResvNameId>\r\n" + 
				"      </res:FetchBookingRequest>\r\n" + 
				"   </soapenv:Body>\r\n" + 
				"</soapenv:Envelope>";
		
		return payload;
	}

	public String getGiftCardBalanceEnquiryPayload(String CardNumber)
	{
		String payload = "{\r\n\"CardNumber\": \""+CardNumber+"\"\r\n} ";
		
		return payload;
	}

	public String getPayUsingPointsPayload(String TransactionComments, String RoomType, String PaymentType, String PaymentTransID, String CheckOutDate, String BillNo, String RegisterNumber, String Phone, String Address2, String city, String state, String Address1, String BookingSource, String postal, String Address3, String RoomNumber, String TotalAmount, String TransactionChannel, String country, String EnrollNumber_c, String CheckInDate, String BookingDate, String BillDate, String RedeemPoints, String Quantity, String ProductName, String PointsRedeemedType)
	{

		String payload = "{\r\n" + 
				"  \"RedemptionTransactionWebsite_Input\":{\r\n" + 
				"    \"TransactionComments\":\""+TransactionComments+"\",\r\n" + 
				"    \"RoomType\":\""+RoomType+"\",\r\n" + 
				"    \"PaymentType\":\""+PaymentType+"\",\r\n" + 
				"    \"PaymentTxnId\":\""+PaymentTransID+"\",\r\n" + 
				"    \"CheckOutDate\":\""+CheckOutDate+"\",\r\n" + 
				"    \"BillNumber\":\""+BillNo+"\",\r\n" + 
				"    \"RegisterNumber\":\""+RegisterNumber+"\",\r\n" + 
				"    \"PhoneNumber\":\""+Phone+"\",\r\n" + 
				"    \"MktgPtnrName\":\"\",\r\n" + 
				"    \"StreetAddress2\":\""+Address2+"\",\r\n" + 
				"    \"CashPaidAmount\":\"\",\r\n" + 
				"    \"MktgPtnrMembershipNo\":\"\",\r\n" + 
				"    \"City\":\""+city+"\",\r\n" + 
				"    \"State\":\""+state+"\",\r\n" + 
				"    \"StreetAddress1\":\""+Address1+"\",\r\n" + 
				"    \"BookingSource\":\""+BookingSource+"\",\r\n" + 
				"    \"ZipCode\":\""+postal+"\",\r\n" + 
				"    \"StreetAddress3\":\""+Address3+"\",\r\n" + 
				"    \"RoomNumber\":\""+RoomNumber+"\",\r\n" + 
				"    \"MemberCardNumber\":\"\",\r\n" + 
				"    \"Amount\":\""+TotalAmount+"\",\r\n" + 
				"    \"TransactionChannel\":\""+TransactionChannel+"\",\r\n" + 
				"    \"Country\":\""+country+"\",\r\n" + 
				"    \"PropertyCode\":\"\",\r\n" + 
				"    \"MemberNumber\":\""+EnrollNumber_c+"\",\r\n" + 
				"    \"CheckInDate\":\""+CheckInDate+"\",\r\n" + 
				"    \"BookingDate\":\""+BookingDate+"\",\r\n" + 
				"    \"BillDate\":\""+BillDate+"\",\r\n" + 
				"    \"RedeemPoints\":\""+RedeemPoints+"\",\r\n" + 
				"    \"OutletCode\":\"\",\r\n" + 
				"    \"ShippingAddress\":\"\",\r\n" + 
				"    \"Quantity\":\""+Quantity+"\",\r\n" + 
				"    \"ProductName\":\""+ProductName+"\",\r\n" + 
				"    \"PointsRedeemedType\":\""+PointsRedeemedType+"\"\r\n" + 
				"  }\r\n" + 
				"}";

		
		return payload;
	}
	
	public String getWriteToPMSPaylaod(String OWSProperty,String PostTime, String UserName, String PaymentDescription, double writeBackAmount, String PostDate, String WindowNumber, String HotelCode, String GlobalReservationNumber, String PaymentCardType, String TransactionID)
	{
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		format.setTimeZone(TimeZone.getTimeZone("GMT"));
		String startTime = format.format(new Date());
		Calendar date1 = Calendar.getInstance();
		long t= date1.getTimeInMillis();
		Date afterAdding5Mins=new Date(t + (5 * 60000));
		String endTime = format.format(afterAdding5Mins);
		
		/*
		 * if(PaymentDescription.startsWith("EP")) PaymentCardType="9051"; else
		 * if(PaymentDescription.startsWith("CH")) PaymentCardType="9050";
		 * 
		 * else if(PaymentDescription.startsWith("Taj Club")) PaymentCardType="9052";
		 */	
			
		/*String payload = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:core=\"http://webservices.micros.com/og/4.3/Core/\" xmlns:res=\"http://webservices.micros.com/og/4.3/ResvAdvanced/\" xmlns:com=\"http://webservices.micros.com/og/4.3/Common/\" xmlns:hot=\"http://webservices.micros.com/og/4.3/HotelCommon/\">\r\n" + 
				"  <soap:Header>\r\n" + 
				"	<wsse:Security soapenv:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\r\n" + 
				"      <wsu:Timestamp wsu:Id=\"TS-C2A3BE2EFF54CC56C915530774679493\">\r\n" + 
				"         <wsu:Created>"+startTime+"</wsu:Created>\r\n" + 
				"         <wsu:Expires>"+endTime+"</wsu:Expires>\r\n" + 
				"      </wsu:Timestamp>\r\n" + 
				"      <wsse:UsernameToken wsu:Id=\"UsernameToken-C2A3BE2EFF54CC56C915530701323592\">\r\n" + 
				"         <wsse:Username>raj.srinivasan@innovacx.com</wsse:Username>\r\n" + 
				"         <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">Smile@25</wsse:Password>\r\n" + 
				"         <wsse:Nonce EncodingType=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary\">1XPN4w2hKfOuK/O+gijXnA==</wsse:Nonce>\r\n" + 
				"         <wsu:Created>"+startTime+"</wsu:Created>\r\n" + 
				"      </wsse:UsernameToken>\r\n" + 
				"   </wsse:Security>\r\n" +
				"    <core:OGHeader transactionID=\"349860637\" timeStamp=\"2009-02-13T14:48:16.0718750-05:00\" xmlns=\"http://webservices.micros.com/og/4.3/Core/\">\r\n" + 
				"      <core:Origin entityID=\"KIOSK\" systemType=\"WEB\" />\r\n" + 
				"      <core:Destination entityID=\"KIOSK\" systemType=\"PMS\" />\r\n" + 
				"     <core:Authentication>\r\n" + 
				"        <core:UserCredentials>\r\n" + 
				"          <core:UserName>"+Configuration.OWSUsername+"</core:UserName>\r\n" + 
				"          <core:UserPassword>"+Configuration.OWSPassword+"</core:UserPassword>\r\n" + 
				"          <core:Domain>"+OWSProperty+"</core:Domain>\r\n" + 
				"        </core:UserCredentials>\r\n" + 
				"      </core:Authentication>\r\n" + 
				"    </core:OGHeader>\r\n" + 
				"  </soap:Header>\r\n" + 
				"  <soap:Body>\r\n" + 
				"    <res:MakePaymentRequest xmlns=\"http://webservices.micros.com/og/4.3/ResvAdvanced/\" xmlns:c=\"http://webservices.micros.com/og/4.3/Common/\" xmlns:hc=\"http://webservices.micros.com/og/4.3/HotelCommon/\" xmlns:n=\"http://webservices.micros.com/og/4.3/Name/\" xmlns:r=\"http://webservices.micros.com/og/4.3/Reservation/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n" + 
				"      <res:Posting PostTime=\""+PostTime+"\" UserID=\""+Configuration.OWSUsername+"\" ShortInfo=\"POINT\" LongInfo=\""+PaymentDescription+"\" Charge=\""+writeBackAmount+"\" StationID=\"KIOSK1\" PostDate=\""+PostDate+"\"  FolioViewNo=\""+WindowNumber+"\" >\r\n" + 
				"        <res:ReservationRequestBase>\r\n" + 
				"          <res:HotelReference hotelCode=\""+OWSProperty+"\" />\r\n" + 
				"           <res:ReservationID>\r\n" + 
				"          <com:UniqueID type=\"INTERNAL\" source=\"RESV_NAME_ID\">"+GlobalReservationNumber+"</com:UniqueID>\r\n" + 
				"        </res:ReservationID>\r\n" + 
				"        </res:ReservationRequestBase>\r\n" + 
				"      </res:Posting>\r\n" + 
				"      <res:CreditCardInfo>\r\n" + 
				"        <res:CreditCardApproved cardType=\""+PaymentCardType+"\">\r\n"+ 
				"        </res:CreditCardApproved>\r\n" + 
				"      </res:CreditCardInfo>\r\n" + 
				"      <res:Reference>"+TransactionID+"</res:Reference>\r\n" + 
				"    </res:MakePaymentRequest>\r\n" + 
				"  </soap:Body>\r\n" + 
				"</soap:Envelope>"; */
		
		String OWSUsername, OWSPassword;
		String  OICUsername,OICPassword;
		
		if(URLConfig.owsOperaCentralOperaCloud(OWSProperty))					
		{
			String upperCaseToLowerCase = OWSProperty.toLowerCase();
			String cloudUserName = Configuration.OperaCloudUsername+upperCaseToLowerCase;
			OWSUsername = cloudUserName;
			OWSPassword = Configuration.OperaCloudPassword;
			OICUsername=  cloudUserName;
			OICPassword = Configuration.OperaCloudPassword;
		}								
		
		else {
			OWSUsername = Configuration.OWSUsername;
			OWSPassword = Configuration.OWSPassword;
			OICUsername=  Configuration.OICUsername;
			OICPassword = Configuration.OICPassword;
		}
		
	  String payload1 = "{\r\n" +
	                    "  \"criteria\": {\r\n" +
	                    "    \"reservationId\": {\r\n" +
	                    "      \"idContext\": \"KIOSK\",\r\n" +
	                    "      \"id\": \"" + GlobalReservationNumber + "\",\r\n" +
	                    "      \"type\": \"Reservation\"\r\n" +
	                    "    },\r\n" +
	                    "    \"paymentMethod\": {\r\n" +
	                    "      \"paymentMethod\": \"" + PaymentCardType + "\"\r\n" +
	                    "    },\r\n" +
	                    "    \"postingReference\": \"" + TransactionID + "\",\r\n" +
	                    "    \"postingRemark\": \"" + PaymentDescription + "\",\r\n" +
	                    "    \"postingAmount\": {\r\n" +
	                    "      \"amount\": \"" + writeBackAmount + "\",\r\n" +
	                    "      \"currencyCode\": \"INR\"\r\n" +
	                    "    },\r\n" +
	                    "    \"cashierId\": 11,\r\n" +
	                    "    \"hotelId\": \"" + HotelCode + "\",\r\n" +
	                    "    \"folioWindowNo\": \"" + WindowNumber + "\"\r\n" +
	                    "  }\r\n" +
	                    "}";
//				"<soapenv:Envelope xmlns:com=\"http://webservices.micros.com/og/4.3/Common/\" xmlns:core=\"http://webservices.micros.com/og/4.3/Core/\" xmlns:hot=\"http://webservices.micros.com/og/4.3/HotelCommon/\" xmlns:res=\"http://webservices.micros.com/og/4.3/ResvAdvanced/\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n" + 
//				"   <soapenv:Header>\r\n" + 
//				"      <wsse:Security soapenv:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\r\n" + 
//				"         <wsu:Timestamp wsu:Id=\"TS-C2A3BE2EFF54CC56C9155309622850627\">\r\n" + 
//				"            <wsu:Created>"+startTime+"</wsu:Created>\r\n" + 
//				"            <wsu:Expires>"+endTime+"</wsu:Expires>\r\n" + 
//				"         </wsu:Timestamp>\r\n" + 
//				"         <wsse:UsernameToken wsu:Id=\"UsernameToken-C2A3BE2EFF54CC56C9155309622492126\">\r\n" + 
//				"            <wsse:Username>"+OICUsername+"</wsse:Username>\r\n" + 
//				"            <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">"+OICPassword+"</wsse:Password>\r\n" + 
//				"            <wsse:Nonce EncodingType=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary\">"+Configuration.OICBase64Binary+"</wsse:Nonce>\r\n" + 
//				"            <wsu:Created>"+startTime+"</wsu:Created>\r\n" + 
//				"         </wsse:UsernameToken>\r\n" + 
//				"      </wsse:Security>\r\n" + 
//				"      <core:OGHeader timeStamp=\"2009-02-13T14:48:16.0718750-05:00\" transactionID=\"349860637\" xmlns=\"http://webservices.micros.com/og/4.3/Core/\">\r\n" + 
//				"         <core:Origin entityID=\"KIOSK\" systemType=\"WEB\"/>\r\n" + 
//				"         <core:Destination entityID=\"KIOSK\" systemType=\"PMS\"/>\r\n" + 
//				"         <core:Authentication>\r\n" + 
//				"            <core:UserCredentials>\r\n" + 
//				"               <core:UserName>"+OWSUsername+"</core:UserName>\r\n" + 
//				"               <core:UserPassword>"+OWSPassword+"</core:UserPassword>\r\n" + 
//				"               <core:Domain>"+OWSProperty+"</core:Domain>\r\n" + 
//				"            </core:UserCredentials>\r\n" + 
//				"         </core:Authentication>\r\n" + 
//				"      </core:OGHeader>\r\n" + 
//				"   </soapenv:Header>\r\n" + 
//				"   <soapenv:Body>\r\n" + 
//				"      <res:MakePaymentRequest>\r\n" + 
//				"         <res:Posting Charge=\""+writeBackAmount+"\" FolioViewNo=\""+WindowNumber+"\" LongInfo=\""+PaymentDescription+"\" PostDate=\""+PostDate+"\" PostTime=\""+PostTime+"\" ShortInfo=\"POINT\" StationID=\"KIOSK1\" UserID=\""+Configuration.OWSUsername+"\">\r\n" + 
//				"            <res:ReservationRequestBase>\r\n" + 
//				"               <res:HotelReference hotelCode=\""+OWSProperty+"\"/>\r\n" + 
//				"               <res:ReservationID>\r\n" + 
//				"                  <com:UniqueID source=\"RESV_NAME_ID\" type=\"INTERNAL\">"+GlobalReservationNumber+"</com:UniqueID>\r\n" + 
//				"               </res:ReservationID>\r\n" + 
//				"            </res:ReservationRequestBase>\r\n" + 
//				"         </res:Posting>\r\n" + 
//				"         <res:CreditCardInfo>\r\n" + 
//				"            <res:CreditCardApproved cardType=\""+PaymentCardType+"\"/>\r\n" + 
//				"         </res:CreditCardInfo>\r\n" + 
//				"         <res:Reference>"+TransactionID+"</res:Reference>\r\n" + 
//				"      </res:MakePaymentRequest>\r\n" + 
//				"   </soapenv:Body>\r\n" + 
//				"</soapenv:Envelope>";
		
		return payload1;
	}

	public String getPayUsingGiftCardPayload(String TotalAmount, String BillAmount, String GiftCardNumber, String GiftCardPin, String TrackData, String Remarks, String IdempotencyKey, String ReservationId)
	{
		String payload = "{\r\n" + 
				"\"Amount\": \""+TotalAmount+"\",\r\n" + 
				"\"CardNumber\": \""+GiftCardNumber+"\",\r\n" + 
				"\"TrackData\": \""+TrackData+"\",\r\n" + 
				"\"CardPIN\": \""+GiftCardPin+"\",\r\n" + 
				"\"BillAmount\": \""+BillAmount+"\",\r\n" + 
				"\"IdempotencyKey\":\""+IdempotencyKey+"\"," +
				"\"InvoiceNumber\": \""+ReservationId+"\",\r\n" + 
				"\"Notes\": \""+Remarks+"\"\r\n" + 
				"} ";
		
		return payload;
	}

	public String getSendOTPPayload(String title, String firstName, String middleName, String lastName, String emailID, String countryCode, String mobile, String gender, String MembershipNumber)
	{
		String payload = "{\r\n" + 
				"   \"title\":\""+title+"\",\r\n" + 
				"   \"firstName\":\""+firstName+"\",\r\n" + 
				"   \"middleName\":\""+middleName+"\",\r\n" + 
				"   \"lastName\":\""+lastName+"\",\r\n" + 
				"   \"email\":\""+emailID+"\",\r\n" + 
				"   \"countryCode\":\""+countryCode+"\",\r\n" + 
				"   \"mobile\":\""+mobile+"\",\r\n" + 
				"   \"gender\":\""+gender+"\",\r\n" + 
				"   \"membershipId\":\""+MembershipNumber+"\"\r\n" + 
				"}";
		
		return payload;
	}
	
	public String getVouchersPayload(String MemberNumber)
	{
		String payload = "{\r\n" + 
				"   \"IHCL_spcVoucher_spcOperations_spcWS_spcWebsite_spcV1_Input\":{\r\n" + 
				"      \"ListOfIhclVoucherIo\":{\r\n" + 
				"         \"LoyVoucherAll\":[\r\n" + 
				"            {\r\n" + 
				"            	\"Status\": \"Available\",\r\n" + 
				"            	\"SourceSystem\":\"PMS\",\r\n" + 
				"               \"MembershipNumber\":\""+MemberNumber+"\"\r\n" + 
				"            }\r\n" + 
				"         ]\r\n" + 
				"      },\r\n" + 
				"      \"Operation\":\"Query\"\r\n" + 
				"   }\r\n" + 
				"}";
		
		return payload;
	}
	
	public String getFutureBookingSummaryUsingNameCode(String ReservationNameCode, String OWSPropertyCode)
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		format.setTimeZone(TimeZone.getTimeZone("GMT"));
		String startTime = format.format(new Date());
		Calendar date1 = Calendar.getInstance();
		long t= date1.getTimeInMillis();
		Date afterAdding5Mins=new Date(t + (5 * 60000));
		String endTime = format.format(afterAdding5Mins);
		
		String OWSusername;
		String OICusername;
		String OWSpassword;
		String OICpassword;
		if(URLConfig.owsOperaCentralOperaCloud(OWSPropertyCode))		
		{
			String upperCaseToLowerCase = OWSPropertyCode.toLowerCase();
			String cloudUserName = Configuration.OperaCloudUsername+upperCaseToLowerCase;
			OWSusername= cloudUserName;
			OICusername= cloudUserName;
			OWSpassword = Configuration.OperaCloudPassword;
			OICpassword= Configuration.OperaCloudPassword;
		}
		else
		{
			OWSusername= Configuration.OWSUsername;
			OWSpassword = Configuration.OWSPassword;
			OICusername = Configuration.OICUsername;
			OICpassword = Configuration.OICPassword;
		}
		String payload = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:core=\"http://webservices.micros.com/og/4.3/Core/\" xmlns:res=\"http://webservices.micros.com/ows/5.1/Reservation.wsdl\" xmlns:hot=\"http://webservices.micros.com/og/4.3/HotelCommon/\" xmlns:res1=\"http://webservices.micros.com/og/4.3/Reservation/\" xmlns:com=\"http://webservices.micros.com/og/4.3/Common/\">\r\n" + 
				"   <soapenv:Header>\r\n" + 
				"      <wsse:Security soapenv:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\r\n" + 
				"         <wsu:Timestamp wsu:Id=\"TS-C2A3BE2EFF54CC56C9155309622850627\">\r\n" + 
				"            <wsu:Created>"+startTime+"</wsu:Created>\r\n" + 
				"            <wsu:Expires>"+endTime+"</wsu:Expires>\r\n" + 
				"         </wsu:Timestamp>\r\n" + 
				"         <wsse:UsernameToken wsu:Id=\"UsernameToken-C2A3BE2EFF54CC56C9155309622492126\">\r\n" + 
				"            <wsse:Username>"+OICusername+"</wsse:Username>\r\n" + 
				"            <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">"+OICpassword+"</wsse:Password>\r\n" + 
				"            <wsse:Nonce EncodingType=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary\">"+Configuration.OICBase64Binary+"</wsse:Nonce>\r\n" + 
				"            <wsu:Created>"+startTime+"</wsu:Created>\r\n" + 
				"         </wsse:UsernameToken>\r\n" + 
				"      </wsse:Security>\r\n" + 
				"      <core:OGHeader\r\n" + 
				"            xmlns=\"http://webservices.micros.com/og/4.3/Core/\" transactionID=\"3297907325\" timeStamp=\"2009-03-08T09:15:27.568125-05:00\" primaryLangID=\"E\">\r\n" + 
				"            <core:Origin entityID=\"KIOSK\" systemType=\"WEB\" />\r\n" + 
				"            <core:Destination entityID=\"KIOSK\" systemType=\"PMS\" />\r\n" + 
				"            <core:Authentication>\r\n" + 
				"                <core:UserCredentials>\r\n" + 
				"                    <core:UserName>"+OWSusername+"</core:UserName>\r\n" + 
				"                    <core:UserPassword>"+OWSpassword+"</core:UserPassword>\r\n" + 
				"                    <core:Domain>"+OWSPropertyCode+"</core:Domain>\r\n" + 
				"                </core:UserCredentials>\r\n" + 
				"            </core:Authentication>\r\n" + 
				"        </core:OGHeader>\r\n" + 
				"   </soapenv:Header>\r\n" + 
				"   <soapenv:Body>\r\n" + 
				"      <res:FutureBookingSummaryRequest summaryOnly=\"false\">\r\n" + 
				"         <res:AdditionalFilters>\r\n" + 
				"            <res1:ResvNameId type=\"INTERNAL\" source=\"RESVID\">"+ReservationNameCode+"</res1:ResvNameId>\r\n" + 
				"         </res:AdditionalFilters>\r\n" + 
				"      </res:FutureBookingSummaryRequest>\r\n" + 
				"   </soapenv:Body>\r\n" + 
				"</soapenv:Envelope>";
		
		return payload;
	}

	public String getHotelsPayload()
	{
		 String payload = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:typ=\"http://xmlns.oracle.com/apps/sales/custExtn/extnService/types/\" xmlns:typ1=\"http://xmlns.oracle.com/adf/svc/types/\"> " + 
				 "  <soapenv:Header /> " + 
				 "  <soapenv:Body> " + 
				 "    <typ:findEntity> " + 
				 "      <typ:findCriteria> " + 
				 "        <typ1:fetchStart>0</typ1:fetchStart> " + 
				 "        <typ1:fetchSize>-1</typ1:fetchSize> " + 
				 "        <!--Optional:--> " + 
				 "        <typ1:findAttribute>Id</typ1:findAttribute> " + 
				 "        <typ1:findAttribute>RecordName</typ1:findAttribute> " + 
				 "        <typ1:findAttribute>HotelName_c</typ1:findAttribute> " + 
				 "        <typ1:findAttribute>PropertyCode_c</typ1:findAttribute> " + 
				 "        <typ1:findAttribute>PmsHotelCode_c</typ1:findAttribute> " + 
				 "      </typ:findCriteria> " + 
				 "      <typ:findControl> " + 
				 "        <typ1:retrieveAllTranslations>false</typ1:retrieveAllTranslations> " + 
				 "      </typ:findControl> " + 
				 "      <typ:objectName>Hotel_c</typ:objectName> " + 
				 "    </typ:findEntity> " + 
				 "  </soapenv:Body> " + 
				 "</soapenv:Envelope> ";
		 
		 return payload;
	}
	
	public String getHotelPayload()
	{
		String payload = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:typ=\"http://xmlns.oracle.com/apps/sales/custExtn/extnService/types/\" xmlns:typ1=\"http://xmlns.oracle.com/adf/svc/types/\"> " + 
				 "  <soapenv:Header /> " + 
				 "  <soapenv:Body> " + 
				 "    <typ:findEntity> " + 
				 "      <typ:findCriteria> " + 
				 "        <typ1:fetchStart>0</typ1:fetchStart> " + 
				 "        <typ1:fetchSize>-1</typ1:fetchSize> " + 
				 "        <!--Optional:--> " + 
				 "        <typ1:findAttribute>Id</typ1:findAttribute> " + 
				 "        <typ1:findAttribute>RecordName</typ1:findAttribute> " + 
				 "        <typ1:findAttribute>HotelName_c</typ1:findAttribute> " + 
				 "        <typ1:findAttribute>PropertyCode_c</typ1:findAttribute> " + 
				 "        <typ1:findAttribute>PmsHotelCode_c</typ1:findAttribute> " +
				 "        <typ1:findAttribute>OrionPropertyCode_c</typ1:findAttribute> " +
				 "      </typ:findCriteria> " + 
				 "      <typ:findControl> " + 
				 "        <typ1:retrieveAllTranslations>false</typ1:retrieveAllTranslations> " + 
				 "      </typ:findControl> " + 
				 "      <typ:objectName>Hotel_c</typ:objectName> " + 
				 "    </typ:findEntity> " + 
				 "  </soapenv:Body> " + 
				 "</soapenv:Envelope> ";
		
		return payload;
	}
	
	public String getAvailVoucherPayload(String VoucherNumber, String MembershipNumber, String PropertyCode, String UsedDate, String IHCLRegisterNumber, String IHCLCheckInDate, String IHCLCheckOutDate )
	{
		String payload = "{\r\n" + 
				"   \"IHCL_spcVoucher_spcOperations_spcWS_spcWebsite_spcV1_Input\":{\r\n" + 
				"      \"ListOfIhclVoucherIo\":{\r\n" + 
				"         \"LoyVoucherAll\":[\r\n" + 
				"            {\r\n" + 
				"               \"IHCLIssuedVoucherNumber\":\""+VoucherNumber+"\",\r\n" + 
				"               \"MembershipNumber\":\""+MembershipNumber+"\",\r\n" + 
				"               \"Status\":\"Used\",\r\n" + 
				"               \"PropertyCode\":\""+PropertyCode+"\",\r\n" + 
				"               \"UsedDate\":\""+UsedDate+"\",\r\n" + 
				"               \"IHCLRegisterNumber\":\""+IHCLRegisterNumber+"\",\r\n" + 
				"               \"IHCLCheckInDate\":\""+IHCLCheckInDate+"\",\r\n" + 
				"               \"IHCLCheckOutDate\":\""+IHCLCheckOutDate+"\"\r\n" + 
				"            }\r\n" + 
				"         ]\r\n" + 
				"      },\r\n" + 
				"      \"Operation\":\"Update\"\r\n" + 
				"   }\r\n" + 
				"}";
		
		return payload;
	}
	
	public String getMembershipProfleInfoPayload(String MembershipNumber)
	{
		String payload = "{\r\n" + 
				"    \"IHCLProfileOperations_Input\": {\r\n" + 
				"        \"ListOfIhclMemberProfileIo\": {\r\n" + 
				"            \"LoyMember\": {\r\n" + 
				"                \"MemberNumber\": \""+MembershipNumber+"\"\r\n" + 
				"            }\r\n" + 
				"        },\r\n" + 
				"        \"ProfileOperation\": \"Query\"\r\n" + 
				"    }\r\n" + 
				"}";
		
		return payload;
	}
	
	/* public String getMembershipProfleInfoPayload(String MembershipNumber)
	{
		String payload = "{\r\n" + 
				"    \"IHCL_spcVoucher_spcOperations_spcWS_spcWebsite_spcV1_Input\": {\r\n" + 
				"        \"ListOfIhclVoucherIo\": {\r\n" + 
				"            \"LoyVoucherAll\": [\r\n" + 
				"                {\r\n" + 
				"                    \"MembershipNumber\": \""+MembershipNumber+"\",\r\n" + 
				"                    \"Status\": \"Available\",\r\n" + 
				"                    \"SourceSystem\": \"PMS\"\r\n" + 
				"                }\r\n" + 
				"            ]\r\n" + 
				"        },\r\n" + 
				"        \"Operation\": \"Query\"\r\n" + 
				"    }\r\n" + 
				"}";
		
		return payload;
	} */
	
	
	
	public String getSiebelCurrencyCodePayload(String fromCurrency, String conversionDate)
	{
		String payload = "{\r\n" + 
				"    \"IHCL_spcExchange_spcRate_spc_Input\": {\r\n" + 
				"        \"To_spcCurrency\": \"INR\",\r\n" + 
				"        \"Exchange_spcType\": \"Daily\",\r\n" + 
				"        \"From_spcCurrency\": \""+fromCurrency+"\",\r\n" + 
				"        \"Exchange_spcDate\": \""+conversionDate+"\"\r\n" + 
				"    }\r\n" + 
				"}";
		
		return payload;
	}

	public String getOffersPayload(String MemberNumber)
	{
		String payload = "{\r\n" + 
				"   \"IHCLMemberOfferQuery_Input\":{\r\n" + 
				"      \"ListOfIhclMemberOfferIo\":{\r\n" + 
				"         \"LoyMember\":[\r\n" + 
				"            {\r\n" + 
				"               \"MemberNumber\":\""+MemberNumber+"\",\r\n" + 
				"               \"Status\":\"\"\r\n" + 
				"            }\r\n" + 
				"         ]\r\n" + 
				"      }\r\n" + 
				"   }\r\n" + 
				"}";
		
		return payload;
	}
	
}
