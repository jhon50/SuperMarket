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
import java.util.ArrayList;
import java.util.Scanner;
import static supermarket.GerenciadorCaixas.CAIXAS;

/**
 *
 * @author pj
 */
class Caixa {

    Scanner in = new Scanner(System.in);

    //
    //Id do caixa
    private int id;

    //
    //Usuário que possa estar utilizando o Caixa
    private final User user = new User();

    //
    //Gerenciador de Estoque
    private GerenciadorEstoque estoque = new GerenciadorEstoque();

    //
    //Lista de todas as vendas que foram realizadas
    private ArrayList<Venda> VENDAS = new ArrayList();

    //
    //Retorna se o usuário está logado
    public boolean userHasLoogedIn() {
        return (user.isAuthenticated());
    }

    //
    //Loga o usuário
    public void userLogIn(String role) {

        //Permissao que se deseja obter
        user.setRole(role);

        //Requer que o usuario insira um nome
        user.requireName();

        //O usuario autenticará
        //apenas se possuir a senha correta.
        //Cada permissao possui uma senha diferente.
        if (user.getRole() != null) {
            user.Authenticate();
        }
    }

    public void userLogOff() {
        user.LogOff();
    }

    //
    //Retorna se o usuário possui a devida permissao
    public boolean userHasRole(String role) {
        return user.getRole().equals(role);
    }

    //Define Id do caixa no qual o usuário deseja logar
    public void setIdCaixa() {
        System.out.print("Qual ID do caixa atual? ");
        this.id = in.nextInt();
    }

    public int getIdCaixa() {
        return this.id;
    }

    public User getUser() {
        return this.user;
    }

    public void adicionarProduto() {
        estoque.AdicionarProduto();
    }

    public void registrarVenda() {
        boolean registrandoVendas = true;
        double preco = 0;
        double troco = 0;
        int codigo;
        do {

            System.out.print("Digite o código: ");
            codigo = in.nextInt();

            //Tenta remover produto do estoque e retorna o produto removido
            Produto produto = estoque.removerProduto(codigo);
            if (produto != null) {
                Venda venda = new Venda(produto, id);
                //registra a venda
                VENDAS.add(venda);
                preco += produto.getValor();
            } else {
                System.out.println("Produto não encontrado!");
            }

            //Verifica se o operador já passou todos os produtos
            System.out.println("Incluir outro produto? (y/n) ");
            if (in.next().equals("n")) {
                registrandoVendas = false;
            }

            //Se o produto estiver nulo, ele nao foi encontrado no estoque
            //possivelmente acabou ou não foi registrado pelo gerente
        } while (registrandoVendas);
        System.out.println("O valor total é de: " + preco);
        System.out.println("1 - Pagamento com cartão \n2 - Pagamento com dinheiro");
        int x = in.nextInt();
        switch (x) {
            case 1:
                pagamentoCartao(preco);
                break;
            case 2:
                troco = pagamentoDinheiro(preco);
                System.out.println("O seu troco é de: " + troco);
        }
    }

    public void ExibirVendas() {
        double  total = 0;
        for (int i = 0; i < VENDAS.size(); i++) {
            System.out.println(
                    "Produto: " + VENDAS.get(i).getNomeProduto()+ " " + VENDAS.get(i).getPrecoProduto() + "    "
            );
            total += VENDAS.get(i).getPrecoProduto();
        }
        System.out.println("Total da venda: " + total);
    }

    public void ExibirProdutosEstoque() {
        estoque.ExibirEstoque();
    }

    public void pagamentoCartao(double preco) {
        System.out.println("1 - Visa  \n2 - Master");
        int x = in.nextInt();
        System.out.println("Digite a senha do cartão.");
        String senha = in.next();
        System.out.println("Transação aprovada.");
    }

    private double pagamentoDinheiro(double preco) {
        System.out.println("Digite total de dinheiro recebido.");
        double total = in.nextDouble();
        double troco = total - preco;
        return troco;
    }
}
