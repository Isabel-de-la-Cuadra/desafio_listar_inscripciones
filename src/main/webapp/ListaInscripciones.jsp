<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.desafiolatam.entidades.CursoDTO"%>
<%@ page import="com.desafiolatam.entidades.FormaDePagoDTO"%>
<%@ page import="com.desafiolatam.entidades.InscripcionDTO"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado de inscripciones</title>
<meta charset="utf-8">
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
	List<InscripcionDTO> inscripciones;
	// capturar información que viene desde el request
	inscripciones = (List)request.getAttribute("inscripciones");
%>
<body>

	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="index">Mantenedor de Cursos</a>
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
		<h2>Listado de inscripciones</h2>
	
		<table class="table">
			<thead>
				<tr>
					<th>Id Inscripción</th>
					<th>Nombre</th>
					<th>Teléfono</th>
					<th>Id Curso</th>
					<th>Id Forma de Pago</th>
				</tr>
			</thead>
			<tbody>
				<%
			for(InscripcionDTO dto : inscripciones){
		%>
				<tr>
					<td><%= dto.getIdInsc()%></td>
					<td><%= dto.getNombre()%></td>
					<td><%= dto.getCelular()%></td>
					<td><%= dto.getIdCurso()%></td>
					<td><%= dto.getIdFormaDePago()%></td>
				</tr>
				<% } %>
			</tbody>
		</table>
	</div>
</body>
</html>