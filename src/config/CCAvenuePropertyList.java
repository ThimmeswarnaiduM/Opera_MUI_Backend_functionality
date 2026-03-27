package config;

import java.util.HashMap;

public class CCAvenuePropertyList {
	
	public static HashMap<String, String> mapCCMUI = new HashMap<String, String>();
	
	static void initMap()
	{
		mapCCMUI.put("BOMLE", "BOMLE");
		//mapCCMUI.put("BLRWE", "BLRWE");
//		mapCCMUI.put("IXCTC", "IXCTC");
//		mapCCMUI.put("JAIML", "JAIML");
	}
	
	public static boolean getCCMUI(String propertyCode)
	{
		initMap();
		
		try {
			
			String property = mapCCMUI.get(propertyCode);
			if(propertyCode.equalsIgnoreCase(property))
				return true;
			else
				return false;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

}
