public class TestPitagoras{
    public static void main(String[] args) {
        TeoremaDePitagoras pitagoras = new TeoremaDePitagoras();
        double resultado = pitagoras.calcularHipotenusa(2, 4);
        System.out.println(resultado);
    }
}