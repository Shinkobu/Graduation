import Animals.Animal;

import java.util.Iterator;
import java.util.List;

public class AnimalsRepository implements Repository {
    @Override
    public void enterNewAnimal(Animal animal) {
        Database.putData(animal);
    }

    @Override
    public void newCommand(Animal animal, String command, String action) {
//TODO
    }

    public Animal findByName(String nameToFind) {
        List<Animal> tempDB = Database.getDatabase();
        boolean isFound = false;
        Animal tempAnimal = null;
        Animal foundTask = null;

        Iterator<Animal> animalIterator = tempDB.iterator();
        while(animalIterator.hasNext() && !isFound){
            tempAnimal = animalIterator.next();
            if(tempAnimal.getName().equals(nameToFind)){
                isFound = true;
                foundTask = tempAnimal;

            }
        }
        return foundTask;
    }
}
