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
    private int votos;
    private int deputados;

    public Resultados() {
        this.idResultados = 0;
        this.participante = "";
        this.votos = 0;
        this.deputados = 0;
    }

    public Resultados(int idResultados, String participante, int vt, int dp) {
        this.idResultados = idResultados;
        this.participante = participante;
        this.votos = vt;
        this.deputados = dp;
    }

    public Resultados(Resultados r) {
        this.idResultados = r.getIdResultados();
        this.participante = r.getParticipante();
        this.votos = r.getVotos();
        this.deputados = r.getDeputados();
    }

    public int getVotos() {
        return votos;
    }

    public int getDeputados() {
        return deputados;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    public void setDeputados(int deputados) {
        this.deputados = deputados;
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
