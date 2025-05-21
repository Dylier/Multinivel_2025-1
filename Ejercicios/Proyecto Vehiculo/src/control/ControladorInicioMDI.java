package control;

import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.table.TableModel;
import modelo.Recaudo;
import modelo.Vehiculo;
import vista.*;

/**
 *
 * @author Dyl
 */
public class ControladorInicioMDI extends Controlador{
    FrmInicio frmR;
    Recaudo objR;
    Vehiculo objV;
    TableModel modeloTB;
    
    public ControladorInicioMDI(FrmInicio frmR, Recaudo objR, Vehiculo objV, TableModel modeloTB) {
        this.frmR = frmR;
        this.objR = objR;
        this.objV = null;
        this.modeloTB = modeloTB;
    }
   
    public ControladorInicioMDI() {
        this.frmR = new FrmInicio();
        this.objR = new Recaudo();
        this.objV = null;
        this.modeloTB = null;
    }

    public boolean verificarVentana(JInternalFrame ifrm) {
        boolean existe = false;
        for (Component c : frmR.getDesktopPane().getComponents()) {
            if(c instanceof JInternalFrame){
                existe = ((JInternalFrame) c).getClass().equals(ifrm.getClass());
                if (existe) break;
            }
        }
        return existe;
    }
    
    @Override
    public void iniciar() {
        frmR.setTitle("Registro Vehiculos");
        frmR.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmR.setLocationRelativeTo(null);
        
        inicializarActList(frmR);
        
        frmR.getBtnConsulPropMenu().addActionListener(this);
        frmR.getBtnRecaudoMenu().addActionListener(this);
        frmR.getBtnRegPropMenu().addActionListener(this);
        frmR.getBtnRegistrarMenu().addActionListener(this);
        frmR.getBtnSalirMenu().addActionListener(this);
        
        modeloTB = new IntFrmRecaudo().getTblDatos().getModel();
                
        frmR.setVisible(true);
    }
    
    @Override
    public void actualizarAtributos(Object[] atributos){
        objR = (Recaudo) atributos[0];
        objV = (Vehiculo) atributos[1];
        modeloTB = (TableModel) atributos[2];
    }
    
    private void inicializarInternalFrame(Controlador objC, Object... atributos){
        if (!verificarVentana((JInternalFrame) atributos[0])){
            objC.actualizarAtributos(atributos);
            frmR.getDesktopPane().add((JInternalFrame) atributos[0]);
            objC.iniciar();
            ((JInternalFrame) atributos[0]).setVisible(true);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {       
        if (e.getSource().equals(frmR.getBtnRecaudo()) || e.getSource().equals(frmR.getBtnRecaudoMenu())) 
            inicializarInternalFrame(new ControladorRecaudoMDI(), new IntFrmRecaudo(), objR, modeloTB);
        
        else if (e.getSource().equals(frmR.getBtnConsulPropMenu())) 
            inicializarInternalFrame(new ControladorConsulPropMDI(), new IntFrmConsulProp());
        
        else if (e.getSource().equals(frmR.getBtnRegistrar()) || e.getSource().equals(frmR.getBtnRegistrarMenu())) 
            inicializarInternalFrame(new ControladorRegistrarMDI(), new IntFrmRegistrar(), objR, objV, modeloTB);
                
        else if (e.getSource().equals(frmR.getBtnRegPropMenu())) 
            inicializarInternalFrame(new ControladorRegPropMDI(), new IntFrmRegProp());
        
        else if (e.getSource().equals(frmR.getBtnSalir()) || e.getSource().equals(frmR.getBtnSalirMenu())) 
            if (new CajasMensaje().confirmar("Desea Salir de la Aplicacion?")) frmR.dispose();
    }
}

