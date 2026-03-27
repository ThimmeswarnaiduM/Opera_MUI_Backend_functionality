//import java.io.BufferedWriter;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import com.squareup.okhttp.MediaType;
//import com.squareup.okhttp.OkHttpClient;
//import com.squareup.okhttp.Request;
//import com.squareup.okhttp.RequestBody;
//import com.squareup.okhttp.Response;
//
//import config.Configuration;
//
//@WebServlet("/GetBillDataServlet")
//public class GetBillDataServlet extends HttpServlet {
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	public static String BillNumber;
//	public static String SponsorName;
//	public static String HotelLocation;
//	
//	//public static String resp = "";
//
//	@SuppressWarnings("null")
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	
//		//System.out.println("GetBillDataServlet started");
//		
//	
//	String MemberId = request.getParameter("memberId");
//	String MemberType = request.getParameter("memberType");
//	String BitId = request.getParameter("BitId");
//	
//	
//	
//	String BillDat = GetBillNo(MemberId,MemberType,BitId);
////	JSONArray array = new JSONArray(BillDat);
////	JSONObject parent = array.getJSONObject(0);
//	try {
//		JSONArray array = new JSONArray(BillDat);
//		JSONObject parent = array.getJSONObject(0);
//		SponsorName = parent.getString("sponsor_name");
//		JSONObject child = parent.getJSONObject("header");
//		BillNumber = child.getString("bill_number");
//		
//		HotelLocation = child.getString("h_location");
//
//	} catch (JSONException e1) {
//		// TODO Auto-generated catch block
//		e1.printStackTrace();
//	}
//	
//	
//	JSONObject BillData = new JSONObject();
//	try {
//			BillData.put("BillNumber", BillNumber);
//			BillData.put("SponsorName", SponsorName);
//			BillData.put("HotelLocation", HotelLocation);
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	System.out.println("Bill Data: "+BillData.toString());
//	response.getWriter().write(BillData.toString());
//	
//	}
//	public String GetBillNo(String MemberId, String MemberType, String BitId) throws IOException
//	{
//		OkHttpClient client_02 = new OkHttpClient();
//				MediaType mediaType_02 = MediaType.parse("application/json");
//				RequestBody body_02 = RequestBody.create(mediaType_02, "{\r\n  \"member_id\": \""+MemberId+"\",\r\n  \"MemberType\": \""+MemberType+"\",\r\n  \"bit_id\": \""+BitId+"\"\r\n}");
//				Request request_02 = new Request.Builder()
//				  .url(Configuration.QUERYBITS)
//				  .method("POST", body_02)
//				  .addHeader("Authorization", "Basic b2ljX3VzZXI6SW5ub3ZhY3hAMzIx")
//				  .addHeader("Content-Type", "application/json")
//				  .build();
//				Response response_02 = client_02.newCall(request_02).execute();
//				String resp = response_02.body().string().toString();
//				//System.out.println("Voucher Resp: \n" + resp);
//				
//				//objVouchers.getJSONArray(Reservation_Status);
//				//JSONObject parent = array[0];
//				//JSONObject child = parent.getJSONObject("header");
//				//String billno = child.getString("bill_number");
//				//[]>header>bill_number;
//				//or should take sponcer from hear ("sponsor_name": "Taj Palace, New Delhi"  ,"sponsor": "The Indian Hotels Co. Ltd.")
//				return resp;
//	}
//	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		doGet(request, response);
//	}
//}