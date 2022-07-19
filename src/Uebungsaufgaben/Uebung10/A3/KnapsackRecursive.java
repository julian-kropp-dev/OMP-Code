package Uebungsaufgaben.Uebung10.A3;

import java.util.Collection;
import java.util.List;

public class KnapsackRecursive extends Knapsack {

	public KnapsackRecursive(int capacity, Collection<Item> candidates) {
		super(capacity, candidates);
		this.candidates.sort((i1, i2) -> Integer.compare(i1.getValue(), i2.getValue()));
	}

	/*
	 * Schreiben Sie eine Klasse KnapsackRecursive, die von Knapsack erbt, und implementieren Sie
		dort die pack-Methode. Implementieren Sie die Methode rekursiv, also indem Sie ganz naïv alle
		Möglichkeiten durchprobieren. Achten Sie auf passende Abbruchbedingungen!
	 */
	
	@Override
	public Selection pack() {
		packRecursive(new Selection());
		return best;
	}
	
	// private
	
	private Selection best = null;
	
	private void packRecursive( Selection inSel ) {
		if ( ( best == null ) || ( inSel.getValue() > best.getValue() ) )
			best = inSel;
		for ( Item cand : candidates ) {
			Selection neuSel = new Selection(inSel, cand);
			if ( neuSel.getWeight() <= capacity )
				packRecursive(neuSel);
		}
	}

}
