package control;

import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import modelo.Formulario;
import modelo.Recaudo;
import vista.IfrmAgFormulario;

/**
 *
 * @author Dyl
 */
public class ControladorAgFormulario extends Controlador {
    IfrmAgFormulario frmP;
    Recaudo objR;
    TableModel tbmV;
    TableModel tbmC;
    
    private final SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy"); 

    /**
     *
     * @param frmP
     * @param objR
     * @param tbmV
     * @param tbmC
     */
    public ControladorAgFormulario(IfrmAgFormulario frmP, Recaudo objR, TableModel tbmV, TableModel tbmC) {
        this.frmP = frmP;
        this.objR = objR;
        this.tbmV = tbmV;
        this.tbmC = tbmC;
    }
    
    /**
     *
     */
    public ControladorAgFormulario() {
        this.frmP =  new IfrmAgFormulario();
        this.objR = new Recaudo();       
        this.tbmV = new DefaultTableModel();
        this.tbmC = new DefaultTableModel();
    }

    /**
     *
     * @param atributos
     */
    @Override
    public void actualizarAtributos(JInternalFrame frm, Object... atributos) {
        frmP = (IfrmAgFormulario) frm;
        objR = (Recaudo) atributos[0];
        tbmV = (DefaultTableModel) atributos[1];
        tbmC = (DefaultTableModel) atributos[2];
    }

    /**
     *
     */
    @Override
    public void iniciar() {
        frmP.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        inicializarActList(frmP); 
        frmP.getTxtDescuentoAdicional().setVisible(false);
        frmP.getLblValDescuentoAdicional().setVisible(false);
        frmP.getCmbDescuentoAdd().setSelectedIndex(0);  
        frmP.getTblDatosVehiRecaudo().setModel(tbmV);
        frmP.getTblDatosContRecaudo().setModel(tbmC);
        frmP.setVisible(true);
    }
        
    /**
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(frmP.getCmbDescuentoAdd())) {
            if (frmP.getCmbDescuentoAdd().getSelectedIndex() == 1){ 
                frmP.getTxtDescuentoAdicional().setVisible(true);
                frmP.getLblValDescuentoAdicional().setVisible(true);
            } else {
                frmP.getTxtDescuentoAdicional().setVisible(false);
                frmP.getLblValDescuentoAdicional().setVisible(false);
            }
        }
        
        if (e.getSource().equals(frmP.getBtnAnadirFormulario())) {
            String msg = "";
            try {
                int idFormulario = Integer.parseInt(frmP.getTxtNFactura().getText());
                objR.getFormularios().getLast().setId(idFormulario);

                Date fechaOp = formatoFecha.parse(frmP.getTxtFechaPagoOp().getText());
                objR.getFormularios().getLast().setFechaOportuna(fechaOp);

                Date fechaLim = formatoFecha.parse(frmP.getTxtFechaPagoTar().getText());
                objR.getFormularios().getLast().setFechaLimite(fechaLim);
                
                objR.getFormularios().getLast().setDescuentoAdd(Double.valueOf(frmP.getTxtDescuentoAdicional().getText()));

                msg = "Formulario #" + objR.getFormularios().getLast().getId() + " creado exitosamente.\n" +
                      "Vehículo: " + objR.getFormularios().getLast().getVehiculo().getPlaca() + "\n" +
                      "Contribuyentes: " + objR.getFormularios().getLast().getContribuyentes().size() + "\n" +
                      "Fecha Oportuna: " + formatoFecha.format(objR.getFormularios().getLast().getFechaOportuna().getTime());
                
                limpiarDatos(frmP);
                
                
                objR.getFormularios().add(new Formulario()); 

            } catch (NumberFormatException ex) {
                msg = "Error con el dato " + ex.getMessage().split(":")[1];
            } catch (ParseException ex) {
                msg = "Error, el formato de la fecha debe ser dd/mm/aaaa." + ex.getMessage().split(":")[1];
            } finally {
                JOptionPane.showMessageDialog(frmP, msg, "Generar Formulario", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}