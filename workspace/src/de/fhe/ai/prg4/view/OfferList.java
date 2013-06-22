package de.fhe.ai.prg4.view;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.fhe.ai.prg4.controller.ArticelListLogic;
import de.fhe.ai.prg4.controller.OfferListLogic;
import de.fhe.ai.prg4.model.Article;
import de.fhe.ai.prg4.model.Offer;

/**
 * Servlet implementation class OfferList
 */
@WebServlet("/OfferList")
public class OfferList extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static OfferListLogic OlLogic = new OfferListLogic();
	LinkedList<Offer> O_List = new LinkedList<Offer>();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OfferList() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		O_List = OlLogic.getOfferList();
		
		request.setAttribute("offerList", O_List);
		RequestDispatcher view = request.getRequestDispatcher("OfferList.jsp");
	    view.forward(request, resp);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		O_List = OlLogic.getOfferList();
		
		request.setAttribute("offerList", O_List);
		RequestDispatcher view = request.getRequestDispatcher("OfferList.jsp");
	    view.forward(request, response);
	}

}
