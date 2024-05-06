<%-- 
    Document   : update-book-form
    Created on : 12 thg 4, 2024, 10:07:46
    Author     : HELLO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/add.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
       
        <div id="container">
            <h1>Chỉnh sửa</h1>
            <hr>
            <form action="BookControllerServlet" method="GET">
                <input type="hidden" name="command" value="UPDATE">
                <input type="hidden" name="bookId" value="${THE_BOOK.id}">
                <table border="0">
                    <tbody>
                        <tr>
                            <td>Ten Sach:</td>
                            <td><input type="text" name="tenSach" value="${THE_BOOK.tenSach}"></td>
                        </tr>
                        <tr>
                            <td>Loai Sach:</td>
                            <td><input type="text" name="loaiSach" value="${THE_BOOK.loaiSach}"></td>
                        </tr>
                        <tr>
                            <td>Gia Sach </td>
                            <td><input type="text" name="giaSach" value="${THE_BOOK.giaSach}"></td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="UPDATE" class="save" /></td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </div>
    </body>
</html>
