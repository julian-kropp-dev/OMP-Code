package Uebungsaufgaben.Uebung02;

public class Out {
    public static void out(boolean booleanValue) {
        System.out.println(booleanValue);
    }

    public static void out(int integerparam) {
        System.out.println(integerparam);
    }

    public static void out(double doubleparam) {
        System.out.println(doubleparam);
    }

    public static void out(char charparam) {
        System.out.println(charparam);
    }

    public static void out(String stringparam) {
        System.out.println(stringparam);
    }

    public static void out(Object objectparam) {
        System.out.println(objectparam);
    }

}

/*
zu Aufgabenteil b:
Dies ist möglich, da die Klasse Objekt (bereitgestellt von Oracle [Java]) mit jedem anderen Datentyp (wie String, int, char etc.) umgehen kann
 */

