package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import uts.wsd.*;
import java.util.ArrayList;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"OMS.css\"> \r\n");
      out.write("        <title>Main page</title>\r\n");
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
      out.write("        ");

            User user = (User) session.getAttribute("userLogin");
            if (user != null) {
      out.write("\r\n");
      out.write("        <header>\r\n");
      out.write("            <nav class=\"nav\">\r\n");
      out.write("                <ul>\r\n");
      out.write("                    <li><a href = \"index.jsp\">Home</a></li>\r\n");
      out.write("                    <li><a href = \"main.jsp\">My History</a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("                <div align=\"right\" margin-left=\"200px\">\r\n");
      out.write("                    <a href = \"logout.jsp\">Logout</a>\r\n");
      out.write("                </div>\r\n");
      out.write("            </nav>\r\n");
      out.write("        </header>\r\n");
      out.write("        ");

            ArrayList<Order> orders = orderApp.getUserOrder(user);
            History history = orderApp.getHistory();
      out.write("\r\n");
      out.write("        <h1>Welcome, ");
      out.print(user.getFullName());
      out.write("!</h1>\r\n");
      out.write("        <p align=\"right\"><a href = \"account.jsp\">Edit account details </a></p> \r\n");
      out.write("    <center>\r\n");
      out.write("        <h2>Your Orders</h2>\r\n");
      out.write("        ");

            if (orders.size() > 0) {
                history.printHistory(orders, out);
                orders = null;
            } else {
      out.write("\r\n");
      out.write("        <p>You have not place any order!</p>\r\n");
      out.write("        ");
}
      out.write("\r\n");
      out.write("    </center>\r\n");
      out.write("    ");
} else {
      out.write("\r\n");
      out.write("    <header>\r\n");
      out.write("        <nav class=\"nav\">\r\n");
      out.write("            <ul>\r\n");
      out.write("                <li><a href = \"index.jsp\">Home</a></li>\r\n");
      out.write("                <li><a href = \"main.jsp\">My History</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("            <div align=\"right\" margin-left=\"200px\">\r\n");
      out.write("                <a href = \"login.jsp\">Login</a>\r\n");
      out.write("                <a href = \"register.jsp\">Register</a>\r\n");
      out.write("            </div>\r\n");
      out.write("        </nav>\r\n");
      out.write("    </header>\r\n");
      out.write("    <h1>You are not login to the system! Please click <a href=\"login.jsp\">here </a>to login....</h1>\r\n");
      out.write("    ");

        }
    
      out.write("\r\n");
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
