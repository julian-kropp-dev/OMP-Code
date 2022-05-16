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

//todo: implement ComparableInteger

public class ComparableTest {
	public static void main(String[] args) {
		//todo: implement this
	}
}
