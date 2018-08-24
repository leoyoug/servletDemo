<%@ page import="com.touch.entity.Person" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/16
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        String role= (String) session.getAttribute("role");
        if (role==null){
            response.sendRedirect("login2.jsp");
            return;
        }
        Object i= request.getAttribute("ok");
        if(i==null){
            request.getRequestDispatcher("/welcome").forward(request,response);
        }


    %>
    <span>欢迎您：${role}</span><br/>
    <span>以下是所有的账号明细</span>
    <div>


        <table>
        ${list}
        <c:forEach items="${list}" var="l">
            <tr>
                <td>${l}</td>
            </tr>
        </c:forEach>
        </table>
    </div>
    <div>
        <a href="${pageContext.request.contextPath}/booklist">网上书城</a>
    </div>
</body>
</html>
