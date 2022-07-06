package Uebungsaufgaben.Uebung11.A1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class FibonacciTest {

	private static final int[] NUMBERS = new int[] { 3, 5, 8, 12, 9, 18, 15, 10, 7, 11, 20 };
	FibonacciRecursive fibrec = new FibonacciRecursive();

	FibonacciParallel fibparal = new FibonacciParallel();

	//FibonacciDynamic fibdyn = new FibonacciDynamic();

	FibonacciDynamicParallel fibdynpar = new FibonacciDynamicParallel();
	
	@Test
	void test() {
		System.out.println(fibrec.calculate(NUMBERS[3]));
		System.out.println(fibparal.calculate(NUMBERS[3]));
		//System.out.println(fibdyn.calculate(NUMBERS[3]));
		System.out.println(fibdynpar.calculate(NUMBERS[3]));

	}

}