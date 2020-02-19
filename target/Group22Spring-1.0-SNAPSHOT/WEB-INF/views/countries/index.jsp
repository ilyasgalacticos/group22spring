<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Title</title>
        <link rel="stylesheet" href="resources/css/myCss.css" type="text/css">
        <%@include file="../templates/head.jsp"%>
    </head>
    <body>
        <div class="container mt-5">
            <a href="/addcountry" class="btn btn-success">ADD COUNTRY</a>
            <br>
            <br>
            <div class="row">
                <div class="col-sm-6 offset-3">
                    <form action="/adduser" method="post">
                        <div class="form-group">
                            <label>
                                FULL NAME:
                            </label>
                            <input type="text" class="form-control" name = "full_name">
                        </div>
                        <div class="form-group">
                            <button class="btn btn-success">ADD USER</button>
                        </div>
                    </form>
                </div>
            </div>
            <br>
            <br>
            <div class="row mb-3">
                <div class="col-sm-12">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>
                                ID
                            </th>
                            <th>
                                FULL NAME
                            </th>
                            <th style="width: 10px;">
                                DETAILS
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${users}" var="usr">
                            <tr>
                                <td>
                                        ${usr.id}
                                </td>
                                <td>
                                        ${usr.fullName}
                                </td>
                                <td>
                                    <a href="/details/${usr.id}" class="btn btn-info btn-sm">EDIT</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <br>
            <br>
            <div class="row">
                <div class="col-sm-6 offset-3">
                    <form action="/addcity" method="post">
                        <div class="form-group">
                            <label>
                                NAME:
                            </label>
                            <input type="text" class="form-control" name = "name">
                        </div>
                        <div class="form-group">
                            <label>
                                COUNTRY:
                            </label>
                            <select name="country_id" class="form-control">
                                <c:forEach items="${countries}" var="cnt">
                                    <option value="${cnt.id}">${cnt.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <button class="btn btn-success">ADD CITY</button>
                        </div>
                    </form>
                </div>
            </div>
            <br>
            <div class="row mb-3">
                <div class="col-sm-12">
                    <table class="table">
                        <thead>
                            <tr>
                                <th>
                                    ID
                                </th>
                                <th>
                                    NAME
                                </th>
                                <th>
                                    COUNTRY
                                </th>
                                <th style="width: 10px;">
                                    EDIT
                                </th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${cities}" var="cit">
                                <tr>
                                    <td>
                                        ${cit.id}
                                    </td>
                                    <td>
                                        ${cit.name}
                                    </td>
                                    <td>
                                        ${cit.country.name}
                                    </td>
                                    <td>
                                         <a href="/edit/${cit.id}" class="btn btn-info btn-sm">EDIT</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
