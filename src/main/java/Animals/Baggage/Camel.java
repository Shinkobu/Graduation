package Animals.Baggage;

import java.util.Date;
import java.util.HashMap;

public class Camel extends BaggageAnimal{
    public Camel(String name, Date dateOfBirth) {
        super(name, dateOfBirth);
    }

    HashMap<String,String> commandsMap = new HashMap<>(){{
        put("Лежать", "Верблюд садится");
        put("Вперёд", "Верблюд идёт вперёд");
        put("Стоп", "Верблюд остановился");}};

    @Override
    public HashMap<String, String> getCommandsMap() {
        return commandsMap;
    }

    public void addCommand(String k, String v) {
        this.commandsMap.put(k,v);
    }
}
