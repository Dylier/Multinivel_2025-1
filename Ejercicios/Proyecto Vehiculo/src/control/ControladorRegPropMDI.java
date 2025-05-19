package control;

import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import modelo.Auto;
import modelo.Moto;
import modelo.Recaudo;
import modelo.Vehiculo;
import vista.FrmRegistro;
import vista.IntFrmRegProp;

/**
 *
 * @author Dyl
 */
public class ControladorRegPropMDI extends Controlador{
    IntFrmRegProp frmR;


    public ControladorRegPropMDI(IntFrmRegProp frmR) {
        this.frmR = frmR;

    }

    public ControladorRegPropMDI() {
        this.frmR = new IntFrmRegProp();
    }

    public void iniciar() {
        frmR.setTitle("Registro Vehiculos");
        frmR.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        inicializarActList(frmR);

        frmR.setVisible(true);
    }
        @Override
    public void actualizarAtributos(Object[] atributos){

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

