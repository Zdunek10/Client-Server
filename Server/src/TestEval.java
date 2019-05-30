import java.util.HashMap;
import java.util.Stack;
import java.util.regex.*;


public class TestEval {


    public static void main(String[] args) {
        String asd = "*1+(2*2)";
        String as = "1+2";


        int n = 5;


        // factorial(n);
        // System.out.println(factorial(n));
        //   System.out.println(matchBrackets("3-(1+2)"));
        //  System.out.println(matchBrackets("(((())))"));
        //   System.out.println(matchBrackets("))))"));

        System.out.println(isValid(as));


    }







    public static boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (map.keySet().contains(curr)) {
                stack.push(curr);
            } else if (map.values().contains(curr)) {
                if (!stack.empty() && map.get(stack.peek()) == curr) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.empty();
    }











    public static int matchBrackets(String brackets) {

        int open = 0;
        int count = 0;


        if (brackets.charAt(0) == '(' && brackets.charAt(brackets.length() - 1) == ')') {
            brackets = brackets.substring(1, brackets.length() - 1);


            System.out.println("ASD");
        }

        if (brackets.contains("[") || brackets.contains("]")) //str.matches(".*[\\[\\]].*")
        {
            //throw your error
        }


        for (int i = 0; i < brackets.length(); i++) {
            if (brackets.charAt(i) == '(') {
                open++;
            } else if (brackets.charAt(i) == ')') {
                open--;
            }
            if (open < 0) {
                count++;
                open++;
            }
        }
        return count + open;
    }












    public static long factorial(int n) {
        if (n == 1) return 1;
        return n * factorial(n - 1);


       /* factorial(5)
              factorial(4)
                factorial(3)
                     factorial(2)
                        factorial(1)
                             return 1
                        return 2*1 = 2
                     return 3*2 = 6
                 return 4*6 = 24
             return 5*24 = 120*/
    }
}
