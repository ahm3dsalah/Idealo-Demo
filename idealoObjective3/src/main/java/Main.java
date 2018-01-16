import config.PropertiesLoader;
import constants.Constants;
import factories.DataSourceFactory;
import interfaces.DataSourceInterFace;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by MAC Windows on 1/7/2018.
 */
class Pairs {
    private final String pair1;
    private final String pair2;

    Pairs(String a, String b) {
        this.pair1 = a;
        this.pair2 = b;
    }

    public String getPair1() {
        return pair1;
    }

    public String getPair2() {
        return pair2;
    }
}
public class Main {


    public static void main(String[] args) throws IOException {


        // use properties loader to load system properties such as word length
        PropertiesLoader loader = new PropertiesLoader();
        Properties p = loader.getProperties();


        DataSourceFactory factory = new DataSourceFactory();
        DataSourceInterFace dataSource = factory.getDataSource(Constants.FILE_DATA_SOURCE);
        List<String> sourceWords = dataSource.getAllWords();

        // to store all six letters words
        Map<String, List<Pairs>> candidateWords = new HashMap<String, List<Pairs>>();

        //to store all other words with length less than 6
        Set<String> wordsList = new HashSet<String>();

        // read from file
        Iterator<String> it = sourceWords.iterator();

        while (it.hasNext()) {
            String line = it.next();
            // put all six letters word into hash set for search later
            if (line.length() == 6 && !candidateWords.containsKey(line.toLowerCase())) {
                candidateWords.put(line.toLowerCase(), getPossibleCombination(line.toLowerCase()));
            } else if (line.length() < 6) {
                wordsList.add(line.toLowerCase());
            } else {
                continue;
            }
        }
        Iterator<Map.Entry<String, List<Pairs>>> mapIt = candidateWords.entrySet().iterator();
        while (mapIt.hasNext()) {
            Map.Entry<String, List<Pairs>> entry = mapIt.next();
            List<Pairs> combination = entry.getValue();
            for (Pairs pair : combination) {
                if (wordsList.contains(pair.getPair1()) && wordsList.contains(pair.getPair2())) {
                    System.out.println(entry.getKey());
                    System.out.println("===========================");
                    break;
                }
            }
        }
    }
    public static List<Pairs> getPossibleCombination(String word) {
        List<Pairs> combination = new ArrayList<Pairs>();
        combination.add(new Pairs(word.substring(0, 1), word.substring(1)));
        combination.add(new Pairs(word.substring(0, 2), word.substring(2)));
        combination.add(new Pairs(word.substring(0, 3), word.substring(3)));
        combination.add(new Pairs(word.substring(0, 4), word.substring(4)));
        combination.add(new Pairs(word.substring(0, 5), word.substring(5)));

        return combination;
    }

}