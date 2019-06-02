

import calculator.resource.Translator;

import java.math.BigDecimal;
import java.util.Scanner;

public class Matrix extends Variable {
    double[][] mat;

    public Matrix(double[][] mat) {
        this.mat = mat;
    }

    public Matrix(Matrix mat) {
        this.mat = mat.mat;
    }

    public Matrix(String mat) {
        mat = mat.replaceAll("[},{]", " ");
        mat = mat.trim();
        String[] mat1 = mat.split("   ");
        String[] matstb = mat1[0].split("\\s+");
        int kolvoStb = matstb.length;
        int kolvoStr = mat1.length;
        String[] mat3 = mat.split("\\s+");
        int k = 0;
        double[][] mat2 = new double[kolvoStr][kolvoStb];
        for (int i = 0; i < mat2.length; i++) {
            for (int j = 0; j < mat2[i].length; j++) {
                mat2[i][j] = Double.parseDouble(mat3[k]);
                k++;
            }
        }
        this.mat = mat2;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{");
        for (int i = 0; i < this.mat.length; i++) {
            stringBuilder.append("{");
            String razdelitel2 = "";
            for (int j = 0; j < mat[i].length; j++) {
                stringBuilder.append(razdelitel2).append(this.mat[i][j]);
                razdelitel2 = ",";
            }
            if (i != this.mat.length - 1)
                stringBuilder.append("},");
        }
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    @Override
    public Variable slogenie(Variable other) throws Exceptions {
        if (other instanceof Matrix) {
            Matrix matrix = (Matrix) other;
            if ((this.mat[0].length == matrix.mat[0].length) && (this.mat.length == matrix.mat.length)) {
                double[][] result = new double[this.mat.length][this.mat[0].length];
                for (int i = 0; i < this.mat.length; i++) {
                    for (int j = 0; j < this.mat[i].length; j++) {

                        result[i][j] = this.mat[i][j] + matrix.mat[i][j];

                    }
                }
                return new Matrix(result);
            } else {
                throw new Exceptions(Translator.WRONG_SIZE);
            }
        }

        if (other instanceof Scalar) {
            Scalar scalar = (Scalar) other;
            double[][] result = new double[this.mat.length][this.mat[0].length];
            for (int i = 0; i < this.mat.length; i++) {
                for (int j = 0; j < this.mat[j].length; j++) {
                    result[i][j] = this.mat[i][j] + scalar.b;
                }

            }
            return new Matrix(result);
        }
        if (other instanceof Vector) {
            throw new Exceptions((Translator.MATRIX_WRONG_OPERATION));
        }

        return other.slogenie(this);
    }

    @Override
    public Variable vichitanie(Variable other) throws Exceptions {
        if (other instanceof Matrix) {
            Matrix matrix = (Matrix) other;
            if ((this.mat[0].length == matrix.mat[0].length) && (this.mat.length == matrix.mat.length)) {
                double[][] result = new double[this.mat.length][this.mat[0].length];
                for (int i = 0; i < this.mat.length; i++) {
                    for (int j = 0; j < this.mat[i].length; j++) {

                        result[i][j] = this.mat[i][j] - matrix.mat[i][j];

                    }
                }
                return new Matrix(result);
            } else {
                throw new Exceptions(Translator.WRONG_SIZE);
            }


        }
        if (other instanceof Scalar) {
            Scalar scalar = (Scalar) other;
            double[][] result = new double[this.mat.length][this.mat[0].length];
            for (int i = 0; i < this.mat.length; i++) {
                for (int j = 0; j < this.mat[i].length; j++) {
                    result[i][j] = this.mat[i][j] - scalar.b;
                }

            }
            return new Matrix(result);
        }

        if (other instanceof Vector) {
            throw new Exceptions((Translator.MATRIX_WRONG_OPERATION));
        }
        return other.vichitanie(this);
    }

    @Override
    public Variable umnogenie(Variable other) throws Exceptions {
        if (other instanceof Vector) {
            Vector vector = (Vector) other;
            double[] result = new double[this.mat.length];
            if (vector.mas.length == this.mat[0].length) {
                for (int i = 0; i < this.mat.length; i++) {
                    for (int j = 0; j < this.mat[i].length; j++) {
                        result[i] = result[i] + this.mat[i][j] * vector.mas[j];
                    }
                }
            } else
                throw new Exceptions(Translator.WRONG_SIZE);
            return new Vector(result);
        }

        if (other instanceof Scalar) {
            Scalar scalar = (Scalar) other;
            double[][] result = new double[this.mat.length][this.mat[0].length];
            for (int i = 0; i < this.mat.length; i++) {
                for (int j = 0; j < this.mat[i].length; j++) {
                    result[i][j] = this.mat[i][j] * scalar.b;
                }

            }
            return new Matrix(result);
        }
        if (other instanceof Matrix) {
            Matrix matrix = (Matrix) other;
            if ((this.mat[0].length == matrix.mat[0].length) && (this.mat.length == matrix.mat.length)) {
                double[][] result = new double[this.mat.length][matrix.mat[0].length];
                for (int i = 0; i < mat.length; i++) {
                    for (int j = 0; j < matrix.mat[0].length; j++) {
                        for (int k = 0; k < matrix.mat.length; k++) {
                            result[i][j] += this.mat[i][k] * matrix.mat[k][j];
                        }

                    }

                }
                return new Matrix(result);
            } else {
                throw new Exceptions(Translator.WRONG_SIZE);
            }
        }
        return other.umnogenie(this);
    }

    @Override
    public Variable delenie(Variable other) throws Exceptions {

        if (other instanceof Scalar) {
            Scalar scalar = (Scalar) other;
            double[][] result = new double[this.mat.length][this.mat[0].length];
            for (int i = 0; i < this.mat.length; i++) {
                for (int j = 0; j < this.mat[i].length; j++) {
                    result[i][j] = this.mat[i][j] / scalar.b;
                }

            }
            return new Matrix(result);
        }
        if (other instanceof Vector) {
            Vector vector = (Vector) other;
            double[] result = new double[this.mat.length];
            if (vector.mas.length == this.mat[0].length) {
                for (int i = 0; i < this.mat.length; i++) {
                    for (int j = 0; j < this.mat[i].length; j++) {
                        result[i] = result[i] + this.mat[i][j] * (1 / vector.mas[j]);
                    }
                }
            } else
                throw new Exceptions(Translator.WRONG_SIZE);
            return new Vector(result);
        }
        if (other instanceof Matrix) {
            Matrix matrix = (Matrix) other;
            if ((this.mat[0].length == matrix.mat[0].length) && (this.mat.length == matrix.mat.length)) {
                double[][] result = new double[this.mat.length][matrix.mat[0].length];
                for (int i = 0; i < mat.length; i++) {
                    for (int j = 0; j < matrix.mat[0].length; j++) {
                        for (int k = 0; k < matrix.mat.length; k++) {
                            result[i][j] += this.mat[i][k] * (1 / matrix.mat[k][j]);
                        }

                    }

                }
                return new Matrix(result);
            } else {
                throw new Exceptions(Translator.WRONG_SIZE);
            }
        }
        return super.delenie(this);
    }

    @Override
    public Variable summa(Variable other) throws Exceptions {
        if (other instanceof Matrix) {
            Matrix matrix = (Matrix) other;
            double result = 0;
            for (int i = 0; i < matrix.mat.length; i++) {
                for (int j = 0; j < matrix.mat[i].length; j++) {
                    result += matrix.mat[i][j];
                }
            }
            return new Scalar(result);
        }
        return null;
    }

    @Override
    public Variable power(Variable other) throws Exceptions {
        if (other instanceof Matrix) {
            Scanner cin = new Scanner(System.in);
            System.out.println(Translator.INPUT_POWER);
            double pow = cin.nextInt();
            Matrix matrix = (Matrix) other;
            double[][] result = new double[matrix.mat.length][matrix.mat[0].length];
            for (int i = 0; i < matrix.mat.length; i++) {
                for (int j = 0; j < matrix.mat[i].length; j++) {
                    result[i][j] = matrix.mat[i][j];
                }
            }
            for (int i = 0; i < matrix.mat.length; i++) {
                for (int j = 0; j < matrix.mat[i].length; j++) {
                    for (int k = 0; k < pow - 1; k++) {
                        result[i][j] *= matrix.mat[i][j];
                    }
                }
            }
            return new Matrix(result);
        } else
            throw new Exceptions(Translator.MATRIX_WRONG_OPERATION);
    }

    @Override
    public Variable root(Variable other) throws Exceptions {
        if (other instanceof Matrix) {
            double[][] result = new double[this.mat.length][this.mat[0].length];
            for (int i = 0; i < this.mat.length; i++) {
                for (int j = 0; j < this.mat[i].length; j++) {

                    result[i][j] = Math.sqrt(this.mat[i][j]);

                }
            }
            return new Matrix(result);
        } else {
            throw new Exceptions(Translator.WRONG_SIZE);
        }
    }

    public Variable determinant(Variable other) throws Exceptions {
        if (other instanceof Matrix) {
            int accuracy = 20;

            BigDecimal EPS = BigDecimal.valueOf(0.00000000001);

            int n = this.mat.length;
            BigDecimal[][] a = new BigDecimal[n][n];
            for (int i = 0; i < n; ++i)
                for (int j = 0; j < n; ++j) {
                    a[i][j] = new BigDecimal(this.mat[i][j]);
                    a[i][j].setScale(accuracy, BigDecimal.ROUND_HALF_UP);
                }

            BigDecimal det = new BigDecimal(1.0);
            det.setScale(accuracy, BigDecimal.ROUND_HALF_UP);

            for (int i = 0; i < n; ++i) {
                int k = i;
                for (int j = i + 1; j < n; ++j)
                    if (a[j][i].abs().compareTo(a[k][i].abs()) > 0)
                        k = j;
                if (a[k][i].abs().compareTo(EPS) < 0) {
                    det = new BigDecimal(0.0);
                    det.setScale(accuracy, BigDecimal.ROUND_HALF_UP);
                    break;
                }
                BigDecimal[] tmp = a[i];
                a[i] = a[k];
                a[k] = tmp;

                if (i != k)
                    det = det.divide(new BigDecimal(-1), accuracy, BigDecimal.ROUND_HALF_UP);
                det = det.multiply(a[i][i]);
                for (int j = i + 1; j < n; ++j)
                    a[i][j] = a[i][j].divide(a[i][i], accuracy, BigDecimal.ROUND_HALF_UP);
                for (int j = 0; j < n; ++j)
                    if (j != i && a[j][i].abs().compareTo(EPS) > 0)
                        for (int kk = i + 1; kk < n; ++kk) {
                            BigDecimal aikji = new BigDecimal(1.0);
                            aikji.setScale(accuracy, BigDecimal.ROUND_HALF_UP);
                            aikji = aikji.multiply(a[i][kk]);
                            aikji = aikji.multiply(a[j][i]);
                            aikji = aikji.multiply(new BigDecimal(-1));
                            a[j][kk] = a[j][kk].add(aikji);
                        }
            }

            det = det.abs();
            det = det.add(new BigDecimal(0.00001));
            return det.abs().toBigInteger();
        }
    }
}

