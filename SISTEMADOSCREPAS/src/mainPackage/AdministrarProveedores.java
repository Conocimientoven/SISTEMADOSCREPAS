package mainPackage;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import static mainPackage.AdministrarUsuarios.pre;
import static mainPackage.IngresarAlSistema.conexion;
import java.sql.ResultSet;
import java.sql.Statement;
import static mainPackage.AdministrarUsuarios.res;
import static mainPackage.Conexion.establecido;

/**
 *
 * @author Success
 */
public class AdministrarProveedores extends javax.swing.JFrame {
public static Connection contacto = null;
public static boolean establecido;

   static ButtonGroup group = new ButtonGroup();
    static PreparedStatement pre;
    String var,var2;
    static ResultSet res, spaceUsed;
    static String testProviders[] = new String[4];
    
    
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
    
    public AdministrarProveedores() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        
        TextPrompt id = new TextPrompt("Id del proveedor", idTextField);
        id.changeAlpha(0.5f);
        id.changeStyle(Font.BOLD + Font.ITALIC);
        
        TextPrompt name  = new TextPrompt("Nombre del proveedor", nameTextField);
        name.changeAlpha(0.5f);
        name.changeStyle(Font.BOLD + Font.ITALIC);
        
        TextPrompt address  = new TextPrompt("Domicilio del proveedor", addressTextField);
        address.changeAlpha(0.5f);
        address.changeStyle(Font.BOLD + Font.ITALIC);
        
