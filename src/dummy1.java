import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import config.SoapExecutor;

public class dummy1 {

public static void main(String[] args) {
	
	String resp = "{\r\n" + 
			"  \"response\": {\r\n" + 
			"    \"status\": {\r\n" + 
			"      \"success\": \"true\",\r\n" + 
			"      \"code\": 200,\r\n" + 
			"      \"message\": \"Success\"\r\n" + 
			"    },\r\n" + 
			"    \"points\": {\r\n" + 
			"      \"redeemable\": {\r\n" + 
			"        \"mobile\": \"3a47110349966c1a27dbd60ec\",\r\n" + 
			"        \"email\": \"3a47110349966c1a27dbd60ecf449714\",\r\n" + 
			"        \"external_id\": \"3a47110349966c1a27dbd60ecf449714\",\r\n" + 
			"        \"points\": 10,\r\n" + 
			"        \"is_redeemable\": \"false\",\r\n" + 
			"        \"points_redeem_value\": 10,\r\n" + 
			"        \"points_redeem_local_value\": 10,\r\n" + 
			"        \"points_currency_ratio\": \"1\",\r\n" + 
			"        \"item_status\": {\r\n" + 
			"          \"success\": \"true\",\r\n" + 
			"          \"code\": 800,\r\n" + 
			"          \"message\": \"Points can be redeemed\"\r\n" + 
			"        }\r\n" + 
			"      }\r\n" + 
			"    },\r\n" + 
			"    \"otpResponse\": {\r\n" + 
			"      \"createdId\": 37765,\r\n" + 
			"      \"warnings\": \"\"\r\n" + 
			"    }\r\n" + 
			"  }\r\n" + 
			"}";
	
		
		try {
			
			JSONObject objResp = new JSONObject();
			
			JSONObject objectMember = new JSONObject(resp);
			JSONObject objPoints = objectMember.getJSONObject("response").getJSONObject("points").getJSONObject("redeemable");
			String isRedeemable = objPoints.getString("is_redeemable");
			
			if(isRedeemable.equals("false"))
			{
				String msg = objPoints.getJSONObject("item_status").getString("message");
				objResp.put("status", "FAILURE");
				objResp.put("msg", msg);
			} else
			{
				objResp.put("status", "SUCCESS");
			}
			
			System.out.println(objResp.toString());
		        
		        
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
        
	}
}
