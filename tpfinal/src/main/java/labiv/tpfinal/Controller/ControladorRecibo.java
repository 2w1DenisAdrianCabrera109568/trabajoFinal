/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labiv.tpfinal.Controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import labiv.tpfinal.Modelos.Recibo;
import labiv.tpfinal.Repositories.RepositorioReciboJPA;
import labiv.tpfinal.exceptions.BackendExceptions;
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
    private RepositorioReciboJPA repo;

    @GetMapping("/recibos/all")
    public ResponseEntity GetAllRecibos() {
        try {
            return ResponseEntity.ok(repo.GetAllRecibo());
        } catch (BackendExceptions ex) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @PutMapping("recibos/add/{legajo}")
    public ResponseEntity guardar(@PathVariable int legajo, @RequestBody Recibo r) {
        System.out.println(legajo);
        System.out.println(r);
        return ResponseEntity.ok(null);
    }

//    //este es para obtener todos los recibos por legajo
//    @GetMapping("/recibos/{legajo}")
//    public ResponseEntity recibosLegajo(@PathVariable int legajo) {
//        try {
//
//        } catch (Exception e) {
//        }
//
//        return ResponseEntity.ok(null);
//    }
    //este es para obtener recibo por id
    @GetMapping("/recibos/{id}")
    public ResponseEntity<Recibo> reciboID(@PathVariable int id) {
        try {
            Recibo r = repo.GetReciboId(id);
            if (r == null) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok(r);

        } catch (BackendExceptions e) {
            return ResponseEntity.internalServerError().body(null);
        }

    }

}
