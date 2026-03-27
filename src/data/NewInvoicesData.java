package data;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import config.SoapExecutor;

public class NewInvoicesData {
	
	public SoapExecutor soapExecutor = null;
	public Document doc = null;
	public Element Ele = null;
	public NodeList nList = null;
	public NodeList nListBillInvoice = null;

	public String AddressLine = "";
	public String FirstName = "";
	public String LastName = "";
	public String CountryCode = "";
	public String PMSId = "";
	public double CurrentBalance = 0;

	public String MembershipNumber = "";
	public String TICPointsBalance = "";
	public String EpicurePointsBalance = "";
	public String MembershipTier = "";
	public String MembershipNumberTPM = "";
	public  String MembershipNumberTIC = "";
	public String MembershipNumberCH="";
	public String MembershipNumberEPI="";
	
	public String membershipNumber="";
	public String membershipType_="";
	public String membershipTier="";
	public String Reservation_Status="";
	
	public String EPIMemberLevel="";
	public String CHMemberLevel="";

	public String PropertyCode = "";
	public String ReservationStatus = "";
	public String Reservation_status = "";

	public String PMSProfileID = "";
	public String MDMProfileID = "";
	public String MDMPartyNumber = "";

	public String ResId = "";
	public String invoiceResponse = "";
	
	public String URLPropertyCode = "";

	public void clearCache()
	{
		soapExecutor = null;
		doc = null;
		Ele = null;
		nList = null;
		nListBillInvoice = null;

		AddressLine = "";
		FirstName = "";
		LastName = "";
		CountryCode = "";
		PMSId = "";
		CurrentBalance = 0;

		MembershipNumber = "";
		TICPointsBalance = "";
		EpicurePointsBalance = "";
		MembershipTier = "";
		MembershipNumberTPM = "";
		MembershipNumberTIC = "";
		MembershipNumberCH = "";
		MembershipNumberEPI = "";
 
		PropertyCode = "";
		ReservationStatus = "";

		PMSProfileID = "";
		MDMProfileID = "";
		MDMPartyNumber = "";

		ResId = "";
		invoiceResponse = "";

		URLPropertyCode = "";
	}
	
}
