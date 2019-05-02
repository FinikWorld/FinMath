package calculator;

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
        return super.vichitanie(other);//тут не по суперу нужно а по other на this, и учесть то что 5-4 это не одно итоже что 4-5
//        return other.vichitanie(this).umnogenie(new Scalar(-1));//тут не по суперу нужно а по other на this,
    }

    @Override
    public Variable umnogenie(Variable other) throws Exceptions {
        if (other instanceof Scalar)
        {
            Scalar chislo = (Scalar) other;
            double result=chislo.b * this.b;
            return new Scalar (result);
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
        return super.delenie(other);
    }
}

