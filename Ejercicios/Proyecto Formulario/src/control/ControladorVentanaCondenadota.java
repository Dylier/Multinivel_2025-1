/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.ventanaNueva;

/**
 *
 * @author Dyl
 */
public class ControladorVentanaCondenadota implements ActionListener{
    ventanaNueva objV;

    public ControladorVentanaCondenadota(ventanaNueva objV) {
        this.objV = objV;
    }
    
    public ControladorVentanaCondenadota() {
        this.objV = new ventanaNueva();
    }
    
    public void iniciar(){
        objV.getBotonVentana().addActionListener(this);
        objV.getjLabel3().setVisible(false);
        objV.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(objV.getBotonVentana())){
            objV.getBotonVentana().setVisible(false);
            objV.getjLabel3().setVisible(true);
        }
    }       
}
