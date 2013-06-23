package de.fhe.ai.prg4.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.fhe.ai.prg4.controller.ArticelLogic;

/**
 * Servlet implementation class ArticleEditServlet
 */
@WebServlet("/editArticle")
public class ArticleEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static ArticelLogic artLogic;   
    private boolean editArticle = false;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleEditServlet() {
        super();
        artLogic = new ArticelLogic();
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
		boolean insertArticle = false;
		response.setContentType("kdhfdsk sdfbhsj" + request.getParameter("id") );
		int id = Integer.parseInt( request.getParameter("id"));
		//System.out.println(request.getParameter("id"));
		insertArticle = artLogic.setArticle(Integer.parseInt(request.getParameter("id")), 
				request.getParameter("type"),
				request.getParameter("description"),
				request.getParameter("place"),
				request.getParameter("name"),
				request.getParameter("photo"),
				request.getParameter("ean_isbn"),
				request.getParameter("externalID"));
		if(!insertArticle)
		{
			response.setContentType( "text/html;charset=UTF-8" );
			response.setContentType( "<html><head></head><body>" );
			response.setContentType( "<h2>Artikel konnte nicht zur Datenbank hinzugefügt werden.</h2></body></html>" );
		}
		else
		{
			forwardToPage(request, response, "/ArticleList");
			
			//RequestDispatcher view = getServletContext().getRequestDispatcher("/ArticleList");
			//view.forward(request, resp);
		}
		 		
	}

}
