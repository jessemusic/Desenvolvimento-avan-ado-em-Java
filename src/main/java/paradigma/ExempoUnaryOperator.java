package paradigma;

import java.util.function.UnaryOperator;

public class ExempoUnaryOperator {
    public static void main(String[] args) {
        UnaryOperator<Integer> uop = x -> x*3;
        int x=11;
        System.out.println("Resultado:: " + uop.apply( x ));
        // Gera
    }
}
