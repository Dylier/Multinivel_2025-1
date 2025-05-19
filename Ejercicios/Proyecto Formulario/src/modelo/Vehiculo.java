package modelo;

/**
 *
 * @author Dyl
 */
public abstract class Vehiculo {
    protected String Placa;
    protected String Marca;
    protected int Modelo, cilindraje;

    protected double Valor;
    
    public Vehiculo(String Placa, String Marca, int Modelo, double Valor) {
        this.Placa = Placa;
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.Valor = Valor;
    }
    public Vehiculo() {
        this.Placa = "";
        this.Marca = "";
        this.Modelo = 0;
        this.Valor = 0.0;
    }

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String Placa) {
        this.Placa = Placa;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public int getModelo() {
        return Modelo;
    }

    public void setModelo(int Modelo) {
        this.Modelo = Modelo;
    }

    public double getValor() {
        return Valor;
    }

    public void setValor(double Valor) {
        this.Valor = Valor;
    }
            
    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }
    
   public abstract double Impuesto();
    
     @Override
    public String toString() {
        return "Placa:" + Placa + "\nMarca:" + Marca + "\nModelo:" + Modelo + "\nValor:" + Valor + "\nCilindraje:" + cilindraje;
    }
  
}