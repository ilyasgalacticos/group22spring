<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Title</title>
        <%@include file="../templates/head.jsp"%>
    </head>
    <body>
        <div class="container mt-5">
            <a href="/addblog" class="btn btn-success">ADD BLOG</a>
            <br>
            <br>
            <div class="row mb-3">
                <div class="col-sm-12">

                    <c:forEach items="${blogs}" var="b">
                        <div class="jumbotron">
                            <h4>
                                ${b.title}
                            </h4>
                            <p class="lead">
                                ${b.content}
                            </p>
                            <b>
                                Posted at : ${b.postDate}
                            </b>
                            <a class="btn btn-primary btn-sm" href="/readblog/${b.id}/${b.latinUrl}.html" role="button">Read more</a>
                        </div>
                    </c:forEach>

                </div>
            </div>
        </div>
    </body>
</html>
