package control;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import modelo.ArregloDatos;

/**
 *
 * @author Dylier
 */
public abstract class Controlador implements ActionListener{
    /**
     *
     */
    protected static String msgAviso;
    
    /**
     *
     */
    public abstract void iniciar();
    
    /**
     *
     * @param frm
     * @param atributos
     */
    public abstract void actualizarAtributos(JInternalFrame frm, Object... atributos);
    
    /**
     *
     * @param Comp
     */
    protected void limpiarDatos(Container Comp){
        for(Component c: Comp.getComponents()){
            if (c instanceof JTextField) ((JTextField) c).setText("");
            else if (c instanceof JTable) ((DefaultTableModel) ((JTable)c).getModel()).setRowCount(0); 
            else if (c instanceof JComboBox) ((JComboBox) c).setSelectedIndex(0);
            else if (c instanceof Container) limpiarDatos((Container) c);
        }
    }
    
    /**
     *
     * @param obj
     * @param tbm
     */
    protected void agregarInformacionTabla(ArregloDatos obj, TableModel tbm){
        if (obj != null) ((DefaultTableModel) tbm).addRow(obj.getArregloDatos());
    }
         
    /**
     *
     * @param lista
     * @param tbm
     */
    protected void agregarInformacionTabla(ArrayList<? extends ArregloDatos> lista, TableModel tbm){
        for (ArregloDatos obj: lista)
            ((DefaultTableModel) tbm).addRow(obj.getArregloDatos());        
    }
    
    /**
     *
     * @param Comp
     */
    protected void inicializarActList(Container Comp){
        for(Component c: Comp.getComponents()){
            if (c instanceof JComboBox)((JComboBox<?>) c).addActionListener(this);
            else if (c instanceof JButton)((JButton) c).addActionListener(this);
            else if (c instanceof JMenu) {
                for (int i = 0; i < ((JMenu) c).getItemCount(); i++) {
                    if (((JMenu) c).getItem(i) != null) {
                        ((JMenu) c).getItem(i).addActionListener(this);
                    }
                }
            }else if (c instanceof Container) inicializarActList((Container) c);
        }
    }
}
