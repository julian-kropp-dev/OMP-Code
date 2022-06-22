package Uebungsaufgaben.Uebung09.A4;

public class FixedSequence {
	
	public static final int THREAD_COUNT = 3;
	
	private static class NumberData {
		//
		private int value;
		//
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
	}
	
	private static class NameOutput extends Thread{
		
		private NumberData data;
		private int threadNumber;
		private int nextThreadNumber;
	
		public NameOutput( NumberData inData, int inThreadNumber, int inNextThreadNumber ) {
			data = inData;
			threadNumber = inThreadNumber;
			nextThreadNumber = inNextThreadNumber;
		}
		
		@Override
		public void run() {
			while (!Thread.currentThread().isInterrupted()) {
				if( data.getValue() == threadNumber) {
					System.out.println(Thread.currentThread().getName());
					data.setValue(nextThreadNumber);
				}
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					break;
				}
			}
			System.out.println(Thread.currentThread().getName() + " is done.");
		}
		
	}

	public static void main(String[] args) {
		NumberData data = new NumberData();
		data.setValue(0);		// erster Thread, der an der Reihe ist
		//
		Thread[] threads = new Thread[THREAD_COUNT];
		//
		for (int i = 0; i < THREAD_COUNT; i++) {
			threads[i] = new Thread(new NameOutput(data, i, (i+1) % THREAD_COUNT));
		}
		for (int i = 0; i < THREAD_COUNT; i++) {
			threads[i].start();
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) { }
		for (int i = 0; i < THREAD_COUNT; i++) {
			threads[i].interrupt();
		}
		System.out.println("Done.");
	}
	


}
