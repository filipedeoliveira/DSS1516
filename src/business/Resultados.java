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
public class Resultados {
    private int idResultados;
    private String participante;

    public Resultados(){
        this.idResultados = 0;
        this.participante = "";    
    }
    
    public Resultados(int idResultados, String participante) {
        this.idResultados = idResultados;
        this.participante = participante;
    }
    public Resultados(Resultados r){
        this.idResultados = r.getIdResultados();
        this.participante = r.getParticipante();
    }

    public int getIdResultados() {
        return idResultados;
    }

    public void setIdResultados(int idResultados) {
        this.idResultados = idResultados;
    }

    public String getParticipante() {
        return participante;
    }

    public void setParticipante(String participante) {
        this.participante = participante;
    }

    @Override
    public String toString() {
        return "Resultados{" + "idResultados=" + idResultados + ", participante=" + participante + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Resultados other = (Resultados) obj;
        if (this.idResultados != other.idResultados) {
            return false;
        }
        if (!Objects.equals(this.participante, other.participante)) {
            return false;
        }
        return true;
    }
    
}
