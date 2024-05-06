<%-- 
    Document   : add-book-form
    Created on : 12 thg 4, 2024, 10:06:48
    Author     : HELLO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> JSP Page</title>
        <link href="css/add.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Thêm Sách</h1>
        <form action="BookControllerServlet" method="GET">
            <input type="hidden" name="command" value="ADD" />

            <table border="0">
                <tbody>
                    <tr>
                        <td><label>Ten Sach: </label></td>
                        <td> <input type="text" name="tenSach" value="" /></td>
                    </tr>

                    <tr>
                        <td><label>Loai Sach: </label></td>
                        <td><input type="text" name="loaiSach" value="" /></td>
                    </tr>
                    <tr>
                        <td><label>Gia Sach: </label> </td>
                        <td><input type="text" name="giaSach" value="" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Save" class="save" /></td>
                    </tr>
                </tbody>
            </table>
        </form>

        <p>
            <a href="BookControllerServlet"> Back to the List</a>
        </p>
    </body>
</html>
