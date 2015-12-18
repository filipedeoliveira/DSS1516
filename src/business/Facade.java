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
import java.util.GregorianCalendar;

/**
 *
 * @author Filipe Oliveira
 */
public class Facade {

    public static void inserirPass(String pass, int cc) {
        try {
            EleitorDAO dao = new EleitorDAO();
            dao.inserirPass(pass, cc);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void inserirEleitor(int num, String nome, int cc, String morada, int idDistrito) {
        try {
            EleitorDAO dao = new EleitorDAO();
            Eleitor e = new Eleitor(num, nome, cc, morada, idDistrito);
            dao.put(e.getNomeEleitor(), e);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("sql exception");
        }
    }

    public static void inserirCirculoEleitoral(String text) {
        try {
            CirculoEleitoralDAO dao = new CirculoEleitoralDAO();
            CirculoEleitoral ce = new CirculoEleitoral(3333333, text);
            dao.put(ce.getNome(), ce);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void removerCirculoEleitoral(String text) {
        try {
            CirculoEleitoralDAO dao = new CirculoEleitoralDAO();
            dao.remove(text);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void criaEleicao(String tipo, int codigo, String estado, GregorianCalendar year) {
        try {
            EleicaoDAO dao = new EleicaoDAO();
            Eleicao e = new Eleicao(tipo, codigo, estado, year);
            dao.put(e);
        } catch (Exception ec) {
            ec.printStackTrace();
        }

    }

    public static boolean testaLogin(int numEle) {
        boolean res = false;
        try {

            EleitorDAO dao = new EleitorDAO();
            res = dao.existeEleitorNE(numEle);

        } catch (Exception ex) {

        }
        return res;
    }

    public static boolean testaPass(int ne, String pass) {
        boolean res = false;
        try {

            EleitorDAO dao = new EleitorDAO();
            res = dao.existePass(pass, ne);

        } catch (Exception ex) {
            throw new NullPointerException(ex.getMessage());
        }
        return res;
    }

    public static int daNCC(int cc) {
        int res = -1;
        try {
            EleitorDAO dao = new EleitorDAO();
            res = dao.getNumEleitor(cc);
            
        } catch (Exception e) {
            e.printStackTrace();
            //throw new NullPointerException(e.getMessage());
        }
        return res;
    }
}
