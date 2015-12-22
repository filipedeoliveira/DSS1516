/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataacess;

import business.Lista;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Filipe Oliveira
 */
public class ListaDAO implements Map<String, Lista> {
    
    private Connection conn;
    
    public ListaDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
        } catch (ClassNotFoundException | SQLException l) {
            l.printStackTrace();
        }
    }
    
    public Lista put(String tipoL, Lista value) {
        
        try {
            Lista l = null;
            Statement stm = conn.createStatement();
            String sql = "INSERT INTO lista (nomeLista, tipo, validacao, Eleicao_nEleicao) VALUES (\"" + value.getNomeLista() + "\",\"" + value.getTipoLista() + "\", \"" +value.getValidacao()+ "\",\"" + value.getNumEleicaoParticipa() + "\");";
            int i = stm.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Lista(value.getIdLista(), value.getTipoLista(), value.getNomeLista(),value.getValidacao(), value.getNumEleicaoParticipa());
        
    }
    
    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean containsKey(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getIdLista(String nome) {
        int i = 0;
        try {
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM lista WHERE nomeLista = '" + nome + "';";
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) {
            i = rs.getInt(1);
            }
        }
        catch(Exception e){
            throw new NullPointerException(e.getMessage());
        }
            return i;
    }
    
    @Override
    public Lista get(Object key) {
        Lista le = null;
        try {
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM lista WHERE nome = '" + (String) key + "';";
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) {
            le = new Lista(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4), rs.getInt(5));
            }
        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        }
        return le;
    }
    
    @Override
    public Lista remove(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void putAll(Map<? extends String, ? extends Lista> m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Set<String> keySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Collection<Lista> values() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Set<Entry<String, Lista>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
