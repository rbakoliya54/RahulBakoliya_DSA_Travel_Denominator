package denominations;

public class Main {
    public static void main(String[] args) {

        DenominationsCalculator denominationsCalculator = new DenominationsCalculator();
        denominationsCalculator.collectDenominations();
        denominationsCalculator.collectPaymentAmount();
        denominationsCalculator.calculate();
    }
}