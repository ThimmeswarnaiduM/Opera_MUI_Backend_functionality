package data;

public class StoreInvoiceDetails {
	
//	public HashMap<String, StoreInvoiceDetails> mapInvoice = new HashMap<>();
	
	public String ReservationID = "";
	public String BillNumber = "";
	public String TotalAmount = "";
	public String BillDate = "";
	public String RoomNumber = "";
		
	public String WindowNo = "";
	public String Name = "";
	public double Amount = 0;
	public double OriginalCurrencyTotalAmount = 0;
		
	public StoreInvoiceDetails() {}
	
	public StoreInvoiceDetails(String windowNo, String name, double amount, double originalCurrencyTotalAmount) {
		super();
		WindowNo = windowNo;
		Name = name;
		Amount = amount;
		OriginalCurrencyTotalAmount = originalCurrencyTotalAmount;
	}
	
	
	public void ClearCache()
	{
		ReservationID = "";
		BillNumber = "";
		TotalAmount = "";
		BillDate = "";
		RoomNumber = "";
			
		WindowNo = "";
		Name = "";
		Amount = 0;
		OriginalCurrencyTotalAmount = 0;
	}
	

	
	

}
