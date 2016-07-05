/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import java.io.Serializable;

/**
 *
 * @author pj
 */
public class Produto implements Serializable {

    private int codigo;
    private String nome;
    private double valor;
    private int quantidade;

    public Produto(int codigo, String nome, double valor, int quantidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
    }
    
    public int getCodigo(){
        return this.codigo;
    }
    
    public String getNome(){
        return this.nome;
    }    
   
    public double getValor(){
        return this.valor;
    }
    
    public int getQuantidade(){
        return this.quantidade;
    }
    
    public void diminuiQuantidade(){
        this.quantidade -= 1;
    }
    
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }
}
