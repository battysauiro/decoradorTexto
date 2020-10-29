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
public class PatronDecoradorTexto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String linea[]={new String()};
        Atexto tb=new TextoBase();
        tb.leer(linea);
        Atexto autenticar =new Autenticar(tb);
        autenticar.escribir(linea);
        autenticar.leer(linea);
        Atexto encriptar=new EncriptarDesencriptar(tb);
        encriptar.escribir(linea);
        encriptar.leer(linea);
        Atexto orientacion=new OrientacionLetraVertical(tb);
        orientacion.escribir(linea);
        orientacion.leer(linea);
        
    }
    
}
