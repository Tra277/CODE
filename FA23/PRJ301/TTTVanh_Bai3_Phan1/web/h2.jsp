<%-- 
    Document   : h2
    Created on : Oct 16, 2023, 2:17:32 PM
    Author     : alexf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Ví dụ cho java bean </h1>
        <form>
            nhap so 1: <input type="number" name="n1" value="${param.n1}"><br/>
            nhap so 2: <input type="number" name="n2" value="${param.n2}"><br/>
            nhap so 3: <input type="number" name="n3" value="${param.n3}"><br/>
            <input type="submit" value="Tính toán"/>
        </form>
        <h2>Tong:${(param.n1+param.n2+param.n3)}</h2>
        <h4>
            Du lieu lay tu server tra ve:
            <br/>
            Hello ${requestScope.name}
        </h4>
        <h2>
            Hello ${requestScope.s}
        </h2>
    </body>
</html>
