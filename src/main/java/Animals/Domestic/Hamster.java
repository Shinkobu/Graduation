package Animals.Domestic;

import java.util.Date;
import java.util.HashMap;

public class Hamster extends DomesticAnimal {
    public Hamster(String name, Date dateOfBirth) {
        super(name, dateOfBirth);
    }

    HashMap<String,String> commandsMap = new HashMap<>(){{
        put("Почесать за ушком", "Фыр-фыр");
        put("Дать еды", "Хомяк ест");
        put("В лоток!", "Хомяк лезет в лоток");}};

    @Override
    public HashMap<String, String> getCommandsMap() {
        return commandsMap;
    }

    public void addCommand(String k, String v) {
        this.commandsMap.put(k,v);
    }
}
