import calculator.resource.ResourseManager;
import calculator.resource.Translator;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Tester {
    public static void print(String other) {
        System.out.println(other);

    }

    public static void main(String[] args) throws Exceptions, IOException {
        /*Matrix mat= new Matrix("{{2,3,4},{3,4,5}}");
        System.out.println(mat.summa(mat));*/
//        ResourseManager resourseManager = ResourseManager.INSTANCE;
       /* String userLocal = Locale.getDefault().toString();
        Locale locale;
        Scanner cin = new Scanner(System.in);*/
        /*print("Какой язык выбираете en, ru, be?");

        userLocal = cin.next();
        switch (userLocal){
            case "en":
                locale = new Locale("en","EN");
                break;
            case "ru":
                locale = new Locale("ru","RU");
                break;
            case "be":
                locale = new Locale("be","BY");
                break;
            default:
                print("Выюрана неправельная локаль, по этому стандартная");
                locale=Locale.getDefault();
                break;
        }
        resourseManager.setLocale(locale);
//        System.out.println(resourseManager.get(Translator.END));

//        System.out.println(resourseManager.get(Translator.START));*/
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
