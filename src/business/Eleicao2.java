/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.TreeMap;

/**
 *
 * @author Filipe Oliveira
 */
public class Eleicao2 {
    
    //private tipoEleicao ??
    private TreeMap<String, Participante> listas;
    // BE -> Participante
    
    public Eleicao2(){
        this.listas=new TreeMap<String, Participante>();
    }
    
    public Eleicao2(TreeMap<String, Participante> in){
        listas = new TreeMap<String, Participante>();
        for(Participante p : in.values())
            this.listas.put(p.getParticipante(),p.clone());                    
    }
    
    public Eleicao2(Eleicao2 e){
        this.listas=e.getListas();
    }
    
    public TreeMap<String, Participante> getListas(){
        TreeMap<String, Participante> res = new TreeMap<String, Participante>();
        for(Participante p : this.listas.values())
            res.put(p.getParticipante(), p.clone());
        return res;
    }
    
    //Método que Constroi um TreeMap<String,Integer> -> BE->50 votos p.e 
}
