package myjava.error;

import javax.swing.*;
import java.io.*;

/**
 * Created by jasonsapdos on 17/11/2017.
 */
public class TXTReader {

    private static String LOG_FILE = "log.txt";

    protected String[] read()
    {
        BufferedReader fileReader = null;
        BufferedReader forCount = null;
        String rawData[] = new String[]{};
        int ctr = 0;

        try
        {
            File file = new File(LOG_FILE);
            if (!file.exists())
                throw new FileNotFoundException("Failed to found file:\n"
                        + System.getProperty("user.dir") + "\\" + LOG_FILE);

            fileReader = new BufferedReader(new FileReader(LOG_FILE));
            forCount = new BufferedReader(new FileReader(LOG_FILE));

            while ((forCount.readLine()) != null)
            {
                ctr++;
            }

            rawData = new String[ctr];

            for (int i = 0; i < rawData.length; i++)
            {
                rawData[i] = fileReader.readLine();
            }

        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error - Load",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (fileReader != null)
                    fileReader.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        return rawData;
    }
}

