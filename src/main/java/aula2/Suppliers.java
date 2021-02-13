package aula2;

import java.util.function.Supplier;

public class Suppliers {//supridores
    public static void main(String[] args) {
        Supplier<Pessoa> supplier = () -> new Pessoa();
        Supplier<Pessoa> supplier2 = Pessoa::new;
        System.out.println(supplier.get());
        System.out.println(supplier2.get());
    }
}

class Pessoa {
    private String nome;
    private Integer idade;

    public  Pessoa(){
        nome = "Jesse";
        idade = 28;
    }

    @Override
    public String toString(){
        return String.format( "nome : %s, idade: %d",nome,idade );
    }
}