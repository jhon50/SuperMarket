/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import java.io.Serializable;

/**
 *
 * @author pj
 */
public class Venda {
    
    //
    //Produto que foi vendido
    private Produto produto;
    
    //
    //Usuário que realizou a venda
    private User user;
    
    //
    //Id do caixa no qual a venda foi realizada
    private int idCaixa;
    
    public Venda (Produto produto, User user, int idCaixa){
        this.produto = produto;
        this.user = user;
        this.idCaixa = idCaixa;
    }
    
    public String getNomeProduto(){
        return produto.getNome();
    }
    
    public String getVendedor(){
        return user.getNome();
    }
    
    public int getIdCaixa(){
        return idCaixa;
    }
}
