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
import javax.swing.table.TableModel;
import modelo.Auto;
import modelo.Moto;
import modelo.Recaudo;
import modelo.Vehiculo;
import vista.IntFrmRecaudo;

/**
 *
 * @author Dyl
 */
public class ControladorRecaudoMDI extends Controlador {
    IntFrmRecaudo frmR;
    Recaudo objR;
    TableModel objTB;

    public ControladorRecaudoMDI(IntFrmRecaudo frmR, Recaudo objR, TableModel objTB) {
        this.frmR = frmR;
        this.objR = objR;
        this.objTB = objTB;
    }
        
    public ControladorRecaudoMDI() {
        this.frmR = new IntFrmRecaudo();
        this.objR = new Recaudo();
    }
    
    @Override
    public void actualizarAtributos(Object[] atributos){
        frmR = (IntFrmRecaudo) atributos[0];
        objR = (Recaudo) atributos[1]; 
        objTB = (TableModel) atributos[2];
    }
    

    @Override
    public void iniciar() {
        frmR.setTitle("Registro Vehiculos");
        frmR.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        inicializarActList(frmR);
        
        frmR.getTblDatos().setModel(objTB);
        frmR.getBtnRecaudo().setEnabled(false);
        frmR.getTxtRecaudo().setEditable(false);
        frmR.setVisible(true);
    }
    

    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(frmR.getBtnRecaudo())) {
            frmR.getTxtRecaudo().setText(String.format("%.2f", objR.totalRecaudo()));
            JOptionPane.showMessageDialog(frmR,
                    "Vehiculos Registrados: " + objR.getListaV().size() + "\nTotal Recaudo: " + String.format("%.2f", objR.totalRecaudo()),
                    "Registro.", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}

