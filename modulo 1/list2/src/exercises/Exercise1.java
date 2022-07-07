package exercises;

import java.util.Locale;
import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite os dados de um produto");
        System.out.print("Nome: ");
        String nameProduct = sc.nextLine();
        System.out.print("Preço: ");
        double price = sc.nextDouble();
        sc.nextLine();
        System.out.println("Produto: " + nameProduct);
        System.out.printf("Preço: R$%.2f%n", price);
        System.out.println("Promoção: " + nameProduct);
        System.out.println("----------------------");
        double discount = 0;
        for (int i=1; i<=10;i++){
            discount += 0.05;
            System.out.printf("%d x R$ %.2f = R$ %.2f%n", i, (price - (price*discount)), ((price - (price*discount))*i));
        }
        sc.close();
    }
}
