package modelo;

import java.util.ArrayList;

/**
 *
 * @author estudiante
 */
public class Circulo extends Figura{

    public Circulo(ArrayList<Punto> Puntos) {
        super(Puntos);
    }

    public Circulo() {
        super();
    }

    public double radio(){
        return Math.abs(puntos.get(1).getX() - puntos.get(0).getX())/2;
    }
    
    @Override
    public double Area() {
        return Math.PI*Math.pow(radio(),2);
        // return Math.PI*(radio()^2);
        // return Math.PI*(radio()**2);
    }
}
