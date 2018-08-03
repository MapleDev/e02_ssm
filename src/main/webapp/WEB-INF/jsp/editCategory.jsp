<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>editCategory</title>
</head>
<body>
<table border="1" cellspacing="0" cellpadding="5">
    <div style="text-align:center">
        <form action="/updateCategory" method="post">
            分类 ID：${category.id}
            <br/>
            <input type="hidden" name="id" value="${category.id}">
            分类名称：<input type="text" name="name" value="${category.name}">
            <br/>
            <input type="submit">
        </form>
    </div>

</table>
</body>
</html>