package modelo;

/**
 *
 * @author Dyl
 */
public class Auto extends Vehiculo{
    private int cantPasajeros;

    /**
     * Calcula impuesto auto segun su modelo
     * @return double
     */
    @Override
    public double getImpuesto(){
        if(this.getModelo()<2000){
            return this.getValor()*0.05;
        }else{
            return this.getValor()*0.1;
        }
    }

    // CONSTRUCTORES
        // Constructor Vacio

    /**
     * Crea un auto con valores predeterminados
     */
    public Auto() {
        super(); // Constructor del super
        this.cantPasajeros = 0;
    }

        // Constructor Super

    /**
     * Crea un auto con todos sus detalles especificados
     */
    public Auto(int cantPasajeros, String placa, String linea, String grupo, String uso, String marca, String combustible, int modelo, int cilindraje, int capacidad, double valor) {
        super(placa, linea, grupo, uso, marca, combustible, modelo, cilindraje, capacidad, valor);
        this.cantPasajeros = cantPasajeros;
    }


    /**
     * Obtiene la cantidad de pasajeros
     * @return int
     */
    public int getCantPasajeros() {
        return cantPasajeros;
    }

    /**
     * Establece la cantidad de pasajeros
     * @param cantPasajeros
     */
    public void setCantPasajeros(int cantPasajeros) {
        this.cantPasajeros = cantPasajeros;
    }


    /**
     * Devuelve los datos del auto en un arreglo
     * @return Object[]
     */
    @Override
    public Object[] getArregloDatos() {
        return new Object[]{"Auto", placa, marca, modelo, cilindraje, cantPasajeros, String.format("%.2f", valor), String.format("%.2f", getImpuesto())};
    }

    /**
     * Devuelve texto con detalles del auto
     * @return String
     */
    @Override
    public String toString() {
        return super.toString()+"\nCantidad Pasajeros: "+ cantPasajeros;
    }

}