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
		System.out.println("Recursive: " + (System.currentTimeMillis() - start) );

	}

	@Test
	void timeParallel() {
		Long start = System.currentTimeMillis();
		for (int i = 0; i < NUMBERS.length; i++) {
			fibparal.calculate(NUMBERS[i]);
		}
		System.out.println("Parallel: " + (System.currentTimeMillis() - start) );

	}

	@Test
	void timeDynamic() {
		Long start = System.currentTimeMillis();
		for (int i = 0; i < NUMBERS.length; i++) {
			fibdyn.calculate(NUMBERS[i]);
		}
		System.out.println("Dynamic: " + (System.currentTimeMillis() - start) );

	}

	@Test
	void timeDynamicParallel() {
		Long start = System.currentTimeMillis();
		for (int i = 0; i < NUMBERS.length; i++) {
			fibdynpar.calculate(NUMBERS[i]);
		}
		System.out.println("ParallelDynamic: " + (System.currentTimeMillis() - start) );

	}
}


/*
Timing-Ergebnisse:
Recursive: 1ms
Parallel: 16943ms
Dynamic: 0ms
ParallelDynamic: 0ms (bei anderen Messungen etwas langsamer als Dynamic)
*/

/*
Die Timing-Ergebnisse entsprechen nicht der Erwartung, dass Parallelisierung beschleunigt.
Das hat mehrere Gründe u.a.:
- Die Erzeugung von Threads ist sehr viel "teurer" als ein Methodenaufruf
- Die Threads tun inhaltlich fast garnichts (nur Addition), d.h. die Thread-Erzeugung/-Vernichtung ist die maßgebliche Laufzeit
- Bei der parallelen, rekursiven Methode werden tausende von Threads erzeugt, d.h.
	- massiver Zeitaufwand fuer Thread-Erzeugung
	- es kann fast nichts wirklich parallel stattfinden
*/
