import Animals.Animal;
import Animals.Baggage.Camel;
import Animals.Baggage.Donkey;
import Animals.Baggage.Horse;
import Animals.Domestic.Cat;
import Animals.Domestic.Dog;
import Animals.Domestic.Hamster;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Controller {

    public static int mainMenu() {

        System.out.println("\nВыберите действие\n");
        Scanner myScan = new Scanner(System.in);
        System.out.println("Введите желаемую операцию:\n" +
                "1 - Добавить животное\n" +
                "2 - Вывести список животных\n" +
                "3 - Информация по животному\n" +
                "9 - Завершить работу \n");

        int choice = 0;
        choice = Integer.parseInt(myScan.nextLine());
        return choice;
    }

    public static void animalMenu(Animal animal) throws IOException {

        System.out.println("\nВыберите действие\n");
        Scanner myScan = new Scanner(System.in);
        System.out.println("Введите желаемую операцию:\n" +
                "1 - Показать умения животного\n" +
                "2 - Обучить животное новым командам\n" +
                "9 - В основное меню \n");

        int choice = 0;
        choice = Integer.parseInt(myScan.nextLine());

        switch (choice) {
            case 1:

                for (String name: animal.getCommandsMap().keySet()) {
                    String key = name.toString();
                    String value = animal.getCommandsMap().get(name).toString();
                    System.out.println("Команда: " + key + ". Действие: " + value);
                }
                animalMenu(animal);
                break;
            case 2:
                Scanner myScanner = new Scanner(System.in);
                System.out.println("Введите команду");
                String newCommand = myScanner.nextLine();
                System.out.println("Введите действие животного");
                String newAction = myScanner.nextLine();
                AnimalsRepository myAnimalsRepository = new AnimalsRepository();
                myAnimalsRepository.newCommandAndAction(animal, newCommand, newAction);

                animalMenu(animal);
                break;

            case 9:
                mainMenuRun();
                break;
        }
    }


    public static void mainMenuRun() throws IOException {
        int choice = mainMenu();

        switch (choice) {
            case 1:
                newAnimal();
                break;
            case 2:
                System.out.println("\nБаза данных имеет вид:\n");
                Database.showDB();
                break;
            case 3:
                findAnimalByName();
                break;
        }
        if (choice != 9) {
            mainMenuRun();
        }else {
            System.exit(1);
        }
    }

    public static void newAnimal() throws IOException {

        Scanner myScan = new Scanner(System.in);
        System.out.println("Введите кличку животного: \n");
        String animalName = myScan.nextLine();


        Date birthDate = DateReader("");


        System.out.println("Выберите вид животного: \n" +
                "1 - Кошка \n" +
                "2 - Собака \n" +
                "3 - Хомяк \n" +
                "4 - Осёл \n" +
                "5 - Верблюд \n" +
                "6 - Лошадь \n");

        int tempPrior = Integer.parseInt(myScan.nextLine());


        Animal newAnimal = null;
        switch (tempPrior) {
            case 1:
                newAnimal = new Cat(animalName, birthDate);
                break;
            case 2:
                newAnimal = new Dog(animalName, birthDate);
                break;
            case 3:
                newAnimal = new Hamster(animalName, birthDate);
                break;
            case 4:
                newAnimal = new Donkey(animalName, birthDate);
                break;
            case 5:
                newAnimal = new Camel(animalName, birthDate);
                break;
            case 6:
                newAnimal = new Horse(animalName, birthDate);
                break;
        }

        AnimalsRepository animalsRepo = new AnimalsRepository();
        animalsRepo.enterNewAnimal(newAnimal);
        System.out.println("\nЖивотное успешно добавлено в базу данных\n");
        System.out.println("\nБаза данных имеет вид:\n");

        Database.showDB();

    }

    public static void findAnimalByName() throws IOException {
        Scanner myScan = new Scanner(System.in);

        System.out.println("\nБаза данных имеет вид:\n");
        Database.showDB();

        System.out.println("Введите имя животного\n");
        String tempName = myScan.nextLine();

        AnimalsRepository animalsRepository = new AnimalsRepository();

        Animal foundAnimal = animalsRepository.findByName(tempName);

        if (foundAnimal != null) {
            System.out.println("\nЖивотное " + tempName + " найдено!");
            System.out.println(foundAnimal.toString());
            int index = foundAnimal.getIndexInDb();
            animalMenu(foundAnimal);
        } else {
            System.out.println("\nЖивотное " + tempName + " не найдено!");
            System.out.println("\nБаза данных имеет вид:\n");
            Database.showDB();
        }

    }

    public static Date DateReader(String rawDate) {

        Scanner dateScanner = new Scanner(System.in);
        System.out.println("Введите дату рождения в формате dd-MM-yyyy: \n");
        rawDate = dateScanner.nextLine();

        Date tempDate = null;
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

        try {
            tempDate = df.parse(rawDate);
        } catch (NumberFormatException | ParseException ignored) {
            System.out.println("Ошибка распознавания даты, попробуйте ещё раз");
            tempDate = DateReader("");
        }
        return tempDate;
    }

}
