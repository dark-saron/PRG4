package de.fhe.ai.prg4.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.fhe.ai.prg4.controller.ArticelLogic;
import de.fhe.ai.prg4.helper.Helper;

/**
 * Servlet implementation class NewArticle
 */
@WebServlet("/psNA")
public class ArticleNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static ArticelLogic artLogic;
    private Helper helper;
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
		
		//helper.forwardToPage(request, resp, "/ArticleList");
		if(!insertArticle)
		{

		}
		else
		{
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ArticleList");
			dispatcher.forward(request,resp);
		}
		 		
	}

}
