package Uebungsaufgaben.Uebung10.A2;

public class Barriers {

	private final static int NUMBER = 3;

	public static void main(String[] args) {
		NumberRunner[] runner = new NumberRunner[NUMBER];
		for (int i = 0; i < NUMBER; i++) {
			runner[i] = new NumberRunner(i);
		}
		for (int i = 0; i < NUMBER; i++) {
			runner[i].start();
		}
	}

}
class NumberRunner extends Thread {

	private int number;

	public NumberRunner(int n) {
		number = n;
	}

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("Thread " + number + ": " + i);
		}
	}
}
