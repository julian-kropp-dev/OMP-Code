package Uebungsaufgaben.Uebung06.A3;

import java.util.Comparator;
import java.util.Map;

public class EntryComparator implements Comparator<Map.Entry<Integer,String>> {
	
	@Override
	public int compare( Map.Entry<Integer,String> o1, Map.Entry<Integer,String> o2 ) {
		int cmp = o1.getValue().compareTo(o2.getValue());
		if ( cmp == 0 ) {
			return o1.getKey() - o2.getKey();
		} else {
			return cmp;			
		}
	}

}
