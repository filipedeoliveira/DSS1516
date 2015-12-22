/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import dataacess.CirculoEleitoralDAO;
import dataacess.EleicaoDAO;
import dataacess.EleitorDAO;
import dataacess.ListaDAO;
import dataacess.ParticipanteDAO;
import exceptions.ExisteOuNaoExisteException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import javax.swing.DefaultListModel;

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

    public static void criaEleicao(String tipo, int codigo, String estado, int year) {
        try {
            EleicaoDAO dao = new EleicaoDAO();
            Eleicao e = new Eleicao(tipo, codigo, estado, year);
            dao.put(e.getTipoEleicao(), e);
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

    public static void insereParticipante(int idParticipanete, String nomeParticipante, int posicaoParticipante, int listaIdLista) {
        try {
            ParticipanteDAO dao = new ParticipanteDAO();
            Participante p = new Participante(idParticipanete, nomeParticipante, posicaoParticipante, listaIdLista);
            dao.put(p.getNomeParticipante(), p);
        } catch (Exception ec) {
            ec.printStackTrace();
        }

    }

    public static void alterarEstado(String text) {
        try {
            EleicaoDAO dao = new EleicaoDAO();
            dao.alterarEstado(text);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void terminaEleP() {
        try {
            EleicaoDAO dao = new EleicaoDAO();
            dao.terminaEleicaoPresidencial();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static void terminaEleA() {
        try {
            EleicaoDAO dao = new EleicaoDAO();
            dao.terminaEleicaoAssembleia();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static void insereLista(int idLista, String tipoLista, String nomeLista,String validacao, int numEleicaoParticipa) {
        try {
            ListaDAO dao = new ListaDAO();
            Lista l = new Lista(idLista, tipoLista, nomeLista, validacao, numEleicaoParticipa);
            dao.put(l.getTipoLista(), l);
        } catch (Exception ec) {
            ec.printStackTrace();
        }

    }
    
    public static int idListapart(String nomeLista){
        int i = 0;
    try {
        ListaDAO dao = new ListaDAO();
        i = dao.getIdLista(nomeLista);
        
    
    }
    catch(Exception e) {e.printStackTrace();}
        return i;
    }
    
    public static int idEleicaoPart(String tipo){
        int i = 0;
    try{
        EleicaoDAO dao = new EleicaoDAO();
        i = dao.getIdEleicao(tipo);
    }
    catch (Exception e) {e.printStackTrace();}
        return i;
    }
    
    public static DefaultListModel<String> validacoesL(String tipo){
    ListaDAO l = new ListaDAO();
        ArrayList<String> aux = new ArrayList<String>();
        DefaultListModel<String> dlm = new DefaultListModel<>();
        aux = l.getValidacoesL(tipo);
        for (String s : aux) {
            dlm.addElement(s);
        }
        return dlm;
    }
    
    public static DefaultListModel<String> tipoE(){
        EleicaoDAO e = new EleicaoDAO();
        ArrayList<String> aux = new ArrayList<String>();
        DefaultListModel<String> dlm = new DefaultListModel<>();
        aux = e.getPresidenciais();
        for (String s : aux) {
            dlm.addElement(s);
        }
        return dlm;
    }
    
    public static void validar(Object nomeL){
        try{
        ListaDAO dao = new ListaDAO(); 
        dao.valida((String) nomeL);
        
        }
        catch(Exception e){}
    }
    
    public static void removerL(Object nomeL){
        try{
        ListaDAO dao = new ListaDAO();
        dao.remove(nomeL);
        }
        catch(Exception e) {}
    }
    
    public static void removerP (int id){
        try{
            ParticipanteDAO dao = new ParticipanteDAO();
            dao.removeTodosPartido(id);
        }
        catch (Exception e){}
    }
}


