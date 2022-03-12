package CodingChallenges.Human;

class Human {
    private String name;
    private final String vorname;
    private int alter;
    private double groesse;

    //constructor

    public Human(String name, String vorname) {
        this.name = name;
        this.vorname = vorname;
    }

    //getter

    public String getName() {
        return name;
    }

    public String getVorname() {
        return vorname;
    }

    public int getAlter() {
        return alter;
    }

    public double getGroesse() {
        return groesse;
    }

    //setter

    public void setName(String name) {
        this.name = name;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }

    public void setGroesse(double groesse) {
        this.groesse = groesse;
    }


    //methods
    boolean isOlder(Human human){
        return this.alter > human.alter;
    }
}

class Student extends Human {
    private double note;
    private String lieblingsmodul;

    //constructor

    public Student(String name, String vorname) {
        super(name, vorname);
    }


    //getter

    public double getNote() {
        return note;
    }

    public String getLieblingsmodul() {
        return lieblingsmodul;
    }

    //setter

    public void setNote(double note) {
        this.note = note;
    }

    public void setLieblingsmodul(String lieblingsmodul) {
        this.lieblingsmodul = lieblingsmodul;
    }

    //methods

    boolean hasBetterGrade(Student student) {
        return this.note < student.getNote();
    }

}

class Teacher extends Human {
    private final String[] module;
    public Teacher(String name, String vorname, String[] module) {
        super(name, vorname);
        this.module = module;
    }

    //getter

    public String[] getModule() {
        return module;
    }

    //methods
    boolean isOlderThanStudent(Student student){
        return this.getAlter() > student.getAlter();
    }
}