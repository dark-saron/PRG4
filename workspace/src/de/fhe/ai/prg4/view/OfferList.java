package de.fhe.ai.prg4.view;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.fhe.ai.prg4.controller.ArticelListLogic;
import de.fhe.ai.prg4.controller.OfferListLogic;
import de.fhe.ai.prg4.model.Article;
import de.fhe.ai.prg4.model.Offer;

/**
 * Servlet implementation class OfferList
 */
@WebServlet("/OfferList")
public class OfferList extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static OfferListLogic OlLogic = new OfferListLogic();
	LinkedList<Offer> O_List = new LinkedList<Offer>();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OfferList() {
        super();
        O_List = OlLogic.getOfferList();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType( "text/html;charset=UTF-8" );
		resp.getOutputStream().println( "<html xmlns=" +
				"'http://www.w3.org/1999/xhtml/'><head><meta http-equiv='Content-Type' content='text/html; charset=utf-8/' />" +
				"<title>Angebots Liste</title></head>" );
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
"<tr><th scope='col'><b>Angebots ID</b></th><th scope='col'><b>Artikel Name</b></th><th scope='col'><b>Status</b></th><th scope='col'><b>Angebots Details</b></th></tr>");
		
	for (Offer offer : O_List) {
			resp.getOutputStream().println( "<tr><td style='text-align:center'>" );
			resp.getOutputStream().println(offer.getId());
			resp.getOutputStream().println( "</td>" );
			resp.getOutputStream().println( "<td style='text-align:center'>" );
			resp.getOutputStream().println(offer.getArticle_Name());
			resp.getOutputStream().println( "</td>" );
			resp.getOutputStream().println( "<td style='text-align:center'>" );
			switch (offer.getStatus()) {
			case 0:
				resp.getOutputStream().println("Offen");
				break;
			case 1:
				resp.getOutputStream().println("Gekauft");
				break;
			case 2:
				resp.getOutputStream().println("Abgelaufen");
				break;
			default:
				resp.getOutputStream().println("Undefined");
				break;
			}
			
			resp.getOutputStream().println( "</td>" );
			resp.getOutputStream().println( "<td style='text-align:center'>" );
			resp.getOutputStream().println("<a href='/flogit_web/Offer'");
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
