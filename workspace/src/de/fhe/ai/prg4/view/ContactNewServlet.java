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
 * Author: Sabine Lueck
 * 20.06.2013
 * Servlet implementation class NewContact
 */
@WebServlet("/psNC")
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
		
		insertContact = contactLogic.setNewContact( 
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
		helper.forwardToPage(request, response, "/ContactList");
		if(!insertContact)
		{

		}
		else
		{
			
		}
	}

}
