/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.arquitectura.ufps.dao;

import com.arquitectura.ufps.models.Persona;
import java.util.List;

/**
 *
 * @author Sistem1
 */
public interface IPersonaDAO {
    
    public List<Persona> getPersonas();
    public Persona getId(int id);
    public int add(Persona p);
    public int update(Persona p);
    public int delete(int id);
    
    
}
