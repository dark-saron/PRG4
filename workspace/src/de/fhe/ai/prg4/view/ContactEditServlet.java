package de.fhe.ai.prg4.view;

import java.io.IOException;

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
		response.setContentType("Kontakt: " + request.getParameter("id") );
		int id = Integer.parseInt( request.getParameter("id"));
		editContact = contactLogic.setContact(
				id,
				request.getParameter("first_Name"),
				request.getParameter("last_Name"),
				request.getParameter("title"),
				request.getParameter("email"),
				request.getParameter("phone"),
				request.getParameter("mobile"),
				1,
				Integer.parseInt(request.getParameter("shipping_Address_Id")),
				Integer.parseInt(request.getParameter("billing_Address_Id"))				
				);
		if(!editContact)
		{
		}
		else
		{
			helper.forwardToPage(request, response, "/ContactList");
		}
		 		
	}

}
