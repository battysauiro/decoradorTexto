/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patrondecoradortexto;

/**
 *
 * @author Oscar
 */
public class OrientacionLetraVertical extends Decorator{
    
    public OrientacionLetraVertical(Atexto i) {
        super(i);
    }
    @Override
    public void leer(String[]s){
            super.escribir(s);
    }
    
    
    @Override
    public void escribir(String[]s){
        String texto=s[0];
        for(int i=0;i<texto.length();i++){
            System.out.println(texto.charAt(i));
        }
    }
}
