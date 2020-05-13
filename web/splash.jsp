<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="css.jsp" %> 

        <script type="text/javascript">
            $(document).ready(function () {
                $('#word').bind('input propertychange', function () {
                    $('.previewWord').text($(this).val());
                });

                $(function () {
                    $('#color-block').on('colorchange', function (e) {
                        var color = $(this).wheelColorPicker('value');
                        $('.previewCol').css('background-color', color);
                        $('#colour').val(color);
                    });
                });
            });

        </script>

        <style type="text/css">
            .color-block {
                max-width: 340px;
                width: 100%;
                box-sizing: border-box;
            }
            .color-preview-box {
                display: inline-block;
                width: .75em;
                height: .75em;
                vertical-align: middle;
                padding: 2px;
                background-clip: content-box;
                border: solid 1px #888;
            }
        </style>

    </head>
    <body>

        <%@include file="header.jsp" %> 
        </br>

        <div class="container-fluid">
            <form action="splash" method="POST">

                <div class="row">

                    <div class="col-md-2">
                        </br>
                    </div>

                    <div class="col-md-8">

                        <div class="row">

                            <div class="col-md-4">
                                <div class="splash-pad">
                                    <input id="color-block" type="text" value="#ff8800" data-wheelcolorpicker="" data-wcp-format="css" data-wcp-layout="block" data-wcp-sliders="wrgbp" data-wcp-cssclass="color-block" data-wcp-autoresize="false">
                                </div>
                            </div>

                            <div class="col-md-8">
                                <h4 class="text-center">Must be under 100 characters</h4>
                                <input type="text" required name="word" id="word" placeholder="What are you thinking?" class="form-control"/>
                            </div>

                        </div>

                        <%@include file="preview.jsp" %> 

                        <input type="hidden" name="colour" id="colour" placeholder="Colour" value="#ff8800"/>
                        <input type="submit" value="Create" name="submit" class="text-center prev-butt"/>
                        <input type="hidden" name="mode" value="create"/>
                    </div>

                    <div class="col-md-2">
                        </br>
                    </div>

                </div>

            </form>

        </div>

        </br>



    </body>
</html>
