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
            total += vehiculo.Impuesto();
        }
        return total;
    }
    
    public String datosVehiculos(){
        String aux = "";
        double total = 0;
        /*
        // Con condicionales
        String tf = "";
        for (Vehiculo vehiculo : ListaV) {
            if (vehiculo instanceof Auto){
                tf = "Auto ";
            } else if (vehiculo instanceof Moto) {
                tf = "Moto ";
            }
            aux += tf + vehiculo.toString();
            total += vehiculo.Impuesto();
        }
        */
        for (Vehiculo vehiculo : ListaV) {
            aux += "\n" + vehiculo.getClass().getSimpleName() + 
                   "\n" + vehiculo.toString()+ 
                   "\n" + "Impuesto: " + String.format("%,.1f",vehiculo.Impuesto())+
                   "\n";
            total += vehiculo.Impuesto();
        }
        return aux;
    }
    
    @Override
    public String toString() {
        return "Recaudo total: " + datosVehiculos() + "\nTotal recaudo: " + String.format("%,.2f",totalRecaudo());
    }
    
    
}
