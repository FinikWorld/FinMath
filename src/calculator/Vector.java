package calculator;

public class Vector extends Variable {
    double[] mas;

    public Vector(double[] mas) {
        this.mas = mas;
    }

    public Vector(Vector mas) {
        this.mas = mas.mas;
    }

    public Vector(String mas) {
        mas = mas.replaceAll("[}{]", "");
        String[] mas1 = mas.split(",\\s*");
        double[] mas2 = new double[mas1.length];
        for (int i = 0; i < mas2.length; i++) {
            mas2[i] = Double.parseDouble(mas1[i]);
        }
        this.mas = mas2;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{");
        String razdelitel = "";
        for (int i = 0; i < this.mas.length; i++) {
            stringBuilder.append(razdelitel).append(this.mas[i]);
            razdelitel = ", ";
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    @Override
    public Variable slogenie(Variable other) throws Exceptions {
        if (other instanceof Vector) {
            Vector vector = (Vector) other;
            if (this.mas.length == vector.mas.length) {
                double[] result = new double[this.mas.length];
                for (int i = 0; i < this.mas.length; i++) {

                    result[i] = this.mas[i] + vector.mas[i];

                }
                return new Vector(result);
            } else {
                throw new Exceptions(Translator.WRONG_SIZE);
            }

        }
        if (other instanceof Scalar) {
            Scalar scalar = (Scalar) other;
            double[] result = new double[this.mas.length];
            for (int i = 0; i < this.mas.length; i++) {

                result[i] = this.mas[i] + scalar.b;

            }
            return new Vector(result);
        }
        if (other instanceof Matrix) {
            throw new Exceptions(Translator.MATRIX_WRONG_OPERATION);
        }
        return other.slogenie(this);
    }

    @Override
    public Variable vichitanie(Variable other) throws Exceptions {
        if (other instanceof Vector) {
            Vector vector = (Vector) other;
            if (this.mas.length == vector.mas.length) {
                double[] result = new double[this.mas.length];
                for (int i = 0; i < this.mas.length; i++) {

                    result[i] = this.mas[i] - vector.mas[i];

                }
                return new Vector(result);
            } else {
                throw new Exceptions(Translator.WRONG_SIZE);
            }

        }
        if (other instanceof Scalar) {
            Scalar scalar = (Scalar) other;
            double[] result = new double[this.mas.length];
            for (int i = 0; i < this.mas.length; i++) {

                result[i] = this.mas[i] - scalar.b;

            }
            return new Vector(result);
        }
        if (other instanceof Matrix) {
            throw new Exceptions(Translator.MATRIX_WRONG_OPERATION);
        }
        return super.vichitanie(other);
    }

    @Override
    public Variable umnogenie(Variable other) throws Exceptions {
        if (other instanceof Scalar) {
            Scalar scalar = (Scalar) other;
            double[] result = new double[this.mas.length];
            for (int i = 0; i < this.mas.length; i++) {

                result[i] = this.mas[i] * scalar.b;

            }
            return new Vector(result);

        }
        if (other instanceof Vector) {
            Vector vector = (Vector) other;
            if (this.mas.length == vector.mas.length) {
                double result = 0;
                for (int i = 0; i < this.mas.length; i++) {

                    result += this.mas[i] * vector.mas[i];

                }
                return new Scalar(result);
            } else {
                throw new Exceptions(Translator.WRONG_SIZE);
            }

        }
        if (other instanceof Matrix) {
            Matrix matrix = (Matrix) other;
            double[] result = new double[matrix.mat.length];
            if (matrix.mat[0].length == this.mas.length) {
                for (int i = 0; i < matrix.mat.length; i++) {
                    for (int j = 0; j < matrix.mat[i].length; j++) {
                        result[i] = result[i] + matrix.mat[i][j] * this.mas[j];
                    }
                }
            } else
                throw new Exceptions(Translator.WRONG_SIZE);
            return new Vector(result);
        }
        return other.umnogenie(this);
    }

    @Override
    public Variable delenie(Variable other) throws Exceptions {

        if (other instanceof Scalar) {
            Scalar scalar = (Scalar) other;
            double[] result = new double[this.mas.length];
            for (int i = 0; i < this.mas.length; i++) {

                result[i] = this.mas[i] / scalar.b;

            }
            return new Vector(result);

        }
        if (other instanceof Matrix){
            throw new Exceptions(Translator.MATRIX_WRONG_OPERATION);
        }
        if (other instanceof Vector){
            throw new Exceptions(Translator.MATRIX_WRONG_OPERATION);
        }
        return super.delenie(other);
    }

    @Override
    public Variable summa(Variable other) throws Exceptions {
        if (other instanceof Vector){
            double rez = 0;
            for (int i = 0; i < ((Vector) other).mas.length; i++) {
                rez+=((Vector) other).mas[i];
            }
            return new Scalar(rez);
        }
        throw new Exceptions("НЕльзя провести операцию с даннм операндом");
    }
}
