package de.fhe.ai.prg4.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.fhe.ai.prg4.controller.BillLogic;
import de.fhe.ai.prg4.controller.ContactLogic;
import de.fhe.ai.prg4.model.Address;
import de.fhe.ai.prg4.model.Bill;

/**
 * Servlet implementation class Bill
 */
@WebServlet("/Billing")
public class Bill1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Bill bill;  
    private BillLogic billL = new BillLogic();
    private Address sellerAddress;
    private Address buyerAddress;
    private ContactLogic cLogic = new ContactLogic();
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean status = false;

		
		
		if(request.getParameter("newSellerAddress")==null)
		{
			//TODO: catch error if no ID of a existing Address is given either
			sellerAddress = cLogic.getAddress(
					cLogic.getContact(Integer.parseInt(request.getParameter("seller_id"))).getShipping_Address_Id());
		}
		else
		{
			sellerAddress = new Address(
					-1,
					request.getParameter("aFirst_Name"), 
					request.getParameter("aLast_Name"), 
					request.getParameter("aStreet_Nr"), 
					request.getParameter("aZip"), 
					request.getParameter("aCity"), 
					request.getParameter("aCountry"), 
					request.getParameter("aTitle"), 
					request.getParameter("aGender"));
		}
		
		if(request.getParameter("newBuyerAddress")==null)
		{
			//TODO: catch error if no ID of a existing Address is given either
			buyerAddress = cLogic.getAddress(
					cLogic.getContact(Integer.parseInt(request.getParameter("buyer_id"))).getShipping_Address_Id());
		}
		else
		{
			buyerAddress = new Address(
					-1,
					request.getParameter("bFirst_Name"), 
					request.getParameter("bLast_Name"), 
					request.getParameter("bStreet_Nr"), 
					request.getParameter("bZip"), 
					request.getParameter("bCity"), 
					request.getParameter("bCountry"), 
					request.getParameter("bTitle"), 
					request.getParameter("bGender"));
		}
		
		
		bill = new Bill(
				-1,
				Float.parseFloat(request.getParameter("total")), 
				request.getParameter("brought_At"), 
				request.getParameter("shipping_At"), 
				Float.parseFloat(request.getParameter("shippingCost")), 
				Integer.parseInt(request.getParameter("offerID")), 
				-1,
				-1);
		status = billL.CreateNewBill(bill, sellerAddress, buyerAddress);
		
		if(!status)
		{
			RequestDispatcher view = getServletContext().getRequestDispatcher("/OfferList");
			view.forward(request, response);
		}
			
		
		int id = billL.GetBillID(bill.getOffer_Id());
		RequestDispatcher view = getServletContext().getRequestDispatcher("/OfferDetails?param=" + bill.getOffer_Id());
		view.forward(request, response);

	}

}
