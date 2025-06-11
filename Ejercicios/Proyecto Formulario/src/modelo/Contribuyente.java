package modelo;

import java.time.Instant;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

/**
 * Representa un contribuyente con sus datos personales y de propiedad.
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
     * Crea un contribuyente con todos sus datos.
     * @param nombre El nombre completo del contribuyente.
     * @param tipoDocumento El tipo de documento de identificación.
     * @param documento El número de documento de identificación.
     * @param correo La dirección de correo electrónico del contribuyente.
     * @param fecNac La fecha de nacimiento del contribuyente.
     * @param calidad La calidad o rol del contribuyente.
     * @param direccion La dirección de residencia del contribuyente.
     * @param municipio El municipio de residencia del contribuyente.
     * @param porcPropiedad El porcentaje de propiedad que posee el contribuyente.
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
     * Crea un contribuyente con valores predeterminados.
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
     * Obtiene el nombre del contribuyente.
     * @return El nombre del contribuyente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del contribuyente.
     * @param nombre El nuevo nombre del contribuyente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el correo del contribuyente.
     * @return La dirección de correo electrónico del contribuyente.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo del contribuyente.
     * @param correo La nueva dirección de correo electrónico.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene la fecha de nacimiento.
     * @return La fecha de nacimiento del contribuyente.
     */
    public Date getFecNac() {
        return fecNac;
    }

    /**
     * Establece la fecha de nacimiento.
     * @param fecNac La nueva fecha de nacimiento.
     */
    public void setFecNac(Date fecNac) {
        this.fecNac = fecNac;
    }

    /**
     * Obtiene el tipo de documento.
     * @return El tipo de documento de identificación.
     */
    public String getTipoDocumento() {
        return tipoDocumento;
    }

    /**
     * Establece el tipo de documento.
     * @param tipoDocumento El nuevo tipo de documento.
     */
    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    /**
     * Obtiene el numero de documento.
     * @return El número de documento de identificación.
     */
    public int getDocumento() {
        return documento;
    }

    /**
     * Establece el numero de documento.
     * @param documento El nuevo número de documento.
     */
    public void setDocumento(int documento) {
        this.documento = documento;
    }

    /**
     * Obtiene la calidad del contribuyente.
     * @return La calidad o rol del contribuyente.
     */
    public String getCalidad() {
        return calidad;
    }

    /**
     * Establece la calidad del contribuyente.
     * @param calidad La nueva calidad del contribuyente.
     */
    public void setCalidad(String calidad) {
        this.calidad = calidad;
    }

    /**
     * Obtiene la direccion del contribuyente.
     * @return La dirección de residencia del contribuyente.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la direccion del contribuyente.
     * @param direccion La nueva dirección de residencia.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Obtiene el municipio del contribuyente.
     * @return El municipio de residencia del contribuyente.
     */
    public String getMunicipio() {
        return municipio;
    }

    /**
     * Establece el municipio del contribuyente.
     * @param municipio El nuevo municipio de residencia.
     */
    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    /**
     * Obtiene el porcentaje de propiedad.
     * @return El porcentaje de propiedad que posee el contribuyente.
     */
    public double getPorcPropiedad() {
        return porcPropiedad;
    }

    /**
     * Establece el porcentaje de propiedad.
     * @param porcPropiedad El nuevo porcentaje de propiedad.
     */
    public void setPorcPropiedad(double porcPropiedad) {
        this.porcPropiedad = porcPropiedad;
    }

    /**
     * Calcula la edad del contribuyente.
     * @return La edad del contribuyente en años. Si la fecha de nacimiento es nula, retorna 0.
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
     * Devuelve los datos del contribuyente en un arreglo de objetos.
     * @return Un arreglo de objetos que contiene los datos del contribuyente.
     */
    @Override
    public Object[] getArregloDatos() {
        return new Object[]{
            getNombre(),
            getTipoDocumento(),
            getDocumento(),
            getCorreo(),
            getEdad(),
            getCalidad(),
            getDireccion(),
            getMunicipio(),
            getPorcPropiedad()
        };
    }

    /**
     * Devuelve una representación en texto de los detalles del contribuyente.
     * @return Un String con los detalles del contribuyente.
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