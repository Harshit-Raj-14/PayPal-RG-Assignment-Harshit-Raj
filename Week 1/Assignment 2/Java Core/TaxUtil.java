public class TaxUtil {
    public double calculateTax(double amount, double rate) {
        return amount * rate;
    }

    public static void main(String[] args) {
        TaxUtil taxUtil = new TaxUtil();

        double amount1 = 1000;
        double rate1 = 0.15;
        double tax1 = taxUtil.calculateTax(amount1, rate1);
        System.out.println("Tax for amount " + amount1 + " at rate " + rate1 + " is: " + tax1);

        double amount2 = 2000;
        double rate2 = 0.18;
        double tax2 = taxUtil.calculateTax(amount2, rate2);
        System.out.println("Tax for amount " + amount2 + " at rate " + rate2 + " is: " + tax2);
    }
}
