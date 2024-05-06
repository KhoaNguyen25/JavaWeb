<%-- 
    Document   : index
    Created on : 12 thg 4, 2024, 10:06:57
    Author     : HELLO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD Book Management</title>
        <style>
            /* Reset CSS */
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
                background-color: #f5f5f5;
            }

            /* Page Title Styling */
            h1 {
                color: #333;
                text-align: center;
                margin-top: 50px;
            }

            /* Subtitle Styling */
            h4 {
                color: #666;
                text-align: center;
                margin-top: 20px;
            }

            /* Link Styling */
            a {
                text-decoration: none;
                color: #007bff;
            }

            /* Link Hover Styling */
            a:hover {
                text-decoration: underline;
            }

            /* Button Styling */
            .button {
                display: inline-block;
                padding: 10px 20px;
                background-color: #007bff;
                color: #fff;
                border-radius: 5px;
                text-decoration: none;
            }

            /* Button Hover Styling */
            .button:hover {
                background-color: #0056b3;
            }
        </style>
    </head>

    <body>
        <h1>Chào mừng bạn đến với quản lý Sách</h1>
        <h4>Đi đến <a href="BookControllerServlet">Quản lý sách</a></h4>
    </body>
</html>
