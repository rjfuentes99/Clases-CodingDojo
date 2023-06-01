public class Celulares {
    
    private int year;
    private String marca;
    private String modelo;
    private String color;

    private static int COUNT = 0;

    public Celulares(){
        COUNT++;
    }
    public void imprimir(){
        System.out.println("Año: "+this.year+" Marca: "+ this.marca+" Modelo: "+this.modelo+" Color: "+this.color);
    }
  
    public int getYear(){
        return this.year;
    }
    public void setYear(int year){
        this.year = year;
    }
    public String getMarca(){
        return this.marca;
    }
    public void setMarca(String marca){
        this.marca = marca;
    }
    public String getmodelo(){
        return this.modelo;
    }
    public void setModelo(String modelo){
        this.modelo = modelo;
    }
    public String getColor(){
        return this.color;
    }
    public void setColor(String color){
        this.color = color;
    }
    public static int getCount(){
        return COUNT;
    }
}
