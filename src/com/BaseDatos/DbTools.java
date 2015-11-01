/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BaseDatos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DbTools {

    EntityManagerFactory emf;
    EntityManager em;
    EntityTransaction tx;

    private DbTools(){
        emf = Persistence.createEntityManagerFactory("ExcelPU");
        em = emf.createEntityManager();
        tx = em.getTransaction();
        tx.begin();         
    }
    
    public static DbTools instanciar(){
        return  new DbTools();
    }
    
    
    public void commit(){        
        tx.commit();
    }

    public void close() {              
        em.close();
    }
    
    public void closeConexion() {
        em.flush();
        tx.commit();
        em.close();
    }
    
    public EntityManager getEntityManager(){
        return em;
    }    
    
}