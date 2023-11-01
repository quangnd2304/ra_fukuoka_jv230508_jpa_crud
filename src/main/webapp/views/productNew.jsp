<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: This MC
  Date: 01/11/2023
  Time: 7:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create New Product</title>
</head>
<body>
  <form action="<%=request.getContextPath()%>/productController/create" method="post">
    <label for="productId">Product Id</label>
    <input type="text" id="productId" name="productId"/><br>
    <label for="productName">Product Name</label>
    <input type="text" id="productName" name="productName"/><br>
    <label for="price">Price</label>
    <input type="number" id="price" name="price"/><br>
    <label for="catalog">Choice catalog</label>
    <select id="catalog" name="catalog.catalogId">
      <c:forEach items="${listCategories}" var="catalog">
          <option value="${catalog.catalogId}">${catalog.catalogName}</option>
      </c:forEach>
    </select><br>
    <label for="active">Status</label>
    <input type="radio" id="active" name="status" checked/><label>Active</label>
    <input type="radio" id="inactive" name="status"/><label>Inactive</label><br>
    <input type="submit" value="Create"/>
  </form>
</body>
</html>
