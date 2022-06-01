package Uebungsaufgaben.Uebung06.A3;

public class InvalidIdException extends Exception {
	
	private int errorID;
	
	public InvalidIdException() {		
	}
	
	public InvalidIdException(String inMessage) {
		super(inMessage);
	}
	
	public InvalidIdException(String inMessage, int inErrorID ) {
		super(inMessage);
		errorID = inErrorID;
	}	
		
	public int getId() {
		return errorID;
	}
	
}
