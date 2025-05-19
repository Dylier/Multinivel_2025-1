package control;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import modelo.Auto;
import modelo.Moto;
import modelo.Recaudo;
import modelo.Vehiculo;
import vista.CajasMensaje;

/**
 *
 * @author Dylier
 */
public abstract class Controlador implements ActionListener{

    public abstract void iniciar();
    
    public abstract void actualizarAtributos(Object... atributos);
    
    public void inicializarActList(Container Comp){
        for(Component c: Comp.getComponents()){
            if (c instanceof JComboBox){
                ((JComboBox) c).addActionListener(this);
            } else if (c instanceof JButton){
                ((JButton) c).addActionListener(this);
            } else if (c instanceof Container){
                inicializarActList((Container) c);
            } 
        }
    }
}
