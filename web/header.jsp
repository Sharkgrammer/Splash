<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="data.user"%>
<%
    user u = (user) session.getAttribute("user");
    boolean user = (u != null);
%>

<nav class="navbar navbar-expand-lg navbar-light splash-nav">
    <a class="navbar-brand" href="#"><img class="splash-brand" src="images/splash.png"/></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="home">Home<span class="sr-only">(current)</span></a>
            </li>

            <% if (user == true) { %>
            
            <li class="nav-item">
                <a class="nav-link" href="user?mode=prof&current=y"><%= u.getName() %></a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="splash.jsp">New splash</a>
            </li>

            <% } else { %>

            <li class="nav-item">
                <a class="nav-link" href="login.jsp">Login!</a>
            </li>

            <% } %>

        </ul>
    </div>
</nav>
