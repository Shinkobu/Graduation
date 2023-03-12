package Animals.Baggage;

import java.util.Date;
import java.util.HashMap;

public class Horse extends BaggageAnimal{
    public Horse(String name, Date dateOfBirth) {
        super(name, dateOfBirth);
    }

    String className = "Лошадь";

    public String getClassName() {
        return className;
    }

    HashMap<String, String> commandsMap = new HashMap<>() {{
        put("Прыжок", "Лошадь прыгает");
        put("Вперёд", "Лошадь идёт вперёд");
        put("Стоп", "Лошадь остановилась");
    }};

    @Override
    public HashMap<String, String> getCommandsMap() {
        return commandsMap;
    }

    public void addCommand(String k, String v) {
        this.commandsMap.put(k, v);
    }
}
