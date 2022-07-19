package Uebungsaufgaben.Uebung12;

import java.util.HashMap;
import java.util.Map;

import com.deliveredtechnologies.rulebook.FactMap;
import com.deliveredtechnologies.rulebook.Result;
import com.deliveredtechnologies.rulebook.model.runner.RuleBookRunner;

public class Labyrinth {

	public static void main(String[] args) {
		/*
		 * A-B-C D
		 * |   | |
		 * E F-G-H
		 * |   |  
		 * I-J-K-L
		 *   |   |
		 * M-N-O-P
		 */
		Map<Character, Chamber> labyrinth = new HashMap<>();
		for (char n = 'A'; n <= 'P'; n++) {
			labyrinth.put(n, new Chamber(Character.toString(n)));
		}
		labyrinth.get('A').addAdjacent(labyrinth.get('B'));
		labyrinth.get('B').addAdjacent(labyrinth.get('C'));
		labyrinth.get('A').addAdjacent(labyrinth.get('E'));
		labyrinth.get('C').addAdjacent(labyrinth.get('G'));
		labyrinth.get('D').addAdjacent(labyrinth.get('H'));
		labyrinth.get('F').addAdjacent(labyrinth.get('G'));
		labyrinth.get('G').addAdjacent(labyrinth.get('H'));
		labyrinth.get('E').addAdjacent(labyrinth.get('I'));
		labyrinth.get('G').addAdjacent(labyrinth.get('K'));
		labyrinth.get('I').addAdjacent(labyrinth.get('J'));
		labyrinth.get('J').addAdjacent(labyrinth.get('K'));
		labyrinth.get('K').addAdjacent(labyrinth.get('L'));
		labyrinth.get('J').addAdjacent(labyrinth.get('N'));
		labyrinth.get('L').addAdjacent(labyrinth.get('P'));
		labyrinth.get('M').addAdjacent(labyrinth.get('N'));
		labyrinth.get('N').addAdjacent(labyrinth.get('O'));
		labyrinth.get('O').addAdjacent(labyrinth.get('P'));
		labyrinth.get('A').setEntrance(true);
		labyrinth.get('P').setTreasure(true);
		Chamber next = labyrinth.get('A');
		FactMap<Chamber> facts = new FactMap<>();
		RuleBookRunner ruleBook = new RuleBookRunner("de.uni_oldenburg.inf.omp.rulebook.labyrinth");
		while (next != null) {
			facts.clear();
			facts.setValue("chamber", next);
			ruleBook.run(facts);
			next = (Chamber) ruleBook.getResult().orElse(new Result<>(null)).getValue();
		}
	}

}
