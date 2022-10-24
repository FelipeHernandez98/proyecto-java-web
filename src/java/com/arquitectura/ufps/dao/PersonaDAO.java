/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arquitectura.ufps.dao;

import java.util.List;
import com.arquitectura.ufps.models.Persona;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.arquitectura.ufps.util.Conexion;
import java.util.ArrayList;

public class PersonaDAO implements IPersonaDAO {
    
    public List<Persona> getPersonas(){
        
        List<Persona> personas = new ArrayList<>();
        String sql = "select * from persona";
        
        try{
            PreparedStatement ps = Conexion.Conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Persona p = new Persona();
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setApellido(rs.getString("apellido"));
                p.setCorreo(rs.getString("correo"));
                personas.add(p);
            }
            
        }catch(Exception e){
            System.out.println("Error: " + e);
        }
        return personas;
    }

    @Override
    public Persona getId(int id) {
        
        String sql = "select * from persona where id=?";
        Persona p = new Persona();
        
        try{
             PreparedStatement ps = Conexion.Conectar().prepareStatement(sql);
             ps.setInt(1, id);
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
                 
                 p.setId(rs.getInt("id"));
                 p.setNombre(rs.getString("nombre"));
                 p.setApellido(rs.getString("apellido"));
                 p.setCorreo(rs.getString("correo"));
             }

         }catch(Exception e){
             System.out.println("Error: " + e);
         }
        
        return p;
        
    }

    @Override
    public int add(Persona p) {
        
        int resultado = 0;
        String sql = "insert into persona(id, nombre, apellido, correo)values(?,?,?,?)";
        
        try {
            PreparedStatement ps = Conexion.Conectar().prepareStatement(sql);
            resultado = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        
        return resultado;
        
    }

    @Override
    public int update(Persona p) {
        int resultado = 0;
        String sql = "update persona nombre = ?, apellido = ?, correo =? where id=?";
        
        try {
            PreparedStatement ps = Conexion.Conectar().prepareStatement(sql);
            resultado = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        
        return resultado;
    }

    @Override
    public int delete(int id) {
        int resultado = 0;
        String sql = "delete from persona where id = "+id;
        try {
            PreparedStatement ps = Conexion.Conectar().prepareStatement(sql);
            resultado = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return resultado;
    }
        
    }

