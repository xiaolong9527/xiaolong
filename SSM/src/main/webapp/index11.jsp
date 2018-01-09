<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<c:set var="ctxStatic" value="${pageContext.request.contextPath}/static"/>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>ClusterApp Test</title>
</head>
<body>
<embed src="${pageContext.request.contextPath}/static/1.mp3" loop="10" autostar="true" hidden="true" />
        访问的Nginx IP:<%=request.getServerName()%>
        <BR>
        Tomcat SessionPort:<%=request.getServerPort()%>
        <%
                out.println("Tomcat Server Info=" + request.getLocalAddr() + " : "     + request.getLocalPort() + "<br>");
                out.println("当前 Session ID=" + session.getId() + "<br>");
        %>

        <%
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
        %>

        <form action="sessiontest.html" method="POST">
                名称:<input type=text size=20 name="dataName"> <br/>
                值:<input type=text size=20 name="dataValue"> <br/>
                <input type=submit text="提交">
        </form>
</body>
</html>