import java.util.HashSet;
import java.util.Set;

public class firstRepeatedCharUsingSet {
    public static void main(String[] args) {
        Set<Character> set = new HashSet<>();
        String s = "a green apple";
        for (var i : s.toCharArray()) {
            if (set.contains(i)) {
                System.out.println(i);
                break;
            }
            set.add(i);
        }
    }
}
