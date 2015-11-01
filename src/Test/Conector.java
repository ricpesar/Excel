/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author f2 a55m-s1
 */
public class Conector {

    String url = "C:\\Users\\f2 a55m-s1\\Documents\\baseSqlLite\\test";
    Connection connect;

    public void connect() {
        try {
            connect = DriverManager.getConnection("jdbc:sqlite:" + url);
            if (connect != null) {
                System.out.println("Conectado");
            }
        } catch (SQLException ex) {
            System.err.println("No se ha podido conectar a la base de datos\n" + ex.getMessage());
        }
    }

    public void close() {
        try {
            connect.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void saveAlumno(Alumno alumno) {
        try {
            PreparedStatement st = connect.prepareStatement("insert into alumnos (nombre, apellidos) values (?,?)");
            st.setString(1, alumno.getNombre());
            st.setString(2, alumno.getApellidos());
            st.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public void mostrarAlumnos() {
        ResultSet result = null;
        try {
            PreparedStatement st = connect.prepareStatement("select * from alumnos");
            result = st.executeQuery();
            while (result.next()) {
                System.out.print("ID: ");
                System.out.println(result.getInt("id"));

                System.out.print("Nombre: ");
                System.out.println(result.getString("nombre"));

                System.out.print("Apellidos: ");
                System.out.println(result.getString("apellidos"));

                System.out.println("=======================");
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
