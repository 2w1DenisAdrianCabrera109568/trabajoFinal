/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labiv.tpfinal.Controller;

import java.util.List;
import labiv.tpfinal.DTO.EmpleadoAntiguedadDTO;
import labiv.tpfinal.DTO.EmpleadoDTO;
import labiv.tpfinal.DTO.ReporteEmpRecXLegDTO;
import labiv.tpfinal.DTO.SueldoNetoAreaDTO;
import labiv.tpfinal.Modelos.Area;
import labiv.tpfinal.Modelos.Empleado;
import labiv.tpfinal.Repositories.RepositorioAreasJpaData;
import labiv.tpfinal.Repositories.RepositorioEmpleadosJDBC;
import labiv.tpfinal.Repositories.RepositorioEmpleadosJpaData;
import labiv.tpfinal.exceptions.BackendExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    @Autowired
    private RepositorioAreasJpaData repo3;

    //Extra - obtener todos los empleados con sus recibos
    @GetMapping("/empleados/todos")
    public ResponseEntity<Iterable<Empleado>> consultarEmpleados() {

        Iterable<Empleado> aux = repo2.findAll();
        if (aux != null) {
            return ResponseEntity.ok(aux);
        } else {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    //Punto 4. Dado un legajo obtener todos los recibos de sueldo
    @GetMapping("empleados/porleg/{leg}")
    public ResponseEntity<List<ReporteEmpRecXLegDTO>> obtenerPorLeg(@PathVariable int leg) {
        try {
            return ResponseEntity.ok(repo1.obtenerPorLeg(leg));
        } catch (BackendExceptions ex) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    //Punto 5. Dado un anio y mes obtener reporte
   @GetMapping(value = "empleados/resumenareas/{anio}/{mes}")
    public ResponseEntity<?> resumenAreas(@PathVariable int anio, @PathVariable int mes) {
        if (anio < 2015 || anio > 2022) {
            return ResponseEntity.badRequest().body("Ano no valido");
        }
        if (mes < 1 || mes > 12) {
            return ResponseEntity.badRequest().body("Mes invalido");

        }

        try {
            if (repo1.resumenAreas(anio, mes).isEmpty()) {
                return ResponseEntity.accepted().body("su consulta es valida pero no existen datos para esa fecha");
            }
            return ResponseEntity.ok(repo1.resumenAreas(anio, mes));

        } catch (BackendExceptions ex) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    //Punto 1 - listado de empleados con antiguedad
    @GetMapping("empleados/endpoint")

    public ResponseEntity<List<EmpleadoAntiguedadDTO>> resumenEmpleados() {
        try {
            return ResponseEntity.ok(repo1.resumenEmpleados());
        } catch (BackendExceptions ex) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    //Punto 2 -Agregamos un empleado
    @PostMapping("empleados/agregar")
    public ResponseEntity<?> agregarEmpleado(@RequestBody EmpleadoDTO empleadoDTO) {
        Area aux = repo3.findById(empleadoDTO.getArea()).orElse(null);
        if (aux == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El Area indicada es invalida");
        }
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
