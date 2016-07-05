/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import static java.lang.System.in;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pj
 */
public class Estoque {

    ArrayList<Produto> produtos = new ArrayList();
    Scanner in = new Scanner(System.in);

    FileOutputStream fos;

    String fileName = "estoque";

    public void save() {
        try {
            FileOutputStream fout = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(produtos);
            fout.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado!");
        } catch (IOException ex) {
            System.out.println("Erro ao tentar abrir o arquivo.");
        }
    }

    public void read() {
        try {
            FileInputStream fin = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fin);
            produtos = (ArrayList<Produto>) ois.readObject();
            fin.close();
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        } catch (ClassNotFoundException ex) {

        }

    }

    public void AdicionarProduto() {
        read();

        System.out.println("Insira as informações do produto que deseja adicionar");

        System.out.print("Insira o código: ");
        int codigo = in.nextInt();

        System.out.print("Insira o Nome: ");
        String nome = in.next();

        System.out.print("Insira o valor: ");
        double valor = in.nextDouble();

        System.out.print("Insira a quantidade: ");
        int quantidade = in.nextInt();

        boolean present = verificaExistencia(codigo, produtos);
        Produto produto = new Produto(codigo, nome, valor, quantidade);
        if(present){
            for (int i = 0; i < produtos.size(); i++) {
                if(produtos.get(i).getCodigo() == codigo){
                    int amountBefore = produtos.get(i).getQuantidade();
                    int newAmount = amountBefore + quantidade;
                    produto.setQuantidade(newAmount);
                    produtos.set(i, produto);
                    save();
                }
            }
        }else{
            produtos.add(produto);
            save();
        }
        

    }

    public Produto removerProduto(int codigo) {
        Estoque estoque = new Estoque();
        estoque.read();
        for (int i = 0; i < produtos.size(); i++) {
            Produto candidato = produtos.get(i);
            if (candidato.getCodigo() == codigo) {
                if (candidato.getQuantidade() > 0) {
                    candidato.diminuiQuantidade();
                    //retorna o produto que foi removido
                    estoque.save();
                    return candidato;
                }
            }
        }
        //Neste ponto o produto não foi encontrado 
        return null;
    }

    public void ExibirEstoque() {
        read();
        System.out.println("Produtos no estoque: ");
        System.out.println("========================");
        produtos.stream().forEach((item) -> {
            System.out.println(
                    "Código: " + item.getCodigo() + "   "
                    + "Nome: " + item.getNome() + "   "
                    + "Valor: " + item.getValor() + "  "
                    + "Quantidade: " + item.getQuantidade()
            );
        });
        System.out.println("========================\n");
    }

    private boolean verificaExistencia(int codigo, ArrayList<Produto> produtos) {
        for (int i = 0; i < produtos.size(); i++) {
            if(produtos.get(i).getCodigo() == codigo){
                return true;
            }
        }
        return false;
    }

}
