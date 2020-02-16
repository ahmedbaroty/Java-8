import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class OperatedStreamHandlingExample {

    static public void closedStreamProblem(){
        System.out.println("closed Stream Problem ");
        String[] array = {"a", "b", "c", "d", "e"};
        Stream<String> stream = Arrays.stream(array);
        // loop a stream
        stream.forEach(x -> System.out.println(x));

        System.out.println("reuse it to filter again! throws IllegalStateException");
        // reuse it to filter again! throws IllegalStateException
        long count = stream.filter(x -> "b".equals(x)).count();
        System.out.println(count);
    }

    static public void workingWithClosedStream(){
        System.out.println("working With Closed Stream");
        String[] array = {"a", "b", "c", "d", "e"};
        System.out.println("working With Closed Stream round 1");
        Supplier<Stream<String>> supplier = () -> Arrays.stream(array);
        supplier.get().forEach(System.out::println);
        System.out.println("working With Closed Stream round 2");
        supplier.get().map(String::toUpperCase).forEach(System.out::println);


    }
}
