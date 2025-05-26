package control;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Auto;
import modelo.Contribuyente;
import modelo.Formulario;
import modelo.Moto;
import modelo.Recaudo;
import modelo.Vehiculo;
import vista.FrmRegistro;

/**
 *
 * @author Dyl
 */
public class ControladorGUI implements ActionListener {
    FrmRegistro frmR;
    Recaudo objR;
    Formulario objF;
    Vehiculo objV;
    int id_form;
    ArrayList<Contribuyente> listaC;

    public ControladorGUI(FrmRegistro frmR, Recaudo objR, Formulario objF, Vehiculo objV, ArrayList<Contribuyente> listaC) {
        this.frmR = frmR;
        this.objR = objR;
        this.objF = objF;
        this.objV = objV;
        this.listaC = listaC;
    }
    
    public ControladorGUI() {
        this.frmR = new FrmRegistro();
        this.objR = new Recaudo();
        this.objF = new Formulario();
        this.objV = null;
        this.listaC = new ArrayList<>();
    }


    public void iniciar() {
        frmR.setTitle("Registro Vehiculos");
        frmR.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmR.setLocationRelativeTo(null);
        // ActionListener
        frmR.getBtnRegistrar().addActionListener(this);
        frmR.getBtnRecaudo().addActionListener(this);
        frmR.getCmbVehiculo().addActionListener(this);
        frmR.getBtnRegistrarProp().addActionListener(this);
        frmR.getBtnAnadirFormulario().addActionListener(this);
        frmR.getBtnBuscar().addActionListener(this);
        frmR.getBtnCambiarVehiculo().addActionListener(this);
        frmR.getCmbNFormulario().addActionListener(this);
        // Editable
        frmR.getTxtCanPas().setEditable(true);
        frmR.getTxtRecaudo().setEditable(false);
        // Enable
        frmR.getBtnRegistrar().setEnabled(false);
        frmR.getBtnRecaudo().setEnabled(false);
        frmR.getCmbNFormulario().setEnabled(false);
        frmR.getTbAvisos().setVisible(false);
        frmR.setVisible(true);
    }
    
    public void limpiarDatos(Container Comp){
        for(Component c: Comp.getComponents()){
            if (c instanceof JTextField){
                ((JTextField) c).setText("");
            } else if (c instanceof JTable){
                DefaultTableModel plantilla = (DefaultTableModel) ((JTable)c).getModel();
                plantilla.setRowCount(0);                
            } else if (c instanceof JComboBox){
                ((JComboBox) c).setSelectedIndex(0);
            } else if (c instanceof Container){
                limpiarDatos((Container) c);
            } 
        }
    }
    
    public void limpiarDatos(JTable objJT){
        DefaultTableModel plantilla = (DefaultTableModel) objJT.getModel();
        plantilla.setRowCount(0); 
    }
    
    private void agregarInformacionTabla(Object[] datos, List<JTable> tablas){
        for (JTable tabla : tablas) {
            DefaultTableModel plantilla = (DefaultTableModel) tabla.getModel();
            plantilla.addRow(datos);
        }
    }
    
    private boolean informacionCompleta(Container Comp){
        boolean infoComp = true;
        for(Component c: Comp.getComponents()){
            if (c instanceof JTextField) infoComp = !((JTextField) c).getText().isEmpty();
            else if (c instanceof Container) infoComp = informacionCompleta((Container) c);            
            if (!infoComp) {
                frmR.getTbAvisos().setVisible(true);
                frmR.getLbAvisos().setText(c.getName() != null ?  "Falta completar el campo " + c.getName(): "Faltan por completar campos obligatorios");
                break;
            } else {
                frmR.getTbAvisos().setVisible(false);
            }
        }
        return infoComp;        
    }
    
    public void agregarContriyenteTabla(List<JTable> tablas) {
        for (Contribuyente c: listaC) {
            Object[] datos = {
                c.getNombre(),
                c.getTipoDocumento(),
                c.getDocumento(),
                c.getCorreo(),
                c.getFecNac(),
                c.getCalidad(),
                c.getDireccion(),
                c.getMunicipio(),
                c.getPorcPropiedad()
            };
            agregarInformacionTabla(datos, tablas);
        }
    }   

