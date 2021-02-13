package aula2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Iteracoes {
    public static void main(String[] args) {
        String [] nomes = {"Jesse", "Caetano","dos", "Santos", "Professor", "Música"};
        Integer[] numeros = {1,2,3,4,5};
      //  imprimirNomesFiltrados(nomes);
       // imprimirTodosNomes(nomes);
        //imprimirODobroDeCadaItemDaLista(numeros);

        List<String> empregado = new ArrayList<>();
        empregado.add( "Professor de INGLÊS" );
        empregado.add( "Professor de GEOGRAFIA" );
        empregado.add( "Professor de DESENHO TÉCNICO" );
        empregado.add( "Professor de MATEMATICA" );
        empregado.add( "Gerente de projeto" );
        empregado.add( "Desendovedor" );
        empregado.add( "Gerente de qualidade" );

        empregado.stream()
                .filter( funcionario -> funcionario.startsWith( "Gerente" ))
                .forEach( System.out::println );

    }

    public static void imprimirNomesFiltrados(String... nomes){
        String nomesParaImprimir = "";
        for (int i = 0; i<nomes.length; i++){
            if (nomes[i].equals( "Jesse" )){
                nomesParaImprimir+= "" +nomes[i];
            }
        }
        System.out.println(nomesParaImprimir);

       String nomesParaImprimirDaString =Stream.of( nomes )
                .filter( nome -> nome.equals( "Jesse" ) )
                .collect( Collectors.joining());//String

        System.out.println(nomesParaImprimirDaString);
    }
    public static void imprimirTodosNomes(String... nomes){
       for( String nome : nomes){
            System.out.println("Impriomido pelo for: " +nome);
        }
        Stream.of( nomes )
                //.forEach( System.out::println ); // ou
                .forEach( nome -> System.out.println("Imprimido pelo Stream: "+nome) );

    }

    public static void imprimirODobroDeCadaItemDaLista(Integer... numeros){
        for(Integer numero : numeros){
            System.out.println(numero +" x 2 = "+numero*2 + " com foreach");
        }
        Stream.of( numeros ).map( numero -> numero + " x 2 = " + numero*2 + " resultado Stream" )
                .forEach( System.out::println );
    }
}
