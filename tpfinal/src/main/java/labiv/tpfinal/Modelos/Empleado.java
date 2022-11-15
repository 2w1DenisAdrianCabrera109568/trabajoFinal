 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labiv.tpfinal.Modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "empleados")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "legajo_empleado")
    private int legajo;
    private String nombre;
    private String apellido;
    @Column( name = "fecha_nacimiento")
    private Date fechaNacimiento;
    @Column( name = "fecha_ingreso")
    private int fechaIngreso;
    
    @Column( name = "sueldo_bruto")
    private double sueldoBruto;
    
    @ManyToOne(targetEntity = Area.class)
    @JoinColumn(name = "idarea")
    @JsonBackReference
    private Area area;
    
    @OneToMany(targetEntity=Recibo.class,mappedBy = "empleado")
    @JsonManagedReference    
    private List<Recibo> recibos;
    
     public void addRecibo(Recibo recibo){
        recibo.setEmpleado(this);
        recibos.add(recibo);
    }

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

    public int getFechaIngreso() {
        return fechaIngreso;
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

    public void setFechaIngreso(int fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }


    public void setSueldoBruto(double sueldoBruto) {
        this.sueldoBruto = sueldoBruto;
    }
    
     public List<Recibo> getRecibo() {
        return recibos;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
       

    public Empleado() {
    }  
    
     
    

    public Empleado(int legajo, String nombre, String apellido, Date fechaNacimiento, int fechaIngreso,double sueldoBruto, Area area) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngreso = fechaIngreso;
        this.sueldoBruto = sueldoBruto;
        this.area = area;
    }

   
    
    
    
    
    
}
