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
