import java.util.HashMap;
import java.util.Map;

public class firstRepeatedChar {
    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>();
        String s = "a green apple";
        var chars = s.toCharArray();
        for (var i : chars) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        // first repeated cahr
        for (var i : chars) {
            if (map.get(i) > 1) {
                System.out.println(i);
                break;
            }
        }
        // first non repeated cahr
        // for (var i : chars) {
        // if (map.get(i) == 1) {
        // System.out.println(i);
        // break;
        // }
        // }
    }
}
