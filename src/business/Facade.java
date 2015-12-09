/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import dataacess.CirculoEleitoralDAO;
import exceptions.ExisteOuNaoExisteException;

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

    public static void criaFreguesia(String text) {
        try{
        CirculoEleitoralDAO dao = new CirculoEleitoralDAO();
        int i = 1;
        CirculoEleitoral ce = new CirculoEleitoral(i,text);
        dao.put(ce);
        System.out.println("prima");
        }
        catch (Exception ex){ex.printStackTrace();}
    }
    

}
