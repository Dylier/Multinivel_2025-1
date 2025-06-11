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
     * Constructor para inicializar el controlador con objetos existentes.
     * @param frmP La ventana de agregar formulario.
     * @param objR El objeto Recaudo que contiene los formularios.
     * @param tbmV El modelo de tabla para los vehículos.
     * @param tbmC El modelo de tabla para los contribuyentes.
     */
    public ControladorAgFormulario(IfrmAgFormulario frmP, Recaudo objR, TableModel tbmV, TableModel tbmC) {
        this.frmP = frmP;
        this.objR = objR;
        this.tbmV = tbmV;
        this.tbmC = tbmC;
    }

    /**
     * Constructor por defecto que inicializa los objetos con nuevas instancias.
     */
    public ControladorAgFormulario() {
        this.frmP = new IfrmAgFormulario();
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
        frmP = (IfrmAgFormulario) frm;
        objR = (Recaudo) atributos[0];
        tbmV = (DefaultTableModel) atributos[1];
        tbmC = (DefaultTableModel) atributos[2];
    }

    /**
     * Inicia el controlador, configurando la ventana de agregar formulario.
     */
    @Override
    public void iniciar() {
        frmP.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        inicializarActList(frmP);
        frmP.getTxtNFactura().setEnabled(false);
        frmP.getTxtNFactura().setText(String.valueOf(objR.getFormularios().size()));
        frmP.getTblDatosVehiRecaudo().setModel(tbmV);
        frmP.getTblDatosContRecaudo().setModel(tbmC);
        frmP.getBtnAnadirFormulario().setEnabled(false);
        frmP.setVisible(true);
    }

    /**
     * Maneja las acciones de los botones y el JComboBox en la interfaz de agregar formulario.
     * @param e El evento de acción.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(frmP.getCmbDescuentoAdd())) {
            switch (frmP.getCmbDescuentoAdd().getSelectedIndex()) {
                case 1:
                    frmP.getTxtDescuentoAdicional().setVisible(true);
                    frmP.getLblValDescuentoAdicional().setVisible(true);
                    frmP.getBtnAnadirFormulario().setEnabled(true);
                    break;
                case 2:
                    frmP.getTxtDescuentoAdicional().setVisible(false);
                    frmP.getLblValDescuentoAdicional().setVisible(false);
                    frmP.getTxtDescuentoAdicional().setText("0");
                    frmP.getBtnAnadirFormulario().setEnabled(true);
                    break;
                default:
                    frmP.getBtnAnadirFormulario().setEnabled(false);
                    break;
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

                if (!objR.getFormularios().getLast().getContribuyentes().isEmpty()){
                    msg = "Formulario #" + objR.getFormularios().getLast().getId() + " creado exitosamente.\n" +
                            "Vehículo: " + objR.getFormularios().getLast().getVehiculo().getPlaca() + "\n" +
                            "Contribuyentes: " + objR.getFormularios().getLast().getContribuyentes().size() + "\n" +
                            "Fecha Oportuna: " + formatoFecha.format(objR.getFormularios().getLast().getFechaOportuna().getTime());

                    limpiarDatos(frmP);

                    objR.getFormularios().add(new Formulario());

                    frmP.getTxtNFactura().setText(String.valueOf(objR.getFormularios().size()));
                } else {
                    throw new ArrayIndexOutOfBoundsException("Debe ingresar al menos un contribuyente.");
                }

            } catch (NumberFormatException ex) {
                msg = "Error con el dato " + ex.getMessage().split(":")[1];
            } catch (ParseException ex) {
                msg = "Error, el formato de la fecha debe ser dd/mm/aaaa." + ex.getMessage().split(":")[1];
            } catch (ArrayIndexOutOfBoundsException ex){
                msg = ex.getMessage();
            } catch (NullPointerException ex){
                msg = "Error, verifique haber ingresado un vehiculo.";
            } finally {
                super.msgAviso.setText(msg);
                JOptionPane.showMessageDialog(frmP, msg, "Generar Formulario", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}