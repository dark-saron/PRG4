package de.fhe.ai.prg4.view;

import java.io.IOException;

import de.fhe.ai.prg4.io_database.DBManager;
import de.fhe.ai.prg4.model.Article;
import java.util.LinkedList;

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
        A_List = DBManager.queryAllArticle();//AlLogic.getArticleList();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType( "text/html;charset=UTF-8" );
		resp.getOutputStream().println( "<html><body>" );
		resp.getOutputStream().println( "<p><b><i>" );
		resp.getOutputStream().println( "Article List Page" );
		
		for (Article art : A_List) {
			resp.getOutputStream().println( art.getName() );
		}
		resp.getOutputStream().println( "</p></i></b>" );
		resp.getOutputStream().println( "</body></html>" );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
