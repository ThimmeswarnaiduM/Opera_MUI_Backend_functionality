package data;

import java.util.HashMap;

public class StoreInvoiceDataMap {
	private HashMap<String, StoreInvoiceDetails> storeInvoices = new HashMap<>(0);
	
	public void addStoreInvoices(String windowNumber, StoreInvoiceDetails storeInvoiceDetails) {
		this.storeInvoices.put(windowNumber, storeInvoiceDetails);
	}
	
	public HashMap<String, StoreInvoiceDetails> getstoreInvoices(){
		return this.storeInvoices;
	}
	
}
