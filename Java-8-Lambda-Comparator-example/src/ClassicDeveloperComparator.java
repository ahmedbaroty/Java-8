import java.util.Comparator;

public class ClassicDeveloperComparator {

    static public Comparator<Developer>byName(){
        return new Comparator<Developer>() {
            @Override
            public int compare(Developer o1, Developer o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
    }

    static public Comparator<Developer>byAge(){
        return new Comparator<Developer>() {
            @Override
            public int compare(Developer o1, Developer o2) {
                return o1.getAge() - o2.getAge();
            }
        };
    }

    static public Comparator<Developer>bySalary(){
        return new Comparator<Developer>() {
            @Override
            public int compare(Developer o1, Developer o2) {
                return o1.getSalary().compareTo(o2.getSalary());
            }
        };
    }

}
