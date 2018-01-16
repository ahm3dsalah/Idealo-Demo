import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * Created by MAC Windows on 1/7/2018.
 */
public class Main {

    static String fileName = "C:\\Other\\springboot WorkSpace\\idealoObjective1\\src\\main\\resources\\wordlist.txt";
    public static void main(String[] args) throws IOException {

        HashSet<String> candidateWords = new HashSet<String>();
        List<String> wordsList = new ArrayList<String>();

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName));

            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                String line = sCurrentLine;
                // put all six letters word into hash set for search later
                if (line.length() == 6) {
                    candidateWords.add(line.toLowerCase());
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
        InputStream inputStream = new FileInputStream(fileName);
        Scanner in = new Scanner(inputStream);

        while (in.hasNext()) {
            String line = in.nextLine();
            // put all six letters word into hash set for search later
            if (line.length() == 6) {
                candidateWords.add(line.toLowerCase());
            } else if (line.length() < 6) {
                wordsList.add(line.toLowerCase());
            } else {
                continue;
            }
        }
        in.close();
        // now start making all possible combination from words at wordsList arrayList and search in hash set
        for (int i = 0; i < wordsList.size(); i++) {
            for (int j = 0; j < wordsList.size(); j++) {
                if (i == j) continue;

                String combinedWord = wordsList.get(i) + wordsList.get(j);
                if (combinedWord.length() == 6 && candidateWords.contains(combinedWord)) {
                    candidateWords.remove(combinedWord);
                    System.out.println(wordsList.get(i) + " <> " + wordsList.get(j));
                    System.out.println(combinedWord);
                    System.out.println("==================================================");
                }
            }
        }
    }
}