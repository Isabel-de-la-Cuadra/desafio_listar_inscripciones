<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.desafiolatam.entidades.CursoDTO"%>
<%@ page import="com.desafiolatam.entidades.FormaDePagoDTO"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulario Inscripción</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<!-- Estilo propio -->
<style>

body{
height: 500px;
background-image: linear-gradient(to right, rgba(166,166,166,0), rgba(85,85,85,1));
}

nav{
background: rgba(166,166,166,0);
}

</style>

</head>
<% 
	List<CursoDTO> cursos;
	List<FormaDePagoDTO> formasPago;
	// capturar información que viene desde el request
	cursos     = (List)request.getAttribute("cursos");
	formasPago = (List)request.getAttribute("formasPago");
%>
<body>

	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="index">Mantenedor De Cursos</a>
			</div>
			<ul class="nav navbar-nav">
				<li><a href="index">Inicio</a></li>
				<li><a href="preInscripcion">Inscribir Cursos</a></li>
				<li><a href="preListarInscripciones">Pre Listar
						Inscripciones</a></li>
			</ul>
		</div>
	</nav>


	<div class="container">
		<form action="posInscripcion">
			<div class="form-group">
				<label for="nombre">Nombre:</label> <input type="text"
					class="form-control" id="nombre" name="nombre">
			</div>
			<div class="form-group">
				<label for="telefono">Teléfono Móvil:</label> <input type="text"
					class="form-control" id="telefono" name="celular">
			</div>
			<div class="form-group">
				<label for="cursos">Cursos:</label> <select name="idCurso">
					<% 
				  	for(CursoDTO dto: cursos){
				  %>
					<option value="<%=dto.getIdCurso()%>">
						<%=dto.getDescricion()%>
					</option>
					<% 
				  	}
				  %>
				</select><br>
			</div>
			<div class="form-group">
				<label for="formasPago">Formas de Pago:</label> <select
					name="idFormaPago">
					<% 
				  	for(FormaDePagoDTO dto : formasPago ){
				  %>
					<option value="<%=dto.getIdFormaDePago()%>">
						<%=dto.getDescripcion()%>
					</option>
					<% 
				  	}
				  %>
				</select><br>
			</div>

			<button type="submit" class="btn btn-default">Enviar</button>
		</form>
	</div>
</body>
</html>