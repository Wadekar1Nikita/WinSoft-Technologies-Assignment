import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Question_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

     
        System.out.println("Enter a sentence:");
        String sentence = scanner.nextLine();

 
        String[] words = sentence.trim().split("\\s+");

     
        Map<String, Integer> wordCountMap = new HashMap<>();

        for (String word : words) {
            word = word.toLowerCase(); 
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }


        System.out.println("Word Counts:");
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

     
    }
}
