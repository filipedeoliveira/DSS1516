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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Filipe Oliveira
 */
public class CirculoEleitoralDAO  implements Map<String,CirculoEleitoral> {

    private Connection conn;

    public CirculoEleitoralDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public CirculoEleitoral put(CirculoEleitoral value) throws SQLException {
        CirculoEleitoral ce1 = null;
        Statement stm = conn.createStatement();
        String sql = "INSERT INTO distrito (nome)  VALUES (\"" + value.getNome() + "\");";
        int i = stm.executeUpdate(sql);
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

    public CirculoEleitoral remove(Object key){
        try
        {
            CirculoEleitoral ce = null;
            Statement stm = conn.createStatement();
            String sql = "DELETE FROM distrito WHERE nome = '"+key+"' ;";
            boolean it = stm.execute(sql);
            return new CirculoEleitoral ((String) key);
        }
        catch (Exception e) {e.printStackTrace();throw new NullPointerException(e.getMessage());
        }
        
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

    @Override
    public CirculoEleitoral get(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CirculoEleitoral put(String key, CirculoEleitoral value) {
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Entry<String, CirculoEleitoral>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
