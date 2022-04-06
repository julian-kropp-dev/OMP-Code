package CodingChallenges;

class JuliansZwanzigsterGeburtstag {
    public static void main(String[] args) {
        Feier juliansGeburtstag = new Feier(1648825200L); 
        juliansGeburtstag.addGuest("xxx");
    }
}

class Feier {
    private long time; //Local-Time, NOT GMT!
    private String place;
    private String guest;

    Feier(long time) {
        this.time = time;
        this.place = "xxx";
    }

    void addGuest(String name) {
        this.guest = name;
    }

}