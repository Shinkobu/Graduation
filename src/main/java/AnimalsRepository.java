import Animals.Animal;

import java.util.Iterator;
import java.util.List;

public class AnimalsRepository implements Repository {
    @Override
    public void enterNewAnimal(Animal animal) {
        Database.addAnimal(animal);
    }

    @Override
    public void newCommandAndAction(Animal animal, String command, String action) {

        animal.addCommand(command,action);
        Database.addCommandAndAction(animal);
    }

    public Animal findByName(String nameToFind) {
        List<Animal> tempDB = Database.getDatabase();
        boolean isFound = false;
        Animal tempAnimal = null;
        Animal foundAnimal = null;

        Iterator<Animal> animalIterator = tempDB.iterator();
        while (animalIterator.hasNext() && !isFound) {
            tempAnimal = animalIterator.next();
            if (tempAnimal.getName().equals(nameToFind)) {
                isFound = true;
                foundAnimal = tempAnimal;
                foundAnimal.setIndexInDb(tempDB.indexOf(tempAnimal));
            }
        }
        return foundAnimal;
    }
}
