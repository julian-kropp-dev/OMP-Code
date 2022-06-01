package Uebungsaufgaben.Uebung06.A3;

public class DuplicateIdException extends InvalidIdException {
	
	public DuplicateIdException() {		
	}
	
	public DuplicateIdException(String inMessage) {
		super(inMessage);
	}

	public DuplicateIdException(String inMessage, int inErrorID ) {
		super(inMessage, inErrorID);
	}	

}
