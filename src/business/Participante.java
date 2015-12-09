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
public class Participante {
    
    private int idParticipanete;
    private String nomeParticipante;
    private int posicaoParticipante;
    private int listaIdLista;

    public Participante(){
        this.idParticipanete = 0;
        this.nomeParticipante = "";
        this.posicaoParticipante = 0;
        this.listaIdLista = 0;
    }
    
    public Participante(int idParticipanete, String nomeParticipante, int posicaoParticipante, int listaIdLista) {
        this.idParticipanete = idParticipanete;
        this.nomeParticipante = nomeParticipante;
        this.posicaoParticipante = posicaoParticipante;
        this.listaIdLista = listaIdLista;
    }
    
    public Participante(Participante c){
        this.idParticipanete = c.getIdParticipanete();
        this.nomeParticipante = c.getNomeParticipante();
        this.posicaoParticipante = c.getPosicaoParticipante();
        this.listaIdLista = c.getListaIdLista();
    }

    public int getIdParticipanete() {
        return idParticipanete;
    }

    public void setIdParticipanete(int idParticipanete) {
        this.idParticipanete = idParticipanete;
    }

    public String getNomeParticipante() {
        return nomeParticipante;
    }

    public void setNomeParticipante(String nomeParticipante) {
        this.nomeParticipante = nomeParticipante;
    }

    public int getPosicaoParticipante() {
        return posicaoParticipante;
    }

    public void setPosicaoParticipante(int posicaoParticipante) {
        this.posicaoParticipante = posicaoParticipante;
    }

    public int getListaIdLista() {
        return listaIdLista;
    }

    public void setListaIdLista(int listaIdLista) {
        this.listaIdLista = listaIdLista;
    }

    @Override
    public String toString() {
        return "Participante{" + "idParticipanete=" + idParticipanete + ", nomeParticipante=" + nomeParticipante + ", posicaoParticipante=" + posicaoParticipante + ", listaIdLista=" + listaIdLista + '}';
    }

  
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Participante other = (Participante) obj;
        if (this.idParticipanete != other.idParticipanete) {
            return false;
        }
        if (!Objects.equals(this.nomeParticipante, other.nomeParticipante)) {
            return false;
        }
        if (this.posicaoParticipante != other.posicaoParticipante) {
            return false;
        }
        if (this.listaIdLista != other.listaIdLista) {
            return false;
        }
        return true;
    }
    
    
}
