/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eleicoes;

import view.ResgistarEleitor;

/**
 *
 * @author Filipe Oliveira
 */
public class RegistarEleitor {
    
    private String nome, numCidadao, morada, freguesia;
    
    public RegistarEleitor(String nome, String numCidadao, String morada, String freguesia){
        this.nome=nome;
        this.numCidadao=numCidadao;
        this.morada=morada;
        this.freguesia=freguesia;
    }
    
    public RegistarEleitor(ResgistarEleitor re){
        this.nome=re.getNome();
        this.numCidadao=re.getNumCidadao();
        this.morada=re.getMorada();
        this.freguesia=re.getFreguesia();
    }
  
    public String getNome(){
        return this.nome;
    }
    public String getNumCidadao(){
        return this.numCidadao;
    }
    public String getMorada(){
        return this.morada;
    }
    public String getFreguesia(){
        return this.freguesia;
    }
    
    public void setNome(String nome){
        this.nome=nome;
    }
    public void setNumCidadao(String numCidadao){
        this.numCidadao=numCidadao;
    }
    public void setMorada(String morada){
        this.morada=morada;
    }
    public RegistarEleitor(String freguesia){
        this.freguesia=freguesia;
    }
}
