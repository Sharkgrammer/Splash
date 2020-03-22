<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>
    </head>
    <body>
        <h1>${profUser.getName()}</h1>
        <h1>${profUser.getEmail()}</h1>

        <c:if test="${current==true}">
            </br> 
            <button>Edit</button>
            </br>
        </c:if>
    </body>
</html>
