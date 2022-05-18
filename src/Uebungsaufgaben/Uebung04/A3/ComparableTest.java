package Uebungsaufgaben.Uebung04.A3;

interface Comparable {
	/**
	 * Vergleicht das aufrufende Objekt mit dem als Parameter uebergebenen
	 * Objekt; liefert: -1 falls das aufrufende Objekt kleiner ist als das
	 * Parameterobjekt, 0 falls beide Objekte gleich gross sind, 1 falls das
	 * aufrufende Objekt groesser ist als das Parameterobjekt.
	 */
	public int compareTo(Comparable obj);
}

class Utils {

	/**
	 * Liefert das "kleinste" (auf der Basis der Comparable-Implementierung!)
	 * Element des Parameter-Arrays.
	 * Achtung: Man kann davon ausgehen, dass das Parameter-Array
	 * mindestens ein Element enthaelt (also weder null noch leer ist)
	 */
	public static Comparable getMinimum(Comparable[] elements) {
//		if ( elements.length == 0 )
//			return null;
		Comparable minimum = elements[0];
		for ( int i = 1; i < elements.length-1; i++ ) {
			if( minimum.compareTo(elements[i]) == 1 )
				minimum = elements[i];
		}
		return minimum;
	}

}


class Integer {
	protected int value;

	public Integer(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}	
}

class ComparableInteger extends Integer implements Comparable{
	
	// Constructor

	public ComparableInteger(int value) {
		super( value );
	}
	
	public int compareTo(Comparable obj) {
		if ( this.getValue() < ((Integer)obj).getValue() )
			return -1;
		else {
			if ( this.getValue() > ((Integer)obj).getValue() )
				return 1;
		}
		return 0;
	}
}


public class ComparableTest {
	//
	public static void main(String[] args) {
		//
		ComparableInteger c1 = new ComparableInteger(5);
		ComparableInteger c2 = new ComparableInteger(7);
		ComparableInteger c3 = new ComparableInteger(1);
		ComparableInteger c4 = new ComparableInteger(10);
		ComparableInteger c5 = new ComparableInteger(3);
		ComparableInteger c6 = new ComparableInteger(8);
		//
		ComparableInteger[] comp = new ComparableInteger[] {c1, c2, c3, c4, c5, c6};
		//
		Comparable result = Utils.getMinimum(comp);
		System.out.println( "Das Minimum ist: " + ( (Integer)result ).getValue() + " ; SOLL: 1" );
		//
		//
		ComparableInteger c7 = new ComparableInteger(9);
		ComparableInteger c8 = new ComparableInteger(4);
		ComparableInteger c9 = new ComparableInteger(11);
		ComparableInteger c10 = new ComparableInteger(30);
		ComparableInteger c11 = new ComparableInteger(4);
		ComparableInteger c12 = new ComparableInteger(6);
		//
		ComparableInteger[] comp2 = new ComparableInteger[] {c7, c8, c9, c10, c11, c12};
		//
		Comparable result2 = Utils.getMinimum(comp2);
		System.out.println( "Das Minimum ist: " + ( (Integer)result2 ).getValue() + " ; SOLL: 4" );
	}
}
