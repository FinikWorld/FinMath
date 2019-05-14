

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parcer {
    private final Map<String, Integer> priority = new HashMap<String, Integer>() {
        {
            this.put("=", 0);
            this.put("+", 1);
            this.put("-", 1);
            this.put("*", 2);
            this.put("/", 2);
            this.put("s", 3);
            this.put("k",3);
            this.put("r",4);

        }
    };

    public String calculator(String string) throws Exceptions {

        List<String> asList = Arrays.asList(string.split(Patterns.OPERATIONS));
        List<String> operands = new ArrayList<>(asList);
        List<String> operations = new ArrayList<>();


        Pattern pattern = Pattern.compile(Patterns.OPERATIONS);
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            operations.add(matcher.group());
        }
        if (operations.size() == 0) {
//                return null;
            return Variable.createVar(string).toString();
        }
        while (operations.size() > 0) {
            int number = getPriority(operations);
            String operation = operations.remove(number);
            String one = operands.remove(number);
            String two = operands.get(number);
            String res = oneOperation(one, operation, two);
            operands.set(number, res);
        }
        return operands.get(0);
    }

    private int getPriority(List<String> opertions) {
        //=+-*/
        int index = 0;
        int currentPriority = -1;
        for (int i = 0; i < opertions.size(); i++) {
            String op = opertions.get(i);
            Integer prioroty = priority.get(op);
            if (prioroty > currentPriority) {
                index = i;
                currentPriority = prioroty;
            }
        }
        return index;
    }

    private String oneOperation(String oneStr, String operation, String twoStr) throws Exceptions, Exceptions {
        Variable two = Variable.createVar(twoStr);
        Variable one = null;
        if (operation.equals("=")) {
            Variable.setVar(oneStr, two);
            return two.toString();
        }
        if (!oneStr.isEmpty()) {
            one = Variable.createVar(oneStr);
        }
        switch (operation) {
            case "+":
                return one.slogenie(two).toString();
            case "-":
                return one.vichitanie(two).toString();
            case "*":
                return one.umnogenie(two).toString();
            case "/":
                return one.delenie(two).toString();
            case "s":
                return two.summa(two).toString();
            case "k":
                return two.kvadrat(two).toString();
            case "r":
                return  two.koren(two).toString();
        }
        throw new Exceptions("Некоректный ввод");
    }
}
