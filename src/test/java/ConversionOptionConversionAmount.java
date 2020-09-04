import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class ConversionOptionConversionAmount includes the flow of which conversion option
 * (Dollars to Shekels / Shekels to Dollars / Euro to Shekel)
 * the user will choose.
 * Loop "Invalid Choice, please try again" in case 1/2/3 is not chosen.
 * Factory instantiation of USD/ILS/EUR class.
 * Check if "Amount for conversion" is numeric or not. If not - Loop "Invalid Choice, please enter numeric value".
 * Introducing to user "The result of conversion".
 * Inserting conversion result to arrayList and to results.txt (file).
 */


public class ConversionOptionConversionAmount {
    // ArrayLists - where conversion results and conversion flow are saved
    private static ArrayList<Double> arraylist = new ArrayList<Double>();
    private static ArrayList<String> arraylistConversionFlow = new ArrayList<String>();


    public void conversionOptionAndAmount(){
        // 1st screen
        // Call conversionOption method which introduces to user 1. Dollars to Shekels or 2. Shekels to Dollars
        int option = conversionOption();
        // While loop until 1 or 2 chosen:
        while (option != 1 && option != 2 && option != 3){
            System.out.println("Invalid Choice, please try again");
            option = conversionOption();
        }
        if (option == 1){ // 1. Dollars to Shekels
            Coin coin = CoinFactory.getCoinInstance(Coins.USD); // Factory instantiation of USD class
            // 2nd screen - enter amount to convert
            String amountinput = amountToConvert();
            boolean isnumeric = isNumeric(amountinput);
            while (!isnumeric) {
                System.out.println("Invalid Choice, please enter numeric value");
                amountinput = amountToConvert();
                isnumeric = isNumeric(amountinput);
            }
            double input = Double.parseDouble(amountinput);// convert string to double for further "input" treatment in other classes
            // 3rd screen
            System.out.println("The result of conversion: " + input + " Dollars = " + coin.calculate(input) + " Shekel");
            arraylist.add(coin.calculate(input));
            arraylistConversionFlow.add("USD to ILS");
        }

        else if (option == 2){ // 2. Shekels to Dollars
            Coin coin = CoinFactory.getCoinInstance(Coins.ILS); // Factory instantiation of ILS class
            // 2nd screen
            String amountinput = amountToConvert();
            boolean isnumeric = isNumeric(amountinput);
            while (!isnumeric) {
                System.out.println("Invalid Choice, please enter numeric value");
                amountinput = amountToConvert();
                isnumeric = isNumeric(amountinput);
            }
            double input = Double.parseDouble(amountinput);// convert string to double for further "input" treatment in other classes
            // 2nd screen - enter amount to convert
            System.out.println("The result of conversion: " + input + " Shekels = " + coin.calculate(input) + " Dollars");
            arraylist.add(coin.calculate(input));
            arraylistConversionFlow.add("ILS to USD");
        }


        if (option == 3){ // 3. Euro to Shekels
            Coin coin = CoinFactory.getCoinInstance(Coins.EUR); // Factory instantiation of EUR class
            // 2nd screen - enter amount to convert
            String amountinput = amountToConvert();
            boolean isnumeric = isNumeric(amountinput);
            while (!isnumeric) {
                System.out.println("Invalid Choice, please enter numeric value");
                amountinput = amountToConvert();
                isnumeric = isNumeric(amountinput);
            }
            double input = Double.parseDouble(amountinput);// convert string to double for further "input" treatment in other classes
            // 3rd screen
            System.out.println("The result of conversion: " + input + " Euro = " + coin.calculate(input) + " Shekel");
            arraylist.add(coin.calculate(input));
            arraylistConversionFlow.add("EUR to ILS");
        }
    }
    // conversionOption method which introduces to user 1. Dollars to Shekels or 2. Shekels to Dollars
    // User's input scanned from keyboard
    // the method also doing try/catch in case other then 1/2 option is entered including letters
    public static int conversionOption() {
        System.out.println("Please choose an option (1/2/3):" + "\n" + "1. Dollars to Shekels" + "\n" + "2. Shekels to Dollars" + "\n" + "3. Euro to Shekel");
        int option = 0;
        try { // catch InputMismatchException
            Scanner scanner = new Scanner(System.in);
            option = scanner.nextInt();
        } catch (InputMismatchException e) {
            //e.printStackTrace();
        }
        return option;
    }

    // The method amountToConvert introduces to user "Please enter an amount to convert"
    // User's input scanned from keyboard
    // the method also doing try/catch in case non numeric is entered
    public static String amountToConvert(){
        System.out.println("Please enter an amount to convert");
        String amountinput = "0";
        try { // catch InputMismatchException
            Scanner scanner = new Scanner(System.in);
            amountinput = scanner.next();
        } catch (InputMismatchException|NumberFormatException e) {
            //e.printStackTrace();
        }
        return amountinput;
    }

    // getter for arraylist, where conversion results are saved
    public static ArrayList<Double> getList() {
        return arraylist;
    }

    // getter for arraylistConversionFlow, where conversion flow is saved
    public static ArrayList<String> getArraylistConversionFlow() {
        return arraylistConversionFlow;
    }

    // Method for checking if scanned from keyboard conversion amount is numeric or not
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
