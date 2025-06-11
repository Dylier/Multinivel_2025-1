package modelo;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dyl
 */
public class Formulario {
    private int id;
    private Vehiculo vehiculo;
    private ArrayList<Contribuyente> contribuyentes;
    private Date fechaOportuna;
    private Date fechaLimite;
    private Double descuentoAdd;
    
    private static final SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");

    /**
     *
     * @param id
     * @param vehiculo
     * @param contribuyentes
     * @param fechaOportuna
     * @param fechaLimite
     * @param descuentoAdd
     */
    public Formulario(int id, Vehiculo vehiculo, ArrayList<Contribuyente> contribuyentes, Date fechaOportuna, Date fechaLimite, Double descuentoAdd) {
        this.id = id;
        this.vehiculo = vehiculo;
        this.contribuyentes = contribuyentes;
        this.fechaOportuna = fechaOportuna;
        this.fechaLimite = fechaLimite;
        this.descuentoAdd = descuentoAdd;
    }
    
    /**
     *
     */
    public Formulario() {
        this.vehiculo = null;
        this.contribuyentes = new ArrayList<>();
        this.fechaOportuna = Date.from(Instant.now());
        this.fechaLimite = Date.from(Instant.now());
        this.descuentoAdd = 0.0;
    }

    /**
     *
     * @return
     */
    public Double getDescuentoAdd() {
        return descuentoAdd;
    }

