<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Title</title>
        <%@include file="../templates/head.jsp"%>
    </head>
    <body>
        <div class="container mt-5">
            <h1>
                ${userData}
            </h1>
            <a href="/addnews" class="btn btn-success">ADD NEWS</a>
            <br>
            <br>
            <div class="row mb-3">
                <div class="col-sm-12">

                    <c:forEach items="${news}" var="n">
                        <div class="jumbotron">
                            <h4>
                                ${n.title}
                            </h4>
                            <p class="lead">
                                ${n.content}
                            </p>
                            <b>
                                Posted at : ${n.postDate}
                            </b>
                            <br>
                            <br>
                            <a class="btn btn-primary btn-sm" href="/readnews/${n.id}" role="button">Read more</a>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </body>
</html>
