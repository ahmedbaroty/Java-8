import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectorsExample {

    public static void groupByListAndDisplayTheTotalCountOfIt() {
        System.out.println("Group by a List and display the total count of it");

        List<String> items =
                Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");

        Map<String, Long> result = items.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("before sorting");
        result.forEach((k, v) -> System.out.println(k + " = " + v));

        System.out.println("after sorting by key");
        result.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEachOrdered(stringLongEntry -> System.out.println(stringLongEntry.getKey() + " = " + stringLongEntry.getValue()));

        System.out.println("after sorting by Max Value ");
        result.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()).forEachOrdered(stringLongEntry -> System.out.println(stringLongEntry.getKey() + " = " + stringLongEntry.getValue()));
    }


    public static void groupByListOfUserDefinedObjects() {
        System.out.println("Examples to ‘group by’ a list of user defined Objects");
        List<Item> items = Arrays.asList(
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 20, new BigDecimal("19.99")),
                new Item("orang", 10, new BigDecimal("29.99")),
                new Item("watermelon", 10, new BigDecimal("29.99")),
                new Item("papaya", 20, new BigDecimal("9.99")),
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 10, new BigDecimal("19.99")),
                new Item("apple", 20, new BigDecimal("9.99"))
        );
        System.out.println("All Items list");
        items.forEach(System.out::println);

        // Group by the name + Count or Sum the Qty.
        System.out.println("All Items Group by the name + Count");
        Map<String , Long> count = items.stream().collect(Collectors.groupingBy(Item::getName , Collectors.counting()));
        count.forEach((k,v)-> System.out.println(k + " = " + v));

        System.out.println("All Items Group by the name + Count and sorted by count");
        count.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEachOrdered(e -> System.out.println(e.getKey() + " = " + e.getValue()));

        System.out.println("All Items Group by the name + Sum the Qty");
        Map<String , Integer> sum = items.stream().collect(Collectors.groupingBy(Item::getName , Collectors.summingInt(Item::getQty)));
        sum.forEach((k,v)-> System.out.println(k + " = " + v));

        System.out.println("All Items Group by the name + sum and sorted reversed by sum ");
        sum.entrySet().stream().sorted(Map.Entry.<String , Integer>comparingByValue().reversed()).forEachOrdered(e -> System.out.println(e.getKey() + " = " + e.getValue()));

        System.out.println("All Items Group by Price");

        Map<BigDecimal , List<Item>> groubedByPrice = items.stream().collect(Collectors.groupingBy(Item::getPrice));
        System.out.println(groubedByPrice);

        System.out.println("All Items Group by Price and sorting by price reversed");

        groubedByPrice.entrySet().stream().sorted(Map.Entry.<BigDecimal , List<Item>>comparingByKey().reversed()).forEachOrdered(e -> System.out.println(e));

    }


    static public class Item {

        private String name;
        private int qty;
        private BigDecimal price;

        public Item(String name, int qty, BigDecimal price) {
            this.name = name;
            this.qty = qty;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getQty() {
            return qty;
        }

        public void setQty(int qty) {
            this.qty = qty;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "name='" + name + '\'' +
                    ", qty=" + qty +
                    ", price=" + price +
                    '}';
        }
    }

}
