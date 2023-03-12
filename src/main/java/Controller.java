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
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class Controller {

    public static int menu() {

        System.out.println("\nВыберите действие\n");
        Scanner myScan = new Scanner(System.in);
        System.out.println("Введите желаемую операцию:\n" +
                "1 - Добавить животное\n" +
                "2 - Вывести список животных\n" +
                "3 - Найти животное по кличке\n" +
                "9 - Завершить работу \n");

        int choice = 0;
        choice = Integer.parseInt(myScan.nextLine());
        return choice;
    }


    public static void run() throws IOException {
        int choice = menu();

        switch (choice) {
            case 1:
                newAnimal();
                break;
            case 2:
                System.out.println("\nБаза данных имеет вид:\n");
                Database.showDB();
                break;
            case 3:
                break;
        }

        if (choice != 9) {
            run();
        }
    }


    public static void newAnimal() throws IOException {

        Scanner myScan = new Scanner(System.in);
        System.out.println("Введите кличку животного: \n");
        String animalName = myScan.nextLine();


        Date birthDate = DataReader("");


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

    public static Date DataReader(String rawDate) {

        Scanner dateScanner = new Scanner(System.in);
        System.out.println("Введите дату рождения в формате dd-MM-yyyy: \n");
        rawDate = dateScanner.nextLine();

        Date tempDate = null;
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

        try {
            tempDate = df.parse(rawDate);
        } catch (NumberFormatException | ParseException ignored) {
            System.out.println("Ошибка распознавания даты, попробуйте ещё раз");
             tempDate = DataReader("");
        }
        return tempDate;
    }
}
