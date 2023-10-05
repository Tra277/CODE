    <%-- 
    Document   : list
    Created on : Oct 2, 2023, 4:06:01 PM
    Author     : alexf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="model.Category,model.Product" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            #wrapper{
                font-family: arial;
                margin-left: 30px;
                width: 90%;
            }
            .clr{
                clear:both;
            }
            /*Menu*/
            #menu-tab{
                width:100%;
            }
            ul.menu{
                float:left;
                background: url(images/background_menu.jpg) repeat-x;
                display: block;
                list-style-type: none;
                font-weight: bold;
                height: 55px;
                padding:12px;
                width:100%;
            }
            ul.menu li{
                display: inline;
                font-size: 14px;
                padding-top: 15px;
                text-align: center;
                line-height: 30px;
                color:#e2d9bc;
            }
            ul.menu li a{
                margin: 10px;
                padding-left:0px;
                text-decoration:none;
                text-align:center;
                color:#E2D9BC;
                position:relative;
            }
            ul.menu li a img{
                float:left;
                margin-left:10px;
            }
            ul.menu li a:hover{
                color:#F90;
            }
            ul.menu li a:active{
                color:#FFO;
            }
            ul.menu li a:focus {
                color:#96F;
            }
            #content {
                margin-left: 20px;
            }
            table{
                border-collapse: collapse;
            }
            td{
                text-align: center;
            }
        </style>

    </head>
    <body>
        <div id="wrapper">
            <div id="menu-tab">
                <ul class="menu">
                    <li><a href="products?cid=<%=0%>">ALL</a></li>
                        <%
                            if(request.getAttribute("data")!=null){
                                List<Category> list = (List<Category>)request.getAttribute("data");
                                for(Category c : list){%>
                    <li><a href="products?cid=<%= (c.getId()) %>"><%= (c.getName()) %></a></li>
                        <%}
                    }
                        %>
                </ul>
                <div class="clr"></div>
                <div id="content">
                    <table border="1px">
                        <tr>
                        <th>ID</th>
                        <th>name</th>
                        <th>price</th>
                        <th>image</th>
                        <th>Category Name</th>
                        </tr>

                        <% 
                            if(request.getAttribute("products")!=null){
                                List<Product> plist = (List<Product>) request.getAttribute("products");
                                for(Product p : plist){%>
                        <tr>
                            <td><%= (p.getId()) %></td>
                            <td><%= (p.getName()) %></td>
                            <td><%= (p.getPrice()) %></td>
                            <td><img src="<%= (p.getImage()) %>" width="80px" height="80px"/></td>
                            <td><%= (p.getCategory() != null ? p.getCategory().getName() : "") %></td>


                        </tr>
                        <%}
                      }
                        %>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
