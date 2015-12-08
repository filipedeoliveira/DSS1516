/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Filipe Oliveira
 */
public class Votar {
    private String tipoEleicao;
    private String numEleitor;
    private TreeMap<String, Participante> votacao;
    // ex: Marcelo -> 50 Não estou a conseguir 

  /* 
    public Votar(){
        this.tipoEleicao="";
        this.numEleitor="";
        this.votacao= new TreeMap<String, Participante>();
    }
  
    public Votar(String tipoEleicao, String numEleitor, TreeMap<String, Participante> v) {
        votacao = new TreeMap<String, Participante>();
        this.tipoEleicao = tipoEleicao;
        this.numEleitor = numEleitor;
        for(Participante p : v.values())
            votacao.put(p.getParticipante(),p.clone());    
    }*/
}
