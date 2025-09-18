<%@ page contentType="text/html;charset=UTF-8" %>
<html><body>
<h2>Inventory</h2>
<c:if test="${not empty product}">
    <p>Product: ${product.name}, Stock: ${product.stockQuantity}, Location: ${product.location}</p>
</c:if>
<c:if test="${not empty products}">
    <ul>
    <c:forEach var="p" items="${products}">
        <li>${p.name} - Stock: ${p.stockQuantity} - Location: ${p.location}</li>
    </c:forEach>
    </ul>
</c:if>
</body></html>
