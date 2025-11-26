/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.tcswpractica04;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author melis
 */
@Entity
@Table(name = "departamentos")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "departamentos_clave_seq")
    @SequenceGenerator(name = "departamentos_clave_seq",
            sequenceName = "departamentos_clave_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column
    private Long clave;

    @Column
    private String nombre;
    
    //relacion de un departamento a muchos empleados 
    @OneToMany(mappedBy = "departamento", 
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Empleados> listempleados;

    public Long getClave() {
        return clave;
    }

    public void setClave(Long clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Empleados> getlistEmpleados() {
        return listempleados;
    }

    public void setEmpleados(List<Empleados> empleados) {
        this.listempleados = empleados;
    }

    @Override
    public String toString() {
        return nombre != null ? nombre : ("Departamento " + (clave != null ? clave : ""));
    }
}


