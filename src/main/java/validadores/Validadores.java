/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validadores;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Cristian
 */
public class Validadores {
    

    public boolean validarContrasena(String contrasena) {

        CharSequence cadena = contrasena.trim();
        String reCadena = "[A-Za-z0-9]{8}";
        Pattern p = Pattern.compile(reCadena);
        
        Matcher matcher = p.matcher(cadena);
        
        if(matcher.matches()){
            return true;
        }
        else {
            return false;
        }
        
    
    }
    
    public boolean validarFecha(String fecha) {
         
        CharSequence cadena = fecha.trim();
        String reCadena = "^\\d{4}[/-]\\d{2}[/-]\\d{2}$";
        Pattern p = Pattern.compile(reCadena);
        
        Matcher matcher = p.matcher(cadena);
        
        if(matcher.matches()){
            return true;
        }
        else {
            return false;
        }
    }
    
    public boolean validarNumeroCasa(String numero) {
         
         CharSequence cadena = numero.trim();
        String reCadena = "[0-9]{5}";
        Pattern p = Pattern.compile(reCadena);
        
        Matcher matcher = p.matcher(cadena);
        
        if(matcher.matches()){
            return true;
        }
        else {
            return false;
        }
    }
    
    public boolean validarNombre(String nombre){
         CharSequence cadena = nombre.trim();
        String reCadena = "^[A-Za-z0-9]{2,12}(([\\s][A-Za-z0-9]{2,12})?)$";
        Pattern p = Pattern.compile(reCadena);
        
        Matcher matcher = p.matcher(cadena);
        
        if(matcher.matches()){
            return true;
        }
        else {
            return false;
        }
        
    }
    
     public boolean validaApellido(String apellido) {
         CharSequence cadena = apellido.trim();
        String reCadena = "[A-Za-z]{2,20}$";
        Pattern p = Pattern.compile(reCadena);
        
        Matcher matcher = p.matcher(cadena);
        
        if(matcher.matches()){
            return true;
        }
        else {
            return false;
        }

       
    }
     
     public boolean validaColonia(String colonia) {
         CharSequence cadena = colonia.trim();
        String reCadena = "^[A-Za-z0-9]{2,20}(([\\s][A-Za-z0-9]{2,12})?)(([\\s][A-Za-z0-9]{2,12})?)$";
        Pattern p = Pattern.compile(reCadena);
        
        Matcher matcher = p.matcher(cadena);
        
        if(matcher.matches()){
            return true;
        }
        else {
            return false;
        }

       
    }
     
      public boolean validaCalle(String calle) {
         CharSequence cadena = calle.trim();
        String reCadena = "^[A-Za-z0-9]{2,20}(([\\s][A-Za-z0-9]{2,12})?)(([\\s][A-Za-z0-9]{2,12})?)$";
        Pattern p = Pattern.compile(reCadena);
        
        Matcher matcher = p.matcher(cadena);
        
        if(matcher.matches()){
            return true;
        }
        else {
            return false;
        }

       
    }
     
     
}
