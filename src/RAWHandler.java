import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is the heart of the filemanagement system, it reads the Textfiles line by line and splits them into
 * a String array by semicolons, which means a string of 31380293;ufhuwfj gets split into 31380293 and ufhuwfj
 * It also writes the data to the textfiles(.txt), and adds new data to the file.
 */
public class RAWHandler {

    String file;

    public RAWHandler(String fileName) {
        file = fileName;
    }

    //one line at a time
    String line = null;

    //hashmap
    Map<String, String> hm = new HashMap();

    public Map<String, String> read() {
        try {
            //initialize reader standard encoding
            FileReader fileReader = new FileReader(file);

            //Wrap FileReader in BufferedReader
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(";");
                hm.put(parts[0], parts[1]);
            }

            //Closes BufferedReader
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File could not be found");
            System.out.println("Trying to create file");
            write();
        } catch (IOException ex) {
            System.out.println("Unable to read file");
        }
        return hm;
    }

    //To add a new User
    public void add(String var1, String var2) {
        //just in case the file was changed in the meantime
        read();
        hm.put(var1, var2);
        //System.out.println(hm);
        write();
    }

    private void write() {
        try {
            // Assume default encoding.
            FileWriter fileWriter = new FileWriter(file);

            // wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (Map.Entry<String, String> entry : hm.entrySet()) {
                bufferedWriter.write(entry.getKey());
                bufferedWriter.write(";");
                bufferedWriter.write(entry.getValue());
                bufferedWriter.newLine();
            }

            // closes file
            bufferedWriter.close();
        } catch (IOException ex) {
            System.out.println("Error writing to file");
        }
    }
}
