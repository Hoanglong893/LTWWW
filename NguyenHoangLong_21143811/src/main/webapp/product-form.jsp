<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Form Sản phẩm</title>
    <style>
        body { font-family: Arial; margin: 20px; }
        form { max-width: 500px; }
        input[type=text], input[type=number] {
            width: 100%; padding: 10px; margin: 8px 0; box-sizing: border-box;
        }
        input[type=submit] {
            background: #4CAF50; color: white; padding: 12px 20px;
            border: none; cursor: pointer;
        }
        label { font-weight: bold; }
    </style>
</head>
<body>
    <h1>
        <c:if test="${product != null}">Sửa Sản phẩm</c:if>
        <c:if test="${product == null}">Thêm Sản phẩm mới</c:if>
    </h1>

    <form action="${product != null ? 'update' : 'insert'}" method="post">
        <c:if test="${product != null}">
            <input type="hidden" name="id" value="${product.id}"/>
        </c:if>

        <label>Tên sản phẩm:</label><br>
        <input type="text" name="name" value="${product.name}" required/><br>

        <label>Giá (VNĐ):</label><br>
        <input type="number" name="price" value="${product.price}" required/><br>

        <label>URL Hình ảnh:</label><br>
        <input type="text" name="urlImage" value="${product.urlImage}"/><br><br>

        <input type="submit" value="Lưu"/>
        <a href="list">Quay lại</a>
    </form>
</body>
</html>