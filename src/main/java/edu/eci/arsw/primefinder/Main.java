package edu.eci.arsw.primefinder;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		PrimeFinderThread pft=new PrimeFinderThread(0, 10000000);
		PrimeFinderThread pft1=new PrimeFinderThread(10000000, 20000000);
		PrimeFinderThread pft2=new PrimeFinderThread(20000000, 30000000);
		Timer time = new Timer();
		pft.start();
		TimerTask tarea = new TimerTask() {
			@Override
			public void run() {
				pft.suspender();
				pft1.suspender();
				pft2.suspender();
				System.out.println("Desea reanudar ? Presione ENTER");
			}
		};

		time.schedule(tarea,5000);
		Scanner entrada = new Scanner(System.in);
		entrada.nextLine();
		pft.reanudar();
		pft1.reanudar();
		pft2.reanudar();
		time.cancel();

	}
	
}
