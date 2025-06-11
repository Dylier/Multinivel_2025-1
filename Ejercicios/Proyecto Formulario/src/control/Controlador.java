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
     * Campo de texto estático para mostrar mensajes de aviso.
     */
    protected static JTextField msgAviso;

    /**
     * Método abstracto para iniciar el controlador y su vista asociada.
     */
    public abstract void iniciar();

    /**
     * Método abstracto para actualizar los atributos del controlador con nuevos valores.
     * @param frm La ventana interna JInternalFrame que se va a actualizar.
     * @param atributos Un conjunto de objetos que se utilizarán para actualizar los atributos.
     */
    public abstract void actualizarAtributos(JInternalFrame frm, Object... atributos);

    /**
     * Limpia los datos de los componentes dentro de un contenedor.
     * Esto incluye JTextFields, JTables y JComboBoxes.
     * @param Comp El contenedor cuyos componentes se limpiarán.
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
     * Agrega la información de un objeto que implementa ArregloDatos a un TableModel.
     * @param obj El objeto ArregloDatos cuya información se agregará.
     * @param tbm El TableModel al que se añadirá la fila.
     */
    protected void agregarInformacionTabla(ArregloDatos obj, TableModel tbm){
        if (obj != null) ((DefaultTableModel) tbm).addRow(obj.getArregloDatos());
    }

    /**
     * Agrega la información de una lista de objetos que implementan ArregloDatos a un TableModel.
     * @param lista La lista de objetos ArregloDatos cuya información se agregará.
     * @param tbm El TableModel al que se añadirán las filas.
     */
    protected void agregarInformacionTabla(ArrayList<? extends ArregloDatos> lista, TableModel tbm){
        for (ArregloDatos obj: lista)
            ((DefaultTableModel) tbm).addRow(obj.getArregloDatos());
    }

    /**
     * Inicializa los ActionListeners para los componentes interactivos dentro de un contenedor.
     * Esto incluye JComboBoxes, JButtons y JMenus.
     * @param Comp El contenedor cuyos componentes se inicializarán.
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