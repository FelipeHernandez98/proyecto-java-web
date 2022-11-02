/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arquitectura.ufps.models;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Yeison
 */
public class PersonaTest {
    
    public static final String EXPECTED_FIRST_NAME="Ryan";
    public static final String EXPECTED_LAST_NAME="Gosling";
    public static final String EXPECTED_EMAIL="test@hotmail.com";
    private Persona persona;
    
    @Before
    public void setUp() throws Exception{
    persona= new Persona("Ryan","Gosling","test@hotmail.com");
    }
    
    @After
    public void tearDown()throws Exception{
        System.out.println("Test completed");
    }
            
    @Test
    public void testPersonaDetails(){
        Assert.assertEquals(EXPECTED_FIRST_NAME, persona.getNombre());
        Assert.assertEquals(EXPECTED_LAST_NAME, persona.getApellido());
        Assert.assertEquals(EXPECTED_EMAIL, persona.getCorreo());
    }
}
