/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.time.LocalDate;

/**
 *
 * @author Filipe Oliveira
 */
public class Eleicao {
    
    private String tipoEleicao;
    private int numeroEleicao;
    private String estado;
    private int dataEncerramento;

    public Eleicao() {
        this.tipoEleicao = "";
        this.numeroEleicao = 0;
        this.estado = "";
        this.dataEncerramento = 0;
    }

    
    
    
    public Eleicao(String tipoEleicao, int numeroEleicao, String estado, int dataEncerramento) {
        this.tipoEleicao = tipoEleicao;
        this.numeroEleicao = numeroEleicao;
        this.estado = estado;
        this.dataEncerramento = dataEncerramento;
    }
    
    public Eleicao(Eleicao e){
        this.tipoEleicao = e.getTipoEleicao();
        this.numeroEleicao = e.getNumeroEleicao();
        this.estado = e.getEstado();
        this.dataEncerramento = e.getDataEncerramento();
    
    }

    public String getTipoEleicao() {
        return tipoEleicao;
    }

    public int getNumeroEleicao() {
        return numeroEleicao;
    }

    public String getEstado() {
        return estado;
    }

    public int getDataEncerramento() {
        return dataEncerramento;
    }

    public void setTipoEleicao(String tipoEleicao) {
        this.tipoEleicao = tipoEleicao;
    }

    public void setNumeroEleicao(int numeroEleicao) {
        this.numeroEleicao = numeroEleicao;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setDataEncerramento(int dataEncerramento) {
        this.dataEncerramento = dataEncerramento;
    }
    
    
    
}
