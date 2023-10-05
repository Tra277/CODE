<%-- 
    Document   : MyJSP
    Created on : Oct 2, 2023, 10:29:47 AM
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
        <h1>Hello World!</h1>
        <%
            //code java/jsp here
            int a= 100;
            out.print("value a="+ a);
            
        %>
        <h2 style="color: red;font-family: sans-serif"> a = <%= a %></h2>
        <% for(int i = 10;i<=200;i+=20){%>
            <hr width="<%=i%>">
        <% } %>
        
        <!-- thẻ khai báo dành cho biến toàn cục -->
        <%! int MAX=2000, Min = 1; %>
        <%! 
            String display(String st){
                return "welcum "+ st;
        }
        %>
        <%!
            String name = "Trần Thanh Tùng";
            
        %>
        <%= display(name)%>
    </body>
</html>
