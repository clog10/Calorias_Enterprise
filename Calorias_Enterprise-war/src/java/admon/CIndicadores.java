/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admon;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import javax.ejb.EJB;
import log_neg.LNIndicadores;
import log_neg.LNUsuario;
import modelo.Indicadoressalud;
import modelo.Tipoactividad;
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
    private Date fechaRegistro;
    private Usuario usuario;

    /**
     * Creates a new instance of CIndicadores
     */
    public CIndicadores() {
        indicadores = new Indicadoressalud();
        fechaRegistro = new Date();
        usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Indicadoressalud getIndicadores() {
        return indicadores;
    }

    public void setIndicadores(Indicadoressalud indicadores) {
        this.indicadores = indicadores;
    }

    public void registrar() {
        indicadores.setFecha(fechaRegistro);
        indicadores.setIdusuario(usuario);
        Usuario u = lNUsuario.buscaUsuario(usuario.getIdusuario());
        indicadores.setTipoact(u.getTipoact());
        lNIndicadores.registrar(indicadores);
    }

}
