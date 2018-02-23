/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listatelefonica.modelo;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author programador
 */

@XmlRootElement
public class Usuario {
    
    private String id;
    private String nome;
    private String telefone;
    private String data;
    private String idOperadora;
    
    private Operadora operadora;
    
    public Usuario () {
    
    }
    
    public Usuario(String nome, String telefone, Operadora operadora, String data) {
        this.nome = nome;
        this.telefone = telefone;
        this.operadora = operadora;
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Operadora getOperadora() {
        return operadora;
    }

    public void setOperadora(Operadora operadora) {
        this.operadora = operadora;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getIdOperadora() {
        return idOperadora;
    }

    public void setIdOperadora(String idOperadora) {
        this.idOperadora = idOperadora;
    }
    
    
        
}
