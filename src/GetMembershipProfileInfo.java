import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import config.ConfigPayloads;
import config.Configuration;
import config.GetMemberData;
import data.HashMapData;

@WebServlet("/GetMembershipProfileInfo")
public class GetMembershipProfileInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Request received");
		
		String MembershipNumber = request.getParameter("MemberNumber");
		String GlobalPartyNumber = request.getParameter("GlobalReservationNumber");
		String GlobalPropertyCode = request.getParameter("GlobalPropertyCode");
		
		System.out.println(MembershipNumber + "\t" + GlobalPartyNumber);
		
		JSONObject object = getMemberInfo(MembershipNumber, GlobalPartyNumber, GlobalPropertyCode);
		
		System.out.println("Get Infor Response : "+object.toString());
		
		response.getWriter().write(object.toString());
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

	private JSONObject getMemberInfo(String MembershipNumber, String ReservationNumber, String GlobalPropertyCode)
	{
		JSONObject objResp = new JSONObject();
		

		ConfigPayloads payloads = new ConfigPayloads();
		
		String payload = payloads.getMemberDataPayload(MembershipNumber);
	
		System.out.println("Get Member Data Payload: \n" + payload);
	
		try {
			
		OkHttpClient client = new OkHttpClient();
		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType, payload);
		Request request = new Request.Builder()
		  .url(Configuration.GetMemberDataURL)
		  .method("POST", body)
		  .addHeader("Store_Id", GlobalPropertyCode)
		  .addHeader("Authorization", Configuration.IcsBasicAuth)
		  .addHeader("Content-Type", "application/json")
		  .build();
		Response responseMember = client.newCall(request).execute();
		
		String testResponse = responseMember.body().string();

		System.out.println("Get Member Data Response: \n" + testResponse);
		
		if(testResponse.contains("No record found"))
		{
			objResp.put("STATUS", "ERROR");
		}
		else
		{
			JSONObject objectMember = new JSONObject(testResponse);
			MembershipNumber = objectMember.getString("tcpNumber");
			String TcpCustomerHash = objectMember.getString("customerHash");
			objResp.put("STATUS", "SUCCESS");
			objResp.put("TcpCustomerHash", TcpCustomerHash);
			System.out.println("ReservationNumber"+ReservationNumber);
			GetMemberData tempMember = HashMapData.mapMemberData.get(ReservationNumber);
			tempMember.redeemTCPCustomerHash = TcpCustomerHash;
			HashMapData.mapMemberData.put(ReservationNumber, tempMember);
			return objResp;
		}
		
		
			
		}
       catch(Exception e)
       {
    	   try {
			objResp.put("STATUS", "ERROR");
		} catch (JSONException e1) {
			e1.printStackTrace();
		}
    	   e.printStackTrace();
       }

		return objResp;
	}
	
	
	
}
