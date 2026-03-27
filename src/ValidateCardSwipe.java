

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ValidateCardSwipe")
public class ValidateCardSwipe extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String GlobalReservationNumber = "";
 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	//	String reqCardNumber = request.getParameter("CardNumber");
		

		try {
			GlobalReservationNumber = request.getParameter("GlobalReservationNumber");
		} catch(Exception e){}
		
		/*String MembershipNumber = GetProfileData.EnrollNumber_c;
		
		if(MembershipNumber != null && !MembershipNumber.equalsIgnoreCase(""))
		{
		
			if(reqCardNumber.equalsIgnoreCase(MembershipNumber))
			{
				response.getWriter().write("success");
				return;
			}else {
				response.getWriter().write("failed");
				return;
			}
		}else {
			response.getWriter().write("Membership Not Initialized");
			return;
		}*/
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
