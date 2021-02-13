package paradigma;

public class ExemploLambda {
    public static void main(String[] args) {
        MeuExercicio funcao1 = valor -> {
            System.out.println(valor);
            System.out.println(valor + " Opa");
        };
        funcao1.gerar( "Jesse" );
    }
    interface MeuExercicio {
        void gerar(String valor);
    }
}
