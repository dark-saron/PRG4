package de.fhe.ai.prg4.view;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet 
{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp )
		throws ServletException, IOException
		{
			
			resp.setContentType("text/html;charset=UTF-8");
			PrintWriter out = resp.getWriter();
			
			out.println("<html><body>");
			out.println("<p><b><i>");
			out.println("Hello World");
			Date now = new Date();
			String currentTime = DateFormat.getTimeInstance(DateFormat.MEDIUM).format(now);
			out.println("Es ist jetzt" + currentTime + "Uhr.");
			out.println("</b></i></p>");
			out.println("</body></html>");

		}

}
