import java.io.*;
import java.util.*;

/**
 * Created by MAC Windows on 1/14/2018.
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

    static String fileName = "C:\\Other\\springboot WorkSpace\\idealoObjective1\\src\\main\\resources\\wordlist.txt";

    public static void main(String[] args) throws IOException {


        Map<String, List<Pairs>> candidateWords = new HashMap<String, List<Pairs>>();

        //to store all other words with length less than 6
        Set<String> wordsList = new HashSet<String>();

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName));

            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                String line = sCurrentLine;
                // put all six letters word into hash set for search later
                if (line.length() == 6 && !candidateWords.containsKey(line.toLowerCase())) {
                    candidateWords.put(line.toLowerCase(), getPossibleCombination(line.toLowerCase()));
                } else if (line.length() < 6) {
                    wordsList.add(line.toLowerCase());
                } else {
                    continue;
                }
            }
        } catch (IOException e) {

            e.printStackTrace();

        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException ex) {

                ex.printStackTrace();
            }
        }
        // now iterate over the map
        Iterator<Map.Entry<String, List<Pairs>>> it = candidateWords.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, List<Pairs>> entry = it.next();
            List<Pairs> combination = entry.getValue();
            for (Pairs p : combination) {
                if (wordsList.contains(p.getPair1()) && wordsList.contains(p.getPair2())) {
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

