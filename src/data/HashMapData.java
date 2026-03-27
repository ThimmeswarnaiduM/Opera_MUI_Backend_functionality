package data;

import java.util.HashMap;

import config.*;


public class HashMapData {

	public static HashMap<String, Double> mapCurrency = new HashMap<String, Double>();
	public static HashMap<String, String> mapCurrencyCode = new HashMap<String, String>();
	public static HashMap<String, GetMemberData> mapMemberData = new HashMap<String, GetMemberData>();
	public static HashMap<String, GetProfileData> mapProfileData = new HashMap<String, GetProfileData>();
	public static HashMap<String, GetReservationData> mapReservationData = new HashMap<String, GetReservationData>();
	public static HashMap<String, StoreInvoiceDetails> mapInvoiceData = new HashMap<String, StoreInvoiceDetails>();
	
	public static HashMap<String, StoreInvoiceDataMap> mapInvoices = new HashMap<String, StoreInvoiceDataMap>();
	
	public static HashMap<String, ProcessInvoicesData> mapProcessInvoices = new HashMap<String, ProcessInvoicesData>();
	
	public static HashMap<String, NewInvoicesData> mapNewInvoices = new HashMap<String, NewInvoicesData>();
	
	public static HashMap<String, GiftCardData> mapGiftCard = new HashMap<String, GiftCardData>();
	
	public static HashMap<String, GetVouchersData> mapVoucher = new HashMap<String, GetVouchersData>();
	
	public static HashMap<String, String> mapBatchNumber = new HashMap<String, String>();
	
	public static HashMap<String, String> mapHotels = new HashMap<String, String>();
	
	public static HashMap<String, String> mapOrionCode = new HashMap<String, String>();
	
	public static HashMap<String, String> mapGcHotelsMap = new HashMap<String, String>();
	
}
