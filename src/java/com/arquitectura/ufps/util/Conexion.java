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
    private static String db = "gx6en8f2c9c35vh5";
    private static String url = "jdbc:mariadb://iu51mf0q32fkhfpl.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/" + db;
    private static String user = "c2arvty9qoltrw8n";
    private static String pass = "k4u4tblcbo1765cw";

    private Conexion() {
    }

    public static Connection conectar() {

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
            System.err.println("Se conecto con exito");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error: " + e);
        }

        return con;
    }

    public static void desconectar() {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
