import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.Instant;

public class EndScreen {

    public void finalScreen(){
        System.out.println("Thank you for using our currency converter.");
        System.out.println("Your conversion results: " + ConversionOptionConversionAmount.getList());

        try {
            File logFile=new File("C:\\Users\\Misha\\Downloads\\results.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true));
            writer.newLine();
            writer.write (Instant.now().toString() + ": " + ConversionOptionConversionAmount.getList() + "\n");
            writer.newLine();
            writer.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
