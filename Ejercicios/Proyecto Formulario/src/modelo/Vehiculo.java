package modelo;

/**
 *
 * @author Dyl
 */
public abstract class Vehiculo implements ArregloDatos {

    /**
     * Almacena datos basicos del vehiculo como placa linea etc
     */
    protected String placa, linea, grupo, uso, marca, combustible;

    /**
     * Guarda datos numericos como modelo cilindraje capacidad
     */
    protected int modelo, cilindraje, capacidad;

    /**
     * Contiene el valor monetario del vehiculo
     */
    protected double valor;

    /**
     * Crea un vehiculo con todos sus detalles especificados
     */
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
     * Crea un vehiculo con valores predeterminados vacios o cero
     */
    public Vehiculo() {
        this.placa = "";
        this.marca = "";
        this.modelo = 0;
        this.valor = 0.0;
    }

    /**
     * Obtiene la capacidad del vehiculo
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * Establece la capacidad del vehiculo
     */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    /**
     * Obtiene el tipo de combustible
     */
    public String getCombustible() {
        return combustible;
    }

    /**
     * Establece el tipo de combustible
     */
    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }


    /**
     * Obtiene la linea del vehiculo
     */
    public String getLinea() {
        return linea;
    }

    /**
     * Establece la linea del vehiculo
     */
    public void setLinea(String linea) {
        this.linea = linea;
    }

    /**
     * Obtiene el grupo del vehiculo
     */
    public String getGrupo() {
        return grupo;
    }

    /**
     * Establece el grupo del vehiculo
     */
    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    /**
     * Obtiene el uso del vehiculo
     */
    public String getUso() {
        return uso;
    }

    /**
     * Establece el uso del vehiculo
     */
    public void setUso(String uso) {
        this.uso = uso;
    }

    /**
     * Devuelve la placa del vehiculo
     * @return
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * Asigna la placa del vehiculo
     * @param Placa
     */
    public void setPlaca(String Placa) {
        this.placa = Placa;
    }

    /**
     * Obtiene la marca del vehiculo
     * @return
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Asigna la marca del vehiculo
     * @param Marca
     */
    public void setMarca(String Marca) {
        this.marca = Marca;
    }

    /**
     * Obtiene el modelo del vehiculo
     * @return
     */
    public int getModelo() {
        return modelo;
    }

    /**
     * Asigna el modelo del vehiculo
     * @param Modelo
     */
    public void setModelo(int Modelo) {
        this.modelo = Modelo;
    }

    /**
     * Obtiene el valor del vehiculo
     * @return
     */
    public double getValor() {
        return valor;
    }

    /**
     * Asigna el valor del vehiculo
     * @param Valor
     */
    public void setValor(double Valor) {
        this.valor = Valor;
    }

    /**
     * Obtiene el cilindraje del vehiculo
     * @return
     */
    public int getCilindraje() {
        return cilindraje;
    }

    /**
     * Asigna el cilindraje del vehiculo
     * @param cilindraje
     */
    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    /**
     * Calcula y devuelve el impuesto del vehiculo
     * @return
     */
    public abstract double getImpuesto();

    /**
     * Devuelve los datos del vehiculo en un arreglo
     * @return
     */
    @Override
    public abstract Object[] getArregloDatos();

    /**
     * Representacion en texto del vehiculo
     * @return
     */
    @Override
    public String toString() {
        return "Placa:" + placa + "\nMarca:" + marca + "\nModelo:" + modelo + "\nValor:" + valor + "\nCilindraje:" + cilindraje;
    }

}