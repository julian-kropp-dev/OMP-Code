package Uebungsaufgaben.Uebung11.A1;

import java.util.HashMap;

public abstract class Fibonacci {
	
	public abstract long calculate(int n);
	
}


class FibonacciRecursive extends Fibonacci {

	@Override
	public long calculate(int n) {
		if (n == 0 || n == 1) {
			return n;
		} else {
			return calculate(n - 1) + calculate(n - 2);
		}
	}

}



class FibonacciParallel extends Fibonacci {
	@Override
	public long calculate(int n) {
		if (n == 0 || n == 1) {
			return n;
		} else {
			FibonacciThread fib1 = new FibonacciThread(n - 1);
			FibonacciThread fib2 = new FibonacciThread(n - 2);
			fib1.start();
			fib2.start();
			try {
				fib1.join();
				fib2.join();
			} catch (InterruptedException e) {
				return -1;
			}
			return fib1.getResult() + fib2.getResult();
		}
	}

	private class FibonacciThread extends Thread {
		private int n;
		private long result;

		public FibonacciThread(int n) {
			this.n = n;
		}

		@Override
		public void run() {
			result = calculate(n);
		}

		public long getResult() {
			return result;
		}
	}
}

class FibonacciDynamic extends Fibonacci {
	private static final HashMap<Integer, Long> myResult = new HashMap<>();

	public FibonacciDynamic() {
		myResult.put(0, (long) 0);
		myResult.put(1, (long) 1);
	}

	@Override
	public long calculate(int n) {

		if (myResult.containsKey(n)) {
			return myResult.get(n);
		} else {

			long result = calculate(n - 2) + calculate(n - 1);
			myResult.put(n, result);
			return result;
		}
	}
}

class FibonacciDynamicParallel extends Fibonacci {
	private static final HashMap<Integer, Long> myResult = new HashMap<>();

	public FibonacciDynamicParallel() {
		myResult.put(0, (long) 0);
		myResult.put(1, (long) 1);
	}

	@Override
	public long calculate(int n) {
		return calculateDynamic2(n);
	}

	private long calculateDynamic2(int n) {
		long result;
		if (myResult.containsKey(n)) {
			return myResult.get(n);
		} else {
			FibonacciThread2 thread1 = new FibonacciThread2(n - 1);
			FibonacciThread2 thread2 = new FibonacciThread2(n - 2);
			thread1.start();
			thread2.start();
			try {
				thread1.join();
				thread2.join();

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			result = thread1.getResult() + thread2.getResult();
			myResult.put(n, result);
	}return result;}

	class FibonacciThread2 extends Thread {
			private int n;
			private long result;

			public FibonacciThread2(int n) {
				this.n = n;
			}

			@Override
			public void run() {
				result = calculate(n);
			}

			public long getResult() {
				return result;
			}
		}


}






