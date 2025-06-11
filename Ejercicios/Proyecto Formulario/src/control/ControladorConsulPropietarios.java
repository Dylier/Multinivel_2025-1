/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;
import modelo.Contribuyente;
import modelo.Formulario;
import modelo.Recaudo;
import vista.IfrmConsulPropietarios;

/**
 *
 * @author Dyl
 */
public class ControladorConsulPropietarios extends Controlador{
    IfrmConsulPropietarios frmP;
    Recaudo objR;

    /**
     * Actualiza la tabla de propietarios en la interfaz.
     */
    public void actualizarTabla(){
        for (Formulario objF: objR.getFormularios()){
            for (Contribuyente objC: objF.getContribuyentes()){
               Object[] datosC = objC.getArregloDatos();
               Object[] datosT = new Object[datosC.length + 1];
               for (int i = 0; i < datosC.length; i++) datosT[i] = datosC[i];
               datosT[datosT.length - 1] = objF.getId();
               ((DefaultTableModel) frmP.getTblDatosContibuyentes().getModel()).addRow(datosT);
            }
        }
    }

    /**
     * Inicia el controlador configurando la ventana y llenando la tabla.
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
     * Actualiza los atributos de la ventana interna.
     * @param frm
     * @param atributos
     */
    @Override
    public void actualizarAtributos(JInternalFrame frm, Object... atributos) {
        this.frmP = (IfrmConsulPropietarios) frm;
        this.objR = (Recaudo) atributos[0];
    }

    /**
     * Maneja las acciones de los eventos. 
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
    }

}