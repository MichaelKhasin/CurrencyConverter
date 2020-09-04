import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.Instant;

/**
* Class responsible for end screen
* "Thank you for using our currency converter."
* Print conversion results
* Save conversion results in results.txt and opens results file automatically
 */

public class EndScreen {

    public void finalScreen(){
        System.out.println("Thank you for using our currency converter.");
        System.out.println("Your conversion results: " + ConversionOptionConversionAmount.getList() + "," + ConversionOptionConversionAmount.getArraylistConversionFlow());

        try {
            File logFile=new File("C:\\Users\\Noam\\Downloads\\results.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true));
            writer.newLine();
            writer.write (Instant.now().toString() + ": " + ConversionOptionConversionAmount.getList() + "," + ConversionOptionConversionAmount.getArraylistConversionFlow() + "\n");
            writer.newLine();
            writer.close();
        } catch(Exception e) {
            e.printStackTrace();
        }

        // open results file automatically
        try {
            File logFile=new File("C:\\Users\\Noam\\Downloads\\results.txt");
            Desktop desktop = Desktop.getDesktop();
            desktop.open(logFile); //opens the specified file
            }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
}
