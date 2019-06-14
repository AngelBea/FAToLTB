<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="shared/includes.jsp" %>
    <meta charset="ISO-8859-1">
    <title>Filmaffinity To Letterbox Converter</title>
</head>
<body>
<div class="container-fluid"></div>
<div id="content" class="container d-flex align-content-center flex-wrap">
    <div class="row col-md-12 d-flex flex-wrap justify-content-md-center ">
        <img style="height:500px" src="img/FAtoLetterBox.png" id="indexLogo"/>
    </div>
    <div class="form-group col-md-12 row justify-content-md-center">
        <div class="col-md-3 col-lg-3 input-lg toggle-passive">
            <input class="form-control" type="text" name="usercode" id="usercode"
                   placeholder="Your FilmAffinity usercode"/>

        </div>
        <div class="col-md-3 col-lg-3 input-lg toggle">
            <input class="form-control" type="email" name="email" id="email" placeholder="Email to send"/>
        </div>
        <div class="col-md-4 col-lg-4">
            <input class="form-control btn btn-primary" id="convert" type="button" value="Convert"/>
        </div>
        <div class="row justify-content-md-center">
            <div class="radio col-md-6 col-lg-6 d-flex no-wrap">
                <label for="checkbox1">
                    <input type="radio" name="check" id="checkbox1" class="form-control radiobutton"/>
                    Send me an email with the results
                </label>
            </div>
            <div class="radio col-md-6 col-lg-6 d-flex no-wrap">
                <label for="checkbox2">
                    <input type="radio" name="check" id="checkbox2" class="form-control radiobutton"/>
                    I'll wait until finish
                </label>
            </div>
        </div>
    </div>
</div>
<div class="container-fluid"></div>
<script src="js/buttons.js"></script>
</body>
</html>