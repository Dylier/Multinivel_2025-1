/*
 * Clase Main para Ejecutar Proy
 */
package proysregestudiantes;

import java.util.Scanner;
import modelo.Estudiante;

/**
 *
 * @author Dyl
 */

public class ProysRegEstudiantes {
    public static void main(String[] args) {
        Estudiante obj = new Estudiante();
        leerEstudiante(obj);
        System.out.println(obj.toString());
        System.out.println("Prom:\n"+obj.promedio());
    }
    
    public static void leerEstudiante(Estudiante obj){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el nombre del estudiante: ");
        obj.setNom(entrada.next());
        System.out.println("Ingrese el codigo del estudiante: ");
        obj.setCod(entrada.next());
        System.out.println("Ingrese las notas del estudiante: ");
        for (int i = 0; i<obj.getNotas().length; i++){
            System.out.println("Ingrese la "+ (i+1) + " nota");
            obj.getNotas()[i] = entrada.nextDouble();
        }
    }

}
