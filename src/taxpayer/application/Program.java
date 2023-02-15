package taxpayer.application;

import taxpayer.entities.Company;
import taxpayer.entities.Individual;
import taxpayer.entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        Locale.setDefault(Locale.US);

        List<TaxPayer> taxPayers = new ArrayList<>();

        System.out.print("Enter the numbers of tax prayers: ");
        int n = sc.nextInt();

        IntStream.rangeClosed(1, n).forEachOrdered(i -> {
            System.out.println("Tax prayer #" + i + " data: ");

            System.out.print("Individual or company (i/c)? ");
            char type = sc.next().charAt(0);

            System.out.print("Name: ");
            String name = sc.next();

            System.out.print("Annual income: ");
            double annualIncome = sc.nextDouble();

            switch (type) {
                case 'i' -> {
                    System.out.print("Health expenditures: ");
                    double healthSpending = sc.nextDouble();

                    taxPayers.add(new Individual(name, annualIncome, healthSpending));
                }
                case 'c' -> {
                    System.out.print("Numbers of employees: ");
                    int numberOfEmployees = sc.nextInt();

                    taxPayers.add(new Company(name, annualIncome, numberOfEmployees));
                }
            }
        });
        sc.close();

        System.out.println("\nTAXES PAID");
        taxPayers.forEach(System.out::println);


        double totalTaxes = taxPayers.stream().mapToDouble(TaxPayer::tax).sum();
        System.out.println("\nTOTAL TAXES: $"+String.format("%.2f", totalTaxes));
    }
}
