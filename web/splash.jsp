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
        <h1>Create a splash!</h1>


        <form action="splash" method="POST">
            <input type="text" required name="colour" placeholder="Colour"/>
            <input type="text" required name="word" placeholder="Word"/>


            <input type="submit" value="Create" name="submit"/> <input type="reset"/>
            <input type="hidden" name="mode" value="create"/>
        </form></br>

    </body>
</html>
