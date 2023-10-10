<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/10/2023
  Time: 11:22 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Sửa Thông Tin Nhân Viên</title>
</head>
<body>
<center>
    <h1>Sửa Thông Tin Nhân Viên</h1>
    <h2>
        <a href="nhanvien?action=nhanvien">Danh Sách Nhân Viên</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Sửa Thông Tin Nhân Viên
                </h2>
            </caption>
            <c:if test="${nhanVien != null}">
                <input type="hidden" name="id" value="<c:out value='${nhanVien.nvId}' />"/>
            </c:if>
            <tr>
                <th>Tên:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${nhanVien.name}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Email:</th>
                <td>
                    <input type="text" name="email" size="45"
                           value="<c:out value='${nhanVien.email}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Địa Chỉ:</th>
                <td>
                    <input type="text" name="address"
                           value="<c:out value='${nhanVien.address}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Số Điện Thoại:</th>
                <td>
                    <input type="text" name="phoneNumber" size="15"
                           value="<c:out value='${nhanVien.phoneNumber}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Lương:</th>
                <td>
                    <input type="text" name="salary" size="15"
                           value="<c:out value='${nhanVien.salary}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Phòng Ban:</th>
                <td>
                    <input type="text" name="department"
                           value="<c:out value='${nhanVien.department}' />"
                    />
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