    /**
     *
     * @param descuentoAdd
     */
    public void setDescuentoAdd(Double descuentoAdd) {
        this.descuentoAdd = descuentoAdd;
    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    /**
     *
     * @param vehiculo
     */
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    /**
     *
     * @return
     */
    public ArrayList<Contribuyente> getContribuyentes() {
        return contribuyentes;
    }

    /**
     *
     * @param contribuyentes
     */
    public void setContribuyentes(ArrayList<Contribuyente> contribuyentes) {
        this.contribuyentes = contribuyentes;
    }

    /**
     *
     * @return
     */
    public Date getFechaOportuna() {
        return fechaOportuna;
    }

    /**
     *
     * @param fechaOportuna
     */
    public void setFechaOportuna(Date fechaOportuna) {
        this.fechaOportuna = fechaOportuna;
    }

    /**
     *
     * @return
     */
    public Date getFechaLimite() {
        return fechaLimite;
    }

    /**
     *
     * @param fechaLimite
     */
    public void setFechaLimite(Date fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    /**
     *
     * @return
     */
    public double getDescuentoProntoPago(){
        return 0.10 * (vehiculo.getImpuesto() + vehiculo.getValor());
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Object[]> getDatosContribuyentes() {
        if (contribuyentes == null || contribuyentes.isEmpty()) {
            return new ArrayList<>(); 
        }
        ArrayList<Object[]> datos = new ArrayList<>();
        for (int i = 0; i < contribuyentes.size(); i++) {
            datos.add(contribuyentes.get(i).getArregloDatos());
        }
        return datos;
    }

    /**
     *
     * @return
     */
    public double getValorSemaforizacion(){
        if (vehiculo instanceof Auto)
            return ((Auto)vehiculo).getCantPasajeros() > 5 ? 20000: 5000;
        else
            return 2000;
    }
    
    /**
     *
     * @return
     */
    public double getTotal(){
        return vehiculo.getValor() + vehiculo.getImpuesto();
    }
    
    /**
     *
     * @return
     */
    public double getPagoVoluntario(){
        return 0.10 * (vehiculo.getValor() + vehiculo.getImpuesto());
    }
    
    /**
     *
     * @return
     */
    public double getDescuentoCombustible(){
        return 0.0;
    }
    
    JTable getDatosLiquidacion() {
        DefaultTableModel tbm = new DefaultTableModel();
        String[] columnas = new String[] {"Nombre", "Iniciales", "Valor Pago Oportuno", "Valor Pago Tardio"};
        for (String columna: columnas) tbm.addColumn(columna);
        tbm.addRow(new Object[] {"16. AVALUO COMERCIAL", "W", vehiculo.getValor() , vehiculo.getValor()});
        tbm.addRow(new Object[] {"17. AVALUO COMERCIAL", "IV", String.format("%.2f", vehiculo.getImpuesto()), String.format("%.2f", vehiculo.getImpuesto())});
        return new JTable(tbm);
    }

    JTable getDatosPago() {
        DefaultTableModel tbm = new DefaultTableModel();
        String[] columnas = new String[] {"Nombre", "Iniciales", "Valor Pago Oportuno", "Valor Pago Tardio"};
        for (String columna: columnas) tbm.addColumn(columna);
        tbm.addRow(new Object[] {"18. VALOR A PAGAR", "VP", String.format("%.2f", vehiculo.getImpuesto()), String.format("%.2f", vehiculo.getImpuesto())});
        tbm.addRow(new Object[] {"19. VALOR SEMAFORIZACION", "IV", getValorSemaforizacion(), getValorSemaforizacion()});
        tbm.addRow(new Object[] {"20. DESCUENTO COMBUSTIBLE", "IS", getDescuentoCombustible(), getDescuentoCombustible()});
        tbm.addRow(new Object[] {"21. DESCUENTO ADICIONAL", "DA", getDescuentoAdd(), getDescuentoAdd()});
        tbm.addRow(new Object[] {"22. DESCUENTO COMBUSTIBLE", "TD", getDescuentoProntoPago(), 0});
        tbm.addRow(new Object[] {"23. DESCUENTO COMBUSTIBLE", "TP", getTotal() - getDescuentoProntoPago(), getTotal()});        
        return new JTable(tbm);
    }

    JTable getDatosPagoVoluntario() {
        DefaultTableModel tbm = new DefaultTableModel();
        String[] columnas = new String[] {"Nombre", "Iniciales", "Valor Pago Oportuno", "Valor Pago Tardio"};
        for (String columna: columnas) tbm.addColumn(columna);
        tbm.addRow(new Object[] {"24. PAGO VOLUNTARIO", "AV", getPagoVoluntario(), getPagoVoluntario()});
        tbm.addRow(new Object[] {"25. VALOR SEMAFORIZACION", "TA", getTotal() - getDescuentoProntoPago() + getPagoVoluntario(), getTotal() + getPagoVoluntario()});
        return new JTable(tbm);
    }

    JTable getTableContribuyentes() {
        DefaultTableModel tbm = new DefaultTableModel();
        String[] columnas = new String[]  {"8. TIPO", "9.No.IDENTIFICACION", "10.NOMBRES Y APELLIDOS/RAZON SOCIAL", "11. % PROP", "12. CALIDAD", "13. DIRECCION DE NOTIFICACION", "14. MUNICIPIO"};
        for (String columna: columnas) tbm.addColumn(columna);
        for (Contribuyente objC: contribuyentes)
            tbm.addRow(new Object[] {objC.getTipoDocumento(), objC.getDocumento(), objC.getNombre(), objC.getPorcPropiedad(), objC.getCalidad(), objC.getDireccion(), objC.getMunicipio()});
        return new JTable(tbm);
    }

    JTable getDatosFecha() {
        DefaultTableModel tbm = new DefaultTableModel();
        String[] columnas = new String[]  {"Nombre", "", "Hasta Temprano", "Hasta Tardio"};
        for (String columna: columnas) tbm.addColumn(columna);
        tbm.addRow(new Object[] {"FECHA LIMITE DE PAGO", "", "HASTA" + formatoFecha.format(fechaOportuna), "HASTA" + formatoFecha.format(fechaLimite)});
        return new JTable(tbm);   
    }
    
    Object[] getDatosVehiculo(){
        return new Object[] {"1. PLACA " + vehiculo.getPlaca(), "2. MARCA " + vehiculo.getMarca(), "3. LINEA " + "SPARK", "4. MODELO " + vehiculo.getModelo(), "5. CAPACIDAD " + "1300", "6. USO " + "Particular", "7. GRUPO " + "---"};
    }
}
