/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Institucion.modelo;

import java.time.LocalDate;

/**
 *
 * @author OzKuro
 */
public class Alumno {
    private int idAlumno = -1;
    private String apellido;
    private String nombre;
    private LocalDate fechaNac;
    private boolean activo;
    
    public Alumno(String apellido, String nombre, LocalDate fechaNac, boolean Activo) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.activo = Activo;
    }

    public Alumno(int idAlumno, String apellido, String nombre, LocalDate fechaNac, boolean Activo) {
        this.idAlumno = idAlumno;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.activo = Activo;
    }

    public Alumno() {
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean Activo) {
        this.activo = Activo;
    }

    @Override
    public String toString() {
        return "Alumno " + idAlumno + ": " + apellido + " " + nombre;
    }
    
    
}