        TextPrompt telephone  = new TextPrompt("Telefóno del proveedor", telephoneTextField);
        telephone.changeAlpha(0.5f);
        telephone.changeStyle(Font.BOLD + Font.ITALIC);
        
    }

    
  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        mainPanel = new javax.swing.JPanel();
        idLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();
        telephoneLabel = new javax.swing.JLabel();
        idTextField = new javax.swing.JTextField();
        nameTextField = new javax.swing.JTextField();
        addressTextField = new javax.swing.JTextField();
        telephoneTextField = new javax.swing.JTextField();
        addRadioButton = new javax.swing.JRadioButton();
        modifyRadioButton = new javax.swing.JRadioButton();
        consultRadioButton = new javax.swing.JRadioButton();
        eraseRadioButton = new javax.swing.JRadioButton();
        mainLabel = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();
        acceptButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBackground(new java.awt.Color(255, 204, 0));
        mainPanel.setMaximumSize(new java.awt.Dimension(1000, 1000));

        idLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        idLabel.setText("ID:");

        nameLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        nameLabel.setText("Nombre:");

        addressLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        addressLabel.setText("Domicilio:");

        telephoneLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        telephoneLabel.setText("Teléfono:");

        idTextField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        idTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idTextFieldActionPerformed(evt);
            }
        });

        nameTextField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        nameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextFieldActionPerformed(evt);
            }
        });

        addressTextField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        addressTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressTextFieldActionPerformed(evt);
            }
        });

        telephoneTextField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        telephoneTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telephoneTextFieldActionPerformed(evt);
            }
        });

        addRadioButton.setBackground(new java.awt.Color(255, 204, 51));
        buttonGroup.add(addRadioButton);
        addRadioButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        addRadioButton.setText("Agregar");
        addRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRadioButtonActionPerformed(evt);
            }
        });

        modifyRadioButton.setBackground(new java.awt.Color(255, 204, 0));
        buttonGroup.add(modifyRadioButton);
        modifyRadioButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        modifyRadioButton.setText("Modificar");
        modifyRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyRadioButtonActionPerformed(evt);
            }
        });

        consultRadioButton.setBackground(new java.awt.Color(255, 204, 0));
        buttonGroup.add(consultRadioButton);
        consultRadioButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        consultRadioButton.setText("Consultar");
        consultRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultRadioButtonActionPerformed(evt);
            }
        });

        eraseRadioButton.setBackground(new java.awt.Color(255, 204, 0));
        buttonGroup.add(eraseRadioButton);
        eraseRadioButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        eraseRadioButton.setText("Eliminar");
        eraseRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eraseRadioButtonActionPerformed(evt);
            }
        });

        mainLabel.setBackground(new java.awt.Color(0, 0, 204));
        mainLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        mainLabel.setText("                          ADMINISTRAR PROVEEDORES");

        cancelButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        cancelButton.setText("Cancelar");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        acceptButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        acceptButton.setText("Aceptar");
        acceptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(mainLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE))
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                .addComponent(modifyRadioButton)
                                .addGap(78, 78, 78))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(addRadioButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(consultRadioButton)
                        .addGap(32, 32, 32)
                        .addComponent(eraseRadioButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameLabel)
                            .addComponent(addressLabel)
                            .addComponent(idLabel)
                            .addComponent(telephoneLabel))
                        .addGap(18, 18, 18)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(nameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                                .addComponent(addressTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(telephoneTextField))
                            .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(acceptButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(mainLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addGap(3, 3, 3)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addRadioButton)
                    .addComponent(modifyRadioButton)
                    .addComponent(consultRadioButton)
                    .addComponent(eraseRadioButton))
                .addGap(35, 35, 35)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLabel))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addressLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telephoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telephoneLabel))
                .addGap(41, 41, 41)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(acceptButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idTextFieldActionPerformed

    private void nameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextFieldActionPerformed

    private void addressTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressTextFieldActionPerformed

    private void telephoneTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telephoneTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telephoneTextFieldActionPerformed

    private void acceptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptButtonActionPerformed
        // TODO add your handling code here:
       

        try
        {
            
            conexion = Conexion.realizarConexion();
            if(addRadioButton.isSelected()){
       
                    /*pre=conexion.prepareStatement("INSERT INTO customers (customerID, customerName, customerGender, customerCity) VALUES(?,?,?,?)");*/

        pre=conexion.prepareStatement("insert into Proveedores (Id_proveedor, Nombre_proveedor, Domicilio_proveedor, Telefono_proveedor)values(?,?,?,?)");
        
        pre.setString(1,idTextField.getText());
        pre.setString(2,nameTextField.getText());
        pre.setString(3,addressTextField.getText());
        pre.setString(4,telephoneTextField.getText());
        pre.executeUpdate();
        
        JOptionPane.showMessageDialog(null, " Proveedor "+ nameTextField.getText()+" agregado correctamente a la base de datos  ");/*+String.valueOf(jComboBox1.getSelectedItem())+"es","",JOptionPane.PLAIN_MESSAGE);*/
        idTextField.setText("");
        nameTextField.setText("");
        addressTextField.setText("");
        telephoneTextField.setText("");
        }
            else if(modifyRadioButton.isSelected()){
                pre=conexion.prepareStatement("alter table Proveedores where Id_Proveedor =  (?,?,?,?)");

                pre.setString(1,idTextField.getText());
                pre.setString(2,nameTextField.getText());
                pre.setString(3,addressTextField.getText());
                pre.setString(4,telephoneTextField.getText());
                pre.executeUpdate();

                JOptionPane.showMessageDialog(null, "Los datos del proveedor:  "+nameTextField.getText()+" han sido modificados correctamente","",JOptionPane.PLAIN_MESSAGE);
                
                }
                       
                        
                else if(consultRadioButton.isSelected()){
                 res=Conexion.Consulta("execute consultUser");   
                 spaceUsed=Conexion.Consulta("execute getRowCount"); 

                 
                    while(res.next())
                    {

                        testProviders[0]=res.getString(1); //Id_Provedor
                        testProviders[1]=res.getString(2);  //Nombre_Proveedor
                        testProviders[2]=res.getString(3);  //Domicilio_Proveedor
                        testProviders[3]=res.getString(4);  //Teléfono_Proveedor
                        
                        if((idTextField.getText()).equals(testProviders[0]))
                        {
                            nameTextField.setText(testProviders[1]);
                            addressTextField.setText(testProviders[2]);
                            break;
                        }

                    }
                        }
                
                else if (eraseRadioButton.isSelected()){
                String name;
                name = nameTextField.getText();
                pre=conexion.prepareStatement("delete from Proveedores where Id_Proveedor = ?");
                pre.setString(1,idTextField.getText());
                pre.executeUpdate();
                JOptionPane.showMessageDialog(null, " Los datos del proveedor:  "+name+" han sido eliminados correctamente","",JOptionPane.PLAIN_MESSAGE);

                            
                        }
        }
        
        
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "ERROR"+e.getMessage());
        }   
        
        
    }//GEN-LAST:event_acceptButtonActionPerformed

    private void addRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRadioButtonActionPerformed
        // TODO add your handling code here:
        acceptButton.setVisible(true);
        nameLabel.setEnabled(true);
        nameTextField.setEnabled(true);
        addressLabel.setEnabled(true);
        addressTextField.setEnabled(true);
        telephoneLabel.setEnabled(true);
        telephoneTextField.setEnabled(true);
        
    }//GEN-LAST:event_addRadioButtonActionPerformed

    private void consultRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultRadioButtonActionPerformed
        // TODO add your handling code here:
        acceptButton.setVisible(false);
        idLabel.setEnabled(true);
        idTextField.setEnabled(true);
        nameLabel.setEnabled(false);
        nameTextField.setEnabled(false);
        addressLabel.setEnabled(false);
        addressTextField.setEnabled(false);
        telephoneLabel.setEnabled(false);
        telephoneTextField.setEnabled(false);
      
    }//GEN-LAST:event_consultRadioButtonActionPerformed

    private void modifyRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyRadioButtonActionPerformed
        acceptButton.setEnabled(true);
        idLabel.setEnabled(true);
        idTextField.setEnabled(true);
        nameLabel.setEnabled(true);
        nameTextField.setEnabled(true);
        addressLabel.setEnabled(true);
        addressTextField.setEnabled(true);
        telephoneLabel.setEnabled(true);
        telephoneTextField.setEnabled(true);
    }//GEN-LAST:event_modifyRadioButtonActionPerformed

    private void eraseRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eraseRadioButtonActionPerformed
        
        acceptButton.setEnabled(true);
        nameLabel.setEnabled(false);
        nameTextField.setEnabled(false);
        addressLabel.setEnabled(false);
        addressTextField.setEnabled(false);
        telephoneLabel.setEnabled(false);
        telephoneTextField.setEnabled(false);

    }//GEN-LAST:event_eraseRadioButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null," Operación cancelada ");
        InterfazAdministrador back = new InterfazAdministrador();
        back.setVisible(true);
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdministrarProveedores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceptButton;
    private javax.swing.JRadioButton addRadioButton;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JTextField addressTextField;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JButton cancelButton;
    private javax.swing.JRadioButton consultRadioButton;
    private javax.swing.JRadioButton eraseRadioButton;
    private javax.swing.JLabel idLabel;
    private javax.swing.JTextField idTextField;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JRadioButton modifyRadioButton;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JLabel telephoneLabel;
    private javax.swing.JTextField telephoneTextField;
    // End of variables declaration//GEN-END:variables
}
