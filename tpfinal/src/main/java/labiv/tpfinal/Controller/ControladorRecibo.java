/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labiv.tpfinal.Controller;

import java.util.List;
import labiv.tpfinal.DTO.ReciboDTO;
import labiv.tpfinal.Modelos.Empleado;
import labiv.tpfinal.Modelos.Recibo;
import labiv.tpfinal.Repositories.RepositorioReciboJpaData;
import labiv.tpfinal.Repositories.RepositorioEmpleadosJpaData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @Autowired
    private RepositorioEmpleadosJpaData repo2;

    //Extra - obtenemos todos los recibos
    @GetMapping("/recibos")
    public ResponseEntity<List<Recibo>> GetAllRecibos() {
        try {
            return ResponseEntity.ok(repo.findAll());
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    //Extra - obtener recibo por id
    @GetMapping("/recibos/{id}")
    public ResponseEntity<?> reciboID(@PathVariable int id
    ) {
        try {
            Recibo r = repo.findById(id).orElse(null);
            if (r != null) {
                return ResponseEntity.ok(r);
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Recibo no encontrado");

        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    //Punto 3 - agregar recibo
    @PostMapping("/recibos/agregar")
    public ResponseEntity<?> agregarRecibo(@RequestBody ReciboDTO reciboDTO) {
        Empleado aux = repo2.findById(reciboDTO.getLegajo()).orElse(null);
        if (aux == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El Empleado indicado no existe");
        }
        aux.setLegajo(reciboDTO.getLegajo());
        Recibo recibo = new Recibo(
                0,
                reciboDTO.getAnio(),
                reciboDTO.getMes(),
                reciboDTO.getSueldoBruto(),
                reciboDTO.getMontoAntiguedad(),
                reciboDTO.getJubilacion(),
                reciboDTO.getFondoComplejidad(),
                reciboDTO.getObraSocial(),
                aux);
        repo.save(recibo);
        return ResponseEntity.ok("Recibo registrado");
    }
}
