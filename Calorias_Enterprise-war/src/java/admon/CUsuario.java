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
    private int idAct;

    /**
     * Creates a new instance of CUsuario
     */
    public CUsuario() {
        usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getIdAct() {
        return idAct;
    }

    public void setIdAct(int idAct) {
        this.idAct = idAct;
    }
    
    public Tipoactividad actividad(){
        List<Tipoactividad> ac = new ArrayList<>();
       for(Tipoactividad a:lNTipoA.actividades()){
           ac.add(a);
       }
       
       for(Tipoactividad a:ac){
           if(a.getIdtact()==idAct){
               return a;
           }
       }
       return null;
    }
    
    public void registrar(){
        usuario.setTipoact(actividad());
        lNUsuario.registrar(usuario);
    }
    
       public List<Usuario> usuarios(){
       List<Usuario> us = new ArrayList<>();
       for(Usuario a:lNUsuario.usuarios()){
           us.add(a);
       }
       return us;
   }
    
}
