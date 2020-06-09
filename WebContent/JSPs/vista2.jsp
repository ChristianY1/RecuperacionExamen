<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Listar Libros</title>
</head>
<body>
	<form action="/Recuperacion2/Listar">
	<a href = "/Recuperacion2/JSPs/index.jsp">volver</a>
	<br/>
		<label>Buscar por nombre de autor</label>
		<br/>
		
		<input type = "text" name = "search">
		<button type = "submit">Buscar</button>
		<c:set var = "listas" scope = "request" value = "${listasT}"/>
		<table>
			<tr>	<td><strong>Nombre</strong></td>
					<td><strong>ISBN</strong></td>
					<td><strong>Número de páginas</strong></td>
					<td><strong>Número de Capítulo</strong></td>
					<td><strong>Título</strong></td>
					<td><strong>Autor</strong></td>
					<td><strong>Nacionalidad</strong></td>
			</tr>
			<c:forEach var = "p" items = "${listasT}">
				<td><label>${p.libro.nombre}</label></td>
				<td><label>${p.libro.ISBN}</label></td>
				<td><label>${p.libro.numPaginas}</label></td>
				<td><label>${p.numero}</label></td>
				<td><label>${p.titulo}</label></td>
				<td><label>${p.autor.nombre}</label></td>
				<td><label>${p.autor.nacionalidad}</label></td>>
				
			</c:forEach>
		</table>
	</form>
	
	<br/>
	<form action="/Recuperacion2/ListarTC">
	<label>Buscar por titulo del capitulo</label>
		<br/>
		
		<input type = "text" name = "search2">
		<button type = "submit">Buscar por titulo</button>
		
		
		<c:set var = "listas2" scope = "request" value = "${listasT2}"/>
		<table>
			<tr>	<td><strong>Nombre</strong></td>
					<td><strong>ISBN</strong></td>
					<td><strong>Número de páginas</strong></td>
					<td><strong>Número de Capítulo</strong></td>
					<td><strong>Título</strong></td>
					<td><strong>Autor</strong></td>
					<td><strong>Nacionalidad</strong></td>
			</tr>
			<c:forEach var = "p" items = "${listasT2}">
				<td><label>${p.libro.nombre}</label></td>
				<td><label>${p.libro.ISBN}</label></td>
				<td><label>${p.libro.numPaginas}</label></td>
				<td><label>${p.numero}</label></td>
				<td><label>${p.titulo}</label></td>
				<td><label>${p.autor.nombre}</label></td>
				<td><label>${p.autor.nacionalidad}</label></td>>
				
			</c:forEach>
		</table>
		
		
	
	</form>
</body>
</html>