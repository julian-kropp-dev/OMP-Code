package CodingChallenges.CodingWithFlo;

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Test {
    public static void main(String[] args) {
        System.out.println(toogle(false));
        System.out.println(toogle(true));


    }
    static Boolean toogle(Boolean mybool) {
        return !mybool;

    }
}