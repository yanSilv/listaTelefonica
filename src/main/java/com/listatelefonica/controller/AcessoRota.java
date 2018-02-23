/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listatelefonica.controller;

import com.listatelefonica.controller.dao.OperadoraDao;
import com.listatelefonica.controller.dao.UsuarioDao;
import com.listatelefonica.modelo.Operadora;
import com.listatelefonica.modelo.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author programador
 */
@Path("rotacesso")
public class AcessoRota {
    
    ArrayList<Usuario> arrayUser = new ArrayList<Usuario>();
    ArrayList<Operadora> arrayOpe = new ArrayList<Operadora>();
    UsuarioDao useDao = new UsuarioDao();
    OperadoraDao opeDao = new OperadoraDao();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/operadora")
    public ArrayList<Operadora> getOperadora () {
        System.out.println("Operadora busca");
        
        try {
            arrayOpe = opeDao.busca();
        } catch (SQLException ex) {
            Logger.getLogger(AcessoRota.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return arrayOpe;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/user")
    public ArrayList<Usuario> getUsuario () {
        System.out.println("Consulta");
        
        try {
            arrayUser = useDao.buscar();
            
            for (int i = 0; i < arrayUser.size(); i++) {
                if (arrayUser.get(i).getIdOperadora() == null || arrayUser.get(i).getIdOperadora().equals("NULL")) {
                    System.out.println("Não tem id");
                    continue;
                }
                arrayUser.set(i, opeDao.busca(arrayUser.get(i)));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AcessoRota.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return arrayUser;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/user")
    public void setUsuario(Usuario usuario) {
        System.out.println("Cadastro");
        
        try {
            useDao.adicionar(usuario);
        } catch (SQLException ex) {
            Logger.getLogger(AcessoRota.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @DELETE
    @Path("/user/{id}")
    public void delUser (@PathParam("id") String id) {
        System.out.println("Delete");
        System.out.println(id);
        try {
            useDao.delete(id);
        } catch (SQLException ex) {
            Logger.getLogger(AcessoRota.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
