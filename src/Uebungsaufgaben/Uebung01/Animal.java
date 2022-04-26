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
        for (Animal animal : animals) {
            if (animal != null) {
                return false;
            }
        }
        return true;
    }

    //Fleischfresser
    public boolean onlyAnimal() {
        for (Plant plant : plants) {
            if (plant != null) {
                return false;
            }
        }
        return true;
    }

    //Allesfresser
    public boolean eatsBoth() {
        return eatsAtLeastOneAnimal() && eatsAtLeastOnePlant();
    }

    public boolean eatsAtLeastOnePlant() {
        for (Plant plant : plants) {
            if (plant != null) {
                return true;
            }
        }
        return false;
    }

    public boolean eatsAtLeastOneAnimal() {
        for (Animal animal : animals) {
            if (animal != null) {
                return true;
            }
        }
        return false;
    }



}
