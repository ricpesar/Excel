/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Productos;

import com.BaseDatos.DbTools;
import com.mapping.Productos;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author f2 a55m-s1
 */
public class DAOProductos {

    public static void ingresarProducto(Productos producto) {
        DbTools db = DbTools.instanciar();
        db.getEntityManager().persist(producto);
        db.closeConexion();
    }

    public static void actualizarProducto(Productos producto) {
        DbTools db = DbTools.instanciar();
        Productos c = db.getEntityManager().getReference(Productos.class, producto.getClave());
        db.getEntityManager().merge(c);
        db.closeConexion();
    }

    public static void eliminarProducto(Productos producto) {
        DbTools db = DbTools.instanciar();
        Productos c = db.getEntityManager().getReference(Productos.class, producto.getClave());
        db.getEntityManager().remove(c);
        db.closeConexion();
    }

    public static Productos consultarProducto(int idProducto) {
        DbTools db = DbTools.instanciar();
        Productos c = db.getEntityManager().getReference(Productos.class, idProducto);
        return c;
    }

    public static List<Productos> buscarProducto(String buscar) {
        List<Productos> productos;
        DbTools db = DbTools.instanciar();
        if (buscar == null || buscar.equals("")) {
            productos = (List<Productos>) db.getEntityManager().createNamedQuery("Productos.findAll").getResultList();
        } else {
            productos = new ArrayList<>();
            String sql = "select ID from productos where clave like '%" + buscar + "%' OR descripcion like '%" + buscar + "%'";
            List ide = db.getEntityManager().createNativeQuery(sql).getResultList();
            for (Object ide1 : ide) {
                productos.add(db.getEntityManager().getReference(Productos.class, Integer.parseInt(ide1.toString())));
            }
        }
        return productos;
    }

    public static void borrarTodosProductos() {
        DbTools db = DbTools.instanciar();      
        String query = "DELETE FROM  productos";
        db.getEntityManager().createNativeQuery(query).executeUpdate();
    }
}
