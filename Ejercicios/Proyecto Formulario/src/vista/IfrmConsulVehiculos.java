/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vista;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Dyl
 */
public class IfrmConsulVehiculos extends javax.swing.JInternalFrame {

    /**
     * Creates new form IfrmConsulVehiculos
     */
    public IfrmConsulVehiculos() {
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

        lblTblDatosVehiculo = new javax.swing.JLabel();
        scrollTblDatosVehiculo = new javax.swing.JScrollPane();
        tblDatosVehiculo = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Consultar Vehiculos");
        setPreferredSize(new java.awt.Dimension(740, 406));

        lblTblDatosVehiculo.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        lblTblDatosVehiculo.setText("DATOS DE VEHICULOS REGISTRADOS");

        tblDatosVehiculo.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        tblDatosVehiculo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo", "Placa", "Marca", "Modelo", "Cilindraje", "Cant Pas", "Valor", "Impuesto", "Nº Formulario"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollTblDatosVehiculo.setViewportView(tblDatosVehiculo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblTblDatosVehiculo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(scrollTblDatosVehiculo, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTblDatosVehiculo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollTblDatosVehiculo, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     *
     * @return
     */
    public JLabel getLblTblDatosVehiculo() {
        return lblTblDatosVehiculo;
    }

    /**
     *
     * @param lblTblDatosVehiculo
     */
    public void setLblTblDatosVehiculo(JLabel lblTblDatosVehiculo) {
        this.lblTblDatosVehiculo = lblTblDatosVehiculo;
    }

    /**
     *
     * @return
     */
    public JScrollPane getScrollTblDatosVehiculo() {
        return scrollTblDatosVehiculo;
    }

    /**
     *
     * @param scrollTblDatosVehiculo
     */
    public void setScrollTblDatosVehiculo(JScrollPane scrollTblDatosVehiculo) {
        this.scrollTblDatosVehiculo = scrollTblDatosVehiculo;
    }

    /**
     *
     * @return
     */
    public JTable getTblDatosVehiculo() {
        return tblDatosVehiculo;
    }

    /**
     *
     * @param tblDatosVehiculo
     */
    public void setTblDatosVehiculo(JTable tblDatosVehiculo) {
        this.tblDatosVehiculo = tblDatosVehiculo;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblTblDatosVehiculo;
    private javax.swing.JScrollPane scrollTblDatosVehiculo;
    private javax.swing.JTable tblDatosVehiculo;
    // End of variables declaration//GEN-END:variables
}
