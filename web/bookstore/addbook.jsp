<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/20
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/table.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/getajax.js"></script>
</head>
<body>
<c:choose>
    <c:when test="${flag}">
        <script>
            alert("保存成功")
            window.location.href="${pageContext.request.contextPath}/booklist";
        </script>
    </c:when>
    <c:when test="!${flag}">
        <script>
            alert("保存失败，请重试")
        </script>
    </c:when>
</c:choose>
<form action="addbook" method="post">
    <table>
        <tr>
            <td>书名</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>价格</td>
            <td><input type="text" name="price"></td>
        </tr>
        <tr>
            <td>出版社</td>
            <td><input type="text" name="publication"></td>
        </tr>
        <tr>
            <td>作者</td>
            <td><input type="text" name="author"></td>
        </tr>
        <tr>
            <td>图片</td>
            <td><input type="file"></td>
        </tr>
        <tr>
            <td>分类</td>
            <td><input type="text" name="category"></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="提交">
            </td>
        </tr>
    </table>
</form>
</body>
<script type="text/javascript">
    xmlhttp=null;
    xmlhttp=getajax();
    xmlhttp.onreadystatechange=function()
    {
        if (xmlhttp.readyState==4 && xmlhttp.status==200)
        {
            document.getElementById("myDiv").innerHTML=xmlhttp.responseText;
        }
    }
    xmlhttp.open("GET","/try/ajax/ajax_info.txt",true);
    xmlhttp.send();
</script>
</html>
