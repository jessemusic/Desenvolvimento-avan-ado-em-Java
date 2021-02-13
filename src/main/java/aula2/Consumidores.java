package aula2;

import java.util.function.Consumer;

public class Consumidores {

    public static void main(String[] args) {

        Consumer<String> imprimirUmaFrase = System.out::println;
     //   Consumer<String> imprimirUmaFrase = Frase -> System.out.println(Frase);
        imprimirUmaFrase.accept( "Hello Jesse" );


    }
}
