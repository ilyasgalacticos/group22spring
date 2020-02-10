<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.group22.db.Items" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ilyas" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Title</title>
        <%@include file="templates/head.jsp"%>
    </head>
    <body>
        <div class="container mt-5">
            <div class="row mb-3">
                <div class="col-sm-6 offset-3">
                    <%
                        if(request.getParameter("success")!=null){
                    %>
                        <div class="alert alert-success" role="alert">
                            Item added successfully!!!
                        </div>
                    <%
                        }
                    %>
                    <form action="/additem" method="post">
                        <div class="form-group">
                            <label>
                                NAME:
                            </label>
                            <input type="text" class="form-control" name="item_name">
                        </div>
                        <div class="form-group">
                            <label>
                                SHOP NAME:
                            </label>
                            <select class="form-control" name="shop_name">
                                <ilyas:forEach items="${shopCenters}" var="sh">
                                    <option>${sh}</option>
                                </ilyas:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>
                                PRICE:
                            </label>
                            <input type="number" class="form-control" name="item_price">
                        </div>
                        <div class="form-group">
                            <button class="btn btn-success">
                                ADD ITEM
                            </button>
                        </div>
                    </form>
                </div>
            </div>
            <table class="table table-stripped">
                <thead>
                    <tr>
                        <th>
                            ID
                        </th>
                        <th>
                            NAME
                        </th>
                        <th>
                            SHOP
                        </th>
                        <th>
                            PRICE
                        </th>
                    </tr>
                </thead>
                <tbody>
                    <ilyas:forEach items="${itemler}" var="item">
                        <tr>
                            <td>${item.id}</td>
                            <td>${item.name}</td>
                            <td>${item.shop}</td>
                            <td>${item.price} KZT</td>
                        </tr>
                    </ilyas:forEach>
                </tbody>
            </table>

        </div>

    </body>
</html>
