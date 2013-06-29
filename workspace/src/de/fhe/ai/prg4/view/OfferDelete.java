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
 * Servlet implementation class OfferDelete
 */
@WebServlet("/OfferDelete")
public class OfferDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static OfferLogic offerLogic;   
    private boolean deleteOffer = false;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OfferDelete() {
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
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType( "text/html;charset=UTF-8" );
		resp.getOutputStream().println( "<html><body>" );
		resp.getOutputStream().println( "<p><b><i>" );
		resp.getOutputStream().println( "Delete over Success Page" );
		resp.getOutputStream().println( "</p></i></b>" );
		resp.getOutputStream().println( "</body></html>" );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		boolean deleteOffer = false;
		System.out.println("Offer: " + request.getParameter("id"));
		int id = Integer.parseInt( request.getParameter("id"));
		deleteOffer = offerLogic.deleteOffer(id);
		
		if(!deleteOffer)
		{
			forwardToPage(request, response, "/OfferDetails?param=" + id);
			//TODO: include fehler meldung
		}
		else
		{
			forwardToPage(request, response, "/OfferList");
		}

		
	}

}
