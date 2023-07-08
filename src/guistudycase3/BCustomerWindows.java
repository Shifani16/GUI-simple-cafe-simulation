/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package guistudycase3;

import StudyCase3.Customer;
import StudyCase3.CustomerGuest;
import StudyCase3.CustomerMember;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class BCustomerWindows extends javax.swing.JFrame {

    CustomerGuest g;
    CustomerMember m;
    public static Map<String, CustomerGuest> guestDB;
    public static Map<String, CustomerMember> memberDB;
    DefaultTableModel model;
    boolean isEditing;
    boolean isPopulated = false;
    private static BCustomerWindows instance;
    Customer currCustomer;

    /**
     * Creates new form GuestWindows
     */
    public BCustomerWindows() {
        initComponents();
        initModel();
        initUI();
        instance = this;
        populateComboBoxCus();
    }

    public void initModel() {
        guestDB = new HashMap<>();
        memberDB = new HashMap<>();
    }

    public void initUI() {
        isEditing = false;
        updateButtons();
        updateFields();
    }

    public void updateButtons() {
        btnSave.setEnabled(isEditing);
        rbGuest.setEnabled(isEditing);
        rbMem.setEnabled(isEditing);
    }

    public void updateFields() {
        txtIDCus.setEnabled(isEditing);
        spnSaldo.setEnabled(isEditing);
        txtNamaCus.setEnabled(isEditing);
        spnTgl.setEnabled(isEditing);
    }

    public void resetFields() {
        cbCus.setSelectedIndex(-1);
        txtIDCus.setText("");
        spnSaldo.setValue(0);
        txtNamaCus.setText("");
        rbGuest.setSelected(false);
        rbMem.setSelected(true);
    }

    public void close() {
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }

    public static BCustomerWindows getInstance() {
        return instance;
    }

    private void populateComboBoxCus() {
        cbCus.removeAllItems();
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();

        Set<String> keys = new HashSet<>();
        keys.addAll(guestDB.keySet());
        keys.addAll(memberDB.keySet());

        comboBoxModel.addElement("");

        for (String key : keys) {
            comboBoxModel.addElement(key);
        }

        cbCus.setSelectedIndex(-1);
        cbCus.setModel(comboBoxModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grp1 = new javax.swing.ButtonGroup();
        jScrollBar1 = new javax.swing.JScrollBar();
        Panel1 = new javax.swing.JPanel();
        TitleGuest = new javax.swing.JLabel();
        lblIDCus = new javax.swing.JLabel();
        txtIDCus = new javax.swing.JTextField();
        lblSaldo = new javax.swing.JLabel();
        spnSaldo = new javax.swing.JSpinner();
        btnSave = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLogGuest = new javax.swing.JTable();
        btnReset = new javax.swing.JButton();
        btnMenuPage = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        rbMem = new javax.swing.JRadioButton();
        rbGuest = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        txtNamaCus = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        spnTgl = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        cbCus = new javax.swing.JComboBox<>();
        btnEdit = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Panel1.setBackground(new java.awt.Color(153, 153, 153));

        TitleGuest.setBackground(new java.awt.Color(51, 51, 51));
        TitleGuest.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        TitleGuest.setForeground(new java.awt.Color(51, 51, 51));
        TitleGuest.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TitleGuest.setText("CUSTOMER");

        javax.swing.GroupLayout Panel1Layout = new javax.swing.GroupLayout(Panel1);
        Panel1.setLayout(Panel1Layout);
        Panel1Layout.setHorizontalGroup(
            Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TitleGuest, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(235, 235, 235))
        );
        Panel1Layout.setVerticalGroup(
            Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TitleGuest, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        lblIDCus.setText("ID Customer");

        txtIDCus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDCusActionPerformed(evt);
            }
        });

        lblSaldo.setText("Saldo ");

        spnSaldo.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 500.0d));

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

        tblLogGuest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Customer", "Nama", "Saldo", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblLogGuest);

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnMenuPage.setText("Menu page");
        btnMenuPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuPageActionPerformed(evt);
            }
        });

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel1.setText("Status");

        grp1.add(rbMem);
        rbMem.setSelected(true);
        rbMem.setText("Member");
        rbMem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMemActionPerformed(evt);
            }
        });

        grp1.add(rbGuest);
        rbGuest.setText("Guest");
        rbGuest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbGuestActionPerformed(evt);
            }
        });

        jLabel2.setText("Nama");

        jLabel3.setText("Tgl. Regis");

        spnTgl.setModel(new javax.swing.SpinnerDateModel());

        jLabel4.setText("Customer");

        cbCus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCusActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblSaldo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblIDCus, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBack))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rbMem, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbGuest, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(spnTgl, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNamaCus, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(spnSaldo, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(40, 40, 40))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtIDCus, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cbCus, javax.swing.GroupLayout.Alignment.LEADING, 0, 161, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btnSave)
                        .addGap(18, 18, 18)
                        .addComponent(btnEdit)
                        .addGap(18, 18, 18)
                        .addComponent(btnReset)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRemove)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMenuPage))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cbCus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblIDCus)
                            .addComponent(txtIDCus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(rbMem)
                            .addComponent(rbGuest))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSaldo)
                            .addComponent(spnSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNamaCus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(spnTgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemove)
                    .addComponent(btnMenuPage)
                    .addComponent(btnReset)
                    .addComponent(btnAdd)
                    .addComponent(btnSave)
                    .addComponent(btnEdit))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIDCusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDCusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDCusActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        isEditing = false;
        updateButtons();
        updateFields();

        String idPel = txtIDCus.getText();
        double saldoAwal = (double) spnSaldo.getValue();
        String namaPel = txtNamaCus.getText();
        Date tgl = (Date) spnTgl.getValue();

        if (rbMem.isSelected()) {
            String status = "MEMBER";
            m = new CustomerMember(namaPel, tgl, saldoAwal);
            m.setSaldoAwal(saldoAwal);
            m.setNamaMember(namaPel);
            m.setTanggalRegis(tgl);

            model = (DefaultTableModel) tblLogGuest.getModel();

            boolean entryExist = false;
            int existingRowIndex = -1;
            for (int i = 0; i < model.getRowCount(); i++) {
                String exist = (String) model.getValueAt(i, 0);
                if (exist.equals(idPel)) {
                    entryExist = true;
                    existingRowIndex = i;
                    break;
                }
            }

            if (entryExist) {
                // Update existing entry
                if (memberDB.containsKey(idPel)) {
                    CustomerMember existingMember = memberDB.get(idPel);
                    existingMember.setNamaMember(namaPel);
                    existingMember.setTanggalRegis(tgl);
                    existingMember.setSaldoAwal(saldoAwal);
                    model.setValueAt(namaPel, existingRowIndex, 1);
                    model.setValueAt(saldoAwal, existingRowIndex, 2);
                }
            } else {
                memberDB.put(idPel, m);
                model.addRow(new Object[]{
                    idPel,
                    namaPel,
                    saldoAwal,
                    status
                });
            }

            

        } else if (rbGuest.isSelected()) {
            String status = "GUEST";
            g = new CustomerGuest(saldoAwal);
            g.setSaldoAwal(saldoAwal);

            model = (DefaultTableModel) tblLogGuest.getModel();
            boolean entryExist = false;
            int existingRowIndex = -1;
            for (int i = 0; i < model.getRowCount(); i++) {
                String exist = (String) model.getValueAt(i, 0);
                if (exist.equals(idPel)) {
                    entryExist = true;
                    existingRowIndex = i;
                    break;
                }
            }

            if (entryExist) {
                // Update existing entry
                if (memberDB.containsKey(idPel)) {
                    CustomerMember existingMember = memberDB.get(idPel);
                    existingMember.setNamaMember(namaPel);
                    existingMember.setTanggalRegis(tgl);
                    existingMember.setSaldoAwal(saldoAwal);
                    model.setValueAt(namaPel, existingRowIndex, 1);
                    model.setValueAt(saldoAwal, existingRowIndex, 2);
                }
            } else {
                guestDB.put(idPel, g);
                model.addRow(new Object[]{
                    idPel,
                    namaPel,
                    saldoAwal,
                    status
                });
            }

            
        }

        tblLogGuest.setModel(model);  // Set the model to the tblLogGuest table

        isPopulated = true;
        populateComboBoxCus();
    }//GEN-LAST:event_btnSaveActionPerformed

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
        model.setRowCount(0);
        guestDB.clear();
        memberDB.clear();

        populateComboBoxCus();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // TODO add your handling code here:
        isEditing = false;
        int selectedRow = tblLogGuest.getSelectedRow();
        if (selectedRow != -1) {
            String idPel = (String) model.getValueAt(selectedRow, 0);
            model.removeRow(selectedRow);
            guestDB.remove(idPel);
            memberDB.remove(idPel);
        }

    }//GEN-LAST:event_btnRemoveActionPerformed

    private void rbMemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMemActionPerformed
        // TODO add your handling code here:
        if (rbMem.isSelected()) {
            isEditing = true;
            txtNamaCus.setEnabled(isEditing);
            spnTgl.setEnabled(isEditing);

            memberDB = BCustomerWindows.memberDB;
        }
    }//GEN-LAST:event_rbMemActionPerformed

    private void rbGuestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbGuestActionPerformed
        // TODO add your handling code here:
        if (rbGuest.isSelected()) {
            isEditing = false;
            txtNamaCus.setEnabled(isEditing);
            spnTgl.setEnabled(isEditing);

            guestDB = BCustomerWindows.guestDB;
        }

    }//GEN-LAST:event_rbGuestActionPerformed

    private void btnMenuPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuPageActionPerformed
        // TODO add your handling code here:
        CMenuWindows mw = new CMenuWindows(guestDB, memberDB);
        close();
        
        mw.setVisible(true);
    }//GEN-LAST:event_btnMenuPageActionPerformed

    private void cbCusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCusActionPerformed
        // TODO add your handling code here:
        isEditing = false;
        updateButtons();
        updateFields();

        JComboBox<String> comboBox = (JComboBox<String>) evt.getSource();
        String selectedItem = (String) comboBox.getSelectedItem();

        currCustomer = null;

        if (selectedItem != null) {
            if (guestDB.containsKey(selectedItem)) {
                currCustomer = guestDB.get(selectedItem);
            } else if (memberDB.containsKey(selectedItem)) {
                currCustomer = memberDB.get(selectedItem);
            }

        } else {
            spnSaldo.setValue(0);
            txtIDCus.setText("");
            txtNamaCus.setText("");
            rbMem.isSelected();
        }

        if (currCustomer instanceof CustomerGuest) {
            txtNamaCus.setEditable(false);
            txtNamaCus.setEnabled(false);
            spnSaldo.setEnabled(false);

            if (currCustomer != null) {
                double saldo = ((CustomerGuest) currCustomer).getSaldoAwal();
                txtIDCus.setText(selectedItem);
                spnSaldo.setValue(saldo);
                rbGuest.isSelected();
            }

        } else if (currCustomer instanceof CustomerMember) {
            txtNamaCus.setEnabled(false);
            txtNamaCus.setEditable(true);
            spnSaldo.setEnabled(false);

            if (currCustomer != null) {
                Date tglRegis = ((CustomerMember) currCustomer).getTanggalRegis();
                double saldo = currCustomer.getSaldoAwal();
                String namaPel = ((CustomerMember) currCustomer).getNamaMember();

                txtIDCus.setText(selectedItem);
                txtNamaCus.setText(namaPel);
                spnSaldo.setValue(saldo);
                spnTgl.setValue(tglRegis);
                rbMem.isSelected();
            }
        }
    }//GEN-LAST:event_cbCusActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        isEditing = true;
        updateButtons();
        updateFields();
        txtIDCus.setEnabled(false);

        String selectedItem = (String) cbCus.getSelectedItem();

        if (selectedItem != null) {
            if (guestDB.containsKey(selectedItem)) {
                currCustomer = guestDB.get(selectedItem);
            } else if (memberDB.containsKey(selectedItem)) {
                currCustomer = memberDB.get(selectedItem);
            }

            if (currCustomer instanceof CustomerGuest) {
                txtNamaCus.setEditable(isEditing);
                spnSaldo.setEnabled(isEditing);

                if (currCustomer != null) {
                    double saldo = ((CustomerGuest) currCustomer).getSaldoAwal();
                    txtIDCus.setText(selectedItem);
                    spnSaldo.setValue(saldo);
                    rbGuest.setSelected(true);
                }

            } else if (currCustomer instanceof CustomerMember) {
                txtNamaCus.setEnabled(isEditing);
                spnTgl.setEnabled(isEditing);

                if (currCustomer != null) {
                    Date tglRegis = ((CustomerMember) currCustomer).getTanggalRegis();
                    double saldo = currCustomer.getSaldoAwal();
                    String namaPel = ((CustomerMember) currCustomer).getNamaMember();

                    txtIDCus.setText(selectedItem);
                    txtNamaCus.setText(namaPel);
                    spnSaldo.setValue(saldo);
                    spnTgl.setValue(tglRegis);
                    rbMem.setSelected(true);
                }
            }
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        AWelcomePage wp = new AWelcomePage();
        close();
        
        wp.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(BCustomerWindows.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BCustomerWindows.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BCustomerWindows.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BCustomerWindows.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                BCustomerWindows gw = new BCustomerWindows();
                gw.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel1;
    private javax.swing.JLabel TitleGuest;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnMenuPage;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cbCus;
    private javax.swing.ButtonGroup grp1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblIDCus;
    private javax.swing.JLabel lblSaldo;
    private javax.swing.JRadioButton rbGuest;
    private javax.swing.JRadioButton rbMem;
    private javax.swing.JSpinner spnSaldo;
    private javax.swing.JSpinner spnTgl;
    private javax.swing.JTable tblLogGuest;
    private javax.swing.JTextField txtIDCus;
    private javax.swing.JTextField txtNamaCus;
    // End of variables declaration//GEN-END:variables
}
