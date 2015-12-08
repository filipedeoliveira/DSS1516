/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.ArrayList;

/**
 *
 * @author Filipe Oliveira
 */
public class Participante {
    /*
        PS->50 votos
        PSD->50 votos
        BE->20
        Cavaco -> 30
    */
    private String tipoEleicao; //Assembleia ou Presidenciais
    private String participante; // PSD ou PS ou BE ou CavacoSilva...
    private int votos; // 50 ou 60...
    private ArrayList<String> elementos = new ArrayList<String>(); //Elementos da lista
    
    
    public Participante(){
        this.tipoEleicao="";
        this.participante="";
        this.votos=0;
        this.elementos = new ArrayList<String>();
    }
    
    public Participante (String tipo, String part, int vt, ArrayList<String> ele ){
        elementos = new ArrayList<String>();
        this.tipoEleicao=tipo;
        this.participante=part;
        this.votos=vt;
        for(String e : ele)
            elementos.add(e);
    }
    
    public Participante(Participante p){
        this.participante=p.getParticipante();
        this.votos=p.getVotos();
    }
    
    public void updateVoto(String part){
        if(part.equals(participante))
            votos=votos++;
    }
    
    public String getParticipante(){
        return this.participante;
    }
    
    public int getVotos(){
        return this.votos;
    }
    
    public void setParticipante(String part){
        this.participante=part;
    }
    
    public void setContador(int cnt){
        this.votos=cnt;
    }
    
    
    
}
