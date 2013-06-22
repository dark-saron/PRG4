package de.fhe.ai.prg4.view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Parser;
import com.sun.org.apache.xml.internal.serializer.utils.StringToIntTable;

import de.fhe.ai.prg4.model.User;

/**
 * Servlet implementation class Article
 */
@WebServlet(
		description = "Article Details", 
		urlPatterns = { "/Article" }, 
		initParams = { 
				@WebInitParam(name = "Name", value = "test", description = "test value")
		})
public class Article extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
     * @see HttpServlet#HttpServlet()
     */
    public Article() {
        super();
        // TODO Auto-generated constructor stub
            }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
/*		resp.setContentType( "text/html;charset=UTF-8" );
		resp.getOutputStream().println( "<html><body>" );
		resp.getOutputStream().println( "<p><b><i>" );
		resp.getOutputStream().println( "Article Details Page" );
		resp.getOutputStream().println( "</p></i></b>" );
		resp.getOutputStream().println( "</body></html>" );
	*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
        String type = request.getParameter("type");
        String description = request.getParameter("description");
        request.setAttribute("error", "Bitte alle Felder mit * ausfüllen!");
        request.getRequestDispatcher("/ArticleDetails.jsp").forward(request, response);
    
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
