package Uebungsaufgaben.Uebung07;

import java.util.stream.Stream;

public class StreamTest {
	
	/*
	 * Erinnern Sie sich an Aufgabe 2 von Übungsblatt 04. Dort ging es um die Definition von Zahlenfolgen.
	 *	Definieren Sie zunächst eine Klasse StreamTest mit einer main-Methode.
	 *	
	 *		a) Erzeugen Sie einen unendlichen Stream<Integer> naturals, der die natürlichen Zahlen 1, 2, 3, ...
	 *		in dieser Reihenfolge enthält.
	 *		
	 *		b) Erzeugen Sie einen unendlichen Stream<Integer> integers, der die ganzen Zahlen 0, 1,-1, 2,-2, 3, ...
	 *		in dieser Reihenfolge enthält.
	 *		
	 *		c) Definieren Sie eine Hilfsmethode filterAndSum(stream: Stream<Integer>): Integer, welche
	 *		nacheinander
	 *			i) den übergebenen Stream auf gerade Zahlen beschränkt
	 *			ii) den beschränkten Stream wiederum auf die ersten zehn Elemente beschränkt
	 *			iii) die verbliebenen Elemente aufsummiert
	 *			iv) diese Summe zurückgibt, oder die Zahl 0 zurückgibt falls der Stream leer ist.
	 *		Verwenden Sie dabei Lambda-Ausdrücke, und verzichten Sie soweit möglich auf Hilfsvariablen zum
	 *		Zwischenspeichern von Streams.
	 *		Geben Sie die Ergebnisse für die beiden Streams naturals und integers auf der Konsole aus.
	 *		
	 *		
	 *	Hinweis 1: Die korrekte Ausgabe ist 110 bzw. 10.
	 *	Hinweis 2: Sie können Stream.iterate(seed: T, f: UnaryOperator<T>): Stream<T> zur Erzeugung
	 *	der Streams nutzen.
	 *	Hinweis 3: Sie können Optional<T>.orElse(other: T): T zum Zurückgeben der Summe nutzen.
	 *	Die Methode gibt den Wert des Optionals zurück, oder other falls der Optional nur null enthält. Die
	 *	Methode Optional<T>.get(): T wirft eine Exception, wenn der Optional nur null enthält.
	 */

	public static void main(String[] args) {
		// a)
		Stream<Integer> naturals = Stream.iterate(1, (i) -> i+1);	
//		naturals.limit(10).forEach( (i) -> System.out.println(i) );
		// b)
		Stream<Integer> integers = Stream.iterate(0, (i) -> (i <= 0) ? -i+1 : -i);
//		integers.limit(10).forEach( (i) -> System.out.println(i) );
		// c)
		System.out.println(filterAndSum(naturals));	// 110
		System.out.println(filterAndSum(integers)); // 10
		System.out.println(filterAndSum(Stream.empty())); // 0
	}
	
	// Hilfsmethode
	
	private static Integer filterAndSum(Stream<Integer> stream) {
		return stream
				.filter((i) -> i % 2 == 0)
				.limit(10)
				.reduce((i, j) -> i + j)
				.orElse(0);
	}

}
