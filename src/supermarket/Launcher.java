/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author pj
 */
public class Launcher {

    public static void start() {
        Scanner in = new Scanner(System.in);
        ArrayList<Produto> produtos = new ArrayList();
        boolean exec = true;
        while (exec) {
            System.out.println("**********************");
            System.out.println("");
            System.out.println("1 - Entrar como gerente");
            System.out.println("2 - Entrar como Operador de Caixa");
            System.out.println("0 - Sair");
            System.out.println("");
            System.out.println("**********************");
            System.out.println("");
            System.out.println("O que deseja fazer?");
            int answer = in.nextInt();

            //recebe opção selecionada pelo usuário para determinar
            //seu privilégio no sistema
            User user = new User();
            switch (answer) {
                //
                //****************************
                //inicio das opções de gerente
                case 1:
                    user.setRole("GERENTE");
                    user.Authenticate();
                    while (user.isAuthenticated()) {
                        System.out.println("**********************");
                        System.out.println("");
                        System.out.println("1 - Adicionar produto");
                        System.out.println("0 - Logout como Gerente");
                        System.out.println("");
                        System.out.println("**********************");
                        int gerente_options = in.nextInt();
                        switch (gerente_options) {
                            case 1:
                                if(user.getRole().equals("GERENTE")){
                                //GERENTE - Adicionar produto    
                                GerenciadorEstoque manager = new GerenciadorEstoque();
                                manager.AdicionarProduto();
                                manager.ExibirEstoque();
                                break;
                                }
                            case 0:
                                user.LogOff();
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
                    user.setRole("OPERADOR");
                    user.Authenticate();
                    Operador operador = new Operador();
                    operador.requireName();
                    while (user.isAuthenticated() && !operador.getNome().equals("")) {
                        System.out.println("**********************");
                        System.out.println("");
                        System.out.println("1 - Remover produto");
                        System.out.println("0 - Logout como Operador");
                        System.out.println("");
                        System.out.println("**********************");
                        int operador_options = in.nextInt();
                        switch (operador_options) {
                            case 1:
                                if(user.getRole().equals("OPERADOR")){
                                GerenciadorEstoque manager = new GerenciadorEstoque();
                                manager.removerProduto();
                                manager.ExibirEstoque();
                                break;
                                }
                            case 0:
                                user.LogOff();
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
