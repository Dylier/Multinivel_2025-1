package modelo;


import java.util.ArrayList;
import modelo.Circulo;
import modelo.Figura;
import modelo.Rectangulo;

/**
 *
 * @author Dylier
 */
public class ListaFiguras {
    private ArrayList<Figura> ListaF;

    public ListaFiguras(ArrayList<Figura> Figuras) {
        this.ListaF = Figuras;
    }
    
    
    public ListaFiguras() {
        this.ListaF =  new ArrayList<>();
    }

    public String datosFiguras() {
        String aux = "";
        /* // Version de funcion con Else - If
        String tf = " ";
        for (Figura fig : ListaF) {
            if (fig instanceof Rectangulo){
                tf = "Rectangulo ";
            } else if (fig instanceof Circulo){
                tf = "Circulo ";
            }
            aux += tf + "\n" + fig.toString() + "\nArea: " + fig.Area() + "\n\n";
        }*/

        /*  // Version de funcion con operadores ternarios
        for (Figura fig : ListaF) {
            String tf = (fig instanceof Rectangulo) ? "Rectangulo" :
                (fig instanceof Circulo) ? "Circulo" :
                (fig instanceof Triangulo) ? "Triangulo" : "Figura no conocida";
        }*/

        /*// Version de funcion con switch simplificado
        for (Figura fig : ListaF) {
            String tf = switch(fig.getClass().getSimpleName()){
                case "Rectangulo" -> "Rectangulo";
                case "Circulo" -> "Circulo";
                case "Triangulo" -> "Triangulo";
                default -> "Figura no conocida";
            };
            aux += tf + "\n" + fig.toString() + "\nArea: " + String.format("%,.2f",fig.Area()) + "\n\n";
        }*/

        // Version directa sin estructuras
        for (Figura fig : ListaF) {
            aux += fig.getClass().getSimpleName() + "\n" + fig.toString() + "\nArea: " + String.format("%,.2f",fig.Area()) + "\n\n";
        }

        return aux;
    }
    
    public ArrayList<Figura> getListaF() {
        return ListaF;
    }

    public void setListaF(ArrayList<Figura> ListaF) {
        this.ListaF = ListaF;
    }

    @Override
    public String toString() {
        return "Lista de Figuras:\n" + datosFiguras();
    }

    
}
