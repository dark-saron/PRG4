package de.fhe.ai.prg4.view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.fhe.ai.prg4.model.Article;

/**
 * Servlet implementation class DeleteArticle
 */
@WebServlet("/ArticleDelete")
public class ArticleDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		resp.setContentType( "text/html;charset=UTF-8" );
		resp.getOutputStream().println( "<html xmlns=" +
				"'http://www.w3.org/1999/xhtml/'><head><meta http-equiv='Content-Type' content='text/html; charset=utf-8/' />" +
				"<title>Artikel Liste</title></head>" );
		resp.getOutputStream().println( "<body><div id='navi'>"+
"	<div id='content' style='margin:auto; width:600px'>" +
	"<span style='float:left; padding-right:5%'><h2><a href='/flogit_web/ArticleList'>Article</a></h2></span>" +
    "<span style='float:left;padding-right:5%'><h2><a href='/flogit_web/OfferList'>Angebote</a></h2></span>" +
    "<span style='float:left;padding-right:5%'><h2><a href='/flogit_web/ContactList'>Kontakte</a></h2></span>" +
    "</div></div>" );
		
		resp.getOutputStream().println( " <div style='float:left; padding:5% 20%''>" +
				"<div id='content' style='margin:auto; width:800px'>" );
		resp.getOutputStream().println( " Artikel wurde entfernt");
		resp.getOutputStream().println( "</body></html>" );
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
