import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterExamples {

    static public void filterAndCollect() {
        System.out.println("Filter And Collect");

        List<Integer> numbers = Arrays.asList(10, 40, 25, 50, 100, 200, 500);
        System.out.print("numbers");
        numbers.stream().forEach(num -> System.out.print(" , " + num));
        System.out.println("\nFilter : num > 30 and num < 300");
        numbers.stream().filter(number -> number > 30 & number < 300).collect(Collectors.toList()).forEach(number -> System.out.print(number + " , "));
        System.out.println();
    }


    public static void filterNullValueFromStream(){
        System.out.println("Filter a null value from a Stream");
        List<String> language = Arrays.asList("java", "python", "node", null, "ruby", null, "php");
        System.out.println("Stream with null objects");
        language.forEach(System.out::println);
        System.out.println("Filter Stream  non null objects");
        language.stream().filter(Objects::nonNull).collect(Collectors.toList()).forEach(System.out::println);
    }

    static public void filterAndFindAnyAndOrElse() {
        System.out.println("filter And FindAny And OrElse");
        List<Person> persons = Arrays.asList(
                new Person("mkyong", 30),
                new Person("jack", 20),
                new Person("lawrence", 40)
        );

        Person person1 = persons
                .stream()
                .filter(person -> person.getName().equalsIgnoreCase("jack"))
                .findAny()
                .orElse(null);

        System.out.println("Person 1 " + person1);

        Person person2 = persons.stream().filter(person -> person.getName().equalsIgnoreCase("ahmed")).findAny().orElse(null);

        System.out.println("person 2 " + person2);

        System.out.println("Filter with multiple condition [find any person with name contains 'a' and age > 20] ");

        Person person3 = persons.stream().filter(person -> person.getName().contains("a") && person.getAge() > 20).findAny().orElse(null);

        System.out.println("person 3 " + person3);

    }

    static public void filterAndMap() {
        System.out.println("filter And Map");
        List<Person> persons = Arrays.asList(
                new Person("mkyong", 30),
                new Person("jack", 20),
                new Person("lawrence", 40)
        );

       String name = persons
                .stream()
                .filter(person -> person.getName().equalsIgnoreCase("jack"))
                .map(Person::getName)
                .findAny()
                .orElse("");

        System.out.println("MAP Person to name = " + name);

        List<String> names = persons
                .stream()
                .map(person -> person.getName()).collect(Collectors.toList());

        System.out.println("MAP All Persons to names");
        names.forEach(System.out::println);
    }


    static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person [" +
                    "name = '" + name + '\'' +
                    " , age = " + age +
                    " ]";
        }
    }


}
