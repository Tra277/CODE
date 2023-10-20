<%-- 
    Document   : nhap
    Created on : Oct 17, 2023, 2:01:34 PM
    Author     : alexf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>nhap danh sach</h1>
        <form action="nhap">
            <label><p>Nhap ho va ten</p><input type="text" name="name"/></label>
            <input type="submit" value="Nhap du lieu"/>
            <h2>Danh sach nhap vao</h2>
            <h3>
                <c:set var="i" value="0"/>
                <c:forEach items="${sessionScope.names}" var="c">
                    <c:set var="i" value="${i+1}"/>
                    ${i}. ${c}<br/>
                </c:forEach>
            </h3>
        </form>
    </body>
</html>
