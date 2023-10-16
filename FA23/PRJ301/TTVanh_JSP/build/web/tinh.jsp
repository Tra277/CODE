<%-- 
    Document   : tinh
    Created on : Oct 8, 2023, 4:42:29 PM
    Author     : alexf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            *{
                margin: auto;
            }
            .label,input,select,option{
                font-size: 30px;
                color:blue;
            }
            .nen{
                background: bisque;
                height:auto;
                width: 40%;
            }

        </style>
    </head>
    <body>
        <div class="nen">
            <h1>A simple calculator</h1>
            <hr/>
            <form>
                <table>
                    <tr>
                        <td class="label">Enter number 1:</td>
                        <td><input type="text" name="num1"></td>
                    </tr>
                    <tr>
                        <td class="label">Enter number 2:</td>
                        <td><input type="text" name="num2"></td>
                    </tr>
                    <tr>
                        <td class="label">Select operation:</td>
                        <td>
                            <select name="op">
                                <option value="+">+</option>
                                <option value="-">-</option>
                                <option value="*">*</option>
                                <option value="/">/</option>

                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Tinh! "></td>
                    </tr>
                </table>
            </form>
            <hr/>
            <h2>
                <jsp:useBean id="c" class="model.Math"/>
                <jsp:setProperty name="c" property="*"/>
                <jsp:getProperty name="c" property="result"/>
            </h2>
        </div>

    </body>
</html>
