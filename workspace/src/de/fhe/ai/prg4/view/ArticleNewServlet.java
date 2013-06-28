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
 * Servlet implementation class NewArticle
 */
@WebServlet("/psNA")
public class ArticleNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static ArticelLogic artLogic;   
    private boolean insertArticle = false;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleNewServlet() {
        super();
        artLogic = new ArticelLogic();
        // TODO Auto-generated constructor stub
    }

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
	

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
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		insertArticle = false;
		
		insertArticle = artLogic.setNewArticle(-1, 
				request.getParameter("type"),
				request.getParameter("description"),
				request.getParameter("place"),
				request.getParameter("name"),
				request.getParameter("photo"),
				request.getParameter("ean_isbn"),
				request.getParameter("externalID"));
		forwardToPage(request, resp, "/ArticleList");
		if(!insertArticle)
		{
			resp.setContentType( "text/html;charset=UTF-8" );
			resp.setContentType( "<html><head></head><body>" );
			resp.setContentType( "<h2>Artikel konnte nicht zur Datenbank hinzugefügt werden.</h2></body></html>" );
		}
		else
		{
			
			//RequestDispatcher view = getServletContext().getRequestDispatcher("/ArticleList");
			//view.forward(request, resp);
		}
		 		
	}

}
