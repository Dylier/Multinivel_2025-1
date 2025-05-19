package modelo;

import java.time.Instant;
import java.util.Date;

/**
 *
 * @author Dyl
 */
public class Contribuyente {
    private String nombre;
    private String tipoDocumento;
    private int documento;
    private String correo;
    private Date fecNac;
    private String calidad;
    private String direccion;
    private String municipio;
    private double porcPropiedad;

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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFecNac() {
        return fecNac;
    }

    public void setFecNac(Date fecNac) {
        this.fecNac = fecNac;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getCalidad() {
        return calidad;
    }

    public void setCalidad(String calidad) {
        this.calidad = calidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public double getPorcPropiedad() {
        return porcPropiedad;
    }

    public void setPorcPropiedad(double porcPropiedad) {
        this.porcPropiedad = porcPropiedad;
    }
    
    

    public int getEdad(){
        return fecNac.getMonth() < Date.from(Instant.now()).getMonth() ? 
                fecNac.getYear()-Date.from(Instant.now()).getYear() : 
                fecNac.getYear()-Date.from(Instant.now()).getYear() - 1;
    }

    @Override
    public String toString() {
        return "nombre: " + nombre + "\n"
                + "correo: " + correo + "\n"
                + "fecha nacimiento: " + fecNac + "\n"
                + "cedula: " + documento + "\n"
                + "edad: " + getEdad();
    }
}
