public class TestCelulares {


    public static void main(String[] args) {

        Celulares celular1 = new Celulares();
        Celulares celular2 = new Celulares();

        celular1.setYear(2019);
        celular1.setMarca("Samsumg");
        celular1.setModelo("A22");
        celular1.setColor("Negro");

        celular1.imprimir();

        celular2.setYear(2020);
        celular2.setMarca("Iphone");
        celular2.setModelo("X8s");
        celular2.setColor("Blanco");
        
        celular2.imprimir();

        int CelularesCount = Celulares.getCount();

        System.out.println("Los celulares creados en total son: "+ CelularesCount);
    }
}
