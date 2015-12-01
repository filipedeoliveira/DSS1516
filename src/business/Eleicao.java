/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Filipe Oliveira
 */
public class Eleicao {
    private String tipoEleicao;
    private ArrayList<String> participantes  = new ArrayList();
    
    
    public Eleicao(){
        this.tipoEleicao="";
        this.participantes=new ArrayList<String>();
    }

    public Eleicao(String tipoEleicao, ArrayList<String> part) {
        participantes = new ArrayList<String>();
        this.tipoEleicao = tipoEleicao;
        for(String s : participantes)
            participantes.add(s);
    }
    
    public Eleicao(Eleicao e){
        this.tipoEleicao=e.getTipoEleicao();
        this.participantes=e.getParticipantes();
    }
    
    public String getTipoEleicao() {
        return tipoEleicao;
    }

    public ArrayList<String> getParticipantes() {
        ArrayList<String> res = participantes;
        participantes = new ArrayList<String>();
        return res;
    }

    public void setTipoEleicao(String tipoEleicao) {
        this.tipoEleicao = tipoEleicao;
    }

    public void setParticipantes(ArrayList<String> part) {
        this.participantes = new ArrayList<String>();
        for (String p : part)
            this.participantes.add(p);
    }
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Eleicao other = (Eleicao) obj;
        if (!Objects.equals(this.tipoEleicao, other.tipoEleicao)) {
            return false;
        }
        if (!Objects.equals(this.participantes, other.participantes)) {
            return false;
        }
        return true;
    }
    
    
    
 
}
