package calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Variable implements IOperation {
    static Map<String, Variable> vars = new HashMap<>();

    public static void setVar(String oneStr, Variable two) {
       vars.put(oneStr,two);
    }

    @Override
    public Variable slogenie(Variable other) throws Exceptions {
        throw new Exceptions("Сложение " + this + " + " + other + " невозможно");
//        throw new Exceptions("Некоректный ввод");
    }

    // Вместо sout, пробрасывай Exeptions, как показано выше

    @Override
    public Variable vichitanie(Variable other) throws Exceptions {
        System.out.println("Вычитание " + this + " - " + other + " невозможно");
        return null;
    }

    @Override
    public Variable umnogenie(Variable other) throws Exceptions {
        System.out.println("Умножение " + this + " * " + other + " невозможно");
        return null;
    }

    @Override
    public Variable delenie(Variable other) throws Exceptions {
        System.out.println("Деление " + this + " / " + other + " невозможно");
        return null;
    }

    @Override
    public Variable summa(Variable other) throws Exceptions {
//        System.out.println("Сумма равна "+this);
        return null;
    }

    public static Variable createVar(String apparand) throws Exceptions {
        if (apparand.matches(Patterns.SCALAR))
            return new Scalar(apparand);
        if (apparand.matches(Patterns.VECTOR))
            return new Vector(apparand);
        if (apparand.matches(Patterns.MATRIX))
            return new Matrix(apparand);
        Variable variable=vars.get(apparand);
        if (variable==null)
            throw new  Exceptions("Непонятный операнд "+apparand);
        return variable;

    }
}
