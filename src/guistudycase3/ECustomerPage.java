/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package guistudycase3;

import StudyCase3.Customer;
import StudyCase3.CustomerGuest;
import StudyCase3.CustomerMember;
import StudyCase3.Menu;
import StudyCase3.MenuMakanan;
import StudyCase3.MenuMinuman;
import StudyCase3.Promo;
import StudyCase3.PromoCashBack;
import StudyCase3.PromoDelivery;
import StudyCase3.PromoDisc;
import static guistudycase3.DPromoWindows.promoDB;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import guistudycase3.Receipt;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class ECustomerPage extends javax.swing.JFrame {

    private static Map<String, CustomerGuest> guestDB;
    private static Map<String, CustomerMember> memberDB;
    private static Map<String, MenuMakanan> makananDB;
    private static Map<String, MenuMinuman> minumanDB;
    private static Map<String, Promo> promoDB;
    Customer currCustomer;
    Menu currMenu;
    Promo promo;
    private CMenuWindows mw;
    private BCustomerWindows gw;
    DefaultTableModel model;
    boolean isEditing;

    /**
     * Creates new form CustomerPage
     */
    public ECustomerPage(Map<String, MenuMakanan> makananDB, Map<String, MenuMinuman> minumanDB, Map<String, CustomerGuest> guestDB, Map<String, CustomerMember> memberDB, Map<String, Promo> promoDB) {
        initComponents();
        this.guestDB = guestDB;
        this.memberDB = memberDB;
        this.makananDB = makananDB;
        this.minumanDB = minumanDB;
        this.promoDB = promoDB;
        populateComboBoxCus();
        populateComboBoxMenu();
        populateComboBoxPromo();
        initUI();
    }

    public ECustomerPage() {
        initComponents();
        initUI();
    }

    public ECustomerPage(BCustomerWindows guestWindows) {
        initComponents();
        this.gw = guestWindows;
        initUI();
    }

    public void initUI() {
        isEditing = false;
        updateFields();
        updateButtons();
        cbPromo.setEnabled(false);
        txtPotongan.setEnabled(false);
        btnApply.setEnabled(false);
    }

    public void updateFields() {

        spnQty.setEnabled(isEditing);
        cbPilihCus.setEnabled(isEditing);
        cbMenu.setEnabled(isEditing);
        txtHargaMenu.setEnabled(isEditing);
        txtNamaMenu.setEnabled(isEditing);
        txtSaldo.setEnabled(isEditing);
        txtNamaCus.setEditable(isEditing);
        txtNamaCus.setEnabled(isEditing);
        txtSaldo.setEditable(isEditing);
    }

    public void updateButtons() {
        btnSave.setEnabled(isEditing);
        btnCetak.setEnabled(isEditing);
        btnAdd.setEnabled(isEditing);
        btnCO.setEnabled(isEditing && !btnSave.isEnabled());
        btnAddPromo.setEnabled(isEditing);
    }

    public void resetFields() {
        cbMenu.setSelectedIndex(-1);
        txtNamaCus.setText("");
        txtSaldo.setText("");
        cbPilihCus.setSelectedIndex(-1);
        txtNamaMenu.setText("");
        txtHargaMenu.setText("");
        spnQty.setValue(0);
        cbPromo.setSelectedIndex(-1);
    }

    private void populateComboBoxMenu() {
        cbMenu.removeAllItems();
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();

        comboBoxModel.addElement("");

        for (String key : makananDB.keySet()) {
            comboBoxModel.addElement(key);
        }

        for (String key : minumanDB.keySet()) {
            comboBoxModel.addElement(key);
        }

        cbMenu.setModel(comboBoxModel);
        cbMenu.addActionListener(this::cbMenuActionPerformed);
    }

    private void populateComboBoxCus() {
        cbPilihCus.removeAllItems();
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();

        Set<String> keys = new HashSet<>();
        keys.addAll(guestDB.keySet());
        keys.addAll(memberDB.keySet());

        comboBoxModel.addElement("");

        for (String key : keys) {
            comboBoxModel.addElement(key);
        }

        cbPilihCus.setSelectedIndex(-1);
        cbPilihCus.setModel(comboBoxModel);
    }

    private void populateComboBoxPromo() {
        cbPromo.removeAllItems();
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();

        Set<String> keys = new HashSet<>();
        keys.addAll(promoDB.keySet());

        comboBoxModel.addElement("");

        for (String key : keys) {
            comboBoxModel.addElement(key);
        }

        cbPromo.setSelectedIndex(-1);
        cbPromo.setModel(comboBoxModel);
    }

    public void close() {
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TitleGuest = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblLogGuest = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        TitleGuest1 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbPilihCus = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtNamaCus = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSaldo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCart = new javax.swing.JTable();
        btnLoad = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnCO = new javax.swing.JButton();
        cbMenu = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        spnQty = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        txtHargaMenu = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNamaMenu = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnCetak = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        cbPromo = new javax.swing.JComboBox<>();
        btnApply = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtPotongan = new javax.swing.JTextField();
        btnAddPromo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        btnLihatNota = new javax.swing.JButton();

        TitleGuest.setBackground(new java.awt.Color(51, 51, 51));
        TitleGuest.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        TitleGuest.setForeground(new java.awt.Color(51, 51, 51));
        TitleGuest.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TitleGuest.setText("GUEST");

        tblLogGuest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Customer", "Saldo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblLogGuest);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setForeground(new java.awt.Color(102, 102, 102));

        TitleGuest1.setBackground(new java.awt.Color(51, 51, 51));
        TitleGuest1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        TitleGuest1.setForeground(new java.awt.Color(51, 51, 51));
        TitleGuest1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TitleGuest1.setText("Customer Page");

        btnBack.setText("Adm.Page");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack)
                .addGap(239, 239, 239)
                .addComponent(TitleGuest1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TitleGuest1, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("ID Customer");

        cbPilihCus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPilihCusActionPerformed(evt);
            }
        });

        jLabel2.setText("Nama");

        jLabel3.setText("Saldo");

        jLabel4.setText("Menu");

        tblCart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nama", "Qty", "Subtotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblCart);

        btnLoad.setText("Load");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnCO.setText("Checkout");
        btnCO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCOActionPerformed(evt);
            }
        });

        cbMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMenuActionPerformed(evt);
            }
        });

        jLabel6.setText("Qty");

        spnQty.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabel7.setText("Harga");

        jLabel8.setText("Nama Menu");

        jLabel9.setText("Total");

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnCetak.setText("Cetak nota");
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        jLabel10.setText("Promo");

        cbPromo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPromoActionPerformed(evt);
            }
        });

        btnApply.setText("Apply");
        btnApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApplyActionPerformed(evt);
            }
        });

        jLabel11.setText("Potongan");

        btnAddPromo.setText("Add Promo");
        btnAddPromo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPromoActionPerformed(evt);
            }
        });

        txtArea.setColumns(20);
        txtArea.setRows(5);
        jScrollPane1.setViewportView(txtArea);

        btnLihatNota.setText("Lihat nota");
        btnLihatNota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLihatNotaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdd)
                                .addGap(18, 18, 18)
                                .addComponent(btnSave)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbPilihCus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNamaCus)
                            .addComponent(txtSaldo)
                            .addComponent(cbMenu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(spnQty)
                            .addComponent(txtHargaMenu)
                            .addComponent(txtNamaMenu)
                            .addComponent(cbPromo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPotongan, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnLoad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnReset))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAddPromo)
                        .addGap(18, 18, 18)
                        .addComponent(btnApply)))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRemove)
                        .addGap(18, 18, 18)
                        .addComponent(btnLihatNota))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCO)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCetak))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(cbPilihCus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNamaCus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(cbMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(txtNamaMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtHargaMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(spnQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnAdd)
                                    .addComponent(btnSave))
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(cbPromo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(jLabel11))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(txtPotongan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnApply)
                    .addComponent(btnAddPromo)
                    .addComponent(jLabel9)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLoad)
                    .addComponent(btnReset)
                    .addComponent(btnRemove)
                    .addComponent(btnLihatNota)
                    .addComponent(btnCO)
                    .addComponent(btnCetak))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbPilihCusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPilihCusActionPerformed
        // TODO add your handling code here:
        txtNamaCus.setEditable(false);
        txtNamaCus.setEnabled(false);

        JComboBox<String> comboBox = (JComboBox<String>) evt.getSource();
        String selectedItem = (String) comboBox.getSelectedItem();

        currCustomer = null;

        if (selectedItem != null) {
            if (guestDB.containsKey(selectedItem)) {
                currCustomer = gw.guestDB.get(selectedItem);
            } else if (memberDB.containsKey(selectedItem)) {
                currCustomer = gw.memberDB.get(selectedItem);
            }

        } else {
            txtSaldo.setText("");
        }

        if (currCustomer instanceof CustomerGuest) {
            txtNamaCus.setEditable(false);
            txtNamaCus.setEnabled(false);
            txtSaldo.setEditable(false);
            txtPotongan.setEditable(false);
            txtPotongan.setEnabled(false);
            cbPromo.setEditable(false);
            cbPromo.setEnabled(false);
            btnApply.setEnabled(false);
            btnAddPromo.setEnabled(false);

            if (currCustomer != null) {
                double saldo = currCustomer.getSaldoAwal();
                txtSaldo.setText(String.valueOf(saldo));
            }

        } else if (currCustomer instanceof CustomerMember) {
            Date registrationDate = ((CustomerMember) currCustomer).getTanggalRegis();
            LocalDate registrationDateLocal = registrationDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate today = LocalDate.now();

            long selisihHari = DAYS.between(registrationDateLocal, today);

            if (currCustomer != null) {
                double saldo = currCustomer.getSaldoAwal();
                String namaPel = ((CustomerMember) currCustomer).getNamaMember();
                txtNamaCus.setText(namaPel);
                txtSaldo.setText(String.valueOf(saldo));

                if (selisihHari >= 30) {
                    txtNamaCus.setEnabled(true);
                    txtNamaCus.setEditable(false);
                    txtSaldo.setEditable(false);

                } else {
                    txtSaldo.setEditable(false);
                    txtPotongan.setEditable(false);
                    txtPotongan.setEnabled(false);
                    cbPromo.setEditable(false);
                    cbPromo.setEnabled(false);
                    btnApply.setEnabled(false);
                }
            }
        }
    }//GEN-LAST:event_cbPilihCusActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        btnCO.setEnabled(true);
        isEditing = false;
        updateFields();
        btnSave.setEnabled(isEditing);
        btnCetak.setEnabled(isEditing);
        btnApply.setEnabled(isEditing);
        btnLoad.setEnabled(isEditing);

        model = (DefaultTableModel) tblCart.getModel();

        String idMenu = (String) cbMenu.getSelectedItem();
        String nama = txtNamaMenu.getText();
        int qty = (int) spnQty.getValue();
        double harga = Double.parseDouble(txtHargaMenu.getText());
        double subtotal = qty * harga;

        if (qty == 0) {
            System.out.println("qty tidak boleh 0!");
        } else {
            model.addRow(new Object[]{
                idMenu,
                nama,
                qty,
                subtotal
            });

            txtTotal.setEditable(false);

            int sum = 0;

            for (int i = 0; i < tblCart.getRowCount(); i++) {
                sum += Double.parseDouble(tblCart.getValueAt(i, 3).toString());
            }

            txtTotal.setText(String.valueOf(sum));

            cbPilihCus.setEnabled(false);
            txtNamaCus.setEnabled(false);
            txtSaldo.setEnabled(false);
        }


    }//GEN-LAST:event_btnSaveActionPerformed

    private void cbMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMenuActionPerformed
        // TODO add your handling code here:
        txtHargaMenu.setEditable(false);
        txtNamaMenu.setEditable(false);

        JComboBox<String> comboBox = (JComboBox<String>) evt.getSource();
        String selectedItem = (String) comboBox.getSelectedItem();

        currMenu = null;

        if (selectedItem != null) {
            if (makananDB.containsKey(selectedItem)) {
                currMenu = makananDB.get(selectedItem);
            } else if (minumanDB.containsKey(selectedItem)) {
                currMenu = minumanDB.get(selectedItem);
            }
        }

        if (currMenu != null) {
            String idMenu = currMenu.getIDMenu();
            double harga = currMenu.getHargaMenu();

            txtNamaMenu.setText(currMenu.getNamaMenu());
            txtHargaMenu.setText(String.valueOf(harga));
        } else {
            txtNamaMenu.setText("");
            txtHargaMenu.setText("");
        }
    }//GEN-LAST:event_cbMenuActionPerformed

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        // TODO add your handling code here:
        isEditing = true;
        btnSave.setEnabled(isEditing);
        btnCetak.setEnabled(false);
        btnAdd.setEnabled(isEditing);
        btnAddPromo.setEnabled(isEditing);
        btnApply.setEnabled(false);
        txtPotongan.setEnabled(false);
        cbPromo.setEnabled(false);
        btnCO.setEnabled(isEditing && !btnSave.isEnabled());
        updateFields();
        btnCO.setEnabled(true);
        
    }//GEN-LAST:event_btnLoadActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        cbMenu.setEnabled(true);
        cbPilihCus.setEnabled(false);
        txtNamaCus.setEnabled(false);
        txtSaldo.setEnabled(false);
        btnCetak.setEnabled(false);
        btnSave.setEnabled(true);
        btnLoad.setEnabled(false);

        txtNamaMenu.setEnabled(true);
        txtHargaMenu.setEnabled(true);
        spnQty.setEnabled(true);

        isEditing = true;
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblCart.getSelectedRow();
        if (selectedRow != -1) {
            String idPel = (String) model.getValueAt(selectedRow, 0);
            model.removeRow(selectedRow);
            
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnCOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCOActionPerformed
        // TODO add your handling code here:
        String saldoString = txtSaldo.getText();
        double saldo = Double.parseDouble(saldoString);

        String totalString = txtTotal.getText();
        double total = Double.parseDouble(totalString);

        if (total > saldo) {
            JOptionPane.showMessageDialog(this, "Saldo tidak mencukupi!");
        } else {
            int yes_no = JOptionPane.showConfirmDialog(this, "Check out?", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION);

            if (yes_no == JOptionPane.YES_OPTION) {
                btnCetak.setEnabled(true);
            } else {
                btnCetak.setEnabled(false);
            }
        }


    }//GEN-LAST:event_btnCOActionPerformed

    private void cbPromoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPromoActionPerformed
        // TODO add your handling code here:
        txtPotongan.setEditable(false);
        
        JComboBox<String> comboBox = (JComboBox<String>) evt.getSource();
        String selectedItem = (String) comboBox.getSelectedItem();
        
        promo = null;
        
        if (selectedItem != null) {
            if (promoDB.containsKey(selectedItem)) {
                promo = promoDB.get(selectedItem);
            }
        }

        if (promo != null) {
            int potongan = promo.getPersenPotongan();

            txtPotongan.setText(String.valueOf(potongan));
          
        } else {
            txtNamaMenu.setText("");

        }
        
    }//GEN-LAST:event_cbPromoActionPerformed

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Nota berhasil dicetak!");
        Receipt receipt = new Receipt();

        String saldoString = txtSaldo.getText();
        double saldo = Double.parseDouble(saldoString);

        String totalString = txtTotal.getText();
        double total = Double.parseDouble(totalString);
        double totalPlesOngkir = total + currCustomer.getOngkir();

        double sisaSaldo = saldo - totalPlesOngkir;

        String output = "";
        
        if (promo instanceof PromoDisc) {
            output += "============= CAFE FILKOM ==============";
            output += "\nID Customer : " + cbPilihCus.getSelectedItem();
            output += "\nNama :" + txtNamaCus.getText();
            output += "\nTanggal : " + LocalDate.now();
            output += "\n=======================================";

            output += "\nID\tNama\tQty\tSubtotal";
            output += "\n----------------------------------------------------------------\n";
            double totalHarga = 0;
            
            double totalCart = 0;
            for (int i = 0; i < tblCart.getRowCount(); i++) {
                String idMenu = (String) tblCart.getValueAt(i, 0);
                String nama = (String) tblCart.getValueAt(i, 1);
                int qty = (int) tblCart.getValueAt(i, 2);
                double subtotal = (double) tblCart.getValueAt(i, 3);
                
                output += idMenu + "\t" + nama + "\t" + qty + "\t" + subtotal + "\n";
                
                totalCart += subtotal;

            }
            output += "\n----------------------------------------------------------------";
            output += "\nTotal : \t\t" + (totalCart + currCustomer.getOngkir());
            output += "\nPromo : " + cbPromo.getSelectedItem() + "\t    -" + (totalCart - total);
            output += "\nOngkir : \t\t" + currCustomer.getOngkir();
            output += "\n----------------------------------------------------------------";
            output += "\nTotal : \t\t" + totalPlesOngkir;
            output += "\nSaldo : \t\t" + sisaSaldo;
            output += "\n=======================================";
            
        }
        
        if (promo instanceof PromoCashBack) {
            int potongan = Integer.parseInt(txtPotongan.getText());
            double hargaPromo = (potongan / 100.0) * total;
            
            output += "============= CAFE FILKOM ==============";
            output += "\nID Customer : " + cbPilihCus.getSelectedItem();
            output += "\nNama :" + txtNamaCus.getText();
            output += "\nTanggal : " + LocalDate.now();
            output += "\n=======================================";
            
            output += "\nID\tNama\tQty\tSubtotal";
            output += "\n----------------------------------------------------------------\n";
            
            double totalCart = 0;
            for (int i = 0; i < tblCart.getRowCount(); i++) {
                String idMenu = (String) tblCart.getValueAt(i, 0);
                String nama = (String) tblCart.getValueAt(i, 1);
                int qty = (int) tblCart.getValueAt(i, 2);
                double subtotal = (double) tblCart.getValueAt(i, 3);
                
                output += idMenu + "\t" + nama + "\t" + qty + "\t" + subtotal + "\n";
                
                totalCart += subtotal;

            }
            output += "\n----------------------------------------------------------------";
            output += "\nTotal : \t\t" + (totalCart);
            output += "\nOngkir : \t\t" + currCustomer.getOngkir();
            output += "\n----------------------------------------------------------------";
            output += "\nPromo : " + cbPromo.getSelectedItem() + "\t    " + hargaPromo;
            output += "\nTotal : \t\t" + totalPlesOngkir;
            output += "\nSisa saldo : \t\t" + (saldo - totalPlesOngkir);
            output += "\n=======================================";
        }
        
        if (promo instanceof PromoDelivery) {
            output += "============= CAFE FILKOM ==============";
            output += "\nID Customer : " + cbPilihCus.getSelectedItem();
            output += "\nNama :" + txtNamaCus.getText();
            output += "\nTanggal : " + LocalDate.now();
            output += "\n=======================================";

            output += "\nID\tNama\tQty\tSubtotal";
            output += "\n----------------------------------------------------------------\n";
            double totalHarga = 0;
            
            double totalCart = 0;
            for (int i = 0; i < tblCart.getRowCount(); i++) {
                String idMenu = (String) tblCart.getValueAt(i, 0);
                String nama = (String) tblCart.getValueAt(i, 1);
                int qty = (int) tblCart.getValueAt(i, 2);
                double subtotal = (double) tblCart.getValueAt(i, 3);
                
                output += idMenu + "\t" + nama + "\t" + qty + "\t" + subtotal + "\n";
                
                totalCart += subtotal;

            }
            output += "\n----------------------------------------------------------------";
            output += "\nTotal : \t\t" + (totalCart + currCustomer.getOngkir());
            output += "\nPromo : " + cbPromo.getSelectedItem() + "\t    -" + (currCustomer.getOngkir());
            output += "\nOngkir : \t\t" + currCustomer.getOngkir();
            output += "\n----------------------------------------------------------------";
            output += "\nTotal : \t\t" + total;
            output += "\nSaldo : \t\t" + (saldo - total);
            output += "\n=======================================";
        }
       
        

        close();

        receipt.txtArea.setText(output);
        receipt.setVisible(true);
    }//GEN-LAST:event_btnCetakActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        BCustomerWindows cw = BCustomerWindows.getInstance();

        if (cw.isPopulated) {
            cw.isPopulated = true;
        }

        cw.setVisible(true);
        close();

    }//GEN-LAST:event_btnBackActionPerformed

    private void btnApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApplyActionPerformed
        // TODO add your handling code here:
        double totalHarga = Double.parseDouble(txtTotal.getText());
        Date promoAwal = promo.getTanggalAwal();
        Date promoAkhir = promo.getTanggalAkhir();
        LocalDate tanggalPromoAwal = promoAwal.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate tanggalPromoAkhir = promoAkhir.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate today = LocalDate.now();
        
        if (today.isBefore(tanggalPromoAwal) || today.isAfter(tanggalPromoAkhir)) {
            System.out.println("Tidak berlaku!");
        }
        else if (promo.getMinPembelian() >= totalHarga ) {
            System.out.println("Tidak memenuhi!");
        }
        else {
            if (promo instanceof PromoDisc) {
                int potongan = Integer.parseInt(txtPotongan.getText());
                double total = Double.parseDouble(txtTotal.getText());
                double currTotal = (potongan / 100.0) * total;
                
                txtTotal.setText(String.valueOf(total - currTotal));
              
            } else if (promo instanceof PromoCashBack) {
                int potongan = Integer.parseInt(txtPotongan.getText());
                double saldo = Double.parseDouble(txtSaldo.getText());
                double total = Double.parseDouble(txtTotal.getText());
                double currTotal = (potongan / 100.0) * total;
              
                txtSaldo.setText(String.valueOf(currTotal + saldo));

            } else if (promo instanceof PromoDelivery) {
                currCustomer.setOngkir(0);
            }
        }
       
        
        isEditing = false;
        btnApply.setEnabled(isEditing);
        
    }//GEN-LAST:event_btnApplyActionPerformed

    private void btnAddPromoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPromoActionPerformed
        // TODO add your handling code here:
        double total = Double.parseDouble(txtTotal.getText());
        if (currCustomer instanceof CustomerMember) {
            Date registrationDate = ((CustomerMember) currCustomer).getTanggalRegis();
            LocalDate registrationDateLocal = registrationDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate today = LocalDate.now();
            
            long selisihHari = DAYS.between(registrationDateLocal, today);
            if (selisihHari <= 30) {
                isEditing = false;
                cbPromo.setEnabled(isEditing);
                txtPotongan.setEnabled(isEditing);
                btnApply.setEnabled(isEditing);
            } else {
                btnApply.setEnabled(true);
                isEditing = true;
                cbPromo.setEnabled(isEditing);
                txtPotongan.setEnabled(isEditing);
                btnApply.setEnabled(isEditing);
            }
            
            
        } else if (currCustomer instanceof CustomerGuest) {
            txtSaldo.setEditable(false);
            txtPotongan.setEditable(false);
            txtPotongan.setEnabled(false);
            cbPromo.setEditable(false);
            cbPromo.setEnabled(false);
            btnApply.setEnabled(false);
        }
 {
            
        }
        
        
    }//GEN-LAST:event_btnAddPromoActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        isEditing = false;
        resetFields();
        updateFields();
        model.setRowCount(0);
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnLihatNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLihatNotaActionPerformed
        // TODO add your handling code here:
        double saldo = Double.parseDouble(txtSaldo.getText());

        String totalString = txtTotal.getText();
        double total = Double.parseDouble(txtTotal.getText());
        double totalPlesOngkir = Double.parseDouble(totalString) + currCustomer.getOngkir();
        String output = "";
        
        if (promo instanceof PromoDisc) {
            
            output += "============= CAFE FILKOM ==============";
            output += "\nID Customer : " + cbPilihCus.getSelectedItem();
            output += "\nNama :" + txtNamaCus.getText();
            output += "\n=======================================";
            
            output += "\nID\tNama\tQty\tSubtotal";
            output += "\n----------------------------------------------------------------\n";
            
            double totalCart = 0;
            for (int i = 0; i < tblCart.getRowCount(); i++) {
                String idMenu = (String) tblCart.getValueAt(i, 0);
                String nama = (String) tblCart.getValueAt(i, 1);
                int qty = (int) tblCart.getValueAt(i, 2);
                double subtotal = (double) tblCart.getValueAt(i, 3);
                
                output += idMenu + "\t" + nama + "\t" + qty + "\t" + subtotal + "\n";
                
                totalCart += subtotal;

            }
            output += "\n----------------------------------------------------------------";
            output += "\nTotal : \t\t" + (totalCart + currCustomer.getOngkir());
            output += "\nPromo : " + cbPromo.getSelectedItem() + "\t    -" + (totalCart - total);
            output += "\nOngkir : \t\t" + currCustomer.getOngkir();
            output += "\n----------------------------------------------------------------";
            output += "\nTotal : \t\t" + totalPlesOngkir;
            output += "\nSaldo : \t\t" + saldo;
            output += "\n=======================================";
        }
        
        if (promo instanceof PromoCashBack) {
            int potongan = Integer.parseInt(txtPotongan.getText());
            double hargaPromo = (potongan / 100.0) * total;
            
            output += "============= CAFE FILKOM ==============";
            output += "\nID Customer : " + cbPilihCus.getSelectedItem();
            output += "\nNama :" + txtNamaCus.getText();
            output += "\n=======================================";
            
            output += "\nID\tNama\tQty\tSubtotal";
            output += "\n----------------------------------------------------------------\n";
            
            double totalCart = 0;
            for (int i = 0; i < tblCart.getRowCount(); i++) {
                String idMenu = (String) tblCart.getValueAt(i, 0);
                String nama = (String) tblCart.getValueAt(i, 1);
                int qty = (int) tblCart.getValueAt(i, 2);
                double subtotal = (double) tblCart.getValueAt(i, 3);
                
                output += idMenu + "\t" + nama + "\t" + qty + "\t" + subtotal + "\n";
                
                totalCart += subtotal;

            }
            output += "\n----------------------------------------------------------------";
            output += "\nTotal : \t\t" + (totalCart);
            output += "\nOngkir : \t\t" + currCustomer.getOngkir();
            output += "\n----------------------------------------------------------------";
            output += "\nPromo : " + cbPromo.getSelectedItem() + "\t    " + hargaPromo;
            output += "\nTotal : \t\t" + totalPlesOngkir;
            output += "\nSaldo : \t\t" + (saldo - hargaPromo);
            output += "\n=======================================";
        }
        
        if (promo instanceof PromoDelivery) {
            output += "============= CAFE FILKOM ==============";
            output += "\nID Customer : " + cbPilihCus.getSelectedItem();
            output += "\nNama :" + txtNamaCus.getText();
            output += "\n=======================================";
            
            output += "\nID\tNama\tQty\tSubtotal";
            output += "\n----------------------------------------------------------------\n";
            
            double totalCart = 0;
            for (int i = 0; i < tblCart.getRowCount(); i++) {
                String idMenu = (String) tblCart.getValueAt(i, 0);
                String nama = (String) tblCart.getValueAt(i, 1);
                int qty = (int) tblCart.getValueAt(i, 2);
                double subtotal = (double) tblCart.getValueAt(i, 3);
                
                output += idMenu + "\t" + nama + "\t" + qty + "\t" + subtotal + "\n";
                
                totalCart += subtotal;

            }
            output += "\n----------------------------------------------------------------";
            output += "\nTotal : \t\t" + (totalCart + currCustomer.getOngkir());
            output += "\nPromo : " + cbPromo.getSelectedItem() + "\t    -" + (currCustomer.getOngkir());
            output += "\nOngkir : \t\t" + currCustomer.getOngkir();
            output += "\n----------------------------------------------------------------";
            output += "\nTotal : \t\t" + total;
            output += "\nSaldo : \t\t" + saldo;
            output += "\n=======================================";
        }
        
        
        txtArea.setText(output);
    }//GEN-LAST:event_btnLihatNotaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ECustomerPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ECustomerPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ECustomerPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ECustomerPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ECustomerPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TitleGuest;
    private javax.swing.JLabel TitleGuest1;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddPromo;
    private javax.swing.JButton btnApply;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCO;
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnLihatNota;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cbMenu;
    private javax.swing.JComboBox<String> cbPilihCus;
    private javax.swing.JComboBox<String> cbPromo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSpinner spnQty;
    private javax.swing.JTable tblCart;
    private javax.swing.JTable tblLogGuest;
    private javax.swing.JTextArea txtArea;
    private javax.swing.JTextField txtHargaMenu;
    private javax.swing.JTextField txtNamaCus;
    private javax.swing.JTextField txtNamaMenu;
    private javax.swing.JTextField txtPotongan;
    private javax.swing.JTextField txtSaldo;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
