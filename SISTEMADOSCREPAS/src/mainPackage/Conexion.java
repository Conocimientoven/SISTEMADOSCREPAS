/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Success
 */
public class Conexion {
    
 
    public static Connection contacto = null;
    
    public static boolean establecido;
        
    
    public static Connection realizarConexion()
    {
	try{
		Connection co;
		co=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=SDCDB;","sa","sa");
		establecido=true;
                return co;
                
	}catch(SQLException ex){
		 JOptionPane.showMessageDialog(null,ex.getMessage());
		establecido=false;
                 return null;
	}
    }
    public static Connection realizarConexionMaster()
    {
	try{
		Connection co;
		co=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=master;","sa","sa");
		establecido=true;
                return co;
                
	}catch(SQLException ex){
		 JOptionPane.showMessageDialog(null,ex.getMessage());
		establecido=false;
                 return null;
	}
    }
    
    
    public static Connection getConexion(){
            
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
            //JOptionPane.showMessageDialog(null, "El driver existe");
        } catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "Cannot stablish connection..."+e.getMessage());
        }
        try{
            contacto = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=SDCDB;", "sa", "sa");
            //JOptionPane.showMessageDialog(null, "Connection establecida");
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error de acceso");
        }
        return contacto;
    }

    public static ResultSet Consulta(String consulta){
        Connection con = getConexion();
        Statement declara;
        try{
            declara = con.createStatement();
            ResultSet respuesta = declara.executeQuery(consulta);
            return respuesta;
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null,"Error de consulta");
            return null;
        }
    }
}

