/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labiv.tpfinal.DTO;

/**
 *
 * @author Candelaria
 */
public class ReciboDTO {
    private int anio;
    private int mes;
    private double montoAntiguedad;
    private double sueldoBruto;
    private double jubilacion;
    private double obraSocial;
    private double fondoComplejidad;
    private int legajo;

    public double getSueldoBruto() {
        return sueldoBruto;
    }

    public void setSueldoBruto(double sueldoBruto) {
        this.sueldoBruto = sueldoBruto;
    }

    public int getAnio() {
        return anio;
    }

    public int getMes() {
        return mes;
    }

    public double getMontoAntiguedad() {
        return montoAntiguedad;
    }

    public double getJubilacion() {
        return jubilacion;
    }

    public double getObraSocial() {
        return obraSocial;
    }

    public double getFondoComplejidad() {
        return fondoComplejidad;
    }

    public int getLegajo() {
        return legajo;
    }

    public ReciboDTO() {
    }

    public ReciboDTO(int anio, int mes, double sueldoBruto,double montoAntiguedad, double jubilacion, double obraSocial, double fondoComplejidad, int legajo) {
        this.anio = anio;
        this.mes = mes;
        this.sueldoBruto= sueldoBruto;
        this.montoAntiguedad = montoAntiguedad;
        this.jubilacion = jubilacion;
        this.obraSocial = obraSocial;
        this.fondoComplejidad = fondoComplejidad;
        this.legajo = legajo;
    }
    
    
}
