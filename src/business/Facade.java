/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import dataacess.EleitorDAO;
import exceptions.ExisteOuNaoExisteException;

/**
 *
 * @author Filipe Oliveira
 */
public class Facade {
    
    
    public static void inserirEleitor(String nome, String CC, String morada, String freguesia, String P_Nome){
        EleitorDAO dao = new EleitorDAO();
        Eleitor e = new Eleitor(nome,CC,morada,freguesia,P_Nome);
        dao.put(e);
    }
    

}
