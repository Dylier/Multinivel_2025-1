package modelo;

import java.util.ArrayList;

/**
 *
 * @author Dylier
 */
public class Rectangulo extends Figura{

    public Rectangulo(ArrayList<Punto> Puntos) {
        super(Puntos);
    }

    public Rectangulo() {
        super();
    }
    
    public int base(){
        return Math.abs(puntos.get(1).getX() - puntos.get(0).getX());
    }
    
    public int altura(){
        return Math.abs(puntos.get(0).getY() - puntos.get(1).getY());
    }
    
    @Override
    public double Area() {
        return base()*altura();
    }
}
