<%-- 
    Document   : list
    Created on : Oct 3, 2023, 5:36:00 PM
    Author     : alexf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List,model.Category,model.Product"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            #wrapper{
                margin-left:10%;
                margin-right:10%;
                font-family: arial;
            }
            h3{
                text-align: left;
                color: blue;
            }
            ul{
                list-style: none;
            }
            li{
                width: 25%;
                text-align: center;
                float: left;
                margin: 25px;
                border: 2px solid chocolate;
                border-radius: 20px;
            }
            li img{
                width:90%;
            }
            li a{
                text-decoration: none;
            }
            li:hover{
                background: bisque;
            }
            p{
                margin: 5px;
                color: blue;
                font-size: 12px;
            }
            .old{
                text-decoration: line-through;
                color:red;
            }
            input[type=submit]{
                width:200px;
                height: 30px;
                background-color: #F90;
                border-radius: 10px;
            }
        </style>
        <script type="text/javascript">
            function change() {
                document.getElementById("f1").submit();
            }
        </script>
    </head>
    <body>
        <div id="wrapper">
            <form id="f1" action="list">
                Dòng điện thoại:
                <select name="key">
                    <option value="0">All</option>
                    <%
                        int cid = (Integer) request.getAttribute("cid");
                        if(request.getAttribute("category")!=null){
                            List<Category> cList = (List<Category>) request.getAttribute("category");
                            for(Category c : cList){%>
                    <option value="<%= (c.getId()) %>"><%= (c.getName()) %></option>  
                    <%}
                }
                    %>


                </select><br/>
                <input type="text" name="key2" placeholder="nhập tên, miêu tả, category"/>
                <br/>
                Từ giá:<input type="number" name="priceFrom"/>
                Đến giá:<input type="number" name="priceTo"/><br/>
                Từ ngày:<input type="date" name="dateFrom"/>
                Đến ngày:<input type="date" name="dateTo"/><br/>
                <input type="submit" value="SEARCH"/>
            </form>
            <h3>Các dòng điện thoại</h3>
            <ul>
                <%
                        if(request.getAttribute("products")!=null){
                            List<Product> pList = (List<Product>) request.getAttribute("products");
                            for(Product p : pList){%>
                <li>
                    <a href="#">
                        <img src="<%=(p.getImage())%>" alt="alt"/>
                        <p><%=(p.getName())%></p>
                        <p>Giá gốc:<span class="old"><%=(p.getPrice()*2)%></span></p>
                        <p>SALE:<%=(p.getPrice())%></p>
                    </a>
                </li>
                <%}}%>

            </ul>
        </div>
    </body>
</html>
