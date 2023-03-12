import Animals.Animal;

import java.util.ArrayList;
import java.util.List;

public class Database {

    private static final List<Animal> ANIMALS_DATABASE = new ArrayList<>();

    public static void putData(Animal animal) {
        ANIMALS_DATABASE.add(animal);
    }

    public static void showDB() {

        for (var element : ANIMALS_DATABASE) {
            System.out.println(element.toString());
        }
    }


    public static List<Animal> getDatabase() {
        return ANIMALS_DATABASE;
    }
}
