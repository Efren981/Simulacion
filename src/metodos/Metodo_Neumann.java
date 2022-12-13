/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metodos;

/**
 *
 * @author efren
 */
//import java.util.Scanner;

public class Metodo_Neumann {

    
    /*public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        Metodo_Neumann me = new Metodo_Neumann();
       String semilla1=entrada.next();
        me.prueba(semilla1);

    }*/

    public void prueba(String semilla) {
        String snumero2, snumero3;
        int tam1, tam2, i, primerc;
        long numero1, numero2;
        tam1 = semilla.length();
        System.out.println("Cantidad de digitos:  " + tam1);
        numero1 = Integer.parseInt(semilla);
        for (i = 1; i <= 50; i++) {
            numero2 = (long) Math.pow(numero1, 2);
            snumero2 = Long.toString(numero2);
            tam2 = snumero2.length();
            primerc = (tam2 - tam1) / 2;
            snumero3 = snumero2.substring(primerc, primerc + tam1);
            System.out.println(i + ". " + snumero3);
            numero1 = Integer.parseInt(snumero3);
        }
    }
}
