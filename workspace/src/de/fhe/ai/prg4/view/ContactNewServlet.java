package de.fhe.ai.prg4.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.fhe.ai.prg4.controller.ContactLogic;
import de.fhe.ai.prg4.helper.Helper;

/**
 * Author: Sabine Lueck
 * 20.06.2013
 * Servlet implementation class NewContact
 */
@WebServlet("/psNK")
public class ContactNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static ContactLogic contactLogic;   
    private Helper helper;
    private boolean insertContact = false;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactNewServlet() {
        super();
        contactLogic = new ContactLogic();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		insertContact = false;
		
		insertContact = contactLogic.CreateNewContactWithAddress(
				request.getParameter("cFirst_Name"), 
				request.getParameter("cLast_Name"), 
				request.getParameter("cEmail"), 
				request.getParameter("cPhone"),
				request.getParameter("cMobile"), 
				1, 
				request.getParameter("aFirst_Name"), 
				request.getParameter("aLast_Name"), 
				request.getParameter("aStreet_Nr"), 
				request.getParameter("aZip"), 
				request.getParameter("aCity"), 
				request.getParameter("aCountry"), 
				request.getParameter("aTitle"), 
				request.getParameter("aGender")
				);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ContactList");
		dispatcher.forward(request,response);
		if(!insertContact)
		{

		}
		else
		{
			
		}
	}

}
