package calculator;

import java.util.Scanner;

public class Tester {
    public static void print(Variable other) {
        System.out.println(other);

    }

    public static void main(String[] args) throws Exceptions {
        System.out.println("Введите пример");
        Scanner cin = new Scanner(System.in);
        Parcer parcer = new Parcer();
        String input;
        while (!(input = cin.next()).equals("stop")) {
            try {
                Variable result = parcer.calculator(input);
                print(result);

            } catch (Exceptions exceptions) {
                System.out.println(exceptions.getMessage());
            }
        }



        /*Integer b = new Integer(2);
        Integer f = new Integer(2);
        System.out.println(b==f);
        System.out.println(b.equals(f));*/


    }
}
