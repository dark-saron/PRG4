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
 * Servlet implementation class DeleteContact
 * Author: Sabine L�ck
 *  
 *  
 */
@WebServlet("/ContactDelete")
public class ContactDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ContactLogic contactLogic;
	private static Helper helper;
    private boolean deleteContact = false;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactDelete() {
        super();
        contactLogic = new ContactLogic();
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
		deleteContact = false;
		System.out.println("Kontakt: " + request.getParameter("id"));
		int id = Integer.parseInt( request.getParameter("id"));
		deleteContact = contactLogic.DeleteContactWithAddress(id);
		
		if(!deleteContact)
		{
			RequestDispatcher view = request.getRequestDispatcher("Contact/ContactDetails?param=" + id);
		    view.forward(request, response);
			
			//TODO: include fehler meldung
		}
		else
		{
			RequestDispatcher view = request.getRequestDispatcher("Contact/ContactList.jsp");
		    view.forward(request, response);
		}

	}

}
