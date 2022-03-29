<%-- 
    Document   : registrarTarea
    Created on : 28 mar. 2022, 20:55:38
    Author     : Karla Angulo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de Registro</title>
    </head>
    <body style="background-color: lightcyan">
        <h1 style="text-align: center">REGISTRAR NUEVA TAREA</h1>
        <form action="ServletListar" method="post">
            <table align="center" style="font-size: 20px">
                <tr>
                    <td>Id</td>
                    <td><input type="text" name="id" value="" size="2" style="font-size: 18px"></td>
                </tr>
                <tr>
                    <td>Tarea</td>
                    <td><input type="text" name="tarea" value="" placeholder="Ingrese una tarea" style="font-size: 18px"></td>
                </tr>
                <tr>
                   <td><br><br><input type="submit" value="Registrar" style="font-size: 18px"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
