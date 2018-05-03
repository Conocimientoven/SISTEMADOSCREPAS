package mainPackage;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import static mainPackage.IngresarAlSistema.conexion;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import javax.swing.table.DefaultTableModel;
import static mainPackage.AdministrarUsuarios.spaceUsed;
import static mainPackage.AdministrarUsuarios.tableSizeComparator;
import static mainPackage.AdministrarUsuarios.testUsers;

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
//AutoCompleteDecorator.decorate(consultComboBox);




   static ButtonGroup group = new ButtonGroup();
   static int tableSize = 0, tableSixeComparation = 0;
    static PreparedStatement pre;
    String var,var2;
    static ResultSet res, spaceUsed;
    static String testProviders[] = new String[8];
    
    
    public static Connection realizarConexion()
    {
	try{
		Connection co;
		co=DriverManager.getConnection("jdbc:sqlserver://RAMON-SON:1433;databaseName=SDCDB;","sa","sa");
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
         ImageIcon crepasLogotype = new ImageIcon("src/images/cre.jpg");
         ImageIcon proverdorLogotype = new ImageIcon("src/images/pro.jpg");
         Icon icono = new ImageIcon(crepasLogotype.getImage().getScaledInstance(lblFondo.getWidth(), lblFondo.getHeight(), Image.SCALE_DEFAULT));
         Icon iconito = new ImageIcon(proverdorLogotype.getImage().getScaledInstance(lblFondito.getWidth(), lblFondito.getHeight(), Image.SCALE_DEFAULT));
         lblFondito.setIcon(iconito);
         lblFondo.setIcon(icono);
         this.repaint();
        
        
        eraseRadioButton.setEnabled(false); 
        modifyRadioButton.setEnabled(false);
        idRadioButton.setEnabled(false);
        nameRadioButton.setEnabled(false);
        
        this.setLocationRelativeTo(null);
        
        
        TextPrompt id = new TextPrompt("Id del proveedor", idTextField);
        id.changeAlpha(0.5f);
        id.changeStyle(Font.BOLD + Font.ITALIC);
        
        
        
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

    public void cleanTextFields()
    {
        idTextField.setText("");
        nameComboBox.getEditor().setItem("");
        telephoneTextField.setText("");
        cpTextField.setText("");
        cityTextField.setText("");
        colonyTextField.setText("");
        streetTextField.setText("");
        numberTextField.setText("");
        //jComboBox1.setSelectedIndex(0);
    }
  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
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
        cityTextField = new javax.swing.JTextField();
        streetTextField = new javax.swing.JTextField();
        streetLabel = new javax.swing.JLabel();
        colonyTextField = new javax.swing.JTextField();
        numberLabel = new javax.swing.JLabel();
        numberTextField = new javax.swing.JTextField();
        setButton = new javax.swing.JButton();
        lblFondo = new javax.swing.JLabel();
        lblFondito = new javax.swing.JLabel();
        nameComboBox = new javax.swing.JComboBox<>();
        idRadioButton = new javax.swing.JRadioButton();
        nameRadioButton = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        Proveedores.setBackground(new java.awt.Color(92, 100, 90));
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

        addRadioButton.setBackground(new java.awt.Color(92, 100, 90));
        buttonGroup.add(addRadioButton);
        addRadioButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        addRadioButton.setText("Agregar");
        addRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRadioButtonActionPerformed(evt);
            }
        });

        modifyRadioButton.setBackground(new java.awt.Color(92, 100, 90));
        buttonGroup.add(modifyRadioButton);
        modifyRadioButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        modifyRadioButton.setText("Modificar");
        modifyRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyRadioButtonActionPerformed(evt);
            }
        });

        consultRadioButton.setBackground(new java.awt.Color(92, 100, 90));
        buttonGroup.add(consultRadioButton);
        consultRadioButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        consultRadioButton.setText("Consultar");
        consultRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultRadioButtonActionPerformed(evt);
            }
        });

        eraseRadioButton.setBackground(new java.awt.Color(92, 100, 90));
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

        nameComboBox.setEditable(true);
        nameComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                nameComboBoxItemStateChanged(evt);
            }
        });

        idRadioButton.setBackground(new java.awt.Color(92, 100, 90));
        buttonGroup1.add(idRadioButton);
        idRadioButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        idRadioButton.setText("Id");
        idRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idRadioButtonActionPerformed(evt);
            }
        });

        nameRadioButton.setBackground(new java.awt.Color(92, 100, 90));
        buttonGroup1.add(nameRadioButton);
        nameRadioButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        nameRadioButton.setText("Nombre");
        nameRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameRadioButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ProveedoresLayout = new javax.swing.GroupLayout(Proveedores);
        Proveedores.setLayout(ProveedoresLayout);
        ProveedoresLayout.setHorizontalGroup(
            ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProveedoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ProveedoresLayout.createSequentialGroup()
                        .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(ProveedoresLayout.createSequentialGroup()
                                .addComponent(telephoneLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(telephoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ProveedoresLayout.createSequentialGroup()
                                .addComponent(numberLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(numberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProveedoresLayout.createSequentialGroup()
                                .addComponent(streetLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(streetTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProveedoresLayout.createSequentialGroup()
                                .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(ProveedoresLayout.createSequentialGroup()
                                        .addComponent(colonyLabel)
                                        .addGap(35, 35, 35))
                                    .addGroup(ProveedoresLayout.createSequentialGroup()
                                        .addComponent(cityLabel)
                                        .addGap(41, 41, 41))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ProveedoresLayout.createSequentialGroup()
                                        .addComponent(cpLabel)
                                        .addGap(53, 53, 53)))
                                .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(ProveedoresLayout.createSequentialGroup()
                                        .addComponent(cpTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(setButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(colonyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(ProveedoresLayout.createSequentialGroup()
                                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(acceptButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProveedoresLayout.createSequentialGroup()
                                .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(idLabel)
                                    .addComponent(nameLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(idTextField)
                                    .addComponent(nameComboBox, 0, 202, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)
                        .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFondito, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(ProveedoresLayout.createSequentialGroup()
                        .addComponent(addRadioButton)
                        .addGap(28, 28, 28)
                        .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ProveedoresLayout.createSequentialGroup()
                                .addComponent(modifyRadioButton)
                                .addGap(56, 56, 56)
                                .addComponent(eraseRadioButton))
                            .addGroup(ProveedoresLayout.createSequentialGroup()
                                .addGap(206, 206, 206)
                                .addComponent(idRadioButton)))
                        .addGap(26, 26, 26)
                        .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(consultRadioButton, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nameRadioButton, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(ProveedoresLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(mainLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        ProveedoresLayout.setVerticalGroup(
            ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProveedoresLayout.createSequentialGroup()
                .addComponent(mainLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addRadioButton)
                    .addComponent(modifyRadioButton)
                    .addComponent(eraseRadioButton)
                    .addComponent(consultRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(idRadioButton)
                        .addComponent(nameRadioButton))
                    .addComponent(idLabel))
                .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ProveedoresLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ProveedoresLayout.createSequentialGroup()
                                .addComponent(nameLabel)
                                .addGap(10, 10, 10))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProveedoresLayout.createSequentialGroup()
                                .addComponent(nameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(telephoneLabel)
                            .addComponent(telephoneTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cpLabel)
                                .addComponent(setButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cpTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cityLabel)
                            .addComponent(cityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(colonyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(colonyLabel))
                        .addGap(8, 8, 8)
                        .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(streetTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(streetLabel)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProveedoresLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(lblFondito, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ProveedoresLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(numberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numberLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(acceptButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(ProveedoresLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(lblFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Proveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Proveedores, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        cityTextField.setEnabled(true);
        colonyTextField.setEnabled(true);
        streetTextField.setEnabled(true);
        numberTextField.setEnabled(true);
    }
    
    public void setDisabledTextFields(){
        idTextField.setEnabled(false);
        nameComboBox.setEnabled(false);
        telephoneTextField.setEnabled(false);
        cpTextField.setEnabled(false);
        cityTextField.setEnabled(false);
        colonyTextField.setEnabled(false);
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
            cityTextField.setText(datos[4]);
            colonyTextField.setText(datos[5]);
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
        
    }//GEN-LAST:event_telephoneTextFieldKeyTyped

    private void setButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_setButtonActionPerformed

    private void setButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_setButtonMouseClicked
        // TODO add your handling code here:
        
        String cp = cpTextField.getText();
        int conver;
        conver = Integer.parseInt(cp);
        if((conver >= 49000) && (conver <= 49100)){
            cityTextField.setText("Ciudad Guzmán");
        }
        else if((conver >= 45470) && (conver <= 45579)){
            cityTextField.setText("Acatic");
        }
        else if ((conver >= 45700) && (conver <= 45723)){
            cityTextField.setText("Acatlan De Juarez");
        }
         else if ((conver >= 46730) && (conver <= 46758)){
            cityTextField.setText("Ahualulco De Mercado");
        }
        else if ((conver >= 49370) && (conver <= 49379)){
            cityTextField.setText("Amacueca");
        }
         else if ((conver >= 49380) && (conver <= 49399)){
            cityTextField.setText("Amatitan");
        }
         else if ((conver >= 46600) && (conver <= 46729)){
            cityTextField.setText("Ameca");
        }
          else if ((conver >= 46560) && (conver <= 46580)){
            cityTextField.setText("Antonio Escobedo");
        }
           else if ((conver >= 44200) && (conver <= 44990)){
            cityTextField.setText("Guadalajara");
        }
            else if ((conver >= 45500) && (conver <= 46629)){
            cityTextField.setText("Tlaquepalque");
        }
             else if ((conver >= 48640) && (conver <= 48655)){
            cityTextField.setText("Chilistaln");
        }
              else if ((conver >= 45920) && (conver <= 45940)){
            cityTextField.setText("Chapala");
        }
               else if ((conver >= 48740) && (conver <= 48750)){
            cityTextField.setText("El Grullo");
        }
                 else if ((conver >= 49900) && (conver <= 49940)){
            cityTextField.setText("Tecatitlan");
        }
                   else if ((conver >= 49120) && (conver <= 49130)){
            cityTextField.setText("Gomez Farias");
        }
                     else if ((conver >= 49300) && (conver <= 49339)){
            cityTextField.setText("Sayula");
        }
                       else if ((conver >= 46400) && (conver <= 46433)){
            cityTextField.setText("Tequila");
        }
                         else if ((conver >= 49400) && (conver <= 49427)){
            cityTextField.setText("Tizapan El Alto");
        }
                           else if ((conver >= 49800) && (conver <= 49836)){
            cityTextField.setText("Tuxpan");
        }
                             else if ((conver >= 49540) && (conver <= 49548)){
            cityTextField.setText("Valle de Juarez");
        }
                            
         else {
             JOptionPane.showMessageDialog(null, "Código Postal no identificado, por favor ingresa tu ciudad","¡Aviso!",JOptionPane.INFORMATION_MESSAGE);
         }
        
        
    }//GEN-LAST:event_setButtonMouseClicked

    
    
    
    
    private void nameComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_nameComboBoxItemStateChanged
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_nameComboBoxItemStateChanged

    private void idRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idRadioButtonActionPerformed
        // TODO add your handling code here:
        if(idRadioButton.isSelected()){
            idTextField.setEnabled(true);
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

        pre=conexion.prepareStatement("{call insertProvider(?,?,?,?,?,?,?,?)}");
        pre.setString(1,idTextField.getText());
        //pre.setString(2,nameTextField.getText());
        pre.setString(2,nameComboBox.getEditor().getItem().toString());
        pre.setString(3,telephoneTextField.getText());
        pre.setString(4,cpTextField.getText());
        pre.setString(5,cityTextField.getText());
        pre.setString(6,colonyTextField.getText());
        pre.setString(7,streetTextField.getText());
        pre.setString(8,numberTextField.getText());
        //pre.setString(4,String.valueOf(jComboBox1.getSelectedItem()));
        pre.executeUpdate();
        JOptionPane.showMessageDialog(null, "Proveedor: " +nameComboBox.getEditor().getItem().toString() +"Agregado correctamente a la base de datos ","¡Felicitaciones!",JOptionPane.PLAIN_MESSAGE);
        cleanTextFields();
        }
            else if(modifyRadioButton.isSelected()){
                
                pre=conexion.prepareStatement("{call modifyProvider(?,?,?,?,?,?,?,?)}");
                pre.setString(1,idTextField.getText());
                pre.setString(2,nameComboBox.getEditor().getItem().toString());
                pre.setString(3,telephoneTextField.getText());
                pre.setString(4,cpTextField.getText());
                pre.setString(5,cityTextField.getText());
                pre.setString(6,colonyTextField.getText());
                pre.setString(7,streetTextField.getText());
                pre.setString(8,numberTextField.getText());
                pre.executeUpdate();
                cleanTextFields();

                JOptionPane.showMessageDialog(null, "Los datos del proveedor han sido modificados correctamente","¡Felicitaciones!",JOptionPane.INFORMATION_MESSAGE);
                
                }
                       
                        
                else if(consultRadioButton.isSelected()){
                 res=Conexion.Consulta("execute consultProvider ");   
                 spaceUsed=Conexion.Consulta("execute getRowCountProviders"); 
                 
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
                     testProviders[0] =  res.getString(1);
                     testProviders[1] =  res.getString(2);
                     testProviders[2] =  res.getString(3);
                     testProviders[3] =  res.getString(4);
                     testProviders[4] =  res.getString(5);
                     testProviders[5] =  res.getString(6);
                     testProviders[6] =  res.getString(7);
                     testProviders[7] =  res.getString(8);
                     
                     if(idRadioButton.isSelected()){
                     

                        if((idTextField.getText()).equals(testProviders[0]))
                        {
                            eraseRadioButton.setEnabled(true);
                            modifyRadioButton.setEnabled(true);
                            JOptionPane.showMessageDialog(null, "Proveedor encontrado \n Usted ahora puede: \n Modificar los datos del proveedor \n Eliminar al proveedor","¡Felicitaciones!",JOptionPane.PLAIN_MESSAGE);
                            nameComboBox.getEditor().setItem(testProviders[1]);
                            telephoneTextField.setText(testProviders[2]);
                            cpTextField.setText(testProviders[3]);
                            cityTextField.setText(testProviders[4]);
                            colonyTextField.setText(testProviders[5]);
                            streetTextField.setText(testProviders[6]);
                            numberTextField.setText(testProviders[7]);
                          
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
                             cityTextField.setText(testProviders[4]);
                             colonyTextField.setText(testProviders[5]);
                             streetTextField.setText(testProviders[6]);
                             numberTextField.setText(testProviders[7]);
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
                String name = idTextField.getText();
                pre=conexion.prepareStatement("{call deleteProvider(?)}");
                pre.setString(1,idTextField.getText());
                pre.executeUpdate();
                JOptionPane.showMessageDialog(null, " Los datos del proveedor:  "+nameComboBox.getEditor().getItem().toString()+" han sido eliminados correctamente","¡Felicitaciones!",JOptionPane.PLAIN_MESSAGE);
                cleanTextFields();
                eraseRadioButton.setEnabled(false);
                modifyRadioButton.setEnabled(false);
                consultRadioButton.setSelected(true);
                            
                        }                
        }
        
        
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "ERROR"+e.getMessage());
        }  
    }//GEN-LAST:event_acceptButtonMouseClicked

    
    
    
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdministrarProveedores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Proveedores;
    private javax.swing.JButton acceptButton;
    private javax.swing.JRadioButton addRadioButton;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.ButtonGroup buttonGroup1;
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
    private javax.swing.JRadioButton idRadioButton;
    private javax.swing.JTextField idTextField;
    private javax.swing.JLabel lblFondito;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JRadioButton modifyRadioButton;
    private javax.swing.JComboBox<String> nameComboBox;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JRadioButton nameRadioButton;
    private javax.swing.JLabel numberLabel;
    private javax.swing.JTextField numberTextField;
    private javax.swing.JButton setButton;
    private javax.swing.JLabel streetLabel;
    private javax.swing.JTextField streetTextField;
    private javax.swing.JLabel telephoneLabel;
    private javax.swing.JTextField telephoneTextField;
    // End of variables declaration//GEN-END:variables
}
