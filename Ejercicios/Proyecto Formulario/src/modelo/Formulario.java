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
     * Crea un formulario con detalles completos
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
     * Crea un formulario con valores iniciales
     */
    public Formulario() {
        this.vehiculo = null;
        this.contribuyentes = new ArrayList<>();
        this.fechaOportuna = Date.from(Instant.now());
        this.fechaLimite = Date.from(Instant.now());
        this.descuentoAdd = 0.0;
    }

    /**
     * Obtiene el descuento adicional
     * @return Double
     */
    public Double getDescuentoAdd() {
        return descuentoAdd;
    }

    /**
     * Establece el descuento adicional
     * @param descuentoAdd
     */
    public void setDescuentoAdd(Double descuentoAdd) {
        this.descuentoAdd = descuentoAdd;
    }

    /**
     * Obtiene el ID del formulario
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID del formulario
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el vehiculo asociado
     * @return Vehiculo
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    /**
     * Establece el vehiculo asociado
     * @param vehiculo
     */
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    /**
     * Obtiene la lista de contribuyentes
     * @return ArrayList<Contribuyente>
     */
    public ArrayList<Contribuyente> getContribuyentes() {
        return contribuyentes;
    }

    /**
     * Establece la lista de contribuyentes
     * @param contribuyentes
     */
    public void setContribuyentes(ArrayList<Contribuyente> contribuyentes) {
        this.contribuyentes = contribuyentes;
    }

    /**
     * Obtiene la fecha de pago oportuno
     * @return Date
     */
    public Date getFechaOportuna() {
        return fechaOportuna;
    }

    /**
     * Establece la fecha de pago oportuno
     * @param fechaOportuna
     */
    public void setFechaOportuna(Date fechaOportuna) {
        this.fechaOportuna = fechaOportuna;
    }

    /**
     * Obtiene la fecha limite de pago
     * @return Date
     */
    public Date getFechaLimite() {
        return fechaLimite;
    }

    /**
     * Establece la fecha limite de pago
     * @param fechaLimite
     */
    public void setFechaLimite(Date fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    /**
     * Calcula el descuento por pronto pago
     * @return double
     */
    public double getDescuentoProntoPago(){
        return 0.10 * (vehiculo.getImpuesto() + vehiculo.getValor());
    }

    /**
     * Obtiene los datos de los contribuyentes
     * @return ArrayList<Object[]>
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
     * Calcula el valor de semaforizacion
     * @return double
     */
    public double getValorSemaforizacion(){
        if (vehiculo instanceof Auto)
            return ((Auto)vehiculo).getCantPasajeros() > 5 ? 20000: 5000;
        else
            return 2000;
    }

    /**
     * Calcula el total a pagar
     * @return double
     */
    public double getTotal(){
        return vehiculo.getValor() + vehiculo.getImpuesto();
    }

    /**
     * Calcula el pago voluntario
     * @return double
     */
    public double getPagoVoluntario(){
        return 0.10 * (vehiculo.getValor() + vehiculo.getImpuesto());
    }

    /**
     * Calcula el descuento por combustible
     * @return double
     */
    public double getDescuentoCombustible(){
        if ("EcoDiesel".equals(vehiculo.getCombustible())){
            return 100000;
        }else
            return 0;
    }

    /**
     * Obtiene tabla con datos de liquidacion
     * @return JTable
     */
    JTable getDatosLiquidacion() {
        DefaultTableModel tbm = new DefaultTableModel();
        String[] columnas = new String[] {"Nombre", "Iniciales", "Valor Pago Oportuno", "Valor Pago Tardio"};
        for (String columna: columnas) tbm.addColumn(columna);
        tbm.addRow(new Object[] {"16. AVALUO COMERCIAL", "W", vehiculo.getValor() , vehiculo.getValor()});
        tbm.addRow(new Object[] {"17. AVALUO COMERCIAL", "IV", String.format("%.2f", vehiculo.getImpuesto()), String.format("%.2f", vehiculo.getImpuesto())});
        return new JTable(tbm);
    }

    /**
     * Obtiene tabla con datos de pago
     * @return JTable
     */
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

    /**
     * Obtiene tabla de pago voluntario
     * @return JTable
     */
    JTable getDatosPagoVoluntario() {
        DefaultTableModel tbm = new DefaultTableModel();
        String[] columnas = new String[] {"Nombre", "Iniciales", "Valor Pago Oportuno", "Valor Pago Tardio"};
        for (String columna: columnas) tbm.addColumn(columna);
        tbm.addRow(new Object[] {"24. PAGO VOLUNTARIO", "AV", getPagoVoluntario(), getPagoVoluntario()});
        tbm.addRow(new Object[] {"25. VALOR SEMAFORIZACION", "TA", getTotal() - getDescuentoProntoPago() + getPagoVoluntario(), getTotal() + getPagoVoluntario()});
        return new JTable(tbm);
    }

    /**
     * Obtiene tabla con datos de contribuyentes
     * @return JTable
     */
    JTable getTableContribuyentes() {
        DefaultTableModel tbm = new DefaultTableModel();
        String[] columnas = new String[]  {"8. TIPO", "9.No.IDENTIFICACION", "10.NOMBRES Y APELLIDOS/RAZON SOCIAL", "11. % PROP", "12. CALIDAD", "13. DIRECCION DE NOTIFICACION", "14. MUNICIPIO"};
        for (String columna: columnas) tbm.addColumn(columna);
        for (Contribuyente objC: contribuyentes)
            tbm.addRow(new Object[] {objC.getTipoDocumento(), objC.getDocumento(), objC.getNombre(), objC.getPorcPropiedad(), objC.getCalidad(), objC.getDireccion(), objC.getMunicipio()});
        return new JTable(tbm);
    }

    /**
     * Obtiene tabla con datos de fechas
     * @return JTable
     */
    JTable getDatosFecha() {
        DefaultTableModel tbm = new DefaultTableModel();
        String[] columnas = new String[]  {"Nombre", "", "Hasta Temprano", "Hasta Tardio"};
        for (String columna: columnas) tbm.addColumn(columna);
        tbm.addRow(new Object[] {"FECHA LIMITE DE PAGO", "", "HASTA" + formatoFecha.format(fechaOportuna), "HASTA" + formatoFecha.format(fechaLimite)});
        return new JTable(tbm);
    }

    /**
     * Obtiene datos principales del vehiculo
     * @return Object[]
     */
    Object[] getDatosVehiculo(){
        return new Object[] {"1. PLACA " + vehiculo.getPlaca(), "2. MARCA " + vehiculo.getMarca(), "3. LINEA " + vehiculo.getLinea(), "4. MODELO " + vehiculo.getModelo(), "5. CAPACIDAD " + vehiculo.getCapacidad(), "6. USO " + vehiculo.getUso(), "7. GRUPO " + vehiculo.getGrupo()};
    }
}