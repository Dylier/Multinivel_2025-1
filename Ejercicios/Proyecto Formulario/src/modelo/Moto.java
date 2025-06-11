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
     *
     * @return
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
     *
     * @return
     */
    @Override
    public Object[] getArregloDatos() {
        return new Object[]{"Moto", placa, marca, modelo, cilindraje, "2", String.format("%.2f", valor), String.format("%.2f", getImpuesto())};
    }


    /**
     *
     */
    public Moto() {
        super();
    }

}
