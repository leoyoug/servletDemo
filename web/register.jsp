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
    <div>
        <form action="${pageContext.request.contextPath}/register" method="post">
            <table>
                <tr>
                    <td>用户名</td>
                    <td><input type="text" name="name"></td>
                </tr>
                <tr>
                    <td>密码</td>
                    <td><input type="password" name="password"></td>
                </tr>
                <tr>
                    <td>邮箱</td>
                    <td><input type="text" name="email"></td>
                </tr>
                <tr>
                    <td>生日</td>
                    <td><input type="date" name="date"></td>
                </tr>
                <tr><input type="submit" value="提交"></tr>
            </table>
        </form>
    </div>
</body>
</html>
