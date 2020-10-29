/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patrondecoradortexto;

import java.io.IOException;

/**
 *
 * @author Oscar
 */
public class Autenticar extends Decorator{
    private String password="";
    private String p="";
    
    public Autenticar(Atexto inner){
        super(inner);
    }
    
    @Override
    public void leer(String[]s){
        System.out.print("DAR PASSWORD:");
        try {
            p=bufer.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(p.equals(password)){
            super.escribir(s);
        }
        else{
            System.out.print("PASSWORD INCORRECTO: ");
        }
    }
    
    @Override
    public void escribir(String[]s){
        System.out.print("Escribir el password: ");
        try {
           password=bufer.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
      
}
