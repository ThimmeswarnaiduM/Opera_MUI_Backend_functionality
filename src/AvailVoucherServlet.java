

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import config.ConfigPayloads;
import config.Configuration;
import config.GetHotelsData;
import config.GetProfileData;
import config.GetReservationData;
import data.HashMapData;


@WebServlet("/AvailVoucherServlet")
public class AvailVoucherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	JSONObject object = new JSONObject();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	
		String ReservationNameCode = request.getParameter("ReservId");
		String PMSPropertyCode = request.getParameter("PropertyCode");
		String VoucherNumber = request.getParameter("VoucherNumber");
		System.out.println("DEBUG >> ReservId: " + ReservationNameCode);
	    System.out.println("DEBUG >> PropertyCode: " + PMSPropertyCode);
	    System.out.println("DEBUG >> VoucherNumber: " + VoucherNumber);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		
		GetReservationData reservationData = HashMapData.mapReservationData.get(ReservationNameCode);
		
		String CheckInDate = dateFormat.format(reservationData.CInDate);
		
		String CheckOutDate = dateFormat.format(reservationData.COutDate);
		
		String RegisterConfirmationNo = reservationData.ConfirmationNo;
		
		String UsedDate = dateFormat.format(new Date());
		
		GetHotelsData hotelsData = new GetHotelsData();
		String PropertyCode = hotelsData.getProperty(PMSPropertyCode);
		
		if(PMSPropertyCode == null || PMSPropertyCode.trim().isEmpty() || PMSPropertyCode.equalsIgnoreCase("null"))
		{
			try {
				this.object.put("status", "ERROR");
				this.object.put("msg", "Failed to fetch property code <br/>please try again later <br/>Thank you");
			}catch (Exception e) {
				//e.printStackTrace();
			}
		}
		
		GetProfileData getProfileData = HashMapData.mapProfileData.get(ReservationNameCode);
		String MemberNumber = getProfileData.EnrollNumber_c;
		
		System.out.println("ReservationConfirmationNo: \t" + RegisterConfirmationNo );
		System.out.println("PMSPropertyCode: \t" + PMSPropertyCode);
		System.out.println("VoucherNumber: \t" + VoucherNumber);
		System.out.println("CheckInDate: \t" + CheckInDate);
		System.out.println("CheckOutDate: \t" + CheckOutDate);
		System.out.println("UsedDate: \t" + UsedDate);
		System.out.println("PropertyCode: \t" + PropertyCode);
		System.out.println("MemberNumber: \t" + MemberNumber);
		
		try
		{
		
			availVoucher(VoucherNumber, MemberNumber, PropertyCode, UsedDate, RegisterConfirmationNo, CheckInDate, CheckOutDate);
			
			/*
			  try { this.object.put("status", "SUCCESS"); } catch (JSONException e1) {
			  e1.printStackTrace(); }
			 */
			
		
		}catch(Exception e)
		{
			e.printStackTrace();
			try {
				this.object.put("status", "ERROR");
				this.object.put("msg", "Failed to avail voucher <br/>please try again later <br/>Thank you");
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
		}
		
		response.getWriter().write(this.object.toString());
		
		return;
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

	protected void availVoucher(String VoucherNumber, String MembershipNumber, String PropertyCode, String UsedDate, String IHCLRegisterNumber, String IHCLCheckInDate, String IHCLCheckOutDate)
	{
		ConfigPayloads payloads = new ConfigPayloads();
		String payload = payloads.getAvailVoucherPayload(VoucherNumber, MembershipNumber, PropertyCode, UsedDate, IHCLRegisterNumber, IHCLCheckInDate, IHCLCheckOutDate);
		
		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + IHCLRegisterNumber+".txt",true));
			
			writer.write("\nGravty Avail Vouchers Request Payload: \n" + payload + "\n\n");
			writer.close();
			
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		//storing redemption logs
		
		//
		
		try
		{
			OkHttpClient client = new OkHttpClient();
	
			MediaType mediaType = MediaType.parse("application/json");
			RequestBody body = RequestBody.create(mediaType, payload);
			Request request = new Request.Builder()
			  .url(Configuration.AvailVoucherURL)
			  .post(body)
			  .addHeader("Content-Type", "application/json")
			  .addHeader("Authorization", Configuration.IcsBasicAuth)
			  .addHeader("cache-control", "no-cache")
			  .addHeader("Postman-Token", "90448d55-d619-40db-b0cd-75dde9d860cd")
			  .build();
	
			Response response = client.newCall(request).execute();
			
			String resp = response.body().string().toString();
			
			try{
				BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.logLoc + IHCLRegisterNumber+".txt",true));
				
				writer.write("\nAvail Vouchers Response: \n" + resp + "\n\n");
				writer.close();
				
			} catch(Exception e)
			{
				e.printStackTrace();
			}
			//storing redemption logs
			
			//////
			
			
			JSONObject jsonObject = new JSONObject(resp);
			
			JSONObject object = jsonObject.getJSONObject("IHCL_spcVoucher_spcOperations_spcWS_spcWebsite_spcV1_Output");
			
			String status = object.getString("Response");
			
			System.out.println(status);
			
			if(status.equals("Success"))
			{
				this.object.put("status", "SUCCESS");
				this.object.put("msg", "Voucher availed successfully <br><b>"+VoucherNumber+"</b>");
				return;
			} else {
				this.object.put("status", "ERROR");
				this.object.put("msg", "Failed to avail voucher <br/>please try again later <br/>Thank you");
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
			try {
				this.object.put("status", "ERROR");
				this.object.put("msg", "Failed to avail voucher <br/>please try again later <br/>Thank you");
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
			
		}
	}
}
