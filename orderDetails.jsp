<%@ page contentType="text/html;charset=UTF-8" %>
<html><body>
<h2>Order Details</h2>
<p>Order ID: ${order.id}</p>
<p>Customer: ${order.customerName}</p>
<p>Date: ${order.orderDate}</p>
<ul>
<c:forEach var="item" items="${order.items}">
    <li>Product ID: ${item.productId}, Quantity: ${item.quantity}, Price: ${item.price}</li>
</c:forEach>
</ul>
</body></html>
