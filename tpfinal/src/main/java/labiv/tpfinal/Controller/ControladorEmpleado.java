/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labiv.tpfinal.Controller;

import java.util.List;
import java.util.Optional;
import labiv.tpfinal.DTO.EmpleadoAntiguedadDTO;
import labiv.tpfinal.DTO.EmpleadoDTO;
import labiv.tpfinal.DTO.ReporteEmpRecXLegDTO;
import labiv.tpfinal.DTO.SueldoNetoAreaDTO;
import labiv.tpfinal.Modelos.Area;
import labiv.tpfinal.Modelos.Empleado;
import labiv.tpfinal.Repositories.RepositorioEmpleadosJDBC;
import labiv.tpfinal.Repositories.RepositorioEmpleadosJpaData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Candelaria
 */
@RestController

public class ControladorEmpleado {
    
  
    @Autowired
    private RepositorioEmpleadosJDBC repo1;
    @Autowired
    private RepositorioEmpleadosJpaData repo2;
    
    //Extra - obtener todos los empleados con sus recibos
    @GetMapping("/empleados/todos")
    public Iterable<Empleado> consultarEmpleados() {

        return repo2.findAll();       
    
    }
  
    //Punto 4. Dado un legajo obtener todos los recibos de sueldo
    @GetMapping("empleados/porleg/{leg}")
    public List<ReporteEmpRecXLegDTO> obtenerPorLeg(@PathVariable int leg){
    return repo1.obtenerPorLeg(leg);
    }
    
    
    //Punto 5. Dado un anio y mes obtener reporte
    @GetMapping(value= "empleados/resumenareas/{anio}/{mes}")
    public List<SueldoNetoAreaDTO> resumenAreas(@PathVariable int anio, @PathVariable int mes){
    return repo1.resumenAreas(anio, mes);
    }
    
   //Punto 1 - listado de empleados con antiguedad
    @GetMapping("empleados/endpoint")
    public List<EmpleadoAntiguedadDTO> resumenEmpleados(){
        return repo1.resumenEmpleados();
    }
    
    //Punto 2 -Agregamos un empleado
    @PostMapping("empleados/agregar")
    public ResponseEntity<?> agregarEmpleado(@RequestBody EmpleadoDTO empleadoDTO){
       Area aux = new Area();
       aux.setId(empleadoDTO.getArea());
       Empleado empleado = new Empleado(
               0,
               empleadoDTO.getNombre(),
               empleadoDTO.getApellido(),
               empleadoDTO.getFechaNacimiento(),
               empleadoDTO.getFechaIngreso(),
               empleadoDTO.getSueldoBruto(),
               aux);
       repo2.save(empleado);
       return ResponseEntity.ok("Empleado registrado");
       
    }
    
    

    
   

}
