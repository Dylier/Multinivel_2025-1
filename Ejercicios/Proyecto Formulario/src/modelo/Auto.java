package modelo;

/**
 *
 * @author Dyl
 */
public class Auto extends Vehiculo{
    private int cantPasajeros;

    /**
     *
     * @return
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
     *
     */
    public Auto() {
        super(); // Constructor del super
        this.cantPasajeros = 0;
    }

        // Constructor Super

    public Auto(int cantPasajeros, String placa, String linea, String grupo, String uso, String marca, String combustible, int modelo, int cilindraje, int capacidad, double valor) {
        super(placa, linea, grupo, uso, marca, combustible, modelo, cilindraje, capacidad, valor);
        this.cantPasajeros = cantPasajeros;
    }


    /**
     *
     * @return
     */
    public int getCantPasajeros() {
        return cantPasajeros;
    }

    /**
     *
     * @param cantPasajeros
     */
    public void setCantPasajeros(int cantPasajeros) {
        this.cantPasajeros = cantPasajeros;
    }


    /**
     *
     * @return
     */
    @Override
    public Object[] getArregloDatos() {
        return new Object[]{"Auto", placa, marca, modelo, cilindraje, cantPasajeros, String.format("%.2f", valor), String.format("%.2f", getImpuesto())};
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return super.toString()+"\nCantidad Pasajeros: "+ cantPasajeros;
    }
    
}
