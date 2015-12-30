/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataacess;

import business.Eleitor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 
 */
public class EleitorDAO implements Map<String, Eleitor> {

    private Connection conn;

    public EleitorDAO() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
            //this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "leicam");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
    }

    public String inserirPass(String pass, int cc) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
        //this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "leicam");
        Statement stm = conn.createStatement();
        String sql = "UPDATE ELEITOR SET password = '" + (String) pass + "' where numCC = " + (int) cc + ";";
        //String sql = "UPDATE eleitor SET password= "+pass+" WHERE numCC= "+cc+";";
        int i = stm.executeUpdate(sql);
        conn.close();
        return pass;
    }

    public Eleitor put(String nome, Eleitor value) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
            //this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "leicam");
            Eleitor e = null;
            Statement stm = conn.createStatement();
            String sql = "INSERT INTO eleitor (nome, numCC, morada, Distrito_idDistrito) VALUES (\"" + value.getNomeEleitor() + "\",\"" + value.getNumCC() + "\",\"" + value.getMorada() + "\",\"" + value.getidDistrito() + "\");";
            int i = stm.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                throw new NullPointerException(ex.getMessage());
            }
        }
        return new Eleitor(value.getNumEleitor(), value.getNomeEleitor(), value.getNumCC(), value.getMorada(), value.getidDistrito());
    }

    @Override
    public int size() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
            //this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "leicam");
            int contador = 0;
            Statement stm = conn.createStatement();
            ResultSet i = stm.executeQuery("SELECT * FROM Eleitor");
            for (; i.next(); contador++);
            return contador;

        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                throw new NullPointerException(ex.getMessage());
            }
        }
    }

    @Override
    public boolean isEmpty() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
            //this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "leicam");
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * From Eleitor");
            return !rs.next();
        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        }
    }

    @Override
    public boolean containsKey(Object key) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
            //this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "leicam");
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM Eleitor WHERE numCC='" + (int) key + "'";
            ResultSet rs = stm.executeQuery(sql);
            return rs.next();   
        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                throw new NullPointerException(ex.getMessage());
            }
        }
    }

    @Override
    public boolean containsValue(Object value) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
            //this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "leicam");
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM Eleitor WHERE nome = '" + value + "';");
            return (rs.next());
        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                throw new NullPointerException(ex.getMessage());
            }
        }
    }

    public boolean existeEleitorNE(int ne) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
            //this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "leicam");
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM Eleitor WHERE numEleitor = '" + ne + "';");
            return (rs.next());
        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        } finally {
            conn.close();
        }

    }

    public boolean existePass(String pass, int ne) throws SQLException {
        String password = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
            //this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "leicam");
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM Eleitor WHERE numEleitor = '" + ne + "';");
            if (rs.next()) {
                password = rs.getString("Password");

            }
        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        } finally {
            conn.close();
        }

        return (password.equals(pass));
    }

    public int getNumEleitor(int cc) throws SQLException {
        int res = -1;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
            //this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "leicam");
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM Eleitor WHERE numCC = '" + cc + "';");
            if (rs.next()) {
                res = rs.getInt("numEleitor");
            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            conn.close();
        }
        return res;
    }

    @Override
    public Eleitor get(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Eleitor remove(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void putAll(Map<? extends String, ? extends Eleitor> m) {
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
    public Collection<Eleitor> values() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Entry<String, Eleitor>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
