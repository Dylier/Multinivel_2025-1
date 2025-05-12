/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Estudiante
 */
public class Moto extends Vehiculo {

    @Override
    public double Impuesto(){
        if(this.getCilindraje()>125){
            return this.getValor()*0.15;
        }else{
            return this.getValor()*0.0;
        }
    }
    
    public Moto(String Placa, String Marca, int Modelo, double Valor) {
        super(Placa, Marca, Modelo, Valor);
    }

    public Moto() {
        super();
    }    
    
}
