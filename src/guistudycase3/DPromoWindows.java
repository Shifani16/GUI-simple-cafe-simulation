/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package guistudycase3;

import StudyCase3.CustomerGuest;
import StudyCase3.CustomerMember;
import StudyCase3.MenuMakanan;
import StudyCase3.MenuMinuman;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import StudyCase3.Promo;
import StudyCase3.PromoCashBack;
import StudyCase3.PromoDelivery;
import StudyCase3.PromoDisc;
import static java.time.LocalDate.now;
import java.util.Date;
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
public class DPromoWindows extends javax.swing.JFrame {

    Promo promo;
    MenuMakanan makan;
    MenuMinuman minum;
    public static Map<String, Promo> promoDB;
    public static Map<String, MenuMakanan> makananDB;
    public static Map<String, MenuMinuman> minumanDB;
    public static Map<String, CustomerGuest> guestDB;
    public static Map<String, CustomerMember> memberDB;
    DefaultTableModel model;
    boolean isEditing;
    boolean isPopulated = true;
    private static DPromoWindows instance;
    PromoDisc diskon;
    PromoCashBack cashback;
    PromoDelivery deliv;

    /**
     * Creates new form PromoWindow
     */
    public DPromoWindows() {
        initComponents();
        initModel();
        initUI();
        populateComboBoxPromo();
    }

    public DPromoWindows(Map<String, CustomerGuest> guestDB, Map<String, CustomerMember> memberDB, Map<String, MenuMakanan> makananDB, Map<String, MenuMinuman> minumanDB) {
        initComponents();
        initModel();
        initUI();
        instance = this;
        this.guestDB = guestDB;
        this.memberDB = memberDB;
        this.makananDB = makananDB;
        this.minumanDB = minumanDB;
        populateComboBoxPromo();
}

    

    public void initModel() {
        promoDB = new HashMap<>();
        guestDB = new HashMap<>();
        memberDB = new HashMap<>();
        makananDB = new HashMap<>();
        minumanDB = new HashMap<>();
    }
    
    public void initUI() {
        isEditing = false;
        updateButton();
        updateFields();
    }
    
    public void updateButton() {
        btnSave.setEnabled(isEditing);
        rbDiskon.setEnabled(isEditing);
        rbCashback.setEnabled(isEditing);
        rbOngkir.setEnabled(isEditing);
        
    }
    
    public void updateFields() {
        txtKode.setEnabled(isEditing);
        spnPersen.setEnabled(isEditing);
        spnMaksPot.setEnabled(isEditing);
        spnMin.setEnabled(isEditing);
        spnTglBerlaku.setEnabled(isEditing);
        spnTglExpired.setEnabled(isEditing);
       
    }

    public void resetFields() {
        txtKode.setText("");
        cbPromo.setSelectedIndex(-1);
        spnPersen.setValue(0);
        rbDiskon.setSelected(true);
    }

