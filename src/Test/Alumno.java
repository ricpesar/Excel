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
public class Alumno {

    private int id;
    private String nombre, apellidos;

    public Alumno(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public void save() {
        Conector con = new Conector();
        con.connect();
        con.saveAlumno(this);
        con.close();
    }
    
    public void mostrarAlumnos(){
        Conector con = new Conector();
        con.connect();
        con.mostrarAlumnos();
        con.close();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

}
