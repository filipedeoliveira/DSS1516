/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataacess;

import business.Lista;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Filipe Oliveira
 */
public class ListaDAO {

    private Connection conn;

    public ListaDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
        } catch (ClassNotFoundException | SQLException l) {
            l.printStackTrace();
        }
    }

    public Lista put(Lista value) throws SQLException {
        Lista l = null;
        Statement stm = conn.createStatement();
        String sql = "INSERT INTO lista (idLista, nomeLista, tipo, numEleicaoParticipa) VALUES (\"" + value.getIdLista() + "\",\"" + value.getNomeLista() + "\",\"" + value.getTipoLista() + "\",\"" + value.getNumEleicaoParticipa() + "\");";
        int i = stm.executeUpdate(sql);
        return new Lista();

    }

}
