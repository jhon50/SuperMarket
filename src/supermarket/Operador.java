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
public class Operador{
    private String nome;
    Scanner in = new Scanner(System.in);
    
    public Operador(){
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }

    public void requireName() {
        System.out.print("Operador, digite seu nome para iniciar sessão: ");
        nome = in.nextLine();
    }
}
