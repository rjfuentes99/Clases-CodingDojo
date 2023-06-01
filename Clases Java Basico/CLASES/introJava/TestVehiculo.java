class TestVehiculo {
    
    public static void main(String[] args) {

        //Crear un vehiculo
        Vehiculo auto1 = new Vehiculo();
        //auto1.año = 2001;
        //auto1.marca = "Honda";
        //auto1.modelo = "Civic";
        //auto1.color = "blanco";
        //auto1.ruedas = 4;

        auto1.setAño(2001);
        auto1.setMarca("Honda");
        auto1.setModelo("civic");
        auto1.setColor("Blanco");
        auto1.setRuedas(4);


        //Crear un segundo vehiculo
        Vehiculo auto2 = new Vehiculo(2018,"Mazda", "CX-3", "Azul",4);

        System.out.println("Auto1: "+ auto1.getMarca());
        System.out.println("Auto2: "+ auto2.getMarca());

        // Creo un vehiculo con color
        Vehiculo autorojo = new Vehiculo("rojo");
        System.out.println("Color autorojo: "+autorojo.color);
        // Creo otro vehiculo
        Vehiculo bicicleta = new Vehiculo("amarilla", 2);
        System.out.println("Color bicicleta: "+bicicleta.color);

        auto2.imprimir();
    }
}
