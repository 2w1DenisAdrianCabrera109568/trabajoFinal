/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labiv.tpfinal.DTO;

/**
 *
 * @author devil
 */
public class ReporteEmpRecXLegDTO {
    private int legajo;
    private String nombre;
    private String apellido;
    private int anio;
    private int mes;
    private double sueldoNeto;

    public ReporteEmpRecXLegDTO(int legajo, String nombre, String apellido, int anio, int mes, double sueldoNeto) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.anio = anio;
        this.mes = mes;
        this.sueldoNeto = sueldoNeto;
    }

    public ReporteEmpRecXLegDTO() {
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public double getSueldoNeto() {
        return sueldoNeto;
    }

    public void setSueldoNeto(double sueldoNeto) {
        this.sueldoNeto = sueldoNeto;
    }
}
