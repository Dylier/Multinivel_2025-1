package control;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.Formulario; 
import modelo.FormularioPDF;
import modelo.Recaudo; 
import vista.IfrmConsulRecaudo;

/**
 *
 * @author Dyl
 */
public class ControladorConsulFormulario extends Controlador {
    IfrmConsulRecaudo frmR;
    Recaudo objR;
    
    /**
     *
     */
    @Override
    public void iniciar() {
        frmR.setTitle("Consulta Formularios");
        frmR.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        inicializarActList(frmR);
        actualizarCmbFormularios();
        frmR.getTxtRecaudo().setEditable(false);
        frmR.getBtnRecaudo().setEnabled(false);
        frmR.setVisible(true);
    }
    
    private void actualizarCmbFormularios(){
        frmR.getCmbNFormulario().removeAllItems();
        frmR.getCmbNFormulario().addItem("Seleccione Formulario");
        for (Formulario objF: objR.getFormularios()){
            frmR.getCmbNFormulario().addItem("Formulario #" + objF.getId());
        }
    }  

    /**
     *
     * @param Comp
     * @param estado
     */
    public void bloquearDatos(Container Comp, boolean estado){
        for(Component c: Comp.getComponents()){
            if (c instanceof JTextField){
                ((JTextField) c).setText(""); 
                ((JTextField) c).setEnabled(estado); 
            } else if (c instanceof JComboBox){
                ((JComboBox) c).setSelectedIndex(0);
                ((JComboBox) c).setEnabled(estado);
            } else if (c instanceof Container){
                bloquearDatos((Container) c, estado);
            } 
        }
    }

    /**
     *
     * @return
     */
    public Formulario buscarFormulario(){
        Formulario objF = null;
        int index;
        if (frmR.getCmbNFormulario().getSelectedIndex() != 0){
            index = Integer.parseInt(frmR.getCmbNFormulario().getSelectedItem().toString().split("#")[1]);
            for (Formulario formulario : objR.getFormularios()) {
                if (index == (formulario.getId())){
                    objF = formulario;
                    break;
                }
            }
        }
        return objF;
    }
    
    /**
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(frmR.getBtnBuscar())){             
            Formulario objF = buscarFormulario();            
            if (objF != null){
                limpiarDatos(frmR);
                agregarInformacionTabla(objF.getVehiculo(), frmR.getTblDatosVehiRecaudo().getModel());
                agregarInformacionTabla(objF.getContribuyentes(), frmR.getTblDatosContRecaudo().getModel());
            }
        }       

        else if (e.getSource().equals(frmR.getBtnRecaudo())) {
            frmR.getTxtRecaudo().setText(String.format("%.2f", objR.totalRecaudo()));
            JOptionPane.showMessageDialog(frmR,
                    "Vehiculos Registrados: " + objR.getFormularios().size() + "\nTotal Recaudo: " + String.format("%.2f", objR.totalRecaudo()),
                    "Registro.", JOptionPane.INFORMATION_MESSAGE);
        }
        
        else if (e.getSource().equals(frmR.getBtnPDF())){
            FormularioPDF objPDF = new FormularioPDF();
            Formulario objF = buscarFormulario(); 
            if (objF != null){
                String msg = "";
                try {
                    objPDF.archivoFormularioPdf(objF);
                    msg = "PDF GENERADO";
                } catch (Exception ex) {
                    msg = "ERROR" + ex.getMessage();
                } finally {
                    JOptionPane.showMessageDialog(frmR, msg);
                }
            }
        }
        
        else if(e.getSource().equals(frmR.getBtnEditar())){
            Formulario objF = buscarFormulario(); 
            if (objF != null){
                objR.getFormularios().removeLast();
                objR.getFormularios().remove(objF);
                objR.getFormularios().add(objF);
            }
        }
        
        else if (e.getSource().equals(frmR.getBtnReintentar()))
            actualizarCmbFormularios();
    }

    /**
     *
     * @param atributos
     */
    @Override
    public void actualizarAtributos(JInternalFrame frm, Object... atributos) {
        frmR = (IfrmConsulRecaudo) frm;
        objR = (Recaudo) atributos[0];
    }
}