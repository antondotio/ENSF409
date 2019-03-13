public class SizeFactorException extends Exception {

    public SizeFactorException(Double n, Double LIMIT){
        super("\n" + n + "  is too small! Choose a larger number that is greater than or equal to " + LIMIT);
    }
}
