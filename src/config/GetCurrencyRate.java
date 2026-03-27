package config;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import data.HashMapData;

@WebServlet("/GetCurrencyRate")
public class GetCurrencyRate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String ReservationNo = request.getParameter("GlobalReservationNumber");
			
			String ConversionRate = getCurrencyRate(ReservationNo);
			
			response.getWriter().write(ConversionRate);
			
			return;
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public String getCurrencyRate(String ReservationNo)
	{
		double currencyRate = HashMapData.mapCurrency.get(ReservationNo);
		
		return Double.toString(currencyRate);
	}
	

}
