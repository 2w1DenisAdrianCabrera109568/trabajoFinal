/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labiv.tpfinal.Modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "recibos")

public class Recibo {
    @Id
    @GeneratedValue
    @Column( name = "numero_recibo")
    private int nroRecibo;
    private int anio;
    private int mes;
    @Column(name = "sueldo_bruto")
    private double sueldoBruto;
    @Column( name = "monto_antiguedad")
    private double montoAntiguedad;
    private double jubilacion;
    @Column( name = "fondo_alta_complejidad")
    private double fondoComplejidad;
    @Column( name = "obra_social")
    private double obraSocial;
    
    
    
    @ManyToOne(targetEntity = Empleado.class)
    @JoinColumn(name = "legajo_empleado")
    @JsonBackReference
    private Empleado empleado;

    public int getNroRecibo() {
        return nroRecibo;
    }

    public int getAnio() {
        return anio;
    }

    public int getMes() {
        return mes;
    }

    public double getSueldoBruto() {
        return sueldoBruto;
    }

    public void setSueldoBruto(double sueldoBruto) {
        this.sueldoBruto = sueldoBruto;
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

    public void setNroRecibo(int nroRecibo) {
        this.nroRecibo = nroRecibo;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setMontoAntiguedad(double montoAntiguedad) {
        this.montoAntiguedad = montoAntiguedad;
    }

    public void setJubilacion(double jubilacion) {
        this.jubilacion = jubilacion;
    }

    public void setObraSocial(double obraSocial) {
        this.obraSocial = obraSocial;
    }

    public void setFondoComplejidad(double fondoComplejidad) {
        this.fondoComplejidad = fondoComplejidad;
    }

    public Recibo(int nroRecibo, int anio, int mes, double sueldoBruto, double montoAntiguedad, double jubilacion, double fondoComplejidad, double obraSocial) {
        this.nroRecibo = nroRecibo;
        this.anio = anio;
        this.mes = mes;
        this.sueldoBruto = sueldoBruto;
        this.montoAntiguedad = montoAntiguedad;
        this.jubilacion = jubilacion;
        this.fondoComplejidad = fondoComplejidad;
        this.obraSocial = obraSocial;

    }

  

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    
    
    
            
}
