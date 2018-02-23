/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listatelefonica.controller.dao;

import com.listatelefonica.modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author programador
 */
public class UsuarioDao {
   
     Conexao conn = new Conexao();
     PreparedStatement ps;
     ResultSet rs;
    
    public void adicionar (Usuario usuario) throws SQLException {
        String sql = "INSERT INTO tb_usuario(nome, telefone, data, tb_operadora_idtb_operadora) "
                + "values(?,?,?,?)";
        
        ps = conn.getConexao().prepareStatement(sql);
        ps.setString(1, usuario.getNome());
        ps.setString(2, usuario.getTelefone());
        ps.setString(3, usuario.getData());
        ps.setString(4, usuario.getOperadora().getId());
        
        ps.execute();
        
    }
    
    public ArrayList<Usuario> buscar () throws SQLException {
        
        ArrayList<Usuario> arrayUsu = new ArrayList<Usuario>();
        
        String sql = "SELECT * FROM tb_usuario";
        
        ps = conn.getConexao().prepareStatement(sql);
        rs = ps.executeQuery();
        
        while(rs.next()) {
            
            Usuario usua = new Usuario();
            
            usua.setId(rs.getString("id"));
            usua.setNome(rs.getString("nome"));
            usua.setTelefone(rs.getString("telefone"));
            usua.setData(rs.getString("data"));
            usua.setIdOperadora(rs.getString("tb_operadora_idtb_operadora"));
            
            arrayUsu.add(usua);
        }
        
        return arrayUsu;
    }
    
    public ArrayList<Usuario> buscar (Usuario usuario) throws SQLException {
        ArrayList<Usuario> arrayUsu = new ArrayList<Usuario>();
        
        String sql = "SELECT * FROM tb_usuario WHERE nome = ?";
        
        ps = conn.getConexao().prepareStatement(sql);
        ps.setString(1, usuario.getNome());
        rs = ps.executeQuery();
        
        while(rs.next()) {
            
            Usuario usua = new Usuario();
            
            usua.setId(rs.getString("id"));
            usua.setNome(rs.getString("nome"));
            usua.setTelefone(rs.getString("telefone"));
            usua.setData(rs.getString("data"));
            
            arrayUsu.add(usua);
        }
        
        return arrayUsu;
    }

    public void delete(String id) throws SQLException {
        String sql = "DELETE FROM tb_usuario WHERE id = ?";
        
        ps = conn.getConexao().prepareStatement(sql);
        ps.setString(1, id);
        
        ps.executeUpdate();
    }
    
}
