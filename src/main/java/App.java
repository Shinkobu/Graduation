import Animals.Animal;
import Animals.Baggage.Camel;
import Animals.Baggage.Donkey;
import Animals.Baggage.Horse;
import Animals.Domestic.Cat;
import Animals.Domestic.Dog;
import Animals.Domestic.Hamster;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class App {
    public static void main(String[] args) throws ParseException, IOException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        Animal sava = new Cat("Sava", dateFormat.parse("01-01-2012"));
        Animal sharik = new Dog("Sharik", dateFormat.parse("15-01-2015"));
        Animal mitrich = new Hamster("Mitrich", dateFormat.parse("01-01-2020"));
        Animal immanuil = new Camel("Immanuil", dateFormat.parse("15-01-2015"));
        Animal bucefal = new Donkey("Bucefal", dateFormat.parse("01-01-2012"));
        Animal pegas = new Horse("Pegas", dateFormat.parse("15-01-2015"));

        System.out.println(sava.getCommandsMap());
        ((Cat) sava).addCommand("Прыжок", "Кошка прыгает");

//        System.out.println(sava.getCommandsMap());
//        System.out.println(sharik.getCommandsMap());
//        System.out.println(mitrich.getCommandsMap());
//        System.out.println(immanuil.getCommandsMap());
//        System.out.println(bucefal.getCommandsMap());
//        System.out.println(pegas.getCommandsMap());

        Database.putData(sava);
        Database.putData(sharik);
        Database.putData(mitrich);
        Database.putData(immanuil);
        Database.putData(bucefal);
        Database.putData(pegas);

        Controller.mainMenuRun();

    }
}
