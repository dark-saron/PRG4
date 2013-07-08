package de.fhe.ai.prg4.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.fhe.ai.prg4.model.Bill;

/**
 * Servlet implementation class Bill
 */
@WebServlet("/Billing")
public class Bill1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Bill bill;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bill1Servlet() {
        super();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		
		bill = new Bill(-1,
				Float.parseFloat(request.getParameter("total")), 
				request.getParameter("brought_At"), 
				request.getParameter("shipping_At"), 
				Float.parseFloat(request.getParameter("shippingCost")), 
				Integer.parseInt(request.getParameter("offerID")), 
				Integer.parseInt(request.getParameter("buyer_id")), 
				Integer.parseInt(request.getParameter("seller_id"))
				);
		request.setAttribute("billDetails", bill);
		
		RequestDispatcher view = getServletContext().getRequestDispatcher("/BillCreate2");
		view.forward(request, resp);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		bill = new Bill(-1,
				Float.parseFloat(request.getParameter("total")), 
				request.getParameter("brought_At"), 
				request.getParameter("shipping_At"), 
				Float.parseFloat(request.getParameter("shippingCost")), 
				Integer.parseInt(request.getParameter("offerID")), 
				Integer.parseInt(request.getParameter("buyer_id")), 
				Integer.parseInt(request.getParameter("seller_id"))
				);
		request.setAttribute("billDetails", bill);
		
		RequestDispatcher view = getServletContext().getRequestDispatcher("/BillCreate2");
		view.forward(request, response);

	}

}
