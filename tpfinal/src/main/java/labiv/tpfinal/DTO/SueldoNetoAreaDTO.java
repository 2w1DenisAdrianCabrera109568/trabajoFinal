/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labiv.tpfinal.DTO;

/**
 *
 * @author devil
 */
public class SueldoNetoAreaDTO {
    private String area;
    private int periodo;
    private int mes;
    private double sueldoNeto;

    public SueldoNetoAreaDTO() {
    }

    public SueldoNetoAreaDTO(String area, int periodo, int mes, double sueldoNeto) {
        this.area = area;
        this.periodo = periodo;
        this.mes = mes;
        this.sueldoNeto = sueldoNeto;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
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
