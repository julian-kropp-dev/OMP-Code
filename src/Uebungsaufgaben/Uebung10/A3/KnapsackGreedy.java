package Uebungsaufgaben.Uebung10.A3;

import java.util.Collection;

public class KnapsackGreedy extends Knapsack {

	public KnapsackGreedy(int capacity, Collection<Item> candidates) {
		super(capacity, candidates);
	}
	
	/*
	 * Schreiben Sie eine Klasse KnapsackGreedy, die von Knapsack erbt, und implementieren Sie dort
		die pack-Methode. Implementieren Sie die Methode nach dem greedy-Verfahren, also indem Sie
		immer die aktuell am besten erscheinende Auswahl treffen und diese Auswahl später nicht wieder
		revidieren.
	 */

	@Override
	public Selection pack() {
		Selection sel = new Selection();
		Item best = mostValuable( capacity );
		while ( best != null ) {
			sel = new Selection(sel, best);
			best = mostValuable( capacity - sel.getWeight() );
		}
		return sel;
	}
	
	// private
	
	private Item mostValuable( int restCapacity) {
		Item bestItem = null;
		for ( Item cand : candidates ) {
			if ( cand.getWeight() <= restCapacity ) {
				// Wir nehmen immer das Teil mit dem hoechsten Wert, welches noch passt
//				if ( ( bestItem == null ) || ( cand.getValue() > bestItem.getValue() ) )
				//
				// Wir nehmen immer das Teil mit dem besten Wert-zu-Gewicht-Verhaeltnis, welches noch passt
				if ( ( bestItem == null ) || ( cand.getValue()/cand.getWeight() > bestItem.getValue()/bestItem.getWeight() ) )
					bestItem = cand;
			}
		}
		return bestItem;
	}

}
