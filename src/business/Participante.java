/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

/**
 *
 * @author Filipe Oliveira
 */
public class Participante {
    private String participante;
    
    public Participante(){
        this.participante="";
    }
    
    public Participante (String part ){
        this.participante=part;
    }
    
    public Participante(Participante p){
        this.participante=p.getParticipante();
    }
    
    public String getParticipante(){
        return this.participante;
    }
    
    public void setParticipante(String part){
        this.participante=part;
    }
    
    
    
}
