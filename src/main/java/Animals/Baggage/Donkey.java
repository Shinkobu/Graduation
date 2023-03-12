package Animals.Baggage;

import java.util.Date;
import java.util.HashMap;

public class Donkey extends BaggageAnimal {

    public Donkey(String name, Date dateOfBirth) {
        super(name, dateOfBirth);
    }
    HashMap<String, String> commandsMap = new HashMap<>() {{
        put("Прыжок", "Осёл прыгает");
        put("Вперёд", "Осёл идёт вперёд");
        put("Стоп", "Осёл остановился");
    }};

    @Override
    public HashMap<String, String> getCommandsMap() {
        return commandsMap;
    }

    public void addCommand(String k, String v) {
        this.commandsMap.put(k, v);
    }
}

