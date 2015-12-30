/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataacess;

import business.CirculoEleitoral;
import business.Eleitor;
import business.Resultados;
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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Filipe Oliveira
 */
public class CirculoEleitoralDAO implements Map<String, CirculoEleitoral> {

    private Connection conn;

    public CirculoEleitoralDAO() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
            //this.conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss","root","leicam");
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
        return new CirculoEleitoral(value.getIdDistrito(), value.getNome());

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
            CirculoEleitoral ce = this.get(key);
            Statement stm = conn.createStatement();
            String sql = "DELETE FROM distrito WHERE nome = '" + (String) key + "' ;";
            boolean i = stm.execute(sql);
            return ce;
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
            return contador;

        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
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

    public boolean existeCirculoEleitoral(String ce) throws SQLException {
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
        try {
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM Distrito WHERE nome='" + (String) value + "'";
            ResultSet rs = stm.executeQuery(sql);
            return rs.next();
        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        } 
    }

    @Override
    public CirculoEleitoral get(Object key) {
        CirculoEleitoral ce = null;
        try {
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM Distrito WHERE nome='" + (String) key + "'";
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) {
                ce = new CirculoEleitoral(rs.getInt(1), rs.getString(2));
            }
        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        }
        return ce;
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
                col.add(new CirculoEleitoral(rs.getInt(1), rs.getString(2)));
            }
            return col;
        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        }
    }

    public int getID(String distrito) {
        try {
            CirculoEleitoral ce = this.get(distrito);
            int id = ce.getIdDistrito();
            return id;
        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        }

    }

    @Override
    public Set<Entry<String, CirculoEleitoral>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
