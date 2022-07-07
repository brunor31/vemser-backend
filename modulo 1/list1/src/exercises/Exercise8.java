package exercises;

import java.util.Locale;
import java.util.Scanner;

public class Exercise8 {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite a base do retângulo: ");
        double base = sc.nextDouble();
        sc.nextLine();
        System.out.print("Digite a altura do retângulo: ");
        double height = sc.nextDouble();
        sc.nextLine();
        double area = base * height;
        System.out.printf("A área do retângulo é: %.2f\n", area);
        sc.close();
    }
}
