package calculator;

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

        }
    };

    public String calculator(String string) throws Exceptions {

        List<String> asList = Arrays.asList(string.split(Patterns.OPERATIONS));
        List<String> operands = new ArrayList<>(asList);
        List<String> opertions = new ArrayList<>();


        Pattern pattern = Pattern.compile(Patterns.OPERATIONS);
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {

            opertions.add(matcher.group());
        }
        if (opertions.size() == 0) {

            return null;
        }
        while (opertions.size()>0){
            int number = getPriority(opertions);
            String operation = opertions.remove(number);
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
        if (operation.equals("=")) {
            Variable.setVar(oneStr, two);
            return two.toString();
        }
        Variable one = Variable.createVar(oneStr);
        switch (operation) {
            case "+":
                return one.slogenie(two).toString();
            case "-":
                return one.vichitanie(two).toString();
            case "*":
                return one.umnogenie(two).toString();
            case "/":
                return one.delenie(two).toString();
        }
        return null;
    }
}
