/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataacess;

import business.CirculoEleitoral;
import business.Eleitor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author Filipe Oliveira
 */
public class CirculoEleitoralDAO implements Map<String, CirculoEleitoral> {

    private Connection conn;

    public CirculoEleitoralDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public CirculoEleitoral put(String nome, CirculoEleitoral value) {
        CirculoEleitoral ce1 = null;
        try {
            Statement stm = conn.createStatement();
            String sql = "INSERT INTO distrito (nome)  VALUES (\"" + value.getNome() + "\");";
            int i = stm.executeUpdate(sql);
        } catch (Exception e) {
        }
        return new CirculoEleitoral(value.getNome());

    }

    public void clear() {
        try {
            Statement stm = conn.createStatement();
            String sql = "DELETE FROM distrito;";
            int i = stm.executeUpdate(sql);

        } catch (Exception e) {
        }
    }

    public CirculoEleitoral remove(Object key) {
        try {
            CirculoEleitoral ce = null;
            Statement stm = conn.createStatement();
            String sql = "DELETE FROM distrito WHERE nome = '" + key + "' ;";
            boolean it = stm.execute(sql);
            return new CirculoEleitoral((String) key);
        } catch (Exception e) {
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }

    }

    @Override
    public int size() {
        try {
            int contador = 0;
            Statement stm = conn.createStatement();
            ResultSet i = stm.executeQuery("SELECT * FROM DISTRITO");
            for (; i.next(); contador++);
            //System.out.println(contador);
            return contador;

        } catch (Exception e) {
            throw new NullPointerException(e.getMessage()); //To change body of generated methods, choose Tools | Templates.
        }
    }

    @Override
    public boolean isEmpty() {
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * From DISTRITO");
            return !rs.next();
        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        }
    }

    @Override
    public boolean containsKey(Object key) {
        try {
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM distrito WHERE id='" + (String) key + "'";
            ResultSet rs = stm.executeQuery(sql);
            return rs.next();
        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        }
    }

    public boolean existeCirculoEleitoral(String ce) {
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM distrito WHERE nome = '" + ce + "';");
            return (rs.next());
        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        }
    }

    public int hashCode() {
        return this.conn.hashCode();
    }

    @Override
    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CirculoEleitoral get(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void putAll(Map<? extends String, ? extends CirculoEleitoral> m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<String> keySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<CirculoEleitoral> values() {
        try {
            Collection<CirculoEleitoral> col = new HashSet<CirculoEleitoral>();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FORM Distrito");
            for (; rs.next();) {
                col.add(new CirculoEleitoral(rs.getString(1)));
            }
            return col;
        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        }

    }

    @Override
    public Set<Entry<String, CirculoEleitoral>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
