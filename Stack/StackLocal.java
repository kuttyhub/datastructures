import java.util.Stack;

public class StackLocal {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        String s = "abcd";
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }
        for (int i = 0; i < s.length(); i++) {
            System.out.print(stack.pop());
        }

    }
}
