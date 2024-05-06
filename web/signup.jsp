<%-- 
    Document   : signup
    Created on : 12 thg 4, 2024, 10:07:30
    Author     : HELLO
--%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/login.css" rel="stylesheet" type="text/css"/>

        <title>Sign Up</title>
    </head>
    <body>
        <h2>Sign Up</h2>
        <form action="RegistrationServlet" method="post">
            <label for="username">Username:</label><br>
            <input type="text" id="username" name="username" required><br>
            <label for="password">Password:</label><br>
            <input type="password" id="password" name="password" required><br>
            <label for="email">Email:</label><br>
            <input type="email" id="email" name="email" required><br><br>
            <input type="submit" value="Sign Up">
        </form>
        <p>Already have an account? <a href="login.jsp">Login</a></p>
    </body>
</html>
