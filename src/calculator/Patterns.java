

final class Patterns {
    private Patterns() {

    }

    static final String OPERATIONS = "[-+*/=spr]";
//    static final String OPERATIONS = "(?<![-+*/={,s]|\\s|^)([-+=*/s])";
    static final String SCALAR = "-?\\d+(.\\d+)?";
    static final String VECTOR = "\\{((-?\\d+(.\\d+)?)(,?\\s*))+}";
    static final String MATRIX = "\\{(\\{((-?\\d+(.\\d+)?)(,?\\s*))+},?\\s*)+}";
}
