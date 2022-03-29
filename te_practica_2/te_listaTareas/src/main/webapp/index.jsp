<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.Session"%>
<%
    if (session.getAttribute("listaTarea") == null){
        ArrayList<Session> lista = new ArrayList<Session>();
        session.setAttribute("listaTarea", lista);
    }
    
    ArrayList<Session> listaTar = (ArrayList<Session>)session.getAttribute("listaTarea");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
     <body style="background-color: lightcyan">
        
        <h1 style="text-align: center;font-size: 30px">Tareas pendientes</h1>      
       <br><br><br>
       <a href="registrarTarea.jsp" style="font-size: 18px">Nuevo</a>
       <br><br>
       <table align="center" border="1" cellspacing="1" style="text-align: center;font-size: 20px">
          
           <tr>
               <th>ID</th>
               <th>Tarea</th>
               <th>Completado</th>
               <th></th>
           </tr>
      
            <%
                if (listaTar != null){
                    for (Session s : listaTar){
            %>
            <tr>
                <td><%= s.getId() %></td>
                <td><%= s.getTarea() %></td>
               
                <td><input type="checkbox" id="estad" value="" defaultchecked="">
                </td>
                <td><a href="ServletListar?opcion=eliminar&id=<%= s.getId() %>">Eliminar</a></td>
            </tr>
            <%
                    }
                }  
            %>
        </table>
    </body>
</html>
