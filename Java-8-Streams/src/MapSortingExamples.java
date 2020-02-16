import java.util.*;
import java.util.stream.Collectors;

public class MapSortingExamples {

    static public void sortByKeys() {
        System.out.println("MapSortingExamples : sort By Keys");
        Map<String, Integer> unsortMap = getUnSortedMap();
        System.out.println("Original Map ");
        System.out.println(unsortMap);

        System.out.println("MapSortingExamples : sorted MAP By Keys example 1");
        Map<String, Integer> result1 = unsortMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        System.out.println(result1);

        System.out.println("MapSortingExamples : sorted MAP By Keys example 2");
        Map<String, Integer> result2 = new LinkedHashMap<>();
        unsortMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEachOrdered(e -> result2.put(e.getKey(), e.getValue()));
        System.out.println(result2);
    }

    static public void sortByValues() {
        System.out.println("MapSortingExamples : sort By value");
        Map<String, Integer> unsortMap = getUnSortedMap();
        System.out.println("Original Map ");
        System.out.println(unsortMap);

        System.out.println("MapSortingExamples : sorted MAP By value and reversed example 1");
        Map<String, Integer> result1 = unsortMap.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        System.out.println(result1);

        System.out.println("MapSortingExamples : sorted MAP By value and reversed example 2");
        Map<String, Integer> result2 = new LinkedHashMap<>();
        unsortMap.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).forEachOrdered(e -> result2.put(e.getKey(), e.getValue()));
        System.out.println(result2);
    }


    static private Map<String, Integer> getUnSortedMap() {
        Map<String, Integer> unsortMap = new HashMap<>();
        unsortMap.put("z", 10);
        unsortMap.put("b", 5);
        unsortMap.put("a", 6);
        unsortMap.put("c", 20);
        unsortMap.put("d", 1);
        unsortMap.put("e", 7);
        unsortMap.put("y", 8);
        unsortMap.put("n", 99);
        unsortMap.put("g", 50);
        unsortMap.put("m", 2);
        unsortMap.put("f", 9);
        return unsortMap;
    }

    static public void sortMapOfObjectKeyAndObjectValue() {
        System.out.println("sortMapOfObjectKeyAndObjectValue : sort the Map<Object,Object>");
        Properties properties = System.getProperties();
        System.out.println(properties);

        Set<Map.Entry<Object , Object>> entries = properties.entrySet();
        LinkedHashMap<String , String> collect =
                entries
                        .stream()
                        .collect(Collectors.toMap(k -> (String)k.getKey() , v -> (String)v.getValue()))
                        .entrySet()
                        .stream()
                        .sorted(Map.Entry.comparingByKey())
                        .collect(Collectors.toMap(Map.Entry::getKey , Map.Entry::getValue , (v1 ,v2) -> v1 , LinkedHashMap::new));

        collect.forEach((k , v) -> System.out.println(k + " : " + v));
    }

}
