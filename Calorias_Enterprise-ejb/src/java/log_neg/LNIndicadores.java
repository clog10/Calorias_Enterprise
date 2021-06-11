/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package log_neg;

import acceso_datos.IndicadoressaludFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.Indicadoressalud;

/**
 *
 * @author Carlos Loaeza
 */
@Stateless
@LocalBean
public class LNIndicadores {

    @EJB
    private IndicadoressaludFacade indicadoressaludFacade;

    public void registrar(Indicadoressalud indicadores){
        indicadoressaludFacade.create(indicadores);
    }
    
    public List<Indicadoressalud> indicadores(){
        return indicadoressaludFacade.findAll();
    }
    
    public void eliminar(Indicadoressalud indicadores){
        indicadoressaludFacade.remove(indicadores);
    }
}
