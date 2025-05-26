package modelo;

public abstract class Vehiculo {
    protected String placa, marca;
    protected int modelo;
    protected double valor, cilindraje;
    
    public Vehiculo(String placa, String marca, int modelo, double cilind, double valor) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.cilindraje = cilind;
        this.valor = valor;
    }

    public Vehiculo() {
        this.placa = "";
        this.marca = "";
        this.modelo = 0;
        this.cilindraje = 0;
        this.valor = 0;
    }

    public abstract double impuesto();
    
    @Override
    public String toString() {
        return "\tplaca=" + placa + "\n\tmarca=" + marca + 
               "\n\tmodelo=" + modelo + "\n\tcilindraje=" + cilindraje + 
               "\n\tvalor=" + String.format("%.0f", valor);
    }

    // Getters y Setters
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public double getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(double cilindraje) {
        this.cilindraje = cilindraje;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}