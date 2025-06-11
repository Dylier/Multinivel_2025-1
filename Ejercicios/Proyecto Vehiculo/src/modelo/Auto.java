package modelo;

/**
 *
 * @author Dyl
 */
public class Auto extends Vehiculo{
    private int cantPasajeros;

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
    public Auto() {
        super(); // Constructor del super
        this.cantPasajeros = 0;
    }

        // Constructor Super
    public Auto(int cantPasajeros, String Placa, String Marca, int Modelo, double Valor) {
        super(Placa, Marca, Modelo, Valor); // Constructor del super
        this.cantPasajeros = cantPasajeros;
    }

    public int getCantPasajeros() {
        return cantPasajeros;
    }

    public void setCantPasajeros(int cantPasajeros) {
        this.cantPasajeros = cantPasajeros;
    }

    @Override
    public String obtenerDatos() {
        return super.obtenerDatos() + ";"+ cantPasajeros +";";
    }

    @Override
    public Object[] arregloDatos() {
        return new Object[]{"Auto", placa, marca, modelo, cilindraje, cantPasajeros, String.format("%.2f", valor), String.format("%.2f", getImpuesto())};
    }

    @Override
    public String toString() {
        return super.toString()+"\nCantidad Pasajeros: "+ cantPasajeros;
    }
    
}
