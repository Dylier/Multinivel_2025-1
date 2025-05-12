package modelo;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Dyl
 */
public class ListaPropietarios {
    private HashMap<Propietario, ArrayList<Vehiculo>> diccionarioProp;

    public ListaPropietarios(HashMap<Propietario, ArrayList<Vehiculo>> propietarios) {
        this.diccionarioProp = propietarios;
    }
    
    public ListaPropietarios() {
        this.diccionarioProp = new HashMap<>();
    }

    public HashMap<Propietario, ArrayList<Vehiculo>> getDiccionarioProp() {
        return diccionarioProp;
    }

    public void setDiccionarioProp(HashMap<Propietario, ArrayList<Vehiculo>> diccionarioProp) {
        this.diccionarioProp = diccionarioProp;
    }

    @Override
    public String toString() {
        return "ListaPropietarios{" + "diccionarioProp=" + diccionarioProp + '}';
    }
        
}