    public void agregarContriyenteTabla(ArrayList<Contribuyente> contribuyente, List<JTable> tablas) {
        for (Contribuyente c: contribuyente) {
            Object[] datos = {
                c.getNombre(),
                c.getTipoDocumento(),
                c.getDocumento(),
                c.getCorreo(),
                c.getFecNac(),
                c.getCalidad(),
                c.getDireccion(),
                c.getMunicipio(),
                c.getPorcPropiedad()
            };
            agregarInformacionTabla(datos, tablas);
        }
    }   


    public void agregarVehiculoTabla(List<JTable> tablas) {
        Object[] datos;
        if (objV instanceof Auto) {
            datos = new Object[]{
                "Auto",
                objV.getPlaca(),
                objV.getMarca(),
                objV.getModelo(),
                objV.getCilindraje(), 
                ((Auto) objV).getCantPass(),
                objV.getValor(), 
                String.format("%.2f", objV.Impuesto())
            };
        } else {
            datos = new Object[]{
                "Moto",
                objV.getPlaca(),
                objV.getMarca(),
                objV.getModelo(),
                objV.getCilindraje(),
                "2",
                objV.getValor(),
                String.format("%.2f", objV.Impuesto())
            };
        }
        agregarInformacionTabla(datos, tablas);
    }

    public void agregarVehiculoTabla(Vehiculo vehiculo, List<JTable> tablas) {
        Object[] datos;
        if (vehiculo instanceof Auto) {
            datos = new Object[]{
                "Auto",
                vehiculo.getPlaca(),
                vehiculo.getMarca(),
                vehiculo.getModelo(),
                vehiculo.getCilindraje(), 
                ((Auto) vehiculo).getCantPass(),
                vehiculo.getValor(), 
                String.format("%.2f", vehiculo.Impuesto())
            };
        } else {
            datos = new Object[]{
                "Moto",
                vehiculo.getPlaca(),
                vehiculo.getMarca(),
                vehiculo.getModelo(),
                vehiculo.getCilindraje(),
                "2",
                vehiculo.getValor(),
                String.format("%.2f", vehiculo.Impuesto())
            };
        }
        agregarInformacionTabla(datos, tablas);
    }

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

    
    public Formulario buscarFormulario(int id){
        Formulario f = null;
        for (Formulario formulario : objR.getFormularios()) {
            if (id == (formulario.getId())){
                f = formulario;
                break;
            }
        }
        return f;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(frmR.getCmbVehiculo())) {
            frmR.getBtnRegistrar().setEnabled(true);
            frmR.getBtnRecaudo().setEnabled(true);
            switch (frmR.getCmbVehiculo().getSelectedIndex()) {
                case 0:
                    frmR.getBtnRegistrar().setEnabled(false);
                    break;
                case 1:
                    frmR.getTxtCanPas().setEditable(true);
                    //frmR.getTxtCanPas().setVisible(true);
                    //frmR.getLblCantPas().setVisible(true);
                    objV = new Auto();
                    break;
                case 2:
                    frmR.getTxtCanPas().setEditable(false);
                    //frmR.getTxtCanPas().setVisible(false);
                    //frmR.getLblCantPas().setVisible(false);
                    frmR.getTxtCanPas().setText("2");
                    objV = new Moto();
                    break;
            }
        }

