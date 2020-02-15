import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Developer before sort");
        List<Developer> developers = getDevelopers();
        printDeveloperList(developers , "");

        System.out.println("Developer After sort");

        System.out.println("1- Sort without Lambda");

        System.out.println("\ta- Sort by name");
        Collections.sort(developers , ClassicDeveloperComparator.byName());
        printDeveloperList(developers , "\t\t");

        System.out.println("\tb- Sort by age");
        Collections.sort(developers , ClassicDeveloperComparator.byAge());
        printDeveloperList(developers , "\t\t");

        System.out.println("\tc- Sort by salary");
        Collections.sort(developers , ClassicDeveloperComparator.bySalary());
        printDeveloperList(developers , "\t\t");

        System.out.println("2- Sort with Lambda");

        System.out.println("\ta- Sort by name");
        Collections.sort(developers , LambdaDeveloperComparator.byName());
        printDeveloperList(developers , "\t\t");

        System.out.println("\tb- Sort by age");
        Collections.sort(developers , LambdaDeveloperComparator.byAge());
        printDeveloperList(developers , "\t\t");

        System.out.println("\tc- Sort by salary");
        Collections.sort(developers , LambdaDeveloperComparator.bySalary());
        printDeveloperList(developers , "\t\t");


    }

    private static void printDeveloperList(List<Developer> developers , String space){
        developers.stream().forEach(developer ->System.out.println(space + developer));
    }

    private static List<Developer> getDevelopers() {

        List<Developer> result = new ArrayList<Developer>();

        result.add(new Developer("mkyong", new BigDecimal("70000"), 33));
        result.add(new Developer("alvin", new BigDecimal("80000"), 20));
        result.add(new Developer("jason", new BigDecimal("100000"), 10));
        result.add(new Developer("iris", new BigDecimal("170000"), 55));

        return result;

    }

}
