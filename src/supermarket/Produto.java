/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

/**
 *
 * @author pj
 */
public class Produto {

    private int codigo;
    private String nome;
    private double valor;

    public Produto(int codigo, String nome, double valor) {
        this.codigo = codigo;
        this.nome = nome;
        this.valor = valor;
    }
    
    public int getCodigo(){
        return this.codigo;
    }
}
