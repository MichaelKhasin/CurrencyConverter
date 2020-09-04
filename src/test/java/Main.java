/**
 * Currency Converter.
 * Converting next currencies:
 * 1. Dollars to Shekels
 * 2. Shekels to Dollars
 * 3. Euro to Shekel
 * Invalid Choice is checked and appropriate message appears to user.
 * Next conversion rates are used:
 * 3.52 for Dollars to Shekels; 0.28 for Shekels to Dollars; 4.23 for Euro to Shekel.
 * Factory design pattern is used for USD/ILS/EUR classes instantiation.
 * javadoc cmd command:
 * cd C:\Users\Noam\IdeaProjects\CurrencyConverter\src\test\java
 * javadoc main.java ConversionOptionConversionAmount.java -d C:\Users\Noam\IdeaProjects\CurrencyConverter\src\main\doc
 */


public class Main {
    public static void main(String[] args) {
        // Welcome screen
        System.out.println("Welcome to currency converter");

        // Conversion options and conversion amount - class instantiation
        ConversionOptionConversionAmount conversionOptionConversionAmount = new ConversionOptionConversionAmount();
        conversionOptionConversionAmount.conversionOptionAndAmount();

        // Another Conversion (Y/N) - class instantiation
        AnotherConversion anotherConversion = new AnotherConversion();
        anotherConversion.anotherConversionFlow();
        while (anotherConversion.option.equalsIgnoreCase("Y")){ // Y – Loop that will start conversion cycle anew
            conversionOptionConversionAmount.conversionOptionAndAmount();
            anotherConversion.anotherConversionFlow();
        }
        if (anotherConversion.option.equalsIgnoreCase("N")){ // N – Will show end screen
            EndScreen endScreen = new EndScreen();
            endScreen.finalScreen();

        }





    }
}
