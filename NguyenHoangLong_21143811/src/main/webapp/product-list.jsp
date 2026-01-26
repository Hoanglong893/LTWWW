<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Quản lý Sản phẩm</title>
    <style>
        body { font-family: Arial; margin: 20px; }
        table { border-collapse: collapse; width: 100%; }
        th, td { border: 1px solid #ddd; padding: 12px; text-align: left; }
        th { background-color: #4CAF50; color: white; }
        img { max-width: 100px; height: auto; }
        .btn { padding: 8px 16px; text-decoration: none; margin: 2px; }
        .btn-add { background: #4CAF50; color: white; }
        .btn-edit { background: #2196F3; color: white; }
        .btn-delete { background: #f44336; color: white; }
    </style>
</head>
<body>
    <h1>Danh sách Sản phẩm</h1>
    <a href="new" class="btn btn-add">Thêm Sản phẩm mới</a>
    <br><br>
    <table>
        <tr>
            <th>ID</th>
            <th>Hình ảnh</th>
            <th>Tên sản phẩm</th>
            <th>Giá (VNĐ)</th>
            <th>Thao tác</th>
        </tr>
        <c:forEach var="product" items="${listProduct}">
            <tr>
                <td>${product.id}</td>
                <td><img src="${product.urlImage}" alt="${product.name}"></td>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>
                    <a href="edit?id=${product.id}" class="btn btn-edit">Sửa</a>
                    <a href="delete?id=${product.id}" class="btn btn-delete"
                       onclick="return confirm('Bạn có chắc muốn xóa?')">Xóa</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>