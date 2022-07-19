package Uebungsaufgaben.Uebung10.A3;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class KnapsackDynamic extends Knapsack {
	
	public KnapsackDynamic(int capacity, Collection<Item> candidates) {
		super(capacity, candidates);
	}
	
	/*
	 * Schreiben Sie eine Klasse KnapsackDynamic, die von Knapsack erbt, und implementieren Sie dort
	die pack-Methode. Implementieren Sie die Methode mittels dynamischer Programmierung und Memoisation,
	also indem Sie Zwischenergebnisse zwischenspeichern und gegebenenfalls wiederverwenden.
	Hinweis: Überlegen Sie sich, mit welcher bekannten Datenstruktur Sie am besten Zwischenergebnisse
	speichern können.
	
	Zwischenergebnisse: zum vergleichen??
	 */

	@Override
	public Selection pack() {
		
		/*
		 * 	Wie in V19 Folie 66 beschrieben, ist dynamische Programmierung nicht sinnvoll,
		 *   wenn eine effizientere Strategie bekannt ist.
		 *  
		 *  Da unser Greedy-Algorithmus die optimale Loesung liefert,
		 *   ist eine Dynamic-Implementierung hier ueberfluessig.
		 * 
		 */
		
		Knapsack knapGreedy = new KnapsackGreedy(capacity, candidates);
		return knapGreedy.pack();
	}

}
