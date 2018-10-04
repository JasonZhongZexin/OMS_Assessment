package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import uts.wsd.*;

public final class account_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=utf-8");
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n");
      out.write("        <title>Account page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <a href=\"main.jsp\">Main</a>&nbsp;\n");
      out.write("        <a href=\"logout.jsp\">Logout</a><br><br>\n");
      out.write("        ");

              User user = (User) session.getAttribute("userLogin");
            if (user == null) {
                response.sendRedirect("login.jsp");
            }
        
      out.write("\n");
      out.write("        <form action=\"accountAction.jsp\">\n");
      out.write("            <input type=\"hidden\" name=\"sub\" value=\"save\">\n");
      out.write("            Full Name  <input type=\"text\" name=\"fullname\"\n");
      out.write("                               value=\"");
      out.print(user.getFullName());
      out.write("\"> <br>\n");
      out.write("            Email  <input type=\"text\" value=\"");
      out.print(user.getEmail());
      out.write("\"\n");
      out.write("                         readonly=\"readonly\" name=\"email\"><br>\n");
      out.write("            Password  <input name=\"password\"\n");
      out.write("                            type=\"text\" value=\"");
      out.print(user.getPassword());
      out.write("\"><br>\n");
      out.write("            Phone number  <input name=\"phonenumber\" type=\"tel\" value=\"");
      out.print(user.getPhoneNumber());
      out.write("\"><br>\n");
      out.write("            Address  <input name=\"address\" type=\"text\" value=\"");
      out.print(user.getAddress());
      out.write("\"><br>\n");
      out.write("            <input type=\"submit\" value=\"save\">&nbsp;<br>\n");
      out.write("            <input type=\"button\" value=\"Remove account\" onclick=\"window.location.href = 'accountAcction.jsp?sub=cancelled'\">\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("    </body>\n");
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
