/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 *
 * @author pj
 */
public class User {

    private boolean authenticated = false;
    private String role = null;
    private String nome;
    Scanner in = new Scanner(System.in);

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public boolean isAuthenticated() {
        return this.authenticated;
    }

    //autentica o usuario
    //caso possua devidos privilegios
    public void Authenticate() {
        String passwordHash = "";
        switch(role){
            
            case Roles.GERENTE:
                passwordHash = Passwords.GERENTE_PASSWORD;
                break;
                
            case Roles.OPERADOR:
                passwordHash = Passwords.OPERADOR_PASSWORD;
                break;
                
        }
        while(!authenticated){
            System.out.print("Digite sua senha: ");
            String password = in.nextLine();
            
            //se a senha estiver correta será autenticado
            if (calculateMD5(password).equals(passwordHash)) {
                this.authenticated = true;
            }
            else
            {
                System.out.println("Senha Incorreta!\nDeseja tentar novamente? (y/n) ");
                if (in.nextLine().equals("n")){ break; }
            }
        }
    }

    public void LogOff() {
        this.authenticated = false;
    }

    //
    //Define a permissão do usuário
    public void setRole(String role) {
          this.role = role;
    }
    
    public String getRole() {
        return role;
    }
    
     //
    //Pede o nome do usuario que está logando
    public void requireName() {
        System.out.print("Digite seu nome para iniciar sessão: ");
        this.nome = in.nextLine();
    }

    public String calculateMD5(String string) {
        StringBuilder result = new StringBuilder();
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(string.getBytes("UTF8"));

            byte s[] = m.digest();

            for (int i = 0; i < s.length; i++) {
                result.append(Integer.toHexString((0x000000ff & s[i]) | 0xffffff00).substring(6));
            }
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("Password hash is unsupported.", e);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("Password hash is unsupported.", e);
        }
        return result.toString();
    }
}
