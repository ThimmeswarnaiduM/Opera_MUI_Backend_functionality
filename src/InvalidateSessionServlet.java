

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import config.GetMemberData;
import config.GetProfileData;
import config.GetReservationData;
import data.HashMapData;
import data.NewInvoicesData;
import data.ProcessInvoicesData;
import data.StoreInvoiceDetails;


@WebServlet("/InvalidateSessionServlet")
public class InvalidateSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String GlobalReservationNumber = "";
       
    
    public InvalidateSessionServlet() {
        super();
    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			GlobalReservationNumber = request.getParameter("GlobalReservationNumber");
			
			GetMemberData getMemberData = HashMapData.mapMemberData.get(GlobalReservationNumber);
			getMemberData.clearCache();
			HashMapData.mapMemberData.put(GlobalReservationNumber, getMemberData);
			
			GetProfileData getProfileData = HashMapData.mapProfileData.get(GlobalReservationNumber);
			getProfileData.clearCache();
			HashMapData.mapProfileData.put(GlobalReservationNumber, getProfileData);
			
			GetReservationData getReservationData = HashMapData.mapReservationData.get(GlobalReservationNumber);
			getReservationData.clearCache();
			HashMapData.mapReservationData.put(GlobalReservationNumber, getReservationData);
			
			StoreInvoiceDetails storeInvoiceDetails = HashMapData.mapInvoiceData.get(GlobalReservationNumber);
			storeInvoiceDetails.ClearCache();
			HashMapData.mapInvoiceData.put(GlobalReservationNumber, storeInvoiceDetails);
			
			ProcessInvoicesData processInvoicesData = HashMapData.mapProcessInvoices.get(GlobalReservationNumber);
			processInvoicesData.clearCache();
			HashMapData.mapProcessInvoices.put(GlobalReservationNumber, processInvoicesData);
			
			NewInvoicesData newInvoicesData = HashMapData.mapNewInvoices.get(GlobalReservationNumber);
			newInvoicesData.clearCache();
			HashMapData.mapNewInvoices.put(GlobalReservationNumber, newInvoicesData);
			
			
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		response.sendRedirect("thank_you.html");
		return;
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
