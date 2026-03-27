

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import config.Configuration;

@WebServlet("/UpdateAppContent")
public class UpdateAppContent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String purpose = request.getParameter("purpose");
		if(purpose.equals("LOGIN"))
		{
			String UserName = request.getParameter("username");
			String Password = request.getParameter("password");
			
			String preUsername = "InnovacxAdminForMUICheck";
			String prePassword = "IhclTaTa@20!9";
			
			if(UserName.equals(preUsername) && Password.equals(prePassword))
			{
//				response.sendRedirect(".jsp?loginStatus=SUCCESS");
				request.setAttribute("loginStatus", "SUCCESS");
				request.getRequestDispatcher("/AppMaintenanceConfig.jsp").forward(request, response);
				return;
			}else 
			{
//				response.sendRedirect(".jsp?loginStatus=FAILED");
				request.setAttribute("loginStatus", "FAILED");
				request.getRequestDispatcher("/AppMaintenanceConfig.jsp").forward(request, response);
				return;
			}
			
		} else if(purpose.equals("UPDATE"))
		{
			String startTime = request.getParameter("startTime");
			String endTime = request.getParameter("endTime");
			String isUnderMaintenance = request.getParameter("maintenance");
			
			if(isUnderMaintenance.equals("true"))
			{
				Configuration.underMaintainance = true;
				Configuration.downtimeFrom = startTime;
				Configuration.downtimeTo = endTime;
			} else if(isUnderMaintenance.equals("false"))
				Configuration.underMaintainance = false;
			
			request.setAttribute("loginStatus", "SUCCESS");
			request.setAttribute("AttributeUpdate", "SUCCESS");
			request.getRequestDispatcher("/AppMaintenanceConfig.jsp").forward(request, response);
			
			return;
				
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
