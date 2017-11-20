package myjava.error;

/**
 * Created by jasonsapdos on 05/08/2017.
 */

import javax.swing.*;
import java.io.*;

public class TXTWriter
{
    private static String LOG_FILE = "log.txt";
    BufferedWriter fileWriter;

    public void clear(){
        try {
            fileWriter = new BufferedWriter(new FileWriter(LOG_FILE, false));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeMessage(String printString){
        write(printString, LOG_FILE);
    }

    private void write(String printString, String fileName)
    {
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
