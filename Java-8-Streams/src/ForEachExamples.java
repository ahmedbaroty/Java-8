import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForEachExamples {

    static public void foreachAndList(){
        System.out.println("Foreach and List example");
        List<String> names = new ArrayList<String>();
        names.add("Ahmed");
        names.add("Mona");
        names.add("Ayman");

        names.stream().forEach(name -> System.out.println(name));
        System.out.println();
    }

    static public void foreachAndMap(){
        System.out.println("Foreach and Map example");
        Map<Integer , String> names = new HashMap<Integer , String>();
        names.put(1 , "Ahmed");
        names.put(2 , "Mona");
        names.put(3 , "Ayman");
        names.forEach((key , name) -> System.out.println(key + " -> " + name));
    }
}
