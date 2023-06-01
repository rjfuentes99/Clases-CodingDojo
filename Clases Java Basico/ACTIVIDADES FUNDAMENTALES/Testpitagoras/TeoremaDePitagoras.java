import java.lang.Math;
public class TeoremaDePitagoras{

    public static double calcularHipotenusa(double catetoA, double catetoB){

        double c = 0;
        catetoA = Math.pow(catetoA, 2);
        catetoB = Math.pow(catetoB, 2);
        c = Math.sqrt(catetoA+catetoB);
        return c;
    }
}


