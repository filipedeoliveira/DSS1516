package dataacess;

import business.CirculoEleitoral;
import business.Eleicao;
import business.Lista;
import business.Resultados;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 
 */
public class ResultadosDAO implements Map<String, Resultados> {

    private Connection conn;

    public ResultadosDAO() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
            //this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
        } catch (ClassNotFoundException | SQLException r) {
            r.printStackTrace();
        } finally {
            conn.close();
        }
    }

    public Resultados put(String participante, Resultados value) {
        Resultados e = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
            //this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
            Statement stm = conn.createStatement();
            String sql = "INSERT INTO resultados (participante,votos, deputados, TipoEleicao) VALUES (\"" + value.getParticipante() + "\",\"" + value.getVotos() + "\",\"" + value.getDeputados() + "\",\"" + value.getTipoEleicao() + "\");";
            int i = stm.executeUpdate(sql);
        } catch (Exception r) {
            r.printStackTrace();

        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                throw new NullPointerException(ex.getMessage());
            }
        }
        return new Resultados();
    }

    @Override
    public int size() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
            //this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
            int contador = 0;
            Statement stm = conn.createStatement();
            ResultSet i = stm.executeQuery("SELECT * FROM resultados");
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
            //this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * From resultados");
            return !rs.next();
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
    public boolean containsKey(Object key) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
            //this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM resultados WHERE id='" + (String) key + "'";
            ResultSet rs = stm.executeQuery(sql);
            return rs.next();
        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ResultadosDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public boolean containsValue(Object value) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
            //this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM resultados WHERE participante='" + (String) value + "'";
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
    public Resultados get(Object key) {
        Resultados res = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
            //this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM Resultados WHERE id='" + (String) key + "'";
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) {
                res = new Resultados(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5));
            }
        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ResultadosDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return res;
    }

    @Override
    public Resultados remove(Object key) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            //this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
            //this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
            Resultados r = this.get(key);
            Statement stm = conn.createStatement();
            String sql = "DELETE FROM resultados WHERE participante = '" + (String) key + "' ;";
            boolean i = stm.execute(sql);
            return r;
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

    public String removeAll(Object key) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
            //this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
            Statement stm = conn.createStatement();
            String sql = "DELETE FROM resultados WHERE TipoEleicao = '" + (String) key + "';";
            boolean i = stm.execute(sql);
            return ((String) key);
        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        } finally {
            conn.close();
        }
    }

    @Override
    public void putAll(Map<? extends String, ? extends Resultados> m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
            //this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
            Statement stm = conn.createStatement();
            String sql = "DELETE FROM resultados;";
            int i = stm.executeUpdate(sql);

        } catch (Exception e) {
        } finally {
            try {
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
    public Collection<Resultados> values() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
            //this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
            Collection<Resultados> res = new HashSet<Resultados>();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FORM Resultados");
            for (; rs.next();) {
                // res.add(new Resultados(rs.getInt(1), rs.getString(2)));
            }
            return res;
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

    public void updateVotos(String nomeVoto, String tipoEleicao) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
            //this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
            Statement stm = conn.createStatement();
            String sql = "Update resultados SET votos = votos + 1 WHERE participante = '" + nomeVoto + "';";
            int i = stm.executeUpdate(sql);
        } catch (Exception e) {
        } finally {
            conn.close();
        }
    }

    public ArrayList<String> verResultadosPres() throws SQLException {
        ArrayList<String> res = new ArrayList<String>();
        String tipo = "Presidêncial";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
            //this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM Resultados WHERE TipoEleicao ='" + tipo + "';";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String aux = rs.getString("participante");
                res.add(aux);

            }
        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        } finally {
            conn.close();
        }
        return res;
    }

    public ArrayList<String> verVotosbdPres() throws SQLException {
        ArrayList<String> res = new ArrayList<String>();
        String tipo = "Presidêncial";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
            //this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM Resultados WHERE TipoEleicao ='" + tipo + "';";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String aux = rs.getString("votos");
                res.add(aux);

            }
        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        } finally {
            conn.close();
        }
        return res;
    }

    public ArrayList<String> verResultadosAss() throws SQLException {
        ArrayList<String> res = new ArrayList<String>();
        String tipo = "Assembleia";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
            //this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM Resultados WHERE TipoEleicao ='" + tipo + "';";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String aux = rs.getString("participante");
                res.add(aux);

            }
        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        } finally {
            conn.close();
        }
        return res;
    }

    public ArrayList<String> verVotosbdAss() throws SQLException {
        ArrayList<String> res = new ArrayList<String>();
        String tipo = "Assembleia";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
            //this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM Resultados WHERE TipoEleicao ='" + tipo + "';";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String aux = rs.getString("votos");
                res.add(aux);

            }
        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        } finally {
            conn.close();
        }
        return res;
    }

    public ArrayList<String> verDeputados() throws SQLException {
        ArrayList<String> res = new ArrayList<String>();
        String tipo = "Assembleia";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
            //this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM Resultados WHERE TipoEleicao ='" + tipo + "';";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String aux = rs.getString("deputados");
                res.add(aux);

            }
        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        } finally {
            conn.close();
        }
        return res;
    }

    public int totalVotos() throws SQLException, ClassNotFoundException {
        int i = 0;
        String tipo = "Assembleia";
        Class.forName("com.mysql.jdbc.Driver");
        this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
        //this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
        Statement stm = conn.createStatement();
        String sql = "SELECT * FROM Resultados WHERE TipoEleicao = '" + tipo + "';";
        ResultSet rs = stm.executeQuery(sql);
        while (rs.next()) {
            i = i + rs.getInt(3);
        }
        conn.close();
        return i;
    }

    public void updateDeputados(int qe) throws SQLException, ClassNotFoundException { // QE = quoeficiente eleitoral

        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
            //this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
            Statement stm = conn.createStatement();
            String sql = "UPDATE resultados SET deputados = FLOOR(votos / '" + qe + "') ;";
            int i = stm.executeUpdate(sql);
        } catch (SQLException ex) {
        } finally {
            conn.close();
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