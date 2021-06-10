/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admon;

import javax.faces.context.FacesContext;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
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

    private String user;
    private String pass;
    
    private String rebote = "Usuario y/o Password incorrectos";

    /**
     * Creates a new instance of CUsuario
     */
    public CUsuario() {
        usuario = new Usuario();
        tipo = new Tipoactividad();
        fechaRegistro = new Date();
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
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

    public String ingresar() {
        for (Usuario u : lNUsuario.usuarios()) {
            if (u.getUsuario().equals(user) && u.getContrasenia().equals(pass)) {
                return "indicadores";
            }
        }
        return "login";
    }

    public String getRebote() {
        return rebote;
    }

    public void setRebote(String rebote) {
        this.rebote = rebote;
    }
    
     public void error() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", rebote));
    }
    
}
