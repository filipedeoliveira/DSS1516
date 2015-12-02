/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import view.ResgistarEleitor;

/**
 *
 * @author Filipe Oliveira
 */
public class Eleitor {
    
    private String nome, CC, morada, freguesia, P_Nome;
    
    public Eleitor(String nome, String CC, String morada, String freguesia, String P_Nome){
        this.nome=nome;
        this.CC=CC;
        this.morada=morada;
        this.freguesia=freguesia;
        this.P_Nome=P_Nome;
    }
    
    public Eleitor(Eleitor re){
        this.nome=re.getNome();
        this.CC=re.getCC();
        this.morada=re.getMorada();
        this.freguesia=re.getFreguesia();
        this.P_Nome=re.getP_Nome();
    }
  
    public String getNome(){
        return this.nome;
    }
    public String getCC(){
        return this.CC;
    }

    public String getP_Nome() {
        return P_Nome;
    }

    public void setCC(String CC) {
        this.CC = CC;
    }

    public void setFreguesia(String freguesia) {
        this.freguesia = freguesia;
    }

    public void setP_Nome(String P_Nome) {
        this.P_Nome = P_Nome;
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
    public void setNumCidadao(String CC){
        this.CC=CC;
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
        Eleitor e = (Eleitor) o;
        return this.nome.equals(e.getNome()) && 
               this.CC.equals(e.getCC()) && 
               this.morada.equals(e.getMorada()) && 
               this.freguesia.equals(e.getFreguesia());
    
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(" Nome:");
        sb.append(nome);
        sb.append('\n');
        sb.append(" Número de Cidadão:");
        sb.append(CC);
        sb.append('\n');
        sb.append(" Morada:");
        sb.append(morada);
        sb.append('\n');
        sb.append(" Freguesia:");
        sb.append(freguesia);
        sb.append('\n');
        return sb.toString();
    }
    
    
}
