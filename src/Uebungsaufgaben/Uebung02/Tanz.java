//Die drei von Nebenan 🏡
package Uebungsaufgaben.Uebung02;

import org.junit.jupiter.api.DisplayNameGenerator;

import java.util.Arrays;

class Dance {
    private String name;
    private String beat;
    private Figure[] figures;

    //Constructors
    public Dance(String name, String beat) {
        this.name = name;
        this.beat = beat;

    }

    public Dance(String name, String beat, Figure[] figures) {
        this.beat = beat;
        this.name = name;
        this.figures = figures;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBeat() {
        return beat;
    }

    public void setBeat(String beat) {
        this.beat = beat;
    }

    public Figure[] getFigures() {
        return figures;
    }

    public void setFigures(Figure[] figures) {
        this.figures = figures;
    }
}

class Figure {
    private String name;
    private String descrption;
    private Figure[] parts = new Figure[0];

    public Figure(String name, String descrption) {
        this.name = name;
        this.descrption = descrption;
    }

    public Figure(String name, Figure[] parts) {
        this.name = name;
        this.parts = parts;
    }

    public boolean add( Figure inFigure ) {
    	if ( sequence == null )					// keine Umwandlung von Beschreibungsfiguren in Sequenzfiguren erlaubt
    		return false;
        if ( !inFigure.contains(this) ) {		// 
        	Figure[] neuSequenz = new Figure[sequence.length+1];
            for ( int i = 0; i < sequence.length; i++ ) {
            	neuSequenz[i] = sequence[i];
            };
            neuSequenz[sequence.length] = inFigure;
            return true;
        }
        return false;
    }
    
    
    //
    // protected
    //

    protected boolean contains( Figure inFigure ) {
    	if ( sequence == null ) {
    		return false;
    	}
        for ( Figure seqItem : sequence ) {
            if ( seqItem == inFigure )
                return true;
            else {
            	if ( seqItem.contains(inFigure) )
            		return true;
            }
        }
        return false;
    }
}

class StandardDance extends Dance{

    public StandardDance(String name, String beat) {
        super(name, beat);
    }

    public StandardDance(String name, String beat, Figure[] figures) {
        super(name, beat, figures);
    }
}

class LatinDance extends Dance{


    public LatinDance(String name, String beat) {
        super(name, beat);
    }

    public LatinDance(String name, String beat, Figure[] figures) {
        super(name, beat, figures);
    }
}

class DanceDatabase {
    public static void main(String[] args) {
        Figure basicMove = new Figure("Basic Move", "Hier könnte IHRE Werbung stehen!");
        Figure fan = new Figure("Fan", "Hier könnte IHRE Werbung stehen!");
        Figure promenade = new Figure("Promenade", "Hier könnte IHRE Werbung stehen!");
        Figure spin_turn = new Figure("Spin Turn", "Hier könnte IHRE Werbung stehen!");
        Figure natural_turn = new Figure("Natual Dance", "Hier könnte IHRE Werbung stehen!");
        Figure chasse = new Figure("Chasse", "Hier könnte IHRE Werbung stehen!");
        Figure whisk = new Figure("Whisk", new Figure[]{promenade, chasse});


        LatinDance jive = new LatinDance("Jive", "4/4" );
        LatinDance rumba = new LatinDance("Rumba", "4/4");
        LatinDance chachacha = new LatinDance("ChaChaCha", "4/4");
        StandardDance tango = new StandardDance("Tango", "4/4");
        LatinDance quickstep = new LatinDance("Quickstep", "4/4");
        StandardDance waltz = new StandardDance("Waltz", "3/4");

        jive.setFigures(new Figure[]{basicMove});
        rumba.setFigures(new Figure[]{basicMove, fan});
        chachacha.setFigures(new Figure[]{basicMove, fan});
        tango.setFigures(new Figure[]{basicMove, promenade});
        quickstep.setFigures(new Figure[]{basicMove, spin_turn});
        waltz.setFigures(new Figure[]{spin_turn, whisk, natural_turn});

        whisk.add(promenade);
        whisk.add(chasse);



    }
}
