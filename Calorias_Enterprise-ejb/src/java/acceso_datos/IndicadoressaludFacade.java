/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acceso_datos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Indicadoressalud;

/**
 *
 * @author Carlos Loaeza
 */
@Stateless
public class IndicadoressaludFacade extends AbstractFacade<Indicadoressalud> {

    @PersistenceContext(unitName = "Calorias_Enterprise-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IndicadoressaludFacade() {
        super(Indicadoressalud.class);
    }
    
}
