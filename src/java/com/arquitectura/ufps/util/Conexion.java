/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arquitectura.ufps.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Sistem1
 */
public class Conexion {
    
    private static Connection con = null;
    private static String db = "crud_java";
    private static String URL = "jdbc:mysql://localhost:3306/" + db;
    private static String USER = "root";
    private static String PASS = "";
    
    public static Connection Conectar(){
        
        try{
            Class.forName("org.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASS);
            System.err.println("Se conecto con exito");
        }catch(Exception e){
            System.err.println("Error: " + e );
        }
        
        return con;
    }
    
    public static void Desconectar(){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
