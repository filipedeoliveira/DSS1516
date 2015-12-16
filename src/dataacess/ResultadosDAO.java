/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataacess;

import business.CirculoEleitoral;
import business.Eleicao;
import business.Resultados;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Filipe Oliveira
 */
public class ResultadosDAO implements Map<String, Resultados> {

    private Connection conn;

    public ResultadosDAO() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
        } catch (ClassNotFoundException | SQLException r) {
            r.printStackTrace();
        }
    }

    public Resultados put(String participante, Resultados value) {
        Resultados e = null;
        try {
            Statement stm = conn.createStatement();
            String sql = "INSERT INTO resultados (idResultados, participantes) VALUES (\"" + value.getIdResultados() + "\",\"" + value.getParticipante() + "\");";
            int i = stm.executeUpdate(sql);
        } catch (Exception r) {

        }
        return new Resultados();
    }

    @Override
    public int size() {
        try {
            int contador = 0;
            Statement stm = conn.createStatement();
            ResultSet i = stm.executeQuery("SELECT * FROM resultados");
            for (; i.next(); contador++);
            return contador;

        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        }

    }

    @Override
    public boolean isEmpty() {
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * From resultados");
            return !rs.next();
        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        }

    }

    @Override
    public boolean containsKey(Object key) {
        try {
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM resultados WHERE id='" + (String) key + "'";
            ResultSet rs = stm.executeQuery(sql);
            return rs.next();
        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        }
    }

    @Override
    public boolean containsValue(Object value) {
        try {
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM resultados WHERE participante='" + (String) value + "'";
            ResultSet rs = stm.executeQuery(sql);
            return rs.next();
        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        }
    }

    @Override
    public Resultados get(Object key) {
        Resultados res = null;
        try {
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM Resultados WHERE id='" + (String) key + "'";
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) {
                res = new Resultados(rs.getInt(1), rs.getString(2));
            }
        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        }
        return res;
    }

    @Override
    public Resultados remove(Object par) {
        
        /**
         *  Resultados ce = this.get(key);
            Statement stm = conn.createStatement();
            String sql = "DELETE '"+key+"' FROM Resultados";
            int i  = stm.executeUpdate(sql);
            return ce;
         * */
        
        try {
            Resultados r = null;
            Statement stm = conn.createStatement();
            String sql = "DELETE FROM resultados WHERE participante = '" + (String) par + "' ;";
            boolean it = stm.execute(sql);
            return new Resultados(r.getIdResultados(), (String) par);//Ver tipos 
        } catch (Exception e) {
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }

    }

    @Override
    public void putAll(Map<? extends String, ? extends Resultados> m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        try {
            Statement stm = conn.createStatement();
            String sql = "DELETE FROM resultados;";
            int i = stm.executeUpdate(sql);

        } catch (Exception e) {
        }
    }

    @Override
    public Set<String> keySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Resultados> values() {
        try {
            Collection<Resultados> res = new HashSet<Resultados>();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FORM Resultados");
            for (; rs.next();) {
                res.add(new Resultados(rs.getInt(1), rs.getString(2)));
            }
            return res;
        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        }
    }

    @Override
    public Set<Entry<String, Resultados>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int hashCode() {
        return this.conn.hashCode();
    }

}
