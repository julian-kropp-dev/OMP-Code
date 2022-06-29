package Uebungsaufgaben.Uebung10.A1;

import Uebungsaufgaben.Uebung05.A1.IO;

import java.util.concurrent.Semaphore;

/*
Dieses Programm berechnet ganz generell die Quardratzahl einer eingegebenen Zahl.
 */
class Output extends Thread {

	public void run() {
		try {
			InOut.getSemaphore().acquire();
			System.out.println(InOut.getValue() * InOut.getValue());
		} catch (InterruptedException e) {
			System.err.println("ERROR!");
		}
	}
}

class Input extends Thread {

	public void run() {
		InOut.setValue(IO.readInt("Value: "));
		InOut.getSemaphore().release();
	}
}

public class InOut {
	private static Semaphore semaphore = new Semaphore(0);
	private static int value = 0;

	public static Semaphore getSemaphore() {return semaphore;}
	
	public static int getValue() {
		return value;
	}
	
	public static void setValue(int value) {
		InOut.value = value;
	}

	public static void main(String[] args) {
		new Output().start();
		new Input().start();
	}

}