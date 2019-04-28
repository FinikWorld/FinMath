package calculator;

import java.util.Scanner;

public class Variable implements IOperation {

    @Override
    public Variable slogenie(Variable other) throws Exceptions {
        System.out.println("Сложение " + this + " + " + other + " невозможно");
        return null;
    }

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
        return null;
    }

    public static Variable createVar(String apparand) throws Exceptions {
        if (apparand.matches(Patterns.SCALAR))
            return new Scalar(apparand);
        if (apparand.matches(Patterns.VECTOR))
            return new Vector(apparand);
        if (apparand.matches(Patterns.MATRIX))
            return new Matrix(apparand);


        return null;
    }
}
