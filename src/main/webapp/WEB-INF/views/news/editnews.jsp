<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <%@include file="../templates/head.jsp"%>
</head>
<body>
<div class="container mt-5">
    <a href="/" class="btn btn-success">HOME PAGE</a>
    <br>
    <div class="row mb-3">
        <div class="col-sm-6 offset-3">
            <form action="/savenews" method="post">
                <input type="hidden" name="id" value="${news.id}">
                <div class="form-group">
                    <label>
                        TITLE:
                    </label>
                    <input type="text" class="form-control" name = "title" value="${news.title}">
                </div>
                <div class="form-group">
                    <label>
                        CONTENT:
                    </label>
                    <textarea class="form-control" name="content">${news.content}</textarea>
                </div>
                <div class="form-group">
                    <button class="btn btn-success">SAVE NEWS</button>
                </div>
            </form>
            <form action="/deletenews" method="post">
                <input type="hidden" name="id" value="${news.id}">
                <button class="btn btn-danger">DELETE</button>
            </form>

        </div>
    </div>
</div>
</body>
</html>
