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
public class CirculoEleitoral {
    
    private int idDistrito;
    private String nome;

    public CirculoEleitoral(int id,String nome) {
        this.idDistrito=id;
        this.nome = nome;
    }

    public int getIdDistrito(){
        return idDistrito;
    }
    public String getNome() {
        return nome;
    }

    public void setIdDistro(int id){
        this.idDistrito=id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

}
