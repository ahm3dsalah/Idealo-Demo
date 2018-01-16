package implementations;

import interfaces.DataSourceInterFace;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by MAC Windows on 1/15/2018.
 */
public class FileDataSource implements DataSourceInterFace {
    private String fileName = "wordlist.txt";
    private InputStream inputStream;
    List<String> wordsList;

    public FileDataSource() {
        wordsList = new ArrayList<String>();
    }

    public List<String> getAllWords() throws IOException {

        try {

            inputStream = getClass().getClassLoader().getResourceAsStream(fileName);

            if (inputStream != null) {
            } else {
                throw new FileNotFoundException("property file '" + fileName + "' not found in the classpath");
            }
            Scanner in = new Scanner(inputStream);
            while (in.hasNext()) {
                wordsList.add(in.next());
            }


        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
        return wordsList;
    }
}
