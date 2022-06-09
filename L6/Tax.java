import java.util.Scanner;

public class Tax {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Filling Status");
        System.out.print("    [0]-Single filer\n    [1]-Married jointly or qualifying widow(er)\n    [2]-Married separately\n    [3]-Head of household\nEnter the filing status: ");
        int status = scan.nextInt();
        System.out.print("Enter the taxable income: ");
        double income = scan.nextDouble();
        System.out.println("Tax is " + computeTax(status, income));
    }
    public static double computeTax(int s, double income) {
        double[] rates = { 0.10, 0.15, 0.25, 0.28, 0.33, 0.35 };
        int[][] brackets = {
                { 8350, 33950, 82250, 171550, 372950 }, // Single filer
                { 16700, 67900, 137050, 20885, 372950 }, // Married jointly or qualifying widow(er)
                { 8350, 33950, 68525, 104425, 186475 }, // Married separately
                { 11950, 45500, 117450, 190200, 372950 } // Head of household
        };
        if (income <= brackets[s][0])
            return income * rates[0];

        if (income <= brackets[s][1])
            return (brackets[s][0] * rates[0]) +
                (income - brackets[s][0]) * rates[1];

        if (income <= brackets[s][2])
            return (brackets[s][0] * rates[0]) +
                (brackets[s][1] - brackets[s][0]) * rates[1] +
                (income - brackets[s][1]) * rates[2];

        if (income <= brackets[s][3])
            return (brackets[s][0] * rates[0]) +
                (brackets[s][1] - brackets[s][0]) * rates[1] +
                (brackets[s][2] - brackets[s][1]) * rates[2] +
                (income - brackets[s][2]) * rates[3];

        if (income <= brackets[s][4])
            return (brackets[s][0] * rates[0]) +
                (brackets[s][1] - brackets[s][0]) * rates[1] +
                (brackets[s][2] - brackets[s][1]) * rates[2] +
                (brackets[s][3] - brackets[s][2]) * rates[3] +
                (income - brackets[s][3]) * rates[4];

        return (brackets[s][0] * rates[0]) +
            (brackets[s][1] - brackets[s][0]) * rates[1] +
            (brackets[s][2] - brackets[s][1]) * rates[2] +
            (brackets[s][3] - brackets[s][2]) * rates[3] +
            (brackets[s][4] - brackets[s][3]) * rates[4] +
            (income - brackets[s][4]) * rates[5];
    }
}
