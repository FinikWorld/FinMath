package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parcer {
    public Variable calculator(String string) throws Exceptions {
        String[] apparands = string.split(Patterns.OPERATIONS);
        Variable one = Variable.createVar(apparands[0]);
        Variable two = Variable.createVar(apparands[1]);

        Pattern pattern = Pattern.compile(Patterns.OPERATIONS);
        Matcher matcher = pattern.matcher(string);
        if (matcher.find()){
            String operation = matcher.group();
            switch (operation){
                case "+":return one.slogenie(two);
                case "-":return one.vichitanie(two);
                case "*":return one.umnogenie(two);
                case "/":return one.delenie(two);
                case "sum":return one.summa(two);
            }
        }

        return null;
    }
}
