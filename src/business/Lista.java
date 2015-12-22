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
public class Lista {

    private int idLista;
    private String tipoLista;
    private String nomeLista;
    private String validacao;
    private int numEleicaoParticipa;

    public Lista() {
        this.idLista = 0;
        this.tipoLista = "";
        this.nomeLista = "";
        this.validacao = "";
        this.numEleicaoParticipa = 0;
    }

    public Lista(int idLista, String tipoLista, String nomeLista,String val, int numEleicaoParticipa) {
        this.idLista = idLista;
        this.tipoLista = tipoLista;
        this.nomeLista = nomeLista;
        this.validacao = val;
        this.numEleicaoParticipa = numEleicaoParticipa;
    }

    public Lista(Lista l) {
        this.idLista = l.getIdLista();
        this.tipoLista = l.getTipoLista();
        this.nomeLista = l.getNomeLista();
        this.validacao = l.getValidacao();
        this.numEleicaoParticipa = l.getNumEleicaoParticipa();
    }

    public int getIdLista() {
        return idLista;
    }

    public void setIdLista(int idLista) {
        this.idLista = idLista;
    }

    public String getTipoLista() {
        return tipoLista;
    }

    public void setTipoLista(String tipoLista) {
        this.tipoLista = tipoLista;
    }

    public void setValidacao(String validacao) {
        this.validacao = validacao;
    }

    public String getValidacao() {
        return validacao;
    }

    public String getNomeLista() {
        return nomeLista;
    }

    public void setNomeLista(String nomeLista) {
        this.nomeLista = nomeLista;
    }

    public int getNumEleicaoParticipa() {
        return numEleicaoParticipa;
    }

    public void setNumEleicaoParticipa(int numEleicaoParticipa) {
        this.numEleicaoParticipa = numEleicaoParticipa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Lista other = (Lista) obj;
        if (this.idLista != other.idLista) {
            return false;
        }
        if (!Objects.equals(this.tipoLista, other.tipoLista)) {
            return false;
        }
        if (!Objects.equals(this.nomeLista, other.nomeLista)) {
            return false;
        }
        if (this.numEleicaoParticipa != other.numEleicaoParticipa) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Lista{" + "idLista=" + idLista + ", tipoLista=" + tipoLista + ", nomeLista=" + nomeLista + ", numEleicaoParticipa=" + numEleicaoParticipa + '}';
    }

}
