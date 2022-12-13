/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodos;

/**
 *
 * @author efren
 */

public class cifrado_Simulacion {
    
    public String cifrado(String mensaje){
        String cifrado="";
        int adelantar=6;
        char []letras=mensaje.toCharArray();
        
        for(int i=0;i<letras.length;i++){
            cifrado+=(char)( ((int) letras[i])+adelantar);
        }
        return cifrado;
    }
    
    public byte[] hexadecimal(String mensaje){
            //convertir la cadena obtenida a hexadecimal(primero se converte a un arreglo de bytes)
        String hex=cifrado(mensaje);
        byte []cadena=new byte[hex.length()];
        for(int i=0;i<cadena.length;i++){
            cadena[i]=(byte)hex.charAt(i);
        }
        return cadena;
    }
    
    public String decifrar_mensaje(String cifrado){
        String mensaje="";
        int atrasar=6;
        char []letras=cifrado.toCharArray();
        
        for(int i=0;i<letras.length;i++){
            mensaje+=(char)( ((int) letras[i])-atrasar);
        }
        return mensaje;
    }
}
