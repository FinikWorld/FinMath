

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Variable implements IOperation {
    static Map<String, Variable> vars = new HashMap<>(); //Карта переменных в вайле
    private static String fileName = Util.getPath("peremennie.txt");

    public static void setVar(String oneStr, Variable two) {
        vars.put(oneStr, two);
    }

    @Override
    public Variable slogenie(Variable other) throws Exceptions {
        throw new Exceptions(Translator.IMPOSSIBLE_ACTION);
    }
    @Override
    public Variable vichitanie(Variable other) throws Exceptions {
        throw new Exceptions(Translator.IMPOSSIBLE_ACTION);
    }

    @Override
    public Variable umnogenie(Variable other) throws Exceptions {
        throw new Exceptions(Translator.IMPOSSIBLE_ACTION);
    }

    @Override
    public Variable delenie(Variable other) throws Exceptions {
        throw new Exceptions(Translator.IMPOSSIBLE_ACTION);
    }

    @Override
    public Variable summa(Variable other) throws Exceptions {
        throw new Exceptions(Translator.IMPOSSIBLE_ACTION);
    }

    @Override
    public Variable kvadrat(Variable other) throws Exceptions {
        throw new Exceptions(Translator.IMPOSSIBLE_ACTION);
    }

    @Override
    public Variable koren(Variable other) throws Exceptions {
        throw new Exceptions(Translator.IMPOSSIBLE_ACTION);
    }

    public static Variable createVar(String apparand) throws Exceptions {
        if (apparand.matches(Patterns.SCALAR))
            return new Scalar(apparand);
        if (apparand.matches(Patterns.VECTOR))
            return new Vector(apparand);
        if (apparand.matches(Patterns.MATRIX))
            return new Matrix(apparand);
        Variable variable = vars.get(apparand);
        if (variable == null)
            throw new Exceptions("Непонятный операнд или переменная " + apparand);
        return variable;
    }

    static void saveVar() throws IOException {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(fileName))) {
            for (Map.Entry<String, Variable> per : vars.entrySet()) {
                printWriter.printf("%s=%s\n", per.getKey(), per.getValue());
            }
        }
    }

    static void readVarsFile() throws IOException, Exceptions {
        File file = new File(fileName);
        if (file.exists()) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                Parcer local = new Parcer();
                while (bufferedReader.ready()) {
                    local.calculator(bufferedReader.readLine());
                }

            }
        }
    }
}
