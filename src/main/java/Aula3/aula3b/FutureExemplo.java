package Aula3.aula3b;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class FutureExemplo {
    private static final ExecutorService pessoasParaExecutarAtividades = Executors.newFixedThreadPool( 3 );

    public static void main(String[] args) throws InterruptedException {
        Casa casa = new Casa( new Quarto() );
        List<? extends Future<String>> futuros =
        new CopyOnWriteArrayList<>(casa.obterAfazeresDaCasa().stream()
                .map(atividade -> pessoasParaExecutarAtividades.submit(() -> {
                    try {
                        return atividade.realizar();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return null;
                })
                )
                .collect( Collectors.toList()));

        while (true){
            int numeroDeAtividadesNaoFinalizadas = 0;
            for(Future<?> futuro  : futuros ) {
                if (futuro.isDone()){
                    try {
                        System.out.println("Parabéns você terminou de " + futuro.get());
                        futuros.remove( futuro );
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {

                        e.printStackTrace();
                    }
                }
                else {
                    numeroDeAtividadesNaoFinalizadas++;
                }
            }
            if(futuros.stream().allMatch(Future::isDone)){
                break;
            }
            System.out.println("Números de atividades não finalizadas : " +numeroDeAtividadesNaoFinalizadas );
            Thread.sleep( 500 );
        }


        pessoasParaExecutarAtividades.shutdown();
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
    String realizar() throws InterruptedException;
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
    private String arrumaOGuardaRoupa() throws InterruptedException {
        Thread.sleep( 5000 );
        String arruma_o_guarda_roupa = "arruma o guarda roupa";
        System.out.println("arruma o guarda roupa");
        return arruma_o_guarda_roupa;
    }
    private String varreOQuarto() throws InterruptedException {
        Thread.sleep( 7000 );
        String varre_o_quarto = "varre o quarto";
        System.out.println("varre o quarto");
        return varre_o_quarto;
    }
    private String arrumaACama() throws InterruptedException {
        Thread.sleep( 9000 );
        String arruma_a_cama ="Arruma a cama";
        System.out.println("Arruma a cama");
        return arruma_a_cama;
    }

}