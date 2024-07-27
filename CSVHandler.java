import java.util.HashMap;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class CSVHandler {
    private Scanner scanner;
    private HashMap<String,String> scheduleMap;
    public CSVHandler() {
        scheduleMap = new HashMap<String,String>();
        scanner = new Scanner(Constants.filePath);
        try {
            while(scanner.hasNext()) {
                String text = scanner.nextLine();
                String[] text2 = text.split(",");
                scheduleMap.put(text2[0],text2[1]);
            }
            scanner.close();

        } catch(Exception e) {
            System.err.println("FILE NOT READ");
        }
    }
    public HashMap<String,String> getData() {
        return scheduleMap;
    }
    public void saveData(HashMap<String,String> newMap) {
        File file = new File((Constants.filePath));
        try {
            FileWriter writer = new FileWriter(file);
            for(Map.Entry<String,String> entry:newMap.entrySet()) {
                String date = entry.getKey();
                String event = entry.getValue();
                writer.write(date + "," + event);
            }
        }catch(IOException o) {
            System.err.println("Error in CSVHandler getData method");
        }
    }
}
