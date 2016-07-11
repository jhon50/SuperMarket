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
    //Id do caixa no qual a venda foi realizada
    private int idCaixa;
    
    public Venda (Produto produto, int idCaixa){
        this.produto = produto;
        this.idCaixa = idCaixa;
    }
    
    public String getNomeProduto(){
        return produto.getNome();
    }
    
    public double getPrecoProduto(){
        return produto.getValor();
    }
    
    public int getIdCaixa(){
        return idCaixa;
    }
}
