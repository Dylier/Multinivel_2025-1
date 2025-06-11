package modelo;

import java.time.Instant;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar; // Keep this import as Calendar is used for age calculation

/**
 *
 * @author Dyl
 */
public class Contribuyente implements ArregloDatos{
    private String nombre;
    private String tipoDocumento;
    private int documento;
    private String correo;
    private Date fecNac;
    private String calidad;
    private String direccion;
    private String municipio;
    private double porcPropiedad;
    
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    /**
     *
     * @param nombre
     * @param tipoDocumento
     * @param documento
     * @param correo
     * @param fecNac
     * @param calidad
     * @param direccion
     * @param municipio
     * @param porcPropiedad
     */
    public Contribuyente(String nombre, String tipoDocumento, int documento, String correo, Date fecNac, String calidad, String direccion, String municipio, double porcPropiedad) {
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
        this.correo = correo;
        this.fecNac = fecNac;
        this.calidad = calidad;
        this.direccion = direccion;
        this.municipio = municipio;
        this.porcPropiedad = porcPropiedad;
    }
    
    /**
     *
     */
    public Contribuyente() {
        this.nombre = "";
        this.tipoDocumento = "";
        this.documento = 0;
        this.correo = "";
        this.fecNac = Date.from(Instant.now());
        this.calidad = "";
        this.direccion = "";
        this.municipio = "";
        this.porcPropiedad = 0.0;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public String getCorreo() {
        return correo;
    }

    /**
     *
     * @param correo
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     *
     * @return
     */
    public Date getFecNac() {
        return fecNac;
    }

    /**
     *
     * @param fecNac
     */
    public void setFecNac(Date fecNac) {
        this.fecNac = fecNac;
    }

    /**
     *
     * @return
     */
    public String getTipoDocumento() {
        return tipoDocumento;
    }

    /**
     *
     * @param tipoDocumento
     */
    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    /**
     *
     * @return
     */
    public int getDocumento() {
        return documento;
    }

    /**
     *
     * @param documento
     */
    public void setDocumento(int documento) {
        this.documento = documento;
    }

    /**
     *
     * @return
     */
    public String getCalidad() {
        return calidad;
    }

    /**
     *
     * @param calidad
     */
    public void setCalidad(String calidad) {
        this.calidad = calidad;
    }

    /**
     *
     * @return
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     *
     * @param direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     *
     * @return
     */
    public String getMunicipio() {
        return municipio;
    }

    /**
     *
     * @param municipio
     */
    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    /**
     *
     * @return
     */
    public double getPorcPropiedad() {
        return porcPropiedad;
    }

    /**
     *
     * @param porcPropiedad
     */
    public void setPorcPropiedad(double porcPropiedad) {
        this.porcPropiedad = porcPropiedad;
    }
    
    /**
     *
     * @return
     */
    public int getEdad() {
        if (fecNac == null) {
            return 0; 
        }
        Calendar dob = Calendar.getInstance();
        dob.setTime(fecNac);
        Calendar today = Calendar.getInstance();

        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }
        return age;
    }

    /**
     *
     * @return
     */
    @Override
    public Object[] getArregloDatos() {
        return new Object[]{
            getNombre(),
            getTipoDocumento(),
            getDocumento(),
            getCorreo(),
            fecNac != null ? dateFormat.format(getFecNac()) : "", 
            getCalidad(),
            getDireccion(),
            getMunicipio(),
            getPorcPropiedad()
        };
    }
    
    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "nombre: " + nombre + "\n"
                + "correo: " + correo + "\n"
                + "fecha nacimiento: " + (fecNac != null ? dateFormat.format(fecNac) : "N/A") + "\n" 
                + "documento: " + documento + "\n"
                + "edad: " + getEdad();
    }
}