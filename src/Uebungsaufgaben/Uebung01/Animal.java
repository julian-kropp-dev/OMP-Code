package Uebungsaufgaben.Uebung01;

public class Animal {
    //Attribute
    private String name;
    private Plant[] plants = new Plant[10];
    private Animal[] animals = new Animal[10];
    //Constructor
    public Animal(String name) {
        this.name = name;
    }

    //Getter & Setter
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Plant[] getFoodPlants() {
        return plants;
    }
    public Animal[] getFoodAnimals() {return animals;}


    //Methods
    public void addFood(Plant plant) {
        for (int i = 0; i < plants.length; i++) {
            if (plants[i] == plant) {
                break;
            }
            else if(plants[i] == null) {
                plants[i] = plant;
                break;
            }
        }
    }

    public void addFood(Animal animal) {
        for (int i = 0; i < animals.length; i++) {
            if (animals[i].equals(animal)) {
                break;
            }
            else if(animals[i] == null) {
                animals[i] = animal;
                break;
            }
        }
    }

    //Pflanzenfresser
    public boolean onlyPlant() {
        return !eatsAtLeastOneAnimal() && eatsAtLeastOnePlant();
    }

    //Fleischfresser
    public boolean onlyAnimal() {
        return eatsAtLeastOneAnimal() && !eatsAtLeastOnePlant();
    }

    //Allesfresser
    public boolean eatsBoth() {
        return eatsAtLeastOneAnimal() && eatsAtLeastOnePlant();
    }

    private boolean eatsAtLeastOnePlant() {
        for (Plant plant : plants) {
            if (plant != null) {
                return true;
            }
        }
        return false;
    }

    private boolean eatsAtLeastOneAnimal() {
        for (Animal animal : animals) {
            if (animal != null) {
                return true;
            }
        }
        return false;
    }



}
