

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import org.json.JSONObject;
import config.GetProfileData;

@SuppressWarnings("serial")
@WebServlet("/fetchOutstanding")
public class OutstandingBalanceServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String PMSNameCode = request.getParameter("PMSNameCode");
            String ReservationNo = request.getParameter("ReservationNo");
            String OWSPropertyCode = request.getParameter("OWSPropertyCode");
            String membershipNumber = request.getParameter("membershipNumber");
            

            // Build payload
            JSONObject payload = new JSONObject();
            payload.put("MemberType", "Chambers");
            payload.put("chambers_id",membershipNumber ); // example

            // Create GetProfileData instance
            GetProfileData getProfileData = new GetProfileData(PMSNameCode, ReservationNo, OWSPropertyCode, request, response);

            // Fetch outstanding balance and store in session
            getProfileData.fetchOutstandingBalance(payload);

            // Redirect to NewInvoice.jsp
            response.sendRedirect("NewInvoice.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
