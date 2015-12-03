/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataacess;

import business.Eleitor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Filipe Oliveira
 */
public class EleitorDAO {
    
     public Connection conn;
    
    public EleitorDAO (){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss","root","Filipe_94");
        }
        catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
        }
    
    }
    
    
    public Eleitor put (Eleitor value) throws SQLException{
       
            Eleitor a1 = null;
            Statement stm = conn.createStatement();
            int x = Integer.parseInt(value.getCC());
            String sql = "INSERT INTO ELEITORES  (CC, NOME, MORADA, FREGUESIA, P_NOME) VALUES (\""+x+"\",\""+value.getNome()+"\",\""+value.getMorada()+"\",\""+value.getFreguesia()+"\",\""+value.getP_Nome()+"\");";
            int i = stm.executeUpdate(sql);
            return new Eleitor (value.getCC(),value.getNome(),value.getMorada(),value.getFreguesia(),value.getP_Nome());
        
    }
    
}
 
