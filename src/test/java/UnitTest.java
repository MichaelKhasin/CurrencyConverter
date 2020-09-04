import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.*;
import java.time.Instant;
import java.util.ArrayList;

/**
 * UnitTest
 * Currency option = 1. Dollars to Shekels
 * Amount to convert = 100$
 * Factory design pattern is used for USD class instantiation, where currency conversion defined 3.52
 * Expected conversion result = 352 nis
 * Assertion if conversion result is valid
 */

public class UnitTest {
    private static int option;
    private static double input;
    private static double result;
    private static ArrayList<Double> arraylist = new ArrayList<Double>();

    // Run once at the beginning of the test - actual Main running
    @BeforeClass
    public static void runOnceBeforeClass() {
        // Conversion options and conversion amount - class instantiation
        option = 1; // 1. Dollars to Shekels
        input = 100;
        Coin coin = CoinFactory.getCoinInstance(Coins.USD);
        result = coin.calculate(input);
        arraylist.add(coin.calculate(input));

        try {
            File logFile=new File("C:\\Users\\Noam\\Downloads\\results.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true));
            writer.newLine();
            writer.write ("UnitTest result" + ": " + arraylist + "\n");
            writer.newLine();
            writer.close();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void enteringValueToConvert() {
        Assert.assertEquals(result,352.0);

//        try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Noam\\Downloads\\results.txt"))) {
//            StringBuilder sb = new StringBuilder();
//            String line = br.readLine();
//            boolean searchedPattern = false;
//            while (line != null) {
//                sb.append(line);
//                line = br.readLine();
//                if (line.contains("UnitTest result: [352.0]")){
//                    searchedPattern = true;
//                }
//            }
//            if (searchedPattern){
//                System.out.println("UnitTest PASS");
//            }
//
//        } catch (IOException | NullPointerException e) {
//            e.printStackTrace();
//        }

    }
}
