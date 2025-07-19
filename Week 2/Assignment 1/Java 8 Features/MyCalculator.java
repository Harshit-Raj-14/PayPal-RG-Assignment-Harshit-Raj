interface Calculator {
    void add(int a, int b); // Abstract method

    // Default method
    default void show() {
        System.out.println("This is the default method in interface.");
    }

    // Static method
    static void display() {
        System.out.println("This is the static method in interface.");
    }
}

public class MyCalculator implements Calculator {
    public void add(int a, int b) {
        System.out.println("Addition: " + (a + b));
    }

    public static void main(String[] args) {
        MyCalculator calc = new MyCalculator();
        calc.add(5, 10);    // Calls abstract method
        calc.show();        // Calls default method
        Calculator.display(); // Calls static method
    }
}
