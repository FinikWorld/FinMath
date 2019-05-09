package calculator;

import calculator.resource.Translator;

public class Scalar extends Variable {
    double b;

    @Override
    public String toString() {
        return Double.toString(b);
    }

    public Scalar(double b) {
        this.b = b;

    }

    public Scalar(String b) {
        this.b = Double.parseDouble(b);
    }

    public Scalar(Scalar b) {
        this.b = b.b;
    }

    @Override
    public Variable slogenie(Variable other) throws Exceptions {
        if (other instanceof Scalar) {
            Scalar chislo = (Scalar) other;
            double result = chislo.b + this.b;
            return new Scalar(result);
        }
        if (other instanceof Matrix) {
            Matrix matrix = (Matrix) other;
            return other.slogenie(this);
        }
        if (other instanceof Vector)
        {
            Vector vector=(Vector) other;
            return other.slogenie(this);
        }
        return other.slogenie(this);
    }

    @Override
    public Variable vichitanie(Variable other) throws Exceptions {
        if (other instanceof Scalar)
        {
            Scalar chislo = (Scalar) other;
            double result=this.b-chislo.b;
            return new Scalar (result);
        }
        if (other instanceof Matrix)
        {
            Matrix matrix = (Matrix) other;
            return other.vichitanie(this).umnogenie(new Scalar(-1));
        }
        if (other instanceof Vector)
        {
            Vector vector=(Vector) other;
            return other.vichitanie(this).umnogenie(new Scalar(-1));
        }
        return other.vichitanie(this);
    }

    @Override
    public Variable umnogenie(Variable other) throws Exceptions {
        if (other instanceof Scalar)
        {
            Scalar chislo = (Scalar) other;
            double result=chislo.b * this.b;
            return new Scalar (result);
        }
        if (other instanceof Matrix)
        {
            Matrix matrix = (Matrix) other;
            return other.umnogenie(this);
        }
        if (other instanceof Vector)
        {
            Vector vector=(Vector) other;
            return other.umnogenie(this);
        }
        return super.umnogenie(other);
    }

    @Override
    public Variable delenie(Variable other) throws Exceptions {
        if (other instanceof Scalar)
        {
            Scalar chislo = (Scalar) other;
            double result=this.b/chislo.b;
            return new Scalar (result);
        }
        if (other instanceof Matrix)
            throw new Exceptions(Translator.MATRIX_WRONG_OPERATION);
        if (other instanceof Vector)
        {
            throw new Exceptions(Translator.MATRIX_WRONG_OPERATION);
        }
        return super.delenie(other);
    }

    @Override
    public Variable kvadrat(Variable other) throws Exceptions {
        if (other instanceof Scalar)
        {
            Scalar chislo = (Scalar) other;
            double result = this.b*chislo.b;
            return new Scalar(result);
        }
        else
            throw new Exceptions(Translator.MATRIX_WRONG_OPERATION);
    }
}

