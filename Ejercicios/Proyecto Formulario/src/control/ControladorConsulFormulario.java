package control;

import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
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
    TableModel tbmV;
    TableModel tbmC;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    /**
     * Constructor para inicializar el controlador con objetos existentes.
     * @param frmR La ventana de consulta de recaudo.
     * @param objR El objeto Recaudo que contiene los formularios.
     * @param tbmV El modelo de tabla para los vehículos.
     * @param tbmC El modelo de tabla para los contribuyentes.
     */
    public ControladorConsulFormulario(IfrmConsulRecaudo frmR, Recaudo objR, TableModel tbmV, TableModel tbmC) {
        this.frmR = frmR;
        this.objR = objR;
        this.tbmV = tbmV;
        this.tbmC = tbmC;
    }

    /**
     * Constructor por defecto que inicializa los objetos con nuevas instancias.
     */
    public ControladorConsulFormulario() {
        this.frmR = new IfrmConsulRecaudo();
        this.objR = new Recaudo();
        this.tbmV = new DefaultTableModel();
        this.tbmC = new DefaultTableModel();
    }


    /**
     * Actualiza los atributos del controlador con los nuevos valores.
     * @param frm La ventana interna.
     * @param atributos Un array de objetos que contiene Recaudo, TableModel de vehículos y TableModel de contribuyentes.
     */
    @Override
    public void actualizarAtributos(JInternalFrame frm, Object... atributos) {
        frmR = (IfrmConsulRecaudo) frm;
        objR = (Recaudo) atributos[0];
        tbmV = (DefaultTableModel) atributos[1];
        tbmC = (DefaultTableModel) atributos[2];
    }

    /**
     * Inicia el controlador, configurando la ventana de consulta de formularios.
     */
    @Override
    public void iniciar() {
        frmR.setTitle("Consulta Formularios");
        frmR.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        inicializarActList(frmR);
        actualizarCmbFormularios();
        frmR.getBtnRecaudo().setEnabled(false);
        frmR.setVisible(true);
    }

    /**
     * Actualiza el JComboBox con los IDs de los formularios existentes.
     */
    private void actualizarCmbFormularios(){
        frmR.getCmbNFormulario().removeAllItems();
        frmR.getCmbNFormulario().addItem("Seleccione Formulario");
        for (int i = 0; i < objR.getFormularios().size() - 1; i++){
            frmR.getCmbNFormulario().addItem("Formulario #" + objR.getFormularios().get(i).getId());
        }
    }

    /**
     * Busca un formulario por su ID.
     * @return Formulario Retorna el objeto Formulario si lo encuentra, de lo contrario retorna null.
     */
    public Formulario buscarFormulario(){
        Formulario objF = null;
        int index;
        if (frmR.getCmbNFormulario().getSelectedIndex() != 0){
            index = Integer.parseInt(frmR.getCmbNFormulario().getSelectedItem().toString().split("#")[1]);
            for (Formulario formulario: objR.getFormularios()) {
                if (index == (formulario.getId())){
                    objF = formulario;
                    break;
                }
            }
        }
        return objF;
    }

    /**
     * Llena los campos y tablas de la interfaz con los datos del formulario seleccionado.
     * @param objF El objeto Formulario con los datos a mostrar.
     */
    private void llenarDatosFormulario(Formulario objF){
        limpiarDatos(frmR);
        agregarInformacionTabla(objF.getVehiculo(), frmR.getTblDatosVehiRecaudo().getModel());
        agregarInformacionTabla(objF.getContribuyentes(), frmR.getTblDatosContRecaudo().getModel());
        frmR.getTxtDescCombus().setText(String.format("%.2f", objF.getDescuentoCombustible()));
        frmR.getTxtDescProntoP().setText(String.format("%.2f", objF.getDescuentoProntoPago()));
        frmR.getTxtPagoVoluntario().setText(String.format("%.2f", objF.getPagoVoluntario()));
        frmR.getTxtTotal().setText(String.format("%.2f", objF.getTotal()));
        frmR.getTxtTotalDescPP().setText(String.format("%.2f", objF.getTotal() - objF.getDescuentoProntoPago()));
        frmR.getTxtTotalPVolDescPP().setText(String.format("%.2f", objF.getTotal() + objF.getPagoVoluntario() - objF.getDescuentoProntoPago()));
        frmR.getTxtTotalPagoV().setText(String.format("%.2f", objF.getPagoVoluntario()));
        frmR.getTxtValSemaforizacion().setText(String.format("%.2f", objF.getValorSemaforizacion()));
        frmR.getTxtFechaOp().setText(dateFormat.format(objF.getFechaOportuna()));
        frmR.getTxtFechaLim().setText(dateFormat.format(objF.getFechaLimite()));
    }

    /**
     * Maneja las acciones de los botones en la interfaz de consulta de formularios.
     * @param e El evento de acción.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(frmR.getBtnBuscar())){
            Formulario objF = buscarFormulario();
            if (objF != null){
                llenarDatosFormulario(objF);
                frmR.getBtnRecaudo().setEnabled(true);
            }
        }

        else if (e.getSource().equals(frmR.getBtnRecaudo())) {
            Formulario objF = buscarFormulario();
            if (objF != null){
                frmR.getTxtRecaudo().setText(String.format("%.2f", objR.totalRecaudo()));
                JOptionPane.showMessageDialog(frmR,
                        "Vehiculos Registrados: " + objR.getFormularios().size() + "\nTotal Recaudo: " + String.format("%.2f", objR.totalRecaudo()),
                        "Registro.", JOptionPane.INFORMATION_MESSAGE);
                frmR.getBtnRecaudo().setEnabled(false);
            }
        }

        else if (e.getSource().equals(frmR.getBtnPDF())){
            FormularioPDF objPDF = new FormularioPDF();
            Formulario objF = buscarFormulario();
            if (objF != null){
                llenarDatosFormulario(objF);
                String msg = "";
                try {
                    objPDF.archivoFormularioPdf(objF);
                    msg = "PDF GENERADO";
                } catch (Exception ex) {
                    msg = "ERROR GENERANDO PDF" + ex.getMessage();
                } finally {
                    super.msgAviso.setText(msg);
                    JOptionPane.showMessageDialog(frmR, msg);
                }
            }
        }

        else if(e.getSource().equals(frmR.getBtnEditar())){
            Formulario objF = buscarFormulario();
            if (objF != null){
                llenarDatosFormulario(objF);
                objR.getFormularios().removeLast();
                objR.getFormularios().remove(objF);
                objR.getFormularios().add(objF);
                ((DefaultTableModel) tbmV).setRowCount(0);
                ((DefaultTableModel) tbmC).setRowCount(0);
                agregarInformacionTabla(objF.getVehiculo(), tbmV);
                agregarInformacionTabla(objF.getContribuyentes(), tbmC);
            }
        }

        else if (e.getSource().equals(frmR.getBtnReintentar())){
            actualizarCmbFormularios();
        }
    }

}