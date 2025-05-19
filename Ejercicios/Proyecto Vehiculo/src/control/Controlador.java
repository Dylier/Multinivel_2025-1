package control;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

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
            } else if (c instanceof JMenuItem){
                ((JMenuItem) c).addActionListener(this);
            } else if (c instanceof Container || c instanceof JMenuBar || c instanceof JMenu){
                inicializarActList((Container) c);
            } 
        }
    }
}
