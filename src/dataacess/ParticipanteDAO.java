/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataacess;

import business.Lista;
import business.Participante;
import java.sql.Connection;
import java.sql.DriverManager;
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
public class ParticipanteDAO implements Map<String, Participante> {

    private Connection conn;

    public ParticipanteDAO() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
            //this.conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss","root","leicam");
        } catch (ClassNotFoundException | SQLException p) {
            p.printStackTrace();
        } finally {
            conn.close();
        }
    }

    public Participante put(String nomeParticipante, Participante value) {
        Participante p = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
            //this.conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss","root","leicam");
            Statement stm = conn.createStatement();
            String sql = "INSERT INTO participantes (nomeEleitor, posicao, Lista_idLista) VALUES (\"" + value.getNomeParticipante() + "\",\"" + value.getPosicaoParticipante() + "\",\"" + value.getListaIdLista() + "\");";
            int i = stm.executeUpdate(sql);
            return new Participante();

        } catch (Exception e) {
            e.printStackTrace();
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
    public Participante get(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Participante remove(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String removeAll(Object key) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
            //this.conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss","root","leicam");
            Statement stm = conn.createStatement();
            String sql = "DELETE FROM participantes WHERE TipoEleicao = '" + (String) key + "';";
            boolean i = stm.execute(sql);
            return (String) key;
        } catch (Exception e) {
            throw new UnsupportedOperationException("Not supported yet.");
        } finally {
            conn.close();
        }
    }

    public void removeTodosPartido(int id) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
            //this.conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss","root","leicam");
            Statement stm = conn.createStatement();
            String sql = "DELETE FROM participantes WHERE Lista_idLista = '" + id + "';";
            int i = stm.executeUpdate(sql);

        } catch (Exception e) {
        } finally {
            conn.close();
        }
    }

    @Override
    public void putAll(Map<? extends String, ? extends Participante> m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
            //this.conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss","root","leicam");
            Statement stm = conn.createStatement();
            String sql = "DELETE FROM participantes;";
            boolean i = stm.execute(sql);
        } catch (Exception e) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
        finally{try {
            conn.close();
            } catch (SQLException ex) {
                throw new NullPointerException(ex.getMessage());
            }
}
    }

    @Override
    public Set<String> keySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Participante> values() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Entry<String, Participante>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
