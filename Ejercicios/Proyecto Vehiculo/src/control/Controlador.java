package control;

import java.util.ArrayList;
import modelo.Auto;
import modelo.Moto;
import modelo.Recaudo;
import modelo.Vehiculo;
import vista.CajasMensaje;

/**
 *
 * @author Dylier
 */
public class Controlador {
    private CajasMensaje objE;
    private Recaudo objLF;

    // Constructores
    public Controlador(CajasMensaje objE, Recaudo objLF) {
        this.objE = objE;
        this.objLF = objLF;
    }

    public Controlador() {
        this.objE = new CajasMensaje();
        this.objLF = new Recaudo();
    }

    // Metodo para pedirle al ususario los puntos de las figuras
    private void datosVehiculo(Vehiculo objV){
        objV.setPlaca(objE.leerTexto("Placa vehiculo: "));
        objV.setMarca(objE.leerTexto("Marca vehiculo: "));
        objV.setModelo(objE.leerEntero("Modelo vehiculo: "));
        objV.setCilindraje(objE.leerEntero("Cilindraje vehiculo: "));
        objV.setValor(objE.leerDecimal("Valor vehiculo: "));
    }

    // Metodo iniciar del controlador
    public void iniciar(){
        int opFig;
        do{
            opFig = objE.leerEntero("Figuras:\n1. Auto\n2. Moto"); 
            switch (opFig){
                case 1 -> {  
                    Auto objA = new Auto();
                    datosVehiculo(objA);
                    objA.setCantPass(objE.leerEntero("Cantidad de Pasajeros: "));
                    objLF.getListaV().add(objA);
                }
                case 2 -> {
                    Vehiculo objM = new Moto();
                    datosVehiculo(objM);
                    objLF.getListaV().add(objM);
                }
                default -> objE.mostrar("Vehiculo invalido.");
            }
            objE.mostrar(objLF.toString());
        } while(objE.confirmar("¿Desea agregar mas vehiculos?"));
    }
}
