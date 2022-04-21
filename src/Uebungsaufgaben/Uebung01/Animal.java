package Uebungsaufgaben.Uebung01;

public class Animal {
    //Attribute
    private String name;
    private Plant[] plants = new Plant[10];
    private Animal[] animals = new Animal[10];
    //Constructor
    public Animal(String name, Plant[] food) {
        this.name = name;
    }

    //Getter & Setter
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Plant[] getFood() {
        return plants;
    }
    public void setFood(Plant[] plants) {
        this.plants = plants;
    }

    //Methods
    public void addPlantFood(Plant plant) {
        for (int i = 0; i < plants.length; i++) {
            if(plants[i] != null) {
                plants[i] = plant;
            }
        }
    }
    public void addAnimalFood(Animal animal) {
        for (int i = 0; i < animals.length; i++) {
            if(animals[i] != null) {
                animals[i] = animal;
            }
        }
    }
    public boolean onlyPlant() {
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] != null) {
                return false;
            }
        }
        return true;
    }
    public boolean onlyAnimal() {
        for (int i = 0; i < plants.length; i++) {
            if (plants[i] != null) {
                return false;
            }
        }
        return true;
    }
    public boolean eatsBoth() {
        return !onlyAnimal() && !onlyPlant();

    }
}
