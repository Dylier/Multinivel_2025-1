/*
 * Clase para representar a un Estudiante
 */
package modelo;

import java.util.Scanner;

/**
 * @author Dyl
 */
public class Estudiante {
    private String nom, cod;
    private double notas[];

    public Estudiante(String nom, String cod, double[] notas) {
        this.nom = nom;
        this.cod = cod;
        this.notas = notas;
    }
    
    public Estudiante() {
        this.nom = "";
        this.cod = "";
        this.notas = new double[3];
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public double[] getNotas() {
        return notas;
    }

    public void setNotas(double[] notas) {
        this.notas = notas;
    }
    
    public double promedio(){
        double prom = 0.0;
        for (double nota: notas){
            prom += nota;
        }
        return prom/notas.length;
    }
    
    @Override
    public String toString() {
        String not = "";
        for (double nota: notas){
            not += nota + "\n";
        }
        return "\nDatos estudiante: \n" + 
                "\nnombre: " + nom + 
                "\ncodigo: " + cod + 
                "\nnotas: \n" + not;
    } 

}
