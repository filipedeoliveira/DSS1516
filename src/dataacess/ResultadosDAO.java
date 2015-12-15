/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataacess;

import business.Eleicao;
import business.Resultados;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Filipe Oliveira
 */
public class ResultadosDAO {

    private Connection conn;

    public ResultadosDAO() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
        } catch (ClassNotFoundException | SQLException r) {
            r.printStackTrace();
        }
    }
     public Resultados put (Resultados value) throws SQLException{
        Resultados e = null;
        Statement stm = conn.createStatement();
        String sql = "INSERT INTO resultados (idResultados, participantes) VALUES (\""+value.getIdResultados()+"\",\""+value.getParticipante()+"\");";
        int i = stm.executeUpdate(sql);
        return new Resultados();
    
    } 

}
