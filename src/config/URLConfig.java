package config;

import java.util.HashMap;

public class URLConfig {

	
	public static String getInvoiceWSDL(String OWSPropertyCode)
	{
		if(owsOpera5005(OWSPropertyCode))
		{
			return Configuration.InvoiceOP5005WSDL;
		} else if(owsOpera5500(OWSPropertyCode)) 
		{
			return Configuration.InvoiceOP5500WSDL;
		}else if(owsOpera500511(OWSPropertyCode))
		{
			return Configuration.InvoiceOP500511WSDL;
		} 
		else if(owsOpera5612(OWSPropertyCode))
		{
			return Configuration.InvoiceOP5612WSDL;
		}
		else if(owsIDS(OWSPropertyCode))
		{
			return Configuration.InvoiceIDSWSDL;
		} else if(owsIDSAMA(OWSPropertyCode))
		{
			return Configuration.InvoiceIDSAMA;
		} else if(owsOperaCentralOCI(OWSPropertyCode))
		{
			return Configuration.InvoiceCentralOCIWSDL;
		}else if(owsOperaCentralOperaCloud(OWSPropertyCode))
		{
			return Configuration.InvoiceWSDLOperaCloud;
		}
		else
			
			return Configuration.InvoiceWSDL;
	}
	public static String getInvoiceActionUrl(String OWSPropertyCode)
	{
		if(owsOpera5005(OWSPropertyCode))
		{
			return Configuration.InvoiceOP5005ActionURL;
		} else if(owsOpera5500(OWSPropertyCode))
		{
			return Configuration.InvoiceOP5500ActionURL;
		}else if(owsOpera500511(OWSPropertyCode))
		{
			return Configuration.InvoiceOP500511ActionURL;
		}
		else if(owsOpera5612(OWSPropertyCode))
		{
			return Configuration.InvoiceOP5612ActionURL;
		}
		else if(owsIDS(OWSPropertyCode))
		{
			return Configuration.InvoiceIDSActionURL;
		} else if(owsIDSAMA(OWSPropertyCode))
		{
			return Configuration.InvoiceIDSAMAActionURL;
		} else if(owsOperaCentralOCI(OWSPropertyCode))
		{
			return Configuration.InvoiceCentralOCIActionURL;
		}else
			return Configuration.InvoiceActionURL;
	}
	
	
	public static String getFutureBookingSummaryWSDL(String OWSPropertyCode)
	{
		if(owsOpera5005(OWSPropertyCode))
		{
			return Configuration.GetFutureBookingSummaryOP5005WSDL;
		} else  if(owsOpera5500(OWSPropertyCode)) 
		{
			return Configuration.GetFutureBookingSummaryOP5500WSDL;
		}else if(owsOpera500511(OWSPropertyCode))
		{
			return Configuration.GetFutureBookingSummaryOP500511WSDL;
		}
		else if(owsOpera5612(OWSPropertyCode))
		{
			return Configuration.GetFutureBookingSummaryOP5612WSDL;
		}
		else if(owsIDS(OWSPropertyCode))
		{
			return Configuration.GetFutureBookingSummaryIDSWSDL;
		} else if(owsIDSAMA(OWSPropertyCode))
		{
			return Configuration.GetFutureBookingSummaryIDSAMA;
		} else if(owsOperaCentralOCI(OWSPropertyCode))
		{
			return Configuration.GetFutureBookingSummaryCentralOCIWSDL;
		}
		else if(owsOperaCentralOperaCloud(OWSPropertyCode))
		{
			return Configuration.GetFutureBookingSummaryOperaCloudWSDL;
		}
		else
			return null;
	}
	public static String getFutureBookingSummaryActionUrl(String OWSPropertyCode)
	{
		if(owsOpera5005(OWSPropertyCode))
		{
			return Configuration.GetFutureBookingSummaryOP5005ActionURL;
		} else  if(owsOpera5500(OWSPropertyCode))
		{
			return Configuration.GetFutureBookingSummaryOP5500ActionURL;
		}else if(owsOpera500511(OWSPropertyCode))
		{
			return Configuration.GetFutureBookingSummaryOP500511ActionURL;
		}
		else if(owsOpera5612(OWSPropertyCode))
		{
			return Configuration.GetFutureBookingSummaryOP5612ActionURL;
		}
		else if(owsIDS(OWSPropertyCode))
		{
			return Configuration.GetFutureBookingSummaryIDSActionURL;
		}		else if(owsIDSAMA(OWSPropertyCode))
		{
			return Configuration.GetFutureBookingSummaryIDSAMAActionURL;
		} else if(owsOperaCentralOCI(OWSPropertyCode))
		{
			return Configuration.GetFutureBookingSummaryCentralOCIActionURL;
		}
		else if(owsOperaCentralOperaCloud(OWSPropertyCode))
		{
			return Configuration.GetFutureBookingSummaryOperaCloudActionURL;
		}
		else
			return Configuration.GetFutureBookingSummaryActionURL;
	}
	
	
	public static String getMakePaymentWSDL(String OWSPropertyCode)
	{
		if(owsOpera5005(OWSPropertyCode))
		{
			return Configuration.MakePaymentOP5005WSDL;
		} else  if(owsOpera5500(OWSPropertyCode)) 
		{
			return Configuration.MakePaymentOP5500WSDL;
		}else if(owsOpera500511(OWSPropertyCode))
		{
			return Configuration.MakePaymentOP500511WSDL;
		}
		else if(owsOpera5612(OWSPropertyCode))
		{
			return Configuration.MakePaymentOP5612WSDL;
		}
		else if(owsIDS(OWSPropertyCode))
		{
			return Configuration.MakePaymentIDSWSDL;
		} else if(owsIDSAMA(OWSPropertyCode))
		{
			return Configuration.MakePaymentIDSAMA;
		} else if(owsOperaCentralOCI(OWSPropertyCode))
		{
			return Configuration.MakePaymentCentralOCIWSDL;
		} 
		else if(owsOperaCentralOperaCloud(OWSPropertyCode))
		{
			return Configuration.MakePaymentOperaCloudWSDL;
		}
		else
			return Configuration.MakePaymentWSDL;
	}
	public static String getMakePaymentActionUrl(String OWSPropertyCode)
	{
		if(owsOpera5005(OWSPropertyCode))
		{
			return Configuration.MakePaymentOP5005ActionURL;
		} else  if(owsOpera5500(OWSPropertyCode)) 
		{
			return Configuration.MakePaymentOP5500ActionURL;
		}else if(owsOpera500511(OWSPropertyCode))
		{
			return Configuration.MakePaymentOP500511ActionURL;
		}
		else if(owsOpera5612(OWSPropertyCode))
		{
			return Configuration.MakePaymentOP5612ActionURL;
		}
		else if(owsIDS(OWSPropertyCode))
		{
			return Configuration.MakePaymentIDSActionURL;
		} else if(owsIDSAMA(OWSPropertyCode))
		{
			return Configuration.MakePaymentIDSAMAActionURL;
		}  else if(owsOperaCentralOCI(OWSPropertyCode))
		{
			return Configuration.MakePaymentCentralOCIActionURL;
		}else if(owsOperaCentralOperaCloud(OWSPropertyCode))
		{
			return Configuration.MakePaymentOperaCloudActionURL;
		}
		else
			return Configuration.MakePaymentActionURL;
	}
	