    public void close() {
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
        this.dispose();
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        TitlePromo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbPromo = new javax.swing.JComboBox<>();
        txtKode = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        spnPersen = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        rbDiskon = new javax.swing.JRadioButton();
        rbCashback = new javax.swing.JRadioButton();
        rbOngkir = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        spnTglBerlaku = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        spnTglExpired = new javax.swing.JSpinner();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPromo = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnRmv = new javax.swing.JButton();
        btnCusPage = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        spnMaksPot = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        spnMin = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setForeground(new java.awt.Color(102, 102, 102));

        TitlePromo.setBackground(new java.awt.Color(51, 51, 51));
        TitlePromo.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        TitlePromo.setForeground(new java.awt.Color(51, 51, 51));
        TitlePromo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TitlePromo.setText("Promo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addComponent(TitlePromo, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TitlePromo, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
        );

        jLabel1.setText("Promo");

        jLabel2.setText("Kode Promo");

        cbPromo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPromoActionPerformed(evt);
            }
        });

        jLabel3.setText("Potongan (%)");

        spnPersen.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 5));

        jLabel4.setText("Jenis Promo");

        buttonGroup1.add(rbDiskon);
        rbDiskon.setSelected(true);
        rbDiskon.setText("Diskon");

        buttonGroup1.add(rbCashback);
        rbCashback.setText("Cashback");

        buttonGroup1.add(rbOngkir);
        rbOngkir.setText("Ongkir");

        jLabel5.setText("Tgl. Berlaku");

        spnTglBerlaku.setModel(new javax.swing.SpinnerDateModel());

        jLabel6.setText("Tgl. Expired");

        spnTglExpired.setModel(new javax.swing.SpinnerDateModel());

        tblPromo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Promo", "Potongan", "Jenis", "Tgl Berlaku", "Tgl Exp"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblPromo);

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

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

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnRmv.setText("Remove");
        btnRmv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRmvActionPerformed(evt);
            }
        });

        btnCusPage.setText("Cus Page");
        btnCusPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCusPageActionPerformed(evt);
            }
        });

        jLabel7.setText("Maks. Potongan");

        spnMaksPot.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 500.0d));

        jLabel8.setText("Min. Pembelian");

        spnMin.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 500.0d));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btnBack)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdd)
                                .addGap(18, 18, 18)
                                .addComponent(btnSave)))
                        .addGap(18, 18, 18)
                        .addComponent(btnEdit)
                        .addGap(18, 18, 18)
                        .addComponent(btnReset))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(spnMaksPot)
                                .addComponent(cbPromo, 0, 159, Short.MAX_VALUE)
                                .addComponent(txtKode)
                                .addComponent(spnPersen))
                            .addComponent(spnTglExpired, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spnMin, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(spnTglBerlaku, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
                                .addGap(27, 27, 27)
                                .addComponent(rbDiskon, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbCashback, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(rbOngkir, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRmv)
                        .addGap(134, 134, 134)
                        .addComponent(btnCusPage))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBack)
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cbPromo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spnPersen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spnMaksPot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(spnMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rbDiskon)
                                .addComponent(rbCashback)
                                .addComponent(rbOngkir)))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(spnTglBerlaku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(spnTglExpired, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnSave)
                    .addComponent(btnEdit)
                    .addComponent(btnReset)
                    .addComponent(btnRmv)
                    .addComponent(btnCusPage))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        CMenuWindows mw = CMenuWindows.getInstance();

        if (mw.isPopulated) {
            mw.isPopulated = true;
        }

        mw.setVisible(true);
        close();


    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        isEditing = false;
        updateButton();
        updateFields();
        
        String kodePromo = txtKode.getText();
        Date tanggalAwal = (Date) spnTglBerlaku.getValue();
        Date tanggalAkhir = (Date) spnTglExpired.getValue();
        int persen = (int) spnPersen.getValue();
        double maks = (double) spnMaksPot.getValue();
        double minPembelian = (double) spnMin.getValue();
        
        model = (DefaultTableModel) tblPromo.getModel();

        String jenis = "";
        if (rbDiskon.isSelected()) {
            jenis = "DISCOUNT";

            PromoDisc disc = new PromoDisc(kodePromo, tanggalAwal, tanggalAkhir, persen, maks, minPembelian, jenis);
            boolean entryExist = false;
            int existingRowIndex = -1;
            for (int i = 0; i < model.getRowCount(); i++) {
                String exist = (String) model.getValueAt(i, 0);
                if (exist.equals(kodePromo)) {
                    entryExist = true;
                    existingRowIndex = i;
                    break;
                }
            }
            if (entryExist) {
                if (promoDB.containsKey(kodePromo)) {
                    PromoDisc existingPromo = (PromoDisc) promoDB.get(kodePromo);
                    existingPromo.setKodePromo(kodePromo);
                    existingPromo.setJenisPromo(jenis);
                    existingPromo.setPersenPotongan(persen);
                    existingPromo.setMaksPotongan(maks);
                    existingPromo.setMinPembelian(minPembelian);
                    existingPromo.setTanggalAwal(tanggalAwal);
                    existingPromo.setTanggalAkhir(tanggalAkhir);
                    
                    model.setValueAt(kodePromo, existingRowIndex, 1);
                    model.setValueAt(persen, existingRowIndex, 2);
                }
            } else {
                promoDB.put(kodePromo, disc);
                model.addRow(new Object[]{
                    kodePromo,
                    persen,
                    jenis,
                    tanggalAwal,
                    tanggalAkhir
                });
            }
        
        } else if (rbCashback.isSelected()) {
            jenis = "CASHBACK";

            PromoCashBack cb = new PromoCashBack(kodePromo, tanggalAwal, tanggalAkhir, persen, maks, minPembelian, jenis);
            boolean entryExist = false;
            int existingRowIndex = -1;
            for (int i = 0; i < model.getRowCount(); i++) {
                String exist = (String) model.getValueAt(i, 0);
                if (exist.equals(kodePromo)) {
                    entryExist = true;
                    existingRowIndex = i;
                    break;
                }
            }
            if (entryExist) {
                if (promoDB.containsKey(kodePromo)) {
                    PromoDisc existingPromo = (PromoDisc) promoDB.get(kodePromo);
                    existingPromo.setKodePromo(kodePromo);
                    existingPromo.setJenisPromo(jenis);
                    existingPromo.setPersenPotongan(persen);
                    existingPromo.setMaksPotongan(maks);
                    existingPromo.setMinPembelian(minPembelian);
                    existingPromo.setTanggalAwal(tanggalAwal);
                    existingPromo.setTanggalAkhir(tanggalAkhir);
                    
                    model.setValueAt(kodePromo, existingRowIndex, 1);
                    model.setValueAt(persen, existingRowIndex, 2);
                }
            } else {
               promoDB.put(kodePromo, cb);
                model.addRow(new Object[]{
                    kodePromo,
                    persen,
                    jenis,
                    tanggalAwal,
                    tanggalAkhir
                });
            }
        } else if (rbOngkir.isSelected()) {
            jenis = "DELIVERY";

            PromoDelivery pd = new PromoDelivery(kodePromo, tanggalAwal, tanggalAkhir, persen, maks, minPembelian, jenis);
            boolean entryExist = false;
            int existingRowIndex = -1;
            for (int i = 0; i < model.getRowCount(); i++) {
                String exist = (String) model.getValueAt(i, 0);
                if (exist.equals(kodePromo)) {
                    entryExist = true;
                    existingRowIndex = i;
                    break;
                }
            }
            if (entryExist) {
                if (promoDB.containsKey(kodePromo)) {
                    PromoDisc existingPromo = (PromoDisc) promoDB.get(kodePromo);
                    existingPromo.setKodePromo(kodePromo);
                    existingPromo.setJenisPromo(jenis);
                    existingPromo.setPersenPotongan(persen);
                    existingPromo.setMaksPotongan(maks);
                    existingPromo.setMinPembelian(minPembelian);
                    existingPromo.setTanggalAwal(tanggalAwal);
                    existingPromo.setTanggalAkhir(tanggalAkhir);
                    
                    model.setValueAt(kodePromo, existingRowIndex, 1);
                    model.setValueAt(persen, existingRowIndex, 2);
                }
            } else {
               promoDB.put(kodePromo, pd);
                model.addRow(new Object[]{
                    kodePromo,
                    persen,
                    jenis,
                    tanggalAwal,
                    tanggalAkhir
                });
            }
        }
        
        isPopulated = true;
        populateComboBoxPromo();

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        isEditing = true;
        updateButton();
        updateFields();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnCusPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCusPageActionPerformed
        // TODO add your handling code here:
        ECustomerPage cp = new ECustomerPage(makananDB, minumanDB, guestDB, memberDB, promoDB);
        close();
        
        cp.setVisible(true);
    }//GEN-LAST:event_btnCusPageActionPerformed

    private void cbPromoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPromoActionPerformed
        // TODO add your handling code here:
        isEditing = false;
        updateButton();
        updateFields();
        
        JComboBox<String> comboBox = (JComboBox<String>) evt.getSource();
        String selectedItem = (String) comboBox.getSelectedItem();
        
        promo = null;
        
        if (selectedItem != null) {
            if (promoDB.containsKey(selectedItem)) {
                promo = promoDB.get(selectedItem);
            }
        }
        
        if (promo instanceof PromoDisc) {
            txtKode.setEnabled(isEditing);
            rbDiskon.setSelected(true);
            spnMaksPot.setEnabled(isEditing);
            spnMin.setEnabled(isEditing);
            spnPersen.setEnabled(isEditing);
            spnTglBerlaku.setEnabled(isEditing);
            spnTglExpired.setEnabled(isEditing);
            
            String kode = ((PromoDisc)promo).getKodePromo();
            int potongan = ((PromoDisc)promo).getPersenPotongan();
            double maksPot = ((PromoDisc)promo).getMaksPotongan();
            double minBel = ((PromoDisc)promo).getMinPembelian();
            Date tglBerlaku = ((PromoDisc)promo).getTanggalAwal();
            Date tglBerakhir = ((PromoDisc)promo).getTanggalAkhir();
            
            txtKode.setText(kode);
            spnPersen.setValue(potongan);
            spnMaksPot.setValue(maksPot);
            spnMin.setValue(minBel);
            spnTglBerlaku.setValue(tglBerlaku);
            spnTglExpired.setValue(tglBerakhir);
            
        } else if (promo instanceof PromoCashBack) {
            txtKode.setEnabled(isEditing);
            rbDiskon.setSelected(true);
            spnMaksPot.setEnabled(isEditing);
            spnMin.setEnabled(isEditing);
            spnPersen.setEnabled(isEditing);
            spnTglBerlaku.setEnabled(isEditing);
            spnTglExpired.setEnabled(isEditing);
            
            String kode = ((PromoCashBack)promo).getKodePromo();
            int potongan = ((PromoCashBack)promo).getPersenPotongan();
            double maksPot = ((PromoCashBack)promo).getMaksPotongan();
            double minBel = ((PromoCashBack)promo).getMinPembelian();
            Date tglBerlaku = ((PromoCashBack)promo).getTanggalAwal();
            Date tglBerakhir = ((PromoCashBack)promo).getTanggalAkhir();
            
            txtKode.setText(kode);
            spnPersen.setValue(potongan);
            spnMaksPot.setValue(maksPot);
            spnMin.setValue(minBel);
            spnTglBerlaku.setValue(tglBerlaku);
            spnTglExpired.setValue(tglBerakhir);
            
        } else if (promo instanceof PromoDelivery) {
            txtKode.setEnabled(isEditing);
            rbDiskon.setSelected(true);
            spnMaksPot.setEnabled(isEditing);
            spnMin.setEnabled(isEditing);
            spnPersen.setEnabled(isEditing);
            spnTglBerlaku.setEnabled(isEditing);
            spnTglExpired.setEnabled(isEditing);
            
            String kode = ((PromoDelivery)promo).getKodePromo();
            int potongan = ((PromoDelivery)promo).getPersenPotongan();
            double maksPot = ((PromoDelivery)promo).getMaksPotongan();
            double minBel = ((PromoDelivery)promo).getMinPembelian();
            Date tglBerlaku = ((PromoDelivery)promo).getTanggalAwal();
            Date tglBerakhir = ((PromoDelivery)promo).getTanggalAkhir();
            
            txtKode.setText(kode);
            spnPersen.setValue(potongan);
            spnMaksPot.setValue(maksPot);
            spnMin.setValue(minBel);
            spnTglBerlaku.setValue(tglBerlaku);
            spnTglExpired.setValue(tglBerakhir);
        }
    }//GEN-LAST:event_cbPromoActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        isEditing = false;
        resetFields();
        updateFields();
        model.setRowCount(0);
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnRmvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRmvActionPerformed
        // TODO add your handling code here:
        isEditing = false;
        int selectedRow = tblPromo.getSelectedRow();

        if (selectedRow != -1) {
            String kodePromo = (String) model.getValueAt(selectedRow, 0);
            model.removeRow(selectedRow);
            promoDB.remove(kodePromo);
        }
    }//GEN-LAST:event_btnRmvActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        isEditing = true;
        updateButton();
        updateFields();
        txtKode.setEnabled(false);
        
        String selectedItem = (String) cbPromo.getSelectedItem();
        
        promo = null;
        
        if (selectedItem != null) {
            if (promoDB.containsKey(selectedItem)) {
                promo = promoDB.get(selectedItem);
            }
        }
        
        if (promo instanceof PromoDisc) {
            txtKode.setEnabled(isEditing);
            rbDiskon.setSelected(true);
            spnMaksPot.setEnabled(isEditing);
            spnMin.setEnabled(isEditing);
            spnPersen.setEnabled(isEditing);
            spnTglBerlaku.setEnabled(isEditing);
            spnTglExpired.setEnabled(isEditing);
            
            String kode = ((PromoDisc)promo).getKodePromo();
            int potongan = ((PromoDisc)promo).getPersenPotongan();
            double maksPot = ((PromoDisc)promo).getMaksPotongan();
            double minBel = ((PromoDisc)promo).getMinPembelian();
            Date tglBerlaku = ((PromoDisc)promo).getTanggalAwal();
            Date tglBerakhir = ((PromoDisc)promo).getTanggalAkhir();
            
            txtKode.setText(kode);
            spnPersen.setValue(potongan);
            spnMaksPot.setValue(maksPot);
            spnMin.setValue(minBel);
            spnTglBerlaku.setValue(tglBerlaku);
            spnTglExpired.setValue(tglBerakhir);
            
        } else if (promo instanceof PromoCashBack) {
            txtKode.setEnabled(isEditing);
            rbDiskon.setSelected(true);
            spnMaksPot.setEnabled(isEditing);
            spnMin.setEnabled(isEditing);
            spnPersen.setEnabled(isEditing);
            spnTglBerlaku.setEnabled(isEditing);
            spnTglExpired.setEnabled(isEditing);
            
            String kode = ((PromoCashBack)promo).getKodePromo();
            int potongan = ((PromoCashBack)promo).getPersenPotongan();
            double maksPot = ((PromoCashBack)promo).getMaksPotongan();
            double minBel = ((PromoCashBack)promo).getMinPembelian();
            Date tglBerlaku = ((PromoCashBack)promo).getTanggalAwal();
            Date tglBerakhir = ((PromoCashBack)promo).getTanggalAkhir();
            
            txtKode.setText(kode);
            spnPersen.setValue(potongan);
            spnMaksPot.setValue(maksPot);
            spnMin.setValue(minBel);
            spnTglBerlaku.setValue(tglBerlaku);
            spnTglExpired.setValue(tglBerakhir);
            
        } else if (promo instanceof PromoDelivery) {
            txtKode.setEnabled(isEditing);
            rbDiskon.setSelected(true);
            spnMaksPot.setEnabled(isEditing);
            spnMin.setEnabled(isEditing);
            spnPersen.setEnabled(isEditing);
            spnTglBerlaku.setEnabled(isEditing);
            spnTglExpired.setEnabled(isEditing);
            
            String kode = ((PromoDelivery)promo).getKodePromo();
            int potongan = ((PromoDelivery)promo).getPersenPotongan();
            double maksPot = ((PromoDelivery)promo).getMaksPotongan();
            double minBel = ((PromoDelivery)promo).getMinPembelian();
            Date tglBerlaku = ((PromoDelivery)promo).getTanggalAwal();
            Date tglBerakhir = ((PromoDelivery)promo).getTanggalAkhir();
            
            txtKode.setText(kode);
            spnPersen.setValue(potongan);
            spnMaksPot.setValue(maksPot);
            spnMin.setValue(minBel);
            spnTglBerlaku.setValue(tglBerlaku);
            spnTglExpired.setValue(tglBerakhir);
        }

    }//GEN-LAST:event_btnEditActionPerformed

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
            java.util.logging.Logger.getLogger(DPromoWindows.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DPromoWindows.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DPromoWindows.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DPromoWindows.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DPromoWindows().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TitlePromo;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCusPage;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnRmv;
    private javax.swing.JButton btnSave;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbPromo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JRadioButton rbCashback;
    private javax.swing.JRadioButton rbDiskon;
    private javax.swing.JRadioButton rbOngkir;
    private javax.swing.JSpinner spnMaksPot;
    private javax.swing.JSpinner spnMin;
    private javax.swing.JSpinner spnPersen;
    private javax.swing.JSpinner spnTglBerlaku;
    private javax.swing.JSpinner spnTglExpired;
    private javax.swing.JTable tblPromo;
    private javax.swing.JTextField txtKode;
    // End of variables declaration//GEN-END:variables
}
