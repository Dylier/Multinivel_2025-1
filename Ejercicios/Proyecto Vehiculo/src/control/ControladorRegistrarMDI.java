package control;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import modelo.Auto;
import modelo.Moto;
import modelo.Recaudo;
import modelo.Vehiculo;
import vista.IntFrmRegistrar;

/**
 *
 * @author Dyl
 */
public class ControladorRegistrarMDI extends Controlador {
    IntFrmRegistrar frmR;
    Recaudo objR;
    Vehiculo objV;
    TableModel objTB;
    
    public ControladorRegistrarMDI(IntFrmRegistrar frmR, Recaudo objR, Vehiculo objV, TableModel objTB) {
        this.frmR = frmR;
        this.objR = objR;
        this.objV = null;
        this.objTB = objTB;
    }
   
    public ControladorRegistrarMDI() {
        this.frmR = new IntFrmRegistrar();
        this.objR = new Recaudo();
        this.objV = null;
        this.objTB = new DefaultTableModel();
    }


    @Override
    public void actualizarAtributos(Object... atributos) {
        frmR = (IntFrmRegistrar) atributos[0];
        objR = (Recaudo) atributos[1];
        objV = (Vehiculo) atributos[2];
        objTB = (DefaultTableModel) atributos[3];
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

    public void agregarRecaudoTabla(Recaudo objR, TableModel plantilla) { 
        ((DefaultTableModel )plantilla).setRowCount(0);
        for (Vehiculo vh : objR.getListaV()) {
            Object[] datos;
            if (vh instanceof Auto) {
                datos = new Object[]{"Auto", ((Auto) vh).getPlaca(), ((Auto) vh).getMarca(), ((Auto) vh).getModelo(), ((Auto) vh).getCilindraje(), ((Auto) vh).getCantPass(), ((Auto) vh).getValor(), String.format("%.2f", ((Auto) vh).Impuesto())};
            } else {
                Moto objM = (Moto) vh;
                datos = new Object[]{"Moto", objM.getPlaca(), objM.getMarca(), objM.getModelo(), objM.getCilindraje(), "2", objM.getValor(), objM.Impuesto()};
            }
            
            ((DefaultTableModel )plantilla).addRow(datos);
        } 
    }
    
    @Override
    public void iniciar() {
        frmR.setTitle("Registro Vehiculos");
        frmR.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        inicializarActList(frmR);

        frmR.getTxtCanPas().setEditable(true);
        frmR.getBtnRegistrar().setEnabled(false);
        
        frmR.setVisible(true);
    }
        
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(frmR.getCmbVehiculo())) {
            frmR.getBtnRegistrar().setEnabled(true);
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
                ((Auto) objV).setCantPass(Integer.parseInt(frmR.getTxtCanPas().getText()));
            }
              
            limpiarDatos(frmR);
            
            objR.getListaV().add(objV);
            agregarRecaudoTabla(objR, frmR.getTblDatos().getModel());
            agregarRecaudoTabla(objR, objTB);
            JOptionPane.showMessageDialog(frmR,
                    "Datos Registrados: " + objV.toString() + "\nImpuesto: " + String.format("%.2f", objV.Impuesto()),
                    "Registro.", JOptionPane.INFORMATION_MESSAGE);
            

        }
    }


}

