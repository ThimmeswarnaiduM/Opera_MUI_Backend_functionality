import org.json.JSONObject;

public class dummyValidateOTP {

	@SuppressWarnings("unused")
	public static void main(String a[])
	{
		try {
			
			String resp = "{\r\n" + 
					"   \"status\":\"SUCCESS\",\r\n" + 
					"   \"errorCode\":null,\r\n" + 
					"   \"errorText\":null,\r\n" + 
					"   \"responseValue\":null,\r\n" + 
					"   \"errorTokenList\":null,\r\n" + 
					"   \"success\":true,\r\n" + 
					"   \"failure\":false\r\n" + 
					"}";
			
			String resp1 = "{\r\n" + 
					"   \"status\":\"FAILURE\",\r\n" + 
					"   \"errorCode\":null,\r\n" + 
					"   \"errorText\":null,\r\n" + 
					"   \"responseValue\":null,\r\n" + 
					"   \"errorTokenList\":null,\r\n" + 
					"   \"failure\":true,\r\n" + 
					"   \"success\":false\r\n" + 
					"}";
			
			String resp2 = "{\r\n" + 
					"   \"status\":\"FAILURE\",\r\n" + 
					"   \"errorCode\":\"INVALID_ARGUMENTS\",\r\n" + 
					"   \"errorText\":\"Provided username is invalid.\",\r\n" + 
					"   \"responseValue\":null,\r\n" + 
					"   \"errorTokenList\":[\r\n" + 
					"      {\r\n" + 
					"         \"className\":null,\r\n" + 
					"         \"fieldName\":\"username\",\r\n" + 
					"         \"message\":\"Provided username is invalid.\",\r\n" + 
					"         \"lengthConstraint\":null,\r\n" + 
					"         \"value\":\"VOTP1101\"\r\n" + 
					"      }\r\n" + 
					"   ],\r\n" + 
					"   \"failure\":true,\r\n" + 
					"   \"success\":false\r\n" + 
					"}";
			
			String resp3 = "{\r\n" + 
					"   \"status\":\"FAILURE\",\r\n" + 
					"   \"errorCode\":\"INVALID_PRINCIPAL\",\r\n" + 
					"   \"errorText\":\"Unable to locate user with provided username.\",\r\n" + 
					"   \"responseValue\":null,\r\n" + 
					"   \"errorTokenList\":[\r\n" + 
					"      {\r\n" + 
					"         \"className\":null,\r\n" + 
					"         \"fieldName\":\"username\",\r\n" + 
					"         \"message\":\"Unable to locate user with provided username.\",\r\n" + 
					"         \"lengthConstraint\":null,\r\n" + 
					"         \"value\":\"VOTP1102\"\r\n" + 
					"      }\r\n" + 
					"   ],\r\n" + 
					"   \"failure\":true,\r\n" + 
					"   \"success\":false\r\n" + 
					"}";
			
			String resp4 = "{\r\n" + 
					"   \"status\":\"FAILURE\",\r\n" + 
					"   \"errorCode\":\"INVALID_ARGUMENTS\",\r\n" + 
					"   \"errorText\":\"Provided otp is invalid.\",\r\n" + 
					"   \"responseValue\":null,\r\n" + 
					"   \"errorTokenList\":[\r\n" + 
					"      {\r\n" + 
					"         \"className\":null,\r\n" + 
					"         \"fieldName\":\"otp\",\r\n" + 
					"         \"message\":\"Provided otp is invalid.\",\r\n" + 
					"         \"lengthConstraint\":null,\r\n" + 
					"         \"value\":\"VOTP1103\"\r\n" + 
					"      }\r\n" + 
					"   ],\r\n" + 
					"   \"failure\":true,\r\n" + 
					"   \"success\":false\r\n" + 
					"}";
			
			
//			JSONObject jsonObject = new JSONObject(resp);
//			JSONObject jsonObject = new JSONObject(resp1);
//			JSONObject jsonObject = new JSONObject(resp2);
//			JSONObject jsonObject = new JSONObject(resp3);
			JSONObject jsonObject = new JSONObject(resp4);
			
			String errMsg = "";
			
			String isSuccess = jsonObject.getString("status");
			
			if(isSuccess.equalsIgnoreCase("SUCCESS"))
			{
				errMsg = "OTP authenticated successfully";
			}
			else if(isSuccess.equalsIgnoreCase("FAILURE"))
			{
				String errCode = jsonObject.getString("errorCode");
				if(errCode.equalsIgnoreCase("null"))
				{
					errMsg = "Failed to validate OTP";
				}
				else if(errCode.equalsIgnoreCase("INVALID_ARGUMENTS"))
				{
					errMsg = jsonObject.getString("errorText");
				}
				else if(errCode.equalsIgnoreCase("INVALID_PRINCIPAL"))
				{
					errMsg = jsonObject.getString("errorText");
				}
			}
			
			System.out.println(errMsg);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
