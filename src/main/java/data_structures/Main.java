package data_structures;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        task1();
        task2();

    }

    private static void task1() {
        Stack<String> stack = new Stack<>();
        String line;
        System.out.println("Вводите скобки!");
        while (!(line = scanner.nextLine()).equals("exit"))
            stack.push(line);
        boolean result = isCorrectParentheses(stack);
        System.out.println(result);
    }

    private static boolean isCorrectParentheses(Stack<String> stack) {
        int cnt = 0;
        for (String symbol : stack) {
            if (symbol.equals("("))
                cnt++;
            else
                cnt--;
        }
        return cnt == 0;
    }

    private static void task2() {
        Stack<String> stack = new Stack<>();
        String line;
        System.out.println("Вводите скобки!");
        while (!(line = scanner.nextLine()).equals("exit"))
            stack.push(line);
        boolean result = isCorrectBrackets(stack);
        System.out.println(result);
    }

    private static boolean isCorrectBrackets(Stack<String> stack) {
        // 1 - (, 2 - [, 3 - {
        Stack<Integer> stackOfMark = new Stack<>();
        int cnt = 0;
        for (String symbol : stack) {
            if (symbol.equals("(") || symbol.equals("[") || symbol.equals("{")) {
                if (symbol.equals("("))
                    stackOfMark.push(1);
                else if (symbol.equals("["))
                    stackOfMark.push(2);
                else
                    stackOfMark.push(3);
                cnt++; // увеличиваем счётчик открывающейся скобки

            } else if (symbol.equals(")") || symbol.equals("]") || symbol.equals("}")) {
                if (symbol.equals(")") && stackOfMark.peek() == 1)
                    stackOfMark.pop();
                else if (symbol.equals("]") && stackOfMark.peek() == 2)
                    stackOfMark.pop();
                else if (symbol.equals("}") && stackOfMark.peek() == 3)
                    stackOfMark.pop();
                else {
                    System.out.println("Нарушение порядка скобок!");
                    System.exit(1);
                }
                cnt--; // уменьшаем счётчик открывающейся скобки
            } else {
                System.out.println("Недопустимый символ!");
                System.exit(1);
            }
        }
        return cnt == 0;
    }
}
