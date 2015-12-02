/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataacess;

import business.*;
import java.util.Map;
import java.util.Set;
import java.util.Collection;
import java.util.HashSet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Filipe Oliveira
 */
public class CadidaturaDAO {
    
    public Connection conn;
    
    public CadidaturaDAO (){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/habitat","root","root");
        }
        catch (ClassNotFoundException | SQLException e) {}
     }
    
    
    
}
