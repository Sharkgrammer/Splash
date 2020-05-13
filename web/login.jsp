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

        <%@include file="css.jsp" %> 

        <script>

            function showImg(input) {
                if (input.files && input.files[0]) {
                    var reader = new FileReader();

                    reader.onload = function (e) {
                        $('#imageView').attr('src', e.target.result);
                        $('#imageView').removeAttr("style");
                    };

                    reader.readAsDataURL(input.files[0]);
                }
            }

        </script>

    </head>



    <body>

        <%@include file="header.jsp" %> 
        </br>

        <div class="container-fluid">

            <div class="row">

                <div class="col-md-3 text-center">
                    </br>
                </div>

                <div class="col-md-6 text-center splash-pad">

                    <div class="splash rounded">

                        <div class="splash-header container">
                            <h2>Login to Splash!</h2>
                        </div>

                        </br>

                        <form action="user" method="POST">

                            <input type="text" required name="email" placeholder="Email" class="form-control loginInput"/>
                            <input type="password" required name="pass" placeholder="Password" class="form-control loginInput"/>
                            <input type="submit" value="Login" name="submit" class="form-button loginInput"/>
                            <input type="hidden" name="mode" value="login"/>

                        </form>

                    </div>

                </div>

                <div class="col-md-3 text-center">
                    </br>
                </div>

            </div>

        </div>


        </br>

        <div class="container-fluid">

            <div class="row">

                <div class="col-md-3 text-center">
                    </br>
                </div>

                <div class="col-md-6 text-center splash-pad">

                    <div class="splash rounded">

                        <div class="splash-header container">
                            <h2>Register for Splash!</h2>
                        </div>

                        </br>

                        <form action="user" method="POST" enctype="multipart/form-data">

                            <input type="text" required name="name" placeholder="Name" class="form-control loginInput"/>
                            <input type="email" required name="email" placeholder="Email" class="form-control loginInput"/>
                            <input type="password" required name="pass" placeholder="Password" class="form-control loginInput"/>


                            <div class="row">
                                <div class="col-sm-8">
                                     <label for="file">Profile image:</label>
                                    <input type='file' required name="file" id="file" onchange="showImg(this);" class="form-control loginInput"/>
                                </div>

                                <div class="col-sm-4">
                                    <div class="imgBox-Big">
                                        <img id="imageView" class="border border-dark" style="display:none">
                                    </div>
                                </div>
                            </div>


                            <input type="submit" value="Register" name="submit" class="form-button loginInput"/>
                            <input type="hidden" name="mode" value="reg"/>
                        </form>

                    </div>

                </div>

                <div class="col-md-3 text-center">
                    </br>
                </div>

            </div>

        </div>

    </body>
</html>
