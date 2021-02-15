package Aula3.aula3c;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class PalaleloStreamExemplos {

    public static void main(String[] args) {
    /*    long inicio = System.currentTimeMillis();
        IntStream.range( 1,100000 ).forEach( num -> fatorial( num ));
        long fim = System.currentTimeMillis();
        System.out.println("Tempo de execução do Serial: " + (fim-inicio));

         inicio = System.currentTimeMillis();
        IntStream.range( 1,100000 ).parallel().forEach( num -> fatorial( num ));
        fim = System.currentTimeMillis();
        System.out.println("Tempo de execução do Paralelo: " + (fim-inicio));
*/
        List<String > nomes = Arrays.asList( "Jesse", "Caetano", "Dos", "Santos", "Professor", "Programador", "Música", "Matemática" );
        nomes.parallelStream().forEach( System.out::println);

    }

    public static long  fatorial(long num){
        long fat =1;
        for(long i=2; i<=num ; i++){
            fat*=i;
        }
        return fat;
    }
}
