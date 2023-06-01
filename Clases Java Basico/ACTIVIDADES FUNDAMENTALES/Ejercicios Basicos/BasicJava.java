public class BasicJava {
    public static void main(String[] args) {
        //CicloPrintTotal();
        //CicloPrintImpares();
        //PrintSuma();
        //RecorrerArreglo();
        //ImprimirMaximoArreglo();
        //PromedioArreglo();
        //ArregloImpar();
        //MayorY();
        //ValoresAlCuadrado();
        //EliminarValoresNegativos();
        //CalcularTodo();
        //CambiarValoresArreglo();
    }
    public static void CicloPrintTotal(){
        for(int i = 1; i <= 255; i++){
            System.out.println(i);
        }
    }

    public static void CicloPrintImpares(){
        for(int i = 1; i <= 255; i++){
            if (i%2 != 0) {
                System.out.println(i);
            }
        }
    }

    public static void PrintSuma(){
        var suma = 0;
        for(int i = 0; i <= 255; i++){
            System.out.print(" Nuevo numero: "+i+" Suma: "+ (suma+i));
            suma = suma + i;
        }
    }

    public static void RecorrerArreglo(){
        int [] arreglo = {1,3,5,7,9,13};
        for(int i=0;i<arreglo.length ; i++){
                System.out.println(arreglo[i]);
        }
    }

    public static void ImprimirMaximoArreglo(){

        int[] numeros = new int[] { -3,-5,-7 };
		int mayor = numeros[0];
		for (int i = 1; i < numeros.length; i++) {
			if (numeros[i] > mayor) {
				mayor = numeros[i];
			}
		}
		System.out.println("El mayor es: " + mayor);
    }

    public static void PromedioArreglo(){
        var suma = 0;
        int [] arreglo = {3,7,9,13};
        for(int i=0;i<arreglo.length ; i++){
            suma = suma + arreglo[i];
        }
        float promedio = suma / arreglo.length;
		System.out.printf("Suma: %d. Promedio: %f", suma, promedio);

    }

    public static void ArregloImpar(){
        int array[] = new int[256];
        for(int i = 1; i <= 255; i++){
            
                array[i] = i;
        }
        for (int i = 0; i < 255; i++) {
            if (i%2 != 0) {
            System.out.print(array[i] + " ");
            }
          }
    }

    public static void MayorY(){
        int sum = 0;
        int [] arreglo = {1,3,5,7};
        for(int i=0;i<arreglo.length ; i++){
            if (arreglo[i] > 3) {
                sum = sum + 1;
            }
        }
        System.out.println(sum);
    }

    public static void ValoresAlCuadrado(){
        int multiplicar = 0;
        int [] arreglo = {1,5,10,-2};
        for(int i=0;i<arreglo.length ; i++){
            multiplicar = arreglo[i] * arreglo[i];
            System.out.print(multiplicar + " ");
        }
        
    }

    public static void EliminarValoresNegativos(){
        int [] arreglo = {1,5,10,-2};
        for(int i=0;i<arreglo.length ; i++){
            if (arreglo[i] < 0) {
                arreglo[i] = 0;
                System.out.println(arreglo[i]);
            }else{
                System.out.println(arreglo[i]);
            }
        }
    }

    public static void CalcularTodo(){
        var suma = 0;
        int [] arreglo = {1,5,10,-2};
        int numeromax = arreglo[0];
        int numeromin = arreglo[0];
        for(int i=0;i<arreglo.length ; i++){
            suma = suma + arreglo[i];
            if (arreglo[i] >= numeromax) {
				numeromax = arreglo[i];
			}else if (arreglo[i] < numeromin) {
                numeromin = arreglo[i];
            }
        }
        float promedio = suma / arreglo.length;
        System.out.print("El valor maximo es: "+numeromax+" El numero minimo es: "+numeromin+" Y el promedio del arreglo es: "+promedio);
    }

    public static void CambiarValoresArreglo(){
        
    }
}
