import taxes.*;

public class Main {
    public static void main(String[] args) {
        TaxSystem taxSystem = new TaxSystem();
        Company company = new Company("T+", taxSystem);
        company.setTaxSystem(new Tax6());
        company.shiftMoney(40_000);
        company.payTaxes();

        Deal[] deal = {new Sale("cake", 0, 10000),
                new Expenditure("torte", 2000, 0)};
        System.out.println(company.applyDeals(deal));
    }
}