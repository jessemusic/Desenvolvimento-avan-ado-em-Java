package fatorrecursivo;

public class FatorialRecursivo {
    public static void main(String[] args) {
        System.out.println(fatorial(4));

    }
    public static int fatorial (int value){
        if(value ==1){
            return value;
        }else {
            return value * fatorial( (value -1) );

        }
    }
}
