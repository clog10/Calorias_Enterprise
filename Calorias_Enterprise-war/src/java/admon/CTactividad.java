/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admon;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import log_neg.LNTipoA;
import modelo.Tipoactividad;

/**
 *
 * @author Carlos Loaeza
 */
@Named(value = "cTactividad")
@SessionScoped
public class CTactividad implements Serializable {

    @EJB
    private LNTipoA lNTipoA;

    private Tipoactividad tactividad;

    /**
     * Creates a new instance of CTactividad
     */
    public CTactividad() {
        tactividad = new Tipoactividad();
    }

    public Tipoactividad getTactividad() {
        return tactividad;
    }

    public void setTactividad(Tipoactividad tactividad) {
        this.tactividad = tactividad;
    }

    public void registrar() {
        lNTipoA.registrar(tactividad);
    }

    public List<Tipoactividad> actividades() {
        return lNTipoA.actividades();
    }
}
