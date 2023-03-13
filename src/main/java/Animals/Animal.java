package Animals;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public abstract class Animal {
    private String name;
    private Date dateOfBirth;
    private int indexInDb;

    public int getIndexInDb() {
        return indexInDb;
    }

    public void setIndexInDb(int indexInDb) {
        this.indexInDb = indexInDb;
    }

    String className = "Животное";

    public String getClassName() {
        return className;
    }

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    private HashMap<String,String> commandsMap = new HashMap<>();

//    public HashMap<String,String> putCommandAndAction (String command, String action){
//        commandsMap.put(command,action);
//        return commandsMap;
//    }
    public Animal(String name, Date dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;

    }

    public String toString() {
        return "Вид "+ getClassName() + ", кличка " + name + ", дата рождения: " + dateFormat.format(dateOfBirth);
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

    public void addCommand(String k, String v) {
        this.commandsMap.put(k, v);
    }
}
