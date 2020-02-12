<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.group22.db.Items" %>
<%@ page import="java.util.List" %>
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
                            Item saved successfully!!!
                        </div>
                    <%
                        }
                    %>
                    <form action="" method="post">
                        <div class="form-group">
                            <label>
                                NAME:
                            </label>
                            <input type="text" class="form-control" name="item_name" value="${item.name}">
                        </div>
                        <div class="form-group">
                            <label>
                                SHOP NAME:
                            </label>
                            <select class="form-control" name="shop_name">
                                <%
                                    Items item = (Items) request.getAttribute("item");
                                    List<String> shops = (ArrayList<String>)request.getAttribute("shopCenters");
                                    if(shops!=null){
                                        for(String sh : shops){
                                %>
                                   <option <% if(sh.equals(item.getShop())){ out.print("selected"); } %> >
                                       <%
                                           out.print(sh);
                                       %>
                                   </option>
                                <%
                                        }
                                    }
                                %>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>
                                PRICE:
                            </label>
                            <input type="number" class="form-control" name="item_price" value="${item.price}">
                        </div>
                        <div class="form-group">
                            <button class="btn btn-success">
                                SAVE ITEM
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

    </body>
</html>
