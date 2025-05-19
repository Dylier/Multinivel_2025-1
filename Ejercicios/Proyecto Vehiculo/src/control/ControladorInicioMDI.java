package control;

import java.awt.Component;
import java.awt.Container;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import modelo.Auto;
import modelo.Moto;
import modelo.Recaudo;
import modelo.Vehiculo;
import vista.CajasMensaje;
import vista.FrmInicio;
import vista.IntFrmConsulProp;
import vista.IntFrmRecaudo;
import vista.IntFrmRegistrar;

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
      

    @Override
    public void iniciar() {
        frmR.setTitle("Registro Vehiculos");
        frmR.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmR.setLocationRelativeTo(null);
        
        inicializarActList(frmR);
        
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
        objC.actualizarAtributos(atributos);
        frmR.getDesktopPane().add((JInternalFrame) atributos[0]);
        objC.iniciar();
        ((JInternalFrame) atributos[0]).setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {       
        if (e.getSource().equals(frmR.getBtnRecaudo()) || e.getSource().equals(frmR.getBtnRecaudoMenu())) inicializarInternalFrame(new ControladorRecaudoMDI(), new IntFrmRecaudo(), objR, modeloTB);
        
        else if (e.getSource().equals(frmR.getBtnConsulPropMenu())) inicializarInternalFrame(new ControladorConsulPropMDI(), new IntFrmConsulProp());
        
        else if (e.getSource().equals(frmR.getBtnRegistrar()) || e.getSource().equals(frmR.getBtnRegistrarMenu())) inicializarInternalFrame(new ControladorRegistrarMDI(), new IntFrmRegistrar(), objR, objV, modeloTB);
                
        else if (e.getSource().equals(frmR.getBtnRegPropMenu())) new ControladorRegPropMDI().iniciar();
        
        else if (e.getSource().equals(frmR.getBtnSalir()) || e.getSource().equals(frmR.getBtnSalirMenu())) if (new CajasMensaje().confirmar("Desea Salir de la Aplicacion?")) frmR.dispose();
    }
}

