package Animals.Domestic;

import java.util.Date;
import java.util.HashMap;

public class Dog extends DomesticAnimal {
    public Dog(String name, Date dateOfBirth) {
        super(name, dateOfBirth);
    }

    String className = "Собака";

    public String getClassName() {
        return className;
    }
    HashMap<String,String> commandsMap = new HashMap<>(){{
        put("Ко мне", "Собака бежит к хозяину");
        put("Голос", "Гав-гав");
        put("Кинуть палку", "Собака бежит за палкой");}};

    @Override
    public HashMap<String, String> getCommandsMap() {
        return commandsMap;
    }

    public void addCommand(String k, String v) {
        this.commandsMap.put(k,v);
    }
}
