package taxpayer.entities;

public class Individual extends TaxPayer {
    private Double healthSpending;
    public static final double ANNUAL_INCOME = 20000.00;
    public static final double FIFTEEN_PERCENT = 0.15;
    public static final double TWENTY_FIVE_PERCENT = 0.25;
    public static final double FIFTY_PERCENT = 0.5;

    public Individual(String name, Double annualIncome, Double healthSpending) {
        super(name, annualIncome);
        this.healthSpending = healthSpending;
    }

    @Override
    public Double tax() {
        double taxValue;

        if (getAnnualIncome() < ANNUAL_INCOME) {
            taxValue = getAnnualIncome() * FIFTEEN_PERCENT;
        } else {
            taxValue = getAnnualIncome() * TWENTY_FIVE_PERCENT;
        }

        taxValue -= this.healthSpending * FIFTY_PERCENT;

        return taxValue;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" $").append(String.format("%.2f", tax()));

        return sb.toString();
    }

}
