package modificacion;

import java.util.Scanner;

import controlador.ControladorCambioDivisas;



public class App {
	static final float MAXIM = 1000000000;

	public static void main(String arg[]) throws ExcepcionFecha {

		
		Clock temporizador = new Clock();
 		System.out.println(temporizador.getTimeTotal());
		temporizador.Start();
		      long total = 0;
		      for (int i = 0; i < MAXIM; i++) {
		         total += i;
		      }      
		temporizador.Stop();
		System.out.println((float)Math.round(temporizador.getTimeTotal() * 100) / 100 + " segundos");
		temporizador.reset();
        Scanner sc = new Scanner(System.in);
        System.out.println("Rseteando el temporizador");
        System.out.println(" Cantidad de euros a transformar ");
        int numero = sc.nextInt();
        sc.close();
		
		temporizador.Start();
        new ControladorCambioDivisas(numero);
		temporizador.Stop();
		System.out.println((float)Math.round(temporizador.getTimeTotal() * 100) / 100 + " segundos");


		
	}
	
	
}
