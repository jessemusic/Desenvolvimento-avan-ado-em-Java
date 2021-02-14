package Aula3.aula3b;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FutureExemplo {
    private static final ExecutorService threadPool = Executors.newFixedThreadPool( 3 );

    public static void main(String[] args) {
        Casa casa = new Casa( new Quarto() );
        casa.obterAfazeresDaCasa().forEach( atividade -> threadPool.execute( () ->
        {
            try {
                atividade.realizar();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } ) );
        threadPool.shutdown();
    }


}

class Casa {
    private List<Comodo> comodos;
    Casa(Comodo... comodos){ this.comodos = Arrays.asList( comodos ); }
    List<Atividade> obterAfazeresDaCasa(){
        return this.comodos.stream().map( Comodo::obterAfazeresDoComodo )
                .reduce(new ArrayList<Atividade>(),(pivo, atividades) -> {
                    pivo.addAll(atividades);
                    return pivo;
        } );
    }
}

interface  Atividade{
    void realizar() throws InterruptedException;
}
abstract  class Comodo {
    abstract List<Atividade> obterAfazeresDoComodo();
}

class Quarto extends Comodo{
    @Override
    List<Atividade> obterAfazeresDoComodo(){
        return  Arrays.asList(
                this::arrumaACama,
                this::varreOQuarto,
                this::arrumaOGuardaRoupa
        );
    }
    private void arrumaOGuardaRoupa() throws InterruptedException {
        Thread.sleep( 5000 );
        System.out.println("arruma o guarda roupa"); }
    private void varreOQuarto() throws InterruptedException {
        Thread.sleep( 5000 );
        System.out.println("varre o quarto");}
    private void arrumaACama() throws InterruptedException {
        Thread.sleep( 5000 );
        System.out.println("Arruma a cama");}

}