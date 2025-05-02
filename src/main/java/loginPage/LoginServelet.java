package loginPage;

import java.io.IOException;
import java.time.LocalTime;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


//@WebServlet("/login") //Same as what is mentioned in the form action, since using servlet mapping in xml
public class LoginServelet extends HttpServlet {
           
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dbUname = "Apoo";
		String dbPass = "1313";
		
		String webUname = request.getParameter("username");
		String webPass = request.getParameter("password");
		
		//LocalTime time = LocalTime.now();
		//request.setAttribute("time", time);
		request.setAttribute("username", webUname); //passing value along with request object

		RequestDispatcher rd = request.getRequestDispatcher("/home.jsp");
		rd.forward(request, response);
		
//		PrintWriter writer = response.getWriter();
//		writer.println("<!DOCTYPE html>\r\n"
//				+ "<html>\r\n"
//				+ "<head>\r\n"
//				+ "<title>Login here</title>\r\n"
//				+ "</head>\r\n");
		if (dbUname.equals(webUname) && dbPass.equals(webPass)) {
//			writer.println("<h1>Login Success.</h1>"); //Displaying the data on webpage // can give full HTML code also
			
			// writer.print("<h3> welcome" + webUname </h3>);
			RequestDispatcher rd = request.getRequestDispatcher("/success.html"); // sending a file as a response
			rd.forward(request, response);
		} else {
//			writer.println("<h1>Login Failed.</h1>");
			
			//RequestDispatcher rd = request.getRequestDispatcher("/fail.html");
			//rd.forward(request, response);
			
			response.sendRedirect("fail.html"); //redirecting to open a page
		}	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
}
