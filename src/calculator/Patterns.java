package calculator;

final class Patterns {
    private Patterns() {

    }

    static final String OPERATIONS = "[-+*/s]";
    static final String SCALAR = "-?\\d+(.\\d+)?";
    static final String VECTOR = "\\{-?\\d+((.\\d+)?)+\\}";
    static final String MATRIX = "\\{(\\{((-?\\d+(.\\d+)?)(,?))+\\},?)+\\}";
}
