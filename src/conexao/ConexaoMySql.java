/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 17171000107
 */
public class ConexaoMySql {
    public static Connection conexao(){
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/VhCurso?useTimezone=true&serverTimezone=UTC";   
        String user = "root";
        String pass ="";
     
        
        
        try{
            Class.forName(driver);
            System.out.println("Driver carregado!");
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }
        //conectando ao banco de dados
        try {            
            Connection conexao =
               DriverManager.getConnection(url, user, pass);
            System.out.println("Conectado com sucesso!");
            //retorna a conexão ao BD
            return conexao;
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoMySql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;       
    }
    

}


