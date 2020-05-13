<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>

        <%@include file="css.jsp" %> 


    </head>
    <body>

        <%@include file="header.jsp" %> 
        </br>



        <div class="container-fluid">

            <div class="row">

                <div class="col-md-9">

                    <%@include file="splashes.jsp" %> 

                </div>

                <div class="col-md-3">

                    <div class="row">

                        <div class="col-md-4">

                            <div class="imgBox-Big">
                                <img src="${profUser.getProfile()}">
                            </div>

                        </div>

                        <div class="col-md-8">

                            <h3>${profUser.getName()}</h3>

                            <c:if test="${current==true}">
                                </br> 
                                <h5>${profUser.getEmail()}</h5>

                                <!-- <form action="user" method="POST">
                                     <input type="submit" value="Edit" name="submit" class="form-button loginInput"/>
                                     <input type="hidden" name="mode" value="edit"/>
                                 </form>-->

                                <form action="user" method="POST">
                                    <input type="submit" value="Logout" name="submit" class="form-button loginInput"/>
                                    <input type="hidden" name="mode" value="logout"/>
                                </form>

                                </br>
                            </c:if>
                        </div>

                    </div>

                </div>

            </div>

        </div>
    </body>
</html>
