

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

@WebServlet("/GiftCardSwipeServlet")
public class GiftCardSwipeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
 		String CardNumber , TrackData;
 		
 		JSONObject object = new JSONObject();
 		
 		String txtCardSwipe = request.getParameter("txtCardSwipe");
 		if(txtCardSwipe.contains("/"))
 		{
 			txtCardSwipe.replace("/", "?");
 		}
 		
 		try
 		{
 			CardNumber = txtCardSwipe.substring(txtCardSwipe.indexOf(";")+1, txtCardSwipe.indexOf("="));
		
 			TrackData = txtCardSwipe;
 			
 			object.put("STATUS", "SUCCESS");
 			object.put("CardNumber", CardNumber);
 			object.put("TrackData", TrackData);
 			
 		}catch(Exception e)
 		{
 			try {
				object.put("STATUS", "ERROR");
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
 			e.printStackTrace();
 		}
		
		response.getWriter().write(object.toString());
		return;
 		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
