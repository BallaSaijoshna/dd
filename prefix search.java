import java.util.HashMap;
import java.util.Map;

public class WordFilter {

    private Map<String, Integer> map;

    public WordFilter(String[] words) {
        map = new HashMap<>();
        for (int index = 0; index < words.length; index++) {
            String word = words[index];
            int len = word.length();
            // For every possible prefix and suffix combination
            for (int i = 0; i <= len; i++) {
                String prefix = word.substring(0, i);
                for (int j = 0; j <= len; j++) {
                    String suffix = word.substring(len - j);
                    map.put(prefix + "#" + suffix, index); // overwrite for latest index
                }
            }
        }
    }

    public int f(String prefix, String suffix) {
        String key = prefix + "#" + suffix;
        return map.getOrDefault(key, -1);
    }

    // Test with main method
    public static void main(String[] args) {
        WordFilter wordFilter = new WordFilter(new String[]{"apple"});

        System.out.println(wordFilter.f("a", "e")); // Output: 0
    }
}
