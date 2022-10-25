<%-- 
    Document   : index
    Created on : 24/10/2022, 2:37:03 p. m.
    Author     : Sistem1
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Usuarios</h1>
        <a href="PersonaController?accion=listar">Listar personas</a>
        <div>
            <table>
                <tr>
                    <th>ID</th>
                    <th>NOMBRE</th>
                    <th>APELLIDO</th>
                    <th>CORREO</th>
                    <th>ACTIONS</th>
                </tr>
                <tr>
                    <c:forEach var="persona" items="${Personas}">
                        <td>${persona.id}</td>
                        <td>${persona.nombre}</td>
                        <td>${persona.apellido}</td>
                        <td>${persona.correo}</td>
                        <td>
                            <a>Editar</a>
                            <a>Eliminar</a>
                        </td>
                    </c:forEach>
                </tr>
            </table>
        </div>
    </body>
</html>
