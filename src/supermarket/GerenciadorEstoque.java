/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author pj
 */
public class GerenciadorEstoque extends Estoque {
    Estoque estoque = new Estoque();
    private List<Produto> estoqueAfter;
    private List<Produto> estoqueBefore;
    
    public GerenciadorEstoque(){
    }
    public GerenciadorEstoque(Estoque estoque){
        this.estoque = estoque;
        estoqueAfter = estoque.getEstoque();
        estoqueBefore = estoque.getEstoque();
    }
    
    public void update() {
        estoque.read();
        estoqueAfter = estoque.getEstoque();
    }
    
    public void ExibeRelatorioEstoque() {
        System.out.println("Inicio do dia");
        estoqueBefore.stream().forEach((item) -> {
            System.out.println(item.getNome() + " " + item.getQuantidade());
        });
        System.out.println("------------------");
        System.out.println("------------------");
        System.out.println("Fim do dia");
        estoqueAfter.stream().forEach((item) -> {
            System.out.println(item.getNome() + " " + item.getQuantidade());
        });
    }
}
