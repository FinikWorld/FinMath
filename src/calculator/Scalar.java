import calculator.resource.Translator;

import java.util.Scanner;

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
        if (other instanceof Vector) {
            Vector vector = (Vector) other;
            return other.slogenie(this);
        }
        return other.slogenie(this);
    }

    @Override
    public Variable vichitanie(Variable other) throws Exceptions {
        if (other instanceof Scalar) {
            Scalar chislo = (Scalar) other;
            double result = this.b - chislo.b;
            return new Scalar(result);
        }
        if (other instanceof Matrix) {
            Matrix matrix = (Matrix) other;
            return other.vichitanie(this).umnogenie(new Scalar(-1));
        }
        if (other instanceof Vector) {
            Vector vector = (Vector) other;
            return other.vichitanie(this).umnogenie(new Scalar(-1));
        }
        return other.vichitanie(this);
    }

    @Override
    public Variable umnogenie(Variable other) throws Exceptions {
        if (other instanceof Scalar) {
            Scalar chislo = (Scalar) other;
            double result = chislo.b * this.b;
            return new Scalar(result);
        }
        if (other instanceof Matrix) {
            Matrix matrix = (Matrix) other;
            return other.umnogenie(this);
        }
        if (other instanceof Vector) {
            Vector vector = (Vector) other;
            return other.umnogenie(this);
        }
        return super.umnogenie(other);
    }

    @Override
    public Variable delenie(Variable other) throws Exceptions {
        if (other instanceof Scalar) {
            Scalar chislo = (Scalar) other;
            double result = this.b / chislo.b;
            return new Scalar(result);
        }
        if (other instanceof Matrix) {
            Matrix matrix = (Matrix) other;
            double[][] result = new double[matrix.mat.length][matrix.mat[0].length];
            for (int i = 0; i < matrix.mat.length; i++) {
                for (int j = 0; j < matrix.mat[i].length; j++) {
                    result[i][j] = this.b * (1 / matrix.mat[i][j]);
                }
            }
            return new Matrix(result);
        }
        if (other instanceof Vector) {
            Vector vector = (Vector) other;
            double[] result = new double[vector.mas.length];
            for (int i = 0; i < vector.mas.length; i++) {

                result[i] = this.b * (1 / vector.mas[i]);

            }
            return new Vector(result);
        }
        return super.delenie(other);
    }
    @Override
    public Variable root(Variable other) throws Exceptions {
        if (other instanceof  Scalar){
            Scanner cin = new Scanner (System.in);
            System.out.println(Translator.INPUT_ROOT);
            double pow = cin.nextInt();
            Scalar chislo = (Scalar) other;
            double result = Math.pow(chislo.b,1/pow);
            double recult = Math.round(result);
            double diff = Math.abs(result-recult);
            if (diff < Math.ulp(10.0)){
                return new Scalar(recult);
            }
            else
                throw new Exceptions(Translator.ROOT_PROBLEM);
        }
        else
            throw new Exceptions(Translator.MATRIX_WRONG_OPERATION);
    }

    @Override
    public Variable power(Variable other) throws Exceptions {
        if (other instanceof  Scalar){
            Scanner cin = new Scanner (System.in);
            System.out.println(Translator.INPUT_POWER);
            double pow = cin.nextInt();
            Scalar chislo = (Scalar) other;
            double result = chislo.b;
            for (int i = 1; i < pow; i++) {
                result *= chislo.b;
            }
            return new Scalar(result);
        }
        else
            throw new Exceptions(Translator.MATRIX_WRONG_OPERATION);
    }
}

