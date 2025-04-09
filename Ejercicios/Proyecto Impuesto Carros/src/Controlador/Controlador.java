/*
 * Clase que comunicara el Modelo con la Vista ... Futuramente
 */
package Controlador;

import Modelo.Vehiculo;
import java.util.Scanner;

/**
 *
 * @author Dyl
 */
public class Controlador {
    public void iniciar(){
        Vehiculo objV = new Vehiculo() ;
        Scanner objS= new Scanner(System.in);
        System.out.println("Digite Placa Vehiculo");
        objV.setPlaca(objS.next());
        System.out.println("Digite Marca Vehicula");
        objV.setMarca(objS.next()) ;
        System.out.println("Digite Modelo Vehiculo") ;
        objV.setModelo(objS.nextInt());
        System.out.println("Digite valor Vehiculo");
        System.out.println("EI valor del impuesto es "+ objV.impuesto());
        System.out.println ("Los datos del vehiculo son "+ objV.toString()) ;
    }
}