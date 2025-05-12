package modelo;

/**
 *
 * @author Dyl
 */
public class Auto extends Vehiculo{
    private int cantPass;
    @Override
    public double Impuesto(){
        if(this.getModelo()<2000){
            return this.getValor()*0.05;
        }else{
            return this.getValor()*0.1;
        }
    }
    
    // CONSTRUCTORES
        // Constructor Vacio
    public Auto() {
        super(); // Constructor del super
        this.cantPass = 0;
    }
    
        // Constructor Super
    public Auto(int cantPass, String Placa, String Marca, int Modelo, double Valor) {
        super(Placa, Marca, Modelo, Valor); // Constructor del super
        this.cantPass = cantPass;
    }

    public int getCantPass() {
        return cantPass;
    }

    public void setCantPass(int cantPass) {
        this.cantPass = cantPass;
    }

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String Placa) {
        this.Placa = Placa;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public int getModelo() {
        return Modelo;
    }

    public void setModelo(int Modelo) {
        this.Modelo = Modelo;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    public double getValor() {
        return Valor;
    }

    public void setValor(double Valor) {
        this.Valor = Valor;
    }

    @Override
    public String toString() {
        return super.toString()+"\nCantPass: "+cantPass;
    }
    
}
