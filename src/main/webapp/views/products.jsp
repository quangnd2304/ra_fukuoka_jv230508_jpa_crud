<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: This MC
  Date: 01/11/2023
  Time: 7:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Products</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/productController/search" method="get">
    <input type="text" id="searchName" name="searchName" placeholder="input product name"/>
    <input type="submit" value="Search"/>
</form>
<table border="1">
    <thead>
    <tr>
        <th>Product Id</th>
        <th>Product Name</th>
        <th>Price</th>
        <th>Catalog Name</th>
        <th>Status</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listProduct}" var="product">
        <tr>
            <td>${product.productId}</td>
            <td>${product.productName}</td>
            <td>${product.price}</td>
            <td>${product.catalog.catalogName}</td>
            <td>${product.status?"Active":"Inactive"}</td>
            <td>
                <a href="">Update</a>
                <a href="">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="<%=request.getContextPath()%>/productController/initCreate">Create New Product</a>
</body>
</html>
