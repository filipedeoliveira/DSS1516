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

/**
 *
 * @author Filipe Oliveira
 */
public class CirculoEleitoralDAO {
    private Connection conn;
    
    public CirculoEleitoralDAO (){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss","root","Filipe_94");
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    public CirculoEleitoral put (CirculoEleitoral value) throws SQLException{
        CirculoEleitoral ce1 = null;
        Statement stm = conn.createStatement();
        String sql = "INSERT INTO distrito (idDISTRITO, nome)  VALUES (\""+value.getIdDistrito()+"\", \""+value.getNome()+"\");";
        int i = stm.executeUpdate(sql);
        return new CirculoEleitoral (value.getIdDistrito(), value.getNome());
        
    }
    
    
}
