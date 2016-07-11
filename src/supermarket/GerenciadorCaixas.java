/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pj
 */
public class GerenciadorCaixas {
    //
    //Lista de todos os caixas
    public static ArrayList<Caixa> CAIXAS = new ArrayList();
    
    public void Add(Caixa caixa) {
        CAIXAS.add(caixa);
    } 
    
     //falta incluir o total da venda
    public void ExibirRelatorioVendas() {
        System.out.println("Relatório de vendas: ");
        CAIXAS.stream().forEach((item) -> {
          System.out.println("========================"); 
                System.out.println("Caixa: " + item.getIdCaixa());
                System.out.println("Operador: " + item.getUser().getNome());
                item.ExibirVendas();
                System.out.println();
           System.out.println("========================");
        });
        
    }
}
