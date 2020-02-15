import java.util.Comparator;

public class LambdaDeveloperComparator {

    static public Comparator<Developer> byName(){
        return (o11, o21) -> o11.getName().compareTo(o21.getName());
    }

    static public Comparator<Developer>byAge(){
        return (o11, o21) -> o11.getAge() - o21.getAge();
    }

    static public Comparator<Developer>bySalary(){
       return (o11, o21) -> o11.getSalary().compareTo(o21.getSalary());
    }

}
