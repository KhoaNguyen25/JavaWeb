<%-- 
    Document   : list-book
    Created on : 12 thg 4, 2024, 10:07:11
    Author     : HELLO
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="wrapper">
            <div id="header">
                <h1>Danh Sach</h1>
            </div>
        </div>
        <div id="container">

            <hr>
            <input type="submit" value="Add Book"
                   onclick="window.location.href = 'add-book-form.jsp';return false;"
                   class="add-book-button"
                   />
            <div id="header">

                <form action="BookControllerServlet" method="GET">
                    <input type="text" name="search" placeholder="Search...">
                    <input type="hidden" name="command" value="SEARCH">
                    <input type="submit" value="Search">
                </form>
            </div>
            <div id="content">
                <table border="1">
                    <thead>
                        <tr>
                            <th>Ten Sach</th>
                            <th>Loai Sach</th>
                            <th>Gia Sach</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="tempBook" items="${booklist}">
                            <!-- set up a link for each book -->
                            <c:url var="tempLink" value="BookControllerServlet">
                                <c:param name="command" value="LOAD"></c:param>
                                <c:param name="bookId" value="${tempBook.id}"></c:param>
                            </c:url>
                            <!-- set up a link to delete a book -->
                            <c:url var="deleteLink" value="BookControllerServlet">
                                <c:param name="command" value="DELETE"></c:param>
                                <c:param name="bookId" value="${tempBook.id}"></c:param>
                            </c:url>
                            <tr>
                                <td>${tempBook.tenSach}</td>
                                <td>${tempBook.loaiSach}</td>
                                <td>${tempBook.giaSach}</td>
                                <td>
                                    <a href="${tempLink}">Update</a>
                                    <a href="${deleteLink}" onclick="if (!(confirm('Sure?')))
                                    return false;">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
