/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.arquitectura.ufps.controllers;

//import com.arquitectura.ufps.dao.IPersonaDAO;
import com.arquitectura.ufps.dao.PersonaDAO;
import com.arquitectura.ufps.models.Persona;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sistem1
 */
@WebServlet(name = "PersonaController", urlPatterns = {"/persona"})
public class PersonaController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private PersonaDAO personadao;
    private Persona persona;

    public PersonaController() {
        this.personadao = new PersonaDAO();
        this.persona= new Persona();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        
        switch (accion) {
            case "vistaPersona":
                vistaPersona(request,response);
                break;
            case "vistaEditar":
                vistaEditar(request,response);
                break;
            case "listar":
                listPersona(request, response);
                break;
            case "insert":
                insertPersona(request, response);
                break;
            case "update":
                updatePersona(request, response);
                break;
            case "delete":
                deletePersona(request,response);
                break;
            default:
                throw new AssertionError();
        }

    }
    
  

    public void insertPersona(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String correo = request.getParameter("correo");
        System.err.println(nombre + apellido + correo);
        persona = new Persona(0,nombre, apellido, correo);
        personadao.add(persona);
        request.getRequestDispatcher("PersonaController?accion=listar").forward(request, response);

    }

    public void updatePersona(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String correo = request.getParameter("correo");
        persona = new Persona(nombre, apellido, correo);
        personadao.update(persona);
        request.getRequestDispatcher("PersonaController?accion=listar").forward(request, response);

    }

    public void deletePersona(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id= Integer.valueOf(request.getParameter("id"));
        personadao.delete(id);
        request.getRequestDispatcher("PersonaController?accion=listar").forward(request, response);

    }

    public void listPersona(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         List<Persona> personas = personadao.getPersonas();      
        request.setAttribute("Personas", personas);
        request.getRequestDispatcher("index.jsp").forward(request, response);

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


    private void vistaPersona(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("crearusuario.jsp").forward(request, response);
    }

    private void vistaEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         request.getRequestDispatcher("editarusuario.jsp").forward(request, response);
    }

}
