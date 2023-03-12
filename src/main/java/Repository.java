import Animals.Animal;

import java.util.HashMap;

public interface Repository {
    void enterNewAnimal (Animal animal);

    void newCommand (Animal animal, String command, String action);
}
