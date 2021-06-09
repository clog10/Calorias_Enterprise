/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package log_neg;

import acceso_datos.TipoactividadFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.Tipoactividad;

/**
 *
 * @author Carlos Loaeza
 */
@Stateless
@LocalBean
public class LNTipoA {

    @EJB
    private TipoactividadFacade tipoactividadFacade;

    public void registrar(Tipoactividad ta){
        tipoactividadFacade.create(ta);
    }
    
    public List<Tipoactividad> actividades(){
        List<Tipoactividad> ac = tipoactividadFacade.findAll();
        return ac;
    }
    
    public Tipoactividad buscaActividad(int id){
        return tipoactividadFacade.find(id);
    }
    
}
