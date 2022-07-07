package exercises;

import java.util.Scanner;

public class Exercise9 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Digite sua idade em anos, meses e dias");
        System.out.print("Anos: ");
        int years = sc.nextInt();
        sc.nextLine();
        System.out.print("Meses: ");
        int month = sc.nextInt();
        sc.nextLine();
        System.out.print("Dias: ");
        int days = sc.nextInt();
        sc.nextLine();
        int ageInDays = (years*365) + (month*30) + days;
        System.out.printf("Sua idade em dias é: %d\n", ageInDays);
        sc.close();
    }
}
