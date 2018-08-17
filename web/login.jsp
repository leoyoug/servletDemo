<%@ page import="java.util.Date" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/14
  Time: 12:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Date date=new Date();
        PrintWriter outs=response.getWriter();
        outs.write(date.toString());
    %>
    <%
        List list=new ArrayList();
        list.add("aaaa");
        list.add("bbbb");
        list.add("cccc");
        list.add("ddddd");
        request.setAttribute("list",list);
    %>
    <table>
    <c:forEach items="${list}" var="l" varStatus="vs">
        <tr>
            <td>aaaaaa</td>
            <td>${l}</td>
            <td>${vs.count}</td>
            ${empty list}
        </tr>
    </c:forEach>
    </table>


</body>
</html>
