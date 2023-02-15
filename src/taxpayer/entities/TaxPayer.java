package taxpayer.entities;

public abstract class TaxPayer {
    protected String name;
    protected Double annualIncome;

    public TaxPayer() {
    }

    public TaxPayer(String name, Double annualIncome) {
        this.name = name;
        this.annualIncome = annualIncome;
    }

    public abstract Double tax();

    public Double getAnnualIncome() {
        return annualIncome;
    }
}
