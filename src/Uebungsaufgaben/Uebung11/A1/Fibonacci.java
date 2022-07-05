package Uebungsaufgaben.Uebung11.A1;

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
				System.out.println("Interrupted!");
			}
			return fib1.getResult() + fib2.getResult();
		}
	}

	class FibonacciThread extends Thread {
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

	@Override
	public long calculate(int n) {
		long[] memo = new long[n + 1];
		return calculateDynamic(n, memo);
	}

	private long calculateDynamic (int n, long[] memo) {
		long result;

		if (memo[n] != 0) {
			return memo[n];
		}

		if (n == 0 || n == 1) {
			result = n;
		} else {
			result = calculateDynamic(n - 1, memo) + calculateDynamic(n - 2, memo);
		}
		memo[n] = result;
		return result;
	}
}

class FibonacciDynamicParallel extends Fibonacci {

	@Override
	public long calculate(int n) {
		long[] memo = new long[n + 1];
		return calculateDynamic2(n, memo);
	}

	private long calculateDynamic2(int n, long[] memo) {
		long result;
		if (memo[n] != 0) {
			return memo[n];
		}

		if (n == 0 || n == 1) {
			result = n;
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
			memo[n] = result;
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



