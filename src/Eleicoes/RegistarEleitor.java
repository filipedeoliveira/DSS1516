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
    public void SetFreguesia(String freguesia){
        this.freguesia=freguesia;
    }
    
    public boolean equals(Object o){
        if (this == o)return true;
        if((o == null) || (this.getClass() != o.getClass())) return false;
        RegistarEleitor e = (RegistarEleitor) o;
        return this.nome.equals(e.getNome()) && 
               this.numCidadao.equals(e.getNumCidadao()) && 
               this.morada.equals(e.getMorada()) && 
               this.freguesia.equals(e.getFreguesia());
    
    }
}
