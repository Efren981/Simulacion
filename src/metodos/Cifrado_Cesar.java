
package metodos;
public class Cifrado_Cesar {
    
    public String cifrado(String mensaje){
        String cifrado="";
        int adelantar=3;
        char []letras=mensaje.toCharArray();
        
        for(int i=0;i<letras.length;i++){
            cifrado+=(char)( ((int) letras[i])+adelantar);
        }
        return cifrado;
    }
    
    public String decifrar_Cesar(String cifrado){
        String mensaje="";
        int atrasar=3;
        char []letras=cifrado.toCharArray();
        
        for(int i=0;i<letras.length;i++){
            mensaje+=(char)( ((int) letras[i])-atrasar);
        }
        return mensaje;
    }
}
