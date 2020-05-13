<div class="container-fluid">

    <div class="row">

        <c:forEach items="${splashes}" var="s">

            <div class="col-md-6 text-center splash-pad">

                <div class="splash rounded">

                    <div class="splash-header container">

                        <div class="row">

                            <div class="col-md-2">
                                <div class="hover imgBox" onclick="location.href = 'user?mode=prof&ID=${s.getUserID()}'">
                                    <img src="${s.getProfile()}" class="border border-dark">
                                </div>
                            </div>

                            <div class="col-md-10 splash-word">
                                <h5 class="text-center">${s.getWord()}</h5>
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
