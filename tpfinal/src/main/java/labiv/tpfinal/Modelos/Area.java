/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labiv.tpfinal.Modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Candelaria
 */
@Entity
@Table(name = "areas")
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "idarea")
    private int id;
    @Column(name ="nombre_area")
    private String nombre;
    
   @OneToMany(targetEntity=Recibo.class,mappedBy = "empleado")
   @JsonManagedReference   
   private List<Empleado> empleados;
   
   public void addEmpleado(Empleado empleado){
        empleado.setArea(this);
        empleados.add(empleado);
   }
   
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Area(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Area() {
    }

   
    
    

    
    
   
   
}
