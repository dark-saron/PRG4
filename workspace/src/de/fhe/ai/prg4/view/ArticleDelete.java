package de.fhe.ai.prg4.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.fhe.ai.prg4.controller.ArticelLogic;
import de.fhe.ai.prg4.model.Article;

/**
 * Servlet implementation class DeleteArticle
 */
@WebServlet("/ArticleDelete")
public class ArticleDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ArticelLogic artLogic;   
    private boolean editArticle = false;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleDelete() {
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
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		boolean deleteArticle = false;
		System.out.println("hdkajgsa" + request.getParameter("id"));
		int id = Integer.parseInt( request.getParameter("id"));
		deleteArticle = artLogic.deleteArticle(id);
		
		if(!deleteArticle)
		{
			forwardToPage(request, response, "/ArticleDetails?param=" + id);
			//TODO: include fehler meldung
		}
		else
		{
			forwardToPage(request, response, "/ArticleList");
		}
	}

}
