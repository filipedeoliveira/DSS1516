/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataacess;

import business.CirculoEleitoral;
import business.Eleicao;
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
public class EleicaoDAO implements Map<String, Eleicao> {

    private Connection conn;

    public EleicaoDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Eleicao put(String tipo, Eleicao value) {
        Eleicao e = null;
        try {
            Statement stm = conn.createStatement();
            String sql = "INSERT INTO eleicao (nEleicao, tipo, dataEncerramento, estado) VALUES (\"" + value.getNumeroEleicao() + "\",\"" + value.getTipoEleicao() + "\",\"" + value.getData() + "\",\"" + value.getEstado() + "\");";
            int i = stm.executeUpdate(sql);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new Eleicao();

    }

    @Override
    public int size() {
        try {
            int contador = 0;
            Statement stm = conn.createStatement();
            ResultSet i = stm.executeQuery("SELECT * FROM Eleicao");
            for (; i.next(); contador++);
            return contador;

        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        }
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
        try {
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM Eleicao WHERE tipo='" + (String) value + "'";
            ResultSet rs = stm.executeQuery(sql);
            return rs.next();
        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        }
    }

    @Override
    public Eleicao get(Object key) {
        Eleicao el = null;
        try {
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM Eleicao WHERE tipo='" + (String) key + "'";
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) {
             //   el = new Eleicao(rs.getString(2),rs.getInt(1),rs.getString(4),rs.getDate(3));
            }
        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        }
        return el;
    }

    @Override
    public Eleicao remove(Object key) {
        try {
            Eleicao el = this.get(key);
            Statement stm = conn.createStatement();
            String sql = "DELETE FROM Eleicao WHERE tipo = '"+(String) key+"' ;";
            boolean i  = stm.execute(sql);
            return el;
        } catch (Exception e) {
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
    }

    @Override
    public void putAll(Map<? extends String, ? extends Eleicao> m) {
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
    public Collection<Eleicao> values() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Entry<String, Eleicao>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
