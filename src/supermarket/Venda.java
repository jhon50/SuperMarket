/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

/**
 *
 * @author pj
 */
public class Venda{
    
    //
    //Produto que foi vendido
    private Produto produto;
    
    //
    //Usuário que realizou a venda
    private User user;
    
    public Venda (Produto produto, User user){
        this.produto = produto;
        this.user = user;
    }
    
    public Produto getProduto(){
        return this.produto;
    }
    
    public String getVendedor(){
        return this.user.getNome();
    }
}
