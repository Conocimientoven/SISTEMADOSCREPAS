package mainPackage;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import static mainPackage.IngresarAlSistema.conexion;
import java.sql.ResultSet;

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
        //Para que se inicialicen desactivados
        eraseRadioButton.setEnabled(false); 
        modifyRadioButton.setEnabled(false);
        
        this.setLocationRelativeTo(null);
        
        
        TextPrompt id = new TextPrompt("Id del proveedor", idTextField);
        id.changeAlpha(0.5f);
        id.changeStyle(Font.BOLD + Font.ITALIC);
        
        TextPrompt name  = new TextPrompt("Nombre del proveedor", nameTextField);
        name.changeAlpha(0.5f);
        name.changeStyle(Font.BOLD + Font.ITALIC);
        
        TextPrompt cp  = new TextPrompt("Código postal ", cpTextField);
        cp.changeAlpha(0.5f);
        cp.changeStyle(Font.BOLD + Font.ITALIC);
        
        TextPrompt city  = new TextPrompt("Nombre de la ciudad", cityTextField);
        city.changeAlpha(0.5f);
        city.changeStyle(Font.BOLD + Font.ITALIC);
        
        TextPrompt colony  = new TextPrompt("Nombre de la colonia", colonyTextField);
        colony.changeAlpha(0.5f);
        colony.changeStyle(Font.BOLD + Font.ITALIC);
        
        TextPrompt street  = new TextPrompt("Nombre de la calle", streetTextField);
        street.changeAlpha(0.5f);
        street.changeStyle(Font.BOLD + Font.ITALIC);
        
        TextPrompt number  = new TextPrompt("Número de la calle", numberTextField);
        number.changeAlpha(0.5f);
        number.changeStyle(Font.BOLD + Font.ITALIC);
        
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
        cpLabel = new javax.swing.JLabel();
        telephoneLabel = new javax.swing.JLabel();
        idTextField = new javax.swing.JTextField();
        nameTextField = new javax.swing.JTextField();
        telephoneTextField = new javax.swing.JTextField();
        addRadioButton = new javax.swing.JRadioButton();
        modifyRadioButton = new javax.swing.JRadioButton();
        consultRadioButton = new javax.swing.JRadioButton();
        eraseRadioButton = new javax.swing.JRadioButton();
        mainLabel = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();
        acceptButton = new javax.swing.JButton();
        cpTextField = new javax.swing.JTextField();
        cityLabel = new javax.swing.JLabel();
        colonyLabel = new javax.swing.JLabel();
        cityTextField = new javax.swing.JTextField();
        streetTextField = new javax.swing.JTextField();
        streetLabel = new javax.swing.JLabel();
        colonyTextField = new javax.swing.JTextField();
        numberLabel = new javax.swing.JLabel();
        numberTextField = new javax.swing.JTextField();
        setButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        mainPanel.setMaximumSize(new java.awt.Dimension(1000, 1000));

        idLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        idLabel.setText("ID:");

        nameLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        nameLabel.setText("Nombre:");

        cpLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        cpLabel.setText("C.P.");

        telephoneLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        telephoneLabel.setText("Teléfono:");

        idTextField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        idTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idTextFieldActionPerformed(evt);
            }
        });
        idTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                idTextFieldKeyTyped(evt);
            }
        });

        nameTextField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        nameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextFieldActionPerformed(evt);
            }
        });
        nameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nameTextFieldKeyTyped(evt);
            }
        });

        telephoneTextField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        telephoneTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telephoneTextFieldActionPerformed(evt);
            }
        });
        telephoneTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telephoneTextFieldKeyTyped(evt);
            }
        });

        buttonGroup.add(addRadioButton);
        addRadioButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        addRadioButton.setText("Agregar");
        addRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup.add(modifyRadioButton);
        modifyRadioButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        modifyRadioButton.setText("Modificar");
        modifyRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup.add(consultRadioButton);
        consultRadioButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        consultRadioButton.setText("Consultar");
        consultRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup.add(eraseRadioButton);
        eraseRadioButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        eraseRadioButton.setText("Eliminar");
        eraseRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eraseRadioButtonActionPerformed(evt);
            }
        });

        mainLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        mainLabel.setText("                   ADMINISTRAR PROVEEDORES");

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

        cpTextField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cpTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cpTextFieldKeyTyped(evt);
            }
        });

        cityLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        cityLabel.setText("Ciudad:");

        colonyLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        colonyLabel.setText("Colonia:");

        cityTextField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cityTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cityTextFieldKeyTyped(evt);
            }
        });

        streetTextField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        streetTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                streetTextFieldActionPerformed(evt);
            }
        });
        streetTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                streetTextFieldKeyTyped(evt);
            }
        });

        streetLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        streetLabel.setText("Calle:");

        colonyTextField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        colonyTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                colonyTextFieldKeyTyped(evt);
            }
        });

        numberLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        numberLabel.setText("Número:");

        numberTextField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        numberTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numberTextFieldKeyTyped(evt);
            }
        });

        setButton.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        setButton.setText("Set");

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addComponent(mainLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(214, 214, 214))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(nameLabel)
                                .addGap(18, 18, 18)
                                .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainPanelLayout.createSequentialGroup()
                                    .addComponent(numberLabel)
                                    .addGap(18, 18, 18)
                                    .addComponent(numberTextField))
                                .addGroup(mainPanelLayout.createSequentialGroup()
                                    .addComponent(streetLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(streetTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(mainPanelLayout.createSequentialGroup()
                                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(colonyLabel)
                                        .addComponent(telephoneLabel)
                                        .addComponent(cpLabel)
                                        .addComponent(cityLabel))
                                    .addGap(11, 11, 11)
                                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                            .addComponent(cpTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(setButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(telephoneTextField)
                                        .addComponent(cityTextField)
                                        .addComponent(colonyTextField))))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(idLabel)
                                .addGap(71, 71, 71)
                                .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(208, 208, 208)
                                .addComponent(acceptButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addComponent(addRadioButton)
                        .addGap(28, 28, 28)
                        .addComponent(modifyRadioButton)
                        .addGap(18, 18, 18)
                        .addComponent(eraseRadioButton)
                        .addGap(18, 18, 18)
                        .addComponent(consultRadioButton)
                        .addGap(110, 110, 110))))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(mainLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addRadioButton)
                            .addComponent(modifyRadioButton))
                        .addGap(18, 18, 18)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idLabel)
                            .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(consultRadioButton)
                            .addComponent(eraseRadioButton))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telephoneLabel)
                    .addComponent(telephoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cpLabel)
                    .addComponent(cpTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(setButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cityLabel)
                    .addComponent(cityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(colonyLabel)
                    .addComponent(colonyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(streetLabel)
                    .addComponent(streetTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numberLabel)
                    .addComponent(numberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(acceptButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idTextFieldActionPerformed

    private void nameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextFieldActionPerformed

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
       
        pre.setString(4,telephoneTextField.getText());
        pre.executeUpdate();
        
        JOptionPane.showMessageDialog(null, " Proveedor "+ nameTextField.getText()+" agregado correctamente a la base de datos  ");/*+String.valueOf(jComboBox1.getSelectedItem())+"es","",JOptionPane.PLAIN_MESSAGE);*/
        idTextField.setText("");
        nameTextField.setText("");
        
        telephoneTextField.setText("");
        }
            else if(modifyRadioButton.isSelected()){
                pre=conexion.prepareStatement("alter table Proveedores where Id_Proveedor =  (?,?,?,?)");

                pre.setString(1,idTextField.getText());
                pre.setString(2,nameTextField.getText());
                
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
        numberTextField.setEnabled(true); //Faltaban unos de activarse
        numberLabel.setEnabled(true);
        setButton.setEnabled(true);
        acceptButton.setEnabled(true);
        cancelButton.setEnabled(true);
        nameLabel.setEnabled(true);
        nameTextField.setEnabled(true);
        telephoneLabel.setEnabled(true);
        telephoneTextField.setEnabled(true);
        cpLabel.setEnabled(true);
        cpTextField.setEnabled(true);
        cityLabel.setEnabled(true);
        cityTextField.setEnabled(true);
        colonyLabel.setEnabled(true);
        colonyTextField.setEnabled(true);
        streetLabel.setEnabled(true);
        streetTextField.setEnabled(true);
        eraseRadioButton.setEnabled(false);
        modifyRadioButton.setEnabled(false);
    }//GEN-LAST:event_addRadioButtonActionPerformed

    private void consultRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultRadioButtonActionPerformed
         
        //Todos los campos, exceptuando ID, se desactivan
        numberTextField.setEnabled(false);
        numberLabel.setEnabled(false);
        setButton.setEnabled(false);
        idLabel.setEnabled(true);
        idTextField.setEnabled(true);
        nameLabel.setEnabled(false);
        nameTextField.setEnabled(false);
        cpLabel.setEnabled(false);
        cpTextField.setEnabled(false);
        cityLabel.setEnabled(false);
        cityTextField.setEnabled(false);
        colonyLabel.setEnabled(false);
        colonyTextField.setEnabled(false);
        streetLabel.setEnabled(false);
        streetTextField.setEnabled(false);
        telephoneLabel.setEnabled(false);
        telephoneTextField.setEnabled(false);
      
    }//GEN-LAST:event_consultRadioButtonActionPerformed

    private void modifyRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyRadioButtonActionPerformed
        numberTextField.setEnabled(true);//Se activan todos los campos a excepción de la ID
        numberLabel.setEnabled(true);
        setButton.setEnabled(true);
        acceptButton.setEnabled(true);
        idLabel.setEnabled(false);//Una vez puesta la ID ya no es posible modificarla
        idTextField.setEnabled(false);
        nameLabel.setEnabled(true);
        nameTextField.setEnabled(true);
        cpLabel.setEnabled(true);
        cpTextField.setEnabled(true);
        cityLabel.setEnabled(true);
        cityTextField.setEnabled(true);
        colonyLabel.setEnabled(true);
        colonyTextField.setEnabled(true);
        streetLabel.setEnabled(true);
        streetTextField.setEnabled(true);
        eraseRadioButton.setEnabled(true);
        modifyRadioButton.setEnabled(true);
        telephoneLabel.setEnabled(true);
        telephoneTextField.setEnabled(true);
    }//GEN-LAST:event_modifyRadioButtonActionPerformed

    private void eraseRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eraseRadioButtonActionPerformed
        //Todos los campos, exceptuando ID, se desactivan
        numberTextField.setEnabled(false); 
        numberLabel.setEnabled(false);
        setButton.setEnabled(false);
        idLabel.setEnabled(true);
        idTextField.setEnabled(true);
        nameLabel.setEnabled(false);
        nameTextField.setEnabled(false);
        cpLabel.setEnabled(false);
        cpTextField.setEnabled(false);
        cityLabel.setEnabled(false);
        cityTextField.setEnabled(false);
        colonyLabel.setEnabled(false);
        colonyTextField.setEnabled(false);
        streetLabel.setEnabled(false);
        streetTextField.setEnabled(false);
        eraseRadioButton.setEnabled(false);
        modifyRadioButton.setEnabled(false);
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

    private void streetTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_streetTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_streetTextFieldActionPerformed

    private void idTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idTextFieldKeyTyped
        // TODO add your handling code here:
        char validator1 = evt.getKeyChar();
        if(idTextField.getText().length() == 8){
            evt.consume();
            JOptionPane.showMessageDialog(null,"Longitud de caracteres máxima alcanzada","Error",JOptionPane.ERROR_MESSAGE);
        }
        else if(Character.isLetter(validator1)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null," Introduce sólo números","Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_idTextFieldKeyTyped

    private void nameTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameTextFieldKeyTyped
        // TODO add your handling code here:
        char validator2 = evt.getKeyChar();
        if(nameTextField.getText().length() == 40){
            evt.consume();
            JOptionPane.showMessageDialog(null,"Longitud de caracteres máxima alcanzada","Error",JOptionPane.ERROR_MESSAGE);
        }
        else if(Character.isDigit(validator2)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null," Introduce sólo letras","Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_nameTextFieldKeyTyped

    private void cpTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cpTextFieldKeyTyped
        // TODO add your handling code here:
        char validator3 = evt.getKeyChar();
        if(cpTextField.getText().length() == 5){
            evt.consume();
            JOptionPane.showMessageDialog(null,"Longitud de caracteres máxima alcanzada","Error",JOptionPane.ERROR_MESSAGE);
        }
        else if(Character.isLetter(validator3)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null," Introduce sólo números","Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cpTextFieldKeyTyped

    private void cityTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cityTextFieldKeyTyped
        // TODO add your handling code here:
        char validator4 = evt.getKeyChar();
        if(cityTextField.getText().length() == 40){
            evt.consume();
            JOptionPane.showMessageDialog(null,"Longitud de caracteres máxima alcanzada","Error",JOptionPane.ERROR_MESSAGE);
        }
        else if(Character.isDigit(validator4)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null," Introduce sólo letras","Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cityTextFieldKeyTyped

    private void colonyTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_colonyTextFieldKeyTyped
        // TODO add your handling code here:
        char validator5 = evt.getKeyChar();
        if(colonyTextField.getText().length() == 40){
            evt.consume();
            JOptionPane.showMessageDialog(null,"Longitud de caracteres máxima alcanzada","Error",JOptionPane.ERROR_MESSAGE);
        }
        else if(Character.isDigit(validator5)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null," Introduce sólo letras","Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_colonyTextFieldKeyTyped

    private void streetTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_streetTextFieldKeyTyped
        // TODO add your handling code here:
        if(streetTextField.getText().length() == 40){
            evt.consume();
            JOptionPane.showMessageDialog(null,"Longitud de caracteres máxima alcanzada","Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_streetTextFieldKeyTyped

    private void numberTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numberTextFieldKeyTyped
        // TODO add your handling code here:
        char validator6 = evt.getKeyChar();
        if(numberTextField.getText().length() == 4){
            evt.consume();
            JOptionPane.showMessageDialog(null,"Longitud de caracteres máxima alcanzada","Error",JOptionPane.ERROR_MESSAGE);
        }
        else if(Character.isLetter(validator6)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null," Introduce sólo números","Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_numberTextFieldKeyTyped

    private void telephoneTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telephoneTextFieldKeyTyped
        // TODO add your handling code here:
        char validator7 = evt.getKeyChar();
        if(telephoneTextField.getText().length() == 10){
            evt.consume();
            JOptionPane.showMessageDialog(null,"Longitud de caracteres máxima alcanzada","Error",JOptionPane.ERROR_MESSAGE);
        }
        else if(Character.isLetter(validator7)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"Introduce sólo números","Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_telephoneTextFieldKeyTyped

    
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
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel cityLabel;
    private javax.swing.JTextField cityTextField;
    private javax.swing.JLabel colonyLabel;
    private javax.swing.JTextField colonyTextField;
    private javax.swing.JRadioButton consultRadioButton;
    private javax.swing.JLabel cpLabel;
    private javax.swing.JTextField cpTextField;
    private javax.swing.JRadioButton eraseRadioButton;
    private javax.swing.JLabel idLabel;
    private javax.swing.JTextField idTextField;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JRadioButton modifyRadioButton;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JLabel numberLabel;
    private javax.swing.JTextField numberTextField;
    private javax.swing.JButton setButton;
    private javax.swing.JLabel streetLabel;
    private javax.swing.JTextField streetTextField;
    private javax.swing.JLabel telephoneLabel;
    private javax.swing.JTextField telephoneTextField;
    // End of variables declaration//GEN-END:variables
}
