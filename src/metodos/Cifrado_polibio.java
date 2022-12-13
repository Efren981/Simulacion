/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodos;

/**
 *
 * @author efren
 */
import java.util.Scanner;

public class Cifrado_polibio {

    /*public static void main(String[] args) {
        // TODO Auto-generated method stub

        char[][] matris = {{'a', 'b', 'c', 'd', 'e', 'f', 'g'},
        {'h', 'i', 'j', 'k', 'l', 'm', 'n'},
        {'ñ', 'o', 'p', 'q', 'r', 's', 't'},
        {'u', 'v', 'w', 'x', 'y', 'z', '1'},
        {'2', '3', '4', '5', '6', '7', '8'},
        {'9', '0', '_', '-', ' ', '.', ','},
        {'$', '#', '%', '&', '+', '*', '/'}};

        System.out.println("\t   ---------------------");
        System.out.println("\t  | *  CIFRADO POLIBIO * |");
        System.out.println("\t   ---------------------");
        Scanner sc = new Scanner(System.in);
        //Imprimir(matris);
        System.out.println("Ingrese el Mensaje: ");
        String mensaje = sc.nextLine();
        System.out.println("\nMatriz");
        
        System.out.print("\nCifrado: ");
        String[] cipher = Cifrar_Polibio(mensaje, matris);
        sc.close();
        System.out.print("\nDescifrado: ");
       //String msj = Descifrar_Polibio(cipher, matris);

    }*/
    
    public String Imprimir(char[][] matris){
        String acumulador="";
        for (int i = 0; i < matris.length; i++) {

            for (int j = 0; j < matris[i].length; j++) {
                acumulador+=matris[i][j]+" ";
                
            }
            acumulador+="\n\t                    ";
        }
        return acumulador;
    }
    
    public String imprimir_mensajes(String[]cipher){
        String acumulador="";
        for (int i = 0; i < cipher.length; i++) {
            acumulador+=cipher[i]+" ";
        }
        return acumulador;
    }

    /*public void Imprimir(char[][] matris) {
        for (int i = 0; i < matris.length; i++) {

            for (int j = 0; j < matris[i].length; j++) {

                System.out.print(matris[i][j] + " ");
            }
            System.out.println("");
        }
    }*/

    public static String[] Cifrar_Polibio(String mensaje, char[][] matris) {

        //Se crea un array de el tamaño del mensaje ingresado
        String[] cipher = new String[mensaje.toCharArray().length];

        //Se convierte el mensaje en un array de char
        char[] msj = mensaje.toCharArray();

        //Va por todas las letras del mensaje
        for (int h = 0; h < msj.length; h++) {

            //Va por todas las filas y columnas de la matriz
            //Hasta encontrar el caracter
            for (int i = 0; i < matris.length; i++) {

                for (int j = 0; j < matris[1].length; j++) {

                    //Si lo encuentra
                    if (matris[i][j] == msj[h]) {

                        //Guarda en nuestro array cipher las posiciones
                        //de el caracter i para las filas y j para las columnas
                        cipher[h] = Integer.toString(i) + Integer.toString(j);

                        //sale del ciclo apenas lo encuentra
                        break;
                    }
                }
            }
            // Va imprimiendo el cipher (mensaje ya cifrado)
           // System.out.print(cipher[h] + " ");
        }
        //Retorna el cipher
        return cipher;

    }

    public String Descifrar_Polibio(String[] cipher, char[][] matris) {

        //Un array con la direccion de el caracter [fila][columna]
        char[] direccion;
        String mensaje = "";
        //
        //Vamos por todas las posiciones del cipher
        for (int i = 0; i < cipher.length; i++) {
            //Convertimos la direccion en un array de char
            direccion = cipher[i].toCharArray();

            // sabemos que en la posicion 0 esta la fila y en la posicion 1 esta la columna
            //buscamos en la matriz el caracter que este en esa posicion y lo vamos concatenando al mensaje normal
            mensaje += matris[Character.getNumericValue(direccion[0])][Character.getNumericValue(direccion[1])];

        }
        //Imprime el mensaje ya descifrado
        //System.out.println(mensaje);

        //Retorna el mensaje
        return mensaje;
    }
}
