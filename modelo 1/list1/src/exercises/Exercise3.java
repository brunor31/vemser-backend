package exercises;

import java.util.Locale;
import java.util.Scanner;

public class Exercise3 {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o valor total consumido: ");
        double valueConsumed = sc.nextDouble();
        sc.nextLine();
        System.out.print("Digite o valor pago: ");
        double valuePaid = sc.nextDouble();
        sc.nextLine();
        while (valuePaid < valueConsumed){
            System.out.print("O valor pago deve ser maior ou igual ao valor consumido, digite novamente: ");
            valuePaid = sc.nextDouble();
        }
        System.out.printf("Seu troco é: R$%.2f%n", valuePaid - valueConsumed);
        sc.close();
    }
}
