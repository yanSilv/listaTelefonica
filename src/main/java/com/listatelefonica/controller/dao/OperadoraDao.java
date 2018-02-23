/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listatelefonica.controller.dao;

import com.listatelefonica.modelo.Operadora;
import com.listatelefonica.modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author programador
 */
public class OperadoraDao {
    
    Conexao conn = new Conexao();
    PreparedStatement ps;
    ResultSet rs;
    
    public void cadastrar (Usuario usuario) throws SQLException {
        
        String sql = "INSERT INTO tb_operadora (nome, codigo) "
                + "values (?,?)";
        ps = conn.getConexao().prepareStatement(sql);
        
        ps.setString(1, usuario.getOperadora().getNome());
        ps.setString(2, usuario.getOperadora().getCodigo());
        
        ps.execute();
        
    }
    
    
    public ArrayList<Operadora> busca() throws SQLException {
        ArrayList<Operadora> arrayOpe = new ArrayList<Operadora>();
        
        String sql = "SELECT * FROM tb_operadora";
        
        ps = conn.getConexao().prepareStatement(sql);
        rs = ps.executeQuery();
        
        while(rs.next()) {
            
            Operadora operadora = new Operadora();
            
            operadora.setId(rs.getString("idtb_operadora"));
            operadora.setCodigo(rs.getString("codigo"));
            operadora.setNome(rs.getString("nome"));
            
            arrayOpe.add(operadora);
        }
        
        return arrayOpe;
    }

    public Usuario busca(Usuario usuario) throws SQLException {
        String sql = "SELECT * FROM tb_operadora WHERE idtb_operadora = ?";
        
        ps = conn.getConexao().prepareStatement(sql);
        ps.setString(1, usuario.getIdOperadora());
        rs = ps.executeQuery();
        
        if (rs.next()) {
            Operadora operadora = new Operadora();
            
            operadora.setId(rs.getString("idtb_operadora"));
            operadora.setCodigo(rs.getString("codigo"));
            operadora.setNome(rs.getString("nome"));
            
            usuario.setOperadora(operadora);
        }
        
        return usuario;
    }
}
