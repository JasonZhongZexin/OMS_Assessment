package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import java.util.ArrayList;
import uts.wsd.Movie;
import uts.wsd.Movies;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"OMS.css\"> \n");
      out.write("        <title>Index Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        <header>\n");
      out.write("            <nav class=\"nav\">\n");
      out.write("                <ul>\n");
      out.write("                    <li><a href = \"index.jsp\">Home</a></li>\n");
      out.write("                    <li><a href=\"history.jsp\">History</a></li>\n");
      out.write("                </ul>\n");
      out.write("                <div align=\"right\" margin-left=\"200px\">\n");
      out.write("                    <a href = \"login.jsp\">Login</a>\n");
      out.write("                    <a href = \"register.jsp\">Register</a>\n");
      out.write("                </div>\n");
      out.write("            </nav>\n");
      out.write("        </header>\n");
      out.write("    <center>\n");
      out.write("        ");
 String filePath = application.getRealPath("WEB-INF/movies.xml");
      out.write("\n");
      out.write("        ");
      uts.wsd.MoviesApplication movieApp = null;
      synchronized (application) {
        movieApp = (uts.wsd.MoviesApplication) _jspx_page_context.getAttribute("movieApp", PageContext.APPLICATION_SCOPE);
        if (movieApp == null){
          movieApp = new uts.wsd.MoviesApplication();
          _jspx_page_context.setAttribute("movieApp", movieApp, PageContext.APPLICATION_SCOPE);
          out.write("\n");
          out.write("            ");
          org.apache.jasper.runtime.JspRuntimeLibrary.handleSetProperty(_jspx_page_context.findAttribute("movieApp"), "filePath",
 filePath);
          out.write("\n");
          out.write("        ");
        }
      }
      out.write("\n");
      out.write("        \n");
      out.write("        <form action=\"searchAction.jsp\" >\n");
      out.write("\n");
      out.write("            Title: <select name=\"title\">\n");
      out.write("                <option value=\"\">Search by title</option>\n");
      out.write("                <option value=\"The Nun\">The Nun</option>\n");
      out.write("            </select>\n");
      out.write("            Genre: <select name=\"genre\">\n");
      out.write("                        <option value=\"\">Search by genre</option>>\n");
      out.write("                        <option value = \"action\">Action</option>\n");
      out.write("                        <option value = \"Sci-Fi\">Sci-Fi</option>\n");
      out.write("                        <option value = \"Horror\">Horror</option>\n");
      out.write("                        <option value = \"Comedy\">Comedy</option>\n");
      out.write("                    </select>\n");
      out.write("            &nbsp;Release Year: <input type=\"text\" name=\"start_date\" placeholder=\"From\">    <input type = \"text\" name=\"end_date\" placeholder=\"To\">&nbsp;\n");
      out.write("            <input type=\"submit\" value=\"submitted\" class=\"button\">\n");
      out.write("        \n");
      out.write("        </form>\n");
      out.write("    </center>\n");
      out.write("    <center> <table border=\"2\">\n");
      out.write("              ");

             List<Movie> list = (List<Movie>) request.getAttribute("search");
         if (list != null) {
      out.write("\n");
      out.write("                \n");
      out.write("         <tr>\n");
      out.write("         <td>Movie title</td>\n");
      out.write("         <td>Genre</td>\n");
      out.write("         <td>Release date</td>\n");
      out.write("         <td>Price</td>\n");
      out.write("         <td>Available copies</td>\n");
      out.write("         <td>Check out</td>\n");
      out.write("         </tr>\n");
      out.write("         \n");
      out.write("                ");

            for (Movie movie : list) {
      
      out.write("\n");
      out.write("      <tr>\n");
      out.write("         <td>");
      out.print(movie.getMovie_title());
      out.write("</td>\n");
      out.write("         <td>");
      out.print(movie.getMovie_genre());
      out.write("</td>\n");
      out.write("         <td>");
      out.print(movie.getMovie_release_date());
      out.write("</td>\n");
      out.write("         <td>");
      out.print(movie.getMovie_price());
      out.write("</td>\n");
      out.write("         <td>");
      out.print(movie.getAvailable_copies());
      out.write("</td> \n");
      out.write("         <td>Check out now</a></td> \n");
      out.write("   \n");
      out.write("      </tr>   \n");
      out.write("                ");

                    }

      out.write("\n");
      out.write("\n");
      out.write("                ");

                    } else {

      out.write("\n");
      out.write("<p> Booked </p>\n");
      out.write("                ");

                    }

      out.write("\n");
      out.write("\n");
      out.write("    \n");
      out.write("        </table>\n");
      out.write("    </center>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
