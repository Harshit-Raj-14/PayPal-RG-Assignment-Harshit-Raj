import java.util.Arrays;
import java.util.List;

public class MethodReferenceExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Harshit", "Raj", "Java", "Stream");

        // Using lambda expression
        System.out.println("Using Lambda:");
        names.forEach(name -> System.out.println(name));

        // Using method reference
        System.out.println("\nUsing Method Reference:");
        names.forEach(System.out::println);
    }
}
