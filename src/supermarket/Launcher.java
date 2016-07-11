/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author pj
 */
public class Launcher {

    public static void start() {
        Scanner in = new Scanner(System.in);
        Launcher launcher = new Launcher();
        Caixa caixa = new Caixa();
        GerenciadorCaixas caixaManager = new GerenciadorCaixas();

        //carrega o estoque
        Estoque estoque = new Estoque();
        estoque.read();

        //inicia o gerenciamento do estoque
        GerenciadorEstoque estoqueManager = new GerenciadorEstoque(estoque);

        boolean executando_menu = true;
        boolean executando_submenu;
        do {
            String role = launcher.menu_incial(in);

            if (role != null && role != Roles.CLIENTE) {
                caixa = launcher.login(role, in);

            }

            if (caixa != null && role == (Roles.GERENTE)) {

                do {
                    executando_submenu = menu_gerente(caixa, caixaManager, estoqueManager, in);
                } while (executando_submenu);

            } else if (caixa != null && role == (Roles.OPERADOR)) {

                do {
                    executando_submenu = menu_operador(caixa, caixaManager, estoqueManager, in);
                } while (executando_submenu);
            } else if (role == (Roles.CLIENTE)) {
                System.out.println("Digite o código do produto.");
                int codigo = in.nextInt();
                
                if(estoque.verificaExistencia(codigo)) {
                    Produto produto = estoque.getProduto(codigo);
                    System.out.println("Nome: " + produto.getNome());
                    System.out.println("Valor: " + produto.getValor());
                }else{
                    System.out.println("Produto não encontrado!");
                }
            }

            if (role == null) {
                executando_menu = false;
            }

        } while (executando_menu);
    }

    private static boolean menu_gerente(Caixa caixa, GerenciadorCaixas caixaManager, GerenciadorEstoque estoqueManager, Scanner in) {
        System.out.println("**********************");
        System.out.println("");
        System.out.println("1 - Adicionar produto");
        System.out.println("2 - Exibir Estoque");
        System.out.println("3 - Exibir Relatório de Vendas");
        System.out.println("4 - Exibir Relatório de Estoque");
        System.out.println("0 - Logout como Gerente");
        System.out.println("");
        System.out.println("**********************");
        int resposta = in.nextInt();
        switch (resposta) {

            case 1:
                //GERENTE - Adicionar produto    
                caixa.adicionarProduto();
                estoqueManager.update();
                break;

            case 2:
                caixa.ExibirProdutosEstoque();
                break;

            case 3:
                caixaManager.ExibirRelatorioVendas();
                break;

            case 4:
                estoqueManager.ExibeRelatorioEstoque();
                break;

            case 0:
                caixa.userLogOff();
                return false;
        }
        return true;
    }

    private static boolean menu_operador(Caixa caixa, GerenciadorCaixas caixaManager, GerenciadorEstoque estoqueManager, Scanner in) {
        System.out.println("**********************");
        System.out.println("");
        System.out.println("1 - Registrar venda");
        System.out.println("0 - Logout como Operador");
        System.out.println("");
        System.out.println("**********************");
        int resposta = in.nextInt();
        switch (resposta) {
            case 1:
                //Inicia o caixa para passar e registrar todas
                //as compras do cliente.
                caixaManager.Add(caixa);
                caixa.registrarVenda();
                estoqueManager.update();
                break;

            case 0:
                caixa.userLogOff();
                return false;
        }
        return true;
    }

    public String menu_incial(Scanner in) {
        System.out.println("**********************");
        System.out.println("");
        System.out.println("1 - Entrar como Gerente");
        System.out.println("2 - Entrar como Operador de Caixa");
        System.out.println("3 - Verificar preço de produto");
        System.out.println("0 - Sair");
        System.out.println("");
        System.out.println("**********************");
        System.out.println("");
        System.out.println("O que deseja fazer?");
        int role = in.nextInt();
        switch (role) {

            case 1:
                return Roles.GERENTE;

            case 2:
                return Roles.OPERADOR;

            case 3:
                return Roles.CLIENTE;

            case 0:
                return null;
        }
        return null;
    }

    public Caixa login(String role, Scanner in) {
        Caixa caixa = new Caixa();
        caixa.userLogIn(role);
        if (role.equals(Roles.OPERADOR)) {
            caixa.setIdCaixa();
        }
        /*Retorna o caixa no qual o usuario está logando*/
        return caixa;
    }
}
