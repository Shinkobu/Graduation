import Animals.Animal;

public class AnimalsRepository implements Repository {
    @Override
    public void enterNewAnimal(Animal animal) {
        Database.putData(animal);
    }

    @Override
    public void newCommand(Animal animal, String command, String action) {
//TODO
    }
}
