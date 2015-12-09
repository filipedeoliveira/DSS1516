/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.Objects;
import view.ResgistarEleitor;

/**
 *
 * @author Filipe Oliveira
 */
public class Eleitor {
    
    private int numEleitor;
    private String nomeEleitor;
    private int numCC;
    private String morada;
    private String distrito;
    
    private Eleitor(){
        this.numEleitor = 0;
        this.nomeEleitor = "";
        this.numCC = 0;
        this.morada = "";
        this.distrito = "";
    }

    public Eleitor(int numEleitor, String nomeEleitor, int numCC, String morada, String distrito) {
        this.numEleitor = numEleitor;
        this.nomeEleitor = nomeEleitor;
        this.numCC = numCC;
        this.morada = morada;
        this.distrito = distrito;
    }
    
    public Eleitor(Eleitor e){
        this.numEleitor = e.getNumEleitor();
        this.nomeEleitor = e.getNomeEleitor();
        this.numCC = e.getNumCC();
        this.morada = e.getMorada();
        this.distrito = e.getDistrito();
    }

    public int getNumEleitor() {
        return numEleitor;
    }

    public void setNumEleitor(int numEleitor) {
        this.numEleitor = numEleitor;
    }

    public String getNomeEleitor() {
        return nomeEleitor;
    }

    public void setNomeEleitor(String nomeEleitor) {
        this.nomeEleitor = nomeEleitor;
    }

    public int getNumCC() {
        return numCC;
    }

    public void setNumCC(int numCC) {
        this.numCC = numCC;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    @Override
    public String toString() {
        return "Eleitor{" + "numEleitor=" + numEleitor + ", nomeEleitor=" + nomeEleitor + ", numCC=" + numCC + ", morada=" + morada + ", distrito=" + distrito + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Eleitor other = (Eleitor) obj;
        if (this.numEleitor != other.numEleitor) {
            return false;
        }
        if (!Objects.equals(this.nomeEleitor, other.nomeEleitor)) {
            return false;
        }
        if (this.numCC != other.numCC) {
            return false;
        }
        if (!Objects.equals(this.morada, other.morada)) {
            return false;
        }
        if (!Objects.equals(this.distrito, other.distrito)) {
            return false;
        }
        return true;
    }
     
    
    
    
}
