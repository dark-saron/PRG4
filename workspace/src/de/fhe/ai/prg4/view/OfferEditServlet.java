package de.fhe.ai.prg4.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.fhe.ai.prg4.controller.ArticelLogic;
import de.fhe.ai.prg4.controller.OfferLogic;

/**
 * Servlet implementation class OfferEditServlet
 */
@WebServlet("/editOffer")
public class OfferEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static OfferLogic offerLogic;   
    private boolean editOffer = false;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OfferEditServlet() {
        super();
        offerLogic = new OfferLogic();
        // TODO Auto-generated constructor stub
    }

	@SuppressWarnings("unused")
	private void forwardToPage(final HttpServletRequest request, 
            final HttpServletResponse response,
            String url) 
            throws IOException, ServletException
            {
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
				dispatcher.forward(request,response);
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
		boolean updateOffer = false;
		response.setContentType("Offer" + request.getParameter("id") );
		int id = Integer.parseInt( request.getParameter("id"));
		String endDate = "";
		
		if(request.getParameter("end") == "")
			endDate = "3012-12-30";
		else
			endDate = request.getParameter("end");
		
		updateOffer = offerLogic.setOffer(
				Integer.parseInt(request.getParameter("id")),
				Float.parseFloat(request.getParameter("startsaleprice")),
				Float.parseFloat(request.getParameter("buynowprice")),
				request.getParameter("start"),
				endDate,
				request.getParameter("url"),
				Integer.parseInt(request.getParameter("status")),
				1,
				Integer.parseInt(request.getParameter("article_Id")),
				request.getParameter("article_Name"),
				request.getParameter("auctionhouse"),
				request.getParameter("externalID"));
		
		if(!updateOffer)
		{
		}
		else
		{
			forwardToPage(request, response, "/OfferList");
		}
		 		
	}

}
