import taxes.*;

public class Company {
    protected String title;
    protected int debit = 0;
    protected int credit = 0;
    protected TaxSystem taxSystem;
    protected Deal[] deals;

    public Company(String title, TaxSystem taxSystem) {
        this.title = title;
        this.taxSystem = taxSystem;
    }

    public void shiftMoney(int amount) {
        if (amount > 0) {
            debit += amount;
        } else if (amount < 0) {
            credit += Math.abs(amount);
        }
    }

    public void setTaxSystem(TaxSystem taxSystem) {
        this.taxSystem = taxSystem;
    }

    public void payTaxes() {
        int tax = taxSystem.calcTaxFor(debit, credit);
        System.out.println("Компания " + title + " уплатила налог в размере: " + tax + " руб");
        debit = 0;
        credit = 0;
    }

    public int applyDeals(Deal[] deals) {
        for (int i = 0; i < deals.length; i++) {
            Deal deals1 = deals[i];
            debit += deals1.getDebitChange();
            credit += deals1.getCreditChange();
            if (deals1.debitChange > 0) {
                System.out.println("Продажа " + deals1.comment + " на " + deals1.debitChange);
            } else System.out.println("Покупка " + deals1.comment + " на " + deals1.creditChange);
        }
        int difference = debit - credit;
        payTaxes();
        return difference;
    }
}
