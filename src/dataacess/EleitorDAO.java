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

/**
 *
 * @author Filipe Oliveira
 */
public class EleitorDAO {

    private Connection conn;

    public EleitorDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    public String inserirPass(String pass, int cc) throws SQLException{
        Statement stm = conn.createStatement();
        String sql = "UPDATE ELEITOR SET password = '"+(String) pass+"' where numCC = "+(int) cc+";";
        //String sql = "UPDATE eleitor SET password= "+pass+" WHERE numCC= "+cc+";";
        int i = stm.executeUpdate(sql);
        return pass;
    }

    public Eleitor put(Eleitor value) throws SQLException {
        Eleitor e = null;
        Statement stm = conn.createStatement();
        String sql = "INSERT INTO eleitor (nome, numCC, morada, Distrito_idDistrito) VALUES (\"" + value.getNomeEleitor() + "\",\"" + value.getNumCC() + "\",\"" + value.getMorada() + "\",\"" + value.getidDistrito() + "\");";
        int i = stm.executeUpdate(sql);
        System.out.println("a tua prima2");
        return new Eleitor(value.getNumEleitor(), value.getNomeEleitor(), value.getNumCC(),value.getMorada(), value.getidDistrito());

    }
}

