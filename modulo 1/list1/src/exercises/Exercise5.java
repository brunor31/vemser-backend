package exercises;

import java.util.Locale;
import java.util.Scanner;

public class Exercise5 {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite seu valor por hora de trabalho: ");
        double valuePerHouer = sc.nextDouble();
        sc.nextLine();
        System.out.print("Digite seu número de horas trabalhadas: ");
        double houers = sc.nextDouble();
        sc.nextLine();
        System.out.print("Digite seu número de horas extras com adicional de 50%: ");
        double overtime50 = sc.nextDouble();
        sc.nextLine();
        System.out.print("Digite seu número de horas extras com adicional de 100%: ");
        double overtime100 = sc.nextDouble();
        sc.nextLine();
        double salary = (houers * valuePerHouer) + (overtime50 * valuePerHouer * 1.5) + (overtime100 * valuePerHouer * 2.0);
        System.out.printf("Seu salário bruto é: R$%.2f%n", salary);
        sc.close();
    }
}
