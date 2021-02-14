package Aula3.aula3a;

public class ThreadsExemplos2 {
    public static void main(String[] args) {
        GeradorPDF iniciarGerarPdf = new GeradorPDF();
        BarraDeCarregamento iniciarBarraDeCarregamento = new BarraDeCarregamento(iniciarGerarPdf);
        iniciarGerarPdf.start();
       iniciarBarraDeCarregamento.start();
    }

}

class GeradorPDF extends   Thread{
    @Override
    public void run(){
        try {
            System.out.println("Iniciando!..");
            Thread.sleep( 5000 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("PDF foi gerado com sucesso!");
    }

}

class BarraDeCarregamento extends Thread{
    private Thread iniciarGeradorPdf;

    public BarraDeCarregamento(Thread inciarGeradorPdf) {
        this.iniciarGeradorPdf = inciarGeradorPdf;
    }
     @Override
     public void run(){


            while (true){
                try {
                    Thread.sleep( 500 );
                    if (!iniciarGeradorPdf.isAlive()){
                        break;
                    }
                    System.out.println("Loading...");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

    }
}
