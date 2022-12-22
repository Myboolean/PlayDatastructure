package main.stack;
import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/12/19
 * Time: 10:04
 *
 * @author:pzj
 */
public class Test {
    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            arrayStack.push(i);
        }
        System.out.println(arrayStack);
        arrayStack.pop();
        System.out.println(arrayStack);
    }
}
class Solution{
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c=='{')
                stack.push(c);
            else {
                if(stack.isEmpty()) {
                    return false;
                }
                char topChar = stack.pop();
                if(c == '(' && topChar != ')')
                    return false;
                if(c == '[' && topChar != ']')
                    return false;
                if(c == '{' && topChar != '}')
                    return false;
            }
        }
        return stack.isEmpty();
    }
}