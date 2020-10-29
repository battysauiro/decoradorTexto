/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patrondecoradortexto;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Oscar
 */
public class EncriptacionAES implements Encriptacion{
    private String texto;
    private Cipher aes;
    private byte[] encriptado;
    // Generamos una clave de 128 bits adecuada para AES
      KeyGenerator keyGenerator;
      Key key ;
      public EncriptacionAES(String texto) throws NoSuchAlgorithmException, NoSuchPaddingException{
        this.texto=texto;
        keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        key = keyGenerator.generateKey();
        key = new SecretKeySpec("una clave de 16 bytes".getBytes(),  0, 16, "AES");
        aes = Cipher.getInstance("AES/ECB/PKCS5Padding");
      }
    @Override
    public void encriptar() throws Exception {
      aes.init(Cipher.ENCRYPT_MODE, key);
      encriptado = aes.doFinal(texto.getBytes());
      System.out.println("el texto fue encriptado ");
      for (byte b : encriptado) {
         System.out.print(Integer.toHexString(0xFF & b));
      }
      System.out.println("");
    }

    @Override
    public String desencriptar() throws Exception {
      aes.init(Cipher.ENCRYPT_MODE, key);
      encriptado = aes.doFinal(texto.getBytes());
      aes.init(Cipher.DECRYPT_MODE, key);
      byte[] desencriptado = aes.doFinal(encriptado);
      texto = new String(desencriptado);
      System.out.println("el texto fue desencriptado ");
      return texto;
    }
    
}
