package Uebungsaufgaben.Uebung05.A1;

class Util {

	// liefert die kleinste Zahl des uebergebenen Arrays
	public static int minimum(int[] values) throws EmtyStringException {
		if (values.length == 0) {
			throw new EmptyArrayException("Du hast ein leeres Array übermittelt. In einem leeren Array gibt es kein kleinstes Element.");
		}
		int min = values[0];
		for (int i = 1; i < values.length; i++) {
			if (values[i] < min) {
				min = values[i];
			}
		}
		return min;
	}

	// konvertiert den uebergebenen String in einen int-Wert
	public static int toInt(String str) throws EmtyStringException, InvalidIntException{
		if (str.isEmpty()) {
			throw new EmtyStringException("Dein String enthält keine Zahl, da er leer ist.");
		}
		int result = 0, factor = 1;
		char ch = str.charAt(0);
		switch (ch) {
		case '-':
			factor = -1;
			break;
		case '+':
			factor = 1;
			break;
		default:
			result = ch - '0';
		}
		for (int i = 1; i < str.length(); i++) {
			ch = str.charAt(i);
			if(!('0' <= ch && ch <= '9')) {
				throw new InvalidIntException(ch + " ist keine gültige Zahl.");
			}
			int ziffer = ch - '0';
			result = result * 10 + ziffer;
			if (result * 10 + ziffer < result) {
				throw new NumberOverflowException();
			}
		}
		return factor * result;
	}

	// liefert die Potenz von zahl mit exp,
	// also zahl "hoch" exp (number to the power of exp)
	public static long power(long number, int exp) throws NegativeExponentException, NumberOverflowException{
		if (exp <= 0) {
			throw new NegativeExponentException("Ein negativer Exponent ist nicht möglich, da sonst eine Kommazahl rauskommt.");
		}
		if (exp == 0) {
			return 1L;
		}

		return number * Util.power(number, exp - 1);
	}
}

public class UtilTest {

	// Testprogramm
	public static void main(String[] args) {
		String eingabe = IO.readString("Zahl: ");
		int zahl = Util.toInt(eingabe);
		System.out.println(zahl + " hoch " + zahl + " = "
				+ Util.power(zahl, zahl));
		System.out.println(Util.minimum(new int[] { 1, 6, 4, 7, -3, 2 }));
		System.out.println(Util.minimum(new int[0]));
		System.out.println(Util.minimum(null));
	}
}

