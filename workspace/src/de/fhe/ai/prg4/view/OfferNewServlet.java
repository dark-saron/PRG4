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
 * Servlet implementation class OfferNew
 */
@WebServlet("/psNO")
public class OfferNewServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private static OfferLogic offerLogic;   
    private boolean query = false;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OfferNewServlet()
    {
        super();
        // TODO Auto-generated constructor stub
        offerLogic = new OfferLogic();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException 
	{
		
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		System.out.println(request.getParameter("article_Id"));
		ArticelLogic artL = new ArticelLogic();
		
		int article_id = Integer.parseInt(request.getParameter("article_Id"));
		String article_name = artL.getArticle(article_id).getName();
		String endDate = "";
		
		if(request.getParameter("end") == "")
			endDate = "3012-12-30";
		else
			endDate = request.getParameter("end");
		
		
		query = offerLogic.setNewOffer(
				-1,
				Float.parseFloat(request.getParameter("startsaleprice")),
				Float.parseFloat(request.getParameter("buynowprice")),
				request.getParameter("start"),
				endDate,
				request.getParameter("url"),
				1,
				1,
				article_id,
				article_name,
				request.getParameter("auctionhouse"),
				request.getParameter("externalID"));
		
		forwardToPage(request, response, "/OfferList");

	}

}
