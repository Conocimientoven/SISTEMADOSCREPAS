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

}
