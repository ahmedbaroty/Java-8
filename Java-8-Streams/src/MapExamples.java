import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapExamples {

    public static void listOfStringToUpperCase(){
        System.out.println("MAP Example : list Of String To Upper Case");
        List<String> strings = Arrays.asList("asd" , "erty" , "cvbnmmnbvc");
        strings.stream().map(String::toUpperCase).collect(Collectors.toList()).forEach(System.out::println);
    }

    public static void convertListOfObjectToListOfString(){
        System.out.println("MAP Example : convert List Of Object To List Of String");
        List<Staff> staff = Arrays.asList(
                new Staff("mkyong", 30, new BigDecimal(10000)),
                new Staff("jack", 27, new BigDecimal(20000)),
                new Staff("lawrence", 33, new BigDecimal(30000))
        );

        List<String> collect = staff.stream().map(Staff::getName).collect(Collectors.toList());
        collect.forEach(System.out::println);

    }

    public static void convertObjectToAnotherObject(){
        System.out.println("MAP Example : convert List Of Object To List Of another Object");
        List<Staff> staff = Arrays.asList(
                new Staff("mkyong", 30, new BigDecimal(10000)),
                new Staff("jack", 27, new BigDecimal(20000)),
                new Staff("lawrence", 33, new BigDecimal(30000))
        );

        List<Person> mapperList =staff.stream()
                .map(staff1 -> new Person(staff1.getName() , staff1.getAge()))
                .collect(Collectors.toList());

        mapperList.forEach(System.out::println);

    }



    static public class Staff {

        private String name;
        private int age;
        private BigDecimal salary;

        public Staff(String name, int age, BigDecimal salary) {
            this.name = name;
            this.age = age;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public BigDecimal getSalary() {
            return salary;
        }

        public void setSalary(BigDecimal salary) {
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Staff{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", salary=" + salary +
                    '}';
        }
    }

    static public class Person{
        String name;
        int age;

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}
