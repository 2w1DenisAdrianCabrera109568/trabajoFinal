/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labiv.tpfinal.Repositories;

import labiv.tpfinal.Modelos.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioEmpleadosJpaData extends JpaRepository<Empleado, Integer> {

}
