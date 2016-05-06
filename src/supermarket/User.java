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
public class User{

    private boolean authenticated;
    private String role;
    public boolean isAuthenticated(){
        return this.authenticated;
    }
    public void Authenticate(){
        this.authenticated = true;
    }
    public void LogOff(){
        this.authenticated = false;
    }

    public void setRole(String role) {
        this.role = role;
        if(role.equals("GERENTE")){
            authenticated = true;
        }
        if(role.equals("OPERADOR")){
            authenticated = true;
        }
    }
    public String getRole(){
        return role;
    }

}
