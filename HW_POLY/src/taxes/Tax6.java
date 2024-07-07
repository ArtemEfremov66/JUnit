package taxes;

public class Tax6 extends TaxSystem {
    @Override
    public int calcTaxFor(int debit, int credit) {
        return (debit > 0) ? (debit * 6 / 100) : 0;
    }
}
