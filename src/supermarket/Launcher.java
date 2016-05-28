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
public class Launcher {

    public static void start() {
        Scanner in = new Scanner(System.in);
        boolean exec = true;
        while (exec) {
            System.out.println("**********************");
            System.out.println("");
            System.out.println("1 - Entrar como Gerente");
            System.out.println("2 - Entrar como Operador de Caixa");
            System.out.println("0 - Sair");
            System.out.println("");
            System.out.println("**********************");
            System.out.println("");
            System.out.println("O que deseja fazer?");
            int answer = in.nextInt();
        
            //recebe opção selecionada pelo usuário para determinar
            //seu privilégio no sistema
            Caixa caixa = new Caixa();
            switch (answer) {
                //
                //****************************
                //inicio das opções de gerente
                case 1:
                    //Seta Usuario com permissao de GERENTE
                    caixa.userLogIn(Roles.GERENTE);
                    while (caixa.userHasLoogedIn()) {
                        System.out.println("**********************");
                        System.out.println("");
                        System.out.println("1 - Adicionar produto");
                        System.out.println("0 - Logout como Gerente");
                        System.out.println("");
                        System.out.println("**********************");
                        int gerente_options = in.nextInt();
                        switch (gerente_options) {
                            
                            case 1:
                                //GERENTE - Adicionar produto    
                                GerenciadorEstoque manager = new GerenciadorEstoque();
                                manager.AdicionarProduto();
                                manager.ExibirEstoque();
                                break;
                                
                            case 0:
                                caixa.userLogOff();
                                break;
                        }
                    }
                    break;
                //fim das opções de gerente
                //*************************************
                //   
                //*************************************    
                //inicio das opções de operador de caixa    
                case 2:
                    caixa.userLogIn(Roles.OPERADOR);
                    while (caixa.userHasLoogedIn()) {
                        System.out.println("**********************");
                        System.out.println("");
                        System.out.println("1 - Remover produto");
                        System.out.println("0 - Logout como Operador");
                        System.out.println("");
                        System.out.println("**********************");
                        int operador_options = in.nextInt();
                        switch (operador_options) {
                            case 1:
                                GerenciadorEstoque manager = new GerenciadorEstoque();
                                manager.removerProduto();
                                manager.ExibirEstoque();
                                break;
                                
                            case 0:
                                caixa.userLogOff();
                                break;
                        }
                    }
                    break;
                //fim das operações de operador de caixa
                //**************************************
                //    
                //
                //**************************************    
                //Finaliza sessão
                case 0:
                    exec = false;
                    break;
            }
        }
    }
}
