<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/10/2023
  Time: 11:24 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh Sách Nhân Viên</title>
</head>
<body>
<center>
    <h1>Danh Sách Nhân Viên</h1>
    <h2>
        <a href="/users?action=create">Thêm Nhân Viên</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>ID</th>
            <th>Tên</th>
            <th>Email</th>
            <th>Địa chỉ</th>
            <th>Số Điện Thoại</th>
            <th>Lương</th>
            <th>Phòng Ban</th>
            <th>Tác vụ</th>
        </tr>
        <c:forEach var="nhanVien" items="${list}">
            <tr>
                <td><c:out value="${nhanVien.nvId}"/></td>
                <td><c:out value="${nhanVien.name}"/></td>
                <td><c:out value="${nhanVien.email}"/></td>
                <td><c:out value="${nhanVien.address}"/></td>
                <td><c:out value="${nhanVien.phoneNumber}"/></td>
                <td><c:out value="${nhanVien.salary}"/></td>
                <td><c:out value="${nhanVien.department}"/></td>
                <td>
                    <a href="/nhanvien?action=edit&id=${nhanVien.nvId}">Sửa</a>
                    <a href="/nhanvien?action=delete&id=${nhanVien.nvId}">Xoá</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
