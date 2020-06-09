<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Libros</title>
</head>
<body>

	<form action="/Recuperacion2/AgregarLibroController" >
        <label>Registre su libro</label> <br>
        <br>
        <label>Libro</label> <br>
        <label>Nombre:</label>
        <input type="text" name = "nombre"> <br>
        <label>ISBN:</label>
        <input type="text" name="ISBN"> <br>
        <label>Número de páginas:</label>
        <input type="text" name = "num"> <br>
        <br>
        <label>Capitulo</label> <br>
        
        <label>Codigo de autor</label>
        <input type="text" name="cautor"> <br>

       
        <label>Número:</label> 
        <input type="text" name = "numcap"> <br>
        <label>Título:</label>
        <input type="text" name="titulo"> <br>

        <button type="submit">Registrar</button>
    </form>
    <a href = "/Recuperacion2/JSPs/vista2.jsp">ver lista</a>
    <br/>
    <label>1.Romero Tullet</label><br/>
    <label>2.Rick Jhonson</label><br/>
    <label>3.Gabriel Garcia Marquez</label>
</body>
</html>