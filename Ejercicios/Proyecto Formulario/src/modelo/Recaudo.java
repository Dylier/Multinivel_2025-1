package modelo;

import java.util.ArrayList;

/**
 *
 * @author Dyl
 */
public class Recaudo {
    private ArrayList<Formulario> formularios;

    public Recaudo(ArrayList<Formulario> formularios) {
        this.formularios = formularios;
    }

    public Recaudo() {
        this.formularios = new ArrayList<>();
    }

    public ArrayList<Formulario> getFormularios() {
        return formularios;
    }

    public void setFormularios(ArrayList<Formulario> formularios) {
        this.formularios = formularios;
    }
    
    public Double totalRecaudo(){
        double total = 0.0;
        for (Formulario formulario : formularios) {
            total += formulario.getVehiculo().Impuesto();
        }
        return total;
    }
}
