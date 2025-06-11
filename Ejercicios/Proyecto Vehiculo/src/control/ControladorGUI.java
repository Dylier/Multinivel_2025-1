/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Auto;
import modelo.Moto;
import modelo.Recaudo;
import modelo.Vehiculo;
import vista.FrmRegistro;

/**
 *
 * @author Dyl
 */
public class ControladorGUI implements ActionListener {
    FrmRegistro frmR;
    Recaudo objR;
    Vehiculo objV;

    public ControladorGUI(FrmRegistro frmR, Recaudo objR, Vehiculo objV) {
        this.frmR = frmR;
        this.objR = objR;
        this.objV = null;
    }

    public ControladorGUI() {
        this.frmR = new FrmRegistro();
        this.objR = new Recaudo();
        this.objV = null;
    }

    public void iniciar() {
        frmR.setTitle("Registro Vehiculos");
        frmR.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmR.setLocationRelativeTo(null);
        frmR.getBtnRegistrar().addActionListener(this);
        frmR.getBtnRecaudo().addActionListener(this);
        frmR.getCmbVehiculo().addActionListener(this);
        frmR.getTxtCanPas().setEditable(true);
        frmR.getBtnRegistrar().setEnabled(false);
        frmR.getBtnRecaudo().setEnabled(false);
        frmR.getTxtRecaudo().setEditable(false);
        frmR.setVisible(true);
    }
    
    public void limpiarDatos(Container Comp){
        for(Component c: Comp.getComponents()){
            if (c instanceof JTextField){
                ((JTextField) c).setText("");
            } else if (c instanceof JTable){
                DefaultTableModel plantilla = (DefaultTableModel) ((JTable)c).getModel();
                plantilla.setRowCount(0);                
            } else if (c instanceof JComboBox){
                ((JComboBox) c).setSelectedIndex(0);
            } else if (c instanceof Container){
                limpiarDatos((Container) c);
            } 
        }
    }
    // YA NO USADO
    /*
    public void limpiarDatos(){
        
        frmR.getTxtCanPas().setText("");
        frmR.getTxtCilindraje().setText("");
        frmR.getTxtMarca().setText("");
        frmR.getTxtModelo().setText("");
        frmR.getTxtPlaca().setText("");
        frmR.getTxtValor().setText("");
        frmR.getTxtRecaudo().setText("");
     
        
        DefaultTableModel plantilla = (DefaultTableModel) frmR.getTblDatos().getModel();
        plantilla.setRowCount(0);
    }
*/
    public void agregarRecaudoTabla(Recaudo objR, JTable tabla) {
        DefaultTableModel plantilla = (DefaultTableModel) tabla.getModel();
        for (Vehiculo vh : objR.getListaV()) {
            if (vh instanceof Auto) {
                Object[] datos = {"Auto", ((Auto) vh).getPlaca(), ((Auto) vh).getMarca(), ((Auto) vh).getModelo(), ((Auto) vh).getCilindraje(), ((Auto) vh).getCantPasajeros(), ((Auto) vh).getValor(), String.format("%.2f", ((Auto) vh).getImpuesto())};
                plantilla.addRow(datos);
            } else {
                Moto objM = (Moto) vh;
                Object[] datos = {"Moto", objM.getPlaca(), objM.getMarca(), objM.getModelo(), objM.getCilindraje(), "2", objM.getValor(), objM.getImpuesto()};
                plantilla.addRow(datos);
            }
        } //cierre for
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(frmR.getCmbVehiculo())) {
            frmR.getBtnRegistrar().setEnabled(true);
            frmR.getBtnRecaudo().setEnabled(true);
            switch (frmR.getCmbVehiculo().getSelectedIndex()) {
                case 0:
                    frmR.getBtnRegistrar().setEnabled(false);
                    break;
                case 1:
                    frmR.getTxtCanPas().setEditable(true);
                    //frmR.getTxtCanPas().setVisible(true);
                    objV = new Auto();
                    break;
                case 2:
                    frmR.getTxtCanPas().setEditable(false);
                    //frmR.getTxtCanPas().setVisible(false);
                    frmR.getTxtCanPas().setText("2");
                    objV = new Moto();
                    break;
            }
        }

        if (e.getSource().equals(frmR.getBtnRegistrar())) {
            if (objV instanceof Moto) {
                objV.setPlaca(frmR.getTxtPlaca().getText());
                objV.setModelo(Integer.parseInt(frmR.getTxtModelo().getText()));
                objV.setMarca(frmR.getTxtMarca().getText());
                objV.setValor(Double.parseDouble(frmR.getTxtValor().getText()));
                objV.setCilindraje(Integer.parseInt(frmR.getTxtCilindraje().getText()));
            } else if (objV instanceof Auto) {
                ((Auto) objV).setPlaca(frmR.getTxtPlaca().getText());
                ((Auto) objV).setModelo(Integer.parseInt(frmR.getTxtModelo().getText()));
                ((Auto) objV).setMarca(frmR.getTxtMarca().getText());
                ((Auto) objV).setValor(Double.parseDouble(frmR.getTxtValor().getText()));
                ((Auto) objV).setCilindraje(Integer.parseInt(frmR.getTxtCilindraje().getText()));
                ((Auto) objV).setCantPasajeros((Integer.parseInt(frmR.getTxtCanPas().getText())));
            }
                
            limpiarDatos(frmR);
            
            objR.getListaV().add(objV);
            agregarRecaudoTabla(objR, frmR.getTblDatos());
            JOptionPane.showMessageDialog(frmR,
                    "Datos Registrados: " + objV.toString() + "\nImpuesto: " + String.format("%.2f", objV.getImpuesto()),
                    "Registro.", JOptionPane.INFORMATION_MESSAGE);
            

        }

        if (e.getSource().equals(frmR.getBtnRecaudo())) {
            frmR.getTxtRecaudo().setText(String.format("%.2f", objR.totalRecaudo()));
            JOptionPane.showMessageDialog(frmR,
                    "Vehiculos Registrados: " + objR.getListaV().size() + "\nTotal Recaudo: " + String.format("%.2f", objR.totalRecaudo()),
                    "Registro.", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}

