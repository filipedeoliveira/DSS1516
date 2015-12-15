/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import dataacess.CirculoEleitoralDAO;
import dataacess.EleicaoDAO;
import exceptions.ExisteOuNaoExisteException;
import java.time.LocalDate;

/**
 *
 * @author Filipe Oliveira
 */
public class Facade {

    /*public static void inserirEleitor(String nome, String CC, String morada, String freguesia, String P_Nome){
     try{
     EleitorDAO dao = new EleitorDAO();
     Eleitor e = new Eleitor(nome,CC,morada,freguesia,P_Nome);
     dao.put(e);
     }
     catch(Exception ex){
     ex.printStackTrace();
     System.out.println("sql exception");
     }
     }*/
    public static void inserirCirculoEleitoral(String text) {
        try {
            CirculoEleitoralDAO dao = new CirculoEleitoralDAO();
            CirculoEleitoral ce = new CirculoEleitoral(text);
            dao.put(ce);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static void removerCirculoEleitoral(String text){
        try{
            new CirculoEleitoralDAO().remove(text);
            
        }   catch (Exception ex){}
    }

    public static void criaEleicao(String tipo, int codigo, String estado, int year) {
        try {
            EleicaoDAO dao = new EleicaoDAO();
            Eleicao e = new Eleicao(tipo, codigo, estado, year);
            dao.put(e);
        } catch (Exception ec) {
            ec.printStackTrace();
        }

    }

}
