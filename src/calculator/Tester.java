package calculator;

import java.io.IOException;
import java.util.Scanner;

public class Tester {
    public static void print(String other) {
        System.out.println(other);

    }

    public static void main(String[] args) throws Exceptions, IOException {
        /*Matrix mat= new Matrix("{{2,3,4},{3,4,5}}");
        System.out.println(mat.summa(mat));*/
        System.out.println("Введите пример");
        Scanner cin = new Scanner(System.in);
        Parcer parcer = new Parcer();

        Variable.readVarsFile();
        String input;
        while (!(input = cin.next()).equals("stop")) {
            try {
                String result = parcer.calculator(input);
                print(result);

            } catch (Exceptions exceptions) {
                System.out.println(exceptions.getMessage());
            }
        }
        Variable.saveVar();



        /*Integer b = new Integer(2);
        Integer f = new Integer(2);
        System.out.println(b==f);
        System.out.println(b.equals(f));*/


    }
}
