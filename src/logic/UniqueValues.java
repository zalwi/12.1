package logic;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.*;

public class UniqueValues {

    Map<String, Integer> uniqueValuesAndCounters;

    public UniqueValues(ArrayList<String> values) {
        uniqueValuesAndCounters = new TreeMap<String, Integer>();
        fillMap(values);
    }

    private void fillMap(List<String> values) {
        for (String val : values) {
            addUniqueValeuOrIncreaseCounter(val);
        }
    }

    private void addUniqueValeuOrIncreaseCounter(String value) {
        if (uniqueValuesAndCounters.containsKey(value)) {
            int counter = uniqueValuesAndCounters.get(value);
            uniqueValuesAndCounters.put(value, ++counter);
        } else {
            uniqueValuesAndCounters.put(value, 1);
        }
    }

    public void printUniqueValuesAndCounters(boolean onlyNumbers) {
        Set<Map.Entry<String, Integer>> entries = uniqueValuesAndCounters.entrySet();
        for (Map.Entry entry : entries) {
            if (onlyNumbers) {
                if (NumberUtils.isParsable(entry.getKey().toString())) { // drukuj tylko liczby
                    System.out.println("'" + entry.getKey() + "'\t\t– liczba wystąpień:\t" + entry.getValue());
                }
            } else {
                System.out.println("'" + entry.getKey() + "'\t\t– liczba wystąpień:\t" + entry.getValue());
            }
        }
    }
}
