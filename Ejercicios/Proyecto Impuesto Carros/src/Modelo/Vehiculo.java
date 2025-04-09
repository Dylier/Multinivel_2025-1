/*
 * Clase para representar un Vehiculo con placa, Marca, Modelo y Valor
 */
package Modelo;

/**
 *
 * @author Dyl
 */
public class Vehiculo {
    private String placa, marca;
    private int modelo;
    private double valor;

    public Vehiculo(String placa, String marca, int modelo, double valor) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.valor = valor;
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public double impuesto(){
        if (modelo < 2000){
            return valor * 0.05;
        }else{
            return valor * 0.1;
        }
    }

    @Override
    public String toString() {
        return  "\nplaca: " + placa + 
                "\n marca: " + marca + 
                "\n modelo: " + modelo +
                "\n valor:" + valor;
    }
}