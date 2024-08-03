package register;

import java.util.ArrayList;
import java.util.List;

import animals.Animal;

public class AnimalRegistry {
    private List<Animal> animals;

    public AnimalRegistry() {
        this.animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void removeAnimal(String name) {
        animals.removeIf(animal -> animal.getName().equals(name));
    }

    public List<String> getAnimalCommands(String name) {
        for (Animal animal : animals) {
            if (animal.getName().equals(name)) {
                return animal.getCommands();
            }
        }
        return null;
    }

    public void trainAnimal(String name, String command) {
        for (Animal animal : animals) {
            if (animal.getName().equals(name)) {
                animal.addCommand(command);
            }
        }
    }

    public List<String> listAnimals() {
        List<String> names = new ArrayList<>();
        for (Animal animal : animals) {
            names.add(animal.getName());
        }
        return names;
    }
}