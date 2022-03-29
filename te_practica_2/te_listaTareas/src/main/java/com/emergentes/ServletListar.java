
package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ServletListar", urlPatterns = {"/ServletListar"})
public class ServletListar extends HttpServlet {

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
             String opcion = request.getParameter("opcion");

  
        if (opcion.equals("eliminar")){
            int pos = -1;
            int buscado = -1;
            int id = Integer.parseInt(request.getParameter("id"));
            // Eliminar la tarea
            HttpSession ses = request.getSession();
            ArrayList<Session> lista = (ArrayList<Session>)ses.getAttribute("listaTarea");
            
            for(Session s : lista){
                pos++;
                if (s.getId() == id){
                    buscado = pos;
                }                
            }
            lista.remove(buscado);
            response.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          int id = Integer.parseInt(request.getParameter("id"));
        String tarea = request.getParameter("tarea");
     
        Session ses = new Session();
        
        ses.setId(id);
        ses.setTarea(tarea);
      
        
        HttpSession sesion = request.getSession();

        ArrayList<Session> lista = (ArrayList<Session>) sesion.getAttribute("listaTarea");

        lista.add(ses);

        response.sendRedirect("index.jsp");

    }
    

}
