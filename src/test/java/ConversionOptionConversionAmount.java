import java.util.ArrayList;
import java.util.Scanner;

public class ConversionOptionConversionAmount {
    // ArrayList vars:
    private static ArrayList<Double> arraylist = new ArrayList<Double>();

    public void conversionOptionAndAmount(){
        // 1st screen
        // Call conversionOption method which introduces to user 1. Dollars to Shekels or 2. Shekels to Dollars
        int option = conversionOption();

        // While loop until 1 or 2 chosen:
        while (option != 1 && option != 2){
            System.out.println("“Invalid Choice, please try again");
            // Add try catch if not number is chosen
            option = conversionOption();
        }
        if (option == 1){ // 1. Dollars to Shekels
            Coin coin = CoinFactory.getCoinInstance(Coins.USD); // Factory instantiation of USD class
            // 2nd screen - enter amount to convert
            double input = amountToConvert();
            // 3rd screen
            System.out.println("The result of conversion: " + input + " Dollars = " + coin.calculate(input) + " Shekel");
            arraylist.add(coin.calculate(input));

        }
        else if (option == 2){ // 2. Shekels to Dollars
            Coin coin = CoinFactory.getCoinInstance(Coins.ILS); // Factory instantiation of ILS class
            // 2nd screen
            double input = amountToConvert();
            // 2nd screen - enter amount to convert
            System.out.println("The result of conversion: " + input + " Shekels = " + coin.calculate(input) + " Dollars");
            arraylist.add(coin.calculate(input));
        }

    }

    public static int conversionOption(){
        System.out.println("Please choose an option (1/2):" + "\n" + "1. Dollars to Shekels" + "\n" + "2. Shekels to Dollars");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        return option;
    }

    public static double amountToConvert(){
        System.out.println("Please enter an amount to convert");
        Scanner scanner = new Scanner(System.in);
        double input = scanner.nextDouble();
        return input;
    }

    public static ArrayList<Double> getList() {
        return arraylist;
    }


}
