package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"OMS.css\"> \r\n");
      out.write("        <title>Index Page</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");
 String moviesPath = application.getRealPath("WEB-INF/movies.xml");
      out.write("\r\n");
      out.write("        ");
      uts.wsd.MoviesApplication movieApp = null;
      synchronized (application) {
        movieApp = (uts.wsd.MoviesApplication) _jspx_page_context.getAttribute("movieApp", PageContext.APPLICATION_SCOPE);
        if (movieApp == null){
          movieApp = new uts.wsd.MoviesApplication();
          _jspx_page_context.setAttribute("movieApp", movieApp, PageContext.APPLICATION_SCOPE);
          out.write("\r\n");
          out.write("            ");
          org.apache.jasper.runtime.JspRuntimeLibrary.handleSetProperty(_jspx_page_context.findAttribute("movieApp"), "filePath",
 moviesPath);
          out.write("\r\n");
          out.write("        ");
        }
      }
      out.write("\r\n");
      out.write("        <header>\r\n");
      out.write("            <nav class=\"nav\">\r\n");
      out.write("                <ul>\r\n");
      out.write("                    <li><a href = \"index.jsp\">Home</a></li>\r\n");
      out.write("                    <li><a href=\"history.jsp\">History</a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("                <div align=\"right\" margin-left=\"200px\">\r\n");
      out.write("                    <a href = \"login.jsp\">Login</a>\r\n");
      out.write("                    <a href = \"register.jsp\">Register</a>\r\n");
      out.write("                </div>\r\n");
      out.write("            </nav>\r\n");
      out.write("        </header>\r\n");
      out.write("        <form action=\"index.jsp\" method =\"post\">\r\n");
      out.write("            <table>\r\n");
      out.write("                <tr><td>Title: </td><td><input type=\"text\" placeholder=\"Title of Movie\" name = \"search_bar\"></td></tr>\r\n");
      out.write("                <tr><td>Genre: </td><td><input type=\"radio\"  name = \"action_radio\">action<input type=\"radio\"  name = \"Sci-Fi_radio\">Sci-Fi<input type=\"radio\"  name = \"Horror_radio\">Horror<input type=\"radio\"  name = \"comedy_radio\">Comedy</td></tr>\r\n");
      out.write("                <tr><td>Release Year: </td><td><input type=\"date\" name=\"start_date\" placeholder=\"From\">    <input type = \"date\" name=\"end_date\" placeholder=\"To\"></td></tr>\r\n");
      out.write("                <tr><td><input type=\"hidden\" value=\"submitted\" name=\"submitted\"></td><td><input class = \"button\" type=\"submit\" value=\"Search\"></td></tr>\r\n");
      out.write("            </table>\r\n");
      out.write("        </form>\r\n");
      out.write("        <footer>\r\n");
      out.write("            \r\n");
      out.write("        </footer>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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
