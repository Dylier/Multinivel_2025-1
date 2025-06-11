package modelo;

/**
 *
 * @author Dyl
 */
public abstract class Vehiculo implements ArregloDatos {

    /**
     *
     */
    protected String placa, linea, grupo, uso, marca, combustible;

    /**
     *
     */
    protected int modelo, cilindraje, capacidad;

    /**
     *
     */
    protected double valor;

    public Vehiculo(String placa, String linea, String grupo, String uso, String marca, String combustible, int modelo, int cilindraje, int capacidad, double valor) {
        this.placa = placa;
        this.linea = linea;
        this.grupo = grupo;
        this.uso = uso;
        this.marca = marca;
        this.combustible = combustible;
        this.modelo = modelo;
        this.cilindraje = cilindraje;
        this.capacidad = capacidad;
        this.valor = valor;
    }


    
    /**
     *
     */
    public Vehiculo() {
        this.placa = "";
        this.marca = "";
        this.modelo = 0;
        this.valor = 0.0;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    
    
    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    /**
     *
     * @return
     */
    public String getPlaca() {
        return placa;
    }

    /**
     *
     * @param Placa
     */
    public void setPlaca(String Placa) {
        this.placa = Placa;
    }

    /**
     *
     * @return
     */
    public String getMarca() {
        return marca;
    }

    /**
     *
     * @param Marca
     */
    public void setMarca(String Marca) {
        this.marca = Marca;
    }

    /**
     *
     * @return
     */
    public int getModelo() {
        return modelo;
    }

    /**
     *
     * @param Modelo
     */
    public void setModelo(int Modelo) {
        this.modelo = Modelo;
    }

    /**
     *
     * @return
     */
    public double getValor() {
        return valor;
    }

    /**
     *
     * @param Valor
     */
    public void setValor(double Valor) {
        this.valor = Valor;
    }
            
    /**
     *
     * @return
     */
    public int getCilindraje() {
        return cilindraje;
    }

    /**
     *
     * @param cilindraje
     */
    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }
    
    /**
     *
     * @return
     */
    public abstract double getImpuesto();

    /**
     *
     * @return
     */
    @Override
    public abstract Object[] getArregloDatos();
    
    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Placa:" + placa + "\nMarca:" + marca + "\nModelo:" + modelo + "\nValor:" + valor + "\nCilindraje:" + cilindraje;
    }
  
}