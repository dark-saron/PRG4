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
        A_List = AlLogic.getArticleList();
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		
		
		resp.setContentType( "text/html;charset=UTF-8" );
		resp.getOutputStream().println( "<html xmlns=" +
				"'http://www.w3.org/1999/xhtml/'><head><meta http-equiv='Content-Type' content='text/html; charset=utf-8/' />" +
				"<title>Artikel Liste</title></head>" );
		resp.getOutputStream().println( "<body>"+
"<div id='navi'>"+
"	<div id='content' style='margin:auto; width:600px'>" +
	"<span style='float:left; padding-right:5%'><h2><a href='/flogit_web/ArticleList'>Article</a></h2></span>" +
    "<span style='float:left;padding-right:5%'><h2><a href='/flogit_web/OfferList'>Angebote</a></h2></span>" +
    "<span style='float:left;padding-right:5%'><h2><a href='/flogit_web/ContactList'>Kontakte</a></h2></span>" +
    "</div></div>" );
		
		resp.getOutputStream().println( " <div style='float:left; padding:5% 20%''>" +
"<div id='content' style='margin:auto; width:800px'>" +
"<table width='600' border='1'>"+
"<tr><th scope='col'><b>ID</b></th><th scope='col'><b>Name</b></th><th scope='col'><b>Type</b></th><th scope='col'><b>Details</b></th></tr>");
		  // The results will be passed back (as an attribute) to the JSP view
	    // The attribute will be a name/value pair, the value in this case will be a List object
	    //request.setAttribute("article", A_List);
	    //RequestDispatcher view = request.getRequestDispatcher("ArticleList.jsp");
	    //view.forward(request, resp); 
	    
	    
	    
		for (Article art : A_List) {
			resp.getOutputStream().println( "<tr><td style='text-align:center'>" );
			resp.getOutputStream().println(art.getId());
			resp.getOutputStream().println( "</td>" );
			resp.getOutputStream().println( "<td style='text-align:center'>" );
			resp.getOutputStream().println(art.getName());
			resp.getOutputStream().println( "</td>" );
			resp.getOutputStream().println( "<td style='text-align:center'>" );
			resp.getOutputStream().println(art.getType());
			resp.getOutputStream().println( "</td>" );
			resp.getOutputStream().println( "<td style='text-align:center'>" );
			resp.getOutputStream().println("<a href='/flogit_web/ArticleDetails");
			resp.getOutputStream().println( "'>Show Details</a></td>" );
			resp.getOutputStream().println( "</tr>");
		}
		resp.getOutputStream().println( "</table></div>" +
				"<a href='/flogit_web/NewArticle'>Erstelle Artikel</a></div></div>" );
		resp.getOutputStream().println( "</body></html>" );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
