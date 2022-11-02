/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arquitectura.ufps.dao;

import com.arquitectura.ufps.models.Persona;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Yeison
 */
public class PersonaDAOTest {

    private PersonaDAO persnaD;
    
    @Before
    public void setUp()throws Exception{
        persnaD= new PersonaDAO();
    }

    @Test
    public void testInsert() {
        Persona p = new Persona("Quentin", "Tarantino", "test@hotmail.com");
        persnaD.add(p);
        Persona personaTest= null;
        List<Persona> db_persona = persnaD.getPersonas();
        for (Persona persona : db_persona) {
            if (persona.getCorreo().equals("test@hotmail.com")) {
                personaTest = persona;
            }
        }
        assertTrue("Se espera que no sea nulo el resultado", personaTest!= null);
        assertEquals("Email incorrecto", "test@hotmail.com", personaTest.getCorreo());

    }
    
    @Test
    public void testUpdate() {
        Persona p = new Persona(12,"QuentinA", "TarantinoA", "test@hotmail.com");
        persnaD.update(p);
        Persona personaTest= null;
        List<Persona> db_persona = persnaD.getPersonas();
        for (Persona persona : db_persona) {
            if (persona.getCorreo().equals("test@hotmail.com")) {
                personaTest = persona;
            }
        }
        assertTrue("Se espera que no sea nulo el resultado", personaTest!= null);
        assertEquals("Nombre no fue actualizado", "QuentinA", personaTest.getNombre());
        assertEquals("Apellido no fue actualizado", "TarantinoA", personaTest.getApellido());

    }
    
    @Test
    public void testListAll() {
        List<Persona> db_persona = persnaD.getPersonas();
        assertTrue("Se espera que el resultado no sea nulo", db_persona!= null);
    }
    
    @Test
    public void testDelete() {
        persnaD.delete(1);
        Persona personaTest= null;
        List<Persona> db_persona = persnaD.getPersonas();
        for (Persona persona : db_persona) {
            if (persona.getId()==1) {
                personaTest = persona;
            }
        }
        assertTrue("Se espera que el resultado sea nulo", personaTest== null);
       

    }

}
