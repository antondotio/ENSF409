public interface Resizable {
    final Double LIMIT = 1.0;

    public void enlarge(Double n) throws SizeFactorException;
    public void shrink(Double n) throws SizeFactorException;
}
