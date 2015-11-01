/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import com.Productos.CargaProductosException;
import com.Productos.CargarProductos;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author f2 a55m-s1
 */
public class TestCargaProductos {
 
    public static void main(String[] args) {
        String path = "C:\\Users\\f2 a55m-s1\\Documents\\baseSqlLite\\";
        String nombre = "Productos y servicios.xls";
        int indiceHoja = 0;
        CargarProductos c = CargarProductos.instanciar(path, nombre, indiceHoja);
        try {
            c.cargarProductosToDb();
        } catch (CargaProductosException ex) {
            System.out.println(ex.toString());
            Logger.getLogger(TestCargaProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
