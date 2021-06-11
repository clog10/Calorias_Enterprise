/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package log_neg;

import acceso_datos.UsuarioFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.Usuario;

/**
 *
 * @author Carlos Loaeza
 */
@Stateless
@LocalBean
public class LNUsuario {

    @EJB
    private UsuarioFacade usuarioFacade;

    public void registrar(Usuario user){
        usuarioFacade.create(user);
    }
    
    public void actualizar(Usuario user){
        usuarioFacade.edit(user);
    }
    
    public List<Usuario> usuarios(){
        List<Usuario> us = usuarioFacade.findAll();
        return us;
    }
    
    public Usuario buscaUsuario(int id){
        return usuarioFacade.find(id);
    }
    
    public Usuario buscaPorUsuario(String user, String pass){
        for(Usuario u : usuarioFacade.findAll()){
            if(u.getUsuario().equals(user) && u.getContrasenia().equals(pass)){
                return u;
            }
        }
        return null;
    }
    
    public Usuario buscaPorNombre(String nombre){
        for(Usuario u : usuarioFacade.findAll()){
            if(u.getUsuario().equals(nombre)){
                return u;
            }
        }
        return null;
    }
     
}
