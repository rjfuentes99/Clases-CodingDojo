public class Vehiculo{

    public int año;
    public String marca;
    public String modelo;
    public String color;
    public int ruedas;

    /*metodo constructor: la que crea la instancia de vehiculio */
    public Vehiculo() {

    }

    /*Sobrecargamos el metodo constructor color = "rojo" autorojo.color = "rojo" */
    public Vehiculo(String color){
        this.color = color;
    }

    /* Color = "amarilla", ruedas = 2
     *bicicleta.color = "amarilal" , bicicleta.ruedas = 2
     */
    public Vehiculo(String color, int ruedas){
        this.color = color;
        this.ruedas = ruedas;
    }

    public Vehiculo(int año,String marca, String modelo, String color, int ruedas){
        this.año = año;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.ruedas = ruedas;
    }


    /* Funcion para imprimir */

    public void imprimir(){
        System.out.println("Año: "+this.año+" Marca: "+ this.marca+" Modelo: "+this.modelo+" Color: "+this.color+" Ruedas: "+this.ruedas);
    }
    public int getAño() {
        return this.año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getRuedas() {
        return this.ruedas;
    }

    public void setRuedas(int ruedas) {
        this.ruedas = ruedas;
    }

}