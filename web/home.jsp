<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <%@include file="css.jsp" %> 
    </head>

    <body>

        <nav class="navbar navbar-expand-lg navbar-light splash-nav">
            <a class="navbar-brand" href="#">Splash!</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a class="nav-link" href="/home">Home<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="splash.jsp">Create!</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="login.jsp">Login!</a>
                    </li>
                </ul>
            </div>
        </nav>

        </br></br>


        <div class="container-fluid">

            <div class="row">

                <c:forEach items="${splashes}" var="s">

                    <div class="col-md-6 text-center splash-pad">

                        <div class="splash rounded">

                            <div class="splash-header container">

                                <div class="row">

                                    <div class="col-md-5 text-left">
                                        <img src="images/meCircle.png" class="splash-img border border-dark left">
                                    </div>

                                    <div class="col-md-7 text-left splash-word">
                                        <h5>${s.getWord()}</h5>
                                    </div>

                                </div>


                            </div>

                            </br>

                            <div class="splash-col-top">
                                <div class="splash-col rounded" style="background-color: ${s.getColour()}"></div>
                            </div>

                        </div>

                    </div>

                </c:forEach>

            </div>


        </div>




    </body>
</html>
