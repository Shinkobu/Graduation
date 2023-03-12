package Animals.Domestic;

import java.util.Date;
import java.util.HashMap;

public class Cat extends DomesticAnimal {

    String className = "Кот";

    public String getClassName() {
        return className;
    }

    HashMap<String,String> commandsMap = new HashMap<>(){{
        put("Сказать кис-кис", "Кошка говорит мяу");
        put("Дать молока", "Кошка пьёт молоко");
        put("Кинуть мячик", "Кошка бежит за мячиком");}};

//    @Override
//    public String toString() {
//        return "Cat{" +
//                "commandsMap=" + commandsMap +
//                "} " + super.toString();
//    }

    @Override
    public HashMap<String, String> getCommandsMap() {
        return commandsMap;
    }

    public void addCommand(String k, String v) {
        this.commandsMap.put(k,v);
    }

    public Cat(String name, Date dateOfBirth) {
        super(name, dateOfBirth);
    }
}
