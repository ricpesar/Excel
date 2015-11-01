/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Productos;

import com.Excel.Excel;
import com.mapping.Productos;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author f2 a55m-s1
 */
public class CargarProductos {

    private final String path;
    private final String nombre;
    private final int indiceHoja;
    private final String[] cabeceraValida = {"Clave", "Descripción", "Línea", "Tipo de Costeo", "CAMPLIB1", "CAMPLIB2", "CAMPLIB3", "Existencias", "Último costo"};

    private CargarProductos(String path, String nombre, int indiceHoja) {
        this.path = path;
        this.nombre = nombre;
        this.indiceHoja = indiceHoja;
    }

    public static CargarProductos instanciar(String path, String nombre, int indiceHoja) {
        return new CargarProductos(path, nombre, indiceHoja);
    }

    public boolean cargarProductosToDb() throws CargaProductosException {
        Map<Integer, List> datos = getDatos();
        if (!validarCabecera(datos.get(0))) {
            throw new CargaProductosException("algo");
        }

        limpiarProductos();

        Set<Integer> keySet = datos.keySet();
        Iterator<Integer> iterator = keySet.iterator();
        while (iterator.hasNext()) {
            int key = iterator.next();
            DAOProductos.ingresarProducto(createProducto(datos.get(key)));            
        }
        return true;
    }

    private Productos createProducto(List producto) {
        Productos p = new Productos();
        p.setClave((String) producto.get(0));
        p.setDescripcion((String) producto.get(1));
        p.setLinea((String) producto.get(2));
        p.setTipoCosto((String) producto.get(3));
        p.setDescripcion1((String) producto.get(4));
        p.setDescripcion2((String) producto.get(5));
        p.setDescripcion3((String) producto.get(6));
        p.setExistencia((String) producto.get(7));
        p.setUltimoCosto((String) producto.get(8));
        return p;
    }

    private void limpiarProductos() {
        DAOProductos.borrarTodosProductos();
    }

    public Map<Integer, List> getDatos() {
        Excel excel = Excel.instanciar(nombre, path);
        return excel.getInformacion(indiceHoja);
    }

    private boolean validarCabecera(List cabecera) {
        int i = 0;
        for (String campo : cabeceraValida) {
            if (!(campo.toLowerCase()).equals(String.valueOf(cabecera.get(i)).trim().toLowerCase())) {
                System.out.println(campo + "<>" + cabecera.get(i));
                return false;
            }
            i++;
        }
        return true;
    }
}
