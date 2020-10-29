/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patrondecoradortexto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Oscar
 */
public class TextoBase extends Atexto{
    
    public TextoBase(){
        bufer=new BufferedReader(new InputStreamReader(System.in));
    }
    
    @Override
    public void escribir(String[]s) {
        System.out.println("El texto es: "+s[0]);
    }

    @Override
    public void leer(String[]s) {
        System.out.print("Introduce texto:  ");
        try {
            s[0]=bufer.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
