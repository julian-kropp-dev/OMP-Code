package Uebungsaufgaben.Uebung09.A2;

public class QuickSortThreaded extends QuickSort implements Runnable {
	private int[] numbers;
	private int left;
	private int right;

	public QuickSortThreaded() {
	}

	public QuickSortThreaded(int[] numbers, int left, int right) {
		this.numbers = numbers;
		this.left = left;
		this.right = right;
	}

	/**
	 * sortiert das uebergebene Array in aufsteigender Reihenfolge
	 * gemaess dem QuickSort-Algorithmus (parallel!)
	 */
	public static void sort(int[] numbers) {
		new QuickSortThreaded().quickSort(numbers, 0 , numbers.length - 1);
	}

	/**
	 * der Quicksort-Algorithmus wird auf dem Array zwischen den
	 * angegebenen Indizes ausgefuehrt
	 */
	protected void quickSort(int[] numbers, int leftIndex, int rightIndex) {
		if(leftIndex < rightIndex) {
			int pivotIndex = divide(numbers, leftIndex, rightIndex);
			Thread thread1 = new Thread(new QuickSortThreaded(numbers, leftIndex, pivotIndex - 1));
			Thread thread2 = new Thread(new QuickSortThreaded(numbers, pivotIndex + 1, rightIndex));
			thread1.start();
			thread2.start();
			try {
				thread1.join();
				thread2.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}


		}
	}

	@Override
	public void run() {
		quickSort(numbers, left, right);
	}
}
