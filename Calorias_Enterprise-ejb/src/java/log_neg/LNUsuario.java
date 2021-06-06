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
    
    public List<Usuario> usuarios(){
        List<Usuario> us = usuarioFacade.findAll();
        return us;
    }
}
