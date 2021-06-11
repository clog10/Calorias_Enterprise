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
import java.util.Date;
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
    private Date fechaRegistro;
    private Usuario usuario;

    private String user;
    private String pass;

    private char indice;
    
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

    public Usuario getNombre() {
        return lNUsuario.buscaPorUsuario(user, pass);
    }

    public char getIndice() {
        return indice;
    }

    public void setIndice(char indice) {
        this.indice = indice;
    }

    public void registrar() {
        indicadores.setFecha(fechaRegistro);
        Usuario u = getNombre();
        indicadores.setIdusuario(u);
        indicadores.setTipoact(u.getTipoact());
        lNIndicadores.registrar(indicadores);
    }
    
    public void eliminar(Indicadoressalud indicador){
        lNIndicadores.eliminar(indicador);
    }

    public String ingresar() {
        for (Usuario u : lNUsuario.usuarios()) {
            if (u.getUsuario().equals(user) && u.getContrasenia().equals(pass)) {
                return "indicadores";
            }
        }
        return "login";
    }

    public List<Indicadoressalud> indicadoresUsuario() {
        List<Indicadoressalud> indicadores = new ArrayList<>();
        for (Indicadoressalud indicador : lNIndicadores.indicadores()) {
            if (indicador.getIdusuario().getIdusuario() == getNombre().getIdusuario()) {
                indicadores.add(indicador);
            }
        }
        return indicadores;
    }
    
    public String mostrar(){
        if('S' == indice){
            return "resultados";
        }
        return "index";
    }
    
        public double imc() {
        double estatura = indicadores.getEstatura() / 100;
        return indicadores.getPeso() / (estatura * estatura);
    }

    public double icc() {
        return indicadores.getCintura() / indicadores.getCadera();
    }

}
