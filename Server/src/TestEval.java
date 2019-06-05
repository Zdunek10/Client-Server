import java.util.*;
import java.util.regex.*;


public class TestEval {


    public static void main(String[] args) {
        String asd = "*(1+(2*2))";
        String as = "1+2";


        int n = 5;

        // factorial(n);
        // System.out.println(factorial(n));
        // System.out.println(matchBrackets("3-(1+2)"));
        // System.out.println(matchBrackets("(((())))"));
        // System.out.println(matchBrackets("))))"));
        // System.out.println(isValid(as));


        //  new TestEval();


       /* String example = asd;
        Matcher m = Pattern.compile("\\(([^)]+)\\)").matcher(example);
        while (m.find()) {
            System.out.println(m.group(1));
        }*/

        //TestEval.getCharFromString();


        new TestEval();
    }


    public TestEval() {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        while (count-- > 0) {
            String exp = in.next();
            int strLength = exp.length();
            int counter = -1;
            Stack<Character> st = new Stack<Character>();
            String output = "";
            while (counter++ < strLength - 1) {

                if (exp.charAt(counter) == '(')
                    continue;

                char test = exp.charAt(counter);

                if (test == '+' || test == '-' || test == '*' || test == '/'
                        || test == '^') {
                    st.add(test);
                    continue;
                } else if (test == ')') {
                    output += st.pop();
                    continue;
                } else {
                    output += String.valueOf(test);
                    continue;
                }

            }
            System.out.println(output.trim());

        }

    }

    public static void getCharFromString() {

        int openBr = 0;
        int closeBr = 0;

   /*     String example = "United Arab Emirates Dirham (AED(XOXO))";
        Matcher m = Pattern.compile("\\(([^)]+)\\)").matcher(example);
        while (m.find()) {
            System.out.println(m.group(1));
        }
*/
        String string = "(1+(1+2))";
        List<Character> chars = new ArrayList<>();

        for (int i = 0; i < string.length(); i++) {

            if (string.charAt(i) == '(') {
                openBr++;
                System.out.println(chars);
            } else if (string.charAt(i) == ')') {
                closeBr++;

            }
            chars.add(string.charAt(i));

            //  System.out.println(string.charAt());
            System.out.println(chars);

        }

        // return string;

        System.out.println("Open: " + openBr);
        System.out.println("Close: " + closeBr);
    }




/*    public TestEval() {

        String myString = "1+(2*(1+1)2))";

        //String myString = "(2*((3-2)+(5-3)))";
        String myArray[] = myString.split("[\\(||//)]");
        for (int i = (myArray.length - 1); i >= 0; i--)
            // System.out.println("myArray[" + i + "] : " + myArray[i]);

            System.out.println(myArray[i].toString());
    }*/


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


 /*       if (brackets.charAt(1) == '(' && brackets.charAt(brackets.length() - 1) == ')') {
            brackets = brackets.substring(1, brackets.length() - 1);


            System.out.println("ASD");
        }

        if (brackets.contains("[") || brackets.contains("]")) //str.matches(".*[\\[\\]].*")
        {
            //throw your error
        }*/


        for (int i = 0; i < brackets.length(); i++) {
            if (brackets.charAt(i) == '(') {
                open++;

            } else if (brackets.charAt(i) == ')') {
                open--;

            }
            i++;
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
