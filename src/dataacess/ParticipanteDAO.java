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

/**
 *
 * @author Filipe Oliveira
 */
public class ParticipanteDAO {
    /*
    private Connection conn;

    public ListaDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
        } catch (ClassNotFoundException | SQLException l) {
            l.printStackTrace();
        }
    }
    */
    private Connection conn;
    
    public ParticipanteDAO(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dss", "root", "Filipe_94");
        }
        catch(ClassNotFoundException | SQLException p){
            p.printStackTrace();
        }
    }
    public Participante put(Participante value) throws SQLException {
        Participante p = null;
        Statement stm = conn.createStatement();
        String sql = "INSERT INTO participantes (idParticipante, nomeParticipante, posicaoParticipante, listaIdLista) VALUES (\"" + value.getIdParticipante() + "\",\"" + value.getNomeParticipante() + "\",\"" + value.getPosicaoParticipante() + "\",\"" + value.getListaIdLista() + "\");";
        int i = stm.executeUpdate(sql);
        return new Participante();

    }
    
}
