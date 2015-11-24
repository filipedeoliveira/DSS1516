/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eleicoes;

/**
 *
 * @author Filipe Oliveira
 */
public class Candidatura {

    private String nome;
    
    public Candidatura(String nome){
    this.nome=nome;
    }
    
    public Candidatura(Candidatura cand){
    this.nome=cand.getNome();
    }
    
    public String getNome(){
    return this.nome;
    }
    
    public void setNome(String myNome){
    this.nome=myNome;
    }
}
