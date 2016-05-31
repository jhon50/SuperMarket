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
import java.io.Serializable;
import static java.lang.System.in;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pj
 */
public class Estoque {

    public static ArrayList<Produto> produtos = new ArrayList();

    FileOutputStream fos;

    String fileName = "estoque";

    public void save() {
        try {
            FileOutputStream fout = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(produtos);
            fout.close();

        }catch(FileNotFoundException ex){
            System.out.println("Arquivo não encontrado!");
        }catch(IOException ex){
            System.out.println("Erro ao tentar abrir o arquivo.");
        }
    }

    public void read() {
        try {
            FileInputStream fin = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fin);
            produtos = (ArrayList<Produto>) ois.readObject();
            fin.close();
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        } catch (ClassNotFoundException ex) {

        }

    }

}
