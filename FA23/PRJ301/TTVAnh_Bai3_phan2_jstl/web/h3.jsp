<%-- 
    Document   : h3
    Created on : Oct 16, 2023, 4:26:13 PM
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
        <h1>vi du cho jstl</h1>
        <c:set var="s" value="${requestScope.s}"/>
        <h2>Hello ${s.name}</h2>
        <h3>${s.gender?"male":"famale"}</h3>
        <c:if test="${s.mark >=5}">
            <h3>Pass</h3>
        </c:if>
        <c:if test="${s.mark <=5}">
            <h3>Fail</h3>
        </c:if>
            <h1>Danh sach sinh vien</h1>
            
                <table border="1px">
                    <caption>Sinh vien</caption>
                    <tr>
                        <th>ID</th>
                        <th>name</th>
                        <th>gender</th>
                        <th>mark</th>
                    </tr>
                    <c:forEach items="${requestScope.list}" var="i">
                    <tr>
                        <td>${i.id}</td>
                        <td>${i.name}</td>
                        <td>${i.gender}</td>
                        <td>${i.mark}</td>
                    </tr>
                    </c:forEach>
                </table>
            
             
    </body>
</html>
