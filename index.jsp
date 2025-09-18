<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Crear Pedido</title>
    <script>
        function addRow() {
            var table = document.getElementById("itemsTable");
            var row = table.insertRow();
            row.innerHTML = '<td><input type="number" name="productId" required></td>' +
                            '<td><input type="number" name="quantity" required></td>' +
                            '<td><input type="number" name="price" step="0.01" required></td>';
        }
    </script>
</head>
<body>
<h2>Crear nuevo pedido</h2>
<c:if test="${not empty error}">
    <p style="color:red;">${error}</p>
</c:if>
<c:if test="${not empty message}">
    <p style="color:green;">${message}</p>
</c:if>
<form method="post" action="${pageContext.request.contextPath}/orders">
    <label>Nombre del cliente: <input type="text" name="customerName" required></label><br>
    <label>Fecha del pedido: <input type="date" name="orderDate" required></label><br>
    <h3>Items</h3>
    <table id="itemsTable">
        <tr><th>Product ID</th><th>Cantidad</th><th>Precio</th></tr>
        <tr>
            <td><input type="number" name="productId" required></td>
            <td><input type="number" name="quantity" required></td>
            <td><input type="number" name="price" step="0.01" required></td>
        </tr>
    </table>
    <button type="button" onclick="addRow()">Agregar Item</button><br><br>
    <button type="submit">Crear Pedido</button>
</form>
</body>
</html>
