package config;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import data.HashMapData;

public class GetHotelsData {
	
	public static String getHotel(String tmpPMSHotelCode)
	{
		String tmpPropertyCode = "";
		
		String WSDL1 = Configuration.SalesCustomObjectServiceWSDL;
		String Action1 = Configuration.SalesCustomObjectServiceAction;
		
		String userName = Configuration.MDMUsername;
		String password = Configuration.MDMPassword;
		
		ConfigPayloads payloads = new ConfigPayloads();
		
		String payload = payloads.getHotelPayload();

		SoapExecutor soapExecutor = new SoapExecutor(WSDL1);
		String responce = soapExecutor.executeRequest(userName, password, Action1,payload);
		System.out.println("Hotel: \n"+responce);
		Document doc = soapExecutor.convertStringToDocument(responce);
		
		NodeList nList = doc.getElementsByTagName("ns0:findEntityResponse");
		
		
		
		Element eleHotel = (Element) nList.item(0);
		NodeList nListHotel =  eleHotel.getElementsByTagName("ns2:result");
		System.out.println("nListHotel: ");
		for(int i=0; i<nListHotel.getLength(); i++)
		{
			Element ele = (Element) nListHotel.item(i);
			
//			String ID = soapExecutor.getValue(ele, "ns1:Id");
//			String RecordName = soapExecutor.getValue(ele, "ns1:RecordName");
//			String HotelName = soapExecutor.getValue(ele, "ns1:HotelName_c");
			String PropertyCode = soapExecutor.getValue(ele, "ns1:PropertyCode_c");
			String PMSHotelCode = soapExecutor.getValue(ele, "ns1:PmsHotelCode_c");
			String OrionCode = soapExecutor.getValue(ele, "ns1:OrionPropertyCode_c");
			
			HashMapData.mapHotels.put(PMSHotelCode, PropertyCode);
			HashMapData.mapOrionCode.put(PMSHotelCode, OrionCode);
			System.out.println("PMSHotelCode: "+PMSHotelCode+"OrionCode_ : "+OrionCode);
		}
		
		tmpPropertyCode = HashMapData.mapHotels.get(tmpPMSHotelCode);
		
		return tmpPropertyCode;
	}
	
	public String getProperty(String PMSHotelCode)
	{
		String PropertyCode = "";
		
		try {
		
			PropertyCode = HashMapData.mapHotels.get(PMSHotelCode);
			
			if(PropertyCode.equalsIgnoreCase("") || PropertyCode == null || PropertyCode.equalsIgnoreCase("null"))
			{
				GetHotelsData hotelsData = new GetHotelsData();
				PropertyCode = hotelsData.getHotel(PMSHotelCode);
			} else 
			{
				GetHotelsData hotelsData = new GetHotelsData();
				PropertyCode = hotelsData.getHotel(PMSHotelCode);
			}
		}catch(Exception e)
		{
			//e.printStackTrace();
			GetHotelsData hotelsData = new GetHotelsData();
			PropertyCode = hotelsData.getHotel(PMSHotelCode);
		}
		
		return PropertyCode;
	}

}
