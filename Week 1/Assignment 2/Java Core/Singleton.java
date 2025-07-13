public class Singleton {
    private static Singleton singleInstance;

    private Singleton() {
        System.out.println("Singleton instance created!");
    }

    public static Singleton getInstance() {
        if (singleInstance == null) {
            singleInstance = new Singleton();
        }
        return singleInstance;
    }

    public void showMessage() {
        System.out.println("Hello from Singleton!");
    }

    public static void main(String[] args) {
        Singleton obj1 = Singleton.getInstance();
        obj1.showMessage();

        Singleton obj2 = Singleton.getInstance();
        obj2.showMessage();

        System.out.println("obj1 and obj2 are the same instance: " + (obj1 == obj2));
    }
}
