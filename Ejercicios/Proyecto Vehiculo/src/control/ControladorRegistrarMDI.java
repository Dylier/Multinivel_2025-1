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
    
    public ControladorRegistrarMDI(IntFrmRegistrar frmR, Recaudo objR, Vehiculo objV) {
        this.frmR = frmR;
        this.objR = objR;
        this.objV = null;
    }
   
    public ControladorRegistrarMDI() {
        this.frmR = new IntFrmRegistrar();
        this.objR = new Recaudo();
        this.objV = null;
    }


    @Override
    public void actualizarAtributos(Object... atributos) {
        frmR = (IntFrmRegistrar) atributos[0];
        objR = (Recaudo) atributos[1];
        objV = (Vehiculo) atributos[2];
    }

    public void limpiarDatos(Container Comp){
        for(Component c: Comp.getComponents()){
            if (c instanceof JTextField) ((JTextField) c).setText("");
            else if (c instanceof JTable) ((DefaultTableModel) ((JTable)c).getModel()).setRowCount(0);
            else if (c instanceof JComboBox) ((JComboBox) c).setSelectedIndex(0);
            else if (c instanceof Container) limpiarDatos((Container) c);
        }
    }

    public void agregarRecaudoTabla(Recaudo objR, TableModel plantilla) {
        for (Vehiculo vh : objR.getListaV()) ((DefaultTableModel) plantilla).addRow(vh.arregloDatos());
    }
    
    @Override
    public void iniciar() {
        frmR.setTitle("Registro Vehiculos");
        frmR.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        inicializarActList(frmR);
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
                    //frmR.getLblCantPas().setVisible(true);
                    objV = new Auto();
                    break;
                case 2:
                    frmR.getTxtCanPas().setEditable(false);
                    //frmR.getTxtCanPas().setVisible(false);
                    //frmR.getLblCantPas().setVisible(false);
                    frmR.getTxtCanPas().setText("2");
                    objV = new Moto();
                    break;
            }
        }

         if (e.getSource().equals(frmR.getBtnRegistrar())) {
             String msg = "";
             try {
                 objV.setPlaca(frmR.getTxtPlaca().getText());
                 objV.setModelo(Integer.parseInt(frmR.getTxtModelo().getText()));
                 objV.setMarca(frmR.getTxtMarca().getText());
                 objV.setValor(Double.parseDouble(frmR.getTxtValor().getText()));
                 objV.setCilindraje(Integer.parseInt(frmR.getTxtCilindraje().getText()));
                 if (objV instanceof Auto)
                     ((Auto) objV).setCantPasajeros(Integer.parseInt(frmR.getTxtCanPas().getText()));
                 objR.getListaV().add(objV);

                 limpiarDatos(frmR);
                 agregarRecaudoTabla(objR, frmR.getTblDatos().getModel());
                 msg = "Datos Registrados: " + objV.toString() + "\nImpuesto: " + String.format("%.2f", objV.getImpuesto());
             } catch (NumberFormatException ex) {
                 msg = "Error, el dato ingresado " + ex.getMessage().split(":")[1] + " no es valido.";
             } finally {
                 JOptionPane.showMessageDialog(frmR, msg, "Registro.", JOptionPane.INFORMATION_MESSAGE);
             }
        }
    }
}

