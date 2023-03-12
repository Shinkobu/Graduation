package Animals;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public abstract class Animal {
    private String name;
    private Date dateOfBirth;
    private HashMap<String,String> commandsMap;

    public Animal(String name, Date dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;

    }

    public String toString() {
        return "Кличка " + name + ", дата рождения: " + dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public HashMap<String, String> getCommandsMap() {
        return commandsMap;
    }

    public void setCommandsMap(HashMap<String, String> commandsMap) {
        this.commandsMap = commandsMap;
    }
}
