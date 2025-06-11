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

    /**
     * Calcula impuesto moto segun cilindraje
     * @return double
     */
    @Override
    public double getImpuesto(){
        if(this.getCilindraje()>125){
            return this.getValor()*0.15;
        }else{
            return this.getValor()*0.0;
        }
    }

    /**
     * Devuelve datos de la moto en formato arreglo
     * @return Object[]
     */
    @Override
    public Object[] getArregloDatos() {
        return new Object[]{"Moto", placa, marca, modelo, cilindraje, "2", String.format("%.2f", valor), String.format("%.2f", getImpuesto())};
    }


    /**
     * Constructor predeterminado para crear una moto
     */
    public Moto() {
        super();
    }

}