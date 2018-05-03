/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mainPackage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import static mainPackage.AdministrarProveedores.pre;
import static mainPackage.AdministrarProveedores.res;
import static mainPackage.AdministrarProveedores.testProviders;
import static mainPackage.IngresarAlSistema.conexion;

/**
 *
 * @author yagami
 */
public class Operaciones {
    
    Conexion conexion =new Conexion();
    ResultSet res;
    Statement st;

    public DefaultComboBoxModel getLista(String cadenaEscrita){

        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try { 
            res = (ResultSet) conexion.Consulta("SELECT Nombre_Usuario FROM Usuarios WHERE Nombre_Usuario LIKE '["+cadenaEscrita+"]%'");
            
            while (res.next()) {
                modelo.addElement(res.getString("Nombre_Usuario"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }

     return modelo;

    }
    

    public String[] buscar(String nombre){

        String[] datos = new String[4];
        try {

            String query = "SELECT Nombre_Usuario FROM Usuarios WHERE Nombre_Usuario LIKE '["+nombre+"]%'";
            conexion = (Conexion) Conexion.realizarConexion();
            res = (ResultSet) conexion.Consulta(query);
            while (res.next()) {
                for (int i = 0; i < datos.length; i++) {
                    datos[i] = res.getString(i + 1);
                }
            }
        } catch (SQLException ex) {
            return null;
        }
        return datos;
    }
    
      public DefaultComboBoxModel getListaProveedores(String cadenaEscrita){

        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try { 
                res = (ResultSet) conexion.Consulta("SELECT Nombre_Proveedor FROM Proveedores WHERE Nombre_Proveedor LIKE '["+cadenaEscrita+"]%'");
              //res = (ResultSet) conexion.Consulta("call searchByName '" +cadenaEscrita+"'");
              //res=Conexion.Consulta("execute searchByName '"+cadenaEscrita+"'");   


            while (res.next()) {
                modelo.addElement(res.getString("Nombre_Proveedor"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }

     return modelo;

    }
    
    public String[] buscarProveedores(String nombre){

        String[] datos = new String[8];
        try {
             //String query = "execute searchByName '"+nombre+"'";  
            //String query = "call sarchByName '"+nombre+"'";
            String query = "SELECT Nombre_Proveedor FROM Proveedores WHERE Nombre_Proveedor LIKE '["+nombre+"]%'";
            conexion = (Conexion) Conexion.realizarConexion();
            res = (ResultSet) conexion.Consulta(query);
            //res=Conexion.Consulta(query);  
            while (res.next()) {
                /*for (int i = 0; i < datos.length; i++) {
                    datos[i] = res.getString(i + 1);
                }*/
                
                datos [0] = res.getString(1);
                datos [1] = res.getString(2);
                datos [2] = res.getString(3);
                datos [3] = res.getString(4);
                datos [4] = res.getString(5);
                datos [5] = res.getString(6);
                datos [6] = res.getString(7);
                datos [7] = res.getString(8);
                
            }
        } catch (SQLException ex) {
            return null;
        }
        return datos;
    }

}
