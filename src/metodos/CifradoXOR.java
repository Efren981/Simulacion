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
public class CifradoXOR {
   /* public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
			System.out.println("\t   ------------------");
			System.out.println("\t  | *  CIFRADO XOR * |");
			System.out.println("\t   ------------------");

			System.out.println("Ingrese el Mensaje: ");
			String mensaje  = sc.nextLine();
			System.out.println("Ingrese clave");
			String clave = sc.nextLine();
			
			//Se convierte el mensaje a array de binarios
			String [] mensajeB = TextoABinario(mensaje);
			String [] claveB = TextoABinario(clave);
	
			
			System.out.println("");
			System.out.println("Mensaje: "+mensaje);
			System.out.println("Clave: "+clave);
			System.out.println("");

		sc.close();
		System.out.println("-------------------------------------------------------");
		System.out.println("\t\t* Cifrando *");
		System.out.println("-------------------------------------------------------");
		
		//Se manda a cifrar
		String [] resultado = Cifrado_Descifrado_XOR(mensajeB,claveB);

		
		//Imprimir(mensajeB);
	
		System.out.print(": <-- bytes del mensaje");

		System.out.println("");
		
		//Imprimir(claveB);
		System.out.print(": <-- bytes de clave");
		
		System.out.println("\n-------------------------------------------------------");
		
		//Imprimir(resultado);
		System.out.print(": <-- bytes de cipher");
		
		System.out.println("\n-------------------------------------------------------");
		System.out.print(" - Mensaje Cifrado: ");
		System.out.print(BinarioATexto(resultado));
		System.out.println("\n-------------------------------------------------------");
		System.out.println("\t\t* Descifrando *");
		System.out.println("-------------------------------------------------------");
		
		//Se manda a descifrar;
		String[] resultado2 = Cifrado_Descifrado_XOR(resultado,claveB);

	
	//Imprimir(resultado);
	System.out.print(": <-- bytes del cipher");

	System.out.println("");
	//Imprimir(claveB);
	
	System.out.print(": <-- bytes de clave");
	System.out.println("\n-------------------------------------------------------");
	
	//Imprimir(resultado2);
	System.out.println(": <-- bytes del mensaje desencriptado");
	System.out.println("\n-------------------------------------------------------");
	System.out.print(" - Mensaje Descrifrado: ");
	System.out.print(BinarioATexto(resultado2));
	System.out.println("\n-------------------------------------------------------");
	}*/
	
	public static String CompuertaXOR (String binario1 , String binario2){
		
		char [] operando1 = binario1.toCharArray();
		char [] operando2 = binario2.toCharArray();
		char [] r =new char [operando1.length];
		
	for(int i=0;i<operando1.length ;i++){
		
		
		if(operando1[i]!=operando2[i]){
				r [i]='1';
			}else {
				r [i]= '0';
			}
	}	

	String re="";
	for(int j=0;j<r.length;j++){
		re+=r[j];
	}

		return re;
	}
	
	public static String [] Cifrado_Descifrado_XOR (String [] mensaje,String [] clave){
		
		String [] resultado = new String [mensaje.length];
		int puntero=0;
	
		for(int i =0 ;i<mensaje.length;i++){
			
			if(puntero>=clave.length){
				puntero =0;
			}
			resultado[i]= CompuertaXOR(mensaje[i],clave[puntero]);
			
			puntero++;
		}
		
		return resultado;
	}

	
	public static String [] TextoABinario(String texto){
		
		char caracter;
		int codigoASCII;
		String binario;
		String [] binarios = new String [texto.length()];
		
		for (int i=0;i<texto.length();i++){
			
			caracter = texto.charAt(i);
			codigoASCII = (int) caracter;
			
			binario = "";
			
			
			for(int j=7;j>=0;j--){
				if(codigoASCII>=Math.pow(2, j)){
					codigoASCII-=Math.pow(2,j);
					binario +="1";
				}else{
					binario+="0";
				}
			}
		
			binarios[i]= binario.toString();

			
		}
		return binarios;
	}
	
	
	public static String BinarioATexto(String [] binarios){
		String texto="";
		
		for(int j=0;j<binarios.length;j++){
		char [] bin = binarios[j].toCharArray();
		
		int decimal =0;
		
		int contador=0;
		for(int i=bin.length-1;i>-1;i--){
	
			if(bin[contador]=='1'){
				decimal+=Math.pow(2, i);
			}
			
			contador++;
		}
		
		texto+= (char) decimal;
		
		}
		
		return texto;
	}
	
	public String Imprimir(String [] arreglo){
		String acumulador="";
		for(int i=0;i<arreglo.length;i++){
                        acumulador+=arreglo[i]+" ";
			//System.out.print(arreglo[i]+" ");
		}
                return acumulador;
	}
}
