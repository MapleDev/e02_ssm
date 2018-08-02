<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>listCategory</title>
</head>
<body>
<table border="1" cellspacing="0" cellpadding="5">
    <div style="text-align:center">
        <tr>
            <th>ID</th>
            <th>分类</th>
        </tr>
        <c:forEach items="${cs}" var="c" varStatus="st">
            <tr>
                <td>${c.id}</td>
                <td>${c.name}</td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="2">
                <a href="?start=0">首页</a>
                <a id="prePage" href="?start=${page.start - page.count}">上一页</a>
                <a id="nextPage" href="?start=${page.start + page.count}">下一页</a>
                <a href="?start=${page.last}">末页</a>
            </td>
        </tr>
    </div>

</table>
</body>
</html>