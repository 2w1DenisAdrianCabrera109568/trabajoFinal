/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labiv.tpfinal.Controller;

import java.util.List;
import java.util.Optional;
import labiv.tpfinal.DTO.ReporteEmpRecXLegDTO;
import labiv.tpfinal.DTO.SueldoNetoAreaDTO;
import labiv.tpfinal.Modelos.Empleado;
import labiv.tpfinal.Repositories.RepositorioEmpleadosJpa;
import labiv.tpfinal.Repositories.RepositorioEmpleadosJpaData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Candelaria
 */
@RestController
public class ControladorEmpleado {
    
  
    @Autowired
    private RepositorioEmpleadosJpa repo1;
    private RepositorioEmpleadosJpaData repo2;
    
    @GetMapping("/empleados")
    public Iterable<Empleado> consultarEmpleados() {

        return repo2.findAll();       
    
    }
    
    @GetMapping("/empleados/porleg/{leg}")
    public List<ReporteEmpRecXLegDTO> obtenerPorLeg(@PathVariable int leg){
    return repo1.obtenerPorLeg(leg);
    }
    
    @GetMapping(value= "/resumenareas/{anio}/{mes}")
    public List<SueldoNetoAreaDTO> resumenAreas(@PathVariable int anio, @PathVariable int mes){
    return repo1.resumenAreas(anio, mes);
    }
    
   

}
