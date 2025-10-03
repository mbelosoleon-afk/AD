package Práctica3;

import java.io.Serializable;

public class Producto implements Serializable {
    private String nome;
    private int num1;
    private double num2;

    public Producto(String nome, int num1, double num2) {
        this.nome = nome;
        this.num1 = num1;
        this.num2 = num2;

    }
}
