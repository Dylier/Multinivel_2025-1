package control;

import modelo.ListaFiguras;
import java.util.ArrayList;
import modelo.Circulo;
import modelo.Punto;
import modelo.Rectangulo;
import modelo.Triangulo;
import vista.CajasMensaje;

/**
 *
 * @author Dylier
 */
public class Controlador {
    private CajasMensaje objE;
    private ListaFiguras objLF;

    // Constructores
    public Controlador(CajasMensaje objE, ListaFiguras objLF) {
        this.objE = objE;
        this.objLF = objLF;
    }

    public Controlador() {
        this.objE = new CajasMensaje();
        this.objLF = new ListaFiguras();
    }

    // Metodo para pedirle al ususario los puntos de las figuras
    private ArrayList<Punto> datosPuntos(int cantP){
        String[] coord;
        ArrayList<Punto> puntos = new ArrayList<>();
        for (int i = 0; i < cantP; i++){
            coord = objE.leerTexto("Ingrese punto " + (i+1) + " de forma x,y: ").split(",");
            puntos.add(new Punto(Integer.parseInt(coord[0]), Integer.parseInt(coord[1])));
        }
        return puntos;
    }

    // Metodo iniciar del controlador
    public void iniciar(){
        int opFig;
        do{
            opFig = objE.leerEntero("Figuras:\n1. Rectangulo\n2. Circulo\n3. Triangulo");
            switch (opFig){
                case 1:      
                    objLF.getListaF().add(new Rectangulo(datosPuntos(2)));
                    break;
                case 2:
                    objLF.getListaF().add(new Circulo(datosPuntos(2)));
                    break;
                case 3:
                    objLF.getListaF().add(new Triangulo(datosPuntos(3)));
                    break;
                default:
                    objE.mostrar("Figura invalida, vuelva a intentar.");
                    break;
            }

            /*// Version con switch simplificado
            switch (opFig){
                case 1 -> objLF.getListaF().add(new Rectangulo(datosPuntos(2)));
                case 2 -> objLF.getListaF().add(new Circulo(datosPuntos(2)));
                case 3 -> objLF.getListaF().add(new Triangulo(datosPuntos(3)));
                default -> objE.mostrar("Figura invalida, vuelva a intentar.");
            }*/

            objE.mostrar(objLF.toString());
        } while(objE.confirmar("¿Desea agregar mas figuras?"));
    }
}
