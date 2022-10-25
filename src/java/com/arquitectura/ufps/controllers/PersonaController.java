/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.arquitectura.ufps.controllers;

//import com.arquitectura.ufps.dao.IPersonaDAO;
import com.arquitectura.ufps.dao.PersonaDAO;
import com.arquitectura.ufps.models.Persona;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sistem1
 */
@WebServlet(name = "PersonaController", urlPatterns={"/persona"})
public class PersonaController extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    
    PersonaDAO personadao;
    
    public PersonaController(){
    
    }

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion = request.getParameter("accion");
        List<Persona> personas = new ArrayList<>();
        
        switch (accion) {
            case "listar":
                personadao = new PersonaDAO();
                personas = personadao.getPersonas();
                request.setAttribute("Personas", personas);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
            default:
                throw new AssertionError();
        }
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
