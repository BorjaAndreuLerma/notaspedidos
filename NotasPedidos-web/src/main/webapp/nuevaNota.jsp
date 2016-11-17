<%-- 
    Document   : nuevaNota
    Created on : 14-nov-2016, 10:04:31
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nueva Nota</title>
    </head>
    <body>
        <h1>Añadir Nueva Nota</h1>
	
	<form action="NuevaNota" method="post">
		<input type="hidden" name="accion" value="agregar"/>
	
		<label for="numMesa">Numero de Mesa:</label>
		<input type="text" name="numMesa" style="display: block;" />
                <br>
		<label for="fecha">Fecha:</label>
		<input type="text" name="fecha" style="display: block;"/>
                <br>
		<label for="hora">Hora:</label>
		<input type="text" name="hora" style="display: block;"/>
                <br>
                <label for="cuenta">Cuetna:</label>
		<input type="text" name="cuenta" value="null" style="display: block;"/>
                <br>
		<input type="submit" value="Añadir" />
	</form>

	<a href="index.jsp">Volver</a>
    </body>
</html>
