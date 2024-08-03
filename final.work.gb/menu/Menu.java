package menu;

import java.util.List;
import java.util.Scanner;

import animals.Animal;
import animals.domestic_animals.Cat;
import animals.domestic_animals.Dog;
import animals.domestic_animals.Hamster;
import animals.pack_animals.Camel;
import animals.pack_animals.Donkey;
import animals.pack_animals.Horse;
import register.AnimalRegistry;
import utils.Counter;

public class Menu {
    private AnimalRegistry registry;
    private Counter counter;
    private Scanner scanner;

    public Menu(AnimalRegistry registry, Counter counter) {
        this.registry = registry;
        this.counter = counter;
        this.scanner = new Scanner(System.in);
    }

    public void show() {
        boolean running = true;

        while (running) {
            System.out.println("\nМеню:");
            System.out.println("1. Добавить животное");
            System.out.println("2. Удалить животное");
            System.out.println("3. Обучить животное");
            System.out.println("4. Показать команды животного");
            System.out.println("5. Показать всех животных");
            System.out.println("6. Показать количество животных");
            System.out.println("0. Выйти");
            System.out.print("Выберите опцию: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addAnimal();
                    break;
                case 2:
                    removeAnimal();
                    break;
                case 3:
                    trainAnimal();
                    break;
                case 4:
                    showCommands();
                    break;
                case 5:
                    listAnimals();
                    break;
                case 6:
                    showAnimalCount();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    private void addAnimal() {
        System.out.print("Введите тип животного (Dog, Cat, Hamster, Horse, Camel, Donkey): ");
        String type = scanner.nextLine();
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();
        System.out.print("Введите дату рождения животного (yyyy-mm-dd): ");
        String birthDate = scanner.nextLine();

        Animal animal;
        switch (type.toLowerCase()) {
            case "dog":
                animal = new Dog(name, birthDate);
                break;
            case "cat":
                animal = new Cat(name, birthDate);
                break;
            case "hamster":
                animal = new Hamster(name, birthDate);
                break;
            case "horse":
                animal = new Horse(name, birthDate);
                break;
            case "camel":
                animal = new Camel(name, birthDate);
                break;
            case "donkey":
                animal = new Donkey(name, birthDate);
                break;
            default:
                System.out.println("Неверный тип животного");
                return;
        }
        registry.addAnimal(animal);
        counter.add();
        System.out.println("Животное добавлено.");
    }

    private void removeAnimal() {
        System.out.print("Введите имя животного для удаления: ");
        String removeName = scanner.nextLine();
        registry.removeAnimal(removeName);
        System.out.println("Животное удалено.");
    }

    private void trainAnimal() {
        System.out.print("Введите имя животного для обучения: ");
        String trainName = scanner.nextLine();
        System.out.print("Введите команду: ");
        String command = scanner.nextLine();
        registry.trainAnimal(trainName, command);
        System.out.println("Животное обучено.");
    }

    private void showCommands() {
        System.out.print("Введите имя животного для показа команд: ");
        String commandName = scanner.nextLine();
        List<String> commands = registry.getAnimalCommands(commandName);
        if (commands != null) {
            System.out.println("Команды " + commandName + ": " + commands);
        } else {
            System.out.println("Животное не найдено.");
        }
    }

    private void listAnimals() {
        System.out.println("Список животных: " + registry.listAnimals());
    }

    private void showAnimalCount() {
        System.out.println("Количество животных: " + counter.getCount());
    }
}
