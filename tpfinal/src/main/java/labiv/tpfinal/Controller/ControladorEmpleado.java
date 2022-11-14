/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labiv.tpfinal.Controller;

import java.util.List;
import labiv.tpfinal.Modelos.Empleado;
import labiv.tpfinal.Repositories.RepositorioEmpleadosJpaData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Candelaria
 */
@RestController
public class ControladorEmpleado {
    
    @Autowired
    private RepositorioEmpleadosJpaData repo;
    
    @GetMapping("/empleados")
    public Iterable<Empleado> consultarEmpleados() {

        return repo.findAll();
    }

}
