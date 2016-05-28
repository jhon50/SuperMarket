/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author pj
 */
class Caixa {
    
    Scanner in = new Scanner(System.in);
    
    //
    //Usuário que possa estar utilizando o Caixa
    private final User user = new User();
 

    //
    //Lista de todas as vendas que foram realizadas
    private static final ArrayList<Venda> VENDAS = new ArrayList();

    
    //
    //Retorna se o usuário está logado
    public boolean userHasLoogedIn(){
        return ( user.isAuthenticated() );
    }
    
    //
    //Loga o usuário
    public void userLogIn(String role){
        
        //Permissao que se deseja obter
        user.setRole(role);
        
        
        //Requer que o usuario insira um nome
        user.requireName();
        
        //O usuario autenticará
        //apenas se possuir a senha correta.
        //Cada permissao possui uma senha diferente.
        if(user.getRole() != null){
            user.Authenticate();    
        } 
    }
    
    public void userLogOff(){
        user.LogOff();
    }
    
    //
    //Retorna se o usuário possui a devida permissao
    public boolean userHasRole(String role){
        return user.getRole().equals(role);
    }
}
