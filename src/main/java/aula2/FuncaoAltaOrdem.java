package aula2;

public class FuncaoAltaOrdem {
    public static void main(String[] args) {
        Calculo soma = ( a, b) -> a+b;
        Calculo sub = ( a, b) -> a-b;
        Calculo div = ( a, b) -> a/b;
        Calculo mult = ( a, b) -> a*b;

        System.out.println(execOp(soma, 1,3));// 4
        System.out.println(execOp(sub, 4,3));//1
        System.out.println(execOp(div, 15,3));// 5
        System.out.println(execOp(mult, 11,3));// 33


    }
    public static int execOp(Calculo calculo, int a, int b){
        return calculo.calculo( a,b );
    }
}
@FunctionalInterface
interface Calculo {
  public int  calculo( int a, int b);
}