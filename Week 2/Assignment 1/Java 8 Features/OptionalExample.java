import java.util.Optional;
public class OptionalExample {
    public static void main(String[] args) {
        String name = "Harshit";
        Optional<String> optionalName = Optional.ofNullable(name);
        if (optionalName.isPresent()) {
            System.out.println("Name is: " + optionalName.get());
        } else {
            System.out.println("Name is not available");
        }
    }
}
