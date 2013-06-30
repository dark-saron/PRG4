package de.fhe.ai.prg4.view;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.fhe.ai.prg4.controller.ContactListLogic;
import de.fhe.ai.prg4.helper.Helper;
import de.fhe.ai.prg4.model.Contact;

/**
 * Servlet implementation class ContactList
 */
@WebServlet("/ContactList")
public class ContactList extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static Helper helper;
	private static ContactListLogic CL_Logic = new ContactListLogic();
    LinkedList<Contact> C_List = new LinkedList<Contact>();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		C_List = CL_Logic.getContactList();
		 
		request.setAttribute("contactList", C_List);
		helper.forwardToPage(request, resp, "Article/ArticleList.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		C_List = CL_Logic.getContactList();
		 
		request.setAttribute("contactList", C_List);
		helper.forwardToPage(request, response, "Article/ArticleList.jsp");

	}

}
