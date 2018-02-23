/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listatelefonica.controller.dao;

import com.listatelefonica.modelo.Operadora;
import com.listatelefonica.modelo.Usuario;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author programador
 */
public class Teste {
    public static void main (String[] args) {
        UsuarioDao useDao = new UsuarioDao();
        OperadoraDao opeDao = new OperadoraDao();
        
        ArrayList<Usuario> arrayUser = new ArrayList<Usuario>();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        arrayUser.add(new Usuario("Yan Silva", "9999-8888", new Operadora("Oi", "31"), df.format(new Date())));
        arrayUser.add(new Usuario("Cris Barata", "9999-7777", new Operadora("Oi", "31"), df.format(new Date())));
        arrayUser.add(new Usuario("Emmanuela Borges", "9999-7777", new Operadora("Claro", "51"), df.format(new Date())));
        arrayUser.add(new Usuario("Livingstone Leal", "9999-7777", new Operadora("Vivo", "50"), df.format(new Date())));
        arrayUser.add(new Usuario("Veveta Alguma coisa", "9999-7777", new Operadora("Oi", "31"), df.format(new Date())));
        
        try {
            useDao.adicionar(arrayUser.get(0));
            useDao.adicionar(arrayUser.get(1));
            useDao.adicionar(arrayUser.get(2));
            useDao.adicionar(arrayUser.get(3));
            useDao.adicionar(arrayUser.get(4));
            
            opeDao.cadastrar(arrayUser.get(0));
            opeDao.cadastrar(arrayUser.get(2));
            opeDao.cadastrar(arrayUser.get(3));
            
        } catch (SQLException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
