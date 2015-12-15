/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataacess;

import business.Eleicao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Filipe Oliveira
 */
public class EleicaoDAO {

    private Connection conn;

    public EleicaoDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Eleicao put(Eleicao value) throws SQLException {
        Eleicao e = null;
        Statement stm = conn.createStatement();
        String sql = "INSERT INTO eleicao (nEleicao, tipo, dataEncerramento, estado) VALUES (\"" + value.getNumeroEleicao()+ "\",\"" + value.getTipoEleicao() + "\",\"" + value.getDataEncerramento() + "\",\"" + value.getEstado() + "\");";
        int i = stm.executeUpdate(sql);
        return new Eleicao();

    }

}
