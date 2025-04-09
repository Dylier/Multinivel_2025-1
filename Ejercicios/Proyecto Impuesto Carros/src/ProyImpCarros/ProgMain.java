/*
 * Main Principal Del Programa
 */
package ProyImpCarros;

import Modelo.Vehiculo;
import java.util.Scanner;

/**
 *
 * @author Dyl
 */
public class ProgMain {
    public static void main(String[] args){
        Vehiculo objV = new Vehiculo() ;
        Scanner objS= new Scanner(System.in);
        System.out.println("Digite Placa Del Vehiculo");
        objV.setPlaca(objS.next());
        System.out.println("Digite Marca Del Vehiculo");
        objV.setMarca(objS.next()) ;
        System.out.println("Digite Modelo Del Vehiculo") ;
        objV.setModelo(objS.nextInt());
        System.out.println("Digite valor Del Vehiculo");
        objV.setValor(objS.nextDouble());
        System.out.println("EI valor del impuesto es "+ objV.impuesto());
        System.out.println ("Los datos del vehiculo son "+ objV.toString()) ;
    }  
}
