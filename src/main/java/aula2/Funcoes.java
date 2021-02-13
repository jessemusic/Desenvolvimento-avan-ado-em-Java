package aula2;

import java.util.function.Function;

public class Funcoes {
    public static void main(String[] args) {
        String nome = "Amanheceu perdi peguei a sacola e fui viajar";
        Function<String , String> retornarNomeAoContrario
                = texto -> new StringBuilder(texto).reverse().toString();
        Function<String ,Integer> ConverteStringParaInteiroECalculaODobro
                = string -> Integer.valueOf( string ) * 2;
        System.out.println(retornarNomeAoContrario.apply( nome));
        System.out.println(ConverteStringParaInteiroECalculaODobro.apply( "35" ));

    }
}
