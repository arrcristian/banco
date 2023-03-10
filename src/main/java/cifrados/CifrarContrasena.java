/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cifrados;

/**
 *
 * @author Cristian
 */
public class CifrarContrasena {
    
    //Retorna un hash a partir de un tipo y un texto
    public static String getHash(String txt, String hashType){
        
         try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance(hashType);
            byte[] array = md.digest(txt.getBytes());
            StringBuffer sb = new StringBuffer();
            
            for (int i = 0; i < array.length; i++) {
                sb.append(Integer.toHexString((array[i] & 0xff) | 0x100).substring(1,3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    //Retorna un hash MD5 a partir de un texto
    public static String md5(String txt){
        return CifrarContrasena.getHash(txt, "MD5");
    }
    
    //Retorna un hash SHA-1 a partir de un texto
    public static String sha1(String txt){
        return CifrarContrasena.getHash(txt, "SHA1");
    }
}
