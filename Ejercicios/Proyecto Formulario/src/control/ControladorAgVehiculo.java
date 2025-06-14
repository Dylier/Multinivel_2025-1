package control;

import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import modelo.Auto;
import modelo.Moto;
import modelo.Recaudo;
import modelo.Vehiculo;
import vista.IfrmAgVehiculo;

/**
 *
 * @author Dyl
 */
public class ControladorAgVehiculo extends Controlador {
    IfrmAgVehiculo frmP;
    Recaudo objR;
    Vehiculo objV;
    TableModel tbmV;

    /**
     * Constructor para inicializar el controlador con objetos existentes.
     * @param frmP La ventana de agregar vehículo.
     * @param objR El objeto Recaudo que contiene los formularios.
     * @param objV El objeto Vehiculo a manipular.
     * @param tbmV El modelo de tabla para los vehículos.
     */
    public ControladorAgVehiculo(IfrmAgVehiculo frmP, Recaudo objR, Vehiculo objV, TableModel tbmV) {
        this.frmP = frmP;
        this.objR = objR;
        this.objV = objV;
        this.tbmV = tbmV;
    }

    /**
     * Constructor por defecto que inicializa los objetos con nuevas instancias.
     */
    public ControladorAgVehiculo() {
        this.frmP = new IfrmAgVehiculo();
        this.objR = new Recaudo();
        this.tbmV = new DefaultTableModel();
        this.objV = null;
    }

    /**
     * Actualiza los atributos del controlador con los nuevos valores.
     * @param frm La ventana interna.
     * @param atributos Un array de objetos que contiene Recaudo, TableModel de vehículos y un objeto Vehiculo.
     */
    @Override
    public void actualizarAtributos(JInternalFrame frm, Object... atributos) {
        frmP = (IfrmAgVehiculo) frm;
        objR = (Recaudo) atributos[0];
        tbmV = (DefaultTableModel) atributos[1];
        objV = (Vehiculo) atributos[2];
    }

    /**
     * Inicia el controlador, configurando la ventana de registro de vehículos.
     */
    @Override
    public void iniciar() {
        frmP.setTitle("Registro Vehiculos");
        frmP.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        inicializarActList(frmP);

        frmP.getTblDatosVehiculo().setModel(tbmV);
        if (tbmV.getRowCount() <= 0){
            frmP.getBtnRegistrar().setEnabled(false);
            frmP.getBtnCambiarVehiculo().setEnabled(false);
        }

        frmP.setVisible(true);
    }

    /**
     * Maneja las acciones de los botones y el JComboBox en la interfaz de agregar vehículo.
     * @param e El evento de acción.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(frmP.getCmbVehiculo())) {
            frmP.getBtnRegistrar().setEnabled(true);
            switch (frmP.getCmbVehiculo().getSelectedIndex()) {
                case 0 -> frmP.getBtnRegistrar().setEnabled(false);
                case 1 -> {
                    frmP.getTxtCanPas().setEditable(true);
                    frmP.getTxtCanPas().setVisible(true);
                    frmP.getLblCantPas().setVisible(true);
                    objV = (new Auto());
                }
                case 2 -> {
                    frmP.getTxtCanPas().setEditable(false);
                    frmP.getTxtCanPas().setVisible(false);
                    frmP.getLblCantPas().setVisible(false);
                    frmP.getTxtCanPas().setText("2");
                    objV = (new Moto());
                }
            }
        }

        if (e.getSource().equals(frmP.getBtnRegistrar())) {
            String msg = "";
            try {
                if (objV instanceof Auto)
                    ((Auto) objV).setCantPasajeros(Integer.parseInt(frmP.getTxtCanPas().getText()));
                objV.setPlaca(frmP.getTxtPlaca().getText());
                objV.setModelo(Integer.parseInt(frmP.getTxtModelo().getText()));
                objV.setMarca(frmP.getTxtMarca().getText());
                objV.setValor(Double.parseDouble(frmP.getTxtValor().getText()));
                objV.setCombustible(frmP.getTxtCombustible().getText());
                objV.setCilindraje(Integer.parseInt(frmP.getTxtCilindraje().getText()));
                objV.setUso(frmP.getTxtUso().getText());
                objV.setLinea(frmP.getTxtLinea().getText());
                objV.setGrupo(frmP.getTxtGrupo().getText());
                objV.setCapacidad(Integer.parseInt(frmP.getTxtCapacidad().getText()));

                objR.getFormularios().getLast().setVehiculo(objV);

                limpiarDatos(frmP);

                agregarInformacionTabla(objV, tbmV);
                frmP.getBtnCambiarVehiculo().setEnabled(true);

                msg = "Datos Registrados: " + objV.toString() + "\nImpuesto: " + String.format("%.2f", objV.getImpuesto());
            } catch (NumberFormatException ex) {
                msg = "Error, el dato ingresado " + ex.getMessage().split(":")[1] + " no es valido.";
            } finally {
                JOptionPane.showMessageDialog(frmP, msg, "Registro Vehiculo", JOptionPane.INFORMATION_MESSAGE);
                super.msgAviso.setText(msg);
            }
        }

        if (e.getSource().equals(frmP.getBtnCambiarVehiculo())) {
            if (tbmV.getRowCount() > 0){
                limpiarDatos(frmP);
                objV = objR.getFormularios().getLast().getVehiculo();
                frmP.getTxtPlaca().setText(objV.getPlaca());
                frmP.getTxtModelo().setText(String.valueOf(objV.getModelo()));
                frmP.getTxtMarca().setText(objV.getMarca());
                frmP.getTxtValor().setText(String.valueOf(objV.getValor()));
                frmP.getTxtCilindraje().setText(String.valueOf(objV.getCilindraje()));
                frmP.getTxtCombustible().setText(objV.getCombustible());
                frmP.getTxtUso().setText(objV.getUso());
                frmP.getTxtLinea().setText(objV.getLinea());
                frmP.getTxtGrupo().setText(objV.getGrupo());
                frmP.getTxtCapacidad().setText(String.valueOf(objV.getCapacidad()));

                if (objV instanceof Auto) {
                    frmP.getTxtCanPas().setText(String.valueOf(((Auto) objV).getCantPasajeros()));
                    frmP.getCmbVehiculo().setSelectedIndex(1);
                } else {
                    frmP.getCmbVehiculo().setSelectedIndex(2);
                }
                frmP.getBtnCambiarVehiculo().setEnabled(false);
            }
        }
    }
}