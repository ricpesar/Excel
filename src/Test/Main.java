/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

/**
 *
 * @author f2 a55m-s1
 */
public class Main {

    public static void main(String[] args) {
        Conector con = new Conector();
        con.connect();
        con.close();

        Alumno alumno = new Alumno("Ricardo", "Lopez Vicente");
        alumno.save();
        alumno.mostrarAlumnos();
    }
}
