package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import uts.wsd.*;

public final class cancel_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Cancel Page</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");
 String path = application.getRealPath("WEB-INF/history.xml");
      out.write("\r\n");
      out.write("        ");
      uts.wsd.OrderApplication orderApp = null;
      synchronized (application) {
        orderApp = (uts.wsd.OrderApplication) _jspx_page_context.getAttribute("orderApp", PageContext.APPLICATION_SCOPE);
        if (orderApp == null){
          orderApp = new uts.wsd.OrderApplication();
          _jspx_page_context.setAttribute("orderApp", orderApp, PageContext.APPLICATION_SCOPE);
          out.write("\r\n");
          out.write("            ");
          org.apache.jasper.runtime.JspRuntimeLibrary.handleSetProperty(_jspx_page_context.findAttribute("orderApp"), "filePath",
path);
          out.write("\r\n");
          out.write("        ");
        }
      }
      out.write("\r\n");
      out.write("    <center>\r\n");
      out.write("        <form action=\"cancelAction.jsp\" method = \"post\">\r\n");
      out.write("            ");

                String ID = request.getParameter("bookingIDSelect");
                Order order = orderApp.getOrderByID(ID);
                ArrayList<Item> items = order.getOrderItems();
                if (order != null) {
      out.write("\r\n");
      out.write("            <h1>Do you want to cancel order ID ");
      out.print(ID);
      out.write("? </h1>\r\n");
      out.write("            <table border=\"2\">\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <th>Title</th>\r\n");
      out.write("                    <th>Genre</th>\r\n");
      out.write("                    <th>Release Year</th>\r\n");
      out.write("                    <th>Copies Purchased</th>\r\n");
      out.write("                </tr>\r\n");
      out.write("                ");

                    if (items.size() > 0) {
                        for (Item item : items) {
                            String title = item.getMovieTitle();
                            String genre = item.getMovieGenre();
                            String releaseDate = item.getReleaseDate();
                            int copiesPurchased = item.getCopiesPurchased();
                
      out.write("\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>");
      out.print(title);
      out.write("</td>\r\n");
      out.write("                    <td>");
      out.print(genre);
      out.write("</td>\r\n");
      out.write("                    <td>");
      out.print(releaseDate);
      out.write("</td>\r\n");
      out.write("                    <td>");
      out.print(copiesPurchased);
      out.write("</td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                ");

                            session.setAttribute("cancelOrder", order);
                        }
                    }
      out.write("\r\n");
      out.write("            </table>\r\n");
      out.write("            ");
}
      out.write("\r\n");
      out.write("            <input type=\"submit\" value=\"Cancel Order\"/>\r\n");
      out.write("        </form>\r\n");
      out.write("    </center>\r\n");
      out.write("</body>\r\n");
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
