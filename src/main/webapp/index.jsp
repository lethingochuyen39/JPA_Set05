<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>list</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h3>Product List</h3>
    <div class="row">
        <div class="col-sm-10 table-responsive">
            <form action="<c:url value="/delete"/> " method="post">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>Deleted</th>
                        <th>ProductName</th>
                        <th>Price</th>
                        <th>Quantity</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${productList}" var="b">
                    <tr>
                        <td>
                            <input type="checkbox" name="del" value="${b.id}">
                        </td>
                        <td>${b.productName}</td>
                        <td>${b.price}</td>
                        <td>${b.quantity}</td>
                        </c:forEach>
                    </tbody>
                </table>
                <button type="submit" class="btn-sm btn-danger">Delete</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
