package paradigma;

import java.util.function.BiPredicate;

public class ExemploFuncoesPuras {
    public static void main(String[] args) {
        BiPredicate<Integer,Integer> vSM = (parametro, valorComparacao) -> parametro > valorComparacao;
        System.out.println(vSM.test( 11,12 ));
        System.out.println(vSM.test( 13,12 ));
    }
}
