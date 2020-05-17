import logic.DataReader;
import logic.UniqueValues;

import javax.xml.crypto.Data;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Wczytaj wartości z pliku
        ArrayList<String> values = DataReader.readValuesFromFile("data.dat");
        //Utwórz kontener z mapą
        UniqueValues uniqueValues = new UniqueValues(values);
        //Drukuj wszystkie unikalne wartości oraz ich ilość wystąpień
        uniqueValues.printUniqueValuesAndCounters(false);
        System.out.println("-- Tylko liczby --");
        uniqueValues.printUniqueValuesAndCounters(true);
    }
}