	public static Boolean owsOpera5005(String OWSPropertyCode)
	{
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("LONSJ", "LONSJ");
		hashMap.put("51BG", "51BG");
		
		String isHas = hashMap.get(OWSPropertyCode);
		
		if (isHas == null) {
			return false;
		}
		if (isHas.equals(OWSPropertyCode)) {
			return true;
		} else 
			return false;
	}
	
	public static Boolean owsOpera5500(String OWSPropertyCode)
	{
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("NYCTP", "NYCTP");
		//hashMap.put("DXBJL", "DXBJL");
		
		String isHas = hashMap.get(OWSPropertyCode);
		
		if (isHas == null) {
			return false;
		}
		if (isHas.equals(OWSPropertyCode)) {
			return true;
		} else 
			return false;
	}
	
	public static Boolean owsOpera500511(String OWSPropertyCode)
	{
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("LGKTR", "LGKTR");
		
		String isHas = hashMap.get(OWSPropertyCode);
		
		if (isHas == null) {
			return false;
		}
		if (isHas.equals(OWSPropertyCode)) {
			return true;
		} else 
			return false;
	}
	
	public static Boolean owsOpera5612(String OWSPropertyCode)
	{
		HashMap<String, String> hashMap = new HashMap<String, String>();
//		hashMap.put("IXBCK", "IXBCK");
//		hashMap.put("AMDTS", "AMDTS");
//		hashMap.put("MAAWM", "MAAWM");
//		hashMap.put("TRVVT", "TRVVT");
//		hashMap.put("DEDHW", "DEDHW");
//		hashMap.put("BBIVB", "BBIVB");
//		hashMap.put("BHOTL", "BHOTL");
//		hashMap.put("GOIVM", "GOIVM");
//		hashMap.put("PYGVS", "PYGVS");
//	//	hashMap.put("DXBTE", "DXBTE");
//		hashMap.put("CCURK", "CCURK");
//		hashMap.put("BOMNT", "BOMNT");
//		hashMap.put("CCUNT", "CCUNT");
//		hashMap.put("IXJVK", "IXJVK");
//		hashMap.put("AMDVA", "AMDVA");

		
		String isHas = hashMap.get(OWSPropertyCode);
		
		if (isHas == null) {
			return false;
		}
		if (isHas.equals(OWSPropertyCode)) {
			return true;
		} else 
			return false;
	}
	
	
	public static Boolean owsIDS(String OWSPropertyCode)
	{
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("IDS6825", "IDS6825");
		
		String isHas = hashMap.get(OWSPropertyCode);
		
		if (isHas == null) {
			return false;
		}
		if (isHas.equals(OWSPropertyCode)) {
			return true;
		} else 
			return false;
	}
	public static Boolean owsIDSAMA(String OWSPropertyCode)
	{
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("IDS7520", "IDS7520");
		hashMap.put("IDS7574", "IDS7574");
		hashMap.put("IDS7575", "IDS7575");
		hashMap.put("IDS7565", "IDS7565");
		hashMap.put("IDS7522", "IDS7522");
		hashMap.put("IDS7716", "IDS7716");
		hashMap.put("IDS7728", "IDS7728");
		hashMap.put("IDS7747", "IDS7747");
		hashMap.put("IDS7851", "IDS7851");
		hashMap.put("IDS7859", "IDS7859");
		hashMap.put("IDS7841", "IDS7841");
		hashMap.put("IDS7846", "IDS7846");
		hashMap.put("IDS7915", "IDS7915");
		hashMap.put("IDS7958", "IDS7958");
		hashMap.put("IDS7983", "IDS7983");
		hashMap.put("IDS7991", "IDS7991");
		hashMap.put("IDS7990", "IDS7990");
		hashMap.put("IDS8049", "IDS8049");
		hashMap.put("IDS8044", "IDS8044");
		hashMap.put("IDS8051", "IDS8051");
		hashMap.put("IDS8066", "IDS8066");
		hashMap.put("IDS8097", "IDS8097");
		hashMap.put("IDS8099", "IDS8099");
		hashMap.put("IDS8111", "IDS8111");
		hashMap.put("IDS8095", "IDS8095");
		hashMap.put("IDS8100", "IDS8100");
		hashMap.put("IDS8101", "IDS8101");
		hashMap.put("IDS8096", "IDS8096");
		hashMap.put("IDS8110", "IDS8110");
		hashMap.put("IDS8098", "IDS8098");
		hashMap.put("IDS8050", "IDS8050");
		hashMap.put("IDS8149", "IDS8149");
		hashMap.put("IDS8130", "IDS8130");
		hashMap.put("IDS8147", "IDS8147");
		hashMap.put("IDS30002", "IDS30002");
		hashMap.put("IDS8350", "IDS8350");
		hashMap.put("IDS30002", "IDS30002");
		

		
		String isHas = hashMap.get(OWSPropertyCode);
		
		if (isHas == null) {
			return false;
		}
		if (isHas.equals(OWSPropertyCode)) {
			return true;
		} else 
			return false;
	}
	public static Boolean owsOperaCentralOCI(String OWSPropertyCode)
	{
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("CCJTW","CentralOCI");
		hashMap.put("SHLVS","CentralOCI");
		hashMap.put("JAITA","CentralOCI");
		hashMap.put("DHMNM","CentralOCI");
		hashMap.put("LKOJM","CentralOCI");
		hashMap.put("KUUBM","CentralOCI");
		hashMap.put("GOXYH","CentralOCI");
		hashMap.put("AMDTG","CentralOCI");
		hashMap.put("IXJVJ","CentralOCI");
		hashMap.put("BBITC","CentralOCI");
		hashMap.put("IDRWC","CentralOCI");
		hashMap.put("PYGTG","CentralOCI");
		hashMap.put("CCUTK","CentralOCI");
		hashMap.put("TEZVT","CentralOCI");
		hashMap.put("JSAGP","CentralOCI");
		hashMap.put("JAISR","CentralOCI");
		hashMap.put("TIRBT","CentralOCI");
		hashMap.put("COKSM","CentralOCI");
		hashMap.put("IXWVJ","CentralOCI");
		hashMap.put("JAIRG","CentralOCI");
		hashMap.put("PNQFM","CentralOCI");
		hashMap.put("PATCP","CentralOCI");
		hashMap.put("IXEGB","CentralOCI");
		
		String isHas = hashMap.get(OWSPropertyCode);
		
		if (isHas == null) {
			return false;
		}
//		if (isHas.equals(OWSPropertyCode)) {//CentralOCI not equals shlvs
//			return true;
//		} 
		if (isHas.equals("CentralOCI")) {
			return true;
		} else 
			return false;
	}
	
