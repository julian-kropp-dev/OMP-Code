package Uebungsaufgaben.Uebung11.A1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class FibonacciTest {

	private static final int[] NUMBERS = new int[] { 3, 5, 8, 12, 9, 18, 15, 10, 7, 11, 20 };
	FibonacciRecursive fibrec = new FibonacciRecursive();

	FibonacciParallel fibparal = new FibonacciParallel();

	FibonacciDynamic fibdyn = new FibonacciDynamic();

	FibonacciDynamicParallel fibdynpar = new FibonacciDynamicParallel();
	
	@Test
	void test() {

		for (int i = 0; i < NUMBERS.length; i++) {
			long result0 = fibrec.calculate(NUMBERS[i]);
			long result1 = fibparal.calculate(NUMBERS[i]);
			long result2 = fibdyn.calculate(NUMBERS[i]);
			long result3 = fibdynpar.calculate(NUMBERS[i]);
			assertEquals(result0, result1);
			assertEquals(result1, result2);
			assertEquals(result2, result3);
		}

	}

	@Test
	void timeRecursive() {
		Long start = System.currentTimeMillis();
		for (int i = 0; i < NUMBERS.length; i++) {
			fibrec.calculate(NUMBERS[i]);
		}
		System.out.println(System.currentTimeMillis() - start);

	}

	@Test
	void timeParallel() {
		Long start = System.currentTimeMillis();
		for (int i = 0; i < NUMBERS.length; i++) {
			fibparal.calculate(NUMBERS[i]);
		}
		System.out.println(System.currentTimeMillis() - start);

	}

	@Test
	void timeDynamic() {
		Long start = System.currentTimeMillis();
		for (int i = 0; i < NUMBERS.length; i++) {
			fibdyn.calculate(NUMBERS[i]);
		}
		System.out.println(System.currentTimeMillis() - start);

	}

	@Test
	void timeDynamicParallel() {
		Long start = System.currentTimeMillis();
		for (int i = 0; i < NUMBERS.length; i++) {
			fibdynpar.calculate(NUMBERS[i]);
		}
		System.out.println(System.currentTimeMillis() - start);

	}
}

/*
Zeit Stoppen: Wie geht denn das? Könnt ihr uns nicht vielleicht erklären, wie man auf die Systemzeit zugreift?
Im Skript steht zu sowelchen Fragen nichts, warum gibt es dann eine Frage zu Themen, die wir noch nie hatten?
Finde ich nicht so nett...
 */