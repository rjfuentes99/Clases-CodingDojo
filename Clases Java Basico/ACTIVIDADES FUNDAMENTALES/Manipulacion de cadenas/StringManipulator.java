public class StringManipulator {
    
    public static void main(String[] args) {
        ManipulacionDeCadenas stringManipulator = new ManipulacionDeCadenas();

        System.out.println(stringManipulator.trimAndConcat(" hola "," mundo "));
        System.out.println(stringManipulator.getIndexOrNull("paralelepido kamikase", 'l'));
        System.out.println(stringManipulator.getIndexOrNull("paralelepido kamikase", 'x'));
        System.out.println(stringManipulator.getIndexOrNull("hola", "la"));
        System.out.println(stringManipulator.getIndexOrNull("hola", "mundo"));
        System.out.println(stringManipulator.concatSubstring("hola", 1,3,"mundo"));
    }

}
