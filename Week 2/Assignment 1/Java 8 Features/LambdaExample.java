import java.util.*;  

public class LambdaExample {  
    public static void main(String[] args) {  
        // List of numbers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);  

        // Using lambda to print each number
        numbers.forEach(n -> System.out.println("Number: " + n));  
    }  
}
