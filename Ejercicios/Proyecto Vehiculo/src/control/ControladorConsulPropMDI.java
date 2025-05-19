package control;

import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import vista.IntFrmConsulProp;

/**
 *
 * @author Dyl
 */
public class ControladorConsulPropMDI extends Controlador {
    IntFrmConsulProp frmR;


    public ControladorConsulPropMDI(IntFrmConsulProp frmR) {
        this.frmR = frmR;
    }

    public ControladorConsulPropMDI() {
        this.frmR = new IntFrmConsulProp();
    }
    
    @Override
    public void actualizarAtributos(Object[] atributos){
        frmR = (IntFrmConsulProp) atributos[0];
    }

    public void iniciar() {
        frmR.setTitle("Consultar Propietarios");
        frmR.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        inicializarActList(frmR);

        frmR.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

