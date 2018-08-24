<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/20
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/table.css">
</head>
<body>
<div id="search">
    <form action="">
        <table>
            <tr>
                <td>商品名称</td>
                <td><input type="text" name="name"></td>
                <td>商品分类</td>
                <td><select name="category" id="">
                    <c:forEach items="${category}" var="cate" >
                        <option value="${cate}">
                            ${cate}
                        </option>
                    </c:forEach><%--需要jsp传入--%>
                </select></td>
            </tr>
            <tr>
                <td><input type="submit" value="提交"></td>
                <td><a href="addbook.jsp"><input type="button" value="新增图书"></a></td>
            </tr>
        </table>
    </form>
</div>
<div id="list">
    <form action="">
        <table>
            <%--list标题--%>
            <tr id="captain">
                <td>书名</td>
                <td>价格</td>
                <td>出版社</td>
                <td>作者</td>
                <td>分类</td>
            </tr>
            <c:forEach items="${booklist}" var="book">
                <tr>
                    <td>${book.name}</td>
                    <td>${book.price}</td>
                    <td>${book.publication}</td>
                    <td>${book.author}</td>
                    <td>${book.category}</td>
                </tr>
            </c:forEach>
        </table>
    </form>
    <div>
        <span>
            <a href="booklist?current=${current==1?1:current-1}">上一页</a>
            ${current}/${count}
            <a href="booklist?current=${current==count?count:current+1}">下一页</a>
        </span>
    </div>
</div>
</body>
</html>
