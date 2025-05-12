package modelo;

import java.time.Instant;
import java.util.Date;

/**
 *
 * @author Dyl
 */
public class Propietario {
    private String nombre;
    private String correo;
    private Date fecNac;
    private int cedula;

    public Propietario(String nombre, String correo, Date fecNac, int cedula) {
        this.nombre = nombre;
        this.correo = correo;
        this.fecNac = fecNac;
        this.cedula = cedula;
    }

    public Propietario() {
        this.nombre = "";
        this.correo = "";
        this.fecNac = Date.from(Instant.now());
        this.cedula = 0;
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

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
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
                + "cedula: " + cedula + "\n"
                + "edad: " + getEdad();
    }
}
