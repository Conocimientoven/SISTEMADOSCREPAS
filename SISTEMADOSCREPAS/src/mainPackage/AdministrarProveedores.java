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
import javax.swing.text.JTextComponent;
import static mainPackage.AdministrarUsuarios.tableSizeComparator;

/**
 *
 * @author Ramón
 */
public class AdministrarProveedores extends javax.swing.JFrame {
public static Connection contacto = null;
public static boolean establecido;
static int counter = 0, counter2 = 0;
DefaultTableModel model;
//AutoCompleteDecorator.decorate(consultComboBox);

Operaciones operations =  new Operaciones();


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
        
    
        namePredictiveSearch.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {});
        
        
        
        
        
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
    
    
    // Ya instancié el objeto de la clase Operaciones, ya solo me falta hacer para que lo haga el método xD
      public void search(String name){
        String dates[] = operations.search(name);
        if(dates[0]!=null){
            idTextField.setText(dates[0]);
            nameTextField.setText(dates[1]);
            telephoneTextField.setText(dates[2]);
            cpTextField.setText(dates[3]);
            cityTextField.setText(dates[4]);
            colonyTextField.setText(dates[5]);
            streetTextField.setText(dates[6]);
            numberTextField.setText(dates[7]);
            
            
        }else {
            JOptionPane.showMessageDialog(rootPane, "No se encontro ningun archivo", "Error",JOptionPane.WARNING_MESSAGE);
        }
     
    
    }
    
    
   
        

        
        
     public void keyReleased(KeyEvent evt){
        
        String  textGetter = namePredictiveSearch.getEditor().getItem().toString();
        
        
        if(evt.getKeyChar()==KeyEvent.VK_ENTER){
            search(textGetter);
        }
        
  
        if(evt.getKeyCode()>=65 &&evt.getKeyCode()<=90 || evt.getKeyCode()>=96 || evt.getKeyCode()<=105|| evt.getKeyCode()==8){ 
         
            namePredictiveSearch.setModel(operations.getList(textGetter));
            if(consultComboBox.getItemCount()>0){
                
                namePredictiveSearch.showPopup();
                if(evt.getKeyCode()!=8){
                    ((JTextComponent)namePredictiveSearch.getEditor().getEditorComponent()).select(textGetter.length(),namePredictiveSearch.getEditor().getItem().toString().length());
                
                
                }else {
                    namePredictiveSearch.getEditor().setItem(textGetter);
                }
                
            }else {
                namePredictiveSearch.addItem(textGetter);
            }
        }
    }//KeyRelased

    public void cleanTextFields()
    {
        idTextField.setText("");
        nameTextField.setText("");
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
        Proveedores = new javax.swing.JPanel();
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
        lblFondo = new javax.swing.JLabel();
        lblFondito = new javax.swing.JLabel();
        consultComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        providersTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        searchButton = new javax.swing.JButton();
        namePredictiveSearch = new javax.swing.JComboBox<>();

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

        consultComboBox.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        consultComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---", "Id", "Nombre" }));
        consultComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                consultComboBoxItemStateChanged(evt);
            }
        });
        consultComboBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                consultComboBoxMouseClicked(evt);
            }
        });
        consultComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultComboBoxActionPerformed(evt);
            }
        });

        providersTable.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        providersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id_Proveedor", "Nombre_Proveedor", "Teléfono_Proveedor", "Código_Postal", "Ciudad_Proveedor", "Colonia_Proveedor", "Calle_Proveedor", "Número_Calle"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        providersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                providersTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(providersTable);
        if (providersTable.getColumnModel().getColumnCount() > 0) {
            providersTable.getColumnModel().getColumn(0).setResizable(false);
            providersTable.getColumnModel().getColumn(1).setResizable(false);
            providersTable.getColumnModel().getColumn(2).setResizable(false);
            providersTable.getColumnModel().getColumn(3).setResizable(false);
            providersTable.getColumnModel().getColumn(4).setResizable(false);
            providersTable.getColumnModel().getColumn(5).setResizable(false);
            providersTable.getColumnModel().getColumn(6).setResizable(false);
            providersTable.getColumnModel().getColumn(7).setResizable(false);
        }

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Datos Personales:");

        searchButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        searchButton.setText("Buscar");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        namePredictiveSearch.setEditable(true);
        namePredictiveSearch.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                namePredictiveSearchItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout ProveedoresLayout = new javax.swing.GroupLayout(Proveedores);
        Proveedores.setLayout(ProveedoresLayout);
        ProveedoresLayout.setHorizontalGroup(
            ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProveedoresLayout.createSequentialGroup()
                .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ProveedoresLayout.createSequentialGroup()
                        .addContainerGap()
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
                                .addComponent(nameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ProveedoresLayout.createSequentialGroup()
                                .addComponent(idLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(ProveedoresLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel1)))
                .addGap(26, 26, 26)
                .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(addRadioButton)
                        .addGroup(ProveedoresLayout.createSequentialGroup()
                            .addGap(4, 4, 4)
                            .addComponent(lblFondito, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(ProveedoresLayout.createSequentialGroup()
                            .addGap(168, 168, 168)
                            .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(ProveedoresLayout.createSequentialGroup()
                                    .addComponent(modifyRadioButton)
                                    .addGap(102, 102, 102)
                                    .addComponent(eraseRadioButton)
                                    .addGap(72, 72, 72)
                                    .addComponent(consultRadioButton))
                                .addComponent(consultComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProveedoresLayout.createSequentialGroup()
                            .addComponent(namePredictiveSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProveedoresLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mainLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(246, 246, 246))
        );
        ProveedoresLayout.setVerticalGroup(
            ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProveedoresLayout.createSequentialGroup()
                .addComponent(mainLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ProveedoresLayout.createSequentialGroup()
                        .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addRadioButton)
                            .addComponent(modifyRadioButton)
                            .addComponent(eraseRadioButton)
                            .addComponent(consultRadioButton))
                        .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(ProveedoresLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(consultComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(searchButton))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProveedoresLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(namePredictiveSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProveedoresLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idLabel))
                        .addGap(5, 5, 5)))
                .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ProveedoresLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblFondito, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                            .addComponent(lblFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(ProveedoresLayout.createSequentialGroup()
                        .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(telephoneLabel)
                            .addComponent(telephoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cpLabel)
                            .addComponent(cpTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(setButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(streetLabel))
                        .addGap(6, 13, Short.MAX_VALUE)
                        .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(numberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numberLabel))
                        .addGap(43, 43, 43)
                        .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(acceptButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Proveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

        pre=conexion.prepareStatement("{call insertProvider(?,?,?,?,?,?,?,?)}");
        pre.setString(1,idTextField.getText());
        pre.setString(2,nameTextField.getText());
        pre.setString(3,telephoneTextField.getText());
        pre.setString(4,cpTextField.getText());
        pre.setString(5,cityTextField.getText());
        pre.setString(6,colonyTextField.getText());
        pre.setString(7,streetTextField.getText());
        pre.setString(8,numberTextField.getText());
        //pre.setString(4,String.valueOf(jComboBox1.getSelectedItem()));
        pre.executeUpdate();
        JOptionPane.showMessageDialog(null, "Proveedor: " +nameTextField.getText() +"Agregado correctamente a la base de datos ","¡Felicitaciones!",JOptionPane.PLAIN_MESSAGE);
        cleanTextFields();
        }
            else if(modifyRadioButton.isSelected()){
                
                pre=conexion.prepareStatement("{call modifyProvider(?,?,?,?,?,?,?,?)}");
                pre.setString(1,idTextField.getText());
                pre.setString(2,nameTextField.getText());
                pre.setString(3,telephoneTextField.getText());
                pre.setString(4,cpTextField.getText());
                pre.setString(5,cityTextField.getText());
                pre.setString(6,colonyTextField.getText());
                pre.setString(7,streetTextField.getText());
                pre.setString(8,numberTextField.getText());
                pre.executeUpdate();
               cleanTextFields();

                JOptionPane.showMessageDialog(null, "Los datos del proveedor:  "+nameTextField.getText()+" han sido modificados correctamente","",JOptionPane.PLAIN_MESSAGE);
                
                }
                       
                        
                else if(consultRadioButton.isSelected()){
                 res=Conexion.Consulta("execute consultProvider");   
                 spaceUsed=Conexion.Consulta("execute getRowCountProviders"); 
                   
                   try {
                       while(spaceUsed.next()){
                           tableSize=spaceUsed.getInt(1);
                       }
                   }
                   catch(SQLException e){
                   }
                    while(res.next())
                    {
                        
                        testProviders[0]=res.getString(1); //Id_Provedor
                        testProviders[1]=res.getString(2);  //Nombre_Proveedor
                        testProviders[2]=res.getString(3);  //Teléfono_Proveedor
                        testProviders[3]=res.getString(4);  //Codigo_Postal
                        testProviders[4]=res.getString(5);  //Ciudad_Proveedor
                        testProviders[5]=res.getString(6);  //Colonia_Proveedor
                        testProviders[6]=res.getString(7);  //Calle_Proveedor
                        testProviders[7]=res.getString(8);  //Número_Proveedor
                        
                        
                        if((idTextField.getText()).equals(testProviders[0]))
                        {
                            
                              
                            eraseRadioButton.setEnabled(true);
                            modifyRadioButton.setEnabled(true);
                            JOptionPane.showMessageDialog(null, "Proveedor encontrado \n Usted ahora puede: \n Modificar los datos del proveedor \n Eliminar al proveedor","¡Felicitaciones!",JOptionPane.PLAIN_MESSAGE);
                            nameTextField.setText(testProviders[1]);
                            telephoneTextField.setText(testProviders[2]);
                            cpTextField.setText(testProviders[3]);
                            cityTextField.setText(testProviders[4]);
                            colonyTextField.setText(testProviders[5]);
                            streetTextField.setText(testProviders[6]);
                            numberTextField.setText(testProviders[7]);
                            break;
                            }
                        
                        else if(tableSizeComparator>tableSize){
                            
                            JOptionPane.showMessageDialog(null, "Proveedor no encontrado","¡Alerta!",JOptionPane.ERROR_MESSAGE);
                            idTextField.setText("");
                            break;
                        }
                                     tableSizeComparator++;
                    }
                        }
                
                else if (eraseRadioButton.isSelected()){
                String name = idTextField.getText();
                pre=conexion.prepareStatement("{call deleteProvider(?)}");
                pre.setString(1,idTextField.getText());
                pre.executeUpdate();
                JOptionPane.showMessageDialog(null, " Los datos del proveedor:  "+name+" han sido eliminados correctamente","¡Felicitaciones!",JOptionPane.PLAIN_MESSAGE);
                idTextField.setText("");
                nameTextField.setText("");
                telephoneTextField.setText("");
                cpTextField.setText("");
                cityTextField.setText("");
                colonyTextField.setText("");
                streetTextField.setText("");
                numberTextField.setText("");
                
                
                eraseRadioButton.setEnabled(false);
                modifyRadioButton.setEnabled(false);
                consultRadioButton.setSelected(true);
                            
                        }
                
        }
        
        
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "ERROR"+e.getMessage());
        }   
    }//GEN-LAST:event_acceptButtonActionPerformed

    private void addRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRadioButtonActionPerformed
        setEnabledAllButtons();
        setEnabledLabels();
        setEnabledTextFields();
        eraseRadioButton.setEnabled(false);
        modifyRadioButton.setEnabled(false);
    }//GEN-LAST:event_addRadioButtonActionPerformed

    private void consultRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultRadioButtonActionPerformed
         
        setDisabledAllButtons();
        setDisabledTextFields();
        cancelButton.setEnabled(true);
        acceptButton.setEnabled(true);
        modifyRadioButton.setEnabled(true);
        consultRadioButton.setEnabled(true);
        eraseRadioButton.setEnabled(true);
        consultComboBox.setEnabled(true);
        idTextField.setEnabled(true);
    }//GEN-LAST:event_consultRadioButtonActionPerformed

    public void setEnabledLabels(){
        idLabel.setEnabled(true);
        nameLabel.setEnabled(true);
        telephoneLabel.setEnabled(true);
        cpLabel.setEnabled(true);
        cityLabel.setEnabled(true);
        colonyLabel.setEnabled(true);
        streetLabel.setEnabled(true);
        numberLabel.setEnabled(true);
    }
    
    public void setEnabledTextFields() {
        idTextField.setEnabled(true);
        nameTextField.setEnabled(true);
        telephoneTextField.setEnabled(true);
        cpTextField.setEnabled(true);
        cityTextField.setEnabled(true);
        colonyTextField.setEnabled(true);
        streetTextField.setEnabled(true);
        numberTextField.setEnabled(true);
    }
    
    public void setDisabledTextFields(){
        idTextField.setEnabled(false);
        nameTextField.setEnabled(false);
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
            consultComboBox.setEnabled(true);
    }
    
    public void setDisabledAllButtons() {
            modifyRadioButton.setEnabled(false);
            cancelButton.setEnabled(false);
            eraseRadioButton.setEnabled(false);
            acceptButton.setEnabled(false);
            setButton.setEnabled(false);
            consultComboBox.setEnabled(false);
    }
    
    private void modifyRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyRadioButtonActionPerformed
        setEnabledAllButtons();
        setEnabledTextFields();
        setEnabledLabels();
        idTextField.setEnabled(false);
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
        setDisabledLabels();
        cancelButton.setEnabled(true);
        acceptButton.setEnabled(true);
        idLabel.setEnabled(true);
        idTextField.setEnabled(true);        
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
        int counterr = 0;
        int validator = (int)evt.getKeyChar();
        char validator2 = evt.getKeyChar();
        boolean state = true;
        String converter = nameTextField.getText();
        int counter = 0;
        if(nameTextField.getText().length() == 40){
            evt.consume();
            JOptionPane.showMessageDialog(null,"Longitud de caracteres máxima alcanzada","¡Error!",JOptionPane.ERROR_MESSAGE);
        }
        else if(Character.isDigit(validator2)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null," Introduce sólo letras","Error",JOptionPane.ERROR_MESSAGE);
        }
        else if(state == true){
            for(int i = 0; i < nameTextField.getText().length(); i ++){
            
            if((converter.charAt(i) == ' ')||(converter.charAt(i) == '.')){
               state = false;
               counter ++;
               if(counter >= 1){
                   state = false;
                   counter = 0;
                   i ++;
                   evt.consume();
                  JOptionPane.showMessageDialog(null," No puedes introducir dos espacios o puntos seguidos","Error",JOptionPane.ERROR_MESSAGE);
                  
               }
               else if(counter == 0){
                        nameTextFieldKeyTyped(evt);
               }
         
        }
       
        }
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

    private void consultComboBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_consultComboBoxMouseClicked
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_consultComboBoxMouseClicked

    private void consultComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultComboBoxActionPerformed
        // TODO add your handling code here:
        
       if(consultComboBox.getSelectedItem().equals("Id")){
            idTextField.setEnabled(true);
            nameTextField.setEnabled(false);
            namePredictiveSearch.setEnabled(false);
            nameTextField.setText("");
            JOptionPane.showMessageDialog(null,"Has seleccionado consultar por Id"," Consulta por Id",JOptionPane.INFORMATION_MESSAGE);
        }
        else if(consultComboBox.getSelectedItem().equals("Nombre")){
            nameTextField.setEnabled(true);
            idTextField.setEnabled(false);
            namePredictiveSearch.setEnabled(true);
            idTextField.setText("");
            JOptionPane.showMessageDialog(null,"Has seleccionado consultar por nombre"," Consulta por Nombre",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_consultComboBoxActionPerformed

    private void consultComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_consultComboBoxItemStateChanged
        // TODO add your handling code here:
        
        
       
    }//GEN-LAST:event_consultComboBoxItemStateChanged

    
    
    MétodosSDC methods = new MétodosSDC();
    
    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
            //methods.searchProvider(nameTextField.getText(),consultComboBox.getSelectedItem().toString(),tlbDatos);
            //methods.searchProvider(nameTextField.getText(), consultComboBox.getSelectedItem().toString(), providersTable); 
    }//GEN-LAST:event_searchButtonActionPerformed

    private void providersTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_providersTableMouseClicked
        // TODO add your handling code here:
       // if(consultComboBox.getSelectedItem()
            
        
            
        
         
    }//GEN-LAST:event_providersTableMouseClicked

    private void namePredictiveSearchItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_namePredictiveSearchItemStateChanged
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_namePredictiveSearchItemStateChanged

    
    
    
    
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
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel cityLabel;
    private javax.swing.JTextField cityTextField;
    private javax.swing.JLabel colonyLabel;
    private javax.swing.JTextField colonyTextField;
    private javax.swing.JComboBox<String> consultComboBox;
    private javax.swing.JRadioButton consultRadioButton;
    private javax.swing.JLabel cpLabel;
    private javax.swing.JTextField cpTextField;
    private javax.swing.JRadioButton eraseRadioButton;
    private javax.swing.JLabel idLabel;
    private javax.swing.JTextField idTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFondito;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JRadioButton modifyRadioButton;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JComboBox<String> namePredictiveSearch;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JLabel numberLabel;
    private javax.swing.JTextField numberTextField;
    private javax.swing.JTable providersTable;
    private javax.swing.JButton searchButton;
    private javax.swing.JButton setButton;
    private javax.swing.JLabel streetLabel;
    private javax.swing.JTextField streetTextField;
    private javax.swing.JLabel telephoneLabel;
    private javax.swing.JTextField telephoneTextField;
    // End of variables declaration//GEN-END:variables
}