        if (e.getSource().equals(frmR.getBtnRegistrar())) {
            if (informacionCompleta(frmR.getPnlVehiculo())){
                if (objV instanceof Auto)((Auto)objV).setCantPass(Integer.parseInt(frmR.getTxtCanPas().getText()));
                objV.setPlaca(frmR.getTxtPlaca().getText());
                objV.setModelo(Integer.parseInt(frmR.getTxtModelo().getText()));
                objV.setMarca(frmR.getTxtMarca().getText());
                objV.setValor(Double.parseDouble(frmR.getTxtValor().getText()));
                objV.setCilindraje(Integer.parseInt(frmR.getTxtCilindraje().getText()));
            

                limpiarDatos(frmR.getPnlVehiculo());
                limpiarDatos(frmR.getTblDatosVehiRecaudo());

                agregarVehiculoTabla(Arrays.asList(
                    frmR.getTblDatosVehiculo(),
                    frmR.getTblDatosVehiRecaudo()
                ));


                objF.setVehiculo(objV);

                bloquearDatos(frmR.getPnlVehiculo(), false);

                JOptionPane.showMessageDialog(frmR,
                        "Datos Registrados: " + objV.toString() + "\nImpuesto: " + String.format("%.2f", objV.Impuesto()),
                        "Registro.", JOptionPane.INFORMATION_MESSAGE);          
                }
            }

            if (e.getSource().equals(frmR.getBtnCambiarVehiculo())){
                objF.setVehiculo(null);
                objV = null;
                bloquearDatos(frmR.getPnlVehiculo(), true);
                limpiarDatos(frmR.getPnlVehiculo());
                limpiarDatos(frmR.getTblDatosVehiRecaudo());            
            }

            if (e.getSource().equals(frmR.getBtnRegistrarProp())){
                if (informacionCompleta(frmR.getPnlProp())){
                    Contribuyente objC = new Contribuyente();
                    objC.setNombre(frmR.getTxtNom().getText());
                    objC.setTipoDocumento((String) frmR.getCmbTipoDocu().getSelectedItem());
                    objC.setDocumento(Integer.parseInt(frmR.getTxtCedula().getText()));
                    objC.setCorreo(frmR.getTxtCorreo().getText());
                    objC.setFecNac(Date.from(Instant.now()));
                    objC.setCalidad(frmR.getTxtCalidad().getText());
                    objC.setDireccion(frmR.getTxtDireccion().getText());
                    objC.setMunicipio(frmR.getTxtMunicipio().getText());
                    objC.setPorcPropiedad(Double.parseDouble(frmR.getTxtPropiedad().getText()));

                    listaC.add(objC);

                    limpiarDatos(frmR.getPnlProp());
                    limpiarDatos(frmR.getTblDatosContRecaudo());

                    agregarContriyenteTabla(Arrays.asList(frmR.getTblDatosContibuyentes(), frmR.getTblDatosContRecaudo()));

                    objF.setContribuyentes(listaC);
                }
            }

            if (e.getSource().equals(frmR.getBtnBuscar())){             
                Formulario Form = buscarFormulario(frmR.getCmbNFormulario().getSelectedIndex());            
                if (Form != null){
                    limpiarDatos(frmR);
                    agregarVehiculoTabla(Form.getVehiculo(), Arrays.asList(frmR.getTblDatosVehiRecaudo()));
                    agregarContriyenteTabla(Form.getContribuyentes(), Arrays.asList(frmR.getTblDatosContRecaudo()));
                }

            }

            if (e.getSource().equals(frmR.getBtnAnadirFormulario())){
                if (objV != null && !listaC.isEmpty()){               
                    if (!objR.getFormularios().isEmpty()) {
                        objF.setId(objR.getFormularios().get(objR.getFormularios().size()-1).getId() + 1);
                    } else {
                        objF.setId(1);
                    }
                    objR.getFormularios().add(objF);
                    frmR.getCmbNFormulario().setEnabled(true);
                    
                    frmR.getCmbNFormulario().addItem(""+objF.getId());
                    limpiarDatos(frmR);
                    bloquearDatos(frmR, true);
                    objF = new Formulario();
                    objV = null;
                    listaC = new ArrayList<>();
                }                            
            }

            if (e.getSource().equals(frmR.getBtnRecaudo())) {
                frmR.getTxtRecaudo().setText(String.format("%.2f", objR.totalRecaudo()));
                JOptionPane.showMessageDialog(frmR,
                        "Vehiculos Registrados: " + objR.getFormularios().size() + "\nTotal Recaudo: " + String.format("%.2f", objR.totalRecaudo()),
                        "Registro.", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}

