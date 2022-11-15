/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labiv.tpfinal.Controller;

import java.util.List;
import labiv.tpfinal.Modelos.Empleado;
import labiv.tpfinal.Modelos.Recibo;
import labiv.tpfinal.Repositories.RepositorioReciboJpaData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author esteban
 */
@RestController
public class ControladorRecibo {

    @Autowired
    private RepositorioReciboJpaData repo;

    @GetMapping("/recibos")
    public ResponseEntity<List<Recibo>> GetAllRecibos() {
        try {
            return ResponseEntity.ok(repo.findAll());
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @PutMapping("recibos/add/")
    public ResponseEntity guardar(@RequestBody Recibo r) {

        try {
            repo.save(r);
            return ResponseEntity.ok(null);
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(ex.getCause());

        }
    }

    //este es para obtener todos los recibos por legajo
    @GetMapping("/recibos/legajo/{legajo}")
    public ResponseEntity<List<Recibo>> recibosLegajo(@PathVariable int legajo, @RequestBody Empleado emp) {
        try {
            return ResponseEntity.ok(repo.findReciboByEmpleado(emp));
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    //este es para obtener recibo por id
    @GetMapping("/recibos/{id}")
    public ResponseEntity<Recibo> reciboID(@PathVariable int id
    ) {
        try {
            Recibo r = repo.findById(id).orElse(null);
            if (r != null) {
                return ResponseEntity.ok(r);
            }
            return ResponseEntity.notFound().build();

        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }
}
