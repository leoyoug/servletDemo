<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/17
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
    <style type="text/css">
        div{
            width: 300px;
            height: 300px;
            margin: 0 auto;
            background-color: azure;
        }
    </style>
</head>
<body>
    <%
        String success= (String) request.getAttribute("success");
        if(success!=null) {
            if (success.equals("yes")) {
                out.write("<script>alert('注册成功，返回登录页');</script>");
                response.sendRedirect("login2.jsp");
            }
            if (success.equals("no")) {
                out.write("<script>alert('系统异常请稍后再试');</script>");
                response.sendRedirect("login2.jsp");
            }
        }

    %>
    <div>
        <form action="${pageContext.request.contextPath}/register" method="post">
            <table>
                <tr>
                    <td>用户名</td>
                    <td><input type="text" name="name"></td>
                       <span>${map.name}</span>
                </tr>
                <tr>
                    <td>密码</td>
                    <td><input type="password" name="password"></td>
                    <span>${map.password}</span>
                </tr>
                <tr>
                    <td>邮箱</td>
                    <td><input type="text" name="email"></td>
                </tr>
                <tr>
                    <td>生日</td>
                    <td><input type="date" name="birthday"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="提交"></td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
