public class Test {

    // javac "Nombre del archivo + .java" Compilar el codigo
    // java "Nombre del archivo" Ejecutar el programa

    public static void main(String[] args) {
        System.out.println("Hola mundo !");
        // Variables primitivas
        int nuestroInt; // podemos declarar una variable sin establecer un valor
        nuestroInt = 400; // Int es un numero entero
        double pi = 3.14159265; // doublee s un valor con decimales
        boolean bool = true; // boolean puede ser true o false
        char unCaracter = 'A';

        String multiplesCaracteres = "ABCDE";
        System.out.println(multiplesCaracteres);

        // Variables tipo objeto
        Integer myInt = 5;
        Double myDouble = 5.99;
        Character myChyar = 'A';

        // Gracias a las variables tipo objeto, nosotros podemos utilizar metodos o
        // funciones pre-hechas
        String myString = myInt.toString(); // myString = "5"
        System.out.println(myString.length()); // tamaño de myString -> 1

        // Cadenas = Strings
        String cadena = "Buenos dias a todos mis Compañeros";
        int length = cadena.length();
        System.out.println("La longitud de mi cadena es: " + length);
        char letra = cadena.charAt(1); // obtenemos una letra en la posicion que indicamos
        System.out.println(letra);

        int posicion1 = cadena.indexOf("Buenos"); // me regresa la posicion donde se encuentra lo que estamos buscando
        System.out.println(posicion1);
        int posicion2 = cadena.indexOf("Compañeros");
        System.out.println(posicion2);

        System.out.println(cadena.toLowerCase()); // Minisculas
        System.out.println(cadena.toUpperCase()); // Mayusculas

        String str1 = "Mi nombre es ";
        String str2 = "Ricardo Fuentes";
        String str3 = str1.concat(str2); // Juntamos dos strings
        System.out.println(str3);

        String hola1 = "hola";
        String hola2 = "hola";
        System.out.println(hola1.equals(hola2)); // Compara dos strings y nos regresa true si son iguales

        int[] myArray; // Inicializando el array
        myArray = new int[5]; // Cuantas posiciones tendra mi arreglo
        myArray[0] = 4;
        myArray[1] = 8;
        myArray[2] = 8;
        myArray[3] = 5;
        myArray[4] = 9;

        int[] myArray2 = {4, 8, 8, 5, 9};

        
    }
}