package logic;

import java.util.*;

public class UniqueValues {

    Map<String, Integer> UniqueValuesAndCounters;

    public UniqueValues(ArrayList<String> values) {
        UniqueValuesAndCounters = new TreeMap<String, Integer>();
        fillMap(values);
    }

    private void fillMap(ArrayList<String> values) {
        for (String val : values) {
            addUniqueValeuOrIncreaseCounter(val);
        }
    }

    private void addUniqueValeuOrIncreaseCounter(String value) {
        if (UniqueValuesAndCounters.containsKey(value)) {
            int counter = UniqueValuesAndCounters.get(value);
            UniqueValuesAndCounters.put(value, ++counter);
        } else {
            UniqueValuesAndCounters.put(value, 1);
        }
    }

    public void printUniqueValuesAndCounters(boolean onlyNumbers) {
        Set<Map.Entry<String, Integer>> entries = UniqueValuesAndCounters.entrySet();
        for (Map.Entry entry : entries) {
            if (onlyNumbers) {
                if (isNumeric(entry.getKey().toString())) { // drukuj tylko liczby
                    System.out.println("'" + entry.getKey() + "'\t\t– liczba wystąpień:\t" + entry.getValue());
                }
            } else {
                System.out.println("'" + entry.getKey() + "'\t\t– liczba wystąpień:\t" + entry.getValue());
            }
        }
    }

    private boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