	public static Boolean owsOperaCentralOperaCloud(String OWSPropertyCode)
	{
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("GOITE","OperaCloud");
		hashMap.put("GOIVI","OperaCloud");
		hashMap.put("GOITH","OperaCloud");
		hashMap.put("GOIFA","OperaCloud");
		hashMap.put("GOITC","OperaCloud");
		hashMap.put("GOICD","OperaCloud");
		hashMap.put("BOMTP","OperaCloud");
		hashMap.put("BOMWM","OperaCloud");
		hashMap.put("BOMTS","OperaCloud");
		hashMap.put("ISKTR","OperaCloud");
		hashMap.put("PNQBD","OperaCloud");
		hashMap.put("PNQHI","OperaCloud");
		hashMap.put("IXUTR","OperaCloud");
		hashMap.put("BLRIT","OperaCloud");
		hashMap.put("BLRGH","OperaCloud");
		hashMap.put("BLRTB","OperaCloud");
		hashMap.put("BLRYE","OperaCloud");
		hashMap.put("BLRTR","OperaCloud");
		hashMap.put("BLRWE","OperaCloud");
		hashMap.put("BLRTG","OperaCloud");
		hashMap.put("IXECO","OperaCloud");
		hashMap.put("GOILE","OperaCloud");
		hashMap.put("IXEVI","OperaCloud");
		hashMap.put("IXEMH","OperaCloud");
		hashMap.put("MAACN","OperaCloud");
		hashMap.put("MAAFC","OperaCloud");
		hashMap.put("MAATC","OperaCloud");
		hashMap.put("MAAGH","OperaCloud");
		hashMap.put("MAAMR","OperaCloud");
		hashMap.put("TIRTT","OperaCloud");
		hashMap.put("CJBVI","OperaCloud");
		hashMap.put("IXMTG","OperaCloud");
		hashMap.put("CJBSH","OperaCloud");
		hashMap.put("CJBTG","OperaCloud");
		hashMap.put("BOMLE","OperaCloud");
		hashMap.put("BOMTM","OperaCloud");
		hashMap.put("BOMPA","OperaCloud");
		hashMap.put("COKTR","OperaCloud");
		hashMap.put("COKTM","OperaCloud");
		hashMap.put("CCJTR","OperaCloud");
		hashMap.put("COKTG","OperaCloud");
		hashMap.put("TRVGR","OperaCloud");
		hashMap.put("TRVTG","OperaCloud");
		hashMap.put("AGRCC","OperaCloud");
		hashMap.put("AGRTV","OperaCloud");
		hashMap.put("VNSTG","OperaCloud");
		hashMap.put("VNSTP","OperaCloud");
		hashMap.put("GWLUK","OperaCloud");
		hashMap.put("LKOTR","OperaCloud");
		hashMap.put("BDQTR","OperaCloud");
		hashMap.put("DIUGF","OperaCloud");
		hashMap.put("JPRDR","OperaCloud");
		hashMap.put("COKIC","OperaCloud");
		hashMap.put("JAIJM","OperaCloud");
		hashMap.put("JAISM","OperaCloud");
		hashMap.put("JAIRP","OperaCloud");
		hashMap.put("JAIAJ","OperaCloud");
		hashMap.put("PGHCO","OperaCloud");
		hashMap.put("SLVTT","OperaCloud");
		hashMap.put("DEDTR","OperaCloud");
		hashMap.put("DEDAK","OperaCloud");
		hashMap.put("IXCTC","OperaCloud");
		hashMap.put("UDRTA","OperaCloud");
		hashMap.put("ATQTA","OperaCloud");
		hashMap.put("UDRTL","OperaCloud");
		hashMap.put("UDRFP","OperaCloud");
		hashMap.put("HYDTK","OperaCloud");
		hashMap.put("HYDFP","OperaCloud");
		hashMap.put("PGHNH","OperaCloud");
		hashMap.put("DEDTD","OperaCloud");
		hashMap.put("DELTP","OperaCloud");
		hashMap.put("DELTA","OperaCloud");
		hashMap.put("DELTM","OperaCloud");
		hashMap.put("HYDVI","OperaCloud");
		hashMap.put("HYDTD","OperaCloud");
		hashMap.put("DELGU","OperaCloud");
		hashMap.put("DELCP","OperaCloud");
		hashMap.put("VGAGH","OperaCloud");
		hashMap.put("SXRSR","OperaCloud");
		hashMap.put("JDHTH","OperaCloud");
		hashMap.put("GAUTG","OperaCloud");
		hashMap.put("DELSU","OperaCloud");//standlone
		hashMap.put("DELDA","OperaCloud");
		hashMap.put("CMBTA","OperaCloud");
		hashMap.put("CMBTE","OperaCloud");
		hashMap.put("MLETC","OperaCloud");
		hashMap.put("MLETE","OperaCloud");
		hashMap.put("CMBTS","OperaCloud");
		hashMap.put("DELDW","OperaCloud");
		hashMap.put("IXZTE","OperaCloud");
		hashMap.put("JAIML","OperaCloud");
		hashMap.put("BOMTT","OperaCloud");//OCI
		hashMap.put("JDHUB","OperaCloud");
		hashMap.put("CCUBK","OperaCloud");
		hashMap.put("CCUEM","OperaCloud");
		hashMap.put("DIUFH","OperaCloud");
		hashMap.put("DXBJL","OperaCloud");
		hashMap.put("DXBTD","OperaCloud");
		hashMap.put("DXBTE","OperaCloud");
		hashMap.put("DELTC","OperaCloud");
		hashMap.put("CNNGC","OperaCloud");
		hashMap.put("NAGBV","OperaCloud");
		hashMap.put("JLRMK","OperaCloud");
		hashMap.put("JLRBT","OperaCloud");
		hashMap.put("HJRPG","OperaCloud");
		hashMap.put("AGXBP","OperaCloud");
		hashMap.put("AGXBR","OperaCloud");
		hashMap.put("BOMTA","OperaCloud");
		hashMap.put("DIUGD","OperaCloud");
		hashMap.put("BOMTH","OperaCloud");
		hashMap.put("GOIGP","OperaCloud");
		hashMap.put("CCUGK","OperaCloud");
		hashMap.put("JAIGH","OperaCloud");
		hashMap.put("JLRBA","OperaCloud");
		hashMap.put("PGHCT","OperaCloud");
		hashMap.put("AMDDA","OperaCloud");
		hashMap.put("DECDE","OperaCloud");
		hashMap.put("DHMBC","OperaCloud");
		hashMap.put("IXBMH","OperaCloud");
		hashMap.put("JAISP","OperaCloud");
		hashMap.put("JDHBH","OperaCloud");
		hashMap.put("PGHJH","OperaCloud");
		hashMap.put("JAIUD","OperaCloud");
		hashMap.put("DEDJO","OperaCloud");
		hashMap.put("VNSVA","OperaCloud");
		hashMap.put("UDRCA","OperaCloud");
		hashMap.put("CDRAR","OperaCloud");
		hashMap.put("AMDGA","OperaCloud");
		hashMap.put("UDRLB","OperaCloud");
		hashMap.put("BDQEN","OperaCloud");
		hashMap.put("DEDHN","OperaCloud");
		hashMap.put("COKVA","OperaCloud");
		hashMap.put("VNSAV","OperaCloud");
		hashMap.put("BDQNS","OperaCloud");
		hashMap.put("PBHTP","OperaCloud");
		hashMap.put("PBHGR","OperaCloud");
		hashMap.put("FRATA","OperaCloud");
		hashMap.put("DEDGD","OperaCloud");
		hashMap.put("MAAWM","OperaCloud");
		hashMap.put("JAIGA","OperaCloud");
		hashMap.put("BHUGB","OperaCloud");
		hashMap.put("JAIGR","OperaCloud");
		hashMap.put("BDQGV","OperaCloud");
		hashMap.put("AMDGK","OperaCloud");
		hashMap.put("DEDTH","OperaCloud");
		
		
		
String isHas = hashMap.get(OWSPropertyCode);
		
		if (isHas == null) {
			return false;
		}
//		if (isHas.equals(OWSPropertyCode)) {//CentralOCI not equals shlvs
//			return true;
//		} 
		if (isHas.equals("OperaCloud")) {
			return true;
		} else 
			return false;
	}
	
	
}
