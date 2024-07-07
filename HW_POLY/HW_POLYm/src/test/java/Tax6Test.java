import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import taxes.Tax6;
import taxes.TaxSystem;

public class Tax6Test {
    TaxSystem ts = new Tax6();
    @Test
    public void tax6Text() {
        // given:
        int debit = 1000;
        int credit = 2000;
        int expected = 60 ;
        // when:
        int result = ts.calcTaxFor(debit, credit);
        // then:
        Assertions.assertEquals(expected, result);
    }
}
