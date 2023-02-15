package taxpayer.entities;

public class Company extends TaxPayer {
    private int numbersOfEmployees;
    public static final double FOURTEEN_PERCENT = 0.14;
    public static final double SIXTEEN_PERCENT = 0.16;
    public static final int NUMBERS_EMPLOYEES = 10;


    public Company(String name, Double annualIncome, int numbersOfEmployees) {
        super(name, annualIncome);
        this.numbersOfEmployees = numbersOfEmployees;
    }

    @Override
    public Double tax() {
        return numbersOfEmployees > NUMBERS_EMPLOYEES ? getAnnualIncome() * FOURTEEN_PERCENT : getAnnualIncome() * SIXTEEN_PERCENT;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" $").append(String.format("%.2f", tax()));

        return sb.toString();
    }
}
