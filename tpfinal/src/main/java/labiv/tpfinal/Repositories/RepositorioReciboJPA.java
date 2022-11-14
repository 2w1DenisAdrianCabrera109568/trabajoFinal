/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labiv.tpfinal.Repositories;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import labiv.tpfinal.Modelos.Recibo;
import labiv.tpfinal.exceptions.BackendExceptions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author esteban
 */
@Repository
public class RepositorioReciboJPA {

    @PersistenceContext
    private EntityManager em;

    public List<Recibo> GetAllRecibo() throws BackendExceptions {

        try {
            return em.createQuery("select r from Recibo r", Recibo.class).getResultList();

        } catch (Exception e) {
            throw new BackendExceptions(e.getMessage());
        }

    }

    public Recibo GetReciboId(int id) throws BackendExceptions {

        try {
            return em.find(Recibo.class, id);

        } catch (Exception e) {
            throw new BackendExceptions(e.getMessage());
        }

    }

}
