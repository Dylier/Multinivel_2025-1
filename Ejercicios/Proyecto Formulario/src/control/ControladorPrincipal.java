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
 * Controlador principal para la aplicación de gestión de recaudo de impuestos vehiculares.
 * Gestiona la interacción con la ventana principal y la apertura de ventanas internas.
 *
 * @author Dyl
 */
public class ControladorPrincipal extends Controlador{
    FrmPrincipal frmP;
    Recaudo objR;
    TableModel tbmV;
    TableModel tbmC;

    /**
     * Inicializa el controlador principal con datos preexistentes.
     * @param frmP La instancia de la ventana principal (FrmPrincipal).
     * @param objR El objeto Recaudo que contiene la lógica de negocio y datos.
     * @param tbmV El TableModel para la tabla de vehículos.
     * @param tbmC El TableModel para la tabla de contribuyentes.
     */
    public ControladorPrincipal(FrmPrincipal frmP, Recaudo objR, TableModel tbmV, TableModel tbmC) {
        this.frmP = frmP;
        this.objR = objR;
        this.tbmV = tbmV;
        this.tbmC = tbmC;
    }

    /**
     * Inicializa el controlador principal con instancias por defecto de sus dependencias.
     */
    public ControladorPrincipal() {
        this.frmP =  new FrmPrincipal();
        this.objR = new Recaudo();
        this.tbmV = new DefaultTableModel();
        this.tbmC = new DefaultTableModel();
    }

    /**
     * Verifica si una ventana interna específica ya está abierta en el escritorio principal.
     * Si está abierta, la trae al frente y la selecciona.
     * @param ifrm La JInternalFrame a verificar.
     * @return true si la ventana ya existe y está abierta, false en caso contrario.
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
                        JOptionPane.showMessageDialog(frmP, "No es posible seleccionar esta ventana", "Informacion Importante", JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;
                }
            }
        }
        return existe;
    }

    /**
     * Inicializa los modelos de las tablas utilizadas en las vistas.
     */
    public void inicializarTablas(){
        tbmC = new IfrmAgPropietarios().getTblDatosContibuyentes().getModel();
        tbmV = new IfrmAgVehiculo().getTblDatosVehiculo().getModel();
    }

    /**
     * Inicia la ventana principal, configura sus propiedades y prepara el entorno.
     */
    @Override
    public void iniciar() {
        frmP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmP.setLocationRelativeTo(null);
        inicializarActList(frmP);
        inicializarTablas();
        super.msgAviso = frmP.getTxtAvisos();
        objR.getFormularios().add(new Formulario()); // Agrega un nuevo formulario vacío al inicio.
        frmP.setVisible(true);
    }

    /**
     * Actualiza los atributos del controlador principal.
     * Este método se sobrescribe, aunque su uso en este controlador particular podría ser limitado
     * dado que los atributos se inicializan en el constructor o en el método `iniciar`.
     * @param frm No se utiliza en esta implementación.
     * @param atributos Un array de objetos que contiene el objeto Recaudo y los TableModels.
     */
    @Override
    public void actualizarAtributos(JInternalFrame frm, Object[] atributos){
        // La creación de una nueva instancia de FrmPrincipal aquí podría no ser el comportamiento deseado
        // si la intención es actualizar la instancia actual.
        frmP = (FrmPrincipal) new FrmPrincipal();
        objR = (Recaudo) atributos[0];
        tbmV = (TableModel) atributos[1];
        tbmC = (TableModel) atributos[2];
    }

    /**
     * Inicializa y muestra una ventana interna (JInternalFrame) en el escritorio principal.
     * Se asegura de que la ventana no esté ya abierta antes de crear una nueva instancia.
     * @param c El controlador asociado a la ventana interna.
     * @param frm La instancia de la JInternalFrame a mostrar.
     * @param atributos Los atributos que se pasarán al controlador de la ventana interna.
     */
    private void inicializarInternalFrame(Controlador c, JInternalFrame frm, Object... atributos){
        if (!verificarVentana(frm)){
            c.actualizarAtributos(frm, atributos);
            frmP.getEscritorio().add(frm);
            c.iniciar();
        }
    }

    /**
     * Maneja los eventos de acción generados por los componentes de la interfaz de usuario.
     * Abre las ventanas internas correspondientes según el botón o elemento de menú presionado.
     * @param e El ActionEvent que disparó este método.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(frmP.getBtnAgPropietarios()) || e.getSource().equals(frmP.getBtnMnAgPropietario())) {
            inicializarInternalFrame(new ControladorAgPropietarios(), new IfrmAgPropietarios(), objR, tbmC);
        } else if (e.getSource().equals(frmP.getBtnAgVehiculo()) || e.getSource().equals(frmP.getBtnMnAgVehiculo())) {
            inicializarInternalFrame(new ControladorAgVehiculo(), new IfrmAgVehiculo(), objR, tbmV, null);
        } else if (e.getSource().equals(frmP.getBtnAgFormulario()) || e.getSource().equals(frmP.getBtnMnAgFormulario())) {
            inicializarInternalFrame(new ControladorAgFormulario(), new IfrmAgFormulario(), objR, tbmV, tbmC);
        } else if (e.getSource().equals(frmP.getBtnMnConsulPropietarios())) {
            inicializarInternalFrame(new ControladorConsulPropietarios(), new IfrmConsulPropietarios(), objR);
        } else if (e.getSource().equals(frmP.getBtnMnConsulVehiculos())) {
            inicializarInternalFrame(new ControladorConsulVehiculos(), new IfrmConsulVehiculos(), objR);
        } else if (e.getSource().equals(frmP.getBtnConsulRecaudo()) || e.getSource().equals(frmP.getBtnMnConsulFormularios())) {
            inicializarInternalFrame(new ControladorConsulFormulario(), new IfrmConsulRecaudo(), objR, tbmV, tbmC);
        } else if (e.getSource().equals(frmP.getBtnSalir())) {
            frmP.dispose(); // Cierra la ventana principal de la aplicación.
        }
    }
}