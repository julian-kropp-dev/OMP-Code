package Uebungsaufgaben.Uebung06.A3;

public class UnknownIdException extends InvalidIdException {
	
	public UnknownIdException() {		
	}
	
	public UnknownIdException(String inMessage) {
		super(inMessage);
	}

	public UnknownIdException(String inMessage, int inErrorID ) {
		super(inMessage, inErrorID);
	}	


}
