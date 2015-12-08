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
    private TreeMap<Participante, Integer> votacao;

   
    public Votar(){
        this.tipoEleicao="";
        this.numEleitor="";
        this.votacao= new TreeMap<Participante, Integer>();
    }
   /* 
    public Votar(String tipoEleicao, String numEleitor, TreeMap<Participante, Integer> v) {
        this.tipoEleicao = tipoEleicao;
        this.numEleitor = numEleitor;
        for(Participante p : v.keySet())
           // this.votacao.put(p.clone(),_____)
            }
   */

    
    

    
}
