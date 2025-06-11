package modelo;

import java.util.ArrayList;

/**
 *
 * @author Dyl
 */
public class Recaudo {
    public ArrayList<Vehiculo> ListaV;

    public Recaudo(ArrayList<Vehiculo> ListaV) {
        this.ListaV = ListaV;
    }
    
    public Recaudo() {
        this.ListaV = new ArrayList<>();
    }


    public ArrayList<Vehiculo> getListaV() {
        return ListaV;
    }

    public void setListaV(ArrayList<Vehiculo> ListaV) {
        this.ListaV = ListaV;
    }

    public double totalRecaudo(){
        double total = 0;
        for (Vehiculo vehiculo : ListaV) {
            total += vehiculo.getImpuesto();
        }
        return total;
    }
    
    public String datosVehiculos(){
        String aux = "";
        for (Vehiculo vehiculo : ListaV) {
            aux += "\n" + vehiculo.getClass().getSimpleName() +
                   "\n" + vehiculo.toString()+
                   "\n" + "Impuesto: " + String.format("%,.1f",vehiculo.getImpuesto())+
                   "\n";
        }
        return aux;
    }
    
    @Override
    public String toString() {
        return "Recaudo total: " + datosVehiculos() + "\nTotal recaudo: " + String.format("%,.2f",totalRecaudo());
    }
}
