package de.fhe.ai.prg4.helper;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Helper extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public void forwardToPage( HttpServletRequest request, 
            HttpServletResponse response,
            String url) 
            throws IOException, ServletException
            {	
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
				dispatcher.forward(request,response);
            }


	private boolean checkIntNumberInput(String number)
	{
		return false;
	}
	
	private boolean checkFloatNumberInput(int number)
	{
			
		return false;
	}
	
	private boolean checkStringInput(String text) 
	{
			
		return false;
	}


}
