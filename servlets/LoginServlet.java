package loginPage;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


//@WebServlet("/login") //Same as what is mentioned in the form action, since using servlet mapping in xml
public class LoginServlet extends HttpServlet {
           
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dbUname = "Apoo";
		String dbPass = "1313";
		
		String webUname = request.getParameter("username");
		String webPass = request.getParameter("password");
		
		if (dbUname.equals(webUname) && dbPass.equals(webPass))
			System.out.println("Login Success.");
		else
			System.out.println("Login Failed.");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
}
