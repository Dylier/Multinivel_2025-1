package modelo;

import java.util.ArrayList;

/**
 *
 * @author Dylier
 */
public abstract class Figura {
    protected ArrayList<Punto> puntos;

    public Figura(ArrayList<Punto> Puntos) {
        this.puntos = Puntos;
    }
    
    public Figura() {
        this.puntos = new ArrayList<Punto>();
    }

    public ArrayList<Punto> getPuntos() {
        return puntos;
    }

    public void setPuntos(ArrayList<Punto> Puntos) {
        this.puntos = Puntos;
    }
    
    public abstract double Area();
    
    public String datosPuntos(){
        String aux = "";
        for (Punto punto : puntos) {
            aux += punto.toString() + "\n";
        }
        return aux;
    }
    
    @Override
    public String toString() {
        return "Puntos de la Figura\n"+ datosPuntos();
    }
}
