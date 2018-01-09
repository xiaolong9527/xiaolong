package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<c:set var=\"ctxStatic\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/static\"/>\r\n");
      out.write("<c:set var=\"contextPath\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("\r\n");
      out.write("<title>ClusterApp Test</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<embed src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/static/1.mp3\" loop=\"10\" autostar=\"true\" hidden=\"true\" />\r\n");
      out.write("        访问的Nginx IP:");
      out.print(request.getServerName());
      out.write("\r\n");
      out.write("        <BR>\r\n");
      out.write("        Tomcat SessionPort:");
      out.print(request.getServerPort());
      out.write("\r\n");
      out.write("        ");

                out.println("Tomcat Server Info=" + request.getLocalAddr() + " : "     + request.getLocalPort() + "<br>");
                out.println("当前 Session ID=" + session.getId() + "<br>");
        
      out.write("\r\n");
      out.write("\r\n");
      out.write("        ");

                String dataName = request.getParameter("dataName");
                if (dataName != null && dataName.length() > 0) {
                        String dataValue = request.getParameter("dataValue");
                        session.setAttribute(dataName, dataValue);
                }

                out.println("<b>Session列表</b><br>");
                System.out.println("Session列表");
                Enumeration e = session.getAttributeNames();
                while (e.hasMoreElements()) {
                        String name = (String) e.nextElement();
                        String value = session.getAttribute(name).toString();
                        out.println(name + " = " + value + "<br>");
                        System.out.println(name + " = " + value);
                }
        
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <form action=\"sessiontest.html\" method=\"POST\">\r\n");
      out.write("                名称:<input type=text size=20 name=\"dataName\"> <br/>\r\n");
      out.write("                值:<input type=text size=20 name=\"dataValue\"> <br/>\r\n");
      out.write("                <input type=submit text=\"提交\">\r\n");
      out.write("        </form>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else log(t.getMessage(), t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
