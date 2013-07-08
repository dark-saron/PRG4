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
 * Servlet implementation class ContactEditServlet
 */
@WebServlet("/editContact")
public class ContactEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static ContactLogic contactLogic;   
    private boolean editContact = false;
    private Helper helper;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactEditServlet() {
        super();
        contactLogic = new ContactLogic();
        // TODO Auto-generated constructor stub
    }

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		editContact = false;
		System.out.println("Kontakt: " + request.getParameter("id") );
		int id = Integer.parseInt( request.getParameter("id"));
		editContact = contactLogic.UpdateContactWithAddress(
				id, 
				request.getParameter("cFirst_Name"), 
				request.getParameter("cLast_Name"), 
				request.getParameter("cEmail"), 
				request.getParameter("cPhone"), 
				request.getParameter("cMobile"), 
				1,
				Integer.parseInt(request.getParameter("aID")), 
				request.getParameter("aFirst_Name"), 
				request.getParameter("aLast_Name"), 
				request.getParameter("aStreet_Nr"), 
				request.getParameter("aZip"), 
				request.getParameter("aCity"), 
				request.getParameter("aCountry"), 
				request.getParameter("aTitle"), 
				request.getParameter("aGender")
				);
		if(!editContact)
		{
		}
		else
		{
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ContactList");
			dispatcher.forward(request,response);
		}
		 		
	}

}
