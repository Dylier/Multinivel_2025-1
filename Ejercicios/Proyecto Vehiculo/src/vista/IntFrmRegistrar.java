/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Dyl
 */
public class IntFrmRegistrar extends javax.swing.JInternalFrame {

    /**
     * Creates new form IntFrmConsultar
     */
    public IntFrmRegistrar() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblPlaca = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        lblCilindraje = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JTextField();
        lblCantPas = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        txtCanPas = new javax.swing.JTextField();
        txtCilindraje = new javax.swing.JTextField();
        cmbVehiculo = new javax.swing.JComboBox<>();
        lblModelo = new javax.swing.JLabel();
        lblMarca = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        lblValor = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 204));
        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Registrar Vehiculo");

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        lblPlaca.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        lblPlaca.setText("Placa ");

        txtMarca.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        txtMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMarcaActionPerformed(evt);
            }
        });

        lblCilindraje.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        lblCilindraje.setText("Cilindraje");

        txtPlaca.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        txtPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPlacaActionPerformed(evt);
            }
        });

        lblCantPas.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        lblCantPas.setText("Cant pasajeros");

        txtValor.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        txtValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorActionPerformed(evt);
            }
        });

        txtCanPas.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        txtCanPas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCanPasActionPerformed(evt);
            }
        });

        txtCilindraje.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        txtCilindraje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCilindrajeActionPerformed(evt);
            }
        });

        cmbVehiculo.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        cmbVehiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Vehiculo", "Carro", "Moto" }));
        cmbVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbVehiculoActionPerformed(evt);
            }
        });

        lblModelo.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        lblModelo.setText("Modelo");

        lblMarca.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        lblMarca.setText("Marca");

        btnRegistrar.setBackground(new java.awt.Color(255, 204, 204));
        btnRegistrar.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        lblValor.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        lblValor.setText("Valor");

        txtModelo.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        txtModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtModeloActionPerformed(evt);
            }
        });

        tblDatos.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo", "Placa", "Marca", "Modelo", "Cilindraje", "Cant Pas", "Valor", "Impuesto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
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
        jScrollPane1.setViewportView(tblDatos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cmbVehiculo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblCantPas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCanPas, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblValor)
                                .addGap(18, 18, 18)
                                .addComponent(txtValor))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblCilindraje)
                                .addGap(18, 18, 18)
                                .addComponent(txtCilindraje, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPlaca)
                                    .addComponent(lblMarca)
                                    .addComponent(lblModelo))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtModelo)
                                    .addComponent(txtMarca)
                                    .addComponent(txtPlaca))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRegistrar)))
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPlaca)
                            .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMarca)
                            .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblModelo)
                            .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCilindraje)
                            .addComponent(txtCilindraje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblValor)
                            .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCantPas)
                            .addComponent(txtCanPas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMarcaActionPerformed

    private void txtPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPlacaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPlacaActionPerformed

    private void txtValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorActionPerformed

    private void txtCanPasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCanPasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCanPasActionPerformed

    private void txtCilindrajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCilindrajeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCilindrajeActionPerformed

    private void cmbVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbVehiculoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbVehiculoActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void txtModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtModeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtModeloActionPerformed

    public JButton getBtnRegistrar() {
        return btnRegistrar;
    }

    public void setBtnRegistrar(JButton btnRegistrar) {
        this.btnRegistrar = btnRegistrar;
    }

    public JComboBox<String> getCmbVehiculo() {
        return cmbVehiculo;
    }

    public void setCmbVehiculo(JComboBox<String> cmbVehiculo) {
        this.cmbVehiculo = cmbVehiculo;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JTable getTblDatos() {
        return tblDatos;
    }

    public void setTblDatos(JTable tblDatos) {
        this.tblDatos = tblDatos;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JLabel getLblCantPas() {
        return lblCantPas;
    }

    public void setLblCantPas(JLabel lblCantPas) {
        this.lblCantPas = lblCantPas;
    }

    public JLabel getLblCilindraje() {
        return lblCilindraje;
    }

    public void setLblCilindraje(JLabel lblCilindraje) {
        this.lblCilindraje = lblCilindraje;
    }

    public JLabel getLblMarca() {
        return lblMarca;
    }

    public void setLblMarca(JLabel lblMarca) {
        this.lblMarca = lblMarca;
    }

    public JLabel getLblModelo() {
        return lblModelo;
    }

    public void setLblModelo(JLabel lblModelo) {
        this.lblModelo = lblModelo;
    }

    public JLabel getLblPlaca() {
        return lblPlaca;
    }

    public void setLblPlaca(JLabel lblPlaca) {
        this.lblPlaca = lblPlaca;
    }

    public JLabel getLblValor() {
        return lblValor;
    }

    public void setLblValor(JLabel lblValor) {
        this.lblValor = lblValor;
    }

    public JTextField getTxtCanPas() {
        return txtCanPas;
    }

    public void setTxtCanPas(JTextField txtCanPas) {
        this.txtCanPas = txtCanPas;
    }

    public JTextField getTxtCilindraje() {
        return txtCilindraje;
    }

    public void setTxtCilindraje(JTextField txtCilindraje) {
        this.txtCilindraje = txtCilindraje;
    }

    public JTextField getTxtMarca() {
        return txtMarca;
    }

    public void setTxtMarca(JTextField txtMarca) {
        this.txtMarca = txtMarca;
    }

    public JTextField getTxtModelo() {
        return txtModelo;
    }

    public void setTxtModelo(JTextField txtModelo) {
        this.txtModelo = txtModelo;
    }

    public JTextField getTxtPlaca() {
        return txtPlaca;
    }

    public void setTxtPlaca(JTextField txtPlaca) {
        this.txtPlaca = txtPlaca;
    }

    public JTextField getTxtValor() {
        return txtValor;
    }

    public void setTxtValor(JTextField txtValor) {
        this.txtValor = txtValor;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cmbVehiculo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCantPas;
    private javax.swing.JLabel lblCilindraje;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblPlaca;
    private javax.swing.JLabel lblValor;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtCanPas;
    private javax.swing.JTextField txtCilindraje;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
