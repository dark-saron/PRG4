package de.fhe.ai.prg4.view;

import java.io.IOException;

import de.fhe.ai.prg4.model.Article;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.fhe.ai.prg4.controller.ArticelListLogic;

/**
 * Servlet implementation class ArticleList
 */
@WebServlet("/ArticleList")
public class ArticleList extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private static ArticelListLogic AlLogic = new ArticelListLogic();
    LinkedList<Article> A_List = new LinkedList<Article>();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleList() {
        super();
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		 A_List = AlLogic.getArticleList();
		 
		request.setAttribute("artList", A_List);
		RequestDispatcher view = request.getRequestDispatcher("ArticleList.jsp");
	    view.forward(request, resp); 
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		A_List = AlLogic.getArticleList();
		
		request.setAttribute("artList", A_List);
		RequestDispatcher view = request.getRequestDispatcher("ArticleList.jsp");
	    view.forward(request, response); 
	    
	}

}
