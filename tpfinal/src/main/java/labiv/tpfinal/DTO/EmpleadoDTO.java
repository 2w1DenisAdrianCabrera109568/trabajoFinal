/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labiv.tpfinal.DTO;

import java.util.Date;

/**
 *
 * @author Candelaria
 */
public class EmpleadoDTO {
    
    private int legajo;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private String area;
    private int antiguedad;
    private double sueldoBruto;

    public int getLegajo() {
        return legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getArea() {
        return area;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public double getSueldoBruto() {
        return sueldoBruto;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public void setSueldoBruto(double sueldoBruto) {
        this.sueldoBruto = sueldoBruto;
    }

    public EmpleadoDTO() {
    }

    public EmpleadoDTO(int legajo, String nombre, String apellido, Date fechaNacimiento, String area, int antiguedad, double sueldoBruto) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.area = area;
        this.antiguedad = antiguedad;
        this.sueldoBruto = sueldoBruto;
    }
    
    
    
    
}
