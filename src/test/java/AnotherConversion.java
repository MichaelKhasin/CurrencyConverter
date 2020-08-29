import java.util.Scanner;

public class AnotherConversion {
    String option;

    public void anotherConversionFlow(){
        // Call anotherConversionOptionYN method which introduces to user "Another Conversion (Y/N)"
        option = anotherConversionOptionYN();
        while (!option.equalsIgnoreCase("Y") && !option.equalsIgnoreCase("N")){
            System.out.println("“Invalid Choice, please try again");
            // Add try catch if not number is chosen
            option = anotherConversionOptionYN();
        }


    }

    public static String anotherConversionOptionYN() {
        System.out.println("Another Conversion (Y/N)");
        // Scanner from keyboard
        Scanner scanner = new Scanner(System.in);
        String option = scanner.next();
        return option;

    }
}
