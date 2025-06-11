package control;

import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import modelo.Contribuyente;
import modelo.Recaudo;
import vista.IfrmAgPropietarios;

/**
 *
 * @author Dyl
 */
public class ControladorAgPropietarios extends Controlador {
    private IfrmAgPropietarios frmP;
    private Recaudo objR;
    private TableModel tbmC;
    private final SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");

    /**
     * Constructor para inicializar el controlador con objetos existentes.
     * @param frmP La ventana de agregar propietarios.
     * @param objR El objeto Recaudo que contiene los formularios.
     * @param tbmC El modelo de tabla para los contribuyentes.
     */
    public ControladorAgPropietarios(IfrmAgPropietarios frmP, Recaudo objR, TableModel tbmC) {
        this.frmP = frmP;
        this.objR = objR;
        this.tbmC = tbmC;
    }

    /**
     * Constructor por defecto que inicializa los objetos con nuevas instancias.
     */
    public ControladorAgPropietarios() {
        this.frmP = new IfrmAgPropietarios();
        this.objR = new Recaudo();
        this.tbmC = new DefaultTableModel();
    }

    /**
     * Actualiza los atributos del controlador con los nuevos valores.
     * @param frm La ventana interna.
     * @param atributos Un array de objetos que contiene Recaudo y el TableModel de contribuyentes.
     */
    @Override
    public void actualizarAtributos(JInternalFrame frm, Object... atributos) {
        frmP = (IfrmAgPropietarios) frm;
        objR = (Recaudo) atributos[0];
        tbmC = (DefaultTableModel) atributos[1];
    }

    /**
     * Inicia el controlador, configurando la ventana de registro de propietarios.
     */
    @Override
    public void iniciar() {
        frmP.setTitle("Registro de Propietarios");
        frmP.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmP.getTblDatosContibuyentes().setModel(tbmC);
        inicializarActList(frmP);
        frmP.setVisible(true);
    }

    /**
     * Maneja las acciones de los botones en la interfaz de agregar propietarios.
     * @param e El evento de acción.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(frmP.getBtnRegistrarProp())) {
            String msg = "";
            try {
                Contribuyente objC = new Contribuyente();
                objC.setNombre(frmP.getTxtNom().getText());
                objC.setTipoDocumento(frmP.getCmbTipoDocu().getSelectedItem().toString());
                objC.setDocumento(Integer.parseInt(frmP.getTxtCedula().getText()));
                objC.setCorreo(frmP.getTxtCorreo().getText());
                objC.setFecNac(formatoFecha.parse(frmP.getTxtFecNac().getText()));
                objC.setCalidad(frmP.getTxtCalidad().getText());
                objC.setDireccion(frmP.getTxtDireccion().getText());
                objC.setMunicipio(frmP.getTxtMunicipio().getText());
                objC.setPorcPropiedad(Double.parseDouble(frmP.getTxtPropiedad().getText()));

                objR.getFormularios().getLast().getContribuyentes().add(objC);

                limpiarDatos(frmP);

                agregarInformacionTabla(objR.getFormularios().getLast().getContribuyentes(), tbmC);

                msg = "Propietario registrado exitosamente: \n" + objC.toString();

            } catch (NumberFormatException ex) {
                msg = "Error con el dato " + ex.getMessage().split(":")[1];
            } catch (ParseException ex) {
                msg = "Error, el formato de la fecha debe ser dd/mm/aaaa.";
            } finally {
                super.msgAviso.setText(msg);
                JOptionPane.showMessageDialog(frmP, msg, "Registro de Propietario", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}