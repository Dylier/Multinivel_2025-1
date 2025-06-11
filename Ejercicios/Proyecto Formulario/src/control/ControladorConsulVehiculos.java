/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import modelo.Contribuyente;
import modelo.Formulario;
import modelo.Recaudo;
import modelo.Vehiculo;
import vista.IfrmConsulPropietarios;
import vista.IfrmConsulVehiculos;

/**
 *
 * @author Dyl
 */
public class ControladorConsulVehiculos extends Controlador{
    IfrmConsulVehiculos frmP;
    Recaudo objR;
       
    /**
     *
     */
    public void actualizarTabla(){        
        for (Formulario objF: objR.getFormularios()){
                if (objF.getVehiculo() != null){
                Object[] datosV = objF.getVehiculo().getArregloDatos();
                Object[] datosT = new Object[datosV.length + 1];
                for (int i = 0; i < datosV.length; i++) datosT[i] = datosV[i];
                datosT[datosT.length - 1] = objF.getId();
                ((DefaultTableModel) frmP.getTblDatosVehiculo().getModel()).addRow(datosT);
            }
        }
    }
    
    /**
     *
     */
    @Override
    public void iniciar() {
        frmP.setTitle("Registro de Propietarios");
        frmP.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);       
        inicializarActList(frmP);
        actualizarTabla();
        frmP.setVisible(true);
    }

    /**
     *
     * @param atributos
     */
    @Override
    public void actualizarAtributos(JInternalFrame frm, Object... atributos) {
        this.frmP = (IfrmConsulVehiculos) frm;
        this.objR = (Recaudo) atributos[0];
    }

    /**
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
