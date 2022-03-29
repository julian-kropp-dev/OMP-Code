package CodingChallenges;

public class Quersumme {
    public static void main(String[] args) {
        int zahl = 12345;
        int ergebnis = 0;
        String zahl1 = Integer.toString(zahl);
        for (int i = 0; i < zahl1.length(); i++) {
            ergebnis += zahl % 10;
            zahl = zahl / 10;
        }
        System.out.println(ergebnis);
    }
}
