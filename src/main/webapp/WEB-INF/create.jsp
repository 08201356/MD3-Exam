<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/10/2023
  Time: 11:23 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Thêm Nhân Viên Mới</title>
</head>
<body>
<center>
    <h1>Thêm Nhân Viên Mới</h1>
    <h2>
        <a href="nhanvien?action=nhanvien">Danh Sách Nhân Viên</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Thêm Nhân Viên</h2>
            </caption>
            <tr>
                <th>Tên:</th>
                <td>
                    <input type="text" name="name" id="name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Email:</th>
                <td>
                    <input type="text" name="email" id="email" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Địa chỉ:</th>
                <td>
                    <input type="text" name="address" id="address"/>
                </td>
            </tr>
            <tr>
                <th>Số Điện Thoại:</th>
                <td>
                    <input type="text" name="phoneNumber" id="phoneNumber" size="30">
                </td>
            </tr>
            <tr>
                <th>Lương:</th>
                <td>
                    <input type="text" name="salary" id="salary" size="30">
                </td>
            </tr>
            <tr>
                <th>Phòng Ban:</th>
                <td>
                    <input type="text" name="department" id="department">
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Lưu"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>