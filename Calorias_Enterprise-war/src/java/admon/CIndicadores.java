/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admon;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import log_neg.LNIndicadores;
import log_neg.LNUsuario;
import modelo.Indicadoressalud;
import modelo.Usuario;

/**
 *
 * @author Carlos Loaeza
 */
@Named(value = "cIndicadores")
@SessionScoped
public class CIndicadores implements Serializable {
    
    @EJB
    private LNUsuario lNUsuario;
    
    @EJB
    private LNIndicadores lNIndicadores;
    
    private Indicadoressalud indicadores;

    /**
     * Creates a new instance of CIndicadores
     */
    public CIndicadores() {
        indicadores = new Indicadoressalud();
    }
    
    public Indicadoressalud getIndicadores() {
        return indicadores;
    }
    
    public void setIndicadores(Indicadoressalud indicadores) {
        this.indicadores = indicadores;
    }
    
    public void registrar() {
        indicadores.setIdusuario(usuario());
        indicadores.setTipoact(usuario().getTipoact());
        lNIndicadores.registrar(indicadores);
    }
    
    public Usuario usuario() {
        List<Usuario> us = new ArrayList<>();
        for (Usuario a : lNUsuario.usuarios()) {
            us.add(a);
        }
        
        int a = us.size();
        Usuario ultimo = us.get(a - 1);
        
        return ultimo;
    }
    
}
