/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Dyl
 */
public class IfrmAgPropietarios extends javax.swing.JInternalFrame {

    /**
     * Creates new form IfrmAgPropietario
     */
    public IfrmAgPropietarios() {
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

        scrollTblDatosContribuyentes = new javax.swing.JScrollPane();
        tblDatosContibuyentes = new javax.swing.JTable();
        txtNom = new javax.swing.JTextField();
        txtCalidad = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        cmbTipoDocu = new javax.swing.JComboBox<>();
        lblCalidad = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        lblCedula = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        lblDireccion = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        lblCorreo = new javax.swing.JLabel();
        txtMunicipio = new javax.swing.JTextField();
        lblMunicipio = new javax.swing.JLabel();
        txtFecNac = new javax.swing.JTextField();
        lblFecNac = new javax.swing.JLabel();
        txtPropiedad = new javax.swing.JTextField();
        lblPropiedad = new javax.swing.JLabel();
        btnRegistrarProp = new javax.swing.JButton();
        lblTblContribuyentes = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Agregar Propietarios");

        tblDatosContibuyentes.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        tblDatosContibuyentes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Tipo", "Documento", "Correo", "Edad", "Calidad", "Direccion", "Municipio", "% Propiedad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDatosContibuyentes.setEnabled(false);
        scrollTblDatosContribuyentes.setViewportView(tblDatosContibuyentes);

        txtNom.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        txtNom.setName("Nombre De Propietario"); // NOI18N
        txtNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomActionPerformed(evt);
            }
        });

        txtCalidad.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        txtCalidad.setName("Calidad del Propietario Sobre Vehiculo"); // NOI18N

        lblNombre.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        lblNombre.setText("Nombre");

        cmbTipoDocu.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        cmbTipoDocu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CC", "TI", "TE" }));

        lblCalidad.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        lblCalidad.setText("Calidad sobre Vehiculo");

        txtCedula.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        txtCedula.setName("Numero De Documento"); // NOI18N
        txtCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaActionPerformed(evt);
            }
        });

        lblCedula.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        lblCedula.setText("Tipo de Documento");

        txtDireccion.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        txtDireccion.setName("Direccion Del Propietario"); // NOI18N

        lblDireccion.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        lblDireccion.setText("Direccion");

        txtCorreo.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        txtCorreo.setName("Correo Del Propietario"); // NOI18N
        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });

        lblCorreo.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        lblCorreo.setText("Correo");

        txtMunicipio.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        txtMunicipio.setName("Municipio Del Propietario"); // NOI18N

        lblMunicipio.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        lblMunicipio.setText("Municipio");

        txtFecNac.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        txtFecNac.setName("Fecha de Nacimiento Del Propietario"); // NOI18N
        txtFecNac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFecNacActionPerformed(evt);
            }
        });

        lblFecNac.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        lblFecNac.setText("Fecha de Nacimiento");

        txtPropiedad.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        txtPropiedad.setName("Procentaje De Propiedad Del Propietario Sobre El Vehiculo"); // NOI18N
        txtPropiedad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPropiedadActionPerformed(evt);
            }
        });

        lblPropiedad.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        lblPropiedad.setText("Porcentaje de Propiedad");

        btnRegistrarProp.setBackground(new java.awt.Color(255, 255, 204));
        btnRegistrarProp.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        btnRegistrarProp.setForeground(new java.awt.Color(0, 0, 0));
        btnRegistrarProp.setText("REGISTRAR");
        btnRegistrarProp.setToolTipText("");
        btnRegistrarProp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRegistrarProp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarPropActionPerformed(evt);
            }
        });

        lblTblContribuyentes.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        lblTblContribuyentes.setText("CONTRIBUYENTES");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTblContribuyentes)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(scrollTblDatosContribuyentes)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNom)
                                    .addComponent(lblFecNac)
                                    .addComponent(lblCorreo)
                                    .addComponent(lblCedula)
                                    .addComponent(txtCorreo)
                                    .addComponent(lblNombre)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cmbTipoDocu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtFecNac))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCalidad)
                                    .addComponent(txtDireccion)
                                    .addComponent(txtMunicipio)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblCalidad)
                                            .addComponent(lblDireccion)
                                            .addComponent(lblMunicipio)
                                            .addComponent(lblPropiedad))
                                        .addGap(0, 25, Short.MAX_VALUE))
                                    .addComponent(txtPropiedad))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRegistrarProp, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(lblCalidad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCedula)
                            .addComponent(lblDireccion))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cmbTipoDocu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCorreo)
                            .addComponent(lblMunicipio))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFecNac)
                            .addComponent(lblPropiedad))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFecNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPropiedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnRegistrarProp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTblContribuyentes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollTblDatosContribuyentes, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                .addGap(9, 9, 9))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPropiedadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPropiedadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPropiedadActionPerformed

    private void btnRegistrarPropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarPropActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarPropActionPerformed

    private void txtNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomActionPerformed

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void txtFecNacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFecNacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFecNacActionPerformed

    /**
     *
     * @return
     */
    public JButton getBtnRegistrarProp() {
        return btnRegistrarProp;
    }

    /**
     *
     * @param btnRegistrarProp
     */
    public void setBtnRegistrarProp(JButton btnRegistrarProp) {
        this.btnRegistrarProp = btnRegistrarProp;
    }

    /**
     *
     * @return
     */
    public JComboBox<String> getCmbTipoDocu() {
        return cmbTipoDocu;
    }

    /**
     *
     * @param cmbTipoDocu
     */
    public void setCmbTipoDocu(JComboBox<String> cmbTipoDocu) {
        this.cmbTipoDocu = cmbTipoDocu;
    }

    /**
     *
     * @return
     */
    public JLabel getLblCalidad() {
        return lblCalidad;
    }

    /**
     *
     * @param lblCalidad
     */
    public void setLblCalidad(JLabel lblCalidad) {
        this.lblCalidad = lblCalidad;
    }

    /**
     *
     * @return
     */
    public JLabel getLblCedula() {
        return lblCedula;
    }

    /**
     *
     * @param lblCedula
     */
    public void setLblCedula(JLabel lblCedula) {
        this.lblCedula = lblCedula;
    }

    /**
     *
     * @return
     */
    public JLabel getLblCorreo() {
        return lblCorreo;
    }

    /**
     *
     * @param lblCorreo
     */
    public void setLblCorreo(JLabel lblCorreo) {
        this.lblCorreo = lblCorreo;
    }

    /**
     *
     * @return
     */
    public JLabel getLblDireccion() {
        return lblDireccion;
    }

    /**
     *
     * @param lblDireccion
     */
    public void setLblDireccion(JLabel lblDireccion) {
        this.lblDireccion = lblDireccion;
    }

    /**
     *
     * @return
     */
    public JLabel getLblFecNac() {
        return lblFecNac;
    }

    /**
     *
     * @param lblFecNac
     */
    public void setLblFecNac(JLabel lblFecNac) {
        this.lblFecNac = lblFecNac;
    }

    /**
     *
     * @return
     */
    public JLabel getLblMunicipio() {
        return lblMunicipio;
    }

    /**
     *
     * @param lblMunicipio
     */
    public void setLblMunicipio(JLabel lblMunicipio) {
        this.lblMunicipio = lblMunicipio;
    }

    /**
     *
     * @return
     */
    public JLabel getLblNombre() {
        return lblNombre;
    }

    /**
     *
     * @param lblNombre
     */
    public void setLblNombre(JLabel lblNombre) {
        this.lblNombre = lblNombre;
    }

    /**
     *
     * @return
     */
    public JLabel getLblPropiedad() {
        return lblPropiedad;
    }

    /**
     *
     * @param lblPropiedad
     */
    public void setLblPropiedad(JLabel lblPropiedad) {
        this.lblPropiedad = lblPropiedad;
    }

    /**
     *
     * @return
     */
    public JLabel getLblTblContribuyentes() {
        return lblTblContribuyentes;
    }

    /**
     *
     * @param lblTblContribuyentes
     */
    public void setLblTblContribuyentes(JLabel lblTblContribuyentes) {
        this.lblTblContribuyentes = lblTblContribuyentes;
    }

    /**
     *
     * @return
     */
    public JScrollPane getScrollTblDatosContribuyentes() {
        return scrollTblDatosContribuyentes;
    }

    /**
     *
     * @param scrollTblDatosContribuyentes
     */
    public void setScrollTblDatosContribuyentes(JScrollPane scrollTblDatosContribuyentes) {
        this.scrollTblDatosContribuyentes = scrollTblDatosContribuyentes;
    }

    /**
     *
     * @return
     */
    public JTable getTblDatosContibuyentes() {
        return tblDatosContibuyentes;
    }

    /**
     *
     * @param tblDatosContibuyentes
     */
    public void setTblDatosContibuyentes(JTable tblDatosContibuyentes) {
        this.tblDatosContibuyentes = tblDatosContibuyentes;
    }

    /**
     *
     * @return
     */
    public JTextField getTxtCalidad() {
        return txtCalidad;
    }

    /**
     *
     * @param txtCalidad
     */
    public void setTxtCalidad(JTextField txtCalidad) {
        this.txtCalidad = txtCalidad;
    }

    /**
     *
     * @return
     */
    public JTextField getTxtCedula() {
        return txtCedula;
    }

    /**
     *
     * @param txtCedula
     */
    public void setTxtCedula(JTextField txtCedula) {
        this.txtCedula = txtCedula;
    }

    /**
     *
     * @return
     */
    public JTextField getTxtCorreo() {
        return txtCorreo;
    }

    /**
     *
     * @param txtCorreo
     */
    public void setTxtCorreo(JTextField txtCorreo) {
        this.txtCorreo = txtCorreo;
    }

    /**
     *
     * @return
     */
    public JTextField getTxtDireccion() {
        return txtDireccion;
    }

    /**
     *
     * @param txtDireccion
     */
    public void setTxtDireccion(JTextField txtDireccion) {
        this.txtDireccion = txtDireccion;
    }

    /**
     *
     * @return
     */
    public JTextField getTxtFecNac() {
        return txtFecNac;
    }

    /**
     *
     * @param txtFecNac
     */
    public void setTxtFecNac(JTextField txtFecNac) {
        this.txtFecNac = txtFecNac;
    }

    /**
     *
     * @return
     */
    public JTextField getTxtMunicipio() {
        return txtMunicipio;
    }

    /**
     *
     * @param txtMunicipio
     */
    public void setTxtMunicipio(JTextField txtMunicipio) {
        this.txtMunicipio = txtMunicipio;
    }

    /**
     *
     * @return
     */
    public JTextField getTxtNom() {
        return txtNom;
    }

    /**
     *
     * @param txtNom
     */
    public void setTxtNom(JTextField txtNom) {
        this.txtNom = txtNom;
    }

    /**
     *
     * @return
     */
    public JTextField getTxtPropiedad() {
        return txtPropiedad;
    }

    /**
     *
     * @param txtPropiedad
     */
    public void setTxtPropiedad(JTextField txtPropiedad) {
        this.txtPropiedad = txtPropiedad;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrarProp;
    private javax.swing.JComboBox<String> cmbTipoDocu;
    private javax.swing.JLabel lblCalidad;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblFecNac;
    private javax.swing.JLabel lblMunicipio;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPropiedad;
    private javax.swing.JLabel lblTblContribuyentes;
    private javax.swing.JScrollPane scrollTblDatosContribuyentes;
    private javax.swing.JTable tblDatosContibuyentes;
    private javax.swing.JTextField txtCalidad;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtFecNac;
    private javax.swing.JTextField txtMunicipio;
    private javax.swing.JTextField txtNom;
    private javax.swing.JTextField txtPropiedad;
    // End of variables declaration//GEN-END:variables
}
