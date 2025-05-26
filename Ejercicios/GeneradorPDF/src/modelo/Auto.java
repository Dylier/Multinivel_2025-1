package modelo;

public class Auto extends Vehiculo {
    private int cantPass;
    
    public Auto(String placa, String marca, int modelo, double cilindraje, int cantPass, double valor) {
        super(placa, marca, modelo, cilindraje, valor);
        this.cantPass = cantPass;
    }
    
    public Auto() {
        super();
        this.cantPass = 0;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\n\tNro Pasajeros: " + cantPass;
    }

    @Override
    public double impuesto() {
        double imp = 0;
        if(this.modelo >= 2000) {
            imp = this.valor * 0.010;
        } else {
            imp = this.valor * 0.05;
        }
        return imp;
    }

    // Getter y Setter para cantPass
    public int getCantPass() {
        return cantPass;
    }

    public void setCantPass(int cantPass) {
        this.cantPass = cantPass;
    }
}