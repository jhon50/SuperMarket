/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import java.util.Scanner;

/**
 *
 * @author pj
 */
public class GerenciadorEstoque extends Estoque {
    Scanner in = new Scanner(System.in);
     public void AdicionarProduto() {
        System.out.println("Insira as informações do produto que deseja adicionar");
        
        System.out.print("Insira o código: ");
        int codigo = in.nextInt();
        
        System.out.print("Insira o Nome: ");
        String nome = in.next();
        
        System.out.print("Insira o valor: ");
        double valor = in.nextDouble();
        
        Produto produto = new Produto(codigo, nome, valor);
        produtos.add(produto);
    }
     public void removerProduto(){
         System.out.print("Digite o código do produto a ser removido: ");
         int codigo = in.nextInt();
         for (int i = 0; i < produtos.size(); i++) {
              Produto testador = produtos.get(i);
              if(codigo == testador.getCodigo()){
                  produtos.remove(i);
              }
         }
     }
     public void ExibirEstoque(){
        System.out.println(produtos);
    }
    
}
