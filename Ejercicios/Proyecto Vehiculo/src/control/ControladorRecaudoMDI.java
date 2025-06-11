package control;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import modelo.*;
import vista.IntFrmRecaudo;

/**
 *
 * @author Dyl
 */
public class ControladorRecaudoMDI extends Controlador {
    IntFrmRecaudo frmR;
    Recaudo objR;


    public ControladorRecaudoMDI(IntFrmRecaudo frmR, Recaudo objR) {
        this.frmR = frmR;
        this.objR = objR;
    }
        
    public ControladorRecaudoMDI() {
        this.frmR = new IntFrmRecaudo();
        this.objR = new Recaudo();
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
        for (Vehiculo vh : objR.getListaV()) ((DefaultTableModel)plantilla).addRow(vh.arregloDatos());
    }

    @Override
    public void actualizarAtributos(Object[] atributos){
        frmR = (IntFrmRecaudo) atributos[0];
        objR = (Recaudo) atributos[1];
    }

    @Override
    public void iniciar() {
        frmR.setTitle("Registro Vehiculos");
        frmR.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        inicializarActList(frmR);
        frmR.getTxtRecaudo().setEditable(false);
        frmR.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(frmR.getBtnRecaudo())) {
            limpiarDatos(frmR);
            agregarRecaudoTabla(objR, frmR.getTblDatos().getModel());
            frmR.getTxtRecaudo().setText(String.format("%.2f", objR.totalRecaudo()));
            JOptionPane.showMessageDialog(frmR,
                    "Vehiculos Registrados: " + objR.getListaV().size() + "\nTotal Recaudo: " + String.format("%.2f", objR.totalRecaudo()),
                    "Registro.", JOptionPane.INFORMATION_MESSAGE);
            ArchPDFBox objB = new ArchPDFBox();
            try {
                objB.crear_PDF(objR.getListaV());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}

