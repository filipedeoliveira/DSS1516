/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.Objects;

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

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Candidatura other = (Candidatura) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }
    
}
