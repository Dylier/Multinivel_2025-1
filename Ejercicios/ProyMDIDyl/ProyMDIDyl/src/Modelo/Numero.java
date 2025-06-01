/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ZullyPc
 */
public class Numero {
    private int valor;

    public Numero(int valor) {
        this.valor = valor;
    }
    
     public Numero() {
        this.valor = 0;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Valor="+valor;
    }
     
    public int suma(int val){
        return valor+val;
    }
    
    public double potencia(int exp){
        double pot=1;
        for(int i=1; i<=exp; i++){
            pot*=this.valor;        
        }
        return pot;
    }
    
}
