/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labiv.tpfinal.Repositories;

import java.util.List;
import labiv.tpfinal.Modelos.Empleado;
import labiv.tpfinal.Modelos.Recibo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author esteban
 */
public interface RepositorioReciboJpaData extends JpaRepository<Recibo, Integer> {
    
    List<Recibo> findReciboByEmpleado(Empleado emp);
    
    
    
}
