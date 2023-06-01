public class ManipulacionDeCadenas{

    // FUNCION UNO
    public static String trimAndConcat(String cadenaUno, String cadenaDos){
        
        return cadenaUno.trim() + cadenaDos.trim();

    }
    // FUNCION DOS

    public static int getIndexOrNull(String str, char letter){

        return str.indexOf(letter);
    }


    // FUNCION TRES
    public static int getIndexOrNull(String cadena, String subCadena){
        return cadena.indexOf(subCadena);
    }


    // FUNCION CUATRO
    public static String concatSubstring(String cadenaUno, int posicionInicio, int posicionFinal, String cadenaDos){

        return cadenaUno.substring(posicionInicio, posicionFinal) + cadenaDos;

    }

}

