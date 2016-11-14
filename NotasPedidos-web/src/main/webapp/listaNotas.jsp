<%-- 
    Document   : listaNotas
    Created on : 14-nov-2016, 9:45:32
    Author     : alumno
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Date"%>
<%@page import="com.mycompany.NotasPedido"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>NotasPediods</title>
    </head>
    <body>
        <h1>Listado de Notas</h1>
        
	<a href="agregarPersona.jsp">Añadir Nota</a>
	<br/>
	<br/>

	<table border="1">
		<tr>
                    <th>Num. Mesa</th>
                    <th>Fecha</th>
                    <th>Hora</th>
                    <th>Cuenta</th>
                    <th></th>
                    <th></th>
 
		</tr>

                <%
                ArrayList<NotasPedido> listaNotas = (ArrayList) session.getAttribute("notas");
                for(NotasPedido nota : listaNotas){                    
                    
                    int id = nota.getId();
                    int numMesa = nota.getNum_mesa();
                    Date fecha = nota.getFecha();
                    String hora = nota.getHora();
                    double cuenta = nota.getCuenta();
                %>                
		<tr>
                    <td><%=numMesa%></td>
                    <td><%=fecha%></td>
                    <td><%=hora%></td>
                    <td><%=cuenta%></td>
                    <td><a href="ModificarPersona?accion=editar&id=<%=id%>">Modificar</a></td>
                    <td><a href="EliminarPersona?id=<%=id%>">Eliminar</a></td>
                </tr>
                <% } %>
	</table>
	<br>
        <a href="productosynotas.jsp">Atras</a>
    </body>
</html>
