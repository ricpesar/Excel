/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mapping;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author f2 a55m-s1
 */
@Entity
@Table(name = "productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productos.findAll", query = "SELECT p FROM Productos p"),
    @NamedQuery(name = "Productos.findByClave", query = "SELECT p FROM Productos p WHERE p.clave = :clave"),
    @NamedQuery(name = "Productos.findByDescripcion", query = "SELECT p FROM Productos p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Productos.findByLinea", query = "SELECT p FROM Productos p WHERE p.linea = :linea"),
    @NamedQuery(name = "Productos.findByTipoCosto", query = "SELECT p FROM Productos p WHERE p.tipoCosto = :tipoCosto"),
    @NamedQuery(name = "Productos.findByDescripcion1", query = "SELECT p FROM Productos p WHERE p.descripcion1 = :descripcion1"),
    @NamedQuery(name = "Productos.findByDescripcion2", query = "SELECT p FROM Productos p WHERE p.descripcion2 = :descripcion2"),
    @NamedQuery(name = "Productos.findByDescripcion3", query = "SELECT p FROM Productos p WHERE p.descripcion3 = :descripcion3"),
    @NamedQuery(name = "Productos.findByExistencia", query = "SELECT p FROM Productos p WHERE p.existencia = :existencia"),
    @NamedQuery(name = "Productos.findByUltimoCosto", query = "SELECT p FROM Productos p WHERE p.ultimoCosto = :ultimoCosto"),
    @NamedQuery(name = "Productos.findByCampo1", query = "SELECT p FROM Productos p WHERE p.campo1 = :campo1"),
    @NamedQuery(name = "Productos.findByCampo2", query = "SELECT p FROM Productos p WHERE p.campo2 = :campo2"),
    @NamedQuery(name = "Productos.findByCampo3", query = "SELECT p FROM Productos p WHERE p.campo3 = :campo3"),
    @NamedQuery(name = "Productos.findByCampo4", query = "SELECT p FROM Productos p WHERE p.campo4 = :campo4"),
    @NamedQuery(name = "Productos.findByCampo5", query = "SELECT p FROM Productos p WHERE p.campo5 = :campo5")})
public class Productos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "clave")
    private String clave;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "linea")
    private String linea;
    @Column(name = "tipo_costo")
    private String tipoCosto;
    @Column(name = "descripcion1")
    private String descripcion1;
    @Column(name = "descripcion2")
    private String descripcion2;
    @Column(name = "descripcion3")
    private String descripcion3;
    @Column(name = "existencia")
    private String existencia;
    @Column(name = "ultimo_costo")
    private String ultimoCosto;
    @Column(name = "campo1")
    private String campo1;
    @Column(name = "campo2")
    private String campo2;
    @Column(name = "campo3")
    private String campo3;
    @Column(name = "campo4")
    private String campo4;
    @Column(name = "campo5")
    private String campo5;

    public Productos() {
    }

    public Productos(String clave) {
        this.clave = clave;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getTipoCosto() {
        return tipoCosto;
    }

    public void setTipoCosto(String tipoCosto) {
        this.tipoCosto = tipoCosto;
    }

    public String getDescripcion1() {
        return descripcion1;
    }

    public void setDescripcion1(String descripcion1) {
        this.descripcion1 = descripcion1;
    }

    public String getDescripcion2() {
        return descripcion2;
    }

    public void setDescripcion2(String descripcion2) {
        this.descripcion2 = descripcion2;
    }

    public String getDescripcion3() {
        return descripcion3;
    }

    public void setDescripcion3(String descripcion3) {
        this.descripcion3 = descripcion3;
    }

    public String getExistencia() {
        return existencia;
    }

    public void setExistencia(String existencia) {
        this.existencia = existencia;
    }

    public String getUltimoCosto() {
        return ultimoCosto;
    }

    public void setUltimoCosto(String ultimoCosto) {
        this.ultimoCosto = ultimoCosto;
    }

    public String getCampo1() {
        return campo1;
    }

    public void setCampo1(String campo1) {
        this.campo1 = campo1;
    }

    public String getCampo2() {
        return campo2;
    }

    public void setCampo2(String campo2) {
        this.campo2 = campo2;
    }

    public String getCampo3() {
        return campo3;
    }

    public void setCampo3(String campo3) {
        this.campo3 = campo3;
    }

    public String getCampo4() {
        return campo4;
    }

    public void setCampo4(String campo4) {
        this.campo4 = campo4;
    }

    public String getCampo5() {
        return campo5;
    }

    public void setCampo5(String campo5) {
        this.campo5 = campo5;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clave != null ? clave.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productos)) {
            return false;
        }
        Productos other = (Productos) object;
        if ((this.clave == null && other.clave != null) || (this.clave != null && !this.clave.equals(other.clave))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Productos{" + "clave=" + clave + ", descripcion=" + descripcion + ", linea=" + linea + ", tipoCosto=" + tipoCosto + ", descripcion1=" + descripcion1 + ", descripcion2=" + descripcion2 + ", descripcion3=" + descripcion3 + ", existencia=" + existencia + ", ultimoCosto=" + ultimoCosto + ", campo1=" + campo1 + ", campo2=" + campo2 + ", campo3=" + campo3 + ", campo4=" + campo4 + ", campo5=" + campo5 + '}';
    }

}
