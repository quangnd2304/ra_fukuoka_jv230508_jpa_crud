<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: This MC
  Date: 30/10/2023
  Time: 7:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Categories</title>
</head>
<body>
    <table border="1">
        <thead>
            <tr>
                <th>Catalog Id</th>
                <th>Catalog Name</th>
                <th>Price</th>
                <th>Created</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listCatalog}" var="catalog">
                <tr>
                    <td>${catalog.catalogId}</td>
                    <td>${catalog.catalogName}</td>
                    <td>${catalog.price}</td>
                    <td><fmt:formatDate value="${catalog.created}" pattern="dd/MM/yyyy"/></td>
                    <td>${catalog.status?"Active":"Inactive"}</td>
                    <td>
                        <a href="">Update</a>
                        <a href="">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
