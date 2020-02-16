import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamConverterExamples {

    static public void convertStreamToList(){

        System.out.println("Convert a Stream to List example" );
        Stream<String> language = Stream.of("java", "python", "node");

        List<String> convertedStreamToList = language.collect(Collectors.toList());
        convertedStreamToList.stream().forEach(System.out::println);
    }

    static public void convertArrayToStream(){
        System.out.println("convert Array to Stream" );
        String[] array = {"a", "b", "c", "d", "e"};

        System.out.println("convert Array to Stream - Stream.of" );
        Stream<String> stream1 = Stream.of(array);
        stream1.forEach(System.out::println);

        System.out.println("convert Array to Stream - Arrays.stream" );
        Stream<String> stream2 = Arrays.stream(array);
        stream2.forEach(System.out::println);

    }


    static public void convertPrimitiveArraysToStream(){
        System.out.println("convert Primitive Arrays to Stream" );
        int[] intArray = {1, 2, 3, 4, 5};

        System.out.println("convert Primitive Arrays to Stream - IntStream.of" );
        IntStream intStream1 = IntStream.of(intArray);
        intStream1.forEach(System.out::println);

        System.out.println("convert Primitive Arrays to Stream - Arrays.stream" );
        IntStream intStream2 = Arrays.stream(intArray);
        intStream2.forEach(System.out::println);

    }

}
