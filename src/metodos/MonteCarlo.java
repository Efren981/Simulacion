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
public class MonteCarlo {
 
	public double countPI(double n) {
		int i = 0;
		int count = 0;
		double pi = 0;
		double x = 0;
		double y = 0;
		while(i < n) {
			x = Math.random();
			y = Math.random();
			if ((x * x) + (y * y) < 1) {
				count++;
			}
			i++;
		}
		pi = 4 * (count / n);
		return pi;
	}
}
