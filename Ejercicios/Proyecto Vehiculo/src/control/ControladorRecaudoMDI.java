package control;

import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

import modelo.Recaudo;
import vista.IntFrmRecaudo;

/**
 *
 * @author Dyl
 */
public class ControladorRecaudoMDI extends Controlador {
    IntFrmRecaudo frmR;
    Recaudo objR;
    TableModel modeloTB;

    public ControladorRecaudoMDI(IntFrmRecaudo frmR, Recaudo objR, TableModel modeloTB) {
        this.frmR = frmR;
        this.objR = objR;
        this.modeloTB = modeloTB;
    }
        
    public ControladorRecaudoMDI() {
        this.frmR = new IntFrmRecaudo();
        this.objR = new Recaudo();
        this.modeloTB = null;
    }
    
    @Override
    public void actualizarAtributos(Object[] atributos){
        frmR = (IntFrmRecaudo) atributos[0];
        objR = (Recaudo) atributos[1]; 
        modeloTB = (TableModel) atributos[2];
    }
    

    @Override
    public void iniciar() {
        frmR.setTitle("Registro Vehiculos");
        frmR.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        inicializarActList(frmR);
        
        frmR.getTblDatos().setModel(modeloTB);
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

