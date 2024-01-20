package denominations;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class DenominationsCalculator {

    Integer[] denominations;
    Integer paymentAmount;

    Scanner input;

    public DenominationsCalculator() {
        input = new Scanner(System.in);
    }
    void collectDenominations () {

        System.out.println("Denominations: ");
        System.out.println("enter the No. of Denominations ");

        Integer denominationSize = input.nextInt();
        denominations = new Integer[denominationSize];

        for (int index = 0; index < denominationSize; index ++) {

            System.out.printf("Denominations value : %d / %d", (index +1),
                    denominationSize);
            System.out.println();
            denominations[index] = input.nextInt();
        }
    }

    void collectPaymentAmount() {

        System.out.println("Payment Amount : ");
        paymentAmount = input.nextInt();
    }

    public void calculate() {
        Arrays.sort(denominations, Collections.reverseOrder());

        System.out.println("After sorting...");
        System.out.println(Arrays.toString(denominations));

        int denominationIndex = 0;
        int tPaymentAmount = paymentAmount;
        boolean exactDenominationsSupplied = false;
        Integer balanceAmount = 0;

        while (denominationIndex < denominations.length) {

            Integer denomination = denominations[denominationIndex];

            Integer noOfTimesDenominations = tPaymentAmount / denomination;

            balanceAmount = tPaymentAmount % denomination;

            if (noOfTimesDenominations != 0) {

                System.out.printf("Denomination : %d, NoOfTimes : %d", denomination, noOfTimesDenominations);
                System.out.println();
            }


            if (balanceAmount == 0) {
                exactDenominationsSupplied = true;
            }

            tPaymentAmount = balanceAmount;

            denominationIndex ++;
        }

        if (exactDenominationsSupplied) {
            System.out.println("Able to provide the exact denominations");
        }else {
            System.out.println("Unable to provide the exact denominations");
            System.out.printf("Balance Amount %d", balanceAmount);
        }
    }
}
