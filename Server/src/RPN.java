import java.util.LinkedList;
import java.util.Stack;

public class RPN {

    public static void main(String[] args) {
  /*      //evalRPN(Infix2("5*(2+3)/5"));
        // System.out.println(Infix2(""));
        Main main = new Main();
        //evalRPN();
        evalRPN("5*(2+3)/5");
      *//* System.out.println("PRZERWA \n");
        Infix2("5*(2+3)/5");
        System.out.println("PRZERWA 222 \n");
        evalRPN(Infix2("5*(2+3)/5"));*/

        //(2+3)*5
        // 2 3 + 5 *

        //evalRPN("2 3 + 5 *");


        //evalRPN(Infix2("(2+3)*5"));

        // String text = Infix2("(2+3)*5");

        //evalRPN(text);

        evalRPN("2 3 + 5 *");


    }


    //obliczanie RPN przy gotowym zaposie RPN
    public static void evalRPN(String expr) {
        String cleanExpr = cleanExpr(expr);
        LinkedList<Double> stack = new LinkedList<Double>();
        //System.out.println("Input\tOperation\tStack after");

        for (String token : cleanExpr.split("\\s")) {
            System.out.print(token + "\t");
            Double tokenNum = null;
            try {
                tokenNum = Double.parseDouble(token);
            } catch (NumberFormatException e) {
            }
            if (tokenNum != null) {
                System.out.print("Push\t\t");
                stack.push(Double.parseDouble(token + ""));
            } else if (token.equals("*")) {
                System.out.print("Operate\t\t");
                double secondOperand = stack.pop();
                double firstOperand = stack.pop();
                stack.push(firstOperand * secondOperand);
            } else if (token.equals("/")) {
                System.out.print("Operate\t\t");
                double secondOperand = stack.pop();
                double firstOperand = stack.pop();
                stack.push(firstOperand / secondOperand);
            } else if (token.equals("-")) {
                System.out.print("Operate\t\t");
                double secondOperand = stack.pop();
                double firstOperand = stack.pop();
                stack.push(firstOperand - secondOperand);
            } else if (token.equals("+")) {
                System.out.print("Operate\t\t");
                double secondOperand = stack.pop();
                double firstOperand = stack.pop();
                stack.push(firstOperand + secondOperand);
            } else if (token.equals("^")) {
                System.out.print("Operate\t\t");
                double secondOperand = stack.pop();
                double firstOperand = stack.pop();
                stack.push(Math.pow(firstOperand, secondOperand));
            } else {//just in case
                System.out.println("Error");
                return;
            }
            System.out.println(stack);
        }
        System.out.println("Wynik:  " + stack.pop());
    }


    private static String cleanExpr(String expr) {
        // usuniecie operatorow, bialych snakow
        return expr.replaceAll("[^\\^\\*\\+\\-\\d/\\s]", "");
    }


    //zamiana zwyklego dzialania (Stringa) na RPN
    public static String Infix2(String input) {
        if (input == null)
            return "first if empty";
        char[] inString = input.toCharArray();
        Stack<Character> stack = new Stack<>();
        StringBuilder out = new StringBuilder();

        for (int i = 0; i < inString.length; i++) {
            switch (inString[i]) {
                case '+':
                case '-':
                    while (!stack.empty() && (stack.peek() == '*' || stack.peek() == '/')) {
                        out.append(' ');
                        out.append(stack.pop());
                    }
                    out.append(' ');
                    stack.push(inString[i]);
                    break;
                case '*':
                    out.append(' ');
                    stack.push(inString[i]);
                    break;
                case '/':
                    out.append(' ');
                    stack.push(inString[i]);
                    break;
                case '(':
                    stack.push(inString[i]);
                    break;
                case ')':
                    while (!stack.empty() && stack.peek() != '(') {
                        out.append(' ');
                        out.append(stack.pop());
                    }
                    stack.pop();
                    break;
                default:
                    out.append(inString[i]);
                    break;
            }
        }
        System.out.println(out.toString());
        return out.toString();
    }
}







