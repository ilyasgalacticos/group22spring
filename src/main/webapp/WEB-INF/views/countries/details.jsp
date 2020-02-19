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
            <form action="/saveuser" method="post">
                <div class="form-group">
                    <label>
                        FULL NAME:
                    </label>
                    <input type="hidden" name="id" value="${user.id}">
                    <input type="text" class="form-control" name = "full_name" value="${user.fullName}">
                </div>
                <div class="form-group">
                    <button class="btn btn-success">SAVE USER</button>
                </div>
            </form>

            <h3>
                ${user.fullName} were in :
            </h3>
            <c:forEach items="${user.cities}" var="cit">
                <h5>
                    ${cit.name} from ${cit.country.name}
                </h5>
            </c:forEach>

            <form action="/assigncity" method="post">
                <input type="hidden" name="user_id" value="${user.id}">
                <div class="form-group">
                    <label>
                        CITY NAME:
                    </label>
                    <select class="form-control" name="city_id">
                        <c:forEach items="${cities}" var="cit">
                            <option value="${cit.id}">${cit.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <button class="btn btn-success">ASSIGN CITY</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
