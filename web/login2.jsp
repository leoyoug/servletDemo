<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/16
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/img.css">
</head>
<body>
<%
    String msg= (String) session.getAttribute("codewrong");

    session.removeAttribute("codewrong");
    if (msg!=null){
        out.write("<script>alert('错误的验证码');</script>");
    }
    String user= (String) session.getAttribute("userwrong");
    session.removeAttribute("userwrong");
    if (user!=null){
        out.write("<script>alert('用户名密码输入错误');</script>");
    }
%>
<div id="header"></div>
<div id="form">
<form action="/touch/loginuser">
    <table >
        <tr>
            <td>用户名</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td>验证码</td>
            <td><input type="text" name="code"></td>
            <td><img src="/touch/code" alt=""></td>
        </tr>
        <tr>
            <td><input type="submit" value="提交"></td>
        </tr>
    </table>
</form>
    <div>
        <span>还没有账号？</span>
        <span><a href="${pageContext.request.contextPath}/register.jsp">注册</a></span>
    </div>
</div>
</body>
</html>
