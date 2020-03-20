<%-- 
    Document   : login
    Created on : 18-Mar-2020, 19:29:29
    Author     : gills
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login!</h1>


        <form action="user" method="POST">
            <input type="text" required name="email" placeholder="Email"/>
            <input type="password" required name="pass" placeholder="Password"/>

            <input type="submit" value="Login" name="submit"/> <input type="reset"/>
            <input type="hidden" name="mode" value="login"/>
        </form></br>

        <h1>Or register!</h1>

        <form action="user" method="POST">
            <input type="text" required name="name" placeholder="Name"/>
            <input type="email" required name="email" placeholder="Email"/>
            <input type="password" required name="pass" placeholder="Password"/>

            <input type="submit" value="Register" name="submit"/> <input type="reset"/>
            <input type="hidden" name="mode" value="reg"/>
        </form></br>



    </body>
</html>
