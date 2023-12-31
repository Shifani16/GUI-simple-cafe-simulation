/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package guistudycase3;

import StudyCase3.CustomerGuest;
import StudyCase3.CustomerMember;
import StudyCase3.Menu;
import StudyCase3.MenuMakanan;
import StudyCase3.MenuMinuman;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class CMenuWindows extends javax.swing.JFrame {

    MenuMakanan makan;
    MenuMinuman minum;
    public static Map<String, MenuMakanan> makananDB;
    public static Map<String, MenuMinuman> minumanDB;
    public static Map<String, CustomerGuest> guestDB;
    public static Map<String, CustomerMember> memberDB;
    DefaultTableModel model;
    boolean isEditing;
    boolean isPopulated = false;
    private static CMenuWindows instance;
    Menu currMenu;

    /**
     * Creates new form MenuWindows
     */
    public CMenuWindows() {
        initComponents();
        initModel();
        initUI();
        instance = this;
    }

    public CMenuWindows(Map<String, CustomerGuest> guestDB, Map<String, CustomerMember> memberDB) {
        initComponents();
        initModel();
        initUI();
        this.guestDB = guestDB;
        this.memberDB = memberDB;
        instance = this;
    }

    public void initModel() {
        makananDB = new HashMap<>();
        minumanDB = new HashMap<>();
    }

    public void initUI() {
        isEditing = false;
        updateFields();
        updateButtons();
    }

    public void updateButtons() {
        btnSave.setEnabled(isEditing);
        rbMakanan.setEnabled(isEditing);
        rbMinuman.setEnabled(isEditing);
    }

    public void updateFields() {
        txtIDMenu.setEnabled(isEditing);
        txtNamaMenu.setEnabled(isEditing);
        cbCusType.setEnabled(isEditing && rbMinuman.isSelected());
        spnHarga.setEnabled(isEditing);

    }

    public void resetFields() {
        cbMenu.setSelectedIndex(-1);
        txtIDMenu.setText("");
        txtNamaMenu.setText("");
        rbMakanan.setSelected(true);
        rbMinuman.setSelected(false);
        spnHarga.setValue(0);
        cbCusType.setSelectedIndex(0);
    }

    public void close() {
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }

    public static CMenuWindows getInstance() {
        return instance;
    }

    private void populateComboBoxMenu() {
        cbMenu.removeAllItems();
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();

        Set<String> keys = new HashSet<>();
        keys.addAll(makananDB.keySet());
        keys.addAll(minumanDB.keySet());

        comboBoxModel.addElement("");

        for (String key : keys) {
            comboBoxModel.addElement(key);
        }

        cbMenu.setSelectedIndex(-1);
        cbMenu.setModel(comboBoxModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpBtn1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        TitleMenu = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtNamaMenu = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtIDMenu = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        rbMakanan = new javax.swing.JRadioButton();
        rbMinuman = new javax.swing.JRadioButton();
        spnHarga = new javax.swing.JSpinner();
        btnAdd = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblMenu = new javax.swing.JTable();
        btnRemove = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cbCusType = new javax.swing.JComboBox<>();
        btnEdit = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cbMenu = new javax.swing.JComboBox<>();
        btnBack = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setForeground(new java.awt.Color(102, 102, 102));

        TitleMenu.setBackground(new java.awt.Color(51, 51, 51));
        TitleMenu.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        TitleMenu.setForeground(new java.awt.Color(51, 51, 51));
        TitleMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TitleMenu.setText("Menu");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(215, 215, 215)
                .addComponent(TitleMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TitleMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
        );

        jLabel1.setText("Nama menu");

        jLabel2.setText("Harga");

        jLabel3.setText("ID Menu");

        jLabel4.setText("Jenis Menu");

        grpBtn1.add(rbMakanan);
        rbMakanan.setSelected(true);
        rbMakanan.setText("Makanan");
        rbMakanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMakananActionPerformed(evt);
            }
        });

        grpBtn1.add(rbMinuman);
        rbMinuman.setText("Minuman");
        rbMinuman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMinumanActionPerformed(evt);
            }
        });

        spnHarga.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 500.0d));

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        tblMenu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nama", "Harga", "Jenis"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblMenu);

        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        jLabel5.setText("Custom type");

        cbCusType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "L" }));

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        jLabel6.setText("Menu");

        cbMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMenuActionPerformed(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jButton1.setText("Promo page");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btnSave)
                        .addGap(18, 18, 18)
                        .addComponent(btnEdit)
                        .addGap(18, 18, 18)
                        .addComponent(btnReset))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rbMakanan, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbMinuman, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(spnHarga, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cbCusType, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cbMenu, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNamaMenu, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtIDMenu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(btnBack))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRemove)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(90, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cbMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtIDMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtNamaMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbMakanan)
                            .addComponent(jLabel4)
                            .addComponent(rbMinuman))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cbCusType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(spnHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd)
                            .addComponent(btnSave)
                            .addComponent(btnReset)
                            .addComponent(btnRemove)
                            .addComponent(btnEdit)
                            .addComponent(jButton1))
                        .addGap(19, 19, 19))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here

        String idMenu = txtIDMenu.getText();
        String namaMenu = txtNamaMenu.getText();
        double harga = (double) spnHarga.getValue();

        String jenis = "";
        if (rbMakanan.isSelected()) {
            jenis = "Makanan";
            makan = new MenuMakanan(idMenu, namaMenu, harga);
            makan.setHargaMenu(harga);
            makan.setIDMenu(idMenu);
            makan.setNamaMenu(namaMenu);

            model = (DefaultTableModel) tblMenu.getModel();

            boolean entryExist = false;
            int existingRowIndex = -1;
            for (int i = 0; i < model.getRowCount(); i++) {
                String exist = (String) model.getValueAt(i, 0);
                if (exist.equals(idMenu)) {
                    entryExist = true;
                    existingRowIndex = i;
                    break;
                }
            }

            if (entryExist) {
                if (makananDB.containsKey(idMenu)) {
                    MenuMakanan existingMenu = makananDB.get(idMenu);
                    existingMenu.setNamaMenu(namaMenu);
                    existingMenu.setHargaMenu(harga);
                    model.setValueAt(namaMenu, existingRowIndex, 1);
                    model.setValueAt(harga, existingRowIndex, 2);
                }
            } else {
                makananDB.put(idMenu, makan);
                model.addRow(new Object[]{
                    idMenu,
                    namaMenu,
                    harga,
                    jenis
                });
            }

        } else if (rbMinuman.isSelected()) {
            isEditing = true;
            jenis = "Minuman";
            String custom = (String) cbCusType.getSelectedItem();

            minum = new MenuMinuman(idMenu, namaMenu, harga, custom);
            minum.setHargaMenu(harga);
            minum.setIDMenu(idMenu);
            minum.setNamaMenu(namaMenu);
            minum.setCustomType(custom);

            model = (DefaultTableModel) tblMenu.getModel();

            boolean entryExist = false;
            int existingRowIndex = -1;
            for (int i = 0; i < model.getRowCount(); i++) {
                String exist = (String) model.getValueAt(i, 0);
                if (exist.equals(idMenu)) {
                    entryExist = true;
                    existingRowIndex = i;
                    break;
                }
            }

            if (entryExist) {
                // Update existing entry
                if (minumanDB.containsKey(idMenu)) {
                    MenuMinuman existingMenu = minumanDB.get(idMenu);
                    existingMenu.setNamaMenu(namaMenu);
                    existingMenu.setHargaMenu(harga);
                    existingMenu.setCustomType(custom);
                    model.setValueAt(namaMenu, existingRowIndex, 1);
                    model.setValueAt(harga, existingRowIndex, 2);
                }
            } else {
                minumanDB.put(idMenu, minum);
                model.addRow(new Object[]{
                    idMenu,
                    namaMenu,
                    harga,
                    jenis
                });
            }

        }

        isPopulated = true;
        isEditing = false;
        updateButtons();
        updateFields();
        populateComboBoxMenu();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void rbMakananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMakananActionPerformed
        // TODO add your handling code here:
        if (rbMakanan.isSelected()) {
            updateFields();
        }
    }//GEN-LAST:event_rbMakananActionPerformed

    private void rbMinumanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMinumanActionPerformed
        // TODO add your handling code here:
        if (rbMinuman.isSelected()) {
            isEditing = true;
            updateFields();
        }

    }//GEN-LAST:event_rbMinumanActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        isEditing = true;
        updateButtons();
        updateFields();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        isEditing = false;
        resetFields();
        updateFields();

        model.setRowCount(0);
        makananDB.clear();
        makananDB.clear();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // TODO add your handling code here:
        isEditing = false;
        int selectedRow = tblMenu.getSelectedRow();

        if (selectedRow != -1) {
            String idMenu = (String) model.getValueAt(selectedRow, 0);
            model.removeRow(selectedRow);
            makananDB.remove(idMenu);
            minumanDB.remove(idMenu);
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        isEditing = true;
        updateButtons();
        updateFields();
        txtIDMenu.setEnabled(false);

        String selectedItem = (String) cbMenu.getSelectedItem();

        if (selectedItem != null) {
            if (makananDB.containsKey(selectedItem)) {
                currMenu = makananDB.get(selectedItem);
            } else if (minumanDB.containsKey(selectedItem)) {
                currMenu = minumanDB.get(selectedItem);
            }

            if (currMenu instanceof MenuMakanan) {
                txtNamaMenu.setEnabled(isEditing);
                spnHarga.setEnabled(isEditing);

                if (currMenu != null) {
                    double harga = ((MenuMakanan) currMenu).getHargaMenu();
                    String namaMenu = ((MenuMakanan) currMenu).getNamaMenu();

                    txtNamaMenu.setText(namaMenu);
                    txtIDMenu.setText(selectedItem);
                    spnHarga.setValue(harga);
                    rbMakanan.setSelected(true);
                }

            } else if (currMenu instanceof MenuMinuman) {
                txtNamaMenu.setEnabled(isEditing);
                spnHarga.setEnabled(isEditing);

                if (currMenu != null) {
                    double harga = ((MenuMinuman) currMenu).getHargaMenu();
                    String namaMenu = ((MenuMinuman) currMenu).getNamaMenu();
                    String type = ((MenuMinuman) currMenu).getCustomType();

                    txtNamaMenu.setText(namaMenu);
                    txtIDMenu.setText(selectedItem);
                    spnHarga.setValue(harga);
                    rbMinuman.setSelected(true);
                    cbCusType.setSelectedItem(type);
                }
            }
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void cbMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMenuActionPerformed
        // TODO add your handling code here:
        isEditing = false;
        updateButtons();
        updateFields();

        JComboBox<String> comboBox = (JComboBox<String>) evt.getSource();
        String selectedItem = (String) comboBox.getSelectedItem();

        currMenu = null;

        if (selectedItem != null) {
            if (makananDB.containsKey(selectedItem)) {
                currMenu = makananDB.get(selectedItem);
            } else if (minumanDB.containsKey(selectedItem)) {
                currMenu = minumanDB.get(selectedItem);
            }
        } else {
            txtIDMenu.setText("");
            txtNamaMenu.setText("");
            rbMakanan.isSelected();
            cbCusType.setSelectedIndex(0);
            spnHarga.setValue(0);
        }

        if (currMenu instanceof MenuMakanan) {
            txtIDMenu.setEnabled(isEditing);
            txtNamaMenu.setEnabled(isEditing);
            rbMakanan.setEnabled(isEditing);
            rbMinuman.setEnabled(isEditing);
            spnHarga.setEnabled(isEditing);

            String idMenu = ((MenuMakanan) currMenu).getIDMenu();
            String namaMenu = ((MenuMakanan) currMenu).getNamaMenu();
            double harga = ((MenuMakanan) currMenu).getHargaMenu();

            txtIDMenu.setText(idMenu);
            txtNamaMenu.setText(namaMenu);
            spnHarga.setValue(harga);

        } else if (currMenu instanceof MenuMinuman) {
            txtIDMenu.setEnabled(isEditing);
            txtNamaMenu.setEnabled(isEditing);
            rbMakanan.setEnabled(isEditing);
            rbMinuman.setEnabled(isEditing);
            spnHarga.setEnabled(isEditing);

            String idMenu = ((MenuMinuman) currMenu).getIDMenu();
            String namaMenu = ((MenuMinuman) currMenu).getNamaMenu();
            double harga = ((MenuMinuman) currMenu).getHargaMenu();
            String selected = ((MenuMinuman) currMenu).getCustomType();

            txtIDMenu.setText(idMenu);
            txtNamaMenu.setText(namaMenu);
            spnHarga.setValue(harga);
            cbCusType.setSelectedItem(selected);
        }

    }//GEN-LAST:event_cbMenuActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        BCustomerWindows cw = BCustomerWindows.getInstance();
        close();
        
        if(cw.isPopulated) {
            cw.isPopulated = true;
        }
        
        cw.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        DPromoWindows pw = new DPromoWindows(guestDB, memberDB, makananDB, minumanDB);
        
        close();
        pw.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(CMenuWindows.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CMenuWindows.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CMenuWindows.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CMenuWindows.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CMenuWindows().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TitleMenu;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cbCusType;
    private javax.swing.JComboBox<String> cbMenu;
    private javax.swing.ButtonGroup grpBtn1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JRadioButton rbMakanan;
    private javax.swing.JRadioButton rbMinuman;
    private javax.swing.JSpinner spnHarga;
    private javax.swing.JTable tblMenu;
    private javax.swing.JTextField txtIDMenu;
    private javax.swing.JTextField txtNamaMenu;
    // End of variables declaration//GEN-END:variables
}
