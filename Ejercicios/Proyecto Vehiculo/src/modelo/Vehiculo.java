package modelo;

/**
 *
 * @author Dyl
 */
public abstract class Vehiculo {
    protected String placa;
    protected String marca;
    protected int modelo, cilindraje;
    protected double valor;
    
    public Vehiculo(String Placa, String Marca, int Modelo, double Valor) {
        this.placa = Placa;
        this.marca = Marca;
        this.modelo = Modelo;
        this.valor = Valor;
    }
    public Vehiculo() {
        this.placa = "";
        this.marca = "";
        this.modelo = 0;
        this.valor = 0.0;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String Placa) {
        this.placa = Placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String Marca) {
        this.marca = Marca;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int Modelo) {
        this.modelo = Modelo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double Valor) {
        this.valor = Valor;
    }
            
    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }
    
    public abstract double getImpuesto();

    public String obtenerDatos() {
        return placa + ";" + marca + ";" + modelo + ";" + cilindraje + ";" + valor;
    }

    public abstract Object[] arregloDatos();

    @Override
    public String toString() {
        return "Placa:" + placa + "\nMarca:" + marca + "\nModelo:" + modelo + "\nValor:" + valor + "\nCilindraje:" + cilindraje;
    }
  
}