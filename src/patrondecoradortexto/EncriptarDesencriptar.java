/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patrondecoradortexto;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static patrondecoradortexto.Atexto.bufer;

/**
 *
 * @author Oscar
 */
public class EncriptarDesencriptar extends Decorator{
    private int tipo; 
    private String texto;
    public EncriptarDesencriptar(Atexto i) {
        super(i);
    }
    
    @Override
    public void leer(String[]s){
        texto=s[0];
        System.out.print("ingrese el numero de tipo de desencriptacion RAS:1 AES:2 :");
        try {
            tipo=Integer.parseInt(bufer.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if(tipo==1){
                EcriptacionRSA des= new EcriptacionRSA(texto);
                String []aux={des.desencriptar()};
                super.escribir(aux);
            }
            else if(tipo==2){
                EncriptacionAES des= new EncriptacionAES(texto);
                String []aux={des.desencriptar()};
                super.escribir(aux);
            }
            } catch (Exception ex) {
                Logger.getLogger(EncriptarDesencriptar.class.getName()).log(Level.SEVERE, null, ex);
            }     
    }
    
    @Override
    public void escribir(String[]s){
        System.out.print("ingrese el numero de tipo de encriptacion RAS:1 AES:2 :");
        String text=s[0];
        try {
            tipo=Integer.parseInt(bufer.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        try {
            if(tipo==1){
                EcriptacionRSA des= new EcriptacionRSA(text);
               des.encriptar();
            }
            else if(tipo==2){
                EncriptacionAES des= new EncriptacionAES(text);
                des.encriptar();
            }
            } catch (Exception ex) {
                Logger.getLogger(EncriptarDesencriptar.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
