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

    public static void start() throws IOException, FileNotFoundException, ClassNotFoundException {
        menu_incial();
    }

    private static void menu_incial() throws IOException, FileNotFoundException, ClassNotFoundException {
        Scanner in = new Scanner(System.in);

        boolean exec;
        do {
            int answer = gerar_opcoes(in);
            exec = menu_secundario(answer, in);
        } while (exec);
    }

    private static int gerar_opcoes(Scanner in) {
        System.out.println("**********************");
        System.out.println("");
        System.out.println("1 - Entrar como Gerente");
        System.out.println("2 - Entrar como Operador de Caixa");
        System.out.println("0 - Sair");
        System.out.println("");
        System.out.println("**********************");
        System.out.println("");
        System.out.println("O que deseja fazer?");
        return in.nextInt();
    }

    private static boolean menu_secundario(int answer, Scanner in) throws IOException, FileNotFoundException, ClassNotFoundException {
        Caixa caixa = new Caixa();
        GerenciadorCaixas gerenciador_caixas = new GerenciadorCaixas();
        int opcao_escolhida;
        switch (answer) {
            //
            //****************************
            //inicio das opções de gerente
            case 1:
                //Seta Usuario com permissao de GERENTE
                caixa.userLogIn(Roles.GERENTE);
                while (caixa.userHasLoogedIn()) {
                    opcao_escolhida = gerar_opcoes_gerente(in);
                    gerente_logado(opcao_escolhida, caixa, gerenciador_caixas);
                }
                break;
            //fim das opções de gerente
            //*************************************
            //   
            //*************************************    
            //inicio das opções de operador de caixa    
            case 2:
                caixa.userLogIn(Roles.OPERADOR);
                caixa.setIdCaixa();
                while (caixa.userHasLoogedIn()) {
                    opcao_escolhida = gerar_opcoes_operador(in);
                    operador_logado(opcao_escolhida, caixa);
                }
                gerenciador_caixas.Add(caixa);
                break;
            //fim das operações de operador de caixa
            //**************************************
            //    
            //
            //**************************************    
            //Finaliza sessão
            case 0:
                return false;
        }
        return true;
    }

    private static int gerar_opcoes_gerente(Scanner in) {
        System.out.println("**********************");
        System.out.println("");
        System.out.println("1 - Adicionar produto");
        System.out.println("2 - Exibir Estoque");
        System.out.println("3 - Exibir Relatório de Vendas");
        System.out.println("0 - Logout como Gerente");
        System.out.println("");
        System.out.println("**********************");
        return in.nextInt();
    }

    private static int gerar_opcoes_operador(Scanner in) {
        System.out.println("**********************");
        System.out.println("");
        System.out.println("1 - Registrar venda");
        System.out.println("0 - Logout como Operador");
        System.out.println("");
        System.out.println("**********************");
        return in.nextInt();
    }

    private static void gerente_logado(int gerente_option, Caixa caixa, GerenciadorCaixas gerenciador_caixas) throws IOException, FileNotFoundException, ClassNotFoundException {
        switch (gerente_option) {

            case 1:
                //GERENTE - Adicionar produto    
                caixa.adicionarProduto();
                break;
            
            case 2:
                caixa.ExibirProdutosEstoque();
                break;    
    
            case 3:
                gerenciador_caixas.ExibirRelatorioVendas();
                break;
            
            case 0:
                caixa.userLogOff();
                break;
        }
    }

    private static void operador_logado(int opcao_escolhida, Caixa caixa) throws IOException, FileNotFoundException, ClassNotFoundException {
        switch (opcao_escolhida) {
            case 1:

                //Inicia o caixa para passar e registrar todas
                //as compras do cliente.
                caixa.registrarVenda();
                break;
            
            case 0:
                caixa.userLogOff();
                break;
        }
    }
}
