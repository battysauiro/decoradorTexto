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
public abstract class Decorator extends Atexto{
    
    protected Atexto buferT;
    
    public Decorator(Atexto i){
        buferT=i;
    }

    @Override
    public void escribir(String[] s) {
        buferT.escribir(s);
    }

    @Override
    public void leer(String[] s) {
        buferT.leer(s);
    }

    
}
