package data;

import org.json.JSONArray;

public class ProcessInvoicesData {
	
	public String rq = "";
	
	public String FirstName = "";
	public String LastName = "";
	public String Salutation = "";
	public String Gender = "";
	public String Email = "";
	public String Phone = "";
	public String PartyId = "";
	public String PartyNumber = "";
	public String MembershipType = "";
	public String EnrollNumber_c = "";
	public String DateOfBirth = "";
	public String Address1 = "";
	public String Address2 = "";
	public String Address3 = "";
	public String Address4 = "";
	public String city = "";
	public String state = "";
	public String country = "";
	public String postal = "";
	
	
	//redeem points variables
	public String PaymentTransID = "";
	public String PaymentType = "Points";
	public String TransactionComments = "";
	public String RoomType = "";
	public String CheckOutDate = "";
	public String BillNo = "";
	public String RegisterNumber = "";
	public String BookingSource = "";
	public String RoomNumber = "";
	public String Amount = "";
	public int intAmount = 0;
	public String TransactionChannel = "";
	public String MemberNumber = "";
	public String MemberCardNumber = "";
	public String CheckInDate = "";
	public String BookingDate = "";
	public String BillDate = "";
	public String RedeemPoints = "";
	public String Quantity = "1";
	public String ProductName = "Stay";
	public String PointsRedeemedType = "";
	
	public String TotalAmount = "";
	public String TotalPoints = "";

	
	public int InvoiceCount = 0;
	
	public String[] strWindowNo;
	public String[] strName;
	public String[] strAmount;
	public String[] strOrigCurrencyAmount;
	
	public String ConversionType = "";
	public String PaymentCardType = "";
	
	public  static JSONArray arrRequest = null;
	
	
	public String GCPayType = "";
	
	public String GiftCardNumber = "";
	public String GiftCardPin = "";
	public String GiftCardTrackData = "";
	public String GCBillAmount = "";
	
	public String ConfirmationNo = "";
		
	public String URLReservationNumber = "";
	public String URLPropertyCode = "";

	public void clearCache()
	{
		rq = "";

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


		//redeem points variables
		PaymentTransID = "";
		PaymentType = "Points";
		TransactionComments = "";
		RoomType = "";
		CheckOutDate = "";
		BillNo = "";
		RegisterNumber = "";
		BookingSource = "";
		RoomNumber = "";
		Amount = "";
		intAmount = 0;
		TransactionChannel = "";
		MemberNumber = "";
		MemberCardNumber = "";
		CheckInDate = "";
		BookingDate = "";
		BillDate = "";
		RedeemPoints = "";
		Quantity = "1";
		ProductName = "Stay";
		PointsRedeemedType = "";

		TotalAmount = "";
		TotalPoints = "";


		InvoiceCount = 0;

		strWindowNo = null;
		strName = null;
		strAmount = null;
		strOrigCurrencyAmount = null;

		ConversionType = "";
		PaymentCardType = "";

		arrRequest = null;


		GCPayType = "";

		GiftCardNumber = "";
		GiftCardPin = "";
		GiftCardTrackData = "";
		ConfirmationNo = "";
			
		URLReservationNumber = "";
		URLPropertyCode = "";
	}
	
}
