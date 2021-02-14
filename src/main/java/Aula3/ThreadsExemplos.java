package Aula3;

public class ThreadsExemplos {
    public static void main(String[] args) {
       Thread thread =new Thread(new BarraDeCarregamento2());
       Thread thread2 =new Thread(new BarraDeCarregamento3());
     thread.start();
     thread2.start();
        System.out.println("Nome da Thread : " + thread.getName());
        System.out.println("Nome da Thread : "+ thread2.getName());

    }

}

class GerarPDF implements  Runnable{
    @Override
    public void run(){

        System.out.println("Gerar PDF");
    }

}

class BarraDeCarregamento implements Runnable{
    @Override
    public void run(){
        System.out.println("Loading...");
    }
}
class BarraDeCarregamento2 implements   Runnable{
    @Override
   public void run(){


        try {
            Thread.sleep( 5000 );
            System.out.println("rodei -- BarraDeCarregamento2");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class BarraDeCarregamento3 implements  Runnable{
    @Override
    public void run(){


        try {
            Thread.sleep( 1000 );
            System.out.println("rodei -- BarraDeCarregamento3 ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}