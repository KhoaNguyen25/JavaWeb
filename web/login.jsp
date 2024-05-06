<%-- 
    Document   : login
    Created on : 12 thg 4, 2024, 10:07:19
    Author     : HELLO
--%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/login.css" rel="stylesheet" type="text/css"/>

        <title>Login</title>
    </head>
    <body>
        <h2>Login</h2>
        <form action="LoginServlet" method="post">
            <label for="username">Username:</label><br>
            <input type="text" id="username" name="username" required><br>
            <label for="password">Password:</label><br>
            <input type="password" id="password" name="password" required><br><br>
            <input type="submit" value="Login">
        </form>
        <p>Don't have an account? <a href="signup.jsp">Sign up</a></p>
    </body>
</html>