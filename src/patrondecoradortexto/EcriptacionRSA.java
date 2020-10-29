/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patrondecoradortexto;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/**
 *
 * @author Oscar
 */
public class EcriptacionRSA implements Encriptacion{
    private String texto;
    private  static Cipher rsa;
    KeyPairGenerator keyPairGenerator ;
    KeyPair keyPair;
    PublicKey publicKey;
    PrivateKey privateKey;
    private  byte[] encriptado;
    public EcriptacionRSA(String texto) throws NoSuchAlgorithmException, Exception{
        keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPair = keyPairGenerator.generateKeyPair();
        publicKey = keyPair.getPublic();
        privateKey = keyPair.getPrivate();
        saveKey(publicKey, "publickey.dat");
        publicKey = loadPublicKey("publickey.dat");

        // Se salva y recupera de fichero la clave privada
        saveKey(privateKey, "privatekey.dat");
        privateKey = loadPrivateKey("privatekey.dat");

        // Obtener la clase para encriptar/desencriptar
        rsa = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        
        this.texto=texto;
        
    }
    @Override
    public void encriptar()throws Exception {
        // Se encripta
        rsa.init(Cipher.ENCRYPT_MODE, publicKey);
        encriptado = rsa.doFinal(texto.getBytes());

      // Escribimos el encriptado para verlo, con caracteres visibles
      System.out.println("el texto se encripto");
      for (byte b : encriptado) {
         System.out.print(Integer.toHexString(0xFF & b));
      }
        System.out.println("el texto fue encriptado ");
        System.out.println("");
    }

    @Override
    public String desencriptar() throws Exception{
        // Se encripta
        rsa.init(Cipher.ENCRYPT_MODE, publicKey);
        encriptado = rsa.doFinal(texto.getBytes());
        rsa.init(Cipher.DECRYPT_MODE, privateKey);
        
      byte[] bytesDesencriptados = rsa.doFinal(encriptado);
      texto = new String(bytesDesencriptados);
      // Se escribe el texto desencriptado
      System.out.println("el texto fue desencriptado ");
      return texto;
    }
    
    private  PublicKey loadPublicKey(String fileName) throws Exception {
      FileInputStream fis = new FileInputStream(fileName);
      int numBtyes = fis.available();
      byte[] bytes = new byte[numBtyes];
      fis.read(bytes);
      fis.close();

      KeyFactory keyFactory = KeyFactory.getInstance("RSA");
      KeySpec keySpec = new X509EncodedKeySpec(bytes);
      PublicKey keyFromBytes = keyFactory.generatePublic(keySpec);
      return keyFromBytes;
   }

   private  PrivateKey loadPrivateKey(String fileName) throws Exception {
      FileInputStream fis = new FileInputStream(fileName);
      int numBtyes = fis.available();
      byte[] bytes = new byte[numBtyes];
      fis.read(bytes);
      fis.close();

      KeyFactory keyFactory = KeyFactory.getInstance("RSA");
      KeySpec keySpec = new PKCS8EncodedKeySpec(bytes);
      PrivateKey keyFromBytes = keyFactory.generatePrivate(keySpec);
      return keyFromBytes;
   }

   private void saveKey(Key key, String fileName) throws Exception {
      byte[] publicKeyBytes = key.getEncoded();
      FileOutputStream fos = new FileOutputStream(fileName);
      fos.write(publicKeyBytes);
      fos.close();
   }
    
}
   
//----------------------------------------


     

   
    

