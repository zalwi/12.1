package logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public abstract class DataReader {

    public static ArrayList<String> readValuesFromFile(String fileName){
        ArrayList<String> values = new ArrayList<>();
        try(
                var fileReader = new FileReader(fileName);
                var reader = new BufferedReader(fileReader);
        ){
            String nextLine = null;
            while ((nextLine = reader.readLine()) != null) {
                values.add(nextLine);
            }
        } catch(IOException e){
            e.printStackTrace();
        }
        return values;
    }
}
