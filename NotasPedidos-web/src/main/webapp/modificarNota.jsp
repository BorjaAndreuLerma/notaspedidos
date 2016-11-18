<%-- 
    Document   : modificarPersona
    Created on : 16-nov-2016, 9:41:44
    Author     : alumno
--%>

<%@page import="com.mycompany.NotasPedido"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Nota</title>
    </head>
    <body>
        <%

            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            NotasPedido nota = (NotasPedido) session.getAttribute("notaP");
            Date fechaNuev = nota.getFecha();
            String fechaFormateada = formatoFecha.format(fechaNuev);
        %>
        <h1>Modificar Nota</h1>

        <form action="NotaMod?accion=modificar&id=${nota.id}" method="post">

            <label for="numMesa">Numero Mesa: </label>
            <input type="text" name="numMesa" value="${nota.num_mesa}" style="display: block;" />

            <label for="fecha">Fecha: </label>
            <input type="text" name="fecha" value="<%=fechaFormateada%>" style="display: block;"/>

            <label for="hora">Hora: </label>
            <input type="text" name="hora" value="${nota.hora}" style="display: block;"/>

            <label for="cuenta">Cuenta: </label>
            <input type="text" name="cuenta" value="${nota.cuenta}" style="display: block;"/>

            <input type="submit" name="guardar" value="Modificar">
        </form>
        <a href="listaNotas.jsp">Atras</a>
    </body>
</html>
