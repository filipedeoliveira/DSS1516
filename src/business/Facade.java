/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import dataacess.CirculoEleitoralDAO;
import dataacess.EleicaoDAO;
import dataacess.EleitorDAO;
import exceptions.ExisteOuNaoExisteException;
import java.time.LocalDate;

/**
 *
 * @author Filipe Oliveira
 */
public class Facade {
    
    public static void inserirPass(String pass, int cc){
    try{
        EleitorDAO dao = new EleitorDAO();
        dao.inserirPass(pass, cc);
        
    }
    catch (Exception e){e.printStackTrace();}
    
    }

    public static void inserirEleitor(int num, String nome, int cc, String morada, int idDistrito){
     try{
     EleitorDAO dao = new EleitorDAO();
     Eleitor e = new Eleitor(num, nome, cc, morada, idDistrito);
     dao.put(e);
     }
     catch(Exception ex){
     ex.printStackTrace();
     System.out.println("sql exception");
     }
     }
    
    public static void inserirCirculoEleitoral(String text) {
        try {
            CirculoEleitoralDAO dao = new CirculoEleitoralDAO();
            CirculoEleitoral ce = new CirculoEleitoral(3333333,text);
            dao.put(ce.getNome(), ce);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static void removerCirculoEleitoral(String text){
        try{
            CirculoEleitoralDAO dao = new CirculoEleitoralDAO();
            dao.remove(text);
            
        }   catch (Exception ex){ex.printStackTrace();}
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
