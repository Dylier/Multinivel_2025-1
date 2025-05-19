/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.MDI;
import vista.ventanaNueva;

/**
 *
 * @author Dyl
 */
public class ControladorMDI implements ActionListener{
    MDI objM;

    public ControladorMDI(MDI objM) {
        this.objM = objM;
    }
    public ControladorMDI() {
        this.objM = new MDI();
    }
    
    public void iniciar(){
        objM.getjMenuItem1().addActionListener(this);
        objM.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // e --> Evento
        // Que hago con ese evento?
        // Como se si es mi boton?
        
        // e.equals(objM.getBoton)
        // -- > Si el evento es igual a mi boton
        
        // e Es un evento, no un boton
        //   
        // De que boton viene?
        //      |
        //      |
        //     \ /
        // e.getSource()
        //
        // e.getSource().equals(objM.getBoton)
        // --> Esto ya es una pregunta
        
        // if (e.getSource().equals(objM.getBoton)) 
        // {Si si es mi boton, haga esto}
        
        if(e.getSource().equals(objM.getjMenuItem1())){
            ventanaNueva objV = new ventanaNueva();
            ControladorVentanaCondenadota objC = new ControladorVentanaCondenadota(objV);
            objC.iniciar();
            objM.getjDesktopPane1().add(objV);
            objV.setVisible(true);
        }
    }
    
    
}
