package control;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.beans.PropertyVetoException;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import modelo.Formulario;
import modelo.Recaudo;
import vista.FrmPrincipal;
import vista.IfrmAgFormulario; 
import vista.IfrmAgPropietarios;
import vista.IfrmAgVehiculo; 
import vista.IfrmConsulPropietarios; 
import vista.IfrmConsulRecaudo; 
import vista.IfrmConsulVehiculos; 

/**
 *
 * @author Dyl
 */
public class ControladorPrincipal extends Controlador{
    FrmPrincipal frmP;
    Recaudo objR;
    TableModel tbmV;
    TableModel tbmC;

    /**
     *
     * @param frmP
     * @param objR
     * @param tbmV
     * @param tbmC
     */
    public ControladorPrincipal(FrmPrincipal frmP, Recaudo objR, TableModel tbmV, TableModel tbmC) {
        this.frmP = frmP;
        this.objR = objR;
        this.tbmV = tbmV;
        this.tbmC = tbmC;
    }
    
    /**
     *
     */
    public ControladorPrincipal() {
        this.frmP =  new FrmPrincipal();
        this.objR = new Recaudo();
        this.tbmV = new DefaultTableModel();
        this.tbmC = new DefaultTableModel();
    }
    
    /**
     *
     * @param ifrm
     * @return
     */
    public boolean verificarVentana(JInternalFrame ifrm) {
        boolean existe = false;
        for (Component c : frmP.getEscritorio().getComponents()) {
            if(c instanceof JInternalFrame){
                existe = ((JInternalFrame) c).getClass().equals(ifrm.getClass());
                if (existe) {
                    ((JInternalFrame) c).toFront();
                    try{
                        ((JInternalFrame) c).setSelected(true);
                    }catch(PropertyVetoException e){
                        JOptionPane.showMessageDialog(frmP, "No es posible seleccionar esta ventana", "Informacion Importante", 1);
                    }
                    break;
                }
            }
        }
        return existe;
    }
    
    /**
     *
     */
    public void inicializarTablas(){
        tbmC = new IfrmAgPropietarios().getTblDatosContibuyentes().getModel();
        tbmV = new IfrmAgVehiculo().getTblDatosVehiculo().getModel();
    }
    
    /**
     *
     */
    @Override
    public void iniciar() {
        frmP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmP.setLocationRelativeTo(null);
        inicializarActList(frmP);
        inicializarTablas();
        objR.getFormularios().add(new Formulario());
        frmP.getAviso().setText(Controlador.msgAviso);
        frmP.setVisible(true);
    }
    
    /**
     *
     * @param frm
     * @param atributos
     */
    @Override
    public void actualizarAtributos(JInternalFrame frm, Object[] atributos){
        frmP = (FrmPrincipal) new FrmPrincipal();
        objR = (Recaudo) atributos[0];
        tbmV = (TableModel) atributos[1];
        tbmC = (TableModel) atributos[2];
    }
    
    private void inicializarInternalFrame(Controlador c, JInternalFrame frm, Object... atributos){
        if (!verificarVentana((JInternalFrame) frm)){
            c.actualizarAtributos(frm, atributos);
            frmP.getEscritorio().add((JInternalFrame) frm);
            c.iniciar();
        }
    }
    
    /**
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {        
        if (e.getSource().equals(frmP.getBtnAgPropietarios()) || e.getSource().equals(frmP.getBtnMnAgPropietario())) 
            inicializarInternalFrame(new ControladorAgPropietarios(), new IfrmAgPropietarios(), objR, tbmC);
        
        else if (e.getSource().equals(frmP.getBtnAgVehiculo()) || e.getSource().equals(frmP.getBtnMnAgVehiculo())) 
            inicializarInternalFrame(new ControladorAgVehiculo(), new IfrmAgVehiculo(), objR, tbmV, null);
        
        else if (e.getSource().equals(frmP.getBtnAgFormulario()) || e.getSource().equals(frmP.getBtnMnAgFormulario())) 
            inicializarInternalFrame(new ControladorAgFormulario(), new IfrmAgFormulario(), objR, tbmV, tbmC);
        
        else if (e.getSource().equals(frmP.getBtnMnConsulPropietarios())) 
            inicializarInternalFrame(new ControladorConsulPropietarios(), new IfrmConsulPropietarios(), objR);
        
         else if (e.getSource().equals(frmP.getBtnMnConsulVehiculos())) 
            inicializarInternalFrame(new ControladorConsulVehiculos(), new IfrmConsulVehiculos(), objR);
         
         else if (e.getSource().equals(frmP.getBtnConsulRecaudo()) || e.getSource().equals(frmP.getBtnMnConsulFormularios()))
            inicializarInternalFrame(new ControladorConsulFormulario(), new IfrmConsulRecaudo(), objR);        
    }
}