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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Filipe Oliveira
 */
public class EleicaoDAO implements Map<String, Eleicao> {

    private Connection conn;

    public EleicaoDAO() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
            //this.conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss","root","leicam");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } 
    }

    public Eleicao put(String tipo, Eleicao value) {
        Eleicao e = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
            //this.conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss","root","leicam");
            Statement stm = conn.createStatement();
            String sql = "INSERT INTO eleicao (nEleicao, tipo, dataEncerramento, estado) VALUES (\"" + value.getNumeroEleicao() + "\",\"" + value.getTipoEleicao() + "\",\"" + value.getData() + "\",\"" + value.getEstado() + "\");";
            int i = stm.executeUpdate(sql);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        finally{try {
            conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(EleicaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
}
        return new Eleicao();

    }

    public void terminaEleicaoPresidencial() throws SQLException {
        Eleicao e = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
            //this.conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss","root","leicam");
            Statement stm = conn.createStatement();
            String sql = "UPDATE eleicao SET estado='Terminado' WHERE nEleicao>=1 AND nEleicao<5000";
            int i = stm.executeUpdate(sql);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        finally{conn.close();}

    }

    public void terminaEleicaoAssembleia() throws SQLException {
        Eleicao e = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
            //this.conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss","root","leicam");
            Statement stm = conn.createStatement();
            String sql = "UPDATE eleicao SET estado='Terminado' WHERE nEleicao>=5000";
            int i = stm.executeUpdate(sql);
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        finally{conn.close();}

    }

    public Eleicao alterarEstado(Object key) throws SQLException {
        try {Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
            //this.conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss","root","leicam");
            Eleicao el = this.get(key);
            Statement stm = conn.createStatement();
            String sql = "UPDATE eleicao SET estado='Terminado' WHERE tipo = '" + (String) key + "';";
            int i = stm.executeUpdate(sql);
            return el;
        } catch (Exception e) {
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        } 
        finally{conn.close();}
    }

    @Override
    public int size() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
            //this.conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss","root","leicam");
            int contador = 0;
            Statement stm = conn.createStatement();
            ResultSet i = stm.executeQuery("SELECT * FROM Eleicao");
            for (; i.next(); contador++);
            return contador;

        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        } 
        finally{try {
            conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(EleicaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
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
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
            //this.conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss","root","leicam");
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM Eleicao WHERE tipo='" + (String) value + "'";
            ResultSet rs = stm.executeQuery(sql);
            return rs.next();
        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        }
        finally{try {
            conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(EleicaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
}
    }

    public int getIdEleicao(String tipo) throws SQLException {
        int i = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
            //this.conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss","root","leicam");
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM eleicao WHERE tipo = '" + (String) tipo + "' AND estado = 'Decorrer' ;";
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) {
                i = rs.getInt(1);
            }
        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        }
        finally{conn.close();}
        return i;

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
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
            //this.conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss","root","leicam");
            Eleicao el = this.get(key);
            Statement stm = conn.createStatement();
            String sql = "DELETE FROM Eleicao WHERE tipo = '" + (String) key + "' ;";
            boolean i = stm.execute(sql);
            return el;
        } catch (Exception e) {
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        finally{try {
            conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(EleicaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
}
    }

    public ArrayList<String> getPresidenciais() throws SQLException {
        ArrayList<String> res = new ArrayList<String>();
        String est = "Decorrer";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
            //this.conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss","root","leicam");
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM Eleicao WHERE estado='" + est + "'";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String aux = rs.getString("tipo");
                res.add(aux);

            }
        } catch (Exception e) {
        } 
        finally{conn.close();}
        return res;
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
