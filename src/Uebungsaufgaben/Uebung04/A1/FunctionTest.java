package Uebungsaufgaben.Uebung04.A1;

abstract class Function {
	
	// Attribute
	
	Function next;
	
	// Constructoren
	
	public Function() {
		next = null;
	}
	
	public Function( Function inNext ) {
		next = inNext;
	}
	
	// Operation
	
	public double calculate( double inParam ) {
		if (next == null ) {
			return oper(inParam);
		} else {
			return oper(next.calculate(inParam));
		}
	}
	
	public abstract double oper( double inParam );

}

class SquareFunction extends Function {
	
	// Constructor
	
	public SquareFunction() {
		super();
	}
	
	public SquareFunction( Function inNext ) {
		super(inNext);
	}
	
	@Override
	public double oper( double inParam ) {
		return inParam*inParam;
	}

	
}

class SquareRootFunction extends Function {

	// Constructor
	
	public SquareRootFunction() {
		super();
	}
	
	public SquareRootFunction( Function inNext ) {
		super(inNext);
	}
	
	@Override
	public double oper( double inParam ) {
		return Math.sqrt(inParam);
	}


}

class SineFunction extends Function {
	
	// Constructor
	
	public SineFunction() {
		super();
	}
	
	public SineFunction( Function inNext ) {
		super(inNext);
	}
	
	@Override
	public double oper( double inParam ) {
		return Math.sin(inParam);
	}


}

public class FunctionTest {

	public static void main(String[] args) {
		// Function chain = new SquareFunction(new SquareRootFunction(new SineFunction()));
		Function chain = new SquareRootFunction(new SquareRootFunction(new SquareFunction()));
		while (true) {
			double x = IO.readDouble("Value: ");
			System.out.println(chain.calculate(x));
		}
	}

}
