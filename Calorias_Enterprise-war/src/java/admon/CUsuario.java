/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admon;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import log_neg.LNTipoA;
import log_neg.LNUsuario;
import modelo.Tipoactividad;
import modelo.Usuario;

/**
 *
 * @author Carlos Loaeza
 */
@Named(value = "cUsuario")
@SessionScoped
public class CUsuario implements Serializable {

    @EJB
    private LNTipoA lNTipoA;

    @EJB
    private LNUsuario lNUsuario;

    private Usuario usuario;
    private Tipoactividad tipo;
    private Date fechaRegistro;

    /**
     * Creates a new instance of CUsuario
     */
    public CUsuario() {
        usuario = new Usuario();
        tipo = new Tipoactividad();
        fechaRegistro = new Date();
    }

    public Tipoactividad getTipo() {
        return tipo;
    }

    public void setTipo(Tipoactividad tipo) {
        this.tipo = tipo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void registrar() {
        usuario.setFecharegistro(fechaRegistro);
        usuario.setTipoact(lNTipoA.buscaActividad(tipo.getIdtact()));
        lNUsuario.registrar(usuario);
    }

    public List<Usuario> usuarios() {
        return lNUsuario.usuarios();
    }

}
