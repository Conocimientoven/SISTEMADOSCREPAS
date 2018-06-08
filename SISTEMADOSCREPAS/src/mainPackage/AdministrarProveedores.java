package mainPackage;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import static mainPackage.IngresarAlSistema.conexion;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import static mainPackage.AdministrarUsuarios.tableSizeComparator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Ramón
 */
public class AdministrarProveedores extends javax.swing.JFrame {
    
    

    public static Connection contacto = null;
    public static boolean establecido;
    static int counter = 0, counter2 = 0;
    DefaultTableModel model;
    Operaciones operacion = new Operaciones();
    DefaultComboBoxModel comboBoxModel =  new DefaultComboBoxModel();
    static ButtonGroup group = new ButtonGroup();
    static int tableSize = 0, tableSixeComparation = 0;
    static PreparedStatement pre;
    String var,var2;
    static ResultSet res, spaceUsed;
    static String testProviders[] = new String[9];
    static String testProvidersPostalCode[] = new String[4];
    
    
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
        //setIconImage(new ImageIcon(getClass().getResource("SISTEMADOSCREPAS/cre.jpg")).getImage());
        
        
        
                nameComboBox.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
             
         public void keyReleased(KeyEvent evt) {
                
                if(nameRadioButton.isSelected())
                {
                String cadenaEscrita = nameComboBox.getEditor().getItem().toString();

                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                   if(comparar(cadenaEscrita)){// compara si el texto escrito se ecuentra en la lista
                       // busca el texto escrito en la base de datos
                       buscarProveedores(cadenaEscrita);
                   }else{// en caso contrario toma como default el elemento 0 o sea el primero de la lista y lo busca.
                    buscarProveedores(nameComboBox.getItemAt(0).toString());
                    nameComboBox.setSelectedIndex(0);
                    }
                }


                if (evt.getKeyCode() >= 65 && evt.getKeyCode() <= 90 || evt.getKeyCode() >= 96 && evt.getKeyCode() <= 105 || evt.getKeyCode() == 8) {
                    nameComboBox.setModel(operacion.getListaProveedores(cadenaEscrita));
                    if (nameComboBox.getItemCount() > 0) {
                        nameComboBox.getEditor().setItem(cadenaEscrita);
                        nameComboBox.showPopup();                     

                    } else {
                        nameComboBox.addItem(cadenaEscrita);
                    }
                }
            }
            }
        });
        
        
        //Para que se inicialicen desactivados
        
        
         ImageIcon crepasLogotype = new ImageIcon("images/cre.jpg");
         ImageIcon proverdorLogotype = new ImageIcon("images/pro.jpg");
         Icon icono = new ImageIcon(crepasLogotype.getImage().getScaledInstance(lblFondo.getWidth(), lblFondo.getHeight(), Image.SCALE_DEFAULT));
         Icon iconito = new ImageIcon(proverdorLogotype.getImage().getScaledInstance(lblFondito.getWidth(), lblFondito.getHeight(), Image.SCALE_DEFAULT));
         lblFondito.setIcon(iconito);
         lblFondo.setIcon(icono);
         this.repaint();
        
        
        eraseRadioButton.setEnabled(false); 
        modifyRadioButton.setEnabled(false);
        idRadioButton.setEnabled(false);
        nameRadioButton.setEnabled(false);
        nameComboBox.setEnabled(false);
        idTextField.setEnabled(false);
        telephoneTextField.setEnabled(false);
        cpTextField.setEnabled(false);
        setButton.setEnabled(false);
        calisComboBox.setEnabled(false);
        municipalityTextField.setEnabled(false);
        stateTextField.setEnabled(false);
        streetTextField.setEnabled(false);
        numberTextField.setEnabled(false);
        acceptButton.setEnabled(false);
        cancelButton.setEnabled(false);
        this.setLocationRelativeTo(null);
        
        
        TextPrompt id = new TextPrompt("Id del proveedor", idTextField);
        id.changeAlpha(0.5f);
        id.changeStyle(Font.BOLD + Font.ITALIC);
        
        
        
        TextPrompt cp  = new TextPrompt("Código postal ", cpTextField);
        cp.changeAlpha(0.5f);
        cp.changeStyle(Font.BOLD + Font.ITALIC);
        
        TextPrompt city  = new TextPrompt("Nombre de la ciudad", stateTextField);
        city.changeAlpha(0.5f);
        city.changeStyle(Font.BOLD + Font.ITALIC);
        
        TextPrompt colony  = new TextPrompt("Nombre de la colonia", state2TextField);
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
        
        TextPrompt municipality  = new TextPrompt("Municipio del proveedor", municipalityTextField);
        municipality.changeAlpha(0.5f);
        municipality.changeStyle(Font.BOLD + Font.ITALIC);
        
       
    
}

    public void cleanTextFields()
    {
        idTextField.setText("");
        nameComboBox.getEditor().setItem("");
        telephoneTextField.setText("");
        cpTextField.setText("");
        stateTextField.setText("");
        state2TextField.setText("");
        streetTextField.setText("");
        numberTextField.setText("");
        //jComboBox1.setSelectedIndex(0);
    }
  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        stateTextField = new javax.swing.JTextField();
        Proveedores = new javax.swing.JPanel();
        idLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        cpLabel = new javax.swing.JLabel();
        telephoneLabel = new javax.swing.JLabel();
        idTextField = new javax.swing.JTextField();
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
        streetTextField = new javax.swing.JTextField();
        streetLabel = new javax.swing.JLabel();
        state2TextField = new javax.swing.JTextField();
        numberLabel = new javax.swing.JLabel();
        numberTextField = new javax.swing.JTextField();
        setButton = new javax.swing.JButton();
        lblFondo = new javax.swing.JLabel();
        lblFondito = new javax.swing.JLabel();
        nameComboBox = new javax.swing.JComboBox<>();
        idRadioButton = new javax.swing.JRadioButton();
        nameRadioButton = new javax.swing.JRadioButton();
        streetLabel1 = new javax.swing.JLabel();
        municipalityTextField = new javax.swing.JTextField();
        calisComboBox = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();

        stateTextField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        stateTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                stateTextFieldKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                stateTextFieldKeyTyped(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        Proveedores.setMaximumSize(new java.awt.Dimension(1000, 1000));
        Proveedores.setName("Administrar Proveedores"); // NOI18N

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
        acceptButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                acceptButtonMouseClicked(evt);
            }
        });
        acceptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptButtonActionPerformed(evt);
            }
        });

        cpTextField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cpTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cpTextFieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cpTextFieldKeyTyped(evt);
            }
        });

        cityLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        cityLabel.setText("Municipio:");

        colonyLabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        colonyLabel.setText("Estado");

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

        state2TextField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        state2TextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                state2TextFieldKeyTyped(evt);
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
        setButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                setButtonMouseClicked(evt);
            }
        });
        setButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setButtonActionPerformed(evt);
            }
        });

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mainPackage/DosCreepauxCutted.png"))); // NOI18N

        lblFondito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mainPackage/pro.jpg"))); // NOI18N

        nameComboBox.setEditable(true);
        nameComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                nameComboBoxItemStateChanged(evt);
            }
        });
        nameComboBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nameComboBoxKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nameComboBoxKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nameComboBoxKeyTyped(evt);
            }
        });

        buttonGroup1.add(idRadioButton);
        idRadioButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        idRadioButton.setText("Id");
        idRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(nameRadioButton);
        nameRadioButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        nameRadioButton.setText("Nombre");
        nameRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameRadioButtonActionPerformed(evt);
            }
        });

        streetLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        streetLabel1.setText("Colonia");

        municipalityTextField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        municipalityTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                municipalityTextFieldActionPerformed(evt);
            }
        });

        calisComboBox.setEditable(true);
        calisComboBox.setToolTipText("");

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout ProveedoresLayout = new javax.swing.GroupLayout(Proveedores);
        Proveedores.setLayout(ProveedoresLayout);
        ProveedoresLayout.setHorizontalGroup(
            ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProveedoresLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mainLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
            .addGroup(ProveedoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(ProveedoresLayout.createSequentialGroup()
                        .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(nameComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(ProveedoresLayout.createSequentialGroup()
                                    .addComponent(idLabel)
                                    .addGap(80, 80, 80)
                                    .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(streetLabel1)
                                .addComponent(cpLabel)
                                .addComponent(nameLabel)
                                .addGroup(ProveedoresLayout.createSequentialGroup()
                                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(acceptButton, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(ProveedoresLayout.createSequentialGroup()
                                    .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(numberLabel)
                                        .addComponent(streetLabel)
                                        .addComponent(colonyLabel))
                                    .addGap(28, 28, 28)
                                    .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(state2TextField)
                                        .addComponent(numberTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                                        .addComponent(streetTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))))
                            .addGroup(ProveedoresLayout.createSequentialGroup()
                                .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(telephoneLabel)
                                    .addComponent(cityLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(ProveedoresLayout.createSequentialGroup()
                                            .addComponent(cpTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(setButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(calisComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(municipalityTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)))
                                    .addComponent(telephoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProveedoresLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(eraseRadioButton)
                                .addGap(68, 68, 68)
                                .addComponent(consultRadioButton))
                            .addGroup(ProveedoresLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(idRadioButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(nameRadioButton)
                                .addGap(27, 27, 27))
                            .addGroup(ProveedoresLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lblFondito, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 12, Short.MAX_VALUE))))
                    .addGroup(ProveedoresLayout.createSequentialGroup()
                        .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ProveedoresLayout.createSequentialGroup()
                                .addComponent(addRadioButton)
                                .addGap(52, 52, 52)
                                .addComponent(modifyRadioButton))
                            .addComponent(lblFondo))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        ProveedoresLayout.setVerticalGroup(
            ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProveedoresLayout.createSequentialGroup()
                .addComponent(mainLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addRadioButton)
                    .addComponent(modifyRadioButton)
                    .addComponent(eraseRadioButton)
                    .addComponent(consultRadioButton))
                .addGap(6, 6, 6)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ProveedoresLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(idLabel))
                    .addGroup(ProveedoresLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idRadioButton)
                            .addComponent(nameRadioButton))))
                .addGap(2, 2, 2)
                .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ProveedoresLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(telephoneLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(ProveedoresLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ProveedoresLayout.createSequentialGroup()
                                .addComponent(lblFondito, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(ProveedoresLayout.createSequentialGroup()
                                .addComponent(telephoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cpTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cpLabel)
                                        .addComponent(setButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(streetLabel1)
                                    .addComponent(calisComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(municipalityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cityLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(state2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(colonyLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(streetTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(streetLabel))
                                .addGap(6, 9, Short.MAX_VALUE)
                                .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(numberLabel)
                                    .addComponent(numberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(acceptButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(14, 14, 14)
                .addComponent(lblFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Proveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Proveedores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Proveedores.getAccessibleContext().setAccessibleName("Proveedores");
        Proveedores.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idTextFieldActionPerformed

    private void telephoneTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telephoneTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telephoneTextFieldActionPerformed

    private void acceptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_acceptButtonActionPerformed

    private void addRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRadioButtonActionPerformed
        setEnabledAllButtons();
        setEnabledLabels();
        setEnabledTextFields();
        eraseRadioButton.setEnabled(false);
        modifyRadioButton.setEnabled(false);
        nameLabel.setEnabled(true);
        idRadioButton.setEnabled(false);
        nameRadioButton.setEnabled(false);
        calisComboBox.setEnabled(true);
        municipalityTextField.setEnabled(true);
    }//GEN-LAST:event_addRadioButtonActionPerformed

    private void consultRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultRadioButtonActionPerformed
         
        setDisabledAllButtons();
        setDisabledTextFields();
        cancelButton.setEnabled(true);
        acceptButton.setEnabled(true);
        modifyRadioButton.setEnabled(true);
        consultRadioButton.setEnabled(true);
        eraseRadioButton.setEnabled(true);
        nameRadioButton.setEnabled(true);
        idRadioButton.setEnabled(true);
        idTextField.setEnabled(true);
        idTextField.setEnabled(false);
        nameComboBox.setEnabled(false);
        municipalityTextField.setEnabled(false);
        calisComboBox.setEnabled(false);
        
    }//GEN-LAST:event_consultRadioButtonActionPerformed

    public void setEnabledLabels(){
        idLabel.setEnabled(true);
        nameComboBox.setEnabled(true);
        telephoneLabel.setEnabled(true);
        cpLabel.setEnabled(true);
        cityLabel.setEnabled(true);
        colonyLabel.setEnabled(true);
        streetLabel.setEnabled(true);
        numberLabel.setEnabled(true);
    }
    
    public void setEnabledTextFields() {
        idTextField.setEnabled(true);
        nameComboBox.setEnabled(true);
        telephoneTextField.setEnabled(true);
        cpTextField.setEnabled(true);
        stateTextField.setEnabled(true);
        state2TextField.setEnabled(true);
        streetTextField.setEnabled(true);
        numberTextField.setEnabled(true);
    }
    
    public void setDisabledTextFields(){
        idTextField.setEnabled(false);
        nameComboBox.setEnabled(false);
        telephoneTextField.setEnabled(false);
        cpTextField.setEnabled(false);
        stateTextField.setEnabled(false);
        state2TextField.setEnabled(false);
        streetTextField.setEnabled(false);
        numberTextField.setEnabled(false);
    }
    
    public void setEnabledAllButtons() {
            modifyRadioButton.setEnabled(true);
            cancelButton.setEnabled(true);
            eraseRadioButton.setEnabled(true);
            acceptButton.setEnabled(true);
            setButton.setEnabled(true);
            nameRadioButton.setEnabled(true);
            idRadioButton.setEnabled(true);
            nameRadioButton.setEnabled(true);
    }
    
    public void setDisabledAllButtons() {
            modifyRadioButton.setEnabled(false);
            cancelButton.setEnabled(false);
            eraseRadioButton.setEnabled(false);
            acceptButton.setEnabled(false);
            setButton.setEnabled(false);
            nameRadioButton.setEnabled(false);
    }
    
    private void modifyRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyRadioButtonActionPerformed
        setEnabledAllButtons();
        setEnabledTextFields();
        setEnabledLabels();
        idTextField.setEnabled(false);
        idRadioButton.setEnabled(false);
        nameRadioButton.setEnabled(false);
        municipalityTextField.setEnabled(true);
        calisComboBox.setEnabled(true);
    }//GEN-LAST:event_modifyRadioButtonActionPerformed
      
    public void setDisabledLabels() {
        idLabel.setEnabled(false);
        nameLabel.setEnabled(false);
        telephoneLabel.setEnabled(false);
        cpLabel.setEnabled(false);
        cityLabel.setEnabled(false);
        colonyLabel.setEnabled(false);
        streetLabel.setEnabled(false);
        numberLabel.setEnabled(false);
    }
    
    
    private void eraseRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eraseRadioButtonActionPerformed
        //Todos los campos, exceptuando ID, se desactivan
        setDisabledAllButtons();    
        setDisabledTextFields();
        setEnabledLabels();
        cancelButton.setEnabled(true);
        acceptButton.setEnabled(true);
        idTextField.setEnabled(true);  
        idRadioButton.setEnabled(false);
        nameRadioButton.setEnabled(false);
        nameComboBox.setEnabled(false);
    }//GEN-LAST:event_eraseRadioButtonActionPerformed

    
    
     private boolean comparar(String cadena){
     Object [] lista = nameComboBox.getComponents();
     boolean encontrado=false;
        for (Object object : lista) {
            if(cadena.equals(object)){
                encontrado = true;
              break;
            }

        }
       return encontrado;
    }
    
    public void buscarProveedores(String nombre) {
        String datos[] = operacion.buscarProveedores(nombre);

        if (datos[0] != null) {
            idTextField.setText(datos[0]);
            nameComboBox.getEditor().setItem(datos[1]);
            telephoneTextField.setText(datos[2]);
            cpTextField.setText(datos[3]);
            stateTextField.setText(datos[4]);
            state2TextField.setText(datos[5]);
            streetTextField.setText(datos[6]);
            numberTextField.setText(datos[7]);            

        } else {

            JOptionPane.showMessageDialog(rootPane, "No se encontro ningun archivo", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }
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
        int no = (int)evt.getKeyChar();
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
        else if(no == 32){
              evt.consume();
              JOptionPane.showMessageDialog(null,"El id no puede tener espacios","¡Error!",JOptionPane.ERROR_MESSAGE);
        }
        else if(no == 46){
            evt.consume();
            JOptionPane.showMessageDialog(null,"No puedes introducir puntos en este campo","¡ERROR!",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_idTextFieldKeyTyped

    private void cpTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cpTextFieldKeyTyped
        // TODO add your handling code here:
        int nospaces = (int)evt.getKeyChar();
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
        else if(nospaces == 32) {
            evt.consume();
            JOptionPane.showMessageDialog(null,"No puedes introducir espacios en este campo,","¡Alerta!",JOptionPane.ERROR_MESSAGE);
        }
        else if(nospaces == 46){
            evt.consume();
            JOptionPane.showMessageDialog(null,"No puedes introducir puntos en este campo,","¡Alerta!",JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_cpTextFieldKeyTyped

    private void stateTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stateTextFieldKeyTyped
        // TODO add your handling code here:
        int points = (int)evt.getKeyChar();
        char validator4 = evt.getKeyChar();
        int numeros = (int)evt.getKeyChar();
        String val = stateTextField.getText();
        if(val.length() == 40){
            evt.consume();
            JOptionPane.showMessageDialog(null,"Longitud de caracteres máxima alcanzada","Error",JOptionPane.ERROR_MESSAGE);
        }
        else if(Character.isDigit(validator4)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null," Introduce sólo letras","Error",JOptionPane.ERROR_MESSAGE);
        }
        else if(numeros == 32){
            for(int i = 0; i < val.length(); i ++){
                if(val.charAt(i) == 32 ){
                    if(val.charAt(i) == 32 && val.charAt(i+1) == 32){
                      JOptionPane.showMessageDialog(null,"No puedes introducir dos espacios seguidos","¡Error!",JOptionPane.ERROR_MESSAGE);
                      evt.consume();
                      break;
                    }
                    
                }
            }

        }
        else if(points == 46){
            for(int i = 0; i <val.length(); i ++) {
                if(val.charAt(i) == 46){
                if(val.charAt(i) == 46 && val.charAt(i+1) == 46){
                    evt.consume();
                    JOptionPane.showMessageDialog(null,"No puedes introducir dos espacios","¡Error!",JOptionPane.ERROR_MESSAGE);
                    break;
                }
                }
            }
        }
    }//GEN-LAST:event_stateTextFieldKeyTyped

    private void state2TextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_state2TextFieldKeyTyped
        // TODO add your handling code here:
        int vali = (int)evt.getKeyChar();
        int vali2 = (int)evt.getKeyChar();
        boolean flag = true;
        char validator5 = evt.getKeyChar();
        int co = 0,co2 = 0;
        String vaca;
        if(state2TextField.getText().length() == 40){
            evt.consume();
            JOptionPane.showMessageDialog(null,"Longitud de caracteres máxima alcanzada","Error",JOptionPane.ERROR_MESSAGE);
        }
        else if(Character.isDigit(validator5)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null," Introduce sólo letras","Error",JOptionPane.ERROR_MESSAGE);
        }
        else if(vali == 32){
            vaca = state2TextField.getText();
            co ++;
            for(int i = 0; i <vaca.length(); i ++){
                if(vaca.charAt(i) == 32 && vaca.charAt(i+1) == 32){
                   evt.consume();
                   JOptionPane.showMessageDialog(null,"No puedes introducir dos espacios","¡Error",JOptionPane.ERROR_MESSAGE);
                }
            }
            
            
        }
        else if (vali2 == 46){
            evt.consume();
            JOptionPane.showMessageDialog(null,"No puedes introducir puntos en este campo","¡ERROR!",JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_state2TextFieldKeyTyped

    private void streetTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_streetTextFieldKeyTyped
        // TODO add your handling code here:
        int goku = (int)evt.getKeyChar();
        if(streetTextField.getText().length() == 40){
            evt.consume();
            JOptionPane.showMessageDialog(null,"Longitud de caracteres máxima alcanzada","Error",JOptionPane.ERROR_MESSAGE);
        }
    else if(goku == 46){
     evt.consume();
     JOptionPane.showMessageDialog(null,"No puedes introducir puntos en este campo","¡Alerta!",JOptionPane.ERROR_MESSAGE);
    }
        
    }//GEN-LAST:event_streetTextFieldKeyTyped

    private void numberTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numberTextFieldKeyTyped
        // TODO add your handling code here:7
        int no = (int)evt.getKeyChar();
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
        else if(no == 32){
            evt.consume();
            JOptionPane.showMessageDialog(null,"No puedes introducir esppacios en este campo","¡Aleryta!",JOptionPane.ERROR_MESSAGE);
        }
        else if (no == 46){
            evt.consume();
            JOptionPane.showMessageDialog(null,"No puedes introducir puntos en este campo");
        }
    }//GEN-LAST:event_numberTextFieldKeyTyped

    private void telephoneTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telephoneTextFieldKeyTyped
        // TODO add your handling code here:
        char validator7 = evt.getKeyChar();
        int nospace = (int)evt.getKeyChar();
        //int amount = telephoneTextField.getText().length();
        if(telephoneTextField.getText().length() == 10){
            evt.consume();
            JOptionPane.showMessageDialog(null,"Longitud de caracteres máxima alcanzada","Error",JOptionPane.ERROR_MESSAGE);
        }
        else if(Character.isLetter(validator7)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"Introduce sólo números","Error",JOptionPane.ERROR_MESSAGE);
        }   
        else if(nospace == 32){
            evt.consume();
            JOptionPane.showMessageDialog(null,"No puedes introducir espacios en este campo","¡Alerta!",JOptionPane.ERROR_MESSAGE);
        }
        else if (nospace == 46){
            evt.consume();
//            JOptionPane.showMessageDialog(null,"No puedes introducir puntos en este campo","¡Alerta!",JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_telephoneTextFieldKeyTyped

    private void setButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_setButtonActionPerformed

    private void setButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_setButtonMouseClicked
        // TODO add your handling code here:
        
        
        
        try {
                 conexion = Conexion.realizarConexion();
                 res=Conexion.Consulta("execute consultPostalCodes ");   
                 spaceUsed=Conexion.Consulta("execute getCount"); 
                 
                  try
                 {
                    while (spaceUsed.next())
                    {
                       tableSize=spaceUsed.getInt(1);
                    }
                 }
                 catch(SQLException e)
                 {}
                  while(res.next()){
                      
                                           //testProviders[0] =  res.getString(1);//id
              
                      testProvidersPostalCode[0] = res.getString(1);
                      testProvidersPostalCode[1] = res.getString(2);
                      testProvidersPostalCode[2] = res.getString(3);
                      testProvidersPostalCode[3] = res.getString(4);
                      if(addRadioButton.isSelected()){
                          if(cpTextField.getText().equals(testProvidersPostalCode[0])){
                      
                              
                       cpTextField.setText(testProvidersPostalCode[0]);
                       String getColony = testProvidersPostalCode[1];
                       String arrayColony[] = getColony.split(";");
                      
                       for(int i = 0; i < arrayColony.length; i ++){
                          // System.out.println(arrayColony[i]);
                          if(acceptButton.isSelected()){
                              calisComboBox.removeItemAt(i);
                          }
                          else {
                          calisComboBox.addItem(arrayColony[i]);   
                          }
                         
                              
                              //calisComboBox.setItem(arrayColony[i]);
                          
                       }
                       
                       
                      municipalityTextField.setText(testProvidersPostalCode[2]);
                      state2TextField.setText(testProvidersPostalCode[3]);
                          
                          }
                      
                      }
                  }
                  
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "ERROR"+e.getMessage());
        }  
        
        //////////////////////////////////////////-----------------------------------------------
        
    }//GEN-LAST:event_setButtonMouseClicked

    
    
    
    
    private void nameComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_nameComboBoxItemStateChanged
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_nameComboBoxItemStateChanged

    private void idRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idRadioButtonActionPerformed
        // TODO add your handling code here:
        if(idRadioButton.isSelected()){
            idTextField.setEnabled(true);
            nameRadioButton.setEnabled(false);
            JOptionPane.showMessageDialog(null,"Has seleccionado búsqueda por Id","¡Aviso!",JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            idTextField.setEnabled(false);
        }
    }//GEN-LAST:event_idRadioButtonActionPerformed

    private void nameRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameRadioButtonActionPerformed
        // TODO add your handling code here:
        
        if(nameRadioButton.isSelected()){
            nameComboBox.setEnabled(true);
            JOptionPane.showMessageDialog(null,"Has seleccionado búsqueda por nombre","¡Aviso!",JOptionPane.INFORMATION_MESSAGE);

        }
        else {
            nameComboBox.setEnabled(false);

        }
    }//GEN-LAST:event_nameRadioButtonActionPerformed

    private void acceptButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_acceptButtonMouseClicked
        // TODO add your handling code here:
        
        
        try
        {
      
        conexion = Conexion.realizarConexion();
        if(addRadioButton.isSelected()){
            if(idTextField.getText() == "" && nameComboBox.getEditor().getItem().toString() == "" && telephoneTextField.getText() == "" && cpTextField.getText() == ""){}
        pre=conexion.prepareStatement("{call addNewProvider(?,?,?,?,?,?,?,?,?)}");
        pre.setString(1,idTextField.getText());
        //pre.setString(2,nameTextField.getText());
        pre.setString(2,nameComboBox.getEditor().getItem().toString());
        pre.setString(3,telephoneTextField.getText());
        pre.setString(4,cpTextField.getText());
        //pre.setString(5,stateTextField.getText());
        pre.setString(5,calisComboBox.getEditor().getItem().toString());
        pre.setString(6,municipalityTextField.getText());
        pre.setString(7,state2TextField.getText());
        pre.setString(8,streetTextField.getText());
        pre.setString(9,numberTextField.getText());
        //pre.setString(4,String.valueOf(jComboBox1.getSelectedItem()));
        pre.executeUpdate();
        JOptionPane.showMessageDialog(null, "Proveedor: " +nameComboBox.getEditor().getItem().toString() +"Agregado correctamente a la base de datos ","¡Felicitaciones!",JOptionPane.PLAIN_MESSAGE);
        cleanTextFields();
        municipalityTextField.setText("");

        
        
        }
            else if(modifyRadioButton.isSelected()){
                
                pre=conexion.prepareStatement("{call newModifyProvidersProcedure(?,?,?,?,?,?,?,?,?)}");
                pre.setString(1,idTextField.getText());
                pre.setString(2,nameComboBox.getEditor().getItem().toString());
                pre.setString(3,telephoneTextField.getText());
                pre.setString(4,cpTextField.getText());
                pre.setString(5,calisComboBox.getEditor().getItem().toString());
                pre.setString(6,municipalityTextField.getText());
                pre.setString(7,state2TextField.getText());
                pre.setString(8,streetTextField.getText());
                pre.setString(9,numberTextField.getText());
                pre.executeUpdate();
                cleanTextFields();
                municipalityTextField.setText("");
                calisComboBox.getEditor().setItem("");
                JOptionPane.showMessageDialog(null, "Los datos del proveedor han sido modificados correctamente","¡Felicitaciones!",JOptionPane.INFORMATION_MESSAGE);
                
                }
                       
                        
                else if(consultRadioButton.isSelected()){
                 res=Conexion.Consulta("execute consultProvider2 ");   
                 spaceUsed=Conexion.Consulta("execute getRowCountProviders2"); 
                 
                 
                 try
                 {
                    while (spaceUsed.next())
                    {
                       tableSize=spaceUsed.getInt(1);
                    }
                 }
                 catch(SQLException e)
                 {}
                 String totalCount [] = new String [tableSize];
                 while(res.next()){
                     testProviders[0] =  res.getString(1);//id
                     testProviders[1] =  res.getString(2);//nombre
                     testProviders[2] =  res.getString(3);//telef
                     testProviders[3] =  res.getString(4);//cp
                     testProviders[4] =  res.getString(5);//esta
                     testProviders[5] =  res.getString(6);//Muni
                     testProviders[6] =  res.getString(7);//Colo
                     testProviders[7] =  res.getString(8);//calle
                     testProviders[8] =  res.getString(9);//numero callw
                     
                     if(idRadioButton.isSelected()){
                     

                        if((idTextField.getText()).equals(testProviders[0]))
                        {
                            eraseRadioButton.setEnabled(true);
                            modifyRadioButton.setEnabled(true);
                            JOptionPane.showMessageDialog(null, "Proveedor encontrado \n Usted ahora puede: \n Modificar los datos del proveedor \n Eliminar al proveedor","¡Felicitaciones!",JOptionPane.PLAIN_MESSAGE);
                            nameComboBox.getEditor().setItem(testProviders[1]);
                            telephoneTextField.setText(testProviders[2]);
                            cpTextField.setText(testProviders[3]);
                            calisComboBox.getEditor().setItem(testProviders[4]);
                            municipalityTextField.setText(testProviders[5]);
                            state2TextField.setText(testProviders[6]);
                            streetTextField.setText(testProviders[7]);
                            numberTextField.setText(testProviders[8]);
                          
                            }
                        
                        else if(tableSizeComparator>tableSize){
                            
                            JOptionPane.showMessageDialog(null, "Proveedor no encontrado5","¡Error!",JOptionPane.ERROR_MESSAGE);
                            idTextField.setText("");
                            
                        }
                     }
                     else if(nameRadioButton.isSelected()) {
                         if(((nameComboBox.getEditor().getItem().toString()).equals(testProviders[1]))) {
                             idRadioButton.setEnabled(false);
                             nameRadioButton.setEnabled(false);
                             
                             JOptionPane.showMessageDialog(null, " Proveedor encontrado \n Usted ahora puede: \n Modificar los datos del proveedor \n Eliminar al proveedor","¡Proveedor encontrado¡¡",JOptionPane.INFORMATION_MESSAGE);
                             idTextField.setText(testProviders[0]);
                             nameComboBox.getEditor().setItem(testProviders[1]);
                             telephoneTextField.setText(testProviders[2]);
                             cpTextField.setText(testProviders[3]);
                             calisComboBox.getEditor().setItem(testProviders[4]);
                             municipalityTextField.setText(testProviders[5]);
                             state2TextField.setText(testProviders[6]);
                             streetTextField.setText(testProviders[7]);
                             numberTextField.setText(testProviders[8]);
                             break;
                          
                         }
                          else if(tableSizeComparator==tableSize-1)
                           {
                                JOptionPane.showMessageDialog(null, "Proveedor no encnotrado6","¡Error!",JOptionPane.ERROR_MESSAGE);
                                break;
                            }                         
                     
                     }
                                     tableSizeComparator++;
                     
                 }
                    tableSizeComparator=0;
                        }
                
                else if (eraseRadioButton.isSelected()){
              
                pre=conexion.prepareStatement("{call providersEraser(?)}");
                pre.setString(1,idTextField.getText());
                pre.executeUpdate();
                JOptionPane.showMessageDialog(null, " Los datos del proveedor:  "+nameComboBox.getEditor().getItem().toString()+" han sido eliminados correctamente","¡Felicitaciones!",JOptionPane.PLAIN_MESSAGE);
                cleanTextFields();
                municipalityTextField.setText("");
                calisComboBox.getEditor().setItem("");
                eraseRadioButton.setEnabled(false);
                modifyRadioButton.setEnabled(false);
                consultRadioButton.setSelected(true);
                calisComboBox.setEnabled(false);
                            
                        }                
        }
        
        
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "ERROR"+e.getMessage());
        }  
    }//GEN-LAST:event_acceptButtonMouseClicked

    private void nameComboBoxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameComboBoxKeyTyped
        // TODO add your handling code here:
        int nume = (int)evt.getKeyChar();
        char number = evt.getKeyChar();
        String val = nameComboBox.getEditor().getItem().toString();
        if(Character.isDigit(number)){
            getToolkit().beep();
            evt.consume();
            //JOptionPane.showMessageDialog(null,"No mames perro","¡Error!",JOptionPane.ERROR_MESSAGE);
        }
        else if(nume == 32){
            for(int i = 0; i < nameComboBox.getEditor().getItem().toString().length(); i ++){
                if(val.charAt(i) == 32){
                    if(val.charAt(i) == 32 && val.charAt(i+1) == 32){
                        evt.consume();
                        break;
                    }
                }
            }
        }
        
        
    }//GEN-LAST:event_nameComboBoxKeyTyped

    private void nameComboBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameComboBoxKeyPressed
        // TODO add your handling code here:
        
        char validationNumbers =  evt.getKeyChar();
        char gg = evt.getKeyChar();
        int counter = 0;
        String spaceValidation = nameComboBox.getEditor().getItem().toString();
        //gg =nameComboBox.getEditor().getItem().toString();
        //String aux = (nameComboBox.getEditor().getItem().toString());
        if(Character.isDigit(validationNumbers)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null,"No puedes introducir números","¡Error!",JOptionPane.ERROR_MESSAGE);
        }
        else if((nameComboBox.getEditor().getItem().toString().length() == 50)){
            evt.consume();
            JOptionPane.showMessageDialog(null,"Longitud de caracteres máxima alcancada","¡Error!",JOptionPane.ERROR_MESSAGE);
        }
        else if(nameComboBox.getEditor().getItem().toString().equals(' ')){
            
           JOptionPane.showMessageDialog(null,"Hola");
        } else {//////
        }
    }//GEN-LAST:event_nameComboBoxKeyPressed

    public void validarEspacios(String comparator, JTextField methodTextField){
        int counter = 0;
        comparator = methodTextField.getText();
        for(int i = 0; i < methodTextField.getText().length(); i ++){
               if(comparator.charAt(i) == ' '){
                   counter ++;
                   if(counter > 1){
                       JOptionPane.showMessageDialog(null,"Addiós");
                   }
               }
        }
        
        
    }
    
    
    private void stateTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stateTextFieldKeyPressed
        // TODO add your handling code here:
        int counter3 = 0;
        String comp = stateTextField.getText();
      
       
    }//GEN-LAST:event_stateTextFieldKeyPressed

    private void nameComboBoxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameComboBoxKeyReleased
        // TODO add your handling code here:
        if(nameComboBox.getEditor().getItem().toString().length() == 5){
        evt.consume();
        }
    }//GEN-LAST:event_nameComboBoxKeyReleased

    private void cpTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cpTextFieldKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cpTextFieldKeyReleased

    private void municipalityTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_municipalityTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_municipalityTextFieldActionPerformed

    
    
    
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdministrarProveedores().setVisible(true);
            }
        });
        
    }
    private javax.swing.JTextField methodTextField;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Proveedores;
    private javax.swing.JButton acceptButton;
    private javax.swing.JRadioButton addRadioButton;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> calisComboBox;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel cityLabel;
    private javax.swing.JLabel colonyLabel;
    private javax.swing.JRadioButton consultRadioButton;
    private javax.swing.JLabel cpLabel;
    private javax.swing.JTextField cpTextField;
    private javax.swing.JRadioButton eraseRadioButton;
    private javax.swing.JLabel idLabel;
    private javax.swing.JRadioButton idRadioButton;
    private javax.swing.JTextField idTextField;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblFondito;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JRadioButton modifyRadioButton;
    private javax.swing.JTextField municipalityTextField;
    private javax.swing.JComboBox<String> nameComboBox;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JRadioButton nameRadioButton;
    private javax.swing.JLabel numberLabel;
    private javax.swing.JTextField numberTextField;
    private javax.swing.JButton setButton;
    private javax.swing.JTextField state2TextField;
    private javax.swing.JTextField stateTextField;
    private javax.swing.JLabel streetLabel;
    private javax.swing.JLabel streetLabel1;
    private javax.swing.JTextField streetTextField;
    private javax.swing.JLabel telephoneLabel;
    private javax.swing.JTextField telephoneTextField;
    // End of variables declaration//GEN-END:variables

    private String replace(String string, String string0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
