<%@ page contentType="text/html;charset=UTF-8" %>
<html><body>
<h2>Orders</h2>
<ul>
<c:forEach var="o" items="${orders}">
    <li>Order #${o.id} - ${o.customerName} - ${o.orderDate}</li>
</c:forEach>
</ul>
</body></html>
