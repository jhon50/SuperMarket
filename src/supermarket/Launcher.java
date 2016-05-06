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
            switch (answer) {
                //
                //****************************
                //inicio das opções de gerente
                case 1:
                    boolean gerenteLogado = true;
                    while (gerenteLogado) {
                        System.out.println("**********************");
                        System.out.println("");
                        System.out.println("1 - Adicionar produto");
                        System.out.println("0 - Logout como Gerente");
                        System.out.println("");
                        System.out.println("**********************");
                        int gerente_options = in.nextInt();
                        switch (gerente_options) {
                            case 1:
                                User user = new User();
                                user.setRole("GERENTE");
                                if(user.isAuthenticated()){
                                    GerenciadorEstoque manager = new GerenciadorEstoque();
                                    manager.AdicionarProduto();
                                    manager.ExibirEstoque();
                                }
                                break;
                            case 0:
                                gerenteLogado = false;
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
