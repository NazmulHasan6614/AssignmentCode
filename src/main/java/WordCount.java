import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;



public class WordCount {
    public static void main(String[] args) {

        String filePath = "C:\\Users\\hp\\IdeaProjects\\JavaCode\\src\\main\\java\\org\\example\\Input.txt";


        Map<String, Integer> wordCount = new TreeMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath)))
        {
            String text;
            while ((text = reader.readLine()) != null) {
                // Process each line of the file
                String[] Arraywords = text.toLowerCase().replaceAll("[^a-zA-Z ]", "").split("\\s+");
                for (String word : Arraywords) {
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException obj) {
            obj.printStackTrace();
        }


        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

