import Animals.Animal;

public interface Repository {
    void enterNewAnimal (Animal animal);

    void newCommandAndAction(Animal animal, String command, String action);
}
