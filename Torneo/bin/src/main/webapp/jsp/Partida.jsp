<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="Datos.DataTorneo"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>JavaScript Snake game</title>    
	<style>
	    canvas {
	    background: black;    
	    display: block;
	    width: 600px;
	    }
	    h1 {
	        text-align: center;
	    }
	    button{
	    	align-self: left;
	    }
	</style>
	<script type="text/javascript" src="jsp/snake.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body onload="init();">
    <!-- Responsive navbar-->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container px-lg-5">
            <a class="navbar-brand" href="ServletHome">Torneo</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                    <li class="nav-item"><a class="nav-link" aria-current="page" href="ServletHome">Home</a></li>
                    <li class="nav-item"><a class="nav-link active" href="ServletPartida">Partida</a></li>
                    <li class="nav-item"><a class="nav-link" href="ServletLogin">Login</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <img alt="apple" src="jsp/apple.png" id="apple" hidden="true">
    <img alt="head" src="jsp/head.png" id="head" hidden="true">
    <img alt="dot" src="jsp/dot.png" id="dot" hidden="true">
    <h1>Snake</h1>
    <div class="container">
    	<div class="row justify-content-center">
    		<canvas id="myCanvas" width=300 height=300></canvas>
		</div>
		<form action="ServletPartida" method="post">
		  <div class="form-row my-3">
		  	<div class="col-2"></div>
			  <div class="col4">
			    <label for="puntos" class="col-sm-3 col-form-label">Puntos: </label>
			    <input type="text" readonly class="form-control-sm-plaintext text-center" id="puntos" name="puntos" value="2">
			  </div>
			  <div class="col4">
			    <label for="intentos" class="col-sm-3 col-form-label">Intentos: </label>
			    <input type="text" readonly class="form-control-sm-plaintext text-center" id="intentos" name="intentos" value="<%= 5 %>">
			  </div>
			  <button type="submit" class="btn btn-primary">Enviar</button>
			  <div class="col"></div>
		  </div>
		</form>
	</div>
</body>
</html>