package util;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import config.Configuration;
import config.GetReservationData;
import data.HashMapData;


@WebServlet("/CCAvenueHandler")
public class CCAvenueHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String reqType = request.getParameter("reqType");
		String resvNameId = request.getParameter("ReservId");
		
		GetReservationData reservationData = HashMapData.mapReservationData.get(resvNameId);
		
		String confirmationNo = reservationData.ConfirmationNo;
		String propertyCode = reservationData.OWSProperty;
		
		String msgReturn = "";
		
		String createInvoiceJarPath = Configuration.CCAvenueMUIInvokeJar + "CCAvenueMUICreateInvoice.jar";
		String resendInvoiceJarPath = Configuration.CCAvenueMUIInvokeJar + "CCAvenueMUIResendInvoiceTest.jar";
		
		Runtime.getRuntime().exec("cd " + Configuration.CCAvenueMUIInvokeJar);
		
		if(reqType.equals("createInvoice"))
		{
			Runtime.getRuntime().exec("java -jar " + createInvoiceJarPath + " " + confirmationNo + " " + propertyCode);
			msgReturn = "Invoice created";
			
		} else if(reqType.equals("ResendInvoice"))
		{
			Runtime.getRuntime().exec("java -jar " + resendInvoiceJarPath + " " + confirmationNo + " " + propertyCode);
			msgReturn = "Invoice resent succesful";
		}
		
		response.getWriter().write(msgReturn);
		return;
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
