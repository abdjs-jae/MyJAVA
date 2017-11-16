package myjava.errors;

/**
 * Created by jasonsapdos on 05/08/2017.
 */
import java.io.*;

import javax.swing.JOptionPane;

public class TXTWriter
{
    private static String LOG_FILE = "log.txt";

    public void writeMessage(String printString){
        write(printString, LOG_FILE);
    }

    private void write(String printString, String fileName)
    {
        BufferedWriter fileWriter = null;

        try
        {
            fileWriter = new BufferedWriter(new FileWriter(fileName, true));

            BufferedReader br = null;
            br = new BufferedReader(new FileReader(fileName));
            String line;

            while((line = br.readLine()) != null) {
                //System.out.println("Checking TXT line...");
            }

            fileWriter.append(printString);
            fileWriter.newLine();

        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "There is an error in saving.");
            e.printStackTrace();
        }
        finally
        {
            try
            {
                // Closes the TXTWriter
                if (fileWriter == null)
                    return;

                fileWriter.flush();
                fileWriter.close();
            }
            catch (IOException e)
            {
                JOptionPane.showMessageDialog(null,
                        "There is an error in closing TXT Writer.");
                e.printStackTrace();
            }
        }
    }
}
