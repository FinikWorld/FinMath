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
        if (other instanceof Scalar)
        {
          Scalar chislo = (Scalar) other;
          double result=chislo.b + this.b;
          return new Scalar (result);
        }
        if (other instanceof Matrix)
        {
            Matrix matrix = (Matrix) other;
            return other.slogenie(this);
            /*double[][] result = new double[matrix.mat.length][matrix.mat[0].length];
            for (int i = 0; i < matrix.mat.length; i++) {
                for (int j = 0; j < matrix.mat[i].length; j++) {
                    result[i][j] = matrix.mat[i][j] + this.b;
                }

            }
            return new Matrix(result);*/
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
            double[][] result = new double[matrix.mat.length][matrix.mat[0].length];
            for (int i = 0; i < matrix.mat.length; i++) {
                for (int j = 0; j < matrix.mat[i].length; j++) {
                    result[i][j] = matrix.mat[i][j] * this.b;
                }

            }
            return new Matrix(result);
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
        return super.delenie(other);
    }
}

