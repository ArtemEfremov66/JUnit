import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import taxes.TaxSystem;

public class CompanyTest {
    TaxSystem taxSystem = new TaxSystem();
    Company sut;
    @BeforeEach
    public void setApp() {
    sut =  new Company("Test", taxSystem );
    }
    @Test
    public void testShiftMoneyPlus() {
        // given:
        sut.debit = 0;
        int amount = 10;
        int result = 10;
        // when:
        sut.shiftMoney(amount);
        // then:
        Assertions.assertEquals(sut.debit, result);
    }
    @Test
    public void testShiftMoneyMinus() {
        // given:
        sut.credit = 0;
        int amount = -10;
        int result = 10;
        // when:
        sut.shiftMoney(amount);
        // then:
        Assertions.assertEquals(sut.credit, result);
    }

    @Test
    public void testApplyDeals() {
        // given:
        Deal[] deal = {new Sale("cake", 0, 10000),
                new Expenditure("torte", 2000, 0)};
        int expected = 8000;

        // when:
        int result = sut.applyDeals(deal);

        // then:
        Assertions.assertEquals(result, expected);
    }
}
