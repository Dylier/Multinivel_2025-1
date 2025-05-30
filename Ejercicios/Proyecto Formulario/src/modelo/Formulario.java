package modelo;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Dyl
 */
public class Formulario {
    private int id;
    private Vehiculo vehiculo;
    private ArrayList<Contribuyente> contribuyentes;
    private Calendar fechaOportuna;
    private Calendar fechaLimite;

    public Formulario(int id, Vehiculo vehiculo, ArrayList<Contribuyente> contribuyentes, Calendar fechaOportuna, Calendar fechaLimite) {
        this.id = id;
        this.vehiculo = vehiculo;
        this.contribuyentes = contribuyentes;
        this.fechaOportuna = fechaOportuna;
        this.fechaLimite = fechaLimite;
    }
    
    public Formulario() {
        this.vehiculo = null;
        this.contribuyentes = new ArrayList<>();
        this.fechaOportuna = Calendar.getInstance();
        this.fechaLimite = Calendar.getInstance();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public ArrayList<Contribuyente> getContribuyentes() {
        return contribuyentes;
    }

    public void setContribuyentes(ArrayList<Contribuyente> contribuyentes) {
        this.contribuyentes = contribuyentes;
    }

    public Calendar getFechaOportuna() {
        return fechaOportuna;
    }

    public void setFechaOportuna(Calendar fechaOportuna) {
        this.fechaOportuna = fechaOportuna;
    }

    public Calendar getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(Calendar fechaLimite) {
        this.fechaLimite = fechaLimite;
    }
    
    
}
