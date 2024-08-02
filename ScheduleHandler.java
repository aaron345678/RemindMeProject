import java.util.*;
public class ScheduleHandler {
    private CSVHandler csvHandler;
    private HashMap<String,String> data;
    public ScheduleHandler() {
        csvHandler = new CSVHandler();
        data = csvHandler.getData();
    }
    public int addEvent(String eventName, String date) {
        String[] dateSplit = date.split(".");
        int index = 0;
        for(String word : dateSplit) {
            char character = word.charAt(index);
            if(!Character.isDigit(character)) {
                System.err.println("Error in adding event " + dateSplit[0]);
                return -1;
            } else {
                data.put(dateSplit[0],dateSplit[1]);
            } 
        }
    return 1;
    }
    public int removeEvent(String name) {
        data.remove(name);
        return 1;
    }
    public int changeEvent(String typeOfchange, String eventName) {
        if(typeOfchange.toLowerCase().equals("date change")) {
            
        }
        return 1;
    }
}
