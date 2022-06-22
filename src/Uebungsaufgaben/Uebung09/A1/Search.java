package Uebungsaufgaben.Uebung09.A1;

public class Search {
	
	private static int[] zahlen = new int[] {2, 7, 3, 9, 23};
	private static boolean found;
	
	private static class SearchThread extends Thread{
		
		private int suchzahl;
		private int startidx;
		private int endidx;
	
		public SearchThread( int inSuchzahl, int inStartidx, int inEndidx ) {
			suchzahl = inSuchzahl;
			startidx = inStartidx;
			endidx = inEndidx;
		}
		
		@Override
		public void run() {
			// sucht Suchzahl in Array zahlen
			for ( int i = startidx; i <= endidx; i++) {
				if ( zahlen[i] == suchzahl ) {
					System.out.println( currentThread().getName() + ": found" );
					found = true;
					return;
				}
			}
			System.out.println( currentThread().getName() + ": not found" );
			
		}
		
	}

	public static void main(String[] args) {
		// TODO Automatisch generierter Methodenstub
		int suchzahl = 7;
		//
		SearchThread left = new SearchThread(suchzahl, 0, 2);
		SearchThread right = new SearchThread(suchzahl, 3, 4);
		found = false;
		left.start();
		right.start();
		try {
			left.join();
			right.join();
		} catch ( InterruptedException e ) {}
		System.out.println("Found: " + found);
//		System.out.println("Done.");
	}
	


}
